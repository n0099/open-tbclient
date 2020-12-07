package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends BaseData {
    private int aIJ;
    public String aIK;
    public String des;
    public String downloadUrl;
    public String icon;
    public String packageName;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIJ = jSONObject.optInt("switch");
            this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.des = jSONObject.optString("text");
            this.downloadUrl = jSONObject.optString("download_url");
            this.packageName = jSONObject.optString("package_name");
            this.aIK = jSONObject.optString("cmd");
        }
    }

    public boolean Fe() {
        return (this.aIJ != 1 || TextUtils.isEmpty(this.aIK) || TextUtils.isEmpty(this.packageName)) ? false : true;
    }
}
