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
    private static String uc;
    private static String ud;
    private static String ue;
    private static boolean uf;
    private static String ug;
    private e uh;
    private c ui;
    private long uj;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.uj = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void an(String str) {
        uc = str;
    }

    public static void ao(String str) {
        ug = str;
    }

    public static void setUserAgent(String str) {
        ud = str;
    }

    public static void setUid(String str) {
        ue = str;
    }

    public static void setKeepAlive(boolean z) {
        uf = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.uh = new e();
        a(this.uh, z);
        this.uh.fe().setUrl(str);
        this.ui = new c(this.uh);
        this.ui.d(i, i3, i4);
        return this.uh.ff();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.uh = new e();
        a(this.uh, z);
        this.uh.fe().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.uh.fe().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.uh.fe().o(next.getName(), next.getValue());
            }
        }
        this.ui = new c(this.uh);
        this.ui.f(i, i2, -1);
        return this.uh.ff();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.uh = new e();
        a(this.uh, z);
        this.uh.fe().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.uh.fe().o(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.uh.fe().n(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.uh.fe().d(entry.getKey(), entry.getValue());
            }
        }
        this.ui = new c(this.uh);
        this.ui.f(i, i2, -1);
        return this.uh.ff();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.uh = new e();
        b(this.uh);
        this.uh.fe().setUrl(str);
        this.ui = new c(this.uh);
        return this.ui.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.ui != null) {
            this.ui.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ui != null) {
            return this.ui.isCancel();
        }
        return false;
    }

    public void eY() {
        if (this.ui != null) {
            this.ui.eY();
        }
    }

    public e fm() {
        return this.uh;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(uc)) {
                eVar.fe().o(SM.COOKIE, uc);
            } else {
                eVar.fe().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ue)) {
                eVar.fe().o("client_user_token", ue);
            }
            if (!TextUtils.isEmpty(ud)) {
                eVar.fe().o(HTTP.USER_AGENT, ud);
            }
            if (z) {
                eVar.fe().o("Accept-Encoding", "gzip");
            } else {
                eVar.fe().o("Accept-Encoding", "");
            }
            if (uf) {
                eVar.fe().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.fe().o(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.fe().o("client_logid", String.valueOf(this.uj));
            if (!TextUtils.isEmpty(ug)) {
                eVar.fe().o("cuid", ug);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
