package com.baidu.tbadk.core.util.httpNet;

import android.os.Build;
import com.baidu.adp.lib.stats.p;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class f {
    private final i FT = new i();
    public boolean mIsNeedTbs = false;
    public boolean FU = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public String FV = p.eK();
    public boolean FW = false;
    public int FX = 0;

    public i nd() {
        return this.FT;
    }

    public void a(u uVar) {
        String currentBduss = TbadkApplication.getCurrentBduss();
        if (currentBduss != null && this.mIsUseCurrentBDUSS) {
            uVar.k("BDUSS", currentBduss);
        }
    }

    public void b(u uVar) {
        uVar.k("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        if (!TbadkApplication.m251getInst().isOfficial()) {
            uVar.k("apid", TbConfig.SW_APID);
        }
        uVar.k("_client_version", TbConfig.getVersion());
        if (TbadkApplication.m251getInst().getImei() != null) {
            uVar.k("_phone_imei", TbadkApplication.m251getInst().getImei());
        }
        String clientId = TbadkApplication.getClientId();
        if (clientId != null) {
            uVar.k("_client_id", clientId);
        }
        String from = TbadkApplication.getFrom();
        if (from != null && from.length() > 0) {
            uVar.k("from", from);
        }
        String netType = j.getNetType();
        if (netType != null) {
            String ot = com.baidu.tbadk.coreExtra.a.a.or().ot();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkApplication.m251getInst().getKeepaliveWifi() == 1) {
                    ot = String.valueOf(ot) + "ka=open";
                }
            } else if (TbadkApplication.m251getInst().getKeepaliveNonWifi() == 1) {
                ot = String.valueOf(ot) + "ka=open";
            }
            com.baidu.adp.lib.network.willdelete.e.dY().X(ot);
        }
        if (this.mIsNeedTbs) {
            uVar.k("tbs", TbadkApplication.m251getInst().getTbs());
        }
        uVar.k("cuid", TbadkApplication.m251getInst().getCuid());
        uVar.k("timestamp", Long.toString(System.currentTimeMillis()));
        uVar.k("model", Build.MODEL);
    }

    public String ne() {
        if (this.FT.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.FT.mUrl.startsWith(str)) {
            int indexOf = this.FT.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.FT.mUrl.length();
            }
            return this.FT.mUrl.substring(str.length(), indexOf);
        }
        return this.FT.mUrl;
    }
}
