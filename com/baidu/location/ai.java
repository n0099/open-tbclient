package com.baidu.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.browser.core.util.BdUtil;
import java.util.ArrayList;
import org.apache.http.Header;
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
public final class ai extends Thread {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x009c, code lost:
        if (r3 == 4) goto L26;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        String str4;
        int i4;
        int i5;
        int i6;
        String str5;
        String str6;
        int i7;
        String str7;
        int i8;
        HttpResponse execute;
        int statusCode;
        String str8;
        Handler handler3;
        String str9;
        Handler handler4;
        int i9;
        String str10;
        i = ah.c;
        int i10 = i;
        while (i10 > 0) {
            try {
                httpPost = new HttpPost(ap.d());
                ArrayList arrayList = new ArrayList();
                str2 = ah.d;
                arrayList.add(new BasicNameValuePair("bloc", str2));
                str3 = ah.f;
                if (str3 != null) {
                    str10 = ah.f;
                    arrayList.add(new BasicNameValuePair("up", str10));
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
                str4 = ah.f460a;
                StringBuilder append = new StringBuilder().append("apn type : ");
                i4 = ah.q;
                ap.a(str4, append.append(i4).toString());
                i5 = ah.q;
                if (i5 != 1) {
                    i9 = ah.q;
                }
                i6 = ah.c;
                if ((i6 - i10) % 2 == 0) {
                    str5 = ah.f460a;
                    StringBuilder append2 = new StringBuilder().append("apn type : ADD PROXY");
                    str6 = ah.r;
                    StringBuilder append3 = append2.append(str6);
                    i7 = ah.s;
                    ap.a(str5, append3.append(i7).toString());
                    str7 = ah.r;
                    i8 = ah.s;
                    defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(str7, i8, "http"));
                }
                execute = defaultHttpClient.execute(httpPost);
                statusCode = execute.getStatusLine().getStatusCode();
                str8 = ah.f460a;
                ap.a(str8, "===status error : " + statusCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (statusCode == 200) {
                String entityUtils = EntityUtils.toString(execute.getEntity(), BdUtil.UTF8);
                Header contentType = execute.getEntity().getContentType();
                str9 = ah.f460a;
                ap.a(str9, "status error : " + contentType);
                handler4 = ah.u;
                Message obtainMessage = handler4.obtainMessage(21);
                obtainMessage.obj = entityUtils;
                obtainMessage.sendToTarget();
                String unused = ah.f = null;
                break;
            }
            httpPost.abort();
            handler3 = ah.u;
            Message obtainMessage2 = handler3.obtainMessage(63);
            obtainMessage2.obj = "HttpStatus error";
            obtainMessage2.sendToTarget();
            i10--;
        }
        if (i10 <= 0) {
            handler = ah.u;
            if (handler != null) {
                str = ah.f460a;
                ap.a(str, "have tried 3 times...");
                handler2 = ah.u;
                handler2.obtainMessage(62).sendToTarget();
            }
        }
        Handler unused2 = ah.u = null;
        boolean unused3 = ah.i = false;
    }
}
