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
    private com.baidu.tbadk.core.util.a.a aeR = null;
    private s aeS = null;
    private z aeT = null;
    private ad.a aeU = null;
    private int aeV = 0;

    private void uY() {
        this.aeR = new com.baidu.tbadk.core.util.a.a();
        this.aeS = ac.vi().a(this.aeR);
        this.aeT = null;
        this.aeR.vS().vV().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.af(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uZ() {
        return this.aeR;
    }

    public z() {
        uY();
    }

    public z(String str) {
        uY();
        this.aeR.vS().vV().mUrl = str;
    }

    public void setUrl(String str) {
        this.aeR.vS().vV().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.aeS.k(arrayList);
    }

    public void n(String str, String str2) {
        this.aeS.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aeS.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aeS.d(str, bArr);
    }

    private void va() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uA = this.aeS.uA();
            int size = uA.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uA.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uA.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uA.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vb() {
        if (this.aeU == null) {
            this.aeU = ad.vj();
        }
        if (this.aeU != null) {
            this.aeS.n("stTime", String.valueOf(this.aeU.mTime));
            this.aeS.n("stSize", String.valueOf(this.aeU.afm));
            this.aeS.n("stTimesNum", String.valueOf(this.aeU.afn));
            this.aeS.n("stMode", String.valueOf(this.aeU.mMode));
            this.aeS.n("stMethod", String.valueOf(this.aeU.afl));
        }
        this.aeV = ad.cC(0);
        if (this.aeV == 0 && this.aeU != null) {
            this.aeV = this.aeU.afn;
        }
        this.aeS.n("stErrorNums", String.valueOf(this.aeV));
    }

    public boolean vc() {
        return this.aeR.vT().vc();
    }

    public int vd() {
        return this.aeR.vT().agW;
    }

    public int ve() {
        return this.aeR.vT().wj;
    }

    public String vf() {
        return this.aeR.vT().agX;
    }

    public String getErrorString() {
        return this.aeR.vT().mErrorString;
    }

    public void fm() {
        if (this.aeS != null) {
            this.aeS.fm();
        }
        if (this.aeT != null) {
            this.aeT.fm();
        }
    }

    public void fp() {
        if (this.aeS != null) {
            this.aeS.fp();
        }
        if (this.aeT != null) {
            this.aeT.fp();
        }
    }

    private com.baidu.tbadk.core.data.aj d(String str, String str2, boolean z) {
        String uB;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.aeT == null) {
                this.aeT = new z(sb.toString());
            } else {
                this.aeT.fm();
            }
            this.aeT.uZ().vS().mIsNeedAddCommenParam = false;
            this.aeT.uZ().vS().mIsUseCurrentBDUSS = false;
            this.aeT.uZ().vS().agT = false;
            this.aeT.n("un", str);
            this.aeT.n("passwd", str2);
            this.aeT.n("isphone", "0");
            this.aeT.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aeT.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aeT.uZ().vS().vV().ahu = true;
            uB = this.aeT.uB();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.aeT.uZ().vT().isRequestSuccess() && uB != null) {
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.parserJson(uB);
            String userId = ajVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aeR.vT().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(ajVar.getUser().getUserName());
            if (ajVar.getUser().getPassword() != null) {
                accountData.setPassword(ajVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(ajVar.getUser().getUserId());
            accountData.setBDUSS(ajVar.getUser().getBDUSS());
            accountData.setPortrait(ajVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (ajVar.qE() != null) {
                accountData.setTbs(ajVar.qE().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return ajVar;
        }
        if (this.aeT.vc()) {
            switch (this.aeT.vd()) {
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

    public byte[] uC() {
        if (!this.aeR.vS().mIsFromCDN) {
            this.aeR.vS().b(this.aeS);
        }
        return this.aeS.uC();
    }

    private void vg() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uA = this.aeS.uA();
        for (int i = 0; uA != null && i < uA.size(); i++) {
            BasicNameValuePair basicNameValuePair = uA.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aeS.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aN(stringBuffer.toString()));
    }

    private String cz(int i) {
        String uE;
        com.baidu.tbadk.coreExtra.a.c xy;
        switch (i) {
            case 1:
                if (uZ().vS().mIsNeedAddCommenParam) {
                    this.aeR.vS().b(this.aeS);
                }
                vb();
                uE = this.aeS.uD();
                break;
            case 2:
                if (uZ().vS().mIsUseCurrentBDUSS) {
                    uZ().vS().a(this.aeS);
                }
                if (uZ().vS().mIsNeedAddCommenParam) {
                    this.aeR.vS().b(this.aeS);
                }
                vb();
                uE = this.aeS.uB();
                break;
            case 3:
                if (uZ().vS().mIsUseCurrentBDUSS) {
                    uZ().vS().a(this.aeS);
                }
                if (uZ().vS().mIsNeedAddCommenParam) {
                    this.aeR.vS().b(this.aeS);
                }
                vg();
                uE = this.aeS.uE();
                break;
            default:
                return null;
        }
        if (!this.aeR.vT().vc()) {
            ad.a(this.aeU);
            ad.cD(this.aeV);
            return uE;
        } else if (!this.aeR.vT().isRequestSuccess() && this.aeR.vT().agW == 1 && this.aeR.vS().agT) {
            String str = this.aeR.vT().mErrorString;
            this.aeR.vT().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.pc();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.bZ(currentAccountObj.getAccount());
            if (ReloginManager.uj().un()) {
                AccountData um = ReloginManager.uj().um();
                if (um == null) {
                    ReloginManager.uj().f(um);
                    return null;
                }
                return cA(i);
            }
            com.baidu.tbadk.core.data.aj d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xy = com.baidu.tbadk.coreExtra.a.a.xy()) != null) {
                xy.h(currentAccountObj);
            }
            if (d == null) {
                if (this.aeT != null) {
                    this.aeR.vT().mErrorString = this.aeT.getErrorString();
                    return null;
                }
                this.aeR.vT().mErrorString = str;
                return uE;
            }
            return cA(i);
        } else {
            return uE;
        }
    }

    private String cA(int i) {
        String uE;
        va();
        switch (i) {
            case 1:
                uE = this.aeS.uD();
                break;
            case 2:
                uE = this.aeS.uB();
                break;
            case 3:
                uE = this.aeS.uE();
                break;
            default:
                return null;
        }
        if (this.aeR.vT().vc()) {
            switch (this.aeR.vT().agW) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.aeR.vT().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uE;
            }
        }
        return uE;
    }

    public String uB() {
        return cz(2);
    }

    public String uD() {
        return cz(1);
    }

    public String uE() {
        return cz(3);
    }

    public String dk(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream cW = l.cW(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = cW.read(bArr2);
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
        return uE();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uZ().vS().a(this.aeS);
        return this.aeS.a(str, handler, i, i2, i3, z);
    }
}
