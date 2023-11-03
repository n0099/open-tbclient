package com.baidu.android.pushservice.p;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.android.pushservice.z.c {
    public Context c;
    public i d;
    public String e = com.baidu.android.pushservice.g.a();

    /* renamed from: com.baidu.android.pushservice.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0034a implements c.d {
        public C0034a() {
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            String str = a.this.e.startsWith("https://") ? "https://" : "http://";
            a aVar = a.this;
            aVar.e = aVar.e.replace(str, "");
            int indexOf = a.this.e.indexOf("/");
            if (indexOf > 0) {
                a aVar2 = a.this;
                aVar2.e = aVar2.e.substring(indexOf);
            }
            String a = com.baidu.android.pushservice.g.a(a.this.c);
            if (list != null && list.size() > 0) {
                a = list.get(0);
            }
            a aVar3 = a.this;
            aVar3.e = "https://" + a + a.this.e;
        }
    }

    public a(i iVar, Context context) {
        this.d = iVar;
        this.c = context.getApplicationContext();
        a((short) 100);
        a("http-" + iVar.a);
    }

    @Override // com.baidu.android.pushservice.z.c
    public void a() {
        c();
    }

    public void a(int i) {
        a(i, PushConstants.a(i).getBytes());
    }

    public void a(int i, byte[] bArr) {
        if (this.d.i) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", this.d.a);
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            a(intent);
            if (this.d.a.equals("method_bind")) {
                intent.putExtra("access_token", this.d.b);
                intent.putExtra("secret_key", this.d.f);
                intent.putExtra("real_bind", "real_bind");
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                    if (i != 0) {
                        jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                    } else {
                        com.baidu.android.pushservice.a0.m.a(this.c, new Intent());
                    }
                } catch (JSONException unused) {
                }
            } else if (bArr != null) {
                this.d.a.equals("method_unbind");
            }
            if (TextUtils.isEmpty(this.d.c)) {
                return;
            }
            String str = "> sendResult to " + this.d.f + ", method:" + this.d.a + ", errorCode : " + i + ", content : " + new String(bArr);
            intent.setPackage(this.d.c);
            Utility.c(this.c, intent, intent.getAction(), this.d.c);
        }
    }

    public void a(Intent intent) {
    }

    public void a(HashMap<String, String> hashMap) {
        hashMap.put("Host", com.baidu.android.pushservice.g.b());
    }

    public final int b(int i) {
        boolean z;
        int i2;
        InputStream inputStream = null;
        try {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                b(hashMap);
                HashMap<String, String> hashMap2 = new HashMap<>();
                a(hashMap2);
                com.baidu.android.pushservice.q.b a = com.baidu.android.pushservice.q.c.a(this.c, this.e, "POST", com.baidu.android.pushservice.q.c.a(hashMap), hashMap2, "application/x-www-form-urlencoded");
                System.currentTimeMillis();
                int a2 = a.a();
                inputStream = a.b();
                if (a2 == 200) {
                    a(0, b(Utility.a(this.c, inputStream)).getBytes());
                    z = false;
                    i2 = 0;
                } else {
                    z = a2 == 503;
                    try {
                        c(Utility.a(this.c, inputStream));
                        i2 = a2;
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.u.a.b("AbstractProcessor", "error : " + e.getMessage(), this.c);
                        if (z) {
                            a(10003);
                        } else {
                            a(ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        }
                        com.baidu.android.pushservice.q.c.a(this.c, inputStream);
                        return -1;
                    }
                }
                if (inputStream == null || a2 == 0) {
                    if (i >= 2) {
                        a(10002);
                    }
                    i2 = 10002;
                }
                com.baidu.android.pushservice.q.c.a(this.c, inputStream);
                return i2;
            } catch (Throwable th) {
                com.baidu.android.pushservice.q.c.a(this.c, null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public String b(String str) {
        return str;
    }

    public void b(HashMap<String, String> hashMap) {
        b.a(this.c, hashMap);
        if (TextUtils.isEmpty(this.d.f)) {
            return;
        }
        hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.d.f);
    }

    public void c() {
        i iVar = this.d;
        if (iVar == null || TextUtils.isEmpty(iVar.a)) {
            return;
        }
        if (this.d.a.equals("com.baidu.android.pushservice.action.UNBIND") || !TextUtils.isEmpty(this.d.c)) {
            if (!com.baidu.android.pushservice.a0.g.d(this.c)) {
                com.baidu.android.pushservice.u.a.b("AbstractProcessor", "Network is not useful!", this.c);
                a(10001);
                com.baidu.android.pushservice.a0.m.a(this.c, new Intent());
                return;
            }
            boolean d = d();
            com.baidu.android.pushservice.u.a.c("AbstractProcessor", "netWorkConnect connectResult: " + d, this.c);
        }
    }

    public void c(String str) {
        if (str == null) {
            return;
        }
        if (!str.startsWith("{\"")) {
            str = str.substring(str.indexOf("{\""));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("error_code");
            String string = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            String string2 = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, string);
            jSONObject2.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, string2);
            a(i, jSONObject2.toString().getBytes());
        } catch (JSONException e) {
            com.baidu.android.pushservice.u.a.b("AbstractProcessor", "error : " + e.getMessage(), this.c);
        }
    }

    public boolean d() {
        if (TextUtils.isEmpty(this.e)) {
            com.baidu.android.pushservice.u.a.b("AbstractProcessor", "mUrl is null", this.c);
            return false;
        }
        for (int i = 0; i <= 2; i++) {
            int b = b(i);
            if (b == 0) {
                return true;
            }
            if (b != 10002) {
                return false;
            }
            e();
            try {
                Thread.sleep(5000L);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final void e() {
        com.baidu.android.pushservice.c.a(this.c).a(0, new C0034a());
    }
}
