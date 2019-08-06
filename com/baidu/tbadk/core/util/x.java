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
    private boolean bSm;
    private com.baidu.tbadk.core.util.a.a bSj = null;
    private q bSk = null;
    private x bSl = null;
    private aa.a bSn = null;
    private int bSo = 0;

    private void aiF() {
        this.bSj = new com.baidu.tbadk.core.util.a.a();
        this.bSk = z.aiQ().a(this.bSj);
        this.bSl = null;
        this.bSj.ajG().ajJ().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aF(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aiG() {
        return this.bSj;
    }

    public x() {
        aiF();
    }

    public x(String str) {
        aiF();
        this.bSj.ajG().ajJ().mUrl = str;
    }

    public void setUrl(String str) {
        this.bSj.ajG().ajJ().mUrl = str;
    }

    public void u(ArrayList<BasicNameValuePair> arrayList) {
        this.bSk.u(arrayList);
    }

    public void o(String str, String str2) {
        this.bSk.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bSk.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bSk.d(str, bArr);
    }

    private void aiH() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> aih = this.bSk.aih();
            int size = aih.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = aih.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    aih.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    aih.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void aiI() {
        if (this.bSn == null) {
            this.bSn = aa.aiR();
        }
        if (this.bSn != null) {
            this.bSk.o("stTime", String.valueOf(this.bSn.mTime));
            this.bSk.o("stSize", String.valueOf(this.bSn.aWr));
            this.bSk.o("stTimesNum", String.valueOf(this.bSn.bSE));
            this.bSk.o("stMode", String.valueOf(this.bSn.mMode));
            this.bSk.o("stMethod", String.valueOf(this.bSn.bSD));
        }
        this.bSo = aa.hZ(0);
        if (this.bSo == 0 && this.bSn != null) {
            this.bSo = this.bSn.bSE;
        }
        this.bSk.o("stErrorNums", String.valueOf(this.bSo));
    }

    public boolean aiJ() {
        return this.bSj.ajH().aiJ();
    }

    public int aiK() {
        return this.bSj.ajH().bUO;
    }

    public int aiL() {
        return this.bSj.ajH().AR;
    }

    public String aiM() {
        return this.bSj.ajH().bUP;
    }

    public String getErrorString() {
        return this.bSj.ajH().mErrorString;
    }

    public void ik() {
        if (this.bSk != null) {
            this.bSk.ik();
        }
        if (this.bSl != null) {
            this.bSl.ik();
        }
    }

    public void in() {
        if (this.bSk != null) {
            this.bSk.in();
        }
        if (this.bSl != null) {
            this.bSl.in();
        }
    }

    public void eb(boolean z) {
        this.bSm = z;
    }

    private com.baidu.tbadk.core.data.ag r(String str, String str2, boolean z) {
        String aii;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.bSl == null) {
                this.bSl = new x(sb.toString());
            } else {
                this.bSl.ik();
            }
            this.bSl.aiG().ajG().mIsNeedAddCommenParam = false;
            this.bSl.aiG().ajG().mIsUseCurrentBDUSS = false;
            this.bSl.aiG().ajG().bUM = false;
            this.bSl.o("un", str);
            this.bSl.o("passwd", str2);
            this.bSl.o("isphone", "0");
            this.bSl.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bSl.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bSl.aiG().ajG().ajJ().bVm = true;
            aii = this.bSl.aii();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bSl.aiG().ajH().isRequestSuccess() && aii != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(aii);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bSj.ajH().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.bSl.aiJ()) {
            switch (this.bSl.aiK()) {
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

    public byte[] aij() {
        if (!this.bSj.ajG().mIsFromCDN) {
            this.bSj.ajG().b(this.bSk);
        }
        return this.bSk.aij();
    }

    private void aiN() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> aih = this.bSk.aih();
        for (int i = 0; aih != null && i < aih.size(); i++) {
            BasicNameValuePair basicNameValuePair = aih.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.bSk.o("sign", com.baidu.adp.lib.util.s.bn(stringBuffer.toString()));
        if (this.bSj.ajG().bSm) {
            this.bSk.o("sig", StringU.rK(stringBuffer.toString()));
        }
    }

    private String hW(int i) {
        String ail;
        this.bSj.ajG().bSm = this.bSm && com.baidu.tbadk.t.w.iN();
        switch (i) {
            case 1:
                if (aiG().ajG().mIsNeedAddCommenParam) {
                    this.bSj.ajG().b(this.bSk);
                }
                aiI();
                ail = this.bSk.aik();
                break;
            case 2:
                if (aiG().ajG().mIsUseCurrentBDUSS) {
                    aiG().ajG().a(this.bSk);
                }
                if (aiG().ajG().mIsNeedAddCommenParam) {
                    this.bSj.ajG().b(this.bSk);
                }
                aiI();
                ail = this.bSk.aii();
                break;
            case 3:
                if (aiG().ajG().mIsUseCurrentBDUSS) {
                    aiG().ajG().a(this.bSk);
                }
                if (aiG().ajG().mIsNeedAddCommenParam) {
                    this.bSj.ajG().b(this.bSk);
                }
                aiN();
                ail = this.bSk.ail();
                break;
            default:
                return null;
        }
        if (!this.bSj.ajH().aiJ()) {
            aa.a(this.bSn);
            aa.ia(this.bSo);
            return ail;
        } else if (!this.bSj.ajH().isRequestSuccess()) {
            if (this.bSj.ajH().bUO == 1 && this.bSj.ajG().bUM) {
                String str = this.bSj.ajH().mErrorString;
                this.bSj.ajH().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.acj();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aiO();
                    return null;
                }
                com.baidu.tbadk.core.a.b.ml(currentAccountObj.getID());
                if (ReloginManager.ahJ().ahM()) {
                    f(currentAccountObj);
                    ReloginManager.ahJ().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag r = r(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (r == null) {
                    if (this.bSl != null) {
                        this.bSj.ajH().mErrorString = this.bSl.getErrorString();
                        return null;
                    }
                    this.bSj.ajH().mErrorString = str;
                    return ail;
                }
                ail = hX(i);
            }
            com.baidu.tieba.i.a.a(this);
            return ail;
        } else {
            return ail;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c alK;
        if (!TextUtils.isEmpty(accountData.getID()) && (alK = com.baidu.tbadk.coreExtra.a.a.alK()) != null) {
            alK.f(accountData);
        }
    }

    private String hX(int i) {
        String ail;
        aiH();
        switch (i) {
            case 1:
                ail = this.bSk.aik();
                break;
            case 2:
                ail = this.bSk.aii();
                break;
            case 3:
                ail = this.bSk.ail();
                break;
            default:
                return null;
        }
        if (this.bSj.ajH().aiJ()) {
            switch (this.bSj.ajH().bUO) {
                case 1:
                case 2:
                case 5:
                    aiO();
                    this.bSj.ajH().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return ail;
            }
        }
        return ail;
    }

    private void aiO() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String aii() {
        return hW(2);
    }

    public String aik() {
        return hW(1);
    }

    public String ail() {
        return hW(3);
    }

    public String nR(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream nB = m.nB(str);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
            while (true) {
                int read = nB.read(bArr2);
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
        return ail();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aiG().ajG().a(this.bSk);
        return this.bSk.a(str, handler, i, i2, i3, z);
    }
}
