package com.baidu.e.c;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes17.dex */
public final class b {
    private static b aoq;
    private c aor;
    private f aos;
    private h aot;
    private String aou;
    private volatile String mC3Aid = null;

    private b() {
        init();
    }

    public static b uR() {
        if (aoq == null) {
            synchronized (b.class) {
                if (aoq == null) {
                    aoq = new b();
                }
            }
        }
        return aoq;
    }

    private void init() {
        this.aos = new f();
        this.aor = new c();
        this.aot = new h();
        String deviceId = a.uP().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.aou = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d uP = a.uP();
        String ua = this.aot.getUA();
        String appName = com.baidu.e.b.a.uN().getAppName();
        String zid = uP.getZid();
        String bDVCInfo = uP.getBDVCInfo();
        String sid = uP.getSid();
        String deviceInfo = this.aor.getDeviceInfo();
        String str2 = this.aou;
        String from = uP.getFrom();
        String cfrom = uP.getCfrom();
        String schemeHeader = uP.getSchemeHeader();
        if (TextUtils.isEmpty(from)) {
            from = com.baidu.e.a.a.uM().getChannel();
        }
        if (TextUtils.isEmpty(cfrom)) {
            cfrom = com.baidu.e.a.a.uM().getLastChannel();
        }
        String k = uP.k(this.aos.addNetWorkParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sid), "ut", deviceInfo), j.c, ua), "bdvc", bDVCInfo), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, cfrom), "from", from), "scheme", schemeHeader), true), true);
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = uP.getC3Aid();
        }
        if (!TextUtils.isEmpty(this.mC3Aid)) {
            return addParam(k, "c3_aid", this.mC3Aid);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, i.getEncodeValue(str3));
        }
        return str;
    }
}
