package b.a.p0.a.p2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
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
    public static final boolean f7312f;

    /* renamed from: g  reason: collision with root package name */
    public static b.a.p0.a.p2.a f7313g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f7314h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f7315a;

    /* renamed from: b  reason: collision with root package name */
    public int f7316b;

    /* renamed from: c  reason: collision with root package name */
    public int f7317c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f7318d;

    /* renamed from: e  reason: collision with root package name */
    public String f7319e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f7320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f7321f;

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
            this.f7321f = cVar;
            this.f7320e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f7313g != null) {
                    c.f7313g.c(this.f7321f.f7319e);
                }
                Rect rect = new Rect();
                this.f7320e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f7321f.f7317c == this.f7321f.f7315a) {
                    this.f7321f.f7317c = height;
                } else if (this.f7321f.f7317c == height) {
                } else {
                    if (this.f7321f.f7317c - height > this.f7321f.f7316b) {
                        if (c.f7313g != null) {
                            c.f7313g.b(this.f7321f.f7319e, this.f7321f.f7317c - height);
                            if (c.f7312f) {
                                String str = "onKeyBoardShow: mRootViewVisibleHeight " + this.f7321f.f7317c + " visibleHeight " + height;
                            }
                        }
                        this.f7321f.f7317c = height;
                    } else if (height - this.f7321f.f7317c > this.f7321f.f7316b) {
                        if (c.f7313g != null) {
                            c.f7313g.a(this.f7321f.f7319e, height - this.f7321f.f7317c);
                        }
                        if (c.f7312f) {
                            String str2 = "onKeyBoardHide: mRootViewVisibleHeight " + this.f7321f.f7317c + " visibleHeight " + height;
                        }
                        this.f7321f.f7317c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1332013423, "Lb/a/p0/a/p2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1332013423, "Lb/a/p0/a/p2/c;");
                return;
            }
        }
        f7312f = k.f6397a;
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
        this.f7315a = 0;
        this.f7316b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f7314h == null) {
                synchronized (c.class) {
                    if (f7314h == null) {
                        f7314h = new c();
                    }
                }
            }
            return f7314h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f7313g = null;
            f7314h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f7318d == null) {
                this.f7318d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f7318d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f7318d);
            this.f7319e = "";
            f7313g = null;
            this.f7317c = 0;
        }
    }

    public void l(View view, String str, b.a.p0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f7319e = str;
            f7313g = aVar;
            this.f7317c = 0;
        }
    }
}
