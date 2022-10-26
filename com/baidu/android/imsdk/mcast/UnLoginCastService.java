package com.baidu.android.imsdk.mcast;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.ParseM3u8;
import com.baidu.android.imsdk.mcast.UpMessageManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.exoplayer2.C;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BACKPLAY = 1;
    public static final int NOWPLAY = 0;
    public static final String TAG = "UnLoginCastService";
    public static Context mContext;
    public static UnLoginCastService mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isActive;
    public boolean isSeek;
    public Timer mAxisTimer;
    public String mCastId;
    public int mInterval;
    public ParseM3u8 mLastpm;
    public boolean mPause;
    public int mPausePosition;
    public int mPosition;
    public String mRoomUrl;
    public Timer mTimer;
    public int mTryTimes;
    public ConcurrentLinkedQueue mTss;
    public int mType;
    public Object mawakeLock;
    public Thread requestTsTask;
    public long startSeekTime;
    public long startSeekTsTime;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-211987253, "Lcom/baidu/android/imsdk/mcast/UnLoginCastService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-211987253, "Lcom/baidu/android/imsdk/mcast/UnLoginCastService;");
        }
    }

    /* loaded from: classes.dex */
    public class Uptask extends UpMessageManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnLoginCastService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Uptask(UnLoginCastService unLoginCastService, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {unLoginCastService, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = unLoginCastService;
        }

        @Override // com.baidu.android.imsdk.mcast.UpMessageManager.Task
        public void work() {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONArray jSONArray3 = jSONArray.getJSONObject(i3).getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                        for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                            JSONObject jSONObject2 = jSONArray3.getJSONObject(i4);
                            if (jSONObject2.optInt("origin_id", -1) != Utility.getTriggerId(UnLoginCastService.mContext)) {
                                jSONArray2.put(jSONObject2);
                            }
                        }
                    }
                    int length2 = jSONArray2.length();
                    int i5 = (int) (optLong / C.NANOS_PER_SECOND);
                    if (i5 == 0) {
                        i2 = i5;
                        i = 0;
                    } else if (length2 >= i5) {
                        i = length2 / i5;
                        i2 = i5;
                    } else {
                        i = 1;
                        i2 = length2;
                    }
                    String str2 = UnLoginCastService.TAG;
                    LogUtils.d(str2, "HBBH work ts duration is " + optLong + " " + i5 + " num is " + i + " size is " + length2);
                    if (i <= 0) {
                        ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(this.this$0.mCastId, jSONArray2);
                        return;
                    }
                    int i6 = 0;
                    for (int i7 = 0; i7 < i2 && this.this$0.isActive && !this.this$0.isSeek; i7++) {
                        JSONArray jSONArray4 = new JSONArray();
                        int i8 = 0;
                        while (i8 < i) {
                            jSONArray4.put(jSONArray2.get(i6));
                            i8++;
                            i6++;
                        }
                        String str3 = UnLoginCastService.TAG;
                        LogUtils.d(str3, "FXF upload a ts message  " + jSONArray4.toString());
                        ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(this.this$0.mCastId, jSONArray4);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (this.this$0.isActive && !this.this$0.isSeek && i6 < length2) {
                        JSONArray jSONArray5 = new JSONArray();
                        int i9 = i6;
                        while (i6 < length2) {
                            jSONArray5.put(jSONArray2.get(i9));
                            i6++;
                            i9++;
                        }
                        String str4 = UnLoginCastService.TAG;
                        LogUtils.d(str4, "FXF upload a last ts message  " + jSONArray5.toString());
                        ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage(this.this$0.mCastId, jSONArray5);
                    }
                } catch (JSONException e2) {
                    LogUtils.e(UnLoginCastService.TAG, "m3u8 work task execption  ");
                    e2.printStackTrace();
                }
            }
        }
    }

    public UnLoginCastService(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mawakeLock = new Object();
        this.mTss = new ConcurrentLinkedQueue();
        this.mLastpm = null;
        this.mInterval = 3000;
        this.isActive = false;
        this.isSeek = false;
        this.mType = -1;
        this.mPosition = 0;
        this.requestTsTask = null;
        this.startSeekTime = 0L;
        this.startSeekTsTime = 0L;
        this.mTryTimes = 0;
        this.mPause = false;
        mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getM3u8task(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, str) == null) {
            String addListener = ListenerManager.getInstance().addListener(new GetM3u8CallBack(this) { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UnLoginCastService this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.android.imsdk.mcast.GetM3u8CallBack
                public void onResult(int i, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, bArr) == null) {
                        this.this$0.handleOnM3u8Callback(i, bArr);
                    }
                }
            });
            String str2 = TAG;
            LogUtils.d(str2, "   " + addListener + GlideException.IndentedAppendable.INDENT + str);
            GetM3u8Request getM3u8Request = new GetM3u8Request(mContext, addListener, str);
            HttpHelper.executor(mContext, getM3u8Request, getM3u8Request);
        }
    }

    private void getTstask(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, str) == null) {
            String addListener = ListenerManager.getInstance().addListener(new GetM3u8CallBack(this) { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UnLoginCastService this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.android.imsdk.mcast.GetM3u8CallBack
                public void onResult(int i, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeIL(1048576, this, i, bArr) != null) {
                        return;
                    }
                    String str2 = UnLoginCastService.TAG;
                    LogUtils.d(str2, "FXF receive a ts file " + i);
                    if (i == 0 || i == 200) {
                        this.this$0.onResultTs(bArr);
                        return;
                    }
                    String str3 = UnLoginCastService.TAG;
                    LogUtils.e(str3, "FXF getTstask error " + i);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResultTs(byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, bArr) == null) && this.isActive && !this.isSeek) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(new String(bArr));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null) {
                String str = TAG;
                LogUtils.d(str, "FXF receive a ts message " + jSONObject.toString());
                UpMessageManager.getInstance(mContext).addTaskRequest(new Uptask(this, "parse ts and upload", jSONObject.toString()));
            }
        }
    }

    public static UnLoginCastService getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            synchronized (UnLoginCastService.class) {
                if (mInstance == null) {
                    mInstance = new UnLoginCastService(context);
                }
            }
            return mInstance;
        }
        return (UnLoginCastService) invokeL.objValue;
    }

    public void setPullInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mInterval = i;
            String str = TAG;
            LogUtils.d(str, "setPullInterval " + this.mInterval);
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mPause = true;
            stopService(1);
        }
    }

    private boolean onResultM3u8(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, bArr)) == null) {
            if (this.isActive && !this.isSeek) {
                ParseM3u8 parseM3u8 = new ParseM3u8();
                try {
                    parseM3u8.readByte(bArr);
                    List arrayList = new ArrayList();
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
                            this.startSeekTsTime = ((ParseM3u8.TS) arrayList.get(0)).relativetime;
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
                        for (int i = 0; i < arrayList.size(); i++) {
                            this.mTss.add(arrayList.get(i));
                        }
                        synchronized (this.mawakeLock) {
                            this.mawakeLock.notifyAll();
                        }
                    }
                    if (!parseM3u8.isEnd() && this.mType != 1) {
                        return true;
                    }
                    LogUtils.d(TAG, "FXF pm has end-list");
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                    LogUtils.d(TAG, "parse m3u8 execption");
                    return false;
                }
            }
            String str3 = TAG;
            LogUtils.d(str3, "onResultM3u8 return, service is not active " + this.isActive + " " + this.isSeek);
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean proofreadTimeAxis(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65555, this, j)) == null) {
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
                    this.mAxisTimer.schedule(new TimerTask(this) { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ UnLoginCastService this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                synchronized (this.this$0.mawakeLock) {
                                    LogUtils.d(UnLoginCastService.TAG, "FXF execute 1 tiime axis");
                                    if (!this.this$0.isSeek && this.this$0.isActive) {
                                        this.this$0.mawakeLock.notifyAll();
                                    }
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
        return invokeJ.booleanValue;
    }

    public void stopService(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            LogUtils.d(TAG, "FXF stopService--->");
            this.isActive = false;
            if (i == 0) {
                this.mLastpm = null;
            }
            this.mTryTimes = 0;
            if (i == 1 && this.mType == 1) {
                if (this.mTss.size() > 0) {
                    this.mPausePosition = (int) ((ParseM3u8.TS) this.mTss.peek()).relativetime;
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
                } catch (InterruptedException e) {
                    e.printStackTrace();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tsWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
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
                        ParseM3u8.TS ts = (ParseM3u8.TS) this.mTss.peek();
                        if (proofreadTimeAxis(ts.relativetime)) {
                            break;
                        }
                        this.mTss.poll();
                        getTstask(ts.tsfile);
                        String str = TAG;
                        LogUtils.d(str, "FXF request ts " + i + " " + ts.tsfile + " " + ts.relativetime);
                    }
                }
            }
            LogUtils.d(TAG, "FXF requestTsTask finish");
        }
    }

    public void handleOnM3u8Callback(int i, byte[] bArr) {
        boolean onResultM3u8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) {
            String str = TAG;
            LogUtils.d(str, "FXF receive a m3u8 file " + i);
            if (i != 0 && i != 200) {
                String str2 = TAG;
                LogUtils.e(str2, "FXF getM3u8task error " + i);
                onResultM3u8 = true;
            } else {
                this.mTryTimes = 0;
                onResultM3u8 = onResultM3u8(bArr);
            }
            if (onResultM3u8 && this.isActive && !this.isSeek) {
                TimerTask timerTask = new TimerTask(this) { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UnLoginCastService this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            UnLoginCastService unLoginCastService = this.this$0;
                            if (!unLoginCastService.isActive) {
                                return;
                            }
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
    }

    public void replay(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i) == null) {
            LogUtils.d(TAG, "FXF replay--->");
            this.isActive = true;
            this.mPause = false;
            this.mType = i;
            this.mRoomUrl = str2;
            this.mCastId = str;
            Thread thread = new Thread(this) { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UnLoginCastService this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.tsWork();
                    }
                }
            };
            this.requestTsTask = thread;
            thread.start();
            new Timer(true).schedule(new TimerTask(this) { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UnLoginCastService this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        List arrayList = new ArrayList();
                        UnLoginCastService unLoginCastService = this.this$0;
                        ParseM3u8 parseM3u8 = unLoginCastService.mLastpm;
                        if (parseM3u8 != null) {
                            arrayList = parseM3u8.getTslist(unLoginCastService.mPausePosition);
                        } else {
                            LogUtils.e(UnLoginCastService.TAG, "FXF seek, last pm is null");
                        }
                        if (arrayList.size() > 0) {
                            this.this$0.startSeekTime = System.currentTimeMillis() / 1000;
                            this.this$0.startSeekTsTime = ((ParseM3u8.TS) arrayList.get(0)).relativetime;
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                this.this$0.mTss.add(arrayList.get(i2));
                            }
                            synchronized (this.this$0.mawakeLock) {
                                this.this$0.mawakeLock.notifyAll();
                            }
                        }
                        LogUtils.d(UnLoginCastService.TAG, "FXF   replay finish...");
                    }
                }
            }, 500L);
            LogUtils.d(TAG, "FXF replay<---");
        }
    }

    public int startService(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, str, str2, i)) == null) {
            LogUtils.d(TAG, "FXF startService--->");
            if (this.isActive) {
                stopService(0);
            }
            this.mPause = false;
            this.isActive = true;
            this.mType = i;
            this.mRoomUrl = str2;
            this.mCastId = str;
            Thread thread = new Thread(this) { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UnLoginCastService this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.tsWork();
                    }
                }
            };
            this.requestTsTask = thread;
            thread.start();
            getM3u8task(str2);
            LogUtils.d(TAG, "FXF startService<---");
            return 0;
        }
        return invokeLLI.intValue;
    }

    public void seek(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            LogUtils.d(TAG, "FXF start seek--->");
            this.mPosition = i;
            if (this.mType != 1) {
                return;
            }
            if (this.mPause) {
                this.mPausePosition = i;
            } else if (!this.isActive) {
            } else {
                this.isSeek = true;
                LogUtils.d(TAG, "FXF start seek...");
                new Timer(true).schedule(new TimerTask(this) { // from class: com.baidu.android.imsdk.mcast.UnLoginCastService.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UnLoginCastService this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            UnLoginCastService unLoginCastService = this.this$0;
                            if (!unLoginCastService.isActive) {
                                return;
                            }
                            unLoginCastService.isSeek = false;
                            unLoginCastService.mTss.clear();
                            UpMessageManager.getInstance(UnLoginCastService.mContext).clear();
                            List arrayList = new ArrayList();
                            UnLoginCastService unLoginCastService2 = this.this$0;
                            ParseM3u8 parseM3u8 = unLoginCastService2.mLastpm;
                            if (parseM3u8 != null) {
                                arrayList = parseM3u8.getTslist(unLoginCastService2.mPosition);
                            } else {
                                LogUtils.e(UnLoginCastService.TAG, "FXF seek, last pm is null");
                            }
                            if (arrayList.size() > 0) {
                                this.this$0.startSeekTime = System.currentTimeMillis() / 1000;
                                this.this$0.startSeekTsTime = ((ParseM3u8.TS) arrayList.get(0)).relativetime;
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    this.this$0.mTss.add(arrayList.get(i2));
                                }
                                synchronized (this.this$0.mawakeLock) {
                                    this.this$0.mawakeLock.notifyAll();
                                }
                            }
                            LogUtils.d(UnLoginCastService.TAG, "FXF   seek finish...");
                        }
                    }
                }, 2000L);
            }
        }
    }
}
