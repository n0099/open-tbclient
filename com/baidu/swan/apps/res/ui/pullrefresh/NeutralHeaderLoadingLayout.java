package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f;
import c.a.p0.a.g;
import c.a.p0.a.k;
import c.a.p0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_H = 50;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public int f39844i;

    /* renamed from: j  reason: collision with root package name */
    public int f39845j;

    /* renamed from: k  reason: collision with root package name */
    public int f39846k;
    public int l;
    public View m;
    public NeutralRefreshAnimView n;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f39847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NeutralHeaderLoadingLayout f39848f;

        public a(NeutralHeaderLoadingLayout neutralHeaderLoadingLayout, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralHeaderLoadingLayout, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39848f = neutralHeaderLoadingLayout;
            this.f39847e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39847e.run();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-89221839, "Lcom/baidu/swan/apps/res/ui/pullrefresh/NeutralHeaderLoadingLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-89221839, "Lcom/baidu/swan/apps/res/ui/pullrefresh/NeutralHeaderLoadingLayout;");
                return;
            }
        }
        o = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NeutralHeaderLoadingLayout(Context context) {
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
        this.f39844i = 0;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n = (NeutralRefreshAnimView) findViewById(f.neutral_refresh_anim_view);
            int f2 = n0.f(getContext(), 29.0f);
            this.f39844i = f2;
            this.f39845j = (int) (f2 * 2.4f);
            int i2 = (int) (f2 * 1.5f);
            this.l = i2;
            this.f39846k = i2;
            if (o) {
                String str = "mRefreshingViewSizeInPixel" + this.f39844i;
                String str2 = "mTriggerRefreshLength" + this.f39845j;
                String str3 = "mRefreshingHeight" + this.l;
                String str4 = "mScrollStartLength" + this.f39846k;
            }
        }
    }

    public float calculateOffsetAnimPercent(int i2) {
        InterceptResult invokeI;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.f39845j;
            if (i2 < i3) {
                int i4 = this.f39844i;
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, viewGroup, attributeSet)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
            this.m = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39845j : invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullLength(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (o) {
                r0 = "pullLength = " + i2;
            }
            if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
                this.n.setAnimPercent(calculateOffsetAnimPercent(i2));
            }
            if (i2 > this.f39846k) {
                setTranslationY((i3 - i2) / 2);
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullRefreshComplete(boolean z, String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, runnable}) == null) {
            boolean z2 = o;
            this.n.stopAnim();
            if (o) {
                String str2 = "current thread name:" + Thread.currentThread().getName();
            }
            this.n.onRefreshCompleteAnim();
            post(new a(this, runnable));
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = o;
            this.n.setAlpha(1.0f);
            this.n.stopAnim();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = o;
            this.n.onRefreshingAnim();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onReleaseToLongRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = o;
            this.n.setAnimPercent(1.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean z = o;
            this.n.setAnimPercent(1.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            boolean z = o;
            this.n.stopAnim();
            this.n.setAlpha(1.0f);
            setTranslationY(0.0f);
        }
    }

    public boolean setBackgroundTextStyle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            NeutralRefreshAnimView neutralRefreshAnimView = this.n;
            if (neutralRefreshAnimView == null) {
                return false;
            }
            neutralRefreshAnimView.setBackgroundTextStyle(i2);
            return true;
        }
        return invokeI.booleanValue;
    }
}
