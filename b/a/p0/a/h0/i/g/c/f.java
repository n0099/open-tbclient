package b.a.p0.a.h0.i.g.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import b.a.p0.a.k;
import b.a.p0.a.n1.j.a;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
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
public final class f extends b.a.p0.a.h0.i.g.c.a<e> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5595c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.p0.a.n1.j.a f5596a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.p0.a.n1.j.b f5597b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f5599f;

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
            this.f5599f = fVar;
            this.f5598e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (p = n0.p()) == null) {
                return;
            }
            Message.obtain(this.f5599f, 2, e.a(this.f5598e.f5591b, p)).sendToTarget();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-948904320, "Lb/a/p0/a/h0/i/g/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-948904320, "Lb/a/p0/a/h0/i/g/c/f;");
                return;
            }
        }
        f5595c = k.f6863a;
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
        this.f5596a = a.C0329a.a("simple_parser");
        this.f5597b = (b.a.p0.a.n1.j.b) a.C0329a.a("hsv_parser");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.h0.i.g.c.a
    /* renamed from: c */
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!e(eVar.f5591b)) {
            if (f5595c) {
                String str = ">> stop to capture, page is not top, webViewId =" + eVar.f5591b;
                return;
            }
            return;
        }
        f(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.h0.i.g.c.a
    /* renamed from: d */
    public void b(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!e(eVar.f5591b)) {
            if (f5595c) {
                String str = ">> stop to parse capture, page is not top, webViewId = " + eVar.f5591b;
                return;
            }
            return;
        }
        Bitmap bitmap = eVar.f5594d;
        b.a.p0.a.h0.g.f f2 = b.a.p0.a.n1.c.f();
        View B = b.a.p0.a.g1.f.U().B(eVar.f5591b);
        if (bitmap != null && f2 != null && B != null) {
            boolean z = f5595c;
            Rect b2 = b.a.p0.a.n1.c.b(bitmap, f2, B);
            this.f5596a.c(b.a.p0.a.n1.c.d(f2));
            if (!b.a.p0.a.n1.c.h() && this.f5596a.a(bitmap, b2)) {
                boolean z2 = f5595c;
                b.a.p0.a.h0.i.h.f fVar = new b.a.p0.a.h0.i.h.f();
                fVar.e(SceneType.SCENE_WHITE_SCREEN_L1);
                fVar.d(eVar.f5591b);
                return;
            }
            double d2 = this.f5597b.d(bitmap, b2);
            b.a.p0.a.h0.i.h.f fVar2 = new b.a.p0.a.h0.i.h.f();
            if (b.a.p0.a.n1.c.g() && d2 >= 0.5d) {
                if (f5595c) {
                    String str2 = ">> capture is part white screen ratio: " + d2;
                }
                fVar2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                fVar2.d(eVar.f5591b);
                return;
            } else if (d2 >= 0.7d) {
                if (f5595c) {
                    String str3 = ">> capture is part white screen ratio: " + d2;
                }
                fVar2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                fVar2.d(eVar.f5591b);
                return;
            } else {
                g.b().a();
                return;
            }
        }
        boolean z3 = f5595c;
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
        boolean z = f5595c;
        q0.e0(new a(this, eVar));
    }
}
