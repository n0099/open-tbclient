package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.ThemeColorInfo;
import tbclient.ThreadRecommendTag;
/* loaded from: classes3.dex */
public class ThreadRecommendTagData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThemeColorInfo backgroundColor;
    public ThemeColorInfo boundaryColor;
    public String text;
    public ThemeColorInfo textColor;

    public ThreadRecommendTagData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ThemeColorInfo getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.backgroundColor;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public ThemeColorInfo getBoundaryColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.boundaryColor;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    public ThemeColorInfo getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.textColor;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public void parseProtobuf(ThreadRecommendTag threadRecommendTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadRecommendTag) == null) {
            this.text = threadRecommendTag.text;
            this.textColor = threadRecommendTag.text_color;
            this.backgroundColor = threadRecommendTag.background_color;
            this.boundaryColor = threadRecommendTag.boundary_color;
        }
    }
}
