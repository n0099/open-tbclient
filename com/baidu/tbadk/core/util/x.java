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
    private com.baidu.tbadk.core.util.a.a aWb = null;
    private q aWc = null;
    private x aWd = null;
    private aa.a aWe = null;
    private int aWf = 0;

    private void Cy() {
        this.aWb = new com.baidu.tbadk.core.util.a.a();
        this.aWc = z.CJ().a(this.aWb);
        this.aWd = null;
        this.aWb.Dw().Dz().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a Cz() {
        return this.aWb;
    }

    public x() {
        Cy();
    }

    public x(String str) {
        Cy();
        this.aWb.Dw().Dz().mUrl = str;
    }

    public void setUrl(String str) {
        this.aWb.Dw().Dz().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.aWc.m(arrayList);
    }

    public void n(String str, String str2) {
        this.aWc.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aWc.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aWc.d(str, bArr);
    }

    private void CA() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> Ca = this.aWc.Ca();
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
        if (this.aWe == null) {
            this.aWe = aa.CK();
        }
        if (this.aWe != null) {
            this.aWc.n("stTime", String.valueOf(this.aWe.mTime));
            this.aWc.n("stSize", String.valueOf(this.aWe.aWw));
            this.aWc.n("stTimesNum", String.valueOf(this.aWe.aWx));
            this.aWc.n("stMode", String.valueOf(this.aWe.mMode));
            this.aWc.n("stMethod", String.valueOf(this.aWe.aWv));
        }
        this.aWf = aa.fF(0);
        if (this.aWf == 0 && this.aWe != null) {
            this.aWf = this.aWe.aWx;
        }
        this.aWc.n("stErrorNums", String.valueOf(this.aWf));
    }

    public boolean CC() {
        return this.aWb.Dx().CC();
    }

    public int CD() {
        return this.aWb.Dx().aYn;
    }

    public int CE() {
        return this.aWb.Dx().ajC;
    }

    public String CF() {
        return this.aWb.Dx().aYo;
    }

    public String getErrorString() {
        return this.aWb.Dx().mErrorString;
    }

    public void mS() {
        if (this.aWc != null) {
            this.aWc.mS();
        }
        if (this.aWd != null) {
            this.aWd.mS();
        }
    }

    public void mV() {
        if (this.aWc != null) {
            this.aWc.mV();
        }
        if (this.aWd != null) {
            this.aWd.mV();
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
            if (this.aWd == null) {
                this.aWd = new x(sb.toString());
            } else {
                this.aWd.mS();
            }
            this.aWd.Cz().Dw().mIsNeedAddCommenParam = false;
            this.aWd.Cz().Dw().mIsUseCurrentBDUSS = false;
            this.aWd.Cz().Dw().aYk = false;
            this.aWd.n("un", str);
            this.aWd.n("passwd", str2);
            this.aWd.n("isphone", "0");
            this.aWd.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aWd.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aWd.Cz().Dw().Dz().aYL = true;
            Cb = this.aWd.Cb();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aWd.Cz().Dx().isRequestSuccess() && Cb != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(Cb);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aWb.Dx().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
        if (this.aWd.CC()) {
            switch (this.aWd.CD()) {
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
        if (!this.aWb.Dw().mIsFromCDN) {
            this.aWb.Dw().b(this.aWc);
        }
        return this.aWc.Cc();
    }

    private void CG() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> Ca = this.aWc.Ca();
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
        this.aWc.n("sign", com.baidu.adp.lib.util.s.ba(stringBuffer.toString()));
    }

    private String fC(int i) {
        String Ce;
        com.baidu.tbadk.coreExtra.a.c Fa;
        switch (i) {
            case 1:
                if (Cz().Dw().mIsNeedAddCommenParam) {
                    this.aWb.Dw().b(this.aWc);
                }
                CB();
                Ce = this.aWc.Cd();
                break;
            case 2:
                if (Cz().Dw().mIsUseCurrentBDUSS) {
                    Cz().Dw().a(this.aWc);
                }
                if (Cz().Dw().mIsNeedAddCommenParam) {
                    this.aWb.Dw().b(this.aWc);
                }
                CB();
                Ce = this.aWc.Cb();
                break;
            case 3:
                if (Cz().Dw().mIsUseCurrentBDUSS) {
                    Cz().Dw().a(this.aWc);
                }
                if (Cz().Dw().mIsNeedAddCommenParam) {
                    this.aWb.Dw().b(this.aWc);
                }
                CG();
                Ce = this.aWc.Ce();
                break;
            default:
                return null;
        }
        if (!this.aWb.Dx().CC()) {
            aa.a(this.aWe);
            aa.fG(this.aWf);
            return Ce;
        } else if (!this.aWb.Dx().isRequestSuccess()) {
            if (this.aWb.Dx().aYn == 1 && this.aWb.Dw().aYk) {
                String str = this.aWb.Dx().mErrorString;
                this.aWb.Dx().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.xz();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    CH();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cN(currentAccountObj.getAccount());
                if (ReloginManager.BJ().BN()) {
                    AccountData BM = ReloginManager.BJ().BM();
                    if (BM == null) {
                        ReloginManager.BJ().e(BM);
                        return null;
                    }
                    return fD(i);
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (Fa = com.baidu.tbadk.coreExtra.a.a.Fa()) != null) {
                    Fa.g(currentAccountObj);
                }
                if (e == null) {
                    if (this.aWd != null) {
                        this.aWb.Dx().mErrorString = this.aWd.getErrorString();
                        return null;
                    }
                    this.aWb.Dx().mErrorString = str;
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
                Ce = this.aWc.Cd();
                break;
            case 2:
                Ce = this.aWc.Cb();
                break;
            case 3:
                Ce = this.aWc.Ce();
                break;
            default:
                return null;
        }
        if (this.aWb.Dx().CC()) {
            switch (this.aWb.Dx().aYn) {
                case 1:
                case 2:
                case 5:
                    CH();
                    this.aWb.Dx().mErrorString = "";
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
        Cz().Dw().a(this.aWc);
        return this.aWc.a(str, handler, i, i2, i3, z);
    }
}
