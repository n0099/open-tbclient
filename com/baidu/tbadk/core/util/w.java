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
    private com.baidu.tbadk.core.util.a.a agP = null;
    private p agQ = null;
    private w agR = null;
    private z.a agS = null;
    private int agT = 0;

    private void vk() {
        this.agP = new com.baidu.tbadk.core.util.a.a();
        this.agQ = y.vv().a(this.agP);
        this.agR = null;
        this.agP.wh().wk().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ao(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vl() {
        return this.agP;
    }

    public w() {
        vk();
    }

    public w(String str) {
        vk();
        this.agP.wh().wk().mUrl = str;
    }

    public void setUrl(String str) {
        this.agP.wh().wk().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.agQ.k(arrayList);
    }

    public void n(String str, String str2) {
        this.agQ.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.agQ.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.agQ.d(str, bArr);
    }

    private void vm() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uN = this.agQ.uN();
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
        if (this.agS == null) {
            this.agS = z.vw();
        }
        if (this.agS != null) {
            this.agQ.n("stTime", String.valueOf(this.agS.mTime));
            this.agQ.n("stSize", String.valueOf(this.agS.ahi));
            this.agQ.n("stTimesNum", String.valueOf(this.agS.ahj));
            this.agQ.n("stMode", String.valueOf(this.agS.mMode));
            this.agQ.n("stMethod", String.valueOf(this.agS.mMethod));
        }
        this.agT = z.cJ(0);
        if (this.agT == 0 && this.agS != null) {
            this.agT = this.agS.ahj;
        }
        this.agQ.n("stErrorNums", String.valueOf(this.agT));
    }

    public boolean vo() {
        return this.agP.wi().vo();
    }

    public int vp() {
        return this.agP.wi().aiR;
    }

    public int vq() {
        return this.agP.wi().xt;
    }

    public String vr() {
        return this.agP.wi().aiS;
    }

    public String getErrorString() {
        return this.agP.wi().mErrorString;
    }

    public void fA() {
        if (this.agQ != null) {
            this.agQ.fA();
        }
        if (this.agR != null) {
            this.agR.fA();
        }
    }

    public void fD() {
        if (this.agQ != null) {
            this.agQ.fD();
        }
        if (this.agR != null) {
            this.agR.fD();
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
            if (this.agR == null) {
                this.agR = new w(sb.toString());
            } else {
                this.agR.fA();
            }
            this.agR.vl().wh().mIsNeedAddCommenParam = false;
            this.agR.vl().wh().mIsUseCurrentBDUSS = false;
            this.agR.vl().wh().aiO = false;
            this.agR.n("un", str);
            this.agR.n("passwd", str2);
            this.agR.n("isphone", "0");
            this.agR.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.agR.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.agR.vl().wh().wk().ajp = true;
            uO = this.agR.uO();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.agR.vl().wi().isRequestSuccess() && uO != null) {
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.parserJson(uO);
            String userId = akVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.agP.wi().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror);
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
        if (this.agR.vo()) {
            switch (this.agR.vp()) {
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
        if (!this.agP.wh().mIsFromCDN) {
            this.agP.wh().b(this.agQ);
        }
        return this.agQ.uf();
    }

    private void vs() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uN = this.agQ.uN();
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
        this.agQ.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aV(stringBuffer.toString()));
    }

    private String cG(int i) {
        String uQ;
        com.baidu.tbadk.coreExtra.a.c xM;
        switch (i) {
            case 1:
                if (vl().wh().mIsNeedAddCommenParam) {
                    this.agP.wh().b(this.agQ);
                }
                vn();
                uQ = this.agQ.uP();
                break;
            case 2:
                if (vl().wh().mIsUseCurrentBDUSS) {
                    vl().wh().a(this.agQ);
                }
                if (vl().wh().mIsNeedAddCommenParam) {
                    this.agP.wh().b(this.agQ);
                }
                vn();
                uQ = this.agQ.uO();
                break;
            case 3:
                if (vl().wh().mIsUseCurrentBDUSS) {
                    vl().wh().a(this.agQ);
                }
                if (vl().wh().mIsNeedAddCommenParam) {
                    this.agP.wh().b(this.agQ);
                }
                vs();
                uQ = this.agQ.uQ();
                break;
            default:
                return null;
        }
        if (!this.agP.wi().vo()) {
            z.a(this.agS);
            z.cK(this.agT);
            return uQ;
        } else if (!this.agP.wi().isRequestSuccess()) {
            if (this.agP.wi().aiR == 1 && this.agP.wh().aiO) {
                String str = this.agP.wi().mErrorString;
                this.agP.wi().mErrorString = "";
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
                    if (this.agR != null) {
                        this.agP.wi().mErrorString = this.agR.getErrorString();
                        return null;
                    }
                    this.agP.wi().mErrorString = str;
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
                uQ = this.agQ.uP();
                break;
            case 2:
                uQ = this.agQ.uO();
                break;
            case 3:
                uQ = this.agQ.uQ();
                break;
            default:
                return null;
        }
        if (this.agP.wi().vo()) {
            switch (this.agP.wi().aiR) {
                case 1:
                case 2:
                case 5:
                    vt();
                    this.agP.wi().mErrorString = "";
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
        vl().wh().a(this.agQ);
        return this.agQ.a(str, handler, i, i2, i3, z);
    }
}
