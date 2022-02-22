package com.baidu.tbadk.core.util.httpNet;

import android.os.Build;
import android.text.TextUtils;
import c.a.d.f.p.l;
import c.a.t0.k0.f;
import c.a.t0.s.j0.b;
import c.a.t0.s.m.c;
import c.a.t0.s.m.e;
import c.a.t0.t.b.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes11.dex */
public class HttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANDROID_ID = "android_id";
    public static final String ANDROID_ID_REVERSAL = "di_diordna";
    public static final String BDUSS = "BDUSS";
    public static final String CLIENT_ID = "_client_id";
    public static final String CLIENT_TYPE = "_client_type";
    public static final String CLIENT_VERSION = "_client_version";
    public static final String FROM = "from";
    public static final String IMAGE_FROM_FRS = "frs";
    public static final String IMAGE_FROM_OTHER = "other";
    public static final String IMAGE_FROM_PB = "pb";
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
    public boolean mCanHttpsDownToHttp;
    public int mImageType;
    public boolean mIsFromCDN;
    public boolean mIsNeedAddCommenParam;
    public boolean mIsNeedTbs;
    public boolean mIsRequestImage;
    public boolean mIsUseCurrentBDUSS;
    public boolean mNeedBackgroundLogin;
    public boolean mNeedSig;
    public final NetWorkParam netWorkParam;

    public HttpRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.netWorkParam = new NetWorkParam();
        this.mIsNeedTbs = false;
        this.mNeedBackgroundLogin = true;
        this.mIsUseCurrentBDUSS = true;
        this.mIsNeedAddCommenParam = true;
        this.mCanHttpsDownToHttp = false;
        this.mIsFromCDN = false;
        this.mIsRequestImage = false;
        this.mImageType = 0;
    }

    public void addBdussData(INetWorkCore iNetWorkCore) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iNetWorkCore) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                b2 = currentAccountInfo.getBDUSS();
            } else if (!TbadkCoreApplication.getInst().isRemoteProcess()) {
                return;
            } else {
                b2 = f.b();
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess() && TextUtils.isEmpty(b2)) {
                currentAccountInfo = c.e();
                if (currentAccountInfo == null) {
                    return;
                }
                b2 = currentAccountInfo.getBDUSS();
            }
            if (TextUtils.isEmpty(b2) || !this.mIsUseCurrentBDUSS) {
                return;
            }
            iNetWorkCore.addPostData(BDUSS, b2);
            String a = e.a(currentAccountInfo);
            if (StringUtils.isNull(a)) {
                return;
            }
            iNetWorkCore.addPostData("stoken", a);
        }
    }

    public void addCommonParam(INetWorkCore iNetWorkCore) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iNetWorkCore) == null) {
            iNetWorkCore.addPostData(CLIENT_TYPE, "2");
            if (!TbadkCoreApplication.getInst().isOfficial()) {
                iNetWorkCore.addPostData("apid", TbConfig.SW_APID);
            }
            iNetWorkCore.addPostData("_client_version", TbConfig.getVersion());
            if (TbadkCoreApplication.getInst().getImei() != null) {
                if (ComplianceParmasHelper.isNeedChange(this.netWorkParam.mUrl)) {
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
            int I = l.I();
            iNetWorkCore.addPostData("net_type", String.valueOf(I));
            String a = a.b().a();
            if (TbSingleton.getInstance().isVisitPreviewServer()) {
                a = a + "pub_env=" + TbSingleton.getInstance().getPubEnvValue() + ";";
            }
            if (1 == I) {
                if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                    a = a + "ka=open;";
                    z = true;
                }
                z = false;
            } else {
                if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                    a = a + "ka=open;";
                    z = true;
                }
                z = false;
            }
            c.a.d.f.j.c.a.s(z);
            c.a.d.f.j.c.a.n(a + "BAIDUID=" + TbSingleton.getInstance().getBaiduIdForAnti());
            if (this.mIsNeedTbs) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    iNetWorkCore.addPostData(TBS, f.f());
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
            iNetWorkCore.addPostData("model", Build.MODEL);
            iNetWorkCore.addPostData("brand", Build.BRAND);
            iNetWorkCore.addPostData("baiduid", TbSingleton.getInstance().getBaiduIdForAnti());
            if (b.k().l("android_safe_sdk_open", 0) == 1) {
                iNetWorkCore.addPostData("z_id", TbadkCoreApplication.getInst().getZid());
            }
            if (ComplianceParmasHelper.isNeedChange(this.netWorkParam.mUrl)) {
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
            iNetWorkCore.addPostData(CommonUrlParamManager.PARAM_CMODE, PermissionUtil.isAgreePrivacyPolicy() ? "1" : "2");
            iNetWorkCore.addPostData("is_teenager", c.a.t0.g1.b.c.d() ? "1" : "0");
            StringBuilder sb = new StringBuilder();
            sb.append(c.a.t0.s.a0.a.f13402f);
            String str = "";
            sb.append("");
            iNetWorkCore.addPostData("start_type", sb.toString());
            try {
                if (!StringUtils.isNull(c.a.t0.s.a0.a.f13401e)) {
                    str = URLEncoder.encode(c.a.t0.s.a0.a.f13401e, "utf-8");
                }
                iNetWorkCore.addPostData("start_scheme", str);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String getApiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.netWorkParam.mUrl;
            if (str == null) {
                return null;
            }
            String str2 = TbConfig.SERVER_ADDRESS;
            if (str.startsWith(str2)) {
                int indexOf = this.netWorkParam.mUrl.indexOf(63);
                if (indexOf < 0) {
                    indexOf = this.netWorkParam.mUrl.length();
                }
                return this.netWorkParam.mUrl.substring(str2.length(), indexOf);
            }
            return this.netWorkParam.mUrl;
        }
        return (String) invokeV.objValue;
    }

    public NetWorkParam getNetWorkParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.netWorkParam : (NetWorkParam) invokeV.objValue;
    }
}
