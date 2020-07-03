package com.baidu.a.b;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.util.Base64Encoder;
/* loaded from: classes12.dex */
public final class b {
    private static b ald;
    private c ale;
    private e alf;
    private f alg;
    private String alh;
    private volatile String ali = null;

    private b() {
        init();
    }

    public static b sO() {
        if (ald == null) {
            synchronized (b.class) {
                if (ald == null) {
                    ald = new b();
                }
            }
        }
        return ald;
    }

    private void init() {
        this.alf = new e();
        this.ale = new c();
        this.alg = new f();
        String deviceId = a.sN().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.alh = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d sN = a.sN();
        String sW = this.alg.sW();
        String appName = com.baidu.a.a.a.sL().getAppName();
        String zid = sN.getZid();
        String sQ = sN.sQ();
        String sR = sN.sR();
        String deviceInfo = this.ale.getDeviceInfo();
        String str2 = this.alh;
        String from = sN.getFrom();
        String sS = sN.sS();
        String k = sN.k(this.alf.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sR), "ut", deviceInfo), j.c, sW), "bdvc", sQ), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, sS), "from", from), SuspensionBallEntity.KEY_SCHEME, sN.sU()), true), true);
        if (TextUtils.isEmpty(this.ali)) {
            this.ali = sN.sT();
        }
        if (!TextUtils.isEmpty(this.ali)) {
            return addParam(k, "c3_aid", this.ali);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, g.dg(str3));
        }
        return str;
    }
}
