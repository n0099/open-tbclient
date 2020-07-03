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
    private static String LA;
    private static String LB;
    private static String Lv;
    private static String Lw;
    private static boolean Lx;
    private static String Ly;
    private static String Lz;
    private static String sUid;
    private e LC;
    private c LD;
    private long LG;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.LG = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bK(String str) {
        Lv = str;
    }

    public static void setCuid(String str) {
        Ly = str;
    }

    public static void bL(String str) {
        Lz = str;
    }

    public static void bM(String str) {
        LA = str;
    }

    public static void bN(String str) {
        LB = str;
    }

    public static void setUserAgent(String str) {
        Lw = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        Lx = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.LC = new e();
        a(this.LC, z);
        this.LC.kT().setUrl(str);
        this.LD = new c(this.LC);
        this.LD.d(i, i3, i4);
        return this.LC.kU();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.LC = new e();
        a(this.LC, z);
        this.LC.kT().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.LC.kT().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.LC.kT().s(next.getName(), next.getValue());
            }
        }
        this.LD = new c(this.LC);
        this.LD.f(i, i2, -1);
        return this.LC.kU();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.LC = new e();
        a(this.LC, z);
        this.LC.kT().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.LC.kT().s(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.LC.kT().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.LC.kT().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.LD = new c(this.LC);
        this.LD.f(i, i2, -1);
        return this.LC.kU();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.LC = new e();
        b(this.LC);
        this.LC.kT().setUrl(str);
        this.LC.kT().ak(z4);
        this.LD = new c(this.LC);
        return this.LD.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.LD != null) {
            this.LD.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.LD != null) {
            return this.LD.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.LD != null) {
            this.LD.setCancel();
        }
    }

    public c ll() {
        return this.LD;
    }

    public e lm() {
        return this.LC;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Lv)) {
                eVar.kT().s(SM.COOKIE, Lv);
            } else {
                eVar.kT().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.kT().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Lw)) {
                eVar.kT().s("User-Agent", Lw);
            }
            if (z) {
                eVar.kT().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.kT().s(Headers.ACCEPT_ENCODING, "");
            }
            if (Lx) {
                eVar.kT().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.kT().s(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.kT().s("client_logid", String.valueOf(this.LG));
            if (!TextUtils.isEmpty(Ly)) {
                eVar.kT().s("cuid", Ly);
            }
            if (!TextUtils.isEmpty(Lz)) {
                eVar.kT().s("cuid_galaxy2", Lz);
            }
            if (!TextUtils.isEmpty(LA)) {
                eVar.kT().s("c3_aid", LA);
            }
            if (!TextUtils.isEmpty(LB)) {
                eVar.kT().s("cuid_gid", LB);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
