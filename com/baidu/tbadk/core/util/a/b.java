package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes.dex */
public class b {
    public boolean arT;
    private final g aup = new g();
    public boolean mIsNeedTbs = false;
    public boolean auq = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean aur = false;
    public int aus = 0;

    public g AS() {
        return this.aup;
    }

    public void a(q qVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            qVar.u("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.d.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                qVar.u(ISapiAccount.SAPI_ACCOUNT_STOKEN, c);
            }
        }
    }

    public void b(q qVar) {
        String str;
        boolean z;
        qVar.u("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            qVar.u("apid", TbConfig.SW_APID);
        }
        qVar.u("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            qVar.u("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            qVar.u("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            qVar.u("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            qVar.u("from", from);
        }
        int kQ = j.kQ();
        qVar.u("net_type", String.valueOf(kQ));
        String CL = com.baidu.tbadk.coreExtra.b.a.CI().CL();
        if (1 == kQ) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = CL + "ka=open";
                z = true;
            }
            str = CL;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = CL + "ka=open";
                z = true;
            }
            str = CL;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.setKeepAlive(z);
        com.baidu.adp.lib.network.a.a.aR(str);
        if (this.mIsNeedTbs) {
            qVar.u("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        qVar.u("cuid", TbadkCoreApplication.getInst().getCuid());
        qVar.u("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        qVar.u("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        qVar.u(HttpConstants.TIMESTAMP, Long.toString(System.currentTimeMillis()));
        qVar.u("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("android_safe_sdk_open", 0) == 1) {
            qVar.u("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String AT() {
        if (this.aup.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.aup.mUrl.startsWith(str)) {
            int indexOf = this.aup.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.aup.mUrl.length();
            }
            return this.aup.mUrl.substring(str.length(), indexOf);
        }
        return this.aup.mUrl;
    }
}
