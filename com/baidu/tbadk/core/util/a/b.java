package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes.dex */
public class b {
    private final g aXX = new g();
    public boolean mIsNeedTbs = false;
    public boolean aXY = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean aXZ = false;
    public int aYa = 0;

    public g Dy() {
        return this.aXX;
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
        int oP = j.oP();
        qVar.n("net_type", String.valueOf(oP));
        String Fg = com.baidu.tbadk.coreExtra.b.a.Fd().Fg();
        if (1 == oP) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = Fg + "ka=open";
                z = true;
            }
            str = Fg;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = Fg + "ka=open";
                z = true;
            }
            str = Fg;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.setKeepAlive(z);
        com.baidu.adp.lib.network.a.a.aq(str);
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

    public String Dz() {
        if (this.aXX.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.aXX.mUrl.startsWith(str)) {
            int indexOf = this.aXX.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.aXX.mUrl.length();
            }
            return this.aXX.mUrl.substring(str.length(), indexOf);
        }
        return this.aXX.mUrl;
    }
}
