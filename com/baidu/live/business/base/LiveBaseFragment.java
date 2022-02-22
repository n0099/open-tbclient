package com.baidu.live.business.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.a.y.b.d.a;
import c.a.y.b.d.c.b;
import c.a.y.g.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class LiveBaseFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_DEF_SUB_TAB_TYPE = "scheme_def_tab_type";
    public static final String SOURCE = "source";
    public static final String TAB_BD_ID = "tab_bd_id";
    public static final String TAB_ENTITY_ITEM = "tab_entity_item";
    public static final String TAB_IS_IMMER = "tab_is_immer";
    public static final String TAB_POSITION = "tab_position";
    public transient /* synthetic */ FieldHolder $fh;
    public String channelId;
    public boolean isImmer;
    public b mFeedConfig;
    public LiveFeedWrapData mFeedWrapData;
    public a mModel;
    public int mPosition;
    public LiveTabEntity mTabItem;
    public boolean needNewCreate;
    public int refreshIndex;
    public int refreshType;
    public String requestKey;
    public String sessionId;
    public String subTab;
    public String tab;

    public LiveBaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.needNewCreate = true;
        this.refreshIndex = 1;
        this.tab = "";
        this.channelId = "";
        this.subTab = "";
        this.requestKey = "";
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RecyclerView.LayoutManager layoutManager = getRecyclerView().getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null);
                return Math.max(findLastVisibleItemPositions[0], findLastVisibleItemPositions[1]);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract RecyclerView getRecyclerView();

    public boolean isValidData(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2)) == null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            return (str + "_" + str2 + "_" + i2).equals(this.requestKey);
        }
        return invokeLLI.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.refreshType = 1;
            String str = this.requestKey;
            if (str.equals(this.tab + "_" + this.subTab + "_" + this.refreshType)) {
                return;
            }
            this.requestKey = this.tab + "_" + this.subTab + "_" + this.refreshType;
            this.refreshIndex = this.refreshIndex + 1;
            c.a.y.b.d.b.b(8);
            a aVar = this.mModel;
            if (aVar != null) {
                aVar.h(c.a.y.b.d.b.a(), this.sessionId, this.refreshType, this.tab, this.channelId, this.subTab, this.refreshIndex);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public abstract void onDarkModeChange(String str);

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.mFeedWrapData = null;
            d.a().e(this);
        }
    }

    public abstract void onFragmentShow(boolean z);

    public abstract void onParentPause();

    public abstract void onParentResume();

    public void onSelectedChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            onFragmentShow(z);
        }
    }

    public boolean refreshFeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.refreshType = 0;
            String str = this.requestKey;
            if (str.equals(this.tab + "_" + this.subTab + "_" + this.refreshType)) {
                return false;
            }
            this.requestKey = this.tab + "_" + this.subTab + "_" + this.refreshType;
            this.sessionId = "";
            this.refreshIndex = 1;
            c.a.y.b.d.b.b(8);
            a aVar = this.mModel;
            if (aVar != null) {
                aVar.h(c.a.y.b.d.b.a(), this.sessionId, this.refreshType, this.tab, this.channelId, this.subTab, this.refreshIndex);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean refreshFeedAndFollow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.refreshType = 0;
            String str = this.requestKey;
            if (str.equals(this.tab + "_" + this.subTab + "_" + this.refreshType)) {
                return false;
            }
            this.requestKey = this.tab + "_" + this.subTab + "_" + this.refreshType;
            this.sessionId = "";
            this.refreshIndex = 1;
            c.a.y.b.d.b.b(10);
            a aVar = this.mModel;
            if (aVar != null) {
                aVar.h(c.a.y.b.d.b.a(), this.sessionId, this.refreshType, this.tab, this.channelId, this.subTab, this.refreshIndex);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean refreshFeedAndFollowAndBanner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.refreshType = 0;
            String str = this.requestKey;
            if (str.equals(this.tab + "_" + this.subTab + "_" + this.refreshType)) {
                return false;
            }
            this.requestKey = this.tab + "_" + this.subTab + "_" + this.refreshType;
            this.sessionId = "";
            this.refreshIndex = 1;
            c.a.y.b.d.b.b(11);
            a aVar = this.mModel;
            if (aVar != null) {
                aVar.h(c.a.y.b.d.b.a(), this.sessionId, this.refreshType, this.tab, this.channelId, this.subTab, this.refreshIndex);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setFeedConfigData(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.mFeedConfig = bVar;
        }
    }

    public void setFeedWrapData(LiveFeedWrapData liveFeedWrapData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, liveFeedWrapData) == null) {
            this.mFeedWrapData = liveFeedWrapData;
        }
    }
}
