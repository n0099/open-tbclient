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
    private static volatile CDNIPDirectConnect Ko;
    private b Kh;
    private com.baidu.tbadk.cdnOptimize.h Km;
    public com.baidu.tbadk.cdnOptimize.a Kn;
    private long Kd = 0;
    private boolean Ke = false;
    private final float Kf = 100.0f;
    private CdnCacheItem Kg = null;
    private final long Ki = 3600000;
    private final long Kj = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long Kk = 10000;
    private final int Kl = 1003;
    private final Handler handler = new a(this, Looper.getMainLooper());

    public static CDNIPDirectConnect pQ() {
        if (Ko == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (Ko == null) {
                    Ko = new CDNIPDirectConnect();
                }
            }
        }
        return Ko;
    }

    public CDNIPDirectConnect() {
        this.Kh = null;
        this.Kn = null;
        try {
            this.Kn = new com.baidu.tbadk.cdnOptimize.a();
            this.Km = new com.baidu.tbadk.cdnOptimize.h();
            pR();
            this.Kh = new b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m255getInst().getApp().registerReceiver(this.Kh, intentFilter);
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

    private void pR() {
        CdnCacheItem pV = pV();
        long currentTimeMillis = System.currentTimeMillis();
        if (pV != null && pV.firstUseIpTime > 0 && currentTimeMillis - pV.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.Kg = pV;
        }
        if (this.Kg == null) {
            this.Kg = new CdnCacheItem();
            this.Kg.firstUseIpTime = currentTimeMillis;
            this.Kg.identifier = pW();
        }
        if (0 == this.Kg.firstUseIpTime) {
            this.Kg.firstUseIpTime = currentTimeMillis;
        }
    }

    public void pS() {
        long currentTimeMillis = System.currentTimeMillis();
        String pW = pW();
        boolean z = (this.Kg.identifier == null || pW == null || this.Kg.identifier.equals(pW)) ? false : true;
        if (com.baidu.adp.lib.util.i.fg()) {
            if (this.Kg.lastTachometerTime == 0 || z || (this.Kg.getIsUsedIp() && currentTimeMillis - this.Kg.lastTachometerTime > 3600000)) {
                this.Kg.lastTachometerTime = currentTimeMillis;
                this.Kg.identifier = pW;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m255getInst().getApp(), true, false);
            }
        } else if (this.Kg.mobileLastTachometerTime == 0 || z || (this.Kg.mobileIsUsedIp() && currentTimeMillis - this.Kg.mobileLastTachometerTime > 3600000)) {
            this.Kg.identifier = pW;
            lw();
        }
    }

    public HttpGet k(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (com.baidu.tbadk.util.h.eC(str)) {
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
        if (!this.Kg.getIsUsedIp() || (ipString = this.Kg.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.Kg.lastTachometerTime > 3600000) {
            pT();
        }
        return ab(str, ipString);
    }

    private HttpGet p(String str, int i) {
        String mobileCdnIp;
        if (!this.Kn.BC || (mobileCdnIp = this.Kg.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.Kg.mobileLastTachometerTime > 3600000) {
            lw();
        }
        return ab(str, mobileCdnIp);
    }

    private HttpGet ab(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && com.baidu.tbadk.util.h.eB(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = com.baidu.tbadk.util.h.eC(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    public void pT() {
        this.Kd = System.currentTimeMillis();
        this.Kg.lastTachometerTime = this.Kd;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m255getInst().getApp(), false, false);
    }

    private void lw() {
        if (this.Kn.BC) {
            this.Kg.mobileLastTachometerTime = System.currentTimeMillis();
            this.Km.lv();
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!com.baidu.tbadk.util.h.eD(str)) {
            if (z2 || !z) {
                if (!z) {
                    if (com.baidu.tbadk.core.util.e.oh().oi() != null) {
                        i = com.baidu.tbadk.core.util.e.oh().oi().mw();
                    } else {
                        i = 25;
                    }
                } else if (com.baidu.tbadk.core.util.e.oh().oi() != null) {
                    i = com.baidu.tbadk.core.util.e.oh().oi().mx();
                } else {
                    i = 10;
                }
            } else if (com.baidu.tbadk.core.util.e.oh().oi() != null) {
                i = -com.baidu.tbadk.core.util.e.oh().oi().mv();
            } else {
                i = -25;
            }
            if (z3) {
                if (str2 != null && str2.length() > 0) {
                    if (this.Kg.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        pT();
                        b(this.Kg);
                    }
                } else if (this.Kg.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    pT();
                    b(this.Kg);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.Kg.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    lw();
                    b(this.Kg);
                }
            } else if (this.Kg.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                lw();
                b(this.Kg);
            }
        }
    }

    public boolean pU() {
        return this.Ke;
    }

    public String ch(int i) {
        if (com.baidu.adp.lib.util.i.fg()) {
            return this.Kg.getIpString(i);
        }
        if (this.Kn.BC) {
            return this.Kg.getMobileCdnIp(i);
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

    private CdnCacheItem pV() {
        String string = com.baidu.tbadk.core.sharedPref.b.oc().getString("cdn_iplist_cache_key_three", "");
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
                    com.baidu.tbadk.core.sharedPref.b.oc().putString("cdn_iplist_cache_key_three", encode);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String pW() {
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
        return (this.Kg != null ? this.Kg.hasImageProblem() : false) || this.Ke;
    }

    public void setIpDisableTime(int i) {
        this.Kg.setIpDisableTime(i);
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
                            CDNIPDirectConnect.pQ().pS();
                        }
                        this.NETWORK_STATUS = 1;
                        return;
                    }
                    if (this.NETWORK_STATUS != -1) {
                        CDNIPDirectConnect.pQ().pS();
                    }
                    this.NETWORK_STATUS = 2;
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
