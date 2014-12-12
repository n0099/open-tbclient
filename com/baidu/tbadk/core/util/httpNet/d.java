package com.baidu.tbadk.core.util.httpNet;

import android.os.Build;
import com.baidu.adp.lib.stats.p;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class d {
    private final g Kd = new g();
    public boolean mIsNeedTbs = false;
    public boolean Ke = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public String Kf = p.eL();
    public boolean Kg = false;
    public int Kh = 0;

    public g pY() {
        return this.Kd;
    }

    public void a(v vVar) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null && this.mIsUseCurrentBDUSS) {
            vVar.o("BDUSS", currentBduss);
        }
    }

    public void b(v vVar) {
        vVar.o("_client_type", "2");
        if (!TbadkCoreApplication.m255getInst().isOfficial()) {
            vVar.o("apid", TbConfig.SW_APID);
        }
        vVar.o("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m255getInst().getImei() != null) {
            vVar.o("_phone_imei", TbadkCoreApplication.m255getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            vVar.o("_client_id", clientId);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            vVar.o("from", from);
        }
        String netType = h.getNetType();
        if (netType != null) {
            String rt = com.baidu.tbadk.coreExtra.a.a.rr().rt();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m255getInst().getKeepaliveWifi() == 1) {
                    rt = String.valueOf(rt) + "ka=open";
                }
            } else if (TbadkCoreApplication.m255getInst().getKeepaliveNonWifi() == 1) {
                rt = String.valueOf(rt) + "ka=open";
            }
            com.baidu.adp.lib.network.willdelete.e.dX().ac(rt);
        }
        if (this.mIsNeedTbs) {
            vVar.o("tbs", TbadkCoreApplication.m255getInst().getTbs());
        }
        vVar.o("cuid", TbadkCoreApplication.m255getInst().getCuid());
        vVar.o("timestamp", Long.toString(System.currentTimeMillis()));
        vVar.o("model", Build.MODEL);
    }

    public String pZ() {
        if (this.Kd.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.Kd.mUrl.startsWith(str)) {
            int indexOf = this.Kd.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.Kd.mUrl.length();
            }
            return this.Kd.mUrl.substring(str.length(), indexOf);
        }
        return this.Kd.mUrl;
    }
}
