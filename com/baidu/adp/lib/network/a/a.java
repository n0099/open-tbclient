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
    private static String MX;
    private static String MY;
    private static boolean MZ;
    private static String Na;
    private static String Nb;
    private static String Nc;
    private static String Nd;
    private static String sUid;
    private e Ne;
    private c Nf;
    private long Ng;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ng = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bM(String str) {
        MX = str;
    }

    public static void setCuid(String str) {
        Na = str;
    }

    public static void bN(String str) {
        Nb = str;
    }

    public static void bO(String str) {
        Nc = str;
    }

    public static void bP(String str) {
        Nd = str;
    }

    public static void setUserAgent(String str) {
        MY = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void al(boolean z) {
        MZ = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ne = new e();
        a(this.Ne, z);
        this.Ne.lV().setUrl(str);
        this.Nf = new c(this.Ne);
        this.Nf.d(i, i3, i4);
        return this.Ne.lW();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ne = new e();
        a(this.Ne, z);
        this.Ne.lV().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Ne.lV().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Ne.lV().u(next.getName(), next.getValue());
            }
        }
        this.Nf = new c(this.Ne);
        this.Nf.f(i, i2, -1);
        return this.Ne.lW();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ne = new e();
        a(this.Ne, z);
        this.Ne.lV().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Ne.lV().u(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Ne.lV().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Ne.lV().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.Nf = new c(this.Ne);
        this.Nf.f(i, i2, -1);
        return this.Ne.lW();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.Ne = new e();
        b(this.Ne);
        this.Ne.lV().setUrl(str);
        this.Ne.lV().ah(z4);
        this.Nf = new c(this.Ne);
        return this.Nf.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Nf != null) {
            this.Nf.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Nf != null) {
            return this.Nf.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.Nf != null) {
            this.Nf.setCancel();
        }
    }

    public c mo() {
        return this.Nf;
    }

    public e mp() {
        return this.Ne;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(MX)) {
                eVar.lV().u(SM.COOKIE, MX);
            } else {
                eVar.lV().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.lV().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MY)) {
                eVar.lV().u("User-Agent", MY);
            }
            if (z) {
                eVar.lV().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.lV().u(Headers.ACCEPT_ENCODING, "");
            }
            if (MZ) {
                eVar.lV().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.lV().u(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.lV().u("client_logid", String.valueOf(this.Ng));
            if (!TextUtils.isEmpty(Na)) {
                eVar.lV().u("cuid", Na);
            }
            if (!TextUtils.isEmpty(Nb)) {
                eVar.lV().u("cuid_galaxy2", Nb);
            }
            if (!TextUtils.isEmpty(Nc)) {
                eVar.lV().u("c3_aid", Nc);
            }
            if (!TextUtils.isEmpty(Nd)) {
                eVar.lV().u("cuid_gid", Nd);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
