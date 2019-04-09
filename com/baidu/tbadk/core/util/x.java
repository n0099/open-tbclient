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
import com.baidu.tieba.StringU;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private boolean bJv;
    private com.baidu.tbadk.core.util.a.a bJs = null;
    private q bJt = null;
    private x bJu = null;
    private aa.a bJw = null;
    private int bJx = 0;

    private void acD() {
        this.bJs = new com.baidu.tbadk.core.util.a.a();
        this.bJt = z.acO().a(this.bJs);
        this.bJu = null;
        this.bJs.adC().adF().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a acE() {
        return this.bJs;
    }

    public x() {
        acD();
    }

    public x(String str) {
        acD();
        this.bJs.adC().adF().mUrl = str;
    }

    public void setUrl(String str) {
        this.bJs.adC().adF().mUrl = str;
    }

    public void r(ArrayList<BasicNameValuePair> arrayList) {
        this.bJt.r(arrayList);
    }

    public void x(String str, String str2) {
        this.bJt.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bJt.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bJt.d(str, bArr);
    }

    private void acF() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> acf = this.bJt.acf();
            int size = acf.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = acf.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    acf.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    acf.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void acG() {
        if (this.bJw == null) {
            this.bJw = aa.acP();
        }
        if (this.bJw != null) {
            this.bJt.x("stTime", String.valueOf(this.bJw.mTime));
            this.bJt.x("stSize", String.valueOf(this.bJw.aSS));
            this.bJt.x("stTimesNum", String.valueOf(this.bJw.bJN));
            this.bJt.x("stMode", String.valueOf(this.bJw.mMode));
            this.bJt.x("stMethod", String.valueOf(this.bJw.bJM));
        }
        this.bJx = aa.hf(0);
        if (this.bJx == 0 && this.bJw != null) {
            this.bJx = this.bJw.bJN;
        }
        this.bJt.x("stErrorNums", String.valueOf(this.bJx));
    }

    public boolean acH() {
        return this.bJs.adD().acH();
    }

    public int acI() {
        return this.bJs.adD().bLV;
    }

    public int acJ() {
        return this.bJs.adD().Dd;
    }

    public String acK() {
        return this.bJs.adD().bLW;
    }

    public String getErrorString() {
        return this.bJs.adD().mErrorString;
    }

    public void ji() {
        if (this.bJt != null) {
            this.bJt.ji();
        }
        if (this.bJu != null) {
            this.bJu.ji();
        }
    }

    public void jl() {
        if (this.bJt != null) {
            this.bJt.jl();
        }
        if (this.bJu != null) {
            this.bJu.jl();
        }
    }

    public void dB(boolean z) {
        this.bJv = z;
    }

    private com.baidu.tbadk.core.data.ag q(String str, String str2, boolean z) {
        String acg;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.bJu == null) {
                this.bJu = new x(sb.toString());
            } else {
                this.bJu.ji();
            }
            this.bJu.acE().adC().mIsNeedAddCommenParam = false;
            this.bJu.acE().adC().mIsUseCurrentBDUSS = false;
            this.bJu.acE().adC().bLT = false;
            this.bJu.x("un", str);
            this.bJu.x("passwd", str2);
            this.bJu.x("isphone", "0");
            this.bJu.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bJu.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bJu.acE().adC().adF().bMt = true;
            acg = this.bJu.acg();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bJu.acE().adD().isRequestSuccess() && acg != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(acg);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bJs.adD().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return agVar;
        }
        if (this.bJu.acH()) {
            switch (this.bJu.acI()) {
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

    public byte[] ach() {
        if (!this.bJs.adC().mIsFromCDN) {
            this.bJs.adC().b(this.bJt);
        }
        return this.bJt.ach();
    }

    private void acL() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> acf = this.bJt.acf();
        for (int i = 0; acf != null && i < acf.size(); i++) {
            BasicNameValuePair basicNameValuePair = acf.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.bJt.x("sign", com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.bJs.adC().bJv) {
            this.bJt.x("sig", StringU.qk(stringBuffer.toString()));
        }
    }

    private String hc(int i) {
        String acj;
        this.bJs.adC().bJv = this.bJv && com.baidu.tbadk.s.t.jK();
        switch (i) {
            case 1:
                if (acE().adC().mIsNeedAddCommenParam) {
                    this.bJs.adC().b(this.bJt);
                }
                acG();
                acj = this.bJt.aci();
                break;
            case 2:
                if (acE().adC().mIsUseCurrentBDUSS) {
                    acE().adC().a(this.bJt);
                }
                if (acE().adC().mIsNeedAddCommenParam) {
                    this.bJs.adC().b(this.bJt);
                }
                acG();
                acj = this.bJt.acg();
                break;
            case 3:
                if (acE().adC().mIsUseCurrentBDUSS) {
                    acE().adC().a(this.bJt);
                }
                if (acE().adC().mIsNeedAddCommenParam) {
                    this.bJs.adC().b(this.bJt);
                }
                acL();
                acj = this.bJt.acj();
                break;
            default:
                return null;
        }
        if (!this.bJs.adD().acH()) {
            aa.a(this.bJw);
            aa.hg(this.bJx);
            return acj;
        } else if (!this.bJs.adD().isRequestSuccess()) {
            if (this.bJs.adD().bLV == 1 && this.bJs.adC().bLT) {
                String str = this.bJs.adD().mErrorString;
                this.bJs.adD().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.WE();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    acM();
                    return null;
                }
                com.baidu.tbadk.core.a.b.kX(currentAccountObj.getID());
                if (ReloginManager.abN().abQ()) {
                    f(currentAccountObj);
                    ReloginManager.abN().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag q = q(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (q == null) {
                    if (this.bJu != null) {
                        this.bJs.adD().mErrorString = this.bJu.getErrorString();
                        return null;
                    }
                    this.bJs.adD().mErrorString = str;
                    return acj;
                }
                acj = hd(i);
            }
            com.baidu.tieba.i.a.a(this);
            return acj;
        } else {
            return acj;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c afE;
        if (!TextUtils.isEmpty(accountData.getID()) && (afE = com.baidu.tbadk.coreExtra.a.a.afE()) != null) {
            afE.f(accountData);
        }
    }

    private String hd(int i) {
        String acj;
        acF();
        switch (i) {
            case 1:
                acj = this.bJt.aci();
                break;
            case 2:
                acj = this.bJt.acg();
                break;
            case 3:
                acj = this.bJt.acj();
                break;
            default:
                return null;
        }
        if (this.bJs.adD().acH()) {
            switch (this.bJs.adD().bLV) {
                case 1:
                case 2:
                case 5:
                    acM();
                    this.bJs.adD().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return acj;
            }
        }
        return acj;
    }

    private void acM() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String acg() {
        return hc(2);
    }

    public String aci() {
        return hc(1);
    }

    public String acj() {
        return hc(3);
    }

    public String my(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream mi = m.mi(str);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
            while (true) {
                int read = mi.read(bArr2);
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
        return acj();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        acE().adC().a(this.bJt);
        return this.bJt.a(str, handler, i, i2, i3, z);
    }
}
