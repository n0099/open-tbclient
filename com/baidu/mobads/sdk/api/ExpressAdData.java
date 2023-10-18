package com.baidu.mobads.sdk.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class ExpressAdData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adPlaceId;
    public String desc;
    public String iconUrl;
    public String imageUrl;
    public List<String> multiPicUrls;
    public String pk;
    public String title;
    public String videoUrl;

    public ExpressAdData(a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adPlaceId = "";
        this.title = "";
        this.desc = "";
        this.iconUrl = "";
        this.pk = "";
        this.imageUrl = "";
        this.videoUrl = "";
        this.multiPicUrls = null;
        this.adPlaceId = str;
        this.title = aVar.a();
        this.desc = aVar.b();
        this.iconUrl = aVar.c();
        this.pk = aVar.m();
        this.imageUrl = aVar.d();
        this.videoUrl = aVar.n();
        this.multiPicUrls = aVar.G();
    }

    public String getAdPlaceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.adPlaceId;
        }
        return (String) invokeV.objValue;
    }

    public String getAppPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.pk;
        }
        return (String) invokeV.objValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.desc;
        }
        return (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.imageUrl;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getMultiPicUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.multiPicUrls;
        }
        return (List) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.videoUrl;
        }
        return (String) invokeV.objValue;
    }
}
