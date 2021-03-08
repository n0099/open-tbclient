package com.baidu.tbadk.core.util.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class b {
    public boolean fby;
    private final g fdo = new g();
    public boolean mIsNeedTbs = false;
    public boolean mNeedBackgroundLogin = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean NZ = false;
    public boolean mIsFromCDN = false;
    public boolean mIsRequestImage = false;
    public int mImageType = 0;

    public g bth() {
        return this.fdo;
    }

    public void a(t tVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            tVar.addPostData("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.d.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                tVar.addPostData("stoken", c);
            }
        }
    }

    public void b(t tVar) {
        boolean z;
        tVar.addPostData("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            tVar.addPostData("apid", "sw");
        }
        tVar.addPostData("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            tVar.addPostData("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            tVar.addPostData("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            tVar.addPostData("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            tVar.addPostData("from", from);
        }
        int netType = j.netType();
        tVar.addPostData("net_type", String.valueOf(netType));
        String bvW = com.baidu.tbadk.coreExtra.b.a.bvT().bvW();
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            bvW = bvW + "pub_env=" + TbSingleton.getInstance().getPubEnvValue() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
        }
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                bvW = bvW + "ka=open";
                z = true;
            }
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                bvW = bvW + "ka=open";
                z = true;
            }
            z = false;
        }
        com.baidu.adp.lib.network.a.a.al(z);
        com.baidu.adp.lib.network.a.a.bQ(bvW);
        if (this.mIsNeedTbs) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                tVar.addPostData("tbs", com.baidu.tbadk.mutiprocess.f.getTbs());
            } else {
                tVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            }
        }
        tVar.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
        tVar.addPostData("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        tVar.addPostData("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        tVar.addPostData("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        tVar.addPostData("timestamp", Long.toString(System.currentTimeMillis()));
        tVar.addPostData("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, 0) == 1) {
            tVar.addPostData("z_id", TbadkCoreApplication.getInst().getZid());
        }
        tVar.addPostData("active_timestamp", String.valueOf(TbSingleton.getInstance().getActiveTimeStamp()));
        tVar.addPostData("first_install_time", String.valueOf(TbSingleton.getInstance().getAppFirstInstallTime()));
        tVar.addPostData(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, String.valueOf(TbSingleton.getInstance().getAppLastUpdateTime()));
        tVar.addPostData("event_day", TbSingleton.getInstance().getData());
    }

    public String getApiName() {
        if (this.fdo.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.fdo.mUrl.startsWith(str)) {
            int indexOf = this.fdo.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.fdo.mUrl.length();
            }
            return this.fdo.mUrl.substring(str.length(), indexOf);
        }
        return this.fdo.mUrl;
    }
}
