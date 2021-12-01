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
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f39871e;

    /* renamed from: f  reason: collision with root package name */
    public j<T> f39872f;

    /* renamed from: g  reason: collision with root package name */
    public LoadingLayout f39873g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout f39874h;

    /* renamed from: i  reason: collision with root package name */
    public int f39875i;

    /* renamed from: j  reason: collision with root package name */
    public int f39876j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f39877k;
    public boolean l;
    public boolean m;
    public HEADERTYPE mHeaderType;
    public T mRefreshableView;
    public boolean n;
    public boolean o;
    public int p;
    public ILoadingLayout$State q;
    public ILoadingLayout$State r;
    public FrameLayout s;
    public int t;
    public Scroller u;
    public int v;
    public c.a.p0.a.c2.a.d.a<T> w;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f39878e;

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
            this.f39878e = pullToRefreshBase;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39878e.j();
                this.f39878e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f39879e;

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
            this.f39879e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39879e.requestLayout();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f39880e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f39881e;

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
                this.f39881e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f39881e.f39880e.setInterceptTouchEventEnabled(true);
                    this.f39881e.f39880e.f39873g.setState(ILoadingLayout$State.RESET);
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
            this.f39880e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39880e.postDelayed(new a(this), this.f39880e.getSmoothScrollDuration());
                this.f39880e.resetHeaderLayout();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f39882e;

        public d(PullToRefreshBase pullToRefreshBase) {
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
            this.f39882e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39882e.setInterceptTouchEventEnabled(true);
                this.f39882e.f39874h.setState(ILoadingLayout$State.RESET);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f39883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f39884f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f39885g;

        public e(PullToRefreshBase pullToRefreshBase, boolean z, Runnable runnable) {
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
            this.f39885g = pullToRefreshBase;
            this.f39883e = z;
            this.f39884f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = -this.f39885g.f39873g.getRefreshingHeight();
                int i3 = this.f39883e ? 300 : 0;
                this.f39885g.startRefreshing();
                this.f39885g.n(i2, i3);
                Runnable runnable = this.f39884f;
                if (runnable != null) {
                    this.f39885g.post(runnable);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f39886e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f39887f;

        public f(PullToRefreshBase pullToRefreshBase, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39887f = pullToRefreshBase;
            this.f39886e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = -this.f39887f.f39873g.getRefreshingHeight();
                int i3 = this.f39886e ? 300 : 0;
                this.f39887f.o(false);
                this.f39887f.n(i2, i3);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f39888e;

        public g(PullToRefreshBase pullToRefreshBase) {
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
            this.f39888e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39888e.f39872f.b(this.f39888e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f39889e;

        public h(PullToRefreshBase pullToRefreshBase) {
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
            this.f39889e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39889e.f39872f.a(this.f39889e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class i {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323549602, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBase$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(323549602, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBase$i;");
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

    /* loaded from: classes9.dex */
    public interface j<V extends View> {
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
        x = k.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, c.a.p0.a.c2.a.d.a<T> aVar) {
        this(context, aVar, HEADERTYPE.Common_STYLE_HEADER);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (c.a.p0.a.c2.a.d.a) objArr2[1], (HEADERTYPE) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    private boolean getNgWebViewHeightSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            c.a.p0.a.c1.a.g0().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, this, z) == null) {
            this.n = z;
        }
    }

    public void addHeaderAndFooter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LoadingLayout loadingLayout = this.f39873g;
            LoadingLayout loadingLayout2 = this.f39874h;
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

    public void addRefreshableView(Context context, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, t) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.s = frameLayout;
            frameLayout.addView(t, -1, -1);
            addView(this.s, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.u.computeScrollOffset()) {
            int currY = this.u.getCurrY();
            scrollTo(0, currY);
            this.f39873g.onPullLength(-currY);
            this.f39874h.onPull(Math.abs(getScrollYValue()) / this.f39876j);
            postInvalidate();
        }
    }

    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, attributeSet)) == null) ? new FooterLoadingLayout(context) : (LoadingLayout) invokeLL.objValue;
    }

    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        LoadingLayout headerLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, attributeSet)) == null) {
            setHeaderType();
            int i2 = i.a[this.mHeaderType.ordinal()];
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

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public void doPullRefreshing(boolean z, long j2, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), runnable}) == null) {
            postDelayed(new e(this, z, runnable), j2);
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39874h : (LoadingLayout) invokeV.objValue;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39873g : (LoadingLayout) invokeV.objValue;
    }

    public c.a.p0.a.c2.a.d.a<T> getRefreshableFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.w : (c.a.p0.a.c2.a.d.a) invokeV.objValue;
    }

    public T getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRefreshableView : (T) invokeV.objValue;
    }

    public int getScrollYValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? getScrollY() : invokeV.intValue;
    }

    public int getSmoothScrollDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 300;
        }
        return invokeV.intValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void h(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, attributeSet) == null) {
            this.u = new Scroller(context);
            super.setOrientation(1);
            this.p = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f39873g = createHeaderLoadingLayout(context, attributeSet);
            this.f39874h = createFooterLoadingLayout(context, attributeSet);
            T createRefreshableView = createRefreshableView(context, attributeSet);
            this.mRefreshableView = createRefreshableView;
            if (x && createRefreshableView == null) {
                throw new NullPointerException("Refreshable view can not be null.");
            }
            T t = this.mRefreshableView;
            if (t != null) {
                addRefreshableView(context, t);
            }
            addHeaderAndFooter(context);
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean isNeedTransferEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPullDownIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ILoadingLayout$State iLoadingLayout$State = this.q;
            return iLoadingLayout$State == ILoadingLayout$State.NONE || iLoadingLayout$State == ILoadingLayout$State.RESET;
        }
        return invokeV.booleanValue;
    }

    public boolean isPullLoadEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l && this.f39874h != null : invokeV.booleanValue;
    }

    public boolean isPullLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.r == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public boolean isPullRefreshEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f39877k && this.f39873g != null : invokeV.booleanValue;
    }

    public boolean isPullRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.q == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public abstract boolean isReadyForPullDown();

    public abstract boolean isReadyForPullUp();

    public boolean isScrollLoadEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LoadingLayout loadingLayout = this.f39873g;
            int contentSize = loadingLayout != null ? loadingLayout.getContentSize() : 0;
            LoadingLayout loadingLayout2 = this.f39874h;
            int contentSize2 = loadingLayout2 != null ? loadingLayout2.getContentSize() : 0;
            if (contentSize < 0) {
                contentSize = 0;
            }
            if (contentSize2 < 0) {
                contentSize2 = 0;
            }
            this.f39875i = contentSize;
            this.f39876j = contentSize2;
            LoadingLayout loadingLayout3 = this.f39873g;
            int measuredHeight = loadingLayout3 != null ? loadingLayout3.getMeasuredHeight() : 0;
            LoadingLayout loadingLayout4 = this.f39874h;
            int measuredHeight2 = loadingLayout4 != null ? loadingLayout4.getMeasuredHeight() : 0;
            if (measuredHeight2 == 0) {
                measuredHeight2 = this.f39876j;
            }
            setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
        }
    }

    public final void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) {
            scrollBy(i2, i3);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
            scrollTo(i2, i3);
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            n(i2, getSmoothScrollDuration());
        }
    }

    public final void n(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) {
            this.u.forceFinished(true);
            int scrollY = getScrollY();
            int i4 = i2 - scrollY;
            if (i4 != 0) {
                this.u.startScroll(0, scrollY, 0, i4, i3);
                postInvalidate();
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || isPullRefreshing()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.q = iLoadingLayout$State;
        onStateChanged(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f39873g;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (!z || this.f39872f == null) {
            return;
        }
        postDelayed(new g(this), getSmoothScrollDuration());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            boolean z = false;
            if (i()) {
                if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                    int action = motionEvent.getAction();
                    if (action != 3) {
                        if (action != 1) {
                            if (action == 0 || !this.o) {
                                int actionIndex = motionEvent.getActionIndex();
                                if (action == 0) {
                                    this.v = motionEvent.getPointerId(actionIndex);
                                    this.f39871e = motionEvent.getY();
                                    this.o = false;
                                } else if (action == 2) {
                                    int findPointerIndex = motionEvent.findPointerIndex(this.v);
                                    if (findPointerIndex < 0) {
                                        this.o = false;
                                        return false;
                                    }
                                    float y = motionEvent.getY(findPointerIndex) - this.f39871e;
                                    if (Math.abs(y) > this.p || isPullRefreshing() || isPullLoading()) {
                                        this.f39871e = motionEvent.getY(findPointerIndex);
                                        if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                            z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                            this.o = z;
                                            if (z && isNeedTransferEvent() && (t = this.mRefreshableView) != null) {
                                                t.onTouchEvent(motionEvent);
                                            }
                                        } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                            this.o = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                                        }
                                    }
                                } else if (action == 5) {
                                    this.v = motionEvent.getPointerId(actionIndex);
                                    this.f39871e = motionEvent.getY(actionIndex);
                                    this.o = false;
                                } else if (action == 6) {
                                    int action2 = (motionEvent.getAction() & 65280) >> 8;
                                    if (motionEvent.getPointerId(action2) == this.v) {
                                        int i2 = action2 != 0 ? 0 : 1;
                                        this.v = motionEvent.getPointerId(i2);
                                        this.f39871e = (int) motionEvent.getY(i2);
                                        this.o = false;
                                    }
                                }
                                return this.o;
                            }
                            return true;
                        }
                    }
                    this.o = false;
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
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    @Deprecated
    public void onPullDownRefreshComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            onPullDownRefreshComplete(false);
        }
    }

    public void onPullUpRefreshComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && isPullLoading()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
            this.r = iLoadingLayout$State;
            onStateChanged(iLoadingLayout$State, false);
            postDelayed(new d(this), getSmoothScrollDuration());
            resetFooterLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048613, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            j();
            refreshRefreshableViewSize(i2, i3);
            post(new b(this));
        }
    }

    public void onStateChanged(ILoadingLayout$State iLoadingLayout$State, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048614, this, iLoadingLayout$State, z) == null) {
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, motionEvent)) == null) {
            int actionIndex = motionEvent.getActionIndex();
            int action = motionEvent.getAction();
            boolean z = false;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.v);
                        if (findPointerIndex < 0) {
                            this.o = false;
                            return false;
                        }
                        float y = motionEvent.getY(findPointerIndex) - this.f39871e;
                        this.f39871e = motionEvent.getY(findPointerIndex);
                        if (isPullRefreshEnabled() && isReadyForPullDown()) {
                            pullHeaderLayout(y / 1.5f);
                        } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                            pullFooterLayout(y / 1.5f);
                        } else {
                            this.o = false;
                            return false;
                        }
                        return true;
                    } else if (action != 3) {
                        if (action == 5) {
                            this.v = motionEvent.getPointerId(actionIndex);
                            this.f39871e = motionEvent.getY(actionIndex);
                            return false;
                        } else if (action != 6) {
                            return false;
                        } else {
                            int action2 = (motionEvent.getAction() & 65280) >> 8;
                            if (motionEvent.getPointerId(action2) == this.v) {
                                int i2 = action2 != 0 ? 0 : 1;
                                this.v = motionEvent.getPointerId(i2);
                                this.f39871e = (int) motionEvent.getY(i2);
                                return false;
                            }
                            return false;
                        }
                    }
                }
                if (this.o) {
                    this.o = false;
                    if (isReadyForPullDown()) {
                        if (this.f39877k && this.q == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
                            this.q = iLoadingLayout$State;
                            onStateChanged(iLoadingLayout$State, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.r == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            startLoading();
                            z = true;
                        }
                        resetFooterLayout();
                        return z;
                    } else {
                        return false;
                    }
                }
                return false;
            }
            this.v = motionEvent.getPointerId(actionIndex);
            this.f39871e = motionEvent.getY();
            return false;
        }
        return invokeL.booleanValue;
    }

    public void pullFooterLayout(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048616, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
                l(0, 0);
                return;
            }
            k(0, -((int) f2));
            if (this.f39874h != null && this.f39876j != 0) {
                this.f39874h.onPull(Math.abs(getScrollYValue()) / this.f39876j);
            }
            int abs = Math.abs(getScrollYValue());
            if (!isPullLoadEnabled() || isPullLoading()) {
                return;
            }
            if (abs > this.f39876j) {
                this.r = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.r = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout = this.f39874h;
            if (loadingLayout != null) {
                loadingLayout.setState(this.r);
            }
            onStateChanged(this.r, false);
        }
    }

    public void pullHeaderLayout(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
                l(0, 0);
                LoadingLayout loadingLayout = this.f39873g;
                if (loadingLayout != null) {
                    loadingLayout.onPullLength(0);
                }
            } else if (this.t <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.t) {
                k(0, -((int) f2));
                LoadingLayout loadingLayout2 = this.f39873g;
                if (loadingLayout2 != null) {
                    loadingLayout2.onPullLength(-getScrollY());
                    if (this.f39875i != 0) {
                        this.f39873g.onPull(Math.abs(getScrollYValue()) / this.f39875i);
                    }
                }
                int abs = Math.abs(getScrollYValue());
                if (!isPullRefreshEnabled() || isPullRefreshing()) {
                    return;
                }
                LoadingLayout loadingLayout3 = this.f39873g;
                if (loadingLayout3 != null && abs > loadingLayout3.getCanRefreshPullLength()) {
                    this.q = ILoadingLayout$State.RELEASE_TO_REFRESH;
                } else {
                    this.q = ILoadingLayout$State.PULL_TO_REFRESH;
                }
                LoadingLayout loadingLayout4 = this.f39873g;
                if (loadingLayout4 != null) {
                    loadingLayout4.setState(this.q);
                }
                onStateChanged(this.q, true);
            }
        }
    }

    public void refreshRefreshableViewSize(int i2, int i3) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048618, this, i2, i3) == null) || (frameLayout = this.s) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        if (layoutParams.height != i3) {
            layoutParams.height = i3;
            this.s.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public void resetFooterLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean isPullLoading = isPullLoading();
            if (isPullLoading && abs <= this.f39876j) {
                m(0);
            } else if (isPullLoading) {
                m(this.f39876j);
            } else {
                m(0);
            }
        }
    }

    public void resetHeaderLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean isPullRefreshing = isPullRefreshing();
            if (isPullRefreshing && abs <= this.f39873g.getRefreshingHeight()) {
                m(0);
            } else if (isPullRefreshing) {
                m(-this.f39873g.getRefreshingHeight());
            } else {
                m(0);
            }
        }
    }

    public void setEmptyView(View view) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, view) == null) || (frameLayout = this.s) == null) {
            return;
        }
        frameLayout.addView(view, -1, -1);
    }

    public void setHeaderBackgroundColor(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048623, this, i2) == null) || (loadingLayout = this.f39873g) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundColor(getResources().getColor(i2));
    }

    public void setHeaderBackgroundResource(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (loadingLayout = this.f39873g) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundResource(i2);
    }

    public void setHeaderBigBackground(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (loadingLayout = this.f39873g) == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i2);
    }

    public void setHeaderType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, charSequence) == null) {
            LoadingLayout loadingLayout = this.f39873g;
            if (loadingLayout != null) {
                loadingLayout.setLastUpdatedLabel(charSequence);
            }
            LoadingLayout loadingLayout2 = this.f39874h;
            if (loadingLayout2 != null) {
                loadingLayout2.setLastUpdatedLabel(charSequence);
            }
        }
    }

    public void setMaxPullOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.t = i2;
        }
    }

    public void setOnRefreshListener(j<T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, jVar) == null) {
            this.f39872f = jVar;
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
        }
    }

    public void setPullLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.l = z;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.f39877k = z;
        }
    }

    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.m = z;
        }
    }

    public void showPullRefreshing(boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            postDelayed(new f(this, z), j2);
        }
    }

    public void startLoading() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || isPullLoading()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.r = iLoadingLayout$State;
        onStateChanged(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.f39874h;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.f39872f != null) {
            postDelayed(new h(this), getSmoothScrollDuration());
        }
    }

    public void startRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            o(true);
        }
    }

    public void superRequestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, c.a.p0.a.c2.a.d.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, headertype};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mHeaderType = HEADERTYPE.Common_STYLE_HEADER;
        this.f39871e = -1.0f;
        this.f39877k = true;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.q = iLoadingLayout$State;
        this.r = iLoadingLayout$State;
        this.t = -1;
        this.v = -1;
        this.w = aVar;
        this.mHeaderType = headertype;
        h(context, null);
    }

    public void doPullRefreshing(boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            doPullRefreshing(z, j2, null);
        }
    }

    public void onPullDownRefreshComplete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            onPullDownRefreshComplete(z, null);
        }
    }

    public void onPullDownRefreshComplete(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048611, this, z, str) == null) && isPullRefreshing()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
            this.q = iLoadingLayout$State;
            onStateChanged(iLoadingLayout$State, true);
            setInterceptTouchEventEnabled(false);
            this.f39873g.onPullRefreshComplete(z, str, new c(this));
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
        this.mHeaderType = HEADERTYPE.Common_STYLE_HEADER;
        this.f39871e = -1.0f;
        this.f39877k = true;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.q = iLoadingLayout$State;
        this.r = iLoadingLayout$State;
        this.t = -1;
        this.v = -1;
        h(context, null);
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
        this.mHeaderType = HEADERTYPE.Common_STYLE_HEADER;
        this.f39871e = -1.0f;
        this.f39877k = true;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.q = iLoadingLayout$State;
        this.r = iLoadingLayout$State;
        this.t = -1;
        this.v = -1;
        h(context, attributeSet);
    }
}
