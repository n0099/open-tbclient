package com.baidu.android.pushservice.message;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f729a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ PublicMsg e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PublicMsg publicMsg, Context context, String str, String str2, String str3) {
        this.e = publicMsg;
        this.f729a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.f729a);
        try {
            HttpPost httpPost = new HttpPost(w.f + this.b);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            ArrayList arrayList = new ArrayList();
            com.baidu.android.pushservice.a.b.a(arrayList);
            arrayList.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "linkhit"));
            arrayList.add(new BasicNameValuePair("channel_token", this.c));
            arrayList.add(new BasicNameValuePair("data", this.d));
            if (com.baidu.android.pushservice.b.a()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.d("PublicMsg", "linkhit param -- " + ((NameValuePair) it.next()).toString());
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = proxyHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.i("PublicMsg", "<<< public msg send result return OK!");
                }
            } else if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", "networkRegister request failed  " + execute.getStatusLine());
            }
        } catch (IOException e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", e.getMessage());
                Log.e("PublicMsg", "io exception do something ? ");
            }
        } catch (Exception e2) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", e2.getMessage());
            }
        } finally {
            proxyHttpClient.close();
        }
    }
}
