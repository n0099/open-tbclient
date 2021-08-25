package c.a.o0.a.p2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import c.a.o0.a.k;
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
    public static final boolean f7984f;

    /* renamed from: g  reason: collision with root package name */
    public static c.a.o0.a.p2.a f7985g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f7986h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f7987a;

    /* renamed from: b  reason: collision with root package name */
    public int f7988b;

    /* renamed from: c  reason: collision with root package name */
    public int f7989c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f7990d;

    /* renamed from: e  reason: collision with root package name */
    public String f7991e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f7992e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f7993f;

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
            this.f7993f = cVar;
            this.f7992e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f7985g != null) {
                    c.f7985g.c(this.f7993f.f7991e);
                }
                Rect rect = new Rect();
                this.f7992e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f7993f.f7989c == this.f7993f.f7987a) {
                    this.f7993f.f7989c = height;
                } else if (this.f7993f.f7989c == height) {
                } else {
                    if (this.f7993f.f7989c - height > this.f7993f.f7988b) {
                        if (c.f7985g != null) {
                            c.f7985g.b(this.f7993f.f7991e, this.f7993f.f7989c - height);
                            if (c.f7984f) {
                                String str = "onKeyBoardShow: mRootViewVisibleHeight " + this.f7993f.f7989c + " visibleHeight " + height;
                            }
                        }
                        this.f7993f.f7989c = height;
                    } else if (height - this.f7993f.f7989c > this.f7993f.f7988b) {
                        if (c.f7985g != null) {
                            c.f7985g.a(this.f7993f.f7991e, height - this.f7993f.f7989c);
                        }
                        if (c.f7984f) {
                            String str2 = "onKeyBoardHide: mRootViewVisibleHeight " + this.f7993f.f7989c + " visibleHeight " + height;
                        }
                        this.f7993f.f7989c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1022968303, "Lc/a/o0/a/p2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1022968303, "Lc/a/o0/a/p2/c;");
                return;
            }
        }
        f7984f = k.f7049a;
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
        this.f7987a = 0;
        this.f7988b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f7986h == null) {
                synchronized (c.class) {
                    if (f7986h == null) {
                        f7986h = new c();
                    }
                }
            }
            return f7986h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f7985g = null;
            f7986h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f7990d == null) {
                this.f7990d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f7990d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f7990d);
            this.f7991e = "";
            f7985g = null;
            this.f7989c = 0;
        }
    }

    public void l(View view, String str, c.a.o0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f7991e = str;
            f7985g = aVar;
            this.f7989c = 0;
        }
    }
}
