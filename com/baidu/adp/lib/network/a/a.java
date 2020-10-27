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
    private static String MF;
    private static String MG;
    private static boolean MH;
    private static String MI;
    private static String MJ;
    private static String MK;
    private static String MN;
    private static String sUid;
    private e MO;
    private c MP;
    private long MQ;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.MQ = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bP(String str) {
        MF = str;
    }

    public static void setCuid(String str) {
        MI = str;
    }

    public static void bQ(String str) {
        MJ = str;
    }

    public static void bR(String str) {
        MK = str;
    }

    public static void bS(String str) {
        MN = str;
    }

    public static void setUserAgent(String str) {
        MG = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        MH = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.MO = new e();
        a(this.MO, z);
        this.MO.mx().setUrl(str);
        this.MP = new c(this.MO);
        this.MP.d(i, i3, i4);
        return this.MO.my();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.MO = new e();
        a(this.MO, z);
        this.MO.mx().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.MO.mx().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.MO.mx().u(next.getName(), next.getValue());
            }
        }
        this.MP = new c(this.MO);
        this.MP.f(i, i2, -1);
        return this.MO.my();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.MO = new e();
        a(this.MO, z);
        this.MO.mx().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.MO.mx().u(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.MO.mx().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.MO.mx().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.MP = new c(this.MO);
        this.MP.f(i, i2, -1);
        return this.MO.my();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.MO = new e();
        b(this.MO);
        this.MO.mx().setUrl(str);
        this.MO.mx().ak(z4);
        this.MP = new c(this.MO);
        return this.MP.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.MP != null) {
            this.MP.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.MP != null) {
            return this.MP.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.MP != null) {
            this.MP.setCancel();
        }
    }

    public c mQ() {
        return this.MP;
    }

    public e mR() {
        return this.MO;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(MF)) {
                eVar.mx().u(SM.COOKIE, MF);
            } else {
                eVar.mx().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.mx().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MG)) {
                eVar.mx().u("User-Agent", MG);
            }
            if (z) {
                eVar.mx().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.mx().u(Headers.ACCEPT_ENCODING, "");
            }
            if (MH) {
                eVar.mx().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.mx().u(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.mx().u("client_logid", String.valueOf(this.MQ));
            if (!TextUtils.isEmpty(MI)) {
                eVar.mx().u("cuid", MI);
            }
            if (!TextUtils.isEmpty(MJ)) {
                eVar.mx().u("cuid_galaxy2", MJ);
            }
            if (!TextUtils.isEmpty(MK)) {
                eVar.mx().u("c3_aid", MK);
            }
            if (!TextUtils.isEmpty(MN)) {
                eVar.mx().u("cuid_gid", MN);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
