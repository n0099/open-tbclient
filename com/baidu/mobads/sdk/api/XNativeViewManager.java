package com.baidu.mobads.sdk.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class XNativeViewManager {
    public static /* synthetic */ Interceptable $ic;
    public static XNativeViewManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<XNativeView> mViewList;

    public XNativeViewManager() {
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
        this.mViewList = new ArrayList<>();
    }

    public static XNativeViewManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (XNativeViewManager.class) {
                    if (sInstance == null) {
                        sInstance = new XNativeViewManager();
                    }
                }
            }
            return sInstance;
        }
        return (XNativeViewManager) invokeV.objValue;
    }

    public void addItem(XNativeView xNativeView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xNativeView) == null) {
            this.mViewList.add(xNativeView);
        }
    }

    public void removeNativeView(XNativeView xNativeView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xNativeView) != null) || this.mViewList.size() == 0) {
            return;
        }
        this.mViewList.remove(xNativeView);
    }

    public void resetAllPlayer(XNativeView xNativeView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xNativeView) != null) || this.mViewList.size() == 0) {
            return;
        }
        Iterator<XNativeView> it = this.mViewList.iterator();
        while (it.hasNext()) {
            XNativeView next = it.next();
            if (next != xNativeView) {
                next.stop();
                next.handleCover();
            }
        }
    }
}
