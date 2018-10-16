package com.baidu.fsg.base.restnet.beans;

import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.StringUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class BeanResponseBase implements NoProguard {
    public int retCode = 0;
    public String retMsg = null;
    public JSONObject result = null;
    public String csign = null;
    public String sign = null;

    public int getServerReturnValue(Class<?> cls) {
        if (this.retCode != 0) {
            return this.retCode;
        }
        if (this.retCode == 0 && (this.result != null || cls == null || JsonUtils.DataType.isString(cls))) {
            return this.retCode;
        }
        return -3;
    }

    public String getRealResponseContent() {
        return this.result != null ? StringUtils.replaceBom(this.result.toString()) : "";
    }
}
