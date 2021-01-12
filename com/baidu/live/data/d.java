package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends BaseData {
    private int aEs;
    public String aEt;
    public String des;
    public String downloadUrl;
    public String icon;
    public String packageName;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aEs = jSONObject.optInt("switch");
            this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.des = jSONObject.optString("text");
            this.downloadUrl = jSONObject.optString("download_url");
            this.packageName = jSONObject.optString("package_name");
            this.aEt = jSONObject.optString("cmd");
        }
    }

    public boolean Ay() {
        return (this.aEs != 1 || TextUtils.isEmpty(this.aEt) || TextUtils.isEmpty(this.packageName)) ? false : true;
    }
}
