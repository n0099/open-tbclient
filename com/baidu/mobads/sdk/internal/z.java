package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class z {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "LoadRemoteDex";
    public static z i;
    public transient /* synthetic */ FieldHolder $fh;
    public IXAdContainerFactory b;
    public bm c;
    public int d;
    public Handler e;
    public Runnable f;
    public Context g;
    public br h;
    public AtomicBoolean j;
    public boolean k;

    /* loaded from: classes3.dex */
    public interface a {
        public static final int a = 1;
        public static final int b = 2;

        void onFailure();

        void onSuccess();
    }

    public z() {
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
        this.d = 5000;
        this.e = new Handler(Looper.getMainLooper());
        this.h = br.a();
        this.j = new AtomicBoolean(false);
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            synchronized (z.class) {
                try {
                    bm bmVar = new bm(Class.forName(w.aK, true, getClass().getClassLoader()), this.g);
                    this.c = bmVar;
                    this.b = bmVar.a();
                    k();
                } catch (Exception unused) {
                    a("反射调用remote失败");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.j.set(false);
            bj.a(this.g);
            i();
            p.a().a(1);
            cl.a(this.g).b();
            cl.a(this.g).a();
        }
    }

    public static z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (i == null) {
                synchronized (z.class) {
                    if (i == null) {
                        i = new z();
                    }
                }
            }
            return i;
        }
        return (z) invokeV.objValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.j.set(true);
            if (an.a()) {
                h();
            } else {
                g();
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Runnable runnable = this.f;
            if (runnable != null) {
                this.e.removeCallbacks(runnable);
            }
            this.f = null;
        }
    }

    private void j() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && (runnable = this.f) != null) {
            this.e.postDelayed(runnable, this.d);
        }
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (Context) invokeV.objValue;
    }

    public IXAdContainerFactory c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.g == null) {
                return null;
            }
            if (this.b == null && !this.j.get()) {
                f();
            }
            return this.b;
        }
        return (IXAdContainerFactory) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b != null) {
                return "_" + this.b.getRemoteVersion();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            br brVar = this.h;
            brVar.a(a, "加载dex失败原因=" + str);
            this.j.set(false);
            i();
            p.a().a(2);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f = new aa(this);
            j();
            if (f.a == null) {
                synchronized (bx.class) {
                    if (f.a == null) {
                        f.a = new bx(this.g);
                    }
                }
            }
            if (this.b != null) {
                k();
            } else if (f.a != null) {
                this.h.a(a, "start load apk");
                try {
                    f.a.a(new ab(this));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                this.h.a(a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
            }
        }
    }

    public void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) {
            if (context == null) {
                this.h.c(a, "init Context is null,error");
                return;
            }
            this.g = context.getApplicationContext();
            p.a().a(aVar);
            if (this.b != null) {
                k();
            } else if (!this.j.get()) {
                f();
            }
        }
    }
}
