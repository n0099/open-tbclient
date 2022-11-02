package com.baidu.searchbox.crius.ui.swiper;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class SwiperItemHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SwiperItemHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public List<CriusData> mBannerItems;

    public SwiperItemHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBannerItems = new LinkedList();
    }

    private void clear() {
        List<CriusData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && (list = this.mBannerItems) != null) {
            list.clear();
        }
    }

    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBannerItems.size();
        }
        return invokeV.intValue;
    }

    public void appendChildAt(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, criusData, i) == null) {
            if (i == 0 && getItemCount() > 0) {
                clear();
            }
            this.mBannerItems.add(i, criusData);
            if (CriusRuntime.DEBUG) {
                Log.d(TAG, "#appendChildAt#, index: " + i + ", size: " + this.mBannerItems.size());
            }
        }
    }

    public CriusData getNode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i < this.mBannerItems.size() && i >= 0) {
                return this.mBannerItems.get(i);
            }
            return null;
        }
        return (CriusData) invokeI.objValue;
    }
}
