package com.baidu.pass.ecommerce.presenter;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.AddressStatUtil;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.mvp.BasePresenter;
import com.baidu.pass.ecommerce.common.mvp.IBaseView;
import com.baidu.pass.ecommerce.common.request.NetCallback;
import com.baidu.pass.ecommerce.request.AddressRequestFactory;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AddressPresenter extends BasePresenter<IBaseView> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEL_ADDR_CODE = 1002;
    public static final int GET_ADDR_LIST_CODE = 1000;
    public static final int IMPORT_NUOMI_ADDRESS_CODE = 10002;
    public static final String KEY_BDSTOKEN = "bdstoken";
    public static final int NUOMI_ADDR_STATUS_CODE = 10001;
    public static final int SET_ADDR_DEFAULT_STATUS_CODE = 1003;
    public static final String TAG = "AddressPresenter";
    public transient /* synthetic */ FieldHolder $fh;
    public String bdSTokenFromAddrList;

    public AddressPresenter() {
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

    private void appendRegionValue(StringBuilder sb, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, this, sb, jSONObject, str) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        sb.append(optString);
        sb.append(",");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAddrListResult(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, this, jSONObject, z) == null) {
            this.bdSTokenFromAddrList = jSONObject.optString("bdstoken");
            Log.d(TAG, "bdSToken from address list request is " + this.bdSTokenFromAddrList);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(AddressField.KEY_ADDR_LIST);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList.add(optJSONObject);
                    } else {
                        Log.d(TAG, "item of address list is error, index=" + i2);
                    }
                }
            }
            doResult(1000, arrayList);
            if (z) {
                if (jSONObject.optInt(AddressField.KEY_HAS_NUOMI, 0) == 1) {
                    Log.d(TAG, "用户有需要授权的糯米地址");
                    if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_NUOMI_ADDR).isMeetGray()) {
                        doResult(10001, null);
                        return;
                    }
                    return;
                }
                Log.d(TAG, "没有需要授权的糯米地址");
            }
        }
    }

    private String getRegionListStr(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, jSONObject)) == null) {
            StringBuilder sb = new StringBuilder();
            appendRegionValue(sb, jSONObject, AddressField.KEY_COUNTRY_ID);
            appendRegionValue(sb, jSONObject, AddressField.KEY_PROVINCE_ID);
            appendRegionValue(sb, jSONObject, AddressField.KEY_CITY_ID);
            appendRegionValue(sb, jSONObject, AddressField.KEY_DISTRICT_ID);
            appendRegionValue(sb, jSONObject, AddressField.KEY_TOWN_ID);
            return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
        }
        return (String) invokeL.objValue;
    }

    public void delAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            MapObject mapObject = new MapObject();
            mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
            mapObject.putValue(AddressField.KEY_ADDR_ID, str);
            AddressRequestFactory.newDelAddressRequest(mapObject).submit(new NetCallback(this, str) { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressPresenter this$0;
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
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.showLoading(1002);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                        this.this$0.doResult(1002, jSONObject, this.val$addressId);
                    }
                }
            });
        }
    }

    public void getAddressList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            AddressRequestFactory.newGetAddressListRequest().submit(new NetCallback(this, z) { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressPresenter this$0;
                public final /* synthetic */ boolean val$needFailedCallback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
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
                    this.val$needFailedCallback = z;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) && this.val$needFailedCallback) {
                        this.this$0.doFailure(1000, i2, str);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                        this.this$0.doAddrListResult(jSONObject, this.val$needFailedCallback);
                    }
                }
            });
        }
    }

    public String getBdSTokenFromAddrList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bdSTokenFromAddrList : (String) invokeV.objValue;
    }

    public void ignoreNuoMiAddressStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AddressRequestFactory.newIgnoreNuoMiAddress().submit(new NetCallback(this) { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressPresenter this$0;

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
            });
        }
    }

    public void importNuoMiAddressStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AddressRequestFactory.newImportNuoMiAddress().submit(new NetCallback(this) { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressPresenter this$0;

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
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = jSONObject.optJSONArray(AddressField.KEY_IMPORT_NUOMI_ADDR_IDS);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                arrayList.add(optJSONArray.optString(i2));
                            }
                        }
                        if (arrayList.size() > 0) {
                            this.this$0.doResult(10002, arrayList);
                        } else {
                            Log.d(AddressPresenter.TAG, "importNuoMiAddressStatus 没有可导入的糯米地址");
                        }
                    }
                }
            });
        }
    }

    public void setAddressDefaultStatus(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            MapObject mapObject = new MapObject();
            mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
            String optString = jSONObject.optString(AddressField.KEY_ADDR_ID);
            mapObject.putValue(AddressField.KEY_ADDR_ID, optString);
            if (1 == jSONObject.optInt(AddressField.KEY_IS_DEFAULT)) {
                mapObject.putValue(AddressField.KEY_IS_DEFAULT, "0");
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_CANCEL_DEFAULT);
            } else {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_SET_DEFAULT);
                mapObject.putValue(AddressField.KEY_IS_DEFAULT, "1");
            }
            mapObject.putValue(AddressField.KEY_MOBILE_COUNTRY_CODE, jSONObject.optString(AddressField.KEY_MOBILE_COUNTRY_CODE));
            JSONObject optJSONObject = jSONObject.optJSONObject("addr_info");
            if (optJSONObject != null) {
                mapObject.putValue(AddressField.KEY_DETAIL_ADDR, optJSONObject.optString(AddressField.KEY_DETAIL_ADDR));
                mapObject.putValue("region_list", getRegionListStr(optJSONObject));
            }
            AddressRequestFactory.newUpdateAddressRequest(mapObject).submit(new NetCallback(this, optString) { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressPresenter this$0;
                public final /* synthetic */ String val$addressId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, optString};
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
                    this.val$addressId = optString;
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onFailure(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.this$0.doFailure(1003, i2, str);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onShowLoading() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.showLoading(1003);
                    }
                }

                @Override // com.baidu.pass.ecommerce.common.request.NetCallback
                public void onSuccess(JSONObject jSONObject2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject2) == null) {
                        this.this$0.doResult(1003, jSONObject2, this.val$addressId);
                    }
                }
            });
        }
    }
}
