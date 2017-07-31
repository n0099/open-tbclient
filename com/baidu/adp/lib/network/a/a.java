package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static boolean xA;
    private static String xB;
    private static String xx;
    private static String xy;
    private static String xz;
    private e xC;
    private c xD;
    private long xE;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.xE = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setCookie(String str) {
        xx = str;
    }

    public static void ao(String str) {
        xB = str;
    }

    public static void setUserAgent(String str) {
        xy = str;
    }

    public static void setUid(String str) {
        xz = str;
    }

    public static void setKeepAlive(boolean z) {
        xA = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.xC = new e();
        a(this.xC, z);
        this.xC.fJ().setUrl(str);
        this.xD = new c(this.xC);
        this.xD.d(i, i3, i4);
        return this.xC.fK();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.xC = new e();
        a(this.xC, z);
        this.xC.fJ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.xC.fJ().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.xC.fJ().o(next.getName(), next.getValue());
            }
        }
        this.xD = new c(this.xC);
        this.xD.f(i, i2, -1);
        return this.xC.fK();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.xC = new e();
        a(this.xC, z);
        this.xC.fJ().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.xC.fJ().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.xC.fJ().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.xC.fJ().d(entry.getKey(), entry.getValue());
            }
        }
        this.xD = new c(this.xC);
        this.xD.f(i, i2, -1);
        return this.xC.fK();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.xC = new e();
        b(this.xC);
        this.xC.fJ().setUrl(str);
        this.xD = new c(this.xC);
        return this.xD.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.xD != null) {
            this.xD.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.xD != null) {
            return this.xD.fC();
        }
        return false;
    }

    public void fD() {
        if (this.xD != null) {
            this.xD.fD();
        }
    }

    public e fR() {
        return this.xC;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(xx)) {
                eVar.fJ().o("Cookie", xx);
            } else {
                eVar.fJ().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(xz)) {
                eVar.fJ().o("client_user_token", xz);
            }
            if (!TextUtils.isEmpty(xy)) {
                eVar.fJ().o("User-Agent", xy);
            }
            if (z) {
                eVar.fJ().o("Accept-Encoding", "gzip");
            } else {
                eVar.fJ().o("Accept-Encoding", "");
            }
            if (xA) {
                eVar.fJ().o("Connection", "Keep-Alive");
            } else {
                eVar.fJ().o("Connection", IntentConfig.CLOSE);
            }
            eVar.fJ().o("client_logid", String.valueOf(this.xE));
            if (!TextUtils.isEmpty(xB)) {
                eVar.fJ().o("cuid", xB);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
