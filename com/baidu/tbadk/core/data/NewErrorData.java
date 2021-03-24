package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NewErrorData implements Serializable {
    public static final long serialVersionUID = -4089110102533296066L;
    public int errno = -1;
    public String errmsg = null;
    public String usermsg = null;

    public String getErrorMsg() {
        return this.errmsg;
    }

    public int getErrorNumber() {
        return this.errno;
    }

    public void parserJson(String str) {
        if (str == null) {
            return;
        }
        try {
            parserJson(new JSONObject(str).optJSONObject("error"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.errno = jSONObject.optInt("errno");
            this.errmsg = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
