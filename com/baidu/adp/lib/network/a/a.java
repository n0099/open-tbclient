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
    private static String Lu;
    private static String Lv;
    private static boolean Lw;
    private static String Lx;
    private static String Ly;
    private static String Lz;
    private static String sUid;
    private e LB;
    private c LC;
    private long LD;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.LD = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bI(String str) {
        Lu = str;
    }

    public static void setCuid(String str) {
        Lx = str;
    }

    public static void bJ(String str) {
        Ly = str;
    }

    public static void bK(String str) {
        Lz = str;
    }

    public static void bL(String str) {
        LA = str;
    }

    public static void setUserAgent(String str) {
        Lv = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        Lw = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.LB = new e();
        a(this.LB, z);
        this.LB.kT().setUrl(str);
        this.LC = new c(this.LB);
        this.LC.d(i, i3, i4);
        return this.LB.kU();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.LB = new e();
        a(this.LB, z);
        this.LB.kT().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.LB.kT().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.LB.kT().s(next.getName(), next.getValue());
            }
        }
        this.LC = new c(this.LB);
        this.LC.f(i, i2, -1);
        return this.LB.kU();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.LB = new e();
        a(this.LB, z);
        this.LB.kT().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.LB.kT().s(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.LB.kT().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.LB.kT().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.LC = new c(this.LB);
        this.LC.f(i, i2, -1);
        return this.LB.kU();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.LB = new e();
        b(this.LB);
        this.LB.kT().setUrl(str);
        this.LB.kT().ak(z4);
        this.LC = new c(this.LB);
        return this.LC.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.LC != null) {
            this.LC.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.LC != null) {
            return this.LC.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.LC != null) {
            this.LC.setCancel();
        }
    }

    public c ll() {
        return this.LC;
    }

    public e lm() {
        return this.LB;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Lu)) {
                eVar.kT().s(SM.COOKIE, Lu);
            } else {
                eVar.kT().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.kT().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Lv)) {
                eVar.kT().s("User-Agent", Lv);
            }
            if (z) {
                eVar.kT().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.kT().s(Headers.ACCEPT_ENCODING, "");
            }
            if (Lw) {
                eVar.kT().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.kT().s(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.kT().s("client_logid", String.valueOf(this.LD));
            if (!TextUtils.isEmpty(Lx)) {
                eVar.kT().s("cuid", Lx);
            }
            if (!TextUtils.isEmpty(Ly)) {
                eVar.kT().s("cuid_galaxy2", Ly);
            }
            if (!TextUtils.isEmpty(Lz)) {
                eVar.kT().s("c3_aid", Lz);
            }
            if (!TextUtils.isEmpty(LA)) {
                eVar.kT().s("cuid_gid", LA);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
