package com.baidu.tbadk.core.util.httpNet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.cdnOptimize.TbCDNTachometerService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public class CDNIPDirectConnect {
    private static volatile CDNIPDirectConnect Kr;
    private b Kk;
    private com.baidu.tbadk.cdnOptimize.h Kp;
    public com.baidu.tbadk.cdnOptimize.a Kq;
    private long Kg = 0;
    private boolean Kh = false;
    private final float Ki = 100.0f;
    private CdnCacheItem Kj = null;
    private final long Kl = 3600000;
    private final long Km = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long Kn = 10000;
    private final int Ko = 1003;
    private final Handler handler = new a(this, Looper.getMainLooper());

    public static CDNIPDirectConnect pX() {
        if (Kr == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (Kr == null) {
                    Kr = new CDNIPDirectConnect();
                }
            }
        }
        return Kr;
    }

    public CDNIPDirectConnect() {
        this.Kk = null;
        this.Kq = null;
        try {
            this.Kq = new com.baidu.tbadk.cdnOptimize.a();
            this.Kp = new com.baidu.tbadk.cdnOptimize.h();
            pY();
            this.Kk = new b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m255getInst().getApp().registerReceiver(this.Kk, intentFilter);
            if (TbadkCoreApplication.m255getInst().isMainProcess(true) && l.ft()) {
                try {
                    TbadkCoreApplication.m255getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void pY() {
        CdnCacheItem qc = qc();
        long currentTimeMillis = System.currentTimeMillis();
        if (qc != null && qc.firstUseIpTime > 0 && currentTimeMillis - qc.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.Kj = qc;
        }
        if (this.Kj == null) {
            this.Kj = new CdnCacheItem();
            this.Kj.firstUseIpTime = currentTimeMillis;
            this.Kj.identifier = qd();
        }
        if (0 == this.Kj.firstUseIpTime) {
            this.Kj.firstUseIpTime = currentTimeMillis;
        }
    }

    public void pZ() {
        long currentTimeMillis = System.currentTimeMillis();
        String qd = qd();
        boolean z = (this.Kj.identifier == null || qd == null || this.Kj.identifier.equals(qd)) ? false : true;
        if (com.baidu.adp.lib.util.i.fg()) {
            if (this.Kj.lastTachometerTime == 0 || z || (this.Kj.getIsUsedIp() && currentTimeMillis - this.Kj.lastTachometerTime > 3600000)) {
                this.Kj.lastTachometerTime = currentTimeMillis;
                this.Kj.identifier = qd;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m255getInst().getApp(), true, false);
            }
        } else if (this.Kj.mobileLastTachometerTime == 0 || z || (this.Kj.mobileIsUsedIp() && currentTimeMillis - this.Kj.mobileLastTachometerTime > 3600000)) {
            this.Kj.identifier = qd;
            lD();
        }
    }

    public HttpGet k(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (com.baidu.tbadk.util.h.eF(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public HttpGet c(String str, int i, boolean z) {
        return z ? o(str, i) : p(str, i);
    }

    private HttpGet o(String str, int i) {
        String ipString;
        if (!this.Kj.getIsUsedIp() || (ipString = this.Kj.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.Kj.lastTachometerTime > 3600000) {
            qa();
        }
        return ab(str, ipString);
    }

    private HttpGet p(String str, int i) {
        String mobileCdnIp;
        if (!this.Kq.BF || (mobileCdnIp = this.Kj.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.Kj.mobileLastTachometerTime > 3600000) {
            lD();
        }
        return ab(str, mobileCdnIp);
    }

    private HttpGet ab(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && com.baidu.tbadk.util.h.eE(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = com.baidu.tbadk.util.h.eF(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    public void qa() {
        this.Kg = System.currentTimeMillis();
        this.Kj.lastTachometerTime = this.Kg;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m255getInst().getApp(), false, false);
    }

    private void lD() {
        if (this.Kq.BF) {
            this.Kj.mobileLastTachometerTime = System.currentTimeMillis();
            this.Kp.lC();
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!com.baidu.tbadk.util.h.eG(str)) {
            if (z2 || !z) {
                if (!z) {
                    if (com.baidu.tbadk.core.util.e.oo().op() != null) {
                        i = com.baidu.tbadk.core.util.e.oo().op().mD();
                    } else {
                        i = 25;
                    }
                } else if (com.baidu.tbadk.core.util.e.oo().op() != null) {
                    i = com.baidu.tbadk.core.util.e.oo().op().mE();
                } else {
                    i = 10;
                }
            } else if (com.baidu.tbadk.core.util.e.oo().op() != null) {
                i = -com.baidu.tbadk.core.util.e.oo().op().mC();
            } else {
                i = -25;
            }
            if (z3) {
                if (str2 != null && str2.length() > 0) {
                    if (this.Kj.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        qa();
                        b(this.Kj);
                    }
                } else if (this.Kj.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    qa();
                    b(this.Kj);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.Kj.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    lD();
                    b(this.Kj);
                }
            } else if (this.Kj.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                lD();
                b(this.Kj);
            }
        }
    }

    public boolean qb() {
        return this.Kh;
    }

    public String ch(int i) {
        if (com.baidu.adp.lib.util.i.fg()) {
            return this.Kj.getIpString(i);
        }
        if (this.Kq.BF) {
            return this.Kj.getMobileCdnIp(i);
        }
        return null;
    }

    private byte[] a(CdnCacheItem cdnCacheItem) {
        if (cdnCacheItem != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(cdnCacheItem);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                objectOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return null;
    }

    private CdnCacheItem x(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object readObject = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            if (readObject instanceof CdnCacheItem) {
                return (CdnCacheItem) readObject;
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    private CdnCacheItem qc() {
        String string = com.baidu.tbadk.core.sharedPref.b.oj().getString("cdn_iplist_cache_key_three", "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return x(com.baidu.tbadk.core.util.b.decode(string));
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public void b(CdnCacheItem cdnCacheItem) {
        byte[] a;
        if (TbadkCoreApplication.m255getInst().isMainProcess(true) && (a = a(cdnCacheItem)) != null && a.length > 0) {
            try {
                String encode = com.baidu.tbadk.core.util.b.encode(a);
                if (encode != null) {
                    com.baidu.tbadk.core.sharedPref.b.oj().putString("cdn_iplist_cache_key_three", encode);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String qd() {
        if (com.baidu.adp.lib.util.i.fg()) {
            try {
                return ((WifiManager) TbadkCoreApplication.m255getInst().getContext().getSystemService("wifi")).getConnectionInfo().getSSID();
            } catch (Exception e) {
                BdLog.e(e);
            }
        } else {
            try {
                return ((TelephonyManager) TbadkCoreApplication.m255getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return null;
    }

    public boolean hasImageProblem() {
        return (this.Kj != null ? this.Kj.hasImageProblem() : false) || this.Kh;
    }

    public void setIpDisableTime(int i) {
        this.Kj.setIpDisableTime(i);
    }

    /* loaded from: classes.dex */
    public class CDNNetworkChangeReceiver extends BroadcastReceiver {
        private static final int MOBILE = 2;
        private static final int NOTSET = -1;
        private static final int WIFI = 1;
        private static final String WIFI_STRING = "WIFI";
        private int NETWORK_STATUS = -1;

        public CDNNetworkChangeReceiver() {
            CDNIPDirectConnect.this = r2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z = false;
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    z = true;
                }
                if (z) {
                    if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                        if (this.NETWORK_STATUS != -1) {
                            CDNIPDirectConnect.pX().pZ();
                        }
                        this.NETWORK_STATUS = 1;
                        return;
                    }
                    if (this.NETWORK_STATUS != -1) {
                        CDNIPDirectConnect.pX().pZ();
                    }
                    this.NETWORK_STATUS = 2;
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
