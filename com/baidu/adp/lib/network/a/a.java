package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.network.http.i;
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
    private static String lI;
    private static String lJ;
    private static String lK;
    private static boolean lL;
    private static String lM;
    private f lN;
    private d lO;
    private long lP;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.lP = com.baidu.adp.lib.stats.a.dO().dQ();
    }

    public static void ac(String str) {
        lI = str;
    }

    public static void ad(String str) {
        lM = str;
    }

    public static void setUserAgent(String str) {
        lJ = str;
    }

    public static void setUid(String str) {
        lK = str;
    }

    public static void setKeepAlive(boolean z) {
        lL = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        this.lN = new f();
        a(this.lN, z);
        this.lN.dv().setUrl(str);
        this.lO = new d(this.lN);
        this.lO.d(i, i3, i4);
        return this.lN.dw();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.lN = new f();
        a(this.lN, z);
        this.lN.dv().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.lN.dv().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.lN.dv().o(next.getName(), next.getValue());
            }
        }
        this.lO = new d(this.lN);
        this.lO.f(i, i2, -1);
        return this.lN.dw();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.lN = new f();
        a(this.lN, z);
        this.lN.dv().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.lN.dv().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.lN.dv().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.lN.dv().d(entry.getKey(), entry.getValue());
            }
        }
        this.lO = new d(this.lN);
        this.lO.f(i, i2, -1);
        return this.lN.dw();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.lN = new f();
        b(this.lN);
        this.lN.dv().setUrl(str);
        this.lO = new d(this.lN);
        return this.lO.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.lO != null) {
            this.lO.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.lO != null) {
            return this.lO.m4do();
        }
        return false;
    }

    public void dp() {
        if (this.lO != null) {
            this.lO.dp();
        }
    }

    public f dD() {
        return this.lN;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(lI)) {
                fVar.dv().o("Cookie", lI);
            } else {
                fVar.dv().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(lK)) {
                fVar.dv().o("client_user_token", lK);
            }
            if (!TextUtils.isEmpty(lJ)) {
                fVar.dv().o("User-Agent", lJ);
            }
            if (z) {
                fVar.dv().o("Accept-Encoding", "gzip");
            } else {
                fVar.dv().o("Accept-Encoding", "");
            }
            if (lL) {
                fVar.dv().o("Connection", "Keep-Alive");
            } else {
                fVar.dv().o("Connection", IntentConfig.CLOSE);
            }
            fVar.dv().o("client_logid", String.valueOf(this.lP));
            if (!TextUtils.isEmpty(lM)) {
                fVar.dv().o(SocialConstants.PARAM_CUID, lM);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
