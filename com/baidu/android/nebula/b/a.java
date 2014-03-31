package com.baidu.android.nebula.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.security.Base64;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private static volatile a b = null;
    private static String g = "http://m.baidu.com/open/iasdk?";
    private Context a;
    private ExecutorService c;
    private String d;
    private p e = null;
    private n f;

    private a(Context context) {
        this.a = null;
        this.c = null;
        this.f = null;
        this.a = context;
        this.f = new n();
        this.c = Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        if (b == null) {
            b = new a(context);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream a(HttpEntity httpEntity) {
        Header contentEncoding = httpEntity.getContentEncoding();
        if (contentEncoding == null || contentEncoding.getValue().toLowerCase().indexOf("gzip") == -1) {
            return null;
        }
        return new GZIPInputStream(httpEntity.getContent());
    }

    private String a(String str) {
        byte[] a = e.a(str.getBytes());
        a[0] = 117;
        a[1] = 123;
        try {
            return Base64.encode(a, "utf-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("AppListPostRequest", "--- encrypt : Base64 Fail!");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InputStream inputStream) {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 100);
            if (read <= 0) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        JSONObject jSONObject2 = new JSONObject(new String(byteArrayOutputStream.toByteArray(), "utf-8"));
        this.f.k();
        if (jSONObject2.has("status")) {
            this.f.a(jSONObject2.getInt("status"));
        }
        if (!jSONObject2.has("result") || (jSONObject = jSONObject2.getJSONObject("result")) == null) {
            return;
        }
        if (jSONObject.has("action")) {
            this.d = jSONObject.getString("action");
        }
        if (jSONObject.has("channelid")) {
            long j = 0;
            try {
                j = Long.parseLong(jSONObject.getString("channelid"));
            } catch (NumberFormatException e) {
            }
            this.f.b(j);
        }
        if (jSONObject.has("maxnum")) {
            this.f.b(jSONObject.getInt("maxnum"));
        }
        if (jSONObject.has("token")) {
            this.f.a(jSONObject.getLong("token"));
        }
        if (jSONObject.has("retlist")) {
            String string = jSONObject.getString("retlist");
            this.f.a().clear();
            if (!TextUtils.isEmpty(string)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                char[] charArray = string.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    if (charArray[i] == '0') {
                        arrayList.add(Integer.valueOf(i));
                    } else {
                        arrayList2.add(Integer.valueOf(i));
                    }
                }
                if (arrayList.size() > 0) {
                    this.f.b();
                }
                this.f.a(arrayList);
                this.f.b(arrayList2);
            }
        }
        if (jSONObject.has("synctimeinterval")) {
            m.c(this.a, Long.valueOf(jSONObject.getLong("synctimeinterval")).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (TextUtils.equals(this.d, "needsmeetuser_info") || TextUtils.equals(this.d, "needsmeetsync_info") || TextUtils.equals(this.d, "needsmeetapp_info")) {
            this.e.a(this.f);
        }
    }

    public final n a() {
        return this.f;
    }

    public final void a(String str, p pVar) {
        this.e = pVar;
        String a = a(str);
        this.c.submit(new i(this, com.baidu.android.nebula.util.d.a(this.a).a(g), a));
    }
}
