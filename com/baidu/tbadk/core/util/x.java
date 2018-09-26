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
import com.baidu.tieba.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private boolean arT;
    private com.baidu.tbadk.core.util.a.a arQ = null;
    private q arR = null;
    private x arS = null;
    private aa.a arU = null;
    private int arV = 0;

    private void zQ() {
        this.arQ = new com.baidu.tbadk.core.util.a.a();
        this.arR = z.Ab().a(this.arQ);
        this.arS = null;
        this.arQ.AP().AS().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a zR() {
        return this.arQ;
    }

    public x() {
        zQ();
    }

    public x(String str) {
        zQ();
        this.arQ.AP().AS().mUrl = str;
    }

    public void setUrl(String str) {
        this.arQ.AP().AS().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.arR.p(arrayList);
    }

    public void u(String str, String str2) {
        this.arR.u(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.arR.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.arR.d(str, bArr);
    }

    private void zS() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> zs = this.arR.zs();
            int size = zs.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = zs.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    zs.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    zs.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void zT() {
        if (this.arU == null) {
            this.arU = aa.Ac();
        }
        if (this.arU != null) {
            this.arR.u("stTime", String.valueOf(this.arU.mTime));
            this.arR.u("stSize", String.valueOf(this.arU.asm));
            this.arR.u("stTimesNum", String.valueOf(this.arU.asn));
            this.arR.u("stMode", String.valueOf(this.arU.mMode));
            this.arR.u("stMethod", String.valueOf(this.arU.asl));
        }
        this.arV = aa.cS(0);
        if (this.arV == 0 && this.arU != null) {
            this.arV = this.arU.asn;
        }
        this.arR.u("stErrorNums", String.valueOf(this.arV));
    }

    public boolean zU() {
        return this.arQ.AQ().zU();
    }

    public int zV() {
        return this.arQ.AQ().aut;
    }

    public int zW() {
        return this.arQ.AQ().Cq;
    }

    public String zX() {
        return this.arQ.AQ().auu;
    }

    public String getErrorString() {
        return this.arQ.AQ().mErrorString;
    }

    public void iT() {
        if (this.arR != null) {
            this.arR.iT();
        }
        if (this.arS != null) {
            this.arS.iT();
        }
    }

    public void iW() {
        if (this.arR != null) {
            this.arR.iW();
        }
        if (this.arS != null) {
            this.arS.iW();
        }
    }

    public void aR(boolean z) {
        this.arT = z;
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String zt;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.arS == null) {
                this.arS = new x(sb.toString());
            } else {
                this.arS.iT();
            }
            this.arS.zR().AP().mIsNeedAddCommenParam = false;
            this.arS.zR().AP().mIsUseCurrentBDUSS = false;
            this.arS.zR().AP().auq = false;
            this.arS.u("un", str);
            this.arS.u("passwd", str2);
            this.arS.u("isphone", "0");
            this.arS.u("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.arS.u("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.arS.zR().AP().AS().auR = true;
            zt = this.arS.zt();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.arS.zR().AQ().isRequestSuccess() && zt != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(zt);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.arQ.AQ().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(e.j.neterror);
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
            if (aeVar.vj() != null) {
                accountData.setTbs(aeVar.vj().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.arS.zU()) {
            switch (this.arS.zV()) {
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

    public byte[] zu() {
        if (!this.arQ.AP().mIsFromCDN) {
            this.arQ.AP().b(this.arR);
        }
        return this.arR.zu();
    }

    private void zY() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> zs = this.arR.zs();
        for (int i = 0; zs != null && i < zs.size(); i++) {
            BasicNameValuePair basicNameValuePair = zs.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.arR.u("sign", com.baidu.adp.lib.util.s.bD(stringBuffer.toString()));
        if (this.arQ.AP().arT) {
            this.arR.u("sig", StringU.iB(stringBuffer.toString()));
        }
    }

    private String cP(int i) {
        String zw;
        this.arQ.AP().arT = this.arT && com.baidu.tbadk.p.s.jw();
        switch (i) {
            case 1:
                if (zR().AP().mIsNeedAddCommenParam) {
                    this.arQ.AP().b(this.arR);
                }
                zT();
                zw = this.arR.zv();
                break;
            case 2:
                if (zR().AP().mIsUseCurrentBDUSS) {
                    zR().AP().a(this.arR);
                }
                if (zR().AP().mIsNeedAddCommenParam) {
                    this.arQ.AP().b(this.arR);
                }
                zT();
                zw = this.arR.zt();
                break;
            case 3:
                if (zR().AP().mIsUseCurrentBDUSS) {
                    zR().AP().a(this.arR);
                }
                if (zR().AP().mIsNeedAddCommenParam) {
                    this.arQ.AP().b(this.arR);
                }
                zY();
                zw = this.arR.zw();
                break;
            default:
                return null;
        }
        if (!this.arQ.AQ().zU()) {
            aa.a(this.arU);
            aa.cT(this.arV);
            return zw;
        } else if (!this.arQ.AQ().isRequestSuccess()) {
            if (this.arQ.AQ().aut == 1 && this.arQ.AP().auq) {
                String str = this.arQ.AQ().mErrorString;
                this.arQ.AQ().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.us();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    zZ();
                    return null;
                }
                com.baidu.tbadk.core.a.b.dv(currentAccountObj.getID());
                if (ReloginManager.za().zd()) {
                    f(currentAccountObj);
                    ReloginManager.za().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (e == null) {
                    if (this.arS != null) {
                        this.arQ.AQ().mErrorString = this.arS.getErrorString();
                        return null;
                    }
                    this.arQ.AQ().mErrorString = str;
                    return zw;
                }
                zw = cQ(i);
            }
            com.baidu.tieba.i.a.a(this);
            return zw;
        } else {
            return zw;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c CG;
        if (!TextUtils.isEmpty(accountData.getID()) && (CG = com.baidu.tbadk.coreExtra.a.a.CG()) != null) {
            CG.f(accountData);
        }
    }

    private String cQ(int i) {
        String zw;
        zS();
        switch (i) {
            case 1:
                zw = this.arR.zv();
                break;
            case 2:
                zw = this.arR.zt();
                break;
            case 3:
                zw = this.arR.zw();
                break;
            default:
                return null;
        }
        if (this.arQ.AQ().zU()) {
            switch (this.arQ.AQ().aut) {
                case 1:
                case 2:
                case 5:
                    zZ();
                    this.arQ.AQ().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return zw;
            }
        }
        return zw;
    }

    private void zZ() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String zt() {
        return cP(2);
    }

    public String zv() {
        return cP(1);
    }

    public String zw() {
        return cP(3);
    }

    public String eT(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream eC = l.eC(str);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
            while (true) {
                int read = eC.read(bArr2);
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
        return zw();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        zR().AP().a(this.arR);
        return this.arR.a(str, handler, i, i2, i3, z);
    }
}
