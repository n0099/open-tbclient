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
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class b {
    public boolean aAT;
    private final g aDq = new g();
    public boolean mIsNeedTbs = false;
    public boolean aDr = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean aDs = false;
    public int aDt = 0;

    public g Ek() {
        return this.aDq;
    }

    public void a(q qVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            qVar.x("BDUSS", bduss);
            String c = com.baidu.tbadk.core.a.d.c(currentAccountInfo);
            if (!StringUtils.isNull(c)) {
                qVar.x(ISapiAccount.SAPI_ACCOUNT_STOKEN, c);
            }
        }
    }

    public void b(q qVar) {
        String str;
        boolean z;
        qVar.x("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            qVar.x("apid", TbConfig.SW_APID);
        }
        qVar.x("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            qVar.x("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            qVar.x("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            qVar.x("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            qVar.x("from", from);
        }
        int netType = j.netType();
        qVar.x(ETAG.KEY_NET_TYPE, String.valueOf(netType));
        String Gf = com.baidu.tbadk.coreExtra.b.a.Gc().Gf();
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = Gf + "ka=open";
                z = true;
            }
            str = Gf;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = Gf + "ka=open";
                z = true;
            }
            str = Gf;
            z = false;
        }
        com.baidu.adp.lib.network.a.a.setKeepAlive(z);
        com.baidu.adp.lib.network.a.a.aR(str);
        if (this.mIsNeedTbs) {
            qVar.x("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        qVar.x("cuid", TbadkCoreApplication.getInst().getCuid());
        qVar.x("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        qVar.x("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        qVar.x(HttpConstants.TIMESTAMP, Long.toString(System.currentTimeMillis()));
        qVar.x("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("android_safe_sdk_open", 0) == 1) {
            qVar.x("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String El() {
        if (this.aDq.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.aDq.mUrl.startsWith(str)) {
            int indexOf = this.aDq.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.aDq.mUrl.length();
            }
            return this.aDq.mUrl.substring(str.length(), indexOf);
        }
        return this.aDq.mUrl;
    }
}
