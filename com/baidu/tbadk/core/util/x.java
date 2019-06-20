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
    private boolean bRg;
    private com.baidu.tbadk.core.util.a.a bRd = null;
    private q bRe = null;
    private x bRf = null;
    private aa.a bRh = null;
    private int bRi = 0;

    private void ahB() {
        this.bRd = new com.baidu.tbadk.core.util.a.a();
        this.bRe = z.ahM().a(this.bRd);
        this.bRf = null;
        this.bRd.aiB().aiE().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a ahC() {
        return this.bRd;
    }

    public x() {
        ahB();
    }

    public x(String str) {
        ahB();
        this.bRd.aiB().aiE().mUrl = str;
    }

    public void setUrl(String str) {
        this.bRd.aiB().aiE().mUrl = str;
    }

    public void u(ArrayList<BasicNameValuePair> arrayList) {
        this.bRe.u(arrayList);
    }

    public void o(String str, String str2) {
        this.bRe.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bRe.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bRe.d(str, bArr);
    }

    private void ahD() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ahd = this.bRe.ahd();
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
        if (this.bRh == null) {
            this.bRh = aa.ahN();
        }
        if (this.bRh != null) {
            this.bRe.o("stTime", String.valueOf(this.bRh.mTime));
            this.bRe.o("stSize", String.valueOf(this.bRh.aVH));
            this.bRe.o("stTimesNum", String.valueOf(this.bRh.bRy));
            this.bRe.o("stMode", String.valueOf(this.bRh.mMode));
            this.bRe.o("stMethod", String.valueOf(this.bRh.bRx));
        }
        this.bRi = aa.hT(0);
        if (this.bRi == 0 && this.bRh != null) {
            this.bRi = this.bRh.bRy;
        }
        this.bRe.o("stErrorNums", String.valueOf(this.bRi));
    }

    public boolean ahF() {
        return this.bRd.aiC().ahF();
    }

    public int ahG() {
        return this.bRd.aiC().bTH;
    }

    public int ahH() {
        return this.bRd.aiC().AK;
    }

    public String ahI() {
        return this.bRd.aiC().bTI;
    }

    public String getErrorString() {
        return this.bRd.aiC().mErrorString;
    }

    public void ia() {
        if (this.bRe != null) {
            this.bRe.ia();
        }
        if (this.bRf != null) {
            this.bRf.ia();
        }
    }

    public void ie() {
        if (this.bRe != null) {
            this.bRe.ie();
        }
        if (this.bRf != null) {
            this.bRf.ie();
        }
    }

    public void dX(boolean z) {
        this.bRg = z;
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
            if (this.bRf == null) {
                this.bRf = new x(sb.toString());
            } else {
                this.bRf.ia();
            }
            this.bRf.ahC().aiB().mIsNeedAddCommenParam = false;
            this.bRf.ahC().aiB().mIsUseCurrentBDUSS = false;
            this.bRf.ahC().aiB().bTF = false;
            this.bRf.o("un", str);
            this.bRf.o("passwd", str2);
            this.bRf.o("isphone", "0");
            this.bRf.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bRf.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bRf.ahC().aiB().aiE().bUf = true;
            ahe = this.bRf.ahe();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bRf.ahC().aiC().isRequestSuccess() && ahe != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(ahe);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bRd.aiC().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.bRf.ahF()) {
            switch (this.bRf.ahG()) {
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
        if (!this.bRd.aiB().mIsFromCDN) {
            this.bRd.aiB().b(this.bRe);
        }
        return this.bRe.ahf();
    }

    private void ahJ() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ahd = this.bRe.ahd();
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
        this.bRe.o("sign", com.baidu.adp.lib.util.s.bm(stringBuffer.toString()));
        if (this.bRd.aiB().bRg) {
            this.bRe.o("sig", StringU.rs(stringBuffer.toString()));
        }
    }

    private String hQ(int i) {
        String ahh;
        this.bRd.aiB().bRg = this.bRg && com.baidu.tbadk.t.w.iE();
        switch (i) {
            case 1:
                if (ahC().aiB().mIsNeedAddCommenParam) {
                    this.bRd.aiB().b(this.bRe);
                }
                ahE();
                ahh = this.bRe.ahg();
                break;
            case 2:
                if (ahC().aiB().mIsUseCurrentBDUSS) {
                    ahC().aiB().a(this.bRe);
                }
                if (ahC().aiB().mIsNeedAddCommenParam) {
                    this.bRd.aiB().b(this.bRe);
                }
                ahE();
                ahh = this.bRe.ahe();
                break;
            case 3:
                if (ahC().aiB().mIsUseCurrentBDUSS) {
                    ahC().aiB().a(this.bRe);
                }
                if (ahC().aiB().mIsNeedAddCommenParam) {
                    this.bRd.aiB().b(this.bRe);
                }
                ahJ();
                ahh = this.bRe.ahh();
                break;
            default:
                return null;
        }
        if (!this.bRd.aiC().ahF()) {
            aa.a(this.bRh);
            aa.hU(this.bRi);
            return ahh;
        } else if (!this.bRd.aiC().isRequestSuccess()) {
            if (this.bRd.aiC().bTH == 1 && this.bRd.aiB().bTF) {
                String str = this.bRd.aiC().mErrorString;
                this.bRd.aiC().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.abk();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    ahK();
                    return null;
                }
                com.baidu.tbadk.core.a.b.mb(currentAccountObj.getID());
                if (ReloginManager.agF().agI()) {
                    f(currentAccountObj);
                    ReloginManager.agF().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag r = r(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (r == null) {
                    if (this.bRf != null) {
                        this.bRd.aiC().mErrorString = this.bRf.getErrorString();
                        return null;
                    }
                    this.bRd.aiC().mErrorString = str;
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
                ahh = this.bRe.ahg();
                break;
            case 2:
                ahh = this.bRe.ahe();
                break;
            case 3:
                ahh = this.bRe.ahh();
                break;
            default:
                return null;
        }
        if (this.bRd.aiC().ahF()) {
            switch (this.bRd.aiC().bTH) {
                case 1:
                case 2:
                case 5:
                    ahK();
                    this.bRd.aiC().mErrorString = "";
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

    public String nF(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream np = m.np(str);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
            while (true) {
                int read = np.read(bArr2);
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
        ahC().aiB().a(this.bRe);
        return this.bRe.a(str, handler, i, i2, i3, z);
    }
}
