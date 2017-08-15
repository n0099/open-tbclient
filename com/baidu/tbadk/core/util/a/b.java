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
    private final g aiP = new g();
    public boolean mIsNeedTbs = false;
    public boolean aiQ = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean aiR = false;
    public int aiS = 0;

    public g wk() {
        return this.aiP;
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
            String xT = com.baidu.tbadk.coreExtra.b.a.xQ().xT();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                    str = xT + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.setCookie(str);
                }
                z = false;
                str = xT;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.setCookie(str);
            } else {
                if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                    str = xT + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.setCookie(str);
                }
                z = false;
                str = xT;
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

    public String wl() {
        if (this.aiP.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.aiP.mUrl.startsWith(str)) {
            int indexOf = this.aiP.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.aiP.mUrl.length();
            }
            return this.aiP.mUrl.substring(str.length(), indexOf);
        }
        return this.aiP.mUrl;
    }
}
