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

    private void tA() {
        this.Wv = new com.baidu.tbadk.core.util.a.a();
        this.Ww = ae.tK().a(this.Wv);
        this.Wx = null;
        this.Wv.uv().uy().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ad(TbadkCoreApplication.m11getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a tB() {
        return this.Wv;
    }

    public ab() {
        tA();
    }

    public ab(String str) {
        tA();
        this.Wv.uv().uy().mUrl = str;
    }

    public void setUrl(String str) {
        this.Wv.uv().uy().mUrl = str;
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

    private void tC() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m11getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tc = this.Ww.tc();
            int size = tc.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = tc.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    tc.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    tc.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void tD() {
        if (this.Wy == null) {
            this.Wy = af.tL();
        }
        if (this.Wy != null) {
            this.Ww.n("stTime", String.valueOf(this.Wy.mTime));
            this.Ww.n("stSize", String.valueOf(this.Wy.WQ));
            this.Ww.n("stTimesNum", String.valueOf(this.Wy.WR));
            this.Ww.n("stMode", String.valueOf(this.Wy.mMode));
            this.Ww.n("stMethod", String.valueOf(this.Wy.WP));
        }
        this.Wz = af.cq(0);
        if (this.Wz == 0 && this.Wy != null) {
            this.Wz = this.Wy.WR;
        }
        this.Ww.n("stErrorNums", String.valueOf(this.Wz));
    }

    public boolean tE() {
        return this.Wv.uw().tE();
    }

    public int tF() {
        return this.Wv.uw().YD;
    }

    public int tG() {
        return this.Wv.uw().lE;
    }

    public String tH() {
        return this.Wv.uw().YE;
    }

    public String getErrorString() {
        return this.Wv.uw().mErrorString;
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
        String td;
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
            this.Wx.tB().uv().mIsNeedAddCommenParam = false;
            this.Wx.tB().uv().mIsUseCurrentBDUSS = false;
            this.Wx.tB().uv().YA = false;
            this.Wx.n("un", str);
            this.Wx.n("passwd", str2);
            this.Wx.n("isphone", "0");
            this.Wx.n("channel_id", TbadkCoreApplication.m11getInst().getPushChannelId());
            this.Wx.n("channel_uid", TbadkCoreApplication.m11getInst().getPushChannelUserId());
            this.Wx.tB().uv().uy().Zb = true;
            td = this.Wx.td();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Wx.tB().uw().nZ() && td != null) {
            com.baidu.tbadk.core.data.y yVar = new com.baidu.tbadk.core.data.y();
            yVar.parserJson(td);
            String userId = yVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Wv.uw().mErrorString = TbadkCoreApplication.m11getInst().getApp().getApplicationContext().getString(t.j.neterror);
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
        if (this.Wx.tE()) {
            switch (this.Wx.tF()) {
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

    public byte[] te() {
        if (!this.Wv.uv().mIsFromCDN) {
            this.Wv.uv().b(this.Ww);
        }
        return this.Ww.te();
    }

    private void tI() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tc = this.Ww.tc();
        for (int i = 0; tc != null && i < tc.size(); i++) {
            BasicNameValuePair basicNameValuePair = tc.get(i);
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

    private String cn(int i) {
        String tg;
        com.baidu.tbadk.coreExtra.a.c wh;
        switch (i) {
            case 1:
                if (tB().uv().mIsNeedAddCommenParam) {
                    this.Wv.uv().b(this.Ww);
                }
                tD();
                tg = this.Ww.tf();
                break;
            case 2:
                if (tB().uv().mIsUseCurrentBDUSS) {
                    tB().uv().a(this.Ww);
                }
                if (tB().uv().mIsNeedAddCommenParam) {
                    this.Wv.uv().b(this.Ww);
                }
                tD();
                tg = this.Ww.td();
                break;
            case 3:
                if (tB().uv().mIsUseCurrentBDUSS) {
                    tB().uv().a(this.Ww);
                }
                if (tB().uv().mIsNeedAddCommenParam) {
                    this.Wv.uv().b(this.Ww);
                }
                tI();
                tg = this.Ww.tg();
                break;
            default:
                return null;
        }
        if (!this.Wv.uw().tE()) {
            af.a(this.Wy);
            af.cr(this.Wz);
            return tg;
        } else if (!this.Wv.uw().nZ() && this.Wv.uw().YD == 1 && this.Wv.uv().YA) {
            String str = this.Wv.uw().mErrorString;
            this.Wv.uw().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.on();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m11getInst().handler.sendMessage(TbadkCoreApplication.m11getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cf(currentAccountObj.getAccount());
            if (ReloginManager.sM().sQ()) {
                AccountData sP = ReloginManager.sM().sP();
                if (sP == null) {
                    ReloginManager.sM().e(sP);
                    return null;
                }
                return co(i);
            }
            com.baidu.tbadk.core.data.y d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (wh = com.baidu.tbadk.coreExtra.a.a.wh()) != null) {
                wh.g(currentAccountObj);
            }
            if (d == null) {
                if (this.Wx != null) {
                    this.Wv.uw().mErrorString = this.Wx.getErrorString();
                    return null;
                }
                this.Wv.uw().mErrorString = str;
                return tg;
            }
            return co(i);
        } else {
            return tg;
        }
    }

    private String co(int i) {
        String tg;
        tC();
        switch (i) {
            case 1:
                tg = this.Ww.tf();
                break;
            case 2:
                tg = this.Ww.td();
                break;
            case 3:
                tg = this.Ww.tg();
                break;
            default:
                return null;
        }
        if (this.Wv.uw().tE()) {
            switch (this.Wv.uw().YD) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m11getInst().handler.sendMessage(TbadkCoreApplication.m11getInst().handler.obtainMessage(1));
                    this.Wv.uw().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return tg;
            }
        }
        return tg;
    }

    public String td() {
        return cn(2);
    }

    public String tg() {
        return cn(3);
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
        return tg();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        tB().uv().a(this.Ww);
        return this.Ww.a(str, handler, i, i2, i3, z);
    }
}
