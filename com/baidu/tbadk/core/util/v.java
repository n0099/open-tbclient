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
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.i;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class v {
    private com.baidu.tbadk.core.util.httpNet.a ZO = null;
    private q ZP = null;
    private v ZQ = null;
    private z.a ZR = null;
    private int ZS = 0;

    private void ud() {
        this.ZO = new com.baidu.tbadk.core.util.httpNet.a();
        this.ZP = y.um().a(this.ZO);
        this.ZQ = null;
        this.ZO.uV().uY().mNetType = com.baidu.tbadk.core.util.httpNet.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.httpNet.a ue() {
        return this.ZO;
    }

    public v() {
        ud();
    }

    public v(String str) {
        ud();
        this.ZO.uV().uY().mUrl = str;
    }

    public void setUrl(String str) {
        this.ZO.uV().uY().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.ZP.m(arrayList);
    }

    public void o(String str, String str2) {
        this.ZP.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.ZP.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.ZP.d(str, bArr);
    }

    private void uf() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tC = this.ZP.tC();
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
        if (this.ZR == null) {
            this.ZR = z.un();
        }
        if (this.ZR != null) {
            this.ZP.o("stTime", String.valueOf(this.ZR.mTime));
            this.ZP.o("stSize", String.valueOf(this.ZR.mSize));
            this.ZP.o("stTimesNum", String.valueOf(this.ZR.aaj));
            this.ZP.o("stMode", String.valueOf(this.ZR.mMode));
            this.ZP.o("stMethod", String.valueOf(this.ZR.aai));
        }
        this.ZS = z.ch(0);
        if (this.ZS == 0 && this.ZR != null) {
            this.ZS = this.ZR.aaj;
        }
        this.ZP.o("stErrorNums", String.valueOf(this.ZS));
    }

    public boolean uh() {
        return this.ZO.uW().uh();
    }

    public int ui() {
        return this.ZO.uW().abI;
    }

    public int uj() {
        return this.ZO.uW().abH;
    }

    public String getErrorString() {
        return this.ZO.uW().mErrorString;
    }

    public void gM() {
        if (this.ZP != null) {
            this.ZP.gM();
        }
        if (this.ZQ != null) {
            this.ZQ.gM();
        }
    }

    private com.baidu.tbadk.core.data.m d(String str, String str2, boolean z) {
        String tD;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.ZQ == null) {
                this.ZQ = new v(sb.toString());
            } else {
                this.ZQ.gM();
            }
            this.ZQ.ue().uV().mIsNeedAddCommenParam = false;
            this.ZQ.ue().uV().mIsUseCurrentBDUSS = false;
            this.ZQ.ue().uV().abE = false;
            this.ZQ.o("un", str);
            this.ZQ.o("passwd", str2);
            this.ZQ.o("isphone", "0");
            this.ZQ.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.ZQ.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.ZQ.ue().uV().uY().acb = true;
            tD = this.ZQ.tD();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ZQ.ue().uW().rb() && tD != null) {
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            mVar.parserJson(tD);
            String userId = mVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ZO.uW().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.C0057i.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(mVar.getUser().getUserName());
            if (mVar.getUser().getPassword() != null) {
                accountData.setPassword(mVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(mVar.getUser().getUserId());
            accountData.setBDUSS(mVar.getUser().getBDUSS());
            accountData.setPortrait(mVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (mVar.rM() != null) {
                accountData.setTbs(mVar.rM().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return mVar;
        }
        if (this.ZQ.uh()) {
            switch (this.ZQ.ui()) {
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
        if (!this.ZO.uV().mIsFromCDN) {
            this.ZO.uV().b(this.ZP);
        }
        return this.ZP.tE();
    }

    private void uk() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tC = this.ZP.tC();
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
        this.ZP.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String ce(int i) {
        String tG;
        com.baidu.tbadk.coreExtra.act.l vZ;
        switch (i) {
            case 1:
                if (ue().uV().mIsNeedAddCommenParam) {
                    this.ZO.uV().b(this.ZP);
                }
                ug();
                tG = this.ZP.tF();
                break;
            case 2:
                if (ue().uV().mIsUseCurrentBDUSS) {
                    ue().uV().a(this.ZP);
                }
                if (ue().uV().mIsNeedAddCommenParam) {
                    this.ZO.uV().b(this.ZP);
                }
                ug();
                tG = this.ZP.tD();
                break;
            case 3:
                if (ue().uV().mIsUseCurrentBDUSS) {
                    ue().uV().a(this.ZP);
                }
                if (ue().uV().mIsNeedAddCommenParam) {
                    this.ZO.uV().b(this.ZP);
                }
                uk();
                tG = this.ZP.tG();
                break;
            default:
                return null;
        }
        if (!this.ZO.uW().uh()) {
            z.a(this.ZR);
            z.ci(this.ZS);
            return tG;
        } else if (!this.ZO.uW().rb() && this.ZO.uW().abI == 1 && this.ZO.uV().abE) {
            String str = this.ZO.uW().mErrorString;
            this.ZO.uW().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rn();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cc(currentAccountObj.getAccount());
            if (ReloginManager.tn().tr()) {
                AccountData tq = ReloginManager.tn().tq();
                if (tq == null) {
                    ReloginManager.tn().e(tq);
                    return null;
                }
                return cf(i);
            }
            com.baidu.tbadk.core.data.m d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (vZ = com.baidu.tbadk.coreExtra.act.a.vZ()) != null) {
                vZ.j(currentAccountObj);
            }
            if (d == null) {
                if (this.ZQ != null) {
                    this.ZO.uW().mErrorString = this.ZQ.getErrorString();
                    return null;
                }
                this.ZO.uW().mErrorString = str;
                return tG;
            }
            return cf(i);
        } else {
            return tG;
        }
    }

    private String cf(int i) {
        String tG;
        uf();
        switch (i) {
            case 1:
                tG = this.ZP.tF();
                break;
            case 2:
                tG = this.ZP.tD();
                break;
            case 3:
                tG = this.ZP.tG();
                break;
            default:
                return null;
        }
        if (this.ZO.uW().uh()) {
            switch (this.ZO.uW().abI) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.ZO.uW().mErrorString = "";
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
        return ce(2);
    }

    public String tF() {
        return ce(1);
    }

    public String tG() {
        return ce(3);
    }

    public String cU(String str) {
        byte[] bArr;
        try {
            InputStream cG = n.cG(str);
            byte[] bArr2 = new byte[a0.O];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a0.O);
            while (true) {
                int read = cG.read(bArr2);
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
        ue().uV().a(this.ZP);
        return this.ZP.a(str, handler, i, i2, i3, z);
    }
}
