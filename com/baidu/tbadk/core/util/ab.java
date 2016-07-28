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
import com.baidu.tieba.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a Xu = null;
    private t Xv = null;
    private ab Xw = null;
    private af.a Xx = null;
    private int Xy = 0;

    private void tw() {
        this.Xu = new com.baidu.tbadk.core.util.a.a();
        this.Xv = ae.tG().a(this.Xu);
        this.Xw = null;
        this.Xu.uu().ux().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.af(TbadkCoreApplication.m10getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a tx() {
        return this.Xu;
    }

    public ab() {
        tw();
    }

    public ab(String str) {
        tw();
        this.Xu.uu().ux().mUrl = str;
    }

    public void setUrl(String str) {
        this.Xu.uu().ux().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.Xv.l(arrayList);
    }

    public void n(String str, String str2) {
        this.Xv.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Xv.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.Xv.d(str, bArr);
    }

    private void ty() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m10getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> sY = this.Xv.sY();
            int size = sY.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = sY.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    sY.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    sY.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void tz() {
        if (this.Xx == null) {
            this.Xx = af.tH();
        }
        if (this.Xx != null) {
            this.Xv.n("stTime", String.valueOf(this.Xx.mTime));
            this.Xv.n("stSize", String.valueOf(this.Xx.XP));
            this.Xv.n("stTimesNum", String.valueOf(this.Xx.XQ));
            this.Xv.n("stMode", String.valueOf(this.Xx.mMode));
            this.Xv.n("stMethod", String.valueOf(this.Xx.XO));
        }
        this.Xy = af.cr(0);
        if (this.Xy == 0 && this.Xx != null) {
            this.Xy = this.Xx.XQ;
        }
        this.Xv.n("stErrorNums", String.valueOf(this.Xy));
    }

    public boolean tA() {
        return this.Xu.uv().tA();
    }

    public int tB() {
        return this.Xu.uv().ZD;
    }

    public int tC() {
        return this.Xu.uv().mi;
    }

    public String tD() {
        return this.Xu.uv().ZE;
    }

    public String getErrorString() {
        return this.Xu.uv().mErrorString;
    }

    public void dl() {
        if (this.Xv != null) {
            this.Xv.dl();
        }
        if (this.Xw != null) {
            this.Xw.dl();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m12do() {
        if (this.Xv != null) {
            this.Xv.mo13do();
        }
        if (this.Xw != null) {
            this.Xw.m12do();
        }
    }

    private com.baidu.tbadk.core.data.ad d(String str, String str2, boolean z) {
        String sZ;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m10getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.Xw == null) {
                this.Xw = new ab(sb.toString());
            } else {
                this.Xw.dl();
            }
            this.Xw.tx().uu().mIsNeedAddCommenParam = false;
            this.Xw.tx().uu().mIsUseCurrentBDUSS = false;
            this.Xw.tx().uu().ZA = false;
            this.Xw.n("un", str);
            this.Xw.n("passwd", str2);
            this.Xw.n("isphone", "0");
            this.Xw.n("channel_id", TbadkCoreApplication.m10getInst().getPushChannelId());
            this.Xw.n("channel_uid", TbadkCoreApplication.m10getInst().getPushChannelUserId());
            this.Xw.tx().uu().ux().aab = true;
            sZ = this.Xw.sZ();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Xw.tx().uv().nJ() && sZ != null) {
            com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
            adVar.parserJson(sZ);
            String userId = adVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Xu.uv().mErrorString = TbadkCoreApplication.m10getInst().getApp().getApplicationContext().getString(u.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(adVar.getUser().getUserName());
            if (adVar.getUser().getPassword() != null) {
                accountData.setPassword(adVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(adVar.getUser().getUserId());
            accountData.setBDUSS(adVar.getUser().getBDUSS());
            accountData.setPortrait(adVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (adVar.pc() != null) {
                accountData.setTbs(adVar.pc().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m10getInst().getApp().getApplicationContext());
            return adVar;
        }
        if (this.Xw.tA()) {
            switch (this.Xw.tB()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m10getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m10getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] ta() {
        if (!this.Xu.uu().mIsFromCDN) {
            this.Xu.uu().b(this.Xv);
        }
        return this.Xv.ta();
    }

    private void tE() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> sY = this.Xv.sY();
        for (int i = 0; sY != null && i < sY.size(); i++) {
            BasicNameValuePair basicNameValuePair = sY.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.Xv.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aT(stringBuffer.toString()));
    }

    private String co(int i) {
        String tc;
        com.baidu.tbadk.coreExtra.a.c wk;
        switch (i) {
            case 1:
                if (tx().uu().mIsNeedAddCommenParam) {
                    this.Xu.uu().b(this.Xv);
                }
                tz();
                tc = this.Xv.tb();
                break;
            case 2:
                if (tx().uu().mIsUseCurrentBDUSS) {
                    tx().uu().a(this.Xv);
                }
                if (tx().uu().mIsNeedAddCommenParam) {
                    this.Xu.uu().b(this.Xv);
                }
                tz();
                tc = this.Xv.sZ();
                break;
            case 3:
                if (tx().uu().mIsUseCurrentBDUSS) {
                    tx().uu().a(this.Xv);
                }
                if (tx().uu().mIsNeedAddCommenParam) {
                    this.Xu.uu().b(this.Xv);
                }
                tE();
                tc = this.Xv.tc();
                break;
            default:
                return null;
        }
        if (!this.Xu.uv().tA()) {
            af.a(this.Xx);
            af.cs(this.Xy);
            return tc;
        } else if (!this.Xu.uv().nJ() && this.Xu.uv().ZD == 1 && this.Xu.uu().ZA) {
            String str = this.Xu.uv().mErrorString;
            this.Xu.uv().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.nX();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m10getInst().handler.sendMessage(TbadkCoreApplication.m10getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cf(currentAccountObj.getAccount());
            if (ReloginManager.sI().sM()) {
                AccountData sL = ReloginManager.sI().sL();
                if (sL == null) {
                    ReloginManager.sI().e(sL);
                    return null;
                }
                return cp(i);
            }
            com.baidu.tbadk.core.data.ad d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (wk = com.baidu.tbadk.coreExtra.a.a.wk()) != null) {
                wk.g(currentAccountObj);
            }
            if (d == null) {
                if (this.Xw != null) {
                    this.Xu.uv().mErrorString = this.Xw.getErrorString();
                    return null;
                }
                this.Xu.uv().mErrorString = str;
                return tc;
            }
            return cp(i);
        } else {
            return tc;
        }
    }

    private String cp(int i) {
        String tc;
        ty();
        switch (i) {
            case 1:
                tc = this.Xv.tb();
                break;
            case 2:
                tc = this.Xv.sZ();
                break;
            case 3:
                tc = this.Xv.tc();
                break;
            default:
                return null;
        }
        if (this.Xu.uv().tA()) {
            switch (this.Xu.uv().ZD) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m10getInst().handler.sendMessage(TbadkCoreApplication.m10getInst().handler.obtainMessage(1));
                    this.Xu.uv().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return tc;
            }
        }
        return tc;
    }

    public String sZ() {
        return co(2);
    }

    public String tb() {
        return co(1);
    }

    public String tc() {
        return co(3);
    }

    public String dl(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream cX = m.cX(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = cX.read(bArr2);
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
        return tc();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        tx().uu().a(this.Xv);
        return this.Xv.a(str, handler, i, i2, i3, z);
    }
}
