package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class b {
    public boolean eLF;
    private final g eNt = new g();
    public boolean mIsNeedTbs = false;
    public boolean mNeedBackgroundLogin = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean Mk = false;
    public boolean mIsFromCDN = false;
    public boolean mIsRequestImage = false;
    public int mImageType = 0;

    public g bqL() {
        return this.eNt;
    }

    public void a(s sVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            sVar.addPostData("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.d.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                sVar.addPostData("stoken", c);
            }
        }
    }

    public void b(s sVar) {
        String str;
        boolean z;
        sVar.addPostData("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            sVar.addPostData("apid", "sw");
        }
        sVar.addPostData("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            sVar.addPostData("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            sVar.addPostData("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            sVar.addPostData("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            sVar.addPostData("from", from);
        }
        int netType = j.netType();
        sVar.addPostData("net_type", String.valueOf(netType));
        String btA = com.baidu.tbadk.coreExtra.b.a.btx().btA();
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            btA = btA + "pub_env=" + TbSingleton.getInstance().getPubEnvValue() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
        }
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = btA + "ka=open";
                z = true;
            }
            str = btA;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = btA + "ka=open";
                z = true;
            }
            str = btA;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.setKeepAlive(z);
        com.baidu.adp.lib.network.a.a.bP(str);
        if (this.mIsNeedTbs) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                sVar.addPostData("tbs", com.baidu.tbadk.mutiprocess.f.getTbs());
            } else {
                sVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            }
        }
        sVar.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
        sVar.addPostData("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        sVar.addPostData("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        sVar.addPostData("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        sVar.addPostData("timestamp", Long.toString(System.currentTimeMillis()));
        sVar.addPostData("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, 0) == 1) {
            sVar.addPostData("z_id", TbadkCoreApplication.getInst().getZid());
        }
    }

    public String getApiName() {
        if (this.eNt.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.eNt.mUrl.startsWith(str)) {
            int indexOf = this.eNt.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.eNt.mUrl.length();
            }
            return this.eNt.mUrl.substring(str.length(), indexOf);
        }
        return this.eNt.mUrl;
    }
}
