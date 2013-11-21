package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.pushservice.y;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    protected Context f698a;
    protected String b;
    private boolean c = false;

    public k(Context context) {
        this.f698a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
        if (com.baidu.android.pushservice.b.a(r5.f698a) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
        com.baidu.android.common.logging.Log.w("Statistics-BaseSender", "Send statistics data failed, abort!" + r0.getStatusLine());
        com.baidu.android.common.logging.Log.w("Statistics-BaseSender", "Response info: " + r0.getStatusLine() + org.apache.http.util.EntityUtils.toString(r0.getEntity()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f0, code lost:
        d();
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        if (TextUtils.isEmpty(this.b)) {
            if (com.baidu.android.pushservice.b.a(this.f698a)) {
                Log.e("Statistics-BaseSender", "mUrl is null");
                return;
            }
            return;
        }
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.f698a);
        try {
            String b = b();
            while (true) {
                if (!TextUtils.isEmpty(b)) {
                    if (!e()) {
                        this.b += y.a().c();
                    }
                    HttpPost httpPost = new HttpPost(this.b);
                    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    ArrayList arrayList = new ArrayList();
                    com.baidu.android.pushservice.a.b.a(arrayList);
                    a(b, arrayList);
                    httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                    if (proxyHttpClient.execute(httpPost).getStatusLine().getStatusCode() != 200) {
                        break;
                    }
                    if (com.baidu.android.pushservice.b.a(this.f698a)) {
                        Log.d("Statistics-BaseSender", "Send statistics data OK, continue!");
                    }
                    c();
                    proxyHttpClient.close();
                    if (e()) {
                        break;
                    }
                    b = b();
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            Log.e("Statistics-BaseSender", "startSendLoop Exception: " + e);
        } finally {
            proxyHttpClient.close();
        }
    }

    abstract void a(String str, List list);

    abstract boolean a();

    abstract String b();

    abstract void c();

    abstract void d();

    abstract boolean e();

    public synchronized void g() {
        if (!this.c) {
            if (a()) {
                if (ConnectManager.isNetworkConnected(this.f698a)) {
                    if (y.a().e()) {
                        this.c = true;
                        Thread thread = new Thread(new l(this));
                        thread.setName("PushService-stats-sender");
                        thread.start();
                    } else if (com.baidu.android.pushservice.b.a(this.f698a)) {
                        Log.e("Statistics-BaseSender", "Fail Send Statistics. Token invalid!");
                    }
                } else if (com.baidu.android.pushservice.b.a(this.f698a)) {
                    Log.w("Statistics-BaseSender", "Network is not reachable!");
                }
            } else if (com.baidu.android.pushservice.b.a(this.f698a)) {
                Log.w("Statistics-BaseSender", "No new data producted, do nothing!");
            }
        }
    }
}
