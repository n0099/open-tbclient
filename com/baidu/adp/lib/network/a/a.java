package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidubce.http.Headers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    private static String KK;
    private static String KL;
    private static boolean KM;
    private static String KN;
    private static String KO;
    private static String KP;
    private static String sUid;
    private e KQ;
    private c KR;
    private long KS;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.KS = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bJ(String str) {
        KK = str;
    }

    public static void setCuid(String str) {
        KN = str;
    }

    public static void bK(String str) {
        KO = str;
    }

    public static void bL(String str) {
        KP = str;
    }

    public static void setUserAgent(String str) {
        KL = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        KM = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.KQ = new e();
        a(this.KQ, z);
        this.KQ.kB().setUrl(str);
        this.KR = new c(this.KQ);
        this.KR.d(i, i3, i4);
        return this.KQ.kC();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.KQ = new e();
        a(this.KQ, z);
        this.KQ.kB().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.KQ.kB().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.KQ.kB().s(next.getName(), next.getValue());
            }
        }
        this.KR = new c(this.KQ);
        this.KR.f(i, i2, -1);
        return this.KQ.kC();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.KQ = new e();
        a(this.KQ, z);
        this.KQ.kB().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.KQ.kB().s(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.KQ.kB().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.KQ.kB().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.KR = new c(this.KQ);
        this.KR.f(i, i2, -1);
        return this.KQ.kC();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.KQ = new e();
        b(this.KQ);
        this.KQ.kB().setUrl(str);
        this.KQ.kB().ah(z4);
        this.KR = new c(this.KQ);
        return this.KR.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.KR != null) {
            this.KR.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.KR != null) {
            return this.KR.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.KR != null) {
            this.KR.setCancel();
        }
    }

    public c kT() {
        return this.KR;
    }

    public e kU() {
        return this.KQ;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(KK)) {
                eVar.kB().s(SM.COOKIE, KK);
            } else {
                eVar.kB().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.kB().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(KL)) {
                eVar.kB().s("User-Agent", KL);
            }
            if (z) {
                eVar.kB().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.kB().s(Headers.ACCEPT_ENCODING, "");
            }
            if (KM) {
                eVar.kB().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.kB().s(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.kB().s("client_logid", String.valueOf(this.KS));
            if (!TextUtils.isEmpty(KN)) {
                eVar.kB().s("cuid", KN);
            }
            if (!TextUtils.isEmpty(KO)) {
                eVar.kB().s("cuid_galaxy2", KO);
            }
            if (!TextUtils.isEmpty(KP)) {
                eVar.kB().s("cuid_gid", KP);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
