package com.baidu.tbadk.core.util.httpNet;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.p;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class b {
    private final f WC = new f();
    public boolean mIsNeedTbs = false;
    public boolean WD = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public String WE = p.hT();
    public boolean WF = false;
    public int WG = 0;

    public f tV() {
        return this.WC;
    }

    public void a(s sVar) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null && this.mIsUseCurrentBDUSS) {
            sVar.o("BDUSS", currentBduss);
        }
    }

    public void b(s sVar) {
        String str;
        boolean z = true;
        sVar.o("_client_type", "2");
        if (!TbadkCoreApplication.m411getInst().isOfficial()) {
            sVar.o("apid", TbConfig.SW_APID);
        }
        sVar.o("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m411getInst().getImei() != null) {
            sVar.o("_phone_imei", TbadkCoreApplication.m411getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            sVar.o("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            sVar.o("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            sVar.o("from", from);
        }
        String netType = g.getNetType();
        if (netType != null) {
            String vf = com.baidu.tbadk.coreExtra.a.a.vd().vf();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m411getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(vf) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.ak(str);
                }
                z = false;
                str = vf;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.ak(str);
            } else {
                if (TbadkCoreApplication.m411getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(vf) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.ak(str);
                }
                z = false;
                str = vf;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.ak(str);
            }
        }
        if (this.mIsNeedTbs) {
            sVar.o("tbs", TbadkCoreApplication.m411getInst().getTbs());
        }
        sVar.o("cuid", TbadkCoreApplication.m411getInst().getCuid());
        sVar.o("timestamp", Long.toString(System.currentTimeMillis()));
        sVar.o("model", Build.MODEL);
    }

    public String tW() {
        if (this.WC.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.WC.mUrl.startsWith(str)) {
            int indexOf = this.WC.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.WC.mUrl.length();
            }
            return this.WC.mUrl.substring(str.length(), indexOf);
        }
        return this.WC.mUrl;
    }
}
