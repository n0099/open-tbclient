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
    private static String rI;
    private static String rJ;
    private static boolean rK;
    private static String rL;
    private static String rM;
    private static String rN;
    private static String sUid;
    private e rO;
    private c rP;
    private long rQ;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.rQ = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void au(String str) {
        rI = str;
    }

    public static void setCuid(String str) {
        rL = str;
    }

    public static void av(String str) {
        rM = str;
    }

    public static void aw(String str) {
        rN = str;
    }

    public static void setUserAgent(String str) {
        rJ = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void setKeepAlive(boolean z) {
        rK = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rO = new e();
        a(this.rO, z);
        this.rO.fX().setUrl(str);
        this.rP = new c(this.rO);
        this.rP.c(i, i3, i4);
        return this.rO.fY();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rO = new e();
        a(this.rO, z);
        this.rO.fX().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.rO.fX().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.rO.fX().l(next.getName(), next.getValue());
            }
        }
        this.rP = new c(this.rO);
        this.rP.e(i, i2, -1);
        return this.rO.fY();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rO = new e();
        a(this.rO, z);
        this.rO.fX().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.rO.fX().l(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.rO.fX().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.rO.fX().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.rP = new c(this.rO);
        this.rP.e(i, i2, -1);
        return this.rO.fY();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3, boolean z4) {
        this.rO = new e();
        b(this.rO);
        this.rO.fX().setUrl(str);
        this.rO.fX().I(z4);
        this.rP = new c(this.rO);
        return this.rP.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.rP != null) {
            this.rP.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.rP != null) {
            return this.rP.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.rP != null) {
            this.rP.setCancel();
        }
    }

    public e gq() {
        return this.rO;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(rI)) {
                eVar.fX().l(SM.COOKIE, rI);
            } else {
                eVar.fX().l(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.fX().l("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rJ)) {
                eVar.fX().l("User-Agent", rJ);
            }
            if (z) {
                eVar.fX().l(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                eVar.fX().l(Headers.ACCEPT_ENCODING, "");
            }
            if (rK) {
                eVar.fX().l(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.fX().l(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.fX().l("client_logid", String.valueOf(this.rQ));
            if (!TextUtils.isEmpty(rL)) {
                eVar.fX().l("cuid", rL);
            }
            if (!TextUtils.isEmpty(rM)) {
                eVar.fX().l("cuid_galaxy2", rM);
            }
            if (!TextUtils.isEmpty(rN)) {
                eVar.fX().l("cuid_gid", rN);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
