package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.webkit.internal.ABTestConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    private static String De;
    private static String Df;
    private static String Dg;
    private static boolean Dh;
    private static String Di;
    private static String Dj;
    private static String Dk;
    private e Dl;
    private c Dm;
    private long Dn;

    public void init() {
        System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        this.Dn = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aR(String str) {
        De = str;
    }

    public static void setCuid(String str) {
        Di = str;
    }

    public static void aS(String str) {
        Dj = str;
    }

    public static void aT(String str) {
        Dk = str;
    }

    public static void setUserAgent(String str) {
        Df = str;
    }

    public static void setUid(String str) {
        Dg = str;
    }

    public static void setKeepAlive(boolean z) {
        Dh = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Dl = new e();
        a(this.Dl, z);
        this.Dl.jr().setUrl(str);
        this.Dm = new c(this.Dl);
        this.Dm.e(i, i3, i4);
        return this.Dl.js();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Dl = new e();
        a(this.Dl, z);
        this.Dl.jr().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Dl.jr().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Dl.jr().y(next.getName(), next.getValue());
            }
        }
        this.Dm = new c(this.Dl);
        this.Dm.g(i, i2, -1);
        return this.Dl.js();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Dl = new e();
        a(this.Dl, z);
        this.Dl.jr().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Dl.jr().y(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Dl.jr().x(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Dl.jr().d(entry.getKey(), entry.getValue());
            }
        }
        this.Dm = new c(this.Dl);
        this.Dm.g(i, i2, -1);
        return this.Dl.js();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.Dl = new e();
        b(this.Dl);
        this.Dl.jr().setUrl(str);
        this.Dm = new c(this.Dl);
        return this.Dm.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Dm != null) {
            this.Dm.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Dm != null) {
            return this.Dm.jk();
        }
        return false;
    }

    public void jl() {
        if (this.Dm != null) {
            this.Dm.jl();
        }
    }

    public e jz() {
        return this.Dl;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(De)) {
                eVar.jr().y(SM.COOKIE, De);
            } else {
                eVar.jr().y(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Dg)) {
                eVar.jr().y("client_user_token", Dg);
            }
            if (!TextUtils.isEmpty(Df)) {
                eVar.jr().y(HTTP.USER_AGENT, Df);
            }
            if (z) {
                eVar.jr().y("Accept-Encoding", "gzip");
            } else {
                eVar.jr().y("Accept-Encoding", "");
            }
            if (Dh) {
                eVar.jr().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.jr().y(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.jr().y("client_logid", String.valueOf(this.Dn));
            if (!TextUtils.isEmpty(Di)) {
                eVar.jr().y("cuid", Di);
            }
            if (!TextUtils.isEmpty(Dj)) {
                eVar.jr().y("cuid_galaxy2", Dj);
            }
            if (!TextUtils.isEmpty(Dk)) {
                eVar.jr().y("cuid_gid", Dk);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
