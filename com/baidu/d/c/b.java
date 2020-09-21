package com.baidu.d.c;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes11.dex */
public final class b {
    private static b amD;
    private c amE;
    private e amF;
    private g amG;
    private String amH;
    private volatile String amI = null;

    private b() {
        init();
    }

    public static b uM() {
        if (amD == null) {
            synchronized (b.class) {
                if (amD == null) {
                    amD = new b();
                }
            }
        }
        return amD;
    }

    private void init() {
        this.amF = new e();
        this.amE = new c();
        this.amG = new g();
        String deviceId = a.uL().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.amH = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d uL = a.uL();
        String uU = this.amG.uU();
        String appName = com.baidu.d.b.a.uJ().getAppName();
        String zid = uL.getZid();
        String uO = uL.uO();
        String uP = uL.uP();
        String deviceInfo = this.amE.getDeviceInfo();
        String str2 = this.amH;
        String from = uL.getFrom();
        String uQ = uL.uQ();
        String uS = uL.uS();
        if (TextUtils.isEmpty(from)) {
            from = com.baidu.d.a.a.uB().getChannel();
        }
        if (TextUtils.isEmpty(uQ)) {
            uQ = com.baidu.d.a.a.uB().uC();
        }
        String k = uL.k(this.amF.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, uP), "ut", deviceInfo), j.c, uU), "bdvc", uO), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, uQ), "from", from), "scheme", uS), true), true);
        if (TextUtils.isEmpty(this.amI)) {
            this.amI = uL.uR();
        }
        if (!TextUtils.isEmpty(this.amI)) {
            return addParam(k, "c3_aid", this.amI);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, h.dt(str3));
        }
        return str;
    }
}
