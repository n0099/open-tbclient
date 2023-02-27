package com.baidu.sapi2.share;

import com.baidu.sapi2.share.ShareStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetOnlineResponseShareModel {
    public String app;
    public String bduss;
    public String pkg;

    public GetOnlineResponseShareModel() {
    }

    public GetOnlineResponseShareModel(ShareStorage.StorageModel storageModel) {
        if (storageModel == null) {
            return;
        }
        this.app = storageModel.app;
        this.pkg = storageModel.pkg;
        this.bduss = storageModel.bduss;
    }

    public static JSONObject parseModel2JsonObject(GetOnlineResponseShareModel getOnlineResponseShareModel) {
        String str;
        String str2;
        if (getOnlineResponseShareModel == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str3 = "";
            if (getOnlineResponseShareModel.app == null) {
                str = "";
            } else {
                str = getOnlineResponseShareModel.app;
            }
            jSONObject.put("app", str);
            if (getOnlineResponseShareModel.pkg == null) {
                str2 = "";
            } else {
                str2 = getOnlineResponseShareModel.pkg;
            }
            jSONObject.put("pkg", str2);
            if (getOnlineResponseShareModel.bduss != null) {
                str3 = getOnlineResponseShareModel.bduss;
            }
            jSONObject.put("bduss", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
