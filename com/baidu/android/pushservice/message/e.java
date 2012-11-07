package com.baidu.android.pushservice.message;

import android.content.Context;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.w;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ PublicMsg e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PublicMsg publicMsg, Context context, String str, String str2, String str3) {
        this.e = publicMsg;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.a);
        try {
            HttpPost httpPost = new HttpPost(w.f + this.b);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            ArrayList arrayList = new ArrayList();
            com.baidu.android.pushservice.a.a.a(arrayList);
            arrayList.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "linkhit"));
            arrayList.add(new BasicNameValuePair("channel_token", this.c));
            arrayList.add(new BasicNameValuePair("data", this.d));
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            if (proxyHttpClient.execute(httpPost).getStatusLine().getStatusCode() == 200) {
            }
        } catch (IOException e) {
        } catch (Exception e2) {
        } finally {
            proxyHttpClient.close();
        }
    }
}
