package com.baidu.d.c;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes9.dex */
public final class b {
    private static b ann;
    private c ano;
    private e anp;
    private g anq;
    private String anr;
    private volatile String ans = null;

    private b() {
        init();
    }

    public static b uV() {
        if (ann == null) {
            synchronized (b.class) {
                if (ann == null) {
                    ann = new b();
                }
            }
        }
        return ann;
    }

    private void init() {
        this.anp = new e();
        this.ano = new c();
        this.anq = new g();
        String deviceId = a.uU().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.anr = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d uU = a.uU();
        String vd = this.anq.vd();
        String appName = com.baidu.d.b.a.uS().getAppName();
        String zid = uU.getZid();
        String uX = uU.uX();
        String uY = uU.uY();
        String deviceInfo = this.ano.getDeviceInfo();
        String str2 = this.anr;
        String from = uU.getFrom();
        String uZ = uU.uZ();
        String vb = uU.vb();
        if (TextUtils.isEmpty(from)) {
            from = com.baidu.d.a.a.uK().getChannel();
        }
        if (TextUtils.isEmpty(uZ)) {
            uZ = com.baidu.d.a.a.uK().uL();
        }
        String k = uU.k(this.anp.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, uY), "ut", deviceInfo), j.c, vd), "bdvc", uX), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, uZ), "from", from), "scheme", vb), true), true);
        if (TextUtils.isEmpty(this.ans)) {
            this.ans = uU.va();
        }
        if (!TextUtils.isEmpty(this.ans)) {
            return addParam(k, "c3_aid", this.ans);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, h.dy(str3));
        }
        return str;
    }
}
