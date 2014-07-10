package com.baidu.adp.lib.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static d b;
    private i A;
    private f B;
    private h C;
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
    private String r = null;
    private String s = null;
    private p t = null;
    private boolean u = false;
    private BdStatLog v = null;
    private BdDebugLog w = null;
    private BdErrorLog x = null;
    private Handler y = null;
    private BdStatSwitchData z = null;
    private BdAsyncTaskParallel D = null;
    @SuppressLint({"SimpleDateFormat"})
    SimpleDateFormat a = new SimpleDateFormat("yy-MM-dd_HH-mm-ss");

    public p a() {
        return this.t;
    }

    public static d b() {
        synchronized (d.class) {
            if (b == null) {
                b = new d();
            }
        }
        return b;
    }

    @SuppressLint({"HandlerLeak"})
    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, p pVar, boolean z) {
        this.c = context;
        this.m = str;
        this.n = str2;
        this.d = str3;
        this.e = str4;
        this.o = str5;
        this.f = str6;
        this.i = str7;
        this.j = str8;
        this.k = Build.MODEL;
        this.l = Build.VERSION.RELEASE;
        this.q = str9;
        this.t = pVar;
        this.u = z;
        if (this.A == null && context != null) {
            try {
                this.A = new i(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.A, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.B == null && context != null) {
            this.B = new f(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager2.account_changed");
            context.registerReceiver(this.B, intentFilter2);
        }
        if (this.C == null && context != null) {
            this.C = new h(this, null);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("adp.bdstatisticsmanager2.multiprocess");
            context.registerReceiver(this.C, intentFilter3);
        }
        if (TextUtils.isEmpty(str10)) {
            str10 = "stat";
        }
        if (this.y == null) {
            this.y = new e(this);
        }
        this.z = new BdStatSwitchData();
        if (this.v == null) {
            this.v = new BdStatLog(context, str10, this.u);
        }
        if (this.w == null) {
            this.w = new BdDebugLog(context, str10, this.u);
        }
        if (this.x == null) {
            this.x = new BdErrorLog(context, str10, this.u);
        }
        b(this.z);
        i();
        if (TextUtils.isEmpty(BdStatBase.mProcessNameMd5)) {
            b().a(this.c, "logpnmd5", null, 1, new Object[0]);
        }
    }

    public String c() {
        return this.q;
    }

    public void i() {
        new g(this, true).execute(new Object[0]);
    }

    public String d() {
        return n.a(this.c);
    }

    public void j() {
        this.r = n.a(this.c);
        this.s = n.b(this.c);
        if (com.baidu.adp.lib.network.willdelete.h.b()) {
            boolean a = com.baidu.adp.lib.network.willdelete.h.a();
            if (this.v != null) {
                this.v.setmIsNetworkWifi(a);
            }
            if (this.w != null) {
                this.w.setmIsNetworkWifi(a);
            }
            if (this.x != null) {
                this.x.setmIsNetworkWifi(a);
            }
        }
    }

    public String e() {
        return this.r;
    }

    public o a(String str) {
        return new o(str);
    }

    public synchronized void a(String str, String str2, String str3) {
        if ((this.p != null || str != null) && (this.p == null || !this.p.equals(str))) {
            this.p = str;
            this.g = str2;
            this.h = str3;
            f();
        }
    }

    public void a(String str, Object... objArr) {
        BdStatBase c;
        if (!TextUtils.isEmpty(str) && objArr != null && objArr.length != 0 && (c = c(str)) != null && c.ismIsLogOpen()) {
            o oVar = new o(str);
            oVar.a(objArr);
            c.add(oVar);
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
        BdStatBase c = c("net");
        if (c != null && c.ismIsLogOpen() && c.isSubTypeOpen(str) && !k.a().a("net")) {
            o oVar = new o("net");
            oVar.a("module", "net", "st", str, "net", this.r, "interface", str2, "cost", Long.valueOf(j3), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                oVar.a(objArr);
            }
            if (i2 != 0) {
                oVar.a("result", Integer.valueOf(i2));
                oVar.a((Object) "es", (Object) str5);
            }
            if (j4 > 0) {
                oVar.a(TiebaStatic.CON_COST, Long.valueOf(j4));
            }
            if (j2 > 0) {
                oVar.a("size_u", Long.valueOf(j2));
            }
            if (j > 0) {
                oVar.a("size_d", Long.valueOf(j));
            }
            if (j5 > 0) {
                oVar.a("rsp_cost", Long.valueOf(j5));
            }
            if (!TextUtils.isEmpty(str3)) {
                oVar.a((Object) "sid", (Object) str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                oVar.a((Object) "f", (Object) str4);
            }
            if (i > 0) {
                oVar.a("retry", Integer.valueOf(i));
            }
            c.add(oVar);
        }
    }

    public void a(String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        a(true, "d", str, str2, str3, j, i, str4, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, String str4, long j, int i, String str5, Object... objArr) {
        BdStatBase c = c("op");
        if (c != null && c.ismIsLogOpen() && c.isSubTypeOpen(str)) {
            if (!z || !k.a().a("op")) {
                o oVar = new o("op");
                oVar.a("module", "op", "st", str, "op_key", str2, "sid", str3, "f", str4, "cost", Long.valueOf(j), "result", Integer.valueOf(i), "es", str5, "t", String.valueOf(System.currentTimeMillis()));
                if (objArr != null && objArr.length > 0) {
                    oVar.a(objArr);
                }
                c.add(oVar);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5, Object... objArr) {
        a(true, str, str2, str3, str4, 0L, i, str5, objArr);
    }

    public void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!k.a().a("file")) {
            a(true, "file", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!k.a().a("db")) {
            a(true, "db", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!k.a().a("voice")) {
            a(true, "voice", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void d(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!k.a().a("live")) {
            a(true, "live", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        BdStatBase c = c("crash");
        if (c != null && c.ismIsLogOpen()) {
            o oVar = new o("crash");
            oVar.a("module", "crash", "crash_type", str, "ci", str2, "f", str3, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                oVar.a(objArr);
            }
            c.add(oVar);
        }
    }

    public void b(String str, Object... objArr) {
        BdStatBase c = c("dbg");
        if (c != null && c.ismIsLogOpen() && c.isSubTypeOpen(str)) {
            o oVar = new o("dbg");
            oVar.a("module", "dbg", "st", str, "t", this.a.format(new Date()));
            if (objArr != null && objArr.length > 0) {
                oVar.a(objArr);
            }
            c.add(oVar);
        }
    }

    public void a(String str, o oVar) {
        BdStatBase c = c("dbg");
        if (oVar != null && c != null && c.ismIsLogOpen() && c.isSubTypeOpen(str)) {
            oVar.a("module", "dbg");
            oVar.a("st", str);
            oVar.a("t", this.a.format(new Date()));
            c.add(oVar);
        }
    }

    public void a(Context context, String str, String str2, int i, Object... objArr) {
        BdStatBase c = c("stat");
        if (c != null && c.ismIsLogOpen()) {
            o oVar = new o("stat");
            oVar.a("module", "stat", "op_key", str, "pt", str2, "co", Integer.valueOf(i), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                oVar.a(objArr);
                oVar.a((Object) "mi", (Object) 0);
            }
            c.add(oVar);
        }
    }

    public void f() {
        if (this.v != null) {
            this.y.sendMessage(this.y.obtainMessage(1, 1, 0, this.v));
        }
        if (this.x != null) {
            this.y.sendMessage(this.y.obtainMessage(1, 1, 0, this.x));
        }
        if (this.w != null) {
            this.y.sendMessage(this.y.obtainMessage(1, 1, 0, this.w));
        }
    }

    public void k() {
        String a = this.t.a();
        if (!com.baidu.adp.lib.util.i.b(a)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.setAppVersion(this.o);
            bdStatSwitchData.parserJson(a);
            b(bdStatSwitchData);
        }
        if (this.v != null) {
            long b2 = this.t.b();
            if (b2 <= 0) {
                b2 = System.currentTimeMillis();
                this.t.a(b2);
            }
            this.v.setmLastUploadTime(b2);
        }
        if (this.x != null) {
            long d = this.t.d();
            if (d <= 0) {
                d = System.currentTimeMillis();
                this.t.c(d);
            }
            this.x.setmLastUploadTime(d);
        }
        if (this.w != null) {
            long c = this.t.c();
            if (c <= 0) {
                c = System.currentTimeMillis();
                this.t.b(c);
            }
            this.w.setmLastUploadTime(c);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(str);
            a(bdStatSwitchData);
        }
    }

    public void a(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            bdStatSwitchData.setAppVersion(this.o);
            if (bdStatSwitchData.getError_code() == 0) {
                b(bdStatSwitchData);
                this.t.a(bdStatSwitchData.getmData());
                if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                    this.w.clearLogs();
                }
                if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                    this.x.clearLogs();
                }
                if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                    this.v.clearLogs();
                }
                m();
            }
        }
    }

    public String l() {
        try {
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.z.inSpecStrategy()) {
            return null;
        }
        com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.a().a(String.valueOf(this.n) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, null, null, null);
        if (a != null) {
            return new String(a.d, "utf-8");
        }
        return null;
    }

    private void b(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            synchronized (BdStatSwitchData.class) {
                this.z = bdStatSwitchData;
                if (this.z.getError() != null && this.x != null) {
                    this.x.setSwitchData(this.z.getError());
                }
                if (this.z.getStat() != null && this.v != null) {
                    this.v.setSwitchData(this.z.getStat());
                }
                if (this.z.getDebug() != null && this.w != null) {
                    this.w.setSwitchData(this.z.getDebug());
                }
            }
        }
    }

    private BdStatBase c(String str) {
        if (this.x != null && (str.equals("net") || str.equals("op") || str.equals("crash"))) {
            return this.x;
        }
        if (this.w != null && str.equals("dbg")) {
            return this.w;
        }
        if (this.v != null && str.equals("stat")) {
            return this.v;
        }
        return this.x;
    }

    private void b(BdStatBase bdStatBase, boolean z) {
        if (bdStatBase != null && !bdStatBase.ismIsUploading()) {
            bdStatBase.refreshFile(z);
            if (bdStatBase.getmUid() == null) {
                if (this.p != null) {
                    bdStatBase.changeUser(this.p);
                }
            } else if (!bdStatBase.getmUid().equals(this.p)) {
                bdStatBase.changeUser(this.p);
            }
        }
    }

    public long g() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.z == null) {
                this.z = new BdStatSwitchData();
            }
            uploadMilliInterval = this.z.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }

    public void m() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.z == null) {
                this.z = new BdStatSwitchData();
            }
            uploadMilliInterval = this.z.getUploadMilliInterval();
        }
        this.y.removeMessages(2);
        this.y.sendMessageDelayed(this.y.obtainMessage(2), uploadMilliInterval);
    }

    public void a(BdStatBase bdStatBase, boolean z, boolean z2) {
        if (bdStatBase != null) {
            this.y.sendMessage(this.y.obtainMessage(1, z ? 1 : 0, z2 ? 1 : 0, bdStatBase));
        }
    }

    public void b(BdStatBase bdStatBase, boolean z, boolean z2) {
        if (!z) {
            try {
                if (!bdStatBase.checkToSendSaveMessage(z)) {
                    return;
                }
            } catch (Exception e) {
                return;
            }
        }
        b(bdStatBase, z2);
    }

    public void a(BdStatBase bdStatBase, boolean z) {
        if (bdStatBase != null) {
            this.y.sendMessage(this.y.obtainMessage(3, z ? 1 : 0, 0, bdStatBase));
        }
    }

    public void c(BdStatBase bdStatBase, boolean z) {
        try {
            bdStatBase.checkToSendUploadMessage(z);
        } catch (Exception e) {
        }
    }

    public void a(BdStatBase bdStatBase) {
        this.y.sendMessage(this.y.obtainMessage(4, bdStatBase));
    }

    public void b(BdStatBase bdStatBase) {
        if (this.u) {
            new j(this, bdStatBase).execute(new Object[0]);
        }
        if (!this.u && !this.z.inSpecStrategy() && this.z.getSpecifiedExpired() > 0) {
            new g(this, false).execute(new Object[0]);
        }
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
                BdLog.e(e);
            }
        }
    }

    private String n() {
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
            sb.append(URLEncoder.encode(this.o, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.l, "utf-8"));
            if (!TextUtils.isEmpty(this.f)) {
                sb.append("&");
                sb.append(com.baidu.tbadk.core.frameworkData.a.FROM);
                sb.append("=");
                sb.append(URLEncoder.encode(this.f, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.k, "utf-8"));
            if (!TextUtils.isEmpty(this.p)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.p, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.i)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(this.i, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.q)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.q, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.g)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(this.g, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.j)) {
                sb.append("&");
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(this.j, "utf-8"));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
            sb.append(URLEncoder.encode(this.r, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            BdLog.e(e);
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
                    BdLog.e(e);
                }
            }
            return sb.toString().getBytes();
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(boolean z) {
        String str;
        String[] split;
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = this.o;
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
                    BdLog.e(e);
                }
                a(sb, "_client_version", str, z);
                a(sb, "_phone_imei", this.q, z);
                a(sb, "_client_id", this.i, z);
                a(sb, com.baidu.tbadk.core.frameworkData.a.FROM, this.f, z);
                a(sb, "net_type", this.s, z);
                a(sb, "cuid", this.j, z);
                a(sb, "model", this.k, z);
                if (!TextUtils.isEmpty(this.p)) {
                    a(sb, SapiAccountManager.SESSION_UID, "0", z);
                } else {
                    a(sb, SapiAccountManager.SESSION_UID, this.p, z);
                }
                a(sb, "un", this.g, z);
                a(sb, "BDUSS", this.h, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.q, z);
        a(sb, "_client_id", this.i, z);
        a(sb, com.baidu.tbadk.core.frameworkData.a.FROM, this.f, z);
        a(sb, "net_type", this.s, z);
        a(sb, "cuid", this.j, z);
        a(sb, "model", this.k, z);
        if (!TextUtils.isEmpty(this.p)) {
        }
        a(sb, "un", this.g, z);
        a(sb, "BDUSS", this.h, z);
        return sb.toString();
    }

    public void c(BdStatBase bdStatBase) {
        String a;
        if (bdStatBase != null && !bdStatBase.ismIsUploading() && bdStatBase.ismIsLogOpen()) {
            bdStatBase.setmIsUploading(true);
            try {
                if (bdStatBase.getPostFileName() != null && bdStatBase.getPostFileName().equals("omp")) {
                    a = n();
                } else {
                    a = a(true);
                }
                if (bdStatBase.checkFileFailed()) {
                    ArrayList<String> memData = bdStatBase.getMemData();
                    bdStatBase.clearMemData();
                    ArrayList<String> filter = bdStatBase.filter(memData);
                    if (filter != null && filter.size() > 0) {
                        a(bdStatBase, a, filter, (ArrayList<q>) null);
                    }
                } else {
                    BdUploadingLogInfo logFiles = bdStatBase.getLogFiles();
                    int size = logFiles.size();
                    if (logFiles != null && size > 0) {
                        for (int i = 0; i < size; i++) {
                            ArrayList<String> filter2 = bdStatBase.filter(logFiles.getLogStringByIndex(i));
                            if (filter2 != null && filter2.size() != 0) {
                                a(bdStatBase, a, filter2, logFiles.get(i));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            bdStatBase.setmIsUploading(false);
            bdStatBase.changeUser(this.p);
        }
    }

    private void a(BdStatBase bdStatBase, String str, ArrayList<String> arrayList, ArrayList<q> arrayList2) {
        byte[] a;
        if (bdStatBase != null && (a = a(str, arrayList)) != null && a.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a.length / 2);
            try {
                com.baidu.adp.lib.util.e.a(a, byteArrayOutputStream);
            } catch (Exception e) {
                BdLog.e(e);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put(bdStatBase.getPostFileName(), byteArray);
            try {
                ArrayList<BasicNameValuePair> arrayList3 = new ArrayList<>();
                arrayList3.add(new BasicNameValuePair("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT));
                arrayList3.add(new BasicNameValuePair("_client_version", this.o));
                arrayList3.add(new BasicNameValuePair("_phone_imei", this.q));
                arrayList3.add(new BasicNameValuePair("_client_id", this.i));
                arrayList3.add(new BasicNameValuePair(com.baidu.tbadk.core.frameworkData.a.FROM, this.f));
                arrayList3.add(new BasicNameValuePair("net_type", this.s));
                arrayList3.add(new BasicNameValuePair("cuid", this.j));
                arrayList3.add(new BasicNameValuePair("model", this.k));
                if (TextUtils.isEmpty(this.p)) {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, "0"));
                } else {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, this.p));
                }
                arrayList3.add(new BasicNameValuePair("un", this.g));
                arrayList3.add(new BasicNameValuePair("BDUSS", this.h));
                com.baidu.adp.lib.network.willdelete.f a2 = com.baidu.adp.lib.network.willdelete.e.a().a(this.m, false, arrayList3, hashMap, 3, -1, null, null, null, null);
                if (a2 != null && a2.a == 200) {
                    try {
                        if (new JSONObject(new String(a2.d, "utf-8")).optInt("error_code", -1) == 0) {
                            bdStatBase.uploadSucc(arrayList2);
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    public void h() {
        Intent intent = new Intent();
        intent.setAction("adp.bdstatisticsmanager2.multiprocess");
        intent.putExtra("intent_data_multiprocess_type", 2);
        this.c.sendBroadcast(intent);
    }
}
