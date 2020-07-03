package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class u {
    private static u dTK;
    private long dTF = 0;
    private long dTG = 0;
    private String dTH = "";
    private String dTI = "";
    private final long dTJ = 120000;

    public static u aWp() {
        if (dTK == null) {
            synchronized (u.class) {
                if (dTK == null) {
                    dTK = new u();
                }
            }
        }
        return dTK;
    }

    public String aWq() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dTF > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dTF = currentTimeMillis;
            this.dTH = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.dTH;
    }

    public String wB(String str) {
        try {
            String host = new URL(str).getHost();
            if (!TextUtils.isEmpty(host)) {
                return UtilHelper.getIpFromDomain(host);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    public String wC(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dTG > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dTG = currentTimeMillis;
            this.dTI = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.dTI;
        }
        return this.dTI;
    }
}
