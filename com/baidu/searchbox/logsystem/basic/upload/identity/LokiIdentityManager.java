package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.upload.LokiRuntime;
import com.baidu.util.Base64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public final class LokiIdentityManager {
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
    public static volatile LokiIdentityManager sLokiIdentityManager;
    public volatile String mC3Aid = null;
    public Context mContext;
    public DeviceInfoParam mDeviceInfoParam;
    public String mEnUid;
    public NetworkParam mNetworkParam;
    public UaParam mUaParam;
    public String mUid;

    public LokiIdentityManager() {
        init();
    }

    private String addParam(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, getEncodeValue(str3)) : str;
    }

    public static String getEncodeValue(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static LokiIdentityManager getInstance() {
        if (sLokiIdentityManager == null) {
            synchronized (LokiIdentityManager.class) {
                if (sLokiIdentityManager == null) {
                    sLokiIdentityManager = new LokiIdentityManager();
                }
            }
        }
        return sLokiIdentityManager;
    }

    private void init() {
        this.mContext = AppRuntime.getAppContext();
        this.mNetworkParam = new NetworkParam();
        this.mDeviceInfoParam = new DeviceInfoParam();
        this.mUaParam = new UaParam();
        String cuid = DeviceId.getCUID(this.mContext);
        this.mUid = cuid;
        if (TextUtils.isEmpty(cuid)) {
            return;
        }
        this.mEnUid = new String(Base64Encoder.B64Encode(this.mUid.getBytes()));
    }

    public String processUrl(String str) {
        String addParam = addParam(addParam(addParam(addParam(this.mNetworkParam.addNetWorkParam(str, true), "ut", this.mDeviceInfoParam.getDeviceInfo()), "ua", this.mUaParam.getUA()), "uid", this.mEnUid), "appname", LokiRuntime.getIdentityNeedContext().getAppName());
        ILokiIdentityContext identityContext = LokiRuntime.getIdentityContext();
        String zid = identityContext.getZid();
        String sid = identityContext.getSid();
        String from = identityContext.getFrom();
        String cfrom = identityContext.getCfrom();
        String schemeHeader = identityContext.getSchemeHeader();
        if (TextUtils.isEmpty(from)) {
            from = ChannelManager.getInstance().getChannel();
        }
        if (TextUtils.isEmpty(cfrom)) {
            cfrom = ChannelManager.getInstance().getLastChannel();
        }
        String addParam2 = addParam(addParam(addParam(addParam(addParam(addParam(addParam, "bdvc", identityContext.getBDVCInfo()), "sid", sid), "zid", zid), "cfrom", cfrom), "from", from), "scheme", schemeHeader);
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = identityContext.getC3Aid();
        }
        return !TextUtils.isEmpty(this.mC3Aid) ? addParam(addParam2, "c3_aid", this.mC3Aid) : addParam2;
    }
}
