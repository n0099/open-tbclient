package com.baidu.android.pushservice.message.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c {
    private static final String b = c.class.getSimpleName();
    protected Context a;

    public c(Context context) {
        this.a = context;
    }

    public abstract com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr);

    public abstract com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr) {
        int i;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(new String(bArr));
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.e(b, "Message parsing feedback fail:\r\n" + e.getMessage());
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
