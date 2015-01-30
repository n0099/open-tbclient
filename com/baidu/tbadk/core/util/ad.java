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
    private com.baidu.tbadk.core.util.httpNet.c Iz = null;
    private v IA = null;
    private ad IB = null;
    private ap IC = null;
    private int IE = 0;

    private void oY() {
        this.Iz = new com.baidu.tbadk.core.util.httpNet.c();
        this.IA = ak.pl().a(this.Iz);
        this.IB = null;
        this.Iz.qg().qj().mNetType = com.baidu.tbadk.core.util.httpNet.h.getNetType();
        this.Iz.qg().qj().Ky = this.Iz.qg().Ky;
    }

    public com.baidu.tbadk.core.util.httpNet.c oZ() {
        return this.Iz;
    }

    public ad() {
        oY();
    }

    public ad(String str) {
        oY();
        this.Iz.qg().qj().mUrl = str;
    }

    public void setUrl(String str) {
        this.Iz.qg().qj().mUrl = str;
    }

    public void r(ArrayList<BasicNameValuePair> arrayList) {
        this.IA.r(arrayList);
    }

    public void o(String str, String str2) {
        this.IA.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.IA.a(basicNameValuePair);
    }

    public void g(String str, byte[] bArr) {
        this.IA.g(str, bArr);
    }

    private void pa() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m255getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ow = this.IA.ow();
            int size = ow.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ow.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ow.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ow.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void pb() {
        if (this.IC == null) {
            this.IC = ao.ps();
        }
        if (this.IC != null) {
            this.IA.o("stTime", String.valueOf(this.IC.mTime));
            this.IA.o("stSize", String.valueOf(this.IC.mSize));
            this.IA.o("stTimesNum", String.valueOf(this.IC.Jf));
            this.IA.o("stMode", String.valueOf(this.IC.mMode));
            this.IA.o("stMethod", String.valueOf(this.IC.Je));
        }
        this.IE = ao.bX(0);
        if (this.IE == 0 && this.IC != null) {
            this.IE = this.IC.Jf;
        }
        this.IA.o("stErrorNums", String.valueOf(this.IE));
    }

    public boolean pc() {
        return this.Iz.qh().pc();
    }

    public int pd() {
        return this.Iz.qh().KC;
    }

    public int pe() {
        return this.Iz.qh().KB;
    }

    public String getErrorString() {
        return this.Iz.qh().mErrorString;
    }

    public void dJ() {
        if (this.IA != null) {
            this.IA.dJ();
        }
        if (this.IB != null) {
            this.IB.dJ();
        }
    }

    private com.baidu.tbadk.core.data.n d(String str, String str2, boolean z) {
        String oy;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.IB == null) {
                this.IB = new ad(sb.toString());
            } else {
                this.IB.dJ();
            }
            this.IB.oZ().qg().mIsNeedAddCommenParam = false;
            this.IB.oZ().qg().mIsUseCurrentBDUSS = false;
            this.IB.oZ().qg().Kx = false;
            this.IB.o("un", str);
            this.IB.o("passwd", str2);
            this.IB.o("isphone", "0");
            this.IB.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
            this.IB.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
            this.IB.oZ().qg().qj().KQ = true;
            oy = this.IB.oy();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.IB.oZ().qh().ma() && oy != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(oy);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Iz.qh().mErrorString = TbadkCoreApplication.m255getInst().getApp().getApplicationContext().getString(com.baidu.tieba.z.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            if (nVar.getUser().getPassword() != null) {
                accountData.setPassword(nVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.mR() != null) {
                accountData.setTbs(nVar.mR().getTbs());
            }
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
            return nVar;
        }
        if (this.IB.pc()) {
            switch (this.IB.pd()) {
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

    public byte[] oz() {
        if (!this.Iz.qg().mIsFromCDN) {
            this.Iz.qg().b(this.IA);
        }
        return this.IA.oz();
    }

    private void pf() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ow = this.IA.ow();
        for (int i = 0; ow != null && i < ow.size(); i++) {
            BasicNameValuePair basicNameValuePair = ow.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.IA.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.z.toMd5(stringBuffer.toString()));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String bS(int i) {
        String oB;
        String str;
        switch (i) {
            case 1:
                if (oZ().qg().mIsNeedAddCommenParam) {
                    this.Iz.qg().b(this.IA);
                }
                pb();
                oB = this.IA.oA();
                break;
            case 2:
                if (oZ().qg().mIsUseCurrentBDUSS) {
                    oZ().qg().a(this.IA);
                }
                if (oZ().qg().mIsNeedAddCommenParam) {
                    this.Iz.qg().b(this.IA);
                }
                pb();
                oB = this.IA.oy();
                break;
            case 3:
                if (oZ().qg().mIsUseCurrentBDUSS) {
                    oZ().qg().a(this.IA);
                }
                if (oZ().qg().mIsNeedAddCommenParam) {
                    this.Iz.qg().b(this.IA);
                }
                pf();
                oB = this.IA.oB();
                break;
            default:
                return null;
        }
        if (oB == null && ak.IX == 1 && this.Iz.qh().KB != 404 && this.Iz.qh().KB < 500) {
            if (!this.IA.ox()) {
                this.IA = new ae(this.Iz);
                switch (i) {
                    case 1:
                        if (oZ().qg().mIsNeedAddCommenParam) {
                            this.Iz.qg().b(this.IA);
                        }
                        pb();
                        oB = this.IA.oA();
                        break;
                    case 2:
                        if (oZ().qg().mIsUseCurrentBDUSS) {
                            oZ().qg().a(this.IA);
                        }
                        if (oZ().qg().mIsNeedAddCommenParam) {
                            this.Iz.qg().b(this.IA);
                        }
                        pb();
                        oB = this.IA.oy();
                        break;
                    case 3:
                        if (oZ().qg().mIsUseCurrentBDUSS) {
                            oZ().qg().a(this.IA);
                        }
                        if (oZ().qg().mIsNeedAddCommenParam) {
                            this.Iz.qg().b(this.IA);
                        }
                        oB = this.IA.oB();
                        break;
                    default:
                        return null;
                }
                if (oB != null && this.Iz.qh().ma()) {
                    ak.pm();
                    str = oB;
                    if (this.Iz.qh().pc()) {
                        ao.a(this.IC);
                        ao.bY(this.IE);
                        return str;
                    } else if (!this.Iz.qh().ma() && this.Iz.qh().KC == 1 && this.Iz.qg().Kx) {
                        String str2 = this.Iz.qh().mErrorString;
                        this.Iz.qh().mErrorString = "";
                        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                        AccountData mk = currentAccountObj == null ? com.baidu.tbadk.core.account.a.mk() : currentAccountObj;
                        if (mk == null || TextUtils.isEmpty(mk.getAccount())) {
                            TbadkCoreApplication.m255getInst().handler.sendMessage(TbadkCoreApplication.m255getInst().handler.obtainMessage(1));
                            return null;
                        }
                        com.baidu.tbadk.core.account.a.bL(mk.getAccount());
                        if (ReloginManager.oe().oi()) {
                            AccountData oh = ReloginManager.oe().oh();
                            if (oh == null) {
                                ReloginManager.oe().d(oh);
                                return null;
                            }
                            return bT(i);
                        }
                        com.baidu.tbadk.core.data.n d = d(mk.getAccount(), mk.getPassword(), true);
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
                            if (this.IB != null) {
                                this.Iz.qh().mErrorString = this.IB.getErrorString();
                                return null;
                            }
                            this.Iz.qh().mErrorString = str2;
                            return str;
                        }
                        return bT(i);
                    } else {
                        return str;
                    }
                }
            } else {
                BdLog.d("手动取消网络请求");
            }
        }
        str = oB;
        if (this.Iz.qh().pc()) {
        }
    }

    private String bT(int i) {
        String oB;
        pa();
        switch (i) {
            case 1:
                oB = this.IA.oA();
                break;
            case 2:
                oB = this.IA.oy();
                break;
            case 3:
                oB = this.IA.oB();
                break;
            default:
                return null;
        }
        if (this.Iz.qh().pc()) {
            switch (this.Iz.qh().KC) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m255getInst().handler.sendMessage(TbadkCoreApplication.m255getInst().handler.obtainMessage(1));
                    this.Iz.qh().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return oB;
            }
        }
        return oB;
    }

    public String oy() {
        return bS(2);
    }

    public String oB() {
        return bS(3);
    }

    public String cx(String str) {
        byte[] bArr;
        try {
            InputStream cl = s.cl(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = cl.read(bArr2);
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
        return oB();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        oZ().qg().a(this.IA);
        return this.IA.a(str, handler, i, i2, i3, z);
    }
}
