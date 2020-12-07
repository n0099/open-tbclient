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
    private static String NA;
    private static boolean NC;
    private static String ND;
    private static String NF;
    private static String NG;
    private static String NH;
    private static String Nz;
    private static String sUid;
    private e NI;
    private c NJ;
    private long NK;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.NK = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bS(String str) {
        Nz = str;
    }

    public static void setCuid(String str) {
        ND = str;
    }

    public static void bT(String str) {
        NF = str;
    }

    public static void bU(String str) {
        NG = str;
    }

    public static void bV(String str) {
        NH = str;
    }

    public static void setUserAgent(String str) {
        NA = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void am(boolean z) {
        NC = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.NI = new e();
        a(this.NI, z);
        this.NI.mx().setUrl(str);
        this.NJ = new c(this.NI);
        this.NJ.d(i, i3, i4);
        return this.NI.my();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.NI = new e();
        a(this.NI, z);
        this.NI.mx().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.NI.mx().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.NI.mx().u(next.getName(), next.getValue());
            }
        }
        this.NJ = new c(this.NI);
        this.NJ.f(i, i2, -1);
        return this.NI.my();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.NI = new e();
        a(this.NI, z);
        this.NI.mx().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.NI.mx().u(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.NI.mx().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.NI.mx().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.NJ = new c(this.NI);
        this.NJ.f(i, i2, -1);
        return this.NI.my();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.NI = new e();
        b(this.NI);
        this.NI.mx().setUrl(str);
        this.NI.mx().ai(z4);
        this.NJ = new c(this.NI);
        return this.NJ.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.NJ != null) {
            this.NJ.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.NJ != null) {
            return this.NJ.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.NJ != null) {
            this.NJ.setCancel();
        }
    }

    public c mQ() {
        return this.NJ;
    }

    public e mR() {
        return this.NI;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Nz)) {
                eVar.mx().u(SM.COOKIE, Nz);
            } else {
                eVar.mx().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.mx().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(NA)) {
                eVar.mx().u("User-Agent", NA);
            }
            if (z) {
                eVar.mx().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.mx().u(Headers.ACCEPT_ENCODING, "");
            }
            if (NC) {
                eVar.mx().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.mx().u(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.mx().u("client_logid", String.valueOf(this.NK));
            if (!TextUtils.isEmpty(ND)) {
                eVar.mx().u("cuid", ND);
            }
            if (!TextUtils.isEmpty(NF)) {
                eVar.mx().u("cuid_galaxy2", NF);
            }
            if (!TextUtils.isEmpty(NG)) {
                eVar.mx().u("c3_aid", NG);
            }
            if (!TextUtils.isEmpty(NH)) {
                eVar.mx().u("cuid_gid", NH);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
