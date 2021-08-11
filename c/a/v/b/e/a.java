package c.a.v.b.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.refresh.BdSwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes4.dex */
public abstract class a implements BdSwipeRefreshLayout.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f30012e;

    /* renamed from: f  reason: collision with root package name */
    public View f30013f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30014g;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30012e = null;
        this.f30013f = null;
        this.f30014g = false;
        if (context != null) {
            this.f30012e = context;
            return;
        }
        throw new InvalidParameterException("BdIListPullView context is null");
    }

    public abstract View a();

    public abstract void b(boolean z);

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30012e : (Context) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30014g : invokeV.booleanValue;
    }

    public final void e(View view) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            int i2 = layoutParams.height;
            if (i2 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(childMeasureSpec, makeMeasureSpec);
        }
    }

    public abstract void f();

    public abstract void g(boolean z);

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f30013f == null) {
                View a2 = a();
                this.f30013f = a2;
                if (a2 != null) {
                    e(a2);
                    this.f30013f.getMeasuredHeight();
                    this.f30013f.getMeasuredWidth();
                } else {
                    throw new IllegalStateException("BdIListPullView getView is null");
                }
            }
            return this.f30013f;
        }
        return (View) invokeV.objValue;
    }

    public abstract void h(boolean z);

    public abstract void i();

    public abstract void j();

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onCompleteRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f30014g) {
            return;
        }
        f();
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onFinish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f30014g) {
            return;
        }
        b(true);
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onPullPercentChange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f30014g) {
            return;
        }
        h(false);
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f30014g) {
            return;
        }
        i();
        g(true);
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f30014g) {
            return;
        }
        j();
    }
}
