package com.baidu.searchbox.ui.bubble;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class BubbleHistory {
    public static /* synthetic */ Interceptable $ic;
    public static BubbleHistory sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> mBubbleHistoryTxtList;
    public List<String> mOpHisList;

    public BubbleHistory() {
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
        this.mBubbleHistoryTxtList = new ArrayList();
        this.mOpHisList = new ArrayList();
    }

    public static BubbleHistory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (BubbleHistory.class) {
                    if (sInstance == null) {
                        sInstance = new BubbleHistory();
                    }
                }
            }
            return sInstance;
        }
        return (BubbleHistory) invokeV.objValue;
    }

    public static void release() {
        BubbleHistory bubbleHistory;
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (bubbleHistory = sInstance) == null || (list = bubbleHistory.mBubbleHistoryTxtList) == null || bubbleHistory.mOpHisList == null) {
            return;
        }
        list.clear();
        sInstance.mOpHisList.clear();
        BubbleHistory bubbleHistory2 = sInstance;
        bubbleHistory2.mBubbleHistoryTxtList = null;
        bubbleHistory2.mOpHisList = null;
    }

    public List getBubbleHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBubbleHistoryTxtList : (List) invokeV.objValue;
    }

    public List getBubbleOpHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mOpHisList : (List) invokeV.objValue;
    }

    public synchronized void trackBubbleHistory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (this.mBubbleHistoryTxtList != null) {
                    this.mBubbleHistoryTxtList.add(str);
                }
            }
        }
    }

    public synchronized void trackBubbleOpHistory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this) {
                if (this.mOpHisList != null) {
                    this.mOpHisList.add(str);
                }
            }
        }
    }
}
