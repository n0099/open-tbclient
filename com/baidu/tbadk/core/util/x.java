package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private com.baidu.tbadk.core.util.a.a aVR = null;
    private q aVS = null;
    private x aVT = null;
    private aa.a aVU = null;
    private int aVV = 0;

    private void Cy() {
        this.aVR = new com.baidu.tbadk.core.util.a.a();
        this.aVS = z.CJ().a(this.aVR);
        this.aVT = null;
        this.aVR.Dw().Dz().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a Cz() {
        return this.aVR;
    }

    public x() {
        Cy();
    }

    public x(String str) {
        Cy();
        this.aVR.Dw().Dz().mUrl = str;
    }

    public void setUrl(String str) {
        this.aVR.Dw().Dz().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.aVS.m(arrayList);
    }

    public void n(String str, String str2) {
        this.aVS.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aVS.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aVS.d(str, bArr);
    }

    private void CA() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> Ca = this.aVS.Ca();
            int size = Ca.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = Ca.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    Ca.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    Ca.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void CB() {
        if (this.aVU == null) {
            this.aVU = aa.CK();
        }
        if (this.aVU != null) {
            this.aVS.n("stTime", String.valueOf(this.aVU.mTime));
            this.aVS.n("stSize", String.valueOf(this.aVU.aWm));
            this.aVS.n("stTimesNum", String.valueOf(this.aVU.aWn));
            this.aVS.n("stMode", String.valueOf(this.aVU.mMode));
            this.aVS.n("stMethod", String.valueOf(this.aVU.aWl));
        }
        this.aVV = aa.fF(0);
        if (this.aVV == 0 && this.aVU != null) {
            this.aVV = this.aVU.aWn;
        }
        this.aVS.n("stErrorNums", String.valueOf(this.aVV));
    }

    public boolean CC() {
        return this.aVR.Dx().CC();
    }

    public int CD() {
        return this.aVR.Dx().aYd;
    }

    public int CE() {
        return this.aVR.Dx().ajw;
    }

    public String CF() {
        return this.aVR.Dx().aYe;
    }

    public String getErrorString() {
        return this.aVR.Dx().mErrorString;
    }

    public void mS() {
        if (this.aVS != null) {
            this.aVS.mS();
        }
        if (this.aVT != null) {
            this.aVT.mS();
        }
    }

    public void mV() {
        if (this.aVS != null) {
            this.aVS.mV();
        }
        if (this.aVT != null) {
            this.aVT.mV();
        }
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String Cb;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aVT == null) {
                this.aVT = new x(sb.toString());
            } else {
                this.aVT.mS();
            }
            this.aVT.Cz().Dw().mIsNeedAddCommenParam = false;
            this.aVT.Cz().Dw().mIsUseCurrentBDUSS = false;
            this.aVT.Cz().Dw().aYa = false;
            this.aVT.n("un", str);
            this.aVT.n("passwd", str2);
            this.aVT.n("isphone", "0");
            this.aVT.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aVT.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aVT.Cz().Dw().Dz().aYB = true;
            Cb = this.aVT.Cb();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aVT.Cz().Dx().isRequestSuccess() && Cb != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(Cb);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aVR.Dx().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aeVar.getUser().getUserName());
            if (aeVar.getUser().getPassword() != null) {
                accountData.setPassword(aeVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aeVar.getUser().getUserId());
            accountData.setBDUSS(aeVar.getUser().getBDUSS());
            accountData.setPortrait(aeVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aeVar.yn() != null) {
                accountData.setTbs(aeVar.yn().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.aVT.CC()) {
            switch (this.aVT.CD()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] Cc() {
        if (!this.aVR.Dw().mIsFromCDN) {
            this.aVR.Dw().b(this.aVS);
        }
        return this.aVS.Cc();
    }

    private void CG() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> Ca = this.aVS.Ca();
        for (int i = 0; Ca != null && i < Ca.size(); i++) {
            BasicNameValuePair basicNameValuePair = Ca.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aVS.n("sign", com.baidu.adp.lib.util.s.ba(stringBuffer.toString()));
    }

    private String fC(int i) {
        String Ce;
        com.baidu.tbadk.coreExtra.a.c Fa;
        switch (i) {
            case 1:
                if (Cz().Dw().mIsNeedAddCommenParam) {
                    this.aVR.Dw().b(this.aVS);
                }
                CB();
                Ce = this.aVS.Cd();
                break;
            case 2:
                if (Cz().Dw().mIsUseCurrentBDUSS) {
                    Cz().Dw().a(this.aVS);
                }
                if (Cz().Dw().mIsNeedAddCommenParam) {
                    this.aVR.Dw().b(this.aVS);
                }
                CB();
                Ce = this.aVS.Cb();
                break;
            case 3:
                if (Cz().Dw().mIsUseCurrentBDUSS) {
                    Cz().Dw().a(this.aVS);
                }
                if (Cz().Dw().mIsNeedAddCommenParam) {
                    this.aVR.Dw().b(this.aVS);
                }
                CG();
                Ce = this.aVS.Ce();
                break;
            default:
                return null;
        }
        if (!this.aVR.Dx().CC()) {
            aa.a(this.aVU);
            aa.fG(this.aVV);
            return Ce;
        } else if (!this.aVR.Dx().isRequestSuccess()) {
            if (this.aVR.Dx().aYd == 1 && this.aVR.Dw().aYa) {
                String str = this.aVR.Dx().mErrorString;
                this.aVR.Dx().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.xz();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    CH();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cN(currentAccountObj.getAccount());
                if (ReloginManager.BK().BN()) {
                    ReloginManager.BK().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (Fa = com.baidu.tbadk.coreExtra.a.a.Fa()) != null) {
                    Fa.g(currentAccountObj);
                }
                if (e == null) {
                    if (this.aVT != null) {
                        this.aVR.Dx().mErrorString = this.aVT.getErrorString();
                        return null;
                    }
                    this.aVR.Dx().mErrorString = str;
                    return Ce;
                }
                Ce = fD(i);
            }
            com.baidu.tieba.h.a.a(this);
            return Ce;
        } else {
            return Ce;
        }
    }

    private String fD(int i) {
        String Ce;
        CA();
        switch (i) {
            case 1:
                Ce = this.aVS.Cd();
                break;
            case 2:
                Ce = this.aVS.Cb();
                break;
            case 3:
                Ce = this.aVS.Ce();
                break;
            default:
                return null;
        }
        if (this.aVR.Dx().CC()) {
            switch (this.aVR.Dx().aYd) {
                case 1:
                case 2:
                case 5:
                    CH();
                    this.aVR.Dx().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return Ce;
            }
        }
        return Ce;
    }

    private void CH() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String Cb() {
        return fC(2);
    }

    public String Cd() {
        return fC(1);
    }

    public String Ce() {
        return fC(3);
    }

    public String ei(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dS = k.dS(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dS.read(bArr2);
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
        return Ce();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cz().Dw().a(this.aVS);
        return this.aVS.a(str, handler, i, i2, i3, z);
    }
}
