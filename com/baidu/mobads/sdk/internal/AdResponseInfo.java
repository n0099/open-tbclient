package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdResponseInfo {
    public int mAdsNum = 0;
    public List<AdElementInfo> mAdList = new ArrayList();

    public static AdResponseInfo fromJson(String str) {
        AdResponseInfo adResponseInfo = new AdResponseInfo();
        if (TextUtils.isEmpty(str)) {
            return adResponseInfo;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (str != null) {
                adResponseInfo.mAdsNum = jSONObject.optInt("n", 0);
                adResponseInfo.mAdList = AdElementInfo.fromJsonArray(jSONObject.optJSONArray("ad"));
                return adResponseInfo;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return adResponseInfo;
    }

    public List<AdElementInfo> getAdInstanceInfoList() {
        return this.mAdList;
    }
}
