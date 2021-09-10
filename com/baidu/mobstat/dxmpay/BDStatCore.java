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
    public static BDStatCore f43541a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f43542b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f43543c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43544d;

    /* renamed from: e  reason: collision with root package name */
    public SessionAnalysis f43545e;

    /* renamed from: f  reason: collision with root package name */
    public EventAnalysis f43546f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f43547g;

    /* renamed from: h  reason: collision with root package name */
    public long f43548h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f43549i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f43550j;

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
        this.f43543c = false;
        this.f43544d = false;
        this.f43548h = 0L;
        this.f43549i = false;
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f43542b = new Handler(handlerThread.getLooper());
        this.f43545e = new SessionAnalysis();
        this.f43546f = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f43550j = new Handler(handlerThread2.getLooper());
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
            if (f43541a == null) {
                synchronized (BDStatCore.class) {
                    if (f43541a == null) {
                        f43541a = new BDStatCore();
                    }
                }
            }
            return f43541a;
        }
        return (BDStatCore) invokeV.objValue;
    }

    public void autoTrackLaunchInfo(Context context, LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, context, launchInfo, z) == null) || launchInfo == null) {
            return;
        }
        if (z) {
            this.f43545e.autoTrackLaunchInfo(launchInfo, z);
            return;
        }
        init(context);
        this.f43542b.post(new Runnable(this, launchInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LaunchInfo f43589a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43590b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43591c;

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
                this.f43591c = this;
                this.f43589a = launchInfo;
                this.f43590b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43591c.f43545e.autoTrackLaunchInfo(this.f43589a, this.f43590b);
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
        this.f43542b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43595a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43596b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43597c;

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
                this.f43597c = this;
                this.f43595a = context;
                this.f43596b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43597c.f43545e.autoTrackSessionEndTime(this.f43595a, this.f43596b);
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
        this.f43542b.post(new Runnable(this, context, System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43592a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43593b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43594c;

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
                this.f43594c = this;
                this.f43592a = context;
                this.f43593b = r8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43594c.f43545e.autoTrackSessionStartTime(this.f43592a, this.f43593b);
                }
            }
        });
    }

    public void cancelSendLogCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Runnable runnable = this.f43547g;
            if (runnable != null) {
                this.f43542b.removeCallbacks(runnable);
            }
            this.f43547g = null;
        }
    }

    public void doSendLogCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        int sessionTimeOut = this.f43545e.getSessionTimeOut();
        Runnable runnable = new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43598a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43599b;

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
                this.f43599b = this;
                this.f43598a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43599b.f43545e.doSendLogCheck(this.f43598a, System.currentTimeMillis());
                }
            }
        };
        this.f43547g = runnable;
        this.f43542b.postDelayed(runnable, sessionTimeOut);
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43545e.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f43545e.getSessionSize() : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43545e.getSessionStartTime() : invokeV.longValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a(context);
            if (this.f43543c) {
                return;
            }
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f43542b.post(new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f43551a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BDStatCore f43552b;

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
                    this.f43552b = this;
                    this.f43551a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f43552b.f43543c) {
                        return;
                    }
                    PrefOperate.loadMetaDataConfig(this.f43551a);
                    this.f43552b.f43543c = true;
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, str2, str3) == null) || this.f43545e.isSessionStart()) {
            return;
        }
        init(context);
        this.f43542b.post(new Runnable(this, context, System.currentTimeMillis(), str2, str3) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43584a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43585b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43586c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43587d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43588e;

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
                this.f43588e = this;
                this.f43584a = context;
                this.f43585b = r8;
                this.f43586c = str2;
                this.f43587d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DataCore.instance().init(this.f43584a);
                    EventAnalysis eventAnalysis = this.f43588e.f43546f;
                    Context context2 = this.f43584a;
                    long j2 = this.f43585b;
                    eventAnalysis.onEvent(context2, j2, this.f43586c, this.f43587d, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(this.f43584a, true, false, this.f43585b, false);
                    if (this.f43585b - this.f43588e.f43548h <= 30000 || !w.h(this.f43584a)) {
                        return;
                    }
                    LogSender.instance().onSend(this.f43584a);
                    this.f43588e.f43548h = this.f43585b;
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
        this.f43542b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43553a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43554b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43555c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43556d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43557e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43558f;

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
                this.f43558f = this;
                this.f43553a = str2;
                this.f43554b = context;
                this.f43555c = r9;
                this.f43556d = z;
                this.f43557e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43553a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43558f.f43545e.onSessionStart(this.f43554b, this.f43555c, this.f43556d);
                    h.c().a("Start event" + this.f43558f.a(this.f43557e, str3, 1, -1L, null, null));
                    this.f43558f.f43546f.onEventStart(this.f43554b, this.f43557e, str3, this.f43555c);
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
        this.f43542b.post(new Runnable(this, str, context, a(), System.currentTimeMillis()) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43603a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43604b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f43605c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f43606d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43607e;

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
                this.f43607e = this;
                this.f43603a = str;
                this.f43604b = context;
                this.f43605c = r9;
                this.f43606d = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("Start page view " + this.f43603a);
                    this.f43607e.f43545e.onPageStart(this.f43604b, this.f43603a, this.f43605c, this.f43606d);
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
        this.f43542b.post(new Runnable(this, new WeakReference(activity), z, applicationContext, extraInfo) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43622a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43623b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f43624c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43625d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43626e;

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
                this.f43626e = this;
                this.f43622a = r7;
                this.f43623b = z;
                this.f43624c = applicationContext;
                this.f43625d = extraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f43622a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                String simpleName = activity2.getClass().getSimpleName();
                CharSequence title = activity2.getTitle();
                String charSequence = title == null ? "" : title.toString();
                if (!this.f43623b) {
                    h c2 = h.c();
                    c2.a("End page view " + cls.getSimpleName());
                }
                this.f43626e.f43545e.onPageEndAct(this.f43624c, name, simpleName, charSequence, System.currentTimeMillis(), this.f43623b, this.f43625d);
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
        this.f43542b.post(new Runnable(this, new WeakReference(activity), z, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43615a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f43616b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f43617c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43618d;

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
                this.f43618d = this;
                this.f43615a = r7;
                this.f43616b = z;
                this.f43617c = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f43615a.get()) == null || (cls = activity2.getClass()) == null) {
                    return;
                }
                String name = activity2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f43616b) {
                    h c2 = h.c();
                    c2.a("Start page view " + cls.getSimpleName());
                }
                this.f43618d.f43545e.onPageStartAct(this.f43617c, name, currentTimeMillis, this.f43616b);
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
        this.f43542b.post(new Runnable(this, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43567a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f43568b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f43569c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43570d;

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
                this.f43570d = this;
                this.f43567a = context;
                this.f43568b = r8;
                this.f43569c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f43570d.f43545e.onSessionStart(this.f43567a, this.f43568b, this.f43569c);
                }
            }
        });
    }

    public void onStat(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) || this.f43545e.isSessionStart()) {
            return;
        }
        this.f43542b.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f43581a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43582b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43583c;

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
                this.f43583c = this;
                this.f43581a = context;
                this.f43582b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogSender.instance().sendEmptyLogData(this.f43581a, this.f43582b);
                }
            }
        });
    }

    public void setAuthorizedState(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048607, this, context, z) == null) || context == null) {
            return;
        }
        this.f43544d = z;
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
        this.f43545e.setAutoSend(z);
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f43545e.setSessionTimeOut(i2);
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
        this.f43542b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, i2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43637a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43638b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43639c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43640d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43641e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43642f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f43643g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43644h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43645i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43646j;

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
                this.f43646j = this;
                this.f43637a = str2;
                this.f43638b = context;
                this.f43639c = r10;
                this.f43640d = z;
                this.f43641e = str;
                this.f43642f = i2;
                this.f43643g = map;
                this.f43644h = extraInfo;
                this.f43645i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43637a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43646j.f43545e.onSessionStart(this.f43638b, this.f43639c, this.f43640d);
                    h.c().a("Put event" + this.f43646j.a(this.f43641e, str3, this.f43642f, 0L, this.f43643g, this.f43644h));
                    this.f43646j.f43546f.onEvent(this.f43638b, this.f43646j.f43545e.getSessionStartTime(), this.f43641e, str3, this.f43642f, this.f43639c, this.f43644h, this.f43643g, this.f43645i);
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
        this.f43542b.post(new Runnable(this, str2, context, System.currentTimeMillis(), z, str, j2, map, extraInfo, z2) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43571a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43572b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43573c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43574d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43575e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43576f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Map f43577g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43578h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43579i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43580j;

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
                this.f43580j = this;
                this.f43571a = str2;
                this.f43572b = context;
                this.f43573c = r10;
                this.f43574d = z;
                this.f43575e = str;
                this.f43576f = j2;
                this.f43577g = map;
                this.f43578h = extraInfo;
                this.f43579i = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43571a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    this.f43580j.f43545e.onSessionStart(this.f43572b, this.f43573c, this.f43574d);
                    h.c().a("Put event" + this.f43580j.a(this.f43575e, str3, 1, this.f43576f, this.f43577g, this.f43578h));
                    this.f43580j.f43546f.onEventDuration(this.f43572b, this.f43580j.f43545e.getSessionStartTime(), this.f43575e, str3, this.f43573c, this.f43576f, this.f43578h, this.f43577g, this.f43579i);
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
        this.f43542b.post(new Runnable(this, str2, str, map, extraInfo, context, System.currentTimeMillis(), z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43559a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43560b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f43561c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43562d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f43563e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43564f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f43565g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43566h;

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
                this.f43566h = this;
                this.f43559a = str2;
                this.f43560b = str;
                this.f43561c = map;
                this.f43562d = extraInfo;
                this.f43563e = context;
                this.f43564f = r12;
                this.f43565g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str3 = this.f43559a;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    long sessionStartTime = this.f43566h.f43545e.getSessionStartTime();
                    h.c().a("End event" + this.f43566h.a(this.f43560b, str3, 1, -1L, this.f43561c, this.f43562d));
                    this.f43566h.f43546f.onEventEnd(this.f43563e, sessionStartTime, this.f43560b, str3, this.f43564f, this.f43562d, this.f43561c, this.f43565g);
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
        this.f43542b.post(new Runnable(this, str, context, b(), System.currentTimeMillis(), extraInfo, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43608a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43609b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43610c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f43611d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ExtraInfo f43612e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f43613f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43614g;

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
                this.f43614g = this;
                this.f43608a = str;
                this.f43609b = context;
                this.f43610c = r9;
                this.f43611d = r10;
                this.f43612e = extraInfo;
                this.f43613f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h c2 = h.c();
                    c2.a("End page view " + this.f43608a);
                    SessionAnalysis sessionAnalysis = this.f43614g.f43545e;
                    Context context2 = this.f43609b;
                    String str2 = this.f43608a;
                    sessionAnalysis.onPageEnd(context2, str2, str2, this.f43610c, this.f43611d, this.f43612e, this.f43613f);
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
        this.f43542b.post(new Runnable(this, str2, context, System.currentTimeMillis(), str, i2, str3, str4, i3, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43647a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43648b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43649c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43650d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43651e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43652f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43653g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f43654h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ boolean f43655i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43656j;

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
                this.f43656j = this;
                this.f43647a = str2;
                this.f43648b = context;
                this.f43649c = r10;
                this.f43650d = str;
                this.f43651e = i2;
                this.f43652f = str3;
                this.f43653g = str4;
                this.f43654h = i3;
                this.f43655i = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str5 = this.f43647a;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "";
                    }
                    this.f43656j.f43545e.onSessionStart(this.f43648b, this.f43649c, false);
                    h.c().a("Put event" + this.f43656j.a(this.f43650d, str5, this.f43651e, 0L, null, null));
                    this.f43656j.f43546f.onEvent(this.f43648b, this.f43656j.f43545e.getSessionStartTime(), this.f43650d, str5, this.f43651e, this.f43649c, this.f43652f, this.f43653g, this.f43654h, this.f43655i);
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
        this.f43542b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43627a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Fragment f43628b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f43629c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f43630d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43631e;

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
                this.f43631e = this;
                this.f43627a = r7;
                this.f43628b = fragment;
                this.f43629c = activity;
                this.f43630d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f43627a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f43628b.getClass().getName();
                String simpleName = this.f43628b.getClass().getSimpleName();
                CharSequence title = this.f43629c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f43631e.f43545e.onPageEndFrag(this.f43630d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f43542b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43600a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43601b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43602c;

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
                this.f43602c = this;
                this.f43600a = r7;
                this.f43601b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (Fragment) this.f43600a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f43602c.f43545e.onPageStartFrag(this.f43601b, name, currentTimeMillis);
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
        this.f43542b.post(new Runnable(this, str2, context, j2, str, i2, map, jSONArray, jSONArray2, str3, str4, str5, z) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43657a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43658b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43659c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f43660d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43661e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f43662f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43663g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43664h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f43665i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ String f43666j;
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
                this.f43657a = str2;
                this.f43658b = context;
                this.f43659c = j2;
                this.f43660d = str;
                this.f43661e = i2;
                this.f43662f = map;
                this.f43663g = jSONArray;
                this.f43664h = jSONArray2;
                this.f43665i = str3;
                this.f43666j = str4;
                this.k = str5;
                this.l = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String str6 = this.f43657a;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    this.m.f43545e.onSessionStart(this.f43658b, this.f43659c, false);
                    h.c().a("Put event" + this.m.a(this.f43660d, str6, this.f43661e, 0L, this.f43662f, null));
                    this.m.f43546f.onEvent(this.f43658b, this.m.f43545e.getSessionStartTime(), this.f43660d, str6, this.f43661e, this.f43659c, this.f43663g, this.f43664h, this.f43665i, this.f43666j, this.k, this.f43662f, this.l);
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
        this.f43542b.post(new Runnable(this, new WeakReference(fragment), fragment, activity, applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43632a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ android.app.Fragment f43633b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Activity f43634c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f43635d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43636e;

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
                this.f43636e = this;
                this.f43632a = r7;
                this.f43633b = fragment;
                this.f43634c = activity;
                this.f43635d = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f43632a.get()) == null || fragment2.getClass() == null) {
                    return;
                }
                String name = this.f43633b.getClass().getName();
                String simpleName = this.f43633b.getClass().getSimpleName();
                CharSequence title = this.f43634c.getTitle();
                String charSequence = title == null ? "" : title.toString();
                h c2 = h.c();
                c2.a("End page view " + simpleName);
                this.f43636e.f43545e.onPageEndFrag(this.f43635d, name, simpleName, charSequence, System.currentTimeMillis());
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
        this.f43542b.post(new Runnable(this, new WeakReference(fragment), applicationContext) { // from class: com.baidu.mobstat.dxmpay.BDStatCore.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WeakReference f43619a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f43620b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BDStatCore f43621c;

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
                this.f43621c = this;
                this.f43619a = r7;
                this.f43620b = applicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Fragment fragment2;
                Class<?> cls;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fragment2 = (android.app.Fragment) this.f43619a.get()) == null || (cls = fragment2.getClass()) == null) {
                    return;
                }
                String name = fragment2.getClass().getName();
                long currentTimeMillis = System.currentTimeMillis();
                h c2 = h.c();
                c2.a("Start page view " + cls.getSimpleName());
                this.f43621c.f43545e.onPageStartFrag(this.f43620b, name, currentTimeMillis);
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
