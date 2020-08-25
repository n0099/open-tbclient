package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NewErrorData implements Serializable {
    private static final long serialVersionUID = -4089110102533296066L;
    public int errno = -1;
    public String errmsg = null;
    public String usermsg = null;

    public int getErrorNumber() {
        return this.errno;
    }

    public String getErrorMsg() {
        return this.errmsg;
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str).optJSONObject(BdStatsConstant.StatsType.ERROR));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.errno = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.errmsg = jSONObject.optString("usermsg");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
