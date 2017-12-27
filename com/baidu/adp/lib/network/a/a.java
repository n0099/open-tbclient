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
    private static String ajE;
    private static String ajF;
    private static String ajG;
    private static boolean ajH;
    private static String ajI;
    private e ajJ;
    private c ajK;
    private long ajL;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.ajL = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aq(String str) {
        ajE = str;
    }

    public static void ar(String str) {
        ajI = str;
    }

    public static void setUserAgent(String str) {
        ajF = str;
    }

    public static void setUid(String str) {
        ajG = str;
    }

    public static void setKeepAlive(boolean z) {
        ajH = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajJ = new e();
        a(this.ajJ, z);
        this.ajJ.na().setUrl(str);
        this.ajK = new c(this.ajJ);
        this.ajK.m(i, i3, i4);
        return this.ajJ.nb();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajJ = new e();
        a(this.ajJ, z);
        this.ajJ.na().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ajJ.na().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ajJ.na().o(next.getName(), next.getValue());
            }
        }
        this.ajK = new c(this.ajJ);
        this.ajK.o(i, i2, -1);
        return this.ajJ.nb();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ajJ = new e();
        a(this.ajJ, z);
        this.ajJ.na().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ajJ.na().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.ajJ.na().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.ajJ.na().d(entry.getKey(), entry.getValue());
            }
        }
        this.ajK = new c(this.ajJ);
        this.ajK.o(i, i2, -1);
        return this.ajJ.nb();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.ajJ = new e();
        b(this.ajJ);
        this.ajJ.na().setUrl(str);
        this.ajK = new c(this.ajJ);
        return this.ajK.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.ajK != null) {
            this.ajK.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ajK != null) {
            return this.ajK.mT();
        }
        return false;
    }

    public void mU() {
        if (this.ajK != null) {
            this.ajK.mU();
        }
    }

    public e ni() {
        return this.ajJ;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(ajE)) {
                eVar.na().o(SM.COOKIE, ajE);
            } else {
                eVar.na().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ajG)) {
                eVar.na().o("client_user_token", ajG);
            }
            if (!TextUtils.isEmpty(ajF)) {
                eVar.na().o(HTTP.USER_AGENT, ajF);
            }
            if (z) {
                eVar.na().o("Accept-Encoding", "gzip");
            } else {
                eVar.na().o("Accept-Encoding", "");
            }
            if (ajH) {
                eVar.na().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.na().o(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            eVar.na().o("client_logid", String.valueOf(this.ajL));
            if (!TextUtils.isEmpty(ajI)) {
                eVar.na().o("cuid", ajI);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
