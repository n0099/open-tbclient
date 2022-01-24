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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BDStatCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVOKE_ACT = 1;
    public static final int INVOKE_API = 0;
    public static final int INVOKE_CUSTOME = 3;
    public static final int INVOKE_FRAG = 2;
    public static BDStatCore a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f36200b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f36201c;

    /* renamed from: d  reason: collision with root package name */
    public SessionAnalysis f36202d;

    /* renamed from: e  reason: collision with root package name */
    public EventAnalysis f36203e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f36204f;

    /* renamed from: g  reason: collision with root package name */
    public long f36205g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f36206h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f36207i;

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
        this.f36201c = false;
        this.f36205g = 0L;
        this.f36206h = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f36200b = new Handler(handlerThread.getLooper());
        this.f36202d = new SessionAnalysis();
        this.f36203e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f36207i = new Handler(handlerThread2.getLooper());
    }

    public static BDStatCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (a == null) {
                synchronized (BDStatCore.class) {
                    if (a == null) {
                        a = new BDStatCore();
                    }
                }
            }
            return a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f36202d.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f36200b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LaunchInfo a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f36240b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36241c;

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
                this.f36241c = this;
                this.a = launchInfo;
                this.f36240b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36241c.f36202d.autoTrackLaunchInfo(this.a, this.f36240b);
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
        this.f36200b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f36244b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36245c;

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
                this.f36245c = this;
                this.a = context;
                this.f36244b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36245c.f36202d.autoTrackSessionEndTime(this.a, this.f36244b);
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
        this.f36200b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f36242b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36243c;

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
                this.f36243c = this;
                this.a = context;
                this.f36242b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36243c.f36202d.autoTrackSessionStartTime(this.a, this.f36242b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f36204f;
            if (runnable != null) {
                this.f36200b.removeCallbacks(runnable);
            }
            this.f36204f = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f36202d.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36248b;

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
                this.f36248b = this;
                this.a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36248b.f36202d.doSendLogCheck(this.a, System.currentTimeMillis());
                }
            }
        };
        this.f36204f = runnable;
        this.f36200b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36202d.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36202d.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36202d.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f36201c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f36200b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f36208b;

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
                    this.f36208b = this;
                    this.a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f36208b.f36201c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.a);
                    this.f36208b.f36201c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f36202d.isSessionStart()) {
            return;
        }
        init(context);
        this.f36200b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f36235b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f36236c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f36237d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36238e;

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
                this.f36238e = this;
                this.a = context;
                this.f36235b = r8;
                this.f36236c = str2;
                this.f36237d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.a);
                    EventAnalysis eventAnalysis = this.f36238e.f36203e;
                    Context context2 = this.a;
                    long j2 = this.f36235b;
                    eventAnalysis.onEvent(context2, j2, this.f36236c, this.f36237d, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(this.a, true, false, this.f36235b, false);
                    if (this.f36235b - this.f36238e.f36205g <= 30000 || !bw.q(this.a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.a);
                    this.f36238e.f36205g = this.f36235b;
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
        this.f36200b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36209b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36210c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f36211d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f36212e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36213f;

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
                this.f36213f = this;
                this.a = str2;
                this.f36209b = context;
                this.f36210c = r9;
                this.f36211d = z;
                this.f36212e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f36213f.f36202d.onSessionStart(this.f36209b, this.f36210c, this.f36211d);
                    bc.c().a("Start event" + this.f36213f.a(this.f36212e, str3, 1, -1L, null, null));
                    this.f36213f.f36203e.onEventStart(this.f36209b, this.f36212e, str3, this.f36210c);
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
        this.f36200b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36249b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f36250c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f36251d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36252e;

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
                this.f36252e = this;
                this.a = str;
                this.f36249b = context;
                this.f36250c = r9;
                this.f36251d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + this.a);
                    this.f36252e.f36202d.onPageStart(this.f36249b, this.a, this.f36250c, this.f36251d);
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
        this.f36200b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f36264b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f36265c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36266d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36267e;

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
                this.f36267e = this;
                this.a = r7;
                this.f36264b = z;
                this.f36265c = applicationContext;
                this.f36266d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f36264b) {
                    bc c2 = bc.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f36267e.f36202d.onPageEndAct(this.f36265c, name, simpleName, charSequence, System.currentTimeMillis(), this.f36264b, this.f36266d);
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
        this.f36200b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f36259b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f36260c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36261d;

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
                this.f36261d = this;
                this.a = r7;
                this.f36259b = z;
                this.f36260c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f36259b) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f36261d.f36202d.onPageStartAct(this.f36260c, name, currentTimeMillis, this.f36259b);
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
        this.f36200b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f36221b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f36222c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36223d;

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
                this.f36223d = this;
                this.a = context;
                this.f36221b = r8;
                this.f36222c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36223d.f36202d.onSessionStart(this.a, this.f36221b, this.f36222c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f36202d.isSessionStart()) {
            return;
        }
        this.f36200b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f36233b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36234c;

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
                this.f36234c = this;
                this.a = context;
                this.f36233b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.a, this.f36233b);
                }
            }
        });
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f36202d.setSessionTimeOut(i2);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, str2, Integer.valueOf(i2), extraInfo, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || context == null) {
            return;
        }
        init(context);
        this.f36200b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36276b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36277c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f36278d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f36279e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f36280f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f36281g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36282h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f36283i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36284j;

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
                this.f36284j = this;
                this.a = str2;
                this.f36276b = context;
                this.f36277c = r10;
                this.f36278d = z;
                this.f36279e = str;
                this.f36280f = i2;
                this.f36281g = map;
                this.f36282h = extraInfo;
                this.f36283i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f36284j.f36202d.onSessionStart(this.f36276b, this.f36277c, this.f36278d);
                    bc.c().a("Put event" + this.f36284j.a(this.f36279e, str3, this.f36280f, 0L, this.f36281g, this.f36282h));
                    this.f36284j.f36203e.onEvent(this.f36276b, this.f36284j.f36202d.getSessionStartTime(), this.f36279e, str3, this.f36280f, this.f36277c, this.f36282h, this.f36281g, this.f36283i);
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
        this.f36200b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36224b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36225c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f36226d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f36227e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f36228f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f36229g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36230h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f36231i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36232j;

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
                this.f36232j = this;
                this.a = str2;
                this.f36224b = context;
                this.f36225c = r10;
                this.f36226d = z;
                this.f36227e = str;
                this.f36228f = j2;
                this.f36229g = map;
                this.f36230h = extraInfo;
                this.f36231i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f36232j.f36202d.onSessionStart(this.f36224b, this.f36225c, this.f36226d);
                    bc.c().a("Put event" + this.f36232j.a(this.f36227e, str3, 1, this.f36228f, this.f36229g, this.f36230h));
                    this.f36232j.f36203e.onEventDuration(this.f36224b, this.f36232j.f36202d.getSessionStartTime(), this.f36227e, str3, this.f36225c, this.f36228f, this.f36230h, this.f36229g, this.f36231i);
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
        this.f36200b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f36214b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f36215c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36216d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f36217e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f36218f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f36219g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36220h;

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
                this.f36220h = this;
                this.a = str2;
                this.f36214b = str;
                this.f36215c = map;
                this.f36216d = extraInfo;
                this.f36217e = context;
                this.f36218f = r12;
                this.f36219g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f36220h.f36202d.getSessionStartTime();
                    bc.c().a("End event" + this.f36220h.a(this.f36214b, str3, 1, -1L, this.f36215c, this.f36216d));
                    this.f36220h.f36203e.onEventEnd(this.f36217e, sessionStartTime, this.f36214b, str3, this.f36218f, this.f36216d, this.f36215c, this.f36219g);
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
        this.f36200b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36253b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f36254c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f36255d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36256e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f36257f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36258g;

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
                this.f36258g = this;
                this.a = str;
                this.f36253b = context;
                this.f36254c = r9;
                this.f36255d = r10;
                this.f36256e = extraInfo;
                this.f36257f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("End page view " + this.a);
                    SessionAnalysis sessionAnalysis = this.f36258g.f36202d;
                    Context context2 = this.f36253b;
                    String str2 = this.a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f36254c, this.f36255d, this.f36256e, this.f36257f);
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
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
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
        this.f36200b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36285b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36286c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f36287d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f36288e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f36289f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f36290g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f36291h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f36292i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36293j;

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
                this.f36293j = this;
                this.a = str2;
                this.f36285b = context;
                this.f36286c = r10;
                this.f36287d = str;
                this.f36288e = i2;
                this.f36289f = str3;
                this.f36290g = str4;
                this.f36291h = i3;
                this.f36292i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.f36293j.f36202d.onSessionStart(this.f36285b, this.f36286c, false);
                    bc.c().a("Put event" + this.f36293j.a(this.f36287d, str5, this.f36288e, 0L, null, null));
                    this.f36293j.f36203e.onEvent(this.f36285b, this.f36293j.f36202d.getSessionStartTime(), this.f36287d, str5, this.f36288e, this.f36286c, this.f36289f, this.f36290g, this.f36291h, this.f36292i);
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
        this.f36200b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f36268b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f36269c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f36270d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36271e;

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
                this.f36271e = this;
                this.a = r7;
                this.f36268b = fragment;
                this.f36269c = activity;
                this.f36270d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f36268b.getClass().getName();
                String simpleName = this.f36268b.getClass().getSimpleName();
                CharSequence title = this.f36269c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f36271e.f36202d.onPageEndFrag(this.f36270d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f36200b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36246b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36247c;

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
                this.f36247c = this;
                this.a = r7;
                this.f36246b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f36247c.f36202d.onPageStartFrag(this.f36246b, name, currentTimeMillis);
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
        if (!(interceptable == null || interceptable.invokeL(65546, this, context) == null) || this.f36206h || context == null || (handler = this.f36207i) == null) {
            return;
        }
        handler.postDelayed(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36239b;

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
                this.f36239b = this;
                this.a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (!t.b(this.a)) {
                            t.a(2).a(this.a);
                        }
                    } catch (Throwable unused) {
                    }
                    this.f36239b.f36206h = false;
                }
            }
        }, 5000L);
        this.f36206h = true;
    }

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f36200b.post(new Runnable(this, str2, context, j2, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36294b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36295c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f36296d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f36297e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f36298f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f36299g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f36300h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f36301i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ String f36302j;
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
                this.a = str2;
                this.f36294b = context;
                this.f36295c = j2;
                this.f36296d = str;
                this.f36297e = i2;
                this.f36298f = map;
                this.f36299g = jSONArray;
                this.f36300h = jSONArray2;
                this.f36301i = str3;
                this.f36302j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f36202d.onSessionStart(this.f36294b, this.f36295c, false);
                    bc.c().a("Put event" + this.m.a(this.f36296d, str6, this.f36297e, 0L, this.f36298f, null));
                    this.m.f36203e.onEvent(this.f36294b, this.m.f36202d.getSessionStartTime(), this.f36296d, str6, this.f36297e, this.f36295c, this.f36299g, this.f36300h, this.f36301i, this.f36302j, this.k, this.f36298f, this.l);
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
        this.f36200b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f36272b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f36273c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f36274d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36275e;

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
                this.f36275e = this;
                this.a = r7;
                this.f36272b = fragment;
                this.f36273c = activity;
                this.f36274d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f36272b.getClass().getName();
                String simpleName = this.f36272b.getClass().getSimpleName();
                CharSequence title = this.f36273c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f36275e.f36202d.onPageEndFrag(this.f36274d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f36200b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36262b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36263c;

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
                this.f36263c = this;
                this.a = r7;
                this.f36262b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f36263c.f36202d.onPageStartFrag(this.f36262b, name, currentTimeMillis);
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
