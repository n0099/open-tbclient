package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.config.AppConfig;
import d.b.b.e.p.l;
import java.net.URL;
/* loaded from: classes3.dex */
public class ImageLoggerHelper {
    public static ImageLoggerHelper mInstance;
    public long lastGetTiebaIpTime = 0;
    public long lastGetCdnIpTime = 0;
    public String cachedTiebaIp = "";
    public String cachedCdnIp = "";
    public final long IP_EXPIRE_TIME = AppConfig.TIMESTAMP_AVAILABLE_DURATION;

    public static ImageLoggerHelper getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoggerHelper.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoggerHelper();
                }
            }
        }
        return mInstance;
    }

    public String getDomainIp(String str) {
        try {
            String host = new URL(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return null;
            }
            return UtilHelper.getIpFromDomain(host);
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public String getHiphotosIp(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastGetCdnIpTime > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || l.B()) {
                return "";
            }
            this.lastGetCdnIpTime = currentTimeMillis;
            String replace = str.substring(0, indexOf).replace("http://", "");
            String ipFromDomain = UtilHelper.getIpFromDomain(replace + "hiphotos.baidu.com");
            this.cachedCdnIp = ipFromDomain;
            return ipFromDomain;
        }
        return this.cachedCdnIp;
    }

    public String getTiebaIp() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastGetTiebaIpTime > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            if (l.B()) {
                return "";
            }
            this.lastGetTiebaIpTime = currentTimeMillis;
            this.cachedTiebaIp = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.cachedTiebaIp;
    }
}
