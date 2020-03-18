package com.baidu.b.b;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes12.dex */
public final class b {
    private static b QE;
    private e QB;
    private f QC;
    private String QD;
    private c Qz;

    private b() {
        init();
    }

    public static b nR() {
        if (QE == null) {
            synchronized (b.class) {
                if (QE == null) {
                    QE = new b();
                }
            }
        }
        return QE;
    }

    private void init() {
        this.QB = new e();
        this.Qz = new c();
        this.QC = new f();
        String deviceId = a.nQ().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.QD = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d nQ = a.nQ();
        String ch = g.ch(this.QC.nX());
        String appName = com.baidu.b.a.a.nO().getAppName();
        String zid = nQ.getZid();
        String nT = nQ.nT();
        String nU = nQ.nU();
        String ch2 = g.ch(this.Qz.getDeviceInfo());
        String ch3 = g.ch(this.QD);
        String from = nQ.getFrom();
        String nV = nQ.nV();
        if (!TextUtils.isEmpty(from)) {
            from = g.ch(from);
        }
        if (!TextUtils.isEmpty(nV)) {
            nV = g.ch(nV);
        }
        return nQ.g(this.QB.h(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), "sid", nU), "ut", ch2), j.c, ch), "bdvc", nT), "zid", zid), "uid", ch3), BdStatsConstant.StatsKey.CURRENT_CHANNEL, nV), "from", from), true), true);
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, str3);
        }
        return str;
    }
}
