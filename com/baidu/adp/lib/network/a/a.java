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
    private static String MZ;
    private static String Na;
    private static boolean Nb;
    private static String Nc;
    private static String Nd;
    private static String Ne;
    private static String Nf;
    private static String sUid;
    private e Ng;
    private c Nh;
    private long Ni;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ni = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bM(String str) {
        MZ = str;
    }

    public static void setCuid(String str) {
        Nc = str;
    }

    public static void bN(String str) {
        Nd = str;
    }

    public static void bO(String str) {
        Ne = str;
    }

    public static void bP(String str) {
        Nf = str;
    }

    public static void setUserAgent(String str) {
        Na = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void al(boolean z) {
        Nb = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ng = new e();
        a(this.Ng, z);
        this.Ng.lV().setUrl(str);
        this.Nh = new c(this.Ng);
        this.Nh.d(i, i3, i4);
        return this.Ng.lW();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ng = new e();
        a(this.Ng, z);
        this.Ng.lV().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Ng.lV().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Ng.lV().u(next.getName(), next.getValue());
            }
        }
        this.Nh = new c(this.Ng);
        this.Nh.f(i, i2, -1);
        return this.Ng.lW();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ng = new e();
        a(this.Ng, z);
        this.Ng.lV().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Ng.lV().u(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Ng.lV().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Ng.lV().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.Nh = new c(this.Ng);
        this.Nh.f(i, i2, -1);
        return this.Ng.lW();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.Ng = new e();
        b(this.Ng);
        this.Ng.lV().setUrl(str);
        this.Ng.lV().ah(z4);
        this.Nh = new c(this.Ng);
        return this.Nh.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Nh != null) {
            this.Nh.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Nh != null) {
            return this.Nh.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.Nh != null) {
            this.Nh.setCancel();
        }
    }

    public c mo() {
        return this.Nh;
    }

    public e mp() {
        return this.Ng;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(MZ)) {
                eVar.lV().u(SM.COOKIE, MZ);
            } else {
                eVar.lV().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.lV().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Na)) {
                eVar.lV().u("User-Agent", Na);
            }
            if (z) {
                eVar.lV().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.lV().u(Headers.ACCEPT_ENCODING, "");
            }
            if (Nb) {
                eVar.lV().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.lV().u(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.lV().u("client_logid", String.valueOf(this.Ni));
            if (!TextUtils.isEmpty(Nc)) {
                eVar.lV().u("cuid", Nc);
            }
            if (!TextUtils.isEmpty(Nd)) {
                eVar.lV().u("cuid_galaxy2", Nd);
            }
            if (!TextUtils.isEmpty(Ne)) {
                eVar.lV().u("c3_aid", Ne);
            }
            if (!TextUtils.isEmpty(Nf)) {
                eVar.lV().u("cuid_gid", Nf);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
