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
    private static String AP;
    private static String AQ;
    private static String AR;
    private static boolean AT;
    private static String AU;
    private static String AV;
    private static String AW;
    private e AX;
    private c AY;
    private long AZ;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.AZ = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aB(String str) {
        AP = str;
    }

    public static void aC(String str) {
        AU = str;
    }

    public static void aD(String str) {
        AV = str;
    }

    public static void aE(String str) {
        AW = str;
    }

    public static void setUserAgent(String str) {
        AQ = str;
    }

    public static void setUid(String str) {
        AR = str;
    }

    public static void setKeepAlive(boolean z) {
        AT = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.AX = new e();
        a(this.AX, z);
        this.AX.ik().setUrl(str);
        this.AY = new c(this.AX);
        this.AY.d(i, i3, i4);
        return this.AX.il();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.AX = new e();
        a(this.AX, z);
        this.AX.ik().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.AX.ik().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.AX.ik().q(next.getName(), next.getValue());
            }
        }
        this.AY = new c(this.AX);
        this.AY.f(i, i2, -1);
        return this.AX.il();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.AX = new e();
        a(this.AX, z);
        this.AX.ik().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.AX.ik().q(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.AX.ik().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.AX.ik().d(entry.getKey(), entry.getValue());
            }
        }
        this.AY = new c(this.AX);
        this.AY.f(i, i2, -1);
        return this.AX.il();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.AX = new e();
        b(this.AX);
        this.AX.ik().setUrl(str);
        this.AY = new c(this.AX);
        return this.AY.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.AY != null) {
            this.AY.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.AY != null) {
            return this.AY.ic();
        }
        return false;
    }

    public void ie() {
        if (this.AY != null) {
            this.AY.ie();
        }
    }

    public e it() {
        return this.AX;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(AP)) {
                eVar.ik().q("Cookie", AP);
            } else {
                eVar.ik().q("Cookie", "");
            }
            if (!TextUtils.isEmpty(AR)) {
                eVar.ik().q("client_user_token", AR);
            }
            if (!TextUtils.isEmpty(AQ)) {
                eVar.ik().q("User-Agent", AQ);
            }
            if (z) {
                eVar.ik().q("Accept-Encoding", "gzip");
            } else {
                eVar.ik().q("Accept-Encoding", "");
            }
            if (AT) {
                eVar.ik().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.ik().q(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.ik().q("client_logid", String.valueOf(this.AZ));
            if (!TextUtils.isEmpty(AU)) {
                eVar.ik().q("cuid", AU);
            }
            if (!TextUtils.isEmpty(AV)) {
                eVar.ik().q("cuid_galaxy2", AV);
            }
            if (!TextUtils.isEmpty(AW)) {
                eVar.ik().q("cuid_gid", AW);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
