package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class z {
    private com.baidu.tbadk.core.util.a.a aan = null;
    private s aao = null;
    private z aap = null;
    private ad.a aaq = null;
    private int aar = 0;

    private void uH() {
        this.aan = new com.baidu.tbadk.core.util.a.a();
        this.aao = ac.uR().a(this.aan);
        this.aap = null;
        this.aan.vB().vE().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ag(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uI() {
        return this.aan;
    }

    public z() {
        uH();
    }

    public z(String str) {
        uH();
        this.aan.vB().vE().mUrl = str;
    }

    public void setUrl(String str) {
        this.aan.vB().vE().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.aao.l(arrayList);
    }

    public void n(String str, String str2) {
        this.aao.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aao.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aao.d(str, bArr);
    }

    private void uJ() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uj = this.aao.uj();
            int size = uj.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uj.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uj.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uj.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uK() {
        if (this.aaq == null) {
            this.aaq = ad.uS();
        }
        if (this.aaq != null) {
            this.aao.n("stTime", String.valueOf(this.aaq.mTime));
            this.aao.n("stSize", String.valueOf(this.aaq.aaI));
            this.aao.n("stTimesNum", String.valueOf(this.aaq.aaJ));
            this.aao.n("stMode", String.valueOf(this.aaq.mMode));
            this.aao.n("stMethod", String.valueOf(this.aaq.aaH));
        }
        this.aar = ad.cH(0);
        if (this.aar == 0 && this.aaq != null) {
            this.aar = this.aaq.aaJ;
        }
        this.aao.n("stErrorNums", String.valueOf(this.aar));
    }

    public boolean uL() {
        return this.aan.vC().uL();
    }

    public int uM() {
        return this.aan.vC().acu;
    }

    public int uN() {
        return this.aan.vC().oF;
    }

    public String uO() {
        return this.aan.vC().acv;
    }

    public String getErrorString() {
        return this.aan.vC().mErrorString;
    }

    public void eg() {
        if (this.aao != null) {
            this.aao.eg();
        }
        if (this.aap != null) {
            this.aap.eg();
        }
    }

    public void ej() {
        if (this.aao != null) {
            this.aao.ej();
        }
        if (this.aap != null) {
            this.aap.ej();
        }
    }

    private com.baidu.tbadk.core.data.ah d(String str, String str2, boolean z) {
        String uk;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aap == null) {
                this.aap = new z(sb.toString());
            } else {
                this.aap.eg();
            }
            this.aap.uI().vB().mIsNeedAddCommenParam = false;
            this.aap.uI().vB().mIsUseCurrentBDUSS = false;
            this.aap.uI().vB().acr = false;
            this.aap.n("un", str);
            this.aap.n("passwd", str2);
            this.aap.n("isphone", "0");
            this.aap.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aap.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aap.uI().vB().vE().acS = true;
            uk = this.aap.uk();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aap.uI().vC().oH() && uk != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(uk);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aan.vC().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(r.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(ahVar.getUser().getUserName());
            if (ahVar.getUser().getPassword() != null) {
                accountData.setPassword(ahVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(ahVar.getUser().getUserId());
            accountData.setBDUSS(ahVar.getUser().getBDUSS());
            accountData.setPortrait(ahVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (ahVar.qt() != null) {
                accountData.setTbs(ahVar.qt().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return ahVar;
        }
        if (this.aap.uL()) {
            switch (this.aap.uM()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m9getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m9getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] ul() {
        if (!this.aan.vB().mIsFromCDN) {
            this.aan.vB().b(this.aao);
        }
        return this.aao.ul();
    }

    private void uP() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uj = this.aao.uj();
        for (int i = 0; uj != null && i < uj.size(); i++) {
            BasicNameValuePair basicNameValuePair = uj.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aao.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aU(stringBuffer.toString()));
    }

    private String cE(int i) {
        String un;
        com.baidu.tbadk.coreExtra.a.c xi;
        switch (i) {
            case 1:
                if (uI().vB().mIsNeedAddCommenParam) {
                    this.aan.vB().b(this.aao);
                }
                uK();
                un = this.aao.um();
                break;
            case 2:
                if (uI().vB().mIsUseCurrentBDUSS) {
                    uI().vB().a(this.aao);
                }
                if (uI().vB().mIsNeedAddCommenParam) {
                    this.aan.vB().b(this.aao);
                }
                uK();
                un = this.aao.uk();
                break;
            case 3:
                if (uI().vB().mIsUseCurrentBDUSS) {
                    uI().vB().a(this.aao);
                }
                if (uI().vB().mIsNeedAddCommenParam) {
                    this.aan.vB().b(this.aao);
                }
                uP();
                un = this.aao.un();
                break;
            default:
                return null;
        }
        if (!this.aan.vC().uL()) {
            ad.a(this.aaq);
            ad.cI(this.aar);
            return un;
        } else if (!this.aan.vC().oH() && this.aan.vC().acu == 1 && this.aan.vB().acr) {
            String str = this.aan.vC().mErrorString;
            this.aan.vC().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.oV();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.ci(currentAccountObj.getAccount());
            if (ReloginManager.tR().tV()) {
                AccountData tU = ReloginManager.tR().tU();
                if (tU == null) {
                    ReloginManager.tR().f(tU);
                    return null;
                }
                return cF(i);
            }
            com.baidu.tbadk.core.data.ah d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xi = com.baidu.tbadk.coreExtra.a.a.xi()) != null) {
                xi.h(currentAccountObj);
            }
            if (d == null) {
                if (this.aap != null) {
                    this.aan.vC().mErrorString = this.aap.getErrorString();
                    return null;
                }
                this.aan.vC().mErrorString = str;
                return un;
            }
            return cF(i);
        } else {
            return un;
        }
    }

    private String cF(int i) {
        String un;
        uJ();
        switch (i) {
            case 1:
                un = this.aao.um();
                break;
            case 2:
                un = this.aao.uk();
                break;
            case 3:
                un = this.aao.un();
                break;
            default:
                return null;
        }
        if (this.aan.vC().uL()) {
            switch (this.aan.vC().acu) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.aan.vC().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return un;
            }
        }
        return un;
    }

    public String uk() {
        return cE(2);
    }

    public String um() {
        return cE(1);
    }

    public String un() {
        return cE(3);
    }

    public String dt(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream df = m.df(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = df.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        d("pic", bArr);
        return un();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uI().vB().a(this.aao);
        return this.aao.a(str, handler, i, i2, i3, z);
    }
}
