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
    private static String vi;
    private static String vj;
    private static String vk;
    private static boolean vl;
    private e vm;
    private c vn;
    private long vo;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vo = com.baidu.adp.lib.stats.a.hk().hm();
    }

    public static void aj(String str) {
        vi = str;
    }

    public static void setCuid(String str) {
        sCuid = str;
    }

    public static void setUserAgent(String str) {
        vj = str;
    }

    public static void setUid(String str) {
        vk = str;
    }

    public static void setKeepAlive(boolean z) {
        vl = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        this.vm = new e();
        a(this.vm, z);
        this.vm.gS().setUrl(str);
        this.vn = new c(this.vm);
        this.vn.f(i, i3, i4);
        return this.vm.gT();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vm = new e();
        a(this.vm, z);
        this.vm.gS().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vm.gS().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vm.gS().p(next.getName(), next.getValue());
            }
        }
        this.vn = new c(this.vm);
        this.vn.h(i, i2, -1);
        return this.vm.gT();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vm = new e();
        a(this.vm, z);
        this.vm.gS().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vm.gS().p(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vm.gS().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vm.gS().d(entry.getKey(), entry.getValue());
            }
        }
        this.vn = new c(this.vm);
        this.vn.h(i, i2, -1);
        return this.vm.gT();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vm = new e();
        a(this.vm);
        this.vm.gS().setUrl(str);
        this.vn = new c(this.vm);
        return this.vn.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vn != null) {
            this.vn.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vn != null) {
            return this.vn.gO();
        }
        return false;
    }

    public e gZ() {
        return this.vm;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vi)) {
                eVar.gS().p("Cookie", vi);
            } else {
                eVar.gS().p("Cookie", "");
            }
            if (!TextUtils.isEmpty(vk)) {
                eVar.gS().p("client_user_token", vk);
            }
            if (!TextUtils.isEmpty(vj)) {
                eVar.gS().p("User-Agent", vj);
            }
            if (z) {
                eVar.gS().p("Accept-Encoding", "gzip");
            } else {
                eVar.gS().p("Accept-Encoding", "");
            }
            if (vl) {
                eVar.gS().p("Connection", "Keep-Alive");
            } else {
                eVar.gS().p("Connection", IntentConfig.CLOSE);
            }
            eVar.gS().p("client_logid", String.valueOf(this.vo));
            if (!TextUtils.isEmpty(sCuid)) {
                eVar.gS().p(SocialConstants.PARAM_CUID, sCuid);
            }
        }
    }

    private void a(e eVar) {
        a(eVar, false);
    }
}
