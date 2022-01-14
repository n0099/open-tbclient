package c.a.r0.a.t2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import c.a.r0.a.k;
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
    public static final boolean f8886f;

    /* renamed from: g  reason: collision with root package name */
    public static c.a.r0.a.t2.a f8887g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f8888h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f8889b;

    /* renamed from: c  reason: collision with root package name */
    public int f8890c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f8891d;

    /* renamed from: e  reason: collision with root package name */
    public String f8892e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f8893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8894f;

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
            this.f8894f = cVar;
            this.f8893e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f8887g != null) {
                    c.f8887g.c(this.f8894f.f8892e);
                }
                Rect rect = new Rect();
                this.f8893e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8894f.f8890c == this.f8894f.a) {
                    this.f8894f.f8890c = height;
                } else if (this.f8894f.f8890c == height) {
                } else {
                    if (this.f8894f.f8890c - height > this.f8894f.f8889b) {
                        if (c.f8887g != null) {
                            c.f8887g.b(this.f8894f.f8892e, this.f8894f.f8890c - height);
                            if (c.f8886f) {
                                String str = "onKeyBoardShow: mRootViewVisibleHeight " + this.f8894f.f8890c + " visibleHeight " + height;
                            }
                        }
                        this.f8894f.f8890c = height;
                    } else if (height - this.f8894f.f8890c > this.f8894f.f8889b) {
                        if (c.f8887g != null) {
                            c.f8887g.a(this.f8894f.f8892e, height - this.f8894f.f8890c);
                        }
                        if (c.f8886f) {
                            String str2 = "onKeyBoardHide: mRootViewVisibleHeight " + this.f8894f.f8890c + " visibleHeight " + height;
                        }
                        this.f8894f.f8890c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(437121872, "Lc/a/r0/a/t2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(437121872, "Lc/a/r0/a/t2/c;");
                return;
            }
        }
        f8886f = k.a;
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
        this.a = 0;
        this.f8889b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f8888h == null) {
                synchronized (c.class) {
                    if (f8888h == null) {
                        f8888h = new c();
                    }
                }
            }
            return f8888h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f8887g = null;
            f8888h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f8891d == null) {
                this.f8891d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f8891d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f8891d);
            this.f8892e = "";
            f8887g = null;
            this.f8890c = 0;
        }
    }

    public void l(View view, String str, c.a.r0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f8892e = str;
            f8887g = aVar;
            this.f8890c = 0;
        }
    }
}
