package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.net.ProxyHttpClient;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f622a;
    private String b;
    private UrlEncodedFormEntity c;
    private int d;

    public k(j jVar, String str, UrlEncodedFormEntity urlEncodedFormEntity, int i) {
        Context context;
        this.f622a = jVar;
        this.b = str;
        this.c = urlEncodedFormEntity;
        this.d = i;
        if (this.d == 1) {
            context = jVar.d;
            this.b = com.baidu.android.nebula.util.e.a(context).a(this.b, false);
        }
    }

    public String a() {
        ProxyHttpClient proxyHttpClient;
        Throwable th;
        Context context;
        try {
            HttpPost httpPost = new HttpPost(this.b);
            httpPost.setEntity(this.c);
            context = this.f622a.d;
            proxyHttpClient = new ProxyHttpClient(context);
            try {
                HttpResponse execute = proxyHttpClient.execute(httpPost);
                r0 = execute.getStatusLine().getStatusCode() == 200 ? EntityUtils.toString(execute.getEntity()) : null;
                if (proxyHttpClient != null) {
                    proxyHttpClient.close();
                }
            } catch (Exception e) {
                if (proxyHttpClient != null) {
                    proxyHttpClient.close();
                }
                return r0;
            } catch (ClientProtocolException e2) {
                if (proxyHttpClient != null) {
                    proxyHttpClient.close();
                }
                return r0;
            } catch (IOException e3) {
                if (proxyHttpClient != null) {
                    proxyHttpClient.close();
                }
                return r0;
            } catch (Throwable th2) {
                th = th2;
                if (proxyHttpClient != null) {
                    proxyHttpClient.close();
                }
                throw th;
            }
        } catch (ClientProtocolException e4) {
            proxyHttpClient = null;
        } catch (IOException e5) {
            proxyHttpClient = null;
        } catch (Exception e6) {
            proxyHttpClient = null;
        } catch (Throwable th3) {
            proxyHttpClient = null;
            th = th3;
        }
        return r0;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        String str = null;
        for (int i = 0; i < 3 && (str = a()) == null; i++) {
        }
        if (str != null) {
            switch (this.d) {
                case 0:
                    try {
                        String string = new JSONObject(str).getString("access_token");
                        if (!TextUtils.isEmpty(string)) {
                            context3 = this.f622a.d;
                            l.a(context3, string);
                            this.f622a.f();
                            break;
                        }
                    } catch (JSONException e) {
                        break;
                    }
                    break;
                case 1:
                    this.f622a.a(str);
                    break;
            }
        }
        if (this.d == 0) {
            context = this.f622a.d;
            synchronized (j.a(context)) {
                context2 = this.f622a.d;
                j.a(context2).notifyAll();
            }
        }
    }
}
