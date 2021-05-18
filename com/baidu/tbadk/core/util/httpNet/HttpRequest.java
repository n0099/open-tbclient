package com.baidu.tbadk.core.util.httpNet;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.j;
import d.a.j0.f0.f;
import d.a.j0.r.d0.b;
import d.a.j0.r.l.c;
import d.a.j0.r.l.e;
import d.a.j0.s.b.a;
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
    public static final String NET_CLASS = "net";
    public static final String NET_TYPE = "net_type";
    public static final String PHONE_IMEI = "_phone_imei";
    public static final String STOKEN = "stoken";
    public static final String SUBAPP_TYPE = "subapp_type";
    public static final String TBS = "tbs";
    public boolean mNeedSig;
    public final NetWorkParam netWorkParam = new NetWorkParam();
    public boolean mIsNeedTbs = false;
    public boolean mNeedBackgroundLogin = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mCanHttpsDownToHttp = false;
    public boolean mIsFromCDN = false;
    public boolean mIsRequestImage = false;
    public int mImageType = 0;

    public void addBdussData(INetWorkCore iNetWorkCore) {
        String b2;
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
        String a2 = e.a(currentAccountInfo);
        if (StringUtils.isNull(a2)) {
            return;
        }
        iNetWorkCore.addPostData("stoken", a2);
    }

    public void addCommonParam(INetWorkCore iNetWorkCore) {
        boolean z;
        iNetWorkCore.addPostData(CLIENT_TYPE, "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            iNetWorkCore.addPostData("apid", "sw");
        }
        iNetWorkCore.addPostData("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            iNetWorkCore.addPostData(PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
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
        int I = j.I();
        iNetWorkCore.addPostData("net_type", String.valueOf(I));
        String a2 = a.b().a();
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            a2 = a2 + "pub_env=" + TbSingleton.getInstance().getPubEnvValue() + ";";
        }
        if (1 == I) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                a2 = a2 + "ka=open";
                z = true;
            }
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                a2 = a2 + "ka=open";
                z = true;
            }
            z = false;
        }
        d.a.c.e.j.b.a.s(z);
        d.a.c.e.j.b.a.n(a2);
        if (this.mIsNeedTbs) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                iNetWorkCore.addPostData(TBS, f.d());
            } else {
                iNetWorkCore.addPostData(TBS, TbadkCoreApplication.getInst().getTbs());
            }
        }
        iNetWorkCore.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
        iNetWorkCore.addPostData("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        iNetWorkCore.addPostData("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        iNetWorkCore.addPostData(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
        iNetWorkCore.addPostData("timestamp", Long.toString(System.currentTimeMillis()));
        iNetWorkCore.addPostData("model", Build.MODEL);
        if (b.j().k("android_safe_sdk_open", 0) == 1) {
            iNetWorkCore.addPostData("z_id", TbadkCoreApplication.getInst().getZid());
        }
        iNetWorkCore.addPostData("active_timestamp", String.valueOf(TbSingleton.getInstance().getActiveTimeStamp()));
        iNetWorkCore.addPostData("first_install_time", String.valueOf(TbSingleton.getInstance().getAppFirstInstallTime()));
        iNetWorkCore.addPostData(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, String.valueOf(TbSingleton.getInstance().getAppLastUpdateTime()));
        iNetWorkCore.addPostData("event_day", TbSingleton.getInstance().getData());
    }

    public String getApiName() {
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

    public NetWorkParam getNetWorkParam() {
        return this.netWorkParam;
    }
}
