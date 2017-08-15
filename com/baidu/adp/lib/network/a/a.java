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
    private static String xA;
    private static String xB;
    private static boolean xC;
    private static String xD;
    private static String xz;
    private e xE;
    private c xF;
    private long xG;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.xG = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setCookie(String str) {
        xz = str;
    }

    public static void ao(String str) {
        xD = str;
    }

    public static void setUserAgent(String str) {
        xA = str;
    }

    public static void setUid(String str) {
        xB = str;
    }

    public static void setKeepAlive(boolean z) {
        xC = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.xE = new e();
        a(this.xE, z);
        this.xE.fJ().setUrl(str);
        this.xF = new c(this.xE);
        this.xF.d(i, i3, i4);
        return this.xE.fK();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.xE = new e();
        a(this.xE, z);
        this.xE.fJ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.xE.fJ().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.xE.fJ().o(next.getName(), next.getValue());
            }
        }
        this.xF = new c(this.xE);
        this.xF.f(i, i2, -1);
        return this.xE.fK();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.xE = new e();
        a(this.xE, z);
        this.xE.fJ().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.xE.fJ().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.xE.fJ().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.xE.fJ().d(entry.getKey(), entry.getValue());
            }
        }
        this.xF = new c(this.xE);
        this.xF.f(i, i2, -1);
        return this.xE.fK();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.xE = new e();
        b(this.xE);
        this.xE.fJ().setUrl(str);
        this.xF = new c(this.xE);
        return this.xF.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.xF != null) {
            this.xF.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.xF != null) {
            return this.xF.fC();
        }
        return false;
    }

    public void fD() {
        if (this.xF != null) {
            this.xF.fD();
        }
    }

    public e fR() {
        return this.xE;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(xz)) {
                eVar.fJ().o("Cookie", xz);
            } else {
                eVar.fJ().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(xB)) {
                eVar.fJ().o("client_user_token", xB);
            }
            if (!TextUtils.isEmpty(xA)) {
                eVar.fJ().o("User-Agent", xA);
            }
            if (z) {
                eVar.fJ().o("Accept-Encoding", "gzip");
            } else {
                eVar.fJ().o("Accept-Encoding", "");
            }
            if (xC) {
                eVar.fJ().o("Connection", "Keep-Alive");
            } else {
                eVar.fJ().o("Connection", IntentConfig.CLOSE);
            }
            eVar.fJ().o("client_logid", String.valueOf(this.xG));
            if (!TextUtils.isEmpty(xD)) {
                eVar.fJ().o("cuid", xD);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
