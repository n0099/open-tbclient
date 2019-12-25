package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.network.http.i;
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
    private f rO;
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

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rO = new f();
        a(this.rO, z);
        this.rO.fY().setUrl(str);
        this.rP = new c(this.rO);
        this.rP.c(i, i3, i4);
        return this.rO.fZ();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rO = new f();
        a(this.rO, z);
        this.rO.fY().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.rO.fY().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.rO.fY().m(next.getName(), next.getValue());
            }
        }
        this.rP = new c(this.rO);
        this.rP.e(i, i2, -1);
        return this.rO.fZ();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.rO = new f();
        a(this.rO, z);
        this.rO.fY().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.rO.fY().m(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.rO.fY().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.rO.fY().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.rP = new c(this.rO);
        this.rP.e(i, i2, -1);
        return this.rO.fZ();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3, boolean z4) {
        this.rO = new f();
        b(this.rO);
        this.rO.fY().setUrl(str);
        this.rO.fY().I(z4);
        this.rP = new c(this.rO);
        return this.rP.a(str2, iVar, i, i2, i3, i4, z2, z3);
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

    public f gr() {
        return this.rO;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(rI)) {
                fVar.fY().m(SM.COOKIE, rI);
            } else {
                fVar.fY().m(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                fVar.fY().m("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rJ)) {
                fVar.fY().m("User-Agent", rJ);
            }
            if (z) {
                fVar.fY().m(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                fVar.fY().m(Headers.ACCEPT_ENCODING, "");
            }
            if (rK) {
                fVar.fY().m(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                fVar.fY().m(HTTP.CONN_DIRECTIVE, "close");
            }
            fVar.fY().m("client_logid", String.valueOf(this.rQ));
            if (!TextUtils.isEmpty(rL)) {
                fVar.fY().m("cuid", rL);
            }
            if (!TextUtils.isEmpty(rM)) {
                fVar.fY().m("cuid_galaxy2", rM);
            }
            if (!TextUtils.isEmpty(rN)) {
                fVar.fY().m("cuid_gid", rN);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
