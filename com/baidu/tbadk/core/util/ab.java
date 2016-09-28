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
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a aav = null;
    private t aaw = null;
    private ab aax = null;
    private af.a aay = null;
    private int aaz = 0;

    private void uR() {
        this.aav = new com.baidu.tbadk.core.util.a.a();
        this.aaw = ae.vb().a(this.aav);
        this.aax = null;
        this.aav.vN().vQ().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ag(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uS() {
        return this.aav;
    }

    public ab() {
        uR();
    }

    public ab(String str) {
        uR();
        this.aav.vN().vQ().mUrl = str;
    }

    public void setUrl(String str) {
        this.aav.vN().vQ().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.aaw.l(arrayList);
    }

    public void n(String str, String str2) {
        this.aaw.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aaw.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aaw.d(str, bArr);
    }

    private void uT() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ut = this.aaw.ut();
            int size = ut.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ut.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ut.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ut.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uU() {
        if (this.aay == null) {
            this.aay = af.vc();
        }
        if (this.aay != null) {
            this.aaw.n("stTime", String.valueOf(this.aay.mTime));
            this.aaw.n("stSize", String.valueOf(this.aay.aaQ));
            this.aaw.n("stTimesNum", String.valueOf(this.aay.aaR));
            this.aaw.n("stMode", String.valueOf(this.aay.mMode));
            this.aaw.n("stMethod", String.valueOf(this.aay.aaP));
        }
        this.aaz = af.cE(0);
        if (this.aaz == 0 && this.aay != null) {
            this.aaz = this.aay.aaR;
        }
        this.aaw.n("stErrorNums", String.valueOf(this.aaz));
    }

    public boolean uV() {
        return this.aav.vO().uV();
    }

    public int uW() {
        return this.aav.vO().acD;
    }

    public int uX() {
        return this.aav.vO().oE;
    }

    public String uY() {
        return this.aav.vO().acE;
    }

    public String getErrorString() {
        return this.aav.vO().mErrorString;
    }

    public void eg() {
        if (this.aaw != null) {
            this.aaw.eg();
        }
        if (this.aax != null) {
            this.aax.eg();
        }
    }

    public void ej() {
        if (this.aaw != null) {
            this.aaw.ej();
        }
        if (this.aax != null) {
            this.aax.ej();
        }
    }

    private com.baidu.tbadk.core.data.ag d(String str, String str2, boolean z) {
        String uu;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aax == null) {
                this.aax = new ab(sb.toString());
            } else {
                this.aax.eg();
            }
            this.aax.uS().vN().mIsNeedAddCommenParam = false;
            this.aax.uS().vN().mIsUseCurrentBDUSS = false;
            this.aax.uS().vN().acA = false;
            this.aax.n("un", str);
            this.aax.n("passwd", str2);
            this.aax.n("isphone", "0");
            this.aax.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aax.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aax.uS().vN().vQ().adb = true;
            uu = this.aax.uu();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aax.uS().vO().oF() && uu != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(uu);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aav.vO().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(r.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(agVar.getUser().getUserName());
            if (agVar.getUser().getPassword() != null) {
                accountData.setPassword(agVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(agVar.getUser().getUserId());
            accountData.setBDUSS(agVar.getUser().getBDUSS());
            accountData.setPortrait(agVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (agVar.qq() != null) {
                accountData.setTbs(agVar.qq().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return agVar;
        }
        if (this.aax.uV()) {
            switch (this.aax.uW()) {
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

    public byte[] uv() {
        if (!this.aav.vN().mIsFromCDN) {
            this.aav.vN().b(this.aaw);
        }
        return this.aaw.uv();
    }

    private void uZ() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ut = this.aaw.ut();
        for (int i = 0; ut != null && i < ut.size(); i++) {
            BasicNameValuePair basicNameValuePair = ut.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aaw.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aU(stringBuffer.toString()));
    }

    private String cB(int i) {
        String ux;
        com.baidu.tbadk.coreExtra.a.c xq;
        switch (i) {
            case 1:
                if (uS().vN().mIsNeedAddCommenParam) {
                    this.aav.vN().b(this.aaw);
                }
                uU();
                ux = this.aaw.uw();
                break;
            case 2:
                if (uS().vN().mIsUseCurrentBDUSS) {
                    uS().vN().a(this.aaw);
                }
                if (uS().vN().mIsNeedAddCommenParam) {
                    this.aav.vN().b(this.aaw);
                }
                uU();
                ux = this.aaw.uu();
                break;
            case 3:
                if (uS().vN().mIsUseCurrentBDUSS) {
                    uS().vN().a(this.aaw);
                }
                if (uS().vN().mIsNeedAddCommenParam) {
                    this.aav.vN().b(this.aaw);
                }
                uZ();
                ux = this.aaw.ux();
                break;
            default:
                return null;
        }
        if (!this.aav.vO().uV()) {
            af.a(this.aay);
            af.cF(this.aaz);
            return ux;
        } else if (!this.aav.vO().oF() && this.aav.vO().acD == 1 && this.aav.vN().acA) {
            String str = this.aav.vO().mErrorString;
            this.aav.vO().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.oT();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cg(currentAccountObj.getAccount());
            if (ReloginManager.uc().ug()) {
                AccountData uf = ReloginManager.uc().uf();
                if (uf == null) {
                    ReloginManager.uc().f(uf);
                    return null;
                }
                return cC(i);
            }
            com.baidu.tbadk.core.data.ag d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xq = com.baidu.tbadk.coreExtra.a.a.xq()) != null) {
                xq.h(currentAccountObj);
            }
            if (d == null) {
                if (this.aax != null) {
                    this.aav.vO().mErrorString = this.aax.getErrorString();
                    return null;
                }
                this.aav.vO().mErrorString = str;
                return ux;
            }
            return cC(i);
        } else {
            return ux;
        }
    }

    private String cC(int i) {
        String ux;
        uT();
        switch (i) {
            case 1:
                ux = this.aaw.uw();
                break;
            case 2:
                ux = this.aaw.uu();
                break;
            case 3:
                ux = this.aaw.ux();
                break;
            default:
                return null;
        }
        if (this.aav.vO().uV()) {
            switch (this.aav.vO().acD) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.aav.vO().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return ux;
            }
        }
        return ux;
    }

    public String uu() {
        return cB(2);
    }

    public String uw() {
        return cB(1);
    }

    public String ux() {
        return cB(3);
    }

    public String dq(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dc = m.dc(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dc.read(bArr2);
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
        return ux();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uS().vN().a(this.aaw);
        return this.aaw.a(str, handler, i, i2, i3, z);
    }
}
