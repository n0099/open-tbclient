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
    private boolean bJu;
    private com.baidu.tbadk.core.util.a.a bJr = null;
    private q bJs = null;
    private x bJt = null;
    private aa.a bJv = null;
    private int bJw = 0;

    private void acD() {
        this.bJr = new com.baidu.tbadk.core.util.a.a();
        this.bJs = z.acO().a(this.bJr);
        this.bJt = null;
        this.bJr.adC().adF().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a acE() {
        return this.bJr;
    }

    public x() {
        acD();
    }

    public x(String str) {
        acD();
        this.bJr.adC().adF().mUrl = str;
    }

    public void setUrl(String str) {
        this.bJr.adC().adF().mUrl = str;
    }

    public void r(ArrayList<BasicNameValuePair> arrayList) {
        this.bJs.r(arrayList);
    }

    public void x(String str, String str2) {
        this.bJs.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bJs.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bJs.d(str, bArr);
    }

    private void acF() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> acf = this.bJs.acf();
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
        if (this.bJv == null) {
            this.bJv = aa.acP();
        }
        if (this.bJv != null) {
            this.bJs.x("stTime", String.valueOf(this.bJv.mTime));
            this.bJs.x("stSize", String.valueOf(this.bJv.aSR));
            this.bJs.x("stTimesNum", String.valueOf(this.bJv.bJM));
            this.bJs.x("stMode", String.valueOf(this.bJv.mMode));
            this.bJs.x("stMethod", String.valueOf(this.bJv.bJL));
        }
        this.bJw = aa.hf(0);
        if (this.bJw == 0 && this.bJv != null) {
            this.bJw = this.bJv.bJM;
        }
        this.bJs.x("stErrorNums", String.valueOf(this.bJw));
    }

    public boolean acH() {
        return this.bJr.adD().acH();
    }

    public int acI() {
        return this.bJr.adD().bLU;
    }

    public int acJ() {
        return this.bJr.adD().Dd;
    }

    public String acK() {
        return this.bJr.adD().bLV;
    }

    public String getErrorString() {
        return this.bJr.adD().mErrorString;
    }

    public void ji() {
        if (this.bJs != null) {
            this.bJs.ji();
        }
        if (this.bJt != null) {
            this.bJt.ji();
        }
    }

    public void jl() {
        if (this.bJs != null) {
            this.bJs.jl();
        }
        if (this.bJt != null) {
            this.bJt.jl();
        }
    }

    public void dB(boolean z) {
        this.bJu = z;
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
            if (this.bJt == null) {
                this.bJt = new x(sb.toString());
            } else {
                this.bJt.ji();
            }
            this.bJt.acE().adC().mIsNeedAddCommenParam = false;
            this.bJt.acE().adC().mIsUseCurrentBDUSS = false;
            this.bJt.acE().adC().bLS = false;
            this.bJt.x("un", str);
            this.bJt.x("passwd", str2);
            this.bJt.x("isphone", "0");
            this.bJt.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bJt.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bJt.acE().adC().adF().bMs = true;
            acg = this.bJt.acg();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bJt.acE().adD().isRequestSuccess() && acg != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(acg);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bJr.adD().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
        if (this.bJt.acH()) {
            switch (this.bJt.acI()) {
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
        if (!this.bJr.adC().mIsFromCDN) {
            this.bJr.adC().b(this.bJs);
        }
        return this.bJs.ach();
    }

    private void acL() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> acf = this.bJs.acf();
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
        this.bJs.x("sign", com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.bJr.adC().bJu) {
            this.bJs.x("sig", StringU.qk(stringBuffer.toString()));
        }
    }

    private String hc(int i) {
        String acj;
        this.bJr.adC().bJu = this.bJu && com.baidu.tbadk.s.t.jK();
        switch (i) {
            case 1:
                if (acE().adC().mIsNeedAddCommenParam) {
                    this.bJr.adC().b(this.bJs);
                }
                acG();
                acj = this.bJs.aci();
                break;
            case 2:
                if (acE().adC().mIsUseCurrentBDUSS) {
                    acE().adC().a(this.bJs);
                }
                if (acE().adC().mIsNeedAddCommenParam) {
                    this.bJr.adC().b(this.bJs);
                }
                acG();
                acj = this.bJs.acg();
                break;
            case 3:
                if (acE().adC().mIsUseCurrentBDUSS) {
                    acE().adC().a(this.bJs);
                }
                if (acE().adC().mIsNeedAddCommenParam) {
                    this.bJr.adC().b(this.bJs);
                }
                acL();
                acj = this.bJs.acj();
                break;
            default:
                return null;
        }
        if (!this.bJr.adD().acH()) {
            aa.a(this.bJv);
            aa.hg(this.bJw);
            return acj;
        } else if (!this.bJr.adD().isRequestSuccess()) {
            if (this.bJr.adD().bLU == 1 && this.bJr.adC().bLS) {
                String str = this.bJr.adD().mErrorString;
                this.bJr.adD().mErrorString = "";
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
                    if (this.bJt != null) {
                        this.bJr.adD().mErrorString = this.bJt.getErrorString();
                        return null;
                    }
                    this.bJr.adD().mErrorString = str;
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
                acj = this.bJs.aci();
                break;
            case 2:
                acj = this.bJs.acg();
                break;
            case 3:
                acj = this.bJs.acj();
                break;
            default:
                return null;
        }
        if (this.bJr.adD().acH()) {
            switch (this.bJr.adD().bLU) {
                case 1:
                case 2:
                case 5:
                    acM();
                    this.bJr.adD().mErrorString = "";
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
        acE().adC().a(this.bJs);
        return this.bJs.a(str, handler, i, i2, i3, z);
    }
}
