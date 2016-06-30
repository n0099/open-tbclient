package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class b {
    private final i YQ = new i();
    public boolean mIsNeedTbs = false;
    public boolean YR = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean YS = false;
    public int YT = 0;

    public i ux() {
        return this.YQ;
    }

    public void a(t tVar) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null && this.mIsUseCurrentBDUSS) {
            tVar.n("BDUSS", currentBduss);
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
            String wr = com.baidu.tbadk.coreExtra.b.a.wo().wr();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m9getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(wr) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.ac(str);
                }
                z = false;
                str = wr;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.ac(str);
            } else {
                if (TbadkCoreApplication.m9getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(wr) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.ac(str);
                }
                z = false;
                str = wr;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.ac(str);
            }
        }
        if (this.mIsNeedTbs) {
            tVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        }
        tVar.n(SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid());
        tVar.n("timestamp", Long.toString(System.currentTimeMillis()));
        tVar.n("model", Build.MODEL);
    }

    public String uy() {
        if (this.YQ.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.YQ.mUrl.startsWith(str)) {
            int indexOf = this.YQ.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.YQ.mUrl.length();
            }
            return this.YQ.mUrl.substring(str.length(), indexOf);
        }
        return this.YQ.mUrl;
    }
}
