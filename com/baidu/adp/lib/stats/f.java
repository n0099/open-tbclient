package com.baidu.adp.lib.stats;

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
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
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
    private static final BdUniqueId xb = BdUniqueId.gen();
    private static f xc;
    private String mClientId;
    private Context mContext;
    private String mCuid;
    private String mUid;
    private String xd;
    private String xe;
    private String xf;
    private String xg;
    private String xh;
    private String xi;
    private String xj;
    private String xk;
    private String xl;
    private String xm;
    private String xn;
    private String xo;
    private k xx;
    private h xy;
    private j xz;
    private String mNetType = null;
    private String xp = null;
    private r xq = null;
    private boolean xr = false;
    private BdStatLog xs = null;
    private BdDebugLog xt = null;
    private BdErrorLog xu = null;
    private BdPerformanceLog xv = null;
    private Handler mHandler = null;
    private BdStatSwitchData xw = null;
    private BdAsyncTaskParallel xA = null;
    SimpleDateFormat xB = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS");

    public r hN() {
        return this.xq;
    }

    public String hO() {
        return this.xm;
    }

    public static void fR() {
        xc = null;
    }

    public static f hP() {
        synchronized (f.class) {
            if (xc == null) {
                xc = new f();
            }
        }
        return xc;
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, r rVar, boolean z) {
        this.mContext = context;
        this.xk = str;
        this.xl = str2;
        this.xd = str3;
        this.xe = str4;
        this.xm = str5;
        this.xf = str6;
        this.mClientId = str7;
        this.mCuid = str8;
        this.xi = Build.MODEL;
        this.xj = Build.VERSION.RELEASE;
        this.xn = str9;
        this.xo = str10;
        this.xq = rVar;
        this.xr = z;
        if (this.xx == null && context != null) {
            try {
                this.xx = new k(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.xx, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.xy == null && context != null) {
            this.xy = new h(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager2.account_changed");
            context.registerReceiver(this.xy, intentFilter2);
        }
        if (this.xz == null && context != null) {
            this.xz = new j(this, null);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("adp.bdstatisticsmanager2.multiprocess");
            context.registerReceiver(this.xz, intentFilter3);
        }
        if (TextUtils.isEmpty(str11)) {
            str11 = "stat";
        }
        if (this.mHandler == null) {
            this.mHandler = new g(this);
        }
        this.xw = new BdStatSwitchData();
        if (this.xs == null) {
            this.xs = new BdStatLog(context, str11, this.xr);
        }
        if (this.xt == null) {
            this.xt = new BdDebugLog(context, str11, this.xr);
        }
        if (this.xu == null) {
            this.xu = new BdErrorLog(context, str11, this.xr);
        }
        if (this.xv == null) {
            this.xv = new BdPerformanceLog(context, str11, this.xr);
        }
        b(this.xw);
        hQ();
        if (TextUtils.isEmpty(BdStatBase.mProcessNameMd5)) {
            hP().eventStat(this.mContext, "logpnmd5", null, 1, new Object[0]);
        }
    }

    public String getImei() {
        return this.xn;
    }

    public void hQ() {
        new i(this, true).execute(new Object[0]);
    }

    public void hR() {
        this.mNetType = p.getNetType(this.mContext);
        this.xp = p.H(this.mContext);
        if (com.baidu.adp.lib.util.k.iH()) {
            boolean iI = com.baidu.adp.lib.util.k.iI();
            if (this.xs != null) {
                this.xs.setmIsNetworkWifi(iI);
            }
            if (this.xt != null) {
                this.xt.setmIsNetworkWifi(iI);
            }
            if (this.xu != null) {
                this.xu.setmIsNetworkWifi(iI);
            }
            if (this.xv != null) {
                this.xv.setmIsNetworkWifi(iI);
            }
        }
    }

    public String hS() {
        return this.mNetType;
    }

    public q ar(String str) {
        return new q(str);
    }

    public synchronized void f(String str, String str2, String str3) {
        if ((this.mUid != null || str != null) && (this.mUid == null || !this.mUid.equals(str))) {
            this.mUid = str;
            this.xg = str2;
            this.xh = str3;
            save();
        }
    }

    public void log(String str, Object... objArr) {
        BdStatBase au;
        if (!TextUtils.isEmpty(str) && objArr != null && objArr.length != 0 && (au = au(str)) != null && au.ismIsLogOpen()) {
            q qVar = new q(str);
            qVar.f(objArr);
            au.add(qVar);
        }
    }

    public void as(String str) {
        a(au(str), true, true);
    }

    public void a(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && NetworkChangeReceiver.WIFI_STRING.equals(this.mNetType))) {
            a("img", str, str2, str3, j, j2, j3, j4, j5, i, i2, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        a("d", str, str2, str3, j, j2, j3, j4, j5, i, i2, str4, objArr);
    }

    public void a(String str, String str2, String str3, String str4, long j, long j2, long j3, long j4, long j5, int i, int i2, String str5, Object... objArr) {
        BdStatBase au = au("net");
        if (au != null && au.ismIsLogOpen() && au.isSubTypeOpen(str) && !m.ia().av("net")) {
            q qVar = new q("net");
            qVar.f("module", "net", "st", str, "net", this.mNetType, "interface", str2, "cost", Long.valueOf(j3), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
            }
            if (i2 != 0) {
                qVar.b("result", Integer.valueOf(i2));
                qVar.b("es", str5);
            }
            if (j4 > 0) {
                qVar.b(TiebaStatic.CON_COST, Long.valueOf(j4));
            }
            if (j2 > 0) {
                qVar.b("size_u", Long.valueOf(j2));
            }
            if (j > 0) {
                qVar.b("size_d", Long.valueOf(j));
            }
            if (j5 > 0) {
                qVar.b("rsp_cost", Long.valueOf(j5));
            }
            if (!TextUtils.isEmpty(str3)) {
                qVar.b("sid", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                qVar.b("f", str4);
            }
            if (i > 0) {
                qVar.b("retry", Integer.valueOf(i));
            }
            au.add(qVar);
        }
    }

    public void a(String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        a(true, "d", str, str2, str3, j, i, str4, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, String str4, long j, int i, String str5, Object... objArr) {
        BdStatBase au = au("op");
        if (au != null && au.ismIsLogOpen() && au.isSubTypeOpen(str)) {
            if (!z || !m.ia().av("op")) {
                q qVar = new q("op");
                qVar.f("module", "op", "st", str, "op_key", str2, "sid", str3, "f", str4, "cost", Long.valueOf(j), "result", Integer.valueOf(i), "es", str5, "t", String.valueOf(System.currentTimeMillis()));
                if (objArr != null && objArr.length > 0) {
                    qVar.f(objArr);
                }
                au.add(qVar);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5, Object... objArr) {
        a(true, str, str2, str3, str4, 0L, i, str5, objArr);
    }

    public void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.ia().av("file")) {
            a(true, "file", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.ia().av("db")) {
            a(true, "db", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.ia().av("voice")) {
            a(true, "voice", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void d(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.ia().av("live")) {
            a(true, "live", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void e(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.ia().av("aladin_port_error")) {
            a(true, "aladin_port_error", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        BdStatBase au = au("crash");
        if (au != null && au.ismIsLogOpen()) {
            q qVar = new q("crash");
            qVar.f("module", "crash", "crash_type", str, "ci", str2, "f", str3, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
            }
            au.add(qVar);
        }
    }

    public void b(String str, Object... objArr) {
        BdStatBase au = au("dbg");
        if (au != null && au.ismIsLogOpen() && au.isSubTypeOpen(str)) {
            q qVar = new q("dbg");
            qVar.f("module", "dbg", "st", str, "t", this.xB.format(new Date()));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
            }
            au.add(qVar);
        }
    }

    public void a(String str, q qVar) {
        BdStatBase au = au("dbg");
        if (qVar != null && au != null && au.ismIsLogOpen() && au.isSubTypeOpen(str)) {
            qVar.r("module", "dbg");
            qVar.r("st", str);
            qVar.r("t", this.xB.format(new Date()));
            au.add(qVar);
        }
    }

    public void b(String str, q qVar) {
        BdStatBase au = au("pfmonitor");
        if (qVar != null && au != null && au.ismIsLogOpen() && au.isSubTypeOpen(str)) {
            qVar.r("module", "pfmonitor");
            qVar.r("st", str);
            qVar.r("t", this.xB.format(new Date()));
            au.add(qVar);
        }
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        BdStatBase au = au("stat");
        if (au != null && au.ismIsLogOpen()) {
            q qVar = new q("stat");
            qVar.f("module", "stat", "op_key", str, "pt", str2, "co", Integer.valueOf(i), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
                qVar.b("mi", 0);
            }
            au.add(qVar);
        }
    }

    public void save() {
        if (this.xs != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.xs));
        }
        if (this.xu != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.xu));
        }
        if (this.xt != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.xt));
        }
        if (this.xv != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.xv));
        }
    }

    public void hT() {
        String in = this.xq.in();
        if (!com.baidu.adp.lib.util.m.isEmpty(in)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(in);
            b(bdStatSwitchData);
        }
        if (this.xs != null) {
            long io = this.xq.io();
            if (io <= 0) {
                io = System.currentTimeMillis();
                this.xq.h(io);
            }
            this.xs.setmLastUploadTime(io);
        }
        if (this.xu != null) {
            long ir = this.xq.ir();
            if (ir <= 0) {
                ir = System.currentTimeMillis();
                this.xq.k(ir);
            }
            this.xu.setmLastUploadTime(ir);
        }
        if (this.xt != null) {
            long ip = this.xq.ip();
            if (ip <= 0) {
                ip = System.currentTimeMillis();
                this.xq.i(ip);
            }
            this.xt.setmLastUploadTime(ip);
        }
        if (this.xv != null) {
            long iq = this.xq.iq();
            if (iq <= 0) {
                iq = System.currentTimeMillis();
                this.xq.j(iq);
            }
            this.xv.setmLastUploadTime(iq);
        }
    }

    public void at(String str) {
        if (!TextUtils.isEmpty(str)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(str);
            a(bdStatSwitchData);
        }
    }

    public void a(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null && bdStatSwitchData.getError_code() == 0) {
            b(bdStatSwitchData);
            this.xq.ax(bdStatSwitchData.getmData());
            if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                this.xt.clearLogs();
            }
            if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                this.xu.clearLogs();
            }
            if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                this.xs.clearLogs();
            }
            if (bdStatSwitchData.getPerformance() != null && bdStatSwitchData.getPerformance().getCommon() != null && !bdStatSwitchData.getPerformance().getCommon().isIs_open()) {
                this.xv.clearLogs();
            }
            hW();
        }
    }

    public String hU() {
        try {
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.xw.inSpecStrategy()) {
            return null;
        }
        com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.hu().a(String.valueOf(this.xl) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, null, null, null);
        if (a != null) {
            return new String(a.data, "utf-8");
        }
        return null;
    }

    private void b(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            synchronized (BdStatSwitchData.class) {
                this.xw = bdStatSwitchData;
                if (this.xw.getError() != null && this.xu != null) {
                    this.xu.setSwitchData(this.xw.getError());
                }
                if (this.xw.getStat() != null && this.xs != null) {
                    this.xs.setSwitchData(this.xw.getStat());
                }
                if (this.xw.getDebug() != null && this.xt != null) {
                    this.xt.setSwitchData(this.xw.getDebug());
                }
                if (this.xw.getPerformance() != null && this.xv != null) {
                    this.xv.setSwitchData(this.xw.getPerformance());
                }
            }
        }
    }

    private BdStatBase au(String str) {
        if (this.xu != null && (str.equals("net") || str.equals("op") || str.equals("crash"))) {
            return this.xu;
        }
        if (this.xt != null && str.equals("dbg")) {
            return this.xt;
        }
        if (this.xs != null && str.equals("stat")) {
            return this.xs;
        }
        if (this.xv != null && str.equals("pfmonitor")) {
            return this.xv;
        }
        return this.xu;
    }

    private void a(BdStatBase bdStatBase, boolean z) {
        if (bdStatBase != null && !bdStatBase.ismIsUploading()) {
            bdStatBase.refreshFile(z);
            if (bdStatBase.getmUid() == null) {
                if (this.mUid != null) {
                    bdStatBase.changeUser(this.mUid);
                }
            } else if (!bdStatBase.getmUid().equals(this.mUid)) {
                bdStatBase.changeUser(this.mUid);
            }
        }
    }

    public long hV() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.xw == null) {
                this.xw = new BdStatSwitchData();
            }
            uploadMilliInterval = this.xw.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }

    public void handleException() {
        this.xs.handleException();
        this.xu.handleException();
        this.xt.handleException();
        this.xv.handleException();
    }

    public void hW() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.xw == null) {
                this.xw = new BdStatSwitchData();
            }
            uploadMilliInterval = this.xw.getUploadMilliInterval();
        }
        this.mHandler.removeMessages(2);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), uploadMilliInterval);
    }

    public void a(BdStatBase bdStatBase, boolean z, boolean z2) {
        if (bdStatBase != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, z ? 1 : 0, z2 ? 1 : 0, bdStatBase));
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
        a(bdStatBase, z2);
    }

    public void b(BdStatBase bdStatBase, boolean z) {
        if (bdStatBase != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, z ? 1 : 0, 0, bdStatBase));
        }
    }

    public void c(BdStatBase bdStatBase, boolean z) {
        try {
            bdStatBase.checkToSendUploadMessage(z);
        } catch (Exception e) {
        }
    }

    public void a(BdStatBase bdStatBase) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, bdStatBase));
    }

    public void b(BdStatBase bdStatBase) {
        if (this.xr) {
            new l(this, bdStatBase).execute(new Object[0]);
        }
        if (!this.xr && !this.xw.inSpecStrategy() && this.xw.getSpecifiedExpired() > 0) {
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

    private String hX() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(this.xd, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(this.xe, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.xm, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.xj, "utf-8"));
            if (!TextUtils.isEmpty(this.xf)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(this.xf, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.xi, "utf-8"));
            if (!TextUtils.isEmpty(this.mUid)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.mClientId)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(this.mClientId, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.xn)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.xn, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.xg)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(this.xg, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.mCuid)) {
                sb.append("&");
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(this.mCuid, "utf-8"));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
            sb.append(URLEncoder.encode(this.mNetType, "utf-8"));
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String B(boolean z) {
        String str;
        String[] split;
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = this.xm;
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
                a(sb, "_phone_imei", this.xn, z);
                a(sb, "_client_id", this.mClientId, z);
                if (!TextUtils.isEmpty(this.xo)) {
                    a(sb, "subapp_type", this.xo, z);
                }
                a(sb, "from", this.xf, z);
                a(sb, "net_type", this.xp, z);
                a(sb, "cuid", this.mCuid, z);
                a(sb, "model", this.xi, z);
                if (!TextUtils.isEmpty(this.mUid)) {
                    a(sb, SapiAccountManager.SESSION_UID, GameInfoData.NOT_FROM_DETAIL, z);
                } else {
                    a(sb, SapiAccountManager.SESSION_UID, this.mUid, z);
                }
                a(sb, "un", this.xg, z);
                a(sb, "BDUSS", this.xh, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.xn, z);
        a(sb, "_client_id", this.mClientId, z);
        if (!TextUtils.isEmpty(this.xo)) {
        }
        a(sb, "from", this.xf, z);
        a(sb, "net_type", this.xp, z);
        a(sb, "cuid", this.mCuid, z);
        a(sb, "model", this.xi, z);
        if (!TextUtils.isEmpty(this.mUid)) {
        }
        a(sb, "un", this.xg, z);
        a(sb, "BDUSS", this.xh, z);
        return sb.toString();
    }

    public void c(BdStatBase bdStatBase) {
        String B;
        if (bdStatBase != null && !bdStatBase.ismIsUploading() && bdStatBase.ismIsLogOpen()) {
            bdStatBase.setmIsUploading(true);
            bdStatBase.splitFile();
            try {
                if (bdStatBase.getPostFileName() != null && bdStatBase.getPostFileName().equals("omp")) {
                    B = hX();
                } else {
                    B = B(true);
                }
                if (bdStatBase.checkFileFailed()) {
                    ArrayList<String> memData = bdStatBase.getMemData();
                    bdStatBase.clearMemData();
                    ArrayList<String> filter = bdStatBase.filter(memData);
                    if (filter != null && filter.size() > 0) {
                        a(bdStatBase, B, filter, (ArrayList<s>) null);
                    }
                } else {
                    BdUploadingLogInfo logFiles = bdStatBase.getLogFiles();
                    int size = logFiles.size();
                    if (logFiles != null && size > 0) {
                        for (int i = 0; i < size; i++) {
                            ArrayList<String> filter2 = bdStatBase.filter(logFiles.getLogStringByIndex(i));
                            if (filter2 != null && filter2.size() != 0) {
                                a(bdStatBase, B, filter2, logFiles.get(i));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            bdStatBase.setmIsUploading(false);
            bdStatBase.changeUser(this.mUid);
        }
    }

    private void a(BdStatBase bdStatBase, String str, ArrayList<String> arrayList, ArrayList<s> arrayList2) {
        byte[] a;
        if (bdStatBase != null && (a = a(str, arrayList)) != null && a.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a.length / 2);
            try {
                com.baidu.adp.lib.util.g.a(a, byteArrayOutputStream);
            } catch (Exception e) {
                BdLog.e(e);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put(bdStatBase.getPostFileName(), byteArray);
            try {
                ArrayList<BasicNameValuePair> arrayList3 = new ArrayList<>();
                arrayList3.add(new BasicNameValuePair("_client_type", "2"));
                arrayList3.add(new BasicNameValuePair("_client_version", this.xm));
                arrayList3.add(new BasicNameValuePair("_phone_imei", this.xn));
                arrayList3.add(new BasicNameValuePair("_client_id", this.mClientId));
                if (!TextUtils.isEmpty(this.xo)) {
                    arrayList3.add(new BasicNameValuePair("subapp_type", this.xo));
                }
                arrayList3.add(new BasicNameValuePair("from", this.xf));
                arrayList3.add(new BasicNameValuePair("net_type", this.xp));
                arrayList3.add(new BasicNameValuePair("cuid", this.mCuid));
                arrayList3.add(new BasicNameValuePair("model", this.xi));
                if (TextUtils.isEmpty(this.mUid)) {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, GameInfoData.NOT_FROM_DETAIL));
                } else {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, this.mUid));
                }
                arrayList3.add(new BasicNameValuePair("un", this.xg));
                arrayList3.add(new BasicNameValuePair("BDUSS", this.xh));
                String str2 = this.xk;
                if (bdStatBase != null && (bdStatBase instanceof BdPerformanceLog) && BdStatisticsSwitchStatic.hZ()) {
                    str2 = "http://nlog.baidu.com/dplog/n";
                }
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.hu().b(str2, false, arrayList3, hashMap, 3, -1, null, null, null, null);
                if (b != null && b.wm == 200) {
                    try {
                        if (new JSONObject(new String(b.data, "utf-8")).optInt("error_code", -1) == 0) {
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

    public void sendMultiProcessBroadcast() {
        Intent intent = new Intent();
        intent.setAction("adp.bdstatisticsmanager2.multiprocess");
        intent.putExtra("intent_data_multiprocess_type", 2);
        this.mContext.sendBroadcast(intent);
    }
}
