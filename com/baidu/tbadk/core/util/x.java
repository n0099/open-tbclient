package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private boolean bRf;
    private com.baidu.tbadk.core.util.a.a bRc = null;
    private q bRd = null;
    private x bRe = null;
    private aa.a bRg = null;
    private int bRh = 0;

    private void ahB() {
        this.bRc = new com.baidu.tbadk.core.util.a.a();
        this.bRd = z.ahM().a(this.bRc);
        this.bRe = null;
        this.bRc.aiB().aiE().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a ahC() {
        return this.bRc;
    }

    public x() {
        ahB();
    }

    public x(String str) {
        ahB();
        this.bRc.aiB().aiE().mUrl = str;
    }

    public void setUrl(String str) {
        this.bRc.aiB().aiE().mUrl = str;
    }

    public void u(ArrayList<BasicNameValuePair> arrayList) {
        this.bRd.u(arrayList);
    }

    public void o(String str, String str2) {
        this.bRd.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bRd.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bRd.d(str, bArr);
    }

    private void ahD() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ahd = this.bRd.ahd();
            int size = ahd.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ahd.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ahd.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ahd.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void ahE() {
        if (this.bRg == null) {
            this.bRg = aa.ahN();
        }
        if (this.bRg != null) {
            this.bRd.o("stTime", String.valueOf(this.bRg.mTime));
            this.bRd.o("stSize", String.valueOf(this.bRg.aVH));
            this.bRd.o("stTimesNum", String.valueOf(this.bRg.bRx));
            this.bRd.o("stMode", String.valueOf(this.bRg.mMode));
            this.bRd.o("stMethod", String.valueOf(this.bRg.bRw));
        }
        this.bRh = aa.hT(0);
        if (this.bRh == 0 && this.bRg != null) {
            this.bRh = this.bRg.bRx;
        }
        this.bRd.o("stErrorNums", String.valueOf(this.bRh));
    }

    public boolean ahF() {
        return this.bRc.aiC().ahF();
    }

    public int ahG() {
        return this.bRc.aiC().bTG;
    }

    public int ahH() {
        return this.bRc.aiC().AM;
    }

    public String ahI() {
        return this.bRc.aiC().bTH;
    }

    public String getErrorString() {
        return this.bRc.aiC().mErrorString;
    }

    public void ia() {
        if (this.bRd != null) {
            this.bRd.ia();
        }
        if (this.bRe != null) {
            this.bRe.ia();
        }
    }

    public void ie() {
        if (this.bRd != null) {
            this.bRd.ie();
        }
        if (this.bRe != null) {
            this.bRe.ie();
        }
    }

    public void dX(boolean z) {
        this.bRf = z;
    }

    private com.baidu.tbadk.core.data.ag r(String str, String str2, boolean z) {
        String ahe;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.bRe == null) {
                this.bRe = new x(sb.toString());
            } else {
                this.bRe.ia();
            }
            this.bRe.ahC().aiB().mIsNeedAddCommenParam = false;
            this.bRe.ahC().aiB().mIsUseCurrentBDUSS = false;
            this.bRe.ahC().aiB().bTE = false;
            this.bRe.o("un", str);
            this.bRe.o("passwd", str2);
            this.bRe.o("isphone", "0");
            this.bRe.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bRe.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bRe.ahC().aiB().aiE().bUe = true;
            ahe = this.bRe.ahe();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bRe.ahC().aiC().isRequestSuccess() && ahe != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(ahe);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bRc.aiC().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(agVar.getUser().getUserName());
            if (agVar.getUser().getPassword() != null) {
                accountData.setPassword(agVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(agVar.getUser().getUserId());
            accountData.setBDUSS(agVar.getUser().getBDUSS());
            accountData.setPortrait(agVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (agVar.getAnti() != null) {
                accountData.setTbs(agVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return agVar;
        }
        if (this.bRe.ahF()) {
            switch (this.bRe.ahG()) {
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

    public byte[] ahf() {
        if (!this.bRc.aiB().mIsFromCDN) {
            this.bRc.aiB().b(this.bRd);
        }
        return this.bRd.ahf();
    }

    private void ahJ() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ahd = this.bRd.ahd();
        for (int i = 0; ahd != null && i < ahd.size(); i++) {
            BasicNameValuePair basicNameValuePair = ahd.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.bRd.o("sign", com.baidu.adp.lib.util.s.bm(stringBuffer.toString()));
        if (this.bRc.aiB().bRf) {
            this.bRd.o("sig", StringU.rt(stringBuffer.toString()));
        }
    }

    private String hQ(int i) {
        String ahh;
        this.bRc.aiB().bRf = this.bRf && com.baidu.tbadk.t.w.iE();
        switch (i) {
            case 1:
                if (ahC().aiB().mIsNeedAddCommenParam) {
                    this.bRc.aiB().b(this.bRd);
                }
                ahE();
                ahh = this.bRd.ahg();
                break;
            case 2:
                if (ahC().aiB().mIsUseCurrentBDUSS) {
                    ahC().aiB().a(this.bRd);
                }
                if (ahC().aiB().mIsNeedAddCommenParam) {
                    this.bRc.aiB().b(this.bRd);
                }
                ahE();
                ahh = this.bRd.ahe();
                break;
            case 3:
                if (ahC().aiB().mIsUseCurrentBDUSS) {
                    ahC().aiB().a(this.bRd);
                }
                if (ahC().aiB().mIsNeedAddCommenParam) {
                    this.bRc.aiB().b(this.bRd);
                }
                ahJ();
                ahh = this.bRd.ahh();
                break;
            default:
                return null;
        }
        if (!this.bRc.aiC().ahF()) {
            aa.a(this.bRg);
            aa.hU(this.bRh);
            return ahh;
        } else if (!this.bRc.aiC().isRequestSuccess()) {
            if (this.bRc.aiC().bTG == 1 && this.bRc.aiB().bTE) {
                String str = this.bRc.aiC().mErrorString;
                this.bRc.aiC().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.abk();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    ahK();
                    return null;
                }
                com.baidu.tbadk.core.a.b.mc(currentAccountObj.getID());
                if (ReloginManager.agF().agI()) {
                    f(currentAccountObj);
                    ReloginManager.agF().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag r = r(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (r == null) {
                    if (this.bRe != null) {
                        this.bRc.aiC().mErrorString = this.bRe.getErrorString();
                        return null;
                    }
                    this.bRc.aiC().mErrorString = str;
                    return ahh;
                }
                ahh = hR(i);
            }
            com.baidu.tieba.i.a.a(this);
            return ahh;
        } else {
            return ahh;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c akD;
        if (!TextUtils.isEmpty(accountData.getID()) && (akD = com.baidu.tbadk.coreExtra.a.a.akD()) != null) {
            akD.f(accountData);
        }
    }

    private String hR(int i) {
        String ahh;
        ahD();
        switch (i) {
            case 1:
                ahh = this.bRd.ahg();
                break;
            case 2:
                ahh = this.bRd.ahe();
                break;
            case 3:
                ahh = this.bRd.ahh();
                break;
            default:
                return null;
        }
        if (this.bRc.aiC().ahF()) {
            switch (this.bRc.aiC().bTG) {
                case 1:
                case 2:
                case 5:
                    ahK();
                    this.bRc.aiC().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return ahh;
            }
        }
        return ahh;
    }

    private void ahK() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String ahe() {
        return hQ(2);
    }

    public String ahg() {
        return hQ(1);
    }

    public String ahh() {
        return hQ(3);
    }

    public String nG(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream nq = m.nq(str);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
            while (true) {
                int read = nq.read(bArr2);
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
        return ahh();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        ahC().aiB().a(this.bRd);
        return this.bRd.a(str, handler, i, i2, i3, z);
    }
}
