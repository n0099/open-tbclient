package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OneKeyLoginOptResult implements NoProguard {
    public static final String TAG = "OneKeyLoginOptResult";
    public int code;
    public String extraStr;
    public String operateType;
    public String securityPhone;
    public int subCode;

    /* loaded from: classes2.dex */
    public interface OptResultFields {
        public static final String CODE = "0";
        public static final String EXTRA = "3";
        public static final String OPERATE_TYPE = "2";
        public static final String SECURITY_PHONE = "fakeMobile";
        public static final String SUB_CODE = "1";
    }

    public int getCode() {
        return this.code;
    }

    public String getExtraStr() {
        return this.extraStr;
    }

    public String getOperateType() {
        return this.operateType;
    }

    public String getSecurityPhone() {
        return this.securityPhone;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public static OneKeyLoginOptResult formatOptResult(String str) {
        OneKeyLoginOptResult oneKeyLoginOptResult = new OneKeyLoginOptResult();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                oneKeyLoginOptResult.code = jSONObject.optInt("0", -202);
                oneKeyLoginOptResult.subCode = jSONObject.optInt("1", -202);
                oneKeyLoginOptResult.operateType = jSONObject.optString("2");
                oneKeyLoginOptResult.extraStr = jSONObject.optString("3");
            } catch (JSONException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return oneKeyLoginOptResult;
    }

    public static boolean isValid(OneKeyLoginOptResult oneKeyLoginOptResult) {
        if (oneKeyLoginOptResult != null && oneKeyLoginOptResult.code == 0 && oneKeyLoginOptResult.subCode == 0 && !TextUtils.isEmpty(oneKeyLoginOptResult.operateType) && !TextUtils.isEmpty(oneKeyLoginOptResult.extraStr)) {
            return true;
        }
        return false;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setSubCode(int i) {
        this.subCode = i;
    }

    public void generateSecurityPhone() {
        Log.d(TAG, "generateSecurityPhone extraStr=" + this.extraStr);
        if (!TextUtils.isEmpty(this.extraStr)) {
            try {
                this.securityPhone = new JSONObject(this.extraStr).optString(OptResultFields.SECURITY_PHONE);
            } catch (JSONException e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }
}
