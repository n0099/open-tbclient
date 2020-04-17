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
    private static String KH;
    private static String KI;
    private static boolean KJ;
    private static String KK;
    private static String KL;
    private static String KM;
    private static String sUid;
    private e KN;
    private c KO;
    private long KP;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.KP = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bJ(String str) {
        KH = str;
    }

    public static void setCuid(String str) {
        KK = str;
    }

    public static void bK(String str) {
        KL = str;
    }

    public static void bL(String str) {
        KM = str;
    }

    public static void setUserAgent(String str) {
        KI = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        KJ = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.KN = new e();
        a(this.KN, z);
        this.KN.kB().setUrl(str);
        this.KO = new c(this.KN);
        this.KO.d(i, i3, i4);
        return this.KN.kC();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.KN = new e();
        a(this.KN, z);
        this.KN.kB().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.KN.kB().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.KN.kB().s(next.getName(), next.getValue());
            }
        }
        this.KO = new c(this.KN);
        this.KO.f(i, i2, -1);
        return this.KN.kC();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.KN = new e();
        a(this.KN, z);
        this.KN.kB().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.KN.kB().s(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.KN.kB().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.KN.kB().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.KO = new c(this.KN);
        this.KO.f(i, i2, -1);
        return this.KN.kC();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.KN = new e();
        b(this.KN);
        this.KN.kB().setUrl(str);
        this.KN.kB().ah(z4);
        this.KO = new c(this.KN);
        return this.KO.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.KO != null) {
            this.KO.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.KO != null) {
            return this.KO.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.KO != null) {
            this.KO.setCancel();
        }
    }

    public c kT() {
        return this.KO;
    }

    public e kU() {
        return this.KN;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(KH)) {
                eVar.kB().s(SM.COOKIE, KH);
            } else {
                eVar.kB().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.kB().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(KI)) {
                eVar.kB().s("User-Agent", KI);
            }
            if (z) {
                eVar.kB().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.kB().s(Headers.ACCEPT_ENCODING, "");
            }
            if (KJ) {
                eVar.kB().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.kB().s(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.kB().s("client_logid", String.valueOf(this.KP));
            if (!TextUtils.isEmpty(KK)) {
                eVar.kB().s("cuid", KK);
            }
            if (!TextUtils.isEmpty(KL)) {
                eVar.kB().s("cuid_galaxy2", KL);
            }
            if (!TextUtils.isEmpty(KM)) {
                eVar.kB().s("cuid_gid", KM);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
