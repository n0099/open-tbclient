package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
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
public class a implements Runnable {
    final /* synthetic */ j a;
    private String b;
    private UrlEncodedFormEntity c;
    private int d;

    public a(j jVar, String str, UrlEncodedFormEntity urlEncodedFormEntity, int i) {
        Context context;
        this.a = jVar;
        this.b = str;
        this.c = urlEncodedFormEntity;
        this.d = i;
        if (this.d == 1) {
            context = jVar.d;
            this.b = com.baidu.android.nebula.a.d.a(context).a(this.b, false);
        }
    }

    public String a() {
        com.baidu.android.nebula.a.a aVar;
        Throwable th;
        Context context;
        try {
            HttpPost httpPost = new HttpPost(this.b);
            httpPost.setEntity(this.c);
            context = this.a.d;
            aVar = new com.baidu.android.nebula.a.a(context);
            try {
                HttpResponse execute = aVar.execute(httpPost);
                r0 = execute.getStatusLine().getStatusCode() == 200 ? EntityUtils.toString(execute.getEntity()) : null;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (Exception e) {
                if (aVar != null) {
                    aVar.a();
                }
                return r0;
            } catch (ClientProtocolException e2) {
                if (aVar != null) {
                    aVar.a();
                }
                return r0;
            } catch (IOException e3) {
                if (aVar != null) {
                    aVar.a();
                }
                return r0;
            } catch (Throwable th2) {
                th = th2;
                if (aVar != null) {
                    aVar.a();
                }
                throw th;
            }
        } catch (ClientProtocolException e4) {
            aVar = null;
        } catch (IOException e5) {
            aVar = null;
        } catch (Exception e6) {
            aVar = null;
        } catch (Throwable th3) {
            aVar = null;
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
                            context3 = this.a.d;
                            g.a(context3, string);
                            this.a.e();
                            break;
                        }
                    } catch (JSONException e) {
                        break;
                    }
                    break;
                case 1:
                    this.a.a(str);
                    break;
            }
        }
        if (this.d == 0) {
            context = this.a.d;
            synchronized (j.a(context)) {
                context2 = this.a.d;
                j.a(context2).notifyAll();
            }
        }
    }
}
