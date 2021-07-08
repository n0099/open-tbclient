package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListView A;
    public LoadingLayout B;
    public AbsListView.OnScrollListener C;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PullToRefreshListView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.K();
            LoadingLayout loadingLayout = this.B;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout$State.REFRESHING);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    /* renamed from: N */
    public ListView j(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet)) == null) {
            ListView listView = new ListView(context);
            listView.setOnScrollListener(this);
            setRefreshableView(listView);
            return listView;
        }
        return (ListView) invokeLL.objValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LoadingLayout loadingLayout = this.B;
            return loadingLayout == null || loadingLayout.getState() != ILoadingLayout$State.NO_MORE_DATA;
        }
        return invokeV.booleanValue;
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ListAdapter adapter = this.A.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            return (this.A.getChildCount() > 0 ? this.A.getChildAt(0).getTop() : 0) >= 0 && this.A.getFirstVisiblePosition() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ListAdapter adapter = this.A.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            int lastVisiblePosition = this.A.getLastVisiblePosition();
            if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
                View childAt = this.A.getChildAt(Math.min(lastVisiblePosition - this.A.getFirstVisiblePosition(), this.A.getChildCount() - 1));
                return childAt != null && childAt.getBottom() <= this.A.getBottom();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (v()) {
                return this.B;
            }
            return super.getFooterLoadingLayout();
        }
        return (LoadingLayout) invokeV.objValue;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048583, this, absListView, i2, i3, i4) == null) || (onScrollListener = this.C) == null) {
            return;
        }
        onScrollListener.onScroll(absListView, i2, i3, i4);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) {
            if (v() && O() && ((i2 == 0 || i2 == 2) && u())) {
                K();
            }
            AbsListView.OnScrollListener onScrollListener = this.C;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i2);
            }
        }
    }

    public void setHasMoreData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            LoadingLayout loadingLayout = this.B;
            if (loadingLayout != null) {
                loadingLayout.setState(z ? ILoadingLayout$State.RESET : ILoadingLayout$State.NO_MORE_DATA);
            }
            LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
            if (footerLoadingLayout != null) {
                footerLoadingLayout.setState(z ? ILoadingLayout$State.RESET : ILoadingLayout$State.NO_MORE_DATA);
            }
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onScrollListener) == null) {
            this.C = onScrollListener;
        }
    }

    public void setRefreshableView(ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, listView) == null) {
            this.A = listView;
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || v() == z) {
            return;
        }
        super.setScrollLoadEnabled(z);
        if (z) {
            if (this.B == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.B = footerLoadingLayout;
                this.A.addFooterView(footerLoadingLayout, null, false);
            }
            this.B.m(true);
            return;
        }
        LoadingLayout loadingLayout = this.B;
        if (loadingLayout != null) {
            loadingLayout.m(false);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? P() : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? Q() : invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setPullLoadEnabled(false);
    }
}
