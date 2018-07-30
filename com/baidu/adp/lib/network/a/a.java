package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    private static String Aa;
    private static boolean Ab;
    private static String Ac;
    private static String Ae;
    private static String Af;
    private static String zY;
    private static String zZ;
    private e Ag;
    private c Ah;
    private long Ai;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ai = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aA(String str) {
        zY = str;
    }

    public static void aB(String str) {
        Ac = str;
    }

    public static void aC(String str) {
        Ae = str;
    }

    public static void aD(String str) {
        Af = str;
    }

    public static void setUserAgent(String str) {
        zZ = str;
    }

    public static void setUid(String str) {
        Aa = str;
    }

    public static void setKeepAlive(boolean z) {
        Ab = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ag = new e();
        a(this.Ag, z);
        this.Ag.hW().setUrl(str);
        this.Ah = new c(this.Ag);
        this.Ah.d(i, i3, i4);
        return this.Ag.hX();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ag = new e();
        a(this.Ag, z);
        this.Ag.hW().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Ag.hW().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Ag.hW().p(next.getName(), next.getValue());
            }
        }
        this.Ah = new c(this.Ag);
        this.Ah.f(i, i2, -1);
        return this.Ag.hX();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ag = new e();
        a(this.Ag, z);
        this.Ag.hW().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Ag.hW().p(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Ag.hW().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Ag.hW().d(entry.getKey(), entry.getValue());
            }
        }
        this.Ah = new c(this.Ag);
        this.Ah.f(i, i2, -1);
        return this.Ag.hX();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.Ag = new e();
        b(this.Ag);
        this.Ag.hW().setUrl(str);
        this.Ah = new c(this.Ag);
        return this.Ah.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Ah != null) {
            this.Ah.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Ah != null) {
            return this.Ah.hP();
        }
        return false;
    }

    public void hQ() {
        if (this.Ah != null) {
            this.Ah.hQ();
        }
    }

    public e ie() {
        return this.Ag;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(zY)) {
                eVar.hW().p(SM.COOKIE, zY);
            } else {
                eVar.hW().p(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Aa)) {
                eVar.hW().p("client_user_token", Aa);
            }
            if (!TextUtils.isEmpty(zZ)) {
                eVar.hW().p(HTTP.USER_AGENT, zZ);
            }
            if (z) {
                eVar.hW().p("Accept-Encoding", "gzip");
            } else {
                eVar.hW().p("Accept-Encoding", "");
            }
            if (Ab) {
                eVar.hW().p(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.hW().p(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            eVar.hW().p("client_logid", String.valueOf(this.Ai));
            if (!TextUtils.isEmpty(Ac)) {
                eVar.hW().p("cuid", Ac);
            }
            if (!TextUtils.isEmpty(Ae)) {
                eVar.hW().p("cuid_galaxy2", Ae);
            }
            if (!TextUtils.isEmpty(Af)) {
                eVar.hW().p("cuid_gid", Af);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
