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
    private static b aiY;
    private c aiZ;
    private e aja;
    private f ajb;
    private String ajc;
    private volatile String ajd = null;

    private b() {
        init();
    }

    public static b sk() {
        if (aiY == null) {
            synchronized (b.class) {
                if (aiY == null) {
                    aiY = new b();
                }
            }
        }
        return aiY;
    }

    private void init() {
        this.aja = new e();
        this.aiZ = new c();
        this.ajb = new f();
        String deviceId = a.sj().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.ajc = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d sj = a.sj();
        String ss = this.ajb.ss();
        String appName = com.baidu.a.a.a.sh().getAppName();
        String zid = sj.getZid();
        String sm = sj.sm();
        String sn = sj.sn();
        String deviceInfo = this.aiZ.getDeviceInfo();
        String str2 = this.ajc;
        String from = sj.getFrom();
        String so = sj.so();
        String k = sj.k(this.aja.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sn), "ut", deviceInfo), j.c, ss), "bdvc", sm), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, so), "from", from), SuspensionBallEntity.KEY_SCHEME, sj.sq()), true), true);
        if (TextUtils.isEmpty(this.ajd)) {
            this.ajd = sj.sp();
        }
        if (!TextUtils.isEmpty(this.ajd)) {
            return addParam(k, "c3_aid", this.ajd);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, g.dc(str3));
        }
        return str;
    }
}
