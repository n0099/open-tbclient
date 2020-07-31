package com.baidu.poly.a.j;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.a.h.d;
import com.baidu.poly.util.e;
import com.baidu.poly.widget.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private Activity activity;
    private com.baidu.poly.d.a.c bAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ String bAA;
        final /* synthetic */ m bAq;

        a(String str, m mVar) {
            this.bAA = str;
            this.bAq = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            com.baidu.poly.a.h.a.j("8");
            b.this.b(map, this.bAA, this.bAq);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            this.bAq.a("pay_platform error msg is " + message, (String) null);
            d.a(new com.baidu.poly.a.h.b("1").gE(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).T()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0247b implements com.baidu.poly.d.a.a {
        final /* synthetic */ String bAC;
        final /* synthetic */ m bAq;

        C0247b(String str, m mVar) {
            this.bAC = str;
            this.bAq = mVar;
        }

        @Override // com.baidu.poly.d.a.a
        public void onResult(int i, String str) {
            com.baidu.poly.util.d.info("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.bAq.a(i, com.baidu.poly.util.b.a(i, this.bAC, str));
        }
    }

    public b(Activity activity, com.baidu.poly.d.a.c cVar) {
        this.activity = activity;
        this.bAD = cVar;
    }

    public void a(Map<String, String> map, String str, m mVar) {
        try {
            a(e.j(map), str, mVar);
        } catch (Throwable th) {
            mVar.a("third pay error msg is " + th.getMessage(), (String) null);
        }
    }

    public void b(Map<String, String> map, String str, m mVar) {
        com.baidu.poly.d.a.b bVar = new com.baidu.poly.d.a.b();
        bVar.bBg = i(map);
        bVar.channel = str;
        String str2 = map.get("payOrderNo");
        d.bAm = str2;
        if (this.bAD != null) {
            com.baidu.poly.a.h.a.D();
            this.bAD.a(this.activity, bVar, new C0247b(str2, mVar));
            com.baidu.poly.util.d.info("WalletChannel->thirdPay setIsPreparePaying()");
            mVar.setIsPreparePaying(false);
        }
    }

    public JSONObject i(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                return new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public void a(Bundle bundle, String str, m mVar) {
        bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
        com.baidu.poly.a.b.b.Oa().b(bundle, new a(str, mVar));
    }
}
