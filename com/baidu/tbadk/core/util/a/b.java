package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes.dex */
public class b {
    public boolean bSg;
    private final g bUF = new g();
    public boolean mIsNeedTbs = false;
    public boolean bUG = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean bUH = false;
    public int mImageType = 0;

    public g ajH() {
        return this.bUF;
    }

    public void a(q qVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            qVar.o("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.d.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                qVar.o("stoken", c);
            }
        }
    }

    public void b(q qVar) {
        String str;
        boolean z;
        qVar.o("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            qVar.o("apid", "sw");
        }
        qVar.o("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            qVar.o("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            qVar.o("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            qVar.o("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            qVar.o("from", from);
        }
        int netType = j.netType();
        qVar.o("net_type", String.valueOf(netType));
        String alN = com.baidu.tbadk.coreExtra.b.a.alK().alN();
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = alN + "ka=open";
                z = true;
            }
            str = alN;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = alN + "ka=open";
                z = true;
            }
            str = alN;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.aa(z);
        com.baidu.adp.lib.network.a.a.aC(str);
        if (this.mIsNeedTbs) {
            qVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        qVar.o("cuid", TbadkCoreApplication.getInst().getCuid());
        qVar.o("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        qVar.o("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        qVar.o("timestamp", Long.toString(System.currentTimeMillis()));
        qVar.o("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getInt("android_safe_sdk_open", 0) == 1) {
            qVar.o("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String ajI() {
        if (this.bUF.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.bUF.mUrl.startsWith(str)) {
            int indexOf = this.bUF.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.bUF.mUrl.length();
            }
            return this.bUF.mUrl.substring(str.length(), indexOf);
        }
        return this.bUF.mUrl;
    }
}
