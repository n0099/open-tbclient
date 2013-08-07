package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.w;
import com.baidu.android.pushservice.y;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected Context f572a;
    private boolean c = false;
    protected String b = w.f;

    public d(Context context) {
        this.f572a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(this.b)) {
            if (com.baidu.android.pushservice.b.a(this.f572a)) {
                Log.e("Statistics-BaseSender", "mUrl is null");
                return;
            }
            return;
        }
        try {
            String b = b();
            while (!TextUtils.isEmpty(b)) {
                ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.f572a);
                HttpPost httpPost = new HttpPost(this.b + y.a().c());
                httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                ArrayList arrayList = new ArrayList();
                com.baidu.android.pushservice.a.b.a(arrayList);
                arrayList.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "appusestat"));
                arrayList.add(new BasicNameValuePair("channel_token", y.a().d()));
                if (com.baidu.android.pushservice.b.a(this.f572a)) {
                    Log.d("Statistics-BaseSender", "Sending statistics data: " + b);
                }
                arrayList.add(new BasicNameValuePair("data", b));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                HttpResponse execute = proxyHttpClient.execute(httpPost);
                if (execute.getStatusLine().getStatusCode() != 200) {
                    if (com.baidu.android.pushservice.b.a(this.f572a)) {
                        Log.w("Statistics-BaseSender", "Send statistics data failed, abort!" + execute.getStatusLine());
                        Log.w("Statistics-BaseSender", "Response info: " + execute.getStatusLine() + EntityUtils.toString(execute.getEntity()));
                    }
                    d();
                    proxyHttpClient.close();
                    return;
                }
                if (com.baidu.android.pushservice.b.a(this.f572a)) {
                    Log.d("Statistics-BaseSender", "Send statistics data OK, continue!");
                }
                c();
                proxyHttpClient.close();
                b = b();
            }
        } catch (Exception e) {
            Log.e("Statistics-BaseSender", "startSendLoop Exception: " + e);
        }
    }

    abstract boolean a();

    abstract String b();

    abstract void c();

    abstract void d();

    public synchronized void e() {
        if (!this.c) {
            if (a()) {
                if (ConnectManager.isNetworkConnected(this.f572a)) {
                    if (y.a().e()) {
                        this.c = true;
                        Thread thread = new Thread(new e(this));
                        thread.setName("PushService-stats-sender");
                        thread.start();
                    } else if (com.baidu.android.pushservice.b.a(this.f572a)) {
                        Log.e("Statistics-BaseSender", "Fail Send Statistics. Token invalid!");
                    }
                } else if (com.baidu.android.pushservice.b.a(this.f572a)) {
                    Log.w("Statistics-BaseSender", "Network is not reachable!");
                }
            } else if (com.baidu.android.pushservice.b.a(this.f572a)) {
                Log.w("Statistics-BaseSender", "No new data producted, do nothing!");
            }
        }
    }
}
