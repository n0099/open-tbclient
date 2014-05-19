package com.baidu.tbadk.core.util.a;

import android.os.Build;
import com.baidu.adp.lib.stats.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class b {
    private final f i = new f();
    public boolean a = false;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public String f = r.a();
    public boolean g = false;
    public int h = 0;

    public f a() {
        return this.i;
    }

    public void a(aa aaVar) {
        String currentBduss = TbadkApplication.getCurrentBduss();
        if (currentBduss != null && this.c) {
            aaVar.a("BDUSS", currentBduss);
        }
    }

    public void b(aa aaVar) {
        aaVar.a("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        if (!TbadkApplication.m252getInst().isOfficial()) {
            aaVar.a("apid", TbConfig.SW_APID);
        }
        aaVar.a("_client_version", TbConfig.getVersion());
        if (TbadkApplication.m252getInst().getImei() != null) {
            aaVar.a("_phone_imei", TbadkApplication.m252getInst().getImei());
        }
        String clientId = TbadkApplication.getClientId();
        if (clientId != null) {
            aaVar.a("_client_id", clientId);
        }
        String from = TbadkApplication.getFrom();
        if (from != null && from.length() > 0) {
            aaVar.a("from", from);
        }
        String a = g.a();
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
            aaVar.a("tbs", TbadkApplication.m252getInst().getTbs());
        }
        String cuid = TbadkApplication.m252getInst().getCuid();
        if (cuid != null) {
            aaVar.a("cuid", cuid);
        }
        aaVar.a("timestamp", Long.toString(System.currentTimeMillis()));
        aaVar.a("model", Build.MODEL);
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
