package com.baidu.pass.ecommerce.presenter;

import android.text.TextUtils;
import com.baidu.pass.ecommerce.common.mvp.BasePresenter;
import com.baidu.pass.ecommerce.common.request.NetCallback;
import com.baidu.pass.ecommerce.request.AddressRequestFactory;
import com.baidu.pass.ecommerce.view.addressdialog.ElementNode;
import com.baidu.pass.ecommerce.view.addressdialog.ListPagerView;
import com.baidu.sapi2.ecommerce.result.AddrSelectorRequestParam;
import com.baidu.sapi2.ecommerce.result.AddrSelectorResponseParam;
import com.baidu.sapi2.ecommerce.result.AddressBean;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddrListPagerPresenter extends BasePresenter<ListPagerView> {
    public void getAddressGetRegion(final int i2, AddrSelectorRequestParam addrSelectorRequestParam) {
        AddressRequestFactory.newAddressGetRegion(addrSelectorRequestParam).submit(new NetCallback() { // from class: com.baidu.pass.ecommerce.presenter.AddrListPagerPresenter.1
            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onFailure(int i3, String str) {
                AddrListPagerPresenter.this.doFailure(i2, i3, str);
            }

            @Override // com.baidu.pass.ecommerce.common.request.NetCallback
            public void onSuccess(JSONObject jSONObject) {
                ArrayList arrayList;
                JSONArray optJSONArray = jSONObject.optJSONArray(AddrSelectorResponseParam.KEY_LEAFS);
                ArrayList arrayList2 = null;
                if (optJSONArray != null) {
                    arrayList = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    String str = "";
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        AddressBean addressBean = new AddressBean();
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        addressBean.id = optJSONObject.optString(AddrSelectorResponseParam.KEY_ID);
                        addressBean.pid = optJSONObject.optString(AddrSelectorResponseParam.KEY_PID);
                        addressBean.type = optJSONObject.optString(AddrSelectorResponseParam.KEY_TYPE);
                        addressBean.name = optJSONObject.optString(AddrSelectorResponseParam.KEY_NAME);
                        addressBean.namePyInit = optJSONObject.optString(AddrSelectorResponseParam.KEY_NAME_PY_INIT);
                        addressBean.hasLeaf = optJSONObject.optBoolean(AddrSelectorResponseParam.KEY_HAS_LEAF);
                        addressBean.leafType = optJSONObject.optString(AddrSelectorResponseParam.KEY_LEAFTYPE);
                        addressBean.isHmt = optJSONObject.optBoolean(AddrSelectorResponseParam.KEY_IS_HMT);
                        addressBean.isShowPy = !optJSONObject.optString(AddrSelectorResponseParam.KEY_NAME_PY_INIT).equals(str);
                        str = optJSONObject.optString(AddrSelectorResponseParam.KEY_NAME_PY_INIT);
                        if ("#".equals(addressBean.namePyInit)) {
                            arrayList3.add(addressBean);
                        } else {
                            arrayList.add(addressBean);
                        }
                    }
                    arrayList.addAll(arrayList3);
                } else {
                    arrayList = null;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray(AddrSelectorResponseParam.KEY_HOTLIST);
                if (optJSONArray2 != null) {
                    arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        AddressBean addressBean2 = new AddressBean();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i4);
                        addressBean2.pid = optJSONObject2.optString(AddrSelectorResponseParam.KEY_PID);
                        addressBean2.pname = optJSONObject2.optString(AddrSelectorResponseParam.KEY_PNAME);
                        addressBean2.ptype = optJSONObject2.optString(AddrSelectorResponseParam.KEY_PTYPE);
                        addressBean2.id = optJSONObject2.optString(AddrSelectorResponseParam.KEY_ID);
                        addressBean2.type = optJSONObject2.optString(AddrSelectorResponseParam.KEY_TYPE);
                        addressBean2.name = optJSONObject2.optString(AddrSelectorResponseParam.KEY_NAME);
                        addressBean2.isHotCity = true;
                        addressBean2.hasLeaf = true;
                        arrayList2.add(addressBean2);
                    }
                }
                AddrListPagerPresenter.this.doResult(i2, new ElementNode.AddressEntity(arrayList, arrayList2));
            }
        });
    }

    public String getErrorMsg(int i2) {
        return "网络不给力，请稍后重试";
    }

    public List<AddressBean> makeSelectedEntity(ElementNode.AddressEntity addressEntity, String str) {
        if (addressEntity == null) {
            return null;
        }
        List<AddressBean> list = addressEntity.list;
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                AddressBean addressBean = list.get(i2);
                if (addressBean != null && str.equals(addressBean.id)) {
                    addressEntity.selectedId = addressBean.id;
                    addressEntity.selectedName = addressBean.name;
                    addressEntity.selectedType = addressBean.type;
                    addressEntity.selectedPosition = i2;
                    break;
                }
                i2++;
            }
        }
        return list;
    }
}
