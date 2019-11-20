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
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    private static String oW;
    private static String oX;
    private static boolean oY;
    private static String oZ;
    private static String pa;
    private static String pd;
    private static String sUid;
    private e pe;
    private c pf;
    private long pg;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.pg = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ai(String str) {
        oW = str;
    }

    public static void setCuid(String str) {
        oZ = str;
    }

    public static void aj(String str) {
        pa = str;
    }

    public static void ak(String str) {
        pd = str;
    }

    public static void setUserAgent(String str) {
        oX = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public static void E(boolean z) {
        oY = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.pe = new e();
        a(this.pe, z);
        this.pe.fJ().setUrl(str);
        this.pf = new c(this.pe);
        this.pf.c(i, i3, i4);
        return this.pe.fK();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.pe = new e();
        a(this.pe, z);
        this.pe.fJ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.pe.fJ().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.pe.fJ().l(next.getName(), next.getValue());
            }
        }
        this.pf = new c(this.pe);
        this.pf.e(i, i2, -1);
        return this.pe.fK();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.pe = new e();
        a(this.pe, z);
        this.pe.fJ().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.pe.fJ().l(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.pe.fJ().addPostData(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.pe.fJ().addPostData(entry.getKey(), entry.getValue());
            }
        }
        this.pf = new c(this.pe);
        this.pf.e(i, i2, -1);
        return this.pe.fK();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.pe = new e();
        b(this.pe);
        this.pe.fJ().setUrl(str);
        this.pf = new c(this.pe);
        return this.pf.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.pf != null) {
            this.pf.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.pf != null) {
            return this.pf.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.pf != null) {
            this.pf.setCancel();
        }
    }

    public e fS() {
        return this.pe;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(oW)) {
                eVar.fJ().l(SM.COOKIE, oW);
            } else {
                eVar.fJ().l(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                eVar.fJ().l("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(oX)) {
                eVar.fJ().l(HTTP.USER_AGENT, oX);
            }
            if (z) {
                eVar.fJ().l("Accept-Encoding", "gzip");
            } else {
                eVar.fJ().l("Accept-Encoding", "");
            }
            if (oY) {
                eVar.fJ().l(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.fJ().l(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.fJ().l("client_logid", String.valueOf(this.pg));
            if (!TextUtils.isEmpty(oZ)) {
                eVar.fJ().l("cuid", oZ);
            }
            if (!TextUtils.isEmpty(pa)) {
                eVar.fJ().l("cuid_galaxy2", pa);
            }
            if (!TextUtils.isEmpty(pd)) {
                eVar.fJ().l("cuid_gid", pd);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
