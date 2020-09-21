package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.message.k;
import com.baidu.webkit.internal.GlobalConstants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b {
    protected Context a;

    public b(Context context) {
        this.a = context;
    }

    public abstract com.baidu.android.pushservice.message.g a(k kVar, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        return ("com.baidu.searchbox_samsung".equals(str) && GlobalConstants.SEARCHBOX_PACKAGE_NAME.equals(this.a.getPackageName())) ? GlobalConstants.SEARCHBOX_PACKAGE_NAME : str;
    }

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
            new b.c(this.a).a(Log.getStackTraceString(e)).a();
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
