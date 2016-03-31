package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.a0;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.t;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a aaV = null;
    private t aaW = null;
    private ab aaX = null;
    private af.a aaY = null;
    private int aaZ = 0;

    private void vT() {
        this.aaV = new com.baidu.tbadk.core.util.a.a();
        this.aaW = ae.wd().a(this.aaV);
        this.aaX = null;
        this.aaV.wO().wR().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.am(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vU() {
        return this.aaV;
    }

    public ab() {
        vT();
    }

    public ab(String str) {
        vT();
        this.aaV.wO().wR().mUrl = str;
    }

    public void setUrl(String str) {
        this.aaV.wO().wR().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.aaW.k(arrayList);
    }

    public void p(String str, String str2) {
        this.aaW.p(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aaW.a(basicNameValuePair);
    }

    public void c(String str, byte[] bArr) {
        this.aaW.c(str, bArr);
    }

    private void vV() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> vv = this.aaW.vv();
            int size = vv.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = vv.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    vv.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    vv.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vW() {
        if (this.aaY == null) {
            this.aaY = af.we();
        }
        if (this.aaY != null) {
            this.aaW.p("stTime", String.valueOf(this.aaY.mTime));
            this.aaW.p("stSize", String.valueOf(this.aaY.abq));
            this.aaW.p("stTimesNum", String.valueOf(this.aaY.abr));
            this.aaW.p("stMode", String.valueOf(this.aaY.mMode));
            this.aaW.p("stMethod", String.valueOf(this.aaY.abp));
        }
        this.aaZ = af.cI(0);
        if (this.aaZ == 0 && this.aaY != null) {
            this.aaZ = this.aaY.abr;
        }
        this.aaW.p("stErrorNums", String.valueOf(this.aaZ));
    }

    public boolean vX() {
        return this.aaV.wP().vX();
    }

    public int vY() {
        return this.aaV.wP().adf;
    }

    public int vZ() {
        return this.aaV.wP().vL;
    }

    public String wa() {
        return this.aaV.wP().adg;
    }

    public String getErrorString() {
        return this.aaV.wP().mErrorString;
    }

    public void gX() {
        if (this.aaW != null) {
            this.aaW.gX();
        }
        if (this.aaX != null) {
            this.aaX.gX();
        }
    }

    public void ha() {
        if (this.aaW != null) {
            this.aaW.ha();
        }
        if (this.aaX != null) {
            this.aaX.ha();
        }
    }

    private com.baidu.tbadk.core.data.x e(String str, String str2, boolean z) {
        String vw;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aaX == null) {
                this.aaX = new ab(sb.toString());
            } else {
                this.aaX.gX();
            }
            this.aaX.vU().wO().mIsNeedAddCommenParam = false;
            this.aaX.vU().wO().mIsUseCurrentBDUSS = false;
            this.aaX.vU().wO().adb = false;
            this.aaX.p("un", str);
            this.aaX.p("passwd", str2);
            this.aaX.p("isphone", "0");
            this.aaX.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.aaX.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.aaX.vU().wO().wR().adD = true;
            vw = this.aaX.vw();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aaX.vU().wP().qC() && vw != null) {
            com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
            xVar.parserJson(vw);
            String userId = xVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aaV.wP().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(t.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(xVar.getUser().getUserName());
            if (xVar.getUser().getPassword() != null) {
                accountData.setPassword(xVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(xVar.getUser().getUserId());
            accountData.setBDUSS(xVar.getUser().getBDUSS());
            accountData.setPortrait(xVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (xVar.sf() != null) {
                accountData.setTbs(xVar.sf().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return xVar;
        }
        if (this.aaX.vX()) {
            switch (this.aaX.vY()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m411getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m411getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] vx() {
        if (!this.aaV.wO().mIsFromCDN) {
            this.aaV.wO().b(this.aaW);
        }
        return this.aaW.vx();
    }

    private void wb() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> vv = this.aaW.vv();
        for (int i = 0; vv != null && i < vv.size(); i++) {
            BasicNameValuePair basicNameValuePair = vv.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aaW.p(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aZ(stringBuffer.toString()));
    }

    private String cF(int i) {
        String vz;
        com.baidu.tbadk.coreExtra.a.c yn;
        switch (i) {
            case 1:
                if (vU().wO().mIsNeedAddCommenParam) {
                    this.aaV.wO().b(this.aaW);
                }
                vW();
                vz = this.aaW.vy();
                break;
            case 2:
                if (vU().wO().mIsUseCurrentBDUSS) {
                    vU().wO().a(this.aaW);
                }
                if (vU().wO().mIsNeedAddCommenParam) {
                    this.aaV.wO().b(this.aaW);
                }
                vW();
                vz = this.aaW.vw();
                break;
            case 3:
                if (vU().wO().mIsUseCurrentBDUSS) {
                    vU().wO().a(this.aaW);
                }
                if (vU().wO().mIsNeedAddCommenParam) {
                    this.aaV.wO().b(this.aaW);
                }
                wb();
                vz = this.aaW.vz();
                break;
            default:
                return null;
        }
        if (!this.aaV.wP().vX()) {
            af.a(this.aaY);
            af.cJ(this.aaZ);
            return vz;
        } else if (!this.aaV.wP().qC() && this.aaV.wP().adf == 1 && this.aaV.wO().adb) {
            String str = this.aaV.wP().mErrorString;
            this.aaV.wP().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.qQ();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.ch(currentAccountObj.getAccount());
            if (ReloginManager.vf().vj()) {
                AccountData vi = ReloginManager.vf().vi();
                if (vi == null) {
                    ReloginManager.vf().e(vi);
                    return null;
                }
                return cG(i);
            }
            com.baidu.tbadk.core.data.x e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (yn = com.baidu.tbadk.coreExtra.a.a.yn()) != null) {
                yn.g(currentAccountObj);
            }
            if (e == null) {
                if (this.aaX != null) {
                    this.aaV.wP().mErrorString = this.aaX.getErrorString();
                    return null;
                }
                this.aaV.wP().mErrorString = str;
                return vz;
            }
            return cG(i);
        } else {
            return vz;
        }
    }

    private String cG(int i) {
        String vz;
        vV();
        switch (i) {
            case 1:
                vz = this.aaW.vy();
                break;
            case 2:
                vz = this.aaW.vw();
                break;
            case 3:
                vz = this.aaW.vz();
                break;
            default:
                return null;
        }
        if (this.aaV.wP().vX()) {
            switch (this.aaV.wP().adf) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.aaV.wP().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return vz;
            }
        }
        return vz;
    }

    public String vw() {
        return cF(2);
    }

    public String vz() {
        return cF(3);
    }

    public String dr(String str) {
        byte[] bArr;
        try {
            InputStream da = m.da(str);
            byte[] bArr2 = new byte[a0.O];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a0.O);
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
        c("pic", bArr);
        return vz();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vU().wO().a(this.aaW);
        return this.aaW.a(str, handler, i, i2, i3, z);
    }
}
