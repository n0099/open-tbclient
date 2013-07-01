package com.baidu.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.browser.core.util.BdUtil;
import java.util.ArrayList;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aj extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int i;
        Handler handler;
        String str;
        Handler handler2;
        HttpPost httpPost;
        String str2;
        String str3;
        int i2;
        int i3;
        int i4;
        HttpResponse execute;
        int statusCode;
        String str4;
        Handler handler3;
        Handler handler4;
        String str5;
        int i5;
        String str6;
        i = ah.c;
        while (i > 0) {
            try {
                httpPost = new HttpPost(ap.d());
                ArrayList arrayList = new ArrayList();
                str2 = ah.e;
                arrayList.add(new BasicNameValuePair("bloc", str2));
                str3 = ah.g;
                if (str3 != null) {
                    str6 = ah.g;
                    arrayList.add(new BasicNameValuePair("up", str6));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, BdUtil.UTF8));
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                HttpParams params = defaultHttpClient.getParams();
                i2 = ah.o;
                params.setParameter("http.connection.timeout", Integer.valueOf(i2));
                HttpParams params2 = defaultHttpClient.getParams();
                i3 = ah.o;
                params2.setParameter("http.socket.timeout", Integer.valueOf(i3));
                HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                i4 = ah.q;
                if (i4 == 1) {
                    str5 = ah.r;
                    i5 = ah.s;
                    defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(str5, i5, "http"));
                }
                execute = defaultHttpClient.execute(httpPost);
                statusCode = execute.getStatusLine().getStatusCode();
                str4 = ah.f460a;
                ap.a(str4, "===status error : " + statusCode);
            } catch (Exception e) {
            }
            if (statusCode == 200) {
                String entityUtils = EntityUtils.toString(execute.getEntity(), BdUtil.UTF8);
                handler4 = ah.v;
                Message obtainMessage = handler4.obtainMessage(26);
                obtainMessage.obj = entityUtils;
                obtainMessage.sendToTarget();
                String unused = ah.f = null;
                break;
            }
            httpPost.abort();
            handler3 = ah.v;
            Message obtainMessage2 = handler3.obtainMessage(65);
            obtainMessage2.obj = "HttpStatus error";
            obtainMessage2.sendToTarget();
            i--;
        }
        if (i <= 0) {
            handler = ah.v;
            if (handler != null) {
                str = ah.f460a;
                ap.a(str, "have tried 3 times...");
                handler2 = ah.v;
                handler2.obtainMessage(64).sendToTarget();
            }
        }
        Handler unused2 = ah.v = null;
        boolean unused3 = ah.j = false;
    }
}
