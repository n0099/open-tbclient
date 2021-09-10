package c.a.p0.a.p2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import c.a.p0.a.k;
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
    public static final boolean f8012f;

    /* renamed from: g  reason: collision with root package name */
    public static c.a.p0.a.p2.a f8013g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f8014h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f8015a;

    /* renamed from: b  reason: collision with root package name */
    public int f8016b;

    /* renamed from: c  reason: collision with root package name */
    public int f8017c;

    /* renamed from: d  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f8018d;

    /* renamed from: e  reason: collision with root package name */
    public String f8019e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f8020e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f8021f;

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
            this.f8021f = cVar;
            this.f8020e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.f8013g != null) {
                    c.f8013g.c(this.f8021f.f8019e);
                }
                Rect rect = new Rect();
                this.f8020e.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8021f.f8017c == this.f8021f.f8015a) {
                    this.f8021f.f8017c = height;
                } else if (this.f8021f.f8017c == height) {
                } else {
                    if (this.f8021f.f8017c - height > this.f8021f.f8016b) {
                        if (c.f8013g != null) {
                            c.f8013g.b(this.f8021f.f8019e, this.f8021f.f8017c - height);
                            if (c.f8012f) {
                                String str = "onKeyBoardShow: mRootViewVisibleHeight " + this.f8021f.f8017c + " visibleHeight " + height;
                            }
                        }
                        this.f8021f.f8017c = height;
                    } else if (height - this.f8021f.f8017c > this.f8021f.f8016b) {
                        if (c.f8013g != null) {
                            c.f8013g.a(this.f8021f.f8019e, height - this.f8021f.f8017c);
                        }
                        if (c.f8012f) {
                            String str2 = "onKeyBoardHide: mRootViewVisibleHeight " + this.f8021f.f8017c + " visibleHeight " + height;
                        }
                        this.f8021f.f8017c = height;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(826454798, "Lc/a/p0/a/p2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(826454798, "Lc/a/p0/a/p2/c;");
                return;
            }
        }
        f8012f = k.f7077a;
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
        this.f8015a = 0;
        this.f8016b = 200;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f8014h == null) {
                synchronized (c.class) {
                    if (f8014h == null) {
                        f8014h = new c();
                    }
                }
            }
            return f8014h;
        }
        return (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f8013g = null;
            f8014h = null;
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f8018d == null) {
                this.f8018d = new a(this, view);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f8018d);
        }
    }

    public void k(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f8018d);
            this.f8019e = "";
            f8013g = null;
            this.f8017c = 0;
        }
    }

    public void l(View view, String str, c.a.p0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, aVar) == null) {
            h(view);
            this.f8019e = str;
            f8013g = aVar;
            this.f8017c = 0;
        }
    }
}
