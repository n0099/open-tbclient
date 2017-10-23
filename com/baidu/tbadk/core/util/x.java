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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private com.baidu.tbadk.core.util.a.a afu = null;
    private q afv = null;
    private x afw = null;
    private aa.a afx = null;
    private int afy = 0;

    private void uF() {
        this.afu = new com.baidu.tbadk.core.util.a.a();
        this.afv = z.uQ().a(this.afu);
        this.afw = null;
        this.afu.vC().vF().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uG() {
        return this.afu;
    }

    public x() {
        uF();
    }

    public x(String str) {
        uF();
        this.afu.vC().vF().mUrl = str;
    }

    public void setUrl(String str) {
        this.afu.vC().vF().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.afv.k(arrayList);
    }

    public void n(String str, String str2) {
        this.afv.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.afv.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.afv.d(str, bArr);
    }

    private void uH() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uh = this.afv.uh();
            int size = uh.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uh.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uh.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uh.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uI() {
        if (this.afx == null) {
            this.afx = aa.uR();
        }
        if (this.afx != null) {
            this.afv.n("stTime", String.valueOf(this.afx.mTime));
            this.afv.n("stSize", String.valueOf(this.afx.afO));
            this.afv.n("stTimesNum", String.valueOf(this.afx.afP));
            this.afv.n("stMode", String.valueOf(this.afx.mMode));
            this.afv.n("stMethod", String.valueOf(this.afx.afN));
        }
        this.afy = aa.cH(0);
        if (this.afy == 0 && this.afx != null) {
            this.afy = this.afx.afP;
        }
        this.afv.n("stErrorNums", String.valueOf(this.afy));
    }

    public boolean uJ() {
        return this.afu.vD().uJ();
    }

    public int uK() {
        return this.afu.vD().ahC;
    }

    public int uL() {
        return this.afu.vD().vp;
    }

    public String uM() {
        return this.afu.vD().ahD;
    }

    public String getErrorString() {
        return this.afu.vD().mErrorString;
    }

    public void fo() {
        if (this.afv != null) {
            this.afv.fo();
        }
        if (this.afw != null) {
            this.afw.fo();
        }
    }

    public void fs() {
        if (this.afv != null) {
            this.afv.fs();
        }
        if (this.afw != null) {
            this.afw.fs();
        }
    }

    private com.baidu.tbadk.core.data.ai e(String str, String str2, boolean z) {
        String ui;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.afw == null) {
                this.afw = new x(sb.toString());
            } else {
                this.afw.fo();
            }
            this.afw.uG().vC().mIsNeedAddCommenParam = false;
            this.afw.uG().vC().mIsUseCurrentBDUSS = false;
            this.afw.uG().vC().ahz = false;
            this.afw.n("un", str);
            this.afw.n("passwd", str2);
            this.afw.n("isphone", "0");
            this.afw.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.afw.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.afw.uG().vC().vF().aia = true;
            ui = this.afw.ui();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.afw.uG().vD().isRequestSuccess() && ui != null) {
            com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
            aiVar.parserJson(ui);
            String userId = aiVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.afu.vD().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aiVar.getUser().getUserName());
            if (aiVar.getUser().getPassword() != null) {
                accountData.setPassword(aiVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aiVar.getUser().getUserId());
            accountData.setBDUSS(aiVar.getUser().getBDUSS());
            accountData.setPortrait(aiVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aiVar.qa() != null) {
                accountData.setTbs(aiVar.qa().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aiVar;
        }
        if (this.afw.uJ()) {
            switch (this.afw.uK()) {
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

    public byte[] uj() {
        if (!this.afu.vC().mIsFromCDN) {
            this.afu.vC().b(this.afv);
        }
        return this.afv.uj();
    }

    private void uN() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uh = this.afv.uh();
        for (int i = 0; uh != null && i < uh.size(); i++) {
            BasicNameValuePair basicNameValuePair = uh.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.afv.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(stringBuffer.toString()));
    }

    private String cE(int i) {
        String ul;
        com.baidu.tbadk.coreExtra.a.c xg;
        switch (i) {
            case 1:
                if (uG().vC().mIsNeedAddCommenParam) {
                    this.afu.vC().b(this.afv);
                }
                uI();
                ul = this.afv.uk();
                break;
            case 2:
                if (uG().vC().mIsUseCurrentBDUSS) {
                    uG().vC().a(this.afv);
                }
                if (uG().vC().mIsNeedAddCommenParam) {
                    this.afu.vC().b(this.afv);
                }
                uI();
                ul = this.afv.ui();
                break;
            case 3:
                if (uG().vC().mIsUseCurrentBDUSS) {
                    uG().vC().a(this.afv);
                }
                if (uG().vC().mIsNeedAddCommenParam) {
                    this.afu.vC().b(this.afv);
                }
                uN();
                ul = this.afv.ul();
                break;
            default:
                return null;
        }
        if (!this.afu.vD().uJ()) {
            aa.a(this.afx);
            aa.cI(this.afy);
            return ul;
        } else if (!this.afu.vD().isRequestSuccess()) {
            if (this.afu.vD().ahC == 1 && this.afu.vC().ahz) {
                String str = this.afu.vD().mErrorString;
                this.afu.vD().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.oY();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    uO();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cp(currentAccountObj.getAccount());
                if (ReloginManager.tQ().tU()) {
                    AccountData tT = ReloginManager.tQ().tT();
                    if (tT == null) {
                        ReloginManager.tQ().f(tT);
                        return null;
                    }
                    return cF(i);
                }
                com.baidu.tbadk.core.data.ai e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xg = com.baidu.tbadk.coreExtra.a.a.xg()) != null) {
                    xg.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.afw != null) {
                        this.afu.vD().mErrorString = this.afw.getErrorString();
                        return null;
                    }
                    this.afu.vD().mErrorString = str;
                    return ul;
                }
                ul = cF(i);
            }
            com.baidu.tieba.h.a.a(this);
            return ul;
        } else {
            return ul;
        }
    }

    private String cF(int i) {
        String ul;
        uH();
        switch (i) {
            case 1:
                ul = this.afv.uk();
                break;
            case 2:
                ul = this.afv.ui();
                break;
            case 3:
                ul = this.afv.ul();
                break;
            default:
                return null;
        }
        if (this.afu.vD().uJ()) {
            switch (this.afu.vD().ahC) {
                case 1:
                case 2:
                case 5:
                    uO();
                    this.afu.vD().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return ul;
            }
        }
        return ul;
    }

    private void uO() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String ui() {
        return cE(2);
    }

    public String uk() {
        return cE(1);
    }

    public String ul() {
        return cE(3);
    }

    public String dC(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dm = k.dm(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dm.read(bArr2);
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
        return ul();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uG().vC().a(this.afv);
        return this.afv.a(str, handler, i, i2, i3, z);
    }
}
