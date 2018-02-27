package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
    private static String ajA;
    private static String ajB;
    private static String ajC;
    private static boolean ajD;
    private static String ajE;
    private e ajF;
    private c ajG;
    private long ajH;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.ajH = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aq(String str) {
        ajA = str;
    }

    public static void ar(String str) {
        ajE = str;
    }

    public static void setUserAgent(String str) {
        ajB = str;
    }

    public static void setUid(String str) {
        ajC = str;
    }

    public static void setKeepAlive(boolean z) {
        ajD = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajF = new e();
        a(this.ajF, z);
        this.ajF.nb().setUrl(str);
        this.ajG = new c(this.ajF);
        this.ajG.m(i, i3, i4);
        return this.ajF.nc();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajF = new e();
        a(this.ajF, z);
        this.ajF.nb().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ajF.nb().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ajF.nb().o(next.getName(), next.getValue());
            }
        }
        this.ajG = new c(this.ajF);
        this.ajG.o(i, i2, -1);
        return this.ajF.nc();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajF = new e();
        a(this.ajF, z);
        this.ajF.nb().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ajF.nb().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.ajF.nb().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.ajF.nb().d(entry.getKey(), entry.getValue());
            }
        }
        this.ajG = new c(this.ajF);
        this.ajG.o(i, i2, -1);
        return this.ajF.nc();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.ajF = new e();
        b(this.ajF);
        this.ajF.nb().setUrl(str);
        this.ajG = new c(this.ajF);
        return this.ajG.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.ajG != null) {
            this.ajG.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ajG != null) {
            return this.ajG.mU();
        }
        return false;
    }

    public void mV() {
        if (this.ajG != null) {
            this.ajG.mV();
        }
    }

    public e nj() {
        return this.ajF;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(ajA)) {
                eVar.nb().o(SM.COOKIE, ajA);
            } else {
                eVar.nb().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ajC)) {
                eVar.nb().o("client_user_token", ajC);
            }
            if (!TextUtils.isEmpty(ajB)) {
                eVar.nb().o(HTTP.USER_AGENT, ajB);
            }
            if (z) {
                eVar.nb().o("Accept-Encoding", "gzip");
            } else {
                eVar.nb().o("Accept-Encoding", "");
            }
            if (ajD) {
                eVar.nb().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.nb().o(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.nb().o("client_logid", String.valueOf(this.ajH));
            if (!TextUtils.isEmpty(ajE)) {
                eVar.nb().o("cuid", ajE);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
