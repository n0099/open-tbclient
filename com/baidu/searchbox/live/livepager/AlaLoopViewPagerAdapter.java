package com.baidu.searchbox.live.livepager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public SimpleArrayMap mPagerList;

    private void setRealRoomInfo(FrameLayout frameLayout, LiveContainer.LiveItemModel liveItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, frameLayout, liveItemModel) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    public AlaLoopViewPagerAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mPagerList = new SimpleArrayMap();
    }

    public FrameLayout getDefaultPage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return (FrameLayout) this.mPagerList.get(Integer.valueOf(i));
        }
        return (FrameLayout) invokeI.objValue;
    }

    public int getNextItemIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return ((getCount() + i) + 1) % getCount();
        }
        return invokeI.intValue;
    }

    public FrameLayout getPageBySelectedPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return (FrameLayout) this.mPagerList.get(Integer.valueOf(i));
        }
        return (FrameLayout) invokeI.objValue;
    }

    public int getPreItemIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return ((getCount() + i) - 1) % getCount();
        }
        return invokeI.intValue;
    }

    public void initPageLayoutList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mPagerList == null) {
                this.mPagerList = new SimpleArrayMap();
            }
            this.mPagerList.put(0, new FrameLayout(this.mContext));
            this.mPagerList.put(1, new FrameLayout(this.mContext));
            this.mPagerList.put(2, new FrameLayout(this.mContext));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) {
            if (this.mPagerList.get(Integer.valueOf(i)) != null && ((FrameLayout) this.mPagerList.get(Integer.valueOf(i))).getParent() != null) {
                ((ViewGroup) ((FrameLayout) this.mPagerList.get(Integer.valueOf(i))).getParent()).removeView((View) this.mPagerList.get(Integer.valueOf(i)));
            }
            if (this.mPagerList.get(Integer.valueOf(i)) != null) {
                viewGroup.addView((View) this.mPagerList.get(Integer.valueOf(i)));
            }
            return this.mPagerList.get(Integer.valueOf(i));
        }
        return invokeLI.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mPagerList.clear();
        }
    }

    public void setCurRoomInfo(int i, LiveContainer.LiveItemModel liveItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, liveItemModel) == null) {
            setRealRoomInfo((FrameLayout) this.mPagerList.get(Integer.valueOf(i)), liveItemModel);
        }
    }

    public void setNextRoomInfo(int i, LiveContainer.LiveItemModel liveItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, liveItemModel) == null) {
            setRealRoomInfo((FrameLayout) this.mPagerList.get(Integer.valueOf(getNextItemIndex(i))), liveItemModel);
        }
    }

    public void setPreRoomInfo(int i, LiveContainer.LiveItemModel liveItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, liveItemModel) == null) {
            setRealRoomInfo((FrameLayout) this.mPagerList.get(Integer.valueOf(getPreItemIndex(i))), liveItemModel);
        }
    }
}
