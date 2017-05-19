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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class z {
    private com.baidu.tbadk.core.util.a.a aey = null;
    private s aez = null;
    private z aeA = null;
    private ad.a aeB = null;
    private int aeC = 0;

    private void uI() {
        this.aey = new com.baidu.tbadk.core.util.a.a();
        this.aez = ac.uS().a(this.aey);
        this.aeA = null;
        this.aey.vD().vG().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ab(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uJ() {
        return this.aey;
    }

    public z() {
        uI();
    }

    public z(String str) {
        uI();
        this.aey.vD().vG().mUrl = str;
    }

    public void setUrl(String str) {
        this.aey.vD().vG().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.aez.k(arrayList);
    }

    public void n(String str, String str2) {
        this.aez.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aez.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aez.d(str, bArr);
    }

    private void uK() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uk = this.aez.uk();
            int size = uk.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uk.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uk.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uk.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uL() {
        if (this.aeB == null) {
            this.aeB = ad.uT();
        }
        if (this.aeB != null) {
            this.aez.n("stTime", String.valueOf(this.aeB.mTime));
            this.aez.n("stSize", String.valueOf(this.aeB.aeT));
            this.aez.n("stTimesNum", String.valueOf(this.aeB.aeU));
            this.aez.n("stMode", String.valueOf(this.aeB.mMode));
            this.aez.n("stMethod", String.valueOf(this.aeB.aeS));
        }
        this.aeC = ad.cC(0);
        if (this.aeC == 0 && this.aeB != null) {
            this.aeC = this.aeB.aeU;
        }
        this.aez.n("stErrorNums", String.valueOf(this.aeC));
    }

    public boolean uM() {
        return this.aey.vE().uM();
    }

    public int uN() {
        return this.aey.vE().agD;
    }

    public int uO() {
        return this.aey.vE().vR;
    }

    public String uP() {
        return this.aey.vE().agE;
    }

    public String getErrorString() {
        return this.aey.vE().mErrorString;
    }

    public void fs() {
        if (this.aez != null) {
            this.aez.fs();
        }
        if (this.aeA != null) {
            this.aeA.fs();
        }
    }

    public void fv() {
        if (this.aez != null) {
            this.aez.fv();
        }
        if (this.aeA != null) {
            this.aeA.fv();
        }
    }

    private com.baidu.tbadk.core.data.aj e(String str, String str2, boolean z) {
        String ul;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aeA == null) {
                this.aeA = new z(sb.toString());
            } else {
                this.aeA.fs();
            }
            this.aeA.uJ().vD().mIsNeedAddCommenParam = false;
            this.aeA.uJ().vD().mIsUseCurrentBDUSS = false;
            this.aeA.uJ().vD().agA = false;
            this.aeA.n("un", str);
            this.aeA.n("passwd", str2);
            this.aeA.n("isphone", "0");
            this.aeA.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aeA.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aeA.uJ().vD().vG().ahb = true;
            ul = this.aeA.ul();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aeA.uJ().vE().isRequestSuccess() && ul != null) {
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.parserJson(ul);
            String userId = ajVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aey.vE().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(ajVar.getUser().getUserName());
            if (ajVar.getUser().getPassword() != null) {
                accountData.setPassword(ajVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(ajVar.getUser().getUserId());
            accountData.setBDUSS(ajVar.getUser().getBDUSS());
            accountData.setPortrait(ajVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (ajVar.ql() != null) {
                accountData.setTbs(ajVar.ql().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return ajVar;
        }
        if (this.aeA.uM()) {
            switch (this.aeA.uN()) {
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

    public byte[] um() {
        if (!this.aey.vD().mIsFromCDN) {
            this.aey.vD().b(this.aez);
        }
        return this.aez.um();
    }

    private void uQ() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uk = this.aez.uk();
        for (int i = 0; uk != null && i < uk.size(); i++) {
            BasicNameValuePair basicNameValuePair = uk.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aez.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aI(stringBuffer.toString()));
    }

    private String cz(int i) {
        String uo;
        com.baidu.tbadk.coreExtra.a.c xi;
        switch (i) {
            case 1:
                if (uJ().vD().mIsNeedAddCommenParam) {
                    this.aey.vD().b(this.aez);
                }
                uL();
                uo = this.aez.un();
                break;
            case 2:
                if (uJ().vD().mIsUseCurrentBDUSS) {
                    uJ().vD().a(this.aez);
                }
                if (uJ().vD().mIsNeedAddCommenParam) {
                    this.aey.vD().b(this.aez);
                }
                uL();
                uo = this.aez.ul();
                break;
            case 3:
                if (uJ().vD().mIsUseCurrentBDUSS) {
                    uJ().vD().a(this.aez);
                }
                if (uJ().vD().mIsNeedAddCommenParam) {
                    this.aey.vD().b(this.aez);
                }
                uQ();
                uo = this.aez.uo();
                break;
            default:
                return null;
        }
        if (!this.aey.vE().uM()) {
            ad.a(this.aeB);
            ad.cD(this.aeC);
            return uo;
        } else if (!this.aey.vE().isRequestSuccess() && this.aey.vE().agD == 1 && this.aey.vD().agA) {
            String str = this.aey.vE().mErrorString;
            this.aey.vE().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.ph();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cg(currentAccountObj.getAccount());
            if (ReloginManager.tS().tW()) {
                AccountData tV = ReloginManager.tS().tV();
                if (tV == null) {
                    ReloginManager.tS().f(tV);
                    return null;
                }
                return cA(i);
            }
            com.baidu.tbadk.core.data.aj e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xi = com.baidu.tbadk.coreExtra.a.a.xi()) != null) {
                xi.h(currentAccountObj);
            }
            if (e == null) {
                if (this.aeA != null) {
                    this.aey.vE().mErrorString = this.aeA.getErrorString();
                    return null;
                }
                this.aey.vE().mErrorString = str;
                return uo;
            }
            return cA(i);
        } else {
            return uo;
        }
    }

    private String cA(int i) {
        String uo;
        uK();
        switch (i) {
            case 1:
                uo = this.aez.un();
                break;
            case 2:
                uo = this.aez.ul();
                break;
            case 3:
                uo = this.aez.uo();
                break;
            default:
                return null;
        }
        if (this.aey.vE().uM()) {
            switch (this.aey.vE().agD) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.aey.vE().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uo;
            }
        }
        return uo;
    }

    public String ul() {
        return cz(2);
    }

    public String un() {
        return cz(1);
    }

    public String uo() {
        return cz(3);
    }

    public String dp(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream db = l.db(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = db.read(bArr2);
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
        return uo();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uJ().vD().a(this.aez);
        return this.aez.a(str, handler, i, i2, i3, z);
    }
}
