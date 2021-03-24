package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OneKeyLoginOptResult implements NoProguard {

    /* renamed from: f  reason: collision with root package name */
    public static final String f11311f = "OneKeyLoginOptResult";

    /* renamed from: a  reason: collision with root package name */
    public int f11312a;

    /* renamed from: b  reason: collision with root package name */
    public int f11313b;

    /* renamed from: c  reason: collision with root package name */
    public String f11314c;

    /* renamed from: d  reason: collision with root package name */
    public String f11315d;

    /* renamed from: e  reason: collision with root package name */
    public String f11316e;

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
                oneKeyLoginOptResult.f11312a = jSONObject.optInt("0", -202);
                oneKeyLoginOptResult.f11313b = jSONObject.optInt("1", -202);
                oneKeyLoginOptResult.f11314c = jSONObject.optString("2");
                oneKeyLoginOptResult.f11315d = jSONObject.optString("3");
            } catch (JSONException e2) {
                Log.e(f11311f, e2.getMessage());
            }
        }
        return oneKeyLoginOptResult;
    }

    public static boolean isValid(OneKeyLoginOptResult oneKeyLoginOptResult) {
        return (oneKeyLoginOptResult == null || oneKeyLoginOptResult.f11312a != 0 || oneKeyLoginOptResult.f11313b != 0 || TextUtils.isEmpty(oneKeyLoginOptResult.f11314c) || TextUtils.isEmpty(oneKeyLoginOptResult.f11315d)) ? false : true;
    }

    public void generateSecurityPhone() {
        Log.d(f11311f, "generateSecurityPhone extraStr=" + this.f11315d);
        if (TextUtils.isEmpty(this.f11315d)) {
            return;
        }
        try {
            this.f11316e = new JSONObject(this.f11315d).optString(OptResultFields.SECURITY_PHONE);
        } catch (JSONException e2) {
            Log.e(f11311f, e2.getMessage());
        }
    }

    public int getCode() {
        return this.f11312a;
    }

    public String getExtraStr() {
        return this.f11315d;
    }

    public String getOperateType() {
        return this.f11314c;
    }

    public String getSecurityPhone() {
        return this.f11316e;
    }

    public int getSubCode() {
        return this.f11313b;
    }

    public void setCode(int i) {
        this.f11312a = i;
    }

    public void setSubCode(int i) {
        this.f11313b = i;
    }
}
