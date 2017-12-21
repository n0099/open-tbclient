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
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static String vr;
    private static String vs;
    private static String vt;
    private static boolean vu;
    private static String vv;
    private e vw;
    private c vx;
    private long vy;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vy = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ai(String str) {
        vr = str;
    }

    public static void aj(String str) {
        vv = str;
    }

    public static void setUserAgent(String str) {
        vs = str;
    }

    public static void setUid(String str) {
        vt = str;
    }

    public static void setKeepAlive(boolean z) {
        vu = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vw = new e();
        a(this.vw, z);
        this.vw.fy().setUrl(str);
        this.vx = new c(this.vw);
        this.vx.d(i, i3, i4);
        return this.vw.fz();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vw = new e();
        a(this.vw, z);
        this.vw.fy().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vw.fy().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vw.fy().o(next.getName(), next.getValue());
            }
        }
        this.vx = new c(this.vw);
        this.vx.f(i, i2, -1);
        return this.vw.fz();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vw = new e();
        a(this.vw, z);
        this.vw.fy().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vw.fy().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vw.fy().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vw.fy().d(entry.getKey(), entry.getValue());
            }
        }
        this.vx = new c(this.vw);
        this.vx.f(i, i2, -1);
        return this.vw.fz();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vw = new e();
        b(this.vw);
        this.vw.fy().setUrl(str);
        this.vx = new c(this.vw);
        return this.vx.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vx != null) {
            this.vx.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vx != null) {
            return this.vx.fq();
        }
        return false;
    }

    public void fs() {
        if (this.vx != null) {
            this.vx.fs();
        }
    }

    public e fG() {
        return this.vw;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vr)) {
                eVar.fy().o("Cookie", vr);
            } else {
                eVar.fy().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(vt)) {
                eVar.fy().o("client_user_token", vt);
            }
            if (!TextUtils.isEmpty(vs)) {
                eVar.fy().o("User-Agent", vs);
            }
            if (z) {
                eVar.fy().o("Accept-Encoding", "gzip");
            } else {
                eVar.fy().o("Accept-Encoding", "");
            }
            if (vu) {
                eVar.fy().o("Connection", "Keep-Alive");
            } else {
                eVar.fy().o("Connection", IntentConfig.CLOSE);
            }
            eVar.fy().o("client_logid", String.valueOf(this.vy));
            if (!TextUtils.isEmpty(vv)) {
                eVar.fy().o("cuid", vv);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
