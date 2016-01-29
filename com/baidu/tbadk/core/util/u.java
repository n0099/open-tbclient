package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long aaX = 0;
    private static long aaY = 0;
    private static a aaZ = new a(null);
    private static b aba = new b(null);
    private static b abb = new b(null);
    private static String abc = null;
    private static Object we = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        int abv;
        int abw;
        int num;
        long time;
        long vc;

        private b() {
            this.num = 0;
            this.abv = 0;
            this.time = 0L;
            this.vc = 0L;
            this.abw = 0;
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        public void reset() {
            this.num = 0;
            this.abv = 0;
            this.time = 0L;
            this.vc = 0L;
            this.abw = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int abd;
        boolean abe;
        b abf;
        b abg;
        b abh;
        b abi;
        b abj;
        b abk;
        b abl;
        b abm;
        b abn;
        b abo;
        b abp;
        b abq;
        b abr;
        b abt;
        b abu;

        private a() {
            this.abd = 0;
            this.abf = new b(null);
            this.abg = new b(null);
            this.abh = new b(null);
            this.abi = new b(null);
            this.abj = new b(null);
            this.abk = new b(null);
            this.abl = new b(null);
            this.abm = new b(null);
            this.abn = new b(null);
            this.abo = new b(null);
            this.abp = new b(null);
            this.abq = new b(null);
            this.abr = new b(null);
            this.abt = new b(null);
            this.abu = new b(null);
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=4] */
        public int vl() {
            return this.abf.num + this.abg.num + this.abh.num + this.abi.num + this.abj.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [94=14] */
        public int vm() {
            return this.abf.num + this.abg.num + this.abh.num + this.abi.num + this.abj.num + this.abk.num + this.abl.num + this.abm.num + this.abn.num + this.abo.num + this.abp.num + this.abq.num + this.abr.num + this.abt.num + this.abu.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        public int vn() {
            return this.abk.num + this.abl.num + this.abm.num + this.abn.num + this.abo.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [111=4] */
        public int vo() {
            return this.abp.num + this.abq.num + this.abr.num + this.abt.num + this.abu.num;
        }

        public void reset() {
            this.abd = 0;
            this.abf.reset();
            this.abg.reset();
            this.abh.reset();
            this.abi.reset();
            this.abj.reset();
            this.abk.reset();
            this.abl.reset();
            this.abm.reset();
            this.abn.reset();
            this.abo.reset();
            this.abp.reset();
            this.abq.reset();
            this.abr.reset();
            this.abt.reset();
            this.abu.reset();
        }

        public void vp() {
            if (u.aaZ.vl() > 0) {
                com.baidu.tbadk.performanceLog.x.a(u.aaZ.abf.num, u.aaZ.abf.abv, u.aaZ.abf.abw, u.aaZ.abf.vc, u.aaZ.abf.time, u.aaZ.abg.num, u.aaZ.abg.abv, u.aaZ.abg.abw, u.aaZ.abg.time, u.aaZ.abg.vc, u.aaZ.abh.num, u.aaZ.abh.abv, u.aaZ.abh.abw, u.aaZ.abh.time, u.aaZ.abh.vc, u.aaZ.abj.num, u.aaZ.abj.abv, u.aaZ.abj.abw, u.aaZ.abj.time, u.aaZ.abj.vc, u.aaZ.abi.num, u.aaZ.abi.abv, u.aaZ.abi.abw, u.aaZ.abi.time, u.aaZ.abi.vc, 3);
            }
        }

        public void vq() {
            if (u.aaZ.vn() > 0) {
                com.baidu.tbadk.performanceLog.x.a(u.aaZ.abk.num, u.aaZ.abk.abv, u.aaZ.abk.abw, u.aaZ.abk.time, u.aaZ.abk.vc, u.aaZ.abl.num, u.aaZ.abl.abv, u.aaZ.abl.abw, u.aaZ.abl.time, u.aaZ.abl.vc, u.aaZ.abm.num, u.aaZ.abm.abv, u.aaZ.abm.abw, u.aaZ.abm.time, u.aaZ.abm.vc, u.aaZ.abo.num, u.aaZ.abo.abv, u.aaZ.abo.abw, u.aaZ.abo.time, u.aaZ.abo.vc, u.aaZ.abn.num, u.aaZ.abn.abv, u.aaZ.abn.abw, u.aaZ.abn.time, u.aaZ.abn.vc, 1);
            }
        }

        public void vr() {
            if (u.aaZ.vo() > 0) {
                com.baidu.tbadk.performanceLog.x.a(u.aaZ.abp.num, u.aaZ.abp.abv, u.aaZ.abp.abw, u.aaZ.abp.time, u.aaZ.abp.vc, u.aaZ.abq.num, u.aaZ.abq.abv, u.aaZ.abq.abw, u.aaZ.abq.time, u.aaZ.abq.vc, u.aaZ.abr.num, u.aaZ.abr.abv, u.aaZ.abr.abw, u.aaZ.abr.time, u.aaZ.abr.vc, u.aaZ.abu.num, u.aaZ.abu.abv, u.aaZ.abu.abw, u.aaZ.abu.time, u.aaZ.abu.vc, u.aaZ.abt.num, u.aaZ.abt.abv, u.aaZ.abt.abw, u.aaZ.abt.time, u.aaZ.abt.vc, 2);
            }
        }
    }

    private static b a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aaZ.abf;
            }
            if (str.startsWith("http://tb.himg")) {
                return aaZ.abg;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aaZ.abh;
            }
            if (z2 && z3) {
                return aaZ.abj;
            }
            return aaZ.abi;
        } else if (com.baidu.adp.lib.util.i.je()) {
            if (z2) {
                return aaZ.abk;
            }
            if (str.startsWith("http://tb.himg")) {
                return aaZ.abl;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aaZ.abm;
            }
            return aaZ.abn;
        } else if (z2) {
            return aaZ.abp;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aaZ.abq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aaZ.abr;
            }
            return aaZ.abt;
        }
    }

    public static com.baidu.adp.lib.stats.d hm() {
        return com.baidu.adp.lib.stats.a.ht().aq("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (we) {
                aba.num++;
                aba.time += j;
                if (aba.num >= 100) {
                    vd();
                }
            }
        }
    }

    public static void vd() {
        if (aba.num > 10) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("act", "locStat");
            hm.r("costTime", String.valueOf(aba.time));
            hm.r("num", String.valueOf(aba.num));
            hm.r("isWifi", "1");
            com.baidu.adp.lib.stats.a.ht().b("img", hm);
            aba.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar2, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.jq()) {
            String str6 = "";
            boolean gb = com.baidu.tbadk.util.e.gb(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().adS) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean ja = com.baidu.adp.lib.util.i.ja();
            if (!z5) {
                z4 = false;
            } else if (ja) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SE);
            } else if (com.baidu.adp.lib.util.i.je()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SG);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SF);
            }
            boolean z6 = false;
            if (gb && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gb && ja && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.vs().vt();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar2.vj, str);
                    }
                }
            }
            if (gb) {
                abc = str;
            }
            boolean z7 = false;
            if (dVar2.vl != null && dVar2.vl.length() > 0) {
                z7 = true;
            }
            synchronized (we) {
                b a2 = a(ja, gb, str2, z7);
                boolean z8 = aaZ.abe;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.vc += j2;
                        aaZ.abe = true;
                        if (z4) {
                            a2.abw++;
                        }
                    } else {
                        a2.abv++;
                        aaZ.abe = false;
                    }
                }
                int vm = aaZ.vm();
                if (vm > 100 || (vm > 0 && z8 != aaZ.abe)) {
                    ve();
                }
            }
            if (z && z5) {
                if (!ja || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SE) {
                    if (ja || !com.baidu.adp.lib.util.i.je() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SG) {
                        if (!ja && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SF) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (dVar == null) {
                dVar = hm();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.vs().vt();
            }
            if (!gb || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.vs().dl(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = vg();
            }
            dVar.r("url", str);
            dVar.r("act", "dl");
            dVar.r("result", z ? "1" : "0");
            dVar.r("fullurl", str2);
            dVar.r("costTime", String.valueOf(j));
            dVar.r("connTime", String.valueOf(dVar2.vd));
            dVar.r("rspTime", String.valueOf(dVar2.ve));
            dVar.r("retry", String.valueOf(dVar2.vf));
            dVar.r("localIp", e.getIp());
            dVar.r("tiebaIp", str6);
            dVar.r("cdnIp", str4);
            dVar.r("useIp", dVar2.vl);
            dVar.r("dnsIp", str5);
            if (dVar2.vd > 1500 || dVar2.vd < 0) {
                dVar.r("connBaidu", String.valueOf(vh()));
            }
            dVar.r("memory", vi());
            dVar.r("task", vj());
            dVar.r("isWifi", ja ? "1" : "0");
            dVar.r("status", String.valueOf(dVar2.vk));
            dVar.r("up", String.valueOf(dVar2.vb));
            dVar.r("down", String.valueOf(dVar2.vc));
            dVar.r("isCDN", gb ? "1" : "0");
            dVar.r("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.r("isMobileProxy", z3 ? "1" : "0");
            dVar.r("exception", dVar2.vi);
            dVar.r("reason", str3);
            if (i != 0) {
                dVar.b("procType", Integer.valueOf(i));
            }
            com.baidu.adp.lib.stats.a.ht().b("img", dVar);
            if (gb && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aaZ.abd++;
            }
        }
    }

    public static void ve() {
        if (aaZ.vm() > 10) {
            if (aaZ.vl() > 0) {
                a(aaZ.abf, aaZ.abg, aaZ.abh, aaZ.abj, aaZ.abi, 10000);
            }
            if (aaZ.vo() > 0) {
                a(aaZ.abp, aaZ.abq, aaZ.abr, aaZ.abu, aaZ.abt, 100002);
            }
            if (aaZ.vn() > 0) {
                a(aaZ.abk, aaZ.abl, aaZ.abm, aaZ.abo, aaZ.abn, 100001);
            }
            aaZ.vp();
            aaZ.vq();
            aaZ.vr();
            aaZ.reset();
        }
    }

    public static void a(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, int i) {
        if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null && bVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.vs().vt();
            }
            if (abc != null && TextUtils.isEmpty("")) {
                str2 = v.vs().dl(abc);
            }
            if (TextUtils.isEmpty("")) {
                str3 = vg();
            }
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("act", "dlStat");
            hm.r("cdnCostTime", String.valueOf(bVar.time));
            hm.r("cdnNum", String.valueOf(bVar.num));
            hm.r("cdnFailnum", String.valueOf(bVar.abv));
            hm.r("portraitCostTime", String.valueOf(bVar2.time));
            hm.r("portraitNum", String.valueOf(bVar2.num));
            hm.r("portraitFailnum", String.valueOf(bVar2.abv));
            hm.r("tiebaCostTime", String.valueOf(bVar3.time));
            hm.r("tiebaNum", String.valueOf(bVar3.num));
            hm.r("tiebaFailnum", String.valueOf(bVar3.abv));
            hm.r("otherCostTime", String.valueOf(bVar5.time));
            hm.r("otherNum", String.valueOf(bVar5.num));
            hm.r("otherFailnum", String.valueOf(bVar5.abv));
            hm.r("directIpCostTime", String.valueOf(bVar4.time));
            hm.r("directIpNum", String.valueOf(bVar4.num));
            hm.r("directIpFailnum", String.valueOf(bVar4.abv));
            hm.r("dnsFailNum", String.valueOf(aaZ.abd));
            if (10000 == i) {
                hm.r("isWifi", "1");
                hm.r("netType", "WIFI");
            } else if (100002 == i) {
                hm.r("netType", "3G");
                hm.r("isWifi", "0");
            } else {
                hm.r("netType", "2G");
                hm.r("isWifi", "0");
            }
            hm.r("localIp", e.getIp());
            hm.r("tbIp", str);
            hm.r("cdnIp", str2);
            hm.r("dnsIp", str3);
            com.baidu.adp.lib.stats.a.ht().b("img", hm);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.jq()) {
            synchronized (we) {
                abb.num++;
                if (z) {
                    abb.time += j;
                } else {
                    abb.abv++;
                }
                if (abb.num >= 100) {
                    vf();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = hm();
                }
                dVar.r("act", "dc");
                dVar.r("costTime", String.valueOf(j));
                dVar.r("url", str);
                dVar.r("fullURL", str2);
                dVar.r("isWebp", z3 ? "1" : "0");
                dVar.r("isCDN", z2 ? "1" : "0");
                dVar.r("length", String.valueOf(i));
                dVar.r("reason", str3);
                dVar.r("result", z ? "0" : "1");
                dVar.r("execption", str4);
                com.baidu.adp.lib.stats.a.ht().b("img", dVar);
            }
        }
    }

    public static void vf() {
        if (abb.num > 10) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("act", "dcStat");
            hm.r("costTime", String.valueOf(abb.time));
            hm.r("num", String.valueOf(abb.num));
            hm.r("failnum", String.valueOf(abb.abv));
            com.baidu.adp.lib.stats.a.ht().b("img", hm);
            com.baidu.tbadk.performanceLog.x.a(abb.num, abb.abv, abb.time);
            abb.reset();
        }
    }

    public static void dk(String str) {
        com.baidu.adp.lib.stats.d hm = hm();
        hm.r("act", "assistant");
        hm.r(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.ht().b("img", hm);
    }

    private static String vg() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return String.valueOf(intToIp(dhcpInfo.dns1)) + "," + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [683=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long vh() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aaX >= 3) {
            return aaY;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.h.a.e(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.h.a.e(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.h.a.e(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.h.a.e(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (aaX > -1) {
                aaY = ((aaY * aaX) + j) / (aaX + 1);
            } else {
                aaY = j;
            }
            aaX++;
            return j;
        }
        return j;
    }

    private static String vi() {
        return com.baidu.tbadk.imageManager.c.Ed().fV();
    }

    private static String vj() {
        return com.baidu.adp.lib.asyncTask.c.fW().fV();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d hm = hm();
        hm.r("act", "getCDNList");
        hm.r("errorNum", str);
        hm.r("errorMsg", str2);
        hm.r("isShortNetError", z2 ? "1" : "0");
        hm.r("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.ht().b("img", hm);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.vs().dl(str);
        }
        String vg = vg();
        String ip = e.getIp();
        com.baidu.adp.lib.stats.d hm = hm();
        hm.r("act", "tachometerCDN");
        hm.r("errorNum", str3);
        hm.r("execption", str4);
        hm.r("size", str5);
        hm.r("isScuess", z ? "1" : "0");
        hm.r("url", str);
        hm.r("localIp", ip);
        hm.r("cdnIp", str6);
        hm.r("dnsIP", vg);
        hm.r("usedIp", str2);
        hm.r("isUsedIp", z2 ? "0" : "1");
        hm.r("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.ht().b("img", hm);
    }

    public static void a(ArrayList<String> arrayList, long j) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    if (i2 != 0) {
                        sb.append(",");
                    }
                    sb.append(arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    com.baidu.adp.lib.stats.d hm = hm();
                    hm.r("act", "mobileTachometerCDN");
                    hm.r("costTime", String.valueOf(j));
                    hm.r("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.ht().b("img", hm);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.d hm = hm();
        hm.r("act", "getCDNList");
        hm.r("isSuccess", z ? "1" : "0");
        hm.r("errorMsg", str);
        com.baidu.adp.lib.stats.a.ht().b("img", hm);
    }
}
