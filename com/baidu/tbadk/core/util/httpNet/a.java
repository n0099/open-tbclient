package com.baidu.tbadk.core.util.httpNet;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.cdnOptimize.TbCDNTachometerService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public class a {
    private static volatile a FN;
    private d FI;
    private long FE = 0;
    private boolean FF = false;
    private final float FG = 100.0f;
    private CdnCacheItem FH = null;
    private final long FJ = 3600000;
    private final long FK = 604800000;
    private final long FL = 10000;
    private final int FM = 1003;
    private final Handler handler = new b(this, Looper.getMainLooper());
    private final CustomMessageListener FO = new c(this, 2001121);

    public static a mT() {
        if (FN == null) {
            synchronized (a.class) {
                if (FN == null) {
                    FN = new a();
                }
            }
        }
        return FN;
    }

    public a() {
        this.FI = null;
        try {
            mU();
            this.FI = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkApplication.m251getInst().getApp().registerReceiver(this.FI, intentFilter);
            if (TbadkApplication.m251getInst().isMainProcess(true) && m.fu()) {
                MessageManager.getInstance().unRegisterListener(this.FO);
                MessageManager.getInstance().registerListener(this.FO);
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void mU() {
        CdnCacheItem mY = mY();
        long currentTimeMillis = System.currentTimeMillis();
        if (mY != null && mY.firstUseIpTime > 0 && currentTimeMillis - mY.firstUseIpTime < 604800000) {
            this.FH = mY;
        }
        if (this.FH == null) {
            this.FH = new CdnCacheItem();
            this.FH.firstUseIpTime = currentTimeMillis;
            this.FH.ssid = mZ();
        }
        if (0 == this.FH.firstUseIpTime) {
            this.FH.firstUseIpTime = currentTimeMillis;
        }
    }

    public void mV() {
        long currentTimeMillis = System.currentTimeMillis();
        String mZ = mZ();
        boolean z = (this.FH.ssid == null || mZ == null || this.FH.ssid.equals(mZ)) ? false : true;
        if (this.FH.lastTachometerTime == 0 || z || (this.FH.getIsUsedIp() && currentTimeMillis - this.FH.lastTachometerTime > 3600000)) {
            this.FH.lastTachometerTime = currentTimeMillis;
            this.FH.ssid = mZ;
            TbCDNTachometerService.startTachometerService(TbadkApplication.m251getInst().getApp(), true, false);
        }
    }

    public HttpGet g(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf > 0 && indexOf < 20) {
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

    public HttpGet o(String str, int i) {
        String ipString;
        int indexOf;
        if (this.FH.getIsUsedIp() && (ipString = this.FH.getIpString(i)) != null) {
            if (System.currentTimeMillis() - this.FH.lastTachometerTime > 3600000) {
                mW();
            }
            if (ipString != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20) {
                try {
                    System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                    URL url = new URL(str);
                    HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + ipString + url.getPath());
                    httpGet.addHeader("Host", "tbcdn.hiphotos.baidu.com");
                    return httpGet;
                } catch (Exception e) {
                }
            }
        }
        return new HttpGet(str);
    }

    public void mW() {
        this.FE = System.currentTimeMillis();
        this.FH.lastTachometerTime = this.FE;
        TbCDNTachometerService.startTachometerService(TbadkApplication.m251getInst().getApp(), false, false);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        int i;
        if (z2 || !z) {
            if (z2) {
                if (com.baidu.tbadk.core.util.e.lq().lr() != null) {
                    i = com.baidu.tbadk.core.util.e.lq().lr().jP();
                } else {
                    i = 10;
                }
            } else if (com.baidu.tbadk.core.util.e.lq().lr() != null) {
                i = com.baidu.tbadk.core.util.e.lq().lr().jO();
            } else {
                i = 25;
            }
        } else if (com.baidu.tbadk.core.util.e.lq().lr() != null) {
            i = -com.baidu.tbadk.core.util.e.lq().lr().jN();
        } else {
            i = -25;
        }
        if (str2 != null && str2.length() > 0) {
            if (this.FH.setIPRank(i, 100.0f, str2) >= 100.0f) {
                mW();
                b(this.FH);
            }
        } else if (this.FH.setCdnDomainRank(i, 100.0f) >= 100.0f) {
            mW();
            b(this.FH);
        }
    }

    public boolean mX() {
        return this.FF;
    }

    public String bD(int i) {
        return this.FH.getIpString(i);
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

    private CdnCacheItem mY() {
        String string = com.baidu.tbadk.core.sharedPref.b.lk().getString("cdn_iplist_cache_key_one", "");
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
        if (TbadkApplication.m251getInst().isMainProcess(true) && (a = a(cdnCacheItem)) != null && a.length > 0) {
            try {
                String encode = com.baidu.tbadk.core.util.b.encode(a);
                if (encode != null) {
                    com.baidu.tbadk.core.sharedPref.b.lk().putString("cdn_iplist_cache_key_one", encode);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String mZ() {
        try {
            return ((WifiManager) TbadkApplication.m251getInst().getSystemService("wifi")).getConnectionInfo().getSSID();
        } catch (Error | Exception e) {
            return null;
        }
    }

    public boolean hasImageProblem() {
        return (this.FH != null ? this.FH.hasImageProblem() : false) || this.FF;
    }
}
