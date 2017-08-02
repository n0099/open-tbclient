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
    private static String vV;
    private static String vW;
    private static String vX;
    private static boolean vY;
    private static String vZ;
    private e wa;
    private c wb;
    private long wc;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.wc = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setCookie(String str) {
        vV = str;
    }

    public static void ai(String str) {
        vZ = str;
    }

    public static void setUserAgent(String str) {
        vW = str;
    }

    public static void setUid(String str) {
        vX = str;
    }

    public static void setKeepAlive(boolean z) {
        vY = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.wa = new e();
        a(this.wa, z);
        this.wa.fy().setUrl(str);
        this.wb = new c(this.wa);
        this.wb.d(i, i3, i4);
        return this.wa.fz();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.wa = new e();
        a(this.wa, z);
        this.wa.fy().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.wa.fy().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.wa.fy().o(next.getName(), next.getValue());
            }
        }
        this.wb = new c(this.wa);
        this.wb.f(i, i2, -1);
        return this.wa.fz();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.wa = new e();
        a(this.wa, z);
        this.wa.fy().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.wa.fy().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.wa.fy().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.wa.fy().d(entry.getKey(), entry.getValue());
            }
        }
        this.wb = new c(this.wa);
        this.wb.f(i, i2, -1);
        return this.wa.fz();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.wa = new e();
        b(this.wa);
        this.wa.fy().setUrl(str);
        this.wb = new c(this.wa);
        return this.wb.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.wb != null) {
            this.wb.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.wb != null) {
            return this.wb.fr();
        }
        return false;
    }

    public void fs() {
        if (this.wb != null) {
            this.wb.fs();
        }
    }

    public e fG() {
        return this.wa;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vV)) {
                eVar.fy().o("Cookie", vV);
            } else {
                eVar.fy().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(vX)) {
                eVar.fy().o("client_user_token", vX);
            }
            if (!TextUtils.isEmpty(vW)) {
                eVar.fy().o("User-Agent", vW);
            }
            if (z) {
                eVar.fy().o("Accept-Encoding", "gzip");
            } else {
                eVar.fy().o("Accept-Encoding", "");
            }
            if (vY) {
                eVar.fy().o("Connection", "Keep-Alive");
            } else {
                eVar.fy().o("Connection", IntentConfig.CLOSE);
            }
            eVar.fy().o("client_logid", String.valueOf(this.wc));
            if (!TextUtils.isEmpty(vZ)) {
                eVar.fy().o("cuid", vZ);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
