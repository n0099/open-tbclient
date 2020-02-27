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
    private static String rJ;
    private static String rK;
    private static boolean rL;
    private static String rM;
    private static String rN;
    private static String rO;
    private static String sUid;
    private e rP;
    private c rQ;
    private long rR;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.rR = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void au(String str) {
        rJ = str;
    }

    public static void setCuid(String str) {
        rM = str;
    }

    public static void av(String str) {
        rN = str;
    }

    public static void aw(String str) {
        rO = str;
    }

    public static void setUserAgent(String str) {
        rK = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        rL = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rP = new e();
        a(this.rP, z);
        this.rP.fX().setUrl(str);
        this.rQ = new c(this.rP);
        this.rQ.c(i, i3, i4);
        return this.rP.fY();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rP = new e();
        a(this.rP, z);
        this.rP.fX().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.rP.fX().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.rP.fX().n(next.getName(), next.getValue());
            }
        }
        this.rQ = new c(this.rP);
        this.rQ.e(i, i2, -1);
        return this.rP.fY();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rP = new e();
        a(this.rP, z);
        this.rP.fX().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.rP.fX().n(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.rP.fX().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.rP.fX().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.rQ = new c(this.rP);
        this.rQ.e(i, i2, -1);
        return this.rP.fY();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.rP = new e();
        b(this.rP);
        this.rP.fX().setUrl(str);
        this.rP.fX().I(z4);
        this.rQ = new c(this.rP);
        return this.rQ.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.rQ != null) {
            this.rQ.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.rQ != null) {
            return this.rQ.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.rQ != null) {
            this.rQ.setCancel();
        }
    }

    public e gq() {
        return this.rP;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(rJ)) {
                eVar.fX().n(SM.COOKIE, rJ);
            } else {
                eVar.fX().n(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.fX().n("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rK)) {
                eVar.fX().n("User-Agent", rK);
            }
            if (z) {
                eVar.fX().n(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.fX().n(Headers.ACCEPT_ENCODING, "");
            }
            if (rL) {
                eVar.fX().n(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.fX().n(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.fX().n("client_logid", String.valueOf(this.rR));
            if (!TextUtils.isEmpty(rM)) {
                eVar.fX().n("cuid", rM);
            }
            if (!TextUtils.isEmpty(rN)) {
                eVar.fX().n("cuid_galaxy2", rN);
            }
            if (!TextUtils.isEmpty(rO)) {
                eVar.fX().n("cuid_gid", rO);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
