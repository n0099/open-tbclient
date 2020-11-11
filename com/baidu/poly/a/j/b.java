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
/* loaded from: classes6.dex */
public class b {
    private Activity activity;
    private com.baidu.poly.d.a.c cdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ m ccQ;
        final /* synthetic */ String cda;

        a(m mVar, String str) {
            this.ccQ = mVar;
            this.cda = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            com.baidu.poly.a.h.a.j("8");
            this.ccQ.e();
            b.this.b(map, this.cda, this.ccQ);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            this.ccQ.a("pay_platform error msg is " + message, (String) null);
            d.a(new com.baidu.poly.a.h.b("1").jA(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).U()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0307b implements com.baidu.poly.d.a.a {
        final /* synthetic */ m ccQ;
        final /* synthetic */ String cdc;

        C0307b(String str, m mVar) {
            this.cdc = str;
            this.ccQ = mVar;
        }

        @Override // com.baidu.poly.d.a.a
        public void onResult(int i, String str) {
            com.baidu.poly.util.d.info("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.ccQ.a(i, com.baidu.poly.util.b.a(i, this.cdc, str));
        }
    }

    public b(Activity activity, com.baidu.poly.d.a.c cVar) {
        this.activity = activity;
        this.cdd = cVar;
    }

    public void a(Map<String, String> map, String str, m mVar) {
        try {
            a(e.l(map), str, mVar);
        } catch (Throwable th) {
            mVar.a("third pay error msg is " + th.getMessage(), (String) null);
        }
    }

    public void b(Map<String, String> map, String str, m mVar) {
        com.baidu.poly.d.a.b bVar = new com.baidu.poly.d.a.b();
        bVar.cdH = k(map);
        bVar.channel = str;
        String str2 = map.get("payOrderNo");
        d.ccM = str2;
        if (this.cdd != null) {
            com.baidu.poly.a.h.a.E();
            this.cdd.a(this.activity, bVar, new C0307b(str2, mVar));
            com.baidu.poly.util.d.info("WalletChannel->thirdPay setIsPreparePaying()");
            mVar.setIsPreparePaying(false);
        }
    }

    public JSONObject k(Map<String, String> map) {
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
        com.baidu.poly.a.b.b.aaS().b(bundle, new a(mVar, str));
    }
}
