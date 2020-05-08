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
    private static b ajd;
    private c aje;
    private e ajf;
    private f ajg;
    private String ajh;
    private volatile String aji = null;

    private b() {
        init();
    }

    public static b sj() {
        if (ajd == null) {
            synchronized (b.class) {
                if (ajd == null) {
                    ajd = new b();
                }
            }
        }
        return ajd;
    }

    private void init() {
        this.ajf = new e();
        this.aje = new c();
        this.ajg = new f();
        String deviceId = a.si().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.ajh = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d si = a.si();
        String sr = this.ajg.sr();
        String appName = com.baidu.a.a.a.sg().getAppName();
        String zid = si.getZid();
        String sl = si.sl();
        String sm = si.sm();
        String deviceInfo = this.aje.getDeviceInfo();
        String str2 = this.ajh;
        String from = si.getFrom();
        String sn = si.sn();
        String k = si.k(this.ajf.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sm), "ut", deviceInfo), j.c, sr), "bdvc", sl), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, sn), "from", from), SuspensionBallEntity.KEY_SCHEME, si.sp()), true), true);
        if (TextUtils.isEmpty(this.aji)) {
            this.aji = si.so();
        }
        if (!TextUtils.isEmpty(this.aji)) {
            return addParam(k, "c3_aid", this.aji);
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
