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
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.n;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a aaJ = null;
    private u aaK = null;
    private ab aaL = null;
    private af.a aaM = null;
    private int aaN = 0;

    private void uL() {
        this.aaJ = new com.baidu.tbadk.core.util.a.a();
        this.aaK = ae.uV().a(this.aaJ);
        this.aaL = null;
        this.aaJ.vF().vI().mNetType = com.baidu.tbadk.core.util.a.i.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uM() {
        return this.aaJ;
    }

    public ab() {
        uL();
    }

    public ab(String str) {
        uL();
        this.aaJ.vF().vI().mUrl = str;
    }

    public void setUrl(String str) {
        this.aaJ.vF().vI().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.aaK.m(arrayList);
    }

    public void o(String str, String str2) {
        this.aaK.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aaK.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aaK.d(str, bArr);
    }

    private void uN() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uk = this.aaK.uk();
            int size = uk.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uk.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uk.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uk.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uO() {
        if (this.aaM == null) {
            this.aaM = af.uW();
        }
        if (this.aaM != null) {
            this.aaK.o("stTime", String.valueOf(this.aaM.mTime));
            this.aaK.o("stSize", String.valueOf(this.aaM.mSize));
            this.aaK.o("stTimesNum", String.valueOf(this.aaM.abe));
            this.aaK.o("stMode", String.valueOf(this.aaM.mMode));
            this.aaK.o("stMethod", String.valueOf(this.aaM.abd));
        }
        this.aaN = af.cv(0);
        if (this.aaN == 0 && this.aaM != null) {
            this.aaN = this.aaM.abe;
        }
        this.aaK.o("stErrorNums", String.valueOf(this.aaN));
    }

    public boolean uP() {
        return this.aaJ.vG().uP();
    }

    public int uQ() {
        return this.aaJ.vG().acP;
    }

    public int uR() {
        return this.aaJ.vG().acO;
    }

    public String uS() {
        return this.aaJ.vG().acQ;
    }

    public String getErrorString() {
        return this.aaJ.vG().mErrorString;
    }

    public void gL() {
        if (this.aaK != null) {
            this.aaK.gL();
        }
        if (this.aaL != null) {
            this.aaL.gL();
        }
    }

    public void gO() {
        if (this.aaK != null) {
            this.aaK.gO();
        }
        if (this.aaL != null) {
            this.aaL.gO();
        }
    }

    private com.baidu.tbadk.core.data.n d(String str, String str2, boolean z) {
        String ul;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aaL == null) {
                this.aaL = new ab(sb.toString());
            } else {
                this.aaL.gL();
            }
            this.aaL.uM().vF().mIsNeedAddCommenParam = false;
            this.aaL.uM().vF().mIsUseCurrentBDUSS = false;
            this.aaL.uM().vF().acL = false;
            this.aaL.o("un", str);
            this.aaL.o("passwd", str2);
            this.aaL.o("isphone", "0");
            this.aaL.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.aaL.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.aaL.uM().vF().vI().adj = true;
            ul = this.aaL.ul();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aaL.uM().vG().rf() && ul != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(ul);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aaJ.vG().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(n.i.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            if (nVar.getUser().getPassword() != null) {
                accountData.setPassword(nVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.rZ() != null) {
                accountData.setTbs(nVar.rZ().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return nVar;
        }
        if (this.aaL.uP()) {
            switch (this.aaL.uQ()) {
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

    public byte[] um() {
        if (!this.aaJ.vF().mIsFromCDN) {
            this.aaJ.vF().b(this.aaK);
        }
        return this.aaK.um();
    }

    private void uT() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uk = this.aaK.uk();
        for (int i = 0; uk != null && i < uk.size(); i++) {
            BasicNameValuePair basicNameValuePair = uk.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aaK.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String cs(int i) {
        String uo;
        com.baidu.tbadk.coreExtra.a.c wP;
        switch (i) {
            case 1:
                if (uM().vF().mIsNeedAddCommenParam) {
                    this.aaJ.vF().b(this.aaK);
                }
                uO();
                uo = this.aaK.un();
                break;
            case 2:
                if (uM().vF().mIsUseCurrentBDUSS) {
                    uM().vF().a(this.aaK);
                }
                if (uM().vF().mIsNeedAddCommenParam) {
                    this.aaJ.vF().b(this.aaK);
                }
                uO();
                uo = this.aaK.ul();
                break;
            case 3:
                if (uM().vF().mIsUseCurrentBDUSS) {
                    uM().vF().a(this.aaK);
                }
                if (uM().vF().mIsNeedAddCommenParam) {
                    this.aaJ.vF().b(this.aaK);
                }
                uT();
                uo = this.aaK.uo();
                break;
            default:
                return null;
        }
        if (!this.aaJ.vG().uP()) {
            af.a(this.aaM);
            af.cw(this.aaN);
            return uo;
        } else if (!this.aaJ.vG().rf() && this.aaJ.vG().acP == 1 && this.aaJ.vF().acL) {
            String str = this.aaJ.vG().mErrorString;
            this.aaJ.vG().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rt();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cj(currentAccountObj.getAccount());
            if (ReloginManager.tU().tY()) {
                AccountData tX = ReloginManager.tU().tX();
                if (tX == null) {
                    ReloginManager.tU().e(tX);
                    return null;
                }
                return ct(i);
            }
            com.baidu.tbadk.core.data.n d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (wP = com.baidu.tbadk.coreExtra.a.a.wP()) != null) {
                wP.g(currentAccountObj);
            }
            if (d == null) {
                if (this.aaL != null) {
                    this.aaJ.vG().mErrorString = this.aaL.getErrorString();
                    return null;
                }
                this.aaJ.vG().mErrorString = str;
                return uo;
            }
            return ct(i);
        } else {
            return uo;
        }
    }

    private String ct(int i) {
        String uo;
        uN();
        switch (i) {
            case 1:
                uo = this.aaK.un();
                break;
            case 2:
                uo = this.aaK.ul();
                break;
            case 3:
                uo = this.aaK.uo();
                break;
            default:
                return null;
        }
        if (this.aaJ.vG().uP()) {
            switch (this.aaJ.vG().acP) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.aaJ.vG().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uo;
            }
        }
        return uo;
    }

    public String ul() {
        return cs(2);
    }

    public String uo() {
        return cs(3);
    }

    public String dn(String str) {
        byte[] bArr;
        try {
            InputStream cX = n.cX(str);
            byte[] bArr2 = new byte[a0.O];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a0.O);
            while (true) {
                int read = cX.read(bArr2);
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
        return uo();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uM().vF().a(this.aaK);
        return this.aaK.a(str, handler, i, i2, i3, z);
    }
}
