package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.StringU;
import com.baidu.tieba.e;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private boolean axt;
    private com.baidu.tbadk.core.util.a.a axq = null;
    private q axr = null;
    private x axs = null;
    private aa.a axu = null;
    private int axv = 0;

    private void Ce() {
        this.axq = new com.baidu.tbadk.core.util.a.a();
        this.axr = z.Cp().a(this.axq);
        this.axs = null;
        this.axq.Dd().Dg().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a Cf() {
        return this.axq;
    }

    public x() {
        Ce();
    }

    public x(String str) {
        Ce();
        this.axq.Dd().Dg().mUrl = str;
    }

    public void setUrl(String str) {
        this.axq.Dd().Dg().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.axr.p(arrayList);
    }

    public void x(String str, String str2) {
        this.axr.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.axr.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.axr.d(str, bArr);
    }

    private void Cg() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> BG = this.axr.BG();
            int size = BG.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = BG.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    BG.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    BG.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void Ch() {
        if (this.axu == null) {
            this.axu = aa.Cq();
        }
        if (this.axu != null) {
            this.axr.x("stTime", String.valueOf(this.axu.mTime));
            this.axr.x("stSize", String.valueOf(this.axu.mSize));
            this.axr.x("stTimesNum", String.valueOf(this.axu.axL));
            this.axr.x("stMode", String.valueOf(this.axu.mMode));
            this.axr.x("stMethod", String.valueOf(this.axu.axK));
        }
        this.axv = aa.dq(0);
        if (this.axv == 0 && this.axu != null) {
            this.axv = this.axu.axL;
        }
        this.axr.x("stErrorNums", String.valueOf(this.axv));
    }

    public boolean Ci() {
        return this.axq.De().Ci();
    }

    public int Cj() {
        return this.axq.De().azT;
    }

    public int Ck() {
        return this.axq.De().De;
    }

    public String Cl() {
        return this.axq.De().azU;
    }

    public String getErrorString() {
        return this.axq.De().mErrorString;
    }

    public void jg() {
        if (this.axr != null) {
            this.axr.jg();
        }
        if (this.axs != null) {
            this.axs.jg();
        }
    }

    public void jj() {
        if (this.axr != null) {
            this.axr.jj();
        }
        if (this.axs != null) {
            this.axs.jj();
        }
    }

    public void br(boolean z) {
        this.axt = z;
    }

    private com.baidu.tbadk.core.data.ae f(String str, String str2, boolean z) {
        String BH;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.axs == null) {
                this.axs = new x(sb.toString());
            } else {
                this.axs.jg();
            }
            this.axs.Cf().Dd().mIsNeedAddCommenParam = false;
            this.axs.Cf().Dd().mIsUseCurrentBDUSS = false;
            this.axs.Cf().Dd().azQ = false;
            this.axs.x("un", str);
            this.axs.x("passwd", str2);
            this.axs.x("isphone", "0");
            this.axs.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.axs.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.axs.Cf().Dd().Dg().aAr = true;
            BH = this.axs.BH();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.axs.Cf().De().isRequestSuccess() && BH != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(BH);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.axq.De().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(e.j.neterror);
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
            if (aeVar.xA() != null) {
                accountData.setTbs(aeVar.xA().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.axs.Ci()) {
            switch (this.axs.Cj()) {
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

    public byte[] BI() {
        if (!this.axq.Dd().mIsFromCDN) {
            this.axq.Dd().b(this.axr);
        }
        return this.axr.BI();
    }

    private void Cm() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> BG = this.axr.BG();
        for (int i = 0; BG != null && i < BG.size(); i++) {
            BasicNameValuePair basicNameValuePair = BG.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + ETAG.EQUAL);
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.axr.x("sign", com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.axq.Dd().axt) {
            this.axr.x("sig", StringU.iQ(stringBuffer.toString()));
        }
    }

    private String dn(int i) {
        String BK;
        this.axq.Dd().axt = this.axt && com.baidu.tbadk.p.s.jJ();
        switch (i) {
            case 1:
                if (Cf().Dd().mIsNeedAddCommenParam) {
                    this.axq.Dd().b(this.axr);
                }
                Ch();
                BK = this.axr.BJ();
                break;
            case 2:
                if (Cf().Dd().mIsUseCurrentBDUSS) {
                    Cf().Dd().a(this.axr);
                }
                if (Cf().Dd().mIsNeedAddCommenParam) {
                    this.axq.Dd().b(this.axr);
                }
                Ch();
                BK = this.axr.BH();
                break;
            case 3:
                if (Cf().Dd().mIsUseCurrentBDUSS) {
                    Cf().Dd().a(this.axr);
                }
                if (Cf().Dd().mIsNeedAddCommenParam) {
                    this.axq.Dd().b(this.axr);
                }
                Cm();
                BK = this.axr.BK();
                break;
            default:
                return null;
        }
        if (!this.axq.De().Ci()) {
            aa.a(this.axu);
            aa.dr(this.axv);
            return BK;
        } else if (!this.axq.De().isRequestSuccess()) {
            if (this.axq.De().azT == 1 && this.axq.Dd().azQ) {
                String str = this.axq.De().mErrorString;
                this.axq.De().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.wJ();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    Cn();
                    return null;
                }
                com.baidu.tbadk.core.a.b.dL(currentAccountObj.getID());
                if (ReloginManager.Bp().Bs()) {
                    f(currentAccountObj);
                    ReloginManager.Bp().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae f = f(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (f == null) {
                    if (this.axs != null) {
                        this.axq.De().mErrorString = this.axs.getErrorString();
                        return null;
                    }
                    this.axq.De().mErrorString = str;
                    return BK;
                }
                BK = m16do(i);
            }
            com.baidu.tieba.i.a.a(this);
            return BK;
        } else {
            return BK;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c EV;
        if (!TextUtils.isEmpty(accountData.getID()) && (EV = com.baidu.tbadk.coreExtra.a.a.EV()) != null) {
            EV.f(accountData);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private String m16do(int i) {
        String BK;
        Cg();
        switch (i) {
            case 1:
                BK = this.axr.BJ();
                break;
            case 2:
                BK = this.axr.BH();
                break;
            case 3:
                BK = this.axr.BK();
                break;
            default:
                return null;
        }
        if (this.axq.De().Ci()) {
            switch (this.axq.De().azT) {
                case 1:
                case 2:
                case 5:
                    Cn();
                    this.axq.De().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return BK;
            }
        }
        return BK;
    }

    private void Cn() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String BH() {
        return dn(2);
    }

    public String BJ() {
        return dn(1);
    }

    public String BK() {
        return dn(3);
    }

    public String fh(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream eS = l.eS(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = eS.read(bArr2);
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
        return BK();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cf().Dd().a(this.axr);
        return this.axr.a(str, handler, i, i2, i3, z);
    }
}
