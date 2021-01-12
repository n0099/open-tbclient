package com.baidu.d.c;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes6.dex */
public final class b {
    private static b aoe;
    private c aof;
    private f aog;
    private h aoh;
    private String aoi;
    private volatile String mC3Aid = null;

    private b() {
        init();
    }

    public static b uj() {
        if (aoe == null) {
            synchronized (b.class) {
                if (aoe == null) {
                    aoe = new b();
                }
            }
        }
        return aoe;
    }

    private void init() {
        this.aog = new f();
        this.aof = new c();
        this.aoh = new h();
        String deviceId = a.uh().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.aoi = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d uh = a.uh();
        String ua = this.aoh.getUA();
        String appName = com.baidu.d.b.a.uf().getAppName();
        String zid = uh.getZid();
        String bDVCInfo = uh.getBDVCInfo();
        String sid = uh.getSid();
        String deviceInfo = this.aof.getDeviceInfo();
        String str2 = this.aoi;
        String from = uh.getFrom();
        String cfrom = uh.getCfrom();
        String schemeHeader = uh.getSchemeHeader();
        if (TextUtils.isEmpty(from)) {
            from = com.baidu.d.a.a.ue().getChannel();
        }
        if (TextUtils.isEmpty(cfrom)) {
            cfrom = com.baidu.d.a.a.ue().getLastChannel();
        }
        String k = uh.k(this.aog.addNetWorkParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sid), "ut", deviceInfo), j.c, ua), "bdvc", bDVCInfo), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, cfrom), "from", from), "scheme", schemeHeader), true), true);
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = uh.getC3Aid();
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
