package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.SapiAccountManager;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.android.pushservice.i.c {
    protected Context a;
    protected l b;
    protected String c = com.baidu.android.pushservice.h.e();
    private C0019a d = new C0019a();

    /* renamed from: com.baidu.android.pushservice.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0019a {
        public C0019a() {
        }

        public void a(Boolean bool) {
            com.baidu.android.pushservice.g.a.c("AbstractProcessor", "isGetChannelToken result:  " + bool);
            com.baidu.android.pushservice.j.q.b("RequetChannelListener#isGetChannelToken#isSucceed=" + bool, a.this.a);
            if (bool.booleanValue()) {
                com.baidu.android.pushservice.g.b.c("AbstractProcessor", "netWorkConnect connectResult: " + a.this.c(), a.this.a);
            } else if (com.baidu.android.pushservice.j.a(a.this.a).c()) {
            } else {
                a.this.a(IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND);
                com.baidu.android.pushservice.j.q.b("RequetChannelListener#isGetChannelToken#isSucceed=false, errorcode=10002", a.this.a);
            }
        }
    }

    public a(l lVar, Context context) {
        this.b = lVar;
        this.a = context.getApplicationContext();
        a((short) 100);
        c("http-" + lVar.a);
    }

    private void a(final String str, final int i) {
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("insertHttpBehavior", (short) 95) { // from class: com.baidu.android.pushservice.e.a.1
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                try {
                    com.baidu.android.pushservice.h.h hVar = new com.baidu.android.pushservice.h.h();
                    hVar.d = str;
                    hVar.e = System.currentTimeMillis();
                    hVar.f = com.baidu.android.pushservice.h.a.b.c(a.this.a);
                    hVar.g = i;
                    if (str.equals("030403")) {
                        hVar.j = com.baidu.android.pushservice.j.q.v(a.this.a);
                    } else if (str.equals("030401")) {
                        hVar.j = com.baidu.android.pushservice.j.q.w(a.this.a);
                    }
                    com.baidu.android.pushservice.h.p.b(a.this.a, hVar);
                } catch (Exception e) {
                    com.baidu.android.pushservice.g.a.e("AbstractProcessor", "insertHttpBehavior exception");
                }
            }
        });
    }

    private int b(int i) {
        InputStream inputStream;
        boolean z;
        int i2;
        boolean z2;
        if (i > 0) {
            String b = com.baidu.android.pushservice.h.b(this.a, i == 1);
            if (b == null) {
                return IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND;
            }
            if (this.c.startsWith("http://")) {
                this.c = this.c.replace("http://", "");
                int indexOf = this.c.indexOf("/");
                if (indexOf > 0) {
                    this.c = this.c.substring(indexOf);
                }
                this.c = "http://" + b + this.c;
                com.baidu.android.pushservice.g.b.a("AbstractProcessor", " --- abstract request URL: " + this.c, this.a);
            }
        }
        InputStream inputStream2 = null;
        try {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                a(hashMap);
                com.baidu.android.pushservice.f.a a = com.baidu.android.pushservice.f.b.a(this.c, "POST", hashMap);
                int b2 = a.b();
                InputStream a2 = a.a();
                try {
                    if (b2 == 200) {
                        String a3 = com.baidu.android.pushservice.h.a.b.a(a2);
                        com.baidu.android.pushservice.g.a.b("AbstractProcessor", "<<< networkRegister return string :  " + a3);
                        a(0, b(a3).getBytes());
                        z2 = false;
                        i2 = 0;
                    } else {
                        com.baidu.android.pushservice.g.a.b("AbstractProcessor", "networkRegister request failed:  " + b2);
                        z2 = b2 == 503;
                        try {
                            String a4 = com.baidu.android.pushservice.h.a.b.a(a2);
                            com.baidu.android.pushservice.g.a.b("AbstractProcessor", "<<< networkRegister return string :  " + a4);
                            a(a4);
                            i2 = b2;
                        } catch (Exception e) {
                            e = e;
                            inputStream = a2;
                            z = z2;
                            try {
                                com.baidu.android.pushservice.g.b.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
                                if (z) {
                                    a(IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE);
                                } else {
                                    com.baidu.android.pushservice.j.q.b("tryConnect failed setResult UnKnown " + e.getMessage(), this.a);
                                    a(IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM);
                                }
                                i2 = -1;
                                com.baidu.android.pushservice.f.b.a(inputStream);
                                return i2;
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream;
                                com.baidu.android.pushservice.f.b.a(inputStream2);
                                throw th;
                            }
                        }
                    }
                    if (a2 == null || b2 == 0) {
                        if (i >= 2) {
                            a(IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND);
                        }
                        i2 = 10002;
                    }
                    com.baidu.android.pushservice.f.b.a(a2);
                } catch (Exception e2) {
                    e = e2;
                    inputStream = a2;
                    z = false;
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                z = false;
            }
            return i2;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.android.pushservice.f.b.a(inputStream2);
            throw th;
        }
    }

    private void b(int i, byte[] bArr) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.internal.RECEIVE");
        intent.putExtra(PushConstants.EXTRA_METHOD, this.b.a);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
        intent.putExtra("content", bArr);
        intent.putExtra("appid", this.b.f);
        intent.setFlags(32);
        a(intent);
        com.baidu.android.pushservice.g.a.c("AbstractProcessor", "> sendInternalMethodResult  ,method:" + this.b.a + " ,errorCode : " + i + " ,content : " + new String(bArr));
        this.a.sendBroadcast(intent);
    }

    private boolean d(String str) {
        for (String str2 : new String[]{"method_deal_lapp_bind_intent", "method_lapp_unbind", "method_set_lapp_tags", "method_del_lapp_tags", "method_list_lapp_tags"}) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.android.pushservice.i.c
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
            if (this.b.a.equals("method_deal_webapp_bind_intent")) {
                intent.setAction("com.baidu.android.pushservice.action.web.RECEIVE");
            } else if (this.b.a.equals("method_lapp_unbind") || this.b.a.equals("method_list_lapp_tags")) {
                intent.setAction("com.baidu.android.pushservice.action.lapp.RECEIVE");
            } else if (this.b.a.equals("method_sdk_bind")) {
                intent.setAction("com.baidu.android.pushservice.action.sdk.RECEIVE");
            } else {
                intent.setAction(PushConstants.ACTION_RECEIVE);
            }
            intent.putExtra(PushConstants.EXTRA_METHOD, this.b.a);
            intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            a(intent);
            boolean z = false;
            if (this.b.a.equals(PushConstants.METHOD_BIND)) {
                intent.putExtra("access_token", this.b.d);
                intent.putExtra("secret_key", this.b.i);
                intent.putExtra("real_bind", "real_bind");
                com.baidu.android.pushservice.h.b bVar = new com.baidu.android.pushservice.h.b();
                bVar.d = "020101";
                bVar.e = System.currentTimeMillis();
                bVar.f = com.baidu.android.pushservice.h.a.b.c(this.a);
                com.baidu.android.pushservice.h.i iVar = new com.baidu.android.pushservice.h.i();
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    bVar.b = jSONObject.getString("request_id");
                    if (i != 0) {
                        bVar.a = jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
                    }
                    String string = jSONObject.getJSONObject("response_params").getString("appid");
                    com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(this.a).d(string);
                    bVar.h = string;
                    String string2 = jSONObject.getJSONObject("response_params").getString("user_id");
                    iVar.a(string);
                    iVar.c(com.baidu.android.pushservice.j.q.a(string2));
                    iVar.b(string2);
                    if (d != null) {
                        iVar.d(d.c());
                        iVar = com.baidu.android.pushservice.j.q.a(iVar, this.a, d.c());
                    }
                } catch (JSONException e) {
                    z = true;
                    if (bArr != null) {
                        com.baidu.android.pushservice.g.a.e("AbstractProcessor", "bind failed msg: " + new String(bArr));
                    } else {
                        com.baidu.android.pushservice.g.b.b("AbstractProcessor", "bind failed", this.a);
                    }
                }
                bVar.g = i;
                try {
                    com.baidu.android.pushservice.h.p.a(this.a, bVar);
                    if (!z) {
                        com.baidu.android.pushservice.h.p.a(this.a, iVar);
                    }
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.b.b("AbstractProcessor", "error " + e2.getMessage(), this.a);
                }
                if (com.baidu.android.pushservice.a.b() > 0) {
                    com.baidu.android.pushservice.h.h hVar = new com.baidu.android.pushservice.h.h();
                    hVar.e = System.currentTimeMillis();
                    hVar.f = com.baidu.android.pushservice.h.a.b.c(this.a);
                    hVar.i = this.b.i;
                    hVar.d = "039904";
                    hVar.g = i;
                    if (bArr != null && bArr.length > 0) {
                        hVar.j = new String(bArr);
                    }
                    com.baidu.android.pushservice.h.p.a(this.a, hVar);
                }
            } else if (bArr != null && (this.b.a.equals("method_unbind") || this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP"))) {
                com.baidu.android.pushservice.h.b bVar2 = new com.baidu.android.pushservice.h.b();
                if (this.b.a.equals("method_unbind")) {
                    bVar2.d = "020301";
                } else {
                    bVar2.d = "020601";
                }
                bVar2.e = System.currentTimeMillis();
                bVar2.f = com.baidu.android.pushservice.h.a.b.c(this.a);
                bVar2.h = this.b.f;
                try {
                    bVar2.b = new JSONObject(new String(bArr)).getString("request_id");
                } catch (JSONException e3) {
                    com.baidu.android.pushservice.g.b.b("AbstractProcessor", "unbind failed msg: " + new String(bArr), this.a);
                    bVar2.a = new String(bArr);
                }
                try {
                    com.baidu.android.pushservice.h.p.a(this.a, bVar2);
                } catch (Exception e4) {
                    com.baidu.android.pushservice.g.b.b("AbstractProcessor", "error " + e4.getMessage(), this.a);
                }
            }
            if (!TextUtils.isEmpty(this.b.e) || d(this.b.a)) {
                if (!d(this.b.a)) {
                    intent.setPackage(this.b.e);
                }
                String str = "> sendResult to " + this.b.i + ", method:" + this.b.a + ", errorCode : " + i + ", content : " + new String(bArr);
                com.baidu.android.pushservice.g.a.c("AbstractProcessor", str);
                com.baidu.android.pushservice.j.q.b(str, this.a);
                if (this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP") || !TextUtils.isEmpty(this.b.j)) {
                    return;
                }
                com.baidu.android.pushservice.j.q.b(this.a, intent, intent.getAction(), this.b.e);
            }
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
            com.baidu.android.pushservice.g.b.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HashMap<String, String> hashMap) {
        b.b(hashMap);
        String str = this.b.a;
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(PushConstants.METHOD_BIND)) {
            if (!TextUtils.isEmpty(this.b.h)) {
                hashMap.put(SapiAccountManager.SESSION_BDUSS, this.b.h);
                hashMap.put("appid", this.b.f);
            } else if (!TextUtils.isEmpty(this.b.d)) {
                hashMap.put("access_token", this.b.d);
            } else if (TextUtils.isEmpty(this.b.i)) {
            } else {
                hashMap.put("apikey", this.b.i);
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
            hashMap.put("apikey", this.b.i);
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
            com.baidu.android.pushservice.j.q.b("AbstractProcessor#execute#mEvent = null or mEvent.method = null", this.a);
        } else if (!this.b.a.equals("com.baidu.android.pushservice.action.UNBIND") && !this.b.a.equals("method_deal_webapp_bind_intent") && !this.b.a.equals("method_sdk_unbind") && !this.b.a.equals("method_del_lapp_tags") && !this.b.a.equals("method_list_lapp_tags") && TextUtils.isEmpty(this.b.e) && !this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP")) {
            com.baidu.android.pushservice.g.a.e("AbstractProcessor", "Unknown method = " + this.b.a);
            com.baidu.android.pushservice.j.q.b("AbstractProcessor#execute#Unknown method", this.a);
        } else if (!com.baidu.android.pushservice.j.l.e(this.a)) {
            com.baidu.android.pushservice.g.b.b("AbstractProcessor", "Network is not useful!", this.a);
            com.baidu.android.pushservice.j.q.b("AbstractProcessor#execute#Network is unuseful!", this.a);
            if (com.baidu.android.pushservice.a.b() > 0) {
                com.baidu.android.pushservice.h.p.a(this.a, "039912");
            }
            a(IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND);
            com.baidu.android.pushservice.j.p.a(this.a, new Intent());
            com.baidu.android.pushservice.g.a.b("AbstractProcessor", "startPushService BaseApiProcess");
        } else {
            if (com.baidu.android.pushservice.a.b() > 0) {
                com.baidu.android.pushservice.h.p.a(this.a, "039914");
            }
            com.baidu.android.pushservice.j a = com.baidu.android.pushservice.j.a(this.a);
            synchronized (a) {
                if (a.d() || !a.c()) {
                    a.a(this.a, false, this.d);
                    com.baidu.android.pushservice.g.a.c("AbstractProcessor", "requestToken   AbstractProcessor  ");
                    com.baidu.android.pushservice.j.q.b("AbstractProcessor#requestToken#" + this.b.toString(), this.a);
                } else {
                    com.baidu.android.pushservice.g.b.c("AbstractProcessor", "netWorkConnect connectResult: " + c(), this.a);
                }
            }
        }
    }

    public boolean c() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.c)) {
            com.baidu.android.pushservice.g.a.c("AbstractProcessor", "Request Url = " + this.c);
            int i = 0;
            while (true) {
                if (i <= 2) {
                    int b = b(i);
                    if (b != 0) {
                        if (b != 10002) {
                            break;
                        }
                        if (i > 0) {
                            a("030403", b);
                        } else {
                            a("030401", b);
                        }
                        i++;
                    } else {
                        z = true;
                        if (i > 0) {
                            a("030402", b);
                        }
                    }
                } else {
                    break;
                }
            }
        } else {
            com.baidu.android.pushservice.g.b.b("AbstractProcessor", "mUrl is null", this.a);
        }
        return z;
    }
}
