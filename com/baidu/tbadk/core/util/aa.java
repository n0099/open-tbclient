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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.t;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class aa {
    private com.baidu.tbadk.core.util.a.a abJ = null;
    private t abK = null;
    private aa abL = null;
    private ae.a abM = null;
    private int abN = 0;

    private void vA() {
        this.abJ = new com.baidu.tbadk.core.util.a.a();
        this.abK = ad.vK().a(this.abJ);
        this.abL = null;
        this.abJ.wv().wy().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vB() {
        return this.abJ;
    }

    public aa() {
        vA();
    }

    public aa(String str) {
        vA();
        this.abJ.wv().wy().mUrl = str;
    }

    public void setUrl(String str) {
        this.abJ.wv().wy().mUrl = str;
    }

    public void n(ArrayList<BasicNameValuePair> arrayList) {
        this.abK.n(arrayList);
    }

    public void p(String str, String str2) {
        this.abK.p(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.abK.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.abK.d(str, bArr);
    }

    private void vC() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uY = this.abK.uY();
            int size = uY.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uY.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uY.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uY.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vD() {
        if (this.abM == null) {
            this.abM = ae.vL();
        }
        if (this.abM != null) {
            this.abK.p("stTime", String.valueOf(this.abM.mTime));
            this.abK.p("stSize", String.valueOf(this.abM.ace));
            this.abK.p("stTimesNum", String.valueOf(this.abM.acf));
            this.abK.p("stMode", String.valueOf(this.abM.mMode));
            this.abK.p("stMethod", String.valueOf(this.abM.acd));
        }
        this.abN = ae.cF(0);
        if (this.abN == 0 && this.abM != null) {
            this.abN = this.abM.acf;
        }
        this.abK.p("stErrorNums", String.valueOf(this.abN));
    }

    public boolean vE() {
        return this.abJ.ww().vE();
    }

    public int vF() {
        return this.abJ.ww().adP;
    }

    public int vG() {
        return this.abJ.ww().vv;
    }

    public String vH() {
        return this.abJ.ww().adQ;
    }

    public String getErrorString() {
        return this.abJ.ww().mErrorString;
    }

    public void gT() {
        if (this.abK != null) {
            this.abK.gT();
        }
        if (this.abL != null) {
            this.abL.gT();
        }
    }

    public void gW() {
        if (this.abK != null) {
            this.abK.gW();
        }
        if (this.abL != null) {
            this.abL.gW();
        }
    }

    private com.baidu.tbadk.core.data.r d(String str, String str2, boolean z) {
        String uZ;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.abL == null) {
                this.abL = new aa(sb.toString());
            } else {
                this.abL.gT();
            }
            this.abL.vB().wv().mIsNeedAddCommenParam = false;
            this.abL.vB().wv().mIsUseCurrentBDUSS = false;
            this.abL.vB().wv().adM = false;
            this.abL.p("un", str);
            this.abL.p("passwd", str2);
            this.abL.p("isphone", "0");
            this.abL.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.abL.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.abL.vB().wv().wy().aen = true;
            uZ = this.abL.uZ();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.abL.vB().ww().rl() && uZ != null) {
            com.baidu.tbadk.core.data.r rVar = new com.baidu.tbadk.core.data.r();
            rVar.parserJson(uZ);
            String userId = rVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.abJ.ww().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(t.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(rVar.getUser().getUserName());
            if (rVar.getUser().getPassword() != null) {
                accountData.setPassword(rVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(rVar.getUser().getUserId());
            accountData.setBDUSS(rVar.getUser().getBDUSS());
            accountData.setPortrait(rVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (rVar.so() != null) {
                accountData.setTbs(rVar.so().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return rVar;
        }
        if (this.abL.vE()) {
            switch (this.abL.vF()) {
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

    public byte[] va() {
        if (!this.abJ.wv().mIsFromCDN) {
            this.abJ.wv().b(this.abK);
        }
        return this.abK.va();
    }

    private void vI() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uY = this.abK.uY();
        for (int i = 0; uY != null && i < uY.size(); i++) {
            BasicNameValuePair basicNameValuePair = uY.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.abK.p(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String cC(int i) {
        String vc;
        com.baidu.tbadk.coreExtra.a.c xM;
        switch (i) {
            case 1:
                if (vB().wv().mIsNeedAddCommenParam) {
                    this.abJ.wv().b(this.abK);
                }
                vD();
                vc = this.abK.vb();
                break;
            case 2:
                if (vB().wv().mIsUseCurrentBDUSS) {
                    vB().wv().a(this.abK);
                }
                if (vB().wv().mIsNeedAddCommenParam) {
                    this.abJ.wv().b(this.abK);
                }
                vD();
                vc = this.abK.uZ();
                break;
            case 3:
                if (vB().wv().mIsUseCurrentBDUSS) {
                    vB().wv().a(this.abK);
                }
                if (vB().wv().mIsNeedAddCommenParam) {
                    this.abJ.wv().b(this.abK);
                }
                vI();
                vc = this.abK.vc();
                break;
            default:
                return null;
        }
        if (!this.abJ.ww().vE()) {
            ae.a(this.abM);
            ae.cG(this.abN);
            return vc;
        } else if (!this.abJ.ww().rl() && this.abJ.ww().adP == 1 && this.abJ.wv().adM) {
            String str = this.abJ.ww().mErrorString;
            this.abJ.ww().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rz();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.ck(currentAccountObj.getAccount());
            if (ReloginManager.uJ().uN()) {
                AccountData uM = ReloginManager.uJ().uM();
                if (uM == null) {
                    ReloginManager.uJ().e(uM);
                    return null;
                }
                return cD(i);
            }
            com.baidu.tbadk.core.data.r d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xM = com.baidu.tbadk.coreExtra.a.a.xM()) != null) {
                xM.g(currentAccountObj);
            }
            if (d == null) {
                if (this.abL != null) {
                    this.abJ.ww().mErrorString = this.abL.getErrorString();
                    return null;
                }
                this.abJ.ww().mErrorString = str;
                return vc;
            }
            return cD(i);
        } else {
            return vc;
        }
    }

    private String cD(int i) {
        String vc;
        vC();
        switch (i) {
            case 1:
                vc = this.abK.vb();
                break;
            case 2:
                vc = this.abK.uZ();
                break;
            case 3:
                vc = this.abK.vc();
                break;
            default:
                return null;
        }
        if (this.abJ.ww().vE()) {
            switch (this.abJ.ww().adP) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.abJ.ww().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return vc;
            }
        }
        return vc;
    }

    public String uZ() {
        return cC(2);
    }

    public String vc() {
        return cC(3);
    }

    public String dn(String str) {
        byte[] bArr;
        try {
            InputStream cX = m.cX(str);
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
        return vc();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vB().wv().a(this.abK);
        return this.abK.a(str, handler, i, i2, i3, z);
    }
}
