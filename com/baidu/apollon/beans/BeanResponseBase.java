package com.baidu.apollon.beans;

import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.StringUtils;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BeanResponseBase implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3661a = "系统开小差，等一会儿再试吧";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3662b = "content";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3663c = "data";
    public Session cashdesk;
    public String mdAlgorithm;
    public String result_string;
    public String signature;
    public int result = 0;
    public int err_no = 0;
    public int ret = 0;
    public String result_info = null;
    public String err_msg = null;
    public String msg = null;
    public JSONObject content = null;
    public JSONObject errContent = null;
    public JSONObject data = null;
    public String token = "";
    public int encrypted = 0;

    /* loaded from: classes.dex */
    public static class Session implements NoProguard, Serializable {
        public int biz_code;
        public String delete_flag;
        public String session_id;
        public String[] session_uri;
    }

    public String getNameOfRealResponseContent() {
        return (this.content == null && this.data != null) ? "data" : "content";
    }

    public String getRealResponseContent() {
        JSONObject jSONObject = this.content;
        if (jSONObject != null) {
            return StringUtils.replaceBom(jSONObject.toString());
        }
        JSONObject jSONObject2 = this.data;
        return jSONObject2 != null ? StringUtils.replaceBom(jSONObject2.toString()) : "";
    }

    public String getRealResponseErrContent() {
        JSONObject jSONObject = this.errContent;
        return jSONObject != null ? StringUtils.replaceBom(jSONObject.toString()) : "";
    }

    public String getRealResponseMsg() {
        if (!TextUtils.isEmpty(this.msg)) {
            return this.msg;
        }
        if (!TextUtils.isEmpty(this.err_msg)) {
            return this.err_msg;
        }
        if (TextUtils.isEmpty(this.result_info)) {
            return !TextUtils.isEmpty(this.result_string) ? this.result_string : f3661a;
        }
        return this.result_info;
    }

    public int getServerReturnValue(Class<?> cls) {
        int i2 = this.ret;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.result;
        if (i3 != 0) {
            return i3;
        }
        int i4 = this.err_no;
        if (i4 != 0) {
            return i4;
        }
        if (i2 == 0 && (this.content != null || cls == null || JsonUtils.DataType.isString(cls))) {
            return this.ret;
        }
        if (this.result == 0 && (this.data != null || cls == null || JsonUtils.DataType.isString(cls))) {
            return this.result;
        }
        int i5 = this.err_no;
        if (i5 == 0) {
            return i5;
        }
        return -3;
    }

    public String getToken() {
        return this.token;
    }

    public boolean needDecryption() {
        return this.encrypted == 1;
    }

    public boolean needVerifySignature() {
        return (TextUtils.isEmpty(this.signature) || TextUtils.isEmpty(this.mdAlgorithm)) ? false : true;
    }
}
