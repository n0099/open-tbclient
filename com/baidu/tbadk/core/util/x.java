package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.StringU;
import com.baidu.tieba.e;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private boolean aAT;
    private com.baidu.tbadk.core.util.a.a aAQ = null;
    private q aAR = null;
    private x aAS = null;
    private aa.a aAU = null;
    private int aAV = 0;

    private void Di() {
        this.aAQ = new com.baidu.tbadk.core.util.a.a();
        this.aAR = z.Dt().a(this.aAQ);
        this.aAS = null;
        this.aAQ.Eh().Ek().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a Dj() {
        return this.aAQ;
    }

    public x() {
        Di();
    }

    public x(String str) {
        Di();
        this.aAQ.Eh().Ek().mUrl = str;
    }

    public void setUrl(String str) {
        this.aAQ.Eh().Ek().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.aAR.p(arrayList);
    }

    public void x(String str, String str2) {
        this.aAR.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aAR.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aAR.d(str, bArr);
    }

    private void Dk() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> CK = this.aAR.CK();
            int size = CK.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = CK.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    CK.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    CK.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void Dl() {
        if (this.aAU == null) {
            this.aAU = aa.Du();
        }
        if (this.aAU != null) {
            this.aAR.x("stTime", String.valueOf(this.aAU.mTime));
            this.aAR.x("stSize", String.valueOf(this.aAU.mSize));
            this.aAR.x("stTimesNum", String.valueOf(this.aAU.aBl));
            this.aAR.x("stMode", String.valueOf(this.aAU.mMode));
            this.aAR.x("stMethod", String.valueOf(this.aAU.aBk));
        }
        this.aAV = aa.dE(0);
        if (this.aAV == 0 && this.aAU != null) {
            this.aAV = this.aAU.aBl;
        }
        this.aAR.x("stErrorNums", String.valueOf(this.aAV));
    }

    public boolean Dm() {
        return this.aAQ.Ei().Dm();
    }

    public int Dn() {
        return this.aAQ.Ei().aDt;
    }

    public int Do() {
        return this.aAQ.Ei().De;
    }

    public String Dp() {
        return this.aAQ.Ei().aDu;
    }

    public String getErrorString() {
        return this.aAQ.Ei().mErrorString;
    }

    public void jg() {
        if (this.aAR != null) {
            this.aAR.jg();
        }
        if (this.aAS != null) {
            this.aAS.jg();
        }
    }

    public void jj() {
        if (this.aAR != null) {
            this.aAR.jj();
        }
        if (this.aAS != null) {
            this.aAS.jj();
        }
    }

    public void bs(boolean z) {
        this.aAT = z;
    }

    private com.baidu.tbadk.core.data.ae f(String str, String str2, boolean z) {
        String CL;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aAS == null) {
                this.aAS = new x(sb.toString());
            } else {
                this.aAS.jg();
            }
            this.aAS.Dj().Eh().mIsNeedAddCommenParam = false;
            this.aAS.Dj().Eh().mIsUseCurrentBDUSS = false;
            this.aAS.Dj().Eh().aDq = false;
            this.aAS.x("un", str);
            this.aAS.x("passwd", str2);
            this.aAS.x("isphone", "0");
            this.aAS.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aAS.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aAS.Dj().Eh().Ek().aDR = true;
            CL = this.aAS.CL();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aAS.Dj().Ei().isRequestSuccess() && CL != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(CL);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aAQ.Ei().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(e.j.neterror);
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
            if (aeVar.yE() != null) {
                accountData.setTbs(aeVar.yE().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.aAS.Dm()) {
            switch (this.aAS.Dn()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] CM() {
        if (!this.aAQ.Eh().mIsFromCDN) {
            this.aAQ.Eh().b(this.aAR);
        }
        return this.aAR.CM();
    }

    private void Dq() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> CK = this.aAR.CK();
        for (int i = 0; CK != null && i < CK.size(); i++) {
            BasicNameValuePair basicNameValuePair = CK.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + ETAG.EQUAL);
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aAR.x("sign", com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.aAQ.Eh().aAT) {
            this.aAR.x("sig", StringU.ji(stringBuffer.toString()));
        }
    }

    private String dB(int i) {
        String CO;
        this.aAQ.Eh().aAT = this.aAT && com.baidu.tbadk.p.s.jJ();
        switch (i) {
            case 1:
                if (Dj().Eh().mIsNeedAddCommenParam) {
                    this.aAQ.Eh().b(this.aAR);
                }
                Dl();
                CO = this.aAR.CN();
                break;
            case 2:
                if (Dj().Eh().mIsUseCurrentBDUSS) {
                    Dj().Eh().a(this.aAR);
                }
                if (Dj().Eh().mIsNeedAddCommenParam) {
                    this.aAQ.Eh().b(this.aAR);
                }
                Dl();
                CO = this.aAR.CL();
                break;
            case 3:
                if (Dj().Eh().mIsUseCurrentBDUSS) {
                    Dj().Eh().a(this.aAR);
                }
                if (Dj().Eh().mIsNeedAddCommenParam) {
                    this.aAQ.Eh().b(this.aAR);
                }
                Dq();
                CO = this.aAR.CO();
                break;
            default:
                return null;
        }
        if (!this.aAQ.Ei().Dm()) {
            aa.a(this.aAU);
            aa.dF(this.aAV);
            return CO;
        } else if (!this.aAQ.Ei().isRequestSuccess()) {
            if (this.aAQ.Ei().aDt == 1 && this.aAQ.Eh().aDq) {
                String str = this.aAQ.Ei().mErrorString;
                this.aAQ.Ei().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.xN();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    Dr();
                    return null;
                }
                com.baidu.tbadk.core.a.b.ed(currentAccountObj.getID());
                if (ReloginManager.Ct().Cw()) {
                    f(currentAccountObj);
                    ReloginManager.Ct().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae f = f(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (f == null) {
                    if (this.aAS != null) {
                        this.aAQ.Ei().mErrorString = this.aAS.getErrorString();
                        return null;
                    }
                    this.aAQ.Ei().mErrorString = str;
                    return CO;
                }
                CO = dC(i);
            }
            com.baidu.tieba.i.a.a(this);
            return CO;
        } else {
            return CO;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c FZ;
        if (!TextUtils.isEmpty(accountData.getID()) && (FZ = com.baidu.tbadk.coreExtra.a.a.FZ()) != null) {
            FZ.f(accountData);
        }
    }

    private String dC(int i) {
        String CO;
        Dk();
        switch (i) {
            case 1:
                CO = this.aAR.CN();
                break;
            case 2:
                CO = this.aAR.CL();
                break;
            case 3:
                CO = this.aAR.CO();
                break;
            default:
                return null;
        }
        if (this.aAQ.Ei().Dm()) {
            switch (this.aAQ.Ei().aDt) {
                case 1:
                case 2:
                case 5:
                    Dr();
                    this.aAQ.Ei().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return CO;
            }
        }
        return CO;
    }

    private void Dr() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String CL() {
        return dB(2);
    }

    public String CN() {
        return dB(1);
    }

    public String CO() {
        return dB(3);
    }

    public String fz(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream fk = l.fk(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = fk.read(bArr2);
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
        return CO();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Dj().Eh().a(this.aAR);
        return this.aAR.a(str, handler, i, i2, i3, z);
    }
}
