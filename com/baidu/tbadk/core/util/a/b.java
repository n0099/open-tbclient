package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class b {
    private final i agz = new i();
    public boolean mIsNeedTbs = false;
    public boolean agA = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean agB = false;
    public int agC = 0;

    public i vG() {
        return this.agz;
    }

    public void a(s sVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            sVar.n("BDUSS", bduss);
            String d = com.baidu.tbadk.core.a.h.d(currentAccountInfo);
            if (!StringUtils.isNull(d)) {
                sVar.n("stoken", d);
            }
        }
    }

    public void b(s sVar) {
        String str;
        boolean z = true;
        sVar.n("_client_type", "2");
        if (!TbadkCoreApplication.m9getInst().isOfficial()) {
            sVar.n("apid", TbConfig.SW_APID);
        }
        sVar.n("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m9getInst().getImei() != null) {
            sVar.n("_phone_imei", TbadkCoreApplication.m9getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            sVar.n("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            sVar.n("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            sVar.n("from", from);
        }
        String netType = j.getNetType();
        if (netType != null) {
            String xp = com.baidu.tbadk.coreExtra.b.a.xm().xp();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m9getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(xp) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.setCookie(str);
                }
                z = false;
                str = xp;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.setCookie(str);
            } else {
                if (TbadkCoreApplication.m9getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(xp) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.setCookie(str);
                }
                z = false;
                str = xp;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.setCookie(str);
            }
        }
        if (this.mIsNeedTbs) {
            sVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        }
        sVar.n("cuid", TbadkCoreApplication.m9getInst().getCuid());
        sVar.n("timestamp", Long.toString(System.currentTimeMillis()));
        sVar.n("model", Build.MODEL);
    }

    public String vH() {
        if (this.agz.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.agz.mUrl.startsWith(str)) {
            int indexOf = this.agz.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.agz.mUrl.length();
            }
            return this.agz.mUrl.substring(str.length(), indexOf);
        }
        return this.agz.mUrl;
    }
}
