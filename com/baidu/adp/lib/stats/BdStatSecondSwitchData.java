package com.baidu.adp.lib.stats;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatSecondSwitchData implements Serializable {
    private static final long serialVersionUID = -7490260966510945264L;
    private String type = null;
    private boolean is_open = false;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public boolean isIs_open() {
        return this.is_open;
    }

    public void setIs_open(boolean z) {
        this.is_open = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setIs_open(jSONObject.optInt("is_open", 0) != 0);
                setType(jSONObject.optString("type"));
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.a(getClass(), "parserJson", e);
            }
        }
    }
}
