package com.baidu.live.tbadk.core.util.httpnet;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.account.StokenPolicy;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.INetWorkCore;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.sofire.ac.FH;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class HttpRequest {
    public static final String BDUSS = "BDUSS";
    public static final String CLIENT_ID = "_client_id";
    public static final String CLIENT_TYPE = "_client_type";
    public static final String CLIENT_VERSION = "_client_version";
    public static final String FROM = "from";
    public static final String IMAGE_FROM_FRS = "frs";
    public static final String IMAGE_FROM_OTHER = "other";
    public static final String IMAGE_FROM_PB = "pb";
    public static final String LIVE_ENTER_TYPE = "live_enter_type";
    public static final String NET_CLASS = "net";
    public static final String NET_TYPE = "net_type";
    public static final String PHONE_IMEI = "_phone_imei";
    public static final String SDK_LIVE_IS_HOT = "ishot";
    public static final String SDK_LIVE_LIVE_ACTIVITY_TYPE = "live_activity_type";
    public static final String SDK_VERSION = "_sdk_version";
    public static final String STOKEN = "stoken";
    public static final String SUBAPP_TYPE = "subapp_type";
    public static final String SUBAPP_VERSION = "subapp_version";
    public static final String SUBAPP_VERSION_NAME = "subapp_version_name";
    public static final String TBS = "tbs";
    private final NetWorkParam netWorkParam = new NetWorkParam();
    public boolean mIsNeedTbs = false;
    public boolean mNeedBackgroundLogin = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean mIsRequestImage = false;
    public int mImageType = 0;

    public NetWorkParam getNetWorkParam() {
        return this.netWorkParam;
    }

    public void addBdussData(INetWorkCore iNetWorkCore) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            iNetWorkCore.addPostData("BDUSS", bduss);
            String verificatedStoken = StokenPolicy.getVerificatedStoken(currentAccountInfo);
            if (!StringUtils.isNull(verificatedStoken)) {
                iNetWorkCore.addPostData("stoken", verificatedStoken);
            }
        }
    }

    public void addCommonParam(INetWorkCore iNetWorkCore) {
        iNetWorkCore.addPostData("_client_type", "2");
        iNetWorkCore.addPostData("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            iNetWorkCore.addPostData("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            iNetWorkCore.addPostData("subapp_type", subappType);
        }
        iNetWorkCore.addPostData(SUBAPP_VERSION, TbConfig.getSubappVersionCode() + "");
        iNetWorkCore.addPostData(SUBAPP_VERSION_NAME, TbConfig.getSubappVersionName());
        iNetWorkCore.addPostData(SDK_VERSION, TbConfig.SDK_VERSION);
        if (AlaLiveSwitchData.isHotLive == 1) {
            iNetWorkCore.addPostData(SDK_LIVE_IS_HOT, "1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            iNetWorkCore.addPostData(SDK_LIVE_LIVE_ACTIVITY_TYPE, AlaLiveSwitchData.liveActivityType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            iNetWorkCore.addPostData("from", from);
        }
        int netType = BdNetTypeUtil.netType();
        iNetWorkCore.addPostData("net_type", String.valueOf(netType));
        if (1 != netType ? TbadkCoreApplication.getInst().getKeepaliveNonWifi() != 1 : TbadkCoreApplication.getInst().getKeepaliveWifi() != 1) {
        }
        if (this.mIsNeedTbs) {
            iNetWorkCore.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        iNetWorkCore.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
        iNetWorkCore.addPostData("timestamp", Long.toString(System.currentTimeMillis()));
        iNetWorkCore.addPostData("model", Build.MODEL);
        iNetWorkCore.addPostData(Constants.PHONE_BRAND, Build.BRAND);
        iNetWorkCore.addPostData("_os_version", Build.VERSION.RELEASE);
        if (SharedPrefHelper.getInstance().getInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, 0) == 1) {
            iNetWorkCore.addPostData("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String getApiName() {
        if (this.netWorkParam.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.netWorkParam.mUrl.startsWith(str)) {
            int indexOf = this.netWorkParam.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.netWorkParam.mUrl.length();
            }
            return this.netWorkParam.mUrl.substring(str.length(), indexOf);
        }
        return this.netWorkParam.mUrl;
    }
}
