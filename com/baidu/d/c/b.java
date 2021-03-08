package com.baidu.d.c;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes4.dex */
public final class b {
    private static b apu;
    private c apv;
    private f apw;
    private h apx;
    private String apy;
    private volatile String mC3Aid = null;

    private b() {
        init();
    }

    public static b ug() {
        if (apu == null) {
            synchronized (b.class) {
                if (apu == null) {
                    apu = new b();
                }
            }
        }
        return apu;
    }

    private void init() {
        this.apw = new f();
        this.apv = new c();
        this.apx = new h();
        String deviceId = a.ue().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.apy = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d ue = a.ue();
        String ua = this.apx.getUA();
        String appName = com.baidu.d.b.a.uc().getAppName();
        String zid = ue.getZid();
        String bDVCInfo = ue.getBDVCInfo();
        String sid = ue.getSid();
        String deviceInfo = this.apv.getDeviceInfo();
        String str2 = this.apy;
        String from = ue.getFrom();
        String cfrom = ue.getCfrom();
        String schemeHeader = ue.getSchemeHeader();
        if (TextUtils.isEmpty(from)) {
            from = com.baidu.d.a.a.ub().getChannel();
        }
        if (TextUtils.isEmpty(cfrom)) {
            cfrom = com.baidu.d.a.a.ub().getLastChannel();
        }
        String k = ue.k(this.apw.addNetWorkParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sid), "ut", deviceInfo), j.c, ua), "bdvc", bDVCInfo), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, cfrom), "from", from), "scheme", schemeHeader), true), true);
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = ue.getC3Aid();
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
