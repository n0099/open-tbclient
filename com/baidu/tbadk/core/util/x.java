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
    private com.baidu.tbadk.core.util.a.a aUu = null;
    private q aUv = null;
    private x aUw = null;
    private aa.a aUx = null;
    private int aUy = 0;

    private void Cm() {
        this.aUu = new com.baidu.tbadk.core.util.a.a();
        this.aUv = z.Cx().a(this.aUu);
        this.aUw = null;
        this.aUu.Dk().Dn().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a Cn() {
        return this.aUu;
    }

    public x() {
        Cm();
    }

    public x(String str) {
        Cm();
        this.aUu.Dk().Dn().mUrl = str;
    }

    public void setUrl(String str) {
        this.aUu.Dk().Dn().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.aUv.m(arrayList);
    }

    public void n(String str, String str2) {
        this.aUv.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aUv.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aUv.d(str, bArr);
    }

    private void Co() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> BO = this.aUv.BO();
            int size = BO.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = BO.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    BO.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    BO.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void Cp() {
        if (this.aUx == null) {
            this.aUx = aa.Cy();
        }
        if (this.aUx != null) {
            this.aUv.n("stTime", String.valueOf(this.aUx.mTime));
            this.aUv.n("stSize", String.valueOf(this.aUx.aUO));
            this.aUv.n("stTimesNum", String.valueOf(this.aUx.aUP));
            this.aUv.n("stMode", String.valueOf(this.aUx.mMode));
            this.aUv.n("stMethod", String.valueOf(this.aUx.aUN));
        }
        this.aUy = aa.fH(0);
        if (this.aUy == 0 && this.aUx != null) {
            this.aUy = this.aUx.aUP;
        }
        this.aUv.n("stErrorNums", String.valueOf(this.aUy));
    }

    public boolean Cq() {
        return this.aUu.Dl().Cq();
    }

    public int Cr() {
        return this.aUu.Dl().aWC;
    }

    public int Cs() {
        return this.aUu.Dl().ajA;
    }

    public String Ct() {
        return this.aUu.Dl().aWD;
    }

    public String getErrorString() {
        return this.aUu.Dl().mErrorString;
    }

    public void mR() {
        if (this.aUv != null) {
            this.aUv.mR();
        }
        if (this.aUw != null) {
            this.aUw.mR();
        }
    }

    public void mU() {
        if (this.aUv != null) {
            this.aUv.mU();
        }
        if (this.aUw != null) {
            this.aUw.mU();
        }
    }

    private com.baidu.tbadk.core.data.af e(String str, String str2, boolean z) {
        String BP;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aUw == null) {
                this.aUw = new x(sb.toString());
            } else {
                this.aUw.mR();
            }
            this.aUw.Cn().Dk().mIsNeedAddCommenParam = false;
            this.aUw.Cn().Dk().mIsUseCurrentBDUSS = false;
            this.aUw.Cn().Dk().aWz = false;
            this.aUw.n("un", str);
            this.aUw.n("passwd", str2);
            this.aUw.n("isphone", "0");
            this.aUw.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aUw.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aUw.Cn().Dk().Dn().aXa = true;
            BP = this.aUw.BP();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aUw.Cn().Dl().isRequestSuccess() && BP != null) {
            com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
            afVar.parserJson(BP);
            String userId = afVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aUu.Dl().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(afVar.getUser().getUserName());
            if (afVar.getUser().getPassword() != null) {
                accountData.setPassword(afVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(afVar.getUser().getUserId());
            accountData.setBDUSS(afVar.getUser().getBDUSS());
            accountData.setPortrait(afVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (afVar.xJ() != null) {
                accountData.setTbs(afVar.xJ().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return afVar;
        }
        if (this.aUw.Cq()) {
            switch (this.aUw.Cr()) {
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

    public byte[] BQ() {
        if (!this.aUu.Dk().mIsFromCDN) {
            this.aUu.Dk().b(this.aUv);
        }
        return this.aUv.BQ();
    }

    private void Cu() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> BO = this.aUv.BO();
        for (int i = 0; BO != null && i < BO.size(); i++) {
            BasicNameValuePair basicNameValuePair = BO.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aUv.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.ba(stringBuffer.toString()));
    }

    private String fE(int i) {
        String BS;
        com.baidu.tbadk.coreExtra.a.c EM;
        switch (i) {
            case 1:
                if (Cn().Dk().mIsNeedAddCommenParam) {
                    this.aUu.Dk().b(this.aUv);
                }
                Cp();
                BS = this.aUv.BR();
                break;
            case 2:
                if (Cn().Dk().mIsUseCurrentBDUSS) {
                    Cn().Dk().a(this.aUv);
                }
                if (Cn().Dk().mIsNeedAddCommenParam) {
                    this.aUu.Dk().b(this.aUv);
                }
                Cp();
                BS = this.aUv.BP();
                break;
            case 3:
                if (Cn().Dk().mIsUseCurrentBDUSS) {
                    Cn().Dk().a(this.aUv);
                }
                if (Cn().Dk().mIsNeedAddCommenParam) {
                    this.aUu.Dk().b(this.aUv);
                }
                Cu();
                BS = this.aUv.BS();
                break;
            default:
                return null;
        }
        if (!this.aUu.Dl().Cq()) {
            aa.a(this.aUx);
            aa.fI(this.aUy);
            return BS;
        } else if (!this.aUu.Dl().isRequestSuccess()) {
            if (this.aUu.Dl().aWC == 1 && this.aUu.Dk().aWz) {
                String str = this.aUu.Dl().mErrorString;
                this.aUu.Dl().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.wM();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    Cv();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cC(currentAccountObj.getAccount());
                if (ReloginManager.Bx().BB()) {
                    AccountData BA = ReloginManager.Bx().BA();
                    if (BA == null) {
                        ReloginManager.Bx().e(BA);
                        return null;
                    }
                    return fF(i);
                }
                com.baidu.tbadk.core.data.af e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (EM = com.baidu.tbadk.coreExtra.a.a.EM()) != null) {
                    EM.g(currentAccountObj);
                }
                if (e == null) {
                    if (this.aUw != null) {
                        this.aUu.Dl().mErrorString = this.aUw.getErrorString();
                        return null;
                    }
                    this.aUu.Dl().mErrorString = str;
                    return BS;
                }
                BS = fF(i);
            }
            com.baidu.tieba.h.a.a(this);
            return BS;
        } else {
            return BS;
        }
    }

    private String fF(int i) {
        String BS;
        Co();
        switch (i) {
            case 1:
                BS = this.aUv.BR();
                break;
            case 2:
                BS = this.aUv.BP();
                break;
            case 3:
                BS = this.aUv.BS();
                break;
            default:
                return null;
        }
        if (this.aUu.Dl().Cq()) {
            switch (this.aUu.Dl().aWC) {
                case 1:
                case 2:
                case 5:
                    Cv();
                    this.aUu.Dl().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return BS;
            }
        }
        return BS;
    }

    private void Cv() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String BP() {
        return fE(2);
    }

    public String BR() {
        return fE(1);
    }

    public String BS() {
        return fE(3);
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
        return BS();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cn().Dk().a(this.aUv);
        return this.aUv.a(str, handler, i, i2, i3, z);
    }
}
