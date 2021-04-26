package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ErrorData implements Serializable {
    public static final long serialVersionUID = -2582050549890612990L;
    public int error_code = -1;
    public String error_msg = null;
    public String error_data = null;

    public int getError_code() {
        return this.error_code;
    }

    public String getError_data() {
        return this.error_data;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setError_code(int i2) {
        this.error_code = i2;
    }

    public void setError_data(String str) {
        this.error_data = str;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject == null) {
                this.error_code = jSONObject.optInt("error_code", 0);
                this.error_msg = jSONObject.optString("error_msg");
                this.error_data = jSONObject.optString("error_data");
            } else {
                this.error_code = optJSONObject.optInt("errno", 0);
                this.error_msg = optJSONObject.optString("errmsg");
                this.error_data = optJSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
