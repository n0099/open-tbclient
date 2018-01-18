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
    private com.baidu.tbadk.core.util.a.a aUt = null;
    private q aUu = null;
    private x aUv = null;
    private aa.a aUw = null;
    private int aUx = 0;

    private void Ce() {
        this.aUt = new com.baidu.tbadk.core.util.a.a();
        this.aUu = z.Cp().a(this.aUt);
        this.aUv = null;
        this.aUt.Db().De().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a Cf() {
        return this.aUt;
    }

    public x() {
        Ce();
    }

    public x(String str) {
        Ce();
        this.aUt.Db().De().mUrl = str;
    }

    public void setUrl(String str) {
        this.aUt.Db().De().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.aUu.m(arrayList);
    }

    public void n(String str, String str2) {
        this.aUu.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aUu.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aUu.d(str, bArr);
    }

    private void Cg() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> BG = this.aUu.BG();
            int size = BG.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = BG.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    BG.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    BG.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void Ch() {
        if (this.aUw == null) {
            this.aUw = aa.Cq();
        }
        if (this.aUw != null) {
            this.aUu.n("stTime", String.valueOf(this.aUw.mTime));
            this.aUu.n("stSize", String.valueOf(this.aUw.aUN));
            this.aUu.n("stTimesNum", String.valueOf(this.aUw.aUO));
            this.aUu.n("stMode", String.valueOf(this.aUw.mMode));
            this.aUu.n("stMethod", String.valueOf(this.aUw.aUM));
        }
        this.aUx = aa.fF(0);
        if (this.aUx == 0 && this.aUw != null) {
            this.aUx = this.aUw.aUO;
        }
        this.aUu.n("stErrorNums", String.valueOf(this.aUx));
    }

    public boolean Ci() {
        return this.aUt.Dc().Ci();
    }

    public int Cj() {
        return this.aUt.Dc().aWB;
    }

    public int Ck() {
        return this.aUt.Dc().ajA;
    }

    public String Cl() {
        return this.aUt.Dc().aWC;
    }

    public String getErrorString() {
        return this.aUt.Dc().mErrorString;
    }

    public void mR() {
        if (this.aUu != null) {
            this.aUu.mR();
        }
        if (this.aUv != null) {
            this.aUv.mR();
        }
    }

    public void mU() {
        if (this.aUu != null) {
            this.aUu.mU();
        }
        if (this.aUv != null) {
            this.aUv.mU();
        }
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String BH;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aUv == null) {
                this.aUv = new x(sb.toString());
            } else {
                this.aUv.mR();
            }
            this.aUv.Cf().Db().mIsNeedAddCommenParam = false;
            this.aUv.Cf().Db().mIsUseCurrentBDUSS = false;
            this.aUv.Cf().Db().aWy = false;
            this.aUv.n("un", str);
            this.aUv.n("passwd", str2);
            this.aUv.n("isphone", "0");
            this.aUv.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aUv.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aUv.Cf().Db().De().aWZ = true;
            BH = this.aUv.BH();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aUv.Cf().Dc().isRequestSuccess() && BH != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(BH);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aUt.Dc().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
            if (aeVar.xG() != null) {
                accountData.setTbs(aeVar.xG().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.aUv.Ci()) {
            switch (this.aUv.Cj()) {
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

    public byte[] BI() {
        if (!this.aUt.Db().mIsFromCDN) {
            this.aUt.Db().b(this.aUu);
        }
        return this.aUu.BI();
    }

    private void Cm() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> BG = this.aUu.BG();
        for (int i = 0; BG != null && i < BG.size(); i++) {
            BasicNameValuePair basicNameValuePair = BG.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aUu.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.ba(stringBuffer.toString()));
    }

    private String fC(int i) {
        String BK;
        com.baidu.tbadk.coreExtra.a.c ED;
        switch (i) {
            case 1:
                if (Cf().Db().mIsNeedAddCommenParam) {
                    this.aUt.Db().b(this.aUu);
                }
                Ch();
                BK = this.aUu.BJ();
                break;
            case 2:
                if (Cf().Db().mIsUseCurrentBDUSS) {
                    Cf().Db().a(this.aUu);
                }
                if (Cf().Db().mIsNeedAddCommenParam) {
                    this.aUt.Db().b(this.aUu);
                }
                Ch();
                BK = this.aUu.BH();
                break;
            case 3:
                if (Cf().Db().mIsUseCurrentBDUSS) {
                    Cf().Db().a(this.aUu);
                }
                if (Cf().Db().mIsNeedAddCommenParam) {
                    this.aUt.Db().b(this.aUu);
                }
                Cm();
                BK = this.aUu.BK();
                break;
            default:
                return null;
        }
        if (!this.aUt.Dc().Ci()) {
            aa.a(this.aUw);
            aa.fG(this.aUx);
            return BK;
        } else if (!this.aUt.Dc().isRequestSuccess()) {
            if (this.aUt.Dc().aWB == 1 && this.aUt.Db().aWy) {
                String str = this.aUt.Dc().mErrorString;
                this.aUt.Dc().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.wL();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    Cn();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cC(currentAccountObj.getAccount());
                if (ReloginManager.Bp().Bt()) {
                    AccountData Bs = ReloginManager.Bp().Bs();
                    if (Bs == null) {
                        ReloginManager.Bp().e(Bs);
                        return null;
                    }
                    return fD(i);
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (ED = com.baidu.tbadk.coreExtra.a.a.ED()) != null) {
                    ED.g(currentAccountObj);
                }
                if (e == null) {
                    if (this.aUv != null) {
                        this.aUt.Dc().mErrorString = this.aUv.getErrorString();
                        return null;
                    }
                    this.aUt.Dc().mErrorString = str;
                    return BK;
                }
                BK = fD(i);
            }
            com.baidu.tieba.h.a.a(this);
            return BK;
        } else {
            return BK;
        }
    }

    private String fD(int i) {
        String BK;
        Cg();
        switch (i) {
            case 1:
                BK = this.aUu.BJ();
                break;
            case 2:
                BK = this.aUu.BH();
                break;
            case 3:
                BK = this.aUu.BK();
                break;
            default:
                return null;
        }
        if (this.aUt.Dc().Ci()) {
            switch (this.aUt.Dc().aWB) {
                case 1:
                case 2:
                case 5:
                    Cn();
                    this.aUt.Dc().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return BK;
            }
        }
        return BK;
    }

    private void Cn() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String BH() {
        return fC(2);
    }

    public String BJ() {
        return fC(1);
    }

    public String BK() {
        return fC(3);
    }

    public String dR(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dA = k.dA(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dA.read(bArr2);
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
        return BK();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cf().Db().a(this.aUu);
        return this.aUu.a(str, handler, i, i2, i3, z);
    }
}
