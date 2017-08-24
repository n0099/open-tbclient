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

    private void vl() {
        this.agR = new com.baidu.tbadk.core.util.a.a();
        this.agS = y.vw().a(this.agR);
        this.agT = null;
        this.agR.wi().wl().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ap(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vm() {
        return this.agR;
    }

    public w() {
        vl();
    }

    public w(String str) {
        vl();
        this.agR.wi().wl().mUrl = str;
    }

    public void setUrl(String str) {
        this.agR.wi().wl().mUrl = str;
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

    private void vn() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uO = this.agS.uO();
            int size = uO.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uO.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uO.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uO.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vo() {
        if (this.agU == null) {
            this.agU = z.vx();
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

    public boolean vp() {
        return this.agR.wj().vp();
    }

    public int vq() {
        return this.agR.wj().aiT;
    }

    public int vr() {
        return this.agR.wj().xv;
    }

    public String vs() {
        return this.agR.wj().aiU;
    }

    public String getErrorString() {
        return this.agR.wj().mErrorString;
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
        String uP;
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
            this.agT.vm().wi().mIsNeedAddCommenParam = false;
            this.agT.vm().wi().mIsUseCurrentBDUSS = false;
            this.agT.vm().wi().aiQ = false;
            this.agT.n("un", str);
            this.agT.n("passwd", str2);
            this.agT.n("isphone", "0");
            this.agT.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.agT.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.agT.vm().wi().wl().ajr = true;
            uP = this.agT.uP();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.agT.vm().wj().isRequestSuccess() && uP != null) {
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.parserJson(uP);
            String userId = akVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.agR.wj().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror);
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
            if (akVar.qs() != null) {
                accountData.setTbs(akVar.qs().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return akVar;
        }
        if (this.agT.vp()) {
            switch (this.agT.vq()) {
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

    public byte[] ug() {
        if (!this.agR.wi().mIsFromCDN) {
            this.agR.wi().b(this.agS);
        }
        return this.agS.ug();
    }

    private void vt() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uO = this.agS.uO();
        for (int i = 0; uO != null && i < uO.size(); i++) {
            BasicNameValuePair basicNameValuePair = uO.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.agS.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aW(stringBuffer.toString()));
    }

    private String cG(int i) {
        String uR;
        com.baidu.tbadk.coreExtra.a.c xM;
        switch (i) {
            case 1:
                if (vm().wi().mIsNeedAddCommenParam) {
                    this.agR.wi().b(this.agS);
                }
                vo();
                uR = this.agS.uQ();
                break;
            case 2:
                if (vm().wi().mIsUseCurrentBDUSS) {
                    vm().wi().a(this.agS);
                }
                if (vm().wi().mIsNeedAddCommenParam) {
                    this.agR.wi().b(this.agS);
                }
                vo();
                uR = this.agS.uP();
                break;
            case 3:
                if (vm().wi().mIsUseCurrentBDUSS) {
                    vm().wi().a(this.agS);
                }
                if (vm().wi().mIsNeedAddCommenParam) {
                    this.agR.wi().b(this.agS);
                }
                vt();
                uR = this.agS.uR();
                break;
            default:
                return null;
        }
        if (!this.agR.wj().vp()) {
            z.a(this.agU);
            z.cK(this.agV);
            return uR;
        } else if (!this.agR.wj().isRequestSuccess()) {
            if (this.agR.wj().aiT == 1 && this.agR.wi().aiQ) {
                String str = this.agR.wj().mErrorString;
                this.agR.wj().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.pk();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    vu();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cA(currentAccountObj.getAccount());
                if (ReloginManager.uz().uD()) {
                    AccountData uC = ReloginManager.uz().uC();
                    if (uC == null) {
                        ReloginManager.uz().f(uC);
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
                        this.agR.wj().mErrorString = this.agT.getErrorString();
                        return null;
                    }
                    this.agR.wj().mErrorString = str;
                    return uR;
                }
                uR = cH(i);
            }
            com.baidu.tieba.h.a.a(this);
            return uR;
        } else {
            return uR;
        }
    }

    private String cH(int i) {
        String uR;
        vn();
        switch (i) {
            case 1:
                uR = this.agS.uQ();
                break;
            case 2:
                uR = this.agS.uP();
                break;
            case 3:
                uR = this.agS.uR();
                break;
            default:
                return null;
        }
        if (this.agR.wj().vp()) {
            switch (this.agR.wj().aiT) {
                case 1:
                case 2:
                case 5:
                    vu();
                    this.agR.wj().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uR;
            }
        }
        return uR;
    }

    private void vu() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String uP() {
        return cG(2);
    }

    public String uQ() {
        return cG(1);
    }

    public String uR() {
        return cG(3);
    }

    public String dT(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dE = k.dE(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dE.read(bArr2);
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
        return uR();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vm().wi().a(this.agS);
        return this.agS.a(str, handler, i, i2, i3, z);
    }
}
