package com.baidu.fsg.base.restnet.beans.business.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ABTestUtils {
    private GetFPResponse.Exp[] exps;

    private ABTestUtils() {
    }

    public ABTestUtils(Context context) {
        String exps = BdWalletUtils.getExps(context);
        if (!TextUtils.isEmpty(exps)) {
            try {
                this.exps = (GetFPResponse.Exp[]) JsonUtils.fromJson(exps, GetFPResponse.Exp[].class);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getABTestValueString(String str, String str2, String str3) {
        GetFPResponse.Exp[] expArr;
        GetFPResponse.ExpContent[] expContentArr;
        if (this.exps != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (GetFPResponse.Exp exp : this.exps) {
                if (exp != null && str.equals(exp.exp_id) && "1".equals(exp.is_enable) && (expContentArr = exp.exp_contents) != null) {
                    for (int i = 0; i < expContentArr.length; i++) {
                        if (str2.equals(expContentArr[i].exp_name)) {
                            return expContentArr[i].exp_value;
                        }
                    }
                    continue;
                }
            }
            return str3;
        }
        return str3;
    }

    public String getABTestVersion(String str) {
        GetFPResponse.Exp[] expArr;
        if (this.exps != null && !TextUtils.isEmpty(str)) {
            for (GetFPResponse.Exp exp : this.exps) {
                if (exp != null && str.equals(exp.exp_id)) {
                    return exp.exp_version;
                }
            }
        }
        return "";
    }

    public JSONObject getABTestStatistics(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exp_id", str);
            jSONObject.put("exp_version", getABTestVersion(str));
            jSONObject.put("exp_name", str2);
            jSONObject.put("exp_value", getABTestValueString(str, str2, str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
