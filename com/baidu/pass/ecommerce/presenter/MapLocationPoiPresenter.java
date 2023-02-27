package com.baidu.pass.ecommerce.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.pass.ecommerce.callback.GetLocationCallback;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.mvp.BasePresenter;
import com.baidu.pass.ecommerce.common.mvp.IBaseView;
import com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack;
import com.baidu.pass.ecommerce.common.request.NetCallback;
import com.baidu.pass.ecommerce.request.AddressRequestFactory;
import com.baidu.sapi2.utils.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MapLocationPoiPresenter extends BasePresenter<IBaseView> implements GetLocationCallback {
    public static final int GET_LOCATION_CODE = 1001;
    public static final String KEY_BDSTOKEN = "bdstoken";
    public static final int LOC_QUERY_ADDR_LIST_CODE = 1004;
    public static final int MAP_LOCATION_2_REGION_CODE = 1005;
    public static final int MAP_LOC_TYPE = 0;
    public static final int SUGGEST_LIST_PAGE_SIZE = 20;
    public static final String TAG = "MapLocationPoiPresenter";
    public static final int USER_SEARCH_TYPE = 1;
    public String bdSTokenFromAddrEdit;
    public String currentUniqueTag;
    public double locLat4Api;
    public double locLng4Api;
    public String mapGeoAddrText;
    public String selectedAddrId;
    public String userSearchText;
    public MapObject paramsMap = new MapObject();
    public int queryAddrListType = 0;
    public int queryListPageNum = 0;
    public boolean hasNextPageByUserInput = true;
    public boolean hasNextPageByUserMapChoiceLoc = true;
    public List<JSONObject> addrListByUserInput = new ArrayList();
    public List<JSONObject> addrListByUserMapChoice = new ArrayList();

    public MapLocationPoiPresenter(Context context) {
    }

    public void mapLocItem2RegoinDetail(final JSONObject jSONObject) {
        if (TextUtils.isEmpty(this.bdSTokenFromAddrEdit)) {
            getBdStokenFromServer(1005, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.5
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i) {
                    MapLocationPoiPresenter.this.executeMapLocation2Region(jSONObject);
                }
            });
        } else {
            executeMapLocation2Region(jSONObject);
        }
    }

    public void queryAddrListByUserInputLoc(String str) {
        setSelectedAddrId("");
        this.userSearchText = str;
        queryNextPageAddrList(true);
    }

    public void queryNextPageAddrList(boolean z) {
        int i;
        if (1 == this.queryAddrListType) {
            this.paramsMap.putValue("query", this.userSearchText);
        } else {
            this.paramsMap.putValue("query", this.mapGeoAddrText);
        }
        if (z) {
            i = 0;
        } else {
            i = this.queryListPageNum + 1;
        }
        this.queryListPageNum = i;
        this.paramsMap.putValue(SuggestAddrField.KEY_PAGE_NUM, Integer.valueOf(i));
        locationQueryAddrList(this.paramsMap);
    }

    public void setBdSTokenFromAddrEdit(String str) {
        this.bdSTokenFromAddrEdit = str;
    }

    public void setQueryAddrListType(int i) {
        this.queryAddrListType = i;
    }

    public void setSelectedAddrId(String str) {
        this.selectedAddrId = str;
    }

    public void getBdStokenFromServer(final int i, final SyncActionCallBack syncActionCallBack) {
        AddressRequestFactory.newGetAddressListRequest().submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.1
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i2, String str) {
                MapLocationPoiPresenter.this.doFailure(i, i2, str);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                MapLocationPoiPresenter.this.bdSTokenFromAddrEdit = jSONObject.optString("bdstoken");
                Log.d(MapLocationPoiPresenter.TAG, "bdSToken from address list request is " + MapLocationPoiPresenter.this.bdSTokenFromAddrEdit);
                SyncActionCallBack syncActionCallBack2 = syncActionCallBack;
                if (syncActionCallBack2 != null) {
                    syncActionCallBack2.doNext(i);
                }
            }
        });
    }

    private MapObject createParamsByRegionInfo(ReverseGeoCodeResult reverseGeoCodeResult) {
        String str;
        MapObject mapObject = new MapObject();
        ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
        if (addressDetail != null) {
            Log.d(TAG, "province=" + addressDetail.province + " city=" + addressDetail.city);
            str = addressDetail.city;
            if (TextUtils.isEmpty(str)) {
                str = addressDetail.province;
            }
        } else {
            str = "";
        }
        mapObject.putValue("city_name", str);
        mapObject.putValue(SuggestAddrField.KEY_LAT, Double.valueOf(this.locLat4Api));
        mapObject.putValue(SuggestAddrField.KEY_LNG, Double.valueOf(this.locLng4Api));
        mapObject.putValue(SuggestAddrField.KEY_PAGE_SIZE, 20);
        return mapObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeMapLocation2Region(JSONObject jSONObject) {
        MapObject mapObject = new MapObject();
        mapObject.putValue("bdstoken", this.bdSTokenFromAddrEdit);
        mapObject.putValue(SuggestAddrField.KEY_MAP_NAME, jSONObject.optString(SuggestAddrField.KEY_MAP_NAME));
        mapObject.putValue(SuggestAddrField.KEY_MAP_ADDRESS, jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRESS));
        mapObject.putValue(SuggestAddrField.KEY_MAP_ADDRID, jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRID));
        mapObject.putValue(SuggestAddrField.KEY_MAP_PROVINCE, jSONObject.optString(SuggestAddrField.KEY_MAP_PROVINCE));
        mapObject.putValue(SuggestAddrField.KEY_MAP_CITY, jSONObject.optString(SuggestAddrField.KEY_MAP_CITY));
        mapObject.putValue(SuggestAddrField.KEY_MAP_DISTRICT, jSONObject.optString(SuggestAddrField.KEY_MAP_DISTRICT));
        mapObject.putValue(SuggestAddrField.KEY_MAP_LAT, Double.valueOf(jSONObject.optDouble(SuggestAddrField.KEY_MAP_LAT)));
        mapObject.putValue(SuggestAddrField.KEY_MAP_LNG, Double.valueOf(jSONObject.optDouble(SuggestAddrField.KEY_MAP_LNG)));
        AddressRequestFactory.newMapLoc2Region(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.6
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject2) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("addr_info");
                if (optJSONObject == null) {
                    return;
                }
                MapLocationPoiPresenter.this.doResult(1005, optJSONObject);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str) {
                MapLocationPoiPresenter.this.doFailure(1005, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAddrListByUserInput(JSONObject jSONObject) {
        boolean z;
        if (TextUtils.isEmpty(this.userSearchText)) {
            return;
        }
        if (isFirstPage()) {
            this.addrListByUserInput.clear();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(SuggestAddrField.KEY_QUERY_LIST);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            if (length >= 20) {
                z = true;
            } else {
                z = false;
            }
            this.hasNextPageByUserInput = z;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    this.addrListByUserInput.add(optJSONObject);
                } else {
                    Log.d(TAG, "updateAddrListByUserInput item of address list is error, index=" + i);
                }
            }
        } else {
            this.hasNextPageByUserInput = false;
        }
        doResult(1004, this.addrListByUserInput);
    }

    public void updateLatLngAndReverseGeoCode(LatLng latLng) {
        Log.d(TAG, "updateLatLngAndReverseGeoCode lat=" + latLng.latitude + ", lng=" + latLng.longitude);
        BDLocation convertBdLocation = OnceLocationManager.getInstance().convertBdLocation(latLng.latitude, latLng.longitude, "bd09ll");
        this.locLat4Api = convertBdLocation.getLatitude();
        this.locLng4Api = convertBdLocation.getLongitude();
        Log.d(TAG, "updateLatLngAndReverseGeoCode locLat4Api=" + this.locLat4Api + ", locLng4Api=" + this.locLng4Api);
        reverseGeoCode(latLng);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeLocationQueryAddrList(MapObject mapObject, final String str) {
        mapObject.putValue("bdstoken", this.bdSTokenFromAddrEdit);
        Log.d(TAG, "executeLocationQueryAddrList params: " + mapObject.toString());
        AddressRequestFactory.newLocationQueryAddrList(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.4
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str2) {
                if (!TextUtils.equals(str, MapLocationPoiPresenter.this.currentUniqueTag)) {
                    return;
                }
                if (1 == MapLocationPoiPresenter.this.queryAddrListType) {
                    MapLocationPoiPresenter.this.hasNextPageByUserInput = false;
                } else {
                    MapLocationPoiPresenter.this.hasNextPageByUserMapChoiceLoc = false;
                }
                MapLocationPoiPresenter.this.doFailure(1004, str2);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
                if (MapLocationPoiPresenter.this.isFirstPage()) {
                    MapLocationPoiPresenter.this.showLoading(1004);
                }
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                if (!TextUtils.equals(str, MapLocationPoiPresenter.this.currentUniqueTag)) {
                    return;
                }
                if (1 == MapLocationPoiPresenter.this.queryAddrListType) {
                    MapLocationPoiPresenter.this.updateAddrListByUserInput(jSONObject);
                } else {
                    MapLocationPoiPresenter.this.updateAddrListByUserMapChoice(jSONObject);
                }
            }
        });
    }

    @Override // com.baidu.pass.ecommerce.callback.GetLocationCallback
    public void onGetLocation(double d, double d2) {
        Log.d(TAG, "onGetLocation lat=" + d + ", lng=" + d2);
        if (d > 0.0d && d2 > 0.0d) {
            doResult(1001, new MyLocationData.Builder().latitude(d).longitude(d2).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstPage() {
        if (this.queryListPageNum == 0) {
            return true;
        }
        return false;
    }

    public void cleanUserSearchAndEmptyQueryContent() {
        this.addrListByUserInput.clear();
        this.userSearchText = "";
    }

    public List<JSONObject> getAddrList4AdapterShow() {
        if (1 == this.queryAddrListType) {
            return this.addrListByUserInput;
        }
        return this.addrListByUserMapChoice;
    }

    public List<JSONObject> getAddrListByUserInput() {
        return this.addrListByUserInput;
    }

    public List<JSONObject> getAddrListByUserMapChoice() {
        return this.addrListByUserMapChoice;
    }

    public String getSelectedAddrId() {
        return this.selectedAddrId;
    }

    public boolean isHasNextPage() {
        if (1 == this.queryAddrListType) {
            return this.hasNextPageByUserInput;
        }
        return this.hasNextPageByUserMapChoiceLoc;
    }

    public boolean isHasNextPageByUserInput() {
        return this.hasNextPageByUserInput;
    }

    public boolean isHasNextPageByUserMapChoiceLoc() {
        return this.hasNextPageByUserMapChoiceLoc;
    }

    public void queryAddrListByLocAddr() {
        setSelectedAddrId("");
        queryNextPageAddrList(true);
    }

    public void requestLocation() {
        Log.d(TAG, "requestLocation -------");
        OnceLocationManager.getInstance().requestLocation(this);
    }

    private void locationQueryAddrList(final MapObject mapObject) {
        this.currentUniqueTag = mapObject.getStrValue("city_name") + mapObject.getStrValue("query");
        if (TextUtils.isEmpty(this.bdSTokenFromAddrEdit)) {
            getBdStokenFromServer(1004, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.3
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i) {
                    MapLocationPoiPresenter mapLocationPoiPresenter = MapLocationPoiPresenter.this;
                    mapLocationPoiPresenter.executeLocationQueryAddrList(mapObject, mapLocationPoiPresenter.currentUniqueTag);
                }
            });
        } else {
            executeLocationQueryAddrList(mapObject, this.currentUniqueTag);
        }
    }

    public void processGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Log.d(TAG, "onGetReverseGeoCodeResult");
        if (reverseGeoCodeResult == null) {
            return;
        }
        this.paramsMap = createParamsByRegionInfo(reverseGeoCodeResult);
        String str = null;
        List<PoiInfo> poiList = reverseGeoCodeResult.getPoiList();
        if (poiList != null && poiList.size() > 0) {
            str = poiList.get(0).getName();
        }
        if (TextUtils.isEmpty(str)) {
            str = reverseGeoCodeResult.getAddress();
        }
        this.mapGeoAddrText = str;
        queryAddrListByLocAddr();
    }

    public void reverseGeoCode(LatLng latLng) {
        Log.d(TAG, "reverseGeoCode lat=" + latLng.latitude + ", lng=" + latLng.longitude);
        GeoCoder newInstance = GeoCoder.newInstance();
        newInstance.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.2
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    MapLocationPoiPresenter.this.processGetReverseGeoCodeResult(reverseGeoCodeResult);
                }
            }
        });
        newInstance.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAddrListByUserMapChoice(JSONObject jSONObject) {
        boolean z;
        if (isFirstPage()) {
            this.addrListByUserMapChoice.clear();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(SuggestAddrField.KEY_QUERY_LIST);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            if (length >= 20) {
                z = true;
            } else {
                z = false;
            }
            this.hasNextPageByUserMapChoiceLoc = z;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    this.addrListByUserMapChoice.add(optJSONObject);
                } else {
                    Log.d(TAG, "item of address list is error, index=" + i);
                }
            }
        } else {
            this.hasNextPageByUserMapChoiceLoc = false;
        }
        doResult(1004, this.addrListByUserMapChoice);
    }
}
