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
/* loaded from: classes7.dex */
public class BDStatCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVOKE_ACT = 1;
    public static final int INVOKE_API = 0;
    public static final int INVOKE_CUSTOME = 3;
    public static final int INVOKE_FRAG = 2;

    /* renamed from: a  reason: collision with root package name */
    public static BDStatCore f40697a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f40698b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f40699c;

    /* renamed from: d  reason: collision with root package name */
    public SessionAnalysis f40700d;

    /* renamed from: e  reason: collision with root package name */
    public EventAnalysis f40701e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f40702f;

    /* renamed from: g  reason: collision with root package name */
    public long f40703g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f40704h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f40705i;

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
        this.f40699c = false;
        this.f40703g = 0L;
        this.f40704h = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f40698b = new Handler(handlerThread.getLooper());
        this.f40700d = new SessionAnalysis();
        this.f40701e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f40705i = new Handler(handlerThread2.getLooper());
    }

    public static BDStatCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f40697a == null) {
                synchronized (BDStatCore.class) {
                    if (f40697a == null) {
                        f40697a = new BDStatCore();
                    }
                }
            }
            return f40697a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f40700d.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f40698b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LaunchInfo f40745a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f40746b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40747c;

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
                this.f40747c = this;
                this.f40745a = launchInfo;
                this.f40746b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f40747c.f40700d.autoTrackLaunchInfo(this.f40745a, this.f40746b);
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
        this.f40698b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f40751a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f40752b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40753c;

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
                this.f40753c = this;
                this.f40751a = context;
                this.f40752b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f40753c.f40700d.autoTrackSessionEndTime(this.f40751a, this.f40752b);
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
        this.f40698b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f40748a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f40749b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40750c;

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
                this.f40750c = this;
                this.f40748a = context;
                this.f40749b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f40750c.f40700d.autoTrackSessionStartTime(this.f40748a, this.f40749b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f40702f;
            if (runnable != null) {
                this.f40698b.removeCallbacks(runnable);
            }
            this.f40702f = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f40700d.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f40757a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40758b;

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
                this.f40758b = this;
                this.f40757a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f40758b.f40700d.doSendLogCheck(this.f40757a, System.currentTimeMillis());
                }
            }
        };
        this.f40702f = runnable;
        this.f40698b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40700d.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40700d.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f40700d.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f40699c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f40698b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f40706a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f40707b;

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
                    this.f40707b = this;
                    this.f40706a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f40707b.f40699c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.f40706a);
                    this.f40707b.f40699c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f40700d.isSessionStart()) {
            return;
        }
        init(context);
        this.f40698b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f40738a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f40739b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f40740c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f40741d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40742e;

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
                this.f40742e = this;
                this.f40738a = context;
                this.f40739b = r8;
                this.f40740c = str2;
                this.f40741d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.f40738a);
                    EventAnalysis eventAnalysis = this.f40742e.f40701e;
                    Context context2 = this.f40738a;
                    long j = this.f40739b;
                    eventAnalysis.onEvent(context2, j, this.f40740c, this.f40741d, 1, j, null, null, false);
                    DataCore.instance().saveLogData(this.f40738a, true, false, this.f40739b, false);
                    if (this.f40739b - this.f40742e.f40703g <= 30000 || !bw.q(this.f40738a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.f40738a);
                    this.f40742e.f40703g = this.f40739b;
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
        this.f40698b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f40708a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40709b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f40710c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f40711d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f40712e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40713f;

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
                this.f40713f = this;
                this.f40708a = str2;
                this.f40709b = context;
                this.f40710c = r9;
                this.f40711d = z;
                this.f40712e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f40708a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f40713f.f40700d.onSessionStart(this.f40709b, this.f40710c, this.f40711d);
                    bc.c().a("Start event" + this.f40713f.a(this.f40712e, str3, 1, -1L, null, null));
                    this.f40713f.f40701e.onEventStart(this.f40709b, this.f40712e, str3, this.f40710c);
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
        this.f40698b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f40759a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40760b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f40761c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f40762d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40763e;

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
                this.f40763e = this;
                this.f40759a = str;
                this.f40760b = context;
                this.f40761c = r9;
                this.f40762d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + this.f40759a);
                    this.f40763e.f40700d.onPageStart(this.f40760b, this.f40759a, this.f40761c, this.f40762d);
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
        this.f40698b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f40778a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f40779b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f40780c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f40781d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40782e;

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
                this.f40782e = this;
                this.f40778a = r7;
                this.f40779b = z;
                this.f40780c = applicationContext;
                this.f40781d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f40778a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f40779b) {
                    bc c2 = bc.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f40782e.f40700d.onPageEndAct(this.f40780c, name, simpleName, charSequence, System.currentTimeMillis(), this.f40779b, this.f40781d);
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
        this.f40698b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f40771a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f40772b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f40773c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40774d;

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
                this.f40774d = this;
                this.f40771a = r7;
                this.f40772b = z;
                this.f40773c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f40771a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f40772b) {
                    bc c2 = bc.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f40774d.f40700d.onPageStartAct(this.f40773c, name, currentTimeMillis, this.f40772b);
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
        this.f40698b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f40722a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f40723b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f40724c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40725d;

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
                this.f40725d = this;
                this.f40722a = context;
                this.f40723b = r8;
                this.f40724c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f40725d.f40700d.onSessionStart(this.f40722a, this.f40723b, this.f40724c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f40700d.isSessionStart()) {
            return;
        }
        this.f40698b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f40735a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f40736b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40737c;

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
                this.f40737c = this;
                this.f40735a = context;
                this.f40736b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.f40735a, this.f40736b);
                }
            }
        });
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f40700d.setSessionTimeOut(i2);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, str2, Integer.valueOf(i2), extraInfo, map, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || context == null) {
            return;
        }
        init(context);
        this.f40698b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f40793a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40794b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f40795c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f40796d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f40797e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f40798f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f40799g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f40800h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f40801i;
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
                this.f40793a = str2;
                this.f40794b = context;
                this.f40795c = r10;
                this.f40796d = z;
                this.f40797e = str;
                this.f40798f = i2;
                this.f40799g = map;
                this.f40800h = extraInfo;
                this.f40801i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f40793a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.j.f40700d.onSessionStart(this.f40794b, this.f40795c, this.f40796d);
                    bc.c().a("Put event" + this.j.a(this.f40797e, str3, this.f40798f, 0L, this.f40799g, this.f40800h));
                    this.j.f40701e.onEvent(this.f40794b, this.j.f40700d.getSessionStartTime(), this.f40797e, str3, this.f40798f, this.f40795c, this.f40800h, this.f40799g, this.f40801i);
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
        this.f40698b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j, map, extraInfo, z2) { // from class: com.baidu.mobstat.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f40726a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40727b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f40728c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f40729d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f40730e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f40731f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f40732g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f40733h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f40734i;
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
                this.f40726a = str2;
                this.f40727b = context;
                this.f40728c = r10;
                this.f40729d = z;
                this.f40730e = str;
                this.f40731f = j;
                this.f40732g = map;
                this.f40733h = extraInfo;
                this.f40734i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f40726a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.j.f40700d.onSessionStart(this.f40727b, this.f40728c, this.f40729d);
                    bc.c().a("Put event" + this.j.a(this.f40730e, str3, 1, this.f40731f, this.f40732g, this.f40733h));
                    this.j.f40701e.onEventDuration(this.f40727b, this.j.f40700d.getSessionStartTime(), this.f40730e, str3, this.f40728c, this.f40731f, this.f40733h, this.f40732g, this.f40734i);
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
        this.f40698b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f40714a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f40715b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f40716c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f40717d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f40718e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f40719f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f40720g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40721h;

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
                this.f40721h = this;
                this.f40714a = str2;
                this.f40715b = str;
                this.f40716c = map;
                this.f40717d = extraInfo;
                this.f40718e = context;
                this.f40719f = r12;
                this.f40720g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f40714a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f40721h.f40700d.getSessionStartTime();
                    bc.c().a("End event" + this.f40721h.a(this.f40715b, str3, 1, -1L, this.f40716c, this.f40717d));
                    this.f40721h.f40701e.onEventEnd(this.f40718e, sessionStartTime, this.f40715b, str3, this.f40719f, this.f40717d, this.f40716c, this.f40720g);
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
        this.f40698b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f40764a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40765b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f40766c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f40767d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f40768e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f40769f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40770g;

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
                this.f40770g = this;
                this.f40764a = str;
                this.f40765b = context;
                this.f40766c = r9;
                this.f40767d = r10;
                this.f40768e = extraInfo;
                this.f40769f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    bc c2 = bc.c();
                    c2.a("End page view " + this.f40764a);
                    SessionAnalysis sessionAnalysis = this.f40770g.f40700d;
                    Context context2 = this.f40765b;
                    String str2 = this.f40764a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f40766c, this.f40767d, this.f40768e, this.f40769f);
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
        this.f40698b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f40802a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40803b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f40804c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f40805d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f40806e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f40807f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f40808g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f40809h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f40810i;
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
                this.f40802a = str2;
                this.f40803b = context;
                this.f40804c = r10;
                this.f40805d = str;
                this.f40806e = i2;
                this.f40807f = str3;
                this.f40808g = str4;
                this.f40809h = i3;
                this.f40810i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.f40802a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.j.f40700d.onSessionStart(this.f40803b, this.f40804c, false);
                    bc.c().a("Put event" + this.j.a(this.f40805d, str5, this.f40806e, 0L, null, null));
                    this.j.f40701e.onEvent(this.f40803b, this.j.f40700d.getSessionStartTime(), this.f40805d, str5, this.f40806e, this.f40804c, this.f40807f, this.f40808g, this.f40809h, this.f40810i);
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
        this.f40698b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f40783a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f40784b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f40785c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f40786d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40787e;

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
                this.f40787e = this;
                this.f40783a = r7;
                this.f40784b = fragment;
                this.f40785c = activity;
                this.f40786d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f40783a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f40784b.getClass().getName();
                String simpleName = this.f40784b.getClass().getSimpleName();
                CharSequence title = this.f40785c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f40787e.f40700d.onPageEndFrag(this.f40786d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f40698b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f40754a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40755b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40756c;

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
                this.f40756c = this;
                this.f40754a = r7;
                this.f40755b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f40754a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f40756c.f40700d.onPageStartFrag(this.f40755b, name, currentTimeMillis);
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

    public void onEvent(Context context, String str, String str2, int i2, long j, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j), jSONArray, jSONArray2, str3, str4, str5, map}) == null) {
            onEvent(context, str, str2, i2, j, jSONArray, jSONArray2, str3, str4, str5, map, false);
        }
    }

    private void b(Context context) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, context) == null) || this.f40704h || context == null || (handler = this.f40705i) == null) {
            return;
        }
        handler.postDelayed(new Runnable(this, context) { // from class: com.baidu.mobstat.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f40743a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40744b;

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
                this.f40744b = this;
                this.f40743a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (!t.b(this.f40743a)) {
                            t.a(2).a(this.f40743a);
                        }
                    } catch (Throwable unused) {
                    }
                    this.f40744b.f40704h = false;
                }
            }
        }, 5000L);
        this.f40704h = true;
    }

    public void onEvent(Context context, String str, String str2, int i2, long j, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j), jSONArray, jSONArray2, str3, str4, str5, map, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        init(context);
        b(context);
        this.f40698b.post(new Runnable(this, str2, context, j, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f40811a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40812b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f40813c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f40814d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f40815e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f40816f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f40817g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f40818h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f40819i;
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
                this.f40811a = str2;
                this.f40812b = context;
                this.f40813c = j;
                this.f40814d = str;
                this.f40815e = i2;
                this.f40816f = map;
                this.f40817g = jSONArray;
                this.f40818h = jSONArray2;
                this.f40819i = str3;
                this.j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.f40811a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f40700d.onSessionStart(this.f40812b, this.f40813c, false);
                    bc.c().a("Put event" + this.m.a(this.f40814d, str6, this.f40815e, 0L, this.f40816f, null));
                    this.m.f40701e.onEvent(this.f40812b, this.m.f40700d.getSessionStartTime(), this.f40814d, str6, this.f40815e, this.f40813c, this.f40817g, this.f40818h, this.f40819i, this.j, this.k, this.f40816f, this.l);
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
        this.f40698b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f40788a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f40789b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f40790c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f40791d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40792e;

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
                this.f40792e = this;
                this.f40788a = r7;
                this.f40789b = fragment;
                this.f40790c = activity;
                this.f40791d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f40788a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f40789b.getClass().getName();
                String simpleName = this.f40789b.getClass().getSimpleName();
                CharSequence title = this.f40790c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                bc c2 = bc.c();
                c2.a("End page view " + simpleName);
                this.f40792e.f40700d.onPageEndFrag(this.f40791d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f40698b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f40775a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f40776b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f40777c;

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
                this.f40777c = this;
                this.f40775a = r7;
                this.f40776b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f40775a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                bc c2 = bc.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f40777c.f40700d.onPageStartFrag(this.f40776b, name, currentTimeMillis);
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
