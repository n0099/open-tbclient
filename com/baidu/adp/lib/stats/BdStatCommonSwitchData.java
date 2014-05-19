package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatCommonSwitchData implements Serializable {
    private static final long serialVersionUID = 7678228379262149818L;
    private int percent;
    private boolean is_open = false;
    private boolean is_only_wifi = true;
    private boolean is_exact = false;

    public BdStatCommonSwitchData() {
        this.percent = 100;
        this.percent = 100;
    }

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

    public int getPercent() {
        return this.percent;
    }

    public void setPercent(int i) {
        this.percent = i;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = true;
        if (jSONObject != null) {
            try {
                setIs_exact(jSONObject.optInt("is_exact", 0) != 0);
                setIs_only_wifi(jSONObject.optInt("is_only_wifi", 0) != 0);
                int optInt = jSONObject.optInt("percent", 100);
                setPercent(optInt);
                boolean z2 = jSONObject.optInt("is_open", 0) != 0;
                if (!z2) {
                    z = z2;
                } else if (new Random().nextInt(101) > optInt) {
                    z = false;
                }
                setIs_open(z);
            } catch (Exception e) {
                BdLog.e(getClass(), "parserJson", e);
            }
        }
    }
}
