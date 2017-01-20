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
    private static String oC;
    private static String oD;
    private static String oE;
    private static boolean oF;
    private static String oG;
    private f oH;
    private d oI;
    private long oJ;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.oJ = com.baidu.adp.lib.stats.a.eG().eI();
    }

    public static void af(String str) {
        oC = str;
    }

    public static void ag(String str) {
        oG = str;
    }

    public static void setUserAgent(String str) {
        oD = str;
    }

    public static void setUid(String str) {
        oE = str;
    }

    public static void setKeepAlive(boolean z) {
        oF = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oH = new f();
        a(this.oH, z);
        this.oH.en().setUrl(str);
        this.oI = new d(this.oH);
        this.oI.d(i, i3, i4);
        return this.oH.eo();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oH = new f();
        a(this.oH, z);
        this.oH.en().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.oH.en().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.oH.en().o(next.getName(), next.getValue());
            }
        }
        this.oI = new d(this.oH);
        this.oI.f(i, i2, -1);
        return this.oH.eo();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.oH = new f();
        a(this.oH, z);
        this.oH.en().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.oH.en().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.oH.en().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.oH.en().d(entry.getKey(), entry.getValue());
            }
        }
        this.oI = new d(this.oH);
        this.oI.f(i, i2, -1);
        return this.oH.eo();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.oH = new f();
        b(this.oH);
        this.oH.en().setUrl(str);
        this.oI = new d(this.oH);
        return this.oI.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.oI != null) {
            this.oI.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.oI != null) {
            return this.oI.eg();
        }
        return false;
    }

    public void eh() {
        if (this.oI != null) {
            this.oI.eh();
        }
    }

    public f ev() {
        return this.oH;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(oC)) {
                fVar.en().o("Cookie", oC);
            } else {
                fVar.en().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(oE)) {
                fVar.en().o("client_user_token", oE);
            }
            if (!TextUtils.isEmpty(oD)) {
                fVar.en().o("User-Agent", oD);
            }
            if (z) {
                fVar.en().o("Accept-Encoding", "gzip");
            } else {
                fVar.en().o("Accept-Encoding", "");
            }
            if (oF) {
                fVar.en().o("Connection", "Keep-Alive");
            } else {
                fVar.en().o("Connection", IntentConfig.CLOSE);
            }
            fVar.en().o("client_logid", String.valueOf(this.oJ));
            if (!TextUtils.isEmpty(oG)) {
                fVar.en().o(SocialConstants.PARAM_CUID, oG);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
