package com.baidu.pass.ecommerce.presenter;

import android.text.TextUtils;
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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AddressPresenter extends BasePresenter<IBaseView> {
    public static final int DEL_ADDR_CODE = 1002;
    public static final int GET_ADDR_LIST_CODE = 1000;
    public static final int IMPORT_NUOMI_ADDRESS_CODE = 10002;
    public static final String KEY_BDSTOKEN = "bdstoken";
    public static final int NUOMI_ADDR_STATUS_CODE = 10001;
    public static final int SET_ADDR_DEFAULT_STATUS_CODE = 1003;
    public static final String TAG = "AddressPresenter";
    public String bdSTokenFromAddrList;

    public String getBdSTokenFromAddrList() {
        return this.bdSTokenFromAddrList;
    }

    public void ignoreNuoMiAddressStatus() {
        AddressRequestFactory.newIgnoreNuoMiAddress().submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.3
        });
    }

    public void importNuoMiAddressStatus() {
        AddressRequestFactory.newImportNuoMiAddress().submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.2
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str) {
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray(AddressField.KEY_IMPORT_NUOMI_ADDR_IDS);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(optJSONArray.optString(i));
                    }
                }
                if (arrayList.size() > 0) {
                    AddressPresenter.this.doResult(10002, arrayList);
                } else {
                    Log.d(AddressPresenter.TAG, "importNuoMiAddressStatus 没有可导入的糯米地址");
                }
            }
        });
    }

    private void appendRegionValue(StringBuilder sb, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(str);
        if (!TextUtils.isEmpty(optString)) {
            sb.append(optString);
            sb.append(",");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAddrListResult(JSONObject jSONObject, boolean z) {
        this.bdSTokenFromAddrList = jSONObject.optString("bdstoken");
        Log.d(TAG, "bdSToken from address list request is " + this.bdSTokenFromAddrList);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(AddressField.KEY_ADDR_LIST);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(optJSONObject);
                } else {
                    Log.d(TAG, "item of address list is error, index=" + i);
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

    private String getRegionListStr(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        appendRegionValue(sb, jSONObject, AddressField.KEY_COUNTRY_ID);
        appendRegionValue(sb, jSONObject, AddressField.KEY_PROVINCE_ID);
        appendRegionValue(sb, jSONObject, AddressField.KEY_CITY_ID);
        appendRegionValue(sb, jSONObject, AddressField.KEY_DISTRICT_ID);
        appendRegionValue(sb, jSONObject, AddressField.KEY_TOWN_ID);
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }

    public void delAddress(final String str) {
        MapObject mapObject = new MapObject();
        mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
        mapObject.putValue(AddressField.KEY_ADDR_ID, str);
        AddressRequestFactory.newDelAddressRequest(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.4
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str2) {
                AddressPresenter.this.doFailure(1002, i, str2);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
                AddressPresenter.this.showLoading(1002);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                AddressPresenter.this.doResult(1002, jSONObject, str);
            }
        });
    }

    public void getAddressList(final boolean z) {
        AddressRequestFactory.newGetAddressListRequest().submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.1
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str) {
                if (!z) {
                    return;
                }
                AddressPresenter.this.doFailure(1000, i, str);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                AddressPresenter.this.doAddrListResult(jSONObject, z);
            }
        });
    }

    public void setAddressDefaultStatus(JSONObject jSONObject) {
        MapObject mapObject = new MapObject();
        mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
        final String optString = jSONObject.optString(AddressField.KEY_ADDR_ID);
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
        AddressRequestFactory.newUpdateAddressRequest(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressPresenter.5
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str) {
                AddressPresenter.this.doFailure(1003, i, str);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
                AddressPresenter.this.showLoading(1003);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject2) {
                AddressPresenter.this.doResult(1003, jSONObject2, optString);
            }
        });
    }
}
