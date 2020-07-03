package com.baidu.poly.a.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.a.g.d;
import com.baidu.poly.util.e;
import com.baidu.poly.widget.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private Activity activity;
    private com.baidu.poly.c.a.c bAn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ m bAc;
        final /* synthetic */ String ec;

        a(String str, m mVar) {
            this.ec = str;
            this.bAc = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            com.baidu.poly.a.g.a.i("8");
            b.this.b(map, this.ec, this.bAc);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            this.bAc.a("pay_platform error msg is " + message, (String) null);
            d.a(new com.baidu.poly.a.g.b("1").gF(new com.baidu.poly.a.h.a("pay_platform error --> " + str, th).L()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0244b implements com.baidu.poly.c.a.a {
        final /* synthetic */ m bAc;
        final /* synthetic */ String bAm;

        C0244b(String str, m mVar) {
            this.bAm = str;
            this.bAc = mVar;
        }

        @Override // com.baidu.poly.c.a.a
        public void onResult(int i, String str) {
            com.baidu.poly.util.d.info("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.bAc.a(i, com.baidu.poly.util.b.a(i, this.bAm, str));
        }
    }

    public b(Activity activity, com.baidu.poly.c.a.c cVar) {
        this.activity = activity;
        this.bAn = cVar;
    }

    public void a(Map<String, String> map, String str, m mVar) {
        try {
            a(e.j(map), str, mVar);
        } catch (Throwable th) {
            mVar.a("third pay error msg is " + th.getMessage(), (String) null);
        }
    }

    public void b(Map<String, String> map, String str, m mVar) {
        com.baidu.poly.c.a.b bVar = new com.baidu.poly.c.a.b();
        bVar.bAQ = i(map);
        bVar.channel = str;
        String str2 = map.get("payOrderNo");
        d.bzY = str2;
        if (this.bAn != null) {
            com.baidu.poly.a.g.a.u();
            this.bAn.a(this.activity, bVar, new C0244b(str2, mVar));
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
        com.baidu.poly.a.b.a.NU().b(bundle, new a(str, mVar));
    }
}
