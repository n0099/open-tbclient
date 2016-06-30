package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DealAuthInfoData implements Serializable {
    private static final long serialVersionUID = 988571684527522373L;
    public String itemContent;
    public String itemName;
    public String itemUrl;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.itemContent = jSONObject.optString("item_content");
                this.itemName = jSONObject.optString("item_name");
                this.itemUrl = jSONObject.optString("item_url");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
