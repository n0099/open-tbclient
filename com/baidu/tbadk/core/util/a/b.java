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
    public boolean awG;
    private final g aza = new g();
    public boolean mIsNeedTbs = false;
    public boolean azb = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean azc = false;
    public int azd = 0;

    public g CZ() {
        return this.aza;
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
        int ld = j.ld();
        qVar.x(ETAG.KEY_NET_TYPE, String.valueOf(ld));
        String EP = com.baidu.tbadk.coreExtra.b.a.EM().EP();
        if (1 == ld) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                str = EP + "ka=open";
                z = true;
            }
            str = EP;
            z = false;
        } else {
            if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                str = EP + "ka=open";
                z = true;
            }
            str = EP;
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

    public String Da() {
        if (this.aza.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.aza.mUrl.startsWith(str)) {
            int indexOf = this.aza.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.aza.mUrl.length();
            }
            return this.aza.mUrl.substring(str.length(), indexOf);
        }
        return this.aza.mUrl;
    }
}
