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
    public static BDStatCore f42889a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f42890b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42891c;

    /* renamed from: d  reason: collision with root package name */
    public SessionAnalysis f42892d;

    /* renamed from: e  reason: collision with root package name */
    public EventAnalysis f42893e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f42894f;

    /* renamed from: g  reason: collision with root package name */
    public long f42895g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f42896h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f42897i;

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
        this.f42891c = false;
        this.f42895g = 0L;
        this.f42896h = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f42890b = new Handler(handlerThread.getLooper());
        this.f42892d = new SessionAnalysis();
        this.f42893e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f42897i = new Handler(handlerThread2.getLooper());
    }

    public static BDStatCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f42889a == null) {
                synchronized (BDStatCore.class) {
                    if (f42889a == null) {
                        f42889a = new BDStatCore();
                    }
                }
            }
            return f42889a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f42892d.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f42890b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LaunchInfo f42938a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42939b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42940c;

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
                this.f42940c = this;
                this.f42938a = launchInfo;
                this.f42939b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42940c.f42892d.autoTrackLaunchInfo(this.f42938a, this.f42939b);
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
        this.f42890b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42944a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42945b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42946c;

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
                this.f42946c = this;
                this.f42944a = context;
                this.f42945b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42946c.f42892d.autoTrackSessionEndTime(this.f42944a, this.f42945b);
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
        this.f42890b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42941a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42942b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42943c;

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
                this.f42943c = this;
                this.f42941a = context;
                this.f42942b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42943c.f42892d.autoTrackSessionStartTime(this.f42941a, this.f42942b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f42894f;
            if (runnable != null) {
                this.f42890b.removeCallbacks(runnable);
            }
            this.f42894f = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f42892d.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42950a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42951b;

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
                this.f42951b = this;
                this.f42950a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42951b.f42892d.doSendLogCheck(this.f42950a, System.currentTimeMillis());
                }
            }
        };
        this.f42894f = runnable;
        this.f42890b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42892d.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42892d.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f42892d.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f42891c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f42890b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f42898a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f42899b;

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
                    this.f42899b = this;
                    this.f42898a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f42899b.f42891c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.f42898a);
                    this.f42899b.f42891c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f42892d.isSessionStart()) {
            return;
        }
        init(context);
        this.f42890b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42931a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42932b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f42933c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f42934d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42935e;

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
                this.f42935e = this;
                this.f42931a = context;
                this.f42932b = r8;
                this.f42933c = str2;
                this.f42934d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.f42931a);
                    EventAnalysis eventAnalysis = this.f42935e.f42893e;
                    Context context2 = this.f42931a;
                    long j2 = this.f42932b;
                    eventAnalysis.onEvent(context2, j2, this.f42933c, this.f42934d, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(this.f42931a, true, false, this.f42932b, false);
                    if (this.f42932b - this.f42935e.f42895g <= 30000 || !bw.q(this.f42931a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.f42931a);
                    this.f42935e.f42895g = this.f42932b;
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
        this.f42890b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42900a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42901b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42902c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f42903d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42904e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42905f;

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
                this.f42905f = this;
                this.f42900a = str2;
                this.f42901b = context;
                this.f42902c = r9;
                this.f42903d = z;
                this.f42904e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42900a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f42905f.f42892d.onSessionStart(this.f42901b, this.f42902c, this.f42903d);
                    bc.c().a("Start event" + this.f42905f.a(this.f42904e, str3, 1, -1L, null, null));
                    this.f42905f.f42893e.onEventStart(this.f42901b, this.f42904e, str3, this.f42902c);
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
        this.f42890b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42952a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42953b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f42954c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f42955d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42956e;

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
                this.f42956e = this;
                this.f42952a = str;
                this.f42953b = context;
                this.f42954c = r9;
                this.f42955d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + this.f42952a);
                    this.f42956e.f42892d.onPageStart(this.f42953b, this.f42952a, this.f42954c, this.f42955d);
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
        this.f42890b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42971a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42972b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f42973c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42974d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42975e;

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
                this.f42975e = this;
                this.f42971a = r7;
                this.f42972b = z;
                this.f42973c = applicationContext;
                this.f42974d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f42971a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f42972b) {
                    bc c2 = bc.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f42975e.f42892d.onPageEndAct(this.f42973c, name, simpleName, charSequence, System.currentTimeMillis(), this.f42972b, this.f42974d);
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
        this.f42890b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42964a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42965b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f42966c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42967d;

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
                this.f42967d = this;
                this.f42964a = r7;
                this.f42965b = z;
                this.f42966c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f42964a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f42965b) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f42967d.f42892d.onPageStartAct(this.f42966c, name, currentTimeMillis, this.f42965b);
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
        this.f42890b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42914a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42915b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f42916c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42917d;

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
                this.f42917d = this;
                this.f42914a = context;
                this.f42915b = r8;
                this.f42916c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42917d.f42892d.onSessionStart(this.f42914a, this.f42915b, this.f42916c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f42892d.isSessionStart()) {
            return;
        }
        this.f42890b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42928a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f42929b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42930c;

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
                this.f42930c = this;
                this.f42928a = context;
                this.f42929b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.f42928a, this.f42929b);
                }
            }
        });
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f42892d.setSessionTimeOut(i2);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, str2, Integer.valueOf(i2), extraInfo, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || context == null) {
            return;
        }
        init(context);
        this.f42890b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42986a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42987b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42988c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f42989d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42990e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f42991f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f42992g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42993h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f42994i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42995j;

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
                this.f42995j = this;
                this.f42986a = str2;
                this.f42987b = context;
                this.f42988c = r10;
                this.f42989d = z;
                this.f42990e = str;
                this.f42991f = i2;
                this.f42992g = map;
                this.f42993h = extraInfo;
                this.f42994i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42986a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f42995j.f42892d.onSessionStart(this.f42987b, this.f42988c, this.f42989d);
                    bc.c().a("Put event" + this.f42995j.a(this.f42990e, str3, this.f42991f, 0L, this.f42992g, this.f42993h));
                    this.f42995j.f42893e.onEvent(this.f42987b, this.f42995j.f42892d.getSessionStartTime(), this.f42990e, str3, this.f42991f, this.f42988c, this.f42993h, this.f42992g, this.f42994i);
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
        this.f42890b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42918a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42919b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42920c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f42921d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42922e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f42923f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f42924g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42925h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f42926i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42927j;

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
                this.f42927j = this;
                this.f42918a = str2;
                this.f42919b = context;
                this.f42920c = r10;
                this.f42921d = z;
                this.f42922e = str;
                this.f42923f = j2;
                this.f42924g = map;
                this.f42925h = extraInfo;
                this.f42926i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42918a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f42927j.f42892d.onSessionStart(this.f42919b, this.f42920c, this.f42921d);
                    bc.c().a("Put event" + this.f42927j.a(this.f42922e, str3, 1, this.f42923f, this.f42924g, this.f42925h));
                    this.f42927j.f42893e.onEventDuration(this.f42919b, this.f42927j.f42892d.getSessionStartTime(), this.f42922e, str3, this.f42920c, this.f42923f, this.f42925h, this.f42924g, this.f42926i);
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
        this.f42890b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42906a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f42907b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f42908c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42909d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f42910e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f42911f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f42912g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42913h;

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
                this.f42913h = this;
                this.f42906a = str2;
                this.f42907b = str;
                this.f42908c = map;
                this.f42909d = extraInfo;
                this.f42910e = context;
                this.f42911f = r12;
                this.f42912g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42906a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f42913h.f42892d.getSessionStartTime();
                    bc.c().a("End event" + this.f42913h.a(this.f42907b, str3, 1, -1L, this.f42908c, this.f42909d));
                    this.f42913h.f42893e.onEventEnd(this.f42910e, sessionStartTime, this.f42907b, str3, this.f42911f, this.f42909d, this.f42908c, this.f42912g);
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
        this.f42890b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42957a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42958b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f42959c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f42960d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42961e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f42962f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42963g;

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
                this.f42963g = this;
                this.f42957a = str;
                this.f42958b = context;
                this.f42959c = r9;
                this.f42960d = r10;
                this.f42961e = extraInfo;
                this.f42962f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("End page view " + this.f42957a);
                    SessionAnalysis sessionAnalysis = this.f42963g.f42892d;
                    Context context2 = this.f42958b;
                    String str2 = this.f42957a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f42959c, this.f42960d, this.f42961e, this.f42962f);
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
        this.f42890b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42996a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42997b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42998c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f42999d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43000e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43001f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43002g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f43003h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43004i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43005j;

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
                this.f43005j = this;
                this.f42996a = str2;
                this.f42997b = context;
                this.f42998c = r10;
                this.f42999d = str;
                this.f43000e = i2;
                this.f43001f = str3;
                this.f43002g = str4;
                this.f43003h = i3;
                this.f43004i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.f42996a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.f43005j.f42892d.onSessionStart(this.f42997b, this.f42998c, false);
                    bc.c().a("Put event" + this.f43005j.a(this.f42999d, str5, this.f43000e, 0L, null, null));
                    this.f43005j.f42893e.onEvent(this.f42997b, this.f43005j.f42892d.getSessionStartTime(), this.f42999d, str5, this.f43000e, this.f42998c, this.f43001f, this.f43002g, this.f43003h, this.f43004i);
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
        this.f42890b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42976a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f42977b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f42978c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f42979d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42980e;

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
                this.f42980e = this;
                this.f42976a = r7;
                this.f42977b = fragment;
                this.f42978c = activity;
                this.f42979d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f42976a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f42977b.getClass().getName();
                String simpleName = this.f42977b.getClass().getSimpleName();
                CharSequence title = this.f42978c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f42980e.f42892d.onPageEndFrag(this.f42979d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f42890b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42947a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42948b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42949c;

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
                this.f42949c = this;
                this.f42947a = r7;
                this.f42948b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f42947a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f42949c.f42892d.onPageStartFrag(this.f42948b, name, currentTimeMillis);
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
        if (!(interceptable == null || interceptable.invokeL(65546, this, context) == null) || this.f42896h || context == null || (handler = this.f42897i) == null) {
            return;
        }
        handler.postDelayed(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42936a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42937b;

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
                this.f42937b = this;
                this.f42936a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (!t.b(this.f42936a)) {
                            t.a(2).a(this.f42936a);
                        }
                    } catch (Throwable unused) {
                    }
                    this.f42937b.f42896h = false;
                }
            }
        }, 5000L);
        this.f42896h = true;
    }

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f42890b.post(new Runnable(this, str2, context, j2, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43006a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43007b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43008c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43009d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43010e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f43011f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43012g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43013h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f43014i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ String f43015j;
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
                this.f43006a = str2;
                this.f43007b = context;
                this.f43008c = j2;
                this.f43009d = str;
                this.f43010e = i2;
                this.f43011f = map;
                this.f43012g = jSONArray;
                this.f43013h = jSONArray2;
                this.f43014i = str3;
                this.f43015j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.f43006a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f42892d.onSessionStart(this.f43007b, this.f43008c, false);
                    bc.c().a("Put event" + this.m.a(this.f43009d, str6, this.f43010e, 0L, this.f43011f, null));
                    this.m.f42893e.onEvent(this.f43007b, this.m.f42892d.getSessionStartTime(), this.f43009d, str6, this.f43010e, this.f43008c, this.f43012g, this.f43013h, this.f43014i, this.f43015j, this.k, this.f43011f, this.l);
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
        this.f42890b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42981a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f42982b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f42983c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f42984d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42985e;

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
                this.f42985e = this;
                this.f42981a = r7;
                this.f42982b = fragment;
                this.f42983c = activity;
                this.f42984d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f42981a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f42982b.getClass().getName();
                String simpleName = this.f42982b.getClass().getSimpleName();
                CharSequence title = this.f42983c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f42985e.f42892d.onPageEndFrag(this.f42984d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f42890b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42968a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42969b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42970c;

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
                this.f42970c = this;
                this.f42968a = r7;
                this.f42969b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f42968a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f42970c.f42892d.onPageStartFrag(this.f42969b, name, currentTimeMillis);
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
