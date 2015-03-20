package com.baidu.tbadk.core.util.httpNet;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.p;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class b {
    private final f VT = new f();
    public boolean mIsNeedTbs = false;
    public boolean VU = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public String VV = p.ik();
    public boolean VW = false;
    public int VX = 0;

    public f ts() {
        return this.VT;
    }

    public void a(s sVar) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null && this.mIsUseCurrentBDUSS) {
            sVar.o("BDUSS", currentBduss);
        }
    }

    public void b(s sVar) {
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
            String uw = com.baidu.tbadk.coreExtra.a.a.uu().uw();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m411getInst().getKeepaliveWifi() == 1) {
                    uw = String.valueOf(uw) + "ka=open";
                }
            } else if (TbadkCoreApplication.m411getInst().getKeepaliveNonWifi() == 1) {
                uw = String.valueOf(uw) + "ka=open";
            }
            com.baidu.adp.lib.network.willdelete.e.hu().aj(uw);
        }
        if (this.mIsNeedTbs) {
            sVar.o("tbs", TbadkCoreApplication.m411getInst().getTbs());
        }
        sVar.o("cuid", TbadkCoreApplication.m411getInst().getCuid());
        sVar.o("timestamp", Long.toString(System.currentTimeMillis()));
        sVar.o("model", Build.MODEL);
    }

    public String tt() {
        if (this.VT.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.VT.mUrl.startsWith(str)) {
            int indexOf = this.VT.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.VT.mUrl.length();
            }
            return this.VT.mUrl.substring(str.length(), indexOf);
        }
        return this.VT.mUrl;
    }
}
