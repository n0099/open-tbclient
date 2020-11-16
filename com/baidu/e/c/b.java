package com.baidu.e.c;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.util.Base64Encoder;
/* loaded from: classes14.dex */
public final class b {
    private static b ant;
    private c anu;
    private e anv;
    private g anw;
    private String anx;
    private volatile String any = null;

    private b() {
        init();
    }

    public static b uU() {
        if (ant == null) {
            synchronized (b.class) {
                if (ant == null) {
                    ant = new b();
                }
            }
        }
        return ant;
    }

    private void init() {
        this.anv = new e();
        this.anu = new c();
        this.anw = new g();
        String deviceId = a.uT().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            this.anx = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
        }
    }

    public String processUrl(String str) {
        d uT = a.uT();
        String vc = this.anw.vc();
        String appName = com.baidu.e.b.a.uR().getAppName();
        String zid = uT.getZid();
        String uW = uT.uW();
        String uX = uT.uX();
        String deviceInfo = this.anu.getDeviceInfo();
        String str2 = this.anx;
        String from = uT.getFrom();
        String uY = uT.uY();
        String va = uT.va();
        if (TextUtils.isEmpty(from)) {
            from = com.baidu.e.a.a.uJ().getChannel();
        }
        if (TextUtils.isEmpty(uY)) {
            uY = com.baidu.e.a.a.uJ().uK();
        }
        String k = uT.k(this.anv.l(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", appName), UbcStatConstant.KEY_CONTENT_EXT_SID, uX), "ut", deviceInfo), j.c, vc), "bdvc", uW), "zid", zid), "uid", str2), BdStatsConstant.StatsKey.CURRENT_CHANNEL, uY), "from", from), "scheme", va), true), true);
        if (TextUtils.isEmpty(this.any)) {
            this.any = uT.uZ();
        }
        if (!TextUtils.isEmpty(this.any)) {
            return addParam(k, "c3_aid", this.any);
        }
        return k;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, h.dA(str3));
        }
        return str;
    }
}
