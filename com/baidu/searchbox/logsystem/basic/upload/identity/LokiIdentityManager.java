package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
    public static final String PARAM_IID = "iid";
    public static final String PARAM_SCHEME_HEADER = "scheme";
    public static final String PARAM_SID = "sid";
    public static final String PARAM_UA = "ua";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UT = "ut";
    public static final String PARAM_ZID = "zid";
    public static volatile LokiIdentityManager sLokiIdentityManager;
    public Context mContext;
    public DeviceInfoParam mDeviceInfoParam;
    public String mEnUid;
    public String mIID;
    public NetworkParam mNetworkParam;
    public UaParam mUaParam;
    public String mUid;
    public volatile String mC3Aid = null;
    public boolean mHasPrivacy = true;

    public LokiIdentityManager() {
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

    private String addParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return UrlUtil.addParam(str, str2, getEncodeValue(str3));
        }
        return str;
    }

    public static String getEncodeValue(String str) {
        try {
            return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
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
        boolean hasPrivacyAuthority = LokiRuntime.getIdentityContext().hasPrivacyAuthority();
        this.mHasPrivacy = hasPrivacyAuthority;
        if (hasPrivacyAuthority) {
            String cuid = DeviceId.getCUID(this.mContext);
            this.mUid = cuid;
            if (!TextUtils.isEmpty(cuid)) {
                this.mEnUid = new String(Base64Encoder.B64Encode(this.mUid.getBytes()));
                return;
            }
            return;
        }
        this.mIID = LokiRuntime.getIdentityContext().getIID();
    }

    public String processUrl(String str) {
        String addParam;
        String addParam2 = addParam(addParam(this.mNetworkParam.addNetWorkParam(str, true), "ut", this.mDeviceInfoParam.getDeviceInfo()), "ua", this.mUaParam.getUA());
        if (this.mHasPrivacy) {
            addParam = addParam(addParam2, "uid", this.mEnUid);
        } else {
            addParam = addParam(addParam2, "iid", this.mIID);
        }
        String addParam3 = addParam(addParam, "appname", LokiRuntime.getIdentityNeedContext().getAppName());
        ILokiIdentityContext identityContext = LokiRuntime.getIdentityContext();
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
        String addParam4 = addParam(addParam(addParam(addParam(addParam(addParam3, "bdvc", identityContext.getBDVCInfo()), "sid", sid), "cfrom", cfrom), "from", from), "scheme", schemeHeader);
        if (this.mHasPrivacy) {
            addParam4 = addParam(addParam4, "zid", identityContext.getZid());
        }
        if (this.mHasPrivacy && TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = identityContext.getC3Aid();
        }
        if (this.mHasPrivacy && !TextUtils.isEmpty(this.mC3Aid)) {
            return addParam(addParam4, "c3_aid", this.mC3Aid);
        }
        return addParam4;
    }
}
