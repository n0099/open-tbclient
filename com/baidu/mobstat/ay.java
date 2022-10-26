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
import com.baidu.mobstat.ak;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ay {
    public static /* synthetic */ Interceptable $ic;
    public static final ay k;
    public static volatile boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Activity b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile String e;
    public long f;
    public long g;
    public String h;
    public PointF i;
    public be j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657594, "Lcom/baidu/mobstat/ay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657594, "Lcom/baidu/mobstat/ay;");
                return;
            }
        }
        k = new ay();
        l = true;
    }

    public ay() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = be.a();
    }

    public static ay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return k;
        }
        return (ay) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return l;
        }
        return invokeV.booleanValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (TextUtils.isEmpty(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65554, this) != null) || !bw.q(this.a)) {
            return;
        }
        Thread thread = new Thread(new Runnable(this) { // from class: com.baidu.mobstat.ay.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ay a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.a.c) {
                    return;
                }
                boolean a = bf.a(this.a.a, this.a.h, 1, false);
                this.a.c = true;
                if (a) {
                    ay ayVar = this.a;
                    ayVar.e = bn.a(ayVar.a, af.b);
                }
            }
        });
        thread.setName("downloadThread");
        thread.start();
    }

    public PointF b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (PointF) invokeV.objValue;
    }

    private Window.Callback a(Window.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, callback)) == null) {
            while (callback != null && (callback instanceof ak)) {
                callback = ((ak) callback).a();
            }
            return callback;
        }
        return (Window.Callback) invokeL.objValue;
    }

    private void c(Activity activity) {
        Window window;
        Window.Callback callback;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65548, this, activity) != null) || activity == null || (window = activity.getWindow()) == null || (callback = window.getCallback()) == null) {
            return;
        }
        window.setCallback(new ak(callback, new ak.a(this) { // from class: com.baidu.mobstat.ay.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ay a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.mobstat.ak.a
            public void a(KeyEvent keyEvent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, keyEvent) == null) {
                    aq.a(keyEvent);
                }
            }

            @Override // com.baidu.mobstat.ak.a
            public void a(MotionEvent motionEvent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && motionEvent.getActionMasked() == 1) {
                    ay.a(true);
                    if (this.a.i == null) {
                        this.a.i = new PointF();
                    }
                    this.a.i.set(motionEvent.getRawX(), motionEvent.getRawY());
                }
            }
        }));
    }

    private void d(Activity activity) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65551, this, activity) != null) || activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setCallback(a(window.getCallback()));
    }

    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, activity) != null) || !d()) {
            return;
        }
        d(this.b);
        this.b = null;
        a(activity, false);
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            if (z) {
                be.b();
            }
            l = z;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.h = str;
        }
    }

    private void b(WebView webView, String str, bk bkVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65545, this, webView, str, bkVar) != null) || bkVar == null) {
            return;
        }
        bkVar.a(this.b, webView, str, (JSONObject) null, false);
    }

    public void a(WebView webView, String str, bk bkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bkVar) == null) {
            if (TextUtils.isEmpty(this.e)) {
                this.e = bn.a(this.a, af.b);
            }
            b(webView, this.e, bkVar);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65553, this) != null) || this.c) {
            return;
        }
        if (!this.d) {
            this.e = bn.a(this.a, af.b);
            this.d = true;
        }
        if (this.f == 0) {
            this.f = bp.a().n(this.a);
            this.g = bp.a().o(this.a);
        }
        long j = this.g;
        if ((this.d && TextUtils.isEmpty(this.e)) || System.currentTimeMillis() - this.f > j) {
            f();
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, activity) != null) || !d()) {
            return;
        }
        a(true);
        this.a = activity.getApplicationContext();
        this.b = activity;
        e();
        c(activity);
        a(activity, true);
    }

    public void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, z) != null) || (activity instanceof IIgnoreAutoEvent)) {
            return;
        }
        if (z) {
            this.j.a(activity, false, null, false);
        } else {
            this.j.a(activity, false);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            aw.a().a(str);
        }
    }
}
