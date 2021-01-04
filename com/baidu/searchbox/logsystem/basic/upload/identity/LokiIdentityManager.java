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
/* loaded from: classes6.dex */
public final class LokiIdentityManager {
    private static final String PARAM_APP_NAME = "appname";
    private static final String PARAM_BDVC = "bdvc";
    private static final String PARAM_C3AID = "c3_aid";
    private static final String PARAM_CFROM = "cfrom";
    private static final String PARAM_FROM = "from";
    private static final String PARAM_SCHEME_HEADER = "scheme";
    private static final String PARAM_SID = "sid";
    private static final String PARAM_UA = "ua";
    private static final String PARAM_UID = "uid";
    private static final String PARAM_UT = "ut";
    private static final String PARAM_ZID = "zid";
    private static volatile LokiIdentityManager sLokiIdentityManager;
    private volatile String mC3Aid = null;
    private Context mContext;
    private DeviceInfoParam mDeviceInfoParam;
    private String mEnUid;
    private NetworkParam mNetworkParam;
    private UaParam mUaParam;
    private String mUid;

    private LokiIdentityManager() {
        init();
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

    public static String getEncodeValue(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    private void init() {
        this.mContext = AppRuntime.getAppContext();
        this.mNetworkParam = new NetworkParam();
        this.mDeviceInfoParam = new DeviceInfoParam();
        this.mUaParam = new UaParam();
        this.mUid = DeviceId.getCUID(this.mContext);
        if (!TextUtils.isEmpty(this.mUid)) {
            this.mEnUid = new String(Base64Encoder.B64Encode(this.mUid.getBytes()));
        }
    }

    public String processUrl(String str) {
        String ua = this.mUaParam.getUA();
        String deviceInfo = this.mDeviceInfoParam.getDeviceInfo();
        String addParam = addParam(addParam(addParam(addParam(this.mNetworkParam.addNetWorkParam(str, true), PARAM_UT, deviceInfo), "ua", ua), "uid", this.mEnUid), PARAM_APP_NAME, LokiRuntime.getIdentityNeedContext().getAppName());
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
        String addParam2 = addParam(addParam(addParam(addParam(addParam(addParam(addParam, PARAM_BDVC, identityContext.getBDVCInfo()), "sid", sid), PARAM_ZID, zid), "cfrom", cfrom), "from", from), PARAM_SCHEME_HEADER, schemeHeader);
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = identityContext.getC3Aid();
        }
        if (!TextUtils.isEmpty(this.mC3Aid)) {
            return addParam(addParam2, PARAM_C3AID, this.mC3Aid);
        }
        return addParam2;
    }

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, getEncodeValue(str3));
        }
        return str;
    }
}
