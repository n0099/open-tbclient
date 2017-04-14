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
    private com.baidu.tbadk.core.util.a.a aff = null;
    private s afg = null;
    private z afh = null;
    private ad.a afi = null;
    private int afj = 0;

    private void vv() {
        this.aff = new com.baidu.tbadk.core.util.a.a();
        this.afg = ac.vF().a(this.aff);
        this.afh = null;
        this.aff.wp().ws().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ab(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vw() {
        return this.aff;
    }

    public z() {
        vv();
    }

    public z(String str) {
        vv();
        this.aff.wp().ws().mUrl = str;
    }

    public void setUrl(String str) {
        this.aff.wp().ws().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.afg.k(arrayList);
    }

    public void n(String str, String str2) {
        this.afg.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.afg.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.afg.d(str, bArr);
    }

    private void vx() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uX = this.afg.uX();
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
        if (this.afi == null) {
            this.afi = ad.vG();
        }
        if (this.afi != null) {
            this.afg.n("stTime", String.valueOf(this.afi.mTime));
            this.afg.n("stSize", String.valueOf(this.afi.afA));
            this.afg.n("stTimesNum", String.valueOf(this.afi.afB));
            this.afg.n("stMode", String.valueOf(this.afi.mMode));
            this.afg.n("stMethod", String.valueOf(this.afi.afz));
        }
        this.afj = ad.cF(0);
        if (this.afj == 0 && this.afi != null) {
            this.afj = this.afi.afB;
        }
        this.afg.n("stErrorNums", String.valueOf(this.afj));
    }

    public boolean vz() {
        return this.aff.wq().vz();
    }

    public int vA() {
        return this.aff.wq().ahk;
    }

    public int vB() {
        return this.aff.wq().vM;
    }

    public String vC() {
        return this.aff.wq().ahl;
    }

    public String getErrorString() {
        return this.aff.wq().mErrorString;
    }

    public void fr() {
        if (this.afg != null) {
            this.afg.fr();
        }
        if (this.afh != null) {
            this.afh.fr();
        }
    }

    public void fu() {
        if (this.afg != null) {
            this.afg.fu();
        }
        if (this.afh != null) {
            this.afh.fu();
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
            if (this.afh == null) {
                this.afh = new z(sb.toString());
            } else {
                this.afh.fr();
            }
            this.afh.vw().wp().mIsNeedAddCommenParam = false;
            this.afh.vw().wp().mIsUseCurrentBDUSS = false;
            this.afh.vw().wp().ahh = false;
            this.afh.n("un", str);
            this.afh.n("passwd", str2);
            this.afh.n("isphone", "0");
            this.afh.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.afh.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.afh.vw().wp().ws().ahI = true;
            uY = this.afh.uY();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.afh.vw().wq().isRequestSuccess() && uY != null) {
            com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
            aiVar.parserJson(uY);
            String userId = aiVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aff.wq().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.neterror);
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
        if (this.afh.vz()) {
            switch (this.afh.vA()) {
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
        if (!this.aff.wp().mIsFromCDN) {
            this.aff.wp().b(this.afg);
        }
        return this.afg.uZ();
    }

    private void vD() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uX = this.afg.uX();
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
        this.afg.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aI(stringBuffer.toString()));
    }

    private String cC(int i) {
        String vb;
        com.baidu.tbadk.coreExtra.a.c xU;
        switch (i) {
            case 1:
                if (vw().wp().mIsNeedAddCommenParam) {
                    this.aff.wp().b(this.afg);
                }
                vy();
                vb = this.afg.va();
                break;
            case 2:
                if (vw().wp().mIsUseCurrentBDUSS) {
                    vw().wp().a(this.afg);
                }
                if (vw().wp().mIsNeedAddCommenParam) {
                    this.aff.wp().b(this.afg);
                }
                vy();
                vb = this.afg.uY();
                break;
            case 3:
                if (vw().wp().mIsUseCurrentBDUSS) {
                    vw().wp().a(this.afg);
                }
                if (vw().wp().mIsNeedAddCommenParam) {
                    this.aff.wp().b(this.afg);
                }
                vD();
                vb = this.afg.vb();
                break;
            default:
                return null;
        }
        if (!this.aff.wq().vz()) {
            ad.a(this.afi);
            ad.cG(this.afj);
            return vb;
        } else if (!this.aff.wq().isRequestSuccess() && this.aff.wq().ahk == 1 && this.aff.wp().ahh) {
            String str = this.aff.wq().mErrorString;
            this.aff.wq().mErrorString = "";
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
                if (this.afh != null) {
                    this.aff.wq().mErrorString = this.afh.getErrorString();
                    return null;
                }
                this.aff.wq().mErrorString = str;
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
                vb = this.afg.va();
                break;
            case 2:
                vb = this.afg.uY();
                break;
            case 3:
                vb = this.afg.vb();
                break;
            default:
                return null;
        }
        if (this.aff.wq().vz()) {
            switch (this.aff.wq().ahk) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.aff.wq().mErrorString = "";
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
        vw().wp().a(this.afg);
        return this.afg.a(str, handler, i, i2, i3, z);
    }
}
