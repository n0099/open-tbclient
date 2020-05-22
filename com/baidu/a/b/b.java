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
    private static b ajH;
    private c ajI;
    private e ajJ;
    private f ajK;
    private String ajL;
    private volatile String ajM = null;

    private b() {
        init();
    }

    public static b st() {
        if (ajH == null) {
            synchronized (b.class) {
                if (ajH == null) {
                    ajH = new b();
                }
            }
        }
        return ajH;
    }

    private void init() {
        this.ajJ = new e();
        this.ajI = new c();
        this.ajK = new f();
        String deviceId = a.ss().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.ajL = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d ss = a.ss();
        String sB = this.ajK.sB();
        String appName = com.baidu.a.a.a.sq().getAppName();
        String zid = ss.getZid();
        String sv = ss.sv();
        String sw = ss.sw();
        String deviceInfo = this.ajI.getDeviceInfo();
        String str2 = this.ajL;
        String from = ss.getFrom();
        String sx = ss.sx();
        String k = ss.k(this.ajJ.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sw), "ut", deviceInfo), j.c, sB), "bdvc", sv), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, sx), "from", from), SuspensionBallEntity.KEY_SCHEME, ss.sz()), true), true);
        if (TextUtils.isEmpty(this.ajM)) {
            this.ajM = ss.sy();
        }
        if (!TextUtils.isEmpty(this.ajM)) {
            return addParam(k, "c3_aid", this.ajM);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, g.de(str3));
        }
        return str;
    }
}
