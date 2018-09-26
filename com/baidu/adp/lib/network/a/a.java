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
    private static String CA;
    private static String Cu;
    private static String Cv;
    private static String Cw;
    private static boolean Cx;
    private static String Cy;
    private static String Cz;
    private e CB;
    private c CC;
    private long CD;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.CD = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aR(String str) {
        Cu = str;
    }

    public static void aS(String str) {
        Cy = str;
    }

    public static void aT(String str) {
        Cz = str;
    }

    public static void aU(String str) {
        CA = str;
    }

    public static void setUserAgent(String str) {
        Cv = str;
    }

    public static void setUid(String str) {
        Cw = str;
    }

    public static void setKeepAlive(boolean z) {
        Cx = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.CB = new e();
        a(this.CB, z);
        this.CB.jc().setUrl(str);
        this.CC = new c(this.CB);
        this.CC.e(i, i3, i4);
        return this.CB.jd();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.CB = new e();
        a(this.CB, z);
        this.CB.jc().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.CB.jc().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.CB.jc().x(next.getName(), next.getValue());
            }
        }
        this.CC = new c(this.CB);
        this.CC.g(i, i2, -1);
        return this.CB.jd();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.CB = new e();
        a(this.CB, z);
        this.CB.jc().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.CB.jc().x(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.CB.jc().u(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.CB.jc().d(entry.getKey(), entry.getValue());
            }
        }
        this.CC = new c(this.CB);
        this.CC.g(i, i2, -1);
        return this.CB.jd();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.CB = new e();
        b(this.CB);
        this.CB.jc().setUrl(str);
        this.CC = new c(this.CB);
        return this.CC.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.CC != null) {
            this.CC.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.CC != null) {
            return this.CC.iV();
        }
        return false;
    }

    public void iW() {
        if (this.CC != null) {
            this.CC.iW();
        }
    }

    public e jk() {
        return this.CB;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Cu)) {
                eVar.jc().x(SM.COOKIE, Cu);
            } else {
                eVar.jc().x(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Cw)) {
                eVar.jc().x("client_user_token", Cw);
            }
            if (!TextUtils.isEmpty(Cv)) {
                eVar.jc().x(HTTP.USER_AGENT, Cv);
            }
            if (z) {
                eVar.jc().x("Accept-Encoding", "gzip");
            } else {
                eVar.jc().x("Accept-Encoding", "");
            }
            if (Cx) {
                eVar.jc().x(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.jc().x(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            eVar.jc().x("client_logid", String.valueOf(this.CD));
            if (!TextUtils.isEmpty(Cy)) {
                eVar.jc().x("cuid", Cy);
            }
            if (!TextUtils.isEmpty(Cz)) {
                eVar.jc().x("cuid_galaxy2", Cz);
            }
            if (!TextUtils.isEmpty(CA)) {
                eVar.jc().x("cuid_gid", CA);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
