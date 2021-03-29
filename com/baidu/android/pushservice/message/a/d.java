package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f3433a;

    public d(Context context) {
        this.f3433a = context;
    }

    public abstract com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr);

    public String a(String str) {
        return ("com.baidu.searchbox_samsung".equals(str) && "com.baidu.searchbox".equals(this.f3433a.getPackageName())) ? "com.baidu.searchbox" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr) {
        int i;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(new String(bArr));
        } catch (Exception e2) {
            new b.c(this.f3433a).a(Log.getStackTraceString(e2)).a();
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
