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
    private static String oJ;
    private static String oK;
    private static String oL;
    private static boolean oM;
    private static String oN;
    private f oO;
    private d oP;
    private long oQ;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.oQ = com.baidu.adp.lib.stats.a.eI().eK();
    }

    public static void af(String str) {
        oJ = str;
    }

    public static void ag(String str) {
        oN = str;
    }

    public static void setUserAgent(String str) {
        oK = str;
    }

    public static void setUid(String str) {
        oL = str;
    }

    public static void setKeepAlive(boolean z) {
        oM = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oO = new f();
        a(this.oO, z);
        this.oO.ep().setUrl(str);
        this.oP = new d(this.oO);
        this.oP.e(i, i3, i4);
        return this.oO.eq();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oO = new f();
        a(this.oO, z);
        this.oO.ep().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.oO.ep().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.oO.ep().o(next.getName(), next.getValue());
            }
        }
        this.oP = new d(this.oO);
        this.oP.g(i, i2, -1);
        return this.oO.eq();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oO = new f();
        a(this.oO, z);
        this.oO.ep().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.oO.ep().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.oO.ep().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.oO.ep().d(entry.getKey(), entry.getValue());
            }
        }
        this.oP = new d(this.oO);
        this.oP.g(i, i2, -1);
        return this.oO.eq();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.oO = new f();
        b(this.oO);
        this.oO.ep().setUrl(str);
        this.oP = new d(this.oO);
        return this.oP.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.oP != null) {
            this.oP.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.oP != null) {
            return this.oP.ei();
        }
        return false;
    }

    public void ej() {
        if (this.oP != null) {
            this.oP.ej();
        }
    }

    public f ex() {
        return this.oO;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(oJ)) {
                fVar.ep().o("Cookie", oJ);
            } else {
                fVar.ep().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(oL)) {
                fVar.ep().o("client_user_token", oL);
            }
            if (!TextUtils.isEmpty(oK)) {
                fVar.ep().o("User-Agent", oK);
            }
            if (z) {
                fVar.ep().o("Accept-Encoding", "gzip");
            } else {
                fVar.ep().o("Accept-Encoding", "");
            }
            if (oM) {
                fVar.ep().o("Connection", "Keep-Alive");
            } else {
                fVar.ep().o("Connection", IntentConfig.CLOSE);
            }
            fVar.ep().o("client_logid", String.valueOf(this.oQ));
            if (!TextUtils.isEmpty(oN)) {
                fVar.ep().o(SocialConstants.PARAM_CUID, oN);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
