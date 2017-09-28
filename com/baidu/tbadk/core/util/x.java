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
    private com.baidu.tbadk.core.util.a.a afG = null;
    private q afH = null;
    private x afI = null;
    private aa.a afJ = null;
    private int afK = 0;

    private void uM() {
        this.afG = new com.baidu.tbadk.core.util.a.a();
        this.afH = z.uX().a(this.afG);
        this.afI = null;
        this.afG.vJ().vM().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uN() {
        return this.afG;
    }

    public x() {
        uM();
    }

    public x(String str) {
        uM();
        this.afG.vJ().vM().mUrl = str;
    }

    public void setUrl(String str) {
        this.afG.vJ().vM().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.afH.k(arrayList);
    }

    public void n(String str, String str2) {
        this.afH.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.afH.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.afH.d(str, bArr);
    }

    private void uO() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uo = this.afH.uo();
            int size = uo.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uo.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uo.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uo.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uP() {
        if (this.afJ == null) {
            this.afJ = aa.uY();
        }
        if (this.afJ != null) {
            this.afH.n("stTime", String.valueOf(this.afJ.mTime));
            this.afH.n("stSize", String.valueOf(this.afJ.aga));
            this.afH.n("stTimesNum", String.valueOf(this.afJ.agb));
            this.afH.n("stMode", String.valueOf(this.afJ.mMode));
            this.afH.n("stMethod", String.valueOf(this.afJ.afZ));
        }
        this.afK = aa.cI(0);
        if (this.afK == 0 && this.afJ != null) {
            this.afK = this.afJ.agb;
        }
        this.afH.n("stErrorNums", String.valueOf(this.afK));
    }

    public boolean uQ() {
        return this.afG.vK().uQ();
    }

    public int uR() {
        return this.afG.vK().ahO;
    }

    public int uS() {
        return this.afG.vK().vo;
    }

    public String uT() {
        return this.afG.vK().ahP;
    }

    public String getErrorString() {
        return this.afG.vK().mErrorString;
    }

    public void fo() {
        if (this.afH != null) {
            this.afH.fo();
        }
        if (this.afI != null) {
            this.afI.fo();
        }
    }

    public void fs() {
        if (this.afH != null) {
            this.afH.fs();
        }
        if (this.afI != null) {
            this.afI.fs();
        }
    }

    private com.baidu.tbadk.core.data.ai e(String str, String str2, boolean z) {
        String up;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.afI == null) {
                this.afI = new x(sb.toString());
            } else {
                this.afI.fo();
            }
            this.afI.uN().vJ().mIsNeedAddCommenParam = false;
            this.afI.uN().vJ().mIsUseCurrentBDUSS = false;
            this.afI.uN().vJ().ahL = false;
            this.afI.n("un", str);
            this.afI.n("passwd", str2);
            this.afI.n("isphone", "0");
            this.afI.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.afI.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.afI.uN().vJ().vM().aim = true;
            up = this.afI.up();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.afI.uN().vK().isRequestSuccess() && up != null) {
            com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
            aiVar.parserJson(up);
            String userId = aiVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.afG.vK().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror);
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
            if (aiVar.qh() != null) {
                accountData.setTbs(aiVar.qh().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aiVar;
        }
        if (this.afI.uQ()) {
            switch (this.afI.uR()) {
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

    public byte[] uq() {
        if (!this.afG.vJ().mIsFromCDN) {
            this.afG.vJ().b(this.afH);
        }
        return this.afH.uq();
    }

    private void uU() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uo = this.afH.uo();
        for (int i = 0; uo != null && i < uo.size(); i++) {
            BasicNameValuePair basicNameValuePair = uo.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.afH.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(stringBuffer.toString()));
    }

    private String cF(int i) {
        String us;
        com.baidu.tbadk.coreExtra.a.c xn;
        switch (i) {
            case 1:
                if (uN().vJ().mIsNeedAddCommenParam) {
                    this.afG.vJ().b(this.afH);
                }
                uP();
                us = this.afH.ur();
                break;
            case 2:
                if (uN().vJ().mIsUseCurrentBDUSS) {
                    uN().vJ().a(this.afH);
                }
                if (uN().vJ().mIsNeedAddCommenParam) {
                    this.afG.vJ().b(this.afH);
                }
                uP();
                us = this.afH.up();
                break;
            case 3:
                if (uN().vJ().mIsUseCurrentBDUSS) {
                    uN().vJ().a(this.afH);
                }
                if (uN().vJ().mIsNeedAddCommenParam) {
                    this.afG.vJ().b(this.afH);
                }
                uU();
                us = this.afH.us();
                break;
            default:
                return null;
        }
        if (!this.afG.vK().uQ()) {
            aa.a(this.afJ);
            aa.cJ(this.afK);
            return us;
        } else if (!this.afG.vK().isRequestSuccess()) {
            if (this.afG.vK().ahO == 1 && this.afG.vJ().ahL) {
                String str = this.afG.vK().mErrorString;
                this.afG.vK().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.pf();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    uV();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cq(currentAccountObj.getAccount());
                if (ReloginManager.tX().ub()) {
                    AccountData ua = ReloginManager.tX().ua();
                    if (ua == null) {
                        ReloginManager.tX().f(ua);
                        return null;
                    }
                    return cG(i);
                }
                com.baidu.tbadk.core.data.ai e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xn = com.baidu.tbadk.coreExtra.a.a.xn()) != null) {
                    xn.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.afI != null) {
                        this.afG.vK().mErrorString = this.afI.getErrorString();
                        return null;
                    }
                    this.afG.vK().mErrorString = str;
                    return us;
                }
                us = cG(i);
            }
            com.baidu.tieba.h.a.a(this);
            return us;
        } else {
            return us;
        }
    }

    private String cG(int i) {
        String us;
        uO();
        switch (i) {
            case 1:
                us = this.afH.ur();
                break;
            case 2:
                us = this.afH.up();
                break;
            case 3:
                us = this.afH.us();
                break;
            default:
                return null;
        }
        if (this.afG.vK().uQ()) {
            switch (this.afG.vK().ahO) {
                case 1:
                case 2:
                case 5:
                    uV();
                    this.afG.vK().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return us;
            }
        }
        return us;
    }

    private void uV() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String up() {
        return cF(2);
    }

    public String ur() {
        return cF(1);
    }

    public String us() {
        return cF(3);
    }

    public String dD(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dn = k.dn(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dn.read(bArr2);
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
        return us();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uN().vJ().a(this.afH);
        return this.afH.a(str, handler, i, i2, i3, z);
    }
}
