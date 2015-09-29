package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.a0;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.i;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class w {
    private com.baidu.tbadk.core.util.a.a ZR = null;
    private q ZS = null;
    private w ZT = null;
    private aa.a ZU = null;
    private int ZV = 0;

    private void ug() {
        this.ZR = new com.baidu.tbadk.core.util.a.a();
        this.ZS = z.up().a(this.ZR);
        this.ZT = null;
        this.ZR.uX().va().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uh() {
        return this.ZR;
    }

    public w() {
        ug();
    }

    public w(String str) {
        ug();
        this.ZR.uX().va().mUrl = str;
    }

    public void setUrl(String str) {
        this.ZR.uX().va().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.ZS.l(arrayList);
    }

    public void o(String str, String str2) {
        this.ZS.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.ZS.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.ZS.d(str, bArr);
    }

    private void ui() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tF = this.ZS.tF();
            int size = tF.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = tF.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    tF.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    tF.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uj() {
        if (this.ZU == null) {
            this.ZU = aa.uq();
        }
        if (this.ZU != null) {
            this.ZS.o("stTime", String.valueOf(this.ZU.mTime));
            this.ZS.o("stSize", String.valueOf(this.ZU.mSize));
            this.ZS.o("stTimesNum", String.valueOf(this.ZU.aam));
            this.ZS.o("stMode", String.valueOf(this.ZU.mMode));
            this.ZS.o("stMethod", String.valueOf(this.ZU.aal));
        }
        this.ZV = aa.cn(0);
        if (this.ZV == 0 && this.ZU != null) {
            this.ZV = this.ZU.aam;
        }
        this.ZS.o("stErrorNums", String.valueOf(this.ZV));
    }

    public boolean uk() {
        return this.ZR.uY().uk();
    }

    public int ul() {
        return this.ZR.uY().abP;
    }

    public int um() {
        return this.ZR.uY().abO;
    }

    public String getErrorString() {
        return this.ZR.uY().mErrorString;
    }

    public void gJ() {
        if (this.ZS != null) {
            this.ZS.gJ();
        }
        if (this.ZT != null) {
            this.ZT.gJ();
        }
    }

    private com.baidu.tbadk.core.data.k d(String str, String str2, boolean z) {
        String tG;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.ZT == null) {
                this.ZT = new w(sb.toString());
            } else {
                this.ZT.gJ();
            }
            this.ZT.uh().uX().mIsNeedAddCommenParam = false;
            this.ZT.uh().uX().mIsUseCurrentBDUSS = false;
            this.ZT.uh().uX().abL = false;
            this.ZT.o("un", str);
            this.ZT.o("passwd", str2);
            this.ZT.o("isphone", "0");
            this.ZT.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.ZT.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.ZT.uh().uX().va().ack = true;
            tG = this.ZT.tG();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ZT.uh().uY().qV() && tG != null) {
            com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
            kVar.parserJson(tG);
            String userId = kVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ZR.uY().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.h.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(kVar.getUser().getUserName());
            if (kVar.getUser().getPassword() != null) {
                accountData.setPassword(kVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(kVar.getUser().getUserId());
            accountData.setBDUSS(kVar.getUser().getBDUSS());
            accountData.setPortrait(kVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (kVar.rF() != null) {
                accountData.setTbs(kVar.rF().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return kVar;
        }
        if (this.ZT.uk()) {
            switch (this.ZT.ul()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m411getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m411getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] tH() {
        if (!this.ZR.uX().mIsFromCDN) {
            this.ZR.uX().b(this.ZS);
        }
        return this.ZS.tH();
    }

    private void un() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tF = this.ZS.tF();
        for (int i = 0; tF != null && i < tF.size(); i++) {
            BasicNameValuePair basicNameValuePair = tF.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.ZS.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String ck(int i) {
        String tJ;
        com.baidu.tbadk.coreExtra.a.c vX;
        switch (i) {
            case 1:
                if (uh().uX().mIsNeedAddCommenParam) {
                    this.ZR.uX().b(this.ZS);
                }
                uj();
                tJ = this.ZS.tI();
                break;
            case 2:
                if (uh().uX().mIsUseCurrentBDUSS) {
                    uh().uX().a(this.ZS);
                }
                if (uh().uX().mIsNeedAddCommenParam) {
                    this.ZR.uX().b(this.ZS);
                }
                uj();
                tJ = this.ZS.tG();
                break;
            case 3:
                if (uh().uX().mIsUseCurrentBDUSS) {
                    uh().uX().a(this.ZS);
                }
                if (uh().uX().mIsNeedAddCommenParam) {
                    this.ZR.uX().b(this.ZS);
                }
                un();
                tJ = this.ZS.tJ();
                break;
            default:
                return null;
        }
        if (!this.ZR.uY().uk()) {
            aa.a(this.ZU);
            aa.co(this.ZV);
            return tJ;
        } else if (!this.ZR.uY().qV() && this.ZR.uY().abP == 1 && this.ZR.uX().abL) {
            String str = this.ZR.uY().mErrorString;
            this.ZR.uY().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rh();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cd(currentAccountObj.getAccount());
            if (ReloginManager.tp().tt()) {
                AccountData ts = ReloginManager.tp().ts();
                if (ts == null) {
                    ReloginManager.tp().e(ts);
                    return null;
                }
                return cl(i);
            }
            com.baidu.tbadk.core.data.k d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (vX = com.baidu.tbadk.coreExtra.a.a.vX()) != null) {
                vX.g(currentAccountObj);
            }
            if (d == null) {
                if (this.ZT != null) {
                    this.ZR.uY().mErrorString = this.ZT.getErrorString();
                    return null;
                }
                this.ZR.uY().mErrorString = str;
                return tJ;
            }
            return cl(i);
        } else {
            return tJ;
        }
    }

    private String cl(int i) {
        String tJ;
        ui();
        switch (i) {
            case 1:
                tJ = this.ZS.tI();
                break;
            case 2:
                tJ = this.ZS.tG();
                break;
            case 3:
                tJ = this.ZS.tJ();
                break;
            default:
                return null;
        }
        if (this.ZR.uY().uk()) {
            switch (this.ZR.uY().abP) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.ZR.uY().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return tJ;
            }
        }
        return tJ;
    }

    public String tG() {
        return ck(2);
    }

    public String tI() {
        return ck(1);
    }

    public String tJ() {
        return ck(3);
    }

    public String dd(String str) {
        byte[] bArr;
        try {
            InputStream cO = n.cO(str);
            byte[] bArr2 = new byte[a0.O];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a0.O);
            while (true) {
                int read = cO.read(bArr2);
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
        return tJ();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uh().uX().a(this.ZS);
        return this.ZS.a(str, handler, i, i2, i3, z);
    }
}
