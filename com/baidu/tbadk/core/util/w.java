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
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class w {
    private com.baidu.tbadk.core.util.a.a agR = null;
    private p agS = null;
    private w agT = null;
    private z.a agU = null;
    private int agV = 0;

    private void vk() {
        this.agR = new com.baidu.tbadk.core.util.a.a();
        this.agS = y.vv().a(this.agR);
        this.agT = null;
        this.agR.wh().wk().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ao(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vl() {
        return this.agR;
    }

    public w() {
        vk();
    }

    public w(String str) {
        vk();
        this.agR.wh().wk().mUrl = str;
    }

    public void setUrl(String str) {
        this.agR.wh().wk().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.agS.k(arrayList);
    }

    public void n(String str, String str2) {
        this.agS.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.agS.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.agS.d(str, bArr);
    }

    private void vm() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uN = this.agS.uN();
            int size = uN.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uN.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uN.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uN.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vn() {
        if (this.agU == null) {
            this.agU = z.vw();
        }
        if (this.agU != null) {
            this.agS.n("stTime", String.valueOf(this.agU.mTime));
            this.agS.n("stSize", String.valueOf(this.agU.ahk));
            this.agS.n("stTimesNum", String.valueOf(this.agU.ahl));
            this.agS.n("stMode", String.valueOf(this.agU.mMode));
            this.agS.n("stMethod", String.valueOf(this.agU.mMethod));
        }
        this.agV = z.cJ(0);
        if (this.agV == 0 && this.agU != null) {
            this.agV = this.agU.ahl;
        }
        this.agS.n("stErrorNums", String.valueOf(this.agV));
    }

    public boolean vo() {
        return this.agR.wi().vo();
    }

    public int vp() {
        return this.agR.wi().aiT;
    }

    public int vq() {
        return this.agR.wi().xv;
    }

    public String vr() {
        return this.agR.wi().aiU;
    }

    public String getErrorString() {
        return this.agR.wi().mErrorString;
    }

    public void fA() {
        if (this.agS != null) {
            this.agS.fA();
        }
        if (this.agT != null) {
            this.agT.fA();
        }
    }

    public void fD() {
        if (this.agS != null) {
            this.agS.fD();
        }
        if (this.agT != null) {
            this.agT.fD();
        }
    }

    private com.baidu.tbadk.core.data.ak e(String str, String str2, boolean z) {
        String uO;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.agT == null) {
                this.agT = new w(sb.toString());
            } else {
                this.agT.fA();
            }
            this.agT.vl().wh().mIsNeedAddCommenParam = false;
            this.agT.vl().wh().mIsUseCurrentBDUSS = false;
            this.agT.vl().wh().aiQ = false;
            this.agT.n("un", str);
            this.agT.n("passwd", str2);
            this.agT.n("isphone", "0");
            this.agT.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.agT.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.agT.vl().wh().wk().ajr = true;
            uO = this.agT.uO();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.agT.vl().wi().isRequestSuccess() && uO != null) {
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.parserJson(uO);
            String userId = akVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.agR.wi().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(akVar.getUser().getUserName());
            if (akVar.getUser().getPassword() != null) {
                accountData.setPassword(akVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(akVar.getUser().getUserId());
            accountData.setBDUSS(akVar.getUser().getBDUSS());
            accountData.setPortrait(akVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (akVar.qr() != null) {
                accountData.setTbs(akVar.qr().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return akVar;
        }
        if (this.agT.vo()) {
            switch (this.agT.vp()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] uf() {
        if (!this.agR.wh().mIsFromCDN) {
            this.agR.wh().b(this.agS);
        }
        return this.agS.uf();
    }

    private void vs() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uN = this.agS.uN();
        for (int i = 0; uN != null && i < uN.size(); i++) {
            BasicNameValuePair basicNameValuePair = uN.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.agS.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aV(stringBuffer.toString()));
    }

    private String cG(int i) {
        String uQ;
        com.baidu.tbadk.coreExtra.a.c xM;
        switch (i) {
            case 1:
                if (vl().wh().mIsNeedAddCommenParam) {
                    this.agR.wh().b(this.agS);
                }
                vn();
                uQ = this.agS.uP();
                break;
            case 2:
                if (vl().wh().mIsUseCurrentBDUSS) {
                    vl().wh().a(this.agS);
                }
                if (vl().wh().mIsNeedAddCommenParam) {
                    this.agR.wh().b(this.agS);
                }
                vn();
                uQ = this.agS.uO();
                break;
            case 3:
                if (vl().wh().mIsUseCurrentBDUSS) {
                    vl().wh().a(this.agS);
                }
                if (vl().wh().mIsNeedAddCommenParam) {
                    this.agR.wh().b(this.agS);
                }
                vs();
                uQ = this.agS.uQ();
                break;
            default:
                return null;
        }
        if (!this.agR.wi().vo()) {
            z.a(this.agU);
            z.cK(this.agV);
            return uQ;
        } else if (!this.agR.wi().isRequestSuccess()) {
            if (this.agR.wi().aiT == 1 && this.agR.wh().aiQ) {
                String str = this.agR.wi().mErrorString;
                this.agR.wi().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.pj();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    vt();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cx(currentAccountObj.getAccount());
                if (ReloginManager.uy().uC()) {
                    AccountData uB = ReloginManager.uy().uB();
                    if (uB == null) {
                        ReloginManager.uy().f(uB);
                        return null;
                    }
                    return cH(i);
                }
                com.baidu.tbadk.core.data.ak e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xM = com.baidu.tbadk.coreExtra.a.a.xM()) != null) {
                    xM.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.agT != null) {
                        this.agR.wi().mErrorString = this.agT.getErrorString();
                        return null;
                    }
                    this.agR.wi().mErrorString = str;
                    return uQ;
                }
                uQ = cH(i);
            }
            com.baidu.tieba.h.a.a(this);
            return uQ;
        } else {
            return uQ;
        }
    }

    private String cH(int i) {
        String uQ;
        vm();
        switch (i) {
            case 1:
                uQ = this.agS.uP();
                break;
            case 2:
                uQ = this.agS.uO();
                break;
            case 3:
                uQ = this.agS.uQ();
                break;
            default:
                return null;
        }
        if (this.agR.wi().vo()) {
            switch (this.agR.wi().aiT) {
                case 1:
                case 2:
                case 5:
                    vt();
                    this.agR.wi().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uQ;
            }
        }
        return uQ;
    }

    private void vt() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String uO() {
        return cG(2);
    }

    public String uP() {
        return cG(1);
    }

    public String uQ() {
        return cG(3);
    }

    public String dP(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dB = k.dB(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dB.read(bArr2);
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
        return uQ();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vl().wh().a(this.agS);
        return this.agS.a(str, handler, i, i2, i3, z);
    }
}
