package com.baidu.pass.ecommerce.presenter;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class MapLocationPoiPresenter extends BasePresenter<IBaseView> implements GetLocationCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GET_LOCATION_CODE = 1001;
    public static final String KEY_BDSTOKEN = "bdstoken";
    public static final int LOC_QUERY_ADDR_LIST_CODE = 1004;
    public static final int MAP_LOCATION_2_REGION_CODE = 1005;
    public static final int MAP_LOC_TYPE = 0;
    public static final int SUGGEST_LIST_PAGE_SIZE = 20;
    public static final String TAG = "MapLocationPoiPresenter";
    public static final int USER_SEARCH_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public List<JSONObject> addrListByUserInput;
    public List<JSONObject> addrListByUserMapChoice;
    public String bdSTokenFromAddrEdit;
    public String currentUniqueTag;
    public boolean hasNextPageByUserInput;
    public boolean hasNextPageByUserMapChoiceLoc;
    public double locLat4Api;
    public double locLng4Api;
    public String mapGeoAddrText;
    public MapObject paramsMap;
    public int queryAddrListType;
    public int queryListPageNum;
    public String selectedAddrId;
    public String userSearchText;

    public MapLocationPoiPresenter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.paramsMap = new MapObject();
        this.queryAddrListType = 0;
        this.queryListPageNum = 0;
        this.hasNextPageByUserInput = true;
        this.hasNextPageByUserMapChoiceLoc = true;
        this.addrListByUserInput = new ArrayList();
        this.addrListByUserMapChoice = new ArrayList();
    }

    private MapObject createParamsByRegionInfo(ReverseGeoCodeResult reverseGeoCodeResult) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, reverseGeoCodeResult)) == null) {
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
            mapObject.putValue("page_size", 20);
            return mapObject;
        }
        return (MapObject) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeLocationQueryAddrList(MapObject mapObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, mapObject, str) == null) {
            mapObject.putValue("bdstoken", this.bdSTokenFromAddrEdit);
            Log.d(TAG, "executeLocationQueryAddrList params: " + mapObject.toString());
            AddressRequestFactory.newLocationQueryAddrList(mapObject).submit(new NetCallback(this, str) { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationPoiPresenter this$0;
                public final /* synthetic */ String val$uniqueTag;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uniqueTag = str;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) && TextUtils.equals(this.val$uniqueTag, this.this$0.currentUniqueTag)) {
                        if (1 == this.this$0.queryAddrListType) {
                            this.this$0.hasNextPageByUserInput = false;
                        } else {
                            this.this$0.hasNextPageByUserMapChoiceLoc = false;
                        }
                        this.this$0.doFailure(1004, str2);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.this$0.isFirstPage()) {
                        this.this$0.showLoading(1004);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) && TextUtils.equals(this.val$uniqueTag, this.this$0.currentUniqueTag)) {
                        if (1 == this.this$0.queryAddrListType) {
                            this.this$0.updateAddrListByUserInput(jSONObject);
                        } else {
                            this.this$0.updateAddrListByUserMapChoice(jSONObject);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeMapLocation2Region(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, jSONObject) == null) {
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
            AddressRequestFactory.newMapLoc2Region(mapObject).submit(new NetCallback(this) { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationPoiPresenter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.this$0.doFailure(1005, i2, str);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject2) {
                    JSONObject optJSONObject;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject2) == null) || (optJSONObject = jSONObject2.optJSONObject("addr_info")) == null) {
                        return;
                    }
                    this.this$0.doResult(1005, optJSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? this.queryListPageNum == 0 : invokeV.booleanValue;
    }

    private void locationQueryAddrList(MapObject mapObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, mapObject) == null) {
            this.currentUniqueTag = mapObject.getStrValue("city_name") + mapObject.getStrValue("query");
            if (TextUtils.isEmpty(this.bdSTokenFromAddrEdit)) {
                getBdStokenFromServer(1004, new SyncActionCallBack(this, mapObject) { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MapLocationPoiPresenter this$0;
                    public final /* synthetic */ MapObject val$paramsMap;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, mapObject};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$paramsMap = mapObject;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            MapLocationPoiPresenter mapLocationPoiPresenter = this.this$0;
                            mapLocationPoiPresenter.executeLocationQueryAddrList(this.val$paramsMap, mapLocationPoiPresenter.currentUniqueTag);
                        }
                    }
                });
            } else {
                executeLocationQueryAddrList(mapObject, this.currentUniqueTag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAddrListByUserInput(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, jSONObject) == null) || TextUtils.isEmpty(this.userSearchText)) {
            return;
        }
        if (isFirstPage()) {
            this.addrListByUserInput.clear();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(SuggestAddrField.KEY_QUERY_LIST);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            this.hasNextPageByUserInput = length >= 20;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    this.addrListByUserInput.add(optJSONObject);
                } else {
                    Log.d(TAG, "updateAddrListByUserInput item of address list is error, index=" + i2);
                }
            }
        } else {
            this.hasNextPageByUserInput = false;
        }
        doResult(1004, this.addrListByUserInput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAddrListByUserMapChoice(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, jSONObject) == null) {
            if (isFirstPage()) {
                this.addrListByUserMapChoice.clear();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(SuggestAddrField.KEY_QUERY_LIST);
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int length = optJSONArray.length();
                this.hasNextPageByUserMapChoiceLoc = length >= 20;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.addrListByUserMapChoice.add(optJSONObject);
                    } else {
                        Log.d(TAG, "item of address list is error, index=" + i2);
                    }
                }
            } else {
                this.hasNextPageByUserMapChoiceLoc = false;
            }
            doResult(1004, this.addrListByUserMapChoice);
        }
    }

    public void cleanUserSearchAndEmptyQueryContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.addrListByUserInput.clear();
            this.userSearchText = "";
        }
    }

    public List<JSONObject> getAddrList4AdapterShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (1 == this.queryAddrListType) {
                return this.addrListByUserInput;
            }
            return this.addrListByUserMapChoice;
        }
        return (List) invokeV.objValue;
    }

    public List<JSONObject> getAddrListByUserInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.addrListByUserInput : (List) invokeV.objValue;
    }

    public List<JSONObject> getAddrListByUserMapChoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.addrListByUserMapChoice : (List) invokeV.objValue;
    }

    public void getBdStokenFromServer(int i2, SyncActionCallBack syncActionCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, syncActionCallBack) == null) {
            AddressRequestFactory.newGetAddressListRequest().submit(new NetCallback(this, syncActionCallBack, i2) { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationPoiPresenter this$0;
                public final /* synthetic */ int val$fromActionCode;
                public final /* synthetic */ SyncActionCallBack val$syncActionCallBack;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, syncActionCallBack, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$syncActionCallBack = syncActionCallBack;
                    this.val$fromActionCode = i2;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str) == null) {
                        this.this$0.doFailure(this.val$fromActionCode, i3, str);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                        this.this$0.bdSTokenFromAddrEdit = jSONObject.optString("bdstoken");
                        Log.d(MapLocationPoiPresenter.TAG, "bdSToken from address list request is " + this.this$0.bdSTokenFromAddrEdit);
                        SyncActionCallBack syncActionCallBack2 = this.val$syncActionCallBack;
                        if (syncActionCallBack2 != null) {
                            syncActionCallBack2.doNext(this.val$fromActionCode);
                        }
                    }
                }
            });
        }
    }

    public String getSelectedAddrId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.selectedAddrId : (String) invokeV.objValue;
    }

    public boolean isHasNextPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (1 == this.queryAddrListType) {
                return this.hasNextPageByUserInput;
            }
            return this.hasNextPageByUserMapChoiceLoc;
        }
        return invokeV.booleanValue;
    }

    public boolean isHasNextPageByUserInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.hasNextPageByUserInput : invokeV.booleanValue;
    }

    public boolean isHasNextPageByUserMapChoiceLoc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.hasNextPageByUserMapChoiceLoc : invokeV.booleanValue;
    }

    public void mapLocItem2RegoinDetail(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            if (TextUtils.isEmpty(this.bdSTokenFromAddrEdit)) {
                getBdStokenFromServer(1005, new SyncActionCallBack(this, jSONObject) { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MapLocationPoiPresenter this$0;
                    public final /* synthetic */ JSONObject val$jsonObj;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jSONObject};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$jsonObj = jSONObject;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.executeMapLocation2Region(this.val$jsonObj);
                        }
                    }
                });
            } else {
                executeMapLocation2Region(jSONObject);
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.callback.GetLocationCallback
    public void onGetLocation(double d2, double d3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)}) == null) {
            Log.d(TAG, "onGetLocation lat=" + d2 + ", lng=" + d3);
            if (d2 <= 0.0d || d3 <= 0.0d) {
                return;
            }
            doResult(1001, new MyLocationData.Builder().latitude(d2).longitude(d3).build());
        }
    }

    public void processGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, reverseGeoCodeResult) == null) {
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
    }

    public void queryAddrListByLocAddr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            setSelectedAddrId("");
            queryNextPageAddrList(true);
        }
    }

    public void queryAddrListByUserInputLoc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            setSelectedAddrId("");
            this.userSearchText = str;
            queryNextPageAddrList(true);
        }
    }

    public void queryNextPageAddrList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (1 == this.queryAddrListType) {
                this.paramsMap.putValue("query", this.userSearchText);
            } else {
                this.paramsMap.putValue("query", this.mapGeoAddrText);
            }
            int i2 = z ? 0 : this.queryListPageNum + 1;
            this.queryListPageNum = i2;
            this.paramsMap.putValue(SuggestAddrField.KEY_PAGE_NUM, Integer.valueOf(i2));
            locationQueryAddrList(this.paramsMap);
        }
    }

    public void requestLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Log.d(TAG, "requestLocation -------");
            OnceLocationManager.getInstance().requestLocation(this);
        }
    }

    public void reverseGeoCode(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, latLng) == null) {
            Log.d(TAG, "reverseGeoCode lat=" + latLng.latitude + ", lng=" + latLng.longitude);
            GeoCoder newInstance = GeoCoder.newInstance();
            newInstance.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener(this) { // from class: com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MapLocationPoiPresenter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
                public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, geoCodeResult) == null) {
                    }
                }

                @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
                public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
                        this.this$0.processGetReverseGeoCodeResult(reverseGeoCodeResult);
                    }
                }
            });
            newInstance.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    public void setBdSTokenFromAddrEdit(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.bdSTokenFromAddrEdit = str;
        }
    }

    public void setQueryAddrListType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.queryAddrListType = i2;
        }
    }

    public void setSelectedAddrId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.selectedAddrId = str;
        }
    }

    public void updateLatLngAndReverseGeoCode(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, latLng) == null) {
            Log.d(TAG, "updateLatLngAndReverseGeoCode lat=" + latLng.latitude + ", lng=" + latLng.longitude);
            BDLocation convertBdLocation = OnceLocationManager.getInstance().convertBdLocation(latLng.latitude, latLng.longitude, "bd09ll");
            this.locLat4Api = convertBdLocation.getLatitude();
            this.locLng4Api = convertBdLocation.getLongitude();
            Log.d(TAG, "updateLatLngAndReverseGeoCode locLat4Api=" + this.locLat4Api + ", locLng4Api=" + this.locLng4Api);
            reverseGeoCode(latLng);
        }
    }
}
