package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ErrorData implements Serializable {
    private static final long serialVersionUID = -2582050549890612990L;
    public int error_code = -1;
    public String error_msg = null;
    public String error_data = null;

    public int getError_code() {
        return this.error_code;
    }

    public void setError_code(int i) {
        this.error_code = i;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public String getError_data() {
        return this.error_data;
    }

    public void setError_data(String str) {
        this.error_data = str;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject == null) {
                    this.error_code = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE, 0);
                    this.error_msg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                    this.error_data = jSONObject.optString("error_data");
                } else {
                    this.error_code = optJSONObject.optInt("errno", 0);
                    this.error_msg = optJSONObject.optString("errmsg");
                    this.error_data = optJSONObject.optString("usermsg");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
