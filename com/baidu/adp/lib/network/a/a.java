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
    private static String AQ;
    private static String AR;
    private static String AT;
    private static boolean AU;
    private static String AV;
    private static String AW;
    private static String AX;
    private e AY;
    private c AZ;
    private long Ba;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ba = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aB(String str) {
        AQ = str;
    }

    public static void aC(String str) {
        AV = str;
    }

    public static void aD(String str) {
        AW = str;
    }

    public static void aE(String str) {
        AX = str;
    }

    public static void setUserAgent(String str) {
        AR = str;
    }

    public static void setUid(String str) {
        AT = str;
    }

    public static void setKeepAlive(boolean z) {
        AU = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.AY = new e();
        a(this.AY, z);
        this.AY.ik().setUrl(str);
        this.AZ = new c(this.AY);
        this.AZ.d(i, i3, i4);
        return this.AY.il();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.AY = new e();
        a(this.AY, z);
        this.AY.ik().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.AY.ik().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.AY.ik().q(next.getName(), next.getValue());
            }
        }
        this.AZ = new c(this.AY);
        this.AZ.f(i, i2, -1);
        return this.AY.il();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.AY = new e();
        a(this.AY, z);
        this.AY.ik().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.AY.ik().q(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.AY.ik().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.AY.ik().d(entry.getKey(), entry.getValue());
            }
        }
        this.AZ = new c(this.AY);
        this.AZ.f(i, i2, -1);
        return this.AY.il();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.AY = new e();
        b(this.AY);
        this.AY.ik().setUrl(str);
        this.AZ = new c(this.AY);
        return this.AZ.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.AZ != null) {
            this.AZ.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.AZ != null) {
            return this.AZ.ic();
        }
        return false;
    }

    public void ie() {
        if (this.AZ != null) {
            this.AZ.ie();
        }
    }

    public e it() {
        return this.AY;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(AQ)) {
                eVar.ik().q("Cookie", AQ);
            } else {
                eVar.ik().q("Cookie", "");
            }
            if (!TextUtils.isEmpty(AT)) {
                eVar.ik().q("client_user_token", AT);
            }
            if (!TextUtils.isEmpty(AR)) {
                eVar.ik().q("User-Agent", AR);
            }
            if (z) {
                eVar.ik().q("Accept-Encoding", "gzip");
            } else {
                eVar.ik().q("Accept-Encoding", "");
            }
            if (AU) {
                eVar.ik().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.ik().q(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.ik().q("client_logid", String.valueOf(this.Ba));
            if (!TextUtils.isEmpty(AV)) {
                eVar.ik().q("cuid", AV);
            }
            if (!TextUtils.isEmpty(AW)) {
                eVar.ik().q("cuid_galaxy2", AW);
            }
            if (!TextUtils.isEmpty(AX)) {
                eVar.ik().q("cuid_gid", AX);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
