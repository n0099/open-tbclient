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
    private static String OA;
    private static String Ou;
    private static String Ov;
    private static boolean Ow;
    private static String Ox;
    private static String Oy;
    private static String Oz;
    private static String sUid;
    private e OB;
    private c OC;
    private long OD;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.OD = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bQ(String str) {
        Ou = str;
    }

    public static void setCuid(String str) {
        Ox = str;
    }

    public static void bR(String str) {
        Oy = str;
    }

    public static void bS(String str) {
        Oz = str;
    }

    public static void bT(String str) {
        OA = str;
    }

    public static void setUserAgent(String str) {
        Ov = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void al(boolean z) {
        Ow = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.OB = new e();
        a(this.OB, z);
        this.OB.lU().setUrl(str);
        this.OC = new c(this.OB);
        this.OC.d(i, i3, i4);
        return this.OB.lV();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.OB = new e();
        a(this.OB, z);
        this.OB.lU().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.OB.lU().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.OB.lU().s(next.getName(), next.getValue());
            }
        }
        this.OC = new c(this.OB);
        this.OC.f(i, i2, -1);
        return this.OB.lV();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.OB = new e();
        a(this.OB, z);
        this.OB.lU().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.OB.lU().s(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.OB.lU().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.OB.lU().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.OC = new c(this.OB);
        this.OC.f(i, i2, -1);
        return this.OB.lV();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.OB = new e();
        b(this.OB);
        this.OB.lU().setUrl(str);
        this.OB.lU().ah(z4);
        this.OC = new c(this.OB);
        return this.OC.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.OC != null) {
            this.OC.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.OC != null) {
            return this.OC.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.OC != null) {
            this.OC.setCancel();
        }
    }

    public c mn() {
        return this.OC;
    }

    public e mo() {
        return this.OB;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Ou)) {
                eVar.lU().s(SM.COOKIE, Ou);
            } else {
                eVar.lU().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.lU().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Ov)) {
                eVar.lU().s("User-Agent", Ov);
            }
            if (z) {
                eVar.lU().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.lU().s(Headers.ACCEPT_ENCODING, "");
            }
            if (Ow) {
                eVar.lU().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.lU().s(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.lU().s("client_logid", String.valueOf(this.OD));
            if (!TextUtils.isEmpty(Ox)) {
                eVar.lU().s("cuid", Ox);
            }
            if (!TextUtils.isEmpty(Oy)) {
                eVar.lU().s("cuid_galaxy2", Oy);
            }
            if (!TextUtils.isEmpty(Oz)) {
                eVar.lU().s("c3_aid", Oz);
            }
            if (!TextUtils.isEmpty(OA)) {
                eVar.lU().s("cuid_gid", OA);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
