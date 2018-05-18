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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private com.baidu.tbadk.core.util.a.a ahl = null;
    private q ahm = null;
    private x ahn = null;
    private aa.a aho = null;
    private int ahp = 0;

    private void vh() {
        this.ahl = new com.baidu.tbadk.core.util.a.a();
        this.ahm = z.vs().a(this.ahl);
        this.ahn = null;
        this.ahl.wh().wk().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ao(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vi() {
        return this.ahl;
    }

    public x() {
        vh();
    }

    public x(String str) {
        vh();
        this.ahl.wh().wk().mUrl = str;
    }

    public void setUrl(String str) {
        this.ahl.wh().wk().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.ahm.l(arrayList);
    }

    public void n(String str, String str2) {
        this.ahm.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.ahm.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.ahm.d(str, bArr);
    }

    private void vj() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uJ = this.ahm.uJ();
            int size = uJ.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uJ.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uJ.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uJ.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vk() {
        if (this.aho == null) {
            this.aho = aa.vt();
        }
        if (this.aho != null) {
            this.ahm.n("stTime", String.valueOf(this.aho.mTime));
            this.ahm.n("stSize", String.valueOf(this.aho.ahG));
            this.ahm.n("stTimesNum", String.valueOf(this.aho.ahH));
            this.ahm.n("stMode", String.valueOf(this.aho.mMode));
            this.ahm.n("stMethod", String.valueOf(this.aho.ahF));
        }
        this.ahp = aa.cE(0);
        if (this.ahp == 0 && this.aho != null) {
            this.ahp = this.aho.ahH;
        }
        this.ahm.n("stErrorNums", String.valueOf(this.ahp));
    }

    public boolean vl() {
        return this.ahl.wi().vl();
    }

    public int vm() {
        return this.ahl.wi().ajG;
    }

    public int vn() {
        return this.ahl.wi().tW;
    }

    public String vo() {
        return this.ahl.wi().ajH;
    }

    public String getErrorString() {
        return this.ahl.wi().mErrorString;
    }

    public void eW() {
        if (this.ahm != null) {
            this.ahm.eW();
        }
        if (this.ahn != null) {
            this.ahn.eW();
        }
    }

    public void eY() {
        if (this.ahm != null) {
            this.ahm.eY();
        }
        if (this.ahn != null) {
            this.ahn.eY();
        }
    }

    private com.baidu.tbadk.core.data.af f(String str, String str2, boolean z) {
        String uK;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.ahn == null) {
                this.ahn = new x(sb.toString());
            } else {
                this.ahn.eW();
            }
            this.ahn.vi().wh().mIsNeedAddCommenParam = false;
            this.ahn.vi().wh().mIsUseCurrentBDUSS = false;
            this.ahn.vi().wh().ajD = false;
            this.ahn.n("un", str);
            this.ahn.n("passwd", str2);
            this.ahn.n("isphone", "0");
            this.ahn.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.ahn.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.ahn.vi().wh().wk().ake = true;
            uK = this.ahn.uK();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ahn.vi().wi().isRequestSuccess() && uK != null) {
            com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
            afVar.parserJson(uK);
            String userId = afVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ahl.wi().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.k.neterror);
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
            if (afVar.qS() != null) {
                accountData.setTbs(afVar.qS().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return afVar;
        }
        if (this.ahn.vl()) {
            switch (this.ahn.vm()) {
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

    public byte[] uL() {
        if (!this.ahl.wh().mIsFromCDN) {
            this.ahl.wh().b(this.ahm);
        }
        return this.ahm.uL();
    }

    private void vp() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uJ = this.ahm.uJ();
        for (int i = 0; uJ != null && i < uJ.size(); i++) {
            BasicNameValuePair basicNameValuePair = uJ.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.ahm.n("sign", com.baidu.adp.lib.util.s.aX(stringBuffer.toString()));
    }

    private String cB(int i) {
        String uN;
        com.baidu.tbadk.coreExtra.a.c xM;
        switch (i) {
            case 1:
                if (vi().wh().mIsNeedAddCommenParam) {
                    this.ahl.wh().b(this.ahm);
                }
                vk();
                uN = this.ahm.uM();
                break;
            case 2:
                if (vi().wh().mIsUseCurrentBDUSS) {
                    vi().wh().a(this.ahm);
                }
                if (vi().wh().mIsNeedAddCommenParam) {
                    this.ahl.wh().b(this.ahm);
                }
                vk();
                uN = this.ahm.uK();
                break;
            case 3:
                if (vi().wh().mIsUseCurrentBDUSS) {
                    vi().wh().a(this.ahm);
                }
                if (vi().wh().mIsNeedAddCommenParam) {
                    this.ahl.wh().b(this.ahm);
                }
                vp();
                uN = this.ahm.uN();
                break;
            default:
                return null;
        }
        if (!this.ahl.wi().vl()) {
            aa.a(this.aho);
            aa.cF(this.ahp);
            return uN;
        } else if (!this.ahl.wi().isRequestSuccess()) {
            if (this.ahl.wi().ajG == 1 && this.ahl.wh().ajD) {
                String str = this.ahl.wi().mErrorString;
                this.ahl.wi().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.qi();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    vq();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cF(currentAccountObj.getAccount());
                if (ReloginManager.ur().uu()) {
                    ReloginManager.ur().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.af f = f(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xM = com.baidu.tbadk.coreExtra.a.a.xM()) != null) {
                    xM.g(currentAccountObj);
                }
                if (f == null) {
                    if (this.ahn != null) {
                        this.ahl.wi().mErrorString = this.ahn.getErrorString();
                        return null;
                    }
                    this.ahl.wi().mErrorString = str;
                    return uN;
                }
                uN = cC(i);
            }
            com.baidu.tieba.i.a.a(this);
            return uN;
        } else {
            return uN;
        }
    }

    private String cC(int i) {
        String uN;
        vj();
        switch (i) {
            case 1:
                uN = this.ahm.uM();
                break;
            case 2:
                uN = this.ahm.uK();
                break;
            case 3:
                uN = this.ahm.uN();
                break;
            default:
                return null;
        }
        if (this.ahl.wi().vl()) {
            switch (this.ahl.wi().ajG) {
                case 1:
                case 2:
                case 5:
                    vq();
                    this.ahl.wi().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uN;
            }
        }
        return uN;
    }

    private void vq() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String uK() {
        return cB(2);
    }

    public String uM() {
        return cB(1);
    }

    public String uN() {
        return cB(3);
    }

    public String ea(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dJ = k.dJ(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dJ.read(bArr2);
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
        return uN();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vi().wh().a(this.ahm);
        return this.ahm.a(str, handler, i, i2, i3, z);
    }
}
