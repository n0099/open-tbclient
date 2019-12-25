package com.baidu.b.b;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes9.dex */
public final class b {
    private static b OO;
    private c OI;
    private e OJ;
    private f OL;
    private String OM;

    private b() {
        init();
    }

    public static b nj() {
        if (OO == null) {
            synchronized (b.class) {
                if (OO == null) {
                    OO = new b();
                }
            }
        }
        return OO;
    }

    private void init() {
        this.OJ = new e();
        this.OI = new c();
        this.OL = new f();
        String deviceId = a.ni().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.OM = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d ni = a.ni();
        String ca = g.ca(this.OL.np());
        String appName = com.baidu.b.a.a.ng().getAppName();
        String zid = ni.getZid();
        String nl = ni.nl();
        String nm = ni.nm();
        String ca2 = g.ca(this.OI.getDeviceInfo());
        String ca3 = g.ca(this.OM);
        String from = ni.getFrom();
        String nn = ni.nn();
        if (!TextUtils.isEmpty(from)) {
            from = g.ca(from);
        }
        if (!TextUtils.isEmpty(nn)) {
            nn = g.ca(nn);
        }
        return ni.g(this.OJ.h(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), "sid", nm), "ut", ca2), j.c, ca), "bdvc", nl), "zid", zid), "uid", ca3), BdStatsConstant.StatsKey.CURRENT_CHANNEL, nn), "from", from), true), true);
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, str3);
        }
        return str;
    }
}
