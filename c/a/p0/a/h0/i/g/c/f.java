package c.a.p0.a.h0.i.g.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import c.a.p0.a.k;
import c.a.p0.a.n1.j.a;
import c.a.p0.a.z2.n0;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class f extends c.a.p0.a.h0.i.g.c.a<e> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5583c;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.a.n1.j.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.a.n1.j.b f5584b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f5586f;

        public a(f fVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5586f = fVar;
            this.f5585e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (p = n0.p()) == null) {
                return;
            }
            Message.obtain(this.f5586f, 2, e.a(this.f5585e.f5579b, p)).sendToTarget();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1357728545, "Lc/a/p0/a/h0/i/g/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1357728545, "Lc/a/p0/a/h0/i/g/c/f;");
                return;
            }
        }
        f5583c = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = a.C0385a.a("simple_parser");
        this.f5584b = (c.a.p0.a.n1.j.b) a.C0385a.a("hsv_parser");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.h0.i.g.c.a
    /* renamed from: c */
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!e(eVar.f5579b)) {
            if (f5583c) {
                String str = ">> stop to capture, page is not top, webViewId =" + eVar.f5579b;
                return;
            }
            return;
        }
        f(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.h0.i.g.c.a
    /* renamed from: d */
    public void b(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!e(eVar.f5579b)) {
            if (f5583c) {
                String str = ">> stop to parse capture, page is not top, webViewId = " + eVar.f5579b;
                return;
            }
            return;
        }
        Bitmap bitmap = eVar.f5582d;
        c.a.p0.a.h0.g.f f2 = c.a.p0.a.n1.c.f();
        View B = c.a.p0.a.g1.f.U().B(eVar.f5579b);
        if (bitmap != null && f2 != null && B != null) {
            boolean z = f5583c;
            Rect b2 = c.a.p0.a.n1.c.b(bitmap, f2, B);
            this.a.c(c.a.p0.a.n1.c.d(f2));
            if (!c.a.p0.a.n1.c.h() && this.a.a(bitmap, b2)) {
                boolean z2 = f5583c;
                c.a.p0.a.h0.i.h.f fVar = new c.a.p0.a.h0.i.h.f();
                fVar.e(SceneType.SCENE_WHITE_SCREEN_L1);
                fVar.d(eVar.f5579b);
                return;
            }
            double d2 = this.f5584b.d(bitmap, b2);
            c.a.p0.a.h0.i.h.f fVar2 = new c.a.p0.a.h0.i.h.f();
            if (c.a.p0.a.n1.c.g() && d2 >= 0.5d) {
                if (f5583c) {
                    String str2 = ">> capture is part white screen ratio: " + d2;
                }
                fVar2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                fVar2.d(eVar.f5579b);
                return;
            } else if (d2 >= 0.7d) {
                if (f5583c) {
                    String str3 = ">> capture is part white screen ratio: " + d2;
                }
                fVar2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                fVar2.d(eVar.f5579b);
                return;
            } else {
                g.b().a();
                return;
            }
        }
        boolean z3 = f5583c;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? TextUtils.equals(q0.B(), str) : invokeL.booleanValue;
    }

    public final void f(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        boolean z = f5583c;
        q0.e0(new a(this, eVar));
    }
}
