package com.baidu.poly.a.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.util.d;
import com.baidu.poly.widget.l;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private Activity activity;
    private com.baidu.poly.c.a.c bnR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ l bnE;
        final /* synthetic */ String bnO;

        a(String str, l lVar) {
            this.bnO = str;
            this.bnE = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            b.this.b(map, this.bnO, this.bnE);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            this.bnE.a("pay_platform error msg is " + message);
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("1").fK(new com.baidu.poly.a.h.a("pay_platform error --> " + str, th).B()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0183b implements com.baidu.poly.c.a.a {
        final /* synthetic */ l bnE;
        final /* synthetic */ String bnQ;

        C0183b(String str, l lVar) {
            this.bnQ = str;
            this.bnE = lVar;
        }

        @Override // com.baidu.poly.c.a.a
        public void onResult(int i, String str) {
            com.baidu.poly.util.c.info("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.bnE.a(i, com.baidu.poly.util.a.a(i, this.bnQ, str));
        }
    }

    public b(Activity activity, com.baidu.poly.c.a.c cVar) {
        this.activity = activity;
        this.bnR = cVar;
    }

    public void a(Map<String, String> map, String str, l lVar) {
        try {
            a(d.i(map), str, lVar);
        } catch (Throwable th) {
            lVar.a("third pay error msg is " + th.getMessage());
        }
    }

    public void b(Map<String, String> map, String str, l lVar) {
        com.baidu.poly.c.a.b bVar = new com.baidu.poly.c.a.b();
        bVar.bou = h(map);
        bVar.channel = str;
        String str2 = map.get("payOrderNo");
        com.baidu.poly.a.g.c.bnB = str2;
        com.baidu.poly.c.a.c cVar = this.bnR;
        if (cVar != null) {
            cVar.a(this.activity, bVar, new C0183b(str2, lVar));
            com.baidu.poly.util.c.info("WalletChannel->thirdPay setIsPreparePaying()");
            lVar.setIsPreparePaying(false);
        }
    }

    public JSONObject h(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                return new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(Bundle bundle, String str, l lVar) {
        bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
        com.baidu.poly.a.b.a.KR().b(bundle, new a(str, lVar));
    }
}
