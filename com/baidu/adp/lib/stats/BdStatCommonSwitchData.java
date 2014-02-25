package com.baidu.adp.lib.stats;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatCommonSwitchData implements Serializable {
    private static final long serialVersionUID = 7678228379262149818L;
    private boolean is_open = false;
    private boolean is_only_wifi = true;
    private boolean is_exact = false;

    public boolean isIs_open() {
        return this.is_open;
    }

    public void setIs_open(boolean z) {
        this.is_open = z;
    }

    public boolean isIs_only_wifi() {
        return this.is_only_wifi;
    }

    public void setIs_only_wifi(boolean z) {
        this.is_only_wifi = z;
    }

    public boolean isIs_exact() {
        return this.is_exact;
    }

    public void setIs_exact(boolean z) {
        this.is_exact = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setIs_exact(jSONObject.optInt("is_exact", 0) != 0);
                setIs_only_wifi(jSONObject.optInt("is_only_wifi", 0) != 0);
                setIs_open(jSONObject.optInt("is_open", 0) != 0);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.a(getClass(), "parserJson", e);
            }
        }
    }
}
