package c.a.n0.a.x.i.g.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import c.a.n0.a.d1.j.a;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
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
public final class f extends c.a.n0.a.x.i.g.c.a<e> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7107c;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.d1.j.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.a.d1.j.b f7108b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f7109b;

        public a(f fVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7109b = fVar;
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (p = n0.p()) == null) {
                return;
            }
            Message.obtain(this.f7109b, 2, e.a(this.a.f7104b, p)).sendToTarget();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(490330171, "Lc/a/n0/a/x/i/g/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(490330171, "Lc/a/n0/a/x/i/g/c/f;");
                return;
            }
        }
        f7107c = c.a.n0.a.a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = a.C0243a.a("simple_parser");
        this.f7108b = (c.a.n0.a.d1.j.b) a.C0243a.a("hsv_parser");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x.i.g.c.a
    /* renamed from: c */
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!e(eVar.f7104b)) {
            if (f7107c) {
                Log.d("WhitePageHandler", ">> stop to capture, page is not top, webViewId =" + eVar.f7104b);
                return;
            }
            return;
        }
        f(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x.i.g.c.a
    /* renamed from: d */
    public void b(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!e(eVar.f7104b)) {
            if (f7107c) {
                Log.d("WhitePageHandler", ">> stop to parse capture, page is not top, webViewId = " + eVar.f7104b);
                return;
            }
            return;
        }
        Bitmap bitmap = eVar.f7106d;
        c.a.n0.a.x.g.f f2 = c.a.n0.a.d1.c.f();
        View B = c.a.n0.a.w0.f.U().B(eVar.f7104b);
        if (bitmap != null && f2 != null && B != null) {
            if (f7107c) {
                Log.d("WhitePageHandler", ">> start parsing capture");
            }
            Rect b2 = c.a.n0.a.d1.c.b(bitmap, f2, B);
            this.a.c(c.a.n0.a.d1.c.d(f2));
            if (!c.a.n0.a.d1.c.h() && this.a.a(bitmap, b2)) {
                if (f7107c) {
                    Log.d("WhitePageHandler", ">> capture is full white screen.");
                }
                c.a.n0.a.x.i.h.f fVar = new c.a.n0.a.x.i.h.f();
                fVar.e(SceneType.SCENE_WHITE_SCREEN_L1);
                fVar.d(eVar.f7104b);
                return;
            }
            double d2 = this.f7108b.d(bitmap, b2);
            c.a.n0.a.x.i.h.f fVar2 = new c.a.n0.a.x.i.h.f();
            if (c.a.n0.a.d1.c.g() && d2 >= 0.5d) {
                if (f7107c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d2);
                }
                fVar2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                fVar2.d(eVar.f7104b);
            } else if (d2 >= 0.7d) {
                if (f7107c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d2);
                }
                fVar2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                fVar2.d(eVar.f7104b);
            } else {
                g.b().a();
            }
        } else if (f7107c) {
            Log.d("WhitePageHandler", ">> stop to parse capture, capture or fragment or webView is null.");
        }
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
        if (f7107c) {
            Log.d("WhitePageHandler", ">> start to get capture.");
        }
        q0.e0(new a(this, eVar));
    }
}
