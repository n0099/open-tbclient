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
    private boolean bJs;
    private com.baidu.tbadk.core.util.a.a bJp = null;
    private q bJq = null;
    private x bJr = null;
    private aa.a bJt = null;
    private int bJu = 0;

    private void acG() {
        this.bJp = new com.baidu.tbadk.core.util.a.a();
        this.bJq = z.acR().a(this.bJp);
        this.bJr = null;
        this.bJp.adF().adI().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a acH() {
        return this.bJp;
    }

    public x() {
        acG();
    }

    public x(String str) {
        acG();
        this.bJp.adF().adI().mUrl = str;
    }

    public void setUrl(String str) {
        this.bJp.adF().adI().mUrl = str;
    }

    public void r(ArrayList<BasicNameValuePair> arrayList) {
        this.bJq.r(arrayList);
    }

    public void x(String str, String str2) {
        this.bJq.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bJq.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bJq.d(str, bArr);
    }

    private void acI() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> aci = this.bJq.aci();
            int size = aci.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = aci.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    aci.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    aci.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void acJ() {
        if (this.bJt == null) {
            this.bJt = aa.acS();
        }
        if (this.bJt != null) {
            this.bJq.x("stTime", String.valueOf(this.bJt.mTime));
            this.bJq.x("stSize", String.valueOf(this.bJt.aSO));
            this.bJq.x("stTimesNum", String.valueOf(this.bJt.bJK));
            this.bJq.x("stMode", String.valueOf(this.bJt.mMode));
            this.bJq.x("stMethod", String.valueOf(this.bJt.bJJ));
        }
        this.bJu = aa.hg(0);
        if (this.bJu == 0 && this.bJt != null) {
            this.bJu = this.bJt.bJK;
        }
        this.bJq.x("stErrorNums", String.valueOf(this.bJu));
    }

    public boolean acK() {
        return this.bJp.adG().acK();
    }

    public int acL() {
        return this.bJp.adG().bLS;
    }

    public int acM() {
        return this.bJp.adG().Dd;
    }

    public String acN() {
        return this.bJp.adG().bLT;
    }

    public String getErrorString() {
        return this.bJp.adG().mErrorString;
    }

    public void ji() {
        if (this.bJq != null) {
            this.bJq.ji();
        }
        if (this.bJr != null) {
            this.bJr.ji();
        }
    }

    public void jl() {
        if (this.bJq != null) {
            this.bJq.jl();
        }
        if (this.bJr != null) {
            this.bJr.jl();
        }
    }

    public void dB(boolean z) {
        this.bJs = z;
    }

    private com.baidu.tbadk.core.data.ag q(String str, String str2, boolean z) {
        String acj;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.bJr == null) {
                this.bJr = new x(sb.toString());
            } else {
                this.bJr.ji();
            }
            this.bJr.acH().adF().mIsNeedAddCommenParam = false;
            this.bJr.acH().adF().mIsUseCurrentBDUSS = false;
            this.bJr.acH().adF().bLQ = false;
            this.bJr.x("un", str);
            this.bJr.x("passwd", str2);
            this.bJr.x("isphone", "0");
            this.bJr.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bJr.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bJr.acH().adF().adI().bMq = true;
            acj = this.bJr.acj();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bJr.acH().adG().isRequestSuccess() && acj != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(acj);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bJp.adG().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
        if (this.bJr.acK()) {
            switch (this.bJr.acL()) {
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

    public byte[] ack() {
        if (!this.bJp.adF().mIsFromCDN) {
            this.bJp.adF().b(this.bJq);
        }
        return this.bJq.ack();
    }

    private void acO() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> aci = this.bJq.aci();
        for (int i = 0; aci != null && i < aci.size(); i++) {
            BasicNameValuePair basicNameValuePair = aci.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.bJq.x("sign", com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.bJp.adF().bJs) {
            this.bJq.x("sig", StringU.qj(stringBuffer.toString()));
        }
    }

    private String hd(int i) {
        String acm;
        this.bJp.adF().bJs = this.bJs && com.baidu.tbadk.s.t.jK();
        switch (i) {
            case 1:
                if (acH().adF().mIsNeedAddCommenParam) {
                    this.bJp.adF().b(this.bJq);
                }
                acJ();
                acm = this.bJq.acl();
                break;
            case 2:
                if (acH().adF().mIsUseCurrentBDUSS) {
                    acH().adF().a(this.bJq);
                }
                if (acH().adF().mIsNeedAddCommenParam) {
                    this.bJp.adF().b(this.bJq);
                }
                acJ();
                acm = this.bJq.acj();
                break;
            case 3:
                if (acH().adF().mIsUseCurrentBDUSS) {
                    acH().adF().a(this.bJq);
                }
                if (acH().adF().mIsNeedAddCommenParam) {
                    this.bJp.adF().b(this.bJq);
                }
                acO();
                acm = this.bJq.acm();
                break;
            default:
                return null;
        }
        if (!this.bJp.adG().acK()) {
            aa.a(this.bJt);
            aa.hh(this.bJu);
            return acm;
        } else if (!this.bJp.adG().isRequestSuccess()) {
            if (this.bJp.adG().bLS == 1 && this.bJp.adF().bLQ) {
                String str = this.bJp.adG().mErrorString;
                this.bJp.adG().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.WH();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    acP();
                    return null;
                }
                com.baidu.tbadk.core.a.b.kW(currentAccountObj.getID());
                if (ReloginManager.abQ().abT()) {
                    f(currentAccountObj);
                    ReloginManager.abQ().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag q = q(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (q == null) {
                    if (this.bJr != null) {
                        this.bJp.adG().mErrorString = this.bJr.getErrorString();
                        return null;
                    }
                    this.bJp.adG().mErrorString = str;
                    return acm;
                }
                acm = he(i);
            }
            com.baidu.tieba.i.a.a(this);
            return acm;
        } else {
            return acm;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c afH;
        if (!TextUtils.isEmpty(accountData.getID()) && (afH = com.baidu.tbadk.coreExtra.a.a.afH()) != null) {
            afH.f(accountData);
        }
    }

    private String he(int i) {
        String acm;
        acI();
        switch (i) {
            case 1:
                acm = this.bJq.acl();
                break;
            case 2:
                acm = this.bJq.acj();
                break;
            case 3:
                acm = this.bJq.acm();
                break;
            default:
                return null;
        }
        if (this.bJp.adG().acK()) {
            switch (this.bJp.adG().bLS) {
                case 1:
                case 2:
                case 5:
                    acP();
                    this.bJp.adG().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return acm;
            }
        }
        return acm;
    }

    private void acP() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String acj() {
        return hd(2);
    }

    public String acl() {
        return hd(1);
    }

    public String acm() {
        return hd(3);
    }

    public String mx(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream mh = m.mh(str);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
            while (true) {
                int read = mh.read(bArr2);
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
        return acm();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        acH().adF().a(this.bJq);
        return this.bJq.a(str, handler, i, i2, i3, z);
    }
}
