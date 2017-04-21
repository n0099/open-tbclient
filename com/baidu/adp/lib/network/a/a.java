package com.baidu.adp.lib.network.a;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.network.http.i;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
    private static String vU;
    private static String vV;
    private static String vW;
    private static boolean vX;
    private static String vY;
    private f vZ;
    private d wa;
    private long wb;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.wb = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setCookie(String str) {
        vU = str;
    }

    public static void ab(String str) {
        vY = str;
    }

    public static void setUserAgent(String str) {
        vV = str;
    }

    public static void setUid(String str) {
        vW = str;
    }

    public static void setKeepAlive(boolean z) {
        vX = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vZ = new f();
        a(this.vZ, z);
        this.vZ.fB().setUrl(str);
        this.wa = new d(this.vZ);
        this.wa.d(i, i3, i4);
        return this.vZ.fC();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vZ = new f();
        a(this.vZ, z);
        this.vZ.fB().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.vZ.fB().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vZ.fB().o(next.getName(), next.getValue());
            }
        }
        this.wa = new d(this.vZ);
        this.wa.f(i, i2, -1);
        return this.vZ.fC();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.vZ = new f();
        a(this.vZ, z);
        this.vZ.fB().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.vZ.fB().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.vZ.fB().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.vZ.fB().d(entry.getKey(), entry.getValue());
            }
        }
        this.wa = new d(this.vZ);
        this.wa.f(i, i2, -1);
        return this.vZ.fC();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.vZ = new f();
        b(this.vZ);
        this.vZ.fB().setUrl(str);
        this.wa = new d(this.vZ);
        return this.wa.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.wa != null) {
            this.wa.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.wa != null) {
            return this.wa.fu();
        }
        return false;
    }

    public void fv() {
        if (this.wa != null) {
            this.wa.fv();
        }
    }

    public f fJ() {
        return this.vZ;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(vU)) {
                fVar.fB().o("Cookie", vU);
            } else {
                fVar.fB().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(vW)) {
                fVar.fB().o("client_user_token", vW);
            }
            if (!TextUtils.isEmpty(vV)) {
                fVar.fB().o("User-Agent", vV);
            }
            if (z) {
                fVar.fB().o("Accept-Encoding", "gzip");
            } else {
                fVar.fB().o("Accept-Encoding", "");
            }
            if (vX) {
                fVar.fB().o("Connection", "Keep-Alive");
            } else {
                fVar.fB().o("Connection", IntentConfig.CLOSE);
            }
            fVar.fB().o("client_logid", String.valueOf(this.wb));
            if (!TextUtils.isEmpty(vY)) {
                fVar.fB().o("cuid", vY);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
