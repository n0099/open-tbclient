package com.baidu.tbadk.core.util.httpNet;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.cw4;
import com.baidu.tieba.hj;
import com.baidu.tieba.n05;
import com.baidu.tieba.nq4;
import com.baidu.tieba.pa5;
import com.baidu.tieba.pq4;
import com.baidu.tieba.sg;
import com.baidu.tieba.ux4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class HttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANDROID_ID = "android_id";
    public static final String ANDROID_ID_REVERSAL = "di_diordna";
    public static final String BDUSS = "BDUSS";
    public static final String CLIENT_ID = "_client_id";
    public static final String CLIENT_TYPE = "_client_type";
    public static final String CLIENT_VERSION = "_client_version";
    public static final String FROM = "from";
    public static final String MAC = "mac";
    public static final String MAC_REVERSAL = "cam";
    public static final String NET_CLASS = "net";
    public static final String NET_TYPE = "net_type";
    public static final String PHONE_IMEI = "_phone_imei";
    public static final String PHONE_IMEI_REVERSAL = "iemi";
    public static final String PHONE_NEWIMEI = "_phone_newimei";
    public static final String PHONE_NEWIMEI_REVERSAL = "iemiwen";
    public static final String STOKEN = "stoken";
    public static final String SUBAPP_TYPE = "subapp_type";
    public static final String TBS = "tbs";
    public static final String USER_AGENT = "user_agent";
    public transient /* synthetic */ FieldHolder $fh;
    public String charSet;
    public boolean mCanHttpsDownToHttp;
    public HashMap<String, byte[]> mFileData;
    public String mFrom;
    public boolean mIsBDImage;
    public boolean mIsBaiduServer;
    public boolean mIsFromCDN;
    public boolean mIsJson;
    public boolean mIsNeedAddCommenParam;
    public boolean mIsNeedTbs;
    public boolean mIsRequestImage;
    public boolean mIsUseCurrentBDUSS;
    public boolean mNeedBackgroundLogin;
    public boolean mNeedSig;
    public String mNetType;
    public ArrayList<BasicNameValuePair> mPostData;
    public boolean mRequestGzip;
    public String mSeqId;
    public String mUrl;

    public HttpRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsNeedTbs = false;
        this.mNeedBackgroundLogin = true;
        this.mIsUseCurrentBDUSS = true;
        this.mIsNeedAddCommenParam = true;
        this.mCanHttpsDownToHttp = false;
        this.mIsFromCDN = false;
        this.mIsRequestImage = false;
        this.mRequestGzip = true;
        this.mIsBaiduServer = true;
        this.mIsJson = true;
        this.charSet = "UTF-8";
    }

    public String getApiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.mUrl;
            if (str == null) {
                return null;
            }
            String str2 = TbConfig.SERVER_ADDRESS;
            if (str.startsWith(str2)) {
                int indexOf = this.mUrl.indexOf(63);
                if (indexOf < 0) {
                    indexOf = this.mUrl.length();
                }
                return this.mUrl.substring(str2.length(), indexOf);
            }
            return this.mUrl;
        }
        return (String) invokeV.objValue;
    }

    private String getBdussData() {
        InterceptResult invokeV;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                b = currentAccountInfo.getBDUSS();
            } else {
                if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                    b = pa5.b();
                }
                return null;
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess() && TextUtils.isEmpty(b)) {
                currentAccountInfo = nq4.e();
                if (currentAccountInfo == null) {
                    return null;
                }
                b = currentAccountInfo.getBDUSS();
            }
            if (!TextUtils.isEmpty(b) && this.mIsUseCurrentBDUSS) {
                StringBuilder sb = new StringBuilder();
                sb.append(BDUSS);
                sb.append("=");
                sb.append(b);
                sb.append(ParamableElem.DIVIDE_PARAM);
                String a = pq4.a(currentAccountInfo);
                if (!StringUtils.isNull(a)) {
                    sb.append("stoken");
                    sb.append("=");
                    sb.append(a);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void addBdussData(INetWorkCore iNetWorkCore) {
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iNetWorkCore) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                b = currentAccountInfo.getBDUSS();
            } else if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                b = pa5.b();
            } else {
                return;
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess() && TextUtils.isEmpty(b)) {
                currentAccountInfo = nq4.e();
                if (currentAccountInfo == null) {
                    return;
                }
                b = currentAccountInfo.getBDUSS();
            }
            if (!TextUtils.isEmpty(b) && this.mIsUseCurrentBDUSS) {
                iNetWorkCore.addPostData(BDUSS, b);
                String a = pq4.a(currentAccountInfo);
                if (!StringUtils.isNull(a)) {
                    iNetWorkCore.addPostData("stoken", a);
                }
            }
        }
    }

    public void addCommonParam(INetWorkCore iNetWorkCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iNetWorkCore) == null) {
            addCommonParam(iNetWorkCore, false);
        }
    }

    public void addCommonParam(INetWorkCore iNetWorkCore, boolean z) {
        boolean z2;
        String bdussData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, iNetWorkCore, z) == null) {
            String str = "2";
            iNetWorkCore.addPostData(CLIENT_TYPE, "2");
            if (!TbadkCoreApplication.getInst().isOfficial()) {
                iNetWorkCore.addPostData("apid", TbConfig.SW_APID);
            }
            iNetWorkCore.addPostData("_client_version", TbConfig.getVersion());
            if (TbadkCoreApplication.getInst().getImei() != null) {
                if (ComplianceParmasHelper.isNeedChange(this.mUrl)) {
                    iNetWorkCore.addPostData(ComplianceParmasHelper.getRenameKey(PHONE_IMEI), ComplianceParmasHelper.getBase64Value(TbadkCoreApplication.getInst().getImei()));
                } else {
                    iNetWorkCore.addPostData(PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
                }
            }
            String clientId = TbadkCoreApplication.getClientId();
            if (clientId != null) {
                iNetWorkCore.addPostData(CLIENT_ID, clientId);
            }
            String subappType = TbConfig.getSubappType();
            if (!TextUtils.isEmpty(subappType)) {
                iNetWorkCore.addPostData(SUBAPP_TYPE, subappType);
            }
            String from = TbadkCoreApplication.getFrom();
            if (from != null && from.length() > 0) {
                iNetWorkCore.addPostData("from", from);
            }
            int netType = BdNetTypeUtil.netType();
            iNetWorkCore.addPostData("net_type", String.valueOf(netType));
            String a = n05.b().a();
            if (TbSingleton.getInstance().isVisitPreviewServer()) {
                a = a + "pub_env=" + TbSingleton.getInstance().getPubEnvValue() + ParamableElem.DIVIDE_PARAM;
            }
            if (1 == netType) {
                if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                    a = a + "ka=open;";
                    z2 = true;
                }
                z2 = false;
            } else {
                if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                    a = a + "ka=open;";
                    z2 = true;
                }
                z2 = false;
            }
            if (z && (bdussData = getBdussData()) != null) {
                a = a + bdussData;
            }
            sg.s(z2);
            sg.n(a + "BAIDUID=" + TbSingleton.getInstance().getBaiduIdForAnti());
            if (this.mIsNeedTbs) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    iNetWorkCore.addPostData(TBS, pa5.f());
                } else {
                    iNetWorkCore.addPostData(TBS, TbadkCoreApplication.getInst().getTbs());
                }
            }
            String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            if (!TextUtils.isEmpty(lastCachedOid)) {
                iNetWorkCore.addPostData("oaid", lastCachedOid);
            }
            iNetWorkCore.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
            iNetWorkCore.addPostData("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            iNetWorkCore.addPostData("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            iNetWorkCore.addPostData(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            iNetWorkCore.addPostData("timestamp", Long.toString(System.currentTimeMillis()));
            iNetWorkCore.addPostData("model", hj.g());
            iNetWorkCore.addPostData(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.BRAND);
            iNetWorkCore.addPostData("baiduid", TbSingleton.getInstance().getBaiduIdForAnti());
            if (ux4.k().l("android_safe_sdk_open", 0) == 1) {
                iNetWorkCore.addPostData("z_id", TbadkCoreApplication.getInst().getZid());
            }
            if (ComplianceParmasHelper.isNeedChange(this.mUrl)) {
                iNetWorkCore.addPostData(ComplianceParmasHelper.getRenameKey("mac"), ComplianceParmasHelper.getBase64Value(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst())));
                iNetWorkCore.addPostData(ComplianceParmasHelper.getRenameKey(ANDROID_ID), ComplianceParmasHelper.getBase64Value(TbadkCoreApplication.getInst().getAndroidId()));
            } else {
                iNetWorkCore.addPostData("mac", PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
                iNetWorkCore.addPostData(ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getSampleId())) {
                iNetWorkCore.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
            }
            iNetWorkCore.addPostData("active_timestamp", String.valueOf(TbSingleton.getInstance().getActiveTimeStamp()));
            iNetWorkCore.addPostData("first_install_time", String.valueOf(TbSingleton.getInstance().getAppFirstInstallTime()));
            iNetWorkCore.addPostData(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, String.valueOf(TbSingleton.getInstance().getAppLastUpdateTime()));
            iNetWorkCore.addPostData("event_day", TbSingleton.getInstance().getData());
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                str = "1";
            }
            iNetWorkCore.addPostData("cmode", str);
            iNetWorkCore.addPostData("is_teenager", "0");
            iNetWorkCore.addPostData("start_type", cw4.f + "");
            iNetWorkCore.addPostData("start_scheme", cw4.e());
        }
    }
}
