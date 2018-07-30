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
    private com.baidu.tbadk.core.util.a.a aps = null;
    private r apt = null;
    private y apu = null;
    private ab.a apv = null;
    private int apw = 0;

    private void yN() {
        this.aps = new com.baidu.tbadk.core.util.a.a();
        this.apt = aa.yY().a(this.aps);
        this.apu = null;
        this.aps.zM().zP().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aB(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a yO() {
        return this.aps;
    }

    public y() {
        yN();
    }

    public y(String str) {
        yN();
        this.aps.zM().zP().mUrl = str;
    }

    public void setUrl(String str) {
        this.aps.zM().zP().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.apt.p(arrayList);
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

    private void yP() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> yp = this.apt.yp();
            int size = yp.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = yp.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    yp.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    yp.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void yQ() {
        if (this.apv == null) {
            this.apv = ab.yZ();
        }
        if (this.apv != null) {
            this.apt.o("stTime", String.valueOf(this.apv.mTime));
            this.apt.o("stSize", String.valueOf(this.apv.apN));
            this.apt.o("stTimesNum", String.valueOf(this.apv.apO));
            this.apt.o("stMode", String.valueOf(this.apv.mMode));
            this.apt.o("stMethod", String.valueOf(this.apv.apM));
        }
        this.apw = ab.cJ(0);
        if (this.apw == 0 && this.apv != null) {
            this.apw = this.apv.apO;
        }
        this.apt.o("stErrorNums", String.valueOf(this.apw));
    }

    public boolean yR() {
        return this.aps.zN().yR();
    }

    public int yS() {
        return this.aps.zN().arU;
    }

    public int yT() {
        return this.aps.zN().zU;
    }

    public String yU() {
        return this.aps.zN().arV;
    }

    public String getErrorString() {
        return this.aps.zN().mErrorString;
    }

    public void hN() {
        if (this.apt != null) {
            this.apt.hN();
        }
        if (this.apu != null) {
            this.apu.hN();
        }
    }

    public void hQ() {
        if (this.apt != null) {
            this.apt.hQ();
        }
        if (this.apu != null) {
            this.apu.hQ();
        }
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String yq;
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
            this.apu.yO().zM().mIsNeedAddCommenParam = false;
            this.apu.yO().zM().mIsUseCurrentBDUSS = false;
            this.apu.yO().zM().arR = false;
            this.apu.o("un", str);
            this.apu.o("passwd", str2);
            this.apu.o("isphone", "0");
            this.apu.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.apu.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.apu.yO().zM().zP().ass = true;
            yq = this.apu.yq();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.apu.yO().zN().isRequestSuccess() && yq != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(yq);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aps.zN().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
            if (aeVar.uh() != null) {
                accountData.setTbs(aeVar.uh().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.apu.yR()) {
            switch (this.apu.yS()) {
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

    public byte[] yr() {
        if (!this.aps.zM().mIsFromCDN) {
            this.aps.zM().b(this.apt);
        }
        return this.apt.yr();
    }

    private void yV() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> yp = this.apt.yp();
        for (int i = 0; yp != null && i < yp.size(); i++) {
            BasicNameValuePair basicNameValuePair = yp.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.apt.o("sign", com.baidu.adp.lib.util.s.bm(stringBuffer.toString()));
    }

    private String cG(int i) {
        String yt;
        switch (i) {
            case 1:
                if (yO().zM().mIsNeedAddCommenParam) {
                    this.aps.zM().b(this.apt);
                }
                yQ();
                yt = this.apt.ys();
                break;
            case 2:
                if (yO().zM().mIsUseCurrentBDUSS) {
                    yO().zM().a(this.apt);
                }
                if (yO().zM().mIsNeedAddCommenParam) {
                    this.aps.zM().b(this.apt);
                }
                yQ();
                yt = this.apt.yq();
                break;
            case 3:
                if (yO().zM().mIsUseCurrentBDUSS) {
                    yO().zM().a(this.apt);
                }
                if (yO().zM().mIsNeedAddCommenParam) {
                    this.aps.zM().b(this.apt);
                }
                yV();
                yt = this.apt.yt();
                break;
            default:
                return null;
        }
        if (!this.aps.zN().yR()) {
            ab.a(this.apv);
            ab.cK(this.apw);
            return yt;
        } else if (!this.aps.zN().isRequestSuccess()) {
            if (this.aps.zN().arU == 1 && this.aps.zM().arR) {
                String str = this.aps.zN().mErrorString;
                this.aps.zN().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.tq();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    yW();
                    return null;
                }
                com.baidu.tbadk.core.a.b.dc(currentAccountObj.getID());
                if (ReloginManager.xU().xX()) {
                    f(currentAccountObj);
                    ReloginManager.xU().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (e == null) {
                    if (this.apu != null) {
                        this.aps.zN().mErrorString = this.apu.getErrorString();
                        return null;
                    }
                    this.aps.zN().mErrorString = str;
                    return yt;
                }
                yt = cH(i);
            }
            com.baidu.tieba.i.a.a(this);
            return yt;
        } else {
            return yt;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c Bx;
        if (!TextUtils.isEmpty(accountData.getID()) && (Bx = com.baidu.tbadk.coreExtra.a.a.Bx()) != null) {
            Bx.f(accountData);
        }
    }

    private String cH(int i) {
        String yt;
        yP();
        switch (i) {
            case 1:
                yt = this.apt.ys();
                break;
            case 2:
                yt = this.apt.yq();
                break;
            case 3:
                yt = this.apt.yt();
                break;
            default:
                return null;
        }
        if (this.aps.zN().yR()) {
            switch (this.aps.zN().arU) {
                case 1:
                case 2:
                case 5:
                    yW();
                    this.aps.zN().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return yt;
            }
        }
        return yt;
    }

    private void yW() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String yq() {
        return cG(2);
    }

    public String ys() {
        return cG(1);
    }

    public String yt() {
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
        return yt();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        yO().zM().a(this.apt);
        return this.apt.a(str, handler, i, i2, i3, z);
    }
}
