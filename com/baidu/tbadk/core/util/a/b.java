package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class b {
    private final h adp = new h();
    public boolean mIsNeedTbs = false;
    public boolean adq = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean adr = false;
    public int ads = 0;

    public h vs() {
        return this.adp;
    }

    public void a(u uVar) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null && this.mIsUseCurrentBDUSS) {
            uVar.o("BDUSS", currentBduss);
        }
    }

    public void b(u uVar) {
        String str;
        boolean z = true;
        uVar.o("_client_type", "2");
        if (!TbadkCoreApplication.m411getInst().isOfficial()) {
            uVar.o("apid", TbConfig.SW_APID);
        }
        uVar.o("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m411getInst().getImei() != null) {
            uVar.o("_phone_imei", TbadkCoreApplication.m411getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            uVar.o("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            uVar.o("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            uVar.o("from", from);
        }
        String netType = i.getNetType();
        if (netType != null) {
            String wF = com.baidu.tbadk.coreExtra.b.a.wC().wF();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m411getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(wF) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.al(str);
                }
                z = false;
                str = wF;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.al(str);
            } else {
                if (TbadkCoreApplication.m411getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(wF) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.al(str);
                }
                z = false;
                str = wF;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.al(str);
            }
        }
        if (this.mIsNeedTbs) {
            uVar.o("tbs", TbadkCoreApplication.m411getInst().getTbs());
        }
        uVar.o(SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid());
        uVar.o("timestamp", Long.toString(System.currentTimeMillis()));
        uVar.o("model", Build.MODEL);
    }

    public String vt() {
        if (this.adp.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.adp.mUrl.startsWith(str)) {
            int indexOf = this.adp.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.adp.mUrl.length();
            }
            return this.adp.mUrl.substring(str.length(), indexOf);
        }
        return this.adp.mUrl;
    }
}
