package com.baidu.b.b;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.util.Base64Encoder;
/* loaded from: classes8.dex */
public final class b {
    private static b akY;
    private c akZ;
    private e ala;
    private f alb;
    private String alc;
    private volatile String ald = null;

    private b() {
        init();
    }

    public static b sQ() {
        if (akY == null) {
            synchronized (b.class) {
                if (akY == null) {
                    akY = new b();
                }
            }
        }
        return akY;
    }

    private void init() {
        this.ala = new e();
        this.akZ = new c();
        this.alb = new f();
        String deviceId = a.sP().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.alc = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d sP = a.sP();
        String sY = this.alb.sY();
        String appName = com.baidu.b.a.a.sN().getAppName();
        String zid = sP.getZid();
        String sS = sP.sS();
        String sT = sP.sT();
        String deviceInfo = this.akZ.getDeviceInfo();
        String str2 = this.alc;
        String from = sP.getFrom();
        String sU = sP.sU();
        String k = sP.k(this.ala.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sT), "ut", deviceInfo), j.c, sY), "bdvc", sS), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, sU), "from", from), SuspensionBallEntity.KEY_SCHEME, sP.sW()), true), true);
        if (TextUtils.isEmpty(this.ald)) {
            this.ald = sP.sV();
        }
        if (!TextUtils.isEmpty(this.ald)) {
            return addParam(k, "c3_aid", this.ald);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, g.df(str3));
        }
        return str;
    }
}
