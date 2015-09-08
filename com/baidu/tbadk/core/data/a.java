package com.baidu.tbadk.core.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private Date TY;
    private int errorCode;
    private String errorMsg;

    protected abstract void h(JSONObject jSONObject);

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean rp() {
        return this.errorMsg != null;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            setErrorMsg("网络不稳定，请稍后再试");
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.errorCode = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE, 0);
            if (this.errorCode != 0) {
                setErrorMsg(jSONObject.optString(SocialConstants.PARAM_ERROR_MSG, "网络不稳定，请稍后再试"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.errorCode = optJSONObject.optInt("errno", 0);
                if (this.errorCode != 0) {
                    setErrorMsg(optJSONObject.optString("usermsg", "网络不稳定，请稍后再试"));
                    return;
                }
            }
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.TY = new Date(optLong * 1000);
            }
            h(jSONObject);
        } catch (Exception e) {
            setErrorMsg("网络不稳定，请稍后再试");
            e.printStackTrace();
        }
    }
}
