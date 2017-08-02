package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.p;
/* loaded from: classes.dex */
public class b {
    private final g ahu = new g();
    public boolean mIsNeedTbs = false;
    public boolean ahv = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean ahw = false;
    public int ahx = 0;

    public g wa() {
        return this.ahu;
    }

    public void a(p pVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            pVar.n("BDUSS", bduss);
            String d = com.baidu.tbadk.core.a.e.d(currentAccountInfo);
            if (!StringUtils.isNull(d)) {
                pVar.n("stoken", d);
            }
        }
    }

    public void b(p pVar) {
        String str;
        boolean z = true;
        pVar.n("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            pVar.n("apid", TbConfig.SW_APID);
        }
        pVar.n("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            pVar.n("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            pVar.n("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            pVar.n("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            pVar.n("from", from);
        }
        String netType = h.getNetType();
        if (netType != null) {
            String xL = com.baidu.tbadk.coreExtra.b.a.xI().xL();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                    str = xL + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.setCookie(str);
                }
                z = false;
                str = xL;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.setCookie(str);
            } else {
                if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                    str = xL + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.setCookie(str);
                }
                z = false;
                str = xL;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.setCookie(str);
            }
        }
        if (this.mIsNeedTbs) {
            pVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        pVar.n("cuid", TbadkCoreApplication.getInst().getCuid());
        pVar.n("timestamp", Long.toString(System.currentTimeMillis()));
        pVar.n("model", Build.MODEL);
    }

    public String wb() {
        if (this.ahu.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.ahu.mUrl.startsWith(str)) {
            int indexOf = this.ahu.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.ahu.mUrl.length();
            }
            return this.ahu.mUrl.substring(str.length(), indexOf);
        }
        return this.ahu.mUrl;
    }
}
