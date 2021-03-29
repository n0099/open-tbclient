package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OneKeyLoginOptResult implements NoProguard {

    /* renamed from: f  reason: collision with root package name */
    public static final String f11312f = "OneKeyLoginOptResult";

    /* renamed from: a  reason: collision with root package name */
    public int f11313a;

    /* renamed from: b  reason: collision with root package name */
    public int f11314b;

    /* renamed from: c  reason: collision with root package name */
    public String f11315c;

    /* renamed from: d  reason: collision with root package name */
    public String f11316d;

    /* renamed from: e  reason: collision with root package name */
    public String f11317e;

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
                oneKeyLoginOptResult.f11313a = jSONObject.optInt("0", -202);
                oneKeyLoginOptResult.f11314b = jSONObject.optInt("1", -202);
                oneKeyLoginOptResult.f11315c = jSONObject.optString("2");
                oneKeyLoginOptResult.f11316d = jSONObject.optString("3");
            } catch (JSONException e2) {
                Log.e(f11312f, e2.getMessage());
            }
        }
        return oneKeyLoginOptResult;
    }

    public static boolean isValid(OneKeyLoginOptResult oneKeyLoginOptResult) {
        return (oneKeyLoginOptResult == null || oneKeyLoginOptResult.f11313a != 0 || oneKeyLoginOptResult.f11314b != 0 || TextUtils.isEmpty(oneKeyLoginOptResult.f11315c) || TextUtils.isEmpty(oneKeyLoginOptResult.f11316d)) ? false : true;
    }

    public void generateSecurityPhone() {
        Log.d(f11312f, "generateSecurityPhone extraStr=" + this.f11316d);
        if (TextUtils.isEmpty(this.f11316d)) {
            return;
        }
        try {
            this.f11317e = new JSONObject(this.f11316d).optString(OptResultFields.SECURITY_PHONE);
        } catch (JSONException e2) {
            Log.e(f11312f, e2.getMessage());
        }
    }

    public int getCode() {
        return this.f11313a;
    }

    public String getExtraStr() {
        return this.f11316d;
    }

    public String getOperateType() {
        return this.f11315c;
    }

    public String getSecurityPhone() {
        return this.f11317e;
    }

    public int getSubCode() {
        return this.f11314b;
    }

    public void setCode(int i) {
        this.f11313a = i;
    }

    public void setSubCode(int i) {
        this.f11314b = i;
    }
}
