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
    public Handler f36666b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f36667c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36668d;

    /* renamed from: e  reason: collision with root package name */
    public SessionAnalysis f36669e;

    /* renamed from: f  reason: collision with root package name */
    public EventAnalysis f36670f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f36671g;

    /* renamed from: h  reason: collision with root package name */
    public long f36672h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f36673i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f36674j;

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
        this.f36667c = false;
        this.f36668d = false;
        this.f36672h = 0L;
        this.f36673i = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f36666b = new Handler(handlerThread.getLooper());
        this.f36669e = new SessionAnalysis();
        this.f36670f = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f36674j = new Handler(handlerThread2.getLooper());
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
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
            this.f36669e.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f36666b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LaunchInfo a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f36706b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36707c;

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
                this.f36707c = this;
                this.a = launchInfo;
                this.f36706b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36707c.f36669e.autoTrackLaunchInfo(this.a, this.f36706b);
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
        this.f36666b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f36710b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36711c;

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
                this.f36711c = this;
                this.a = context;
                this.f36710b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36711c.f36669e.autoTrackSessionEndTime(this.a, this.f36710b);
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
        this.f36666b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f36708b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36709c;

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
                this.f36709c = this;
                this.a = context;
                this.f36708b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36709c.f36669e.autoTrackSessionStartTime(this.a, this.f36708b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f36671g;
            if (runnable != null) {
                this.f36666b.removeCallbacks(runnable);
            }
            this.f36671g = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f36669e.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36712b;

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
                this.f36712b = this;
                this.a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36712b.f36669e.doSendLogCheck(this.a, System.currentTimeMillis());
                }
            }
        };
        this.f36671g = runnable;
        this.f36666b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36669e.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36669e.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36669e.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f36667c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f36666b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f36675b;

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
                    this.f36675b = this;
                    this.a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f36675b.f36667c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.a);
                    this.f36675b.f36667c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f36669e.isSessionStart()) {
            return;
        }
        init(context);
        this.f36666b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f36702b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f36703c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f36704d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36705e;

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
                this.f36705e = this;
                this.a = context;
                this.f36702b = r8;
                this.f36703c = str2;
                this.f36704d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.a);
                    EventAnalysis eventAnalysis = this.f36705e.f36670f;
                    Context context2 = this.a;
                    long j2 = this.f36702b;
                    eventAnalysis.onEvent(context2, j2, this.f36703c, this.f36704d, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(this.a, true, false, this.f36702b, false);
                    if (this.f36702b - this.f36705e.f36672h <= 30000 || !w.h(this.a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.a);
                    this.f36705e.f36672h = this.f36702b;
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
        this.f36666b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36676b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36677c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f36678d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f36679e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36680f;

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
                this.f36680f = this;
                this.a = str2;
                this.f36676b = context;
                this.f36677c = r9;
                this.f36678d = z;
                this.f36679e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f36680f.f36669e.onSessionStart(this.f36676b, this.f36677c, this.f36678d);
                    h.c().a("Start event" + this.f36680f.a(this.f36679e, str3, 1, -1L, null, null));
                    this.f36680f.f36670f.onEventStart(this.f36676b, this.f36679e, str3, this.f36677c);
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
        this.f36666b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36715b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f36716c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f36717d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36718e;

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
                this.f36718e = this;
                this.a = str;
                this.f36715b = context;
                this.f36716c = r9;
                this.f36717d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("Start page view " + this.a);
                    this.f36718e.f36669e.onPageStart(this.f36715b, this.a, this.f36716c, this.f36717d);
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
        this.f36666b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f36730b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f36731c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36732d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36733e;

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
                this.f36733e = this;
                this.a = r7;
                this.f36730b = z;
                this.f36731c = applicationContext;
                this.f36732d = extraInfo;
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
                if (!this.f36730b) {
                    h c2 = h.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f36733e.f36669e.onPageEndAct(this.f36731c, name, simpleName, charSequence, System.currentTimeMillis(), this.f36730b, this.f36732d);
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
        this.f36666b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f36725b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f36726c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36727d;

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
                this.f36727d = this;
                this.a = r7;
                this.f36725b = z;
                this.f36726c = applicationContext;
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
                if (!this.f36725b) {
                    h c2 = h.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f36727d.f36669e.onPageStartAct(this.f36726c, name, currentTimeMillis, this.f36725b);
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
        this.f36666b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f36688b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f36689c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36690d;

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
                this.f36690d = this;
                this.a = context;
                this.f36688b = r8;
                this.f36689c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36690d.f36669e.onSessionStart(this.a, this.f36688b, this.f36689c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f36669e.isSessionStart()) {
            return;
        }
        this.f36666b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f36700b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36701c;

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
                this.f36701c = this;
                this.a = context;
                this.f36700b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.a, this.f36700b);
                }
            }
        });
    }

    public void setAuthorizedState(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048607, this, context, z) == null) || context == null) {
            return;
        }
        this.f36668d = z;
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
        this.f36669e.setAutoSend(z);
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f36669e.setSessionTimeOut(i2);
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
        this.f36666b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36742b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36743c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f36744d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f36745e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f36746f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f36747g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36748h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f36749i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36750j;

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
                this.f36750j = this;
                this.a = str2;
                this.f36742b = context;
                this.f36743c = r10;
                this.f36744d = z;
                this.f36745e = str;
                this.f36746f = i2;
                this.f36747g = map;
                this.f36748h = extraInfo;
                this.f36749i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f36750j.f36669e.onSessionStart(this.f36742b, this.f36743c, this.f36744d);
                    h.c().a("Put event" + this.f36750j.a(this.f36745e, str3, this.f36746f, 0L, this.f36747g, this.f36748h));
                    this.f36750j.f36670f.onEvent(this.f36742b, this.f36750j.f36669e.getSessionStartTime(), this.f36745e, str3, this.f36746f, this.f36743c, this.f36748h, this.f36747g, this.f36749i);
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
        this.f36666b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36691b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36692c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f36693d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f36694e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f36695f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f36696g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36697h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f36698i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36699j;

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
                this.f36699j = this;
                this.a = str2;
                this.f36691b = context;
                this.f36692c = r10;
                this.f36693d = z;
                this.f36694e = str;
                this.f36695f = j2;
                this.f36696g = map;
                this.f36697h = extraInfo;
                this.f36698i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f36699j.f36669e.onSessionStart(this.f36691b, this.f36692c, this.f36693d);
                    h.c().a("Put event" + this.f36699j.a(this.f36694e, str3, 1, this.f36695f, this.f36696g, this.f36697h));
                    this.f36699j.f36670f.onEventDuration(this.f36691b, this.f36699j.f36669e.getSessionStartTime(), this.f36694e, str3, this.f36692c, this.f36695f, this.f36697h, this.f36696g, this.f36698i);
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
        this.f36666b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f36681b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f36682c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36683d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f36684e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f36685f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f36686g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36687h;

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
                this.f36687h = this;
                this.a = str2;
                this.f36681b = str;
                this.f36682c = map;
                this.f36683d = extraInfo;
                this.f36684e = context;
                this.f36685f = r12;
                this.f36686g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f36687h.f36669e.getSessionStartTime();
                    h.c().a("End event" + this.f36687h.a(this.f36681b, str3, 1, -1L, this.f36682c, this.f36683d));
                    this.f36687h.f36670f.onEventEnd(this.f36684e, sessionStartTime, this.f36681b, str3, this.f36685f, this.f36683d, this.f36682c, this.f36686g);
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
        this.f36666b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36719b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f36720c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f36721d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f36722e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f36723f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36724g;

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
                this.f36724g = this;
                this.a = str;
                this.f36719b = context;
                this.f36720c = r9;
                this.f36721d = r10;
                this.f36722e = extraInfo;
                this.f36723f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("End page view " + this.a);
                    SessionAnalysis sessionAnalysis = this.f36724g.f36669e;
                    Context context2 = this.f36719b;
                    String str2 = this.a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f36720c, this.f36721d, this.f36722e, this.f36723f);
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
        this.f36666b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36751b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36752c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f36753d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f36754e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f36755f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f36756g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f36757h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f36758i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36759j;

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
                this.f36759j = this;
                this.a = str2;
                this.f36751b = context;
                this.f36752c = r10;
                this.f36753d = str;
                this.f36754e = i2;
                this.f36755f = str3;
                this.f36756g = str4;
                this.f36757h = i3;
                this.f36758i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.f36759j.f36669e.onSessionStart(this.f36751b, this.f36752c, false);
                    h.c().a("Put event" + this.f36759j.a(this.f36753d, str5, this.f36754e, 0L, null, null));
                    this.f36759j.f36670f.onEvent(this.f36751b, this.f36759j.f36669e.getSessionStartTime(), this.f36753d, str5, this.f36754e, this.f36752c, this.f36755f, this.f36756g, this.f36757h, this.f36758i);
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
        this.f36666b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f36734b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f36735c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f36736d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36737e;

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
                this.f36737e = this;
                this.a = r7;
                this.f36734b = fragment;
                this.f36735c = activity;
                this.f36736d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f36734b.getClass().getName();
                String simpleName = this.f36734b.getClass().getSimpleName();
                CharSequence title = this.f36735c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f36737e.f36669e.onPageEndFrag(this.f36736d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f36666b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36713b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36714c;

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
                this.f36714c = this;
                this.a = r7;
                this.f36713b = applicationContext;
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
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f36714c.f36669e.onPageStartFrag(this.f36713b, name, currentTimeMillis);
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
        this.f36666b.post(new Runnable(this, str2, context, j2, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36760b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f36761c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f36762d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f36763e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f36764f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f36765g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f36766h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f36767i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ String f36768j;
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
                this.f36760b = context;
                this.f36761c = j2;
                this.f36762d = str;
                this.f36763e = i2;
                this.f36764f = map;
                this.f36765g = jSONArray;
                this.f36766h = jSONArray2;
                this.f36767i = str3;
                this.f36768j = str4;
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
                    this.m.f36669e.onSessionStart(this.f36760b, this.f36761c, false);
                    h.c().a("Put event" + this.m.a(this.f36762d, str6, this.f36763e, 0L, this.f36764f, null));
                    this.m.f36670f.onEvent(this.f36760b, this.m.f36669e.getSessionStartTime(), this.f36762d, str6, this.f36763e, this.f36761c, this.f36765g, this.f36766h, this.f36767i, this.f36768j, this.k, this.f36764f, this.l);
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
        this.f36666b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f36738b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f36739c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f36740d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36741e;

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
                this.f36741e = this;
                this.a = r7;
                this.f36738b = fragment;
                this.f36739c = activity;
                this.f36740d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f36738b.getClass().getName();
                String simpleName = this.f36738b.getClass().getSimpleName();
                CharSequence title = this.f36739c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f36741e.f36669e.onPageEndFrag(this.f36740d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f36666b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WeakReference a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f36728b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f36729c;

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
                this.f36729c = this;
                this.a = r7;
                this.f36728b = applicationContext;
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
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f36729c.f36669e.onPageStartFrag(this.f36728b, name, currentTimeMillis);
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
