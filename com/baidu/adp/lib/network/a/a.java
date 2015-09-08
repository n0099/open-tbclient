package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
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
    private static String vg;
    private static String vh;
    private static String vi;
    private static boolean vj;
    private e vk;
    private c vl;
    private long vm;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vm = com.baidu.adp.lib.stats.a.hh().hj();
    }

    public static void aj(String str) {
        vg = str;
    }

    public static void setCuid(String str) {
        sCuid = str;
    }

    public static void setUserAgent(String str) {
        vh = str;
    }

    public static void setUid(String str) {
        vi = str;
    }

    public static void setKeepAlive(boolean z) {
        vj = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        this.vk = new e();
        a(this.vk, z);
        this.vk.gP().setUrl(str);
        this.vl = new c(this.vk);
        this.vl.e(i, i3, i4);
        return this.vk.gQ();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vk = new e();
        a(this.vk, z);
        this.vk.gP().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vk.gP().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vk.gP().p(next.getName(), next.getValue());
            }
        }
        this.vl = new c(this.vk);
        this.vl.g(i, i2, -1);
        return this.vk.gQ();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vk = new e();
        a(this.vk, z);
        this.vk.gP().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vk.gP().p(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vk.gP().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vk.gP().d(entry.getKey(), entry.getValue());
            }
        }
        this.vl = new c(this.vk);
        this.vl.g(i, i2, -1);
        return this.vk.gQ();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vk = new e();
        a(this.vk);
        this.vk.gP().setUrl(str);
        this.vl = new c(this.vk);
        return this.vl.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vl != null) {
            this.vl.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vl != null) {
            return this.vl.gL();
        }
        return false;
    }

    public e gW() {
        return this.vk;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vg)) {
                eVar.gP().p("Cookie", vg);
            } else {
                eVar.gP().p("Cookie", "");
            }
            if (!TextUtils.isEmpty(vi)) {
                eVar.gP().p("client_user_token", vi);
            }
            if (!TextUtils.isEmpty(vh)) {
                eVar.gP().p("User-Agent", vh);
            }
            if (z) {
                eVar.gP().p("Accept-Encoding", "gzip");
            } else {
                eVar.gP().p("Accept-Encoding", "");
            }
            if (vj) {
                eVar.gP().p("Connection", "Keep-Alive");
            } else {
                eVar.gP().p("Connection", IntentConfig.CLOSE);
            }
            eVar.gP().p("client_logid", String.valueOf(this.vm));
            if (!TextUtils.isEmpty(sCuid)) {
                eVar.gP().p(SocialConstants.PARAM_CUID, sCuid);
            }
        }
    }

    private void a(e eVar) {
        a(eVar, false);
    }
}
