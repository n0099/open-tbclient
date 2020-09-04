package com.baidu.d.b;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.util.Base64Encoder;
/* loaded from: classes5.dex */
public final class b {
    private static b amb;
    private c amc;
    private e amd;
    private f ame;
    private String amf;
    private volatile String amg = null;

    private b() {
        init();
    }

    public static b uy() {
        if (amb == null) {
            synchronized (b.class) {
                if (amb == null) {
                    amb = new b();
                }
            }
        }
        return amb;
    }

    private void init() {
        this.amd = new e();
        this.amc = new c();
        this.ame = new f();
        String deviceId = a.ux().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.amf = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d ux = a.ux();
        String uG = this.ame.uG();
        String appName = com.baidu.d.a.a.uv().getAppName();
        String zid = ux.getZid();
        String uA = ux.uA();
        String uB = ux.uB();
        String deviceInfo = this.amc.getDeviceInfo();
        String str2 = this.amf;
        String from = ux.getFrom();
        String uC = ux.uC();
        String k = ux.k(this.amd.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, uB), "ut", deviceInfo), j.c, uG), "bdvc", uA), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, uC), "from", from), SuspensionBallEntity.KEY_SCHEME, ux.uE()), true), true);
        if (TextUtils.isEmpty(this.amg)) {
            this.amg = ux.uD();
        }
        if (!TextUtils.isEmpty(this.amg)) {
            return addParam(k, "c3_aid", this.amg);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, g.dr(str3));
        }
        return str;
    }
}
