package com.baidu.android.nebula.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.net.ProxyHttpClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private static a d = null;

    /* renamed from: a  reason: collision with root package name */
    private String f666a = "^http[s]?:\\/\\/[^\\/]+(\\.baidu\\.com|\\.hao123\\.com)(:\\d+)?(\\/.*|)$";
    private byte b = 0;
    private Context c;

    private a(Context context) {
        this.c = null;
        this.c = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a(context);
            }
            aVar = d;
        }
        return aVar;
    }

    public boolean a(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && Pattern.compile(this.f666a).matcher(str).matches()) {
            z = true;
        }
        if (this.b == 0) {
            this.b = (byte) 1;
            b bVar = new b(this);
            bVar.setName("ServerAuth");
            bVar.setPriority(10);
            bVar.start();
        }
        return z;
    }

    public String b(Context context) {
        String str = null;
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(context);
        try {
            HttpPost httpPost = new HttpPost(com.baidu.android.moplus.b.b);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bdapplocatesetting", 0);
            jSONObject.put("format", "json");
            arrayList.add(new BasicNameValuePair("updateversion", jSONObject.toString()));
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = proxyHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                str = new JSONObject(EntityUtils.toString(execute.getEntity())).getJSONObject("bdapplocatesetting").getString("data");
            } else {
                EntityUtils.toString(execute.getEntity());
            }
        } catch (IOException e) {
        } catch (Exception e2) {
        } finally {
            proxyHttpClient.close();
        }
        return str;
    }
}
