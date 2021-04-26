package com.baidu.android.imsdk.mcast;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.ParseM3u8;
import com.baidu.android.imsdk.mcast.UpMessageManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.bumptech.glide.load.engine.GlideException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UnLoginCastService {
    public static final int BACKPLAY = 1;
    public static final int NOWPLAY = 0;
    public static final String TAG = "UnLoginCastService";
    public static Context mContext;
    public static UnLoginCastService mInstance;
    public Timer mAxisTimer;
    public String mCastId;
    public int mPausePosition;
    public String mRoomUrl;
    public Timer mTimer;
    public Object mawakeLock = new Object();
    public ConcurrentLinkedQueue<ParseM3u8.TS> mTss = new ConcurrentLinkedQueue<>();
    public ParseM3u8 mLastpm = null;
    public int mInterval = 3000;
    public boolean isActive = false;
    public boolean isSeek = false;
    public int mType = -1;
    public int mPosition = 0;
    public Thread requestTsTask = null;
    public long startSeekTime = 0;
    public long startSeekTsTime = 0;
    public int mTryTimes = 0;
    public boolean mPause = false;

    /* loaded from: classes.dex */
    public class Uptask extends UpMessageManager.Task {
        public Uptask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.mcast.UpMessageManager.Task
        public void work() {
            int i2;
            int i3;
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                jSONObject.optInt("version");
                long optLong = jSONObject.optLong("duration");
                JSONArray jSONArray = jSONObject.getJSONArray("list");
                int length = jSONArray.length();
                if (length == 0) {
                    LogUtils.d(UnLoginCastService.TAG, "FXF work  is null");
                    return;
                }
                String str = UnLoginCastService.TAG;
                LogUtils.d(str, "FXF work data is " + jSONArray.toString());
                JSONArray jSONArray2 = new JSONArray();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONArray jSONArray3 = jSONArray.getJSONObject(i4).getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                    for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                        JSONObject jSONObject2 = jSONArray3.getJSONObject(i5);
                        if (jSONObject2.optInt("origin_id", -1) != Utility.getTriggerId(UnLoginCastService.mContext)) {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
                int length2 = jSONArray2.length();
                int i6 = (int) (optLong / 1000000000);
                if (i6 == 0) {
                    i3 = i6;
                    i2 = 0;
                } else if (length2 >= i6) {
                    i2 = length2 / i6;
                    i3 = i6;
                } else {
                    i2 = 1;
                    i3 = length2;
                }
                String str2 = UnLoginCastService.TAG;
                LogUtils.d(str2, "HBBH work ts duration is " + optLong + " " + i6 + " num is " + i2 + " size is " + length2);
                if (i2 <= 0) {
                    ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(UnLoginCastService.this.mCastId, jSONArray2);
                    return;
                }
                int i7 = 0;
                for (int i8 = 0; i8 < i3 && UnLoginCastService.this.isActive && !UnLoginCastService.this.isSeek; i8++) {
                    JSONArray jSONArray4 = new JSONArray();
                    int i9 = 0;
                    while (i9 < i2) {
                        jSONArray4.put(jSONArray2.get(i7));
                        i9++;
                        i7++;
                    }
                    String str3 = UnLoginCastService.TAG;
                    LogUtils.d(str3, "FXF upload a ts message  " + jSONArray4.toString());
                    ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(UnLoginCastService.this.mCastId, jSONArray4);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                if (!UnLoginCastService.this.isActive || UnLoginCastService.this.isSeek || i7 >= length2) {
                    return;
                }
                JSONArray jSONArray5 = new JSONArray();
                int i10 = i7;
                while (i7 < length2) {
                    jSONArray5.put(jSONArray2.get(i10));
                    i7++;
                    i10++;
                }
                String str4 = UnLoginCastService.TAG;
                LogUtils.d(str4, "FXF upload a last ts message  " + jSONArray5.toString());
                ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(UnLoginCastService.this.mCastId, jSONArray5);
            } catch (JSONException e3) {
                LogUtils.e(UnLoginCastService.TAG, "m3u8 work task execption  ");
                e3.printStackTrace();
            }
        }
    }

    public UnLoginCastService(Context context) {
        mContext = context.getApplicationContext();
    }

    public static UnLoginCastService getInstance(Context context) {
        synchronized (UnLoginCastService.class) {
            if (mInstance == null) {
                mInstance = new UnLoginCastService(context);
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getM3u8task(String str) {
        String addListener = ListenerManager.getInstance().addListener(new GetM3u8CallBack() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.7
            @Override // com.baidu.android.imsdk.mcast.GetM3u8CallBack
            public void onResult(int i2, byte[] bArr) {
                UnLoginCastService.this.handleOnM3u8Callback(i2, bArr);
            }
        });
        String str2 = TAG;
        LogUtils.d(str2, "   " + addListener + GlideException.IndentedAppendable.INDENT + str);
        GetM3u8Request getM3u8Request = new GetM3u8Request(mContext, addListener, str);
        HttpHelper.executor(mContext, getM3u8Request, getM3u8Request);
    }

    private void getTstask(String str) {
        String addListener = ListenerManager.getInstance().addListener(new GetM3u8CallBack() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.6
            @Override // com.baidu.android.imsdk.mcast.GetM3u8CallBack
            public void onResult(int i2, byte[] bArr) {
                String str2 = UnLoginCastService.TAG;
                LogUtils.d(str2, "FXF receive a ts file " + i2);
                if (i2 == 0 || i2 == 200) {
                    UnLoginCastService.this.onResultTs(bArr);
                    return;
                }
                String str3 = UnLoginCastService.TAG;
                LogUtils.e(str3, "FXF getTstask error " + i2);
            }
        });
        int indexOf = this.mRoomUrl.indexOf("/", 10);
        if (indexOf <= this.mRoomUrl.length()) {
            String substring = this.mRoomUrl.substring(0, indexOf);
            if (!str.contains("http://")) {
                str = substring + str;
            }
            GetTsRequest getTsRequest = new GetTsRequest(mContext, addListener, str);
            HttpHelper.executor(mContext, getTsRequest, getTsRequest);
        }
    }

    private boolean onResultM3u8(byte[] bArr) {
        if (this.isActive && !this.isSeek) {
            ParseM3u8 parseM3u8 = new ParseM3u8();
            try {
                parseM3u8.readByte(bArr);
                List<ParseM3u8.TS> arrayList = new ArrayList<>();
                if (this.mLastpm == null) {
                    this.mLastpm = parseM3u8;
                    if (this.mType == 0) {
                        arrayList = parseM3u8.getLatestTS(parseM3u8.getMaxTime());
                        String str = TAG;
                        LogUtils.d(str, "FXF ts list  1 size" + arrayList.size());
                    } else {
                        arrayList = parseM3u8.getTslist(this.mPosition);
                        String str2 = TAG;
                        LogUtils.d(str2, "FXF ts list 2 size" + arrayList.size());
                        this.startSeekTime = System.currentTimeMillis() / 1000;
                        this.startSeekTsTime = arrayList.get(0).relativetime;
                    }
                    LogUtils.d(TAG, "FXF first get 1 m3u8");
                } else {
                    LogUtils.d(TAG, "FXF get one m3u8");
                    if (parseM3u8.getMaxTime() > this.mLastpm.getMaxTime()) {
                        LogUtils.d(TAG, "FXF has new ts");
                        arrayList = parseM3u8.getNewAppendTS(this.mLastpm.getMaxTime());
                        this.mLastpm = parseM3u8;
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.mTss.add(arrayList.get(i2));
                    }
                    synchronized (this.mawakeLock) {
                        this.mawakeLock.notifyAll();
                    }
                }
                if (parseM3u8.isEnd() || this.mType == 1) {
                    LogUtils.d(TAG, "FXF pm has end-list");
                    return false;
                }
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                LogUtils.d(TAG, "parse m3u8 execption");
                return false;
            }
        }
        String str3 = TAG;
        LogUtils.d(str3, "onResultM3u8 return, service is not active " + this.isActive + " " + this.isSeek);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResultTs(byte[] bArr) {
        if (!this.isActive || this.isSeek) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(new String(bArr));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject != null) {
            String str = TAG;
            LogUtils.d(str, "FXF receive a ts message " + jSONObject.toString());
            UpMessageManager.getInstance(mContext).addTaskRequest(new Uptask("parse ts and upload", jSONObject.toString()));
        }
    }

    private boolean proofreadTimeAxis(long j) {
        if (this.mType == 1) {
            long j2 = j - this.startSeekTsTime;
            long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.startSeekTime;
            if (this.mAxisTimer == null) {
                this.mAxisTimer = new Timer(true);
            }
            if (j2 - currentTimeMillis > 5) {
                String str = TAG;
                LogUtils.d(str, "startSeekTsTime = " + this.startSeekTsTime + "  currenttstime =  " + j + " past = " + j2);
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("startSeekTime = ");
                sb.append(this.startSeekTime);
                sb.append(" past = ");
                sb.append(currentTimeMillis);
                LogUtils.d(str2, sb.toString());
                this.mAxisTimer.schedule(new TimerTask() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        synchronized (UnLoginCastService.this.mawakeLock) {
                            LogUtils.d(UnLoginCastService.TAG, "FXF execute 1 tiime axis");
                            if (!UnLoginCastService.this.isSeek && UnLoginCastService.this.isActive) {
                                UnLoginCastService.this.mawakeLock.notifyAll();
                            }
                        }
                    }
                }, 3000L);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tsWork() {
        while (true) {
            if (!this.isActive) {
                break;
            }
            synchronized (this.mawakeLock) {
                try {
                    LogUtils.d(TAG, "FXF requestTsTask wait...");
                    this.mawakeLock.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                int size = this.mTss.size();
                if (!this.isActive) {
                    break;
                }
                for (int i2 = 0; i2 < size && this.isActive && !this.isSeek; i2++) {
                    ParseM3u8.TS peek = this.mTss.peek();
                    if (proofreadTimeAxis(peek.relativetime)) {
                        break;
                    }
                    this.mTss.poll();
                    getTstask(peek.tsfile);
                    String str = TAG;
                    LogUtils.d(str, "FXF request ts " + i2 + " " + peek.tsfile + " " + peek.relativetime);
                }
            }
        }
        LogUtils.d(TAG, "FXF requestTsTask finish");
    }

    public void handleOnM3u8Callback(int i2, byte[] bArr) {
        boolean onResultM3u8;
        String str = TAG;
        LogUtils.d(str, "FXF receive a m3u8 file " + i2);
        if (i2 != 0 && i2 != 200) {
            String str2 = TAG;
            LogUtils.e(str2, "FXF getM3u8task error " + i2);
            onResultM3u8 = true;
        } else {
            this.mTryTimes = 0;
            onResultM3u8 = onResultM3u8(bArr);
        }
        if (onResultM3u8 && this.isActive && !this.isSeek) {
            TimerTask timerTask = new TimerTask() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.8
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    UnLoginCastService unLoginCastService = UnLoginCastService.this;
                    if (unLoginCastService.isActive) {
                        unLoginCastService.getM3u8task(unLoginCastService.mRoomUrl);
                    }
                }
            };
            if (this.mTimer == null) {
                this.mTimer = new Timer(true);
            }
            this.mTimer.schedule(timerTask, this.mInterval);
        }
    }

    public void pause() {
        this.mPause = true;
        stopService(1);
    }

    public void replay(String str, String str2, int i2) {
        LogUtils.d(TAG, "FXF replay--->");
        this.isActive = true;
        this.mPause = false;
        this.mType = i2;
        this.mRoomUrl = str2;
        this.mCastId = str;
        Thread thread = new Thread() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                UnLoginCastService.this.tsWork();
            }
        };
        this.requestTsTask = thread;
        thread.start();
        new Timer(true).schedule(new TimerTask() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                List<ParseM3u8.TS> arrayList = new ArrayList<>();
                UnLoginCastService unLoginCastService = UnLoginCastService.this;
                ParseM3u8 parseM3u8 = unLoginCastService.mLastpm;
                if (parseM3u8 != null) {
                    arrayList = parseM3u8.getTslist(unLoginCastService.mPausePosition);
                } else {
                    LogUtils.e(UnLoginCastService.TAG, "FXF seek, last pm is null");
                }
                if (arrayList.size() > 0) {
                    UnLoginCastService.this.startSeekTime = System.currentTimeMillis() / 1000;
                    UnLoginCastService.this.startSeekTsTime = arrayList.get(0).relativetime;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        UnLoginCastService.this.mTss.add(arrayList.get(i3));
                    }
                    synchronized (UnLoginCastService.this.mawakeLock) {
                        UnLoginCastService.this.mawakeLock.notifyAll();
                    }
                }
                LogUtils.d(UnLoginCastService.TAG, "FXF   replay finish...");
            }
        }, 500L);
        LogUtils.d(TAG, "FXF replay<---");
    }

    public void seek(int i2) {
        LogUtils.d(TAG, "FXF start seek--->");
        this.mPosition = i2;
        if (this.mType != 1) {
            return;
        }
        if (this.mPause) {
            this.mPausePosition = i2;
        } else if (this.isActive) {
            this.isSeek = true;
            LogUtils.d(TAG, "FXF start seek...");
            new Timer(true).schedule(new TimerTask() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    UnLoginCastService unLoginCastService = UnLoginCastService.this;
                    if (unLoginCastService.isActive) {
                        unLoginCastService.isSeek = false;
                        unLoginCastService.mTss.clear();
                        UpMessageManager.getInstance(UnLoginCastService.mContext).clear();
                        List<ParseM3u8.TS> arrayList = new ArrayList<>();
                        UnLoginCastService unLoginCastService2 = UnLoginCastService.this;
                        ParseM3u8 parseM3u8 = unLoginCastService2.mLastpm;
                        if (parseM3u8 == null) {
                            LogUtils.e(UnLoginCastService.TAG, "FXF seek, last pm is null");
                        } else {
                            arrayList = parseM3u8.getTslist(unLoginCastService2.mPosition);
                        }
                        if (arrayList.size() > 0) {
                            UnLoginCastService.this.startSeekTime = System.currentTimeMillis() / 1000;
                            UnLoginCastService.this.startSeekTsTime = arrayList.get(0).relativetime;
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                UnLoginCastService.this.mTss.add(arrayList.get(i3));
                            }
                            synchronized (UnLoginCastService.this.mawakeLock) {
                                UnLoginCastService.this.mawakeLock.notifyAll();
                            }
                        }
                        LogUtils.d(UnLoginCastService.TAG, "FXF   seek finish...");
                    }
                }
            }, 2000L);
        }
    }

    public void setPullInterval(int i2) {
        this.mInterval = i2;
        String str = TAG;
        LogUtils.d(str, "setPullInterval " + this.mInterval);
    }

    public int startService(String str, String str2, int i2) {
        LogUtils.d(TAG, "FXF startService--->");
        if (this.isActive) {
            stopService(0);
        }
        this.mPause = false;
        this.isActive = true;
        this.mType = i2;
        this.mRoomUrl = str2;
        this.mCastId = str;
        Thread thread = new Thread() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                UnLoginCastService.this.tsWork();
            }
        };
        this.requestTsTask = thread;
        thread.start();
        getM3u8task(str2);
        LogUtils.d(TAG, "FXF startService<---");
        return 0;
    }

    public void stopService(int i2) {
        LogUtils.d(TAG, "FXF stopService--->");
        this.isActive = false;
        if (i2 == 0) {
            this.mLastpm = null;
        }
        this.mTryTimes = 0;
        if (i2 == 1 && this.mType == 1) {
            if (this.mTss.size() > 0) {
                this.mPausePosition = (int) this.mTss.peek().relativetime;
            } else {
                this.mPausePosition = 0;
            }
        }
        this.mTss.clear();
        synchronized (this.mawakeLock) {
            this.mawakeLock.notifyAll();
        }
        Thread thread = this.requestTsTask;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.requestTsTask = null;
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        Timer timer2 = this.mAxisTimer;
        if (timer2 != null) {
            timer2.cancel();
            this.mAxisTimer = null;
        }
        UpMessageManager.getInstance(mContext).clear();
        LogUtils.d(TAG, "FXF stopService<---");
    }
}
