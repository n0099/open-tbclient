package com.baidu.pass.ecommerce.request;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.request.BaseMapObjectRequest;
import com.baidu.pass.ecommerce.common.request.BaseRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AddressRequestFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADDRESS_GET_REGION = "/address/get/region";
    public static final String ADD_ADDRESS_URL = "/v3/ucenter/addr/additem";
    public static final String DEL_ADDRESS_URL = "/v3/ucenter/addr/deleteitem";
    public static final String GET_ADDRESS_LIST_URL = "/v3/ucenter/addr/myaddr";
    public static final String IGNORE_NUOMI_ADDRESS_URL = "/v3/ucenter/addr/ignorenuomi";
    public static final String IMG_OCR_URL = "/v3/ucenter/addr/ocrdetect";
    public static final String IMPORT_NUOMI_ADDRESS_URL = "/v3/ucenter/addr/importnuomi";
    public static final String LOC_BASE_QUERY_URL = "/v3/ucenter/addr/locationbasedquery";
    public static final String LONG_TEXT_RECOGNISE_URL = "/v3/ucenter/addr/longaddrsplit";
    public static final String MAP_LOC_2_REGION_URL = "/v3/ucenter/addr/maplocation2id";
    public static final String SUGGEST_DETAIL_URL = "/v3/ucenter/addr/suggestdetail";
    public static final String SUGGEST_LIST_URL = "/v3/ucenter/addr/suggestlist";
    public static final String UPDATE_ADDRESS_URL = "/v3/ucenter/addr/edititem";
    public transient /* synthetic */ FieldHolder $fh;

    public AddressRequestFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static BaseRequest newAddAddrRequest(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mapObject)) == null) ? new BaseMapObjectRequest(ADD_ADDRESS_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newAddressGetRegion(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mapObject)) == null) ? new BaseMapObjectRequest(ADDRESS_GET_REGION, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newDelAddressRequest(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, mapObject)) == null) ? new BaseMapObjectRequest(DEL_ADDRESS_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newGetAddressListRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new BaseMapObjectRequest(GET_ADDRESS_LIST_URL, null) : (BaseRequest) invokeV.objValue;
    }

    public static BaseRequest newIgnoreNuoMiAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? new BaseMapObjectRequest(IGNORE_NUOMI_ADDRESS_URL, null) : (BaseRequest) invokeV.objValue;
    }

    public static BaseRequest newImportNuoMiAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new BaseMapObjectRequest(IMPORT_NUOMI_ADDRESS_URL, null) : (BaseRequest) invokeV.objValue;
    }

    public static BaseRequest newLocationQueryAddrList(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mapObject)) == null) ? new BaseMapObjectRequest(LOC_BASE_QUERY_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newMapLoc2Region(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, mapObject)) == null) ? new BaseMapObjectRequest(MAP_LOC_2_REGION_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newOCRImg2Address(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, mapObject)) == null) ? new BaseMapObjectRequest(IMG_OCR_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newRecogniseText2Address(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, mapObject)) == null) ? new BaseMapObjectRequest(LONG_TEXT_RECOGNISE_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newSuggestDetailRequest(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, mapObject)) == null) ? new BaseMapObjectRequest(SUGGEST_DETAIL_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newSuggestListRequest(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, mapObject)) == null) ? new BaseMapObjectRequest(SUGGEST_LIST_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }

    public static BaseRequest newUpdateAddressRequest(MapObject mapObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, mapObject)) == null) ? new BaseMapObjectRequest(UPDATE_ADDRESS_URL, mapObject) : (BaseRequest) invokeL.objValue;
    }
}
