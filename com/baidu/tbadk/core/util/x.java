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

    private void vi() {
        this.ahl = new com.baidu.tbadk.core.util.a.a();
        this.ahm = z.vt().a(this.ahl);
        this.ahn = null;
        this.ahl.wi().wl().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ao(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vj() {
        return this.ahl;
    }

    public x() {
        vi();
    }

    public x(String str) {
        vi();
        this.ahl.wi().wl().mUrl = str;
    }

    public void setUrl(String str) {
        this.ahl.wi().wl().mUrl = str;
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

    private void vk() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uK = this.ahm.uK();
            int size = uK.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uK.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uK.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uK.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vl() {
        if (this.aho == null) {
            this.aho = aa.vu();
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

    public boolean vm() {
        return this.ahl.wj().vm();
    }

    public int vn() {
        return this.ahl.wj().ajG;
    }

    public int vo() {
        return this.ahl.wj().tX;
    }

    public String vp() {
        return this.ahl.wj().ajH;
    }

    public String getErrorString() {
        return this.ahl.wj().mErrorString;
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
        String uL;
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
            this.ahn.vj().wi().mIsNeedAddCommenParam = false;
            this.ahn.vj().wi().mIsUseCurrentBDUSS = false;
            this.ahn.vj().wi().ajD = false;
            this.ahn.n("un", str);
            this.ahn.n("passwd", str2);
            this.ahn.n("isphone", "0");
            this.ahn.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.ahn.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.ahn.vj().wi().wl().ake = true;
            uL = this.ahn.uL();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ahn.vj().wj().isRequestSuccess() && uL != null) {
            com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
            afVar.parserJson(uL);
            String userId = afVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ahl.wj().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.k.neterror);
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
            if (afVar.qT() != null) {
                accountData.setTbs(afVar.qT().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return afVar;
        }
        if (this.ahn.vm()) {
            switch (this.ahn.vn()) {
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

    public byte[] uM() {
        if (!this.ahl.wi().mIsFromCDN) {
            this.ahl.wi().b(this.ahm);
        }
        return this.ahm.uM();
    }

    private void vq() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uK = this.ahm.uK();
        for (int i = 0; uK != null && i < uK.size(); i++) {
            BasicNameValuePair basicNameValuePair = uK.get(i);
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
        String uO;
        com.baidu.tbadk.coreExtra.a.c xN;
        switch (i) {
            case 1:
                if (vj().wi().mIsNeedAddCommenParam) {
                    this.ahl.wi().b(this.ahm);
                }
                vl();
                uO = this.ahm.uN();
                break;
            case 2:
                if (vj().wi().mIsUseCurrentBDUSS) {
                    vj().wi().a(this.ahm);
                }
                if (vj().wi().mIsNeedAddCommenParam) {
                    this.ahl.wi().b(this.ahm);
                }
                vl();
                uO = this.ahm.uL();
                break;
            case 3:
                if (vj().wi().mIsUseCurrentBDUSS) {
                    vj().wi().a(this.ahm);
                }
                if (vj().wi().mIsNeedAddCommenParam) {
                    this.ahl.wi().b(this.ahm);
                }
                vq();
                uO = this.ahm.uO();
                break;
            default:
                return null;
        }
        if (!this.ahl.wj().vm()) {
            aa.a(this.aho);
            aa.cF(this.ahp);
            return uO;
        } else if (!this.ahl.wj().isRequestSuccess()) {
            if (this.ahl.wj().ajG == 1 && this.ahl.wi().ajD) {
                String str = this.ahl.wj().mErrorString;
                this.ahl.wj().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.qj();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    vr();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cF(currentAccountObj.getAccount());
                if (ReloginManager.us().uv()) {
                    ReloginManager.us().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.af f = f(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xN = com.baidu.tbadk.coreExtra.a.a.xN()) != null) {
                    xN.g(currentAccountObj);
                }
                if (f == null) {
                    if (this.ahn != null) {
                        this.ahl.wj().mErrorString = this.ahn.getErrorString();
                        return null;
                    }
                    this.ahl.wj().mErrorString = str;
                    return uO;
                }
                uO = cC(i);
            }
            com.baidu.tieba.i.a.a(this);
            return uO;
        } else {
            return uO;
        }
    }

    private String cC(int i) {
        String uO;
        vk();
        switch (i) {
            case 1:
                uO = this.ahm.uN();
                break;
            case 2:
                uO = this.ahm.uL();
                break;
            case 3:
                uO = this.ahm.uO();
                break;
            default:
                return null;
        }
        if (this.ahl.wj().vm()) {
            switch (this.ahl.wj().ajG) {
                case 1:
                case 2:
                case 5:
                    vr();
                    this.ahl.wj().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uO;
            }
        }
        return uO;
    }

    private void vr() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String uL() {
        return cB(2);
    }

    public String uN() {
        return cB(1);
    }

    public String uO() {
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
        return uO();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vj().wi().a(this.ahm);
        return this.ahm.a(str, handler, i, i2, i3, z);
    }
}
