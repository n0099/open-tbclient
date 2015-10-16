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

    private void ug() {
        this.ZT = new com.baidu.tbadk.core.util.a.a();
        this.ZU = z.up().a(this.ZT);
        this.ZV = null;
        this.ZT.uY().vb().mNetType = com.baidu.tbadk.core.util.a.i.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uh() {
        return this.ZT;
    }

    public w() {
        ug();
    }

    public w(String str) {
        ug();
        this.ZT.uY().vb().mUrl = str;
    }

    public void setUrl(String str) {
        this.ZT.uY().vb().mUrl = str;
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

    private void ui() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tF = this.ZU.tF();
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
        if (this.ZW == null) {
            this.ZW = aa.uq();
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

    public boolean uk() {
        return this.ZT.uZ().uk();
    }

    public int ul() {
        return this.ZT.uZ().abS;
    }

    public int um() {
        return this.ZT.uZ().abR;
    }

    public String getErrorString() {
        return this.ZT.uZ().mErrorString;
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
        String tG;
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
            this.ZV.uh().uY().mIsNeedAddCommenParam = false;
            this.ZV.uh().uY().mIsUseCurrentBDUSS = false;
            this.ZV.uh().uY().abO = false;
            this.ZV.o("un", str);
            this.ZV.o("passwd", str2);
            this.ZV.o("isphone", "0");
            this.ZV.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.ZV.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.ZV.uh().uY().vb().acl = true;
            tG = this.ZV.tG();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ZV.uh().uZ().qV() && tG != null) {
            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
            lVar.parserJson(tG);
            String userId = lVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ZT.uZ().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.h.neterror);
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
            if (lVar.rF() != null) {
                accountData.setTbs(lVar.rF().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return lVar;
        }
        if (this.ZV.uk()) {
            switch (this.ZV.ul()) {
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
        if (!this.ZT.uY().mIsFromCDN) {
            this.ZT.uY().b(this.ZU);
        }
        return this.ZU.tH();
    }

    private void un() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tF = this.ZU.tF();
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
        this.ZU.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String ck(int i) {
        String tJ;
        com.baidu.tbadk.coreExtra.a.c vX;
        switch (i) {
            case 1:
                if (uh().uY().mIsNeedAddCommenParam) {
                    this.ZT.uY().b(this.ZU);
                }
                uj();
                tJ = this.ZU.tI();
                break;
            case 2:
                if (uh().uY().mIsUseCurrentBDUSS) {
                    uh().uY().a(this.ZU);
                }
                if (uh().uY().mIsNeedAddCommenParam) {
                    this.ZT.uY().b(this.ZU);
                }
                uj();
                tJ = this.ZU.tG();
                break;
            case 3:
                if (uh().uY().mIsUseCurrentBDUSS) {
                    uh().uY().a(this.ZU);
                }
                if (uh().uY().mIsNeedAddCommenParam) {
                    this.ZT.uY().b(this.ZU);
                }
                un();
                tJ = this.ZU.tJ();
                break;
            default:
                return null;
        }
        if (!this.ZT.uZ().uk()) {
            aa.a(this.ZW);
            aa.co(this.ZX);
            return tJ;
        } else if (!this.ZT.uZ().qV() && this.ZT.uZ().abS == 1 && this.ZT.uY().abO) {
            String str = this.ZT.uZ().mErrorString;
            this.ZT.uZ().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rh();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.ce(currentAccountObj.getAccount());
            if (ReloginManager.tp().tt()) {
                AccountData ts = ReloginManager.tp().ts();
                if (ts == null) {
                    ReloginManager.tp().e(ts);
                    return null;
                }
                return cl(i);
            }
            com.baidu.tbadk.core.data.l d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (vX = com.baidu.tbadk.coreExtra.a.a.vX()) != null) {
                vX.g(currentAccountObj);
            }
            if (d == null) {
                if (this.ZV != null) {
                    this.ZT.uZ().mErrorString = this.ZV.getErrorString();
                    return null;
                }
                this.ZT.uZ().mErrorString = str;
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
                tJ = this.ZU.tI();
                break;
            case 2:
                tJ = this.ZU.tG();
                break;
            case 3:
                tJ = this.ZU.tJ();
                break;
            default:
                return null;
        }
        if (this.ZT.uZ().uk()) {
            switch (this.ZT.uZ().abS) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.ZT.uZ().mErrorString = "";
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
        return tJ();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uh().uY().a(this.ZU);
        return this.ZU.a(str, handler, i, i2, i3, z);
    }
}
