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
import com.baidu.tieba.wj1;
import com.baidu.tieba.y13;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class PullToRefreshBaseNew extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public transient /* synthetic */ FieldHolder $fh;
    public HEADERTYPE a;
    public float b;
    public float c;
    public e d;
    public LoadingLayout e;
    public LoadingLayout f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public ILoadingLayout$State n;
    public ILoadingLayout$State o;
    public View p;
    public f q;
    public FrameLayout r;
    public int s;
    public boolean t;
    public float u;
    public boolean v;
    public y13 w;

    /* loaded from: classes3.dex */
    public interface e {
        void a(PullToRefreshBaseNew pullToRefreshBaseNew);

        void b(PullToRefreshBaseNew pullToRefreshBaseNew);

        void c(PullToRefreshBaseNew pullToRefreshBaseNew);
    }

    public abstract View g(Context context, AttributeSet attributeSet);

    public long getSmoothScrollDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 150L;
        }
        return invokeV.longValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean p();

    public abstract boolean q();

    public void r(ILoadingLayout$State iLoadingLayout$State, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, iLoadingLayout$State, z) == null) {
        }
    }

    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public final class HEADERTYPE {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (HEADERTYPE) Enum.valueOf(HEADERTYPE.class, str);
            }
            return (HEADERTYPE) invokeL.objValue;
        }

        public static HEADERTYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (HEADERTYPE[]) $VALUES.clone();
            }
            return (HEADERTYPE[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBaseNew a;

        public a(PullToRefreshBaseNew pullToRefreshBaseNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.a(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBaseNew a;

        public b(PullToRefreshBaseNew pullToRefreshBaseNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.b(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBaseNew a;

        public c(PullToRefreshBaseNew pullToRefreshBaseNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBaseNew;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.c(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
        }
    }

    /* loaded from: classes3.dex */
    public final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Interpolator a;
        public final int b;
        public final int c;
        public final long d;
        public boolean e;
        public long f;
        public int g;
        public final /* synthetic */ PullToRefreshBaseNew h;

        public f(PullToRefreshBaseNew pullToRefreshBaseNew, int i, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBaseNew, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = pullToRefreshBaseNew;
            this.e = true;
            this.f = -1L;
            this.g = -1;
            this.c = i;
            this.b = i2;
            this.d = j;
            this.a = new DecelerateInterpolator();
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e = false;
                this.h.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.d > 0) {
                    if (this.f == -1) {
                        this.f = System.currentTimeMillis();
                    } else {
                        int round = this.c - Math.round((this.c - this.b) * this.a.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f) * 1000) / this.d, 1000L), 0L)) / 1000.0f));
                        this.g = round;
                        this.h.y(0, round);
                    }
                    if (this.e && this.b != this.g) {
                        this.h.postDelayed(this, 16L);
                        return;
                    }
                    return;
                }
                this.h.y(0, this.b);
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
        x = wj1.a;
    }

    private int getScrollYValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return getScrollY();
        }
        return invokeV.intValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            D(true);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            F(true);
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return (LoadingLayout) invokeV.objValue;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return (LoadingLayout) invokeV.objValue;
    }

    public y13 getRefreshableFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.w;
        }
        return (y13) invokeV.objValue;
    }

    public View getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.n == ILoadingLayout$State.LONG_REFRESHING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.j && this.f != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.o == ILoadingLayout$State.REFRESHING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.i && this.e != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.n == ILoadingLayout$State.REFRESHING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean m = m();
            if (m && abs <= this.h) {
                z(0);
            } else if (m) {
                z(this.h);
            } else {
                z(0);
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = HEADERTYPE.STANDARD_HEADER;
        this.b = 2.5f;
        this.c = -1.0f;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.s = -1;
        this.t = false;
        this.u = 1.0f;
        h(context, null);
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
        this.a = HEADERTYPE.STANDARD_HEADER;
        this.b = 2.5f;
        this.c = -1.0f;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.s = -1;
        this.t = false;
        this.u = 1.0f;
        h(context, attributeSet);
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            this.k = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048607, this, z) == null) && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setEmptyView(View view2) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, view2) == null) && (frameLayout = this.r) != null) {
            frameLayout.addView(view2, -1, -1);
        }
    }

    public void setHeaderBackgroundColor(int i) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && (loadingLayout = this.e) != null) {
            loadingLayout.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && (loadingLayout = this.e) != null) {
            loadingLayout.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        LoadingLayout loadingLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048612, this, i) != null) || (loadingLayout = this.e) == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, charSequence) == null) {
            LoadingLayout loadingLayout = this.e;
            if (loadingLayout != null) {
                loadingLayout.setLastUpdatedLabel(charSequence);
            }
            LoadingLayout loadingLayout2 = this.f;
            if (loadingLayout2 != null) {
                loadingLayout2.setLastUpdatedLabel(charSequence);
            }
        }
    }

    public void setListenParentScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.v = z;
        }
    }

    public void setLongPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.t = z;
        }
    }

    public void setMaxPullOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.s = i;
        }
    }

    public void setOffsetRadio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            this.b = f2;
        }
    }

    public void setOnRefreshListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, eVar) == null) {
            this.d = eVar;
        }
    }

    public void setPullLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.j = z;
        }
    }

    public void setPullRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f2) == null) {
            this.u = Math.max(f2, 1.0f);
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.i = z;
        }
    }

    public final void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            A(i, getSmoothScrollDuration(), 0L);
        }
    }

    public final void A(int i, long j, long j2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            f fVar = this.q;
            if (fVar != null) {
                fVar.a();
            }
            int scrollYValue = getScrollYValue();
            if (scrollYValue != i) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.q = new f(this, scrollYValue, i, j);
            }
            if (z) {
                if (j2 > 0) {
                    postDelayed(this.q, j2);
                } else {
                    post(this.q);
                }
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || m()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.o = iLoadingLayout$State;
        r(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.f;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.d != null) {
            postDelayed(new c(this), getSmoothScrollDuration());
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            int abs = Math.abs(getScrollYValue());
            boolean o = o();
            boolean j = j();
            if ((o || j) && abs <= this.g) {
                z(0);
            } else if (!o && !j) {
                z(0);
            } else {
                z(-this.g);
            }
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && !o() && !j()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.LONG_REFRESHING;
            this.n = iLoadingLayout$State;
            r(iLoadingLayout$State, true);
            LoadingLayout loadingLayout = this.e;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout$State.LONG_REFRESHING);
            }
            if (this.d != null) {
                postDelayed(new b(this), getSmoothScrollDuration());
            }
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && !o() && !j()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
            this.n = iLoadingLayout$State;
            r(iLoadingLayout$State, true);
            LoadingLayout loadingLayout = this.e;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout$State.REFRESHING);
            }
            if (z && this.d != null) {
                postDelayed(new a(this), getSmoothScrollDuration());
            }
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LoadingLayout loadingLayout = this.e;
            LoadingLayout loadingLayout2 = this.f;
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

    public void d(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, view2) == null) {
            addView(view2, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public LoadingLayout e(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, attributeSet)) == null) {
            return new FooterLoadingLayout(context);
        }
        return (LoadingLayout) invokeLL.objValue;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public final void x(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048627, this, i, i2) == null) {
            scrollBy(i, i2);
        }
    }

    public final void y(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i, i2) == null) {
            scrollTo(i, i2);
        }
    }

    public LoadingLayout f(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        LoadingLayout headerLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, attributeSet)) == null) {
            w();
            int i = d.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        headerLoadingLayout = null;
                    } else {
                        headerLoadingLayout = new RotateLoadingLayout(context);
                    }
                } else {
                    headerLoadingLayout = new BigBgHeaderLoadingLayout(context);
                }
            } else {
                headerLoadingLayout = new HeaderLoadingLayout(context);
            }
            if (headerLoadingLayout == null) {
                return new HeaderLoadingLayout(context);
            }
            return headerLoadingLayout;
        }
        return (LoadingLayout) invokeLL.objValue;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, attributeSet) == null) {
            this.m = ViewConfiguration.get(context).getScaledTouchSlop();
            this.e = f(context, attributeSet);
            this.f = e(context, attributeSet);
            View g = g(context, attributeSet);
            this.p = g;
            if (x && g == null) {
                throw new NullPointerException("Refreshable view can not be null.");
            }
            View view2 = this.p;
            if (view2 != null) {
                d(context, view2);
            }
            c(context);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            boolean z = false;
            if (!i()) {
                return false;
            }
            if (!l() && !n()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 3 && action != 1) {
                if (action != 0 && this.l) {
                    return true;
                }
                if (action != 0) {
                    if (action == 2) {
                        float y = motionEvent.getY() - this.c;
                        if (Math.abs(y) > this.m || o() || m() || j()) {
                            this.c = motionEvent.getY();
                            if (n() && p()) {
                                z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                this.l = z;
                                if (z && k() && (view2 = this.p) != null) {
                                    view2.onTouchEvent(motionEvent);
                                }
                            } else if (l() && q()) {
                                this.l = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                            }
                        }
                    }
                } else {
                    this.c = motionEvent.getY();
                    this.l = false;
                }
                return this.l;
            }
            this.l = false;
            return false;
        }
        return invokeL.booleanValue;
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
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else {
                        float y = motionEvent.getY() - this.c;
                        this.c = motionEvent.getY();
                        if (n() && p()) {
                            t(y / this.b);
                        } else if (l() && q()) {
                            s(y / this.b);
                        } else {
                            this.l = false;
                            return false;
                        }
                        return true;
                    }
                }
                if (!this.l) {
                    return false;
                }
                this.l = false;
                if (p()) {
                    if (this.i) {
                        ILoadingLayout$State iLoadingLayout$State = this.n;
                        if (iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            E();
                            z = true;
                        } else if (this.t && iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_LONG_REFRESH) {
                            C();
                            z = true;
                            if (this.v) {
                                return true;
                            }
                        }
                    } else {
                        ILoadingLayout$State iLoadingLayout$State2 = ILoadingLayout$State.RESET;
                        this.n = iLoadingLayout$State2;
                        r(iLoadingLayout$State2, true);
                    }
                    v();
                    return z;
                } else if (!q()) {
                    return false;
                } else {
                    if (l() && this.o == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                        B();
                        z = true;
                    }
                    u();
                    return z;
                }
            }
            this.c = motionEvent.getY();
            this.l = false;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void t(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048623, this, f2) == null) {
            int scrollYValue = getScrollYValue();
            if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
                y(0, 0);
            } else if (this.s > 0 && f2 > 0.0f && Math.abs(scrollYValue) >= this.s) {
            } else {
                x(0, -((int) f2));
                if (this.e != null && this.g != 0) {
                    this.e.d(Math.abs(getScrollYValue()) / this.g);
                }
                int abs = Math.abs(getScrollYValue());
                if (n() && !o() && !j()) {
                    if (this.t && abs > this.g * this.u * 2.0f) {
                        this.n = ILoadingLayout$State.RELEASE_TO_LONG_REFRESH;
                    } else if (abs > this.g * this.u) {
                        this.n = ILoadingLayout$State.RELEASE_TO_REFRESH;
                    } else {
                        this.n = ILoadingLayout$State.PULL_TO_REFRESH;
                    }
                    LoadingLayout loadingLayout = this.e;
                    if (loadingLayout != null) {
                        loadingLayout.setState(this.n);
                    }
                    r(this.n, true);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            LoadingLayout loadingLayout = this.e;
            if (loadingLayout != null) {
                loadingLayout.layout(loadingLayout.getLeft(), this.e.getTop() - this.e.getHeight(), this.e.getRight(), this.e.getBottom() - this.e.getHeight());
                this.g = this.e.getContentSize();
            }
            LoadingLayout loadingLayout2 = this.f;
            if (loadingLayout2 != null && this.p != null) {
                loadingLayout2.layout(loadingLayout2.getLeft(), this.p.getBottom(), this.f.getRight(), this.p.getBottom() + this.f.getHeight());
                this.h = this.f.getContentSize();
            }
        }
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
            if (this.f != null && this.h != 0) {
                this.f.d(Math.abs(getScrollYValue()) / this.h);
            }
            int abs = Math.abs(getScrollYValue());
            if (l() && !m()) {
                if (abs > this.h) {
                    this.o = ILoadingLayout$State.RELEASE_TO_REFRESH;
                } else {
                    this.o = ILoadingLayout$State.PULL_TO_REFRESH;
                }
                LoadingLayout loadingLayout = this.f;
                if (loadingLayout != null) {
                    loadingLayout.setState(this.o);
                }
                r(this.o, false);
            }
        }
    }
}
