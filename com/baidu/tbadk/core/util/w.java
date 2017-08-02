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
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class w {
    private com.baidu.tbadk.core.util.a.a afu = null;
    private p afv = null;
    private w afw = null;
    private z.a afx = null;
    private int afy = 0;

    private void va() {
        this.afu = new com.baidu.tbadk.core.util.a.a();
        this.afv = y.vl().a(this.afu);
        this.afw = null;
        this.afu.vX().wa().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ai(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vb() {
        return this.afu;
    }

    public w() {
        va();
    }

    public w(String str) {
        va();
        this.afu.vX().wa().mUrl = str;
    }

    public void setUrl(String str) {
        this.afu.vX().wa().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.afv.k(arrayList);
    }

    public void n(String str, String str2) {
        this.afv.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.afv.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.afv.d(str, bArr);
    }

    private void vc() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uD = this.afv.uD();
            int size = uD.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uD.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uD.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uD.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vd() {
        if (this.afx == null) {
            this.afx = z.vm();
        }
        if (this.afx != null) {
            this.afv.n("stTime", String.valueOf(this.afx.mTime));
            this.afv.n("stSize", String.valueOf(this.afx.afO));
            this.afv.n("stTimesNum", String.valueOf(this.afx.afP));
            this.afv.n("stMode", String.valueOf(this.afx.mMode));
            this.afv.n("stMethod", String.valueOf(this.afx.afN));
        }
        this.afy = z.cH(0);
        if (this.afy == 0 && this.afx != null) {
            this.afy = this.afx.afP;
        }
        this.afv.n("stErrorNums", String.valueOf(this.afy));
    }

    public boolean ve() {
        return this.afu.vY().ve();
    }

    public int vf() {
        return this.afu.vY().ahy;
    }

    public int vg() {
        return this.afu.vY().vR;
    }

    public String vh() {
        return this.afu.vY().ahz;
    }

    public String getErrorString() {
        return this.afu.vY().mErrorString;
    }

    public void fp() {
        if (this.afv != null) {
            this.afv.fp();
        }
        if (this.afw != null) {
            this.afw.fp();
        }
    }

    public void fs() {
        if (this.afv != null) {
            this.afv.fs();
        }
        if (this.afw != null) {
            this.afw.fs();
        }
    }

    private com.baidu.tbadk.core.data.ak e(String str, String str2, boolean z) {
        String uE;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.afw == null) {
                this.afw = new w(sb.toString());
            } else {
                this.afw.fp();
            }
            this.afw.vb().vX().mIsNeedAddCommenParam = false;
            this.afw.vb().vX().mIsUseCurrentBDUSS = false;
            this.afw.vb().vX().ahv = false;
            this.afw.n("un", str);
            this.afw.n("passwd", str2);
            this.afw.n("isphone", "0");
            this.afw.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.afw.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.afw.vb().vX().wa().ahW = true;
            uE = this.afw.uE();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.afw.vb().vY().isRequestSuccess() && uE != null) {
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.parserJson(uE);
            String userId = akVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.afu.vY().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(akVar.getUser().getUserName());
            if (akVar.getUser().getPassword() != null) {
                accountData.setPassword(akVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(akVar.getUser().getUserId());
            accountData.setBDUSS(akVar.getUser().getBDUSS());
            accountData.setPortrait(akVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (akVar.qh() != null) {
                accountData.setTbs(akVar.qh().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return akVar;
        }
        if (this.afw.ve()) {
            switch (this.afw.vf()) {
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

    public byte[] tV() {
        if (!this.afu.vX().mIsFromCDN) {
            this.afu.vX().b(this.afv);
        }
        return this.afv.tV();
    }

    private void vi() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uD = this.afv.uD();
        for (int i = 0; uD != null && i < uD.size(); i++) {
            BasicNameValuePair basicNameValuePair = uD.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.afv.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aP(stringBuffer.toString()));
    }

    private String cE(int i) {
        String uG;
        com.baidu.tbadk.coreExtra.a.c xE;
        switch (i) {
            case 1:
                if (vb().vX().mIsNeedAddCommenParam) {
                    this.afu.vX().b(this.afv);
                }
                vd();
                uG = this.afv.uF();
                break;
            case 2:
                if (vb().vX().mIsUseCurrentBDUSS) {
                    vb().vX().a(this.afv);
                }
                if (vb().vX().mIsNeedAddCommenParam) {
                    this.afu.vX().b(this.afv);
                }
                vd();
                uG = this.afv.uE();
                break;
            case 3:
                if (vb().vX().mIsUseCurrentBDUSS) {
                    vb().vX().a(this.afv);
                }
                if (vb().vX().mIsNeedAddCommenParam) {
                    this.afu.vX().b(this.afv);
                }
                vi();
                uG = this.afv.uG();
                break;
            default:
                return null;
        }
        if (!this.afu.vY().ve()) {
            z.a(this.afx);
            z.cI(this.afy);
            return uG;
        } else if (!this.afu.vY().isRequestSuccess()) {
            if (this.afu.vY().ahy == 1 && this.afu.vX().ahv) {
                String str = this.afu.vY().mErrorString;
                this.afu.vY().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.oZ();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    vj();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cr(currentAccountObj.getAccount());
                if (ReloginManager.uo().us()) {
                    AccountData ur = ReloginManager.uo().ur();
                    if (ur == null) {
                        ReloginManager.uo().f(ur);
                        return null;
                    }
                    return cF(i);
                }
                com.baidu.tbadk.core.data.ak e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xE = com.baidu.tbadk.coreExtra.a.a.xE()) != null) {
                    xE.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.afw != null) {
                        this.afu.vY().mErrorString = this.afw.getErrorString();
                        return null;
                    }
                    this.afu.vY().mErrorString = str;
                    return uG;
                }
                uG = cF(i);
            }
            com.baidu.tieba.h.a.a(this);
            return uG;
        } else {
            return uG;
        }
    }

    private String cF(int i) {
        String uG;
        vc();
        switch (i) {
            case 1:
                uG = this.afv.uF();
                break;
            case 2:
                uG = this.afv.uE();
                break;
            case 3:
                uG = this.afv.uG();
                break;
            default:
                return null;
        }
        if (this.afu.vY().ve()) {
            switch (this.afu.vY().ahy) {
                case 1:
                case 2:
                case 5:
                    vj();
                    this.afu.vY().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uG;
            }
        }
        return uG;
    }

    private void vj() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String uE() {
        return cE(2);
    }

    public String uF() {
        return cE(1);
    }

    public String uG() {
        return cE(3);
    }

    public String dJ(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream dv = k.dv(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = dv.read(bArr2);
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
        return uG();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vb().vX().a(this.afv);
        return this.afv.a(str, handler, i, i2, i3, z);
    }
}
