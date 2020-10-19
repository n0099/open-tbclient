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
    private static String ME;
    private static String MF;
    private static boolean MG;
    private static String MH;
    private static String MI;
    private static String MJ;
    private static String MK;
    private static String sUid;
    private e MN;
    private c MO;
    private long MP;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.MP = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bP(String str) {
        ME = str;
    }

    public static void setCuid(String str) {
        MH = str;
    }

    public static void bQ(String str) {
        MI = str;
    }

    public static void bR(String str) {
        MJ = str;
    }

    public static void bS(String str) {
        MK = str;
    }

    public static void setUserAgent(String str) {
        MF = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        MG = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.MN = new e();
        a(this.MN, z);
        this.MN.mx().setUrl(str);
        this.MO = new c(this.MN);
        this.MO.d(i, i3, i4);
        return this.MN.my();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.MN = new e();
        a(this.MN, z);
        this.MN.mx().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.MN.mx().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.MN.mx().u(next.getName(), next.getValue());
            }
        }
        this.MO = new c(this.MN);
        this.MO.f(i, i2, -1);
        return this.MN.my();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.MN = new e();
        a(this.MN, z);
        this.MN.mx().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.MN.mx().u(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.MN.mx().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.MN.mx().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.MO = new c(this.MN);
        this.MO.f(i, i2, -1);
        return this.MN.my();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.MN = new e();
        b(this.MN);
        this.MN.mx().setUrl(str);
        this.MN.mx().ak(z4);
        this.MO = new c(this.MN);
        return this.MO.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.MO != null) {
            this.MO.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.MO != null) {
            return this.MO.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.MO != null) {
            this.MO.setCancel();
        }
    }

    public c mQ() {
        return this.MO;
    }

    public e mR() {
        return this.MN;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(ME)) {
                eVar.mx().u(SM.COOKIE, ME);
            } else {
                eVar.mx().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.mx().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MF)) {
                eVar.mx().u("User-Agent", MF);
            }
            if (z) {
                eVar.mx().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.mx().u(Headers.ACCEPT_ENCODING, "");
            }
            if (MG) {
                eVar.mx().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.mx().u(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.mx().u("client_logid", String.valueOf(this.MP));
            if (!TextUtils.isEmpty(MH)) {
                eVar.mx().u("cuid", MH);
            }
            if (!TextUtils.isEmpty(MI)) {
                eVar.mx().u("cuid_galaxy2", MI);
            }
            if (!TextUtils.isEmpty(MJ)) {
                eVar.mx().u("c3_aid", MJ);
            }
            if (!TextUtils.isEmpty(MK)) {
                eVar.mx().u("cuid_gid", MK);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
