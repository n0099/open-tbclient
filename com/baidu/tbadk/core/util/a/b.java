package com.baidu.tbadk.core.util.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes.dex */
public class b {
    private final g ahV = new g();
    public boolean mIsNeedTbs = false;
    public boolean ahW = true;
    public boolean mIsUseCurrentBDUSS = true;
    public boolean mIsNeedAddCommenParam = true;
    public boolean mIsFromCDN = false;
    public boolean ahX = false;
    public int ahY = 0;

    public g vN() {
        return this.ahV;
    }

    public void a(q qVar) {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null && this.mIsUseCurrentBDUSS) {
            qVar.n("BDUSS", bduss);
            String d = com.baidu.tbadk.core.a.e.d(currentAccountInfo);
            if (!StringUtils.isNull(d)) {
                qVar.n("stoken", d);
            }
        }
    }

    public void b(q qVar) {
        String str;
        boolean z;
        qVar.n("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            qVar.n("apid", TbConfig.SW_APID);
        }
        qVar.n("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            qVar.n("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            qVar.n("_client_id", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            qVar.n("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            qVar.n("from", from);
        }
        String netType = h.getNetType();
        if (netType != null) {
            String xu = com.baidu.tbadk.coreExtra.b.a.xr().xu();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                    str = xu + "ka=open";
                    z = true;
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.ai(str);
                }
                str = xu;
                z = false;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.ai(str);
            } else {
                if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                    str = xu + "ka=open";
                    z = true;
                    com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                    com.baidu.adp.lib.network.a.a.ai(str);
                }
                str = xu;
                z = false;
                com.baidu.adp.lib.network.a.a.setKeepAlive(z);
                com.baidu.adp.lib.network.a.a.ai(str);
            }
        }
        if (this.mIsNeedTbs) {
            qVar.n("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        qVar.n("cuid", TbadkCoreApplication.getInst().getCuid());
        qVar.n("timestamp", Long.toString(System.currentTimeMillis()));
        qVar.n("model", Build.MODEL);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("android_safe_sdk_open", 0) == 1) {
            qVar.n("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    public String vO() {
        if (this.ahV.mUrl == null) {
            return null;
        }
        String str = TbConfig.SERVER_ADDRESS;
        if (this.ahV.mUrl.startsWith(str)) {
            int indexOf = this.ahV.mUrl.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.ahV.mUrl.length();
            }
            return this.ahV.mUrl.substring(str.length(), indexOf);
        }
        return this.ahV.mUrl;
    }
}
