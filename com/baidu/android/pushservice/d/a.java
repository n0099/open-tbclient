package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushConstants;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a extends com.baidu.android.pushservice.h.c {
    protected Context a;
    protected l b;
    protected String c = com.baidu.android.pushservice.g.e();
    private C0041a d = new C0041a();

    /* renamed from: com.baidu.android.pushservice.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0041a {
        public C0041a() {
        }

        public void a(Boolean bool) {
            com.baidu.android.pushservice.i.l.b("RequetChannelListener#isGetChannelToken#isSucceed=" + bool, a.this.a);
            if (bool.booleanValue()) {
                com.baidu.android.pushservice.f.a.c("AbstractProcessor", "netWorkConnect connectResult: " + a.this.c(), a.this.a);
            } else if (com.baidu.android.pushservice.i.a(a.this.a).e()) {
            } else {
                a.this.a(10002);
                com.baidu.android.pushservice.i.l.b("RequetChannelListener#isGetChannelToken#isSucceed=false, errorcode=10002", a.this.a);
            }
        }
    }

    public a(l lVar, Context context) {
        this.b = lVar;
        this.a = context.getApplicationContext();
        a((short) 100);
        c("http-" + lVar.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007c A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #5 {all -> 0x00ad, blocks: (B:24:0x005a, B:26:0x007c, B:28:0x008a), top: B:47:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x00ad, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x00ad, blocks: (B:24:0x005a, B:26:0x007c, B:28:0x008a), top: B:47:0x005a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int b(int i) {
        InputStream inputStream;
        boolean z;
        boolean z2;
        int i2;
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            a(hashMap);
            com.baidu.android.pushservice.e.a a = com.baidu.android.pushservice.e.b.a(this.c, "POST", hashMap);
            int b = a.b();
            InputStream a2 = a.a();
            try {
                if (b == 200) {
                    try {
                        a(0, b(com.baidu.android.pushservice.g.a.b.a(a2)).getBytes());
                        z2 = false;
                        i2 = 0;
                    } catch (Exception e) {
                        e = e;
                        inputStream = a2;
                        z = false;
                        try {
                            com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
                            if (z) {
                            }
                            com.baidu.android.pushservice.e.b.a(inputStream);
                            return -1;
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.android.pushservice.e.b.a(inputStream);
                            throw th;
                        }
                    }
                } else {
                    z2 = b == 503;
                    try {
                        a(com.baidu.android.pushservice.g.a.b.a(a2));
                        i2 = b;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = a2;
                        z = z2;
                        com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
                        if (z) {
                            com.baidu.android.pushservice.i.l.b("tryConnect failed setResult UnKnown " + e.getMessage(), this.a);
                            a(20001);
                        } else {
                            a(10003);
                        }
                        com.baidu.android.pushservice.e.b.a(inputStream);
                        return -1;
                    }
                }
                if (a2 == null || b == 0) {
                    if (i >= 2) {
                        a(10002);
                    }
                    i2 = 10002;
                }
                com.baidu.android.pushservice.e.b.a(a2);
                return i2;
            } catch (Throwable th2) {
                th = th2;
                inputStream = a2;
                com.baidu.android.pushservice.e.b.a(inputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
            z = false;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private void b(int i, byte[] bArr) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.internal.RECEIVE");
        intent.putExtra("method", this.b.a);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
        intent.putExtra("content", bArr);
        intent.putExtra("appid", this.b.f);
        intent.setFlags(32);
        a(intent);
        this.a.sendBroadcast(intent);
    }

    @Override // com.baidu.android.pushservice.h.c
    public void a() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        a(i, PushConstants.a(i).getBytes());
    }

    protected void a(int i, byte[] bArr) {
        if (!TextUtils.isEmpty(this.b.b) && this.b.b.equals("internal")) {
            b(i, bArr);
        } else if (this.b.m) {
            Intent intent = new Intent();
            if (this.b.a.equals("method_sdk_bind")) {
                intent.setAction("com.baidu.android.pushservice.action.sdk.RECEIVE");
            } else {
                intent.setAction(PushConstants.ACTION_RECEIVE);
            }
            intent.putExtra("method", this.b.a);
            intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            a(intent);
            com.baidu.android.pushservice.g.a aVar = new com.baidu.android.pushservice.g.a();
            aVar.g = i;
            aVar.h = this.b.f;
            aVar.j = this.b.e;
            aVar.e = System.currentTimeMillis();
            aVar.f = com.baidu.android.pushservice.g.a.b.b(this.a);
            if (this.b.a.equals(PushConstants.METHOD_BIND)) {
                intent.putExtra("access_token", this.b.d);
                intent.putExtra("secret_key", this.b.i);
                intent.putExtra("real_bind", "real_bind");
                aVar.d = "020101";
                com.baidu.android.pushservice.g.g gVar = new com.baidu.android.pushservice.g.g();
                gVar.b(this.b.e);
                com.baidu.android.pushservice.g.g a = com.baidu.android.pushservice.i.l.a(gVar, this.a, this.b.e);
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    aVar.b = jSONObject.getString("request_id");
                    if (i != 0) {
                        aVar.a = jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
                    }
                    String string = jSONObject.getJSONObject("response_params").getString("appid");
                    aVar.h = string;
                    a.a(string);
                } catch (JSONException e) {
                }
                try {
                    com.baidu.android.pushservice.g.m.a(this.a, aVar);
                    com.baidu.android.pushservice.g.m.a(this.a, a);
                } catch (Exception e2) {
                    com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error " + e2.getMessage(), this.a);
                }
            } else if (bArr != null && (this.b.a.equals("method_unbind") || this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP"))) {
                if (this.b.a.equals("method_unbind")) {
                    aVar.d = "020301";
                } else {
                    aVar.d = "020601";
                }
                try {
                    aVar.b = new JSONObject(new String(bArr)).getString("request_id");
                } catch (JSONException e3) {
                    com.baidu.android.pushservice.f.a.b("AbstractProcessor", "unbind failed msg: " + new String(bArr), this.a);
                    aVar.a = new String(bArr);
                }
                try {
                    com.baidu.android.pushservice.g.m.a(this.a, aVar);
                } catch (Exception e4) {
                    com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error " + e4.getMessage(), this.a);
                }
            }
            if (TextUtils.isEmpty(this.b.e)) {
                return;
            }
            com.baidu.android.pushservice.i.l.b("> sendResult to " + this.b.i + ", method:" + this.b.a + ", errorCode : " + i + ", content : " + new String(bArr), this.a);
            if (this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP") || !TextUtils.isEmpty(this.b.j)) {
                return;
            }
            intent.setPackage(this.b.e);
            com.baidu.android.pushservice.i.l.b(this.a, intent, intent.getAction(), this.b.e);
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
            String string = jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
            String string2 = jSONObject.getString("request_id");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(PushConstants.EXTRA_ERROR_CODE, string);
            jSONObject2.put("request_id", string2);
            a(i, jSONObject2.toString().getBytes());
        } catch (JSONException e) {
            com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HashMap<String, String> hashMap) {
        b.a(hashMap);
        String str = this.b.a;
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(PushConstants.METHOD_BIND)) {
            if (!TextUtils.isEmpty(this.b.h)) {
                hashMap.put("bduss", this.b.h);
                hashMap.put("appid", this.b.f);
            } else if (!TextUtils.isEmpty(this.b.d)) {
                hashMap.put("access_token", this.b.d);
            } else if (TextUtils.isEmpty(this.b.i)) {
            } else {
                hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.b.i);
            }
        } else if (!TextUtils.isEmpty(this.b.h)) {
            if (this.b.e.equals(this.a.getPackageName())) {
                hashMap.put("pure_bduss", this.b.h);
            } else {
                hashMap.put("rsa_bduss", this.b.h);
            }
            hashMap.put("appid", this.b.f);
        } else if (TextUtils.isEmpty(this.b.d)) {
            if (TextUtils.isEmpty(this.b.i)) {
                return;
            }
            hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.b.i);
        } else if (this.b.e.equals(this.a.getPackageName())) {
            hashMap.put("pure_access_token", this.b.d);
        } else {
            hashMap.put("rsa_access_token", this.b.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(String str) {
        return str;
    }

    protected void b() {
        if (this.b == null || TextUtils.isEmpty(this.b.a)) {
            com.baidu.android.pushservice.i.l.b("AbstractProcessor#execute#mEvent = null or mEvent.method = null", this.a);
        } else if (!this.b.a.equals("com.baidu.android.pushservice.action.UNBIND") && !this.b.a.equals("method_sdk_unbind") && TextUtils.isEmpty(this.b.e) && !this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP")) {
            com.baidu.android.pushservice.i.l.b("AbstractProcessor#execute#Unknown method", this.a);
        } else if (!com.baidu.android.pushservice.i.g.e(this.a)) {
            com.baidu.android.pushservice.f.a.b("AbstractProcessor", "Network is not useful!", this.a);
            com.baidu.android.pushservice.i.l.b("AbstractProcessor#execute#Network is unuseful!", this.a);
            a(10001);
            com.baidu.android.pushservice.i.k.a(this.a, new Intent());
        } else {
            com.baidu.android.pushservice.i a = com.baidu.android.pushservice.i.a(this.a);
            synchronized (a) {
                if (a.f() || !a.e()) {
                    a.a(this.a, false, this.d);
                    com.baidu.android.pushservice.i.l.b("AbstractProcessor#requestToken#" + this.b.toString(), this.a);
                } else {
                    com.baidu.android.pushservice.f.a.c("AbstractProcessor", "netWorkConnect connectResult: " + c(), this.a);
                }
            }
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
        }
        return false;
    }
}
