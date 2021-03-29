package com.baidu.android.lbspay.datamodel;

import com.baidu.apollon.restnet.RestNameValuePair;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class AuthorizeData implements Serializable {
    public static String DELIVERY_AUTHORIZE_DATA = "delivery_authorize_data";
    public Map<String, String> mData;

    public void addParams(List<RestNameValuePair> list) {
        Map<String, String> map = this.mData;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                key = "";
            }
            if (value == null) {
                value = "";
            }
            list.add(new RestNameValuePair(key, value));
        }
    }

    public void setData(Map<String, String> map) {
        this.mData = map;
    }
}
