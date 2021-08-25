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
    public static BDStatCore f42800a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f42801b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42802c;

    /* renamed from: d  reason: collision with root package name */
    public SessionAnalysis f42803d;

    /* renamed from: e  reason: collision with root package name */
    public EventAnalysis f42804e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f42805f;

    /* renamed from: g  reason: collision with root package name */
    public long f42806g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f42807h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f42808i;

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
        this.f42802c = false;
        this.f42806g = 0L;
        this.f42807h = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f42801b = new Handler(handlerThread.getLooper());
        this.f42803d = new SessionAnalysis();
        this.f42804e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f42808i = new Handler(handlerThread2.getLooper());
    }

    public static BDStatCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f42800a == null) {
                synchronized (BDStatCore.class) {
                    if (f42800a == null) {
                        f42800a = new BDStatCore();
                    }
                }
            }
            return f42800a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f42803d.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f42801b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LaunchInfo f42849a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42850b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42851c;

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
                this.f42851c = this;
                this.f42849a = launchInfo;
                this.f42850b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42851c.f42803d.autoTrackLaunchInfo(this.f42849a, this.f42850b);
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
        this.f42801b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42855a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42856b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42857c;

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
                this.f42857c = this;
                this.f42855a = context;
                this.f42856b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42857c.f42803d.autoTrackSessionEndTime(this.f42855a, this.f42856b);
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
        this.f42801b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42852a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42853b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42854c;

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
                this.f42854c = this;
                this.f42852a = context;
                this.f42853b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42854c.f42803d.autoTrackSessionStartTime(this.f42852a, this.f42853b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f42805f;
            if (runnable != null) {
                this.f42801b.removeCallbacks(runnable);
            }
            this.f42805f = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f42803d.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42861a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42862b;

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
                this.f42862b = this;
                this.f42861a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42862b.f42803d.doSendLogCheck(this.f42861a, System.currentTimeMillis());
                }
            }
        };
        this.f42805f = runnable;
        this.f42801b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42803d.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42803d.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f42803d.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f42802c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f42801b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f42809a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f42810b;

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
                    this.f42810b = this;
                    this.f42809a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f42810b.f42802c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.f42809a);
                    this.f42810b.f42802c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f42803d.isSessionStart()) {
            return;
        }
        init(context);
        this.f42801b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42842a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42843b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f42844c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f42845d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42846e;

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
                this.f42846e = this;
                this.f42842a = context;
                this.f42843b = r8;
                this.f42844c = str2;
                this.f42845d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.f42842a);
                    EventAnalysis eventAnalysis = this.f42846e.f42804e;
                    Context context2 = this.f42842a;
                    long j2 = this.f42843b;
                    eventAnalysis.onEvent(context2, j2, this.f42844c, this.f42845d, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(this.f42842a, true, false, this.f42843b, false);
                    if (this.f42843b - this.f42846e.f42806g <= 30000 || !bw.q(this.f42842a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.f42842a);
                    this.f42846e.f42806g = this.f42843b;
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
        this.f42801b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42811a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42812b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42813c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f42814d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42815e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42816f;

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
                this.f42816f = this;
                this.f42811a = str2;
                this.f42812b = context;
                this.f42813c = r9;
                this.f42814d = z;
                this.f42815e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42811a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f42816f.f42803d.onSessionStart(this.f42812b, this.f42813c, this.f42814d);
                    bc.c().a("Start event" + this.f42816f.a(this.f42815e, str3, 1, -1L, null, null));
                    this.f42816f.f42804e.onEventStart(this.f42812b, this.f42815e, str3, this.f42813c);
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
        this.f42801b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42863a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42864b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f42865c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f42866d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42867e;

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
                this.f42867e = this;
                this.f42863a = str;
                this.f42864b = context;
                this.f42865c = r9;
                this.f42866d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + this.f42863a);
                    this.f42867e.f42803d.onPageStart(this.f42864b, this.f42863a, this.f42865c, this.f42866d);
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
        this.f42801b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42882a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42883b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f42884c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42885d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42886e;

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
                this.f42886e = this;
                this.f42882a = r7;
                this.f42883b = z;
                this.f42884c = applicationContext;
                this.f42885d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f42882a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f42883b) {
                    bc c2 = bc.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f42886e.f42803d.onPageEndAct(this.f42884c, name, simpleName, charSequence, System.currentTimeMillis(), this.f42883b, this.f42885d);
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
        this.f42801b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42875a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f42876b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f42877c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42878d;

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
                this.f42878d = this;
                this.f42875a = r7;
                this.f42876b = z;
                this.f42877c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f42875a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f42876b) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f42878d.f42803d.onPageStartAct(this.f42877c, name, currentTimeMillis, this.f42876b);
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
        this.f42801b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42825a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f42826b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f42827c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42828d;

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
                this.f42828d = this;
                this.f42825a = context;
                this.f42826b = r8;
                this.f42827c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f42828d.f42803d.onSessionStart(this.f42825a, this.f42826b, this.f42827c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f42803d.isSessionStart()) {
            return;
        }
        this.f42801b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42839a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f42840b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42841c;

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
                this.f42841c = this;
                this.f42839a = context;
                this.f42840b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.f42839a, this.f42840b);
                }
            }
        });
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f42803d.setSessionTimeOut(i2);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, str2, Integer.valueOf(i2), extraInfo, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || context == null) {
            return;
        }
        init(context);
        this.f42801b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42897a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42898b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42899c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f42900d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42901e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f42902f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f42903g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42904h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f42905i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42906j;

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
                this.f42906j = this;
                this.f42897a = str2;
                this.f42898b = context;
                this.f42899c = r10;
                this.f42900d = z;
                this.f42901e = str;
                this.f42902f = i2;
                this.f42903g = map;
                this.f42904h = extraInfo;
                this.f42905i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42897a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f42906j.f42803d.onSessionStart(this.f42898b, this.f42899c, this.f42900d);
                    bc.c().a("Put event" + this.f42906j.a(this.f42901e, str3, this.f42902f, 0L, this.f42903g, this.f42904h));
                    this.f42906j.f42804e.onEvent(this.f42898b, this.f42906j.f42803d.getSessionStartTime(), this.f42901e, str3, this.f42902f, this.f42899c, this.f42904h, this.f42903g, this.f42905i);
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
        this.f42801b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42829a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42830b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42831c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f42832d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42833e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f42834f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f42835g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42836h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f42837i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42838j;

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
                this.f42838j = this;
                this.f42829a = str2;
                this.f42830b = context;
                this.f42831c = r10;
                this.f42832d = z;
                this.f42833e = str;
                this.f42834f = j2;
                this.f42835g = map;
                this.f42836h = extraInfo;
                this.f42837i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42829a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f42838j.f42803d.onSessionStart(this.f42830b, this.f42831c, this.f42832d);
                    bc.c().a("Put event" + this.f42838j.a(this.f42833e, str3, 1, this.f42834f, this.f42835g, this.f42836h));
                    this.f42838j.f42804e.onEventDuration(this.f42830b, this.f42838j.f42803d.getSessionStartTime(), this.f42833e, str3, this.f42831c, this.f42834f, this.f42836h, this.f42835g, this.f42837i);
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
        this.f42801b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42817a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f42818b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f42819c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42820d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f42821e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f42822f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f42823g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42824h;

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
                this.f42824h = this;
                this.f42817a = str2;
                this.f42818b = str;
                this.f42819c = map;
                this.f42820d = extraInfo;
                this.f42821e = context;
                this.f42822f = r12;
                this.f42823g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f42817a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f42824h.f42803d.getSessionStartTime();
                    bc.c().a("End event" + this.f42824h.a(this.f42818b, str3, 1, -1L, this.f42819c, this.f42820d));
                    this.f42824h.f42804e.onEventEnd(this.f42821e, sessionStartTime, this.f42818b, str3, this.f42822f, this.f42820d, this.f42819c, this.f42823g);
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
        this.f42801b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42868a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42869b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f42870c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f42871d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f42872e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f42873f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42874g;

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
                this.f42874g = this;
                this.f42868a = str;
                this.f42869b = context;
                this.f42870c = r9;
                this.f42871d = r10;
                this.f42872e = extraInfo;
                this.f42873f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("End page view " + this.f42868a);
                    SessionAnalysis sessionAnalysis = this.f42874g.f42803d;
                    Context context2 = this.f42869b;
                    String str2 = this.f42868a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f42870c, this.f42871d, this.f42872e, this.f42873f);
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
        this.f42801b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42907a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42908b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42909c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f42910d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f42911e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f42912f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f42913g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f42914h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f42915i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42916j;

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
                this.f42916j = this;
                this.f42907a = str2;
                this.f42908b = context;
                this.f42909c = r10;
                this.f42910d = str;
                this.f42911e = i2;
                this.f42912f = str3;
                this.f42913g = str4;
                this.f42914h = i3;
                this.f42915i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.f42907a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.f42916j.f42803d.onSessionStart(this.f42908b, this.f42909c, false);
                    bc.c().a("Put event" + this.f42916j.a(this.f42910d, str5, this.f42911e, 0L, null, null));
                    this.f42916j.f42804e.onEvent(this.f42908b, this.f42916j.f42803d.getSessionStartTime(), this.f42910d, str5, this.f42911e, this.f42909c, this.f42912f, this.f42913g, this.f42914h, this.f42915i);
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
        this.f42801b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42887a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f42888b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f42889c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f42890d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42891e;

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
                this.f42891e = this;
                this.f42887a = r7;
                this.f42888b = fragment;
                this.f42889c = activity;
                this.f42890d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f42887a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f42888b.getClass().getName();
                String simpleName = this.f42888b.getClass().getSimpleName();
                CharSequence title = this.f42889c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f42891e.f42803d.onPageEndFrag(this.f42890d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f42801b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42858a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42859b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42860c;

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
                this.f42860c = this;
                this.f42858a = r7;
                this.f42859b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f42858a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f42860c.f42803d.onPageStartFrag(this.f42859b, name, currentTimeMillis);
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
        if (!(interceptable == null || interceptable.invokeL(65546, this, context) == null) || this.f42807h || context == null || (handler = this.f42808i) == null) {
            return;
        }
        handler.postDelayed(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f42847a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42848b;

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
                this.f42848b = this;
                this.f42847a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (!t.b(this.f42847a)) {
                            t.a(2).a(this.f42847a);
                        }
                    } catch (Throwable unused) {
                    }
                    this.f42848b.f42807h = false;
                }
            }
        }, 5000L);
        this.f42807h = true;
    }

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f42801b.post(new Runnable(this, str2, context, j2, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42917a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42918b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f42919c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f42920d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f42921e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f42922f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f42923g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f42924h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f42925i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ String f42926j;
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
                this.f42917a = str2;
                this.f42918b = context;
                this.f42919c = j2;
                this.f42920d = str;
                this.f42921e = i2;
                this.f42922f = map;
                this.f42923g = jSONArray;
                this.f42924h = jSONArray2;
                this.f42925i = str3;
                this.f42926j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.f42917a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f42803d.onSessionStart(this.f42918b, this.f42919c, false);
                    bc.c().a("Put event" + this.m.a(this.f42920d, str6, this.f42921e, 0L, this.f42922f, null));
                    this.m.f42804e.onEvent(this.f42918b, this.m.f42803d.getSessionStartTime(), this.f42920d, str6, this.f42921e, this.f42919c, this.f42923g, this.f42924h, this.f42925i, this.f42926j, this.k, this.f42922f, this.l);
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
        this.f42801b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42892a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f42893b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f42894c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f42895d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42896e;

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
                this.f42896e = this;
                this.f42892a = r7;
                this.f42893b = fragment;
                this.f42894c = activity;
                this.f42895d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f42892a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f42893b.getClass().getName();
                String simpleName = this.f42893b.getClass().getSimpleName();
                CharSequence title = this.f42894c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f42896e.f42803d.onPageEndFrag(this.f42895d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f42801b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f42879a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f42880b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f42881c;

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
                this.f42881c = this;
                this.f42879a = r7;
                this.f42880b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f42879a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f42881c.f42803d.onPageStartFrag(this.f42880b, name, currentTimeMillis);
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
