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
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    private static String ajH;
    private static String ajI;
    private static String ajJ;
    private static boolean ajK;
    private static String ajL;
    private e ajM;
    private c ajN;
    private long ajO;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.ajO = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aq(String str) {
        ajH = str;
    }

    public static void ar(String str) {
        ajL = str;
    }

    public static void setUserAgent(String str) {
        ajI = str;
    }

    public static void setUid(String str) {
        ajJ = str;
    }

    public static void setKeepAlive(boolean z) {
        ajK = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajM = new e();
        a(this.ajM, z);
        this.ajM.nb().setUrl(str);
        this.ajN = new c(this.ajM);
        this.ajN.m(i, i3, i4);
        return this.ajM.nc();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajM = new e();
        a(this.ajM, z);
        this.ajM.nb().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ajM.nb().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ajM.nb().o(next.getName(), next.getValue());
            }
        }
        this.ajN = new c(this.ajM);
        this.ajN.o(i, i2, -1);
        return this.ajM.nc();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajM = new e();
        a(this.ajM, z);
        this.ajM.nb().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ajM.nb().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.ajM.nb().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.ajM.nb().d(entry.getKey(), entry.getValue());
            }
        }
        this.ajN = new c(this.ajM);
        this.ajN.o(i, i2, -1);
        return this.ajM.nc();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.ajM = new e();
        b(this.ajM);
        this.ajM.nb().setUrl(str);
        this.ajN = new c(this.ajM);
        return this.ajN.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.ajN != null) {
            this.ajN.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ajN != null) {
            return this.ajN.mU();
        }
        return false;
    }

    public void mV() {
        if (this.ajN != null) {
            this.ajN.mV();
        }
    }

    public e nj() {
        return this.ajM;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(ajH)) {
                eVar.nb().o(SM.COOKIE, ajH);
            } else {
                eVar.nb().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ajJ)) {
                eVar.nb().o("client_user_token", ajJ);
            }
            if (!TextUtils.isEmpty(ajI)) {
                eVar.nb().o(HTTP.USER_AGENT, ajI);
            }
            if (z) {
                eVar.nb().o("Accept-Encoding", "gzip");
            } else {
                eVar.nb().o("Accept-Encoding", "");
            }
            if (ajK) {
                eVar.nb().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.nb().o(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            eVar.nb().o("client_logid", String.valueOf(this.ajO));
            if (!TextUtils.isEmpty(ajL)) {
                eVar.nb().o("cuid", ajL);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
