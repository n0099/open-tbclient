package com.baidu.common.param;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.util.Base64Encoder;
import d.b.l.c.a;
import d.b.l.c.b;
import d.b.l.c.c;
import d.b.l.c.e;
import d.b.l.c.g;
import d.b.l.c.h;
/* loaded from: classes2.dex */
public final class CommonUrlParamManager {
    public static final String PARAM_APP_NAME = "appname";
    public static final String PARAM_BDVC = "bdvc";
    public static final String PARAM_C3AID = "c3_aid";
    public static final String PARAM_CFROM = "cfrom";
    public static final String PARAM_FROM = "from";
    public static final String PARAM_SCHEME_HEADER = "scheme";
    public static final String PARAM_SID = "sid";
    public static final String PARAM_UA = "ua";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UT = "ut";
    public static final String PARAM_ZID = "zid";
    public static CommonUrlParamManager sCommonUrlParamManager;
    public volatile String mC3Aid = null;
    public b mDeviceInfoParam;
    public String mEnuid;
    public e mNetworkParam;
    public g mUaParam;

    public CommonUrlParamManager() {
        init();
    }

    private String addParam(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, h.a(str3)) : str;
    }

    public static CommonUrlParamManager getInstance() {
        if (sCommonUrlParamManager == null) {
            synchronized (CommonUrlParamManager.class) {
                if (sCommonUrlParamManager == null) {
                    sCommonUrlParamManager = new CommonUrlParamManager();
                }
            }
        }
        return sCommonUrlParamManager;
    }

    private void init() {
        this.mNetworkParam = new e();
        this.mDeviceInfoParam = new b();
        this.mUaParam = new g();
        String deviceId = a.a().getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            return;
        }
        this.mEnuid = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
    }

    public String processUrl(String str) {
        c a2 = a.a();
        String a3 = this.mUaParam.a();
        String a4 = d.b.l.b.a.b().a();
        String zid = a2.getZid();
        String bDVCInfo = a2.getBDVCInfo();
        String sid = a2.getSid();
        String a5 = this.mDeviceInfoParam.a();
        String str2 = this.mEnuid;
        String from = a2.getFrom();
        String cfrom = a2.getCfrom();
        String schemeHeader = a2.getSchemeHeader();
        if (TextUtils.isEmpty(from)) {
            from = d.b.l.a.a.b().a();
        }
        if (TextUtils.isEmpty(cfrom)) {
            cfrom = d.b.l.a.a.b().c();
        }
        String a6 = this.mNetworkParam.a(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "appname", a4), "sid", sid), "ut", a5), "ua", a3), "bdvc", bDVCInfo), "zid", zid), "uid", str2), "cfrom", cfrom), "from", from), "scheme", schemeHeader), true);
        a2.a(a6, true);
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = a2.getC3Aid();
        }
        return !TextUtils.isEmpty(this.mC3Aid) ? addParam(a6, "c3_aid", this.mC3Aid) : a6;
    }
}
