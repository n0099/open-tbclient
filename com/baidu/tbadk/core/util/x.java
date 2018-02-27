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
    private com.baidu.tbadk.core.util.a.a aVP = null;
    private q aVQ = null;
    private x aVR = null;
    private aa.a aVS = null;
    private int aVT = 0;

    private void Cx() {
        this.aVP = new com.baidu.tbadk.core.util.a.a();
        this.aVQ = z.CI().a(this.aVP);
        this.aVR = null;
        this.aVP.Dv().Dy().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a Cy() {
        return this.aVP;
    }

    public x() {
        Cx();
    }

    public x(String str) {
        Cx();
        this.aVP.Dv().Dy().mUrl = str;
    }

    public void setUrl(String str) {
        this.aVP.Dv().Dy().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.aVQ.m(arrayList);
    }

    public void n(String str, String str2) {
        this.aVQ.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aVQ.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aVQ.d(str, bArr);
    }

    private void Cz() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> BZ = this.aVQ.BZ();
            int size = BZ.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = BZ.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    BZ.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    BZ.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void CA() {
        if (this.aVS == null) {
            this.aVS = aa.CJ();
        }
        if (this.aVS != null) {
            this.aVQ.n("stTime", String.valueOf(this.aVS.mTime));
            this.aVQ.n("stSize", String.valueOf(this.aVS.aWk));
            this.aVQ.n("stTimesNum", String.valueOf(this.aVS.aWl));
            this.aVQ.n("stMode", String.valueOf(this.aVS.mMode));
            this.aVQ.n("stMethod", String.valueOf(this.aVS.aWj));
        }
        this.aVT = aa.fF(0);
        if (this.aVT == 0 && this.aVS != null) {
            this.aVT = this.aVS.aWl;
        }
        this.aVQ.n("stErrorNums", String.valueOf(this.aVT));
    }

    public boolean CB() {
        return this.aVP.Dw().CB();
    }

    public int CC() {
        return this.aVP.Dw().aYb;
    }

    public int CD() {
        return this.aVP.Dw().ajw;
    }

    public String CE() {
        return this.aVP.Dw().aYc;
    }

    public String getErrorString() {
        return this.aVP.Dw().mErrorString;
    }

    public void mS() {
        if (this.aVQ != null) {
            this.aVQ.mS();
        }
        if (this.aVR != null) {
            this.aVR.mS();
        }
    }

    public void mV() {
        if (this.aVQ != null) {
            this.aVQ.mV();
        }
        if (this.aVR != null) {
            this.aVR.mV();
        }
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String Ca;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aVR == null) {
                this.aVR = new x(sb.toString());
            } else {
                this.aVR.mS();
            }
            this.aVR.Cy().Dv().mIsNeedAddCommenParam = false;
            this.aVR.Cy().Dv().mIsUseCurrentBDUSS = false;
            this.aVR.Cy().Dv().aXY = false;
            this.aVR.n("un", str);
            this.aVR.n("passwd", str2);
            this.aVR.n("isphone", "0");
            this.aVR.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aVR.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aVR.Cy().Dv().Dy().aYz = true;
            Ca = this.aVR.Ca();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aVR.Cy().Dw().isRequestSuccess() && Ca != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(Ca);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aVP.Dw().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
        if (this.aVR.CB()) {
            switch (this.aVR.CC()) {
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

    public byte[] Cb() {
        if (!this.aVP.Dv().mIsFromCDN) {
            this.aVP.Dv().b(this.aVQ);
        }
        return this.aVQ.Cb();
    }

    private void CF() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> BZ = this.aVQ.BZ();
        for (int i = 0; BZ != null && i < BZ.size(); i++) {
            BasicNameValuePair basicNameValuePair = BZ.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aVQ.n("sign", com.baidu.adp.lib.util.s.ba(stringBuffer.toString()));
    }

    private String fC(int i) {
        String Cd;
        com.baidu.tbadk.coreExtra.a.c EZ;
        switch (i) {
            case 1:
                if (Cy().Dv().mIsNeedAddCommenParam) {
                    this.aVP.Dv().b(this.aVQ);
                }
                CA();
                Cd = this.aVQ.Cc();
                break;
            case 2:
                if (Cy().Dv().mIsUseCurrentBDUSS) {
                    Cy().Dv().a(this.aVQ);
                }
                if (Cy().Dv().mIsNeedAddCommenParam) {
                    this.aVP.Dv().b(this.aVQ);
                }
                CA();
                Cd = this.aVQ.Ca();
                break;
            case 3:
                if (Cy().Dv().mIsUseCurrentBDUSS) {
                    Cy().Dv().a(this.aVQ);
                }
                if (Cy().Dv().mIsNeedAddCommenParam) {
                    this.aVP.Dv().b(this.aVQ);
                }
                CF();
                Cd = this.aVQ.Cd();
                break;
            default:
                return null;
        }
        if (!this.aVP.Dw().CB()) {
            aa.a(this.aVS);
            aa.fG(this.aVT);
            return Cd;
        } else if (!this.aVP.Dw().isRequestSuccess()) {
            if (this.aVP.Dw().aYb == 1 && this.aVP.Dv().aXY) {
                String str = this.aVP.Dw().mErrorString;
                this.aVP.Dw().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.xz();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    CG();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cN(currentAccountObj.getAccount());
                if (ReloginManager.BJ().BM()) {
                    ReloginManager.BJ().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (EZ = com.baidu.tbadk.coreExtra.a.a.EZ()) != null) {
                    EZ.g(currentAccountObj);
                }
                if (e == null) {
                    if (this.aVR != null) {
                        this.aVP.Dw().mErrorString = this.aVR.getErrorString();
                        return null;
                    }
                    this.aVP.Dw().mErrorString = str;
                    return Cd;
                }
                Cd = fD(i);
            }
            com.baidu.tieba.h.a.a(this);
            return Cd;
        } else {
            return Cd;
        }
    }

    private String fD(int i) {
        String Cd;
        Cz();
        switch (i) {
            case 1:
                Cd = this.aVQ.Cc();
                break;
            case 2:
                Cd = this.aVQ.Ca();
                break;
            case 3:
                Cd = this.aVQ.Cd();
                break;
            default:
                return null;
        }
        if (this.aVP.Dw().CB()) {
            switch (this.aVP.Dw().aYb) {
                case 1:
                case 2:
                case 5:
                    CG();
                    this.aVP.Dw().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return Cd;
            }
        }
        return Cd;
    }

    private void CG() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String Ca() {
        return fC(2);
    }

    public String Cc() {
        return fC(1);
    }

    public String Cd() {
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
        return Cd();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cy().Dv().a(this.aVQ);
        return this.aVQ.a(str, handler, i, i2, i3, z);
    }
}
