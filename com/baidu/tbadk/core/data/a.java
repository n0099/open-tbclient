package com.baidu.tbadk.core.data;

import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private Date Dd;
    private int errorCode;
    private String errorMsg;

    protected abstract void e(JSONObject jSONObject);

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean mi() {
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
            setErrorMsg("你的网络状况不大好，请稍后重试");
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.errorCode = jSONObject.optInt("error_code", 0);
            if (this.errorCode != 0) {
                setErrorMsg(jSONObject.optString("error_msg", "你的网络状况不大好，请稍后重试"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.errorCode = optJSONObject.optInt("errno", 0);
                if (this.errorCode != 0) {
                    setErrorMsg(optJSONObject.optString("usermsg", "你的网络状况不大好，请稍后重试"));
                    return;
                }
            }
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.Dd = new Date(optLong * 1000);
            }
            e(jSONObject);
        } catch (Exception e) {
            setErrorMsg("你的网络状况不大好，请稍后重试");
            e.printStackTrace();
        }
    }
}
