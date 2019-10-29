package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
    private static String pC;
    private static String pD;
    private static boolean pE;
    private static String pF;
    private static String pG;
    private static String pH;
    private static String sUid;
    private e pI;
    private c pJ;
    private long pK;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.pK = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ai(String str) {
        pC = str;
    }

    public static void setCuid(String str) {
        pF = str;
    }

    public static void aj(String str) {
        pG = str;
    }

    public static void ak(String str) {
        pH = str;
    }

    public static void setUserAgent(String str) {
        pD = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void E(boolean z) {
        pE = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.pI = new e();
        a(this.pI, z);
        this.pI.fJ().setUrl(str);
        this.pJ = new c(this.pI);
        this.pJ.c(i, i3, i4);
        return this.pI.fK();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.pI = new e();
        a(this.pI, z);
        this.pI.fJ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.pI.fJ().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.pI.fJ().l(next.getName(), next.getValue());
            }
        }
        this.pJ = new c(this.pI);
        this.pJ.e(i, i2, -1);
        return this.pI.fK();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.pI = new e();
        a(this.pI, z);
        this.pI.fJ().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.pI.fJ().l(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.pI.fJ().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.pI.fJ().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.pJ = new c(this.pI);
        this.pJ.e(i, i2, -1);
        return this.pI.fK();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.pI = new e();
        b(this.pI);
        this.pI.fJ().setUrl(str);
        this.pJ = new c(this.pI);
        return this.pJ.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.pJ != null) {
            this.pJ.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.pJ != null) {
            return this.pJ.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.pJ != null) {
            this.pJ.setCancel();
        }
    }

    public e fS() {
        return this.pI;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(pC)) {
                eVar.fJ().l(SM.COOKIE, pC);
            } else {
                eVar.fJ().l(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.fJ().l("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(pD)) {
                eVar.fJ().l(HTTP.USER_AGENT, pD);
            }
            if (z) {
                eVar.fJ().l("Accept-Encoding", "gzip");
            } else {
                eVar.fJ().l("Accept-Encoding", "");
            }
            if (pE) {
                eVar.fJ().l(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.fJ().l(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.fJ().l("client_logid", String.valueOf(this.pK));
            if (!TextUtils.isEmpty(pF)) {
                eVar.fJ().l("cuid", pF);
            }
            if (!TextUtils.isEmpty(pG)) {
                eVar.fJ().l("cuid_galaxy2", pG);
            }
            if (!TextUtils.isEmpty(pH)) {
                eVar.fJ().l("cuid_gid", pH);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
