package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
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
        boolean z = true;
        if (jSONObject != null) {
            try {
                setType(jSONObject.optString("type"));
                int optInt = jSONObject.optInt("percent", 100);
                boolean z2 = jSONObject.optInt("is_open", 0) != 0;
                if (z2) {
                    String imei = f.er().getImei();
                    if (!TextUtils.isEmpty(imei)) {
                        if (imei.hashCode() % 100 >= optInt) {
                            z = false;
                        }
                        setIs_open(z);
                    }
                }
                z = z2;
                setIs_open(z);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
