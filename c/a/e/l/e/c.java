package c.a.e.l.e;

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
    public Context f2973e;

    /* renamed from: f  reason: collision with root package name */
    public View f2974f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2975g;

    /* renamed from: h  reason: collision with root package name */
    public int f2976h;

    /* renamed from: i  reason: collision with root package name */
    public a f2977i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2978j;

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
        this.f2973e = null;
        this.f2974f = null;
        this.f2975g = true;
        this.f2976h = 0;
        this.f2978j = false;
        if (context != null) {
            this.f2973e = context;
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

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f2974f == null) {
                View i2 = i();
                this.f2974f = i2;
                if (i2 != null) {
                    o(i2);
                    this.f2976h = this.f2974f.getMeasuredHeight();
                    this.f2974f.getMeasuredWidth();
                } else {
                    throw new IllegalStateException("BdIListPullView getView is null");
                }
            }
            return this.f2974f;
        }
        return (View) invokeV.objValue;
    }

    public abstract View i();

    public abstract void j(boolean z);

    public Context k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2973e : (Context) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2976h : invokeV.intValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2975g : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2978j : invokeV.booleanValue;
    }

    public final void o(View view) {
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

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onCompleteRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f2978j) {
            return;
        }
        p();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onFinish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f2978j) {
            return;
        }
        j(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onPullPercentChange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f2978j) {
            return;
        }
        s(false);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f2978j) {
            return;
        }
        t();
        q(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f2978j) {
            return;
        }
        u();
    }

    public abstract void p();

    public abstract void q(boolean z);

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f2978j = true;
        }
    }

    public abstract void s(boolean z);

    public abstract void t();

    public abstract void u();

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f2978j = false;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f2975g = z;
        }
    }

    public void x(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.f2977i = aVar;
        }
    }

    public void y(int i2, int i3, int i4, int i5) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048600, this, i2, i3, i4, i5) == null) || (view = this.f2974f) == null || this.f2978j) {
            return;
        }
        view.setPadding(i2, i3, i4, i5);
        a aVar = this.f2977i;
        if (aVar != null) {
            aVar.a(this, i2, i4, i3 + l(), i5);
        }
    }
}
