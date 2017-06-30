package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class b {
    private final i agY = new i();
    public boolean mIsNeedTbs = false;
    public boolean agZ = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean aha = false;
    public int ahb = 0;

    public i vU() {
        return this.agY;
    }

    public void a(u uVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            uVar.n("BDUSS", bduss);
            String d = com.baidu.tbadk.core.a.h.d(currentAccountInfo);
            if (!StringUtils.isNull(d)) {
                uVar.n("stoken", d);
            }
        }
    }

    public void b(u uVar) {
        String str;
        boolean z = true;
        uVar.n("_client_type", "2");
        if (!TbadkCoreApplication.m9getInst().isOfficial()) {
            uVar.n("apid", TbConfig.SW_APID);
        }
        uVar.n("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m9getInst().getImei() != null) {
            uVar.n("_phone_imei", TbadkCoreApplication.m9getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            uVar.n("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            uVar.n("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            uVar.n("from", from);
        }
        String netType = j.getNetType();
        if (netType != null) {
            String xA = com.baidu.tbadk.coreExtra.b.a.xx().xA();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m9getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(xA) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.setCookie(str);
                }
                z = false;
                str = xA;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.setCookie(str);
            } else {
                if (TbadkCoreApplication.m9getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(xA) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.setCookie(str);
                }
                z = false;
                str = xA;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.setCookie(str);
            }
        }
        if (this.mIsNeedTbs) {
            uVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        }
        uVar.n("cuid", TbadkCoreApplication.m9getInst().getCuid());
        uVar.n("timestamp", Long.toString(System.currentTimeMillis()));
        uVar.n("model", Build.MODEL);
    }

    public String vV() {
        if (this.agY.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.agY.mUrl.startsWith(str)) {
            int indexOf = this.agY.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.agY.mUrl.length();
            }
            return this.agY.mUrl.substring(str.length(), indexOf);
        }
        return this.agY.mUrl;
    }
}
