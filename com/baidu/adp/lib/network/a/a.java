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
    private static String vA;
    private static String vB;
    private static boolean vC;
    private static String vz;
    private e vD;
    private c vE;
    private long vF;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vF = com.baidu.adp.lib.stats.a.ht().hv();
    }

    public static void ak(String str) {
        vz = str;
    }

    public static void setCuid(String str) {
        sCuid = str;
    }

    public static void setUserAgent(String str) {
        vA = str;
    }

    public static void setUid(String str) {
        vB = str;
    }

    public static void setKeepAlive(boolean z) {
        vC = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        this.vD = new e();
        a(this.vD, z);
        this.vD.ha().setUrl(str);
        this.vE = new c(this.vD);
        this.vE.e(i, i3, i4);
        return this.vD.hb();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vD = new e();
        a(this.vD, z);
        this.vD.ha().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vD.ha().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vD.ha().q(next.getName(), next.getValue());
            }
        }
        this.vE = new c(this.vD);
        this.vE.g(i, i2, -1);
        return this.vD.hb();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vD = new e();
        a(this.vD, z);
        this.vD.ha().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vD.ha().q(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vD.ha().p(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vD.ha().d(entry.getKey(), entry.getValue());
            }
        }
        this.vE = new c(this.vD);
        this.vE.g(i, i2, -1);
        return this.vD.hb();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.vD = new e();
        a(this.vD);
        this.vD.ha().setUrl(str);
        this.vE = new c(this.vD);
        return this.vE.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vE != null) {
            this.vE.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vE != null) {
            return this.vE.gV();
        }
        return false;
    }

    public void gW() {
        if (this.vE != null) {
            this.vE.gW();
        }
    }

    public e hi() {
        return this.vD;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(vz)) {
                eVar.ha().q("Cookie", vz);
            } else {
                eVar.ha().q("Cookie", "");
            }
            if (!TextUtils.isEmpty(vB)) {
                eVar.ha().q("client_user_token", vB);
            }
            if (!TextUtils.isEmpty(vA)) {
                eVar.ha().q("User-Agent", vA);
            }
            if (z) {
                eVar.ha().q("Accept-Encoding", "gzip");
            } else {
                eVar.ha().q("Accept-Encoding", "");
            }
            if (vC) {
                eVar.ha().q("Connection", "Keep-Alive");
            } else {
                eVar.ha().q("Connection", IntentConfig.CLOSE);
            }
            eVar.ha().q("client_logid", String.valueOf(this.vF));
            if (!TextUtils.isEmpty(sCuid)) {
                eVar.ha().q(SocialConstants.PARAM_CUID, sCuid);
            }
        }
    }

    private void a(e eVar) {
        a(eVar, false);
    }
}
