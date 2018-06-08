package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
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
    private com.baidu.tbadk.core.util.a.a aps = null;
    private r apt = null;
    private y apu = null;
    private ab.a apv = null;
    private int apw = 0;

    private void yI() {
        this.aps = new com.baidu.tbadk.core.util.a.a();
        this.apt = aa.yT().a(this.aps);
        this.apu = null;
        this.aps.zI().zL().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aA(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a yJ() {
        return this.aps;
    }

    public y() {
        yI();
    }

    public y(String str) {
        yI();
        this.aps.zI().zL().mUrl = str;
    }

    public void setUrl(String str) {
        this.aps.zI().zL().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.apt.l(arrayList);
    }

    public void o(String str, String str2) {
        this.apt.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.apt.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.apt.d(str, bArr);
    }

    private void yK() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> yk = this.apt.yk();
            int size = yk.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = yk.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    yk.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    yk.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void yL() {
        if (this.apv == null) {
            this.apv = ab.yU();
        }
        if (this.apv != null) {
            this.apt.o("stTime", String.valueOf(this.apv.mTime));
            this.apt.o("stSize", String.valueOf(this.apv.apN));
            this.apt.o("stTimesNum", String.valueOf(this.apv.apO));
            this.apt.o("stMode", String.valueOf(this.apv.mMode));
            this.apt.o("stMethod", String.valueOf(this.apv.apM));
        }
        this.apw = ab.cG(0);
        if (this.apw == 0 && this.apv != null) {
            this.apw = this.apv.apO;
        }
        this.apt.o("stErrorNums", String.valueOf(this.apw));
    }

    public boolean yM() {
        return this.aps.zJ().yM();
    }

    public int yN() {
        return this.aps.zJ().arO;
    }

    public int yO() {
        return this.aps.zJ().Ab;
    }

    public String yP() {
        return this.aps.zJ().arP;
    }

    public String getErrorString() {
        return this.aps.zJ().mErrorString;
    }

    public void hN() {
        if (this.apt != null) {
            this.apt.hN();
        }
        if (this.apu != null) {
            this.apu.hN();
        }
    }

    public void hP() {
        if (this.apt != null) {
            this.apt.hP();
        }
        if (this.apu != null) {
            this.apu.hP();
        }
    }

    private com.baidu.tbadk.core.data.af f(String str, String str2, boolean z) {
        String yl;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.apu == null) {
                this.apu = new y(sb.toString());
            } else {
                this.apu.hN();
            }
            this.apu.yJ().zI().mIsNeedAddCommenParam = false;
            this.apu.yJ().zI().mIsUseCurrentBDUSS = false;
            this.apu.yJ().zI().arL = false;
            this.apu.o("un", str);
            this.apu.o("passwd", str2);
            this.apu.o("isphone", "0");
            this.apu.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.apu.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.apu.yJ().zI().zL().asm = true;
            yl = this.apu.yl();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.apu.yJ().zJ().isRequestSuccess() && yl != null) {
            com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
            afVar.parserJson(yl);
            String userId = afVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aps.zJ().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.k.neterror);
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
            if (afVar.uo() != null) {
                accountData.setTbs(afVar.uo().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return afVar;
        }
        if (this.apu.yM()) {
            switch (this.apu.yN()) {
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

    public byte[] ym() {
        if (!this.aps.zI().mIsFromCDN) {
            this.aps.zI().b(this.apt);
        }
        return this.apt.ym();
    }

    private void yQ() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> yk = this.apt.yk();
        for (int i = 0; yk != null && i < yk.size(); i++) {
            BasicNameValuePair basicNameValuePair = yk.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.apt.o("sign", com.baidu.adp.lib.util.s.bj(stringBuffer.toString()));
    }

    private String cD(int i) {
        String yo;
        com.baidu.tbadk.coreExtra.a.c Bn;
        switch (i) {
            case 1:
                if (yJ().zI().mIsNeedAddCommenParam) {
                    this.aps.zI().b(this.apt);
                }
                yL();
                yo = this.apt.yn();
                break;
            case 2:
                if (yJ().zI().mIsUseCurrentBDUSS) {
                    yJ().zI().a(this.apt);
                }
                if (yJ().zI().mIsNeedAddCommenParam) {
                    this.aps.zI().b(this.apt);
                }
                yL();
                yo = this.apt.yl();
                break;
            case 3:
                if (yJ().zI().mIsUseCurrentBDUSS) {
                    yJ().zI().a(this.apt);
                }
                if (yJ().zI().mIsNeedAddCommenParam) {
                    this.aps.zI().b(this.apt);
                }
                yQ();
                yo = this.apt.yo();
                break;
            default:
                return null;
        }
        if (!this.aps.zJ().yM()) {
            ab.a(this.apv);
            ab.cH(this.apw);
            return yo;
        } else if (!this.aps.zJ().isRequestSuccess()) {
            if (this.aps.zJ().arO == 1 && this.aps.zI().arL) {
                String str = this.aps.zJ().mErrorString;
                this.aps.zJ().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.tE();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    yR();
                    return null;
                }
                com.baidu.tbadk.core.a.b.dd(currentAccountObj.getID());
                if (ReloginManager.xP().xS()) {
                    ReloginManager.xP().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.af f = f(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (Bn = com.baidu.tbadk.coreExtra.a.a.Bn()) != null) {
                    Bn.h(currentAccountObj);
                }
                if (f == null) {
                    if (this.apu != null) {
                        this.aps.zJ().mErrorString = this.apu.getErrorString();
                        return null;
                    }
                    this.aps.zJ().mErrorString = str;
                    return yo;
                }
                yo = cE(i);
            }
            com.baidu.tieba.i.a.a(this);
            return yo;
        } else {
            return yo;
        }
    }

    private String cE(int i) {
        String yo;
        yK();
        switch (i) {
            case 1:
                yo = this.apt.yn();
                break;
            case 2:
                yo = this.apt.yl();
                break;
            case 3:
                yo = this.apt.yo();
                break;
            default:
                return null;
        }
        if (this.aps.zJ().yM()) {
            switch (this.aps.zJ().arO) {
                case 1:
                case 2:
                case 5:
                    yR();
                    this.aps.zJ().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return yo;
            }
        }
        return yo;
    }

    private void yR() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String yl() {
        return cD(2);
    }

    public String yn() {
        return cD(1);
    }

    public String yo() {
        return cD(3);
    }

    public String eA(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream ej = l.ej(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = ej.read(bArr2);
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
        return yo();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        yJ().zI().a(this.apt);
        return this.apt.a(str, handler, i, i2, i3, z);
    }
}
