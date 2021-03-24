package com.baidu.pass.ecommerce.request;

import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.request.BaseMapObjectRequest;
import com.baidu.pass.ecommerce.common.request.BaseRequest;
/* loaded from: classes2.dex */
public class AddressRequestFactory {
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

    public static BaseRequest newAddAddrRequest(MapObject mapObject) {
        return new BaseMapObjectRequest(ADD_ADDRESS_URL, mapObject);
    }

    public static BaseRequest newAddressGetRegion(MapObject mapObject) {
        return new BaseMapObjectRequest(ADDRESS_GET_REGION, mapObject);
    }

    public static BaseRequest newDelAddressRequest(MapObject mapObject) {
        return new BaseMapObjectRequest(DEL_ADDRESS_URL, mapObject);
    }

    public static BaseRequest newGetAddressListRequest() {
        return new BaseMapObjectRequest(GET_ADDRESS_LIST_URL, null);
    }

    public static BaseRequest newIgnoreNuoMiAddress() {
        return new BaseMapObjectRequest(IGNORE_NUOMI_ADDRESS_URL, null);
    }

    public static BaseRequest newImportNuoMiAddress() {
        return new BaseMapObjectRequest(IMPORT_NUOMI_ADDRESS_URL, null);
    }

    public static BaseRequest newLocationQueryAddrList(MapObject mapObject) {
        return new BaseMapObjectRequest(LOC_BASE_QUERY_URL, mapObject);
    }

    public static BaseRequest newMapLoc2Region(MapObject mapObject) {
        return new BaseMapObjectRequest(MAP_LOC_2_REGION_URL, mapObject);
    }

    public static BaseRequest newOCRImg2Address(MapObject mapObject) {
        return new BaseMapObjectRequest(IMG_OCR_URL, mapObject);
    }

    public static BaseRequest newRecogniseText2Address(MapObject mapObject) {
        return new BaseMapObjectRequest(LONG_TEXT_RECOGNISE_URL, mapObject);
    }

    public static BaseRequest newSuggestDetailRequest(MapObject mapObject) {
        return new BaseMapObjectRequest(SUGGEST_DETAIL_URL, mapObject);
    }

    public static BaseRequest newSuggestListRequest(MapObject mapObject) {
        return new BaseMapObjectRequest(SUGGEST_LIST_URL, mapObject);
    }

    public static BaseRequest newUpdateAddressRequest(MapObject mapObject) {
        return new BaseMapObjectRequest(UPDATE_ADDRESS_URL, mapObject);
    }
}
