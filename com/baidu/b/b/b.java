package com.baidu.b.b;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes12.dex */
public final class b {
    private static b QC;
    private String QB;
    private c Qx;
    private e Qy;
    private f Qz;

    private b() {
        init();
    }

    public static b nS() {
        if (QC == null) {
            synchronized (b.class) {
                if (QC == null) {
                    QC = new b();
                }
            }
        }
        return QC;
    }

    private void init() {
        this.Qy = new e();
        this.Qx = new c();
        this.Qz = new f();
        String deviceId = a.nR().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.QB = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d nR = a.nR();
        String ci = g.ci(this.Qz.nY());
        String appName = com.baidu.b.a.a.nP().getAppName();
        String zid = nR.getZid();
        String nU = nR.nU();
        String nV = nR.nV();
        String ci2 = g.ci(this.Qx.getDeviceInfo());
        String ci3 = g.ci(this.QB);
        String from = nR.getFrom();
        String nW = nR.nW();
        if (!TextUtils.isEmpty(from)) {
            from = g.ci(from);
        }
        if (!TextUtils.isEmpty(nW)) {
            nW = g.ci(nW);
        }
        return nR.g(this.Qy.h(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), "sid", nV), "ut", ci2), j.c, ci), "bdvc", nU), "zid", zid), "uid", ci3), BdStatsConstant.StatsKey.CURRENT_CHANNEL, nW), "from", from), true), true);
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, str3);
        }
        return str;
    }
}
