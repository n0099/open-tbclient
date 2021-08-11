package c.a.n0.a.p2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import c.a.n0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7738f;

    /* renamed from: g  reason: collision with root package name */
    public static c.a.n0.a.p2.a f7739g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f7740h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f7741a;

    /* renamed from: b  reason: collision with root package name */
    public int f7742b;

    /* renamed from: c  reason: collision with root package name */
    public int f7743c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f7744d;

    /* renamed from: e  reason: collision with root package name */
    public String f7745e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f7746e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f7747f;

        public a(c cVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7747f = cVar;
            this.f7746e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f7739g != null) {
                    c.f7739g.c(this.f7747f.f7745e);
                }
                Rect rect = new Rect();
                this.f7746e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f7747f.f7743c == this.f7747f.f7741a) {
                    this.f7747f.f7743c = height;
                } else if (this.f7747f.f7743c == height) {
                } else {
                    if (this.f7747f.f7743c - height > this.f7747f.f7742b) {
                        if (c.f7739g != null) {
                            c.f7739g.b(this.f7747f.f7745e, this.f7747f.f7743c - height);
                            if (c.f7738f) {
                                String str = "onKeyBoardShow: mRootViewVisibleHeight " + this.f7747f.f7743c + " visibleHeight " + height;
                            }
                        }
                        this.f7747f.f7743c = height;
                    } else if (height - this.f7747f.f7743c > this.f7747f.f7742b) {
                        if (c.f7739g != null) {
                            c.f7739g.a(this.f7747f.f7745e, height - this.f7747f.f7743c);
                        }
                        if (c.f7738f) {
                            String str2 = "onKeyBoardHide: mRootViewVisibleHeight " + this.f7747f.f7743c + " visibleHeight " + height;
                        }
                        this.f7747f.f7743c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1219481808, "Lc/a/n0/a/p2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1219481808, "Lc/a/n0/a/p2/c;");
                return;
            }
        }
        f7738f = k.f6803a;
    }

    public c() {
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
        this.f7741a = 0;
        this.f7742b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f7740h == null) {
                synchronized (c.class) {
                    if (f7740h == null) {
                        f7740h = new c();
                    }
                }
            }
            return f7740h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f7739g = null;
            f7740h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f7744d == null) {
                this.f7744d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f7744d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f7744d);
            this.f7745e = "";
            f7739g = null;
            this.f7743c = 0;
        }
    }

    public void l(View view, String str, c.a.n0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f7745e = str;
            f7739g = aVar;
            this.f7743c = 0;
        }
    }
}
