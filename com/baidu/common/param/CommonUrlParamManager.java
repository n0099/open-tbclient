package com.baidu.common.param;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.util.Base64Encoder;
import d.a.l.c.a;
import d.a.l.c.b;
import d.a.l.c.c;
import d.a.l.c.d;
import d.a.l.c.f;
import d.a.l.c.h;
import d.a.l.c.i;
/* loaded from: classes.dex */
public final class CommonUrlParamManager {
    public static final String PARAM_APP_NAME = "appname";
    public static final String PARAM_BDVC = "bdvc";
    public static final String PARAM_C3AID = "c3_aid";
    public static final String PARAM_CFROM = "cfrom";
    public static final String PARAM_FROM = "from";
    public static final String PARAM_IID = "iid";
    public static final String PARAM_MATRIXSTYLE = "matrixstyle";
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
    public f mNetworkParam;
    public h mUaParam;

    public CommonUrlParamManager() {
        init();
    }

    private String addParam(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, i.a(str3)) : str;
    }

    private String getC3Aid() {
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = a.a().getC3Aid();
        }
        return this.mC3Aid;
    }

    private String getEnuid() {
        if (TextUtils.isEmpty(this.mEnuid)) {
            String deviceId = a.a().getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                this.mEnuid = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
            }
        }
        return this.mEnuid;
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
        this.mNetworkParam = new f();
        this.mDeviceInfoParam = new b();
        this.mUaParam = new h();
    }

    public String processUrl(String str) {
        c a2 = a.a();
        String enuid = getEnuid();
        String c3Aid = getC3Aid();
        String zid = a2.getZid();
        d b2 = a.b();
        String a3 = b2.a();
        if (b2.c()) {
            return processUrl(enuid, zid, c3Aid, null, str);
        }
        return processUrl(null, null, null, a3, str);
    }

    public String spliceNoPrivacyParams(String str) {
        return processUrl(null, null, null, a.b().a(), str);
    }

    private String processUrl(String str, String str2, String str3, String str4, String str5) {
        c a2 = a.a();
        String a3 = this.mUaParam.a();
        String a4 = d.a.l.b.a.b().a();
        String sid = a2.getSid();
        String bDVCInfo = a2.getBDVCInfo();
        String a5 = this.mDeviceInfoParam.a();
        String from = a2.getFrom();
        String cfrom = a2.getCfrom();
        String schemeHeader = a2.getSchemeHeader();
        String b2 = a.b().b();
        if (TextUtils.isEmpty(from)) {
            from = d.a.l.a.a.b().a();
        }
        if (TextUtils.isEmpty(cfrom)) {
            cfrom = d.a.l.a.a.b().c();
        }
        String addParam = addParam(addParam(this.mNetworkParam.a(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str5, "appname", a4), "sid", sid), "ut", a5), "ua", a3), "bdvc", bDVCInfo), "zid", str2), "uid", str), PARAM_IID, str4), "cfrom", cfrom), "from", from), "scheme", schemeHeader), true), "c3_aid", str3), PARAM_MATRIXSTYLE, b2);
        a2.a(addParam, true);
        return addParam;
    }
}
