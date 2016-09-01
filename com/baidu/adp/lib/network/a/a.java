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
    private static String oI;
    private static String oJ;
    private static String oK;
    private static boolean oL;
    private static String oM;
    private f oN;
    private d oO;
    private long oP;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.oP = com.baidu.adp.lib.stats.a.eI().eK();
    }

    public static void af(String str) {
        oI = str;
    }

    public static void ag(String str) {
        oM = str;
    }

    public static void setUserAgent(String str) {
        oJ = str;
    }

    public static void setUid(String str) {
        oK = str;
    }

    public static void setKeepAlive(boolean z) {
        oL = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oN = new f();
        a(this.oN, z);
        this.oN.ep().setUrl(str);
        this.oO = new d(this.oN);
        this.oO.e(i, i3, i4);
        return this.oN.eq();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oN = new f();
        a(this.oN, z);
        this.oN.ep().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.oN.ep().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.oN.ep().o(next.getName(), next.getValue());
            }
        }
        this.oO = new d(this.oN);
        this.oO.g(i, i2, -1);
        return this.oN.eq();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oN = new f();
        a(this.oN, z);
        this.oN.ep().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.oN.ep().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.oN.ep().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.oN.ep().d(entry.getKey(), entry.getValue());
            }
        }
        this.oO = new d(this.oN);
        this.oO.g(i, i2, -1);
        return this.oN.eq();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.oN = new f();
        b(this.oN);
        this.oN.ep().setUrl(str);
        this.oO = new d(this.oN);
        return this.oO.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.oO != null) {
            this.oO.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.oO != null) {
            return this.oO.ei();
        }
        return false;
    }

    public void ej() {
        if (this.oO != null) {
            this.oO.ej();
        }
    }

    public f ex() {
        return this.oN;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(oI)) {
                fVar.ep().o("Cookie", oI);
            } else {
                fVar.ep().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(oK)) {
                fVar.ep().o("client_user_token", oK);
            }
            if (!TextUtils.isEmpty(oJ)) {
                fVar.ep().o("User-Agent", oJ);
            }
            if (z) {
                fVar.ep().o("Accept-Encoding", "gzip");
            } else {
                fVar.ep().o("Accept-Encoding", "");
            }
            if (oL) {
                fVar.ep().o("Connection", "Keep-Alive");
            } else {
                fVar.ep().o("Connection", IntentConfig.CLOSE);
            }
            fVar.ep().o("client_logid", String.valueOf(this.oP));
            if (!TextUtils.isEmpty(oM)) {
                fVar.ep().o(SocialConstants.PARAM_CUID, oM);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
