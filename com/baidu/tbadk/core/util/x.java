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
    private boolean aBv;
    private com.baidu.tbadk.core.util.a.a aBs = null;
    private q aBt = null;
    private x aBu = null;
    private aa.a aBw = null;
    private int aBx = 0;

    private void Dv() {
        this.aBs = new com.baidu.tbadk.core.util.a.a();
        this.aBt = z.DG().a(this.aBs);
        this.aBu = null;
        this.aBs.Eu().Ex().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a Dw() {
        return this.aBs;
    }

    public x() {
        Dv();
    }

    public x(String str) {
        Dv();
        this.aBs.Eu().Ex().mUrl = str;
    }

    public void setUrl(String str) {
        this.aBs.Eu().Ex().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.aBt.p(arrayList);
    }

    public void x(String str, String str2) {
        this.aBt.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aBt.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aBt.d(str, bArr);
    }

    private void Dx() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> CX = this.aBt.CX();
            int size = CX.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = CX.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    CX.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    CX.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void Dy() {
        if (this.aBw == null) {
            this.aBw = aa.DH();
        }
        if (this.aBw != null) {
            this.aBt.x("stTime", String.valueOf(this.aBw.mTime));
            this.aBt.x("stSize", String.valueOf(this.aBw.mSize));
            this.aBt.x("stTimesNum", String.valueOf(this.aBw.aBN));
            this.aBt.x("stMode", String.valueOf(this.aBw.mMode));
            this.aBt.x("stMethod", String.valueOf(this.aBw.aBM));
        }
        this.aBx = aa.dE(0);
        if (this.aBx == 0 && this.aBw != null) {
            this.aBx = this.aBw.aBN;
        }
        this.aBt.x("stErrorNums", String.valueOf(this.aBx));
    }

    public boolean Dz() {
        return this.aBs.Ev().Dz();
    }

    public int DA() {
        return this.aBs.Ev().aDW;
    }

    public int DB() {
        return this.aBs.Ev().De;
    }

    public String DC() {
        return this.aBs.Ev().aDX;
    }

    public String getErrorString() {
        return this.aBs.Ev().mErrorString;
    }

    public void jg() {
        if (this.aBt != null) {
            this.aBt.jg();
        }
        if (this.aBu != null) {
            this.aBu.jg();
        }
    }

    public void jj() {
        if (this.aBt != null) {
            this.aBt.jj();
        }
        if (this.aBu != null) {
            this.aBu.jj();
        }
    }

    public void bt(boolean z) {
        this.aBv = z;
    }

    private com.baidu.tbadk.core.data.ae f(String str, String str2, boolean z) {
        String CY;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aBu == null) {
                this.aBu = new x(sb.toString());
            } else {
                this.aBu.jg();
            }
            this.aBu.Dw().Eu().mIsNeedAddCommenParam = false;
            this.aBu.Dw().Eu().mIsUseCurrentBDUSS = false;
            this.aBu.Dw().Eu().aDT = false;
            this.aBu.x("un", str);
            this.aBu.x("passwd", str2);
            this.aBu.x("isphone", "0");
            this.aBu.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aBu.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aBu.Dw().Eu().Ex().aEu = true;
            CY = this.aBu.CY();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aBu.Dw().Ev().isRequestSuccess() && CY != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(CY);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aBs.Ev().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(e.j.neterror);
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
            if (aeVar.yR() != null) {
                accountData.setTbs(aeVar.yR().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.aBu.Dz()) {
            switch (this.aBu.DA()) {
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

    public byte[] CZ() {
        if (!this.aBs.Eu().mIsFromCDN) {
            this.aBs.Eu().b(this.aBt);
        }
        return this.aBt.CZ();
    }

    private void DD() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> CX = this.aBt.CX();
        for (int i = 0; CX != null && i < CX.size(); i++) {
            BasicNameValuePair basicNameValuePair = CX.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + ETAG.EQUAL);
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aBt.x("sign", com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.aBs.Eu().aBv) {
            this.aBt.x("sig", StringU.jz(stringBuffer.toString()));
        }
    }

    private String dB(int i) {
        String Db;
        this.aBs.Eu().aBv = this.aBv && com.baidu.tbadk.p.s.jJ();
        switch (i) {
            case 1:
                if (Dw().Eu().mIsNeedAddCommenParam) {
                    this.aBs.Eu().b(this.aBt);
                }
                Dy();
                Db = this.aBt.Da();
                break;
            case 2:
                if (Dw().Eu().mIsUseCurrentBDUSS) {
                    Dw().Eu().a(this.aBt);
                }
                if (Dw().Eu().mIsNeedAddCommenParam) {
                    this.aBs.Eu().b(this.aBt);
                }
                Dy();
                Db = this.aBt.CY();
                break;
            case 3:
                if (Dw().Eu().mIsUseCurrentBDUSS) {
                    Dw().Eu().a(this.aBt);
                }
                if (Dw().Eu().mIsNeedAddCommenParam) {
                    this.aBs.Eu().b(this.aBt);
                }
                DD();
                Db = this.aBt.Db();
                break;
            default:
                return null;
        }
        if (!this.aBs.Ev().Dz()) {
            aa.a(this.aBw);
            aa.dF(this.aBx);
            return Db;
        } else if (!this.aBs.Ev().isRequestSuccess()) {
            if (this.aBs.Ev().aDW == 1 && this.aBs.Eu().aDT) {
                String str = this.aBs.Ev().mErrorString;
                this.aBs.Ev().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.ya();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    DE();
                    return null;
                }
                com.baidu.tbadk.core.a.b.em(currentAccountObj.getID());
                if (ReloginManager.CG().CJ()) {
                    f(currentAccountObj);
                    ReloginManager.CG().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae f = f(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (f == null) {
                    if (this.aBu != null) {
                        this.aBs.Ev().mErrorString = this.aBu.getErrorString();
                        return null;
                    }
                    this.aBs.Ev().mErrorString = str;
                    return Db;
                }
                Db = dC(i);
            }
            com.baidu.tieba.i.a.a(this);
            return Db;
        } else {
            return Db;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c Gn;
        if (!TextUtils.isEmpty(accountData.getID()) && (Gn = com.baidu.tbadk.coreExtra.a.a.Gn()) != null) {
            Gn.f(accountData);
        }
    }

    private String dC(int i) {
        String Db;
        Dx();
        switch (i) {
            case 1:
                Db = this.aBt.Da();
                break;
            case 2:
                Db = this.aBt.CY();
                break;
            case 3:
                Db = this.aBt.Db();
                break;
            default:
                return null;
        }
        if (this.aBs.Ev().Dz()) {
            switch (this.aBs.Ev().aDW) {
                case 1:
                case 2:
                case 5:
                    DE();
                    this.aBs.Ev().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return Db;
            }
        }
        return Db;
    }

    private void DE() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String CY() {
        return dB(2);
    }

    public String Da() {
        return dB(1);
    }

    public String Db() {
        return dB(3);
    }

    public String fM(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream fu = l.fu(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = fu.read(bArr2);
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
        return Db();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Dw().Eu().a(this.aBt);
        return this.aBt.a(str, handler, i, i2, i3, z);
    }
}
