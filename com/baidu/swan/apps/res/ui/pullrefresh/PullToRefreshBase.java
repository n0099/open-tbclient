package com.baidu.swan.apps.res.ui.pullrefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hk2;
import com.baidu.tieba.kh1;
import com.baidu.tieba.mz2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public HEADERTYPE a;
    public float b;
    public h<T> c;
    public LoadingLayout d;
    public LoadingLayout e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public ILoadingLayout$State n;
    public ILoadingLayout$State o;
    public T p;
    public FrameLayout q;
    public int r;
    public Scroller s;
    public int t;
    public mz2<T> u;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class HEADERTYPE {
        public static final /* synthetic */ HEADERTYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HEADERTYPE BIG_BG_HEADER;
        public static final HEADERTYPE Common_STYLE_HEADER;
        public static final HEADERTYPE ROTATE_HEADER;
        public static final HEADERTYPE STANDARD_HEADER;
        public static final HEADERTYPE SWAN_APP_HEADER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1936657628, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBase$HEADERTYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1936657628, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBase$HEADERTYPE;");
                    return;
                }
            }
            STANDARD_HEADER = new HEADERTYPE("STANDARD_HEADER", 0);
            BIG_BG_HEADER = new HEADERTYPE("BIG_BG_HEADER", 1);
            ROTATE_HEADER = new HEADERTYPE("ROTATE_HEADER", 2);
            Common_STYLE_HEADER = new HEADERTYPE("Common_STYLE_HEADER", 3);
            HEADERTYPE headertype = new HEADERTYPE("SWAN_APP_HEADER", 4);
            SWAN_APP_HEADER = headertype;
            $VALUES = new HEADERTYPE[]{STANDARD_HEADER, BIG_BG_HEADER, ROTATE_HEADER, Common_STYLE_HEADER, headertype};
        }

        public HEADERTYPE(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static HEADERTYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HEADERTYPE) Enum.valueOf(HEADERTYPE.class, str) : (HEADERTYPE) invokeL.objValue;
        }

        public static HEADERTYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HEADERTYPE[]) $VALUES.clone() : (HEADERTYPE[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBase a;

        public a(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBase a;

        public b(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBase a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.setInterceptTouchEventEnabled(true);
                    this.a.a.d.setState(ILoadingLayout$State.RESET);
                }
            }
        }

        public c(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.postDelayed(new a(this), this.a.getSmoothScrollDuration());
                this.a.E();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Runnable b;
        public final /* synthetic */ PullToRefreshBase c;

        public d(PullToRefreshBase pullToRefreshBase, boolean z, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase, Boolean.valueOf(z), runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pullToRefreshBase;
            this.a = z;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = -this.c.d.getRefreshingHeight();
                int i2 = this.a ? 300 : 0;
                this.c.L();
                this.c.J(i, i2);
                Runnable runnable = this.b;
                if (runnable != null) {
                    this.c.post(runnable);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBase a;

        public e(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.b(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBase a;

        public f(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.a(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323549540, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBase$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(323549540, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBase$g;");
                    return;
                }
            }
            int[] iArr = new int[HEADERTYPE.values().length];
            a = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[HEADERTYPE.Common_STYLE_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[HEADERTYPE.SWAN_APP_HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface h<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1627150535, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1627150535, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBase;");
                return;
            }
        }
        v = kh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, mz2<T> mz2Var, HEADERTYPE headertype) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mz2Var, headertype};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = HEADERTYPE.Common_STYLE_HEADER;
        this.b = -1.0f;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.r = -1;
        this.t = -1;
        this.u = mz2Var;
        this.a = headertype;
        m(context, null);
    }

    private boolean getNgWebViewHeightSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            hk2.g0().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            this.k = z;
        }
    }

    public void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
                H(0, 0);
                LoadingLayout loadingLayout = this.d;
                if (loadingLayout != null) {
                    loadingLayout.e(0);
                }
            } else if (this.r <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.r) {
                G(0, -((int) f2));
                LoadingLayout loadingLayout2 = this.d;
                if (loadingLayout2 != null) {
                    loadingLayout2.e(-getScrollY());
                    if (this.f != 0) {
                        this.d.d(Math.abs(getScrollYValue()) / this.f);
                    }
                }
                int abs = Math.abs(getScrollYValue());
                if (!r() || s()) {
                    return;
                }
                LoadingLayout loadingLayout3 = this.d;
                if (loadingLayout3 != null && abs > loadingLayout3.getCanRefreshPullLength()) {
                    this.n = ILoadingLayout$State.RELEASE_TO_REFRESH;
                } else {
                    this.n = ILoadingLayout$State.PULL_TO_REFRESH;
                }
                LoadingLayout loadingLayout4 = this.d;
                if (loadingLayout4 != null) {
                    loadingLayout4.setState(this.n);
                }
                y(this.n, true);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LoadingLayout loadingLayout = this.d;
            int contentSize = loadingLayout != null ? loadingLayout.getContentSize() : 0;
            LoadingLayout loadingLayout2 = this.e;
            int contentSize2 = loadingLayout2 != null ? loadingLayout2.getContentSize() : 0;
            if (contentSize < 0) {
                contentSize = 0;
            }
            if (contentSize2 < 0) {
                contentSize2 = 0;
            }
            this.f = contentSize;
            this.g = contentSize2;
            LoadingLayout loadingLayout3 = this.d;
            int measuredHeight = loadingLayout3 != null ? loadingLayout3.getMeasuredHeight() : 0;
            LoadingLayout loadingLayout4 = this.e;
            int measuredHeight2 = loadingLayout4 != null ? loadingLayout4.getMeasuredHeight() : 0;
            if (measuredHeight2 == 0) {
                measuredHeight2 = this.g;
            }
            setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
        }
    }

    public void C(int i, int i2) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (frameLayout = this.q) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        if (layoutParams.height != i2) {
            layoutParams.height = i2;
            this.q.requestLayout();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean q = q();
            if (q && abs <= this.g) {
                I(0);
            } else if (q) {
                I(this.g);
            } else {
                I(0);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean s = s();
            if (s && abs <= this.d.getRefreshingHeight()) {
                I(0);
            } else if (s) {
                I(-this.d.getRefreshingHeight());
            } else {
                I(0);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void G(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            scrollBy(i, i2);
        }
    }

    public final void H(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            scrollTo(i, i2);
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            J(i, getSmoothScrollDuration());
        }
    }

    public final void J(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            this.s.forceFinished(true);
            int scrollY = getScrollY();
            int i3 = i - scrollY;
            if (i3 != 0) {
                this.s.startScroll(0, scrollY, 0, i3, i2);
                postInvalidate();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || q()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.o = iLoadingLayout$State;
        y(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.e;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.c != null) {
            postDelayed(new f(this), getSmoothScrollDuration());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            M(true);
        }
    }

    public final void M(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || s()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.n = iLoadingLayout$State;
        y(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.d;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (!z || this.c == null) {
            return;
        }
        postDelayed(new e(this), getSmoothScrollDuration());
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.s.computeScrollOffset()) {
            int currY = this.s.getCurrY();
            scrollTo(0, currY);
            this.d.e(-currY);
            this.e.d(Math.abs(getScrollYValue()) / this.g);
            postInvalidate();
        }
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LoadingLayout loadingLayout = this.d;
            LoadingLayout loadingLayout2 = this.e;
            if (loadingLayout != null) {
                if (this == loadingLayout.getParent()) {
                    removeView(loadingLayout);
                }
                addView(loadingLayout, 0, layoutParams);
            }
            if (loadingLayout2 != null) {
                if (this == loadingLayout2.getParent()) {
                    removeView(loadingLayout2);
                }
                addView(loadingLayout2, -1, layoutParams);
            }
        }
    }

    public void g(Context context, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, t) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.q = frameLayout;
            frameLayout.addView(t, -1, -1);
            addView(this.q, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.e : (LoadingLayout) invokeV.objValue;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.d : (LoadingLayout) invokeV.objValue;
    }

    public mz2<T> getRefreshableFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.u : (mz2) invokeV.objValue;
    }

    public T getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.p : (T) invokeV.objValue;
    }

    public int getScrollYValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getScrollY() : invokeV.intValue;
    }

    public int getSmoothScrollDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return 300;
        }
        return invokeV.intValue;
    }

    public LoadingLayout h(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, context, attributeSet)) == null) ? new FooterLoadingLayout(context) : (LoadingLayout) invokeLL.objValue;
    }

    public LoadingLayout i(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        LoadingLayout headerLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, context, attributeSet)) == null) {
            F();
            int i = g.a[this.a.ordinal()];
            if (i == 1) {
                headerLoadingLayout = new HeaderLoadingLayout(context);
            } else if (i == 2) {
                headerLoadingLayout = new BigBgHeaderLoadingLayout(context);
            } else if (i == 3) {
                headerLoadingLayout = new RotateLoadingLayout(context);
            } else if (i != 4) {
                headerLoadingLayout = i != 5 ? null : new NeutralHeaderLoadingLayout(context);
            } else {
                headerLoadingLayout = new CommonHeaderLoadingLayout(context);
            }
            return headerLoadingLayout == null ? new HeaderLoadingLayout(context) : headerLoadingLayout;
        }
        return (LoadingLayout) invokeLL.objValue;
    }

    public abstract T j(Context context, AttributeSet attributeSet);

    public void k(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            l(z, j, null);
        }
    }

    public void l(boolean z, long j, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), runnable}) == null) {
            postDelayed(new d(this, z, runnable), j);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void m(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, context, attributeSet) == null) {
            this.s = new Scroller(context);
            super.setOrientation(1);
            this.m = ViewConfiguration.get(context).getScaledTouchSlop();
            this.d = i(context, attributeSet);
            this.e = h(context, attributeSet);
            T j = j(context, attributeSet);
            this.p = j;
            if (v && j == null) {
                throw new NullPointerException("Refreshable view can not be null.");
            }
            T t = this.p;
            if (t != null) {
                g(context, t);
            }
            f(context);
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            boolean z = false;
            if (n()) {
                if (p() || r()) {
                    int action = motionEvent.getAction();
                    if (action != 3) {
                        if (action != 1) {
                            if (action == 0 || !this.l) {
                                int actionIndex = motionEvent.getActionIndex();
                                if (action == 0) {
                                    this.t = motionEvent.getPointerId(actionIndex);
                                    this.b = motionEvent.getY();
                                    this.l = false;
                                } else if (action == 2) {
                                    int findPointerIndex = motionEvent.findPointerIndex(this.t);
                                    if (findPointerIndex < 0) {
                                        this.l = false;
                                        return false;
                                    }
                                    float y = motionEvent.getY(findPointerIndex) - this.b;
                                    if (Math.abs(y) > this.m || s() || q()) {
                                        this.b = motionEvent.getY(findPointerIndex);
                                        if (r() && t()) {
                                            z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                            this.l = z;
                                            if (z && o() && (t = this.p) != null) {
                                                t.onTouchEvent(motionEvent);
                                            }
                                        } else if (p() && u()) {
                                            this.l = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                                        }
                                    }
                                } else if (action == 5) {
                                    this.t = motionEvent.getPointerId(actionIndex);
                                    this.b = motionEvent.getY(actionIndex);
                                    this.l = false;
                                } else if (action == 6) {
                                    int action2 = (motionEvent.getAction() & 65280) >> 8;
                                    if (motionEvent.getPointerId(action2) == this.t) {
                                        int i = action2 != 0 ? 0 : 1;
                                        this.t = motionEvent.getPointerId(i);
                                        this.b = (int) motionEvent.getY(i);
                                        this.l = false;
                                    }
                                }
                                return this.l;
                            }
                            return true;
                        }
                    }
                    this.l = false;
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048607, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048608, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            B();
            C(i, i2);
            post(new b(this));
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, motionEvent)) == null) {
            int actionIndex = motionEvent.getActionIndex();
            int action = motionEvent.getAction();
            boolean z = false;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.t);
                        if (findPointerIndex < 0) {
                            this.l = false;
                            return false;
                        }
                        float y = motionEvent.getY(findPointerIndex) - this.b;
                        this.b = motionEvent.getY(findPointerIndex);
                        if (r() && t()) {
                            A(y / 1.5f);
                        } else if (p() && u()) {
                            z(y / 1.5f);
                        } else {
                            this.l = false;
                            return false;
                        }
                        return true;
                    } else if (action != 3) {
                        if (action == 5) {
                            this.t = motionEvent.getPointerId(actionIndex);
                            this.b = motionEvent.getY(actionIndex);
                            return false;
                        } else if (action != 6) {
                            return false;
                        } else {
                            int action2 = (motionEvent.getAction() & 65280) >> 8;
                            if (motionEvent.getPointerId(action2) == this.t) {
                                int i = action2 != 0 ? 0 : 1;
                                this.t = motionEvent.getPointerId(i);
                                this.b = (int) motionEvent.getY(i);
                                return false;
                            }
                            return false;
                        }
                    }
                }
                if (this.l) {
                    this.l = false;
                    if (t()) {
                        if (this.h && this.n == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            L();
                            z = true;
                        } else if (!s()) {
                            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
                            this.n = iLoadingLayout$State;
                            y(iLoadingLayout$State, true);
                        }
                        E();
                        return z;
                    } else if (u()) {
                        if (p() && this.o == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            K();
                            z = true;
                        }
                        D();
                        return z;
                    } else {
                        return false;
                    }
                }
                return false;
            }
            this.t = motionEvent.getPointerId(actionIndex);
            this.b = motionEvent.getY();
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.i && this.e != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.o == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.h && this.d != null : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.n == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public void setEmptyView(View view2) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, view2) == null) || (frameLayout = this.q) == null) {
            return;
        }
        frameLayout.addView(view2, -1, -1);
    }

    public void setHeaderBackgroundColor(int i) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i) == null) || (loadingLayout = this.d) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundColor(getResources().getColor(i));
    }

    public void setHeaderBackgroundResource(int i) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i) == null) || (loadingLayout = this.d) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundResource(i);
    }

    public void setHeaderBigBackground(int i) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i) == null) || (loadingLayout = this.d) == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, charSequence) == null) {
            LoadingLayout loadingLayout = this.d;
            if (loadingLayout != null) {
                loadingLayout.setLastUpdatedLabel(charSequence);
            }
            LoadingLayout loadingLayout2 = this.e;
            if (loadingLayout2 != null) {
                loadingLayout2.setLastUpdatedLabel(charSequence);
            }
        }
    }

    public void setMaxPullOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.r = i;
        }
    }

    public void setOnRefreshListener(h<T> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, hVar) == null) {
            this.c = hVar;
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
        }
    }

    public void setPullLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.i = z;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.h = z;
        }
    }

    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.j = z;
        }
    }

    public abstract boolean t();

    public abstract boolean u();

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            x(z, null);
        }
    }

    public void x(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048630, this, z, str) == null) && s()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
            this.n = iLoadingLayout$State;
            y(iLoadingLayout$State, true);
            setInterceptTouchEventEnabled(false);
            this.d.f(z, str, new c(this));
        }
    }

    public void y(ILoadingLayout$State iLoadingLayout$State, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, iLoadingLayout$State, z) == null) {
        }
    }

    public void z(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
                H(0, 0);
                return;
            }
            G(0, -((int) f2));
            if (this.e != null && this.g != 0) {
                this.e.d(Math.abs(getScrollYValue()) / this.g);
            }
            int abs = Math.abs(getScrollYValue());
            if (!p() || q()) {
                return;
            }
            if (abs > this.g) {
                this.o = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.o = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout = this.e;
            if (loadingLayout != null) {
                loadingLayout.setState(this.o);
            }
            y(this.o, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = HEADERTYPE.Common_STYLE_HEADER;
        this.b = -1.0f;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.r = -1;
        this.t = -1;
        m(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = HEADERTYPE.Common_STYLE_HEADER;
        this.b = -1.0f;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.r = -1;
        this.t = -1;
        m(context, attributeSet);
    }
}
