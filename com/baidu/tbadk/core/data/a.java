package com.baidu.tbadk.core.data;

import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private Date Pi;
    private int errorCode;
    private String errorMsg;

    protected abstract void d(JSONObject jSONObject);

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean qp() {
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
            this.errorCode = jSONObject.optInt("error_code", 0);
            if (this.errorCode != 0) {
                setErrorMsg(jSONObject.optString("error_msg", "网络不稳定，请稍后再试"));
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
                this.Pi = new Date(optLong * 1000);
            }
            d(jSONObject);
        } catch (Exception e) {
            setErrorMsg("网络不稳定，请稍后再试");
            e.printStackTrace();
        }
    }
}
