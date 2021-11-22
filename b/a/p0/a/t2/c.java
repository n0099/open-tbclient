package b.a.p0.a.t2;

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
    public static final boolean f8468f;

    /* renamed from: g  reason: collision with root package name */
    public static b.a.p0.a.t2.a f8469g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f8470h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f8471a;

    /* renamed from: b  reason: collision with root package name */
    public int f8472b;

    /* renamed from: c  reason: collision with root package name */
    public int f8473c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f8474d;

    /* renamed from: e  reason: collision with root package name */
    public String f8475e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f8476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8477f;

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
            this.f8477f = cVar;
            this.f8476e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f8469g != null) {
                    c.f8469g.c(this.f8477f.f8475e);
                }
                Rect rect = new Rect();
                this.f8476e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8477f.f8473c == this.f8477f.f8471a) {
                    this.f8477f.f8473c = height;
                } else if (this.f8477f.f8473c == height) {
                } else {
                    if (this.f8477f.f8473c - height > this.f8477f.f8472b) {
                        if (c.f8469g != null) {
                            c.f8469g.b(this.f8477f.f8475e, this.f8477f.f8473c - height);
                            if (c.f8468f) {
                                String str = "onKeyBoardShow: mRootViewVisibleHeight " + this.f8477f.f8473c + " visibleHeight " + height;
                            }
                        }
                        this.f8477f.f8473c = height;
                    } else if (height - this.f8477f.f8473c > this.f8477f.f8472b) {
                        if (c.f8469g != null) {
                            c.f8469g.a(this.f8477f.f8475e, height - this.f8477f.f8473c);
                        }
                        if (c.f8468f) {
                            String str2 = "onKeyBoardHide: mRootViewVisibleHeight " + this.f8477f.f8473c + " visibleHeight " + height;
                        }
                        this.f8477f.f8473c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1335707507, "Lb/a/p0/a/t2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1335707507, "Lb/a/p0/a/t2/c;");
                return;
            }
        }
        f8468f = k.f6863a;
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
        this.f8471a = 0;
        this.f8472b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f8470h == null) {
                synchronized (c.class) {
                    if (f8470h == null) {
                        f8470h = new c();
                    }
                }
            }
            return f8470h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f8469g = null;
            f8470h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f8474d == null) {
                this.f8474d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f8474d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f8474d);
            this.f8475e = "";
            f8469g = null;
            this.f8473c = 0;
        }
    }

    public void l(View view, String str, b.a.p0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f8475e = str;
            f8469g = aVar;
            this.f8473c = 0;
        }
    }
}
