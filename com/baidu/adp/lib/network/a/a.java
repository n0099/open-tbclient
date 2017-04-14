package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.network.http.i;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
    private static String vQ;
    private static String vR;
    private static String vS;
    private static boolean vT;
    private static String vU;
    private f vV;
    private d vW;
    private long vX;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vX = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setCookie(String str) {
        vQ = str;
    }

    public static void ab(String str) {
        vU = str;
    }

    public static void setUserAgent(String str) {
        vR = str;
    }

    public static void setUid(String str) {
        vS = str;
    }

    public static void setKeepAlive(boolean z) {
        vT = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vV = new f();
        a(this.vV, z);
        this.vV.fA().setUrl(str);
        this.vW = new d(this.vV);
        this.vW.d(i, i3, i4);
        return this.vV.fB();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vV = new f();
        a(this.vV, z);
        this.vV.fA().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vV.fA().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vV.fA().o(next.getName(), next.getValue());
            }
        }
        this.vW = new d(this.vV);
        this.vW.f(i, i2, -1);
        return this.vV.fB();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vV = new f();
        a(this.vV, z);
        this.vV.fA().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vV.fA().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vV.fA().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vV.fA().d(entry.getKey(), entry.getValue());
            }
        }
        this.vW = new d(this.vV);
        this.vW.f(i, i2, -1);
        return this.vV.fB();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.vV = new f();
        b(this.vV);
        this.vV.fA().setUrl(str);
        this.vW = new d(this.vV);
        return this.vW.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vW != null) {
            this.vW.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vW != null) {
            return this.vW.ft();
        }
        return false;
    }

    public void fu() {
        if (this.vW != null) {
            this.vW.fu();
        }
    }

    public f fI() {
        return this.vV;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(vQ)) {
                fVar.fA().o("Cookie", vQ);
            } else {
                fVar.fA().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(vS)) {
                fVar.fA().o("client_user_token", vS);
            }
            if (!TextUtils.isEmpty(vR)) {
                fVar.fA().o("User-Agent", vR);
            }
            if (z) {
                fVar.fA().o("Accept-Encoding", "gzip");
            } else {
                fVar.fA().o("Accept-Encoding", "");
            }
            if (vT) {
                fVar.fA().o("Connection", "Keep-Alive");
            } else {
                fVar.fA().o("Connection", IntentConfig.CLOSE);
            }
            fVar.fA().o("client_logid", String.valueOf(this.vX));
            if (!TextUtils.isEmpty(vU)) {
                fVar.fA().o("cuid", vU);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
