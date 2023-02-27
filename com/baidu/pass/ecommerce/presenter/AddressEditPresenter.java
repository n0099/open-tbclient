package com.baidu.pass.ecommerce.presenter;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.ecommerce.AddressStatUtil;
import com.baidu.pass.ecommerce.StatKey;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddressEditPresenter extends BasePresenter<IBaseView> {
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
    public String bdSTokenFromAddrList;

    public String getBdSTokenFromAddrList() {
        return this.bdSTokenFromAddrList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRecogniseTextRequest(String str, final int i) {
        MapObject mapObject = new MapObject();
        mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
        mapObject.putValue("text", str);
        AddressRequestFactory.newRecogniseText2Address(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.13
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i2, String str2) {
                AddressEditPresenter.this.doFailure(i, i2, str2);
                HashMap hashMap = new HashMap();
                hashMap.put("stage", "failed");
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_PASTE_ADDRESS_STAGE, hashMap);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
                AddressEditPresenter.this.showLoading(i);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                AddressEditPresenter.this.doResult(i, jSONObject.optJSONObject("data"));
                HashMap hashMap = new HashMap();
                hashMap.put("stage", "success");
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_PASTE_ADDRESS_STAGE, hashMap);
            }
        });
    }

    public void createAddress(final MapObject mapObject, final AddressSelectedBean addressSelectedBean) {
        if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
            getBdStokenFromServer(1004, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.2
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i) {
                    AddressEditPresenter.this.executeCreateAddrRequest(mapObject, addressSelectedBean);
                }
            });
        } else {
            executeCreateAddrRequest(mapObject, addressSelectedBean);
        }
    }

    public void getBdStokenFromServer(final int i, final SyncActionCallBack syncActionCallBack) {
        AddressRequestFactory.newGetAddressListRequest().submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.1
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i2, String str) {
                AddressEditPresenter.this.doFailure(i, i2, str);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
                AddressEditPresenter.this.showLoading(i);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                AddressEditPresenter.this.bdSTokenFromAddrList = jSONObject.optString("bdstoken");
                Log.d(AddressEditPresenter.TAG, "bdSToken from address list request is " + AddressEditPresenter.this.bdSTokenFromAddrList);
                SyncActionCallBack syncActionCallBack2 = syncActionCallBack;
                if (syncActionCallBack2 != null) {
                    syncActionCallBack2.doNext(i);
                }
            }
        });
    }

    public void getSuggestAddrDetail(final JSONObject jSONObject, final AddressSelectedBean addressSelectedBean) {
        if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
            getBdStokenFromServer(2002, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.8
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i) {
                    AddressEditPresenter.this.executeSuggestAddrDetailRequest(jSONObject, addressSelectedBean);
                }
            });
        } else {
            executeSuggestAddrDetailRequest(jSONObject, addressSelectedBean);
        }
    }

    public void getSuggestAddrList(final String str, final AddressSelectedBean addressSelectedBean) {
        if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
            getBdStokenFromServer(2001, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.6
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i) {
                    AddressEditPresenter.this.executeSuggestAddrListRequest(str, addressSelectedBean);
                }
            });
        } else {
            executeSuggestAddrListRequest(str, addressSelectedBean);
        }
    }

    public void recogniseTextOcrAddressResult(final String str, final int i) {
        if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
            getBdStokenFromServer(i, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.12
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i2) {
                    AddressEditPresenter.this.executeRecogniseTextRequest(str, i);
                }
            });
        } else {
            executeRecogniseTextRequest(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeImgOcrRequest(String str) {
        MapObject mapObject = new MapObject();
        mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
        mapObject.putValue("img", str);
        AddressRequestFactory.newOCRImg2Address(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.11
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                AddressEditPresenter.this.doResult(3001, jSONObject.optString("text"));
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str2) {
                AddressEditPresenter.this.doFailure(3001, i, str2);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
                AddressEditPresenter.this.showLoading(3001);
            }
        });
    }

    public void delAddress(final String str) {
        if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
            getBdStokenFromServer(1002, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.14
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i) {
                    AddressEditPresenter.this.executeDelAddrRequest(str);
                }
            });
        } else {
            executeDelAddrRequest(str);
        }
    }

    public void executeDelAddrRequest(final String str) {
        MapObject mapObject = new MapObject();
        mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
        mapObject.putValue(AddressField.KEY_ADDR_ID, str);
        AddressRequestFactory.newDelAddressRequest(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.15
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str2) {
                AddressEditPresenter.this.doFailure(1002, i, str2);
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_DELETE_FAILED);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                AddressEditPresenter.this.doResult(1002, jSONObject, str);
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_DELETE_SUCCES);
            }
        });
    }

    public void getImgOcrAddressResult(final String str) {
        if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
            getBdStokenFromServer(3001, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.10
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i) {
                    AddressEditPresenter.this.executeImgOcrRequest(str);
                }
            });
        } else {
            executeImgOcrRequest(str);
        }
    }

    public boolean isNumber(String str) {
        try {
            float parseFloat = Float.parseFloat(str);
            Log.d(TAG, "floatValue=" + parseFloat);
            return true;
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
            return false;
        }
    }

    public void setBdSTokenFromAddrList(String str) {
        this.bdSTokenFromAddrList = str;
    }

    public void updateAddress(final String str, final MapObject mapObject, final AddressSelectedBean addressSelectedBean) {
        if (TextUtils.isEmpty(this.bdSTokenFromAddrList)) {
            getBdStokenFromServer(1001, new SyncActionCallBack() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.4
                @Override // com.baidu.pass.ecommerce.common.mvp.SyncActionCallBack
                public void doNext(int i) {
                    AddressEditPresenter.this.executeUpdateAddrRequest(str, mapObject, addressSelectedBean);
                }
            });
        } else {
            executeUpdateAddrRequest(str, mapObject, addressSelectedBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeCreateAddrRequest(MapObject mapObject, AddressSelectedBean addressSelectedBean) {
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
        AddressRequestFactory.newAddAddrRequest(mapObject2).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.3
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                String optString = jSONObject.optString(AddressField.KEY_ADDR_ID);
                if (!TextUtils.isEmpty(optString)) {
                    AddressEditPresenter.this.doResult(1004, optString);
                } else {
                    AddressEditPresenter.this.doFailure(1004, -10000, "未知错误");
                }
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str) {
                AddressEditPresenter.this.doFailure(1004, i, str);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
                AddressEditPresenter.this.showLoading(1004);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeSuggestAddrDetailRequest(JSONObject jSONObject, AddressSelectedBean addressSelectedBean) {
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
        AddressRequestFactory.newSuggestDetailRequest(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.9
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject2) {
                AddressEditPresenter.this.doResult(2002, jSONObject2.optJSONObject("addr_info"));
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str) {
                AddressEditPresenter.this.doFailure(2002, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeUpdateAddrRequest(String str, MapObject mapObject, AddressSelectedBean addressSelectedBean) {
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
        AddressRequestFactory.newUpdateAddressRequest(mapObject2).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.5
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                AddressEditPresenter.this.doResult(1001, jSONObject);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str2) {
                AddressEditPresenter.this.doFailure(1001, i, str2);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onShowLoading() {
                AddressEditPresenter.this.showLoading(1001);
            }
        });
    }

    public void executeSuggestAddrListRequest(final String str, AddressSelectedBean addressSelectedBean) {
        MapObject mapObject = new MapObject();
        mapObject.putValue("bdstoken", this.bdSTokenFromAddrList);
        mapObject.putValue("query", str);
        RegionList generateRegionList = RegionList.generateRegionList(addressSelectedBean);
        mapObject.putValue("region_list", generateRegionList.regionListStr);
        mapObject.putValue(SuggestAddrField.KEY_TYPE_LIST, generateRegionList.typeListStr);
        mapObject.putValue(SuggestAddrField.KEY_NAME_LIST, generateRegionList.nameListStr);
        AddressRequestFactory.newSuggestListRequest(mapObject).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddressEditPresenter.7
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i, String str2) {
                AddressEditPresenter.this.doFailure(2001, i, str2);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray(SuggestAddrField.KEY_SUGGEST_LIST);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            arrayList.add(optJSONObject);
                        } else {
                            Log.d(AddressEditPresenter.TAG, "item of suggest address list is error, index=" + i);
                        }
                    }
                }
                AddressEditPresenter.this.doResult(2001, arrayList, str);
            }
        });
    }

    public String readClipBoardAddrText(Context context) {
        try {
            CharSequence text = ((ClipboardManager) context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).getText();
            if (text != null) {
                String charSequence = text.toString();
                if (!TextUtils.isEmpty(charSequence) && charSequence.length() > 7) {
                    if (!isNumber(charSequence)) {
                        return charSequence;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
            return null;
        }
    }
}
