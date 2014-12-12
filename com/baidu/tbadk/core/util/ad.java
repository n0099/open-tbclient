package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ad {
    private com.baidu.tbadk.core.util.httpNet.c Iq = null;
    private v Ir = null;
    private ad Is = null;
    private ap It = null;
    private int Iu = 0;

    private void oV() {
        this.Iq = new com.baidu.tbadk.core.util.httpNet.c();
        this.Ir = ak.pi().a(this.Iq);
        this.Is = null;
        this.Iq.pV().pY().mNetType = com.baidu.tbadk.core.util.httpNet.h.getNetType();
        this.Iq.pV().pY().Kf = this.Iq.pV().Kf;
    }

    public com.baidu.tbadk.core.util.httpNet.c oW() {
        return this.Iq;
    }

    public ad() {
        oV();
    }

    public ad(String str) {
        oV();
        this.Iq.pV().pY().mUrl = str;
    }

    public void setUrl(String str) {
        this.Iq.pV().pY().mUrl = str;
    }

    public void q(ArrayList<BasicNameValuePair> arrayList) {
        this.Ir.q(arrayList);
    }

    public void o(String str, String str2) {
        this.Ir.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Ir.a(basicNameValuePair);
    }

    public void g(String str, byte[] bArr) {
        this.Ir.g(str, bArr);
    }

    private void oX() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m255getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ot = this.Ir.ot();
            int size = ot.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ot.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ot.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ot.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void oY() {
        if (this.It == null) {
            this.It = ao.pp();
        }
        if (this.It != null) {
            this.Ir.o("stTime", String.valueOf(this.It.mTime));
            this.Ir.o("stSize", String.valueOf(this.It.mSize));
            this.Ir.o("stTimesNum", String.valueOf(this.It.IV));
            this.Ir.o("stMode", String.valueOf(this.It.mMode));
            this.Ir.o("stMethod", String.valueOf(this.It.IU));
        }
        this.Iu = ao.bS(0);
        if (this.Iu == 0 && this.It != null) {
            this.Iu = this.It.IV;
        }
        this.Ir.o("stErrorNums", String.valueOf(this.Iu));
    }

    public boolean oZ() {
        return this.Iq.pW().oZ();
    }

    public int pa() {
        return this.Iq.pW().Kj;
    }

    public int pb() {
        return this.Iq.pW().Ki;
    }

    public String getErrorString() {
        return this.Iq.pW().mErrorString;
    }

    public void dL() {
        if (this.Ir != null) {
            this.Ir.dL();
        }
        if (this.Is != null) {
            this.Is.dL();
        }
    }

    private com.baidu.tbadk.core.data.m d(String str, String str2, boolean z) {
        String ov;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.Is == null) {
                this.Is = new ad(sb.toString());
            } else {
                this.Is.dL();
            }
            this.Is.oW().pV().mIsNeedAddCommenParam = false;
            this.Is.oW().pV().mIsUseCurrentBDUSS = false;
            this.Is.oW().pV().Ke = false;
            this.Is.o("un", str);
            this.Is.o("passwd", str2);
            this.Is.o("isphone", "0");
            this.Is.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
            this.Is.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
            this.Is.oW().pV().pY().Kx = true;
            ov = this.Is.ov();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Is.oW().pW().ma() && ov != null) {
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            mVar.parserJson(ov);
            String userId = mVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Iq.pW().mErrorString = TbadkCoreApplication.m255getInst().getApp().getApplicationContext().getString(com.baidu.tieba.z.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(mVar.getUser().getUserName());
            if (mVar.getUser().getPassword() != null) {
                accountData.setPassword(mVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(mVar.getUser().getUserId());
            accountData.setBDUSS(mVar.getUser().getBDUSS());
            accountData.setPortrait(mVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (mVar.mP() != null) {
                accountData.setTbs(mVar.mP().getTbs());
            }
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
            return mVar;
        }
        if (this.Is.oZ()) {
            switch (this.Is.pa()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m255getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m255getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] ow() {
        if (!this.Iq.pV().mIsFromCDN) {
            this.Iq.pV().b(this.Ir);
        }
        return this.Ir.ow();
    }

    private void pc() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ot = this.Ir.ot();
        for (int i = 0; ot != null && i < ot.size(); i++) {
            BasicNameValuePair basicNameValuePair = ot.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.Ir.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.z.toMd5(stringBuffer.toString()));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String bN(int i) {
        String oy;
        String str;
        switch (i) {
            case 1:
                if (oW().pV().mIsNeedAddCommenParam) {
                    this.Iq.pV().b(this.Ir);
                }
                oY();
                oy = this.Ir.ox();
                break;
            case 2:
                if (oW().pV().mIsUseCurrentBDUSS) {
                    oW().pV().a(this.Ir);
                }
                if (oW().pV().mIsNeedAddCommenParam) {
                    this.Iq.pV().b(this.Ir);
                }
                oY();
                oy = this.Ir.ov();
                break;
            case 3:
                if (oW().pV().mIsUseCurrentBDUSS) {
                    oW().pV().a(this.Ir);
                }
                if (oW().pV().mIsNeedAddCommenParam) {
                    this.Iq.pV().b(this.Ir);
                }
                pc();
                oy = this.Ir.oy();
                break;
            default:
                return null;
        }
        if (oy == null && ak.IN == 1 && this.Iq.pW().Ki != 404 && this.Iq.pW().Ki < 500) {
            if (!this.Ir.ou()) {
                this.Ir = new ae(this.Iq);
                switch (i) {
                    case 1:
                        if (oW().pV().mIsNeedAddCommenParam) {
                            this.Iq.pV().b(this.Ir);
                        }
                        oY();
                        oy = this.Ir.ox();
                        break;
                    case 2:
                        if (oW().pV().mIsUseCurrentBDUSS) {
                            oW().pV().a(this.Ir);
                        }
                        if (oW().pV().mIsNeedAddCommenParam) {
                            this.Iq.pV().b(this.Ir);
                        }
                        oY();
                        oy = this.Ir.ov();
                        break;
                    case 3:
                        if (oW().pV().mIsUseCurrentBDUSS) {
                            oW().pV().a(this.Ir);
                        }
                        if (oW().pV().mIsNeedAddCommenParam) {
                            this.Iq.pV().b(this.Ir);
                        }
                        oy = this.Ir.oy();
                        break;
                    default:
                        return null;
                }
                if (oy != null && this.Iq.pW().ma()) {
                    ak.pj();
                    str = oy;
                    if (this.Iq.pW().oZ()) {
                        ao.a(this.It);
                        ao.bT(this.Iu);
                        return str;
                    } else if (!this.Iq.pW().ma() && this.Iq.pW().Kj == 1 && this.Iq.pV().Ke) {
                        String str2 = this.Iq.pW().mErrorString;
                        this.Iq.pW().mErrorString = "";
                        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                        AccountData mk = currentAccountObj == null ? com.baidu.tbadk.core.account.a.mk() : currentAccountObj;
                        if (mk == null || TextUtils.isEmpty(mk.getAccount())) {
                            TbadkCoreApplication.m255getInst().handler.sendMessage(TbadkCoreApplication.m255getInst().handler.obtainMessage(1));
                            return null;
                        }
                        com.baidu.tbadk.core.account.a.bN(mk.getAccount());
                        if (ReloginManager.ob().of()) {
                            AccountData oe = ReloginManager.ob().oe();
                            if (oe == null) {
                                ReloginManager.ob().d(oe);
                                return null;
                            }
                            return bO(i);
                        }
                        com.baidu.tbadk.core.data.m d = d(mk.getAccount(), mk.getPassword(), true);
                        if (!TextUtils.isEmpty(mk.getID())) {
                            if (mk.getID().equals(TbadkCoreApplication.getCurrentAccount())) {
                                SapiAccountManager.getInstance().logout();
                            } else {
                                List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
                                if (loginAccounts != null && loginAccounts.size() > 0) {
                                    Iterator<SapiAccount> it = loginAccounts.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            SapiAccount next = it.next();
                                            if (mk.getID().equals(next.uid)) {
                                                SapiAccountManager.getInstance().removeLoginAccount(next);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (d == null) {
                            if (this.Is != null) {
                                this.Iq.pW().mErrorString = this.Is.getErrorString();
                                return null;
                            }
                            this.Iq.pW().mErrorString = str2;
                            return str;
                        }
                        return bO(i);
                    } else {
                        return str;
                    }
                }
            } else {
                BdLog.d("手动取消网络请求");
            }
        }
        str = oy;
        if (this.Iq.pW().oZ()) {
        }
    }

    private String bO(int i) {
        String oy;
        oX();
        switch (i) {
            case 1:
                oy = this.Ir.ox();
                break;
            case 2:
                oy = this.Ir.ov();
                break;
            case 3:
                oy = this.Ir.oy();
                break;
            default:
                return null;
        }
        if (this.Iq.pW().oZ()) {
            switch (this.Iq.pW().Kj) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m255getInst().handler.sendMessage(TbadkCoreApplication.m255getInst().handler.obtainMessage(1));
                    this.Iq.pW().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return oy;
            }
        }
        return oy;
    }

    public String ov() {
        return bN(2);
    }

    public String oy() {
        return bN(3);
    }

    public String cz(String str) {
        byte[] bArr;
        try {
            InputStream cn = s.cn(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = cn.read(bArr2);
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
        g("pic", bArr);
        return oy();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        oW().pV().a(this.Ir);
        return this.Ir.a(str, handler, i, i2, i3, z);
    }
}
