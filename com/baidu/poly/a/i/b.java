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
    private com.baidu.poly.c.a.c bvw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ m bvl;
        final /* synthetic */ String ec;

        a(String str, m mVar) {
            this.ec = str;
            this.bvl = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            com.baidu.poly.a.g.a.i("8");
            b.this.b(map, this.ec, this.bvl);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            this.bvl.a("pay_platform error msg is " + message, (String) null);
            d.a(new com.baidu.poly.a.g.b("1").gx(new com.baidu.poly.a.h.a("pay_platform error --> " + str, th).L()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0238b implements com.baidu.poly.c.a.a {
        final /* synthetic */ m bvl;
        final /* synthetic */ String bvv;

        C0238b(String str, m mVar) {
            this.bvv = str;
            this.bvl = mVar;
        }

        @Override // com.baidu.poly.c.a.a
        public void onResult(int i, String str) {
            com.baidu.poly.util.d.info("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.bvl.a(i, com.baidu.poly.util.b.a(i, this.bvv, str));
        }
    }

    public b(Activity activity, com.baidu.poly.c.a.c cVar) {
        this.activity = activity;
        this.bvw = cVar;
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
        bVar.bvZ = i(map);
        bVar.channel = str;
        String str2 = map.get("payOrderNo");
        d.bvh = str2;
        if (this.bvw != null) {
            com.baidu.poly.a.g.a.u();
            this.bvw.a(this.activity, bVar, new C0238b(str2, mVar));
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
        com.baidu.poly.a.b.a.ML().b(bundle, new a(str, mVar));
    }
}
