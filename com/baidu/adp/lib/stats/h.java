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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private static h b;
    private j A;
    private Context c;
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
    private String q;
    private l z;
    private String r = null;
    private String s = null;
    private g t = null;
    private a u = null;
    private b v = null;
    private Handler w = null;
    private BdAsyncTaskParallel x = null;
    private BdStatSwitchData y = null;
    SimpleDateFormat a = new SimpleDateFormat("yy-MM-dd_HH-mm-ss");

    public static h a() {
        synchronized (h.class) {
            if (b == null) {
                b = new h();
            }
        }
        return b;
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.c = context;
        this.p = str;
        this.q = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.k = str7;
        this.l = str8;
        this.n = Build.MODEL;
        this.o = Build.VERSION.RELEASE;
        this.m = str9;
        if (this.z == null && context != null) {
            try {
                this.z = new l(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.z, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.A == null && context != null) {
            this.A = new j(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager2.account_changed");
            context.registerReceiver(this.A, intentFilter2);
        }
        if (TextUtils.isEmpty(str10)) {
            str10 = TbConfig.TMP_LOG_DIR_NAME;
        }
        if (this.w == null) {
            this.w = new i(this);
        }
        this.y = new BdStatSwitchData();
        if (this.t == null) {
            this.t = new g(context, str10);
        }
        if (this.u == null) {
            this.u = new a(context, str10);
        }
        if (this.v == null) {
            this.v = new b(context, str10);
        }
        a(this.y);
        g();
    }

    public String b() {
        return this.m;
    }

    private void g() {
        new k(this, true).execute(new Object[0]);
    }

    public String c() {
        return r.a(this.c);
    }

    public void h() {
        this.r = r.a(this.c);
        this.s = r.b(this.c);
        if (com.baidu.adp.lib.network.willdelete.h.b()) {
            boolean a = com.baidu.adp.lib.network.willdelete.h.a();
            if (this.t != null) {
                this.t.d(a);
            }
            if (this.u != null) {
                this.u.d(a);
            }
            if (this.v != null) {
                this.v.d(a);
            }
        }
    }

    public String d() {
        return this.r;
    }

    public s a(String str) {
        return new s(str);
    }

    public synchronized void a(String str, String str2, String str3) {
        if ((this.h != null || str != null) && (this.h == null || !this.h.equals(str))) {
            this.h = str;
            this.i = str2;
            this.j = str3;
            e();
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
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && NetworkChangeReceiver.WIFI_STRING.equals(this.r))) {
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
            sVar.a("module", "net", "st", str, "net", this.r, "interface", str2, "cost", Long.valueOf(j3), "t", String.valueOf(System.currentTimeMillis()));
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
            sVar.a("module", "dbg", "st", str, "t", this.a.format(new Date()));
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
            sVar.a("t", this.a.format(new Date()));
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

    public void e() {
        if (this.t != null) {
            this.w.sendMessage(this.w.obtainMessage(1, 1, 0, this.t));
        }
        if (this.v != null) {
            this.w.sendMessage(this.w.obtainMessage(1, 1, 0, this.v));
        }
        if (this.u != null) {
            this.w.sendMessage(this.w.obtainMessage(1, 1, 0, this.u));
        }
    }

    public void i() {
        String b2 = n.a().b();
        if (!com.baidu.adp.lib.util.j.b(b2)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.setAppVersion(this.f);
            bdStatSwitchData.parserJson(b2);
            a(bdStatSwitchData);
        }
        if (this.t != null) {
            long b3 = n.a().b(this.h);
            if (b3 <= 0) {
                b3 = System.currentTimeMillis();
                n.a().a(b3, this.h);
            }
            this.t.a(b3);
        }
        if (this.v != null) {
            long d = n.a().d(this.h);
            if (d <= 0) {
                d = System.currentTimeMillis();
                n.a().c(d, this.h);
            }
            this.v.a(d);
        }
        if (this.u != null) {
            long c = n.a().c(this.h);
            if (c <= 0) {
                c = System.currentTimeMillis();
                n.a().b(c, this.h);
            }
            this.u.a(c);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.setAppVersion(this.f);
            bdStatSwitchData.parserJson(str);
            if (bdStatSwitchData.getError_code() == 0) {
                a(bdStatSwitchData);
                n.a().a(str);
                if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                    this.u.e();
                }
                if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                    this.v.e();
                }
                if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                    this.t.e();
                }
                l();
            }
        }
    }

    public String j() {
        try {
        } catch (Exception e) {
            BdLog.e(getClass(), "loadSwitchDataFromNet", e);
        }
        if (this.y.inSpecStrategy()) {
            return null;
        }
        com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.a().a(String.valueOf(this.q) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, null, null, null);
        if (a != null) {
            return new String(a.d, "utf-8");
        }
        return null;
    }

    private void a(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            synchronized (BdStatSwitchData.class) {
                this.y = bdStatSwitchData;
                if (this.y.getError() != null && this.v != null) {
                    this.v.a(this.y.getError());
                }
                if (this.y.getStat() != null && this.t != null) {
                    this.t.a(this.y.getStat());
                }
                if (this.y.getDebug() != null && this.u != null) {
                    this.u.a(this.y.getDebug());
                }
            }
        }
    }

    public void b(f fVar) {
        String a;
        ArrayList<String> a2;
        if (fVar != null && !fVar.j() && fVar.k()) {
            fVar.e(true);
            try {
                if (fVar.c() != null && fVar.c().equals("omp")) {
                    a = k();
                } else {
                    a = a(true);
                }
                if (fVar.d()) {
                    ArrayList<String> m = fVar.m();
                    fVar.n();
                    ArrayList<String> a3 = fVar.a(m);
                    if (a3 != null && a3.size() > 0) {
                        a(fVar, a, a3, (String) null);
                    }
                } else {
                    ArrayList<String> f = fVar.f();
                    if (f != null && f.size() > 0) {
                        Iterator<String> it = f.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!TextUtils.isEmpty(next) && (a2 = fVar.a(fVar.c(next))) != null && a2.size() != 0) {
                                a(fVar, a, a2, next);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(getClass(), "upload", e);
            }
            fVar.e(false);
            fVar.b(this.h);
        }
    }

    private void a(f fVar, String str, ArrayList<String> arrayList, String str2) {
        byte[] a;
        if (fVar != null && (a = a(str, arrayList)) != null && a.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a.length / 2);
            try {
                com.baidu.adp.lib.util.e.a(a, byteArrayOutputStream);
            } catch (Exception e) {
                BdLog.e(getClass(), "compressAndUpload", e);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put(fVar.c(), byteArray);
            try {
                ArrayList<BasicNameValuePair> arrayList2 = new ArrayList<>();
                arrayList2.add(new BasicNameValuePair("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT));
                arrayList2.add(new BasicNameValuePair("_client_version", this.f));
                arrayList2.add(new BasicNameValuePair("_phone_imei", this.m));
                arrayList2.add(new BasicNameValuePair("_client_id", this.k));
                arrayList2.add(new BasicNameValuePair("from", this.g));
                arrayList2.add(new BasicNameValuePair("net_type", this.s));
                arrayList2.add(new BasicNameValuePair("cuid", this.l));
                arrayList2.add(new BasicNameValuePair("model", this.n));
                if (TextUtils.isEmpty(this.h)) {
                    arrayList2.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, "0"));
                } else {
                    arrayList2.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, this.h));
                }
                arrayList2.add(new BasicNameValuePair("un", this.i));
                arrayList2.add(new BasicNameValuePair("BDUSS", this.j));
                com.baidu.adp.lib.network.willdelete.f a2 = com.baidu.adp.lib.network.willdelete.e.a().a(this.p, false, arrayList2, hashMap, 3, -1, null, null, null, null);
                if (a2 != null && a2.a == 200) {
                    try {
                        if (new JSONObject(new String(a2.d, "utf-8")).optInt("error_code", -1) == 0) {
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
        String str2 = this.f;
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
                a(sb, "_phone_imei", this.m, z);
                a(sb, "_client_id", this.k, z);
                a(sb, "from", this.g, z);
                a(sb, "net_type", this.s, z);
                a(sb, "cuid", this.l, z);
                a(sb, "model", this.n, z);
                if (!TextUtils.isEmpty(this.h)) {
                    a(sb, SapiAccountManager.SESSION_UID, "0", z);
                } else {
                    a(sb, SapiAccountManager.SESSION_UID, this.h, z);
                }
                a(sb, "un", this.i, z);
                a(sb, "BDUSS", this.j, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.m, z);
        a(sb, "_client_id", this.k, z);
        a(sb, "from", this.g, z);
        a(sb, "net_type", this.s, z);
        a(sb, "cuid", this.l, z);
        a(sb, "model", this.n, z);
        if (!TextUtils.isEmpty(this.h)) {
        }
        a(sb, "un", this.i, z);
        a(sb, "BDUSS", this.j, z);
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

    private String k() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(this.d, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(this.e, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.f, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.o, "utf-8"));
            if (!TextUtils.isEmpty(this.g)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(this.g, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.n, "utf-8"));
            if (!TextUtils.isEmpty(this.h)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.h, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.k)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(this.k, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.m)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.m, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.i)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(this.i, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.l)) {
                sb.append("&");
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(this.l, "utf-8"));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
            sb.append(URLEncoder.encode(this.r, "utf-8"));
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
        if (this.v != null && (str.equals("net") || str.equals("op") || str.equals("crash"))) {
            return this.v;
        }
        if (this.u != null && str.equals("dbg")) {
            return this.u;
        }
        if (this.t != null && str.equals("stat")) {
            return this.t;
        }
        return this.v;
    }

    private void b(f fVar, boolean z) {
        if (fVar != null && !fVar.j()) {
            fVar.c(z);
            if (fVar.h() == null) {
                if (this.h != null) {
                    fVar.b(this.h);
                }
            } else if (!fVar.h().equals(this.h)) {
                fVar.b(this.h);
            }
        }
    }

    public long f() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.y == null) {
                this.y = new BdStatSwitchData();
            }
            uploadMilliInterval = this.y.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }

    public void l() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.y == null) {
                this.y = new BdStatSwitchData();
            }
            uploadMilliInterval = this.y.getUploadMilliInterval();
        }
        this.w.removeMessages(2);
        this.w.sendMessageDelayed(this.w.obtainMessage(2), uploadMilliInterval);
    }

    public void a(f fVar, boolean z, boolean z2) {
        if (fVar != null) {
            this.w.sendMessage(this.w.obtainMessage(1, z ? 1 : 0, z2 ? 1 : 0, fVar));
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
            this.w.sendMessage(this.w.obtainMessage(3, z ? 1 : 0, 0, fVar));
        }
    }

    public void c(f fVar, boolean z) {
        try {
            fVar.b(z);
        } catch (Exception e) {
        }
    }

    public void a(f fVar) {
        this.w.sendMessage(this.w.obtainMessage(4, fVar));
    }

    public void c(f fVar) {
        try {
            new m(this, fVar).execute(new Object[0]);
        } catch (Exception e) {
        }
    }
}
