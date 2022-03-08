package com.baidu.pass.ecommerce.presenter;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.mvp.BasePresenter;
import com.baidu.pass.ecommerce.common.mvp.IBaseView;
import com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack;
import com.baidu.pass.ecommerce.common.request.NetCallback;
import com.baidu.pass.ecommerce.request.AddressRequestFactory;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.sapi2.ecommerce.result.RegionList;
import com.baidu.sapi2.utils.Log;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AddressEditPresenter extends BasePresenter<IBaseView> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CREATE_ADDR_CODE = 1004;
    public static final int DEL_ADDR_CODE = 1002;
    public static final String KEY_BDSTOKEN = "bdstoken";
    public static final int OCR_IMG_ADDR_CODE = 3001;
    public static final int RECOGNISE_TEXT_ADDR_CODE = 3002;
    public static final int RECOGNISE_TEXT_ADDR_FROM_CLIPBOARD_CODE = 3003;
    public static final int SUGGEST_ADDR_DETAIL_CODE = 2002;
    public static final int SUGGEST_ADDR_LIST_CODE = 2001;
    public static final String TAG = "AddressEditPresenter";
    public static final int UPDATE_ADDR_CODE = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public String bdSTokenFromAddrList;

    public AddressEditPresenter() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void executeCreateAddrRequest(MapObject mapObject, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, this, mapObject, addressSelectedBean) == null) {
            MapObject mapObject2 = new MapObject();
            mapObject2.putValue("bdstoken", this.bdSTokenFromAddrList);
            mapObject2.putValue("name", mapObject.getStrValue("name"));
            mapObject2.putValue("mobile", mapObject.getStrValue("mobile"));
            mapObject2.putValue(AddressField.KEY_MOBILE_COUNTRY_CODE, mapObject.getStrValue(AddressField.KEY_MOBILE_COUNTRY_CODE));
            mapObject2.putValue("tag", mapObject.getStrValue("tag"));
            mapObject2.putValue(AddressField.KEY_IS_DEFAULT, Integer.valueOf(mapObject.getIntValue(AddressField.KEY_IS_DEFAULT)));
            mapObject2.putValue(AddressField.KEY_ZIP_CODE, mapObject.getStrValue(AddressField.KEY_ZIP_CODE));
            mapObject2.putValue(AddressField.KEY_DETAIL_ADDR, mapObject.getStrValue(AddressField.KEY_DETAIL_ADDR));
            mapObject2.putValue("region_list", RegionList.generateRegionList(addressSelectedBean).regionListStr);
            AddressRequestFactory.newAddAddrRequest(mapObject2).submit(new NetCallback(this) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditPresenter this$0;

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
                        this.this$0.doFailure(1004, i2, str);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.showLoading(1004);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                        String optString = jSONObject.optString(AddressField.KEY_ADDR_ID);
                        if (TextUtils.isEmpty(optString)) {
                            this.this$0.doFailure(1004, -10000, "未知错误");
                        } else {
                            this.this$0.doResult(1004, optString);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeImgOcrRequest(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, str) == null) {
            MapObject mapObject = new MapObject();
            mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
            mapObject.putValue("img", str);
            AddressRequestFactory.newOCRImg2Address(mapObject).submit(new NetCallback(this) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditPresenter this$0;

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
                public void onFailure(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.this$0.doFailure(3001, i2, str2);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.showLoading(3001);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                        this.this$0.doResult(3001, jSONObject.optString("text"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRecogniseTextRequest(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65567, this, str, i2) == null) {
            MapObject mapObject = new MapObject();
            mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
            mapObject.putValue("text", str);
            AddressRequestFactory.newRecogniseText2Address(mapObject).submit(new NetCallback(this, i2) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditPresenter this$0;
                public final /* synthetic */ int val$fromActionCode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
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
                    this.val$fromActionCode = i2;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str2) == null) {
                        this.this$0.doFailure(this.val$fromActionCode, i3, str2);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.showLoading(this.val$fromActionCode);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                        this.this$0.doResult(this.val$fromActionCode, jSONObject.optJSONObject("data"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeSuggestAddrDetailRequest(JSONObject jSONObject, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, this, jSONObject, addressSelectedBean) == null) {
            MapObject mapObject = new MapObject();
            mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                mapObject.putValue(next, jSONObject.optString(next));
            }
            RegionList generateRegionList = RegionList.generateRegionList(addressSelectedBean);
            mapObject.putValue("region_list", generateRegionList.regionListStr);
            mapObject.putValue(SuggestAddrField.KEY_TYPE_LIST, generateRegionList.typeListStr);
            mapObject.putValue(SuggestAddrField.KEY_NAME_LIST, generateRegionList.nameListStr);
            AddressRequestFactory.newSuggestDetailRequest(mapObject).submit(new NetCallback(this) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditPresenter this$0;

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
                        this.this$0.doFailure(2002, i2, str);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject2) == null) {
                        this.this$0.doResult(2002, jSONObject2.optJSONObject("addr_info"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeUpdateAddrRequest(String str, MapObject mapObject, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, this, str, mapObject, addressSelectedBean) == null) {
            MapObject mapObject2 = new MapObject();
            mapObject2.putValue("bdstoken", this.bdSTokenFromAddrList);
            if (!TextUtils.isEmpty(str)) {
                mapObject2.putValue("mobile", str);
            }
            mapObject2.putValue(AddressField.KEY_ADDR_ID, mapObject.getStrValue(AddressField.KEY_ADDR_ID));
            mapObject2.putValue("name", mapObject.getStrValue("name"));
            mapObject2.putValue(AddressField.KEY_MOBILE_COUNTRY_CODE, mapObject.getStrValue(AddressField.KEY_MOBILE_COUNTRY_CODE));
            mapObject2.putValue("tag", mapObject.getStrValue("tag"));
            mapObject2.putValue(AddressField.KEY_IS_DEFAULT, Integer.valueOf(mapObject.getIntValue(AddressField.KEY_IS_DEFAULT)));
            mapObject2.putValue(AddressField.KEY_ZIP_CODE, mapObject.getStrValue(AddressField.KEY_ZIP_CODE));
            mapObject2.putValue(AddressField.KEY_DETAIL_ADDR, mapObject.getStrValue(AddressField.KEY_DETAIL_ADDR));
            if (addressSelectedBean != null) {
                mapObject2.putValue("region_list", RegionList.generateRegionList(addressSelectedBean).regionListStr);
            }
            AddressRequestFactory.newUpdateAddressRequest(mapObject2).submit(new NetCallback(this) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditPresenter this$0;

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
                public void onFailure(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.this$0.doFailure(1001, i2, str2);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.showLoading(1001);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                        this.this$0.doResult(1001, jSONObject);
                    }
                }
            });
        }
    }

    public void createAddress(MapObject mapObject, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, mapObject, addressSelectedBean) == null) {
            if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
                getBdStokenFromServer(1004, new SyncActionCallBack(this, mapObject, addressSelectedBean) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressEditPresenter this$0;
                    public final /* synthetic */ MapObject val$mapObject;
                    public final /* synthetic */ AddressSelectedBean val$selectedRegion;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, mapObject, addressSelectedBean};
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
                        this.val$mapObject = mapObject;
                        this.val$selectedRegion = addressSelectedBean;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.executeCreateAddrRequest(this.val$mapObject, this.val$selectedRegion);
                        }
                    }
                });
            } else {
                executeCreateAddrRequest(mapObject, addressSelectedBean);
            }
        }
    }

    public void delAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
                getBdStokenFromServer(1002, new SyncActionCallBack(this, str) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressEditPresenter this$0;
                    public final /* synthetic */ String val$addressId;

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
                        this.val$addressId = str;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.executeDelAddrRequest(this.val$addressId);
                        }
                    }
                });
            } else {
                executeDelAddrRequest(str);
            }
        }
    }

    public void executeDelAddrRequest(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            MapObject mapObject = new MapObject();
            mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
            mapObject.putValue(AddressField.KEY_ADDR_ID, str);
            AddressRequestFactory.newDelAddressRequest(mapObject).submit(new NetCallback(this, str) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditPresenter this$0;
                public final /* synthetic */ String val$addressId;

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
                    this.val$addressId = str;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.this$0.doFailure(1002, i2, str2);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                        this.this$0.doResult(1002, jSONObject, this.val$addressId);
                    }
                }
            });
        }
    }

    public void executeSuggestAddrListRequest(String str, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, addressSelectedBean) == null) {
            MapObject mapObject = new MapObject();
            mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
            mapObject.putValue("query", str);
            RegionList generateRegionList = RegionList.generateRegionList(addressSelectedBean);
            mapObject.putValue("region_list", generateRegionList.regionListStr);
            mapObject.putValue(SuggestAddrField.KEY_TYPE_LIST, generateRegionList.typeListStr);
            mapObject.putValue(SuggestAddrField.KEY_NAME_LIST, generateRegionList.nameListStr);
            AddressRequestFactory.newSuggestListRequest(mapObject).submit(new NetCallback(this, str) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditPresenter this$0;
                public final /* synthetic */ String val$queryText;

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
                    this.val$queryText = str;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.this$0.doFailure(2001, i2, str2);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = jSONObject.optJSONArray(SuggestAddrField.KEY_SUGGEST_LIST);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                                if (optJSONObject != null) {
                                    arrayList.add(optJSONObject);
                                } else {
                                    Log.d(AddressEditPresenter.TAG, "item of suggest address list is error, index=" + i2);
                                }
                            }
                        }
                        this.this$0.doResult(2001, arrayList, this.val$queryText);
                    }
                }
            });
        }
    }

    public String getBdSTokenFromAddrList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.bdSTokenFromAddrList : (String) invokeV.objValue;
    }

    public void getBdStokenFromServer(int i2, SyncActionCallBack syncActionCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, syncActionCallBack) == null) {
            AddressRequestFactory.newGetAddressListRequest().submit(new NetCallback(this, i2, syncActionCallBack) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditPresenter this$0;
                public final /* synthetic */ int val$fromActionCode;
                public final /* synthetic */ SyncActionCallBack val$syncActionCallBack;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), syncActionCallBack};
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
                    this.val$fromActionCode = i2;
                    this.val$syncActionCallBack = syncActionCallBack;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str) == null) {
                        this.this$0.doFailure(this.val$fromActionCode, i3, str);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.showLoading(this.val$fromActionCode);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                        this.this$0.bdSTokenFromAddrList = jSONObject.optString("bdstoken");
                        Log.d(AddressEditPresenter.TAG, "bdSToken from address list request is " + this.this$0.bdSTokenFromAddrList);
                        SyncActionCallBack syncActionCallBack2 = this.val$syncActionCallBack;
                        if (syncActionCallBack2 != null) {
                            syncActionCallBack2.doNext(this.val$fromActionCode);
                        }
                    }
                }
            });
        }
    }

    public void getImgOcrAddressResult(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
                getBdStokenFromServer(3001, new SyncActionCallBack(this, str) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressEditPresenter this$0;
                    public final /* synthetic */ String val$imgBase64Str;

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
                        this.val$imgBase64Str = str;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.executeImgOcrRequest(this.val$imgBase64Str);
                        }
                    }
                });
            } else {
                executeImgOcrRequest(str);
            }
        }
    }

    public void getSuggestAddrDetail(JSONObject jSONObject, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, addressSelectedBean) == null) {
            if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
                getBdStokenFromServer(2002, new SyncActionCallBack(this, jSONObject, addressSelectedBean) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressEditPresenter this$0;
                    public final /* synthetic */ AddressSelectedBean val$selectedRegion;
                    public final /* synthetic */ JSONObject val$suggestItemObj;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jSONObject, addressSelectedBean};
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
                        this.val$suggestItemObj = jSONObject;
                        this.val$selectedRegion = addressSelectedBean;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.executeSuggestAddrDetailRequest(this.val$suggestItemObj, this.val$selectedRegion);
                        }
                    }
                });
            } else {
                executeSuggestAddrDetailRequest(jSONObject, addressSelectedBean);
            }
        }
    }

    public void getSuggestAddrList(String str, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, addressSelectedBean) == null) {
            if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
                getBdStokenFromServer(2001, new SyncActionCallBack(this, str, addressSelectedBean) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressEditPresenter this$0;
                    public final /* synthetic */ String val$query;
                    public final /* synthetic */ AddressSelectedBean val$selectedRegion;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, addressSelectedBean};
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
                        this.val$query = str;
                        this.val$selectedRegion = addressSelectedBean;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.executeSuggestAddrListRequest(this.val$query, this.val$selectedRegion);
                        }
                    }
                });
            } else {
                executeSuggestAddrListRequest(str, addressSelectedBean);
            }
        }
    }

    public boolean isNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
                float parseFloat = Float.parseFloat(str);
                Log.d(TAG, "floatValue=" + parseFloat);
                return true;
            } catch (Exception e2) {
                Log.d(TAG, e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public String readClipBoardAddrText(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            try {
                CharSequence text = ((ClipboardManager) context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).getText();
                if (text != null) {
                    String charSequence = text.toString();
                    if (TextUtils.isEmpty(charSequence) || charSequence.length() <= 7) {
                        return null;
                    }
                    if (isNumber(charSequence)) {
                        return null;
                    }
                    return charSequence;
                }
                return null;
            } catch (Exception e2) {
                Log.d(TAG, e2.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void recogniseTextOcrAddressResult(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i2) == null) {
            if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
                getBdStokenFromServer(i2, new SyncActionCallBack(this, str, i2) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressEditPresenter this$0;
                    public final /* synthetic */ int val$fromActionCode;
                    public final /* synthetic */ String val$text;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Integer.valueOf(i2)};
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
                        this.val$text = str;
                        this.val$fromActionCode = i2;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                            this.this$0.executeRecogniseTextRequest(this.val$text, this.val$fromActionCode);
                        }
                    }
                });
            } else {
                executeRecogniseTextRequest(str, i2);
            }
        }
    }

    public void setBdSTokenFromAddrList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.bdSTokenFromAddrList = str;
        }
    }

    public void updateAddress(String str, MapObject mapObject, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, mapObject, addressSelectedBean) == null) {
            if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
                getBdStokenFromServer(1001, new SyncActionCallBack(this, str, mapObject, addressSelectedBean) { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressEditPresenter this$0;
                    public final /* synthetic */ MapObject val$mapObj;
                    public final /* synthetic */ String val$mobile;
                    public final /* synthetic */ AddressSelectedBean val$selectedRegion;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, mapObject, addressSelectedBean};
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
                        this.val$mobile = str;
                        this.val$mapObj = mapObject;
                        this.val$selectedRegion = addressSelectedBean;
                    }

                    @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                    public void doNext(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.executeUpdateAddrRequest(this.val$mobile, this.val$mapObj, this.val$selectedRegion);
                        }
                    }
                });
            } else {
                executeUpdateAddrRequest(str, mapObject, addressSelectedBean);
            }
        }
    }
}
