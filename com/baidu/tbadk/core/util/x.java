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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private com.baidu.tbadk.core.util.a.a aUw = null;
    private q aUx = null;
    private x aUy = null;
    private aa.a aUz = null;
    private int aUA = 0;

    private void Cf() {
        this.aUw = new com.baidu.tbadk.core.util.a.a();
        this.aUx = z.Cq().a(this.aUw);
        this.aUy = null;
        this.aUw.Dc().Df().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a Cg() {
        return this.aUw;
    }

    public x() {
        Cf();
    }

    public x(String str) {
        Cf();
        this.aUw.Dc().Df().mUrl = str;
    }

    public void setUrl(String str) {
        this.aUw.Dc().Df().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.aUx.m(arrayList);
    }

    public void n(String str, String str2) {
        this.aUx.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aUx.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aUx.d(str, bArr);
    }

    private void Ch() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> BH = this.aUx.BH();
            int size = BH.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = BH.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    BH.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    BH.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void Ci() {
        if (this.aUz == null) {
            this.aUz = aa.Cr();
        }
        if (this.aUz != null) {
            this.aUx.n("stTime", String.valueOf(this.aUz.mTime));
            this.aUx.n("stSize", String.valueOf(this.aUz.aUQ));
            this.aUx.n("stTimesNum", String.valueOf(this.aUz.aUR));
            this.aUx.n("stMode", String.valueOf(this.aUz.mMode));
            this.aUx.n("stMethod", String.valueOf(this.aUz.aUP));
        }
        this.aUA = aa.fF(0);
        if (this.aUA == 0 && this.aUz != null) {
            this.aUA = this.aUz.aUR;
        }
        this.aUx.n("stErrorNums", String.valueOf(this.aUA));
    }

    public boolean Cj() {
        return this.aUw.Dd().Cj();
    }

    public int Ck() {
        return this.aUw.Dd().aWE;
    }

    public int Cl() {
        return this.aUw.Dd().ajD;
    }

    public String Cm() {
        return this.aUw.Dd().aWF;
    }

    public String getErrorString() {
        return this.aUw.Dd().mErrorString;
    }

    public void mS() {
        if (this.aUx != null) {
            this.aUx.mS();
        }
        if (this.aUy != null) {
            this.aUy.mS();
        }
    }

    public void mV() {
        if (this.aUx != null) {
            this.aUx.mV();
        }
        if (this.aUy != null) {
            this.aUy.mV();
        }
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String BI;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aUy == null) {
                this.aUy = new x(sb.toString());
            } else {
                this.aUy.mS();
            }
            this.aUy.Cg().Dc().mIsNeedAddCommenParam = false;
            this.aUy.Cg().Dc().mIsUseCurrentBDUSS = false;
            this.aUy.Cg().Dc().aWB = false;
            this.aUy.n("un", str);
            this.aUy.n("passwd", str2);
            this.aUy.n("isphone", "0");
            this.aUy.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aUy.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aUy.Cg().Dc().Df().aXc = true;
            BI = this.aUy.BI();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aUy.Cg().Dd().isRequestSuccess() && BI != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(BI);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aUw.Dd().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
            if (aeVar.xH() != null) {
                accountData.setTbs(aeVar.xH().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.aUy.Cj()) {
            switch (this.aUy.Ck()) {
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

    public byte[] BJ() {
        if (!this.aUw.Dc().mIsFromCDN) {
            this.aUw.Dc().b(this.aUx);
        }
        return this.aUx.BJ();
    }

    private void Cn() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> BH = this.aUx.BH();
        for (int i = 0; BH != null && i < BH.size(); i++) {
            BasicNameValuePair basicNameValuePair = BH.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aUx.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.ba(stringBuffer.toString()));
    }

    private String fC(int i) {
        String BL;
        com.baidu.tbadk.coreExtra.a.c EF;
        switch (i) {
            case 1:
                if (Cg().Dc().mIsNeedAddCommenParam) {
                    this.aUw.Dc().b(this.aUx);
                }
                Ci();
                BL = this.aUx.BK();
                break;
            case 2:
                if (Cg().Dc().mIsUseCurrentBDUSS) {
                    Cg().Dc().a(this.aUx);
                }
                if (Cg().Dc().mIsNeedAddCommenParam) {
                    this.aUw.Dc().b(this.aUx);
                }
                Ci();
                BL = this.aUx.BI();
                break;
            case 3:
                if (Cg().Dc().mIsUseCurrentBDUSS) {
                    Cg().Dc().a(this.aUx);
                }
                if (Cg().Dc().mIsNeedAddCommenParam) {
                    this.aUw.Dc().b(this.aUx);
                }
                Cn();
                BL = this.aUx.BL();
                break;
            default:
                return null;
        }
        if (!this.aUw.Dd().Cj()) {
            aa.a(this.aUz);
            aa.fG(this.aUA);
            return BL;
        } else if (!this.aUw.Dd().isRequestSuccess()) {
            if (this.aUw.Dd().aWE == 1 && this.aUw.Dc().aWB) {
                String str = this.aUw.Dd().mErrorString;
                this.aUw.Dd().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.wM();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    Co();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cC(currentAccountObj.getAccount());
                if (ReloginManager.Bq().Bu()) {
                    AccountData Bt = ReloginManager.Bq().Bt();
                    if (Bt == null) {
                        ReloginManager.Bq().e(Bt);
                        return null;
                    }
                    return fD(i);
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (EF = com.baidu.tbadk.coreExtra.a.a.EF()) != null) {
                    EF.g(currentAccountObj);
                }
                if (e == null) {
                    if (this.aUy != null) {
                        this.aUw.Dd().mErrorString = this.aUy.getErrorString();
                        return null;
                    }
                    this.aUw.Dd().mErrorString = str;
                    return BL;
                }
                BL = fD(i);
            }
            com.baidu.tieba.h.a.a(this);
            return BL;
        } else {
            return BL;
        }
    }

    private String fD(int i) {
        String BL;
        Ch();
        switch (i) {
            case 1:
                BL = this.aUx.BK();
                break;
            case 2:
                BL = this.aUx.BI();
                break;
            case 3:
                BL = this.aUx.BL();
                break;
            default:
                return null;
        }
        if (this.aUw.Dd().Cj()) {
            switch (this.aUw.Dd().aWE) {
                case 1:
                case 2:
                case 5:
                    Co();
                    this.aUw.Dd().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return BL;
            }
        }
        return BL;
    }

    private void Co() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String BI() {
        return fC(2);
    }

    public String BK() {
        return fC(1);
    }

    public String BL() {
        return fC(3);
    }

    public String dX(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dH = k.dH(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dH.read(bArr2);
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
        return BL();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cg().Dc().a(this.aUx);
        return this.aUx.a(str, handler, i, i2, i3, z);
    }
}
