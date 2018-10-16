package com.baidu.ar.cloud;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.util.HttpUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements d {
    private static volatile c a;
    private HandlerThread b;
    private Handler c;
    private a d;
    private Context e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void onResourceRequest(com.baidu.ar.cloud.b bVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        private d a;

        public b(Looper looper, d dVar) {
            super(looper);
            this.a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    /* renamed from: com.baidu.ar.cloud.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0038c {
        String a;
        HashMap<String, String> b;
        byte[] c;

        public C0038c(String str, HashMap<String, String> hashMap, byte[] bArr) {
            this.a = str;
            this.b = hashMap;
            this.c = bArr;
        }
    }

    private c() {
        d();
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, HashMap<String, String> hashMap, byte[] bArr) {
        int i;
        JSONException e;
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        if (ARConfig.isAipAuth()) {
            str = str + "?access_token=" + ARConfig.getToken();
        }
        String uploadFile = HttpUtils.uploadFile(str, hashMap, bArr);
        if (TextUtils.isEmpty(uploadFile)) {
            if (this.d != null) {
                this.d.onResourceRequest(null, -1);
                return;
            }
            return;
        }
        com.baidu.ar.cloud.b bVar = new com.baidu.ar.cloud.b();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (ARConfig.isAipAuth()) {
                JSONObject jSONObject3 = new JSONObject(uploadFile);
                if (jSONObject3.has("data")) {
                    jSONObject2 = new JSONObject(jSONObject3.getString("data"));
                }
                jSONObject = jSONObject2;
            } else {
                jSONObject = new JSONObject(uploadFile);
            }
            i = jSONObject.getInt("errorNum");
        } catch (JSONException e2) {
            i = -1;
            e = e2;
        }
        try {
            bVar.a(i == 0);
            bVar.a(jSONObject.getString("errorMsg"));
            if (jSONObject.has("data") && !TextUtils.isEmpty(jSONObject.get("data").toString())) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("data");
                e eVar = new e();
                eVar.a(jSONObject4.getString("ar_key"));
                eVar.b(jSONObject4.getString("image_md5"));
                bVar.a(eVar);
                Log.e("qatest", "云端识图: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            }
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            if (this.d == null) {
            }
        }
        if (this.d == null) {
            this.d.onResourceRequest(bVar, i);
        }
    }

    private void d() {
        if (c()) {
            return;
        }
        this.b = new HandlerThread("CloudSearchThread");
        this.b.start();
        this.c = new b(this.b.getLooper(), this);
    }

    public void a(Context context, String str, HashMap<String, String> hashMap, byte[] bArr) {
        this.e = context;
        if (this.c != null) {
            this.c.removeMessages(1007);
            this.c.sendMessage(this.c.obtainMessage(1001, new C0038c(str, hashMap, bArr)));
        }
    }

    @Override // com.baidu.ar.cloud.d
    public void a(Message message) {
        switch (message.what) {
            case 1001:
                C0038c c0038c = (C0038c) message.obj;
                a(c0038c.a, c0038c.b, c0038c.c);
                return;
            default:
                return;
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void b() {
        if (this.b != null) {
            this.b.getLooper().quit();
        }
        this.d = null;
        this.b = null;
        this.c = null;
        a = null;
    }

    public boolean c() {
        return this.b != null && this.b.isAlive();
    }
}
