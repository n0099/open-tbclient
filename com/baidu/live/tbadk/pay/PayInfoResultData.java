package com.baidu.live.tbadk.pay;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PayInfoResultData extends BaseData implements Serializable {
    private static final long serialVersionUID = -3890790632004634138L;
    private String errmsg;
    private int errno;
    private int pay_status;
    private String usermsg;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.errmsg = jSONObject.optString("errmsg");
            this.errno = jSONObject.optInt("errno");
            this.usermsg = jSONObject.optString("");
            this.pay_status = jSONObject.optInt("pay_status");
        }
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String str) {
        this.errmsg = str;
    }

    public int getErrno() {
        return this.errno;
    }

    public void setErrno(int i) {
        this.errno = i;
    }

    public String getUsermsg() {
        return this.usermsg;
    }

    public void setUsermsg(String str) {
        this.usermsg = str;
    }

    public int getPay_status() {
        return this.pay_status;
    }

    public void setPay_status(int i) {
        this.pay_status = i;
    }
}
