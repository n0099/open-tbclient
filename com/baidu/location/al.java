package com.baidu.location;

import com.baidu.browser.core.util.BdUtil;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        boolean z;
        String str2;
        int i;
        int i2;
        String str3;
        boolean z2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Long valueOf;
        String str9;
        String str10;
        String str11;
        boolean z3 = true;
        try {
            HttpPost httpPost = new HttpPost(ap.d());
            ArrayList arrayList = new ArrayList();
            z = ah.m;
            if (z) {
                arrayList.add(new BasicNameValuePair("qt", "grid"));
            } else {
                arrayList.add(new BasicNameValuePair("qt", "conf"));
            }
            str2 = ah.h;
            arrayList.add(new BasicNameValuePair("req", str2));
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, BdUtil.UTF8));
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpParams params = defaultHttpClient.getParams();
            i = ah.o;
            params.setParameter("http.connection.timeout", Integer.valueOf(i));
            HttpParams params2 = defaultHttpClient.getParams();
            i2 = ah.o;
            params2.setParameter("http.socket.timeout", Integer.valueOf(i2));
            str3 = ah.a;
            ap.a(str3, "req config...");
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                z2 = ah.m;
                if (z2) {
                    str6 = ah.a;
                    ap.a(str6, "req config response...");
                    byte[] byteArray = EntityUtils.toByteArray(execute.getEntity());
                    if (byteArray == null) {
                        z3 = false;
                    } else if (byteArray.length < 640) {
                        str11 = ah.a;
                        ap.a(str11, "req config response.<640.");
                        ap.s = false;
                        ap.p = ap.n + 0.025d;
                        ap.o = ap.m - 0.025d;
                    } else {
                        ap.s = true;
                        Long valueOf2 = Long.valueOf(((byteArray[7] & 255) << 56) | ((byteArray[6] & 255) << 48) | ((byteArray[5] & 255) << 40) | ((byteArray[4] & 255) << 32) | ((byteArray[3] & 255) << 24) | ((byteArray[2] & 255) << 16) | ((byteArray[1] & 255) << 8) | (byteArray[0] & 255));
                        str7 = ah.a;
                        ap.a(str7, "req config 1...");
                        ap.o = Double.longBitsToDouble(valueOf2.longValue());
                        str8 = ah.a;
                        ap.a(str8, "req config response:" + Double.longBitsToDouble(valueOf2.longValue()));
                        ap.p = Double.longBitsToDouble(Long.valueOf(((byteArray[15] & 255) << 56) | ((byteArray[14] & 255) << 48) | ((byteArray[13] & 255) << 40) | ((byteArray[12] & 255) << 32) | ((byteArray[11] & 255) << 24) | ((byteArray[10] & 255) << 16) | ((byteArray[9] & 255) << 8) | (byteArray[8] & 255)).longValue());
                        ap.r = new byte[625];
                        str9 = ah.a;
                        ap.a(str9, "req config response:" + Double.longBitsToDouble(valueOf.longValue()));
                        for (int i3 = 0; i3 < 625; i3++) {
                            ap.r[i3] = byteArray[i3 + 16];
                            str10 = ah.a;
                            ap.a(str10, "req config value:" + ((int) ap.r[i3]));
                        }
                    }
                    if (z3) {
                        ah.c();
                    }
                } else {
                    String entityUtils = EntityUtils.toString(execute.getEntity(), BdUtil.UTF8);
                    str4 = ah.a;
                    ap.a(str4, "req config value:" + entityUtils);
                    if (ah.a(entityUtils)) {
                        str5 = ah.a;
                        ap.a(str5, "Save to config");
                        ah.b();
                    }
                }
            }
        } catch (Exception e) {
            str = ah.a;
            ap.a(str, "Exception!!!");
        } finally {
            String unused = ah.h = null;
            boolean unused2 = ah.l = false;
            boolean unused3 = ah.m = false;
        }
    }
}
