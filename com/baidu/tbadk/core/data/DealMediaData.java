package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DealMediaData implements Serializable {
    private static final long serialVersionUID = -647657268690539487L;
    public String bigPic;
    public String smallPic;
    public int type;
    public String waterPic;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bigPic = jSONObject.optString("big_pic");
                this.smallPic = jSONObject.optString("small_pic");
                this.type = jSONObject.optInt("type");
                this.waterPic = jSONObject.optString("water_pic");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
