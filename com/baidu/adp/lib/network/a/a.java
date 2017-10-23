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
    private static String vt;
    private static String vu;
    private static String vv;
    private static boolean vw;
    private static String vx;
    private long vA;
    private e vy;
    private c vz;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vA = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ai(String str) {
        vt = str;
    }

    public static void aj(String str) {
        vx = str;
    }

    public static void setUserAgent(String str) {
        vu = str;
    }

    public static void setUid(String str) {
        vv = str;
    }

    public static void setKeepAlive(boolean z) {
        vw = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vy = new e();
        a(this.vy, z);
        this.vy.fy().setUrl(str);
        this.vz = new c(this.vy);
        this.vz.d(i, i3, i4);
        return this.vy.fz();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vy = new e();
        a(this.vy, z);
        this.vy.fy().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vy.fy().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vy.fy().o(next.getName(), next.getValue());
            }
        }
        this.vz = new c(this.vy);
        this.vz.f(i, i2, -1);
        return this.vy.fz();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vy = new e();
        a(this.vy, z);
        this.vy.fy().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vy.fy().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vy.fy().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vy.fy().d(entry.getKey(), entry.getValue());
            }
        }
        this.vz = new c(this.vy);
        this.vz.f(i, i2, -1);
        return this.vy.fz();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vy = new e();
        b(this.vy);
        this.vy.fy().setUrl(str);
        this.vz = new c(this.vy);
        return this.vz.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vz != null) {
            this.vz.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vz != null) {
            return this.vz.fq();
        }
        return false;
    }

    public void fs() {
        if (this.vz != null) {
            this.vz.fs();
        }
    }

    public e fG() {
        return this.vy;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vt)) {
                eVar.fy().o("Cookie", vt);
            } else {
                eVar.fy().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(vv)) {
                eVar.fy().o("client_user_token", vv);
            }
            if (!TextUtils.isEmpty(vu)) {
                eVar.fy().o("User-Agent", vu);
            }
            if (z) {
                eVar.fy().o("Accept-Encoding", "gzip");
            } else {
                eVar.fy().o("Accept-Encoding", "");
            }
            if (vw) {
                eVar.fy().o("Connection", "Keep-Alive");
            } else {
                eVar.fy().o("Connection", IntentConfig.CLOSE);
            }
            eVar.fy().o("client_logid", String.valueOf(this.vA));
            if (!TextUtils.isEmpty(vx)) {
                eVar.fy().o("cuid", vx);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
