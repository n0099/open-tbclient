package c.a.d.m.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c implements BdSwipeRefreshLayout.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f2879e;

    /* renamed from: f  reason: collision with root package name */
    public View f2880f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2881g;

    /* renamed from: h  reason: collision with root package name */
    public int f2882h;

    /* renamed from: i  reason: collision with root package name */
    public a f2883i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2884j;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar, int i2, int i3, int i4, int i5);
    }

    public c(Context context) {
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
        this.f2879e = null;
        this.f2880f = null;
        this.f2881g = true;
        this.f2882h = 0;
        this.f2884j = false;
        if (context != null) {
            this.f2879e = context;
            return;
        }
        throw new InvalidParameterException("BdIListPullView context is null");
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2879e : (Context) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f2880f == null) {
                View i2 = i();
                this.f2880f = i2;
                if (i2 != null) {
                    n(i2);
                    this.f2882h = this.f2880f.getMeasuredHeight();
                    this.f2880f.getMeasuredWidth();
                } else {
                    throw new IllegalStateException("BdIListPullView getView is null");
                }
            }
            return this.f2880f;
        }
        return (View) invokeV.objValue;
    }

    public abstract View i();

    public abstract void j(boolean z);

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2882h : invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2881g : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2884j : invokeV.booleanValue;
    }

    public final void n(View view) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
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

    public abstract void o();

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onCompleteRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f2884j) {
            return;
        }
        o();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onFinish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f2884j) {
            return;
        }
        j(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onPullPercentChange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f2884j) {
            return;
        }
        r(false);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f2884j) {
            return;
        }
        s();
        p(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f2884j) {
            return;
        }
        t();
    }

    public abstract void p(boolean z);

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f2884j = true;
        }
    }

    public abstract void r(boolean z);

    public abstract void s();

    public abstract void t();

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f2884j = false;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f2881g = z;
        }
    }

    public void w(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.f2883i = aVar;
        }
    }

    public void x(int i2, int i3, int i4, int i5) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048600, this, i2, i3, i4, i5) == null) || (view = this.f2880f) == null || this.f2884j) {
            return;
        }
        view.setPadding(i2, i3, i4, i5);
        a aVar = this.f2883i;
        if (aVar != null) {
            aVar.a(this, i2, i4, i3 + k(), i5);
        }
    }
}
