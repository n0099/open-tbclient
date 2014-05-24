package com.baidu.adp.lib.stats;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private static h a;
    private Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q = null;
    private String r = null;
    private g s = null;
    private a t = null;
    private b u = null;
    private Handler v = null;
    private BdAsyncTaskParallel w = null;
    private BdStatSwitchData x = null;
    private l y;
    private j z;

    public static h a() {
        synchronized (h.class) {
            if (a == null) {
                a = new h();
            }
        }
        return a;
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.b = context;
        this.o = str;
        this.p = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.j = str7;
        this.k = str8;
        this.m = Build.MODEL;
        this.n = Build.VERSION.RELEASE;
        this.l = str9;
        if (this.y == null && context != null) {
            try {
                this.y = new l(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.y, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.z == null && context != null) {
            this.z = new j(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager2.account_changed");
            context.registerReceiver(this.z, intentFilter2);
        }
        if (TextUtils.isEmpty(str10)) {
            str10 = TbConfig.TMP_LOG_DIR_NAME;
        }
        if (this.v == null) {
            this.v = new i(this);
        }
        this.x = new BdStatSwitchData();
        if (this.s == null) {
            this.s = new g(context, str10);
        }
        if (this.t == null) {
            this.t = new a(context, str10);
        }
        if (this.u == null) {
            this.u = new b(context, str10);
        }
        a(this.x);
        f();
    }

    private void f() {
        new k(this, true).execute(new Object[0]);
    }

    public String b() {
        return r.a(this.b);
    }

    public void g() {
        this.q = r.a(this.b);
        this.r = r.b(this.b);
        if (com.baidu.adp.lib.network.willdelete.h.b()) {
            boolean a2 = com.baidu.adp.lib.network.willdelete.h.a();
            if (this.s != null) {
                this.s.d(a2);
            }
            if (this.t != null) {
                this.t.d(a2);
            }
            if (this.u != null) {
                this.u.d(a2);
            }
        }
    }

    public String c() {
        return this.q;
    }

    public s a(String str) {
        return new s(str);
    }

    public synchronized void a(String str, String str2, String str3) {
        if ((this.g != null || str != null) && (this.g == null || !this.g.equals(str))) {
            this.g = str;
            this.h = str2;
            this.i = str3;
            d();
        }
    }

    public void a(String str, Object... objArr) {
        f c;
        if (!TextUtils.isEmpty(str) && objArr != null && objArr.length != 0 && (c = c(str)) != null && c.k()) {
            s sVar = new s(str);
            sVar.a(objArr);
            c.a(sVar);
        }
    }

    public void a(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && NetworkChangeReceiver.WIFI_STRING.equals(this.q))) {
            a("img", str, str2, str3, j, j2, j3, j4, j5, i, i2, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        a("d", str, str2, str3, j, j2, j3, j4, j5, i, i2, str4, objArr);
    }

    public void a(String str, String str2, String str3, String str4, long j, long j2, long j3, long j4, long j5, int i, int i2, String str5, Object... objArr) {
        f c = c("net");
        if (c != null && c.k() && c.d(str) && !o.a().a("net")) {
            s sVar = new s("net");
            sVar.a("module", "net", "st", str, "net", this.q, "interface", str2, "cost", Long.valueOf(j3), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                sVar.a(objArr);
            }
            if (i2 != 0) {
                sVar.a("result", Integer.valueOf(i2));
                sVar.a((Object) "es", (Object) str5);
            }
            if (j4 > 0) {
                sVar.a(TiebaStatic.CON_COST, Long.valueOf(j4));
            }
            if (j2 > 0) {
                sVar.a("size_u", Long.valueOf(j2));
            }
            if (j > 0) {
                sVar.a("size_d", Long.valueOf(j));
            }
            if (j5 > 0) {
                sVar.a("rsp_cost", Long.valueOf(j5));
            }
            if (!TextUtils.isEmpty(str3)) {
                sVar.a((Object) "sid", (Object) str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                sVar.a((Object) "f", (Object) str4);
            }
            if (i > 0) {
                sVar.a("retry", Integer.valueOf(i));
            }
            c.a(sVar);
        }
    }

    public void a(String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        a(true, "d", str, str2, str3, j, i, str4, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, String str4, long j, int i, String str5, Object... objArr) {
        f c = c("op");
        if (c != null && c.k() && c.d(str)) {
            if (!z || !o.a().a("op")) {
                s sVar = new s("op");
                sVar.a("module", "op", "st", str, "op_key", str2, "sid", str3, "f", str4, "cost", Long.valueOf(j), "result", Integer.valueOf(i), "es", str5, "t", String.valueOf(System.currentTimeMillis()));
                if (objArr != null && objArr.length > 0) {
                    sVar.a(objArr);
                }
                c.a(sVar);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5, Object... objArr) {
        a(true, str, str2, str3, str4, 0L, i, str5, objArr);
    }

    public void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!o.a().a("file")) {
            a(true, "file", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!o.a().a("db")) {
            a(true, "db", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!o.a().a("voice")) {
            a(true, "voice", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void d(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!o.a().a("live")) {
            a(true, "live", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        f c = c("crash");
        if (c != null && c.k()) {
            s sVar = new s("crash");
            sVar.a("module", "crash", "crash_type", str, "ci", str2, "f", str3, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                sVar.a(objArr);
            }
            c.a(sVar);
        }
    }

    public void b(String str, Object... objArr) {
        f c = c("dbg");
        if (c != null && c.k() && c.d(str)) {
            s sVar = new s("dbg");
            sVar.a("module", "dbg", "st", str, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                sVar.a(objArr);
            }
            c.a(sVar);
        }
    }

    public void a(String str, s sVar) {
        f c = c("dbg");
        if (sVar != null && c != null && c.k() && c.d(str)) {
            sVar.a("module", "dbg");
            sVar.a("st", str);
            sVar.a("t", String.valueOf(System.currentTimeMillis()));
            c.a(sVar);
        }
    }

    public void a(Context context, String str, String str2, int i, Object... objArr) {
        f c = c("stat");
        if (c != null && c.k()) {
            s sVar = new s("stat");
            sVar.a("module", "stat", "op_key", str, "pt", str2, "co", Integer.valueOf(i), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                sVar.a(objArr);
                sVar.a((Object) "mi", (Object) 0);
            }
            c.a(sVar);
        }
    }

    public void d() {
        if (this.s != null) {
            this.v.sendMessage(this.v.obtainMessage(1, 1, 0, this.s));
        }
        if (this.u != null) {
            this.v.sendMessage(this.v.obtainMessage(1, 1, 0, this.u));
        }
        if (this.t != null) {
            this.v.sendMessage(this.v.obtainMessage(1, 1, 0, this.t));
        }
    }

    public void h() {
        String b = n.a().b();
        if (!com.baidu.adp.lib.util.j.b(b)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.setAppVersion(this.e);
            bdStatSwitchData.parserJson(b);
            a(bdStatSwitchData);
        }
        if (this.s != null) {
            long b2 = n.a().b(this.g);
            if (b2 <= 0) {
                b2 = System.currentTimeMillis();
                n.a().a(b2, this.g);
            }
            this.s.a(b2);
        }
        if (this.u != null) {
            long d = n.a().d(this.g);
            if (d <= 0) {
                d = System.currentTimeMillis();
                n.a().c(d, this.g);
            }
            this.u.a(d);
        }
        if (this.t != null) {
            long c = n.a().c(this.g);
            if (c <= 0) {
                c = System.currentTimeMillis();
                n.a().b(c, this.g);
            }
            this.t.a(c);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.setAppVersion(this.e);
            bdStatSwitchData.parserJson(str);
            if (bdStatSwitchData.getError_code() == 0) {
                a(bdStatSwitchData);
                n.a().a(str);
                if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                    this.t.e();
                }
                if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                    this.u.e();
                }
                if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                    this.s.e();
                }
                k();
            }
        }
    }

    public String i() {
        try {
        } catch (Exception e) {
            BdLog.e(getClass(), "loadSwitchDataFromNet", e);
        }
        if (this.x.inSpecStrategy()) {
            return null;
        }
        com.baidu.adp.lib.network.willdelete.f a2 = com.baidu.adp.lib.network.willdelete.e.a().a(this.p, 3, -1, 30000, null, null, null);
        if (a2 != null) {
            return new String(a2.d, "utf-8");
        }
        return null;
    }

    private void a(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            synchronized (BdStatSwitchData.class) {
                this.x = bdStatSwitchData;
                if (this.x.getError() != null && this.u != null) {
                    this.u.a(this.x.getError());
                }
                if (this.x.getStat() != null && this.s != null) {
                    this.s.a(this.x.getStat());
                }
                if (this.x.getDebug() != null && this.t != null) {
                    this.t.a(this.x.getDebug());
                }
            }
        }
    }

    public void b(f fVar) {
        String a2;
        ArrayList<String> a3;
        if (fVar != null && !fVar.j() && fVar.k()) {
            fVar.e(true);
            try {
                if (fVar.c() != null && fVar.c().equals("omp")) {
                    a2 = j();
                } else {
                    a2 = a(true);
                }
                if (fVar.d()) {
                    ArrayList<String> m = fVar.m();
                    fVar.n();
                    ArrayList<String> a4 = fVar.a(m);
                    if (a4 != null && a4.size() > 0) {
                        a(fVar, a2, a4, (String) null);
                    }
                } else {
                    ArrayList<String> f = fVar.f();
                    if (f != null && f.size() > 0) {
                        Iterator<String> it = f.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!TextUtils.isEmpty(next) && (a3 = fVar.a(fVar.c(next))) != null && a3.size() != 0) {
                                a(fVar, a2, a3, next);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(getClass(), "upload", e);
            }
            fVar.e(false);
            fVar.b(this.g);
        }
    }

    private void a(f fVar, String str, ArrayList<String> arrayList, String str2) {
        byte[] a2;
        if (fVar != null && (a2 = a(str, arrayList)) != null && a2.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a2.length / 2);
            try {
                com.baidu.adp.lib.util.e.a(a2, byteArrayOutputStream);
            } catch (Exception e) {
                BdLog.e(getClass(), "compressAndUpload", e);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put(fVar.c(), byteArray);
            try {
                ArrayList<BasicNameValuePair> arrayList2 = new ArrayList<>();
                arrayList2.add(new BasicNameValuePair("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT));
                arrayList2.add(new BasicNameValuePair("_client_version", this.e));
                arrayList2.add(new BasicNameValuePair("_phone_imei", this.l));
                arrayList2.add(new BasicNameValuePair("_client_id", this.j));
                arrayList2.add(new BasicNameValuePair("from", this.f));
                arrayList2.add(new BasicNameValuePair("net_type", this.r));
                arrayList2.add(new BasicNameValuePair("cuid", this.k));
                arrayList2.add(new BasicNameValuePair("model", this.m));
                if (TextUtils.isEmpty(this.g)) {
                    arrayList2.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, "0"));
                } else {
                    arrayList2.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, this.g));
                }
                arrayList2.add(new BasicNameValuePair("un", this.h));
                arrayList2.add(new BasicNameValuePair("BDUSS", this.i));
                com.baidu.adp.lib.network.willdelete.f a3 = com.baidu.adp.lib.network.willdelete.e.a().a(this.o, false, arrayList2, hashMap, 3, -1, null, null, null, null);
                if (a3 != null && a3.a == 200) {
                    try {
                        if (new JSONObject(new String(a3.d, "utf-8")).optInt("error_code", -1) == 0) {
                            fVar.a(str2);
                        }
                    } catch (Exception e2) {
                        BdLog.e(getClass(), "compressAndUpload", e2);
                    }
                }
            } catch (Exception e3) {
                BdLog.e(getClass(), "compressAndUpload", e3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(boolean z) {
        String str;
        String[] split;
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = this.e;
        if (!TextUtils.isEmpty(str2)) {
            if (str2.split("\\.").length == 4) {
                str = String.valueOf(split[0]) + "." + split[1] + "." + split[2];
                try {
                    StringBuilder append = sb.append("&").append("new_four_version").append("=");
                    if (z) {
                        str2 = URLEncoder.encode(str2, "utf-8");
                    }
                    append.append(str2);
                } catch (UnsupportedEncodingException e) {
                    BdLog.e(getClass(), "generalStatCommonPostdata", e);
                }
                a(sb, "_client_version", str, z);
                a(sb, "_phone_imei", this.l, z);
                a(sb, "_client_id", this.j, z);
                a(sb, "from", this.f, z);
                a(sb, "net_type", this.r, z);
                a(sb, "cuid", this.k, z);
                a(sb, "model", this.m, z);
                if (!TextUtils.isEmpty(this.g)) {
                    a(sb, SapiAccountManager.SESSION_UID, "0", z);
                } else {
                    a(sb, SapiAccountManager.SESSION_UID, this.g, z);
                }
                a(sb, "un", this.h, z);
                a(sb, "BDUSS", this.i, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.l, z);
        a(sb, "_client_id", this.j, z);
        a(sb, "from", this.f, z);
        a(sb, "net_type", this.r, z);
        a(sb, "cuid", this.k, z);
        a(sb, "model", this.m, z);
        if (!TextUtils.isEmpty(this.g)) {
        }
        a(sb, "un", this.h, z);
        a(sb, "BDUSS", this.i, z);
        return sb.toString();
    }

    private void a(StringBuilder sb, String str, String str2, boolean z) {
        if (sb != null && !TextUtils.isEmpty(str)) {
            try {
                String str3 = TextUtils.isEmpty(str2) ? "" : str2;
                StringBuilder append = sb.append("&").append(str).append("=");
                if (z) {
                    str3 = URLEncoder.encode(str3, "utf-8");
                }
                append.append(str3);
            } catch (Exception e) {
                BdLog.e(getClass(), "AppendParam", e);
            }
        }
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(this.c, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(this.d, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.e, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.n, "utf-8"));
            if (!TextUtils.isEmpty(this.f)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(this.f, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.m, "utf-8"));
            if (!TextUtils.isEmpty(this.g)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.g, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.j)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(this.j, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.l)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.l, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.h)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(this.h, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.k)) {
                sb.append("&");
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(this.k, "utf-8"));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
            sb.append(URLEncoder.encode(this.q, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            BdLog.e(getClass(), "generalCommonPostdata", e);
        }
        return sb.toString();
    }

    private byte[] a(String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sb.append("&rec");
                sb.append(i);
                sb.append('=');
                try {
                    sb.append(URLEncoder.encode(arrayList.get(i), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    BdLog.e(getClass(), "generatePostdata", e);
                }
            }
            return sb.toString().getBytes();
        } catch (Exception e2) {
            BdLog.e(getClass(), "generatePostdata", e2);
            return null;
        }
    }

    private f c(String str) {
        if (this.u != null && (str.equals("net") || str.equals("op") || str.equals("crash"))) {
            return this.u;
        }
        if (this.t != null && str.equals("dbg")) {
            return this.t;
        }
        if (this.s != null && str.equals("stat")) {
            return this.s;
        }
        return this.u;
    }

    private void b(f fVar, boolean z) {
        if (fVar != null && !fVar.j()) {
            fVar.c(z);
            if (fVar.h() == null) {
                if (this.g != null) {
                    fVar.b(this.g);
                }
            } else if (!fVar.h().equals(this.g)) {
                fVar.b(this.g);
            }
        }
    }

    public long e() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.x == null) {
                this.x = new BdStatSwitchData();
            }
            uploadMilliInterval = this.x.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }

    public void k() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.x == null) {
                this.x = new BdStatSwitchData();
            }
            uploadMilliInterval = this.x.getUploadMilliInterval();
        }
        this.v.removeMessages(2);
        this.v.sendMessageDelayed(this.v.obtainMessage(2), uploadMilliInterval);
    }

    public void a(f fVar, boolean z, boolean z2) {
        if (fVar != null) {
            this.v.sendMessage(this.v.obtainMessage(1, z ? 1 : 0, z2 ? 1 : 0, fVar));
        }
    }

    public void b(f fVar, boolean z, boolean z2) {
        if (!z) {
            try {
                if (!fVar.a(z)) {
                    return;
                }
            } catch (Exception e) {
                return;
            }
        }
        b(fVar, z2);
    }

    public void a(f fVar, boolean z) {
        if (fVar != null) {
            this.v.sendMessage(this.v.obtainMessage(3, z ? 1 : 0, 0, fVar));
        }
    }

    public void c(f fVar, boolean z) {
        try {
            fVar.b(z);
        } catch (Exception e) {
        }
    }

    public void a(f fVar) {
        this.v.sendMessage(this.v.obtainMessage(4, fVar));
    }

    public void c(f fVar) {
        try {
            new m(this, fVar).execute(new Object[0]);
        } catch (Exception e) {
        }
    }
}
