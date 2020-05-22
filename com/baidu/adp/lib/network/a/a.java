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
    private static String KV;
    private static String KW;
    private static boolean KX;
    private static String KY;
    private static String KZ;
    private static String La;
    private static String Lb;
    private static String sUid;
    private e Lc;
    private c Ld;
    private long Le;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Le = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bJ(String str) {
        KV = str;
    }

    public static void setCuid(String str) {
        KY = str;
    }

    public static void bK(String str) {
        KZ = str;
    }

    public static void bL(String str) {
        La = str;
    }

    public static void bM(String str) {
        Lb = str;
    }

    public static void setUserAgent(String str) {
        KW = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        KX = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Lc = new e();
        a(this.Lc, z);
        this.Lc.kD().setUrl(str);
        this.Ld = new c(this.Lc);
        this.Ld.d(i, i3, i4);
        return this.Lc.kE();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Lc = new e();
        a(this.Lc, z);
        this.Lc.kD().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Lc.kD().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Lc.kD().s(next.getName(), next.getValue());
            }
        }
        this.Ld = new c(this.Lc);
        this.Ld.f(i, i2, -1);
        return this.Lc.kE();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Lc = new e();
        a(this.Lc, z);
        this.Lc.kD().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Lc.kD().s(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Lc.kD().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Lc.kD().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.Ld = new c(this.Lc);
        this.Ld.f(i, i2, -1);
        return this.Lc.kE();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.Lc = new e();
        b(this.Lc);
        this.Lc.kD().setUrl(str);
        this.Lc.kD().aj(z4);
        this.Ld = new c(this.Lc);
        return this.Ld.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Ld != null) {
            this.Ld.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Ld != null) {
            return this.Ld.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.Ld != null) {
            this.Ld.setCancel();
        }
    }

    public c kV() {
        return this.Ld;
    }

    public e kW() {
        return this.Lc;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(KV)) {
                eVar.kD().s(SM.COOKIE, KV);
            } else {
                eVar.kD().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.kD().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(KW)) {
                eVar.kD().s("User-Agent", KW);
            }
            if (z) {
                eVar.kD().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.kD().s(Headers.ACCEPT_ENCODING, "");
            }
            if (KX) {
                eVar.kD().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.kD().s(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.kD().s("client_logid", String.valueOf(this.Le));
            if (!TextUtils.isEmpty(KY)) {
                eVar.kD().s("cuid", KY);
            }
            if (!TextUtils.isEmpty(KZ)) {
                eVar.kD().s("cuid_galaxy2", KZ);
            }
            if (!TextUtils.isEmpty(La)) {
                eVar.kD().s("c3_aid", La);
            }
            if (!TextUtils.isEmpty(Lb)) {
                eVar.kD().s("cuid_gid", Lb);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
