package com.baidu.ar.logo;

import android.net.http.Headers;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.util.HttpUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements com.baidu.ar.logo.a {
    private static volatile d a;
    private HandlerThread b;
    private Handler c;
    private IttRecognitionCallback d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private com.baidu.ar.logo.a a;

        public a(Looper looper, com.baidu.ar.logo.a aVar) {
            super(looper);
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        String a;
        HashMap<String, String> b;
        byte[] c;

        public b(String str, HashMap<String, String> hashMap, byte[] bArr) {
            this.a = str;
            this.b = hashMap;
            this.c = bArr;
        }
    }

    private d() {
        d();
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private void b(String str, HashMap<String, String> hashMap, byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append(ETAG.EQUAL);
                sb.append((Object) entry.getValue());
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.deleteCharAt(sb.lastIndexOf(ETAG.ITEM_SEPARATOR));
        }
        String post = HttpUtils.post(str, sb.toString());
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(post);
            cVar.a(jSONObject.getInt("errorNum") == 0);
            cVar.a(jSONObject.getString("errorMsg"));
            if (!jSONObject.has("data") || TextUtils.isEmpty(jSONObject.get("data").toString())) {
                if (this.d != null) {
                    this.d.recognition(arrayList);
                    return;
                }
                return;
            }
            RecognitionRes recognitionRes = new RecognitionRes();
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                recognitionRes.setName(jSONObject2.getString("name"));
                recognitionRes.setCode(jSONObject2.getString("code"));
                recognitionRes.setType(jSONObject2.getInt("type"));
                recognitionRes.setProbability(jSONObject2.getDouble("probability"));
                if (jSONObject2.has(Headers.LOCATION)) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(Headers.LOCATION);
                    com.baidu.ar.logo.b bVar = new com.baidu.ar.logo.b();
                    bVar.d(jSONObject3.getInt("height"));
                    bVar.b(jSONObject3.getInt(AiAppsNaViewModel.POSITION_KEY_TOP));
                    bVar.a(jSONObject3.getInt("left"));
                    bVar.c(jSONObject3.getInt("width"));
                    recognitionRes.setImageLocation(bVar);
                }
                arrayList.add(recognitionRes);
            }
            if (this.d != null) {
                this.d.recognition(arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            if (this.d != null) {
                this.d.recognition(arrayList);
            }
        }
    }

    private void d() {
        if (c()) {
            return;
        }
        this.b = new HandlerThread("CloudSearchThread");
        this.b.start();
        this.c = new a(this.b.getLooper(), this);
    }

    @Override // com.baidu.ar.logo.a
    public void a(Message message) {
        switch (message.what) {
            case 1001:
                b bVar = (b) message.obj;
                b(bVar.a, bVar.b, bVar.c);
                return;
            default:
                return;
        }
    }

    public void a(IttRecognitionCallback ittRecognitionCallback) {
        this.d = ittRecognitionCallback;
    }

    public void a(String str, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.c != null) {
            this.c.removeMessages(1007);
            this.c.sendMessage(this.c.obtainMessage(1001, new b(str, hashMap, bArr)));
        }
    }

    public void b() {
        a = null;
        this.d = null;
    }

    public boolean c() {
        return this.b != null && this.b.isAlive();
    }
}
