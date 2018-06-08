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
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class b {
    private final g arK = new g();
    public boolean mIsNeedTbs = false;
    public boolean arL = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean arM = false;
    public int arN = 0;

    public g zL() {
        return this.arK;
    }

    public void a(r rVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            rVar.o("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.e.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                rVar.o(ISapiAccount.SAPI_ACCOUNT_STOKEN, c);
            }
        }
    }

    public void b(r rVar) {
        String str;
        boolean z;
        rVar.o("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            rVar.o("apid", TbConfig.SW_APID);
        }
        rVar.o("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            rVar.o("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            rVar.o("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            rVar.o("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            rVar.o("from", from);
        }
        int jJ = j.jJ();
        rVar.o("net_type", String.valueOf(jJ));
        String Bt = com.baidu.tbadk.coreExtra.b.a.Bq().Bt();
        if (1 == jJ) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = Bt + "ka=open";
                z = true;
            }
            str = Bt;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = Bt + "ka=open";
                z = true;
            }
            str = Bt;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.setKeepAlive(z);
        com.baidu.adp.lib.network.a.a.az(str);
        if (this.mIsNeedTbs) {
            rVar.o("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        rVar.o("cuid", TbadkCoreApplication.getInst().getCuid());
        rVar.o(HttpConstants.TIMESTAMP, Long.toString(System.currentTimeMillis()));
        rVar.o("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("android_safe_sdk_open", 0) == 1) {
            rVar.o("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String zM() {
        if (this.arK.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.arK.mUrl.startsWith(str)) {
            int indexOf = this.arK.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.arK.mUrl.length();
            }
            return this.arK.mUrl.substring(str.length(), indexOf);
        }
        return this.arK.mUrl;
    }
}
