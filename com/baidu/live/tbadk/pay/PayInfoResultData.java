package com.baidu.live.tbadk.pay;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PayInfoResultData extends BaseData implements Serializable {
    private static final long serialVersionUID = -3890790632004634138L;
    private String errmsg;
    private int errno;
    private int pay_status;
    private String usermsg;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.errmsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
            this.errno = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            this.usermsg = jSONObject.optString("");
            this.pay_status = jSONObject.optInt(UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS);
        }
    }

    public void parserNuomiJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.errno = jSONObject.optInt("error_code", 0);
            this.errmsg = jSONObject.optString("error_msg");
            JSONObject optJSONObject = jSONObject.optJSONObject("order_info");
            if (optJSONObject != null) {
                this.pay_status = optJSONObject.optInt("result");
            }
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
