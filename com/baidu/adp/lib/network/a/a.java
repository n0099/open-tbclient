package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.webkit.internal.ABTestConstants;
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
    private static String Di;
    private static String Dj;
    private static String Dk;
    private static boolean Dl;
    private static String Dm;
    private static String Dn;
    private static String Do;
    private e Dp;
    private c Dq;
    private long Dr;

    public void init() {
        System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        this.Dr = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aR(String str) {
        Di = str;
    }

    public static void setCuid(String str) {
        Dm = str;
    }

    public static void aS(String str) {
        Dn = str;
    }

    public static void aT(String str) {
        Do = str;
    }

    public static void setUserAgent(String str) {
        Dj = str;
    }

    public static void setUid(String str) {
        Dk = str;
    }

    public static void setKeepAlive(boolean z) {
        Dl = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Dp = new e();
        a(this.Dp, z);
        this.Dp.jp().setUrl(str);
        this.Dq = new c(this.Dp);
        this.Dq.e(i, i3, i4);
        return this.Dp.jq();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Dp = new e();
        a(this.Dp, z);
        this.Dp.jp().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Dp.jp().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Dp.jp().y(next.getName(), next.getValue());
            }
        }
        this.Dq = new c(this.Dp);
        this.Dq.g(i, i2, -1);
        return this.Dp.jq();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Dp = new e();
        a(this.Dp, z);
        this.Dp.jp().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Dp.jp().y(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Dp.jp().x(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Dp.jp().d(entry.getKey(), entry.getValue());
            }
        }
        this.Dq = new c(this.Dp);
        this.Dq.g(i, i2, -1);
        return this.Dp.jq();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.Dp = new e();
        b(this.Dp);
        this.Dp.jp().setUrl(str);
        this.Dq = new c(this.Dp);
        return this.Dq.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Dq != null) {
            this.Dq.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Dq != null) {
            return this.Dq.ji();
        }
        return false;
    }

    public void jj() {
        if (this.Dq != null) {
            this.Dq.jj();
        }
    }

    public e jx() {
        return this.Dp;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Di)) {
                eVar.jp().y(SM.COOKIE, Di);
            } else {
                eVar.jp().y(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Dk)) {
                eVar.jp().y("client_user_token", Dk);
            }
            if (!TextUtils.isEmpty(Dj)) {
                eVar.jp().y(HTTP.USER_AGENT, Dj);
            }
            if (z) {
                eVar.jp().y("Accept-Encoding", "gzip");
            } else {
                eVar.jp().y("Accept-Encoding", "");
            }
            if (Dl) {
                eVar.jp().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.jp().y(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.jp().y("client_logid", String.valueOf(this.Dr));
            if (!TextUtils.isEmpty(Dm)) {
                eVar.jp().y("cuid", Dm);
            }
            if (!TextUtils.isEmpty(Dn)) {
                eVar.jp().y("cuid_galaxy2", Dn);
            }
            if (!TextUtils.isEmpty(Do)) {
                eVar.jp().y("cuid_gid", Do);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
