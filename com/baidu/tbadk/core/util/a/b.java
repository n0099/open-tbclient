package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class b {
    private final i ada = new i();
    public boolean mIsNeedTbs = false;
    public boolean adb = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean adc = false;
    public int ade = 0;

    public i wR() {
        return this.ada;
    }

    public void a(t tVar) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null && this.mIsUseCurrentBDUSS) {
            tVar.p("BDUSS", currentBduss);
        }
    }

    public void b(t tVar) {
        String str;
        boolean z = true;
        tVar.p("_client_type", "2");
        if (!TbadkCoreApplication.m411getInst().isOfficial()) {
            tVar.p("apid", TbConfig.SW_APID);
        }
        tVar.p("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m411getInst().getImei() != null) {
            tVar.p("_phone_imei", TbadkCoreApplication.m411getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            tVar.p("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            tVar.p("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            tVar.p("from", from);
        }
        String netType = j.getNetType();
        if (netType != null) {
            String yu = com.baidu.tbadk.coreExtra.b.a.yr().yu();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m411getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(yu) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.al(str);
                }
                z = false;
                str = yu;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.al(str);
            } else {
                if (TbadkCoreApplication.m411getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(yu) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.al(str);
                }
                z = false;
                str = yu;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.al(str);
            }
        }
        if (this.mIsNeedTbs) {
            tVar.p("tbs", TbadkCoreApplication.m411getInst().getTbs());
        }
        tVar.p(SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid());
        tVar.p("timestamp", Long.toString(System.currentTimeMillis()));
        tVar.p("model", Build.MODEL);
    }

    public String wS() {
        if (this.ada.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.ada.mUrl.startsWith(str)) {
            int indexOf = this.ada.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.ada.mUrl.length();
            }
            return this.ada.mUrl.substring(str.length(), indexOf);
        }
        return this.ada.mUrl;
    }
}
