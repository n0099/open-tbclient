package com.baidu.tbadk.core.util.httpNet;

import android.os.Build;
import com.baidu.adp.lib.stats.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ac;
/* loaded from: classes.dex */
public class d {
    private final g i = new g();
    public boolean a = false;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public String f = n.a();
    public boolean g = false;
    public int h = 0;

    public g a() {
        return this.i;
    }

    public void a(ac acVar) {
        String currentBduss = TbadkApplication.getCurrentBduss();
        if (currentBduss != null && this.c) {
            acVar.a("BDUSS", currentBduss);
        }
    }

    public void b(ac acVar) {
        acVar.a("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        if (!TbadkApplication.m252getInst().isOfficial()) {
            acVar.a("apid", TbConfig.SW_APID);
        }
        acVar.a("_client_version", TbConfig.getVersion());
        if (TbadkApplication.m252getInst().getImei() != null) {
            acVar.a("_phone_imei", TbadkApplication.m252getInst().getImei());
        }
        String clientId = TbadkApplication.getClientId();
        if (clientId != null) {
            acVar.a("_client_id", clientId);
        }
        String from = TbadkApplication.getFrom();
        if (from != null && from.length() > 0) {
            acVar.a(com.baidu.tbadk.core.frameworkData.a.FROM, from);
        }
        String a = h.a();
        if (a != null) {
            String c = com.baidu.tbadk.coreExtra.a.a.a().c();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(a)) {
                if (TbadkApplication.m252getInst().getKeepaliveWifi() == 1) {
                    c = String.valueOf(c) + "ka=open";
                }
            } else if (TbadkApplication.m252getInst().getKeepaliveNonWifi() == 1) {
                c = String.valueOf(c) + "ka=open";
            }
            com.baidu.adp.lib.network.willdelete.e.a().a(c);
        }
        if (this.a) {
            acVar.a("tbs", TbadkApplication.m252getInst().getTbs());
        }
        String cuid = TbadkApplication.m252getInst().getCuid();
        if (cuid != null) {
            acVar.a("cuid", cuid);
        }
        acVar.a("timestamp", Long.toString(System.currentTimeMillis()));
        acVar.a("model", Build.MODEL);
    }

    public String b() {
        if (this.i.a == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.i.a.startsWith(str)) {
            int indexOf = this.i.a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.i.a.length();
            }
            return this.i.a.substring(str.length(), indexOf);
        }
        return this.i.a;
    }
}
