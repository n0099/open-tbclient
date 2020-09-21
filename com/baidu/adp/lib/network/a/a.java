package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidubce.http.Headers;
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
    private static String Mn;
    private static String Mo;
    private static boolean Mp;
    private static String Mq;
    private static String Mr;
    private static String Ms;
    private static String Mt;
    private static String sUid;
    private e Mu;
    private c Mv;
    private long Mw;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Mw = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bP(String str) {
        Mn = str;
    }

    public static void setCuid(String str) {
        Mq = str;
    }

    public static void bQ(String str) {
        Mr = str;
    }

    public static void bR(String str) {
        Ms = str;
    }

    public static void bS(String str) {
        Mt = str;
    }

    public static void setUserAgent(String str) {
        Mo = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        Mp = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Mu = new e();
        a(this.Mu, z);
        this.Mu.mw().setUrl(str);
        this.Mv = new c(this.Mu);
        this.Mv.d(i, i3, i4);
        return this.Mu.mx();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Mu = new e();
        a(this.Mu, z);
        this.Mu.mw().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Mu.mw().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Mu.mw().u(next.getName(), next.getValue());
            }
        }
        this.Mv = new c(this.Mu);
        this.Mv.f(i, i2, -1);
        return this.Mu.mx();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Mu = new e();
        a(this.Mu, z);
        this.Mu.mw().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Mu.mw().u(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Mu.mw().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Mu.mw().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.Mv = new c(this.Mu);
        this.Mv.f(i, i2, -1);
        return this.Mu.mx();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.Mu = new e();
        b(this.Mu);
        this.Mu.mw().setUrl(str);
        this.Mu.mw().ak(z4);
        this.Mv = new c(this.Mu);
        return this.Mv.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Mv != null) {
            this.Mv.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Mv != null) {
            return this.Mv.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.Mv != null) {
            this.Mv.setCancel();
        }
    }

    public c mP() {
        return this.Mv;
    }

    public e mQ() {
        return this.Mu;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Mn)) {
                eVar.mw().u(SM.COOKIE, Mn);
            } else {
                eVar.mw().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.mw().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Mo)) {
                eVar.mw().u("User-Agent", Mo);
            }
            if (z) {
                eVar.mw().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.mw().u(Headers.ACCEPT_ENCODING, "");
            }
            if (Mp) {
                eVar.mw().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.mw().u(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.mw().u("client_logid", String.valueOf(this.Mw));
            if (!TextUtils.isEmpty(Mq)) {
                eVar.mw().u("cuid", Mq);
            }
            if (!TextUtils.isEmpty(Mr)) {
                eVar.mw().u("cuid_galaxy2", Mr);
            }
            if (!TextUtils.isEmpty(Ms)) {
                eVar.mw().u("c3_aid", Ms);
            }
            if (!TextUtils.isEmpty(Mt)) {
                eVar.mw().u("cuid_gid", Mt);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
