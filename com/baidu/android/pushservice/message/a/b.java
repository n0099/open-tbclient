package com.baidu.android.pushservice.message.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b {
    protected Context a;

    public b(Context context) {
        this.a = context;
    }

    public abstract com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        return ("com.baidu.searchbox_samsung".equals(str) && "com.baidu.searchbox".equals(this.a.getPackageName())) ? "com.baidu.searchbox" : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(byte[] bArr) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            i = !jSONObject.isNull("bccs_fb") ? Integer.parseInt(jSONObject.getString("bccs_fb")) : 0;
        } catch (Exception e) {
            i = 0;
        }
        return i == 1;
    }
}
