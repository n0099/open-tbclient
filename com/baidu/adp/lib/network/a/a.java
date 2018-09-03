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
    private static String Ab;
    private static boolean Ac;
    private static String Ae;
    private static String Af;
    private static String Ag;
    private static String zZ;
    private e Ah;
    private c Ai;
    private long Aj;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Aj = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aA(String str) {
        zZ = str;
    }

    public static void aB(String str) {
        Ae = str;
    }

    public static void aC(String str) {
        Af = str;
    }

    public static void aD(String str) {
        Ag = str;
    }

    public static void setUserAgent(String str) {
        Aa = str;
    }

    public static void setUid(String str) {
        Ab = str;
    }

    public static void setKeepAlive(boolean z) {
        Ac = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ah = new e();
        a(this.Ah, z);
        this.Ah.hW().setUrl(str);
        this.Ai = new c(this.Ah);
        this.Ai.d(i, i3, i4);
        return this.Ah.hX();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ah = new e();
        a(this.Ah, z);
        this.Ah.hW().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Ah.hW().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Ah.hW().p(next.getName(), next.getValue());
            }
        }
        this.Ai = new c(this.Ah);
        this.Ai.f(i, i2, -1);
        return this.Ah.hX();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Ah = new e();
        a(this.Ah, z);
        this.Ah.hW().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Ah.hW().p(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Ah.hW().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Ah.hW().d(entry.getKey(), entry.getValue());
            }
        }
        this.Ai = new c(this.Ah);
        this.Ai.f(i, i2, -1);
        return this.Ah.hX();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.Ah = new e();
        b(this.Ah);
        this.Ah.hW().setUrl(str);
        this.Ai = new c(this.Ah);
        return this.Ai.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Ai != null) {
            this.Ai.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Ai != null) {
            return this.Ai.hP();
        }
        return false;
    }

    public void hQ() {
        if (this.Ai != null) {
            this.Ai.hQ();
        }
    }

    public e ie() {
        return this.Ah;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(zZ)) {
                eVar.hW().p(SM.COOKIE, zZ);
            } else {
                eVar.hW().p(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Ab)) {
                eVar.hW().p("client_user_token", Ab);
            }
            if (!TextUtils.isEmpty(Aa)) {
                eVar.hW().p(HTTP.USER_AGENT, Aa);
            }
            if (z) {
                eVar.hW().p("Accept-Encoding", "gzip");
            } else {
                eVar.hW().p("Accept-Encoding", "");
            }
            if (Ac) {
                eVar.hW().p(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.hW().p(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            eVar.hW().p("client_logid", String.valueOf(this.Aj));
            if (!TextUtils.isEmpty(Ae)) {
                eVar.hW().p("cuid", Ae);
            }
            if (!TextUtils.isEmpty(Af)) {
                eVar.hW().p("cuid_galaxy2", Af);
            }
            if (!TextUtils.isEmpty(Ag)) {
                eVar.hW().p("cuid_gid", Ag);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
