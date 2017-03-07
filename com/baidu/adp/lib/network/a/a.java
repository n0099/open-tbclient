package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.network.http.i;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
    private static String wn;
    private static String wo;
    private static String wp;
    private static boolean wq;
    private static String wr;
    private f ws;
    private d wt;
    private long wu;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.wu = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ae(String str) {
        wn = str;
    }

    public static void af(String str) {
        wr = str;
    }

    public static void setUserAgent(String str) {
        wo = str;
    }

    public static void setUid(String str) {
        wp = str;
    }

    public static void setKeepAlive(boolean z) {
        wq = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ws = new f();
        a(this.ws, z);
        this.ws.fv().setUrl(str);
        this.wt = new d(this.ws);
        this.wt.d(i, i3, i4);
        return this.ws.fw();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ws = new f();
        a(this.ws, z);
        this.ws.fv().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ws.fv().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ws.fv().o(next.getName(), next.getValue());
            }
        }
        this.wt = new d(this.ws);
        this.wt.f(i, i2, -1);
        return this.ws.fw();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ws = new f();
        a(this.ws, z);
        this.ws.fv().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ws.fv().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.ws.fv().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.ws.fv().d(entry.getKey(), entry.getValue());
            }
        }
        this.wt = new d(this.ws);
        this.wt.f(i, i2, -1);
        return this.ws.fw();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.ws = new f();
        b(this.ws);
        this.ws.fv().setUrl(str);
        this.wt = new d(this.ws);
        return this.wt.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.wt != null) {
            this.wt.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.wt != null) {
            return this.wt.fo();
        }
        return false;
    }

    public void fp() {
        if (this.wt != null) {
            this.wt.fp();
        }
    }

    public f fD() {
        return this.ws;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(wn)) {
                fVar.fv().o("Cookie", wn);
            } else {
                fVar.fv().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(wp)) {
                fVar.fv().o("client_user_token", wp);
            }
            if (!TextUtils.isEmpty(wo)) {
                fVar.fv().o("User-Agent", wo);
            }
            if (z) {
                fVar.fv().o("Accept-Encoding", "gzip");
            } else {
                fVar.fv().o("Accept-Encoding", "");
            }
            if (wq) {
                fVar.fv().o("Connection", "Keep-Alive");
            } else {
                fVar.fv().o("Connection", IntentConfig.CLOSE);
            }
            fVar.fv().o("client_logid", String.valueOf(this.wu));
            if (!TextUtils.isEmpty(wr)) {
                fVar.fv().o(SocialConstants.PARAM_CUID, wr);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
