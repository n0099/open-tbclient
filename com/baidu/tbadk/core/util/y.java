package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class y {
    private com.baidu.tbadk.core.util.a.a apt = null;
    private r apu = null;
    private y apv = null;
    private ab.a apw = null;
    private int apx = 0;

    private void yL() {
        this.apt = new com.baidu.tbadk.core.util.a.a();
        this.apu = aa.yW().a(this.apt);
        this.apv = null;
        this.apt.zK().zN().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aB(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a yM() {
        return this.apt;
    }

    public y() {
        yL();
    }

    public y(String str) {
        yL();
        this.apt.zK().zN().mUrl = str;
    }

    public void setUrl(String str) {
        this.apt.zK().zN().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.apu.p(arrayList);
    }

    public void o(String str, String str2) {
        this.apu.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.apu.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.apu.d(str, bArr);
    }

    private void yN() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> yn = this.apu.yn();
            int size = yn.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = yn.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    yn.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    yn.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void yO() {
        if (this.apw == null) {
            this.apw = ab.yX();
        }
        if (this.apw != null) {
            this.apu.o("stTime", String.valueOf(this.apw.mTime));
            this.apu.o("stSize", String.valueOf(this.apw.apO));
            this.apu.o("stTimesNum", String.valueOf(this.apw.apP));
            this.apu.o("stMode", String.valueOf(this.apw.mMode));
            this.apu.o("stMethod", String.valueOf(this.apw.apN));
        }
        this.apx = ab.cJ(0);
        if (this.apx == 0 && this.apw != null) {
            this.apx = this.apw.apP;
        }
        this.apu.o("stErrorNums", String.valueOf(this.apx));
    }

    public boolean yP() {
        return this.apt.zL().yP();
    }

    public int yQ() {
        return this.apt.zL().arV;
    }

    public int yR() {
        return this.apt.zL().zV;
    }

    public String yS() {
        return this.apt.zL().arW;
    }

    public String getErrorString() {
        return this.apt.zL().mErrorString;
    }

    public void hN() {
        if (this.apu != null) {
            this.apu.hN();
        }
        if (this.apv != null) {
            this.apv.hN();
        }
    }

    public void hQ() {
        if (this.apu != null) {
            this.apu.hQ();
        }
        if (this.apv != null) {
            this.apv.hQ();
        }
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String yo;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.apv == null) {
                this.apv = new y(sb.toString());
            } else {
                this.apv.hN();
            }
            this.apv.yM().zK().mIsNeedAddCommenParam = false;
            this.apv.yM().zK().mIsUseCurrentBDUSS = false;
            this.apv.yM().zK().arS = false;
            this.apv.o("un", str);
            this.apv.o("passwd", str2);
            this.apv.o("isphone", "0");
            this.apv.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.apv.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.apv.yM().zK().zN().ast = true;
            yo = this.apv.yo();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.apv.yM().zL().isRequestSuccess() && yo != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(yo);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.apt.zL().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(f.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aeVar.getUser().getUserName());
            if (aeVar.getUser().getPassword() != null) {
                accountData.setPassword(aeVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aeVar.getUser().getUserId());
            accountData.setBDUSS(aeVar.getUser().getBDUSS());
            accountData.setPortrait(aeVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aeVar.ug() != null) {
                accountData.setTbs(aeVar.ug().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.apv.yP()) {
            switch (this.apv.yQ()) {
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

    public byte[] yp() {
        if (!this.apt.zK().mIsFromCDN) {
            this.apt.zK().b(this.apu);
        }
        return this.apu.yp();
    }

    private void yT() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> yn = this.apu.yn();
        for (int i = 0; yn != null && i < yn.size(); i++) {
            BasicNameValuePair basicNameValuePair = yn.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.apu.o("sign", com.baidu.adp.lib.util.s.bm(stringBuffer.toString()));
    }

    private String cG(int i) {
        String yr;
        switch (i) {
            case 1:
                if (yM().zK().mIsNeedAddCommenParam) {
                    this.apt.zK().b(this.apu);
                }
                yO();
                yr = this.apu.yq();
                break;
            case 2:
                if (yM().zK().mIsUseCurrentBDUSS) {
                    yM().zK().a(this.apu);
                }
                if (yM().zK().mIsNeedAddCommenParam) {
                    this.apt.zK().b(this.apu);
                }
                yO();
                yr = this.apu.yo();
                break;
            case 3:
                if (yM().zK().mIsUseCurrentBDUSS) {
                    yM().zK().a(this.apu);
                }
                if (yM().zK().mIsNeedAddCommenParam) {
                    this.apt.zK().b(this.apu);
                }
                yT();
                yr = this.apu.yr();
                break;
            default:
                return null;
        }
        if (!this.apt.zL().yP()) {
            ab.a(this.apw);
            ab.cK(this.apx);
            return yr;
        } else if (!this.apt.zL().isRequestSuccess()) {
            if (this.apt.zL().arV == 1 && this.apt.zK().arS) {
                String str = this.apt.zL().mErrorString;
                this.apt.zL().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.tp();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    yU();
                    return null;
                }
                com.baidu.tbadk.core.a.b.dd(currentAccountObj.getID());
                if (ReloginManager.xT().xW()) {
                    f(currentAccountObj);
                    ReloginManager.xT().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (e == null) {
                    if (this.apv != null) {
                        this.apt.zL().mErrorString = this.apv.getErrorString();
                        return null;
                    }
                    this.apt.zL().mErrorString = str;
                    return yr;
                }
                yr = cH(i);
            }
            com.baidu.tieba.i.a.a(this);
            return yr;
        } else {
            return yr;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c Bu;
        if (!TextUtils.isEmpty(accountData.getID()) && (Bu = com.baidu.tbadk.coreExtra.a.a.Bu()) != null) {
            Bu.f(accountData);
        }
    }

    private String cH(int i) {
        String yr;
        yN();
        switch (i) {
            case 1:
                yr = this.apu.yq();
                break;
            case 2:
                yr = this.apu.yo();
                break;
            case 3:
                yr = this.apu.yr();
                break;
            default:
                return null;
        }
        if (this.apt.zL().yP()) {
            switch (this.apt.zL().arV) {
                case 1:
                case 2:
                case 5:
                    yU();
                    this.apt.zL().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return yr;
            }
        }
        return yr;
    }

    private void yU() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String yo() {
        return cG(2);
    }

    public String yq() {
        return cG(1);
    }

    public String yr() {
        return cG(3);
    }

    public String eB(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream ek = l.ek(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = ek.read(bArr2);
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
        return yr();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        yM().zK().a(this.apu);
        return this.apu.a(str, handler, i, i2, i3, z);
    }
}
