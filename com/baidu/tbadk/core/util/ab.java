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
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a aai = null;
    private t aaj = null;
    private ab aak = null;
    private af.a aal = null;
    private int aam = 0;

    private void uC() {
        this.aai = new com.baidu.tbadk.core.util.a.a();
        this.aaj = ae.uM().a(this.aai);
        this.aak = null;
        this.aai.vz().vC().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ag(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uD() {
        return this.aai;
    }

    public ab() {
        uC();
    }

    public ab(String str) {
        uC();
        this.aai.vz().vC().mUrl = str;
    }

    public void setUrl(String str) {
        this.aai.vz().vC().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.aaj.l(arrayList);
    }

    public void n(String str, String str2) {
        this.aaj.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aaj.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aaj.d(str, bArr);
    }

    private void uE() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ud = this.aaj.ud();
            int size = ud.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ud.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ud.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ud.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uF() {
        if (this.aal == null) {
            this.aal = af.uN();
        }
        if (this.aal != null) {
            this.aaj.n("stTime", String.valueOf(this.aal.mTime));
            this.aaj.n("stSize", String.valueOf(this.aal.aaD));
            this.aaj.n("stTimesNum", String.valueOf(this.aal.aaE));
            this.aaj.n("stMode", String.valueOf(this.aal.mMode));
            this.aaj.n("stMethod", String.valueOf(this.aal.aaC));
        }
        this.aam = af.cE(0);
        if (this.aam == 0 && this.aal != null) {
            this.aam = this.aal.aaE;
        }
        this.aaj.n("stErrorNums", String.valueOf(this.aam));
    }

    public boolean uG() {
        return this.aai.vA().uG();
    }

    public int uH() {
        return this.aai.vA().acs;
    }

    public int uI() {
        return this.aai.vA().oE;
    }

    public String uJ() {
        return this.aai.vA().act;
    }

    public String getErrorString() {
        return this.aai.vA().mErrorString;
    }

    public void eg() {
        if (this.aaj != null) {
            this.aaj.eg();
        }
        if (this.aak != null) {
            this.aak.eg();
        }
    }

    public void ej() {
        if (this.aaj != null) {
            this.aaj.ej();
        }
        if (this.aak != null) {
            this.aak.ej();
        }
    }

    private com.baidu.tbadk.core.data.ae d(String str, String str2, boolean z) {
        String ue;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aak == null) {
                this.aak = new ab(sb.toString());
            } else {
                this.aak.eg();
            }
            this.aak.uD().vz().mIsNeedAddCommenParam = false;
            this.aak.uD().vz().mIsUseCurrentBDUSS = false;
            this.aak.uD().vz().acp = false;
            this.aak.n("un", str);
            this.aak.n("passwd", str2);
            this.aak.n("isphone", "0");
            this.aak.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aak.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aak.uD().vz().vC().acQ = true;
            ue = this.aak.ue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aak.uD().vA().oE() && ue != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(ue);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aai.vA().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(t.j.neterror);
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
            if (aeVar.qf() != null) {
                accountData.setTbs(aeVar.qf().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.aak.uG()) {
            switch (this.aak.uH()) {
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

    public byte[] uf() {
        if (!this.aai.vz().mIsFromCDN) {
            this.aai.vz().b(this.aaj);
        }
        return this.aaj.uf();
    }

    private void uK() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ud = this.aaj.ud();
        for (int i = 0; ud != null && i < ud.size(); i++) {
            BasicNameValuePair basicNameValuePair = ud.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aaj.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aU(stringBuffer.toString()));
    }

    private String cB(int i) {
        String uh;
        com.baidu.tbadk.coreExtra.a.c xo;
        switch (i) {
            case 1:
                if (uD().vz().mIsNeedAddCommenParam) {
                    this.aai.vz().b(this.aaj);
                }
                uF();
                uh = this.aaj.ug();
                break;
            case 2:
                if (uD().vz().mIsUseCurrentBDUSS) {
                    uD().vz().a(this.aaj);
                }
                if (uD().vz().mIsNeedAddCommenParam) {
                    this.aai.vz().b(this.aaj);
                }
                uF();
                uh = this.aaj.ue();
                break;
            case 3:
                if (uD().vz().mIsUseCurrentBDUSS) {
                    uD().vz().a(this.aaj);
                }
                if (uD().vz().mIsNeedAddCommenParam) {
                    this.aai.vz().b(this.aaj);
                }
                uK();
                uh = this.aaj.uh();
                break;
            default:
                return null;
        }
        if (!this.aai.vA().uG()) {
            af.a(this.aal);
            af.cF(this.aam);
            return uh;
        } else if (!this.aai.vA().oE() && this.aai.vA().acs == 1 && this.aai.vz().acp) {
            String str = this.aai.vA().mErrorString;
            this.aai.vA().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.oS();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cg(currentAccountObj.getAccount());
            if (ReloginManager.tN().tR()) {
                AccountData tQ = ReloginManager.tN().tQ();
                if (tQ == null) {
                    ReloginManager.tN().f(tQ);
                    return null;
                }
                return cC(i);
            }
            com.baidu.tbadk.core.data.ae d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xo = com.baidu.tbadk.coreExtra.a.a.xo()) != null) {
                xo.h(currentAccountObj);
            }
            if (d == null) {
                if (this.aak != null) {
                    this.aai.vA().mErrorString = this.aak.getErrorString();
                    return null;
                }
                this.aai.vA().mErrorString = str;
                return uh;
            }
            return cC(i);
        } else {
            return uh;
        }
    }

    private String cC(int i) {
        String uh;
        uE();
        switch (i) {
            case 1:
                uh = this.aaj.ug();
                break;
            case 2:
                uh = this.aaj.ue();
                break;
            case 3:
                uh = this.aaj.uh();
                break;
            default:
                return null;
        }
        if (this.aai.vA().uG()) {
            switch (this.aai.vA().acs) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.aai.vA().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uh;
            }
        }
        return uh;
    }

    public String ue() {
        return cB(2);
    }

    public String ug() {
        return cB(1);
    }

    public String uh() {
        return cB(3);
    }

    /* renamed from: do  reason: not valid java name */
    public String m11do(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream da = m.da(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = da.read(bArr2);
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
        return uh();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uD().vz().a(this.aaj);
        return this.aaj.a(str, handler, i, i2, i3, z);
    }
}
