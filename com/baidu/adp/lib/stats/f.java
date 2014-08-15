package com.baidu.adp.lib.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
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
public class f {
    private static final BdUniqueId b = BdUniqueId.gen();
    private static f c;
    private k B;
    private h C;
    private j D;
    private Context d;
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
    private String r;
    private String s = null;
    private String t = null;
    private r u = null;
    private boolean v = false;
    private BdStatLog w = null;
    private BdDebugLog x = null;
    private BdErrorLog y = null;
    private Handler z = null;
    private BdStatSwitchData A = null;
    private BdAsyncTaskParallel E = null;
    @SuppressLint({"SimpleDateFormat"})
    SimpleDateFormat a = new SimpleDateFormat("yy-MM-dd_HH-mm-ss");

    public r a() {
        return this.u;
    }

    public String b() {
        return this.p;
    }

    public static f c() {
        synchronized (f.class) {
            if (c == null) {
                c = new f();
            }
        }
        return c;
    }

    @SuppressLint({"HandlerLeak"})
    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, r rVar, boolean z) {
        this.d = context;
        this.n = str;
        this.o = str2;
        this.e = str3;
        this.f = str4;
        this.p = str5;
        this.g = str6;
        this.j = str7;
        this.k = str8;
        this.l = Build.MODEL;
        this.m = Build.VERSION.RELEASE;
        this.r = str9;
        this.u = rVar;
        this.v = z;
        if (this.B == null && context != null) {
            try {
                this.B = new k(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.B, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.C == null && context != null) {
            this.C = new h(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager2.account_changed");
            context.registerReceiver(this.C, intentFilter2);
        }
        if (this.D == null && context != null) {
            this.D = new j(this, null);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("adp.bdstatisticsmanager2.multiprocess");
            context.registerReceiver(this.D, intentFilter3);
        }
        if (TextUtils.isEmpty(str10)) {
            str10 = "stat";
        }
        if (this.z == null) {
            this.z = new g(this);
        }
        this.A = new BdStatSwitchData();
        if (this.w == null) {
            this.w = new BdStatLog(context, str10, this.v);
        }
        if (this.x == null) {
            this.x = new BdDebugLog(context, str10, this.v);
        }
        if (this.y == null) {
            this.y = new BdErrorLog(context, str10, this.v);
        }
        b(this.A);
        j();
        if (TextUtils.isEmpty(BdStatBase.mProcessNameMd5)) {
            c().a(this.d, "logpnmd5", null, 1, new Object[0]);
        }
    }

    public String d() {
        return this.r;
    }

    public void j() {
        new i(this, true).execute(new Object[0]);
    }

    public void k() {
        this.s = p.a(this.d);
        this.t = p.b(this.d);
        if (com.baidu.adp.lib.network.willdelete.h.b()) {
            boolean a = com.baidu.adp.lib.network.willdelete.h.a();
            if (this.w != null) {
                this.w.setmIsNetworkWifi(a);
            }
            if (this.x != null) {
                this.x.setmIsNetworkWifi(a);
            }
            if (this.y != null) {
                this.y.setmIsNetworkWifi(a);
            }
        }
    }

    public String e() {
        return this.s;
    }

    public q a(String str) {
        return new q(str);
    }

    public synchronized void a(String str, String str2, String str3) {
        if ((this.q != null || str != null) && (this.q == null || !this.q.equals(str))) {
            this.q = str;
            this.h = str2;
            this.i = str3;
            f();
        }
    }

    public void a(String str, Object... objArr) {
        BdStatBase c2;
        if (!TextUtils.isEmpty(str) && objArr != null && objArr.length != 0 && (c2 = c(str)) != null && c2.ismIsLogOpen()) {
            q qVar = new q(str);
            qVar.a(objArr);
            c2.add(qVar);
        }
    }

    public void a(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && NetworkChangeReceiver.WIFI_STRING.equals(this.s))) {
            a("img", str, str2, str3, j, j2, j3, j4, j5, i, i2, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        a("d", str, str2, str3, j, j2, j3, j4, j5, i, i2, str4, objArr);
    }

    public void a(String str, String str2, String str3, String str4, long j, long j2, long j3, long j4, long j5, int i, int i2, String str5, Object... objArr) {
        BdStatBase c2 = c("net");
        if (c2 != null && c2.ismIsLogOpen() && c2.isSubTypeOpen(str) && !m.a().a("net")) {
            q qVar = new q("net");
            qVar.a("module", "net", "st", str, "net", this.s, "interface", str2, "cost", Long.valueOf(j3), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.a(objArr);
            }
            if (i2 != 0) {
                qVar.a("result", Integer.valueOf(i2));
                qVar.a((Object) "es", (Object) str5);
            }
            if (j4 > 0) {
                qVar.a(TiebaStatic.CON_COST, Long.valueOf(j4));
            }
            if (j2 > 0) {
                qVar.a("size_u", Long.valueOf(j2));
            }
            if (j > 0) {
                qVar.a("size_d", Long.valueOf(j));
            }
            if (j5 > 0) {
                qVar.a("rsp_cost", Long.valueOf(j5));
            }
            if (!TextUtils.isEmpty(str3)) {
                qVar.a((Object) "sid", (Object) str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                qVar.a((Object) "f", (Object) str4);
            }
            if (i > 0) {
                qVar.a("retry", Integer.valueOf(i));
            }
            c2.add(qVar);
        }
    }

    public void a(String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        a(true, "d", str, str2, str3, j, i, str4, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, String str4, long j, int i, String str5, Object... objArr) {
        BdStatBase c2 = c("op");
        if (c2 != null && c2.ismIsLogOpen() && c2.isSubTypeOpen(str)) {
            if (!z || !m.a().a("op")) {
                q qVar = new q("op");
                qVar.a("module", "op", "st", str, "op_key", str2, "sid", str3, "f", str4, "cost", Long.valueOf(j), "result", Integer.valueOf(i), "es", str5, "t", String.valueOf(System.currentTimeMillis()));
                if (objArr != null && objArr.length > 0) {
                    qVar.a(objArr);
                }
                c2.add(qVar);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5, Object... objArr) {
        a(true, str, str2, str3, str4, 0L, i, str5, objArr);
    }

    public void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.a().a("file")) {
            a(true, "file", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.a().a("db")) {
            a(true, "db", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.a().a("voice")) {
            a(true, "voice", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void d(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.a().a("live")) {
            a(true, "live", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void e(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.a().a("aladin_port_error")) {
            a(true, "aladin_port_error", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        BdStatBase c2 = c("crash");
        if (c2 != null && c2.ismIsLogOpen()) {
            q qVar = new q("crash");
            qVar.a("module", "crash", "crash_type", str, "ci", str2, "f", str3, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.a(objArr);
            }
            c2.add(qVar);
        }
    }

    public void b(String str, Object... objArr) {
        BdStatBase c2 = c("dbg");
        if (c2 != null && c2.ismIsLogOpen() && c2.isSubTypeOpen(str)) {
            q qVar = new q("dbg");
            qVar.a("module", "dbg", "st", str, "t", this.a.format(new Date()));
            if (objArr != null && objArr.length > 0) {
                qVar.a(objArr);
            }
            c2.add(qVar);
        }
    }

    public void a(String str, q qVar) {
        BdStatBase c2 = c("dbg");
        if (qVar != null && c2 != null && c2.ismIsLogOpen() && c2.isSubTypeOpen(str)) {
            qVar.a("module", "dbg");
            qVar.a("st", str);
            qVar.a("t", this.a.format(new Date()));
            c2.add(qVar);
        }
    }

    public void a(Context context, String str, String str2, int i, Object... objArr) {
        BdStatBase c2 = c("stat");
        if (c2 != null && c2.ismIsLogOpen()) {
            q qVar = new q("stat");
            qVar.a("module", "stat", "op_key", str, "pt", str2, "co", Integer.valueOf(i), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.a(objArr);
                qVar.a((Object) "mi", (Object) 0);
            }
            c2.add(qVar);
        }
    }

    public void f() {
        if (this.w != null) {
            this.z.sendMessage(this.z.obtainMessage(1, 1, 0, this.w));
        }
        if (this.y != null) {
            this.z.sendMessage(this.z.obtainMessage(1, 1, 0, this.y));
        }
        if (this.x != null) {
            this.z.sendMessage(this.z.obtainMessage(1, 1, 0, this.x));
        }
    }

    public void l() {
        String a = this.u.a();
        if (!com.baidu.adp.lib.util.i.c(a)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(a);
            b(bdStatSwitchData);
        }
        if (this.w != null) {
            long b2 = this.u.b();
            if (b2 <= 0) {
                b2 = System.currentTimeMillis();
                this.u.a(b2);
            }
            this.w.setmLastUploadTime(b2);
        }
        if (this.y != null) {
            long d = this.u.d();
            if (d <= 0) {
                d = System.currentTimeMillis();
                this.u.c(d);
            }
            this.y.setmLastUploadTime(d);
        }
        if (this.x != null) {
            long c2 = this.u.c();
            if (c2 <= 0) {
                c2 = System.currentTimeMillis();
                this.u.b(c2);
            }
            this.x.setmLastUploadTime(c2);
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
        if (bdStatSwitchData != null && bdStatSwitchData.getError_code() == 0) {
            b(bdStatSwitchData);
            this.u.a(bdStatSwitchData.getmData());
            if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                this.x.clearLogs();
            }
            if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                this.y.clearLogs();
            }
            if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                this.w.clearLogs();
            }
            n();
        }
    }

    public String m() {
        try {
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.A.inSpecStrategy()) {
            return null;
        }
        com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.a().a(String.valueOf(this.o) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, null, null, null);
        if (a != null) {
            return new String(a.d, "utf-8");
        }
        return null;
    }

    private void b(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            synchronized (BdStatSwitchData.class) {
                this.A = bdStatSwitchData;
                if (this.A.getError() != null && this.y != null) {
                    this.y.setSwitchData(this.A.getError());
                }
                if (this.A.getStat() != null && this.w != null) {
                    this.w.setSwitchData(this.A.getStat());
                }
                if (this.A.getDebug() != null && this.x != null) {
                    this.x.setSwitchData(this.A.getDebug());
                }
            }
        }
    }

    private BdStatBase c(String str) {
        if (this.y != null && (str.equals("net") || str.equals("op") || str.equals("crash"))) {
            return this.y;
        }
        if (this.x != null && str.equals("dbg")) {
            return this.x;
        }
        if (this.w != null && str.equals("stat")) {
            return this.w;
        }
        return this.y;
    }

    private void b(BdStatBase bdStatBase, boolean z) {
        if (bdStatBase != null && !bdStatBase.ismIsUploading()) {
            bdStatBase.refreshFile(z);
            if (bdStatBase.getmUid() == null) {
                if (this.q != null) {
                    bdStatBase.changeUser(this.q);
                }
            } else if (!bdStatBase.getmUid().equals(this.q)) {
                bdStatBase.changeUser(this.q);
            }
        }
    }

    public long g() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.A == null) {
                this.A = new BdStatSwitchData();
            }
            uploadMilliInterval = this.A.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }

    public void n() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.A == null) {
                this.A = new BdStatSwitchData();
            }
            uploadMilliInterval = this.A.getUploadMilliInterval();
        }
        this.z.removeMessages(2);
        this.z.sendMessageDelayed(this.z.obtainMessage(2), uploadMilliInterval);
    }

    public void a(BdStatBase bdStatBase, boolean z, boolean z2) {
        if (bdStatBase != null) {
            this.z.sendMessage(this.z.obtainMessage(1, z ? 1 : 0, z2 ? 1 : 0, bdStatBase));
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
            this.z.sendMessage(this.z.obtainMessage(3, z ? 1 : 0, 0, bdStatBase));
        }
    }

    public void c(BdStatBase bdStatBase, boolean z) {
        try {
            bdStatBase.checkToSendUploadMessage(z);
        } catch (Exception e) {
        }
    }

    public void a(BdStatBase bdStatBase) {
        this.z.sendMessage(this.z.obtainMessage(4, bdStatBase));
    }

    public void b(BdStatBase bdStatBase) {
        if (this.v) {
            new l(this, bdStatBase).execute(new Object[0]);
        }
        if (!this.v && !this.A.inSpecStrategy() && this.A.getSpecifiedExpired() > 0) {
            new i(this, false).execute(new Object[0]);
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

    private String o() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(this.e, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(this.f, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.p, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.m, "utf-8"));
            if (!TextUtils.isEmpty(this.g)) {
                sb.append("&");
                sb.append(com.baidu.tbadk.core.frameworkData.a.FROM);
                sb.append("=");
                sb.append(URLEncoder.encode(this.g, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.l, "utf-8"));
            if (!TextUtils.isEmpty(this.q)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.q, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.j)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(this.j, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.r)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.r, "utf-8"));
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
            sb.append(URLEncoder.encode(this.s, "utf-8"));
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
        String str2 = this.p;
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
                a(sb, "_phone_imei", this.r, z);
                a(sb, "_client_id", this.j, z);
                a(sb, com.baidu.tbadk.core.frameworkData.a.FROM, this.g, z);
                a(sb, "net_type", this.t, z);
                a(sb, "cuid", this.k, z);
                a(sb, "model", this.l, z);
                if (!TextUtils.isEmpty(this.q)) {
                    a(sb, SapiAccountManager.SESSION_UID, "0", z);
                } else {
                    a(sb, SapiAccountManager.SESSION_UID, this.q, z);
                }
                a(sb, "un", this.h, z);
                a(sb, "BDUSS", this.i, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.r, z);
        a(sb, "_client_id", this.j, z);
        a(sb, com.baidu.tbadk.core.frameworkData.a.FROM, this.g, z);
        a(sb, "net_type", this.t, z);
        a(sb, "cuid", this.k, z);
        a(sb, "model", this.l, z);
        if (!TextUtils.isEmpty(this.q)) {
        }
        a(sb, "un", this.h, z);
        a(sb, "BDUSS", this.i, z);
        return sb.toString();
    }

    public void c(BdStatBase bdStatBase) {
        String a;
        if (bdStatBase != null && !bdStatBase.ismIsUploading() && bdStatBase.ismIsLogOpen()) {
            bdStatBase.setmIsUploading(true);
            bdStatBase.splitFile();
            try {
                if (bdStatBase.getPostFileName() != null && bdStatBase.getPostFileName().equals("omp")) {
                    a = o();
                } else {
                    a = a(true);
                }
                if (bdStatBase.checkFileFailed()) {
                    ArrayList<String> memData = bdStatBase.getMemData();
                    bdStatBase.clearMemData();
                    ArrayList<String> filter = bdStatBase.filter(memData);
                    if (filter != null && filter.size() > 0) {
                        a(bdStatBase, a, filter, (ArrayList<s>) null);
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
            bdStatBase.changeUser(this.q);
        }
    }

    private void a(BdStatBase bdStatBase, String str, ArrayList<String> arrayList, ArrayList<s> arrayList2) {
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
                arrayList3.add(new BasicNameValuePair("_client_version", this.p));
                arrayList3.add(new BasicNameValuePair("_phone_imei", this.r));
                arrayList3.add(new BasicNameValuePair("_client_id", this.j));
                arrayList3.add(new BasicNameValuePair(com.baidu.tbadk.core.frameworkData.a.FROM, this.g));
                arrayList3.add(new BasicNameValuePair("net_type", this.t));
                arrayList3.add(new BasicNameValuePair("cuid", this.k));
                arrayList3.add(new BasicNameValuePair("model", this.l));
                if (TextUtils.isEmpty(this.q)) {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, "0"));
                } else {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, this.q));
                }
                arrayList3.add(new BasicNameValuePair("un", this.h));
                arrayList3.add(new BasicNameValuePair("BDUSS", this.i));
                com.baidu.adp.lib.network.willdelete.f a2 = com.baidu.adp.lib.network.willdelete.e.a().a(this.n, false, arrayList3, hashMap, 3, -1, null, null, null, null);
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
        this.d.sendBroadcast(intent);
    }
}
