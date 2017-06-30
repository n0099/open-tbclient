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
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a aeY = null;
    private u aeZ = null;
    private ab afa = null;
    private af.a afb = null;
    private int afc = 0;

    private void uU() {
        this.aeY = new com.baidu.tbadk.core.util.a.a();
        this.aeZ = ae.vf().a(this.aeY);
        this.afa = null;
        this.aeY.vR().vU().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ag(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uV() {
        return this.aeY;
    }

    public ab() {
        uU();
    }

    public ab(String str) {
        uU();
        this.aeY.vR().vU().mUrl = str;
    }

    public void setUrl(String str) {
        this.aeY.vR().vU().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.aeZ.k(arrayList);
    }

    public void n(String str, String str2) {
        this.aeZ.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.aeZ.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.aeZ.d(str, bArr);
    }

    private void uW() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ux = this.aeZ.ux();
            int size = ux.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ux.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ux.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ux.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uX() {
        if (this.afb == null) {
            this.afb = af.vg();
        }
        if (this.afb != null) {
            this.aeZ.n("stTime", String.valueOf(this.afb.mTime));
            this.aeZ.n("stSize", String.valueOf(this.afb.afs));
            this.aeZ.n("stTimesNum", String.valueOf(this.afb.aft));
            this.aeZ.n("stMode", String.valueOf(this.afb.mMode));
            this.aeZ.n("stMethod", String.valueOf(this.afb.afr));
        }
        this.afc = af.cF(0);
        if (this.afc == 0 && this.afb != null) {
            this.afc = this.afb.aft;
        }
        this.aeZ.n("stErrorNums", String.valueOf(this.afc));
    }

    public boolean uY() {
        return this.aeY.vS().uY();
    }

    public int uZ() {
        return this.aeY.vS().ahc;
    }

    public int va() {
        return this.aeY.vS().vQ;
    }

    public String vb() {
        return this.aeY.vS().ahd;
    }

    public String getErrorString() {
        return this.aeY.vS().mErrorString;
    }

    public void fr() {
        if (this.aeZ != null) {
            this.aeZ.fr();
        }
        if (this.afa != null) {
            this.afa.fr();
        }
    }

    public void fu() {
        if (this.aeZ != null) {
            this.aeZ.fu();
        }
        if (this.afa != null) {
            this.afa.fu();
        }
    }

    private com.baidu.tbadk.core.data.al e(String str, String str2, boolean z) {
        String uy;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.afa == null) {
                this.afa = new ab(sb.toString());
            } else {
                this.afa.fr();
            }
            this.afa.uV().vR().mIsNeedAddCommenParam = false;
            this.afa.uV().vR().mIsUseCurrentBDUSS = false;
            this.afa.uV().vR().agZ = false;
            this.afa.n("un", str);
            this.afa.n("passwd", str2);
            this.afa.n("isphone", "0");
            this.afa.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.afa.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.afa.uV().vR().vU().ahA = true;
            uy = this.afa.uy();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.afa.uV().vS().isRequestSuccess() && uy != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.parserJson(uy);
            String userId = alVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.aeY.vS().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(w.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(alVar.getUser().getUserName());
            if (alVar.getUser().getPassword() != null) {
                accountData.setPassword(alVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(alVar.getUser().getUserId());
            accountData.setBDUSS(alVar.getUser().getBDUSS());
            accountData.setPortrait(alVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (alVar.qe() != null) {
                accountData.setTbs(alVar.qe().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return alVar;
        }
        if (this.afa.uY()) {
            switch (this.afa.uZ()) {
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

    public byte[] tP() {
        if (!this.aeY.vR().mIsFromCDN) {
            this.aeY.vR().b(this.aeZ);
        }
        return this.aeZ.tP();
    }

    private void vc() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ux = this.aeZ.ux();
        for (int i = 0; ux != null && i < ux.size(); i++) {
            BasicNameValuePair basicNameValuePair = ux.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.aeZ.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aN(stringBuffer.toString()));
    }

    private String cC(int i) {
        String uA;
        com.baidu.tbadk.coreExtra.a.c xt;
        switch (i) {
            case 1:
                if (uV().vR().mIsNeedAddCommenParam) {
                    this.aeY.vR().b(this.aeZ);
                }
                uX();
                uA = this.aeZ.uz();
                break;
            case 2:
                if (uV().vR().mIsUseCurrentBDUSS) {
                    uV().vR().a(this.aeZ);
                }
                if (uV().vR().mIsNeedAddCommenParam) {
                    this.aeY.vR().b(this.aeZ);
                }
                uX();
                uA = this.aeZ.uy();
                break;
            case 3:
                if (uV().vR().mIsUseCurrentBDUSS) {
                    uV().vR().a(this.aeZ);
                }
                if (uV().vR().mIsNeedAddCommenParam) {
                    this.aeY.vR().b(this.aeZ);
                }
                vc();
                uA = this.aeZ.uA();
                break;
            default:
                return null;
        }
        if (!this.aeY.vS().uY()) {
            af.a(this.afb);
            af.cG(this.afc);
            return uA;
        } else if (!this.aeY.vS().isRequestSuccess()) {
            if (this.aeY.vS().ahc == 1 && this.aeY.vR().agZ) {
                String str = this.aeY.vS().mErrorString;
                this.aeY.vS().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.oW();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    vd();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cm(currentAccountObj.getAccount());
                if (ReloginManager.uh().um()) {
                    AccountData ul = ReloginManager.uh().ul();
                    if (ul == null) {
                        ReloginManager.uh().f(ul);
                        return null;
                    }
                    return cD(i);
                }
                com.baidu.tbadk.core.data.al e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xt = com.baidu.tbadk.coreExtra.a.a.xt()) != null) {
                    xt.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.afa != null) {
                        this.aeY.vS().mErrorString = this.afa.getErrorString();
                        return null;
                    }
                    this.aeY.vS().mErrorString = str;
                    return uA;
                }
                uA = cD(i);
            }
            com.baidu.tieba.h.a.a(this);
            return uA;
        } else {
            return uA;
        }
    }

    private String cD(int i) {
        String uA;
        uW();
        switch (i) {
            case 1:
                uA = this.aeZ.uz();
                break;
            case 2:
                uA = this.aeZ.uy();
                break;
            case 3:
                uA = this.aeZ.uA();
                break;
            default:
                return null;
        }
        if (this.aeY.vS().uY()) {
            switch (this.aeY.vS().ahc) {
                case 1:
                case 2:
                case 5:
                    vd();
                    this.aeY.vS().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uA;
            }
        }
        return uA;
    }

    private void vd() {
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String uy() {
        return cC(2);
    }

    public String uz() {
        return cC(1);
    }

    public String uA() {
        return cC(3);
    }

    public String dG(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream ds = n.ds(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = ds.read(bArr2);
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
        return uA();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uV().vR().a(this.aeZ);
        return this.aeZ.a(str, handler, i, i2, i3, z);
    }
}
