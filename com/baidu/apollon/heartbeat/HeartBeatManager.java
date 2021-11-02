package com.baidu.apollon.heartbeat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.c;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes6.dex */
public final class HeartBeatManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_KEY = "activity_state_oberserver";

    /* renamed from: a  reason: collision with root package name */
    public static final String f35965a = "HeartBeatManager";

    /* renamed from: b  reason: collision with root package name */
    public static final int f35966b = 180;

    /* renamed from: c  reason: collision with root package name */
    public static HeartBeatManager f35967c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Context f35968d;

    /* renamed from: e  reason: collision with root package name */
    public RestHeartBeat f35969e;

    /* renamed from: f  reason: collision with root package name */
    public Timer f35970f;

    /* renamed from: g  reason: collision with root package name */
    public b f35971g;

    /* renamed from: h  reason: collision with root package name */
    public long f35972h;

    /* renamed from: i  reason: collision with root package name */
    public c.a f35973i;

    /* loaded from: classes6.dex */
    public final class RestHeartBeat implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public long mCostTime;
        public String mHeartbeatUrl;
        public int mKeepAliveMax;
        public int mSplitTime;
        public final /* synthetic */ HeartBeatManager this$0;

        public RestHeartBeat(HeartBeatManager heartBeatManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartBeatManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = heartBeatManager;
            this.mHeartbeatUrl = "/heartbeat";
            this.mCostTime = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getSplitTimeMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? this.mSplitTime * 1000 : invokeV.longValue;
        }

        public boolean beating() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j = this.mCostTime + this.mSplitTime;
                this.mCostTime = j;
                return j > ((long) this.mKeepAliveMax);
            }
            return invokeV.booleanValue;
        }

        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSplitTime > 0 && this.mKeepAliveMax > 0 : invokeV.booleanValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mCostTime = 0L;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return " costTime:" + this.mCostTime + ",splitTime:" + this.mSplitTime;
            }
            return (String) invokeV.objValue;
        }

        public void updateCfg(HeartBeatCfgEntity heartBeatCfgEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, heartBeatCfgEntity) == null) {
                if (!TextUtils.isEmpty(heartBeatCfgEntity.KA_INIT)) {
                    this.mSplitTime = Integer.valueOf(heartBeatCfgEntity.KA_INIT).intValue();
                }
                if (!TextUtils.isEmpty(heartBeatCfgEntity.KA_MAX)) {
                    this.mKeepAliveMax = Integer.valueOf(heartBeatCfgEntity.KA_MAX).intValue();
                }
                String str = HeartBeatManager.f35965a;
                LogUtil.i(str, HeartBeatManager.f35965a + " cfg:" + heartBeatCfgEntity);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(597249689, "Lcom/baidu/apollon/heartbeat/HeartBeatManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(597249689, "Lcom/baidu/apollon/heartbeat/HeartBeatManager;");
        }
    }

    public HeartBeatManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35968d = null;
        this.f35969e = new RestHeartBeat();
        this.f35970f = null;
        this.f35971g = new b();
        this.f35972h = 0L;
        this.f35973i = new c.a(this) { // from class: com.baidu.apollon.heartbeat.HeartBeatManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ HeartBeatManager f35974a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35974a = this;
            }

            @Override // com.baidu.apollon.restnet.c.a
            public boolean a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    return TextUtils.equals(a.c().a() + this.f35974a.f35969e.mHeartbeatUrl, str);
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.apollon.restnet.c.a
            public void a(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) || TextUtils.equals(str2, str)) {
                    return;
                }
                if (!a(str)) {
                    this.f35974a.f35969e.reset();
                    long splitTimeMs = this.f35974a.f35969e.getSplitTimeMs();
                    this.f35974a.a(splitTimeMs, splitTimeMs);
                    String str3 = HeartBeatManager.f35965a;
                    LogUtil.i(str3, HeartBeatManager.f35965a + " business request success.");
                    return;
                }
                String str4 = HeartBeatManager.f35965a;
                StringBuilder sb = new StringBuilder();
                sb.append(HeartBeatManager.f35965a);
                sb.append(" heartbeat ");
                sb.append(this.f35974a.f35972h > 0 ? "background " : "");
                sb.append("request success.");
                LogUtil.i(str4, sb.toString());
            }
        };
    }

    public static synchronized HeartBeatManager getInstance() {
        InterceptResult invokeV;
        HeartBeatManager heartBeatManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (HeartBeatManager.class) {
                if (f35967c == null) {
                    f35967c = new HeartBeatManager();
                }
                heartBeatManager = f35967c;
            }
            return heartBeatManager;
        }
        return (HeartBeatManager) invokeV.objValue;
    }

    public synchronized void applyBeating() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                HeartBeatCfgEntity a2 = a.c().a(this.f35968d);
                if (a2 != null && a2.isUsed()) {
                    if (a2.validate()) {
                        this.f35969e.updateCfg(a2);
                        this.f35971g.a(1);
                    } else {
                        String str = f35965a;
                        LogUtil.w(str, f35965a + " start resp isn't validate.");
                    }
                    return;
                }
                String str2 = f35965a;
                LogUtil.w(str2, f35965a + " start resp is null or isn't used.");
                this.f35971g.a(2);
            }
        }
    }

    public void executeInForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            String str = f35965a;
            LogUtil.i(str, f35965a + " onStateChanged isForeground:" + z);
            if (z) {
                if (this.f35969e.isValid()) {
                    this.f35971g.a(1);
                    this.f35971g.a(4);
                }
                a.c().b(this.f35968d);
                return;
            }
            this.f35971g.a(3);
        }
    }

    public void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            if (context != null) {
                this.f35968d = DxmApplicationContextImpl.getApplicationContext(context);
                a.c().c(str);
                return;
            }
            throw new IllegalArgumentException("context param is null exception.");
        }
    }

    public void startHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.baidu.apollon.restnet.c.a(this.f35973i);
            a(0L, this.f35969e.getSplitTimeMs());
            String str = f35965a;
            LogUtil.i(str, f35965a + " HeartBeat start.");
        }
    }

    public void stopHeartBeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Timer timer = this.f35970f;
            if (timer != null) {
                timer.cancel();
                this.f35970f = null;
            }
            this.f35969e.reset();
            a(0L);
            com.baidu.apollon.restnet.c.a(null);
            String str = f35965a;
            LogUtil.i(str, f35965a + " HeartBeat end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.f35969e.beating()) {
                this.f35971g.a(2);
                String str = f35965a;
                LogUtil.i(str, f35965a + " heartbeat beat enough mKeepAliveMax:" + this.f35969e.mKeepAliveMax + ", costTime:" + this.f35969e.mCostTime);
            } else if (this.f35972h > 0 && Calendar.getInstance().getTimeInMillis() / 1000 > this.f35972h + 180) {
                this.f35971g.a(2);
            } else if (!NetworkUtils.isNetworkAvailable(this.f35968d)) {
                String str2 = f35965a;
                LogUtil.i(str2, f35965a + " schedule the network isn't available.");
            } else {
                RestTemplate restTemplate = new RestTemplate(this.f35968d);
                restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.b());
                try {
                    String str3 = f35965a;
                    LogUtil.i(str3, f35965a + " send heartbeat request.");
                    restTemplate.a(a.c().a() + this.f35969e.mHeartbeatUrl, null, "utf-8", String.class);
                } catch (RestRuntimeException e2) {
                    String str4 = f35965a;
                    LogUtil.errord(str4, f35965a + " Heart Beat exception:" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f35972h = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            try {
                if (this.f35970f != null) {
                    this.f35970f.cancel();
                }
                Timer timer = new Timer();
                this.f35970f = timer;
                timer.schedule(new TimerTask(this) { // from class: com.baidu.apollon.heartbeat.HeartBeatManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ HeartBeatManager f35975a;

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
                        this.f35975a = this;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f35975a.b();
                        }
                    }
                }, j, j2);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }
}
