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
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    private static String Dh;
    private static String Di;
    private static String Dj;
    private static boolean Dk;
    private static String Dl;
    private static String Dm;
    private static String Dn;
    private e Do;
    private c Dp;
    private long Dq;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Dq = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aR(String str) {
        Dh = str;
    }

    public static void aS(String str) {
        Dl = str;
    }

    public static void aT(String str) {
        Dm = str;
    }

    public static void aU(String str) {
        Dn = str;
    }

    public static void setUserAgent(String str) {
        Di = str;
    }

    public static void setUid(String str) {
        Dj = str;
    }

    public static void setKeepAlive(boolean z) {
        Dk = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Do = new e();
        a(this.Do, z);
        this.Do.jr().setUrl(str);
        this.Dp = new c(this.Do);
        this.Dp.e(i, i3, i4);
        return this.Do.js();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Do = new e();
        a(this.Do, z);
        this.Do.jr().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Do.jr().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Do.jr().y(next.getName(), next.getValue());
            }
        }
        this.Dp = new c(this.Do);
        this.Dp.g(i, i2, -1);
        return this.Do.js();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Do = new e();
        a(this.Do, z);
        this.Do.jr().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Do.jr().y(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Do.jr().x(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Do.jr().d(entry.getKey(), entry.getValue());
            }
        }
        this.Dp = new c(this.Do);
        this.Dp.g(i, i2, -1);
        return this.Do.js();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.Do = new e();
        b(this.Do);
        this.Do.jr().setUrl(str);
        this.Dp = new c(this.Do);
        return this.Dp.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Dp != null) {
            this.Dp.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Dp != null) {
            return this.Dp.jk();
        }
        return false;
    }

    public void jl() {
        if (this.Dp != null) {
            this.Dp.jl();
        }
    }

    public e jz() {
        return this.Do;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(Dh)) {
                eVar.jr().y("Cookie", Dh);
            } else {
                eVar.jr().y("Cookie", "");
            }
            if (!TextUtils.isEmpty(Dj)) {
                eVar.jr().y("client_user_token", Dj);
            }
            if (!TextUtils.isEmpty(Di)) {
                eVar.jr().y("User-Agent", Di);
            }
            if (z) {
                eVar.jr().y("Accept-Encoding", "gzip");
            } else {
                eVar.jr().y("Accept-Encoding", "");
            }
            if (Dk) {
                eVar.jr().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.jr().y(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.jr().y("client_logid", String.valueOf(this.Dq));
            if (!TextUtils.isEmpty(Dl)) {
                eVar.jr().y("cuid", Dl);
            }
            if (!TextUtils.isEmpty(Dm)) {
                eVar.jr().y("cuid_galaxy2", Dm);
            }
            if (!TextUtils.isEmpty(Dn)) {
                eVar.jr().y("cuid_gid", Dn);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
