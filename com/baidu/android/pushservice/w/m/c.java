package com.baidu.android.pushservice.w.m;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c {
    public Context a;

    public c(Context context) {
        this.a = context;
    }

    public abstract com.baidu.android.pushservice.w.g a(com.baidu.android.pushservice.w.k kVar, byte[] bArr);

    public String a(String str) {
        return ("com.baidu.searchbox_samsung".equals(str) && "com.baidu.searchbox".equals(this.a.getPackageName())) ? "com.baidu.searchbox" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr) {
        int i;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(new String(bArr));
        } catch (Exception unused) {
        }
        if (!jSONObject.isNull("bccs_fb")) {
            i = Integer.parseInt(jSONObject.getString("bccs_fb"));
            return i != 1;
        }
        i = 0;
        if (i != 1) {
        }
    }
}
