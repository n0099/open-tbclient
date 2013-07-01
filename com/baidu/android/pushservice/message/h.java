package com.baidu.android.pushservice.message;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f326a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ int g;
    final /* synthetic */ PublicMsg h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PublicMsg publicMsg, Context context, String str, String str2, String str3, String str4, String str5, int i) {
        this.h = publicMsg;
        this.f326a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.f326a);
        try {
            HttpPost httpPost = new HttpPost(w.f + this.b);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            ArrayList arrayList = new ArrayList();
            com.baidu.android.pushservice.a.b.a(arrayList);
            arrayList.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "feedback"));
            arrayList.add(new BasicNameValuePair("channel_token", this.c));
            arrayList.add(new BasicNameValuePair("data", this.d));
            if (com.baidu.android.pushservice.b.a()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.d("PublicMsg", "feedback param -- " + ((NameValuePair) it.next()).toString());
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = proxyHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() != 200) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.e("PublicMsg", "networkRegister request failed  " + execute.getStatusLine());
                }
                SQLiteDatabase a2 = com.baidu.android.pushservice.util.e.a(this.f326a);
                if (a2 != null) {
                    com.baidu.android.pushservice.util.j jVar = new com.baidu.android.pushservice.util.j();
                    jVar.c = this.e;
                    jVar.b = this.f;
                    jVar.d = this.g;
                    com.baidu.android.pushservice.util.e.a(a2, jVar);
                }
            } else if (com.baidu.android.pushservice.b.a()) {
                Log.i("PublicMsg", "<<< Private Notification send result return OK!");
            }
        } catch (IOException e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", e.getMessage());
                Log.e("PublicMsg", "io exception do something ? ");
            }
            SQLiteDatabase a3 = com.baidu.android.pushservice.util.e.a(this.f326a);
            if (a3 != null) {
                com.baidu.android.pushservice.util.j jVar2 = new com.baidu.android.pushservice.util.j();
                jVar2.c = this.e;
                jVar2.b = this.f;
                jVar2.d = this.g;
                com.baidu.android.pushservice.util.e.a(a3, jVar2);
            }
        } catch (Exception e2) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("PublicMsg", e2.getMessage());
            }
            SQLiteDatabase a4 = com.baidu.android.pushservice.util.e.a(this.f326a);
            if (a4 != null) {
                com.baidu.android.pushservice.util.j jVar3 = new com.baidu.android.pushservice.util.j();
                jVar3.c = this.e;
                jVar3.b = this.f;
                jVar3.d = this.g;
                com.baidu.android.pushservice.util.e.a(a4, jVar3);
            }
        } finally {
            proxyHttpClient.close();
        }
    }
}
