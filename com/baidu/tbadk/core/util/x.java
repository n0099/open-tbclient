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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private com.baidu.tbadk.core.util.a.a agn = null;
    private q ago = null;
    private x agp = null;
    private aa.a agq = null;
    private int agr = 0;

    private void uP() {
        this.agn = new com.baidu.tbadk.core.util.a.a();
        this.ago = z.va().a(this.agn);
        this.agp = null;
        this.agn.vN().vQ().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uQ() {
        return this.agn;
    }

    public x() {
        uP();
    }

    public x(String str) {
        uP();
        this.agn.vN().vQ().mUrl = str;
    }

    public void setUrl(String str) {
        this.agn.vN().vQ().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.ago.l(arrayList);
    }

    public void n(String str, String str2) {
        this.ago.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.ago.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.ago.d(str, bArr);
    }

    private void uR() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ur = this.ago.ur();
            int size = ur.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ur.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ur.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ur.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void uS() {
        if (this.agq == null) {
            this.agq = aa.vb();
        }
        if (this.agq != null) {
            this.ago.n("stTime", String.valueOf(this.agq.mTime));
            this.ago.n("stSize", String.valueOf(this.agq.agH));
            this.ago.n("stTimesNum", String.valueOf(this.agq.agI));
            this.ago.n("stMode", String.valueOf(this.agq.mMode));
            this.ago.n("stMethod", String.valueOf(this.agq.agG));
        }
        this.agr = aa.cI(0);
        if (this.agr == 0 && this.agq != null) {
            this.agr = this.agq.agI;
        }
        this.ago.n("stErrorNums", String.valueOf(this.agr));
    }

    public boolean uT() {
        return this.agn.vO().uT();
    }

    public int uU() {
        return this.agn.vO().aiw;
    }

    public int uV() {
        return this.agn.vO().vp;
    }

    public String uW() {
        return this.agn.vO().aix;
    }

    public String getErrorString() {
        return this.agn.vO().mErrorString;
    }

    public void fo() {
        if (this.ago != null) {
            this.ago.fo();
        }
        if (this.agp != null) {
            this.agp.fo();
        }
    }

    public void fs() {
        if (this.ago != null) {
            this.ago.fs();
        }
        if (this.agp != null) {
            this.agp.fs();
        }
    }

    private com.baidu.tbadk.core.data.ae e(String str, String str2, boolean z) {
        String us;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.agp == null) {
                this.agp = new x(sb.toString());
            } else {
                this.agp.fo();
            }
            this.agp.uQ().vN().mIsNeedAddCommenParam = false;
            this.agp.uQ().vN().mIsUseCurrentBDUSS = false;
            this.agp.uQ().vN().ait = false;
            this.agp.n("un", str);
            this.agp.n("passwd", str2);
            this.agp.n("isphone", "0");
            this.agp.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.agp.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.agp.uQ().vN().vQ().aiU = true;
            us = this.agp.us();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.agp.uQ().vO().isRequestSuccess() && us != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(us);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.agn.vO().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.j.neterror);
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
            if (aeVar.qi() != null) {
                accountData.setTbs(aeVar.qi().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.agp.uT()) {
            switch (this.agp.uU()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] ut() {
        if (!this.agn.vN().mIsFromCDN) {
            this.agn.vN().b(this.ago);
        }
        return this.ago.ut();
    }

    private void uX() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ur = this.ago.ur();
        for (int i = 0; ur != null && i < ur.size(); i++) {
            BasicNameValuePair basicNameValuePair = ur.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.ago.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(stringBuffer.toString()));
    }

    private String cF(int i) {
        String uv;
        com.baidu.tbadk.coreExtra.a.c xo;
        switch (i) {
            case 1:
                if (uQ().vN().mIsNeedAddCommenParam) {
                    this.agn.vN().b(this.ago);
                }
                uS();
                uv = this.ago.uu();
                break;
            case 2:
                if (uQ().vN().mIsUseCurrentBDUSS) {
                    uQ().vN().a(this.ago);
                }
                if (uQ().vN().mIsNeedAddCommenParam) {
                    this.agn.vN().b(this.ago);
                }
                uS();
                uv = this.ago.us();
                break;
            case 3:
                if (uQ().vN().mIsUseCurrentBDUSS) {
                    uQ().vN().a(this.ago);
                }
                if (uQ().vN().mIsNeedAddCommenParam) {
                    this.agn.vN().b(this.ago);
                }
                uX();
                uv = this.ago.uv();
                break;
            default:
                return null;
        }
        if (!this.agn.vO().uT()) {
            aa.a(this.agq);
            aa.cJ(this.agr);
            return uv;
        } else if (!this.agn.vO().isRequestSuccess()) {
            if (this.agn.vO().aiw == 1 && this.agn.vN().ait) {
                String str = this.agn.vO().mErrorString;
                this.agn.vO().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.pl();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    uY();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cv(currentAccountObj.getAccount());
                if (ReloginManager.ua().ue()) {
                    AccountData ud = ReloginManager.ua().ud();
                    if (ud == null) {
                        ReloginManager.ua().f(ud);
                        return null;
                    }
                    return cG(i);
                }
                com.baidu.tbadk.core.data.ae e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xo = com.baidu.tbadk.coreExtra.a.a.xo()) != null) {
                    xo.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.agp != null) {
                        this.agn.vO().mErrorString = this.agp.getErrorString();
                        return null;
                    }
                    this.agn.vO().mErrorString = str;
                    return uv;
                }
                uv = cG(i);
            }
            com.baidu.tieba.h.a.a(this);
            return uv;
        } else {
            return uv;
        }
    }

    private String cG(int i) {
        String uv;
        uR();
        switch (i) {
            case 1:
                uv = this.ago.uu();
                break;
            case 2:
                uv = this.ago.us();
                break;
            case 3:
                uv = this.ago.uv();
                break;
            default:
                return null;
        }
        if (this.agn.vO().uT()) {
            switch (this.agn.vO().aiw) {
                case 1:
                case 2:
                case 5:
                    uY();
                    this.agn.vO().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uv;
            }
        }
        return uv;
    }

    private void uY() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String us() {
        return cF(2);
    }

    public String uu() {
        return cF(1);
    }

    public String uv() {
        return cF(3);
    }

    public String dK(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dt = k.dt(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dt.read(bArr2);
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
        return uv();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uQ().vN().a(this.ago);
        return this.ago.a(str, handler, i, i2, i3, z);
    }
}
