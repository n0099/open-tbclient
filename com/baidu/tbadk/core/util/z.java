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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class z {
    private com.baidu.tbadk.core.util.a.a afg = null;
    private s afh = null;
    private z afi = null;
    private ad.a afj = null;
    private int afk = 0;

    private void vv() {
        this.afg = new com.baidu.tbadk.core.util.a.a();
        this.afh = ac.vF().a(this.afg);
        this.afi = null;
        this.afg.wp().ws().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ab(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vw() {
        return this.afg;
    }

    public z() {
        vv();
    }

    public z(String str) {
        vv();
        this.afg.wp().ws().mUrl = str;
    }

    public void setUrl(String str) {
        this.afg.wp().ws().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.afh.k(arrayList);
    }

    public void n(String str, String str2) {
        this.afh.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.afh.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.afh.d(str, bArr);
    }

    private void vx() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uX = this.afh.uX();
            int size = uX.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uX.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uX.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uX.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vy() {
        if (this.afj == null) {
            this.afj = ad.vG();
        }
        if (this.afj != null) {
            this.afh.n("stTime", String.valueOf(this.afj.mTime));
            this.afh.n("stSize", String.valueOf(this.afj.afB));
            this.afh.n("stTimesNum", String.valueOf(this.afj.afC));
            this.afh.n("stMode", String.valueOf(this.afj.mMode));
            this.afh.n("stMethod", String.valueOf(this.afj.afA));
        }
        this.afk = ad.cF(0);
        if (this.afk == 0 && this.afj != null) {
            this.afk = this.afj.afC;
        }
        this.afh.n("stErrorNums", String.valueOf(this.afk));
    }

    public boolean vz() {
        return this.afg.wq().vz();
    }

    public int vA() {
        return this.afg.wq().ahl;
    }

    public int vB() {
        return this.afg.wq().vQ;
    }

    public String vC() {
        return this.afg.wq().ahm;
    }

    public String getErrorString() {
        return this.afg.wq().mErrorString;
    }

    public void fs() {
        if (this.afh != null) {
            this.afh.fs();
        }
        if (this.afi != null) {
            this.afi.fs();
        }
    }

    public void fv() {
        if (this.afh != null) {
            this.afh.fv();
        }
        if (this.afi != null) {
            this.afi.fv();
        }
    }

    private com.baidu.tbadk.core.data.ai e(String str, String str2, boolean z) {
        String uY;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.afi == null) {
                this.afi = new z(sb.toString());
            } else {
                this.afi.fs();
            }
            this.afi.vw().wp().mIsNeedAddCommenParam = false;
            this.afi.vw().wp().mIsUseCurrentBDUSS = false;
            this.afi.vw().wp().ahi = false;
            this.afi.n("un", str);
            this.afi.n("passwd", str2);
            this.afi.n("isphone", "0");
            this.afi.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.afi.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.afi.vw().wp().ws().ahJ = true;
            uY = this.afi.uY();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.afi.vw().wq().isRequestSuccess() && uY != null) {
            com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
            aiVar.parserJson(uY);
            String userId = aiVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.afg.wq().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aiVar.getUser().getUserName());
            if (aiVar.getUser().getPassword() != null) {
                accountData.setPassword(aiVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aiVar.getUser().getUserId());
            accountData.setBDUSS(aiVar.getUser().getBDUSS());
            accountData.setPortrait(aiVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aiVar.rb() != null) {
                accountData.setTbs(aiVar.rb().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return aiVar;
        }
        if (this.afi.vz()) {
            switch (this.afi.vA()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m9getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m9getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] uZ() {
        if (!this.afg.wp().mIsFromCDN) {
            this.afg.wp().b(this.afh);
        }
        return this.afh.uZ();
    }

    private void vD() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uX = this.afh.uX();
        for (int i = 0; uX != null && i < uX.size(); i++) {
            BasicNameValuePair basicNameValuePair = uX.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.afh.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aI(stringBuffer.toString()));
    }

    private String cC(int i) {
        String vb;
        com.baidu.tbadk.coreExtra.a.c xU;
        switch (i) {
            case 1:
                if (vw().wp().mIsNeedAddCommenParam) {
                    this.afg.wp().b(this.afh);
                }
                vy();
                vb = this.afh.va();
                break;
            case 2:
                if (vw().wp().mIsUseCurrentBDUSS) {
                    vw().wp().a(this.afh);
                }
                if (vw().wp().mIsNeedAddCommenParam) {
                    this.afg.wp().b(this.afh);
                }
                vy();
                vb = this.afh.uY();
                break;
            case 3:
                if (vw().wp().mIsUseCurrentBDUSS) {
                    vw().wp().a(this.afh);
                }
                if (vw().wp().mIsNeedAddCommenParam) {
                    this.afg.wp().b(this.afh);
                }
                vD();
                vb = this.afh.vb();
                break;
            default:
                return null;
        }
        if (!this.afg.wq().vz()) {
            ad.a(this.afj);
            ad.cG(this.afk);
            return vb;
        } else if (!this.afg.wq().isRequestSuccess() && this.afg.wq().ahl == 1 && this.afg.wp().ahi) {
            String str = this.afg.wq().mErrorString;
            this.afg.wq().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.pA();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cg(currentAccountObj.getAccount());
            if (ReloginManager.uG().uK()) {
                AccountData uJ = ReloginManager.uG().uJ();
                if (uJ == null) {
                    ReloginManager.uG().f(uJ);
                    return null;
                }
                return cD(i);
            }
            com.baidu.tbadk.core.data.ai e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xU = com.baidu.tbadk.coreExtra.a.a.xU()) != null) {
                xU.h(currentAccountObj);
            }
            if (e == null) {
                if (this.afi != null) {
                    this.afg.wq().mErrorString = this.afi.getErrorString();
                    return null;
                }
                this.afg.wq().mErrorString = str;
                return vb;
            }
            return cD(i);
        } else {
            return vb;
        }
    }

    private String cD(int i) {
        String vb;
        vx();
        switch (i) {
            case 1:
                vb = this.afh.va();
                break;
            case 2:
                vb = this.afh.uY();
                break;
            case 3:
                vb = this.afh.vb();
                break;
            default:
                return null;
        }
        if (this.afg.wq().vz()) {
            switch (this.afg.wq().ahl) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.afg.wq().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return vb;
            }
        }
        return vb;
    }

    public String uY() {
        return cC(2);
    }

    public String va() {
        return cC(1);
    }

    public String vb() {
        return cC(3);
    }

    public String dr(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dd = l.dd(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dd.read(bArr2);
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
        return vb();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vw().wp().a(this.afh);
        return this.afh.a(str, handler, i, i2, i3, z);
    }
}
