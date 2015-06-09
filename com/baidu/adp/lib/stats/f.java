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
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.game.GameInfoData;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private static final BdUniqueId we = BdUniqueId.gen();
    private static volatile f wf;
    private String mClientId;
    private Context mContext;
    private String mCuid;
    private String mUid;
    private k wA;
    private h wB;
    private j wC;
    private String wg;
    private String wh;
    private String wi;
    private String wj;
    private String wk;
    private String wl;
    private String wm;
    private String wn;
    private String wo;
    private String wp;
    private String wq;
    private String wr;
    private String mNetType = null;
    private String ws = null;
    private r wt = null;
    private boolean wu = false;
    private BdStatLog wv = null;
    private BdDebugLog ww = null;
    private BdErrorLog wx = null;
    private BdPerformanceLog wy = null;
    private Handler mHandler = null;
    private BdStatSwitchData wz = null;
    private BdAsyncTaskParallel wD = null;
    SimpleDateFormat wE = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS");

    public r hx() {
        return this.wt;
    }

    public String hy() {
        return this.wp;
    }

    public static f hz() {
        if (wf == null) {
            synchronized (f.class) {
                if (wf == null) {
                    wf = new f();
                }
            }
        }
        return wf;
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, r rVar, boolean z) {
        this.mContext = context;
        this.wn = str;
        this.wo = str2;
        this.wg = str3;
        this.wh = str4;
        this.wp = str5;
        this.wi = str6;
        this.mClientId = str7;
        this.mCuid = str8;
        this.wl = Build.MODEL;
        this.wm = Build.VERSION.RELEASE;
        this.wq = str9;
        this.wr = str10;
        this.wt = rVar;
        this.wu = z;
        if (this.wA == null && context != null) {
            try {
                this.wA = new k(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.wA, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.wB == null && context != null) {
            this.wB = new h(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager.account_changed");
            context.registerReceiver(this.wB, intentFilter2);
        }
        if (this.wC == null && context != null) {
            this.wC = new j(this, null);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("adp.bdstatisticsmanager.multiprocess");
            context.registerReceiver(this.wC, intentFilter3);
        }
        if (TextUtils.isEmpty(str11)) {
            str11 = "stat";
        }
        if (this.mHandler == null) {
            this.mHandler = new g(this);
        }
        this.wz = new BdStatSwitchData();
        if (this.wv == null) {
            this.wv = new BdStatLog(context, str11, this.wu);
        }
        if (this.ww == null) {
            this.ww = new BdDebugLog(context, str11, this.wu);
        }
        if (this.wx == null) {
            this.wx = new BdErrorLog(context, str11, this.wu);
        }
        if (this.wy == null) {
            this.wy = new BdPerformanceLog(context, str11, this.wu);
        }
        b(this.wz);
        hA();
        if (TextUtils.isEmpty(BdStatBase.mProcessNameMd5)) {
            hz().eventStat(this.mContext, "logpnmd5", null, 1, new Object[0]);
        }
    }

    public String getImei() {
        return this.wq;
    }

    public void hA() {
        new i(this, true).execute(new Object[0]);
    }

    public void hB() {
        this.mNetType = p.getNetType(this.mContext);
        this.ws = p.H(this.mContext);
        if (com.baidu.adp.lib.util.k.iX()) {
            boolean iY = com.baidu.adp.lib.util.k.iY();
            if (this.wv != null) {
                this.wv.setmIsNetworkWifi(iY);
            }
            if (this.ww != null) {
                this.ww.setmIsNetworkWifi(iY);
            }
            if (this.wx != null) {
                this.wx.setmIsNetworkWifi(iY);
            }
            if (this.wy != null) {
                this.wy.setmIsNetworkWifi(iY);
            }
        }
    }

    public String hC() {
        return this.mNetType;
    }

    public q as(String str) {
        return new q(str);
    }

    public synchronized void f(String str, String str2, String str3) {
        if ((this.mUid != null || str != null) && (this.mUid == null || !this.mUid.equals(str))) {
            this.mUid = str;
            this.wj = str2;
            this.wk = str3;
            save();
        }
    }

    public void log(String str, Object... objArr) {
        if (!TextUtils.isEmpty(str) && objArr != null && objArr.length != 0) {
            com.baidu.adp.lib.h.a.iB().log(str, objArr);
        }
    }

    public void at(String str) {
        a(av(str), true, true);
        com.baidu.adp.lib.h.a.iB().aG(str);
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
        BdStatBase av = av("net");
        if (av != null && av.ismIsLogOpen() && av.isSubTypeOpen(str) && !m.hK().aw("net")) {
            com.baidu.adp.lib.h.a.iB().a(str, str2, -1L, str3, str4, j, j2, j3, j4, j5, i, i2, str5, objArr);
        }
    }

    public void a(String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        a(true, "d", str, str2, str3, j, i, str4, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, String str4, long j, int i, String str5, Object... objArr) {
        BdStatBase av = av("op");
        if (av != null && av.ismIsLogOpen() && av.isSubTypeOpen(str)) {
            if (!z || !m.hK().aw("op")) {
                com.baidu.adp.lib.h.a.iB().a(z, str, str2, -1L, str3, str4, j, i, str5, objArr);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5, Object... objArr) {
        a(true, str, str2, str3, str4, 0L, i, str5, objArr);
    }

    public void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.hK().aw("file")) {
            a(true, "file", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.hK().aw("db")) {
            a(true, "db", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.hK().aw("voice")) {
            a(true, "voice", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void d(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.hK().aw("live")) {
            a(true, "live", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void e(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.hK().aw("aladin_port_error")) {
            a(true, "aladin_port_error", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        BdStatBase av = av("crash");
        if (av != null && av.ismIsLogOpen()) {
            com.baidu.adp.lib.h.a.iB().a(str, -1L, (String) null, str2, str3, objArr);
        }
    }

    public void b(String str, Object... objArr) {
        BdStatBase av = av("dbg");
        if (av != null && av.ismIsLogOpen() && av.isSubTypeOpen(str)) {
            com.baidu.adp.lib.h.a.iB().a(str, -1L, (String) null, null, objArr);
        }
    }

    public void a(String str, q qVar) {
        BdStatBase av = av("dbg");
        if (qVar != null && av != null && av.ismIsLogOpen() && av.isSubTypeOpen(str)) {
            q qVar2 = new q("dbg");
            qVar2.ax(qVar.toString());
            com.baidu.adp.lib.h.a.iB().b(str, -1L, null, qVar2);
        }
    }

    public void b(String str, q qVar) {
        BdStatBase av = av("pfmonitor");
        if (qVar != null && av != null && av.ismIsLogOpen() && av.isSubTypeOpen(str)) {
            q qVar2 = new q("pfmonitor");
            qVar2.ax(qVar.toString());
            com.baidu.adp.lib.h.a.iB().a(str, -1L, (String) null, qVar2);
        }
    }

    public void a(String str, long j, String str2, q qVar) {
        BdStatBase av = av("pfmonitor");
        if (qVar != null && av != null && av.ismIsLogOpen() && av.isSubTypeOpen(str)) {
            q qVar2 = new q("pfmonitor");
            qVar2.ax(qVar.toString());
            com.baidu.adp.lib.h.a.iB().a(str, j, str2, qVar2);
        }
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        com.baidu.adp.lib.h.a.iB().eventStat(context, str, str2, i, objArr);
        BdStatBase av = av("stat");
        if (av != null && av.ismIsLogOpen()) {
            q qVar = new q("stat");
            qVar.f("module", "stat", "op_key", str, "pt", str2, "co", Integer.valueOf(i), Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
                qVar.b("mi", 0);
            }
            av.add(qVar);
        }
    }

    public void save() {
        if (this.wv != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.wv));
        }
        if (this.wx != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.wx));
        }
        if (this.ww != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.ww));
        }
        if (this.wy != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.wy));
        }
    }

    public void hD() {
        String hW = this.wt.hW();
        if (!com.baidu.adp.lib.util.m.isEmpty(hW)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(hW);
            b(bdStatSwitchData);
        }
        if (this.wv != null) {
            long hX = this.wt.hX();
            if (hX <= 0) {
                hX = System.currentTimeMillis();
                this.wt.h(hX);
            }
            this.wv.setmLastUploadTime(hX);
        }
        if (this.wx != null) {
            long ia = this.wt.ia();
            if (ia <= 0) {
                ia = System.currentTimeMillis();
                this.wt.k(ia);
            }
            this.wx.setmLastUploadTime(ia);
        }
        if (this.ww != null) {
            long hY = this.wt.hY();
            if (hY <= 0) {
                hY = System.currentTimeMillis();
                this.wt.i(hY);
            }
            this.ww.setmLastUploadTime(hY);
        }
        if (this.wy != null) {
            long hZ = this.wt.hZ();
            if (hZ <= 0) {
                hZ = System.currentTimeMillis();
                this.wt.j(hZ);
            }
            this.wy.setmLastUploadTime(hZ);
        }
    }

    public void au(String str) {
        if (!TextUtils.isEmpty(str)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(str);
            a(bdStatSwitchData);
        }
    }

    public void a(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null && bdStatSwitchData.getError_code() == 0) {
            b(bdStatSwitchData);
            this.wt.az(bdStatSwitchData.getmData());
            if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                this.ww.clearLogs();
            }
            if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                this.wx.clearLogs();
            }
            if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                this.wv.clearLogs();
            }
            if (bdStatSwitchData.getPerformance() != null && bdStatSwitchData.getPerformance().getCommon() != null && !bdStatSwitchData.getPerformance().getCommon().isIs_open()) {
                this.wy.clearLogs();
            }
            hG();
        }
    }

    public String hE() {
        try {
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.wz.inSpecStrategy()) {
            return null;
        }
        com.baidu.adp.lib.network.http.g a = new com.baidu.adp.lib.network.a.a().a(String.valueOf(this.wo) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, -1, (LinkedList<BasicNameValuePair>) null);
        if (a != null) {
            return new String(a.vk, "utf-8");
        }
        return null;
    }

    private void b(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            synchronized (BdStatSwitchData.class) {
                this.wz = bdStatSwitchData;
                if (this.wz.getError() != null && this.wx != null) {
                    this.wx.setSwitchData(this.wz.getError());
                }
                if (this.wz.getStat() != null && this.wv != null) {
                    this.wv.setSwitchData(this.wz.getStat());
                }
                if (this.wz.getDebug() != null && this.ww != null) {
                    this.ww.setSwitchData(this.wz.getDebug());
                }
                if (this.wz.getPerformance() != null && this.wy != null) {
                    this.wy.setSwitchData(this.wz.getPerformance());
                }
            }
        }
    }

    private BdStatBase av(String str) {
        if (this.wx != null && (str.equals("net") || str.equals("op") || str.equals("crash"))) {
            return this.wx;
        }
        if (this.ww != null && str.equals("dbg")) {
            return this.ww;
        }
        if (this.wv != null && str.equals("stat")) {
            return this.wv;
        }
        if (this.wy != null && str.equals("pfmonitor")) {
            return this.wy;
        }
        return this.wx;
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

    public long hF() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.wz == null) {
                this.wz = new BdStatSwitchData();
            }
            uploadMilliInterval = this.wz.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }

    public void handleException() {
        this.wv.handleException();
        this.wx.handleException();
        this.ww.handleException();
        this.wy.handleException();
    }

    public void hG() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.wz == null) {
                this.wz = new BdStatSwitchData();
            }
            uploadMilliInterval = this.wz.getUploadMilliInterval();
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
        if (this.wu) {
            new l(this, bdStatBase).execute(new Object[0]);
        }
        if (!this.wu && !this.wz.inSpecStrategy() && this.wz.getSpecifiedExpired() > 0) {
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

    private String hH() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(this.wg, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(this.wh, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.wp, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.wm, "utf-8"));
            if (!TextUtils.isEmpty(this.wi)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(this.wi, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.wl, "utf-8"));
            if (!TextUtils.isEmpty(this.mUid)) {
                sb.append("&");
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(this.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.mClientId)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(this.mClientId, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.wq)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.wq, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.wj)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(this.wj, "utf-8"));
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
    private String A(boolean z) {
        String str;
        String[] split;
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = this.wp;
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
                a(sb, "_phone_imei", this.wq, z);
                a(sb, "_client_id", this.mClientId, z);
                if (!TextUtils.isEmpty(this.wr)) {
                    a(sb, "subapp_type", this.wr, z);
                }
                a(sb, "from", this.wi, z);
                a(sb, "net_type", this.ws, z);
                a(sb, "cuid", this.mCuid, z);
                a(sb, "model", this.wl, z);
                if (!TextUtils.isEmpty(this.mUid)) {
                    a(sb, "uid", GameInfoData.NOT_FROM_DETAIL, z);
                } else {
                    a(sb, "uid", this.mUid, z);
                }
                a(sb, "un", this.wj, z);
                a(sb, "BDUSS", this.wk, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.wq, z);
        a(sb, "_client_id", this.mClientId, z);
        if (!TextUtils.isEmpty(this.wr)) {
        }
        a(sb, "from", this.wi, z);
        a(sb, "net_type", this.ws, z);
        a(sb, "cuid", this.mCuid, z);
        a(sb, "model", this.wl, z);
        if (!TextUtils.isEmpty(this.mUid)) {
        }
        a(sb, "un", this.wj, z);
        a(sb, "BDUSS", this.wk, z);
        return sb.toString();
    }

    public void c(BdStatBase bdStatBase) {
        String A;
        if (bdStatBase != null && !bdStatBase.ismIsUploading() && bdStatBase.ismIsLogOpen()) {
            bdStatBase.setmIsUploading(true);
            bdStatBase.splitFile();
            try {
                if (bdStatBase.getPostFileName() != null && bdStatBase.getPostFileName().equals("omp")) {
                    A = hH();
                } else {
                    A = A(true);
                }
                if (bdStatBase.checkFileFailed()) {
                    ArrayList<String> memData = bdStatBase.getMemData();
                    bdStatBase.clearMemData();
                    ArrayList<String> filter = bdStatBase.filter(memData);
                    if (filter != null && filter.size() > 0) {
                        a(bdStatBase, A, filter, (ArrayList<s>) null);
                    }
                } else {
                    BdUploadingLogInfo logFiles = bdStatBase.getLogFiles();
                    int size = logFiles.size();
                    if (logFiles != null && size > 0) {
                        for (int i = 0; i < size; i++) {
                            ArrayList<String> filter2 = bdStatBase.filter(logFiles.getLogStringByIndex(i));
                            if (filter2 != null && filter2.size() != 0) {
                                a(bdStatBase, A, filter2, logFiles.get(i));
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
                arrayList3.add(new BasicNameValuePair("_client_version", this.wp));
                arrayList3.add(new BasicNameValuePair("_phone_imei", this.wq));
                arrayList3.add(new BasicNameValuePair("_client_id", this.mClientId));
                if (!TextUtils.isEmpty(this.wr)) {
                    arrayList3.add(new BasicNameValuePair("subapp_type", this.wr));
                }
                arrayList3.add(new BasicNameValuePair("from", this.wi));
                arrayList3.add(new BasicNameValuePair("net_type", this.ws));
                arrayList3.add(new BasicNameValuePair("cuid", this.mCuid));
                arrayList3.add(new BasicNameValuePair("model", this.wl));
                if (TextUtils.isEmpty(this.mUid)) {
                    arrayList3.add(new BasicNameValuePair("uid", GameInfoData.NOT_FROM_DETAIL));
                } else {
                    arrayList3.add(new BasicNameValuePair("uid", this.mUid));
                }
                arrayList3.add(new BasicNameValuePair("un", this.wj));
                arrayList3.add(new BasicNameValuePair("BDUSS", this.wk));
                String str2 = this.wn;
                if (bdStatBase != null && (bdStatBase instanceof BdPerformanceLog) && BdStatisticsSwitchStatic.hJ()) {
                    str2 = "http://nlog.baidu.com/dplog/n";
                }
                com.baidu.adp.lib.network.http.g a2 = new com.baidu.adp.lib.network.a.a().a(str2, false, arrayList3, hashMap, 3, -1, (LinkedList<BasicNameValuePair>) null);
                if (a2 != null && a2.responseCode == 200) {
                    try {
                        if (new JSONObject(new String(a2.vk, "utf-8")).optInt("error_code", -1) == 0) {
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
        intent.setAction("adp.bdstatisticsmanager.multiprocess");
        intent.putExtra("intent_data_multiprocess_type", 2);
        this.mContext.sendBroadcast(intent);
    }
}
