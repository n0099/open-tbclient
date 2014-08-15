package com.baidu.tbadk.core.util.httpNet;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.cdnOptimize.TbCDNTachometerService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public class a {
    private static Object n = new Object();
    private static volatile a o;
    private d i;
    private long a = 0;
    private boolean b = false;
    private int c = 0;
    private final int d = -1;
    private final int e = 1;
    private final int f = 2;
    private final int g = 10;
    private CdnCacheItem h = null;
    private final long j = 3600000;
    private final long k = 604800000;
    private final long l = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final int m = 1003;
    @SuppressLint({"HandlerLeak"})
    private final Handler p = new b(this, Looper.getMainLooper());
    private final CustomMessageListener q = new c(this, 2001121);

    public static a a() {
        if (o == null) {
            synchronized (a.class) {
                if (o == null) {
                    o = new a();
                }
            }
        }
        return o;
    }

    public a() {
        this.i = null;
        try {
            g();
            this.i = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkApplication.m252getInst().getApp().registerReceiver(this.i, intentFilter);
            if (TbadkApplication.m252getInst().isMainProcess(true) && com.baidu.adp.lib.util.j.b()) {
                MessageManager.getInstance().unRegisterListener(this.q);
                MessageManager.getInstance().registerListener(this.q);
            }
            this.p.sendEmptyMessageDelayed(1003, TbConfig.NOTIFY_SOUND_INTERVAL);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void g() {
        CdnCacheItem h = h();
        long currentTimeMillis = System.currentTimeMillis();
        if (h != null && h.firstUseIpTime > 0 && currentTimeMillis - h.firstUseIpTime < 604800000) {
            this.h = h;
        }
        if (this.h == null) {
            this.h = new CdnCacheItem();
            this.h.firstUseIpTime = currentTimeMillis;
            this.h.ssid = e();
        }
        if (0 == this.h.firstUseIpTime) {
            this.h.firstUseIpTime = currentTimeMillis;
        }
    }

    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        String e = e();
        boolean z = (this.h.ssid == null || e == null || this.h.ssid.equals(e)) ? false : true;
        if (this.h.lastTachometerTime == 0 || z || (this.h.isUsedIp && currentTimeMillis - this.h.lastTachometerTime > 3600000)) {
            this.h.lastTachometerTime = currentTimeMillis;
            this.h.ssid = e;
            TbCDNTachometerService.startTachometerService(TbadkApplication.m252getInst().getApp(), true, false);
        }
    }

    public HttpGet a(String str, String str2, String str3) {
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

    public HttpGet a(String str) {
        int indexOf;
        ArrayList<String> arrayList = this.h.ipList;
        int i = this.h.currentUseIpPos;
        if (arrayList != null && arrayList.size() > i && this.h.isUsedIp) {
            if (System.currentTimeMillis() - this.a > 3600000) {
                c();
            }
            String str2 = arrayList.get(i);
            if (str2 != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20) {
                try {
                    System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                    URL url = new URL(str);
                    HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                    httpGet.addHeader("Host", "tbcdn.hiphotos.baidu.com");
                    return httpGet;
                } catch (Exception e) {
                }
            }
        }
        return new HttpGet(str);
    }

    public void c() {
        this.a = System.currentTimeMillis();
        this.h.lastTachometerTime = this.a;
        TbCDNTachometerService.startTachometerService(TbadkApplication.m252getInst().getApp(), false, false);
    }

    public void b(String str) {
        int i = 0;
        synchronized (n) {
            if (this.h.ipList != null && str != null) {
                int i2 = -1;
                int size = this.h.ipList.size();
                while (i < size) {
                    int i3 = str.equals(this.h.ipList.get(i)) ? i : i2;
                    i++;
                    i2 = i3;
                }
                if (i2 + 1 < size) {
                    c();
                    this.h.currentUseIpPos = i2 + 1;
                } else {
                    c();
                    this.h.ipList.clear();
                    this.h.isUsedIp = false;
                    b(this.h);
                }
            }
        }
    }

    public boolean a(String str, String str2, boolean z, boolean z2) {
        if (z2 || !z) {
            if (z2) {
                this.c++;
            } else {
                this.c += 2;
            }
            if (this.c >= 10) {
                if (str2 != null) {
                    b(str2);
                } else {
                    c();
                    this.h.isUsedIp = true;
                    b(this.h);
                }
            }
        } else {
            this.c--;
            if (this.c < 0) {
                this.c = 0;
            }
        }
        return this.b;
    }

    public String d() {
        if (this.h != null && this.h.isUsedIp) {
            ArrayList<String> arrayList = this.h.ipList;
            int i = this.h.currentUseIpPos;
            if (arrayList == null || arrayList.size() <= i) {
                return null;
            }
            return arrayList.get(i);
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

    private CdnCacheItem a(byte[] bArr) {
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

    private CdnCacheItem h() {
        String a = com.baidu.tbadk.core.sharedPref.b.a().a("cdn_iplist_cache_key", "");
        if (a == null || a.length() == 0) {
            return null;
        }
        try {
            return a(com.baidu.tbadk.core.util.b.a(a));
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public void b(CdnCacheItem cdnCacheItem) {
        byte[] a;
        if (TbadkApplication.m252getInst().isMainProcess(true) && (a = a(cdnCacheItem)) != null && a.length > 0) {
            try {
                String a2 = com.baidu.tbadk.core.util.b.a(a);
                if (a2 != null) {
                    com.baidu.tbadk.core.sharedPref.b.a().b("cdn_iplist_cache_key", a2);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String e() {
        try {
            return ((WifiManager) TbadkApplication.m252getInst().getSystemService("wifi")).getConnectionInfo().getSSID();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean f() {
        return this.c > 0 || (this.h != null && this.h.isUsedIp) || this.b;
    }
}
