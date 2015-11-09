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
    private static String vh;
    private static String vi;
    private static String vj;
    private static boolean vk;
    private e vl;
    private c vm;
    private long vn;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vn = com.baidu.adp.lib.stats.a.hj().hl();
    }

    public static void ah(String str) {
        vh = str;
    }

    public static void setCuid(String str) {
        sCuid = str;
    }

    public static void setUserAgent(String str) {
        vi = str;
    }

    public static void setUid(String str) {
        vj = str;
    }

    public static void setKeepAlive(boolean z) {
        vk = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        this.vl = new e();
        a(this.vl, z);
        this.vl.gQ().setUrl(str);
        this.vm = new c(this.vl);
        this.vm.e(i, i3, i4);
        return this.vl.gR();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vl = new e();
        a(this.vl, z);
        this.vl.gQ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vl.gQ().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vl.gQ().p(next.getName(), next.getValue());
            }
        }
        this.vm = new c(this.vl);
        this.vm.g(i, i2, -1);
        return this.vl.gR();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vl = new e();
        a(this.vl, z);
        this.vl.gQ().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vl.gQ().p(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vl.gQ().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vl.gQ().d(entry.getKey(), entry.getValue());
            }
        }
        this.vm = new c(this.vl);
        this.vm.g(i, i2, -1);
        return this.vl.gR();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vl = new e();
        a(this.vl);
        this.vl.gQ().setUrl(str);
        this.vm = new c(this.vl);
        return this.vm.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vm != null) {
            this.vm.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vm != null) {
            return this.vm.gL();
        }
        return false;
    }

    public void gM() {
        if (this.vm != null) {
            this.vm.gM();
        }
    }

    public e gY() {
        return this.vl;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vh)) {
                eVar.gQ().p("Cookie", vh);
            } else {
                eVar.gQ().p("Cookie", "");
            }
            if (!TextUtils.isEmpty(vj)) {
                eVar.gQ().p("client_user_token", vj);
            }
            if (!TextUtils.isEmpty(vi)) {
                eVar.gQ().p("User-Agent", vi);
            }
            if (z) {
                eVar.gQ().p("Accept-Encoding", "gzip");
            } else {
                eVar.gQ().p("Accept-Encoding", "");
            }
            if (vk) {
                eVar.gQ().p("Connection", "Keep-Alive");
            } else {
                eVar.gQ().p("Connection", IntentConfig.CLOSE);
            }
            eVar.gQ().p("client_logid", String.valueOf(this.vn));
            if (!TextUtils.isEmpty(sCuid)) {
                eVar.gQ().p(SocialConstants.PARAM_CUID, sCuid);
            }
        }
    }

    private void a(e eVar) {
        a(eVar, false);
    }
}
