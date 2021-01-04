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
/* loaded from: classes3.dex */
public class b {
    private Activity activity;
    private com.baidu.poly.d.a.c coX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ m coK;
        final /* synthetic */ String coU;

        a(m mVar, String str) {
            this.coK = mVar;
            this.coU = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            com.baidu.poly.a.h.a.j("8");
            this.coK.e();
            b.this.b(map, this.coU, this.coK);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            this.coK.a("pay_platform error msg is " + message, (String) null);
            d.a(new com.baidu.poly.a.h.b("1").jX(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).U()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0316b implements com.baidu.poly.d.a.a {
        final /* synthetic */ m coK;
        final /* synthetic */ String coW;

        C0316b(String str, m mVar) {
            this.coW = str;
            this.coK = mVar;
        }

        @Override // com.baidu.poly.d.a.a
        public void onResult(int i, String str) {
            com.baidu.poly.util.d.info("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.coK.a(i, com.baidu.poly.util.b.a(i, this.coW, str));
        }
    }

    public b(Activity activity, com.baidu.poly.d.a.c cVar) {
        this.activity = activity;
        this.coX = cVar;
    }

    public void a(Map<String, String> map, String str, m mVar) {
        try {
            a(e.m(map), str, mVar);
        } catch (Throwable th) {
            mVar.a("third pay error msg is " + th.getMessage(), (String) null);
        }
    }

    public void b(Map<String, String> map, String str, m mVar) {
        com.baidu.poly.d.a.b bVar = new com.baidu.poly.d.a.b();
        bVar.cpB = l(map);
        bVar.channel = str;
        String str2 = map.get("payOrderNo");
        d.coG = str2;
        if (this.coX != null) {
            com.baidu.poly.a.h.a.E();
            this.coX.a(this.activity, bVar, new C0316b(str2, mVar));
            com.baidu.poly.util.d.info("WalletChannel->thirdPay setIsPreparePaying()");
            mVar.setIsPreparePaying(false);
        }
    }

    public JSONObject l(Map<String, String> map) {
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
        com.baidu.poly.a.b.b.afn().b(bundle, new a(mVar, str));
    }
}
