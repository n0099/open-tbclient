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
import com.baidu.tbadk.core.util.q;
/* loaded from: classes.dex */
public class b {
    public boolean dNa;
    private final g dOz = new g();
    public boolean mIsNeedTbs = false;
    public boolean mNeedBackgroundLogin = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean KA = false;
    public boolean mIsFromCDN = false;
    public boolean mIsRequestImage = false;
    public int mImageType = 0;

    public g aVe() {
        return this.dOz;
    }

    public void a(q qVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            qVar.addPostData("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.d.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                qVar.addPostData("stoken", c);
            }
        }
    }

    public void b(q qVar) {
        String str;
        boolean z;
        qVar.addPostData("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            qVar.addPostData("apid", "sw");
        }
        qVar.addPostData("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            qVar.addPostData("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            qVar.addPostData("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            qVar.addPostData("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            qVar.addPostData("from", from);
        }
        int netType = j.netType();
        qVar.addPostData("net_type", String.valueOf(netType));
        String aXD = com.baidu.tbadk.coreExtra.b.a.aXA().aXD();
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            aXD = aXD + "pub_env=" + TbSingleton.getInstance().getPubEnvValue() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
        }
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = aXD + "ka=open";
                z = true;
            }
            str = aXD;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = aXD + "ka=open";
                z = true;
            }
            str = aXD;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.setKeepAlive(z);
        com.baidu.adp.lib.network.a.a.bJ(str);
        if (this.mIsNeedTbs) {
            qVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        qVar.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
        qVar.addPostData("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        qVar.addPostData("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        qVar.addPostData("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        qVar.addPostData("timestamp", Long.toString(System.currentTimeMillis()));
        qVar.addPostData("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, 0) == 1) {
            qVar.addPostData("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String getApiName() {
        if (this.dOz.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.dOz.mUrl.startsWith(str)) {
            int indexOf = this.dOz.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.dOz.mUrl.length();
            }
            return this.dOz.mUrl.substring(str.length(), indexOf);
        }
        return this.dOz.mUrl;
    }
}
