package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class b {
    private final i aco = new i();
    public boolean mIsNeedTbs = false;
    public boolean acp = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean acq = false;
    public int acr = 0;

    public i vC() {
        return this.aco;
    }

    public void a(t tVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            tVar.n("BDUSS", bduss);
            String d = com.baidu.tbadk.core.a.h.d(currentAccountInfo);
            if (!StringUtils.isNull(d)) {
                tVar.n("stoken", d);
            }
        }
    }

    public void b(t tVar) {
        String str;
        boolean z = true;
        tVar.n("_client_type", "2");
        if (!TbadkCoreApplication.m9getInst().isOfficial()) {
            tVar.n("apid", TbConfig.SW_APID);
        }
        tVar.n("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m9getInst().getImei() != null) {
            tVar.n("_phone_imei", TbadkCoreApplication.m9getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            tVar.n("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            tVar.n("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            tVar.n("from", from);
        }
        String netType = j.getNetType();
        if (netType != null) {
            String xv = com.baidu.tbadk.coreExtra.b.a.xs().xv();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m9getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(xv) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.af(str);
                }
                z = false;
                str = xv;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.af(str);
            } else {
                if (TbadkCoreApplication.m9getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(xv) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.af(str);
                }
                z = false;
                str = xv;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.af(str);
            }
        }
        if (this.mIsNeedTbs) {
            tVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        }
        tVar.n(SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid());
        tVar.n("timestamp", Long.toString(System.currentTimeMillis()));
        tVar.n("model", Build.MODEL);
    }

    public String vD() {
        if (this.aco.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.aco.mUrl.startsWith(str)) {
            int indexOf = this.aco.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.aco.mUrl.length();
            }
            return this.aco.mUrl.substring(str.length(), indexOf);
        }
        return this.aco.mUrl;
    }
}
