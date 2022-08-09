package com.baidu.swan.apps.res.ui.pullrefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jh1;
/* loaded from: classes2.dex */
public abstract class LoadingLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ILoadingLayout$State b;
    public ILoadingLayout$State c;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1079636112, "Lcom/baidu/swan/apps/res/ui/pullrefresh/LoadingLayout$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1079636112, "Lcom/baidu/swan/apps/res/ui/pullrefresh/LoadingLayout$a;");
                    return;
                }
            }
            int[] iArr = new int[ILoadingLayout$State.values().length];
            a = iArr;
            try {
                iArr[ILoadingLayout$State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ILoadingLayout$State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ILoadingLayout$State.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ILoadingLayout$State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ILoadingLayout$State.NO_MORE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ILoadingLayout$State.RELEASE_TO_LONG_REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1793300211, "Lcom/baidu/swan/apps/res/ui/pullrefresh/LoadingLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1793300211, "Lcom/baidu/swan/apps/res/ui/pullrefresh/LoadingLayout;");
                return;
            }
        }
        d = jh1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public abstract View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet);

    @SuppressLint({"BDThrowableCheck"})
    public void b(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
            View a2 = a(context, this, attributeSet);
            this.a = a2;
            if (a2 == null) {
                if (d) {
                    throw new NullPointerException("Loading view can not be null.");
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
            addView(this.a, new FrameLayout.LayoutParams(-1, layoutParams != null ? layoutParams.height : -2));
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void d(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
        }
    }

    public void f(boolean z, String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, runnable}) == null) {
            runnable.run();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public int getCanRefreshPullLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getContentSize() : invokeV.intValue;
    }

    public abstract int getContentSize();

    public ILoadingLayout$State getPreState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (ILoadingLayout$State) invokeV.objValue;
    }

    public int getRefreshingHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getContentSize() : invokeV.intValue;
    }

    public ILoadingLayout$State getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (ILoadingLayout$State) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, iLoadingLayout$State, iLoadingLayout$State2) == null) {
            switch (a.a[iLoadingLayout$State.ordinal()]) {
                case 1:
                    k();
                    return;
                case 2:
                    j();
                    return;
                case 3:
                    g();
                    return;
                case 4:
                    h();
                    return;
                case 5:
                    c();
                    return;
                case 6:
                    i();
                    return;
                default:
                    return;
            }
        }
    }

    public void m(boolean z) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z == (getVisibility() == 0) || (view2 = this.a) == null || (layoutParams = view2.getLayoutParams()) == null) {
                return;
            }
            if (z) {
                layoutParams.height = -2;
            } else {
                layoutParams.height = 0;
            }
            requestLayout();
            setVisibility(z ? 0 : 4);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || (view2 = this.a) == null) {
            return;
        }
        view2.setBackgroundColor(i);
    }

    public void setHeaderBackgroundColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (view2 = this.a) == null) {
            return;
        }
        view2.setBackgroundColor(i);
    }

    public void setHeaderBackgroundResource(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || (view2 = this.a) == null) {
            return;
        }
        view2.setBackgroundColor(getResources().getColor(i));
    }

    public void setHeaderBigBackground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, charSequence) == null) {
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, drawable) == null) {
        }
    }

    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, charSequence) == null) {
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, charSequence) == null) {
        }
    }

    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, charSequence) == null) {
        }
    }

    public void setState(ILoadingLayout$State iLoadingLayout$State) {
        ILoadingLayout$State iLoadingLayout$State2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, iLoadingLayout$State) == null) || (iLoadingLayout$State2 = this.b) == iLoadingLayout$State) {
            return;
        }
        this.c = iLoadingLayout$State2;
        this.b = iLoadingLayout$State;
        l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.b = iLoadingLayout$State;
        this.c = iLoadingLayout$State;
        b(context, attributeSet);
    }
}
