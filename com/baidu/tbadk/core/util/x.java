package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private boolean bSN;
    private com.baidu.tbadk.core.util.a.a bSK = null;
    private q bSL = null;
    private x bSM = null;
    private aa.a bSO = null;
    private int bSP = 0;

    private void aiJ() {
        this.bSK = new com.baidu.tbadk.core.util.a.a();
        this.bSL = z.aiU().a(this.bSK);
        this.bSM = null;
        this.bSK.ajM().ajP().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aF(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aiK() {
        return this.bSK;
    }

    public x() {
        aiJ();
    }

    public x(String str) {
        aiJ();
        this.bSK.ajM().ajP().mUrl = str;
    }

    public void setUrl(String str) {
        this.bSK.ajM().ajP().mUrl = str;
    }

    public void u(ArrayList<BasicNameValuePair> arrayList) {
        this.bSL.u(arrayList);
    }

    public void o(String str, String str2) {
        this.bSL.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bSL.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bSL.d(str, bArr);
    }

    private void aiL() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ail = this.bSL.ail();
            int size = ail.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ail.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ail.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ail.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void aiM() {
        if (this.bSO == null) {
            this.bSO = aa.aiV();
        }
        if (this.bSO != null) {
            this.bSL.o("stTime", String.valueOf(this.bSO.mTime));
            this.bSL.o("stSize", String.valueOf(this.bSO.aWP));
            this.bSL.o("stTimesNum", String.valueOf(this.bSO.bTf));
            this.bSL.o("stMode", String.valueOf(this.bSO.mMode));
            this.bSL.o("stMethod", String.valueOf(this.bSO.bTe));
        }
        this.bSP = aa.hZ(0);
        if (this.bSP == 0 && this.bSO != null) {
            this.bSP = this.bSO.bTf;
        }
        this.bSL.o("stErrorNums", String.valueOf(this.bSP));
    }

    public boolean aiN() {
        return this.bSK.ajN().aiN();
    }

    public int aiO() {
        return this.bSK.ajN().bVr;
    }

    public int aiP() {
        return this.bSK.ajN().AR;
    }

    public String aiQ() {
        return this.bSK.ajN().bVs;
    }

    public String getErrorString() {
        return this.bSK.ajN().mErrorString;
    }

    public void ik() {
        if (this.bSL != null) {
            this.bSL.ik();
        }
        if (this.bSM != null) {
            this.bSM.ik();
        }
    }

    public void in() {
        if (this.bSL != null) {
            this.bSL.in();
        }
        if (this.bSM != null) {
            this.bSM.in();
        }
    }

    public void eb(boolean z) {
        this.bSN = z;
    }

    private com.baidu.tbadk.core.data.ag r(String str, String str2, boolean z) {
        String aim;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.bSM == null) {
                this.bSM = new x(sb.toString());
            } else {
                this.bSM.ik();
            }
            this.bSM.aiK().ajM().mIsNeedAddCommenParam = false;
            this.bSM.aiK().ajM().mIsUseCurrentBDUSS = false;
            this.bSM.aiK().ajM().bVp = false;
            this.bSM.o("un", str);
            this.bSM.o("passwd", str2);
            this.bSM.o("isphone", "0");
            this.bSM.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bSM.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bSM.aiK().ajM().ajP().bVR = true;
            aim = this.bSM.aim();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bSM.aiK().ajN().isRequestSuccess() && aim != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(aim);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bSK.ajN().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(agVar.getUser().getUserName());
            if (agVar.getUser().getPassword() != null) {
                accountData.setPassword(agVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(agVar.getUser().getUserId());
            accountData.setBDUSS(agVar.getUser().getBDUSS());
            accountData.setPortrait(agVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (agVar.getAnti() != null) {
                accountData.setTbs(agVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return agVar;
        }
        if (this.bSM.aiN()) {
            switch (this.bSM.aiO()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] ain() {
        if (!this.bSK.ajM().mIsFromCDN) {
            this.bSK.ajM().b(this.bSL);
        }
        return this.bSL.ain();
    }

    private void aiR() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ail = this.bSL.ail();
        for (int i = 0; ail != null && i < ail.size(); i++) {
            BasicNameValuePair basicNameValuePair = ail.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.bSL.o("sign", com.baidu.adp.lib.util.s.bn(stringBuffer.toString()));
        if (this.bSK.ajM().bSN) {
            this.bSL.o("sig", StringU.rV(stringBuffer.toString()));
        }
    }

    private String hW(int i) {
        String aip;
        this.bSK.ajM().bSN = this.bSN && com.baidu.tbadk.t.w.iN();
        switch (i) {
            case 1:
                if (aiK().ajM().mIsNeedAddCommenParam) {
                    this.bSK.ajM().b(this.bSL);
                }
                aiM();
                aip = this.bSL.aio();
                break;
            case 2:
                if (aiK().ajM().mIsUseCurrentBDUSS) {
                    aiK().ajM().a(this.bSL);
                }
                if (aiK().ajM().mIsNeedAddCommenParam) {
                    this.bSK.ajM().b(this.bSL);
                }
                aiM();
                aip = this.bSL.aim();
                break;
            case 3:
                if (aiK().ajM().mIsUseCurrentBDUSS) {
                    aiK().ajM().a(this.bSL);
                }
                if (aiK().ajM().mIsNeedAddCommenParam) {
                    this.bSK.ajM().b(this.bSL);
                }
                aiR();
                aip = this.bSL.aip();
                break;
            default:
                return null;
        }
        if (!this.bSK.ajN().aiN()) {
            aa.a(this.bSO);
            aa.ia(this.bSP);
            return aip;
        } else if (!this.bSK.ajN().isRequestSuccess()) {
            if (this.bSK.ajN().bVr == 1 && this.bSK.ajM().bVp) {
                String str = this.bSK.ajN().mErrorString;
                this.bSK.ajN().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.acn();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aiS();
                    return null;
                }
                com.baidu.tbadk.core.a.b.mn(currentAccountObj.getID());
                if (ReloginManager.ahN().ahQ()) {
                    f(currentAccountObj);
                    ReloginManager.ahN().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag r = r(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (r == null) {
                    if (this.bSM != null) {
                        this.bSK.ajN().mErrorString = this.bSM.getErrorString();
                        return null;
                    }
                    this.bSK.ajN().mErrorString = str;
                    return aip;
                }
                aip = hX(i);
            }
            com.baidu.tieba.i.a.a(this);
            return aip;
        } else {
            return aip;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c alW;
        if (!TextUtils.isEmpty(accountData.getID()) && (alW = com.baidu.tbadk.coreExtra.a.a.alW()) != null) {
            alW.f(accountData);
        }
    }

    private String hX(int i) {
        String aip;
        aiL();
        switch (i) {
            case 1:
                aip = this.bSL.aio();
                break;
            case 2:
                aip = this.bSL.aim();
                break;
            case 3:
                aip = this.bSL.aip();
                break;
            default:
                return null;
        }
        if (this.bSK.ajN().aiN()) {
            switch (this.bSK.ajN().bVr) {
                case 1:
                case 2:
                case 5:
                    aiS();
                    this.bSK.ajN().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return aip;
            }
        }
        return aip;
    }

    private void aiS() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String aim() {
        return hW(2);
    }

    public String aio() {
        return hW(1);
    }

    public String aip() {
        return hW(3);
    }

    public String nT(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream nD = m.nD(str);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
            while (true) {
                int read = nD.read(bArr2);
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
        return aip();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aiK().ajM().a(this.bSL);
        return this.bSL.a(str, handler, i, i2, i3, z);
    }
}
