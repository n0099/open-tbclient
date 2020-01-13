package com.baidu.b.b;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes10.dex */
public final class b {
    private static b OT;
    private c OO;
    private e OP;
    private f OQ;
    private String OR;

    private b() {
        init();
    }

    public static b nk() {
        if (OT == null) {
            synchronized (b.class) {
                if (OT == null) {
                    OT = new b();
                }
            }
        }
        return OT;
    }

    private void init() {
        this.OP = new e();
        this.OO = new c();
        this.OQ = new f();
        String deviceId = a.nj().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.OR = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d nj = a.nj();
        String ca = g.ca(this.OQ.nq());
        String appName = com.baidu.b.a.a.nh().getAppName();
        String zid = nj.getZid();
        String nm = nj.nm();
        String nn = nj.nn();
        String ca2 = g.ca(this.OO.getDeviceInfo());
        String ca3 = g.ca(this.OR);
        String from = nj.getFrom();
        String no = nj.no();
        if (!TextUtils.isEmpty(from)) {
            from = g.ca(from);
        }
        if (!TextUtils.isEmpty(no)) {
            no = g.ca(no);
        }
        return nj.g(this.OP.h(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), "sid", nn), "ut", ca2), j.c, ca), "bdvc", nm), "zid", zid), "uid", ca3), BdStatsConstant.StatsKey.CURRENT_CHANNEL, no), "from", from), true), true);
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, str3);
        }
        return str;
    }
}
