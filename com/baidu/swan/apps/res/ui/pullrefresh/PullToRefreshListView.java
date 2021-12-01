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
/* loaded from: classes9.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsListView.OnScrollListener A;
    public ListView y;
    public LoadingLayout z;

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

    public void dismissListViewDivider() {
        ListView listView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (listView = this.y) == null) {
            return;
        }
        listView.setDivider(null);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (isScrollLoadEnabled()) {
                return this.z;
            }
            return super.getFooterLoadingLayout();
        }
        return (LoadingLayout) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? q() : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? r() : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void onPullUpRefreshComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPullUpRefreshComplete();
            LoadingLayout loadingLayout = this.z;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout$State.RESET);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048583, this, absListView, i2, i3, i4) == null) || (onScrollListener = this.A) == null) {
            return;
        }
        onScrollListener.onScroll(absListView, i2, i3, i4);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) {
            if (isScrollLoadEnabled() && p() && ((i2 == 0 || i2 == 2) && isReadyForPullUp())) {
                startLoading();
            }
            AbsListView.OnScrollListener onScrollListener = this.A;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i2);
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LoadingLayout loadingLayout = this.z;
            return loadingLayout == null || loadingLayout.getState() != ILoadingLayout$State.NO_MORE_DATA;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ListAdapter adapter = this.y.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            return (this.y.getChildCount() > 0 ? this.y.getChildAt(0).getTop() : 0) >= 0 && this.y.getFirstVisiblePosition() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ListAdapter adapter = this.y.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            int lastVisiblePosition = this.y.getLastVisiblePosition();
            if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
                View childAt = this.y.getChildAt(Math.min(lastVisiblePosition - this.y.getFirstVisiblePosition(), this.y.getChildCount() - 1));
                return childAt != null && childAt.getBottom() <= this.y.getBottom();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setHasMoreData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            LoadingLayout loadingLayout = this.z;
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
        if (interceptable == null || interceptable.invokeL(1048589, this, onScrollListener) == null) {
            this.A = onScrollListener;
        }
    }

    public void setRefreshableView(ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, listView) == null) {
            this.y = listView;
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || isScrollLoadEnabled() == z) {
            return;
        }
        super.setScrollLoadEnabled(z);
        if (z) {
            if (this.z == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.z = footerLoadingLayout;
                this.y.addFooterView(footerLoadingLayout, null, false);
            }
            this.z.show(true);
            return;
        }
        LoadingLayout loadingLayout = this.z;
        if (loadingLayout != null) {
            loadingLayout.show(false);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.startLoading();
            LoadingLayout loadingLayout = this.z;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout$State.REFRESHING);
            }
        }
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
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
}
