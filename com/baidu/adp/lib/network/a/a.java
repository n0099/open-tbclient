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
    private static String mm;
    private static String mn;
    private static String mo;
    private static boolean mp;
    private static String mq;
    private f mr;
    private d ms;
    private long mt;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.mt = com.baidu.adp.lib.stats.a.dN().dP();
    }

    public static void ae(String str) {
        mm = str;
    }

    public static void af(String str) {
        mq = str;
    }

    public static void setUserAgent(String str) {
        mn = str;
    }

    public static void setUid(String str) {
        mo = str;
    }

    public static void setKeepAlive(boolean z) {
        mp = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mr = new f();
        a(this.mr, z);
        this.mr.du().setUrl(str);
        this.ms = new d(this.mr);
        this.ms.e(i, i3, i4);
        return this.mr.dv();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mr = new f();
        a(this.mr, z);
        this.mr.du().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mr.du().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mr.du().o(next.getName(), next.getValue());
            }
        }
        this.ms = new d(this.mr);
        this.ms.g(i, i2, -1);
        return this.mr.dv();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mr = new f();
        a(this.mr, z);
        this.mr.du().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mr.du().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.mr.du().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.mr.du().d(entry.getKey(), entry.getValue());
            }
        }
        this.ms = new d(this.mr);
        this.ms.g(i, i2, -1);
        return this.mr.dv();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.mr = new f();
        b(this.mr);
        this.mr.du().setUrl(str);
        this.ms = new d(this.mr);
        return this.ms.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.ms != null) {
            this.ms.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ms != null) {
            return this.ms.dn();
        }
        return false;
    }

    /* renamed from: do  reason: not valid java name */
    public void m4do() {
        if (this.ms != null) {
            this.ms.m5do();
        }
    }

    public f dC() {
        return this.mr;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(mm)) {
                fVar.du().o("Cookie", mm);
            } else {
                fVar.du().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(mo)) {
                fVar.du().o("client_user_token", mo);
            }
            if (!TextUtils.isEmpty(mn)) {
                fVar.du().o("User-Agent", mn);
            }
            if (z) {
                fVar.du().o("Accept-Encoding", "gzip");
            } else {
                fVar.du().o("Accept-Encoding", "");
            }
            if (mp) {
                fVar.du().o("Connection", "Keep-Alive");
            } else {
                fVar.du().o("Connection", IntentConfig.CLOSE);
            }
            fVar.du().o("client_logid", String.valueOf(this.mt));
            if (!TextUtils.isEmpty(mq)) {
                fVar.du().o(SocialConstants.PARAM_CUID, mq);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
