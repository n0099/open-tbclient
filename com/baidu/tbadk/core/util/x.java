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
    private com.baidu.tbadk.core.util.a.a agh = null;
    private q agi = null;
    private x agj = null;
    private aa.a agk = null;
    private int agl = 0;

    private void uM() {
        this.agh = new com.baidu.tbadk.core.util.a.a();
        this.agi = z.uX().a(this.agh);
        this.agj = null;
        this.agh.vK().vN().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uN() {
        return this.agh;
    }

    public x() {
        uM();
    }

    public x(String str) {
        uM();
        this.agh.vK().vN().mUrl = str;
    }

    public void setUrl(String str) {
        this.agh.vK().vN().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.agi.l(arrayList);
    }

    public void n(String str, String str2) {
        this.agi.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.agi.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.agi.d(str, bArr);
    }

    private void uO() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uo = this.agi.uo();
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
        if (this.agk == null) {
            this.agk = aa.uY();
        }
        if (this.agk != null) {
            this.agi.n("stTime", String.valueOf(this.agk.mTime));
            this.agi.n("stSize", String.valueOf(this.agk.agB));
            this.agi.n("stTimesNum", String.valueOf(this.agk.agC));
            this.agi.n("stMode", String.valueOf(this.agk.mMode));
            this.agi.n("stMethod", String.valueOf(this.agk.agA));
        }
        this.agl = aa.cI(0);
        if (this.agl == 0 && this.agk != null) {
            this.agl = this.agk.agC;
        }
        this.agi.n("stErrorNums", String.valueOf(this.agl));
    }

    public boolean uQ() {
        return this.agh.vL().uQ();
    }

    public int uR() {
        return this.agh.vL().aiq;
    }

    public int uS() {
        return this.agh.vL().vm;
    }

    public String uT() {
        return this.agh.vL().air;
    }

    public String getErrorString() {
        return this.agh.vL().mErrorString;
    }

    public void fo() {
        if (this.agi != null) {
            this.agi.fo();
        }
        if (this.agj != null) {
            this.agj.fo();
        }
    }

    public void fs() {
        if (this.agi != null) {
            this.agi.fs();
        }
        if (this.agj != null) {
            this.agj.fs();
        }
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String up;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.agj == null) {
                this.agj = new x(sb.toString());
            } else {
                this.agj.fo();
            }
            this.agj.uN().vK().mIsNeedAddCommenParam = false;
            this.agj.uN().vK().mIsUseCurrentBDUSS = false;
            this.agj.uN().vK().ain = false;
            this.agj.n("un", str);
            this.agj.n("passwd", str2);
            this.agj.n("isphone", "0");
            this.agj.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.agj.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.agj.uN().vK().vN().aiO = true;
            up = this.agj.up();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.agj.uN().vL().isRequestSuccess() && up != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(up);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.agh.vL().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
            if (aeVar.qg() != null) {
                accountData.setTbs(aeVar.qg().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.agj.uQ()) {
            switch (this.agj.uR()) {
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
        if (!this.agh.vK().mIsFromCDN) {
            this.agh.vK().b(this.agi);
        }
        return this.agi.uq();
    }

    private void uU() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uo = this.agi.uo();
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
        this.agi.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(stringBuffer.toString()));
    }

    private String cF(int i) {
        String us;
        com.baidu.tbadk.coreExtra.a.c xn;
        switch (i) {
            case 1:
                if (uN().vK().mIsNeedAddCommenParam) {
                    this.agh.vK().b(this.agi);
                }
                uP();
                us = this.agi.ur();
                break;
            case 2:
                if (uN().vK().mIsUseCurrentBDUSS) {
                    uN().vK().a(this.agi);
                }
                if (uN().vK().mIsNeedAddCommenParam) {
                    this.agh.vK().b(this.agi);
                }
                uP();
                us = this.agi.up();
                break;
            case 3:
                if (uN().vK().mIsUseCurrentBDUSS) {
                    uN().vK().a(this.agi);
                }
                if (uN().vK().mIsNeedAddCommenParam) {
                    this.agh.vK().b(this.agi);
                }
                uU();
                us = this.agi.us();
                break;
            default:
                return null;
        }
        if (!this.agh.vL().uQ()) {
            aa.a(this.agk);
            aa.cJ(this.agl);
            return us;
        } else if (!this.agh.vL().isRequestSuccess()) {
            if (this.agh.vL().aiq == 1 && this.agh.vK().ain) {
                String str = this.agh.vL().mErrorString;
                this.agh.vL().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.pj();
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
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xn = com.baidu.tbadk.coreExtra.a.a.xn()) != null) {
                    xn.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.agj != null) {
                        this.agh.vL().mErrorString = this.agj.getErrorString();
                        return null;
                    }
                    this.agh.vL().mErrorString = str;
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
                us = this.agi.ur();
                break;
            case 2:
                us = this.agi.up();
                break;
            case 3:
                us = this.agi.us();
                break;
            default:
                return null;
        }
        if (this.agh.vL().uQ()) {
            switch (this.agh.vL().aiq) {
                case 1:
                case 2:
                case 5:
                    uV();
                    this.agh.vL().mErrorString = "";
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

    public String dK(String str) throws IOException {
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
        uN().vK().a(this.agi);
        return this.agi.a(str, handler, i, i2, i3, z);
    }
}
