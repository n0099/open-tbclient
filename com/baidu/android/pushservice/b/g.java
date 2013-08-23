package com.baidu.android.pushservice.b;

import android.content.Context;
import android.util.Log;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f598a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ f e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Context context, String str, String str2, String str3) {
        this.e = fVar;
        this.f598a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.f598a);
        try {
            HttpPost httpPost = new HttpPost(w.f + this.b);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            ArrayList arrayList = new ArrayList();
            com.baidu.android.pushservice.a.b.a(arrayList);
            arrayList.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "feedback"));
            arrayList.add(new BasicNameValuePair("channel_token", this.c));
            arrayList.add(new BasicNameValuePair("data", this.d));
            context3 = this.e.f597a;
            if (com.baidu.android.pushservice.b.a(context3)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.d("StatisticsInfoManager", "feedback param -- " + ((NameValuePair) it.next()).toString());
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = proxyHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                context5 = this.e.f597a;
                if (com.baidu.android.pushservice.b.a(context5)) {
                    Log.i("StatisticsInfoManager", "<<< Msg result send result return OK!");
                }
                com.baidu.android.pushservice.util.e.d(com.baidu.android.pushservice.util.e.a(this.f598a));
            } else {
                context4 = this.e.f597a;
                if (com.baidu.android.pushservice.b.a(context4)) {
                    Log.e("StatisticsInfoManager", "networkRegister request failed  " + execute.getStatusLine());
                }
            }
        } catch (Exception e) {
            context2 = this.e.f597a;
            if (com.baidu.android.pushservice.b.a(context2)) {
                Log.e("StatisticsInfoManager", "" + e.getMessage());
            }
        } catch (IOException e2) {
            context = this.e.f597a;
            if (com.baidu.android.pushservice.b.a(context)) {
                Log.e("StatisticsInfoManager", "" + e2.getMessage());
                Log.e("StatisticsInfoManager", "io exception do something ? ");
            }
        } finally {
            proxyHttpClient.close();
        }
    }
}
