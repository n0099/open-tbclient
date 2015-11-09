package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes.dex */
public class b {
    private final h abS = new h();
    public boolean mIsNeedTbs = false;
    public boolean abT = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean abU = false;
    public int abV = 0;

    public h vc() {
        return this.abS;
    }

    public void a(q qVar) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null && this.mIsUseCurrentBDUSS) {
            qVar.o("BDUSS", currentBduss);
        }
    }

    public void b(q qVar) {
        String str;
        boolean z = true;
        qVar.o("_client_type", "2");
        if (!TbadkCoreApplication.m411getInst().isOfficial()) {
            qVar.o("apid", TbConfig.SW_APID);
        }
        qVar.o("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m411getInst().getImei() != null) {
            qVar.o("_phone_imei", TbadkCoreApplication.m411getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            qVar.o("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            qVar.o("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            qVar.o("from", from);
        }
        String netType = i.getNetType();
        if (netType != null) {
            String wf = com.baidu.tbadk.coreExtra.b.a.wc().wf();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m411getInst().getKeepaliveWifi() == 1) {
                    str = String.valueOf(wf) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.ah(str);
                }
                z = false;
                str = wf;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.ah(str);
            } else {
                if (TbadkCoreApplication.m411getInst().getKeepaliveNonWifi() == 1) {
                    str = String.valueOf(wf) + "ka=open";
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.ah(str);
                }
                z = false;
                str = wf;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.ah(str);
            }
        }
        if (this.mIsNeedTbs) {
            qVar.o("tbs", TbadkCoreApplication.m411getInst().getTbs());
        }
        qVar.o(SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid());
        qVar.o("timestamp", Long.toString(System.currentTimeMillis()));
        qVar.o("model", Build.MODEL);
    }

    public String vd() {
        if (this.abS.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.abS.mUrl.startsWith(str)) {
            int indexOf = this.abS.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.abS.mUrl.length();
            }
            return this.abS.mUrl.substring(str.length(), indexOf);
        }
        return this.abS.mUrl;
    }
}
