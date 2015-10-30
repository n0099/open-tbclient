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
    private com.baidu.tbadk.core.util.a.a ZT = null;
    private q ZU = null;
    private w ZV = null;
    private aa.a ZW = null;
    private int ZX = 0;

    private void ud() {
        this.ZT = new com.baidu.tbadk.core.util.a.a();
        this.ZU = z.um().a(this.ZT);
        this.ZV = null;
        this.ZT.uV().uY().mNetType = com.baidu.tbadk.core.util.a.i.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a ue() {
        return this.ZT;
    }

    public w() {
        ud();
    }

    public w(String str) {
        ud();
        this.ZT.uV().uY().mUrl = str;
    }

    public void setUrl(String str) {
        this.ZT.uV().uY().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.ZU.l(arrayList);
    }

    public void o(String str, String str2) {
        this.ZU.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.ZU.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.ZU.d(str, bArr);
    }

    private void uf() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tC = this.ZU.tC();
            int size = tC.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = tC.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    tC.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    tC.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void ug() {
        if (this.ZW == null) {
            this.ZW = aa.un();
        }
        if (this.ZW != null) {
            this.ZU.o("stTime", String.valueOf(this.ZW.mTime));
            this.ZU.o("stSize", String.valueOf(this.ZW.mSize));
            this.ZU.o("stTimesNum", String.valueOf(this.ZW.aao));
            this.ZU.o("stMode", String.valueOf(this.ZW.mMode));
            this.ZU.o("stMethod", String.valueOf(this.ZW.aan));
        }
        this.ZX = aa.cn(0);
        if (this.ZX == 0 && this.ZW != null) {
            this.ZX = this.ZW.aao;
        }
        this.ZU.o("stErrorNums", String.valueOf(this.ZX));
    }

    public boolean uh() {
        return this.ZT.uW().uh();
    }

    public int ui() {
        return this.ZT.uW().abS;
    }

    public int uj() {
        return this.ZT.uW().abR;
    }

    public String getErrorString() {
        return this.ZT.uW().mErrorString;
    }

    public void gJ() {
        if (this.ZU != null) {
            this.ZU.gJ();
        }
        if (this.ZV != null) {
            this.ZV.gJ();
        }
    }

    private com.baidu.tbadk.core.data.l d(String str, String str2, boolean z) {
        String tD;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.ZV == null) {
                this.ZV = new w(sb.toString());
            } else {
                this.ZV.gJ();
            }
            this.ZV.ue().uV().mIsNeedAddCommenParam = false;
            this.ZV.ue().uV().mIsUseCurrentBDUSS = false;
            this.ZV.ue().uV().abO = false;
            this.ZV.o("un", str);
            this.ZV.o("passwd", str2);
            this.ZV.o("isphone", "0");
            this.ZV.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.ZV.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.ZV.ue().uV().uY().acl = true;
            tD = this.ZV.tD();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ZV.ue().uW().qS() && tD != null) {
            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
            lVar.parserJson(tD);
            String userId = lVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ZT.uW().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.h.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(lVar.getUser().getUserName());
            if (lVar.getUser().getPassword() != null) {
                accountData.setPassword(lVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(lVar.getUser().getUserId());
            accountData.setBDUSS(lVar.getUser().getBDUSS());
            accountData.setPortrait(lVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (lVar.rC() != null) {
                accountData.setTbs(lVar.rC().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return lVar;
        }
        if (this.ZV.uh()) {
            switch (this.ZV.ui()) {
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

    public byte[] tE() {
        if (!this.ZT.uV().mIsFromCDN) {
            this.ZT.uV().b(this.ZU);
        }
        return this.ZU.tE();
    }

    private void uk() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tC = this.ZU.tC();
        for (int i = 0; tC != null && i < tC.size(); i++) {
            BasicNameValuePair basicNameValuePair = tC.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.ZU.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String ck(int i) {
        String tG;
        com.baidu.tbadk.coreExtra.a.c vU;
        switch (i) {
            case 1:
                if (ue().uV().mIsNeedAddCommenParam) {
                    this.ZT.uV().b(this.ZU);
                }
                ug();
                tG = this.ZU.tF();
                break;
            case 2:
                if (ue().uV().mIsUseCurrentBDUSS) {
                    ue().uV().a(this.ZU);
                }
                if (ue().uV().mIsNeedAddCommenParam) {
                    this.ZT.uV().b(this.ZU);
                }
                ug();
                tG = this.ZU.tD();
                break;
            case 3:
                if (ue().uV().mIsUseCurrentBDUSS) {
                    ue().uV().a(this.ZU);
                }
                if (ue().uV().mIsNeedAddCommenParam) {
                    this.ZT.uV().b(this.ZU);
                }
                uk();
                tG = this.ZU.tG();
                break;
            default:
                return null;
        }
        if (!this.ZT.uW().uh()) {
            aa.a(this.ZW);
            aa.co(this.ZX);
            return tG;
        } else if (!this.ZT.uW().qS() && this.ZT.uW().abS == 1 && this.ZT.uV().abO) {
            String str = this.ZT.uW().mErrorString;
            this.ZT.uW().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.re();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.ce(currentAccountObj.getAccount());
            if (ReloginManager.tm().tq()) {
                AccountData tp = ReloginManager.tm().tp();
                if (tp == null) {
                    ReloginManager.tm().e(tp);
                    return null;
                }
                return cl(i);
            }
            com.baidu.tbadk.core.data.l d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (vU = com.baidu.tbadk.coreExtra.a.a.vU()) != null) {
                vU.g(currentAccountObj);
            }
            if (d == null) {
                if (this.ZV != null) {
                    this.ZT.uW().mErrorString = this.ZV.getErrorString();
                    return null;
                }
                this.ZT.uW().mErrorString = str;
                return tG;
            }
            return cl(i);
        } else {
            return tG;
        }
    }

    private String cl(int i) {
        String tG;
        uf();
        switch (i) {
            case 1:
                tG = this.ZU.tF();
                break;
            case 2:
                tG = this.ZU.tD();
                break;
            case 3:
                tG = this.ZU.tG();
                break;
            default:
                return null;
        }
        if (this.ZT.uW().uh()) {
            switch (this.ZT.uW().abS) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.ZT.uW().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return tG;
            }
        }
        return tG;
    }

    public String tD() {
        return ck(2);
    }

    public String tF() {
        return ck(1);
    }

    public String tG() {
        return ck(3);
    }

    public String de(String str) {
        byte[] bArr;
        try {
            InputStream cP = n.cP(str);
            byte[] bArr2 = new byte[a0.O];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a0.O);
            while (true) {
                int read = cP.read(bArr2);
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
        return tG();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        ue().uV().a(this.ZU);
        return this.ZU.a(str, handler, i, i2, i3, z);
    }
}
