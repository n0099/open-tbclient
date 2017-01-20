package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class b {
    private final i abC = new i();
    public boolean mIsNeedTbs = false;
    public boolean abD = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean abE = false;
    public int abF = 0;

    public i vy() {
        return this.abC;
    }

    public void a(r rVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            rVar.n("BDUSS", bduss);
            String d = com.baidu.tbadk.core.a.h.d(currentAccountInfo);
            if (!StringUtils.isNull(d)) {
                rVar.n("stoken", d);
            }
        }
    }

    public void b(r rVar) {
        String str;
        boolean z = true;
        rVar.n("_client_type", "2");
        if (!TbadkCoreApplication.m9getInst().isOfficial()) {
            rVar.n("apid", TbConfig.SW_APID);
        }
        rVar.n("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m9getInst().getImei() != null) {
            rVar.n("_phone_imei", TbadkCoreApplication.m9getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            rVar.n("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            rVar.n("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            rVar.n("from", from);
        }
        String netType = j.getNetType();
        if (netType != null) {
            String xj = com.baidu.tbadk.coreExtra.b.a.xg().xj();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m9getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(xj) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.af(str);
                }
                z = false;
                str = xj;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.af(str);
            } else {
                if (TbadkCoreApplication.m9getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(xj) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.af(str);
                }
                z = false;
                str = xj;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.af(str);
            }
        }
        if (this.mIsNeedTbs) {
            rVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        }
        rVar.n(SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid());
        rVar.n("timestamp", Long.toString(System.currentTimeMillis()));
        rVar.n("model", Build.MODEL);
    }

    public String vz() {
        if (this.abC.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.abC.mUrl.startsWith(str)) {
            int indexOf = this.abC.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.abC.mUrl.length();
            }
            return this.abC.mUrl.substring(str.length(), indexOf);
        }
        return this.abC.mUrl;
    }
}
