package com.baidu.browser.sailor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebHistoryItem;
/* loaded from: classes5.dex */
public class BdSailorWebBackForwardList implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebBackForwardList mBackForwardList;

    public BdSailorWebBackForwardList(WebBackForwardList webBackForwardList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webBackForwardList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBackForwardList = webBackForwardList;
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBackForwardList.getCurrentIndex() : invokeV.intValue;
    }

    public BdSailorWebHistoryItem getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WebHistoryItem currentItem = this.mBackForwardList.getCurrentItem();
            if (currentItem != null) {
                return new BdSailorWebHistoryItem(currentItem);
            }
            return null;
        }
        return (BdSailorWebHistoryItem) invokeV.objValue;
    }

    public BdSailorWebHistoryItem getItemAtIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new BdSailorWebHistoryItem(this.mBackForwardList.getItemAtIndex(i2)) : (BdSailorWebHistoryItem) invokeI.objValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBackForwardList.getSize() : invokeV.intValue;
    }
}
