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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pluginArch.PluginNameList;
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
    private static final BdUniqueId lJ = BdUniqueId.gen();
    private static f lK;
    private String lL;
    private String lM;
    private String lN;
    private String lO;
    private String lP;
    private String lQ;
    private String lR;
    private String lS;
    private String lT;
    private String lU;
    private String lV;
    private String mBduss;
    private Context mContext;
    private String mCuid;
    private String mUid;
    private k mf;
    private h mg;
    private j mh;
    private String mNetType = null;
    private String lW = null;
    private r lX = null;
    private boolean lY = false;
    private BdStatLog lZ = null;
    private BdDebugLog ma = null;
    private BdErrorLog mb = null;
    private BdPerformanceLog mc = null;
    private Handler mHandler = null;
    private BdStatSwitchData md = null;
    private BdAsyncTaskParallel mi = null;
    SimpleDateFormat mj = new SimpleDateFormat("yy-MM-dd_HH-mm-ss");

    public r ep() {
        return this.lX;
    }

    public String eq() {
        return this.lU;
    }

    public static f er() {
        synchronized (f.class) {
            if (lK == null) {
                lK = new f();
            }
        }
        return lK;
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, r rVar, boolean z) {
        this.mContext = context;
        this.lS = str;
        this.lT = str2;
        this.lL = str3;
        this.lM = str4;
        this.lU = str5;
        this.lN = str6;
        this.lP = str7;
        this.mCuid = str8;
        this.lQ = Build.MODEL;
        this.lR = Build.VERSION.RELEASE;
        this.lV = str9;
        this.lX = rVar;
        this.lY = z;
        if (this.mf == null && context != null) {
            try {
                this.mf = new k(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.mf, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.mg == null && context != null) {
            this.mg = new h(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager2.account_changed");
            context.registerReceiver(this.mg, intentFilter2);
        }
        if (this.mh == null && context != null) {
            this.mh = new j(this, null);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("adp.bdstatisticsmanager2.multiprocess");
            context.registerReceiver(this.mh, intentFilter3);
        }
        if (TextUtils.isEmpty(str10)) {
            str10 = "stat";
        }
        if (this.mHandler == null) {
            this.mHandler = new g(this);
        }
        this.md = new BdStatSwitchData();
        if (this.lZ == null) {
            this.lZ = new BdStatLog(context, str10, this.lY);
        }
        if (this.ma == null) {
            this.ma = new BdDebugLog(context, str10, this.lY);
        }
        if (this.mb == null) {
            this.mb = new BdErrorLog(context, str10, this.lY);
        }
        if (this.mc == null) {
            this.mc = new BdPerformanceLog(context, str10, this.lY);
        }
        b(this.md);
        es();
        if (TextUtils.isEmpty(BdStatBase.mProcessNameMd5)) {
            er().eventStat(this.mContext, "logpnmd5", null, 1, new Object[0]);
        }
    }

    public String getImei() {
        return this.lV;
    }

    public void es() {
        new i(this, true).execute(new Object[0]);
    }

    public void et() {
        this.mNetType = p.j(this.mContext);
        this.lW = p.k(this.mContext);
        if (com.baidu.adp.lib.util.j.fh()) {
            boolean fi = com.baidu.adp.lib.util.j.fi();
            if (this.lZ != null) {
                this.lZ.setmIsNetworkWifi(fi);
            }
            if (this.ma != null) {
                this.ma.setmIsNetworkWifi(fi);
            }
            if (this.mb != null) {
                this.mb.setmIsNetworkWifi(fi);
            }
            if (this.mc != null) {
                this.mc.setmIsNetworkWifi(fi);
            }
        }
    }

    public String eu() {
        return this.mNetType;
    }

    public q ag(String str) {
        return new q(str);
    }

    public synchronized void b(String str, String str2, String str3) {
        if ((this.mUid != null || str != null) && (this.mUid == null || !this.mUid.equals(str))) {
            this.mUid = str;
            this.lO = str2;
            this.mBduss = str3;
            save();
        }
    }

    public void b(String str, Object... objArr) {
        BdStatBase aj;
        if (!TextUtils.isEmpty(str) && objArr != null && objArr.length != 0 && (aj = aj(str)) != null && aj.ismIsLogOpen()) {
            q qVar = new q(str);
            qVar.c(objArr);
            aj.add(qVar);
        }
    }

    public void ah(String str) {
        a(aj(str), true, true);
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
        BdStatBase aj = aj("net");
        if (aj != null && aj.ismIsLogOpen() && aj.isSubTypeOpen(str) && !m.eB().ak("net")) {
            q qVar = new q("net");
            qVar.c("module", "net", "st", str, "net", this.mNetType, "interface", str2, "cost", Long.valueOf(j3), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.c(objArr);
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
            aj.add(qVar);
        }
    }

    public void a(String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        a(true, "d", str, str2, str3, j, i, str4, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, String str4, long j, int i, String str5, Object... objArr) {
        BdStatBase aj = aj("op");
        if (aj != null && aj.ismIsLogOpen() && aj.isSubTypeOpen(str)) {
            if (!z || !m.eB().ak("op")) {
                q qVar = new q("op");
                qVar.c("module", "op", "st", str, "op_key", str2, "sid", str3, "f", str4, "cost", Long.valueOf(j), "result", Integer.valueOf(i), "es", str5, "t", String.valueOf(System.currentTimeMillis()));
                if (objArr != null && objArr.length > 0) {
                    qVar.c(objArr);
                }
                aj.add(qVar);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5, Object... objArr) {
        a(true, str, str2, str3, str4, 0L, i, str5, objArr);
    }

    public void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eB().ak("file")) {
            a(true, "file", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eB().ak("db")) {
            a(true, "db", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eB().ak("voice")) {
            a(true, "voice", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void d(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eB().ak(PluginNameList.NAME_LIVE)) {
            a(true, PluginNameList.NAME_LIVE, str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void e(String str, String str2, String str3, int i, String str4, Object... objArr) {
        if (!m.eB().ak("aladin_port_error")) {
            a(true, "aladin_port_error", str, str2, str3, 0L, i, str4, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        BdStatBase aj = aj("crash");
        if (aj != null && aj.ismIsLogOpen()) {
            q qVar = new q("crash");
            qVar.c("module", "crash", "crash_type", str, "ci", str2, "f", str3, "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.c(objArr);
            }
            aj.add(qVar);
        }
    }

    public void c(String str, Object... objArr) {
        BdStatBase aj = aj("dbg");
        if (aj != null && aj.ismIsLogOpen() && aj.isSubTypeOpen(str)) {
            q qVar = new q("dbg");
            qVar.c("module", "dbg", "st", str, "t", this.mj.format(new Date()));
            if (objArr != null && objArr.length > 0) {
                qVar.c(objArr);
            }
            aj.add(qVar);
        }
    }

    public void a(String str, q qVar) {
        BdStatBase aj = aj("dbg");
        if (qVar != null && aj != null && aj.ismIsLogOpen() && aj.isSubTypeOpen(str)) {
            qVar.n("module", "dbg");
            qVar.n("st", str);
            qVar.n("t", this.mj.format(new Date()));
            aj.add(qVar);
        }
    }

    public void b(String str, q qVar) {
        BdStatBase aj = aj("pfmonitor");
        if (qVar != null && aj != null && aj.ismIsLogOpen() && aj.isSubTypeOpen(str)) {
            qVar.n("module", "pfmonitor");
            qVar.n("st", str);
            qVar.n("t", this.mj.format(new Date()));
            aj.add(qVar);
        }
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        BdStatBase aj = aj("stat");
        if (aj != null && aj.ismIsLogOpen()) {
            q qVar = new q("stat");
            qVar.c("module", "stat", "op_key", str, "pt", str2, "co", Integer.valueOf(i), "t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                qVar.c(objArr);
                qVar.b("mi", 0);
            }
            aj.add(qVar);
        }
    }

    public void save() {
        if (this.lZ != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.lZ));
        }
        if (this.mb != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.mb));
        }
        if (this.ma != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.ma));
        }
        if (this.mc != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 1, 0, this.mc));
        }
    }

    public void ev() {
        String eN = this.lX.eN();
        if (!com.baidu.adp.lib.util.l.aA(eN)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(eN);
            b(bdStatSwitchData);
        }
        if (this.lZ != null) {
            long eO = this.lX.eO();
            if (eO <= 0) {
                eO = System.currentTimeMillis();
                this.lX.d(eO);
            }
            this.lZ.setmLastUploadTime(eO);
        }
        if (this.mb != null) {
            long eR = this.lX.eR();
            if (eR <= 0) {
                eR = System.currentTimeMillis();
                this.lX.g(eR);
            }
            this.mb.setmLastUploadTime(eR);
        }
        if (this.ma != null) {
            long eP = this.lX.eP();
            if (eP <= 0) {
                eP = System.currentTimeMillis();
                this.lX.e(eP);
            }
            this.ma.setmLastUploadTime(eP);
        }
        if (this.mc != null) {
            long eQ = this.lX.eQ();
            if (eQ <= 0) {
                eQ = System.currentTimeMillis();
                this.lX.f(eQ);
            }
            this.mc.setmLastUploadTime(eQ);
        }
    }

    public void ai(String str) {
        if (!TextUtils.isEmpty(str)) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            bdStatSwitchData.parserJson(str);
            a(bdStatSwitchData);
        }
    }

    public void a(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null && bdStatSwitchData.getError_code() == 0) {
            b(bdStatSwitchData);
            this.lX.am(bdStatSwitchData.getmData());
            if (bdStatSwitchData.getDebug() != null && bdStatSwitchData.getDebug().getCommon() != null && !bdStatSwitchData.getDebug().getCommon().isIs_open()) {
                this.ma.clearLogs();
            }
            if (bdStatSwitchData.getError() != null && bdStatSwitchData.getError().getCommon() != null && !bdStatSwitchData.getError().getCommon().isIs_open()) {
                this.mb.clearLogs();
            }
            if (bdStatSwitchData.getStat() != null && bdStatSwitchData.getStat().getCommon() != null && !bdStatSwitchData.getStat().getCommon().isIs_open()) {
                this.lZ.clearLogs();
            }
            if (bdStatSwitchData.getPerformance() != null && bdStatSwitchData.getPerformance().getCommon() != null && !bdStatSwitchData.getPerformance().getCommon().isIs_open()) {
                this.mc.clearLogs();
            }
            ey();
        }
    }

    public String ew() {
        try {
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.md.inSpecStrategy()) {
            return null;
        }
        com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.dY().a(String.valueOf(this.lT) + "?t=" + System.currentTimeMillis(), 3, -1, 30000, null, null, null);
        if (a != null) {
            return new String(a.data, "utf-8");
        }
        return null;
    }

    private void b(BdStatSwitchData bdStatSwitchData) {
        if (bdStatSwitchData != null) {
            synchronized (BdStatSwitchData.class) {
                this.md = bdStatSwitchData;
                if (this.md.getError() != null && this.mb != null) {
                    this.mb.setSwitchData(this.md.getError());
                }
                if (this.md.getStat() != null && this.lZ != null) {
                    this.lZ.setSwitchData(this.md.getStat());
                }
                if (this.md.getDebug() != null && this.ma != null) {
                    this.ma.setSwitchData(this.md.getDebug());
                }
                if (this.md.getPerformance() != null && this.mc != null) {
                    this.mc.setSwitchData(this.md.getPerformance());
                }
            }
        }
    }

    private BdStatBase aj(String str) {
        if (this.mb != null && (str.equals("net") || str.equals("op") || str.equals("crash"))) {
            return this.mb;
        }
        if (this.ma != null && str.equals("dbg")) {
            return this.ma;
        }
        if (this.lZ != null && str.equals("stat")) {
            return this.lZ;
        }
        if (this.mc != null && str.equals("pfmonitor")) {
            return this.mc;
        }
        return this.mb;
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

    public long ex() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.md == null) {
                this.md = new BdStatSwitchData();
            }
            uploadMilliInterval = this.md.getUploadMilliInterval();
        }
        return uploadMilliInterval;
    }

    public void ey() {
        long uploadMilliInterval;
        synchronized (BdStatSwitchData.class) {
            if (this.md == null) {
                this.md = new BdStatSwitchData();
            }
            uploadMilliInterval = this.md.getUploadMilliInterval();
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
        if (this.lY) {
            new l(this, bdStatBase).execute(new Object[0]);
        }
        if (!this.lY && !this.md.inSpecStrategy() && this.md.getSpecifiedExpired() > 0) {
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

    private String ez() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lL, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lM, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lU, "utf-8"));
            sb.append("&");
            sb.append("os");
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lR, "utf-8"));
            if (!TextUtils.isEmpty(this.lN)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(this.lN, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(this.lQ, "utf-8"));
            if (!TextUtils.isEmpty(this.mUid)) {
                sb.append("&");
                sb.append(SapiAccountManager.SESSION_UID);
                sb.append("=");
                sb.append(URLEncoder.encode(this.mUid, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.lP)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(this.lP, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.lV)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(this.lV, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.lO)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(this.lO, "utf-8"));
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
    private String v(boolean z) {
        String str;
        String[] split;
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        String str2 = this.lU;
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
                a(sb, "_phone_imei", this.lV, z);
                a(sb, "_client_id", this.lP, z);
                a(sb, "from", this.lN, z);
                a(sb, "net_type", this.lW, z);
                a(sb, "cuid", this.mCuid, z);
                a(sb, "model", this.lQ, z);
                if (!TextUtils.isEmpty(this.mUid)) {
                    a(sb, SapiAccountManager.SESSION_UID, "0", z);
                } else {
                    a(sb, SapiAccountManager.SESSION_UID, this.mUid, z);
                }
                a(sb, "un", this.lO, z);
                a(sb, "BDUSS", this.mBduss, z);
                return sb.toString();
            }
        }
        str = str2;
        a(sb, "_client_version", str, z);
        a(sb, "_phone_imei", this.lV, z);
        a(sb, "_client_id", this.lP, z);
        a(sb, "from", this.lN, z);
        a(sb, "net_type", this.lW, z);
        a(sb, "cuid", this.mCuid, z);
        a(sb, "model", this.lQ, z);
        if (!TextUtils.isEmpty(this.mUid)) {
        }
        a(sb, "un", this.lO, z);
        a(sb, "BDUSS", this.mBduss, z);
        return sb.toString();
    }

    public void c(BdStatBase bdStatBase) {
        String v;
        if (bdStatBase != null && !bdStatBase.ismIsUploading() && bdStatBase.ismIsLogOpen()) {
            bdStatBase.setmIsUploading(true);
            bdStatBase.splitFile();
            try {
                if (bdStatBase.getPostFileName() != null && bdStatBase.getPostFileName().equals("omp")) {
                    v = ez();
                } else {
                    v = v(true);
                }
                if (bdStatBase.checkFileFailed()) {
                    ArrayList<String> memData = bdStatBase.getMemData();
                    bdStatBase.clearMemData();
                    ArrayList<String> filter = bdStatBase.filter(memData);
                    if (filter != null && filter.size() > 0) {
                        a(bdStatBase, v, filter, (ArrayList<s>) null);
                    }
                } else {
                    BdUploadingLogInfo logFiles = bdStatBase.getLogFiles();
                    int size = logFiles.size();
                    if (logFiles != null && size > 0) {
                        for (int i = 0; i < size; i++) {
                            ArrayList<String> filter2 = bdStatBase.filter(logFiles.getLogStringByIndex(i));
                            if (filter2 != null && filter2.size() != 0) {
                                a(bdStatBase, v, filter2, logFiles.get(i));
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
                com.baidu.adp.lib.util.f.a(a, byteArrayOutputStream);
            } catch (Exception e) {
                BdLog.e(e);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put(bdStatBase.getPostFileName(), byteArray);
            try {
                ArrayList<BasicNameValuePair> arrayList3 = new ArrayList<>();
                arrayList3.add(new BasicNameValuePair("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT));
                arrayList3.add(new BasicNameValuePair("_client_version", this.lU));
                arrayList3.add(new BasicNameValuePair("_phone_imei", this.lV));
                arrayList3.add(new BasicNameValuePair("_client_id", this.lP));
                arrayList3.add(new BasicNameValuePair("from", this.lN));
                arrayList3.add(new BasicNameValuePair("net_type", this.lW));
                arrayList3.add(new BasicNameValuePair("cuid", this.mCuid));
                arrayList3.add(new BasicNameValuePair("model", this.lQ));
                if (TextUtils.isEmpty(this.mUid)) {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, "0"));
                } else {
                    arrayList3.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, this.mUid));
                }
                arrayList3.add(new BasicNameValuePair("un", this.lO));
                arrayList3.add(new BasicNameValuePair("BDUSS", this.mBduss));
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.dY().b(this.lS, false, arrayList3, hashMap, 3, -1, null, null, null, null);
                if (b != null && b.kU == 200) {
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
