package com.baidu.mobstat.dxmpay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class BDStatCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVOKE_ACT = 1;
    public static final int INVOKE_API = 0;
    public static final int INVOKE_CUSTOME = 3;
    public static final int INVOKE_FRAG = 2;

    /* renamed from: a  reason: collision with root package name */
    public static BDStatCore f41303a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f41304b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f41305c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41306d;

    /* renamed from: e  reason: collision with root package name */
    public SessionAnalysis f41307e;

    /* renamed from: f  reason: collision with root package name */
    public EventAnalysis f41308f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f41309g;

    /* renamed from: h  reason: collision with root package name */
    public long f41310h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f41311i;
    public Handler j;

    public BDStatCore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41305c = false;
        this.f41306d = false;
        this.f41310h = 0L;
        this.f41311i = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f41304b = new Handler(handlerThread.getLooper());
        this.f41307e = new SessionAnalysis();
        this.f41308f = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.j = new Handler(handlerThread2.getLooper());
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, context) == null) {
        }
    }

    public static BDStatCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f41303a == null) {
                synchronized (BDStatCore.class) {
                    if (f41303a == null) {
                        f41303a = new BDStatCore();
                    }
                }
            }
            return f41303a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f41307e.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f41304b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LaunchInfo f41349a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f41350b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41351c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, launchInfo, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41351c = this;
                this.f41349a = launchInfo;
                this.f41350b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f41351c.f41307e.autoTrackLaunchInfo(this.f41349a, this.f41350b);
                }
            }
        });
    }

    public void autoTrackSessionEndTime(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || context == null) {
            return;
        }
        init(context);
        this.f41304b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f41355a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f41356b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41357c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, Long.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41357c = this;
                this.f41355a = context;
                this.f41356b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f41357c.f41307e.autoTrackSessionEndTime(this.f41355a, this.f41356b);
                }
            }
        });
    }

    public void autoTrackSessionStartTime(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) || context == null) {
            return;
        }
        init(context);
        this.f41304b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f41352a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f41353b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41354c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, Long.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41354c = this;
                this.f41352a = context;
                this.f41353b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f41354c.f41307e.autoTrackSessionStartTime(this.f41352a, this.f41353b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f41309g;
            if (runnable != null) {
                this.f41304b.removeCallbacks(runnable);
            }
            this.f41309g = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f41307e.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f41358a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41359b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41359b = this;
                this.f41358a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f41359b.f41307e.doSendLogCheck(this.f41358a, System.currentTimeMillis());
                }
            }
        };
        this.f41309g = runnable;
        this.f41304b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41307e.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41307e.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41307e.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f41305c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f41304b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f41312a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f41313b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41313b = this;
                    this.f41312a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f41313b.f41305c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.f41312a);
                    this.f41313b.f41305c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f41307e.isSessionStart()) {
            return;
        }
        init(context);
        this.f41304b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f41344a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f41345b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f41346c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f41347d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41348e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, Long.valueOf(r8), str2, str3};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41348e = this;
                this.f41344a = context;
                this.f41345b = r8;
                this.f41346c = str2;
                this.f41347d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.f41344a);
                    EventAnalysis eventAnalysis = this.f41348e.f41308f;
                    Context context2 = this.f41344a;
                    long j = this.f41345b;
                    eventAnalysis.onEvent(context2, j, this.f41346c, this.f41347d, 1, j, null, null, false);
                    DataCore.instance().saveLogData(this.f41344a, true, false, this.f41345b, false);
                    if (this.f41345b - this.f41348e.f41310h <= 30000 || !w.h(this.f41344a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.f41344a);
                    this.f41348e.f41310h = this.f41345b;
                }
            }
        });
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, str, str2, Integer.valueOf(i2), extraInfo, map, Boolean.valueOf(z)}) == null) {
            onEvent(context, str, str2, i2, extraInfo, map, z, false);
        }
    }

    public void onEventDuration(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, str2, Long.valueOf(j), extraInfo, map, Boolean.valueOf(z)}) == null) {
            onEventDuration(context, str, str2, j, extraInfo, map, z, false);
        }
    }

    public void onEventEnd(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, context, str, str2, extraInfo, map) == null) {
            onEventEnd(context, str, str2, extraInfo, map, false);
        }
    }

    public void onEventStart(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f41304b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41314a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41315b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f41316c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f41317d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41318e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41319f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str2, context, Long.valueOf(r9), Boolean.valueOf(z), str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41319f = this;
                this.f41314a = str2;
                this.f41315b = context;
                this.f41316c = r9;
                this.f41317d = z;
                this.f41318e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f41314a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f41319f.f41307e.onSessionStart(this.f41315b, this.f41316c, this.f41317d);
                    h.c().a("Start event" + this.f41319f.a(this.f41318e, str3, 1, -1L, null, null));
                    this.f41319f.f41308f.onEventStart(this.f41315b, this.f41318e, str3, this.f41316c);
                }
            }
        });
    }

    public void onPageEnd(Context context, String str, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, context, str, extraInfo) == null) {
            onPageEnd(context, str, extraInfo, false);
        }
    }

    public void onPageStart(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        b(context);
        this.f41304b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41363a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41364b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f41365c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f41366d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41367e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, context, Integer.valueOf(r9), Long.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41367e = this;
                this.f41363a = str;
                this.f41364b = context;
                this.f41365c = r9;
                this.f41366d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("Start page view " + this.f41363a);
                    this.f41367e.f41307e.onPageStart(this.f41364b, this.f41363a, this.f41365c, this.f41366d);
                }
            }
        });
    }

    public void onPause(Activity activity, boolean z, ExtraInfo extraInfo) {
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{activity, Boolean.valueOf(z), extraInfo}) == null) || activity == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        this.f41304b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f41382a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f41383b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f41384c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f41385d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41386e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, Boolean.valueOf(z), applicationContext, extraInfo};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41386e = this;
                this.f41382a = r7;
                this.f41383b = z;
                this.f41384c = applicationContext;
                this.f41385d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f41382a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f41383b) {
                    h c2 = h.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f41386e.f41307e.onPageEndAct(this.f41384c, name, simpleName, charSequence, System.currentTimeMillis(), this.f41383b, this.f41385d);
            }
        });
    }

    public void onResume(Activity activity, boolean z) {
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, activity, z) == null) || activity == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        this.f41304b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f41375a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f41376b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f41377c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41378d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, Boolean.valueOf(z), applicationContext};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41378d = this;
                this.f41375a = r7;
                this.f41376b = z;
                this.f41377c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f41375a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f41376b) {
                    h c2 = h.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f41378d.f41307e.onPageStartAct(this.f41377c, name, currentTimeMillis, this.f41376b);
            }
        });
    }

    public void onSessionStart(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, context, z) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f41304b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f41328a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f41329b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f41330c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41331d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, Long.valueOf(r8), Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41331d = this;
                this.f41328a = context;
                this.f41329b = r8;
                this.f41330c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f41331d.f41307e.onSessionStart(this.f41328a, this.f41329b, this.f41330c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f41307e.isSessionStart()) {
            return;
        }
        this.f41304b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f41341a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f41342b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41343c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41343c = this;
                this.f41341a = context;
                this.f41342b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.f41341a, this.f41342b);
                }
            }
        });
    }

    public void setAuthorizedState(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048607, this, context, z) == null) || context == null) {
            return;
        }
        this.f41306d = z;
        init(context);
        b(context);
    }

    public void setAutoSendLog(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048608, this, context, z) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f41307e.setAutoSend(z);
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f41307e.setSessionTimeOut(i2);
        }
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                String className = stackTraceElement.getClassName();
                if (!TextUtils.isEmpty(className)) {
                    Class<?> cls = null;
                    try {
                        cls = Class.forName(className);
                    } catch (Throwable unused) {
                    }
                    if (cls != null && Activity.class.isAssignableFrom(cls)) {
                        return cls.getName();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, str2, Integer.valueOf(i2), extraInfo, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || context == null) {
            return;
        }
        init(context);
        this.f41304b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41397a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41398b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f41399c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f41400d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41401e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f41402f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f41403g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f41404h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f41405i;
            public final /* synthetic */ BDStatCore j;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {this, str2, context, Long.valueOf(r10), Boolean.valueOf(z), str, Integer.valueOf(i2), map, extraInfo, Boolean.valueOf(z2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = this;
                this.f41397a = str2;
                this.f41398b = context;
                this.f41399c = r10;
                this.f41400d = z;
                this.f41401e = str;
                this.f41402f = i2;
                this.f41403g = map;
                this.f41404h = extraInfo;
                this.f41405i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f41397a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.j.f41307e.onSessionStart(this.f41398b, this.f41399c, this.f41400d);
                    h.c().a("Put event" + this.j.a(this.f41401e, str3, this.f41402f, 0L, this.f41403g, this.f41404h));
                    this.j.f41308f.onEvent(this.f41398b, this.j.f41307e.getSessionStartTime(), this.f41401e, str3, this.f41402f, this.f41399c, this.f41404h, this.f41403g, this.f41405i);
                }
            }
        });
    }

    public void onEventDuration(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, str, str2, Long.valueOf(j), extraInfo, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        b(context);
        this.f41304b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41332a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41333b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f41334c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f41335d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41336e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f41337f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f41338g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f41339h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f41340i;
            public final /* synthetic */ BDStatCore j;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {this, str2, context, Long.valueOf(r10), Boolean.valueOf(z), str, Long.valueOf(j), map, extraInfo, Boolean.valueOf(z2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = this;
                this.f41332a = str2;
                this.f41333b = context;
                this.f41334c = r10;
                this.f41335d = z;
                this.f41336e = str;
                this.f41337f = j;
                this.f41338g = map;
                this.f41339h = extraInfo;
                this.f41340i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f41332a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.j.f41307e.onSessionStart(this.f41333b, this.f41334c, this.f41335d);
                    h.c().a("Put event" + this.j.a(this.f41336e, str3, 1, this.f41337f, this.f41338g, this.f41339h));
                    this.j.f41308f.onEventDuration(this.f41333b, this.j.f41307e.getSessionStartTime(), this.f41336e, str3, this.f41334c, this.f41337f, this.f41339h, this.f41338g, this.f41340i);
                }
            }
        });
    }

    public void onEventEnd(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{context, str, str2, extraInfo, map, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        this.f41304b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41320a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f41321b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f41322c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f41323d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f41324e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f41325f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f41326g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41327h;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str2, str, map, extraInfo, context, Long.valueOf(r12), Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41327h = this;
                this.f41320a = str2;
                this.f41321b = str;
                this.f41322c = map;
                this.f41323d = extraInfo;
                this.f41324e = context;
                this.f41325f = r12;
                this.f41326g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f41320a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f41327h.f41307e.getSessionStartTime();
                    h.c().a("End event" + this.f41327h.a(this.f41321b, str3, 1, -1L, this.f41322c, this.f41323d));
                    this.f41327h.f41308f.onEventEnd(this.f41324e, sessionStartTime, this.f41321b, str3, this.f41325f, this.f41323d, this.f41322c, this.f41326g);
                }
            }
        });
    }

    public void onPageEnd(Context context, String str, ExtraInfo extraInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{context, str, extraInfo, Boolean.valueOf(z)}) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        this.f41304b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41368a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41369b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f41370c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f41371d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f41372e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f41373f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41374g;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, context, r9, Long.valueOf(r10), extraInfo, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41374g = this;
                this.f41368a = str;
                this.f41369b = context;
                this.f41370c = r9;
                this.f41371d = r10;
                this.f41372e = extraInfo;
                this.f41373f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("End page view " + this.f41368a);
                    SessionAnalysis sessionAnalysis = this.f41374g.f41307e;
                    Context context2 = this.f41369b;
                    String str2 = this.f41368a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f41370c, this.f41371d, this.f41372e, this.f41373f);
                }
            }
        });
    }

    private int a() {
        InterceptResult invokeV;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                cls = Class.forName("android.app.Fragment");
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            try {
                cls2 = Class.forName("androidx.fragment.app.Fragment");
            } catch (ClassNotFoundException unused2) {
                cls2 = null;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i2 = 0; stackTrace != null && i2 < stackTrace.length; i2++) {
                String className = stackTrace[i2].getClassName();
                if (!TextUtils.isEmpty(className) && "onResume".equals(stackTrace[i2].getMethodName())) {
                    try {
                        cls3 = Class.forName(className);
                    } catch (Throwable unused3) {
                        cls3 = null;
                    }
                    if (cls3 == null) {
                        continue;
                    } else if (Activity.class.isAssignableFrom(cls3)) {
                        return 1;
                    } else {
                        if (cls != null && cls.isAssignableFrom(cls3)) {
                            return 2;
                        }
                        if (cls2 != null && cls2.isAssignableFrom(cls3)) {
                            return 2;
                        }
                    }
                }
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void onEvent(Context context, String str, String str2, int i2, String str3, String str4, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f41304b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41406a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41407b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f41408c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f41409d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f41410e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f41411f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f41412g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f41413h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f41414i;
            public final /* synthetic */ BDStatCore j;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {this, str2, context, Long.valueOf(r10), str, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = this;
                this.f41406a = str2;
                this.f41407b = context;
                this.f41408c = r10;
                this.f41409d = str;
                this.f41410e = i2;
                this.f41411f = str3;
                this.f41412g = str4;
                this.f41413h = i3;
                this.f41414i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.f41406a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.j.f41307e.onSessionStart(this.f41407b, this.f41408c, false);
                    h.c().a("Put event" + this.j.a(this.f41409d, str5, this.f41410e, 0L, null, null));
                    this.j.f41308f.onEvent(this.f41407b, this.j.f41307e.getSessionStartTime(), this.f41409d, str5, this.f41410e, this.f41408c, this.f41411f, this.f41412g, this.f41413h, this.f41414i);
                }
            }
        });
    }

    public void onPause(Fragment fragment) {
        FragmentActivity activity;
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, fragment) == null) || fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        this.f41304b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f41387a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f41388b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f41389c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f41390d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41391e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, fragment, activity, applicationContext};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41391e = this;
                this.f41387a = r7;
                this.f41388b = fragment;
                this.f41389c = activity;
                this.f41390d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f41387a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f41388b.getClass().getName();
                String simpleName = this.f41388b.getClass().getSimpleName();
                CharSequence title = this.f41389c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f41391e.f41307e.onPageEndFrag(this.f41390d, name, simpleName, charSequence, System.currentTimeMillis());
            }
        });
    }

    public void onResume(Fragment fragment) {
        FragmentActivity activity;
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, fragment) == null) || fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        this.f41304b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f41360a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41361b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41362c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, applicationContext};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41362c = this;
                this.f41360a = r7;
                this.f41361b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f41360a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f41362c.f41307e.onPageStartFrag(this.f41361b, name, currentTimeMillis);
            }
        });
    }

    public void onEvent(Context context, String str, String str2, int i2, long j, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j), jSONArray, jSONArray2, str3, str4, str5, map}) == null) {
            onEvent(context, str, str2, i2, j, jSONArray, jSONArray2, str3, str4, str5, map, false);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, long j, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f41304b.post(new Runnable(this, str2, context, j, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41415a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41416b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f41417c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f41418d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f41419e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f41420f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f41421g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f41422h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f41423i;
            public final /* synthetic */ String j;
            public final /* synthetic */ String k;
            public final /* synthetic */ boolean l;
            public final /* synthetic */ BDStatCore m;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {this, str2, context, Long.valueOf(j), str, Integer.valueOf(i2), map, jSONArray, jSONArray2, str3, str4, str5, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.m = this;
                this.f41415a = str2;
                this.f41416b = context;
                this.f41417c = j;
                this.f41418d = str;
                this.f41419e = i2;
                this.f41420f = map;
                this.f41421g = jSONArray;
                this.f41422h = jSONArray2;
                this.f41423i = str3;
                this.j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.f41415a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f41307e.onSessionStart(this.f41416b, this.f41417c, false);
                    h.c().a("Put event" + this.m.a(this.f41418d, str6, this.f41419e, 0L, this.f41420f, null));
                    this.m.f41308f.onEvent(this.f41416b, this.m.f41307e.getSessionStartTime(), this.f41418d, str6, this.f41419e, this.f41417c, this.f41421g, this.f41422h, this.f41423i, this.j, this.k, this.f41420f, this.l);
                }
            }
        });
    }

    @SuppressLint({"NewApi"})
    public void onPause(android.app.Fragment fragment) {
        Activity activity;
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, fragment) == null) || fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        this.f41304b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f41392a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f41393b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f41394c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f41395d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41396e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, fragment, activity, applicationContext};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41396e = this;
                this.f41392a = r7;
                this.f41393b = fragment;
                this.f41394c = activity;
                this.f41395d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f41392a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f41393b.getClass().getName();
                String simpleName = this.f41393b.getClass().getSimpleName();
                CharSequence title = this.f41394c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f41396e.f41307e.onPageEndFrag(this.f41395d, name, simpleName, charSequence, System.currentTimeMillis());
            }
        });
    }

    @SuppressLint({"NewApi"})
    public void onResume(android.app.Fragment fragment) {
        Activity activity;
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, fragment) == null) || fragment == null || (activity = fragment.getActivity()) == null || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        init(applicationContext);
        b(applicationContext);
        this.f41304b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f41379a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f41380b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f41381c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, applicationContext};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41381c = this;
                this.f41379a = r7;
                this.f41380b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f41379a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f41381c.f41307e.onPageStartFrag(this.f41380b, name, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2, int i2, long j, Map<String, String> map, ExtraInfo extraInfo) {
        InterceptResult invokeCommon;
        JSONObject jSONObject;
        JSONObject dumpToJson;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, Integer.valueOf(i2), Long.valueOf(j), map, extraInfo})) == null) {
            StringBuilder sb = new StringBuilder();
            if (map != null && map.size() != 0) {
                try {
                    jSONObject = new JSONObject(map.toString());
                } catch (Exception unused) {
                }
                dumpToJson = extraInfo != null ? extraInfo.dumpToJson() : null;
                sb.append(" eventId " + str + ", with eventLabel " + str2 + ", with acc " + i2);
                if (j > 0) {
                    sb.append(", with duration " + j);
                }
                if (jSONObject != null && jSONObject.length() != 0) {
                    sb.append(", with attributes " + jSONObject);
                }
                if (dumpToJson != null && dumpToJson.length() != 0) {
                    sb.append(", with extraInfo " + dumpToJson);
                }
                return sb.toString();
            }
            jSONObject = null;
            if (extraInfo != null) {
            }
            sb.append(" eventId " + str + ", with eventLabel " + str2 + ", with acc " + i2);
            if (j > 0) {
            }
            if (jSONObject != null) {
                sb.append(", with attributes " + jSONObject);
            }
            if (dumpToJson != null) {
                sb.append(", with extraInfo " + dumpToJson);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }
}
