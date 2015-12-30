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
import com.baidu.tieba.n;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a abm = null;
    private u abn = null;
    private ab abo = null;
    private af.a abp = null;
    private int abq = 0;

    private void uv() {
        this.abm = new com.baidu.tbadk.core.util.a.a();
        this.abn = ae.uF().a(this.abm);
        this.abo = null;
        this.abm.vp().vs().mNetType = com.baidu.tbadk.core.util.a.i.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uw() {
        return this.abm;
    }

    public ab() {
        uv();
    }

    public ab(String str) {
        uv();
        this.abm.vp().vs().mUrl = str;
    }

    public void setUrl(String str) {
        this.abm.vp().vs().mUrl = str;
    }

    public void m(ArrayList<BasicNameValuePair> arrayList) {
        this.abn.m(arrayList);
    }

    public void o(String str, String str2) {
        this.abn.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.abn.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.abn.d(str, bArr);
    }

    private void ux() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tU = this.abn.tU();
            int size = tU.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = tU.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    tU.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    tU.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uy() {
        if (this.abp == null) {
            this.abp = af.uG();
        }
        if (this.abp != null) {
            this.abn.o("stTime", String.valueOf(this.abp.mTime));
            this.abn.o("stSize", String.valueOf(this.abp.abI));
            this.abn.o("stTimesNum", String.valueOf(this.abp.abJ));
            this.abn.o("stMode", String.valueOf(this.abp.mMode));
            this.abn.o("stMethod", String.valueOf(this.abp.abH));
        }
        this.abq = af.co(0);
        if (this.abq == 0 && this.abp != null) {
            this.abq = this.abp.abJ;
        }
        this.abn.o("stErrorNums", String.valueOf(this.abq));
    }

    public boolean uz() {
        return this.abm.vq().uz();
    }

    public int uA() {
        return this.abm.vq().adu;
    }

    public int uB() {
        return this.abm.vq().adt;
    }

    public String uC() {
        return this.abm.vq().adv;
    }

    public String getErrorString() {
        return this.abm.vq().mErrorString;
    }

    public void gL() {
        if (this.abn != null) {
            this.abn.gL();
        }
        if (this.abo != null) {
            this.abo.gL();
        }
    }

    public void gO() {
        if (this.abn != null) {
            this.abn.gO();
        }
        if (this.abo != null) {
            this.abo.gO();
        }
    }

    private com.baidu.tbadk.core.data.n d(String str, String str2, boolean z) {
        String tV;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.abo == null) {
                this.abo = new ab(sb.toString());
            } else {
                this.abo.gL();
            }
            this.abo.uw().vp().mIsNeedAddCommenParam = false;
            this.abo.uw().vp().mIsUseCurrentBDUSS = false;
            this.abo.uw().vp().adq = false;
            this.abo.o("un", str);
            this.abo.o("passwd", str2);
            this.abo.o("isphone", "0");
            this.abo.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.abo.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.abo.uw().vp().vs().adN = true;
            tV = this.abo.tV();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.abo.uw().vq().qO() && tV != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(tV);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.abm.vq().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(n.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            if (nVar.getUser().getPassword() != null) {
                accountData.setPassword(nVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.rI() != null) {
                accountData.setTbs(nVar.rI().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return nVar;
        }
        if (this.abo.uz()) {
            switch (this.abo.uA()) {
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

    public byte[] tW() {
        if (!this.abm.vp().mIsFromCDN) {
            this.abm.vp().b(this.abn);
        }
        return this.abn.tW();
    }

    private void uD() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tU = this.abn.tU();
        for (int i = 0; tU != null && i < tU.size(); i++) {
            BasicNameValuePair basicNameValuePair = tU.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.abn.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String cl(int i) {
        String tY;
        com.baidu.tbadk.coreExtra.a.c wy;
        switch (i) {
            case 1:
                if (uw().vp().mIsNeedAddCommenParam) {
                    this.abm.vp().b(this.abn);
                }
                uy();
                tY = this.abn.tX();
                break;
            case 2:
                if (uw().vp().mIsUseCurrentBDUSS) {
                    uw().vp().a(this.abn);
                }
                if (uw().vp().mIsNeedAddCommenParam) {
                    this.abm.vp().b(this.abn);
                }
                uy();
                tY = this.abn.tV();
                break;
            case 3:
                if (uw().vp().mIsUseCurrentBDUSS) {
                    uw().vp().a(this.abn);
                }
                if (uw().vp().mIsNeedAddCommenParam) {
                    this.abm.vp().b(this.abn);
                }
                uD();
                tY = this.abn.tY();
                break;
            default:
                return null;
        }
        if (!this.abm.vq().uz()) {
            af.a(this.abp);
            af.cp(this.abq);
            return tY;
        } else if (!this.abm.vq().qO() && this.abm.vq().adu == 1 && this.abm.vp().adq) {
            String str = this.abm.vq().mErrorString;
            this.abm.vq().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rc();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cl(currentAccountObj.getAccount());
            if (ReloginManager.tE().tI()) {
                AccountData tH = ReloginManager.tE().tH();
                if (tH == null) {
                    ReloginManager.tE().e(tH);
                    return null;
                }
                return cm(i);
            }
            com.baidu.tbadk.core.data.n d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (wy = com.baidu.tbadk.coreExtra.a.a.wy()) != null) {
                wy.g(currentAccountObj);
            }
            if (d == null) {
                if (this.abo != null) {
                    this.abm.vq().mErrorString = this.abo.getErrorString();
                    return null;
                }
                this.abm.vq().mErrorString = str;
                return tY;
            }
            return cm(i);
        } else {
            return tY;
        }
    }

    private String cm(int i) {
        String tY;
        ux();
        switch (i) {
            case 1:
                tY = this.abn.tX();
                break;
            case 2:
                tY = this.abn.tV();
                break;
            case 3:
                tY = this.abn.tY();
                break;
            default:
                return null;
        }
        if (this.abm.vq().uz()) {
            switch (this.abm.vq().adu) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.abm.vq().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return tY;
            }
        }
        return tY;
    }

    public String tV() {
        return cl(2);
    }

    public String tY() {
        return cl(3);
    }

    public String dr(String str) {
        byte[] bArr;
        try {
            InputStream da = n.da(str);
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
        d("pic", bArr);
        return tY();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uw().vp().a(this.abn);
        return this.abn.a(str, handler, i, i2, i3, z);
    }
}
