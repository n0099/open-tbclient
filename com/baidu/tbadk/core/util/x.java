package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
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
    private boolean bJr;
    private com.baidu.tbadk.core.util.a.a bJo = null;
    private q bJp = null;
    private x bJq = null;
    private aa.a bJs = null;
    private int bJt = 0;

    private void acG() {
        this.bJo = new com.baidu.tbadk.core.util.a.a();
        this.bJp = z.acR().a(this.bJo);
        this.bJq = null;
        this.bJo.adF().adI().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a acH() {
        return this.bJo;
    }

    public x() {
        acG();
    }

    public x(String str) {
        acG();
        this.bJo.adF().adI().mUrl = str;
    }

    public void setUrl(String str) {
        this.bJo.adF().adI().mUrl = str;
    }

    public void r(ArrayList<BasicNameValuePair> arrayList) {
        this.bJp.r(arrayList);
    }

    public void x(String str, String str2) {
        this.bJp.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.bJp.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.bJp.d(str, bArr);
    }

    private void acI() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> aci = this.bJp.aci();
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
        if (this.bJs == null) {
            this.bJs = aa.acS();
        }
        if (this.bJs != null) {
            this.bJp.x("stTime", String.valueOf(this.bJs.mTime));
            this.bJp.x("stSize", String.valueOf(this.bJs.aSN));
            this.bJp.x("stTimesNum", String.valueOf(this.bJs.bJJ));
            this.bJp.x("stMode", String.valueOf(this.bJs.mMode));
            this.bJp.x("stMethod", String.valueOf(this.bJs.bJI));
        }
        this.bJt = aa.hg(0);
        if (this.bJt == 0 && this.bJs != null) {
            this.bJt = this.bJs.bJJ;
        }
        this.bJp.x("stErrorNums", String.valueOf(this.bJt));
    }

    public boolean acK() {
        return this.bJo.adG().acK();
    }

    public int acL() {
        return this.bJo.adG().bLR;
    }

    public int acM() {
        return this.bJo.adG().Dd;
    }

    public String acN() {
        return this.bJo.adG().bLS;
    }

    public String getErrorString() {
        return this.bJo.adG().mErrorString;
    }

    public void ji() {
        if (this.bJp != null) {
            this.bJp.ji();
        }
        if (this.bJq != null) {
            this.bJq.ji();
        }
    }

    public void jl() {
        if (this.bJp != null) {
            this.bJp.jl();
        }
        if (this.bJq != null) {
            this.bJq.jl();
        }
    }

    public void dB(boolean z) {
        this.bJr = z;
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
            if (this.bJq == null) {
                this.bJq = new x(sb.toString());
            } else {
                this.bJq.ji();
            }
            this.bJq.acH().adF().mIsNeedAddCommenParam = false;
            this.bJq.acH().adF().mIsUseCurrentBDUSS = false;
            this.bJq.acH().adF().bLP = false;
            this.bJq.x("un", str);
            this.bJq.x("passwd", str2);
            this.bJq.x("isphone", "0");
            this.bJq.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.bJq.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.bJq.acH().adF().adI().bMp = true;
            acj = this.bJq.acj();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.bJq.acH().adG().isRequestSuccess() && acj != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(acj);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.bJo.adG().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
        if (this.bJq.acK()) {
            switch (this.bJq.acL()) {
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
        if (!this.bJo.adF().mIsFromCDN) {
            this.bJo.adF().b(this.bJp);
        }
        return this.bJp.ack();
    }

    private void acO() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> aci = this.bJp.aci();
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
        this.bJp.x(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.bJo.adF().bJr) {
            this.bJp.x("sig", StringU.qk(stringBuffer.toString()));
        }
    }

    private String hd(int i) {
        String acm;
        this.bJo.adF().bJr = this.bJr && com.baidu.tbadk.s.t.jK();
        switch (i) {
            case 1:
                if (acH().adF().mIsNeedAddCommenParam) {
                    this.bJo.adF().b(this.bJp);
                }
                acJ();
                acm = this.bJp.acl();
                break;
            case 2:
                if (acH().adF().mIsUseCurrentBDUSS) {
                    acH().adF().a(this.bJp);
                }
                if (acH().adF().mIsNeedAddCommenParam) {
                    this.bJo.adF().b(this.bJp);
                }
                acJ();
                acm = this.bJp.acj();
                break;
            case 3:
                if (acH().adF().mIsUseCurrentBDUSS) {
                    acH().adF().a(this.bJp);
                }
                if (acH().adF().mIsNeedAddCommenParam) {
                    this.bJo.adF().b(this.bJp);
                }
                acO();
                acm = this.bJp.acm();
                break;
            default:
                return null;
        }
        if (!this.bJo.adG().acK()) {
            aa.a(this.bJs);
            aa.hh(this.bJt);
            return acm;
        } else if (!this.bJo.adG().isRequestSuccess()) {
            if (this.bJo.adG().bLR == 1 && this.bJo.adF().bLP) {
                String str = this.bJo.adG().mErrorString;
                this.bJo.adG().mErrorString = "";
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
                    if (this.bJq != null) {
                        this.bJo.adG().mErrorString = this.bJq.getErrorString();
                        return null;
                    }
                    this.bJo.adG().mErrorString = str;
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
                acm = this.bJp.acl();
                break;
            case 2:
                acm = this.bJp.acj();
                break;
            case 3:
                acm = this.bJp.acm();
                break;
            default:
                return null;
        }
        if (this.bJo.adG().acK()) {
            switch (this.bJo.adG().bLR) {
                case 1:
                case 2:
                case 5:
                    acP();
                    this.bJo.adG().mErrorString = "";
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
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
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
        acH().adF().a(this.bJp);
        return this.bJp.a(str, handler, i, i2, i3, z);
    }
}
