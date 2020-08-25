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
    private static b alZ;
    private c ama;
    private e amb;
    private f amc;
    private String amd;
    private volatile String ame = null;

    private b() {
        init();
    }

    public static b uy() {
        if (alZ == null) {
            synchronized (b.class) {
                if (alZ == null) {
                    alZ = new b();
                }
            }
        }
        return alZ;
    }

    private void init() {
        this.amb = new e();
        this.ama = new c();
        this.amc = new f();
        String deviceId = a.ux().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.amd = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d ux = a.ux();
        String uG = this.amc.uG();
        String appName = com.baidu.d.a.a.uv().getAppName();
        String zid = ux.getZid();
        String uA = ux.uA();
        String uB = ux.uB();
        String deviceInfo = this.ama.getDeviceInfo();
        String str2 = this.amd;
        String from = ux.getFrom();
        String uC = ux.uC();
        String k = ux.k(this.amb.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, uB), "ut", deviceInfo), j.c, uG), "bdvc", uA), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, uC), "from", from), SuspensionBallEntity.KEY_SCHEME, ux.uE()), true), true);
        if (TextUtils.isEmpty(this.ame)) {
            this.ame = ux.uD();
        }
        if (!TextUtils.isEmpty(this.ame)) {
            return addParam(k, "c3_aid", this.ame);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, g.dq(str3));
        }
        return str;
    }
}
