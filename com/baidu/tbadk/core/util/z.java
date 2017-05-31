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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class z {
    private com.baidu.tbadk.core.util.a.a aeq = null;
    private s aer = null;
    private z aes = null;
    private ad.a aet = null;
    private int aeu = 0;

    private void uE() {
        this.aeq = new com.baidu.tbadk.core.util.a.a();
        this.aer = ac.uP().a(this.aeq);
        this.aes = null;
        this.aeq.vA().vD().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ab(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uF() {
        return this.aeq;
    }

    public z() {
        uE();
    }

    public z(String str) {
        uE();
        this.aeq.vA().vD().mUrl = str;
    }

    public void setUrl(String str) {
        this.aeq.vA().vD().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.aer.k(arrayList);
    }

    public void n(String str, String str2) {
        this.aer.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aer.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aer.d(str, bArr);
    }

    private void uG() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uf = this.aer.uf();
            int size = uf.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uf.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uf.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uf.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uH() {
        if (this.aet == null) {
            this.aet = ad.uQ();
        }
        if (this.aet != null) {
            this.aer.n("stTime", String.valueOf(this.aet.mTime));
            this.aer.n("stSize", String.valueOf(this.aet.aeK));
            this.aer.n("stTimesNum", String.valueOf(this.aet.aeL));
            this.aer.n("stMode", String.valueOf(this.aet.mMode));
            this.aer.n("stMethod", String.valueOf(this.aet.aeJ));
        }
        this.aeu = ad.cD(0);
        if (this.aeu == 0 && this.aet != null) {
            this.aeu = this.aet.aeL;
        }
        this.aer.n("stErrorNums", String.valueOf(this.aeu));
    }

    public boolean uI() {
        return this.aeq.vB().uI();
    }

    public int uJ() {
        return this.aeq.vB().agu;
    }

    public int uK() {
        return this.aeq.vB().vR;
    }

    public String uL() {
        return this.aeq.vB().agv;
    }

    public String getErrorString() {
        return this.aeq.vB().mErrorString;
    }

    public void fs() {
        if (this.aer != null) {
            this.aer.fs();
        }
        if (this.aes != null) {
            this.aes.fs();
        }
    }

    public void fv() {
        if (this.aer != null) {
            this.aer.fv();
        }
        if (this.aes != null) {
            this.aes.fv();
        }
    }

    private com.baidu.tbadk.core.data.ak e(String str, String str2, boolean z) {
        String ug;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aes == null) {
                this.aes = new z(sb.toString());
            } else {
                this.aes.fs();
            }
            this.aes.uF().vA().mIsNeedAddCommenParam = false;
            this.aes.uF().vA().mIsUseCurrentBDUSS = false;
            this.aes.uF().vA().agr = false;
            this.aes.n("un", str);
            this.aes.n("passwd", str2);
            this.aes.n("isphone", "0");
            this.aes.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aes.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aes.uF().vA().vD().agS = true;
            ug = this.aes.ug();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aes.uF().vB().isRequestSuccess() && ug != null) {
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.parserJson(ug);
            String userId = akVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aeq.vB().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.neterror);
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
            if (akVar.qh() != null) {
                accountData.setTbs(akVar.qh().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return akVar;
        }
        if (this.aes.uI()) {
            switch (this.aes.uJ()) {
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

    public byte[] uh() {
        if (!this.aeq.vA().mIsFromCDN) {
            this.aeq.vA().b(this.aer);
        }
        return this.aer.uh();
    }

    private void uM() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uf = this.aer.uf();
        for (int i = 0; uf != null && i < uf.size(); i++) {
            BasicNameValuePair basicNameValuePair = uf.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aer.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aI(stringBuffer.toString()));
    }

    private String cA(int i) {
        String uk;
        com.baidu.tbadk.coreExtra.a.c xb;
        switch (i) {
            case 1:
                if (uF().vA().mIsNeedAddCommenParam) {
                    this.aeq.vA().b(this.aer);
                }
                uH();
                uk = this.aer.uj();
                break;
            case 2:
                if (uF().vA().mIsUseCurrentBDUSS) {
                    uF().vA().a(this.aer);
                }
                if (uF().vA().mIsNeedAddCommenParam) {
                    this.aeq.vA().b(this.aer);
                }
                uH();
                uk = this.aer.ug();
                break;
            case 3:
                if (uF().vA().mIsUseCurrentBDUSS) {
                    uF().vA().a(this.aer);
                }
                if (uF().vA().mIsNeedAddCommenParam) {
                    this.aeq.vA().b(this.aer);
                }
                uM();
                uk = this.aer.uk();
                break;
            default:
                return null;
        }
        if (!this.aeq.vB().uI()) {
            ad.a(this.aet);
            ad.cE(this.aeu);
            return uk;
        } else if (!this.aeq.vB().isRequestSuccess()) {
            if (this.aeq.vB().agu == 1 && this.aeq.vA().agr) {
                String str = this.aeq.vB().mErrorString;
                this.aeq.vB().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.oZ();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    uN();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cg(currentAccountObj.getAccount());
                if (ReloginManager.tR().tV()) {
                    AccountData tU = ReloginManager.tR().tU();
                    if (tU == null) {
                        ReloginManager.tR().f(tU);
                        return null;
                    }
                    return cB(i);
                }
                com.baidu.tbadk.core.data.ak e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xb = com.baidu.tbadk.coreExtra.a.a.xb()) != null) {
                    xb.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.aes != null) {
                        this.aeq.vB().mErrorString = this.aes.getErrorString();
                        return null;
                    }
                    this.aeq.vB().mErrorString = str;
                    return uk;
                }
                uk = cB(i);
            }
            com.baidu.tieba.h.a.a(this);
            return uk;
        } else {
            return uk;
        }
    }

    private String cB(int i) {
        String uk;
        uG();
        switch (i) {
            case 1:
                uk = this.aer.uj();
                break;
            case 2:
                uk = this.aer.ug();
                break;
            case 3:
                uk = this.aer.uk();
                break;
            default:
                return null;
        }
        if (this.aeq.vB().uI()) {
            switch (this.aeq.vB().agu) {
                case 1:
                case 2:
                case 5:
                    uN();
                    this.aeq.vB().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uk;
            }
        }
        return uk;
    }

    private void uN() {
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String ug() {
        return cA(2);
    }

    public String uj() {
        return cA(1);
    }

    public String uk() {
        return cA(3);
    }

    public String dm(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream cY = l.cY(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = cY.read(bArr2);
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
        return uk();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uF().vA().a(this.aer);
        return this.aer.a(str, handler, i, i2, i3, z);
    }
}
