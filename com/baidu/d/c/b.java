package com.baidu.d.c;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes5.dex */
public final class b {
    private static b anU;
    private c anV;
    private f anW;
    private h anX;
    private String anY;
    private volatile String mC3Aid = null;

    private b() {
        init();
    }

    public static b ug() {
        if (anU == null) {
            synchronized (b.class) {
                if (anU == null) {
                    anU = new b();
                }
            }
        }
        return anU;
    }

    private void init() {
        this.anW = new f();
        this.anV = new c();
        this.anX = new h();
        String deviceId = a.ue().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.anY = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d ue = a.ue();
        String ua = this.anX.getUA();
        String appName = com.baidu.d.b.a.uc().getAppName();
        String zid = ue.getZid();
        String bDVCInfo = ue.getBDVCInfo();
        String sid = ue.getSid();
        String deviceInfo = this.anV.getDeviceInfo();
        String str2 = this.anY;
        String from = ue.getFrom();
        String cfrom = ue.getCfrom();
        String schemeHeader = ue.getSchemeHeader();
        if (TextUtils.isEmpty(from)) {
            from = com.baidu.d.a.a.ub().getChannel();
        }
        if (TextUtils.isEmpty(cfrom)) {
            cfrom = com.baidu.d.a.a.ub().getLastChannel();
        }
        String k = ue.k(this.anW.addNetWorkParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, sid), "ut", deviceInfo), j.c, ua), "bdvc", bDVCInfo), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, cfrom), "from", from), "scheme", schemeHeader), true), true);
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
