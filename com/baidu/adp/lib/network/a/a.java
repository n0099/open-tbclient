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
    private static String vV;
    private static String vW;
    private static String vX;
    private static boolean vY;
    private static String vZ;
    private f wa;
    private d wb;
    private long wc;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.wc = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setCookie(String str) {
        vV = str;
    }

    public static void ab(String str) {
        vZ = str;
    }

    public static void setUserAgent(String str) {
        vW = str;
    }

    public static void setUid(String str) {
        vX = str;
    }

    public static void setKeepAlive(boolean z) {
        vY = z;
    }

    public h a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.wa = new f();
        a(this.wa, z);
        this.wa.fB().setUrl(str);
        this.wb = new d(this.wa);
        this.wb.d(i, i3, i4);
        return this.wa.fC();
    }

    public h a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public h a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.wa = new f();
        a(this.wa, z);
        this.wa.fB().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.wa.fB().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.wa.fB().o(next.getName(), next.getValue());
            }
        }
        this.wb = new d(this.wa);
        this.wb.f(i, i2, -1);
        return this.wa.fC();
    }

    public h a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.wa = new f();
        a(this.wa, z);
        this.wa.fB().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.wa.fB().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.wa.fB().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.wa.fB().d(entry.getKey(), entry.getValue());
            }
        }
        this.wb = new d(this.wa);
        this.wb.f(i, i2, -1);
        return this.wa.fC();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, iVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, i iVar, boolean z2, boolean z3) {
        this.wa = new f();
        b(this.wa);
        this.wa.fB().setUrl(str);
        this.wb = new d(this.wa);
        return this.wb.a(str2, iVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.wb != null) {
            this.wb.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.wb != null) {
            return this.wb.fu();
        }
        return false;
    }

    public void fv() {
        if (this.wb != null) {
            this.wb.fv();
        }
    }

    public f fJ() {
        return this.wa;
    }

    private void a(f fVar, boolean z) {
        if (fVar != null) {
            if (!TextUtils.isEmpty(vV)) {
                fVar.fB().o("Cookie", vV);
            } else {
                fVar.fB().o("Cookie", "");
            }
            if (!TextUtils.isEmpty(vX)) {
                fVar.fB().o("client_user_token", vX);
            }
            if (!TextUtils.isEmpty(vW)) {
                fVar.fB().o("User-Agent", vW);
            }
            if (z) {
                fVar.fB().o("Accept-Encoding", "gzip");
            } else {
                fVar.fB().o("Accept-Encoding", "");
            }
            if (vY) {
                fVar.fB().o("Connection", "Keep-Alive");
            } else {
                fVar.fB().o("Connection", IntentConfig.CLOSE);
            }
            fVar.fB().o("client_logid", String.valueOf(this.wc));
            if (!TextUtils.isEmpty(vZ)) {
                fVar.fB().o("cuid", vZ);
            }
        }
    }

    private void b(f fVar) {
        a(fVar, false);
    }
}
