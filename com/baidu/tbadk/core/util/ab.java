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
import com.baidu.tieba.t;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a Wv = null;
    private t Ww = null;
    private ab Wx = null;
    private af.a Wy = null;
    private int Wz = 0;

    private void tz() {
        this.Wv = new com.baidu.tbadk.core.util.a.a();
        this.Ww = ae.tJ().a(this.Wv);
        this.Wx = null;
        this.Wv.uu().ux().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ad(TbadkCoreApplication.m11getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a tA() {
        return this.Wv;
    }

    public ab() {
        tz();
    }

    public ab(String str) {
        tz();
        this.Wv.uu().ux().mUrl = str;
    }

    public void setUrl(String str) {
        this.Wv.uu().ux().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.Ww.k(arrayList);
    }

    public void n(String str, String str2) {
        this.Ww.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Ww.a(basicNameValuePair);
    }

    public void c(String str, byte[] bArr) {
        this.Ww.c(str, bArr);
    }

    private void tB() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m11getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tb = this.Ww.tb();
            int size = tb.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = tb.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    tb.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    tb.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void tC() {
        if (this.Wy == null) {
            this.Wy = af.tK();
        }
        if (this.Wy != null) {
            this.Ww.n("stTime", String.valueOf(this.Wy.mTime));
            this.Ww.n("stSize", String.valueOf(this.Wy.WQ));
            this.Ww.n("stTimesNum", String.valueOf(this.Wy.WR));
            this.Ww.n("stMode", String.valueOf(this.Wy.mMode));
            this.Ww.n("stMethod", String.valueOf(this.Wy.WP));
        }
        this.Wz = af.cr(0);
        if (this.Wz == 0 && this.Wy != null) {
            this.Wz = this.Wy.WR;
        }
        this.Ww.n("stErrorNums", String.valueOf(this.Wz));
    }

    public boolean tD() {
        return this.Wv.uv().tD();
    }

    public int tE() {
        return this.Wv.uv().YD;
    }

    public int tF() {
        return this.Wv.uv().lE;
    }

    public String tG() {
        return this.Wv.uv().YE;
    }

    public String getErrorString() {
        return this.Wv.uv().mErrorString;
    }

    public void dl() {
        if (this.Ww != null) {
            this.Ww.dl();
        }
        if (this.Wx != null) {
            this.Wx.dl();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m14do() {
        if (this.Ww != null) {
            this.Ww.mo15do();
        }
        if (this.Wx != null) {
            this.Wx.m14do();
        }
    }

    private com.baidu.tbadk.core.data.y d(String str, String str2, boolean z) {
        String tc;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m11getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.Wx == null) {
                this.Wx = new ab(sb.toString());
            } else {
                this.Wx.dl();
            }
            this.Wx.tA().uu().mIsNeedAddCommenParam = false;
            this.Wx.tA().uu().mIsUseCurrentBDUSS = false;
            this.Wx.tA().uu().YA = false;
            this.Wx.n("un", str);
            this.Wx.n("passwd", str2);
            this.Wx.n("isphone", "0");
            this.Wx.n("channel_id", TbadkCoreApplication.m11getInst().getPushChannelId());
            this.Wx.n("channel_uid", TbadkCoreApplication.m11getInst().getPushChannelUserId());
            this.Wx.tA().uu().ux().Zb = true;
            tc = this.Wx.tc();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Wx.tA().uv().nZ() && tc != null) {
            com.baidu.tbadk.core.data.y yVar = new com.baidu.tbadk.core.data.y();
            yVar.parserJson(tc);
            String userId = yVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Wv.uv().mErrorString = TbadkCoreApplication.m11getInst().getApp().getApplicationContext().getString(t.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(yVar.getUser().getUserName());
            if (yVar.getUser().getPassword() != null) {
                accountData.setPassword(yVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(yVar.getUser().getUserId());
            accountData.setBDUSS(yVar.getUser().getBDUSS());
            accountData.setPortrait(yVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (yVar.pz() != null) {
                accountData.setTbs(yVar.pz().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m11getInst().getApp().getApplicationContext());
            return yVar;
        }
        if (this.Wx.tD()) {
            switch (this.Wx.tE()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m11getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m11getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] td() {
        if (!this.Wv.uu().mIsFromCDN) {
            this.Wv.uu().b(this.Ww);
        }
        return this.Ww.td();
    }

    private void tH() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tb = this.Ww.tb();
        for (int i = 0; tb != null && i < tb.size(); i++) {
            BasicNameValuePair basicNameValuePair = tb.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.Ww.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aS(stringBuffer.toString()));
    }

    private String co(int i) {
        String tf;
        com.baidu.tbadk.coreExtra.a.c wg;
        switch (i) {
            case 1:
                if (tA().uu().mIsNeedAddCommenParam) {
                    this.Wv.uu().b(this.Ww);
                }
                tC();
                tf = this.Ww.te();
                break;
            case 2:
                if (tA().uu().mIsUseCurrentBDUSS) {
                    tA().uu().a(this.Ww);
                }
                if (tA().uu().mIsNeedAddCommenParam) {
                    this.Wv.uu().b(this.Ww);
                }
                tC();
                tf = this.Ww.tc();
                break;
            case 3:
                if (tA().uu().mIsUseCurrentBDUSS) {
                    tA().uu().a(this.Ww);
                }
                if (tA().uu().mIsNeedAddCommenParam) {
                    this.Wv.uu().b(this.Ww);
                }
                tH();
                tf = this.Ww.tf();
                break;
            default:
                return null;
        }
        if (!this.Wv.uv().tD()) {
            af.a(this.Wy);
            af.cs(this.Wz);
            return tf;
        } else if (!this.Wv.uv().nZ() && this.Wv.uv().YD == 1 && this.Wv.uu().YA) {
            String str = this.Wv.uv().mErrorString;
            this.Wv.uv().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.on();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m11getInst().handler.sendMessage(TbadkCoreApplication.m11getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cf(currentAccountObj.getAccount());
            if (ReloginManager.sL().sP()) {
                AccountData sO = ReloginManager.sL().sO();
                if (sO == null) {
                    ReloginManager.sL().e(sO);
                    return null;
                }
                return cp(i);
            }
            com.baidu.tbadk.core.data.y d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (wg = com.baidu.tbadk.coreExtra.a.a.wg()) != null) {
                wg.g(currentAccountObj);
            }
            if (d == null) {
                if (this.Wx != null) {
                    this.Wv.uv().mErrorString = this.Wx.getErrorString();
                    return null;
                }
                this.Wv.uv().mErrorString = str;
                return tf;
            }
            return cp(i);
        } else {
            return tf;
        }
    }

    private String cp(int i) {
        String tf;
        tB();
        switch (i) {
            case 1:
                tf = this.Ww.te();
                break;
            case 2:
                tf = this.Ww.tc();
                break;
            case 3:
                tf = this.Ww.tf();
                break;
            default:
                return null;
        }
        if (this.Wv.uv().tD()) {
            switch (this.Wv.uv().YD) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m11getInst().handler.sendMessage(TbadkCoreApplication.m11getInst().handler.obtainMessage(1));
                    this.Wv.uv().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return tf;
            }
        }
        return tf;
    }

    public String tc() {
        return co(2);
    }

    public String tf() {
        return co(3);
    }

    /* renamed from: do  reason: not valid java name */
    public String m13do(String str) {
        byte[] bArr;
        try {
            InputStream cY = m.cY(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = cY.read(bArr2);
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
        c("pic", bArr);
        return tf();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        tA().uu().a(this.Ww);
        return this.Ww.a(str, handler, i, i2, i3, z);
    }
}
