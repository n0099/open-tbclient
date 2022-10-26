package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.dh3;
import com.baidu.tieba.wj1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;
    public int f;
    public int g;
    public int h;
    public View i;
    public NeutralRefreshAnimView j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ NeutralHeaderLoadingLayout b;

        public a(NeutralHeaderLoadingLayout neutralHeaderLoadingLayout, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralHeaderLoadingLayout, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = neutralHeaderLoadingLayout;
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.run();
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
        k = wj1.a;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (k) {
                Log.e("NeutralLoadingLayout", "onPullToRefresh");
            }
            this.j.setAlpha(1.0f);
            this.j.A();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.getHeight();
            }
            return dh3.f(getContext(), 50.0f);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (k) {
                Log.e("NeutralLoadingLayout", "onRefreshing");
            }
            this.j.r();
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (k) {
                Log.e("NeutralLoadingLayout", "onReleaseToLongRefresh");
            }
            this.j.setAnimPercent(1.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (k) {
                Log.e("NeutralLoadingLayout", "onReleaseToRefresh");
            }
            this.j.setAnimPercent(1.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (k) {
                Log.e("NeutralLoadingLayout", "onReset");
            }
            this.j.A();
            this.j.setAlpha(1.0f);
            setTranslationY(0.0f);
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0;
        o();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (k) {
                Log.e("NeutralLoadingLayout", "pullLength = " + i);
            }
            if (getState() == ILoadingLayout$State.PULL_TO_REFRESH) {
                this.j.setAnimPercent(n(i));
            }
            int i2 = this.g;
            if (i > i2) {
                setTranslationY((i2 - i) / 2);
            }
        }
    }

    public float n(int i) {
        InterceptResult invokeI;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            int i2 = this.f;
            float f2 = 0.0f;
            if (i < i2) {
                int i3 = this.e;
                if (i < i3) {
                    f = 0.0f;
                } else {
                    f = (i - i3) / (i2 - i3);
                }
            } else {
                f = 1.0f;
            }
            if (f >= 0.0f) {
                f2 = f;
            }
            if (f2 > 1.0f) {
                return 1.0f;
            }
            return f2;
        }
        return invokeI.floatValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, viewGroup, attributeSet)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00be, viewGroup, false);
            this.i = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void f(boolean z, String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, runnable}) == null) {
            if (k) {
                Log.e("NeutralLoadingLayout", "onPullRefreshComplete");
            }
            this.j.A();
            if (k) {
                Log.e("NeutralLoadingLayout", "current thread name:" + Thread.currentThread().getName());
            }
            this.j.q();
            post(new a(this, runnable));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.j = (NeutralRefreshAnimView) findViewById(R.id.obfuscated_res_0x7f091676);
            int f = dh3.f(getContext(), 29.0f);
            this.e = f;
            this.f = (int) (f * 2.4f);
            int i = (int) (f * 1.5f);
            this.h = i;
            this.g = i;
            if (k) {
                Log.e("NeutralLoadingLayout", "mRefreshingViewSizeInPixel" + this.e);
                Log.e("NeutralLoadingLayout", "mTriggerRefreshLength" + this.f);
                Log.e("NeutralLoadingLayout", "mRefreshingHeight" + this.h);
                Log.e("NeutralLoadingLayout", "mScrollStartLength" + this.g);
            }
        }
    }

    public boolean p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            NeutralRefreshAnimView neutralRefreshAnimView = this.j;
            if (neutralRefreshAnimView == null) {
                return false;
            }
            neutralRefreshAnimView.z(i);
            return true;
        }
        return invokeI.booleanValue;
    }
}
