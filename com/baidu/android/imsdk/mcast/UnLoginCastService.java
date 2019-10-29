package com.baidu.android.imsdk.mcast;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.ParseM3u8;
import com.baidu.android.imsdk.mcast.UpMessageManager;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class UnLoginCastService {
    static final int BACKPLAY = 1;
    static final int NOWPLAY = 0;
    private static final String TAG = UnLoginCastService.class.getSimpleName();
    private static Context mContext;
    private static UnLoginCastService mInstance;
    Timer mAxisTimer;
    private String mCastId;
    private int mPausePosition;
    private String mRoomUrl;
    Timer mTimer;
    private Object mawakeLock = new Object();
    private ConcurrentLinkedQueue<ParseM3u8.TS> mTss = new ConcurrentLinkedQueue<>();
    ParseM3u8 mLastpm = null;
    private int mInterval = 3000;
    boolean isActive = false;
    boolean isSeek = false;
    int mType = -1;
    int mPosition = 0;
    private Thread requestTsTask = null;
    private long startSeekTime = 0;
    private long startSeekTsTime = 0;
    private int mTryTimes = 0;
    private boolean mPause = false;

    public static UnLoginCastService getInstance(Context context) {
        synchronized (UnLoginCastService.class) {
            if (mInstance == null) {
                mInstance = new UnLoginCastService(context);
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UnLoginCastService(Context context) {
        mContext = context.getApplicationContext();
    }

    public void setPullInterval(int i) {
        this.mInterval = i;
        LogUtils.d(TAG, "setPullInterval " + this.mInterval);
    }

    public int startService(String str, String str2, int i) {
        LogUtils.d(TAG, "FXF startService--->");
        if (this.isActive) {
            stopService(0);
        }
        this.mPause = false;
        this.isActive = true;
        this.mType = i;
        this.mRoomUrl = str2;
        this.mCastId = str;
        this.requestTsTask = new Thread() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                UnLoginCastService.this.tsWork();
            }
        };
        this.requestTsTask.start();
        getM3u8task(str2);
        LogUtils.d(TAG, "FXF startService<---");
        return 0;
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
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int size = this.mTss.size();
                if (!this.isActive) {
                    break;
                }
                for (int i = 0; i < size && this.isActive && !this.isSeek; i++) {
                    ParseM3u8.TS peek = this.mTss.peek();
                    if (proofreadTimeAxis(peek.relativetime)) {
                        break;
                    }
                    this.mTss.poll();
                    getTstask(peek.tsfile);
                    LogUtils.d(TAG, "FXF request ts " + i + HanziToPinyin.Token.SEPARATOR + peek.tsfile + HanziToPinyin.Token.SEPARATOR + peek.relativetime);
                }
            }
        }
        LogUtils.d(TAG, "FXF requestTsTask finish");
    }

    private boolean proofreadTimeAxis(long j) {
        if (this.mType == 1) {
            long j2 = j - this.startSeekTsTime;
            long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.startSeekTime;
            if (this.mAxisTimer == null) {
                this.mAxisTimer = new Timer(true);
            }
            if (j2 - currentTimeMillis > 5) {
                LogUtils.d(TAG, "startSeekTsTime = " + this.startSeekTsTime + "  currenttstime =  " + j + " past = " + j2);
                LogUtils.d(TAG, "startSeekTime = " + this.startSeekTime + " past = " + currentTimeMillis);
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
        }
        return false;
    }

    public void stopService(int i) {
        LogUtils.d(TAG, "FXF stopService--->");
        this.isActive = false;
        if (i == 0) {
            this.mLastpm = null;
        }
        this.mTryTimes = 0;
        if (i == 1 && this.mType == 1) {
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
        if (this.requestTsTask != null) {
            try {
                this.requestTsTask.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.requestTsTask = null;
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (this.mAxisTimer != null) {
            this.mAxisTimer.cancel();
            this.mAxisTimer = null;
        }
        UpMessageManager.getInstance(mContext).clear();
        LogUtils.d(TAG, "FXF stopService<---");
    }

    public void seek(int i) {
        LogUtils.d(TAG, "FXF start seek--->");
        this.mPosition = i;
        if (this.mType == 1) {
            if (this.mPause) {
                this.mPausePosition = i;
            } else if (this.isActive) {
                this.isSeek = true;
                LogUtils.d(TAG, "FXF start seek...");
                new Timer(true).schedule(new TimerTask() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        ArrayList arrayList;
                        if (UnLoginCastService.this.isActive) {
                            UnLoginCastService.this.isSeek = false;
                            UnLoginCastService.this.mTss.clear();
                            UpMessageManager.getInstance(UnLoginCastService.mContext).clear();
                            ArrayList arrayList2 = new ArrayList();
                            if (UnLoginCastService.this.mLastpm == null) {
                                LogUtils.e(UnLoginCastService.TAG, "FXF seek, last pm is null");
                                arrayList = arrayList2;
                            } else {
                                arrayList = UnLoginCastService.this.mLastpm.getTslist(UnLoginCastService.this.mPosition);
                            }
                            if (arrayList.size() > 0) {
                                UnLoginCastService.this.startSeekTime = System.currentTimeMillis() / 1000;
                                UnLoginCastService.this.startSeekTsTime = ((ParseM3u8.TS) arrayList.get(0)).relativetime;
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    UnLoginCastService.this.mTss.add(arrayList.get(i2));
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
    }

    public void pause() {
        this.mPause = true;
        stopService(1);
    }

    public void replay(String str, String str2, int i) {
        LogUtils.d(TAG, "FXF replay--->");
        this.isActive = true;
        this.mPause = false;
        this.mType = i;
        this.mRoomUrl = str2;
        this.mCastId = str;
        this.requestTsTask = new Thread() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                UnLoginCastService.this.tsWork();
            }
        };
        this.requestTsTask.start();
        new Timer(true).schedule(new TimerTask() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                ArrayList arrayList2 = new ArrayList();
                if (UnLoginCastService.this.mLastpm != null) {
                    arrayList = UnLoginCastService.this.mLastpm.getTslist(UnLoginCastService.this.mPausePosition);
                } else {
                    LogUtils.e(UnLoginCastService.TAG, "FXF seek, last pm is null");
                    arrayList = arrayList2;
                }
                if (arrayList.size() > 0) {
                    UnLoginCastService.this.startSeekTime = System.currentTimeMillis() / 1000;
                    UnLoginCastService.this.startSeekTsTime = ((ParseM3u8.TS) arrayList.get(0)).relativetime;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        UnLoginCastService.this.mTss.add(arrayList.get(i2));
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

    private void getTstask(String str) {
        String addListener = ListenerManager.getInstance().addListener(new GetM3u8CallBack() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.6
            @Override // com.baidu.android.imsdk.mcast.GetM3u8CallBack
            public void onResult(int i, byte[] bArr) {
                LogUtils.d(UnLoginCastService.TAG, "FXF receive a ts file " + i);
                if (i == 0 || i == 200) {
                    UnLoginCastService.this.onResultTs(bArr);
                } else {
                    LogUtils.e(UnLoginCastService.TAG, "FXF getTstask error " + i);
                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void getM3u8task(String str) {
        String addListener = ListenerManager.getInstance().addListener(new GetM3u8CallBack() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.7
            @Override // com.baidu.android.imsdk.mcast.GetM3u8CallBack
            public void onResult(int i, byte[] bArr) {
                UnLoginCastService.this.handleOnM3u8Callback(i, bArr);
            }
        });
        LogUtils.d(TAG, "   " + addListener + "  " + str);
        GetM3u8Request getM3u8Request = new GetM3u8Request(mContext, addListener, str);
        HttpHelper.executor(mContext, getM3u8Request, getM3u8Request);
    }

    public void handleOnM3u8Callback(int i, byte[] bArr) {
        boolean onResultM3u8;
        LogUtils.d(TAG, "FXF receive a m3u8 file " + i);
        if (i == 0 || i == 200) {
            this.mTryTimes = 0;
            onResultM3u8 = onResultM3u8(bArr);
        } else {
            LogUtils.e(TAG, "FXF getM3u8task error " + i);
            onResultM3u8 = true;
        }
        if (onResultM3u8 && this.isActive && !this.isSeek) {
            TimerTask timerTask = new TimerTask() { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.8
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (UnLoginCastService.this.isActive) {
                        UnLoginCastService.this.getM3u8task(UnLoginCastService.this.mRoomUrl);
                    }
                }
            };
            if (this.mTimer == null) {
                this.mTimer = new Timer(true);
            }
            this.mTimer.schedule(timerTask, this.mInterval);
        }
    }

    private boolean onResultM3u8(byte[] bArr) {
        ArrayList arrayList;
        List<ParseM3u8.TS> list;
        if (!this.isActive || this.isSeek) {
            LogUtils.d(TAG, "onResultM3u8 return, service is not active " + this.isActive + HanziToPinyin.Token.SEPARATOR + this.isSeek);
            return false;
        }
        ParseM3u8 parseM3u8 = new ParseM3u8();
        try {
            parseM3u8.readByte(bArr);
            ArrayList arrayList2 = new ArrayList();
            if (this.mLastpm == null) {
                this.mLastpm = parseM3u8;
                if (this.mType == 0) {
                    list = parseM3u8.getLatestTS(this.mLastpm.getMaxTime());
                    LogUtils.d(TAG, "FXF ts list  1 size" + list.size());
                } else {
                    List<ParseM3u8.TS> tslist = parseM3u8.getTslist(this.mPosition);
                    LogUtils.d(TAG, "FXF ts list 2 size" + tslist.size());
                    this.startSeekTime = System.currentTimeMillis() / 1000;
                    this.startSeekTsTime = tslist.get(0).relativetime;
                    list = tslist;
                }
                LogUtils.d(TAG, "FXF first get 1 m3u8");
                arrayList = list;
            } else {
                LogUtils.d(TAG, "FXF get one m3u8");
                if (parseM3u8.getMaxTime() > this.mLastpm.getMaxTime()) {
                    LogUtils.d(TAG, "FXF has new ts");
                    List<ParseM3u8.TS> newAppendTS = parseM3u8.getNewAppendTS(this.mLastpm.getMaxTime());
                    this.mLastpm = parseM3u8;
                    arrayList = newAppendTS;
                } else {
                    arrayList = arrayList2;
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    this.mTss.add(arrayList.get(i));
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
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.d(TAG, "parse m3u8 execption");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class Uptask extends UpMessageManager.Task {
        public Uptask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.mcast.UpMessageManager.Task
        public void work() {
            int i;
            int i2;
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
                LogUtils.d(UnLoginCastService.TAG, "FXF work data is " + jSONArray.toString());
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONArray jSONArray3 = jSONArray.getJSONObject(i3).getJSONArray("messages");
                    for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                        JSONObject jSONObject2 = jSONArray3.getJSONObject(i4);
                        if (jSONObject2.optInt("origin_id", -1) != Utility.getTriggerId(UnLoginCastService.mContext)) {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
                int length2 = jSONArray2.length();
                int i5 = (int) (optLong / 1000000000);
                if (i5 == 0) {
                    i = 0;
                    i2 = i5;
                } else if (length2 >= i5) {
                    i = length2 / i5;
                    i2 = i5;
                } else {
                    i = 1;
                    i2 = length2;
                }
                LogUtils.d(UnLoginCastService.TAG, "HBBH work ts duration is " + optLong + HanziToPinyin.Token.SEPARATOR + i5 + " num is " + i + " size is " + length2);
                if (i <= 0) {
                    ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(UnLoginCastService.this.mCastId, jSONArray2);
                    return;
                }
                int i6 = 0;
                int i7 = 0;
                while (i6 < i2 && UnLoginCastService.this.isActive && !UnLoginCastService.this.isSeek) {
                    JSONArray jSONArray4 = new JSONArray();
                    int i8 = i7;
                    int i9 = 0;
                    while (i9 < i) {
                        jSONArray4.put(jSONArray2.get(i8));
                        i9++;
                        i8++;
                    }
                    LogUtils.d(UnLoginCastService.TAG, "FXF upload a ts message  " + jSONArray4.toString());
                    ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(UnLoginCastService.this.mCastId, jSONArray4);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i6++;
                    i7 = i8;
                }
                if (UnLoginCastService.this.isActive && !UnLoginCastService.this.isSeek && i7 < length2) {
                    JSONArray jSONArray5 = new JSONArray();
                    int i10 = i7;
                    while (i7 < length2) {
                        jSONArray5.put(jSONArray2.get(i10));
                        i7++;
                        i10++;
                    }
                    LogUtils.d(UnLoginCastService.TAG, "FXF upload a last ts message  " + jSONArray5.toString());
                    ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(UnLoginCastService.this.mCastId, jSONArray5);
                }
            } catch (JSONException e2) {
                LogUtils.e(UnLoginCastService.TAG, "m3u8 work task execption  ");
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResultTs(byte[] bArr) {
        JSONObject jSONObject;
        if (this.isActive && !this.isSeek) {
            try {
                jSONObject = new JSONObject(new String(bArr));
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                LogUtils.d(TAG, "FXF receive a ts message " + jSONObject.toString());
                UpMessageManager.getInstance(mContext).addTaskRequest(new Uptask("parse ts and upload", jSONObject.toString()));
            }
        }
    }
}
