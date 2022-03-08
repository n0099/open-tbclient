package c.a.p0.a.j2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
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
    public static final boolean f5856f;

    /* renamed from: g  reason: collision with root package name */
    public static c.a.p0.a.j2.a f5857g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f5858h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f5859b;

    /* renamed from: c  reason: collision with root package name */
    public int f5860c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f5861d;

    /* renamed from: e  reason: collision with root package name */
    public String f5862e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f5863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5864f;

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
            this.f5864f = cVar;
            this.f5863e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f5857g != null) {
                    c.f5857g.c(this.f5864f.f5862e);
                }
                Rect rect = new Rect();
                this.f5863e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f5864f.f5860c == this.f5864f.a) {
                    this.f5864f.f5860c = height;
                } else if (this.f5864f.f5860c == height) {
                } else {
                    if (this.f5864f.f5860c - height > this.f5864f.f5859b) {
                        if (c.f5857g != null) {
                            c.f5857g.b(this.f5864f.f5862e, this.f5864f.f5860c - height);
                            if (c.f5856f) {
                                String str = "onKeyBoardShow: mRootViewVisibleHeight " + this.f5864f.f5860c + " visibleHeight " + height;
                            }
                        }
                        this.f5864f.f5860c = height;
                    } else if (height - this.f5864f.f5860c > this.f5864f.f5859b) {
                        if (c.f5857g != null) {
                            c.f5857g.a(this.f5864f.f5862e, height - this.f5864f.f5860c);
                        }
                        if (c.f5856f) {
                            String str2 = "onKeyBoardHide: mRootViewVisibleHeight " + this.f5864f.f5860c + " visibleHeight " + height;
                        }
                        this.f5864f.f5860c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820913672, "Lc/a/p0/a/j2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(820913672, "Lc/a/p0/a/j2/c;");
                return;
            }
        }
        f5856f = c.a.p0.a.a.a;
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
        this.f5859b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f5858h == null) {
                synchronized (c.class) {
                    if (f5858h == null) {
                        f5858h = new c();
                    }
                }
            }
            return f5858h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f5857g = null;
            f5858h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f5861d == null) {
                this.f5861d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f5861d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f5861d);
            this.f5862e = "";
            f5857g = null;
            this.f5860c = 0;
        }
    }

    public void l(View view, String str, c.a.p0.a.j2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f5862e = str;
            f5857g = aVar;
            this.f5860c = 0;
        }
    }
}
