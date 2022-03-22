package c.a.n0.a.j2;

import android.graphics.Rect;
import android.util.Log;
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
    public static final boolean f4937f;

    /* renamed from: g  reason: collision with root package name */
    public static c.a.n0.a.j2.a f4938g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f4939h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f4940b;

    /* renamed from: c  reason: collision with root package name */
    public int f4941c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f4942d;

    /* renamed from: e  reason: collision with root package name */
    public String f4943e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f4944b;

        public a(c cVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4944b = cVar;
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f4938g != null) {
                    c.f4938g.c(this.f4944b.f4943e);
                }
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f4944b.f4941c == this.f4944b.a) {
                    this.f4944b.f4941c = height;
                } else if (this.f4944b.f4941c == height) {
                } else {
                    if (this.f4944b.f4941c - height > this.f4944b.f4940b) {
                        if (c.f4938g != null) {
                            c.f4938g.b(this.f4944b.f4943e, this.f4944b.f4941c - height);
                            if (c.f4937f) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + this.f4944b.f4941c + " visibleHeight " + height);
                            }
                        }
                        this.f4944b.f4941c = height;
                    } else if (height - this.f4944b.f4941c > this.f4944b.f4940b) {
                        if (c.f4938g != null) {
                            c.f4938g.a(this.f4944b.f4943e, height - this.f4944b.f4941c);
                        }
                        if (c.f4937f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + this.f4944b.f4941c + " visibleHeight " + height);
                        }
                        this.f4944b.f4941c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1213940682, "Lc/a/n0/a/j2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1213940682, "Lc/a/n0/a/j2/c;");
                return;
            }
        }
        f4937f = c.a.n0.a.a.a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f4940b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f4939h == null) {
                synchronized (c.class) {
                    if (f4939h == null) {
                        f4939h = new c();
                    }
                }
            }
            return f4939h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f4938g = null;
            f4939h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f4942d == null) {
                this.f4942d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f4942d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f4942d);
            this.f4943e = "";
            f4938g = null;
            this.f4941c = 0;
        }
    }

    public void l(View view, String str, c.a.n0.a.j2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f4943e = str;
            f4938g = aVar;
            this.f4941c = 0;
        }
    }
}
