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
    private static String vs;
    private static String vt;
    private static String vu;
    private static boolean vv;
    private static String vw;
    private e vx;
    private c vy;
    private long vz;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vz = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ai(String str) {
        vs = str;
    }

    public static void aj(String str) {
        vw = str;
    }

    public static void setUserAgent(String str) {
        vt = str;
    }

    public static void setUid(String str) {
        vu = str;
    }

    public static void setKeepAlive(boolean z) {
        vv = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vx = new e();
        a(this.vx, z);
        this.vx.fy().setUrl(str);
        this.vy = new c(this.vx);
        this.vy.d(i, i3, i4);
        return this.vx.fz();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vx = new e();
        a(this.vx, z);
        this.vx.fy().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vx.fy().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vx.fy().o(next.getName(), next.getValue());
            }
        }
        this.vy = new c(this.vx);
        this.vy.f(i, i2, -1);
        return this.vx.fz();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vx = new e();
        a(this.vx, z);
        this.vx.fy().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vx.fy().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vx.fy().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vx.fy().d(entry.getKey(), entry.getValue());
            }
        }
        this.vy = new c(this.vx);
        this.vy.f(i, i2, -1);
        return this.vx.fz();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vx = new e();
        b(this.vx);
        this.vx.fy().setUrl(str);
        this.vy = new c(this.vx);
        return this.vy.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vy != null) {
            this.vy.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vy != null) {
            return this.vy.fq();
        }
        return false;
    }

    public void fs() {
        if (this.vy != null) {
            this.vy.fs();
        }
    }

    public e fG() {
        return this.vx;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vs)) {
                eVar.fy().o("Cookie", vs);
            } else {
                eVar.fy().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(vu)) {
                eVar.fy().o("client_user_token", vu);
            }
            if (!TextUtils.isEmpty(vt)) {
                eVar.fy().o("User-Agent", vt);
            }
            if (z) {
                eVar.fy().o("Accept-Encoding", "gzip");
            } else {
                eVar.fy().o("Accept-Encoding", "");
            }
            if (vv) {
                eVar.fy().o("Connection", "Keep-Alive");
            } else {
                eVar.fy().o("Connection", IntentConfig.CLOSE);
            }
            eVar.fy().o("client_logid", String.valueOf(this.vz));
            if (!TextUtils.isEmpty(vw)) {
                eVar.fy().o("cuid", vw);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
