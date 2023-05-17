package com.baidu.searchbox.toolbar;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonToolbarLikeInfoEvent {
    public CommonToolBarLikeInfo mLikeInfo;

    public CommonToolbarLikeInfoEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mLikeInfo = valueOf(str);
        }
    }

    private CommonToolBarLikeInfo valueOf(String str) {
        try {
            CommonToolBarLikeInfo commonToolBarLikeInfo = new CommonToolBarLikeInfo();
            JSONObject jSONObject = new JSONObject(str);
            commonToolBarLikeInfo.ext = jSONObject.optString("ext");
            commonToolBarLikeInfo.nid = jSONObject.optString("nid");
            commonToolBarLikeInfo.isLiked = "1".equals(jSONObject.optString("status"));
            commonToolBarLikeInfo.likeCount = jSONObject.optString("count");
            commonToolBarLikeInfo.likeSyncData = jSONObject.optString("syncdata");
            return commonToolBarLikeInfo;
        } catch (JSONException unused) {
            return null;
        }
    }

    public CommonToolBarLikeInfo getLikeInfo() {
        return this.mLikeInfo;
    }
}
