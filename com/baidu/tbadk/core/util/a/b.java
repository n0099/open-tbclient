package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class b {
    public boolean dTQ;
    private final g dVr = new g();
    public boolean mIsNeedTbs = false;
    public boolean mNeedBackgroundLogin = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean Lb = false;
    public boolean mIsFromCDN = false;
    public boolean mIsRequestImage = false;
    public int mImageType = 0;

    public g aWZ() {
        return this.dVr;
    }

    public void a(r rVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            rVar.addPostData("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.d.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                rVar.addPostData("stoken", c);
            }
        }
    }

    public void b(r rVar) {
        String str;
        boolean z;
        rVar.addPostData("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            rVar.addPostData("apid", "sw");
        }
        rVar.addPostData("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            rVar.addPostData("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            rVar.addPostData("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            rVar.addPostData("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            rVar.addPostData("from", from);
        }
        int netType = j.netType();
        rVar.addPostData("net_type", String.valueOf(netType));
        String aZK = com.baidu.tbadk.coreExtra.b.a.aZH().aZK();
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            aZK = aZK + "pub_env=" + TbSingleton.getInstance().getPubEnvValue() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
        }
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = aZK + "ka=open";
                z = true;
            }
            str = aZK;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = aZK + "ka=open";
                z = true;
            }
            str = aZK;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.setKeepAlive(z);
        com.baidu.adp.lib.network.a.a.bK(str);
        if (this.mIsNeedTbs) {
            rVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        rVar.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
        rVar.addPostData("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        rVar.addPostData("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        rVar.addPostData("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        rVar.addPostData("timestamp", Long.toString(System.currentTimeMillis()));
        rVar.addPostData("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, 0) == 1) {
            rVar.addPostData("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String getApiName() {
        if (this.dVr.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.dVr.mUrl.startsWith(str)) {
            int indexOf = this.dVr.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.dVr.mUrl.length();
            }
            return this.dVr.mUrl.substring(str.length(), indexOf);
        }
        return this.dVr.mUrl;
    }
}
