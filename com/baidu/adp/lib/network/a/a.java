package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {
    private static String sCuid;
    private static String vm;
    private static String vn;
    private static String vo;
    private static boolean vp;
    private e vq;
    private c vr;
    private long vs;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vs = com.baidu.adp.lib.h.a.iB().io();
    }

    public static void ak(String str) {
        vm = str;
    }

    public static void setCuid(String str) {
        sCuid = str;
    }

    public static void setUserAgent(String str) {
        vn = str;
    }

    public static void setUid(String str) {
        vo = str;
    }

    public static void setKeepAlive(boolean z) {
        vp = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) {
        this.vq = new e();
        a(this.vq, z);
        this.vq.gY().setUrl(str);
        this.vr = new c(this.vq);
        this.vr.i(i, i3, i2);
        return this.vq.gZ();
    }

    public g a(String str, int i, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vq = new e();
        a(this.vq, z);
        this.vq.gY().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vq.gY().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vq.gY().p(next.getName(), next.getValue());
            }
        }
        this.vr = new c(this.vq);
        this.vr.k(i, i2, -1);
        return this.vq.gZ();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vq = new e();
        a(this.vq, z);
        this.vq.gY().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vq.gY().p(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vq.gY().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vq.gY().d(entry.getKey(), entry.getValue());
            }
        }
        this.vr = new c(this.vq);
        this.vr.k(i, i2, -1);
        return this.vq.gZ();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vq = new e();
        a(this.vq);
        this.vq.gY().setUrl(str);
        this.vr = new c(this.vq);
        return this.vr.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vr != null) {
            this.vr.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vr != null) {
            return this.vr.gU();
        }
        return false;
    }

    public e hf() {
        return this.vq;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vm)) {
                eVar.gY().p("Cookie", vm);
            } else {
                eVar.gY().p("Cookie", "");
            }
            if (!TextUtils.isEmpty(vo)) {
                eVar.gY().p("client_user_token", vo);
            }
            if (!TextUtils.isEmpty(vn)) {
                eVar.gY().p("User-Agent", vn);
            }
            if (z) {
                eVar.gY().p("Accept-Encoding", "gzip");
            }
            if (vp) {
                eVar.gY().p("Connection", "Keep-Alive");
            } else {
                eVar.gY().p("Connection", com.baidu.tbadk.core.frameworkData.c.CLOSE);
            }
            eVar.gY().p("client_logid", String.valueOf(this.vs));
            if (!TextUtils.isEmpty(sCuid)) {
                eVar.gY().p("cuid", sCuid);
            }
        }
    }

    private void a(e eVar) {
        a(eVar, false);
    }
}
