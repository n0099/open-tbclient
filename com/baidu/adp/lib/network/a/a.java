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
    private static String AW;
    private static String AX;
    private static String AY;
    private static boolean AZ;
    private static String Ba;
    private static String Bb;
    private static String Bc;
    private e Bd;
    private c Be;
    private long Bf;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Bf = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aC(String str) {
        AW = str;
    }

    public static void aD(String str) {
        Ba = str;
    }

    public static void aE(String str) {
        Bb = str;
    }

    public static void aF(String str) {
        Bc = str;
    }

    public static void setUserAgent(String str) {
        AX = str;
    }

    public static void setUid(String str) {
        AY = str;
    }

    public static void aa(boolean z) {
        AZ = z;
    }

    public g a(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Bd = new e();
        a(this.Bd, z);
        this.Bd.iu().setUrl(str);
        this.Be = new c(this.Bd);
        this.Be.d(i, i3, i4);
        return this.Bd.iv();
    }

    public g a(String str, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        return a(str, false, i, i2, i3, i4, linkedList);
    }

    public g a(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Bd = new e();
        a(this.Bd, z);
        this.Bd.iu().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.Bd.iu().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Bd.iu().q(next.getName(), next.getValue());
            }
        }
        this.Be = new c(this.Bd);
        this.Be.f(i, i2, -1);
        return this.Bd.iv();
    }

    public g a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.Bd = new e();
        a(this.Bd, z);
        this.Bd.iu().setUrl(str);
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.Bd.iu().q(next.getName(), next.getValue());
            }
        }
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BasicNameValuePair next2 = it2.next();
                this.Bd.iu().o(next2.getName(), next2.getValue());
            }
        }
        if (hashMap != null) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                this.Bd.iu().d(entry.getKey(), entry.getValue());
            }
        }
        this.Be = new c(this.Bd);
        this.Be.f(i, i2, -1);
        return this.Bd.iv();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, hVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, h hVar, boolean z2, boolean z3) {
        this.Bd = new e();
        b(this.Bd);
        this.Bd.iu().setUrl(str);
        this.Be = new c(this.Bd);
        return this.Be.a(str2, hVar, i, i2, i3, i4, z2, z3);
    }

    public a() {
        init();
    }

    public void cancel() {
        if (this.Be != null) {
            this.Be.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.Be != null) {
            return this.Be.im();
        }
        return false;
    }

    public void in() {
        if (this.Be != null) {
            this.Be.in();
        }
    }

    public e iC() {
        return this.Bd;
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            if (!TextUtils.isEmpty(AW)) {
                eVar.iu().q(SM.COOKIE, AW);
            } else {
                eVar.iu().q(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(AY)) {
                eVar.iu().q("client_user_token", AY);
            }
            if (!TextUtils.isEmpty(AX)) {
                eVar.iu().q(HTTP.USER_AGENT, AX);
            }
            if (z) {
                eVar.iu().q("Accept-Encoding", "gzip");
            } else {
                eVar.iu().q("Accept-Encoding", "");
            }
            if (AZ) {
                eVar.iu().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                eVar.iu().q(HTTP.CONN_DIRECTIVE, "close");
            }
            eVar.iu().q("client_logid", String.valueOf(this.Bf));
            if (!TextUtils.isEmpty(Ba)) {
                eVar.iu().q("cuid", Ba);
            }
            if (!TextUtils.isEmpty(Bb)) {
                eVar.iu().q("cuid_galaxy2", Bb);
            }
            if (!TextUtils.isEmpty(Bc)) {
                eVar.iu().q("cuid_gid", Bc);
            }
        }
    }

    private void b(e eVar) {
        a(eVar, false);
    }
}
