package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class y {
    private com.baidu.tbadk.core.util.a.a ZB = null;
    private r ZC = null;
    private y ZD = null;
    private ac.a ZE = null;
    private int ZF = 0;

    private void uB() {
        this.ZB = new com.baidu.tbadk.core.util.a.a();
        this.ZC = ab.uL().a(this.ZB);
        this.ZD = null;
        this.ZB.vv().vy().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ag(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uC() {
        return this.ZB;
    }

    public y() {
        uB();
    }

    public y(String str) {
        uB();
        this.ZB.vv().vy().mUrl = str;
    }

    public void setUrl(String str) {
        this.ZB.vv().vy().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.ZC.l(arrayList);
    }

    public void n(String str, String str2) {
        this.ZC.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.ZC.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.ZC.d(str, bArr);
    }

    private void uD() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uc = this.ZC.uc();
            int size = uc.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uc.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uc.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uc.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uE() {
        if (this.ZE == null) {
            this.ZE = ac.uM();
        }
        if (this.ZE != null) {
            this.ZC.n("stTime", String.valueOf(this.ZE.mTime));
            this.ZC.n("stSize", String.valueOf(this.ZE.ZW));
            this.ZC.n("stTimesNum", String.valueOf(this.ZE.ZX));
            this.ZC.n("stMode", String.valueOf(this.ZE.mMode));
            this.ZC.n("stMethod", String.valueOf(this.ZE.ZV));
        }
        this.ZF = ac.cG(0);
        if (this.ZF == 0 && this.ZE != null) {
            this.ZF = this.ZE.ZX;
        }
        this.ZC.n("stErrorNums", String.valueOf(this.ZF));
    }

    public boolean uF() {
        return this.ZB.vw().uF();
    }

    public int uG() {
        return this.ZB.vw().abG;
    }

    public int uH() {
        return this.ZB.vw().oy;
    }

    public String uI() {
        return this.ZB.vw().abH;
    }

    public String getErrorString() {
        return this.ZB.vw().mErrorString;
    }

    public void ee() {
        if (this.ZC != null) {
            this.ZC.ee();
        }
        if (this.ZD != null) {
            this.ZD.ee();
        }
    }

    public void eh() {
        if (this.ZC != null) {
            this.ZC.eh();
        }
        if (this.ZD != null) {
            this.ZD.eh();
        }
    }

    private com.baidu.tbadk.core.data.ai d(String str, String str2, boolean z) {
        String ud;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.ZD == null) {
                this.ZD = new y(sb.toString());
            } else {
                this.ZD.ee();
            }
            this.ZD.uC().vv().mIsNeedAddCommenParam = false;
            this.ZD.uC().vv().mIsUseCurrentBDUSS = false;
            this.ZD.uC().vv().abD = false;
            this.ZD.n("un", str);
            this.ZD.n("passwd", str2);
            this.ZD.n("isphone", "0");
            this.ZD.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.ZD.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.ZD.uC().vv().vy().ace = true;
            ud = this.ZD.ud();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ZD.uC().vw().isRequestSuccess() && ud != null) {
            com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
            aiVar.parserJson(ud);
            String userId = aiVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ZB.vw().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(r.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aiVar.getUser().getUserName());
            if (aiVar.getUser().getPassword() != null) {
                accountData.setPassword(aiVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aiVar.getUser().getUserId());
            accountData.setBDUSS(aiVar.getUser().getBDUSS());
            accountData.setPortrait(aiVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aiVar.qm() != null) {
                accountData.setTbs(aiVar.qm().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return aiVar;
        }
        if (this.ZD.uF()) {
            switch (this.ZD.uG()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m9getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m9getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] ue() {
        if (!this.ZB.vv().mIsFromCDN) {
            this.ZB.vv().b(this.ZC);
        }
        return this.ZC.ue();
    }

    private void uJ() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uc = this.ZC.uc();
        for (int i = 0; uc != null && i < uc.size(); i++) {
            BasicNameValuePair basicNameValuePair = uc.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.ZC.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aT(stringBuffer.toString()));
    }

    private String cD(int i) {
        String ug;
        com.baidu.tbadk.coreExtra.a.c xc;
        switch (i) {
            case 1:
                if (uC().vv().mIsNeedAddCommenParam) {
                    this.ZB.vv().b(this.ZC);
                }
                uE();
                ug = this.ZC.uf();
                break;
            case 2:
                if (uC().vv().mIsUseCurrentBDUSS) {
                    uC().vv().a(this.ZC);
                }
                if (uC().vv().mIsNeedAddCommenParam) {
                    this.ZB.vv().b(this.ZC);
                }
                uE();
                ug = this.ZC.ud();
                break;
            case 3:
                if (uC().vv().mIsUseCurrentBDUSS) {
                    uC().vv().a(this.ZC);
                }
                if (uC().vv().mIsNeedAddCommenParam) {
                    this.ZB.vv().b(this.ZC);
                }
                uJ();
                ug = this.ZC.ug();
                break;
            default:
                return null;
        }
        if (!this.ZB.vw().uF()) {
            ac.a(this.ZE);
            ac.cH(this.ZF);
            return ug;
        } else if (!this.ZB.vw().isRequestSuccess() && this.ZB.vw().abG == 1 && this.ZB.vv().abD) {
            String str = this.ZB.vw().mErrorString;
            this.ZB.vw().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.oO();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cg(currentAccountObj.getAccount());
            if (ReloginManager.tL().tP()) {
                AccountData tO = ReloginManager.tL().tO();
                if (tO == null) {
                    ReloginManager.tL().f(tO);
                    return null;
                }
                return cE(i);
            }
            com.baidu.tbadk.core.data.ai d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xc = com.baidu.tbadk.coreExtra.a.a.xc()) != null) {
                xc.h(currentAccountObj);
            }
            if (d == null) {
                if (this.ZD != null) {
                    this.ZB.vw().mErrorString = this.ZD.getErrorString();
                    return null;
                }
                this.ZB.vw().mErrorString = str;
                return ug;
            }
            return cE(i);
        } else {
            return ug;
        }
    }

    private String cE(int i) {
        String ug;
        uD();
        switch (i) {
            case 1:
                ug = this.ZC.uf();
                break;
            case 2:
                ug = this.ZC.ud();
                break;
            case 3:
                ug = this.ZC.ug();
                break;
            default:
                return null;
        }
        if (this.ZB.vw().uF()) {
            switch (this.ZB.vw().abG) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.ZB.vw().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return ug;
            }
        }
        return ug;
    }

    public String ud() {
        return cD(2);
    }

    public String uf() {
        return cD(1);
    }

    public String ug() {
        return cD(3);
    }

    public String dr(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dd = l.dd(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dd.read(bArr2);
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
        return ug();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uC().vv().a(this.ZC);
        return this.ZC.a(str, handler, i, i2, i3, z);
    }
}
