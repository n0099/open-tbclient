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
    private static String Mc;
    private static String Md;
    private static boolean Me;
    private static String Mf;
    private static String Mg;
    private static String Mh;
    private static String Mi;
    private static String sUid;
    private e Mj;
    private c Mk;
    private long Ml;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ml = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bN(String str) {
        Mc = str;
    }

    public static void setCuid(String str) {
        Mf = str;
    }

    public static void bO(String str) {
        Mg = str;
    }

    public static void bP(String str) {
        Mh = str;
    }

    public static void bQ(String str) {
        Mi = str;
    }

    public static void setUserAgent(String str) {
        Md = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        Me = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Mj = new e();
        a(this.Mj, z);
        this.Mj.ms().setUrl(str);
        this.Mk = new c(this.Mj);
        this.Mk.d(i, i3, i4);
        return this.Mj.mt();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Mj = new e();
        a(this.Mj, z);
        this.Mj.ms().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Mj.ms().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Mj.ms().u(next.getName(), next.getValue());
            }
        }
        this.Mk = new c(this.Mj);
        this.Mk.f(i, i2, -1);
        return this.Mj.mt();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Mj = new e();
        a(this.Mj, z);
        this.Mj.ms().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Mj.ms().u(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Mj.ms().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Mj.ms().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.Mk = new c(this.Mj);
        this.Mk.f(i, i2, -1);
        return this.Mj.mt();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.Mj = new e();
        b(this.Mj);
        this.Mj.ms().setUrl(str);
        this.Mj.ms().al(z4);
        this.Mk = new c(this.Mj);
        return this.Mk.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Mk != null) {
            this.Mk.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Mk != null) {
            return this.Mk.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.Mk != null) {
            this.Mk.setCancel();
        }
    }

    public c mK() {
        return this.Mk;
    }

    public e mL() {
        return this.Mj;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Mc)) {
                eVar.ms().u(SM.COOKIE, Mc);
            } else {
                eVar.ms().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.ms().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Md)) {
                eVar.ms().u("User-Agent", Md);
            }
            if (z) {
                eVar.ms().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.ms().u(Headers.ACCEPT_ENCODING, "");
            }
            if (Me) {
                eVar.ms().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.ms().u(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.ms().u("client_logid", String.valueOf(this.Ml));
            if (!TextUtils.isEmpty(Mf)) {
                eVar.ms().u("cuid", Mf);
            }
            if (!TextUtils.isEmpty(Mg)) {
                eVar.ms().u("cuid_galaxy2", Mg);
            }
            if (!TextUtils.isEmpty(Mh)) {
                eVar.ms().u("c3_aid", Mh);
            }
            if (!TextUtils.isEmpty(Mi)) {
                eVar.ms().u("cuid_gid", Mi);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
