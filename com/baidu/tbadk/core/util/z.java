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
import com.baidu.tieba.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class z {
    private com.baidu.tbadk.core.util.a.a aaT = null;
    private s aaU = null;
    private z aaV = null;
    private ad.a aaW = null;
    private int aaX = 0;

    private void uV() {
        this.aaT = new com.baidu.tbadk.core.util.a.a();
        this.aaU = ac.vf().a(this.aaT);
        this.aaV = null;
        this.aaT.vR().vU().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ag(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uW() {
        return this.aaT;
    }

    public z() {
        uV();
    }

    public z(String str) {
        uV();
        this.aaT.vR().vU().mUrl = str;
    }

    public void setUrl(String str) {
        this.aaT.vR().vU().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.aaU.l(arrayList);
    }

    public void n(String str, String str2) {
        this.aaU.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aaU.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aaU.d(str, bArr);
    }

    private void uX() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ux = this.aaU.ux();
            int size = ux.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ux.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ux.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ux.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uY() {
        if (this.aaW == null) {
            this.aaW = ad.vg();
        }
        if (this.aaW != null) {
            this.aaU.n("stTime", String.valueOf(this.aaW.mTime));
            this.aaU.n("stSize", String.valueOf(this.aaW.abo));
            this.aaU.n("stTimesNum", String.valueOf(this.aaW.abp));
            this.aaU.n("stMode", String.valueOf(this.aaW.mMode));
            this.aaU.n("stMethod", String.valueOf(this.aaW.abn));
        }
        this.aaX = ad.cF(0);
        if (this.aaX == 0 && this.aaW != null) {
            this.aaX = this.aaW.abp;
        }
        this.aaU.n("stErrorNums", String.valueOf(this.aaX));
    }

    public boolean uZ() {
        return this.aaT.vS().uZ();
    }

    public int va() {
        return this.aaT.vS().adb;
    }

    public int vb() {
        return this.aaT.vS().oF;
    }

    public String vc() {
        return this.aaT.vS().adc;
    }

    public String getErrorString() {
        return this.aaT.vS().mErrorString;
    }

    public void eg() {
        if (this.aaU != null) {
            this.aaU.eg();
        }
        if (this.aaV != null) {
            this.aaV.eg();
        }
    }

    public void ej() {
        if (this.aaU != null) {
            this.aaU.ej();
        }
        if (this.aaV != null) {
            this.aaV.ej();
        }
    }

    private com.baidu.tbadk.core.data.ai d(String str, String str2, boolean z) {
        String uy;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aaV == null) {
                this.aaV = new z(sb.toString());
            } else {
                this.aaV.eg();
            }
            this.aaV.uW().vR().mIsNeedAddCommenParam = false;
            this.aaV.uW().vR().mIsUseCurrentBDUSS = false;
            this.aaV.uW().vR().acY = false;
            this.aaV.n("un", str);
            this.aaV.n("passwd", str2);
            this.aaV.n("isphone", "0");
            this.aaV.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aaV.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aaV.uW().vR().vU().adA = true;
            uy = this.aaV.uy();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aaV.uW().vS().oH() && uy != null) {
            com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
            aiVar.parserJson(uy);
            String userId = aiVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aaT.vS().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(r.j.neterror);
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
            if (aiVar.qs() != null) {
                accountData.setTbs(aiVar.qs().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return aiVar;
        }
        if (this.aaV.uZ()) {
            switch (this.aaV.va()) {
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

    public byte[] uz() {
        if (!this.aaT.vR().mIsFromCDN) {
            this.aaT.vR().b(this.aaU);
        }
        return this.aaU.uz();
    }

    private void vd() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ux = this.aaU.ux();
        for (int i = 0; ux != null && i < ux.size(); i++) {
            BasicNameValuePair basicNameValuePair = ux.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aaU.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aU(stringBuffer.toString()));
    }

    private String cC(int i) {
        String uB;
        com.baidu.tbadk.coreExtra.a.c xv;
        switch (i) {
            case 1:
                if (uW().vR().mIsNeedAddCommenParam) {
                    this.aaT.vR().b(this.aaU);
                }
                uY();
                uB = this.aaU.uA();
                break;
            case 2:
                if (uW().vR().mIsUseCurrentBDUSS) {
                    uW().vR().a(this.aaU);
                }
                if (uW().vR().mIsNeedAddCommenParam) {
                    this.aaT.vR().b(this.aaU);
                }
                uY();
                uB = this.aaU.uy();
                break;
            case 3:
                if (uW().vR().mIsUseCurrentBDUSS) {
                    uW().vR().a(this.aaU);
                }
                if (uW().vR().mIsNeedAddCommenParam) {
                    this.aaT.vR().b(this.aaU);
                }
                vd();
                uB = this.aaU.uB();
                break;
            default:
                return null;
        }
        if (!this.aaT.vS().uZ()) {
            ad.a(this.aaW);
            ad.cG(this.aaX);
            return uB;
        } else if (!this.aaT.vS().oH() && this.aaT.vS().adb == 1 && this.aaT.vR().acY) {
            String str = this.aaT.vS().mErrorString;
            this.aaT.vS().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.oV();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.ch(currentAccountObj.getAccount());
            if (ReloginManager.ug().ul()) {
                AccountData uk = ReloginManager.ug().uk();
                if (uk == null) {
                    ReloginManager.ug().f(uk);
                    return null;
                }
                return cD(i);
            }
            com.baidu.tbadk.core.data.ai d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xv = com.baidu.tbadk.coreExtra.a.a.xv()) != null) {
                xv.h(currentAccountObj);
            }
            if (d == null) {
                if (this.aaV != null) {
                    this.aaT.vS().mErrorString = this.aaV.getErrorString();
                    return null;
                }
                this.aaT.vS().mErrorString = str;
                return uB;
            }
            return cD(i);
        } else {
            return uB;
        }
    }

    private String cD(int i) {
        String uB;
        uX();
        switch (i) {
            case 1:
                uB = this.aaU.uA();
                break;
            case 2:
                uB = this.aaU.uy();
                break;
            case 3:
                uB = this.aaU.uB();
                break;
            default:
                return null;
        }
        if (this.aaT.vS().uZ()) {
            switch (this.aaT.vS().adb) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.aaT.vS().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uB;
            }
        }
        return uB;
    }

    public String uy() {
        return cC(2);
    }

    public String uA() {
        return cC(1);
    }

    public String uB() {
        return cC(3);
    }

    public String ds(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream de = m.de(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = de.read(bArr2);
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
        return uB();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uW().vR().a(this.aaU);
        return this.aaU.a(str, handler, i, i2, i3, z);
    }
}
