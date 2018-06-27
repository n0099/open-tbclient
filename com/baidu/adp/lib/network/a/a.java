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
    private static String Ae;
    private static String Af;
    private static String Ag;
    private static boolean Ah;
    private static String Ai;
    private static String Aj;
    private static String Ak;
    private e Al;
    private c Am;
    private long An;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.An = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void az(String str) {
        Ae = str;
    }

    public static void aA(String str) {
        Ai = str;
    }

    public static void aB(String str) {
        Aj = str;
    }

    public static void aC(String str) {
        Ak = str;
    }

    public static void setUserAgent(String str) {
        Af = str;
    }

    public static void setUid(String str) {
        Ag = str;
    }

    public static void setKeepAlive(boolean z) {
        Ah = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Al = new e();
        a(this.Al, z);
        this.Al.hV().setUrl(str);
        this.Am = new c(this.Al);
        this.Am.d(i, i3, i4);
        return this.Al.hW();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Al = new e();
        a(this.Al, z);
        this.Al.hV().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Al.hV().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Al.hV().q(next.getName(), next.getValue());
            }
        }
        this.Am = new c(this.Al);
        this.Am.f(i, i2, -1);
        return this.Al.hW();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Al = new e();
        a(this.Al, z);
        this.Al.hV().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Al.hV().q(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Al.hV().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Al.hV().d(entry.getKey(), entry.getValue());
            }
        }
        this.Am = new c(this.Al);
        this.Am.f(i, i2, -1);
        return this.Al.hW();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.Al = new e();
        b(this.Al);
        this.Al.hV().setUrl(str);
        this.Am = new c(this.Al);
        return this.Am.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Am != null) {
            this.Am.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Am != null) {
            return this.Am.isCancel();
        }
        return false;
    }

    public void hP() {
        if (this.Am != null) {
            this.Am.hP();
        }
    }

    public e id() {
        return this.Al;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Ae)) {
                eVar.hV().q(SM.COOKIE, Ae);
            } else {
                eVar.hV().q(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Ag)) {
                eVar.hV().q("client_user_token", Ag);
            }
            if (!TextUtils.isEmpty(Af)) {
                eVar.hV().q(HTTP.USER_AGENT, Af);
            }
            if (z) {
                eVar.hV().q("Accept-Encoding", "gzip");
            } else {
                eVar.hV().q("Accept-Encoding", "");
            }
            if (Ah) {
                eVar.hV().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.hV().q(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            eVar.hV().q("client_logid", String.valueOf(this.An));
            if (!TextUtils.isEmpty(Ai)) {
                eVar.hV().q("cuid", Ai);
            }
            if (!TextUtils.isEmpty(Aj)) {
                eVar.hV().q("cuid_galaxy2", Aj);
            }
            if (!TextUtils.isEmpty(Ak)) {
                eVar.hV().q("cuid_gid", Ak);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
