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
    private com.baidu.tbadk.core.util.httpNet.e Ee = null;
    private u Ef = null;
    private ac Eg = null;
    private ao Eh = null;
    private int Ei = 0;

    private void mb() {
        this.Ee = new com.baidu.tbadk.core.util.httpNet.e();
        this.Ef = aj.mo().a(this.Ee);
        this.Eg = null;
        this.Ee.na().nd().mNetType = com.baidu.tbadk.core.util.httpNet.j.getNetType();
        this.Ee.na().nd().FV = this.Ee.na().FV;
    }

    public com.baidu.tbadk.core.util.httpNet.e mc() {
        return this.Ee;
    }

    public ac() {
        mb();
    }

    public ac(String str) {
        mb();
        this.Ee.na().nd().mUrl = str;
    }

    public void setUrl(String str) {
        this.Ee.na().nd().mUrl = str;
    }

    public void h(ArrayList<BasicNameValuePair> arrayList) {
        this.Ef.h(arrayList);
    }

    public void k(String str, String str2) {
        this.Ef.k(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Ef.a(basicNameValuePair);
    }

    public void e(String str, byte[] bArr) {
        this.Ef.e(str, bArr);
    }

    private void md() {
        String currentBduss = TbadkApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkApplication.m251getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> ly = this.Ef.ly();
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
        if (this.Eh == null) {
            this.Eh = an.mv();
        }
        if (this.Eh != null) {
            this.Ef.k("stTime", String.valueOf(this.Eh.mTime));
            this.Ef.k("stSize", String.valueOf(this.Eh.mSize));
            this.Ef.k("stTimesNum", String.valueOf(this.Eh.EK));
            this.Ef.k("stMode", String.valueOf(this.Eh.mMode));
            this.Ef.k("stMethod", String.valueOf(this.Eh.EJ));
        }
        this.Ei = an.bv(0);
        if (this.Ei == 0 && this.Eh != null) {
            this.Ei = this.Eh.EK;
        }
        this.Ef.k("stErrorNums", String.valueOf(this.Ei));
    }

    public boolean mf() {
        return this.Ee.nb().mf();
    }

    public int mg() {
        return this.Ee.nb().FZ;
    }

    public int mh() {
        return this.Ee.nb().FY;
    }

    public String getErrorString() {
        return this.Ee.nb().mErrorString;
    }

    public void dM() {
        if (this.Ef != null) {
            this.Ef.dM();
        }
        if (this.Eg != null) {
            this.Eg.dM();
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
            if (this.Eg == null) {
                this.Eg = new ac(sb.toString());
            } else {
                this.Eg.dM();
            }
            this.Eg.mc().na().mIsNeedAddCommenParam = false;
            this.Eg.mc().na().mIsUseCurrentBDUSS = false;
            this.Eg.mc().na().FU = false;
            this.Eg.k("un", str);
            this.Eg.k("passwd", str2);
            this.Eg.k("isphone", "0");
            this.Eg.k("channel_id", TbadkApplication.m251getInst().getPushChannelId());
            this.Eg.k("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId());
            this.Eg.mc().na().nd().Gm = true;
            lA = this.Eg.lA();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Eg.mc().nb().jq() && lA != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.parserJson(lA);
            String userId = jVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Ee.nb().mErrorString = TbadkApplication.m251getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.neterror);
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
        if (this.Eg.mf()) {
            switch (this.Eg.mg()) {
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
        if (!this.Ee.na().mIsFromCDN) {
            this.Ee.na().b(this.Ef);
        }
        return this.Ef.lB();
    }

    private void mi() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> ly = this.Ef.ly();
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
        this.Ef.k(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.u.aE(stringBuffer.toString()));
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
                    this.Ee.na().b(this.Ef);
                }
                me();
                lD = this.Ef.lC();
                break;
            case 2:
                if (mc().na().mIsUseCurrentBDUSS) {
                    mc().na().a(this.Ef);
                }
                if (mc().na().mIsNeedAddCommenParam) {
                    this.Ee.na().b(this.Ef);
                }
                me();
                lD = this.Ef.lA();
                break;
            case 3:
                if (mc().na().mIsUseCurrentBDUSS) {
                    mc().na().a(this.Ef);
                }
                if (mc().na().mIsNeedAddCommenParam) {
                    this.Ee.na().b(this.Ef);
                }
                mi();
                lD = this.Ef.lD();
                break;
            default:
                return null;
        }
        if (lD == null && aj.EC == 1 && this.Ee.nb().FY != 404 && this.Ee.nb().FY < 500) {
            if (!this.Ef.lz()) {
                this.Ef = new ad(this.Ee);
                switch (i) {
                    case 1:
                        if (mc().na().mIsNeedAddCommenParam) {
                            this.Ee.na().b(this.Ef);
                        }
                        me();
                        lD = this.Ef.lC();
                        break;
                    case 2:
                        if (mc().na().mIsUseCurrentBDUSS) {
                            mc().na().a(this.Ef);
                        }
                        if (mc().na().mIsNeedAddCommenParam) {
                            this.Ee.na().b(this.Ef);
                        }
                        me();
                        lD = this.Ef.lA();
                        break;
                    case 3:
                        if (mc().na().mIsUseCurrentBDUSS) {
                            mc().na().a(this.Ef);
                        }
                        if (mc().na().mIsNeedAddCommenParam) {
                            this.Ee.na().b(this.Ef);
                        }
                        lD = this.Ef.lD();
                        break;
                    default:
                        return null;
                }
                if (lD != null && this.Ee.nb().jq()) {
                    aj.mp();
                    str = lD;
                    if (this.Ee.nb().mf()) {
                        an.a(this.Eh);
                        an.bw(this.Ei);
                        return str;
                    } else if (!this.Ee.nb().jq() && this.Ee.nb().FZ == 1 && this.Ee.na().FU) {
                        String str2 = this.Ee.nb().mErrorString;
                        this.Ee.nb().mErrorString = "";
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
                            if (this.Eg != null) {
                                this.Ee.nb().mErrorString = this.Eg.getErrorString();
                                return null;
                            }
                            this.Ee.nb().mErrorString = str2;
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
        if (this.Ee.nb().mf()) {
        }
    }

    private String br(int i) {
        String lD;
        md();
        switch (i) {
            case 1:
                lD = this.Ef.lC();
                break;
            case 2:
                lD = this.Ef.lA();
                break;
            case 3:
                lD = this.Ef.lD();
                break;
            default:
                return null;
        }
        if (this.Ee.nb().mf()) {
            switch (this.Ee.nb().FZ) {
                case 1:
                case 2:
                case 5:
                    TbadkApplication.m251getInst().handler.sendMessage(TbadkApplication.m251getInst().handler.obtainMessage(1));
                    this.Ee.nb().mErrorString = "";
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
        mc().na().a(this.Ef);
        return this.Ef.a(str, handler, i, i2, i3, z);
    }
}
