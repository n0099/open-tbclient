package com.baidu.sapi2.share;

import com.baidu.sapi2.share.ShareStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetOnlineRequestShareModel {
    public static final String FROM_INTER_FLOW_NO = "0";
    public static final String FROM_INTER_FLOW_YES = "1";
    public String app;
    public String bduss;
    public String pkg;

    public GetOnlineRequestShareModel() {
    }

    public GetOnlineRequestShareModel(ShareStorage.StorageModel storageModel) {
        if (storageModel == null) {
            return;
        }
        this.app = storageModel.app;
        this.pkg = storageModel.pkg;
        this.bduss = storageModel.bduss;
    }

    public static JSONObject parseModel2JsonObject(GetOnlineRequestShareModel getOnlineRequestShareModel) {
        String str;
        String str2;
        if (getOnlineRequestShareModel == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str3 = "";
            if (getOnlineRequestShareModel.app == null) {
                str = "";
            } else {
                str = getOnlineRequestShareModel.app;
            }
            jSONObject.put("app", str);
            if (getOnlineRequestShareModel.pkg == null) {
                str2 = "";
            } else {
                str2 = getOnlineRequestShareModel.pkg;
            }
            jSONObject.put("pkg", str2);
            if (getOnlineRequestShareModel.bduss != null) {
                str3 = getOnlineRequestShareModel.bduss;
            }
            jSONObject.put("bduss", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
