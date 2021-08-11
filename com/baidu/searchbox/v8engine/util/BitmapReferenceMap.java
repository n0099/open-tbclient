package com.baidu.searchbox.v8engine.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.bean.ImageBitmapBean;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class BitmapReferenceMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BitmapReferenceMap";
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, ImageBitmapBean> map;

    public BitmapReferenceMap() {
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
        this.map = new HashMap<>();
    }

    public ImageBitmapBean decrease(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ImageBitmapBean imageBitmapBean = this.map.get(str);
            if (imageBitmapBean == null || imageBitmapBean.getBitmap() == null) {
                return null;
            }
            imageBitmapBean.decreaseRefCount();
            if (imageBitmapBean.getRefCount() <= 0) {
                return this.map.remove(str);
            }
            return null;
        }
        return (ImageBitmapBean) invokeL.objValue;
    }

    public ImageBitmapBean get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.map.get(str) : (ImageBitmapBean) invokeL.objValue;
    }

    public ImageBitmapBean put(String str, ImageBitmapBean imageBitmapBean) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, imageBitmapBean)) == null) ? this.map.put(str, imageBitmapBean) : (ImageBitmapBean) invokeLL.objValue;
    }

    public ImageBitmapBean remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.map.remove(str) : (ImageBitmapBean) invokeL.objValue;
    }
}
