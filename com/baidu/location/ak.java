package com.baidu.location;

import com.baidu.browser.core.util.BdUtil;
import java.util.ArrayList;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak extends Thread {
    /* JADX WARN: Incorrect condition in loop: B:5:0x0018 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ArrayList arrayList;
        int i;
        int i2;
        String str;
        String str2;
        ArrayList arrayList2;
        int i3;
        ArrayList arrayList3;
        ArrayList arrayList4;
        try {
            HttpPost httpPost = new HttpPost(ap.d());
            ArrayList arrayList5 = new ArrayList();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                i3 = ah.t;
                if (i3 == 1) {
                    arrayList4 = ah.n;
                    arrayList5.add(new BasicNameValuePair("cldc[" + i4 + "]", (String) arrayList4.get(i4)));
                } else {
                    arrayList3 = ah.n;
                    arrayList5.add(new BasicNameValuePair("cltr[" + i4 + "]", (String) arrayList3.get(i4)));
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList5, BdUtil.UTF8));
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpParams params = defaultHttpClient.getParams();
            i = ah.o;
            params.setParameter("http.connection.timeout", Integer.valueOf(i));
            HttpParams params2 = defaultHttpClient.getParams();
            i2 = ah.o;
            params2.setParameter("http.socket.timeout", Integer.valueOf(i2));
            if (defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode() == 200) {
                str2 = ah.f460a;
                ap.a(str2, "Status ok1...");
                arrayList2 = ah.n;
                arrayList2.clear();
                ArrayList unused = ah.n = null;
            } else {
                str = ah.f460a;
                ap.a(str, "Status err1...");
            }
        } catch (Exception e) {
        } finally {
            boolean unused2 = ah.k = false;
        }
    }
}
