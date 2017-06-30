package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.j.q;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c {
    private static final String b = b.class.getSimpleName();
    private Context c;

    public b(Context context) {
        super(context);
        this.c = context.getApplicationContext();
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ff  */
    @Override // com.baidu.android.pushservice.message.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str4;
        Intent intent;
        boolean z = true;
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        try {
            jSONObject = new JSONObject(new String(bArr2));
            try {
                str4 = jSONObject.getString("action");
                jSONObject2 = jSONObject;
            } catch (JSONException e) {
                e = e;
                com.baidu.android.pushservice.g.b.b(b, "Supper message parsing action Fail:\r\n" + e.getMessage(), this.c);
                z = false;
                jSONObject2 = jSONObject;
                str4 = null;
                if (z) {
                }
                intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
                intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr2);
                q.b(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE", this.a);
                if (intent == null) {
                }
                return gVar;
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        if (z || TextUtils.isEmpty(str4)) {
            intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
            intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr2);
            q.b(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE", this.a);
        } else if (str4.equalsIgnoreCase("push.NOTIFICATION")) {
            try {
                f.a(this.a, jSONObject2.isNull(VrPlayerActivityConfig.TITLE) ? null : jSONObject2.getString(VrPlayerActivityConfig.TITLE), jSONObject2.getString("description"), jSONObject2.isNull("iconUrl") ? null : jSONObject2.getString("iconUrl"), jSONObject2.isNull("url") ? null : jSONObject2.getString("url"), str2);
            } catch (JSONException e3) {
                com.baidu.android.pushservice.g.b.b(b, "Supper message parsing notification action Fail:\r\n" + e3.getMessage(), this.c);
            }
            intent = null;
        } else {
            String str5 = null;
            try {
                str5 = jSONObject2.getString(PushConstants.EXTRA_PUSH_MESSAGE);
            } catch (JSONException e4) {
                com.baidu.android.pushservice.g.a.e(b, "Supper message parsing default action Fail:\r\n" + e4.getMessage());
            }
            Intent intent2 = new Intent(str4);
            intent2.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, str5);
            intent = intent2;
        }
        if (intent == null) {
            intent.setFlags(32);
            this.a.sendBroadcast(intent);
            gVar.a(0);
        } else {
            gVar.a(2);
        }
        return gVar;
    }
}
