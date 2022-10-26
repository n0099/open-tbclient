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
public class PullToRefreshListView extends PullToRefreshBase implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListView w;
    public LoadingLayout x;
    public AbsListView.OnScrollListener y;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PullToRefreshListView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void setScrollLoadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048588, this, z) != null) || v() == z) {
            return;
        }
        super.setScrollLoadEnabled(z);
        if (z) {
            if (this.x == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.x = footerLoadingLayout;
                this.w.addFooterView(footerLoadingLayout, null, false);
            }
            this.x.m(true);
            return;
        }
        LoadingLayout loadingLayout = this.x;
        if (loadingLayout != null) {
            loadingLayout.m(false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setPullLoadEnabled(false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.K();
            LoadingLayout loadingLayout = this.x;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout$State.REFRESHING);
            }
        }
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LoadingLayout loadingLayout = this.x;
            if (loadingLayout != null && loadingLayout.getState() == ILoadingLayout$State.NO_MORE_DATA) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (v()) {
                return this.x;
            }
            return super.getFooterLoadingLayout();
        }
        return (LoadingLayout) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return P();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return Q();
        }
        return invokeV.booleanValue;
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

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i) == null) {
            if (v() && O() && ((i == 0 || i == 2) && u())) {
                K();
            }
            AbsListView.OnScrollListener onScrollListener = this.y;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i);
            }
        }
    }

    public final boolean P() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ListAdapter adapter = this.w.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            if (this.w.getChildCount() > 0) {
                i = this.w.getChildAt(0).getTop();
            } else {
                i = 0;
            }
            if (i >= 0 && this.w.getFirstVisiblePosition() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ListAdapter adapter = this.w.getAdapter();
            if (adapter == null || adapter.isEmpty()) {
                return true;
            }
            int lastVisiblePosition = this.w.getLastVisiblePosition();
            if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
                View childAt = this.w.getChildAt(Math.min(lastVisiblePosition - this.w.getFirstVisiblePosition(), this.w.getChildCount() - 1));
                if (childAt != null && childAt.getBottom() <= this.w.getBottom()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048583, this, absListView, i, i2, i3) == null) && (onScrollListener = this.y) != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    public void setHasMoreData(boolean z) {
        ILoadingLayout$State iLoadingLayout$State;
        ILoadingLayout$State iLoadingLayout$State2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            LoadingLayout loadingLayout = this.x;
            if (loadingLayout != null) {
                if (z) {
                    iLoadingLayout$State2 = ILoadingLayout$State.RESET;
                } else {
                    iLoadingLayout$State2 = ILoadingLayout$State.NO_MORE_DATA;
                }
                loadingLayout.setState(iLoadingLayout$State2);
            }
            LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
            if (footerLoadingLayout != null) {
                if (z) {
                    iLoadingLayout$State = ILoadingLayout$State.RESET;
                } else {
                    iLoadingLayout$State = ILoadingLayout$State.NO_MORE_DATA;
                }
                footerLoadingLayout.setState(iLoadingLayout$State);
            }
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onScrollListener) == null) {
            this.y = onScrollListener;
        }
    }

    public void setRefreshableView(ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, listView) == null) {
            this.w = listView;
        }
    }
}
