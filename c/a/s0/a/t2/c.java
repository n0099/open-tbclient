package c.a.s0.a.t2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import c.a.s0.a.k;
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
    public static final boolean f9128f;

    /* renamed from: g  reason: collision with root package name */
    public static c.a.s0.a.t2.a f9129g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f9130h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f9131b;

    /* renamed from: c  reason: collision with root package name */
    public int f9132c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f9133d;

    /* renamed from: e  reason: collision with root package name */
    public String f9134e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f9135e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f9136f;

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
            this.f9136f = cVar;
            this.f9135e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f9129g != null) {
                    c.f9129g.c(this.f9136f.f9134e);
                }
                Rect rect = new Rect();
                this.f9135e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f9136f.f9132c == this.f9136f.a) {
                    this.f9136f.f9132c = height;
                } else if (this.f9136f.f9132c == height) {
                } else {
                    if (this.f9136f.f9132c - height > this.f9136f.f9131b) {
                        if (c.f9129g != null) {
                            c.f9129g.b(this.f9136f.f9134e, this.f9136f.f9132c - height);
                            if (c.f9128f) {
                                String str = "onKeyBoardShow: mRootViewVisibleHeight " + this.f9136f.f9132c + " visibleHeight " + height;
                            }
                        }
                        this.f9136f.f9132c = height;
                    } else if (height - this.f9136f.f9132c > this.f9136f.f9131b) {
                        if (c.f9129g != null) {
                            c.f9129g.a(this.f9136f.f9134e, height - this.f9136f.f9132c);
                        }
                        if (c.f9128f) {
                            String str2 = "onKeyBoardHide: mRootViewVisibleHeight " + this.f9136f.f9132c + " visibleHeight " + height;
                        }
                        this.f9136f.f9132c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(240608367, "Lc/a/s0/a/t2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(240608367, "Lc/a/s0/a/t2/c;");
                return;
            }
        }
        f9128f = k.a;
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
        this.f9131b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f9130h == null) {
                synchronized (c.class) {
                    if (f9130h == null) {
                        f9130h = new c();
                    }
                }
            }
            return f9130h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f9129g = null;
            f9130h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f9133d == null) {
                this.f9133d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f9133d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f9133d);
            this.f9134e = "";
            f9129g = null;
            this.f9132c = 0;
        }
    }

    public void l(View view, String str, c.a.s0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f9134e = str;
            f9129g = aVar;
            this.f9132c = 0;
        }
    }
}
