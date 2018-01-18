package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes.dex */
public class b {
    private final g aWx = new g();
    public boolean mIsNeedTbs = false;
    public boolean aWy = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean aWz = false;
    public int aWA = 0;

    public g De() {
        return this.aWx;
    }

    public void a(q qVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            qVar.n("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.e.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                qVar.n(ISapiAccount.SAPI_ACCOUNT_STOKEN, c);
            }
        }
    }

    public void b(q qVar) {
        String str;
        boolean z;
        qVar.n("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            qVar.n("apid", TbConfig.SW_APID);
        }
        qVar.n("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            qVar.n("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            qVar.n("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            qVar.n("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            qVar.n("from", from);
        }
        String netType = h.getNetType();
        if (netType != null) {
            String EK = com.baidu.tbadk.coreExtra.b.a.EH().EK();
            if ("3".equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                    str = EK + "ka=open";
                    z = true;
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.aq(str);
                }
                str = EK;
                z = false;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.aq(str);
            } else {
                if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                    str = EK + "ka=open";
                    z = true;
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.aq(str);
                }
                str = EK;
                z = false;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.aq(str);
            }
        }
        if (this.mIsNeedTbs) {
            qVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        qVar.n("cuid", TbadkCoreApplication.getInst().getCuid());
        qVar.n("timestamp", Long.toString(System.currentTimeMillis()));
        qVar.n("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("android_safe_sdk_open", 0) == 1) {
            qVar.n("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String Df() {
        if (this.aWx.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.aWx.mUrl.startsWith(str)) {
            int indexOf = this.aWx.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.aWx.mUrl.length();
            }
            return this.aWx.mUrl.substring(str.length(), indexOf);
        }
        return this.aWx.mUrl;
    }
}
