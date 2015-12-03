package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.cloudsdk.social.core.SocialConstants;
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
    private static String sCuid;
    private static String vn;
    private static String vo;
    private static String vp;
    private static boolean vq;
    private e vr;
    private c vs;
    private long vt;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vt = com.baidu.adp.lib.stats.a.hl().hn();
    }

    public static void al(String str) {
        vn = str;
    }

    public static void setCuid(String str) {
        sCuid = str;
    }

    public static void setUserAgent(String str) {
        vo = str;
    }

    public static void setUid(String str) {
        vp = str;
    }

    public static void setKeepAlive(boolean z) {
        vq = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        this.vr = new e();
        a(this.vr, z);
        this.vr.gS().setUrl(str);
        this.vs = new c(this.vr);
        this.vs.e(i, i3, i4);
        return this.vr.gT();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vr = new e();
        a(this.vr, z);
        this.vr.gS().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vr.gS().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vr.gS().p(next.getName(), next.getValue());
            }
        }
        this.vs = new c(this.vr);
        this.vs.g(i, i2, -1);
        return this.vr.gT();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vr = new e();
        a(this.vr, z);
        this.vr.gS().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vr.gS().p(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vr.gS().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vr.gS().d(entry.getKey(), entry.getValue());
            }
        }
        this.vs = new c(this.vr);
        this.vs.g(i, i2, -1);
        return this.vr.gT();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vr = new e();
        a(this.vr);
        this.vr.gS().setUrl(str);
        this.vs = new c(this.vr);
        return this.vs.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vs != null) {
            this.vs.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vs != null) {
            return this.vs.gN();
        }
        return false;
    }

    public void gO() {
        if (this.vs != null) {
            this.vs.gO();
        }
    }

    public e ha() {
        return this.vr;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vn)) {
                eVar.gS().p(HttpMessage.KEY_COOKIE, vn);
            } else {
                eVar.gS().p(HttpMessage.KEY_COOKIE, "");
            }
            if (!TextUtils.isEmpty(vp)) {
                eVar.gS().p("client_user_token", vp);
            }
            if (!TextUtils.isEmpty(vo)) {
                eVar.gS().p("User-Agent", vo);
            }
            if (z) {
                eVar.gS().p("Accept-Encoding", "gzip");
            } else {
                eVar.gS().p("Accept-Encoding", "");
            }
            if (vq) {
                eVar.gS().p("Connection", "Keep-Alive");
            } else {
                eVar.gS().p("Connection", IntentConfig.CLOSE);
            }
            eVar.gS().p("client_logid", String.valueOf(this.vt));
            if (!TextUtils.isEmpty(sCuid)) {
                eVar.gS().p(SocialConstants.PARAM_CUID, sCuid);
            }
        }
    }

    private void a(e eVar) {
        a(eVar, false);
    }
}
