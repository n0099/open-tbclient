package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f;
import d.a.q0.a.g;
import d.a.q0.a.k;
import d.a.q0.a.v2.n0;
/* loaded from: classes4.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public int f11367i;
    public int j;
    public int k;
    public int l;
    public View m;
    public NeutralRefreshAnimView n;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f11368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NeutralHeaderLoadingLayout f11369f;

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
            this.f11369f = neutralHeaderLoadingLayout;
            this.f11368e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11368e.run();
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
        o = k.f49133a;
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
        this.f11367i = 0;
        o();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, viewGroup, attributeSet)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(g.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
            this.m = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (o) {
                Log.e("NeutralLoadingLayout", "pullLength = " + i2);
            }
            if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
                this.n.setAnimPercent(n(i2));
            }
            int i3 = this.k;
            if (i2 > i3) {
                setTranslationY((i3 - i2) / 2);
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void f(boolean z, String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, runnable}) == null) {
            if (o) {
                Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
            }
            this.n.A();
            if (o) {
                Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
            }
            this.n.q();
            post(new a(this, runnable));
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (o) {
                Log.e("NeutralLoadingLayout", "onPullToRefresh");
            }
            this.n.setAlpha(1.0f);
            this.n.A();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (o) {
                Log.e("NeutralLoadingLayout", "onRefreshing");
            }
            this.n.r();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (o) {
                Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
            }
            this.n.setAnimPercent(1.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (o) {
                Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
            }
            this.n.setAnimPercent(1.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (o) {
                Log.e("NeutralLoadingLayout", "onReset");
            }
            this.n.A();
            this.n.setAlpha(1.0f);
            setTranslationY(0.0f);
        }
    }

    public float n(int i2) {
        InterceptResult invokeI;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int i3 = this.j;
            if (i2 < i3) {
                int i4 = this.f11367i;
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

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.n = (NeutralRefreshAnimView) findViewById(f.neutral_refresh_anim_view);
            int f2 = n0.f(getContext(), 29.0f);
            this.f11367i = f2;
            this.j = (int) (f2 * 2.4f);
            int i2 = (int) (f2 * 1.5f);
            this.l = i2;
            this.k = i2;
            if (o) {
                Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.f11367i);
                Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.j);
                Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.l);
                Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.k);
            }
        }
    }

    public boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            NeutralRefreshAnimView neutralRefreshAnimView = this.n;
            if (neutralRefreshAnimView == null) {
                return false;
            }
            neutralRefreshAnimView.z(i2);
            return true;
        }
        return invokeI.booleanValue;
    }
}
