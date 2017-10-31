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
    private com.baidu.tbadk.core.util.a.a afP = null;
    private q afQ = null;
    private x afR = null;
    private aa.a afS = null;
    private int afT = 0;

    private void uM() {
        this.afP = new com.baidu.tbadk.core.util.a.a();
        this.afQ = z.uX().a(this.afP);
        this.afR = null;
        this.afP.vK().vN().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uN() {
        return this.afP;
    }

    public x() {
        uM();
    }

    public x(String str) {
        uM();
        this.afP.vK().vN().mUrl = str;
    }

    public void setUrl(String str) {
        this.afP.vK().vN().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.afQ.l(arrayList);
    }

    public void n(String str, String str2) {
        this.afQ.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.afQ.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.afQ.d(str, bArr);
    }

    private void uO() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uo = this.afQ.uo();
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
        if (this.afS == null) {
            this.afS = aa.uY();
        }
        if (this.afS != null) {
            this.afQ.n("stTime", String.valueOf(this.afS.mTime));
            this.afQ.n("stSize", String.valueOf(this.afS.agk));
            this.afQ.n("stTimesNum", String.valueOf(this.afS.agl));
            this.afQ.n("stMode", String.valueOf(this.afS.mMode));
            this.afQ.n("stMethod", String.valueOf(this.afS.agj));
        }
        this.afT = aa.cI(0);
        if (this.afT == 0 && this.afS != null) {
            this.afT = this.afS.agl;
        }
        this.afQ.n("stErrorNums", String.valueOf(this.afT));
    }

    public boolean uQ() {
        return this.afP.vL().uQ();
    }

    public int uR() {
        return this.afP.vL().ahZ;
    }

    public int uS() {
        return this.afP.vL().vp;
    }

    public String uT() {
        return this.afP.vL().aia;
    }

    public String getErrorString() {
        return this.afP.vL().mErrorString;
    }

    public void fo() {
        if (this.afQ != null) {
            this.afQ.fo();
        }
        if (this.afR != null) {
            this.afR.fo();
        }
    }

    public void fs() {
        if (this.afQ != null) {
            this.afQ.fs();
        }
        if (this.afR != null) {
            this.afR.fs();
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
            if (this.afR == null) {
                this.afR = new x(sb.toString());
            } else {
                this.afR.fo();
            }
            this.afR.uN().vK().mIsNeedAddCommenParam = false;
            this.afR.uN().vK().mIsUseCurrentBDUSS = false;
            this.afR.uN().vK().ahW = false;
            this.afR.n("un", str);
            this.afR.n("passwd", str2);
            this.afR.n("isphone", "0");
            this.afR.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.afR.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.afR.uN().vK().vN().aix = true;
            up = this.afR.up();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.afR.uN().vL().isRequestSuccess() && up != null) {
            com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
            aiVar.parserJson(up);
            String userId = aiVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.afP.vL().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
            if (aiVar.qf() != null) {
                accountData.setTbs(aiVar.qf().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aiVar;
        }
        if (this.afR.uQ()) {
            switch (this.afR.uR()) {
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
        if (!this.afP.vK().mIsFromCDN) {
            this.afP.vK().b(this.afQ);
        }
        return this.afQ.uq();
    }

    private void uU() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uo = this.afQ.uo();
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
        this.afQ.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(stringBuffer.toString()));
    }

    private String cF(int i) {
        String us;
        com.baidu.tbadk.coreExtra.a.c xn;
        switch (i) {
            case 1:
                if (uN().vK().mIsNeedAddCommenParam) {
                    this.afP.vK().b(this.afQ);
                }
                uP();
                us = this.afQ.ur();
                break;
            case 2:
                if (uN().vK().mIsUseCurrentBDUSS) {
                    uN().vK().a(this.afQ);
                }
                if (uN().vK().mIsNeedAddCommenParam) {
                    this.afP.vK().b(this.afQ);
                }
                uP();
                us = this.afQ.up();
                break;
            case 3:
                if (uN().vK().mIsUseCurrentBDUSS) {
                    uN().vK().a(this.afQ);
                }
                if (uN().vK().mIsNeedAddCommenParam) {
                    this.afP.vK().b(this.afQ);
                }
                uU();
                us = this.afQ.us();
                break;
            default:
                return null;
        }
        if (!this.afP.vL().uQ()) {
            aa.a(this.afS);
            aa.cJ(this.afT);
            return us;
        } else if (!this.afP.vL().isRequestSuccess()) {
            if (this.afP.vL().ahZ == 1 && this.afP.vK().ahW) {
                String str = this.afP.vL().mErrorString;
                this.afP.vL().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.pe();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    uV();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cv(currentAccountObj.getAccount());
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
                    if (this.afR != null) {
                        this.afP.vL().mErrorString = this.afR.getErrorString();
                        return null;
                    }
                    this.afP.vL().mErrorString = str;
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
                us = this.afQ.ur();
                break;
            case 2:
                us = this.afQ.up();
                break;
            case 3:
                us = this.afQ.us();
                break;
            default:
                return null;
        }
        if (this.afP.vL().uQ()) {
            switch (this.afP.vL().ahZ) {
                case 1:
                case 2:
                case 5:
                    uV();
                    this.afP.vL().mErrorString = "";
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

    public String dI(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dt = k.dt(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dt.read(bArr2);
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
        uN().vK().a(this.afQ);
        return this.afQ.a(str, handler, i, i2, i3, z);
    }
}
