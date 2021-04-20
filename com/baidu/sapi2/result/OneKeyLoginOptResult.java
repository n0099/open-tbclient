package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OneKeyLoginOptResult implements NoProguard {

    /* renamed from: f  reason: collision with root package name */
    public static final String f10896f = "OneKeyLoginOptResult";

    /* renamed from: a  reason: collision with root package name */
    public int f10897a;

    /* renamed from: b  reason: collision with root package name */
    public int f10898b;

    /* renamed from: c  reason: collision with root package name */
    public String f10899c;

    /* renamed from: d  reason: collision with root package name */
    public String f10900d;

    /* renamed from: e  reason: collision with root package name */
    public String f10901e;

    /* loaded from: classes2.dex */
    public interface OptResultFields {
        public static final String CODE = "0";
        public static final String EXTRA = "3";
        public static final String OPERATE_TYPE = "2";
        public static final String SECURITY_PHONE = "fakeMobile";
        public static final String SUB_CODE = "1";
    }

    public static OneKeyLoginOptResult formatOptResult(String str) {
        OneKeyLoginOptResult oneKeyLoginOptResult = new OneKeyLoginOptResult();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                oneKeyLoginOptResult.f10897a = jSONObject.optInt("0", -202);
                oneKeyLoginOptResult.f10898b = jSONObject.optInt("1", -202);
                oneKeyLoginOptResult.f10899c = jSONObject.optString("2");
                oneKeyLoginOptResult.f10900d = jSONObject.optString("3");
            } catch (JSONException e2) {
                Log.e(f10896f, e2.getMessage());
            }
        }
        return oneKeyLoginOptResult;
    }

    public static boolean isValid(OneKeyLoginOptResult oneKeyLoginOptResult) {
        return (oneKeyLoginOptResult == null || oneKeyLoginOptResult.f10897a != 0 || oneKeyLoginOptResult.f10898b != 0 || TextUtils.isEmpty(oneKeyLoginOptResult.f10899c) || TextUtils.isEmpty(oneKeyLoginOptResult.f10900d)) ? false : true;
    }

    public void generateSecurityPhone() {
        Log.d(f10896f, "generateSecurityPhone extraStr=" + this.f10900d);
        if (TextUtils.isEmpty(this.f10900d)) {
            return;
        }
        try {
            this.f10901e = new JSONObject(this.f10900d).optString(OptResultFields.SECURITY_PHONE);
        } catch (JSONException e2) {
            Log.e(f10896f, e2.getMessage());
        }
    }

    public int getCode() {
        return this.f10897a;
    }

    public String getExtraStr() {
        return this.f10900d;
    }

    public String getOperateType() {
        return this.f10899c;
    }

    public String getSecurityPhone() {
        return this.f10901e;
    }

    public int getSubCode() {
        return this.f10898b;
    }

    public void setCode(int i) {
        this.f10897a = i;
    }

    public void setSubCode(int i) {
        this.f10898b = i;
    }
}
