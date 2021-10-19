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
/* loaded from: classes5.dex */
public class BDStatCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVOKE_ACT = 1;
    public static final int INVOKE_API = 0;
    public static final int INVOKE_CUSTOME = 3;
    public static final int INVOKE_FRAG = 2;

    /* renamed from: a  reason: collision with root package name */
    public static BDStatCore f43515a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f43516b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f43517c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43518d;

    /* renamed from: e  reason: collision with root package name */
    public SessionAnalysis f43519e;

    /* renamed from: f  reason: collision with root package name */
    public EventAnalysis f43520f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f43521g;

    /* renamed from: h  reason: collision with root package name */
    public long f43522h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f43523i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f43524j;

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
        this.f43517c = false;
        this.f43518d = false;
        this.f43522h = 0L;
        this.f43523i = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f43516b = new Handler(handlerThread.getLooper());
        this.f43519e = new SessionAnalysis();
        this.f43520f = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f43524j = new Handler(handlerThread2.getLooper());
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
            if (f43515a == null) {
                synchronized (BDStatCore.class) {
                    if (f43515a == null) {
                        f43515a = new BDStatCore();
                    }
                }
            }
            return f43515a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f43519e.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f43516b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LaunchInfo f43563a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43564b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43565c;

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
                this.f43565c = this;
                this.f43563a = launchInfo;
                this.f43564b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43565c.f43519e.autoTrackLaunchInfo(this.f43563a, this.f43564b);
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
        this.f43516b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43569a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43570b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43571c;

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
                this.f43571c = this;
                this.f43569a = context;
                this.f43570b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43571c.f43519e.autoTrackSessionEndTime(this.f43569a, this.f43570b);
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
        this.f43516b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43566a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43567b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43568c;

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
                this.f43568c = this;
                this.f43566a = context;
                this.f43567b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43568c.f43519e.autoTrackSessionStartTime(this.f43566a, this.f43567b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f43521g;
            if (runnable != null) {
                this.f43516b.removeCallbacks(runnable);
            }
            this.f43521g = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f43519e.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43572a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43573b;

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
                this.f43573b = this;
                this.f43572a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43573b.f43519e.doSendLogCheck(this.f43572a, System.currentTimeMillis());
                }
            }
        };
        this.f43521g = runnable;
        this.f43516b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43519e.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43519e.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43519e.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f43517c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f43516b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f43525a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f43526b;

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
                    this.f43526b = this;
                    this.f43525a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f43526b.f43517c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.f43525a);
                    this.f43526b.f43517c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f43519e.isSessionStart()) {
            return;
        }
        init(context);
        this.f43516b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43558a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43559b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43560c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43561d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43562e;

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
                this.f43562e = this;
                this.f43558a = context;
                this.f43559b = r8;
                this.f43560c = str2;
                this.f43561d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.f43558a);
                    EventAnalysis eventAnalysis = this.f43562e.f43520f;
                    Context context2 = this.f43558a;
                    long j2 = this.f43559b;
                    eventAnalysis.onEvent(context2, j2, this.f43560c, this.f43561d, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(this.f43558a, true, false, this.f43559b, false);
                    if (this.f43559b - this.f43562e.f43522h <= 30000 || !w.h(this.f43558a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.f43558a);
                    this.f43562e.f43522h = this.f43559b;
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
        this.f43516b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43527a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43528b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43529c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43530d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43531e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43532f;

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
                this.f43532f = this;
                this.f43527a = str2;
                this.f43528b = context;
                this.f43529c = r9;
                this.f43530d = z;
                this.f43531e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43527a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43532f.f43519e.onSessionStart(this.f43528b, this.f43529c, this.f43530d);
                    h.c().a("Start event" + this.f43532f.a(this.f43531e, str3, 1, -1L, null, null));
                    this.f43532f.f43520f.onEventStart(this.f43528b, this.f43531e, str3, this.f43529c);
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
        this.f43516b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43577a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43578b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f43579c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f43580d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43581e;

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
                this.f43581e = this;
                this.f43577a = str;
                this.f43578b = context;
                this.f43579c = r9;
                this.f43580d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("Start page view " + this.f43577a);
                    this.f43581e.f43519e.onPageStart(this.f43578b, this.f43577a, this.f43579c, this.f43580d);
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
        this.f43516b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43596a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43597b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f43598c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43599d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43600e;

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
                this.f43600e = this;
                this.f43596a = r7;
                this.f43597b = z;
                this.f43598c = applicationContext;
                this.f43599d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f43596a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f43597b) {
                    h c2 = h.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f43600e.f43519e.onPageEndAct(this.f43598c, name, simpleName, charSequence, System.currentTimeMillis(), this.f43597b, this.f43599d);
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
        this.f43516b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43589a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43590b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f43591c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43592d;

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
                this.f43592d = this;
                this.f43589a = r7;
                this.f43590b = z;
                this.f43591c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f43589a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f43590b) {
                    h c2 = h.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f43592d.f43519e.onPageStartAct(this.f43591c, name, currentTimeMillis, this.f43590b);
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
        this.f43516b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43541a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43542b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f43543c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43544d;

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
                this.f43544d = this;
                this.f43541a = context;
                this.f43542b = r8;
                this.f43543c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43544d.f43519e.onSessionStart(this.f43541a, this.f43542b, this.f43543c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f43519e.isSessionStart()) {
            return;
        }
        this.f43516b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43555a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43556b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43557c;

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
                this.f43557c = this;
                this.f43555a = context;
                this.f43556b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.f43555a, this.f43556b);
                }
            }
        });
    }

    public void setAuthorizedState(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048607, this, context, z) == null) || context == null) {
            return;
        }
        this.f43518d = z;
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
        this.f43519e.setAutoSend(z);
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f43519e.setSessionTimeOut(i2);
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
        this.f43516b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43611a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43612b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43613c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43614d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43615e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43616f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f43617g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43618h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43619i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43620j;

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
                this.f43620j = this;
                this.f43611a = str2;
                this.f43612b = context;
                this.f43613c = r10;
                this.f43614d = z;
                this.f43615e = str;
                this.f43616f = i2;
                this.f43617g = map;
                this.f43618h = extraInfo;
                this.f43619i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43611a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43620j.f43519e.onSessionStart(this.f43612b, this.f43613c, this.f43614d);
                    h.c().a("Put event" + this.f43620j.a(this.f43615e, str3, this.f43616f, 0L, this.f43617g, this.f43618h));
                    this.f43620j.f43520f.onEvent(this.f43612b, this.f43620j.f43519e.getSessionStartTime(), this.f43615e, str3, this.f43616f, this.f43613c, this.f43618h, this.f43617g, this.f43619i);
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
        this.f43516b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43545a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43546b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43547c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43548d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43549e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43550f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f43551g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43552h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43553i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43554j;

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
                this.f43554j = this;
                this.f43545a = str2;
                this.f43546b = context;
                this.f43547c = r10;
                this.f43548d = z;
                this.f43549e = str;
                this.f43550f = j2;
                this.f43551g = map;
                this.f43552h = extraInfo;
                this.f43553i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43545a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43554j.f43519e.onSessionStart(this.f43546b, this.f43547c, this.f43548d);
                    h.c().a("Put event" + this.f43554j.a(this.f43549e, str3, 1, this.f43550f, this.f43551g, this.f43552h));
                    this.f43554j.f43520f.onEventDuration(this.f43546b, this.f43554j.f43519e.getSessionStartTime(), this.f43549e, str3, this.f43547c, this.f43550f, this.f43552h, this.f43551g, this.f43553i);
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
        this.f43516b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43533a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43534b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f43535c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43536d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f43537e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43538f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f43539g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43540h;

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
                this.f43540h = this;
                this.f43533a = str2;
                this.f43534b = str;
                this.f43535c = map;
                this.f43536d = extraInfo;
                this.f43537e = context;
                this.f43538f = r12;
                this.f43539g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43533a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f43540h.f43519e.getSessionStartTime();
                    h.c().a("End event" + this.f43540h.a(this.f43534b, str3, 1, -1L, this.f43535c, this.f43536d));
                    this.f43540h.f43520f.onEventEnd(this.f43537e, sessionStartTime, this.f43534b, str3, this.f43538f, this.f43536d, this.f43535c, this.f43539g);
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
        this.f43516b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43582a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43583b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43584c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f43585d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43586e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f43587f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43588g;

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
                this.f43588g = this;
                this.f43582a = str;
                this.f43583b = context;
                this.f43584c = r9;
                this.f43585d = r10;
                this.f43586e = extraInfo;
                this.f43587f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("End page view " + this.f43582a);
                    SessionAnalysis sessionAnalysis = this.f43588g.f43519e;
                    Context context2 = this.f43583b;
                    String str2 = this.f43582a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f43584c, this.f43585d, this.f43586e, this.f43587f);
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
        this.f43516b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43621a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43622b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43623c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43624d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43625e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43626f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43627g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f43628h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43629i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43630j;

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
                this.f43630j = this;
                this.f43621a = str2;
                this.f43622b = context;
                this.f43623c = r10;
                this.f43624d = str;
                this.f43625e = i2;
                this.f43626f = str3;
                this.f43627g = str4;
                this.f43628h = i3;
                this.f43629i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.f43621a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.f43630j.f43519e.onSessionStart(this.f43622b, this.f43623c, false);
                    h.c().a("Put event" + this.f43630j.a(this.f43624d, str5, this.f43625e, 0L, null, null));
                    this.f43630j.f43520f.onEvent(this.f43622b, this.f43630j.f43519e.getSessionStartTime(), this.f43624d, str5, this.f43625e, this.f43623c, this.f43626f, this.f43627g, this.f43628h, this.f43629i);
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
        this.f43516b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43601a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f43602b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f43603c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f43604d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43605e;

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
                this.f43605e = this;
                this.f43601a = r7;
                this.f43602b = fragment;
                this.f43603c = activity;
                this.f43604d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f43601a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f43602b.getClass().getName();
                String simpleName = this.f43602b.getClass().getSimpleName();
                CharSequence title = this.f43603c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f43605e.f43519e.onPageEndFrag(this.f43604d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f43516b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43574a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43575b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43576c;

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
                this.f43576c = this;
                this.f43574a = r7;
                this.f43575b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f43574a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f43576c.f43519e.onPageStartFrag(this.f43575b, name, currentTimeMillis);
            }
        });
    }

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map}) == null) {
            onEvent(context, str, str2, i2, j2, jSONArray, jSONArray2, str3, str4, str5, map, false);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f43516b.post(new Runnable(this, str2, context, j2, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43631a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43632b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43633c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43634d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43635e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f43636f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43637g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43638h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f43639i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ String f43640j;
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
                this.f43631a = str2;
                this.f43632b = context;
                this.f43633c = j2;
                this.f43634d = str;
                this.f43635e = i2;
                this.f43636f = map;
                this.f43637g = jSONArray;
                this.f43638h = jSONArray2;
                this.f43639i = str3;
                this.f43640j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.f43631a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f43519e.onSessionStart(this.f43632b, this.f43633c, false);
                    h.c().a("Put event" + this.m.a(this.f43634d, str6, this.f43635e, 0L, this.f43636f, null));
                    this.m.f43520f.onEvent(this.f43632b, this.m.f43519e.getSessionStartTime(), this.f43634d, str6, this.f43635e, this.f43633c, this.f43637g, this.f43638h, this.f43639i, this.f43640j, this.k, this.f43636f, this.l);
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
        this.f43516b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43606a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f43607b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f43608c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f43609d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43610e;

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
                this.f43610e = this;
                this.f43606a = r7;
                this.f43607b = fragment;
                this.f43608c = activity;
                this.f43609d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f43606a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f43607b.getClass().getName();
                String simpleName = this.f43607b.getClass().getSimpleName();
                CharSequence title = this.f43608c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f43610e.f43519e.onPageEndFrag(this.f43609d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f43516b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43593a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43594b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43595c;

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
                this.f43595c = this;
                this.f43593a = r7;
                this.f43594b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f43593a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f43595c.f43519e.onPageStartFrag(this.f43594b, name, currentTimeMillis);
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
