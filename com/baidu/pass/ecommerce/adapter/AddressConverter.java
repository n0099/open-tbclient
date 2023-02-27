package com.baidu.pass.ecommerce.adapter;

import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.common.JsonFieldConverter;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddressConverter {
    public static final String TAG = "AddrInfoConverter";

    public static JSONObject convertMapObj2AddrJsonObj(MapObject mapObject) {
        JSONObject jSONObject = new JSONObject();
        JsonFieldConverter.putStr(AddressField.KEY_ADDR_ID, mapObject, jSONObject);
        JsonFieldConverter.putStr("name", mapObject, jSONObject);
        JsonFieldConverter.putStr("mobile", mapObject, jSONObject);
        JsonFieldConverter.putStr(AddressField.KEY_MOBILE_COUNTRY_CODE, mapObject, jSONObject);
        JsonFieldConverter.putStr("tag", mapObject, jSONObject);
        JsonFieldConverter.putInt(AddressField.KEY_IS_DEFAULT, mapObject, jSONObject);
        JsonFieldConverter.putStr(AddressField.KEY_ZIP_CODE, mapObject, jSONObject);
        return jSONObject;
    }

    public static JSONObject convertRegion2RegionJsonObj(AddressSelectedBean addressSelectedBean) {
        JSONObject jSONObject = new JSONObject();
        if (addressSelectedBean == null) {
            return jSONObject;
        }
        try {
            jSONObject.put(AddressField.KEY_COUNTRY_ID, addressSelectedBean.countryId);
            jSONObject.put(AddressField.KEY_COUNTRY_NAME, addressSelectedBean.countryName);
            jSONObject.put(AddressField.KEY_PROVINCE_ID, addressSelectedBean.provinceId);
            jSONObject.put(AddressField.KEY_PROVINCE_NAME, addressSelectedBean.provinceName);
            jSONObject.put(AddressField.KEY_CITY_ID, addressSelectedBean.cityId);
            jSONObject.put("city_name", addressSelectedBean.cityName);
            jSONObject.put(AddressField.KEY_DISTRICT_ID, addressSelectedBean.districtId);
            jSONObject.put(AddressField.KEY_DISTRICT_NAME, addressSelectedBean.districtName);
            jSONObject.put(AddressField.KEY_TOWN_ID, addressSelectedBean.townId);
            jSONObject.put(AddressField.KEY_TOWN_NAME, addressSelectedBean.townName);
        } catch (JSONException e) {
            Log.e(TAG, "convert region to JsonObj is error " + e.getMessage());
        }
        return jSONObject;
    }

    public static AddressSelectedBean convertRegionJsonObj2Region(JSONObject jSONObject) {
        AddressSelectedBean addressSelectedBean = new AddressSelectedBean();
        if (jSONObject == null) {
            return null;
        }
        addressSelectedBean.countryId = jSONObject.optString(AddressField.KEY_COUNTRY_ID);
        addressSelectedBean.countryName = jSONObject.optString(AddressField.KEY_COUNTRY_NAME);
        addressSelectedBean.provinceId = jSONObject.optString(AddressField.KEY_PROVINCE_ID);
        addressSelectedBean.provinceName = jSONObject.optString(AddressField.KEY_PROVINCE_NAME);
        addressSelectedBean.cityId = jSONObject.optString(AddressField.KEY_CITY_ID);
        addressSelectedBean.cityName = jSONObject.optString("city_name");
        addressSelectedBean.districtId = jSONObject.optString(AddressField.KEY_DISTRICT_ID);
        addressSelectedBean.districtName = jSONObject.optString(AddressField.KEY_DISTRICT_NAME);
        addressSelectedBean.townId = jSONObject.optString(AddressField.KEY_TOWN_ID);
        addressSelectedBean.townName = jSONObject.optString(AddressField.KEY_TOWN_NAME);
        return addressSelectedBean;
    }

    public static JSONObject createAddressJsonObj(MapObject mapObject, AddressSelectedBean addressSelectedBean) {
        JSONObject convertMapObj2AddrJsonObj = convertMapObj2AddrJsonObj(mapObject);
        JSONObject convertRegion2RegionJsonObj = convertRegion2RegionJsonObj(addressSelectedBean);
        JsonFieldConverter.putStr(AddressField.KEY_DETAIL_ADDR, mapObject, convertRegion2RegionJsonObj);
        JsonFieldConverter.putJsonObj("addr_info", convertRegion2RegionJsonObj, convertMapObj2AddrJsonObj);
        return convertMapObj2AddrJsonObj;
    }
}
