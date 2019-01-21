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
    private boolean aBw;
    private com.baidu.tbadk.core.util.a.a aBt = null;
    private q aBu = null;
    private x aBv = null;
    private aa.a aBx = null;
    private int aBy = 0;

    private void Dv() {
        this.aBt = new com.baidu.tbadk.core.util.a.a();
        this.aBu = z.DG().a(this.aBt);
        this.aBv = null;
        this.aBt.Eu().Ex().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a Dw() {
        return this.aBt;
    }

    public x() {
        Dv();
    }

    public x(String str) {
        Dv();
        this.aBt.Eu().Ex().mUrl = str;
    }

    public void setUrl(String str) {
        this.aBt.Eu().Ex().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.aBu.p(arrayList);
    }

    public void x(String str, String str2) {
        this.aBu.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aBu.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aBu.d(str, bArr);
    }

    private void Dx() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> CX = this.aBu.CX();
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
        if (this.aBx == null) {
            this.aBx = aa.DH();
        }
        if (this.aBx != null) {
            this.aBu.x("stTime", String.valueOf(this.aBx.mTime));
            this.aBu.x("stSize", String.valueOf(this.aBx.mSize));
            this.aBu.x("stTimesNum", String.valueOf(this.aBx.aBO));
            this.aBu.x("stMode", String.valueOf(this.aBx.mMode));
            this.aBu.x("stMethod", String.valueOf(this.aBx.aBN));
        }
        this.aBy = aa.dE(0);
        if (this.aBy == 0 && this.aBx != null) {
            this.aBy = this.aBx.aBO;
        }
        this.aBu.x("stErrorNums", String.valueOf(this.aBy));
    }

    public boolean Dz() {
        return this.aBt.Ev().Dz();
    }

    public int DA() {
        return this.aBt.Ev().aDX;
    }

    public int DB() {
        return this.aBt.Ev().De;
    }

    public String DC() {
        return this.aBt.Ev().aDY;
    }

    public String getErrorString() {
        return this.aBt.Ev().mErrorString;
    }

    public void jg() {
        if (this.aBu != null) {
            this.aBu.jg();
        }
        if (this.aBv != null) {
            this.aBv.jg();
        }
    }

    public void jj() {
        if (this.aBu != null) {
            this.aBu.jj();
        }
        if (this.aBv != null) {
            this.aBv.jj();
        }
    }

    public void bt(boolean z) {
        this.aBw = z;
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
            if (this.aBv == null) {
                this.aBv = new x(sb.toString());
            } else {
                this.aBv.jg();
            }
            this.aBv.Dw().Eu().mIsNeedAddCommenParam = false;
            this.aBv.Dw().Eu().mIsUseCurrentBDUSS = false;
            this.aBv.Dw().Eu().aDU = false;
            this.aBv.x("un", str);
            this.aBv.x("passwd", str2);
            this.aBv.x("isphone", "0");
            this.aBv.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.aBv.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.aBv.Dw().Eu().Ex().aEv = true;
            CY = this.aBv.CY();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aBv.Dw().Ev().isRequestSuccess() && CY != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(CY);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aBt.Ev().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(e.j.neterror);
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
        if (this.aBv.Dz()) {
            switch (this.aBv.DA()) {
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
        if (!this.aBt.Eu().mIsFromCDN) {
            this.aBt.Eu().b(this.aBu);
        }
        return this.aBu.CZ();
    }

    private void DD() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> CX = this.aBu.CX();
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
        this.aBu.x("sign", com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.aBt.Eu().aBw) {
            this.aBu.x("sig", StringU.jz(stringBuffer.toString()));
        }
    }

    private String dB(int i) {
        String Db;
        this.aBt.Eu().aBw = this.aBw && com.baidu.tbadk.p.s.jJ();
        switch (i) {
            case 1:
                if (Dw().Eu().mIsNeedAddCommenParam) {
                    this.aBt.Eu().b(this.aBu);
                }
                Dy();
                Db = this.aBu.Da();
                break;
            case 2:
                if (Dw().Eu().mIsUseCurrentBDUSS) {
                    Dw().Eu().a(this.aBu);
                }
                if (Dw().Eu().mIsNeedAddCommenParam) {
                    this.aBt.Eu().b(this.aBu);
                }
                Dy();
                Db = this.aBu.CY();
                break;
            case 3:
                if (Dw().Eu().mIsUseCurrentBDUSS) {
                    Dw().Eu().a(this.aBu);
                }
                if (Dw().Eu().mIsNeedAddCommenParam) {
                    this.aBt.Eu().b(this.aBu);
                }
                DD();
                Db = this.aBu.Db();
                break;
            default:
                return null;
        }
        if (!this.aBt.Ev().Dz()) {
            aa.a(this.aBx);
            aa.dF(this.aBy);
            return Db;
        } else if (!this.aBt.Ev().isRequestSuccess()) {
            if (this.aBt.Ev().aDX == 1 && this.aBt.Eu().aDU) {
                String str = this.aBt.Ev().mErrorString;
                this.aBt.Ev().mErrorString = "";
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
                    if (this.aBv != null) {
                        this.aBt.Ev().mErrorString = this.aBv.getErrorString();
                        return null;
                    }
                    this.aBt.Ev().mErrorString = str;
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
                Db = this.aBu.Da();
                break;
            case 2:
                Db = this.aBu.CY();
                break;
            case 3:
                Db = this.aBu.Db();
                break;
            default:
                return null;
        }
        if (this.aBt.Ev().Dz()) {
            switch (this.aBt.Ev().aDX) {
                case 1:
                case 2:
                case 5:
                    DE();
                    this.aBt.Ev().mErrorString = "";
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
        Dw().Eu().a(this.aBu);
        return this.aBu.a(str, handler, i, i2, i3, z);
    }
}
