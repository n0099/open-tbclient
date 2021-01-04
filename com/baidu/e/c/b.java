package com.baidu.e.c;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes6.dex */
public final class b {
    private static b aoR;
    private c aoS;
    private f aoT;
    private h aoU;
    private String aoV;
    private volatile String mC3Aid = null;

    private b() {
        init();
    }

    public static b uq() {
        if (aoR == null) {
            synchronized (b.class) {
                if (aoR == null) {
                    aoR = new b();
                }
            }
        }
        return aoR;
    }

    private void init() {
        this.aoT = new f();
        this.aoS = new c();
        this.aoU = new h();
        String deviceId = a.uo().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.aoV = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d uo = a.uo();
        String ua = this.aoU.getUA();
        String appName = com.baidu.e.b.a.um().getAppName();
        String zid = uo.getZid();
        String bDVCInfo = uo.getBDVCInfo();
        String sid = uo.getSid();
        String deviceInfo = this.aoS.getDeviceInfo();
        String str2 = this.aoV;
        String from = uo.getFrom();
        String cfrom = uo.getCfrom();
        String schemeHeader = uo.getSchemeHeader();
        if (TextUtils.isEmpty(from)) {
            from = com.baidu.e.a.a.ul().getChannel();
        }
        if (TextUtils.isEmpty(cfrom)) {
            cfrom = com.baidu.e.a.a.ul().getLastChannel();
        }
        String k = uo.k(this.aoT.addNetWorkParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sid), "ut", deviceInfo), j.c, ua), "bdvc", bDVCInfo), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, cfrom), "from", from), "scheme", schemeHeader), true), true);
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = uo.getC3Aid();
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
