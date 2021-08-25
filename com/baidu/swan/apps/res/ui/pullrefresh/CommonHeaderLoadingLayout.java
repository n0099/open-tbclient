package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.f;
import c.a.o0.a.g;
import c.a.o0.a.h;
import c.a.o0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public int f46205i;

    /* renamed from: j  reason: collision with root package name */
    public int f46206j;
    public int k;
    public int l;
    public View m;
    public RefreshingAnimView n;
    public HeaderRefreshIndicator o;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommonHeaderLoadingLayout f46207e;

        public a(CommonHeaderLoadingLayout commonHeaderLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonHeaderLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46207e = commonHeaderLoadingLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46207e.o.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f46208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonHeaderLoadingLayout f46209f;

        public b(CommonHeaderLoadingLayout commonHeaderLoadingLayout, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonHeaderLoadingLayout, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46209f = commonHeaderLoadingLayout;
            this.f46208e = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f46209f.postDelayed(this.f46208e, 800L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f46209f.o.setTranslationY(0.0f);
                this.f46209f.o.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46205i = 0;
        this.n = (RefreshingAnimView) findViewById(f.refreshing_anim_view);
        int f2 = n0.f(getContext(), 29.0f);
        this.f46205i = f2;
        this.f46206j = (int) (f2 * 2.4f);
        int i4 = (int) (f2 * 1.5f);
        this.l = i4;
        this.k = i4;
        HeaderRefreshIndicator headerRefreshIndicator = (HeaderRefreshIndicator) findViewById(f.refresh_over_tip);
        this.o = headerRefreshIndicator;
        headerRefreshIndicator.initIfNeed();
    }

    public float calculateOffsetAnimPercent(int i2) {
        InterceptResult invokeI;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f46206j;
            if (i2 < i3) {
                int i4 = this.f46205i;
                f2 = i2 < i4 ? 0.0f : (i2 - i4) / (i3 - i4);
            } else {
                f2 = 1.0f;
            }
            float f3 = f2 >= 0.0f ? f2 : 0.0f;
            if (f3 > 1.0f) {
                return 1.0f;
            }
            return f3;
        }
        return invokeI.floatValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup, attributeSet)) == null) {
            View inflate = LayoutInflater.from(context).inflate(g.aiapps_common_pull_to_refresh_header, viewGroup, false);
            this.m = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46206j : invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.m;
            if (view != null) {
                return view.getHeight();
            }
            return n0.f(getContext(), 50.0f);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullLength(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
                this.n.setAnimPercent(calculateOffsetAnimPercent(i2));
            }
            int i3 = this.k;
            if (i2 > i3) {
                setTranslationY((i3 - i2) / 2);
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullRefreshComplete(boolean z, String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, runnable}) == null) {
            if (z) {
                this.n.setAlpha(0.0f);
                if (TextUtils.isEmpty(str)) {
                    this.o.setText(getResources().getText(h.aiapps_pull_down_refresh_success));
                } else {
                    this.o.setText(str);
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(this.o.getHeight(), 0);
                ofInt.setDuration(150L);
                ofInt.addUpdateListener(new a(this));
                ofInt.addListener(new b(this, runnable));
                ofInt.start();
                return;
            }
            setState(ILoadingLayout$State.PULL_TO_REFRESH);
            runnable.run();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n.setAlpha(1.0f);
            this.n.stopAnim();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n.startMagnifierRotate();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onReleaseToLongRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.setAnimPercent(1.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.n.setAnimPercent(1.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setTranslationY(0.0f);
            this.n.setAlpha(1.0f);
            this.n.stopAnim();
            this.o.setVisibility(4);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.setHeaderBackgroundResource(i2);
            this.o.initResources();
        }
    }
}
