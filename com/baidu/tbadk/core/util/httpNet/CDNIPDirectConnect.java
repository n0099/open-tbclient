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
    private static volatile CDNIPDirectConnect JY;
    private b JR;
    private com.baidu.tbadk.cdnOptimize.h JW;
    public com.baidu.tbadk.cdnOptimize.a JX;
    private long JN = 0;
    private boolean JO = false;
    private final float JP = 100.0f;
    private CdnCacheItem JQ = null;
    private final long JS = 3600000;
    private final long JT = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long JU = 10000;
    private final int JV = 1003;
    private final Handler handler = new a(this, Looper.getMainLooper());

    public static CDNIPDirectConnect pM() {
        if (JY == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (JY == null) {
                    JY = new CDNIPDirectConnect();
                }
            }
        }
        return JY;
    }

    public CDNIPDirectConnect() {
        this.JR = null;
        this.JX = null;
        try {
            this.JX = new com.baidu.tbadk.cdnOptimize.a();
            this.JW = new com.baidu.tbadk.cdnOptimize.h();
            pN();
            this.JR = new b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m255getInst().getApp().registerReceiver(this.JR, intentFilter);
            if (TbadkCoreApplication.m255getInst().isMainProcess(true) && l.fu()) {
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

    private void pN() {
        CdnCacheItem pR = pR();
        long currentTimeMillis = System.currentTimeMillis();
        if (pR != null && pR.firstUseIpTime > 0 && currentTimeMillis - pR.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.JQ = pR;
        }
        if (this.JQ == null) {
            this.JQ = new CdnCacheItem();
            this.JQ.firstUseIpTime = currentTimeMillis;
            this.JQ.identifier = pS();
        }
        if (0 == this.JQ.firstUseIpTime) {
            this.JQ.firstUseIpTime = currentTimeMillis;
        }
    }

    public void pO() {
        long currentTimeMillis = System.currentTimeMillis();
        String pS = pS();
        boolean z = (this.JQ.identifier == null || pS == null || this.JQ.identifier.equals(pS)) ? false : true;
        if (com.baidu.adp.lib.util.i.fh()) {
            if (this.JQ.lastTachometerTime == 0 || z || (this.JQ.getIsUsedIp() && currentTimeMillis - this.JQ.lastTachometerTime > 3600000)) {
                this.JQ.lastTachometerTime = currentTimeMillis;
                this.JQ.identifier = pS;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m255getInst().getApp(), true, false);
            }
        } else if (this.JQ.mobileLastTachometerTime == 0 || z || (this.JQ.mobileIsUsedIp() && currentTimeMillis - this.JQ.mobileLastTachometerTime > 3600000)) {
            this.JQ.identifier = pS;
            lD();
        }
    }

    public HttpGet k(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (com.baidu.tbadk.util.e.eF(str)) {
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
        if (!this.JQ.getIsUsedIp() || (ipString = this.JQ.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.JQ.lastTachometerTime > 3600000) {
            pP();
        }
        return Y(str, ipString);
    }

    private HttpGet p(String str, int i) {
        String mobileCdnIp;
        if (!this.JX.BF || (mobileCdnIp = this.JQ.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.JQ.mobileLastTachometerTime > 3600000) {
            lD();
        }
        return Y(str, mobileCdnIp);
    }

    private HttpGet Y(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && com.baidu.tbadk.util.e.eE(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = com.baidu.tbadk.util.e.eF(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    public void pP() {
        this.JN = System.currentTimeMillis();
        this.JQ.lastTachometerTime = this.JN;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m255getInst().getApp(), false, false);
    }

    private void lD() {
        if (this.JX.BF) {
            this.JQ.mobileLastTachometerTime = System.currentTimeMillis();
            this.JW.lC();
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!com.baidu.tbadk.util.e.eG(str)) {
            if (z2 || !z) {
                if (!z) {
                    if (com.baidu.tbadk.core.util.e.ol().om() != null) {
                        i = com.baidu.tbadk.core.util.e.ol().om().mD();
                    } else {
                        i = 25;
                    }
                } else if (com.baidu.tbadk.core.util.e.ol().om() != null) {
                    i = com.baidu.tbadk.core.util.e.ol().om().mE();
                } else {
                    i = 10;
                }
            } else if (com.baidu.tbadk.core.util.e.ol().om() != null) {
                i = -com.baidu.tbadk.core.util.e.ol().om().mC();
            } else {
                i = -25;
            }
            if (z3) {
                if (str2 != null && str2.length() > 0) {
                    if (this.JQ.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        pP();
                        b(this.JQ);
                    }
                } else if (this.JQ.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    pP();
                    b(this.JQ);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.JQ.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    lD();
                    b(this.JQ);
                }
            } else if (this.JQ.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                lD();
                b(this.JQ);
            }
        }
    }

    public boolean pQ() {
        return this.JO;
    }

    public String ca(int i) {
        if (com.baidu.adp.lib.util.i.fh()) {
            return this.JQ.getIpString(i);
        }
        if (this.JX.BF) {
            return this.JQ.getMobileCdnIp(i);
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

    private CdnCacheItem pR() {
        String string = com.baidu.tbadk.core.sharedPref.b.og().getString("cdn_iplist_cache_key_three", "");
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
                    com.baidu.tbadk.core.sharedPref.b.og().putString("cdn_iplist_cache_key_three", encode);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String pS() {
        if (com.baidu.adp.lib.util.i.fh()) {
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
        return (this.JQ != null ? this.JQ.hasImageProblem() : false) || this.JO;
    }

    public void setIpDisableTime(int i) {
        this.JQ.setIpDisableTime(i);
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
                            CDNIPDirectConnect.pM().pO();
                        }
                        this.NETWORK_STATUS = 1;
                        return;
                    }
                    if (this.NETWORK_STATUS != -1) {
                        CDNIPDirectConnect.pM().pO();
                    }
                    this.NETWORK_STATUS = 2;
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
