package com.baidu.mobstat;

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
/* loaded from: classes5.dex */
public class BDStatCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVOKE_ACT = 1;
    public static final int INVOKE_API = 0;
    public static final int INVOKE_CUSTOME = 3;
    public static final int INVOKE_FRAG = 2;

    /* renamed from: a  reason: collision with root package name */
    public static BDStatCore f42915a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f42916b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42917c;

    /* renamed from: d  reason: collision with root package name */
    public SessionAnalysis f42918d;

    /* renamed from: e  reason: collision with root package name */
    public EventAnalysis f42919e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f42920f;

    /* renamed from: g  reason: collision with root package name */
    public long f42921g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f42922h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f42923i;

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
        this.f42917c = false;
        this.f42921g = 0L;
        this.f42922h = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f42916b = new Handler(handlerThread.getLooper());
        this.f42918d = new SessionAnalysis();
        this.f42919e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f42923i = new Handler(handlerThread2.getLooper());
    }

    public static BDStatCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f42915a == null) {
                synchronized (BDStatCore.class) {
                    if (f42915a == null) {
                        f42915a = new BDStatCore();
                    }
                }
            }
            return f42915a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f42918d.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f42916b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LaunchInfo f42964a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42965b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42966c;

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
                this.f42966c = this;
                this.f42964a = launchInfo;
                this.f42965b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42966c.f42918d.autoTrackLaunchInfo(this.f42964a, this.f42965b);
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
        this.f42916b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42970a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42971b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42972c;

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
                this.f42972c = this;
                this.f42970a = context;
                this.f42971b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42972c.f42918d.autoTrackSessionEndTime(this.f42970a, this.f42971b);
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
        this.f42916b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42967a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42968b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42969c;

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
                this.f42969c = this;
                this.f42967a = context;
                this.f42968b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42969c.f42918d.autoTrackSessionStartTime(this.f42967a, this.f42968b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f42920f;
            if (runnable != null) {
                this.f42916b.removeCallbacks(runnable);
            }
            this.f42920f = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f42918d.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42976a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42977b;

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
                this.f42977b = this;
                this.f42976a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42977b.f42918d.doSendLogCheck(this.f42976a, System.currentTimeMillis());
                }
            }
        };
        this.f42920f = runnable;
        this.f42916b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42918d.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42918d.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f42918d.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f42917c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f42916b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f42924a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f42925b;

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
                    this.f42925b = this;
                    this.f42924a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f42925b.f42917c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.f42924a);
                    this.f42925b.f42917c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f42918d.isSessionStart()) {
            return;
        }
        init(context);
        this.f42916b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42957a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42958b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f42959c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f42960d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42961e;

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
                this.f42961e = this;
                this.f42957a = context;
                this.f42958b = r8;
                this.f42959c = str2;
                this.f42960d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.f42957a);
                    EventAnalysis eventAnalysis = this.f42961e.f42919e;
                    Context context2 = this.f42957a;
                    long j2 = this.f42958b;
                    eventAnalysis.onEvent(context2, j2, this.f42959c, this.f42960d, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(this.f42957a, true, false, this.f42958b, false);
                    if (this.f42958b - this.f42961e.f42921g <= 30000 || !bw.q(this.f42957a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.f42957a);
                    this.f42961e.f42921g = this.f42958b;
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

    public void onEventDuration(Context context, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, str2, Long.valueOf(j2), extraInfo, map, Boolean.valueOf(z)}) == null) {
            onEventDuration(context, str, str2, j2, extraInfo, map, z, false);
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
        this.f42916b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42926a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42927b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42928c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f42929d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42930e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42931f;

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
                this.f42931f = this;
                this.f42926a = str2;
                this.f42927b = context;
                this.f42928c = r9;
                this.f42929d = z;
                this.f42930e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42926a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f42931f.f42918d.onSessionStart(this.f42927b, this.f42928c, this.f42929d);
                    bc.c().a("Start event" + this.f42931f.a(this.f42930e, str3, 1, -1L, null, null));
                    this.f42931f.f42919e.onEventStart(this.f42927b, this.f42930e, str3, this.f42928c);
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
        this.f42916b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42978a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42979b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f42980c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f42981d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42982e;

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
                this.f42982e = this;
                this.f42978a = str;
                this.f42979b = context;
                this.f42980c = r9;
                this.f42981d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + this.f42978a);
                    this.f42982e.f42918d.onPageStart(this.f42979b, this.f42978a, this.f42980c, this.f42981d);
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
        this.f42916b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42997a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42998b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f42999c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43000d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43001e;

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
                this.f43001e = this;
                this.f42997a = r7;
                this.f42998b = z;
                this.f42999c = applicationContext;
                this.f43000d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f42997a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f42998b) {
                    bc c2 = bc.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f43001e.f42918d.onPageEndAct(this.f42999c, name, simpleName, charSequence, System.currentTimeMillis(), this.f42998b, this.f43000d);
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
        this.f42916b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42990a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42991b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f42992c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42993d;

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
                this.f42993d = this;
                this.f42990a = r7;
                this.f42991b = z;
                this.f42992c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f42990a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f42991b) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f42993d.f42918d.onPageStartAct(this.f42992c, name, currentTimeMillis, this.f42991b);
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
        this.f42916b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42940a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42941b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f42942c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42943d;

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
                this.f42943d = this;
                this.f42940a = context;
                this.f42941b = r8;
                this.f42942c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42943d.f42918d.onSessionStart(this.f42940a, this.f42941b, this.f42942c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f42918d.isSessionStart()) {
            return;
        }
        this.f42916b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42954a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f42955b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42956c;

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
                this.f42956c = this;
                this.f42954a = context;
                this.f42955b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.f42954a, this.f42955b);
                }
            }
        });
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f42918d.setSessionTimeOut(i2);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, str2, Integer.valueOf(i2), extraInfo, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || context == null) {
            return;
        }
        init(context);
        this.f42916b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43012a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43013b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43014c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43015d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43016e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43017f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f43018g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43019h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43020i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43021j;

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
                this.f43021j = this;
                this.f43012a = str2;
                this.f43013b = context;
                this.f43014c = r10;
                this.f43015d = z;
                this.f43016e = str;
                this.f43017f = i2;
                this.f43018g = map;
                this.f43019h = extraInfo;
                this.f43020i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43012a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43021j.f42918d.onSessionStart(this.f43013b, this.f43014c, this.f43015d);
                    bc.c().a("Put event" + this.f43021j.a(this.f43016e, str3, this.f43017f, 0L, this.f43018g, this.f43019h));
                    this.f43021j.f42919e.onEvent(this.f43013b, this.f43021j.f42918d.getSessionStartTime(), this.f43016e, str3, this.f43017f, this.f43014c, this.f43019h, this.f43018g, this.f43020i);
                }
            }
        });
    }

    public void onEventDuration(Context context, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, str, str2, Long.valueOf(j2), extraInfo, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        init(context);
        b(context);
        this.f42916b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42944a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42945b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42946c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f42947d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42948e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f42949f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f42950g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42951h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f42952i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42953j;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {this, str2, context, Long.valueOf(r10), Boolean.valueOf(z), str, Long.valueOf(j2), map, extraInfo, Boolean.valueOf(z2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42953j = this;
                this.f42944a = str2;
                this.f42945b = context;
                this.f42946c = r10;
                this.f42947d = z;
                this.f42948e = str;
                this.f42949f = j2;
                this.f42950g = map;
                this.f42951h = extraInfo;
                this.f42952i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42944a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f42953j.f42918d.onSessionStart(this.f42945b, this.f42946c, this.f42947d);
                    bc.c().a("Put event" + this.f42953j.a(this.f42948e, str3, 1, this.f42949f, this.f42950g, this.f42951h));
                    this.f42953j.f42919e.onEventDuration(this.f42945b, this.f42953j.f42918d.getSessionStartTime(), this.f42948e, str3, this.f42946c, this.f42949f, this.f42951h, this.f42950g, this.f42952i);
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
        this.f42916b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42932a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f42933b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f42934c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42935d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f42936e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f42937f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f42938g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42939h;

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
                this.f42939h = this;
                this.f42932a = str2;
                this.f42933b = str;
                this.f42934c = map;
                this.f42935d = extraInfo;
                this.f42936e = context;
                this.f42937f = r12;
                this.f42938g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42932a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f42939h.f42918d.getSessionStartTime();
                    bc.c().a("End event" + this.f42939h.a(this.f42933b, str3, 1, -1L, this.f42934c, this.f42935d));
                    this.f42939h.f42919e.onEventEnd(this.f42936e, sessionStartTime, this.f42933b, str3, this.f42937f, this.f42935d, this.f42934c, this.f42938g);
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
        this.f42916b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42983a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42984b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f42985c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f42986d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42987e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f42988f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42989g;

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
                this.f42989g = this;
                this.f42983a = str;
                this.f42984b = context;
                this.f42985c = r9;
                this.f42986d = r10;
                this.f42987e = extraInfo;
                this.f42988f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("End page view " + this.f42983a);
                    SessionAnalysis sessionAnalysis = this.f42989g.f42918d;
                    Context context2 = this.f42984b;
                    String str2 = this.f42983a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f42985c, this.f42986d, this.f42987e, this.f42988f);
                }
            }
        });
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

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            String appKey = CooperService.instance().getAppKey(context);
            if (TextUtils.isEmpty(appKey)) {
                return;
            }
            av.a(appKey);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, String str3, String str4, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f42916b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43022a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43023b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43024c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43025d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43026e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43027f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43028g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f43029h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43030i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43031j;

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
                this.f43031j = this;
                this.f43022a = str2;
                this.f43023b = context;
                this.f43024c = r10;
                this.f43025d = str;
                this.f43026e = i2;
                this.f43027f = str3;
                this.f43028g = str4;
                this.f43029h = i3;
                this.f43030i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.f43022a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.f43031j.f42918d.onSessionStart(this.f43023b, this.f43024c, false);
                    bc.c().a("Put event" + this.f43031j.a(this.f43025d, str5, this.f43026e, 0L, null, null));
                    this.f43031j.f42919e.onEvent(this.f43023b, this.f43031j.f42918d.getSessionStartTime(), this.f43025d, str5, this.f43026e, this.f43024c, this.f43027f, this.f43028g, this.f43029h, this.f43030i);
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
        this.f42916b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43002a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f43003b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f43004c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f43005d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43006e;

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
                this.f43006e = this;
                this.f43002a = r7;
                this.f43003b = fragment;
                this.f43004c = activity;
                this.f43005d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f43002a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f43003b.getClass().getName();
                String simpleName = this.f43003b.getClass().getSimpleName();
                CharSequence title = this.f43004c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f43006e.f42918d.onPageEndFrag(this.f43005d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f42916b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42973a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42974b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42975c;

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
                this.f42975c = this;
                this.f42973a = r7;
                this.f42974b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f42973a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f42975c.f42918d.onPageStartFrag(this.f42974b, name, currentTimeMillis);
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

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map}) == null) {
            onEvent(context, str, str2, i2, j2, jSONArray, jSONArray2, str3, str4, str5, map, false);
        }
    }

    private void b(Context context) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, context) == null) || this.f42922h || context == null || (handler = this.f42923i) == null) {
            return;
        }
        handler.postDelayed(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42962a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42963b;

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
                this.f42963b = this;
                this.f42962a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (!t.b(this.f42962a)) {
                            t.a(2).a(this.f42962a);
                        }
                    } catch (Throwable unused) {
                    }
                    this.f42963b.f42922h = false;
                }
            }
        }, 5000L);
        this.f42922h = true;
    }

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f42916b.post(new Runnable(this, str2, context, j2, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43032a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43033b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43034c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43035d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43036e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f43037f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43038g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43039h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f43040i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ String f43041j;
            public final /* synthetic */ String k;
            public final /* synthetic */ boolean l;
            public final /* synthetic */ BDStatCore m;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {this, str2, context, Long.valueOf(j2), str, Integer.valueOf(i2), map, jSONArray, jSONArray2, str3, str4, str5, Boolean.valueOf(z)};
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
                this.f43032a = str2;
                this.f43033b = context;
                this.f43034c = j2;
                this.f43035d = str;
                this.f43036e = i2;
                this.f43037f = map;
                this.f43038g = jSONArray;
                this.f43039h = jSONArray2;
                this.f43040i = str3;
                this.f43041j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.f43032a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f42918d.onSessionStart(this.f43033b, this.f43034c, false);
                    bc.c().a("Put event" + this.m.a(this.f43035d, str6, this.f43036e, 0L, this.f43037f, null));
                    this.m.f42919e.onEvent(this.f43033b, this.m.f42918d.getSessionStartTime(), this.f43035d, str6, this.f43036e, this.f43034c, this.f43038g, this.f43039h, this.f43040i, this.f43041j, this.k, this.f43037f, this.l);
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
        this.f42916b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43007a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f43008b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f43009c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f43010d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43011e;

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
                this.f43011e = this;
                this.f43007a = r7;
                this.f43008b = fragment;
                this.f43009c = activity;
                this.f43010d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f43007a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f43008b.getClass().getName();
                String simpleName = this.f43008b.getClass().getSimpleName();
                CharSequence title = this.f43009c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f43011e.f42918d.onPageEndFrag(this.f43010d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f42916b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42994a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42995b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42996c;

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
                this.f42996c = this;
                this.f42994a = r7;
                this.f42995b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f42994a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f42996c.f42918d.onPageStartFrag(this.f42995b, name, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2, int i2, long j2, Map<String, String> map, ExtraInfo extraInfo) {
        InterceptResult invokeCommon;
        JSONObject jSONObject;
        JSONObject dumpToJson;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, Integer.valueOf(i2), Long.valueOf(j2), map, extraInfo})) == null) {
            StringBuilder sb = new StringBuilder();
            if (map != null && map.size() != 0) {
                try {
                    jSONObject = new JSONObject(map.toString());
                } catch (Exception unused) {
                }
                dumpToJson = extraInfo != null ? extraInfo.dumpToJson() : null;
                sb.append(" eventId " + str + ", with eventLabel " + str2 + ", with acc " + i2);
                if (j2 > 0) {
                    sb.append(", with duration " + j2);
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
            if (j2 > 0) {
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
