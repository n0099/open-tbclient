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
    private static String ajG;
    private static String ajH;
    private static String ajI;
    private static boolean ajJ;
    private static String ajK;
    private e ajL;
    private c ajM;
    private long ajN;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.ajN = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aq(String str) {
        ajG = str;
    }

    public static void ar(String str) {
        ajK = str;
    }

    public static void setUserAgent(String str) {
        ajH = str;
    }

    public static void setUid(String str) {
        ajI = str;
    }

    public static void setKeepAlive(boolean z) {
        ajJ = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajL = new e();
        a(this.ajL, z);
        this.ajL.nb().setUrl(str);
        this.ajM = new c(this.ajL);
        this.ajM.m(i, i3, i4);
        return this.ajL.nc();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajL = new e();
        a(this.ajL, z);
        this.ajL.nb().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ajL.nb().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ajL.nb().o(next.getName(), next.getValue());
            }
        }
        this.ajM = new c(this.ajL);
        this.ajM.o(i, i2, -1);
        return this.ajL.nc();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajL = new e();
        a(this.ajL, z);
        this.ajL.nb().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ajL.nb().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.ajL.nb().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.ajL.nb().d(entry.getKey(), entry.getValue());
            }
        }
        this.ajM = new c(this.ajL);
        this.ajM.o(i, i2, -1);
        return this.ajL.nc();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.ajL = new e();
        b(this.ajL);
        this.ajL.nb().setUrl(str);
        this.ajM = new c(this.ajL);
        return this.ajM.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.ajM != null) {
            this.ajM.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ajM != null) {
            return this.ajM.mU();
        }
        return false;
    }

    public void mV() {
        if (this.ajM != null) {
            this.ajM.mV();
        }
    }

    public e nj() {
        return this.ajL;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(ajG)) {
                eVar.nb().o(SM.COOKIE, ajG);
            } else {
                eVar.nb().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ajI)) {
                eVar.nb().o("client_user_token", ajI);
            }
            if (!TextUtils.isEmpty(ajH)) {
                eVar.nb().o(HTTP.USER_AGENT, ajH);
            }
            if (z) {
                eVar.nb().o("Accept-Encoding", "gzip");
            } else {
                eVar.nb().o("Accept-Encoding", "");
            }
            if (ajJ) {
                eVar.nb().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.nb().o(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.nb().o("client_logid", String.valueOf(this.ajN));
            if (!TextUtils.isEmpty(ajK)) {
                eVar.nb().o("cuid", ajK);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
