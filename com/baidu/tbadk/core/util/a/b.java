package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes.dex */
public class b {
    public boolean cjj;
    private final g ckE = new g();
    public boolean mIsNeedTbs = false;
    public boolean mNeedBackgroundLogin = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean mIsRequestImage = false;
    public int mImageType = 0;

    public g amU() {
        return this.ckE;
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
        String aoO = com.baidu.tbadk.coreExtra.b.a.aoL().aoO();
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = aoO + "ka=open";
                z = true;
            }
            str = aoO;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = aoO + "ka=open";
                z = true;
            }
            str = aoO;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.E(z);
        com.baidu.adp.lib.network.a.a.ai(str);
        if (this.mIsNeedTbs) {
            qVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        qVar.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
        qVar.addPostData("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        qVar.addPostData("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        qVar.addPostData("timestamp", Long.toString(System.currentTimeMillis()));
        qVar.addPostData("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, 0) == 1) {
            qVar.addPostData("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String getApiName() {
        if (this.ckE.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.ckE.mUrl.startsWith(str)) {
            int indexOf = this.ckE.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.ckE.mUrl.length();
            }
            return this.ckE.mUrl.substring(str.length(), indexOf);
        }
        return this.ckE.mUrl;
    }
}
