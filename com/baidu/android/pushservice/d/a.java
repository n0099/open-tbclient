package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class a extends com.baidu.android.pushservice.g.c {
    protected Context a;
    protected i b;
    private long d = 0;
    protected String c = com.baidu.android.pushservice.h.e();

    public a(i iVar, Context context) {
        this.b = iVar;
        this.a = context.getApplicationContext();
        a((short) 100);
        c("http-" + iVar.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:6:0x002f, B:13:0x004c, B:24:0x006d, B:26:0x00a1, B:28:0x00b1, B:20:0x005f), top: B:40:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1 A[Catch: all -> 0x00d4, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:6:0x002f, B:13:0x004c, B:24:0x006d, B:26:0x00a1, B:28:0x00b1, B:20:0x005f), top: B:40:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int b(int i) {
        InputStream inputStream;
        boolean z;
        int i2;
        try {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                a(hashMap);
                com.baidu.android.pushservice.e.a a = com.baidu.android.pushservice.e.b.a(this.a, this.c, "POST", hashMap, null, com.baidu.android.pushservice.h.c());
                this.d = System.currentTimeMillis();
                int b = a.b();
                inputStream = a.a();
                if (b == 200) {
                    try {
                        a(0, b(com.baidu.android.pushservice.i.m.a(this.a, inputStream)).getBytes());
                        z = false;
                        i2 = 0;
                    } catch (Exception e) {
                        e = e;
                        z = false;
                        com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
                        new b.c(this.a).a(Log.getStackTraceString(e)).a();
                        if (z) {
                        }
                        com.baidu.android.pushservice.e.b.a(this.a, inputStream);
                        return -1;
                    }
                } else {
                    z = b == 503;
                    try {
                        a(com.baidu.android.pushservice.i.m.a(this.a, inputStream));
                        i2 = b;
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
                        new b.c(this.a).a(Log.getStackTraceString(e)).a();
                        if (z) {
                            com.baidu.android.pushservice.i.m.a("tryConnect failed setResult UnKnown " + e.getMessage(), this.a);
                            a(com.baidu.sapi2.share.m.g);
                        } else {
                            a(10003);
                        }
                        com.baidu.android.pushservice.e.b.a(this.a, inputStream);
                        return -1;
                    }
                }
                if (inputStream == null || b == 0) {
                    if (i >= 2) {
                        a(10002);
                    }
                    i2 = 10002;
                }
                com.baidu.android.pushservice.e.b.a(this.a, inputStream);
                return i2;
            } catch (Throwable th) {
                th = th;
                com.baidu.android.pushservice.e.b.a(this.a, null);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.android.pushservice.e.b.a(this.a, null);
            throw th;
        }
    }

    private void e() {
        com.baidu.android.pushservice.c.a(this.a).a(0, new c.a() { // from class: com.baidu.android.pushservice.d.a.1
            @Override // com.baidu.android.pushservice.c.a
            public void a(int i, String str) {
                a.this.c = a.this.c.replace(a.this.c.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) ? SapiUtils.COOKIE_HTTPS_URL_PREFIX : "http://", "");
                int indexOf = a.this.c.indexOf("/");
                if (indexOf > 0) {
                    a.this.c = a.this.c.substring(indexOf);
                }
                if (TextUtils.isEmpty(str)) {
                    str = com.baidu.android.pushservice.h.d(a.this.a);
                }
                a.this.c = SapiUtils.COOKIE_HTTPS_URL_PREFIX + str + a.this.c;
            }
        });
    }

    @Override // com.baidu.android.pushservice.g.c
    public void a() {
        b();
    }

    protected void a(int i) {
        a(i, PushConstants.a(i).getBytes());
    }

    protected void a(int i, byte[] bArr) {
        if (this.b.j) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", this.b.a);
            intent.putExtra("error_msg", i);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            a(intent);
            if (this.b.a.equals("method_bind")) {
                intent.putExtra("access_token", this.b.c);
                intent.putExtra("secret_key", this.b.g);
                intent.putExtra("real_bind", "real_bind");
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String string = jSONObject.getString("request_id");
                    String str = "";
                    if (i != 0) {
                        str = jSONObject.getString("error_msg");
                    } else {
                        com.baidu.android.pushservice.i.l.a(this.a, new Intent());
                    }
                    b.d a = new b.d(this.a).a("bindForBD").c(i).d(501003L).b(string).b(System.currentTimeMillis()).a(this.d);
                    if (i == 0) {
                        str = "";
                    }
                    a.c(str).a();
                } catch (JSONException e) {
                }
            } else if (bArr == null || this.b.a.equals("method_unbind")) {
            }
            if (TextUtils.isEmpty(this.b.d)) {
                return;
            }
            com.baidu.android.pushservice.i.m.a("> sendResult to " + this.b.g + ", method:" + this.b.a + ", errorCode : " + i + ", content : " + new String(bArr), this.a);
            intent.setPackage(this.b.d);
            com.baidu.android.pushservice.i.m.b(this.a, intent, intent.getAction(), this.b.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Intent intent) {
    }

    protected void a(String str) {
        if (str == null) {
            return;
        }
        if (!str.startsWith("{\"")) {
            str = str.substring(str.indexOf("{\""));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("error_code");
            String string = jSONObject.getString("error_msg");
            String string2 = jSONObject.getString("request_id");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error_msg", string);
            jSONObject2.put("request_id", string2);
            a(i, jSONObject2.toString().getBytes());
        } catch (JSONException e) {
            com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HashMap<String, String> hashMap) {
        b.a(this.a, hashMap);
        if (TextUtils.isEmpty(this.b.g)) {
            return;
        }
        hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.b.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(String str) {
        return str;
    }

    protected void b() {
        if (this.b == null || TextUtils.isEmpty(this.b.a)) {
            com.baidu.android.pushservice.i.m.a("AbstractProcessor#execute#mEvent = null or mEvent.method = null", this.a);
        } else if (!this.b.a.equals("com.baidu.android.pushservice.action.UNBIND") && TextUtils.isEmpty(this.b.d)) {
            com.baidu.android.pushservice.i.m.a("AbstractProcessor#execute#Unknown method", this.a);
        } else if (com.baidu.android.pushservice.i.g.a(this.a)) {
            com.baidu.android.pushservice.f.a.c("AbstractProcessor", "netWorkConnect connectResult: " + c(), this.a);
        } else {
            com.baidu.android.pushservice.f.a.b("AbstractProcessor", "Network is not useful!", this.a);
            com.baidu.android.pushservice.i.m.a("AbstractProcessor#execute#Network is unuseful!", this.a);
            a(10001);
            com.baidu.android.pushservice.i.l.a(this.a, new Intent());
        }
    }

    public boolean c() {
        if (TextUtils.isEmpty(this.c)) {
            com.baidu.android.pushservice.f.a.b("AbstractProcessor", "mUrl is null", this.a);
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
            } catch (Exception e) {
            }
        }
        return false;
    }
}
