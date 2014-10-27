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
import com.baidu.tbadk.TbadkApplication;
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
public class ac {
    private com.baidu.tbadk.core.util.httpNet.e Ed = null;
    private u Ee = null;
    private ac Ef = null;
    private ao Eg = null;
    private int Eh = 0;

    private void mb() {
        this.Ed = new com.baidu.tbadk.core.util.httpNet.e();
        this.Ee = aj.mo().a(this.Ed);
        this.Ef = null;
        this.Ed.na().nd().mNetType = com.baidu.tbadk.core.util.httpNet.j.getNetType();
        this.Ed.na().nd().FU = this.Ed.na().FU;
    }

    public com.baidu.tbadk.core.util.httpNet.e mc() {
        return this.Ed;
    }

    public ac() {
        mb();
    }

    public ac(String str) {
        mb();
        this.Ed.na().nd().mUrl = str;
    }

    public void setUrl(String str) {
        this.Ed.na().nd().mUrl = str;
    }

    public void h(ArrayList<BasicNameValuePair> arrayList) {
        this.Ee.h(arrayList);
    }

    public void k(String str, String str2) {
        this.Ee.k(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Ee.a(basicNameValuePair);
    }

    public void e(String str, byte[] bArr) {
        this.Ee.e(str, bArr);
    }

    private void md() {
        String currentBduss = TbadkApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkApplication.m251getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ly = this.Ee.ly();
            int size = ly.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = ly.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    ly.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    ly.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void me() {
        if (this.Eg == null) {
            this.Eg = an.mv();
        }
        if (this.Eg != null) {
            this.Ee.k("stTime", String.valueOf(this.Eg.mTime));
            this.Ee.k("stSize", String.valueOf(this.Eg.mSize));
            this.Ee.k("stTimesNum", String.valueOf(this.Eg.EJ));
            this.Ee.k("stMode", String.valueOf(this.Eg.mMode));
            this.Ee.k("stMethod", String.valueOf(this.Eg.EI));
        }
        this.Eh = an.bv(0);
        if (this.Eh == 0 && this.Eg != null) {
            this.Eh = this.Eg.EJ;
        }
        this.Ee.k("stErrorNums", String.valueOf(this.Eh));
    }

    public boolean mf() {
        return this.Ed.nb().mf();
    }

    public int mg() {
        return this.Ed.nb().FY;
    }

    public int mh() {
        return this.Ed.nb().FX;
    }

    public String getErrorString() {
        return this.Ed.nb().mErrorString;
    }

    public void dM() {
        if (this.Ee != null) {
            this.Ee.dM();
        }
        if (this.Ef != null) {
            this.Ef.dM();
        }
    }

    private com.baidu.tbadk.core.data.j b(String str, String str2, boolean z) {
        String lA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkApplication.setCurrentAccount(null, TbadkApplication.m251getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.Ef == null) {
                this.Ef = new ac(sb.toString());
            } else {
                this.Ef.dM();
            }
            this.Ef.mc().na().mIsNeedAddCommenParam = false;
            this.Ef.mc().na().mIsUseCurrentBDUSS = false;
            this.Ef.mc().na().FT = false;
            this.Ef.k("un", str);
            this.Ef.k("passwd", str2);
            this.Ef.k("isphone", "0");
            this.Ef.k("channel_id", TbadkApplication.m251getInst().getPushChannelId());
            this.Ef.k("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId());
            this.Ef.mc().na().nd().Gl = true;
            lA = this.Ef.lA();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Ef.mc().nb().jq() && lA != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.parserJson(lA);
            String userId = jVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Ed.nb().mErrorString = TbadkApplication.m251getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(jVar.getUser().getUserName());
            if (jVar.getUser().getPassword() != null) {
                accountData.setPassword(jVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(jVar.getUser().getUserId());
            accountData.setBDUSS(jVar.getUser().getBDUSS());
            accountData.setPortrait(jVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (jVar.jZ() != null) {
                accountData.setTbs(jVar.jZ().getTbs());
            }
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkApplication.setCurrentAccount(accountData, TbadkApplication.m251getInst().getApp().getApplicationContext());
            return jVar;
        }
        if (this.Ef.mf()) {
            switch (this.Ef.mg()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkApplication.m251getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkApplication.m251getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] lB() {
        if (!this.Ed.na().mIsFromCDN) {
            this.Ed.na().b(this.Ee);
        }
        return this.Ee.lB();
    }

    private void mi() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ly = this.Ee.ly();
        for (int i = 0; ly != null && i < ly.size(); i++) {
            BasicNameValuePair basicNameValuePair = ly.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.Ee.k(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.u.aE(stringBuffer.toString()));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String bq(int i) {
        String lD;
        String str;
        switch (i) {
            case 1:
                if (mc().na().mIsNeedAddCommenParam) {
                    this.Ed.na().b(this.Ee);
                }
                me();
                lD = this.Ee.lC();
                break;
            case 2:
                if (mc().na().mIsUseCurrentBDUSS) {
                    mc().na().a(this.Ee);
                }
                if (mc().na().mIsNeedAddCommenParam) {
                    this.Ed.na().b(this.Ee);
                }
                me();
                lD = this.Ee.lA();
                break;
            case 3:
                if (mc().na().mIsUseCurrentBDUSS) {
                    mc().na().a(this.Ee);
                }
                if (mc().na().mIsNeedAddCommenParam) {
                    this.Ed.na().b(this.Ee);
                }
                mi();
                lD = this.Ee.lD();
                break;
            default:
                return null;
        }
        if (lD == null && aj.EB == 1 && this.Ed.nb().FX != 404 && this.Ed.nb().FX < 500) {
            if (!this.Ee.lz()) {
                this.Ee = new ad(this.Ed);
                switch (i) {
                    case 1:
                        if (mc().na().mIsNeedAddCommenParam) {
                            this.Ed.na().b(this.Ee);
                        }
                        me();
                        lD = this.Ee.lC();
                        break;
                    case 2:
                        if (mc().na().mIsUseCurrentBDUSS) {
                            mc().na().a(this.Ee);
                        }
                        if (mc().na().mIsNeedAddCommenParam) {
                            this.Ed.na().b(this.Ee);
                        }
                        me();
                        lD = this.Ee.lA();
                        break;
                    case 3:
                        if (mc().na().mIsUseCurrentBDUSS) {
                            mc().na().a(this.Ee);
                        }
                        if (mc().na().mIsNeedAddCommenParam) {
                            this.Ed.na().b(this.Ee);
                        }
                        lD = this.Ee.lD();
                        break;
                    default:
                        return null;
                }
                if (lD != null && this.Ed.nb().jq()) {
                    aj.mp();
                    str = lD;
                    if (this.Ed.nb().mf()) {
                        an.a(this.Eg);
                        an.bw(this.Eh);
                        return str;
                    } else if (!this.Ed.nb().jq() && this.Ed.nb().FY == 1 && this.Ed.na().FT) {
                        String str2 = this.Ed.nb().mErrorString;
                        this.Ed.nb().mErrorString = "";
                        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                        AccountData jA = currentAccountObj == null ? com.baidu.tbadk.core.account.a.jA() : currentAccountObj;
                        if (jA == null || TextUtils.isEmpty(jA.getAccount())) {
                            TbadkApplication.m251getInst().handler.sendMessage(TbadkApplication.m251getInst().handler.obtainMessage(1));
                            return null;
                        }
                        com.baidu.tbadk.core.account.a.aW(jA.getAccount());
                        if (ReloginManager.lf().lj()) {
                            AccountData li = ReloginManager.lf().li();
                            if (li == null) {
                                ReloginManager.lf().d(li);
                                return null;
                            }
                            return br(i);
                        }
                        com.baidu.tbadk.core.data.j b = b(jA.getAccount(), jA.getPassword(), true);
                        if (!TextUtils.isEmpty(jA.getID())) {
                            if (jA.getID().equals(TbadkApplication.getCurrentAccount())) {
                                SapiAccountManager.getInstance().logout();
                            } else {
                                List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
                                if (loginAccounts != null && loginAccounts.size() > 0) {
                                    Iterator<SapiAccount> it = loginAccounts.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            SapiAccount next = it.next();
                                            if (jA.getID().equals(next.uid)) {
                                                SapiAccountManager.getInstance().removeLoginAccount(next);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (b == null) {
                            if (this.Ef != null) {
                                this.Ed.nb().mErrorString = this.Ef.getErrorString();
                                return null;
                            }
                            this.Ed.nb().mErrorString = str2;
                            return str;
                        }
                        return br(i);
                    } else {
                        return str;
                    }
                }
            } else {
                BdLog.d("手动取消网络请求");
            }
        }
        str = lD;
        if (this.Ed.nb().mf()) {
        }
    }

    private String br(int i) {
        String lD;
        md();
        switch (i) {
            case 1:
                lD = this.Ee.lC();
                break;
            case 2:
                lD = this.Ee.lA();
                break;
            case 3:
                lD = this.Ee.lD();
                break;
            default:
                return null;
        }
        if (this.Ed.nb().mf()) {
            switch (this.Ed.nb().FY) {
                case 1:
                case 2:
                case 5:
                    TbadkApplication.m251getInst().handler.sendMessage(TbadkApplication.m251getInst().handler.obtainMessage(1));
                    this.Ed.nb().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return lD;
            }
        }
        return lD;
    }

    public String lA() {
        return bq(2);
    }

    public String lD() {
        return bq(3);
    }

    public String bG(String str) {
        byte[] bArr;
        try {
            InputStream bv = s.bv(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = bv.read(bArr2);
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
        e("pic", bArr);
        return lD();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        mc().na().a(this.Ee);
        return this.Ee.a(str, handler, i, i2, i3, z);
    }
}
