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
    private com.baidu.tbadk.core.util.a.a ZX = null;
    private q ZY = null;
    private w ZZ = null;
    private aa.a aaa = null;
    private int aab = 0;

    private void ug() {
        this.ZX = new com.baidu.tbadk.core.util.a.a();
        this.ZY = z.up().a(this.ZX);
        this.ZZ = null;
        this.ZX.uZ().vc().mNetType = com.baidu.tbadk.core.util.a.i.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uh() {
        return this.ZX;
    }

    public w() {
        ug();
    }

    public w(String str) {
        ug();
        this.ZX.uZ().vc().mUrl = str;
    }

    public void setUrl(String str) {
        this.ZX.uZ().vc().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.ZY.l(arrayList);
    }

    public void o(String str, String str2) {
        this.ZY.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.ZY.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.ZY.d(str, bArr);
    }

    private void ui() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tF = this.ZY.tF();
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
        if (this.aaa == null) {
            this.aaa = aa.uq();
        }
        if (this.aaa != null) {
            this.ZY.o("stTime", String.valueOf(this.aaa.mTime));
            this.ZY.o("stSize", String.valueOf(this.aaa.mSize));
            this.ZY.o("stTimesNum", String.valueOf(this.aaa.aas));
            this.ZY.o("stMode", String.valueOf(this.aaa.mMode));
            this.ZY.o("stMethod", String.valueOf(this.aaa.aar));
        }
        this.aab = aa.cn(0);
        if (this.aab == 0 && this.aaa != null) {
            this.aab = this.aaa.aas;
        }
        this.ZY.o("stErrorNums", String.valueOf(this.aab));
    }

    public boolean uk() {
        return this.ZX.va().uk();
    }

    public int ul() {
        return this.ZX.va().abX;
    }

    public int um() {
        return this.ZX.va().abW;
    }

    public String getErrorString() {
        return this.ZX.va().mErrorString;
    }

    public void gJ() {
        if (this.ZY != null) {
            this.ZY.gJ();
        }
        if (this.ZZ != null) {
            this.ZZ.gJ();
        }
    }

    public void gM() {
        if (this.ZY != null) {
            this.ZY.gM();
        }
        if (this.ZZ != null) {
            this.ZZ.gM();
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
            if (this.ZZ == null) {
                this.ZZ = new w(sb.toString());
            } else {
                this.ZZ.gJ();
            }
            this.ZZ.uh().uZ().mIsNeedAddCommenParam = false;
            this.ZZ.uh().uZ().mIsUseCurrentBDUSS = false;
            this.ZZ.uh().uZ().abT = false;
            this.ZZ.o("un", str);
            this.ZZ.o("passwd", str2);
            this.ZZ.o("isphone", "0");
            this.ZZ.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.ZZ.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.ZZ.uh().uZ().vc().acq = true;
            tG = this.ZZ.tG();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ZZ.uh().va().qT() && tG != null) {
            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
            lVar.parserJson(tG);
            String userId = lVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ZX.va().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.h.neterror);
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
            if (lVar.rE() != null) {
                accountData.setTbs(lVar.rE().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return lVar;
        }
        if (this.ZZ.uk()) {
            switch (this.ZZ.ul()) {
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
        if (!this.ZX.uZ().mIsFromCDN) {
            this.ZX.uZ().b(this.ZY);
        }
        return this.ZY.tH();
    }

    private void un() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tF = this.ZY.tF();
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
        this.ZY.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String ck(int i) {
        String tJ;
        com.baidu.tbadk.coreExtra.a.c vY;
        switch (i) {
            case 1:
                if (uh().uZ().mIsNeedAddCommenParam) {
                    this.ZX.uZ().b(this.ZY);
                }
                uj();
                tJ = this.ZY.tI();
                break;
            case 2:
                if (uh().uZ().mIsUseCurrentBDUSS) {
                    uh().uZ().a(this.ZY);
                }
                if (uh().uZ().mIsNeedAddCommenParam) {
                    this.ZX.uZ().b(this.ZY);
                }
                uj();
                tJ = this.ZY.tG();
                break;
            case 3:
                if (uh().uZ().mIsUseCurrentBDUSS) {
                    uh().uZ().a(this.ZY);
                }
                if (uh().uZ().mIsNeedAddCommenParam) {
                    this.ZX.uZ().b(this.ZY);
                }
                un();
                tJ = this.ZY.tJ();
                break;
            default:
                return null;
        }
        if (!this.ZX.va().uk()) {
            aa.a(this.aaa);
            aa.co(this.aab);
            return tJ;
        } else if (!this.ZX.va().qT() && this.ZX.va().abX == 1 && this.ZX.uZ().abT) {
            String str = this.ZX.va().mErrorString;
            this.ZX.va().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rf();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cc(currentAccountObj.getAccount());
            if (ReloginManager.tp().tt()) {
                AccountData ts = ReloginManager.tp().ts();
                if (ts == null) {
                    ReloginManager.tp().e(ts);
                    return null;
                }
                return cl(i);
            }
            com.baidu.tbadk.core.data.l d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (vY = com.baidu.tbadk.coreExtra.a.a.vY()) != null) {
                vY.g(currentAccountObj);
            }
            if (d == null) {
                if (this.ZZ != null) {
                    this.ZX.va().mErrorString = this.ZZ.getErrorString();
                    return null;
                }
                this.ZX.va().mErrorString = str;
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
                tJ = this.ZY.tI();
                break;
            case 2:
                tJ = this.ZY.tG();
                break;
            case 3:
                tJ = this.ZY.tJ();
                break;
            default:
                return null;
        }
        if (this.ZX.va().uk()) {
            switch (this.ZX.va().abX) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.ZX.va().mErrorString = "";
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
        uh().uZ().a(this.ZY);
        return this.ZY.a(str, handler, i, i2, i3, z);
    }
}
