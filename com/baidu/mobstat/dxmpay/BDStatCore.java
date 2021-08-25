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
    public static BDStatCore f43426a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f43427b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f43428c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43429d;

    /* renamed from: e  reason: collision with root package name */
    public SessionAnalysis f43430e;

    /* renamed from: f  reason: collision with root package name */
    public EventAnalysis f43431f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f43432g;

    /* renamed from: h  reason: collision with root package name */
    public long f43433h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f43434i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f43435j;

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
        this.f43428c = false;
        this.f43429d = false;
        this.f43433h = 0L;
        this.f43434i = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f43427b = new Handler(handlerThread.getLooper());
        this.f43430e = new SessionAnalysis();
        this.f43431f = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f43435j = new Handler(handlerThread2.getLooper());
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
            if (f43426a == null) {
                synchronized (BDStatCore.class) {
                    if (f43426a == null) {
                        f43426a = new BDStatCore();
                    }
                }
            }
            return f43426a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f43430e.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f43427b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LaunchInfo f43474a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43475b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43476c;

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
                this.f43476c = this;
                this.f43474a = launchInfo;
                this.f43475b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43476c.f43430e.autoTrackLaunchInfo(this.f43474a, this.f43475b);
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
        this.f43427b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43480a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43481b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43482c;

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
                this.f43482c = this;
                this.f43480a = context;
                this.f43481b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43482c.f43430e.autoTrackSessionEndTime(this.f43480a, this.f43481b);
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
        this.f43427b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43477a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43478b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43479c;

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
                this.f43479c = this;
                this.f43477a = context;
                this.f43478b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43479c.f43430e.autoTrackSessionStartTime(this.f43477a, this.f43478b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f43432g;
            if (runnable != null) {
                this.f43427b.removeCallbacks(runnable);
            }
            this.f43432g = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f43430e.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43483a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43484b;

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
                this.f43484b = this;
                this.f43483a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43484b.f43430e.doSendLogCheck(this.f43483a, System.currentTimeMillis());
                }
            }
        };
        this.f43432g = runnable;
        this.f43427b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43430e.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43430e.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43430e.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f43428c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f43427b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f43436a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f43437b;

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
                    this.f43437b = this;
                    this.f43436a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f43437b.f43428c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.f43436a);
                    this.f43437b.f43428c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f43430e.isSessionStart()) {
            return;
        }
        init(context);
        this.f43427b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43469a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43470b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43471c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43472d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43473e;

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
                this.f43473e = this;
                this.f43469a = context;
                this.f43470b = r8;
                this.f43471c = str2;
                this.f43472d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.f43469a);
                    EventAnalysis eventAnalysis = this.f43473e.f43431f;
                    Context context2 = this.f43469a;
                    long j2 = this.f43470b;
                    eventAnalysis.onEvent(context2, j2, this.f43471c, this.f43472d, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(this.f43469a, true, false, this.f43470b, false);
                    if (this.f43470b - this.f43473e.f43433h <= 30000 || !w.h(this.f43469a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.f43469a);
                    this.f43473e.f43433h = this.f43470b;
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
        this.f43427b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43438a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43439b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43440c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43441d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43442e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43443f;

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
                this.f43443f = this;
                this.f43438a = str2;
                this.f43439b = context;
                this.f43440c = r9;
                this.f43441d = z;
                this.f43442e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43438a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43443f.f43430e.onSessionStart(this.f43439b, this.f43440c, this.f43441d);
                    h.c().a("Start event" + this.f43443f.a(this.f43442e, str3, 1, -1L, null, null));
                    this.f43443f.f43431f.onEventStart(this.f43439b, this.f43442e, str3, this.f43440c);
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
        this.f43427b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43488a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43489b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f43490c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f43491d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43492e;

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
                this.f43492e = this;
                this.f43488a = str;
                this.f43489b = context;
                this.f43490c = r9;
                this.f43491d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("Start page view " + this.f43488a);
                    this.f43492e.f43430e.onPageStart(this.f43489b, this.f43488a, this.f43490c, this.f43491d);
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
        this.f43427b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43507a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43508b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f43509c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43510d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43511e;

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
                this.f43511e = this;
                this.f43507a = r7;
                this.f43508b = z;
                this.f43509c = applicationContext;
                this.f43510d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f43507a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f43508b) {
                    h c2 = h.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f43511e.f43430e.onPageEndAct(this.f43509c, name, simpleName, charSequence, System.currentTimeMillis(), this.f43508b, this.f43510d);
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
        this.f43427b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43500a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43501b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f43502c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43503d;

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
                this.f43503d = this;
                this.f43500a = r7;
                this.f43501b = z;
                this.f43502c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f43500a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f43501b) {
                    h c2 = h.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f43503d.f43430e.onPageStartAct(this.f43502c, name, currentTimeMillis, this.f43501b);
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
        this.f43427b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43452a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43453b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f43454c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43455d;

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
                this.f43455d = this;
                this.f43452a = context;
                this.f43453b = r8;
                this.f43454c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43455d.f43430e.onSessionStart(this.f43452a, this.f43453b, this.f43454c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f43430e.isSessionStart()) {
            return;
        }
        this.f43427b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43466a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43467b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43468c;

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
                this.f43468c = this;
                this.f43466a = context;
                this.f43467b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.f43466a, this.f43467b);
                }
            }
        });
    }

    public void setAuthorizedState(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048607, this, context, z) == null) || context == null) {
            return;
        }
        this.f43429d = z;
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
        this.f43430e.setAutoSend(z);
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f43430e.setSessionTimeOut(i2);
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
        this.f43427b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43522a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43523b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43524c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43525d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43526e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43527f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f43528g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43529h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43530i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43531j;

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
                this.f43531j = this;
                this.f43522a = str2;
                this.f43523b = context;
                this.f43524c = r10;
                this.f43525d = z;
                this.f43526e = str;
                this.f43527f = i2;
                this.f43528g = map;
                this.f43529h = extraInfo;
                this.f43530i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43522a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43531j.f43430e.onSessionStart(this.f43523b, this.f43524c, this.f43525d);
                    h.c().a("Put event" + this.f43531j.a(this.f43526e, str3, this.f43527f, 0L, this.f43528g, this.f43529h));
                    this.f43531j.f43431f.onEvent(this.f43523b, this.f43531j.f43430e.getSessionStartTime(), this.f43526e, str3, this.f43527f, this.f43524c, this.f43529h, this.f43528g, this.f43530i);
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
        this.f43427b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43456a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43457b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43458c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43459d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43460e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43461f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f43462g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43463h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43464i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43465j;

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
                this.f43465j = this;
                this.f43456a = str2;
                this.f43457b = context;
                this.f43458c = r10;
                this.f43459d = z;
                this.f43460e = str;
                this.f43461f = j2;
                this.f43462g = map;
                this.f43463h = extraInfo;
                this.f43464i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43456a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43465j.f43430e.onSessionStart(this.f43457b, this.f43458c, this.f43459d);
                    h.c().a("Put event" + this.f43465j.a(this.f43460e, str3, 1, this.f43461f, this.f43462g, this.f43463h));
                    this.f43465j.f43431f.onEventDuration(this.f43457b, this.f43465j.f43430e.getSessionStartTime(), this.f43460e, str3, this.f43458c, this.f43461f, this.f43463h, this.f43462g, this.f43464i);
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
        this.f43427b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43444a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43445b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f43446c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43447d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f43448e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43449f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f43450g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43451h;

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
                this.f43451h = this;
                this.f43444a = str2;
                this.f43445b = str;
                this.f43446c = map;
                this.f43447d = extraInfo;
                this.f43448e = context;
                this.f43449f = r12;
                this.f43450g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43444a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f43451h.f43430e.getSessionStartTime();
                    h.c().a("End event" + this.f43451h.a(this.f43445b, str3, 1, -1L, this.f43446c, this.f43447d));
                    this.f43451h.f43431f.onEventEnd(this.f43448e, sessionStartTime, this.f43445b, str3, this.f43449f, this.f43447d, this.f43446c, this.f43450g);
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
        this.f43427b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43493a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43494b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43495c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f43496d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43497e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f43498f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43499g;

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
                this.f43499g = this;
                this.f43493a = str;
                this.f43494b = context;
                this.f43495c = r9;
                this.f43496d = r10;
                this.f43497e = extraInfo;
                this.f43498f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("End page view " + this.f43493a);
                    SessionAnalysis sessionAnalysis = this.f43499g.f43430e;
                    Context context2 = this.f43494b;
                    String str2 = this.f43493a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f43495c, this.f43496d, this.f43497e, this.f43498f);
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
        this.f43427b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43532a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43533b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43534c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43535d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43536e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43537f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43538g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f43539h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43540i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43541j;

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
                this.f43541j = this;
                this.f43532a = str2;
                this.f43533b = context;
                this.f43534c = r10;
                this.f43535d = str;
                this.f43536e = i2;
                this.f43537f = str3;
                this.f43538g = str4;
                this.f43539h = i3;
                this.f43540i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.f43532a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.f43541j.f43430e.onSessionStart(this.f43533b, this.f43534c, false);
                    h.c().a("Put event" + this.f43541j.a(this.f43535d, str5, this.f43536e, 0L, null, null));
                    this.f43541j.f43431f.onEvent(this.f43533b, this.f43541j.f43430e.getSessionStartTime(), this.f43535d, str5, this.f43536e, this.f43534c, this.f43537f, this.f43538g, this.f43539h, this.f43540i);
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
        this.f43427b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43512a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f43513b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f43514c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f43515d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43516e;

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
                this.f43516e = this;
                this.f43512a = r7;
                this.f43513b = fragment;
                this.f43514c = activity;
                this.f43515d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f43512a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f43513b.getClass().getName();
                String simpleName = this.f43513b.getClass().getSimpleName();
                CharSequence title = this.f43514c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f43516e.f43430e.onPageEndFrag(this.f43515d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f43427b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43485a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43486b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43487c;

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
                this.f43487c = this;
                this.f43485a = r7;
                this.f43486b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f43485a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f43487c.f43430e.onPageStartFrag(this.f43486b, name, currentTimeMillis);
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
        this.f43427b.post(new Runnable(this, str2, context, j2, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43542a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43543b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43544c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43545d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43546e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f43547f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43548g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43549h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f43550i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ String f43551j;
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
                this.f43542a = str2;
                this.f43543b = context;
                this.f43544c = j2;
                this.f43545d = str;
                this.f43546e = i2;
                this.f43547f = map;
                this.f43548g = jSONArray;
                this.f43549h = jSONArray2;
                this.f43550i = str3;
                this.f43551j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.f43542a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f43430e.onSessionStart(this.f43543b, this.f43544c, false);
                    h.c().a("Put event" + this.m.a(this.f43545d, str6, this.f43546e, 0L, this.f43547f, null));
                    this.m.f43431f.onEvent(this.f43543b, this.m.f43430e.getSessionStartTime(), this.f43545d, str6, this.f43546e, this.f43544c, this.f43548g, this.f43549h, this.f43550i, this.f43551j, this.k, this.f43547f, this.l);
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
        this.f43427b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43517a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f43518b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f43519c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f43520d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43521e;

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
                this.f43521e = this;
                this.f43517a = r7;
                this.f43518b = fragment;
                this.f43519c = activity;
                this.f43520d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f43517a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f43518b.getClass().getName();
                String simpleName = this.f43518b.getClass().getSimpleName();
                CharSequence title = this.f43519c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f43521e.f43430e.onPageEndFrag(this.f43520d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f43427b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43504a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43505b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43506c;

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
                this.f43506c = this;
                this.f43504a = r7;
                this.f43505b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f43504a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f43506c.f43430e.onPageStartFrag(this.f43505b, name, currentTimeMillis);
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
