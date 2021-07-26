package com.baidu.swan.apps.res.ui.pullrefresh;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
/* loaded from: classes3.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HEADERTYPE f11432e;

    /* renamed from: f  reason: collision with root package name */
    public float f11433f;

    /* renamed from: g  reason: collision with root package name */
    public h<T> f11434g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout f11435h;

    /* renamed from: i  reason: collision with root package name */
    public LoadingLayout f11436i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public ILoadingLayout$State r;
    public ILoadingLayout$State s;
    public T t;
    public FrameLayout u;
    public int v;
    public Scroller w;
    public int x;
    public d.a.o0.a.z1.a.d.a<T> y;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public HEADERTYPE(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f11437e;

        public a(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11437e = pullToRefreshBase;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11437e.B();
                this.f11437e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f11438e;

        public b(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11438e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11438e.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f11439e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f11440e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11440e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f11440e.f11439e.setInterceptTouchEventEnabled(true);
                    this.f11440e.f11439e.f11435h.setState(ILoadingLayout$State.RESET);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11439e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11439e.postDelayed(new a(this), this.f11439e.getSmoothScrollDuration());
                this.f11439e.E();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f11442f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f11443g;

        public d(PullToRefreshBase pullToRefreshBase, boolean z, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase, Boolean.valueOf(z), runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11443g = pullToRefreshBase;
            this.f11441e = z;
            this.f11442f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = -this.f11443g.f11435h.getRefreshingHeight();
                int i3 = this.f11441e ? 300 : 0;
                this.f11443g.L();
                this.f11443g.J(i2, i3);
                Runnable runnable = this.f11442f;
                if (runnable != null) {
                    this.f11443g.post(runnable);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f11444e;

        public e(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11444e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11444e.f11434g.b(this.f11444e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f11445e;

        public f(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11445e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11445e.f11434g.a(this.f11445e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11446a;
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
            f11446a = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11446a[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11446a[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11446a[HEADERTYPE.Common_STYLE_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11446a[HEADERTYPE.SWAN_APP_HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
        z = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, d.a.o0.a.z1.a.d.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, headertype};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f11432e = HEADERTYPE.Common_STYLE_HEADER;
        this.f11433f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.v = -1;
        this.x = -1;
        this.y = aVar;
        this.f11432e = headertype;
        m(context, null);
    }

    private boolean getNgWebViewHeightSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            d.a.o0.a.c1.a.Z().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z2) == null) {
            this.o = z2;
        }
    }

    public void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
                H(0, 0);
                LoadingLayout loadingLayout = this.f11435h;
                if (loadingLayout != null) {
                    loadingLayout.e(0);
                }
            } else if (this.v <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.v) {
                G(0, -((int) f2));
                LoadingLayout loadingLayout2 = this.f11435h;
                if (loadingLayout2 != null) {
                    loadingLayout2.e(-getScrollY());
                    if (this.j != 0) {
                        this.f11435h.d(Math.abs(getScrollYValue()) / this.j);
                    }
                }
                int abs = Math.abs(getScrollYValue());
                if (!r() || s()) {
                    return;
                }
                LoadingLayout loadingLayout3 = this.f11435h;
                if (loadingLayout3 != null && abs > loadingLayout3.getCanRefreshPullLength()) {
                    this.r = ILoadingLayout$State.RELEASE_TO_REFRESH;
                } else {
                    this.r = ILoadingLayout$State.PULL_TO_REFRESH;
                }
                LoadingLayout loadingLayout4 = this.f11435h;
                if (loadingLayout4 != null) {
                    loadingLayout4.setState(this.r);
                }
                y(this.r, true);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LoadingLayout loadingLayout = this.f11435h;
            int contentSize = loadingLayout != null ? loadingLayout.getContentSize() : 0;
            LoadingLayout loadingLayout2 = this.f11436i;
            int contentSize2 = loadingLayout2 != null ? loadingLayout2.getContentSize() : 0;
            if (contentSize < 0) {
                contentSize = 0;
            }
            if (contentSize2 < 0) {
                contentSize2 = 0;
            }
            this.j = contentSize;
            this.k = contentSize2;
            LoadingLayout loadingLayout3 = this.f11435h;
            int measuredHeight = loadingLayout3 != null ? loadingLayout3.getMeasuredHeight() : 0;
            LoadingLayout loadingLayout4 = this.f11436i;
            int measuredHeight2 = loadingLayout4 != null ? loadingLayout4.getMeasuredHeight() : 0;
            if (measuredHeight2 == 0) {
                measuredHeight2 = this.k;
            }
            setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
        }
    }

    public void C(int i2, int i3) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (frameLayout = this.u) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        if (layoutParams.height != i3) {
            layoutParams.height = i3;
            this.u.requestLayout();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean q = q();
            if (q && abs <= this.k) {
                I(0);
            } else if (q) {
                I(this.k);
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
            if (s && abs <= this.f11435h.getRefreshingHeight()) {
                I(0);
            } else if (s) {
                I(-this.f11435h.getRefreshingHeight());
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

    public final void G(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            scrollBy(i2, i3);
        }
    }

    public final void H(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            scrollTo(i2, i3);
        }
    }

    public final void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            J(i2, getSmoothScrollDuration());
        }
    }

    public final void J(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.w.forceFinished(true);
            int scrollY = getScrollY();
            int i4 = i2 - scrollY;
            if (i4 != 0) {
                this.w.startScroll(0, scrollY, 0, i4, i3);
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
        this.s = iLoadingLayout$State;
        y(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.f11436i;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.f11434g != null) {
            postDelayed(new f(this), getSmoothScrollDuration());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            M(true);
        }
    }

    public final void M(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) || s()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.r = iLoadingLayout$State;
        y(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f11435h;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (!z2 || this.f11434g == null) {
            return;
        }
        postDelayed(new e(this), getSmoothScrollDuration());
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.w.computeScrollOffset()) {
            int currY = this.w.getCurrY();
            scrollTo(0, currY);
            this.f11435h.e(-currY);
            this.f11436i.d(Math.abs(getScrollYValue()) / this.k);
            postInvalidate();
        }
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LoadingLayout loadingLayout = this.f11435h;
            LoadingLayout loadingLayout2 = this.f11436i;
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
            this.u = frameLayout;
            frameLayout.addView(t, -1, -1);
            addView(this.u, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f11436i : (LoadingLayout) invokeV.objValue;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f11435h : (LoadingLayout) invokeV.objValue;
    }

    public d.a.o0.a.z1.a.d.a<T> getRefreshableFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.y : (d.a.o0.a.z1.a.d.a) invokeV.objValue;
    }

    public T getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.t : (T) invokeV.objValue;
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
            int i2 = g.f11446a[this.f11432e.ordinal()];
            if (i2 == 1) {
                headerLoadingLayout = new HeaderLoadingLayout(context);
            } else if (i2 == 2) {
                headerLoadingLayout = new BigBgHeaderLoadingLayout(context);
            } else if (i2 == 3) {
                headerLoadingLayout = new RotateLoadingLayout(context);
            } else if (i2 != 4) {
                headerLoadingLayout = i2 != 5 ? null : new NeutralHeaderLoadingLayout(context);
            } else {
                headerLoadingLayout = new CommonHeaderLoadingLayout(context);
            }
            return headerLoadingLayout == null ? new HeaderLoadingLayout(context) : headerLoadingLayout;
        }
        return (LoadingLayout) invokeLL.objValue;
    }

    public abstract T j(Context context, AttributeSet attributeSet);

    public void k(boolean z2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            l(z2, j, null);
        }
    }

    public void l(boolean z2, long j, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z2), Long.valueOf(j), runnable}) == null) {
            postDelayed(new d(this, z2, runnable), j);
        }
    }

    public final void m(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, context, attributeSet) == null) {
            this.w = new Scroller(context);
            super.setOrientation(1);
            this.q = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f11435h = i(context, attributeSet);
            this.f11436i = h(context, attributeSet);
            T j = j(context, attributeSet);
            this.t = j;
            if (z && j == null) {
                throw new NullPointerException("Refreshable view can not be null.");
            }
            T t = this.t;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.o : invokeV.booleanValue;
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
            boolean z2 = false;
            if (n()) {
                if (p() || r()) {
                    int action = motionEvent.getAction();
                    if (action != 3) {
                        if (action != 1) {
                            if (action == 0 || !this.p) {
                                int actionIndex = motionEvent.getActionIndex();
                                if (action == 0) {
                                    this.x = motionEvent.getPointerId(actionIndex);
                                    this.f11433f = motionEvent.getY();
                                    this.p = false;
                                } else if (action == 2) {
                                    int findPointerIndex = motionEvent.findPointerIndex(this.x);
                                    if (findPointerIndex < 0) {
                                        this.p = false;
                                        return false;
                                    }
                                    float y = motionEvent.getY(findPointerIndex) - this.f11433f;
                                    if (Math.abs(y) > this.q || s() || q()) {
                                        this.f11433f = motionEvent.getY(findPointerIndex);
                                        if (r() && t()) {
                                            z2 = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                            this.p = z2;
                                            if (z2 && o() && (t = this.t) != null) {
                                                t.onTouchEvent(motionEvent);
                                            }
                                        } else if (p() && u()) {
                                            this.p = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                                        }
                                    }
                                } else if (action == 5) {
                                    this.x = motionEvent.getPointerId(actionIndex);
                                    this.f11433f = motionEvent.getY(actionIndex);
                                    this.p = false;
                                } else if (action == 6) {
                                    int action2 = (motionEvent.getAction() & 65280) >> 8;
                                    if (motionEvent.getPointerId(action2) == this.x) {
                                        int i2 = action2 != 0 ? 0 : 1;
                                        this.x = motionEvent.getPointerId(i2);
                                        this.f11433f = (int) motionEvent.getY(i2);
                                        this.p = false;
                                    }
                                }
                                return this.p;
                            }
                            return true;
                        }
                    }
                    this.p = false;
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048607, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048608, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            B();
            C(i2, i3);
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
            boolean z2 = false;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.x);
                        if (findPointerIndex < 0) {
                            this.p = false;
                            return false;
                        }
                        float y = motionEvent.getY(findPointerIndex) - this.f11433f;
                        this.f11433f = motionEvent.getY(findPointerIndex);
                        if (r() && t()) {
                            A(y / 1.5f);
                        } else if (p() && u()) {
                            z(y / 1.5f);
                        } else {
                            this.p = false;
                            return false;
                        }
                        return true;
                    } else if (action != 3) {
                        if (action == 5) {
                            this.x = motionEvent.getPointerId(actionIndex);
                            this.f11433f = motionEvent.getY(actionIndex);
                            return false;
                        } else if (action != 6) {
                            return false;
                        } else {
                            int action2 = (motionEvent.getAction() & 65280) >> 8;
                            if (motionEvent.getPointerId(action2) == this.x) {
                                int i2 = action2 != 0 ? 0 : 1;
                                this.x = motionEvent.getPointerId(i2);
                                this.f11433f = (int) motionEvent.getY(i2);
                                return false;
                            }
                            return false;
                        }
                    }
                }
                if (this.p) {
                    this.p = false;
                    if (t()) {
                        if (this.l && this.r == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            L();
                            z2 = true;
                        } else if (!s()) {
                            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
                            this.r = iLoadingLayout$State;
                            y(iLoadingLayout$State, true);
                        }
                        E();
                        return z2;
                    } else if (u()) {
                        if (p() && this.s == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            K();
                            z2 = true;
                        }
                        D();
                        return z2;
                    } else {
                        return false;
                    }
                }
                return false;
            }
            this.x = motionEvent.getPointerId(actionIndex);
            this.f11433f = motionEvent.getY();
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.m && this.f11436i != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.s == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.l && this.f11435h != null : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z2);
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.r == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public void setEmptyView(View view) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, view) == null) || (frameLayout = this.u) == null) {
            return;
        }
        frameLayout.addView(view, -1, -1);
    }

    public void setHeaderBackgroundColor(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i2) == null) || (loadingLayout = this.f11435h) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundColor(getResources().getColor(i2));
    }

    public void setHeaderBackgroundResource(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i2) == null) || (loadingLayout = this.f11435h) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundResource(i2);
    }

    public void setHeaderBigBackground(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || (loadingLayout = this.f11435h) == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i2);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, charSequence) == null) {
            LoadingLayout loadingLayout = this.f11435h;
            if (loadingLayout != null) {
                loadingLayout.setLastUpdatedLabel(charSequence);
            }
            LoadingLayout loadingLayout2 = this.f11436i;
            if (loadingLayout2 != null) {
                loadingLayout2.setLastUpdatedLabel(charSequence);
            }
        }
    }

    public void setMaxPullOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.v = i2;
        }
    }

    public void setOnRefreshListener(h<T> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, hVar) == null) {
            this.f11434g = hVar;
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
        }
    }

    public void setPullLoadEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) {
            this.m = z2;
        }
    }

    public void setPullRefreshEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z2) == null) {
            this.l = z2;
        }
    }

    public void setScrollLoadEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            this.n = z2;
        }
    }

    public abstract boolean t();

    public abstract boolean u();

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void w(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            x(z2, null);
        }
    }

    public void x(boolean z2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048630, this, z2, str) == null) && s()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
            this.r = iLoadingLayout$State;
            y(iLoadingLayout$State, true);
            setInterceptTouchEventEnabled(false);
            this.f11435h.f(z2, str, new c(this));
        }
    }

    public void y(ILoadingLayout$State iLoadingLayout$State, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, iLoadingLayout$State, z2) == null) {
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
            if (this.f11436i != null && this.k != 0) {
                this.f11436i.d(Math.abs(getScrollYValue()) / this.k);
            }
            int abs = Math.abs(getScrollYValue());
            if (!p() || q()) {
                return;
            }
            if (abs > this.k) {
                this.s = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.s = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout = this.f11436i;
            if (loadingLayout != null) {
                loadingLayout.setState(this.s);
            }
            y(this.s, false);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11432e = HEADERTYPE.Common_STYLE_HEADER;
        this.f11433f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.v = -1;
        this.x = -1;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f11432e = HEADERTYPE.Common_STYLE_HEADER;
        this.f11433f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.v = -1;
        this.x = -1;
        m(context, attributeSet);
    }
}
