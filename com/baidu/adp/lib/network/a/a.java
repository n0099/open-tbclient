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
    private static String MV;
    private static String MW;
    private static boolean MX;
    private static String MY;
    private static String MZ;
    private static String Na;
    private static String Nb;
    private static String sUid;
    private e Nc;
    private c Nd;
    private long Ne;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ne = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bM(String str) {
        MV = str;
    }

    public static void setCuid(String str) {
        MY = str;
    }

    public static void bN(String str) {
        MZ = str;
    }

    public static void bO(String str) {
        Na = str;
    }

    public static void bP(String str) {
        Nb = str;
    }

    public static void setUserAgent(String str) {
        MW = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void al(boolean z) {
        MX = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Nc = new e();
        a(this.Nc, z);
        this.Nc.lU().setUrl(str);
        this.Nd = new c(this.Nc);
        this.Nd.d(i, i3, i4);
        return this.Nc.lV();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Nc = new e();
        a(this.Nc, z);
        this.Nc.lU().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Nc.lU().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Nc.lU().s(next.getName(), next.getValue());
            }
        }
        this.Nd = new c(this.Nc);
        this.Nd.f(i, i2, -1);
        return this.Nc.lV();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Nc = new e();
        a(this.Nc, z);
        this.Nc.lU().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Nc.lU().s(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Nc.lU().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Nc.lU().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.Nd = new c(this.Nc);
        this.Nd.f(i, i2, -1);
        return this.Nc.lV();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.Nc = new e();
        b(this.Nc);
        this.Nc.lU().setUrl(str);
        this.Nc.lU().ah(z4);
        this.Nd = new c(this.Nc);
        return this.Nd.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Nd != null) {
            this.Nd.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Nd != null) {
            return this.Nd.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.Nd != null) {
            this.Nd.setCancel();
        }
    }

    public c mn() {
        return this.Nd;
    }

    public e mo() {
        return this.Nc;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(MV)) {
                eVar.lU().s(SM.COOKIE, MV);
            } else {
                eVar.lU().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.lU().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MW)) {
                eVar.lU().s("User-Agent", MW);
            }
            if (z) {
                eVar.lU().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.lU().s(Headers.ACCEPT_ENCODING, "");
            }
            if (MX) {
                eVar.lU().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.lU().s(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.lU().s("client_logid", String.valueOf(this.Ne));
            if (!TextUtils.isEmpty(MY)) {
                eVar.lU().s("cuid", MY);
            }
            if (!TextUtils.isEmpty(MZ)) {
                eVar.lU().s("cuid_galaxy2", MZ);
            }
            if (!TextUtils.isEmpty(Na)) {
                eVar.lU().s("c3_aid", Na);
            }
            if (!TextUtils.isEmpty(Nb)) {
                eVar.lU().s("cuid_gid", Nb);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
