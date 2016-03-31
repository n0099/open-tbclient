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
    private static String vP;
    private static String vQ;
    private static String vR;
    private static boolean vS;
    private static String vT;
    private f vU;
    private d vV;
    private long vW;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.vW = com.baidu.adp.lib.stats.a.hz().hB();
    }

    public static void al(String str) {
        vP = str;
    }

    public static void am(String str) {
        vT = str;
    }

    public static void setUserAgent(String str) {
        vQ = str;
    }

    public static void setUid(String str) {
        vR = str;
    }

    public static void setKeepAlive(boolean z) {
        vS = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        this.vU = new f();
        a(this.vU, z);
        this.vU.hg().setUrl(str);
        this.vV = new d(this.vU);
        this.vV.e(i, i3, i4);
        return this.vU.hh();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vU = new f();
        a(this.vU, z);
        this.vU.hg().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vU.hg().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vU.hg().q(next.getName(), next.getValue());
            }
        }
        this.vV = new d(this.vU);
        this.vV.g(i, i2, -1);
        return this.vU.hh();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) {
        this.vU = new f();
        a(this.vU, z);
        this.vU.hg().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vU.hg().q(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vU.hg().p(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vU.hg().c(entry.getKey(), entry.getValue());
            }
        }
        this.vV = new d(this.vU);
        this.vV.g(i, i2, -1);
        return this.vU.hh();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.vU = new f();
        b(this.vU);
        this.vU.hg().setUrl(str);
        this.vV = new d(this.vU);
        return this.vV.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.vV != null) {
            this.vV.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.vV != null) {
            return this.vV.gZ();
        }
        return false;
    }

    public void ha() {
        if (this.vV != null) {
            this.vV.ha();
        }
    }

    public f ho() {
        return this.vU;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(vP)) {
                fVar.hg().q("Cookie", vP);
            } else {
                fVar.hg().q("Cookie", "");
            }
            if (!TextUtils.isEmpty(vR)) {
                fVar.hg().q("client_user_token", vR);
            }
            if (!TextUtils.isEmpty(vQ)) {
                fVar.hg().q("User-Agent", vQ);
            }
            if (z) {
                fVar.hg().q("Accept-Encoding", "gzip");
            } else {
                fVar.hg().q("Accept-Encoding", "");
            }
            if (vS) {
                fVar.hg().q("Connection", "Keep-Alive");
            } else {
                fVar.hg().q("Connection", IntentConfig.CLOSE);
            }
            fVar.hg().q("client_logid", String.valueOf(this.vW));
            if (!TextUtils.isEmpty(vT)) {
                fVar.hg().q(SocialConstants.PARAM_CUID, vT);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
