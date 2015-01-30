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
    private static final BdUniqueId lN = BdUniqueId.gen();
    private static f lO;
    private String lP;
    private String lQ;
    private String lR;
    private String lS;
    private String lT;
    private String lU;
    private String lV;
    private String lW;
    private String lX;
    private String lY;
    private String mBduss;
    private String mClientId;
    private Context mContext;
    private String mCuid;
    private String mUid;
    private k mi;
    private h mj;
    private j mk;
    private String mNetType = null;
    private String lZ = null;
    private r ma = null;
    private boolean mb = false;
    private BdStatLog mc = null;
    private BdDebugLog md = null;
    private BdErrorLog mf = null;
    private BdPerformanceLog mg = null;
    private Handler mHandler = null;
    private BdStatSwitchData mh = null;
    private BdAsyncTaskParallel ml = null;
    SimpleDateFormat mm = new SimpleDateFormat("yy-MM-dd_HH-mm-ss");

    public r eo() {
        return this.ma;
    }

    public String ep() {
        return this.lX;
    }

    public static void ct() {
        lO = null;
    }

    public static f eq() {
        synchronized (f.class) {
            if (lO == null) {
                lO = new f();
            }
        }
        return lO;
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, r rVar, boolean z) {
        this.mContext = context;
        this.lV = str;
        this.lW = str2;
        this.lP = str3;
        this.lQ = str4;
        this.lX = str5;
        this.lR = str6;
        this.mClientId = str7;
        this.mCuid = str8;
        this.lT = Build.MODEL;
        this.lU = Build.VERSION.RELEASE;
        this.lY = str9;
        this.ma = rVar;
        this.mb = z;
        if (this.mi == null && context != null) {
            try {
                this.mi = new k(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.mi, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.mj == null && context != null) {
            this.mj = new h(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager2.account_changed");
            context.registerReceiver(this.mj, intentFilter2);
        }
        if (this.mk == null && context != null) {
            this.mk = new j(this, null);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("adp.bdstatisticsmanager2.multiprocess");
            context.registerReceiver(this.mk, intentFilter3);
        }
        if (TextUtils.isEmpty(str10)) {
            str10 = "stat";
        }
        if (this.mHandler == null) {
            this.mHandler = new g(this);
        }
        this.mh = new BdStatSwitchData();
        if (this.mc == null) {
            this.mc = new BdStatLog(context, str10, this.mb);
        }
        if (this.md == null) {
            this.md = new BdDebugLog(context, str10, this.mb);
        }
        if (this.mf == null) {
            this.mf = new BdErrorLog(context, str10, this.mb);
        }
        if (this.mg == null) {
            this.mg = new BdPerformanceLog(context, str10, this.mb);
        }
        b(this.mh);
        er();
        if (TextUtils.isEmpty(BdStatBase.mProcessNameMd5)) {
            eq().eventStat(this.mContext, "logpnmd5", null, 1, new Object[0]);
        }
    }

    public String getImei() {
        return this.lY;
    }

    public void er() {
        new i(this, true).execute(new Object[0]);
    }

    public void es() {
        this.mNetType = p.getNetType(this.mContext);
        this.lZ = p.H(this.mContext);
        if (com.baidu.adp.lib.util.i.ff()) {
            boolean fg = com.baidu.adp.lib.util.i.fg();
            if (this.mc != null) {
                this.mc.setmIsNetworkWifi(fg);
            }
            if (this.md != null) {
                this.md.setmIsNetworkWifi(fg);
            }
            if (this.mf != null) {
                this.mf.setmIsNetworkWifi(fg);
            }
            if (this.mg != null) {
                this.mg.setmIsNetworkWifi(fg);
            }
        }
    }

    public String et() {
        return this.mNetType;
    }

    public q ak(String str) {
        return new q(str);
    }

    public synchronized void f(String str, String str2, String str3) {
        if ((this.mUid != null || str != null) && (this.mUid == null || !this.mUid.equals(str))) {
            this.mUid = str;
            this.lS = str2;
            this.mBduss = str3;
            save();
        }
    }

    public void log(String str, Object... objArr) {
        BdStatBase an;
        if (!TextUtils.isEmpty(str) && objArr != null && objArr.length != 0 && (an = an(str)) != null && an.ismIsLogOpen()) {
            q qVar = new q(str);
            qVar.f(objArr);
            an.add(qVar);
        }
    }

    public void al(String str) {
        a(an(str), true, true);
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
        BdStatBase an = an("net");
        if (an != null && an.ismIsLogOpen() && an.isSubTypeOpen(str) && !m.eA().ao("net")) {
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
            an.add(qVar);
        }
    }

    public void a(String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        a(true, "d", str, str2, str3, j, i, str4, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, String str4, long j, int i, String str5, Object... objArr) {
        BdStatBase an = an("op");
        if (an != null && an.ismIsLogOpen() && an.isSubTypeOpen(str)) {
            if (!z || !m.eA().ao("op")) {
                q qVar = new q("op");
                qVar.f("module", "op", "st", str, "op_key", str2, "sid", str3, "f", str4, "cost", Long.valueOf(j), "result", Integer.valueOf(i), "es", str5, "t", String.valueOf(System.currentTimeMillis()));
                if (objArr != null && objArr.length > 0) {
                    qVar.f(objArr);
                }
                an.add(qVar);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5, Object... objArr) {
        a(true, str, str2, str3, str4, 0L, i, str5, objArr);
    }

    public void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eA().ao("file")) {
            a(true, "file", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eA().ao("db")) {
            a(true, "db", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eA().ao("voice")) {
            a(true, "voice", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void d(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eA().ao("live")) {
            a(true, "live", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void e(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eA().ao("aladin_port_error")) {
            a(true, "aladin_port_error", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        BdStatBase an = an("crash");
        if (an != null && an.ismIsLogOpen()) {
            q qVar = new q("crash");
            qVar.f("module", "crash", "crash_type", str, "ci", str2, "f", str3, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
            }
            an.add(qVar);
        }
    }

    public void b(String str, Object... objArr) {
        BdStatBase an = an("dbg");
        if (an != null && an.ismIsLogOpen() && an.isSubTypeOpen(str)) {
            q qVar = new q("dbg");
            qVar.f("module", "dbg", "st", str, "t", this.mm.format(new Date()));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
            }
            an.add(qVar);
        }
    }

    public void a(String str, q qVar) {
        BdStatBase an = an("dbg");
        if (qVar != null && an != null && an.ismIsLogOpen() && an.isSubTypeOpen(str)) {
            qVar.r("module", "dbg");
            qVar.r("st", str);
            qVar.r("t", this.mm.format(new Date()));
            an.add(qVar);
        }
    }

    public void b(String str, q qVar) {
        BdStatBase an = an("pfmonitor");
        if (qVar != null && an != null && an.ismIsLogOpen() && an.isSubTypeOpen(str)) {
            qVar.r("module", "pfmonitor");
            qVar.r("st", str);
            qVar.r("t", this.mm.format(new Date()));
            an.add(qVar);
        }
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        BdStatBase an = an("stat");
        if (an != null && an.ismIsLogOpen()) {
            q qVar = new q("stat");
            qVar.f("module", "stat", "op_key", str, "pt", str2, "co", Integer.valueOf(i), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
                qVar.b("mi", 0);
            }
            an.add(qVar);
        }
    }

    public void save() {
        if (this.mc != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.mc));
        }
        if (this.mf != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.mf));
        }
        if (this.md != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.md));
        }
        if (this.mg != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.mg));
        }
    }

    public void eu() {
        String eM = this.ma.eM();
        if (!com.baidu.adp.lib.util.k.isEmpty(eM)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(eM);
            b(bdStatSwitchData);
        }
        if (this.mc != null) {
            long eN = this.ma.eN();
            if (eN <= 0) {
                eN = System.currentTimeMillis();
                this.ma.h(eN);
            }
            this.mc.setmLastUploadTime(eN);
        }
        if (this.mf != null) {
            long eQ = this.ma.eQ();
            if (eQ <= 0) {
                eQ = System.currentTimeMillis();
                this.ma.k(eQ);
            }
            this.mf.setmLastUploadTime(eQ);
        }
        if (this.md != null) {
            long eO = this.ma.eO();
            if (eO <= 0) {
                eO = System.currentTimeMillis();
                this.ma.i(eO);
            }
            this.md.setmLastUploadTime(eO);
        }
        if (this.mg != null) {
            long eP = this.ma.eP();
            if (eP <= 0) {
                eP = System.currentTimeMillis();
                this.ma.j(eP);
            }
            this.mg.setmLastUploadTime(eP);
        }
    }

    public void am(String str) {
        if (!TextUtils.isEmpty(str)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(str);
            a(bdStatSwitchData);
        }
    }

    public void a(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null && bdStatSwitchData.getError_code() == 0) {
            b(bdStatSwitchData);
            this.ma.aq(bdStatSwitchData.getmData());
            if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                this.md.clearLogs();
            }
            if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                this.mf.clearLogs();
            }
            if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                this.mc.clearLogs();
            }
            if (bdStatSwitchData.getPerformance() != null && bdStatSwitchData.getPerformance().getCommon() != null && !bdStatSwitchData.getPerformance().getCommon().isIs_open()) {
                this.mg.clearLogs();
            }
            ex();
        }
    }

    public String ev() {
        try {
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.mh.inSpecStrategy()) {
            return null;
        }
        com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.dV().a(String.valueOf(this.lW) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, null, null, null);
        if (a != null) {
            return new String(a.data, "utf-8");
        }
        return null;
    }

    private void b(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            synchronized (BdStatSwitchData.class) {
                this.mh = bdStatSwitchData;
                if (this.mh.getError() != null && this.mf != null) {
                    this.mf.setSwitchData(this.mh.getError());
                }
                if (this.mh.getStat() != null && this.mc != null) {
                    this.mc.setSwitchData(this.mh.getStat());
                }
                if (this.mh.getDebug() != null && this.md != null) {
                    this.md.setSwitchData(this.mh.getDebug());
                }
                if (this.mh.getPerformance() != null && this.mg != null) {
                    this.mg.setSwitchData(this.mh.getPerformance());
                }
            }
        }
    }

    private BdStatBase an(String str) {
        if (this.mf != null && (str.equals("net") || str.equals("op") || str.equals("crash"))) {
            return this.mf;
        }
        if (this.md != null && str.equals("dbg")) {
            return this.md;
        }
        if (this.mc != null && str.equals("stat")) {
            return this.mc;
        }
        if (this.mg != null && str.equals("pfmonitor")) {
            return this.mg;
        }
        return this.mf;
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

    public long ew() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.mh == null) {
                this.mh = new BdStatSwitchData();
            }
            uploadMilliInterval = this.mh.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }

    public void ex() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.mh == null) {
                this.mh = new BdStatSwitchData();
            }
            uploadMilliInterval = this.mh.getUploadMilliInterval();
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
        if (this.mb) {
            new l(this, bdStatBase).execute(new Object[0]);
        }
        if (!this.mb && !this.mh.inSpecStrategy() && this.mh.getSpecifiedExpired() > 0) {
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

    private String ey() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lP, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lQ, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lX, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lU, "utf-8"));
            if (!TextUtils.isEmpty(this.lR)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(this.lR, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lT, "utf-8"));
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
            if (!TextUtils.isEmpty(this.lY)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.lY, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.lS)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(this.lS, "utf-8"));
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

    /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String B(boolean z) {
        String str;
        String[] split;
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = this.lX;
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
                a(sb, "_phone_imei", this.lY, z);
                a(sb, "_client_id", this.mClientId, z);
                a(sb, "from", this.lR, z);
                a(sb, "net_type", this.lZ, z);
                a(sb, "cuid", this.mCuid, z);
                a(sb, "model", this.lT, z);
                if (!TextUtils.isEmpty(this.mUid)) {
                    a(sb, SapiAccountManager.SESSION_UID, "0", z);
                } else {
                    a(sb, SapiAccountManager.SESSION_UID, this.mUid, z);
                }
                a(sb, "un", this.lS, z);
                a(sb, "BDUSS", this.mBduss, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.lY, z);
        a(sb, "_client_id", this.mClientId, z);
        a(sb, "from", this.lR, z);
        a(sb, "net_type", this.lZ, z);
        a(sb, "cuid", this.mCuid, z);
        a(sb, "model", this.lT, z);
        if (!TextUtils.isEmpty(this.mUid)) {
        }
        a(sb, "un", this.lS, z);
        a(sb, "BDUSS", this.mBduss, z);
        return sb.toString();
    }

    public void c(BdStatBase bdStatBase) {
        String B;
        if (bdStatBase != null && !bdStatBase.ismIsUploading() && bdStatBase.ismIsLogOpen()) {
            bdStatBase.setmIsUploading(true);
            bdStatBase.splitFile();
            try {
                if (bdStatBase.getPostFileName() != null && bdStatBase.getPostFileName().equals("omp")) {
                    B = ey();
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
                com.baidu.adp.lib.util.e.a(a, byteArrayOutputStream);
            } catch (Exception e) {
                BdLog.e(e);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put(bdStatBase.getPostFileName(), byteArray);
            try {
                ArrayList<BasicNameValuePair> arrayList3 = new ArrayList<>();
                arrayList3.add(new BasicNameValuePair("_client_type", "2"));
                arrayList3.add(new BasicNameValuePair("_client_version", this.lX));
                arrayList3.add(new BasicNameValuePair("_phone_imei", this.lY));
                arrayList3.add(new BasicNameValuePair("_client_id", this.mClientId));
                arrayList3.add(new BasicNameValuePair("from", this.lR));
                arrayList3.add(new BasicNameValuePair("net_type", this.lZ));
                arrayList3.add(new BasicNameValuePair("cuid", this.mCuid));
                arrayList3.add(new BasicNameValuePair("model", this.lT));
                if (TextUtils.isEmpty(this.mUid)) {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, "0"));
                } else {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, this.mUid));
                }
                arrayList3.add(new BasicNameValuePair("un", this.lS));
                arrayList3.add(new BasicNameValuePair("BDUSS", this.mBduss));
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.dV().b(this.lV, false, arrayList3, hashMap, 3, -1, null, null, null, null);
                if (b != null && b.kY == 200) {
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
