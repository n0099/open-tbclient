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
    private boolean bSg;
    private com.baidu.tbadk.core.util.a.a bSd = null;
    private q bSe = null;
    private x bSf = null;
    private aa.a bSh = null;
    private int bSi = 0;

    private void aiD() {
        this.bSd = new com.baidu.tbadk.core.util.a.a();
        this.bSe = z.aiO().a(this.bSd);
        this.bSf = null;
        this.bSd.ajE().ajH().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aF(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aiE() {
        return this.bSd;
    }

    public x() {
        aiD();
    }

    public x(String str) {
        aiD();
        this.bSd.ajE().ajH().mUrl = str;
    }

    public void setUrl(String str) {
        this.bSd.ajE().ajH().mUrl = str;
    }

    public void u(ArrayList<BasicNameValuePair> arrayList) {
        this.bSe.u(arrayList);
    }

    public void o(String str, String str2) {
        this.bSe.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bSe.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bSe.d(str, bArr);
    }

    private void aiF() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> aif = this.bSe.aif();
            int size = aif.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = aif.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    aif.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    aif.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void aiG() {
        if (this.bSh == null) {
            this.bSh = aa.aiP();
        }
        if (this.bSh != null) {
            this.bSe.o("stTime", String.valueOf(this.bSh.mTime));
            this.bSe.o("stSize", String.valueOf(this.bSh.aWr));
            this.bSe.o("stTimesNum", String.valueOf(this.bSh.bSy));
            this.bSe.o("stMode", String.valueOf(this.bSh.mMode));
            this.bSe.o("stMethod", String.valueOf(this.bSh.bSx));
        }
        this.bSi = aa.hZ(0);
        if (this.bSi == 0 && this.bSh != null) {
            this.bSi = this.bSh.bSy;
        }
        this.bSe.o("stErrorNums", String.valueOf(this.bSi));
    }

    public boolean aiH() {
        return this.bSd.ajF().aiH();
    }

    public int aiI() {
        return this.bSd.ajF().bUI;
    }

    public int aiJ() {
        return this.bSd.ajF().AR;
    }

    public String aiK() {
        return this.bSd.ajF().bUJ;
    }

    public String getErrorString() {
        return this.bSd.ajF().mErrorString;
    }

    public void ik() {
        if (this.bSe != null) {
            this.bSe.ik();
        }
        if (this.bSf != null) {
            this.bSf.ik();
        }
    }

    public void in() {
        if (this.bSe != null) {
            this.bSe.in();
        }
        if (this.bSf != null) {
            this.bSf.in();
        }
    }

    public void eb(boolean z) {
        this.bSg = z;
    }

    private com.baidu.tbadk.core.data.ag r(String str, String str2, boolean z) {
        String aig;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.bSf == null) {
                this.bSf = new x(sb.toString());
            } else {
                this.bSf.ik();
            }
            this.bSf.aiE().ajE().mIsNeedAddCommenParam = false;
            this.bSf.aiE().ajE().mIsUseCurrentBDUSS = false;
            this.bSf.aiE().ajE().bUG = false;
            this.bSf.o("un", str);
            this.bSf.o("passwd", str2);
            this.bSf.o("isphone", "0");
            this.bSf.o("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bSf.o("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bSf.aiE().ajE().ajH().bVg = true;
            aig = this.bSf.aig();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bSf.aiE().ajF().isRequestSuccess() && aig != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(aig);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bSd.ajF().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.bSf.aiH()) {
            switch (this.bSf.aiI()) {
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

    public byte[] aih() {
        if (!this.bSd.ajE().mIsFromCDN) {
            this.bSd.ajE().b(this.bSe);
        }
        return this.bSe.aih();
    }

    private void aiL() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> aif = this.bSe.aif();
        for (int i = 0; aif != null && i < aif.size(); i++) {
            BasicNameValuePair basicNameValuePair = aif.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.bSe.o("sign", com.baidu.adp.lib.util.s.bn(stringBuffer.toString()));
        if (this.bSd.ajE().bSg) {
            this.bSe.o("sig", StringU.rK(stringBuffer.toString()));
        }
    }

    private String hW(int i) {
        String aij;
        this.bSd.ajE().bSg = this.bSg && com.baidu.tbadk.t.w.iN();
        switch (i) {
            case 1:
                if (aiE().ajE().mIsNeedAddCommenParam) {
                    this.bSd.ajE().b(this.bSe);
                }
                aiG();
                aij = this.bSe.aii();
                break;
            case 2:
                if (aiE().ajE().mIsUseCurrentBDUSS) {
                    aiE().ajE().a(this.bSe);
                }
                if (aiE().ajE().mIsNeedAddCommenParam) {
                    this.bSd.ajE().b(this.bSe);
                }
                aiG();
                aij = this.bSe.aig();
                break;
            case 3:
                if (aiE().ajE().mIsUseCurrentBDUSS) {
                    aiE().ajE().a(this.bSe);
                }
                if (aiE().ajE().mIsNeedAddCommenParam) {
                    this.bSd.ajE().b(this.bSe);
                }
                aiL();
                aij = this.bSe.aij();
                break;
            default:
                return null;
        }
        if (!this.bSd.ajF().aiH()) {
            aa.a(this.bSh);
            aa.ia(this.bSi);
            return aij;
        } else if (!this.bSd.ajF().isRequestSuccess()) {
            if (this.bSd.ajF().bUI == 1 && this.bSd.ajE().bUG) {
                String str = this.bSd.ajF().mErrorString;
                this.bSd.ajF().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.acj();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aiM();
                    return null;
                }
                com.baidu.tbadk.core.a.b.ml(currentAccountObj.getID());
                if (ReloginManager.ahH().ahK()) {
                    f(currentAccountObj);
                    ReloginManager.ahH().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag r = r(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (r == null) {
                    if (this.bSf != null) {
                        this.bSd.ajF().mErrorString = this.bSf.getErrorString();
                        return null;
                    }
                    this.bSd.ajF().mErrorString = str;
                    return aij;
                }
                aij = hX(i);
            }
            com.baidu.tieba.i.a.a(this);
            return aij;
        } else {
            return aij;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c alI;
        if (!TextUtils.isEmpty(accountData.getID()) && (alI = com.baidu.tbadk.coreExtra.a.a.alI()) != null) {
            alI.f(accountData);
        }
    }

    private String hX(int i) {
        String aij;
        aiF();
        switch (i) {
            case 1:
                aij = this.bSe.aii();
                break;
            case 2:
                aij = this.bSe.aig();
                break;
            case 3:
                aij = this.bSe.aij();
                break;
            default:
                return null;
        }
        if (this.bSd.ajF().aiH()) {
            switch (this.bSd.ajF().bUI) {
                case 1:
                case 2:
                case 5:
                    aiM();
                    this.bSd.ajF().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return aij;
            }
        }
        return aij;
    }

    private void aiM() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String aig() {
        return hW(2);
    }

    public String aii() {
        return hW(1);
    }

    public String aij() {
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
        return aij();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aiE().ajE().a(this.bSe);
        return this.bSe.a(str, handler, i, i2, i3, z);
    }
}
