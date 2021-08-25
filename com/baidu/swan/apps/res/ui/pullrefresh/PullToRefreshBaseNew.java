package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.a.z1.a.d.a<T> A;

    /* renamed from: e  reason: collision with root package name */
    public float f46270e;

    /* renamed from: f  reason: collision with root package name */
    public float f46271f;

    /* renamed from: g  reason: collision with root package name */
    public j<T> f46272g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout f46273h;

    /* renamed from: i  reason: collision with root package name */
    public LoadingLayout f46274i;

    /* renamed from: j  reason: collision with root package name */
    public int f46275j;
    public int k;
    public boolean l;
    public boolean m;
    public HEADERTYPE mHeaderType;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public ILoadingLayout$State r;
    public ILoadingLayout$State s;
    public T t;
    public PullToRefreshBaseNew<T>.k u;
    public FrameLayout v;
    public int w;
    public boolean x;
    public float y;
    public boolean z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f46276e;

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
            this.f46276e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46276e.setInterceptTouchEventEnabled(true);
                this.f46276e.f46273h.setState(ILoadingLayout$State.RESET);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f46277e;

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
            this.f46277e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46277e.setInterceptTouchEventEnabled(true);
                this.f46277e.f46273h.setState(ILoadingLayout$State.RESET);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f46278e;

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
            this.f46278e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46278e.setInterceptTouchEventEnabled(true);
                this.f46278e.f46274i.setState(ILoadingLayout$State.RESET);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46280f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f46281g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f46282h;

        public d(PullToRefreshBaseNew pullToRefreshBaseNew, boolean z, boolean z2, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew, Boolean.valueOf(z), Boolean.valueOf(z2), runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46282h = pullToRefreshBaseNew;
            this.f46279e = z;
            this.f46280f = z2;
            this.f46281g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46282h.startRefreshing();
                if (this.f46279e) {
                    this.f46282h.n(-this.f46282h.f46275j, this.f46280f ? 150 : 0, 0L);
                }
                Runnable runnable = this.f46281g;
                if (runnable != null) {
                    this.f46282h.post(runnable);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46283e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f46284f;

        public e(PullToRefreshBaseNew pullToRefreshBaseNew, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46284f = pullToRefreshBaseNew;
            this.f46283e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = -this.f46284f.f46275j;
                int i3 = this.f46283e ? 150 : 0;
                this.f46284f.p(false);
                this.f46284f.n(i2, i3, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f46285e;

        public f(PullToRefreshBaseNew pullToRefreshBaseNew) {
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
            this.f46285e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46285e.f46272g.a(this.f46285e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f46286e;

        public g(PullToRefreshBaseNew pullToRefreshBaseNew) {
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
            this.f46286e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46286e.f46272g.b(this.f46286e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBaseNew f46287e;

        public h(PullToRefreshBaseNew pullToRefreshBaseNew) {
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
            this.f46287e = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46287e.f46272g.c(this.f46287e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46288a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2134830710, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBaseNew$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2134830710, "Lcom/baidu/swan/apps/res/ui/pullrefresh/PullToRefreshBaseNew$i;");
                    return;
                }
            }
            int[] iArr = new int[HEADERTYPE.values().length];
            f46288a = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46288a[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46288a[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface j<V extends View> {
        void a(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void b(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void c(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void d(boolean z);
    }

    /* loaded from: classes6.dex */
    public final class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f46289e;

        /* renamed from: f  reason: collision with root package name */
        public final int f46290f;

        /* renamed from: g  reason: collision with root package name */
        public final int f46291g;

        /* renamed from: h  reason: collision with root package name */
        public final long f46292h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f46293i;

        /* renamed from: j  reason: collision with root package name */
        public long f46294j;
        public int k;
        public final /* synthetic */ PullToRefreshBaseNew l;

        public k(PullToRefreshBaseNew pullToRefreshBaseNew, int i2, int i3, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)};
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
            this.f46293i = true;
            this.f46294j = -1L;
            this.k = -1;
            this.f46291g = i2;
            this.f46290f = i3;
            this.f46292h = j2;
            this.f46289e = new DecelerateInterpolator();
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46293i = false;
                this.l.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f46292h <= 0) {
                    this.l.l(0, this.f46290f);
                    return;
                }
                if (this.f46294j == -1) {
                    this.f46294j = System.currentTimeMillis();
                } else {
                    int round = this.f46291g - Math.round((this.f46291g - this.f46290f) * this.f46289e.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f46294j) * 1000) / this.f46292h, 1000L), 0L)) / 1000.0f));
                    this.k = round;
                    this.l.l(0, round);
                }
                if (!this.f46293i || this.f46290f == this.k) {
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
        B = c.a.o0.a.k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBaseNew(Context context, c.a.o0.a.z1.a.d.a<T> aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
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
        this.mHeaderType = HEADERTYPE.STANDARD_HEADER;
        this.f46270e = 2.5f;
        this.f46271f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.w = -1;
        this.x = false;
        this.y = 1.0f;
        this.A = aVar;
        i(context, null);
    }

    private int getScrollYValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? getScrollY() : invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            this.o = z;
        }
    }

    public void addHeaderAndFooter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LoadingLayout loadingLayout = this.f46273h;
            LoadingLayout loadingLayout2 = this.f46274i;
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

    public void addRefreshableView(Context context, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, t) == null) {
            addView(t, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet)) == null) ? new FooterLoadingLayout(context) : (LoadingLayout) invokeLL.objValue;
    }

    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        LoadingLayout headerLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, attributeSet)) == null) {
            setHeaderType();
            int i2 = i.f46288a[this.mHeaderType.ordinal()];
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

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public void doPullRefreshing(boolean z, long j2, Runnable runnable, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), runnable, Boolean.valueOf(z2)}) == null) {
            postDelayed(new d(this, z2, z, runnable), j2);
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f46274i : (LoadingLayout) invokeV.objValue;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f46273h : (LoadingLayout) invokeV.objValue;
    }

    public c.a.o0.a.z1.a.d.a<T> getRefreshableFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A : (c.a.o0.a.z1.a.d.a) invokeV.objValue;
    }

    public T getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.t : (T) invokeV.objValue;
    }

    public long getSmoothScrollDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 150L;
        }
        return invokeV.longValue;
    }

    public final void i(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, attributeSet) == null) {
            this.q = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f46273h = createHeaderLoadingLayout(context, attributeSet);
            this.f46274i = createFooterLoadingLayout(context, attributeSet);
            T createRefreshableView = createRefreshableView(context, attributeSet);
            this.t = createRefreshableView;
            if (B && createRefreshableView == null) {
                throw new NullPointerException("Refreshable view can not be null.");
            }
            T t = this.t;
            if (t != null) {
                addRefreshableView(context, t);
            }
            addHeaderAndFooter(context);
        }
    }

    public boolean isLongPullRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.r == ILoadingLayout$State.LONG_REFRESHING : invokeV.booleanValue;
    }

    public boolean isNeedTransferEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPullDownIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ILoadingLayout$State iLoadingLayout$State = this.r;
            return iLoadingLayout$State == ILoadingLayout$State.NONE || iLoadingLayout$State == ILoadingLayout$State.RESET;
        }
        return invokeV.booleanValue;
    }

    public boolean isPullLoadEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m && this.f46274i != null : invokeV.booleanValue;
    }

    public boolean isPullLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.s == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public boolean isPullRefreshEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l && this.f46273h != null : invokeV.booleanValue;
    }

    public boolean isPullRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.r == ILoadingLayout$State.REFRESHING : invokeV.booleanValue;
    }

    public abstract boolean isReadyForPullDown();

    public abstract boolean isReadyForPullUp();

    public boolean isScrollLoadEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public final void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) {
            scrollBy(i2, i3);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) {
            scrollTo(i2, i3);
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            n(i2, getSmoothScrollDuration(), 0L);
        }
    }

    public final void n(int i2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            PullToRefreshBaseNew<T>.k kVar = this.u;
            if (kVar != null) {
                kVar.a();
            }
            int scrollYValue = getScrollYValue();
            boolean z = scrollYValue != i2;
            if (z) {
                this.u = new k(this, scrollYValue, i2, j2);
            }
            if (z) {
                if (j3 > 0) {
                    postDelayed(this.u, j3);
                } else {
                    post(this.u);
                }
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || isPullRefreshing() || isLongPullRefreshing()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.LONG_REFRESHING;
        this.r = iLoadingLayout$State;
        onStateChanged(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f46273h;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.LONG_REFRESHING);
        }
        if (this.f46272g != null) {
            postDelayed(new g(this), getSmoothScrollDuration());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            boolean z = false;
            if (j()) {
                if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                    int action = motionEvent.getAction();
                    if (action != 3 && action != 1) {
                        if (action == 0 || !this.p) {
                            if (action == 0) {
                                this.f46271f = motionEvent.getY();
                                this.p = false;
                            } else if (action == 2) {
                                float y = motionEvent.getY() - this.f46271f;
                                if (Math.abs(y) > this.q || isPullRefreshing() || isPullLoading() || isLongPullRefreshing()) {
                                    this.f46271f = motionEvent.getY();
                                    if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                        z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                        this.p = z;
                                        if (z && isNeedTransferEvent() && (t = this.t) != null) {
                                            t.onTouchEvent(motionEvent);
                                        }
                                    } else if (isPullLoadEnabled() && isReadyForPullUp()) {
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
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            LoadingLayout loadingLayout = this.f46273h;
            if (loadingLayout != null) {
                loadingLayout.layout(loadingLayout.getLeft(), this.f46273h.getTop() - this.f46273h.getHeight(), this.f46273h.getRight(), this.f46273h.getBottom() - this.f46273h.getHeight());
                this.f46275j = this.f46273h.getContentSize();
            }
            LoadingLayout loadingLayout2 = this.f46274i;
            if (loadingLayout2 == null || this.t == null) {
                return;
            }
            loadingLayout2.layout(loadingLayout2.getLeft(), this.t.getBottom(), this.f46274i.getRight(), this.t.getBottom() + this.f46274i.getHeight());
            this.k = this.f46274i.getContentSize();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void onParentScrollChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) && this.z) {
            int scrollYValue = getScrollYValue();
            if (scrollYValue < 0) {
                k(0, i2 - i3);
            } else if (scrollYValue > 0) {
                l(0, 0);
            }
            if (i3 != 0 || getScrollYValue() == 0) {
                return;
            }
            m(0);
        }
    }

    public void onPullDownLongRefreshComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && isLongPullRefreshing()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
            this.r = iLoadingLayout$State;
            onStateChanged(iLoadingLayout$State, true);
            postDelayed(new b(this), getSmoothScrollDuration());
            if (!this.z) {
                resetHeaderLayout();
            }
            setInterceptTouchEventEnabled(false);
        }
    }

    public void onPullDownRefreshComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (isPullRefreshing()) {
                ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
                this.r = iLoadingLayout$State;
                onStateChanged(iLoadingLayout$State, true);
                postDelayed(new a(this), getSmoothScrollDuration());
                resetHeaderLayout();
                setInterceptTouchEventEnabled(false);
            }
            j<T> jVar = this.f46272g;
            if (jVar != null) {
                jVar.d(true);
            }
        }
    }

    public void onPullUpRefreshComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && isPullLoading()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
            this.s = iLoadingLayout$State;
            onStateChanged(iLoadingLayout$State, false);
            postDelayed(new c(this), getSmoothScrollDuration());
            resetFooterLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    public void onStateChanged(ILoadingLayout$State iLoadingLayout$State, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048613, this, iLoadingLayout$State, z) == null) {
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float y = motionEvent.getY() - this.f46271f;
                        this.f46271f = motionEvent.getY();
                        if (isPullRefreshEnabled() && isReadyForPullDown()) {
                            pullHeaderLayout(y / this.f46270e);
                        } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                            pullFooterLayout(y / this.f46270e);
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
                    if (isReadyForPullDown()) {
                        if (this.l) {
                            ILoadingLayout$State iLoadingLayout$State = this.r;
                            if (iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                                z = true;
                            } else if (this.x && iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_LONG_REFRESH) {
                                startLongRefreshing();
                                z = true;
                                if (this.z) {
                                    return true;
                                }
                            }
                        } else {
                            ILoadingLayout$State iLoadingLayout$State2 = ILoadingLayout$State.RESET;
                            this.r = iLoadingLayout$State2;
                            onStateChanged(iLoadingLayout$State2, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.s == ILoadingLayout$State.RELEASE_TO_REFRESH) {
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
            this.f46271f = motionEvent.getY();
            this.p = false;
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || isPullRefreshing() || isLongPullRefreshing()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.r = iLoadingLayout$State;
        onStateChanged(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f46273h;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (!z || this.f46272g == null) {
            return;
        }
        postDelayed(new f(this), getSmoothScrollDuration());
    }

    public void pullDownWithoutAnim(boolean z) {
        j<T> jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            p(false);
            int scrollY = getScrollY();
            int i2 = this.f46275j;
            if (scrollY != (-i2)) {
                l(0, -i2);
            }
            if (!z || (jVar = this.f46272g) == null) {
                return;
            }
            jVar.c(this);
        }
    }

    public void pullFooterLayout(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
                l(0, 0);
                return;
            }
            k(0, -((int) f2));
            if (this.f46274i != null && this.k != 0) {
                this.f46274i.onPull(Math.abs(getScrollYValue()) / this.k);
            }
            int abs = Math.abs(getScrollYValue());
            if (!isPullLoadEnabled() || isPullLoading()) {
                return;
            }
            if (abs > this.k) {
                this.s = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.s = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout = this.f46274i;
            if (loadingLayout != null) {
                loadingLayout.setState(this.s);
            }
            onStateChanged(this.s, false);
        }
    }

    public void pullHeaderLayout(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
                l(0, 0);
            } else if (this.w <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.w) {
                k(0, -((int) f2));
                if (this.f46273h != null && this.f46275j != 0) {
                    this.f46273h.onPull(Math.abs(getScrollYValue()) / this.f46275j);
                }
                int abs = Math.abs(getScrollYValue());
                if (!isPullRefreshEnabled() || isPullRefreshing() || isLongPullRefreshing()) {
                    return;
                }
                if (this.x && abs > this.f46275j * this.y * 2.0f) {
                    this.r = ILoadingLayout$State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.f46275j * this.y) {
                    this.r = ILoadingLayout$State.RELEASE_TO_REFRESH;
                } else {
                    this.r = ILoadingLayout$State.PULL_TO_REFRESH;
                }
                LoadingLayout loadingLayout = this.f46273h;
                if (loadingLayout != null) {
                    loadingLayout.setState(this.r);
                }
                onStateChanged(this.r, true);
            }
        }
    }

    public void refreshRefreshableViewSize(int i2, int i3) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048619, this, i2, i3) == null) || (frameLayout = this.v) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        if (layoutParams.height != i3) {
            layoutParams.height = i3;
            this.v.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048620, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public void resetFooterLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean isPullLoading = isPullLoading();
            if (isPullLoading && abs <= this.k) {
                m(0);
            } else if (isPullLoading) {
                m(this.k);
            } else {
                m(0);
            }
        }
    }

    public void resetHeaderLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean isPullRefreshing = isPullRefreshing();
            boolean isLongPullRefreshing = isLongPullRefreshing();
            if ((isPullRefreshing || isLongPullRefreshing) && abs <= this.f46275j) {
                m(0);
            } else if (!isPullRefreshing && !isLongPullRefreshing) {
                m(0);
            } else {
                m(-this.f46275j);
            }
        }
    }

    public void setEmptyView(View view) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, view) == null) || (frameLayout = this.v) == null) {
            return;
        }
        frameLayout.addView(view, -1, -1);
    }

    public void setHeaderBackgroundColor(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (loadingLayout = this.f46273h) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundColor(getResources().getColor(i2));
    }

    public void setHeaderBackgroundResource(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (loadingLayout = this.f46273h) == null) {
            return;
        }
        loadingLayout.setHeaderBackgroundResource(i2);
    }

    public void setHeaderBigBackground(int i2) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i2) == null) || (loadingLayout = this.f46273h) == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i2);
    }

    public void setHeaderType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, charSequence) == null) {
            LoadingLayout loadingLayout = this.f46273h;
            if (loadingLayout != null) {
                loadingLayout.setLastUpdatedLabel(charSequence);
            }
            LoadingLayout loadingLayout2 = this.f46274i;
            if (loadingLayout2 != null) {
                loadingLayout2.setLastUpdatedLabel(charSequence);
            }
        }
    }

    public void setListenParentScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.z = z;
        }
    }

    public void setLongPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.x = z;
        }
    }

    public void setMaxPullOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setOffsetRadio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f2) == null) {
            this.f46270e = f2;
        }
    }

    public void setOnRefreshListener(j<T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, jVar) == null) {
            this.f46272g = jVar;
        }
    }

    public void setPullLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.m = z;
        }
    }

    public void setPullRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048635, this, f2) == null) {
            this.y = Math.max(f2, 1.0f);
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.l = z;
        }
    }

    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.n = z;
        }
    }

    public void showPullRefreshing(boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            postDelayed(new e(this, z), j2);
        }
    }

    public void startLoading() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || isPullLoading()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.s = iLoadingLayout$State;
        onStateChanged(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.f46274i;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.f46272g != null) {
            postDelayed(new h(this), getSmoothScrollDuration());
        }
    }

    public void startLongRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            o(true);
        }
    }

    public void startRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            p(true);
        }
    }

    public void superRequestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void doPullRefreshing(boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            doPullRefreshing(z, j2, null, true);
        }
    }

    public void doPullRefreshing(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            doPullRefreshing(z, 0L, null, z2);
        }
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
        this.mHeaderType = HEADERTYPE.STANDARD_HEADER;
        this.f46270e = 2.5f;
        this.f46271f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.w = -1;
        this.x = false;
        this.y = 1.0f;
        i(context, null);
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
        this.mHeaderType = HEADERTYPE.STANDARD_HEADER;
        this.f46270e = 2.5f;
        this.f46271f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.w = -1;
        this.x = false;
        this.y = 1.0f;
        i(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBaseNew(Context context, c.a.o0.a.z1.a.d.a<T> aVar, HEADERTYPE headertype) {
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
        this.mHeaderType = HEADERTYPE.STANDARD_HEADER;
        this.f46270e = 2.5f;
        this.f46271f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.w = -1;
        this.x = false;
        this.y = 1.0f;
        this.A = aVar;
        this.mHeaderType = headertype;
        i(context, null);
    }
}
