package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class y {
    private com.baidu.tbadk.core.util.a.a apR = null;
    private r apS = null;
    private y apT = null;
    private ab.a apU = null;
    private int apV = 0;

    private void yW() {
        this.apR = new com.baidu.tbadk.core.util.a.a();
        this.apS = aa.zh().a(this.apR);
        this.apT = null;
        this.apR.zX().Aa().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aA(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aB(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a yX() {
        return this.apR;
    }

    public y() {
        yW();
    }

    public y(String str) {
        yW();
        this.apR.zX().Aa().mUrl = str;
    }

    public void setUrl(String str) {
        this.apR.zX().Aa().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.apS.p(arrayList);
    }

    public void o(String str, String str2) {
        this.apS.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.apS.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.apS.d(str, bArr);
    }

    private void yY() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> yy = this.apS.yy();
            int size = yy.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = yy.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    yy.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    yy.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void yZ() {
        if (this.apU == null) {
            this.apU = ab.zi();
        }
        if (this.apU != null) {
            this.apS.o("stTime", String.valueOf(this.apU.mTime));
            this.apS.o("stSize", String.valueOf(this.apU.aqm));
            this.apS.o("stTimesNum", String.valueOf(this.apU.aqn));
            this.apS.o("stMode", String.valueOf(this.apU.mMode));
            this.apS.o("stMethod", String.valueOf(this.apU.aql));
        }
        this.apV = ab.cH(0);
        if (this.apV == 0 && this.apU != null) {
            this.apV = this.apU.aqn;
        }
        this.apS.o("stErrorNums", String.valueOf(this.apV));
    }

    public boolean za() {
        return this.apR.zY().za();
    }

    public int zb() {
        return this.apR.zY().asr;
    }

    public int zc() {
        return this.apR.zY().zZ;
    }

    public String zd() {
        return this.apR.zY().ass;
    }

    public String getErrorString() {
        return this.apR.zY().mErrorString;
    }

    public void hN() {
        if (this.apS != null) {
            this.apS.hN();
        }
        if (this.apT != null) {
            this.apT.hN();
        }
    }

    public void hP() {
        if (this.apS != null) {
            this.apS.hP();
        }
        if (this.apT != null) {
            this.apT.hP();
        }
    }

    private com.baidu.tbadk.core.data.af f(String str, String str2, boolean z) {
        String yz;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.apT == null) {
                this.apT = new y(sb.toString());
            } else {
                this.apT.hN();
            }
            this.apT.yX().zX().mIsNeedAddCommenParam = false;
            this.apT.yX().zX().mIsUseCurrentBDUSS = false;
            this.apT.yX().zX().aso = false;
            this.apT.o("un", str);
            this.apT.o("passwd", str2);
            this.apT.o("isphone", "0");
            this.apT.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.apT.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.apT.yX().zX().Aa().asP = true;
            yz = this.apT.yz();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.apT.yX().zY().isRequestSuccess() && yz != null) {
            com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
            afVar.parserJson(yz);
            String userId = afVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.apR.zY().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.k.neterror);
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
            if (afVar.uu() != null) {
                accountData.setTbs(afVar.uu().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return afVar;
        }
        if (this.apT.za()) {
            switch (this.apT.zb()) {
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

    public byte[] yA() {
        if (!this.apR.zX().mIsFromCDN) {
            this.apR.zX().b(this.apS);
        }
        return this.apS.yA();
    }

    private void ze() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> yy = this.apS.yy();
        for (int i = 0; yy != null && i < yy.size(); i++) {
            BasicNameValuePair basicNameValuePair = yy.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.apS.o("sign", com.baidu.adp.lib.util.s.bl(stringBuffer.toString()));
    }

    private String cE(int i) {
        String yC;
        switch (i) {
            case 1:
                if (yX().zX().mIsNeedAddCommenParam) {
                    this.apR.zX().b(this.apS);
                }
                yZ();
                yC = this.apS.yB();
                break;
            case 2:
                if (yX().zX().mIsUseCurrentBDUSS) {
                    yX().zX().a(this.apS);
                }
                if (yX().zX().mIsNeedAddCommenParam) {
                    this.apR.zX().b(this.apS);
                }
                yZ();
                yC = this.apS.yz();
                break;
            case 3:
                if (yX().zX().mIsUseCurrentBDUSS) {
                    yX().zX().a(this.apS);
                }
                if (yX().zX().mIsNeedAddCommenParam) {
                    this.apR.zX().b(this.apS);
                }
                ze();
                yC = this.apS.yC();
                break;
            default:
                return null;
        }
        if (!this.apR.zY().za()) {
            ab.a(this.apU);
            ab.cI(this.apV);
            return yC;
        } else if (!this.apR.zY().isRequestSuccess()) {
            if (this.apR.zY().asr == 1 && this.apR.zX().aso) {
                String str = this.apR.zY().mErrorString;
                this.apR.zY().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.tE();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    zf();
                    return null;
                }
                com.baidu.tbadk.core.a.b.df(currentAccountObj.getID());
                if (ReloginManager.yc().yf()) {
                    f(currentAccountObj);
                    ReloginManager.yc().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.af f = f(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (f == null) {
                    if (this.apT != null) {
                        this.apR.zY().mErrorString = this.apT.getErrorString();
                        return null;
                    }
                    this.apR.zY().mErrorString = str;
                    return yC;
                }
                yC = cF(i);
            }
            com.baidu.tieba.i.a.a(this);
            return yC;
        } else {
            return yC;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c BF;
        if (!TextUtils.isEmpty(accountData.getID()) && (BF = com.baidu.tbadk.coreExtra.a.a.BF()) != null) {
            BF.f(accountData);
        }
    }

    private String cF(int i) {
        String yC;
        yY();
        switch (i) {
            case 1:
                yC = this.apS.yB();
                break;
            case 2:
                yC = this.apS.yz();
                break;
            case 3:
                yC = this.apS.yC();
                break;
            default:
                return null;
        }
        if (this.apR.zY().za()) {
            switch (this.apR.zY().asr) {
                case 1:
                case 2:
                case 5:
                    zf();
                    this.apR.zY().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return yC;
            }
        }
        return yC;
    }

    private void zf() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String yz() {
        return cE(2);
    }

    public String yB() {
        return cE(1);
    }

    public String yC() {
        return cE(3);
    }

    public String eD(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream em = l.em(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = em.read(bArr2);
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
        return yC();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        yX().zX().a(this.apS);
        return this.apS.a(str, handler, i, i2, i3, z);
    }
}
