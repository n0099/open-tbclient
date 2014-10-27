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
    private static volatile a FM;
    private d FH;
    private long FD = 0;
    private boolean FE = false;
    private final float FF = 100.0f;
    private CdnCacheItem FG = null;
    private final long FI = 3600000;
    private final long FJ = 604800000;
    private final long FK = 10000;
    private final int FL = 1003;
    private final Handler handler = new b(this, Looper.getMainLooper());
    private final CustomMessageListener FN = new c(this, 2001121);

    public static a mT() {
        if (FM == null) {
            synchronized (a.class) {
                if (FM == null) {
                    FM = new a();
                }
            }
        }
        return FM;
    }

    public a() {
        this.FH = null;
        try {
            mU();
            this.FH = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkApplication.m251getInst().getApp().registerReceiver(this.FH, intentFilter);
            if (TbadkApplication.m251getInst().isMainProcess(true) && m.fu()) {
                MessageManager.getInstance().unRegisterListener(this.FN);
                MessageManager.getInstance().registerListener(this.FN);
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
            this.FG = mY;
        }
        if (this.FG == null) {
            this.FG = new CdnCacheItem();
            this.FG.firstUseIpTime = currentTimeMillis;
            this.FG.ssid = mZ();
        }
        if (0 == this.FG.firstUseIpTime) {
            this.FG.firstUseIpTime = currentTimeMillis;
        }
    }

    public void mV() {
        long currentTimeMillis = System.currentTimeMillis();
        String mZ = mZ();
        boolean z = (this.FG.ssid == null || mZ == null || this.FG.ssid.equals(mZ)) ? false : true;
        if (this.FG.lastTachometerTime == 0 || z || (this.FG.getIsUsedIp() && currentTimeMillis - this.FG.lastTachometerTime > 3600000)) {
            this.FG.lastTachometerTime = currentTimeMillis;
            this.FG.ssid = mZ;
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
        if (this.FG.getIsUsedIp() && (ipString = this.FG.getIpString(i)) != null) {
            if (System.currentTimeMillis() - this.FG.lastTachometerTime > 3600000) {
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
        this.FD = System.currentTimeMillis();
        this.FG.lastTachometerTime = this.FD;
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
            if (this.FG.setIPRank(i, 100.0f, str2) >= 100.0f) {
                mW();
                b(this.FG);
            }
        } else if (this.FG.setCdnDomainRank(i, 100.0f) >= 100.0f) {
            mW();
            b(this.FG);
        }
    }

    public boolean mX() {
        return this.FE;
    }

    public String bD(int i) {
        return this.FG.getIpString(i);
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
        return (this.FG != null ? this.FG.hasImageProblem() : false) || this.FE;
    }
}
