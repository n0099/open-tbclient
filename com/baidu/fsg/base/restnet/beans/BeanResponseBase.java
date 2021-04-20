package com.baidu.fsg.base.restnet.beans;

import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.StringUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BeanResponseBase implements NoProguard {
    public int retCode = 0;
    public String retMsg = null;
    public JSONObject result = null;
    public String csign = null;
    public String sign = null;

    public String getRealResponseContent() {
        JSONObject jSONObject = this.result;
        return jSONObject != null ? StringUtils.replaceBom(jSONObject.toString()) : "";
    }

    public int getServerReturnValue(Class<?> cls) {
        int i = this.retCode;
        if (i != 0) {
            return i;
        }
        if (i == 0) {
            if (this.result != null || cls == null || JsonUtils.DataType.isString(cls)) {
                return this.retCode;
            }
            return -3;
        }
        return -3;
    }
}
