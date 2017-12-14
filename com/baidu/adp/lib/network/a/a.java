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
    private static String vq;
    private static String vr;
    private static String vs;
    private static boolean vt;
    private static String vu;
    private e vv;
    private c vw;
    private long vx;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vx = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ai(String str) {
        vq = str;
    }

    public static void aj(String str) {
        vu = str;
    }

    public static void setUserAgent(String str) {
        vr = str;
    }

    public static void setUid(String str) {
        vs = str;
    }

    public static void setKeepAlive(boolean z) {
        vt = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vv = new e();
        a(this.vv, z);
        this.vv.fy().setUrl(str);
        this.vw = new c(this.vv);
        this.vw.d(i, i3, i4);
        return this.vv.fz();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vv = new e();
        a(this.vv, z);
        this.vv.fy().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vv.fy().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vv.fy().o(next.getName(), next.getValue());
            }
        }
        this.vw = new c(this.vv);
        this.vw.f(i, i2, -1);
        return this.vv.fz();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vv = new e();
        a(this.vv, z);
        this.vv.fy().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vv.fy().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vv.fy().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vv.fy().d(entry.getKey(), entry.getValue());
            }
        }
        this.vw = new c(this.vv);
        this.vw.f(i, i2, -1);
        return this.vv.fz();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vv = new e();
        b(this.vv);
        this.vv.fy().setUrl(str);
        this.vw = new c(this.vv);
        return this.vw.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vw != null) {
            this.vw.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vw != null) {
            return this.vw.fq();
        }
        return false;
    }

    public void fs() {
        if (this.vw != null) {
            this.vw.fs();
        }
    }

    public e fG() {
        return this.vv;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vq)) {
                eVar.fy().o("Cookie", vq);
            } else {
                eVar.fy().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(vs)) {
                eVar.fy().o("client_user_token", vs);
            }
            if (!TextUtils.isEmpty(vr)) {
                eVar.fy().o("User-Agent", vr);
            }
            if (z) {
                eVar.fy().o("Accept-Encoding", "gzip");
            } else {
                eVar.fy().o("Accept-Encoding", "");
            }
            if (vt) {
                eVar.fy().o("Connection", "Keep-Alive");
            } else {
                eVar.fy().o("Connection", IntentConfig.CLOSE);
            }
            eVar.fy().o("client_logid", String.valueOf(this.vx));
            if (!TextUtils.isEmpty(vu)) {
                eVar.fy().o("cuid", vu);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
