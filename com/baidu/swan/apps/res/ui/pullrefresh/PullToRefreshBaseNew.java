package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
/* loaded from: classes3.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.o0.a.z1.a.d.a<T> A;

    /* renamed from: e  reason: collision with root package name */
    public HEADERTYPE f11447e;

    /* renamed from: f  reason: collision with root package name */
    public float f11448f;

    /* renamed from: g  reason: collision with root package name */
    public float f11449g;

    /* renamed from: h  reason: collision with root package name */
    public e<T> f11450h;

    /* renamed from: i  reason: collision with root package name */
    public LoadingLayout f11451i;
    public LoadingLayout j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public ILoadingLayout$State r;
    public ILoadingLayout$State s;
    public T t;
    public PullToRefreshBaseNew<T>.f u;
    public FrameLayout v;
    public int w;
    public boolean x;
    public float y;
    public boolean z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class HEADERTYPE {
        public static final /* synthetic */ HEADERTYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HEADERTYPE BIG_BG_HEADER;
        public static final HEADERTYPE ROTATE_HEADER;
        public static final HEADERTYPE STANDARD_HEADER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1043251140, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBaseNew$HEADERTYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1043251140, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBaseNew$HEADERTYPE;");
                    return;
                }
            }
            STANDARD_HEADER = new HEADERTYPE("STANDARD_HEADER", 0);
            BIG_BG_HEADER = new HEADERTYPE("BIG_BG_HEADER", 1);
            HEADERTYPE headertype = new HEADERTYPE("ROTATE_HEADER", 2);
            ROTATE_HEADER = headertype;
            $VALUES = new HEADERTYPE[]{STANDARD_HEADER, BIG_BG_HEADER, headertype};
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
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f11452e;

        public a(PullToRefreshBaseNew pullToRefreshBaseNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11452e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11452e.f11450h.a(this.f11452e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f11453e;

        public b(PullToRefreshBaseNew pullToRefreshBaseNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11453e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11453e.f11450h.b(this.f11453e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f11454e;

        public c(PullToRefreshBaseNew pullToRefreshBaseNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11454e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11454e.f11450h.c(this.f11454e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11455a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2134830865, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBaseNew$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2134830865, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBaseNew$d;");
                    return;
                }
            }
            int[] iArr = new int[HEADERTYPE.values().length];
            f11455a = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11455a[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11455a[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e<V extends View> {
        void a(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void b(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void c(PullToRefreshBaseNew<V> pullToRefreshBaseNew);
    }

    /* loaded from: classes3.dex */
    public final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f11456e;

        /* renamed from: f  reason: collision with root package name */
        public final int f11457f;

        /* renamed from: g  reason: collision with root package name */
        public final int f11458g;

        /* renamed from: h  reason: collision with root package name */
        public final long f11459h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f11460i;
        public long j;
        public int k;
        public final /* synthetic */ PullToRefreshBaseNew l;

        public f(PullToRefreshBaseNew pullToRefreshBaseNew, int i2, int i3, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = pullToRefreshBaseNew;
            this.f11460i = true;
            this.j = -1L;
            this.k = -1;
            this.f11458g = i2;
            this.f11457f = i3;
            this.f11459h = j;
            this.f11456e = new DecelerateInterpolator();
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11460i = false;
                this.l.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f11459h <= 0) {
                    this.l.y(0, this.f11457f);
                    return;
                }
                if (this.j == -1) {
                    this.j = System.currentTimeMillis();
                } else {
                    int round = this.f11458g - Math.round((this.f11458g - this.f11457f) * this.f11456e.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.j) * 1000) / this.f11459h, 1000L), 0L)) / 1000.0f));
                    this.k = round;
                    this.l.y(0, round);
                }
                if (!this.f11460i || this.f11457f == this.k) {
                    return;
                }
                this.l.postDelayed(this, 16L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1441352367, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBaseNew;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1441352367, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBaseNew;");
                return;
            }
        }
        B = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBaseNew(Context context) {
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
        this.f11447e = HEADERTYPE.STANDARD_HEADER;
        this.f11448f = 2.5f;
        this.f11449g = -1.0f;
        this.m = true;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.w = -1;
        this.x = false;
        this.y = 1.0f;
        h(context, null);
    }

    private int getScrollYValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? getScrollY() : invokeV.intValue;
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) {
            this.o = z;
        }
    }

    public final void A(int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            PullToRefreshBaseNew<T>.f fVar = this.u;
            if (fVar != null) {
                fVar.a();
            }
            int scrollYValue = getScrollYValue();
            boolean z = scrollYValue != i2;
            if (z) {
                this.u = new f(this, scrollYValue, i2, j);
            }
            if (z) {
                if (j2 > 0) {
                    postDelayed(this.u, j2);
                } else {
                    post(this.u);
                }
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || m()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.s = iLoadingLayout$State;
        r(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.j;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.f11450h != null) {
            postDelayed(new c(this), getSmoothScrollDuration());
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            D(true);
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || o() || j()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.LONG_REFRESHING;
        this.r = iLoadingLayout$State;
        r(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f11451i;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.LONG_REFRESHING);
        }
        if (this.f11450h != null) {
            postDelayed(new b(this), getSmoothScrollDuration());
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            F(true);
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || o() || j()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.r = iLoadingLayout$State;
        r(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f11451i;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (!z || this.f11450h == null) {
            return;
        }
        postDelayed(new a(this), getSmoothScrollDuration());
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LoadingLayout loadingLayout = this.f11451i;
            LoadingLayout loadingLayout2 = this.j;
            if (loadingLayout != null) {
                if (this == loadingLayout.getParent()) {
                    removeView(loadingLayout);
                }
                addView(loadingLayout, 0, new FrameLayout.LayoutParams(-1, -2));
            }
            if (loadingLayout2 != null) {
                if (this == loadingLayout2.getParent()) {
                    removeView(loadingLayout2);
                }
                addView(loadingLayout2, -1, new FrameLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void d(Context context, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, t) == null) {
            addView(t, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public LoadingLayout e(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, attributeSet)) == null) ? new FooterLoadingLayout(context) : (LoadingLayout) invokeLL.objValue;
    }

    public LoadingLayout f(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        LoadingLayout headerLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, attributeSet)) == null) {
            w();
            int i2 = d.f11455a[this.f11447e.ordinal()];
            if (i2 == 1) {
                headerLoadingLayout = new HeaderLoadingLayout(context);
            } else if (i2 != 2) {
                headerLoadingLayout = i2 != 3 ? null : new RotateLoadingLayout(context);
            } else {
                headerLoadingLayout = new BigBgHeaderLoadingLayout(context);
            }
            return headerLoadingLayout == null ? new HeaderLoadingLayout(context) : headerLoadingLayout;
        }
        return (LoadingLayout) invokeLL.objValue;
    }

    public abstract T g(Context context, AttributeSet attributeSet);

    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : (LoadingLayout) invokeV.objValue;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f11451i : (LoadingLayout) invokeV.objValue;
    }

    public d.a.o0.a.z1.a.d.a<T> getRefreshableFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.A : (d.a.o0.a.z1.a.d.a) invokeV.objValue;
    }

    public T getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.t : (T) invokeV.objValue;
    }

    public long getSmoothScrollDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 150L;
        }
        return invokeV.longValue;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, attributeSet) == null) {
            this.q = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f11451i = f(context, attributeSet);
            this.j = e(context, attributeSet);
            T g2 = g(context, attributeSet);
            this.t = g2;
            if (B && g2 == null) {
                throw new NullPointerException("Refreshable view can not be null.");
            }
            T t = this.t;
            if (t != null) {
                d(context, t);
            }
            c(context);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.r == ILoadingLayout$State.LONG_REFRESHING : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n && this.j != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.s == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.m && this.f11451i != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.r == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            boolean z = false;
            if (i()) {
                if (l() || n()) {
                    int action = motionEvent.getAction();
                    if (action != 3 && action != 1) {
                        if (action == 0 || !this.p) {
                            if (action == 0) {
                                this.f11449g = motionEvent.getY();
                                this.p = false;
                            } else if (action == 2) {
                                float y = motionEvent.getY() - this.f11449g;
                                if (Math.abs(y) > this.q || o() || m() || j()) {
                                    this.f11449g = motionEvent.getY();
                                    if (n() && p()) {
                                        z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                        this.p = z;
                                        if (z && k() && (t = this.t) != null) {
                                            t.onTouchEvent(motionEvent);
                                        }
                                    } else if (l() && q()) {
                                        this.p = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                                    }
                                }
                            }
                            return this.p;
                        }
                        return true;
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

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            LoadingLayout loadingLayout = this.f11451i;
            if (loadingLayout != null) {
                loadingLayout.layout(loadingLayout.getLeft(), this.f11451i.getTop() - this.f11451i.getHeight(), this.f11451i.getRight(), this.f11451i.getBottom() - this.f11451i.getHeight());
                this.k = this.f11451i.getContentSize();
            }
            LoadingLayout loadingLayout2 = this.j;
            if (loadingLayout2 == null || this.t == null) {
                return;
            }
            loadingLayout2.layout(loadingLayout2.getLeft(), this.t.getBottom(), this.j.getRight(), this.t.getBottom() + this.j.getHeight());
            this.l = this.j.getContentSize();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float y = motionEvent.getY() - this.f11449g;
                        this.f11449g = motionEvent.getY();
                        if (n() && p()) {
                            t(y / this.f11448f);
                        } else if (l() && q()) {
                            s(y / this.f11448f);
                        } else {
                            this.p = false;
                            return false;
                        }
                        return true;
                    } else if (action != 3) {
                        return false;
                    }
                }
                if (this.p) {
                    this.p = false;
                    if (p()) {
                        if (this.m) {
                            ILoadingLayout$State iLoadingLayout$State = this.r;
                            if (iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                                E();
                                z = true;
                            } else if (this.x && iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_LONG_REFRESH) {
                                C();
                                z = true;
                                if (this.z) {
                                    return true;
                                }
                            }
                        } else {
                            ILoadingLayout$State iLoadingLayout$State2 = ILoadingLayout$State.RESET;
                            this.r = iLoadingLayout$State2;
                            r(iLoadingLayout$State2, true);
                        }
                        v();
                        return z;
                    } else if (q()) {
                        if (l() && this.s == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            B();
                            z = true;
                        }
                        u();
                        return z;
                    } else {
                        return false;
                    }
                }
                return false;
            }
            this.f11449g = motionEvent.getY();
            this.p = false;
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract boolean p();

    public abstract boolean q();

    public void r(ILoadingLayout$State iLoadingLayout$State, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, iLoadingLayout$State, z) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048608, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
                y(0, 0);
                return;
            }
            x(0, -((int) f2));
            if (this.j != null && this.l != 0) {
                this.j.d(Math.abs(getScrollYValue()) / this.l);
            }
            int abs = Math.abs(getScrollYValue());
            if (!l() || m()) {
                return;
            }
            if (abs > this.l) {
                this.s = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.s = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout = this.j;
            if (loadingLayout != null) {
                loadingLayout.setState(this.s);
            }
            r(this.s, false);
        }
    }

    public void setEmptyView(View view) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, view) == null) || (frameLayout = this.v) == null) {
            return;
        }
        frameLayout.addView(view, -1, -1);
    }

    public void setHeaderBackgroundColor(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || (loadingLayout = this.f11451i) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundColor(getResources().getColor(i2));
    }

    public void setHeaderBackgroundResource(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || (loadingLayout = this.f11451i) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundResource(i2);
    }

    public void setHeaderBigBackground(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048612, this, i2) == null) || (loadingLayout = this.f11451i) == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i2);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, charSequence) == null) {
            LoadingLayout loadingLayout = this.f11451i;
            if (loadingLayout != null) {
                loadingLayout.setLastUpdatedLabel(charSequence);
            }
            LoadingLayout loadingLayout2 = this.j;
            if (loadingLayout2 != null) {
                loadingLayout2.setLastUpdatedLabel(charSequence);
            }
        }
    }

    public void setListenParentScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.z = z;
        }
    }

    public void setLongPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.x = z;
        }
    }

    public void setMaxPullOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setOffsetRadio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            this.f11448f = f2;
        }
    }

    public void setOnRefreshListener(e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, eVar) == null) {
            this.f11450h = eVar;
        }
    }

    public void setPullLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.n = z;
        }
    }

    public void setPullRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f2) == null) {
            this.y = Math.max(f2, 1.0f);
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.m = z;
        }
    }

    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
        }
    }

    public void t(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048623, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
                y(0, 0);
            } else if (this.w <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.w) {
                x(0, -((int) f2));
                if (this.f11451i != null && this.k != 0) {
                    this.f11451i.d(Math.abs(getScrollYValue()) / this.k);
                }
                int abs = Math.abs(getScrollYValue());
                if (!n() || o() || j()) {
                    return;
                }
                if (this.x && abs > this.k * this.y * 2.0f) {
                    this.r = ILoadingLayout$State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.k * this.y) {
                    this.r = ILoadingLayout$State.RELEASE_TO_REFRESH;
                } else {
                    this.r = ILoadingLayout$State.PULL_TO_REFRESH;
                }
                LoadingLayout loadingLayout = this.f11451i;
                if (loadingLayout != null) {
                    loadingLayout.setState(this.r);
                }
                r(this.r, true);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean m = m();
            if (m && abs <= this.l) {
                z(0);
            } else if (m) {
                z(this.l);
            } else {
                z(0);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean o = o();
            boolean j = j();
            if ((o || j) && abs <= this.k) {
                z(0);
            } else if (!o && !j) {
                z(0);
            } else {
                z(-this.k);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    public final void x(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048627, this, i2, i3) == null) {
            scrollBy(i2, i3);
        }
    }

    public final void y(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i2, i3) == null) {
            scrollTo(i2, i3);
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            A(i2, getSmoothScrollDuration(), 0L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
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
        this.f11447e = HEADERTYPE.STANDARD_HEADER;
        this.f11448f = 2.5f;
        this.f11449g = -1.0f;
        this.m = true;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.w = -1;
        this.x = false;
        this.y = 1.0f;
        h(context, attributeSet);
    }
}
