package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.android.pushservice.h.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f3014a;

    /* renamed from: b  reason: collision with root package name */
    public i f3015b;

    /* renamed from: d  reason: collision with root package name */
    public long f3017d = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f3016c = com.baidu.android.pushservice.h.e();

    public a(i iVar, Context context) {
        this.f3015b = iVar;
        this.f3014a = context.getApplicationContext();
        a((short) 100);
        c("http-" + iVar.f3030a);
    }

    private int b(int i2) {
        boolean z;
        int i3;
        InputStream inputStream = null;
        try {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                b(hashMap);
                HashMap<String, String> hashMap2 = new HashMap<>();
                a(hashMap2);
                com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(this.f3014a, this.f3016c, "POST", com.baidu.android.pushservice.e.c.a(hashMap), hashMap2, "application/x-www-form-urlencoded");
                this.f3017d = System.currentTimeMillis();
                int b2 = a2.b();
                inputStream = a2.a();
                if (b2 == 200) {
                    a(0, b(com.baidu.android.pushservice.j.m.a(this.f3014a, inputStream)).getBytes());
                    z = false;
                    i3 = 0;
                } else {
                    z = b2 == 503;
                    try {
                        a(com.baidu.android.pushservice.j.m.a(this.f3014a, inputStream));
                        i3 = b2;
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.android.pushservice.g.a.b("AbstractProcessor", "error : " + e.getMessage(), this.f3014a);
                        new b.c(this.f3014a).a(Log.getStackTraceString(e)).a();
                        if (z) {
                            a(10003);
                        } else {
                            com.baidu.android.pushservice.j.m.a("tryConnect failed setResult UnKnown " + e.getMessage(), this.f3014a);
                            a(20001);
                        }
                        com.baidu.android.pushservice.e.c.a(this.f3014a, inputStream);
                        return -1;
                    }
                }
                if (inputStream == null || b2 == 0) {
                    if (i2 >= 2) {
                        a(10002);
                    }
                    i3 = 10002;
                }
                com.baidu.android.pushservice.e.c.a(this.f3014a, inputStream);
                return i3;
            } catch (Throwable th) {
                com.baidu.android.pushservice.e.c.a(this.f3014a, null);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    private void e() {
        com.baidu.android.pushservice.c.a(this.f3014a).a(0, new c.a() { // from class: com.baidu.android.pushservice.d.a.1
            @Override // com.baidu.android.pushservice.c.a
            public void a(int i2, List<String> list) {
                String str = a.this.f3016c.startsWith("https://") ? "https://" : "http://";
                a aVar = a.this;
                aVar.f3016c = aVar.f3016c.replace(str, "");
                int indexOf = a.this.f3016c.indexOf("/");
                if (indexOf > 0) {
                    a aVar2 = a.this;
                    aVar2.f3016c = aVar2.f3016c.substring(indexOf);
                }
                String d2 = com.baidu.android.pushservice.h.d(a.this.f3014a);
                if (list != null && list.size() > 0) {
                    d2 = list.get(0);
                }
                a aVar3 = a.this;
                aVar3.f3016c = "https://" + d2 + a.this.f3016c;
            }
        });
    }

    @Override // com.baidu.android.pushservice.h.c
    public void a() {
        b();
    }

    public void a(int i2) {
        a(i2, PushConstants.a(i2).getBytes());
    }

    public void a(int i2, byte[] bArr) {
        String str;
        if (this.f3015b.j) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", this.f3015b.f3030a);
            intent.putExtra("error_msg", i2);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            a(intent);
            if (this.f3015b.f3030a.equals("method_bind")) {
                intent.putExtra("access_token", this.f3015b.f3032c);
                intent.putExtra("secret_key", this.f3015b.f3036g);
                intent.putExtra("real_bind", "real_bind");
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String string = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                    if (i2 != 0) {
                        str = jSONObject.getString("error_msg");
                    } else {
                        com.baidu.android.pushservice.j.l.a(this.f3014a, new Intent());
                        str = "";
                    }
                    new b.d(this.f3014a).a("bindForBD").c(i2).d(501003L).b(string).b(System.currentTimeMillis()).a(this.f3017d).c(i2 != 0 ? str : "").a();
                } catch (JSONException unused) {
                }
            } else if (bArr != null) {
                this.f3015b.f3030a.equals("method_unbind");
            }
            if (TextUtils.isEmpty(this.f3015b.f3033d)) {
                return;
            }
            com.baidu.android.pushservice.j.m.a("> sendResult to " + this.f3015b.f3036g + ", method:" + this.f3015b.f3030a + ", errorCode : " + i2 + ", content : " + new String(bArr), this.f3014a);
            intent.setPackage(this.f3015b.f3033d);
            com.baidu.android.pushservice.j.m.b(this.f3014a, intent, intent.getAction(), this.f3015b.f3033d);
        }
    }

    public void a(Intent intent) {
    }

    public void a(String str) {
        if (str == null) {
            return;
        }
        if (!str.startsWith("{\"")) {
            str = str.substring(str.indexOf("{\""));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = jSONObject.getInt("error_code");
            String string = jSONObject.getString("error_msg");
            String string2 = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error_msg", string);
            jSONObject2.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, string2);
            a(i2, jSONObject2.toString().getBytes());
        } catch (JSONException e2) {
            com.baidu.android.pushservice.g.a.b("AbstractProcessor", "error : " + e2.getMessage(), this.f3014a);
        }
    }

    public void a(HashMap<String, String> hashMap) {
        hashMap.put("Host", com.baidu.android.pushservice.h.c());
    }

    public String b(String str) {
        return str;
    }

    public void b() {
        i iVar = this.f3015b;
        if (iVar == null || TextUtils.isEmpty(iVar.f3030a)) {
            com.baidu.android.pushservice.j.m.a("AbstractProcessor#execute#mEvent = null or mEvent.method = null", this.f3014a);
        } else if (!this.f3015b.f3030a.equals("com.baidu.android.pushservice.action.UNBIND") && TextUtils.isEmpty(this.f3015b.f3033d)) {
            com.baidu.android.pushservice.j.m.a("AbstractProcessor#execute#Unknown method", this.f3014a);
        } else if (!com.baidu.android.pushservice.j.g.a(this.f3014a)) {
            com.baidu.android.pushservice.g.a.b("AbstractProcessor", "Network is not useful!", this.f3014a);
            com.baidu.android.pushservice.j.m.a("AbstractProcessor#execute#Network is unuseful!", this.f3014a);
            a(10001);
            com.baidu.android.pushservice.j.l.a(this.f3014a, new Intent());
        } else {
            boolean c2 = c();
            com.baidu.android.pushservice.g.a.c("AbstractProcessor", "netWorkConnect connectResult: " + c2, this.f3014a);
        }
    }

    public void b(HashMap<String, String> hashMap) {
        b.a(this.f3014a, hashMap);
        if (TextUtils.isEmpty(this.f3015b.f3036g)) {
            return;
        }
        hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.f3015b.f3036g);
    }

    public boolean c() {
        if (TextUtils.isEmpty(this.f3016c)) {
            com.baidu.android.pushservice.g.a.b("AbstractProcessor", "mUrl is null", this.f3014a);
            return false;
        }
        for (int i2 = 0; i2 <= 2; i2++) {
            int b2 = b(i2);
            if (b2 == 0) {
                return true;
            }
            if (b2 != 10002) {
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
}
