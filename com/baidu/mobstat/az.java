package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.al;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class az {
    public static /* synthetic */ Interceptable $ic;
    public static final az k;
    public static volatile boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43234a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f43235b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f43236c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f43237d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f43238e;

    /* renamed from: f  reason: collision with root package name */
    public long f43239f;

    /* renamed from: g  reason: collision with root package name */
    public long f43240g;

    /* renamed from: h  reason: collision with root package name */
    public String f43241h;

    /* renamed from: i  reason: collision with root package name */
    public PointF f43242i;

    /* renamed from: j  reason: collision with root package name */
    public bf f43243j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657625, "Lcom/baidu/mobstat/az;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657625, "Lcom/baidu/mobstat/az;");
                return;
            }
        }
        k = new az();
        l = true;
    }

    public az() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43243j = bf.a();
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65553, this) == null) && bw.s(this.f43234a) && !this.f43236c) {
            if (!this.f43237d) {
                this.f43238e = bo.a(this.f43234a, "mtj_autoTracker.js");
                this.f43237d = true;
            }
            if (this.f43239f == 0) {
                this.f43239f = bq.a().n(this.f43234a);
                this.f43240g = bq.a().o(this.f43234a);
            }
            if (!(this.f43237d && TextUtils.isEmpty(this.f43238e)) && System.currentTimeMillis() - this.f43239f <= this.f43240g) {
                return;
            }
            f();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            Thread thread = new Thread(new Runnable(this) { // from class: com.baidu.mobstat.az.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ az f43245a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f43245a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f43245a.f43236c) {
                        return;
                    }
                    boolean a2 = bg.a(this.f43245a.f43234a, this.f43245a.f43241h, 1, false);
                    this.f43245a.f43236c = true;
                    if (a2) {
                        az azVar = this.f43245a;
                        azVar.f43238e = bo.a(azVar.f43234a, "mtj_autoTracker.js");
                    }
                }
            });
            thread.setName("downloadThread");
            thread.start();
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? l : invokeV.booleanValue;
    }

    private void d(Activity activity) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, activity) == null) || activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setCallback(a(window.getCallback()));
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f43241h = str;
        }
    }

    private void c(Activity activity) {
        Window window;
        Window.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, activity) == null) || activity == null || (window = activity.getWindow()) == null || (callback = window.getCallback()) == null) {
            return;
        }
        window.setCallback(new al(callback, new al.a(this) { // from class: com.baidu.mobstat.az.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ az f43244a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43244a = this;
            }

            @Override // com.baidu.mobstat.al.a
            public void a(MotionEvent motionEvent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && motionEvent.getActionMasked() == 1) {
                    az.a(true);
                    if (this.f43244a.f43242i == null) {
                        this.f43244a.f43242i = new PointF();
                    }
                    this.f43244a.f43242i.set(motionEvent.getRawX(), motionEvent.getRawY());
                }
            }

            @Override // com.baidu.mobstat.al.a
            public void a(KeyEvent keyEvent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, keyEvent) == null) {
                    ar.a(keyEvent);
                }
            }
        }));
    }

    public PointF b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43242i : (PointF) invokeV.objValue;
    }

    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, activity) == null) && d()) {
            d(this.f43235b);
            this.f43235b = null;
            a(activity, false);
        }
    }

    public static az a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? k : (az) invokeV.objValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? !TextUtils.isEmpty(this.f43241h) : invokeV.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ax.a().a(str);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            if (z) {
                bf.b();
            }
            l = z;
        }
    }

    private void b(WebView webView, String str, bl blVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, this, webView, str, blVar) == null) || blVar == null) {
            return;
        }
        blVar.a(this.f43235b, webView, str, (JSONObject) null, false);
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && d()) {
            a(true);
            this.f43234a = activity.getApplicationContext();
            this.f43235b = activity;
            e();
            c(activity);
            a(activity, true);
        }
    }

    public void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, z) == null) || (activity instanceof IIgnoreAutoEvent)) {
            return;
        }
        if (z) {
            this.f43243j.a(activity, false, null, false);
        } else {
            this.f43243j.a(activity, false);
        }
    }

    private Window.Callback a(Window.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, callback)) == null) {
            while (callback != null && (callback instanceof al)) {
                callback = ((al) callback).a();
            }
            return callback;
        }
        return (Window.Callback) invokeL.objValue;
    }

    public void a(WebView webView, String str, bl blVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, blVar) == null) {
            if (TextUtils.isEmpty(this.f43238e)) {
                this.f43238e = bo.a(this.f43234a, "mtj_autoTracker.js");
            }
            b(webView, this.f43238e, blVar);
        }
    }
}
