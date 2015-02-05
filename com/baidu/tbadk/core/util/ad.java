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
    private com.baidu.tbadk.core.util.httpNet.c Iw = null;
    private v Ix = null;
    private ad Iy = null;
    private ap Iz = null;
    private int IA = 0;

    private void oR() {
        this.Iw = new com.baidu.tbadk.core.util.httpNet.c();
        this.Ix = ak.pe().a(this.Iw);
        this.Iy = null;
        this.Iw.pZ().qc().mNetType = com.baidu.tbadk.core.util.httpNet.h.getNetType();
        this.Iw.pZ().qc().Kv = this.Iw.pZ().Kv;
    }

    public com.baidu.tbadk.core.util.httpNet.c oS() {
        return this.Iw;
    }

    public ad() {
        oR();
    }

    public ad(String str) {
        oR();
        this.Iw.pZ().qc().mUrl = str;
    }

    public void setUrl(String str) {
        this.Iw.pZ().qc().mUrl = str;
    }

    public void r(ArrayList<BasicNameValuePair> arrayList) {
        this.Ix.r(arrayList);
    }

    public void o(String str, String str2) {
        this.Ix.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Ix.a(basicNameValuePair);
    }

    public void g(String str, byte[] bArr) {
        this.Ix.g(str, bArr);
    }

    private void oT() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m255getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> op = this.Ix.op();
            int size = op.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = op.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    op.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    op.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void oU() {
        if (this.Iz == null) {
            this.Iz = ao.pl();
        }
        if (this.Iz != null) {
            this.Ix.o("stTime", String.valueOf(this.Iz.mTime));
            this.Ix.o("stSize", String.valueOf(this.Iz.mSize));
            this.Ix.o("stTimesNum", String.valueOf(this.Iz.Jc));
            this.Ix.o("stMode", String.valueOf(this.Iz.mMode));
            this.Ix.o("stMethod", String.valueOf(this.Iz.Jb));
        }
        this.IA = ao.bX(0);
        if (this.IA == 0 && this.Iz != null) {
            this.IA = this.Iz.Jc;
        }
        this.Ix.o("stErrorNums", String.valueOf(this.IA));
    }

    public boolean oV() {
        return this.Iw.qa().oV();
    }

    public int oW() {
        return this.Iw.qa().Kz;
    }

    public int oX() {
        return this.Iw.qa().Ky;
    }

    public String getErrorString() {
        return this.Iw.qa().mErrorString;
    }

    public void dJ() {
        if (this.Ix != null) {
            this.Ix.dJ();
        }
        if (this.Iy != null) {
            this.Iy.dJ();
        }
    }

    private com.baidu.tbadk.core.data.n d(String str, String str2, boolean z) {
        String or;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.Iy == null) {
                this.Iy = new ad(sb.toString());
            } else {
                this.Iy.dJ();
            }
            this.Iy.oS().pZ().mIsNeedAddCommenParam = false;
            this.Iy.oS().pZ().mIsUseCurrentBDUSS = false;
            this.Iy.oS().pZ().Ku = false;
            this.Iy.o("un", str);
            this.Iy.o("passwd", str2);
            this.Iy.o("isphone", "0");
            this.Iy.o("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId());
            this.Iy.o("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId());
            this.Iy.oS().pZ().qc().KN = true;
            or = this.Iy.or();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Iy.oS().qa().lT() && or != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(or);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Iw.qa().mErrorString = TbadkCoreApplication.m255getInst().getApp().getApplicationContext().getString(com.baidu.tieba.z.neterror);
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
            if (nVar.mK() != null) {
                accountData.setTbs(nVar.mK().getTbs());
            }
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
            return nVar;
        }
        if (this.Iy.oV()) {
            switch (this.Iy.oW()) {
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

    public byte[] os() {
        if (!this.Iw.pZ().mIsFromCDN) {
            this.Iw.pZ().b(this.Ix);
        }
        return this.Ix.os();
    }

    private void oY() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> op = this.Ix.op();
        for (int i = 0; op != null && i < op.size(); i++) {
            BasicNameValuePair basicNameValuePair = op.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.Ix.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.z.toMd5(stringBuffer.toString()));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String bS(int i) {
        String ou;
        String str;
        switch (i) {
            case 1:
                if (oS().pZ().mIsNeedAddCommenParam) {
                    this.Iw.pZ().b(this.Ix);
                }
                oU();
                ou = this.Ix.ot();
                break;
            case 2:
                if (oS().pZ().mIsUseCurrentBDUSS) {
                    oS().pZ().a(this.Ix);
                }
                if (oS().pZ().mIsNeedAddCommenParam) {
                    this.Iw.pZ().b(this.Ix);
                }
                oU();
                ou = this.Ix.or();
                break;
            case 3:
                if (oS().pZ().mIsUseCurrentBDUSS) {
                    oS().pZ().a(this.Ix);
                }
                if (oS().pZ().mIsNeedAddCommenParam) {
                    this.Iw.pZ().b(this.Ix);
                }
                oY();
                ou = this.Ix.ou();
                break;
            default:
                return null;
        }
        if (ou == null && ak.IU == 1 && this.Iw.qa().Ky != 404 && this.Iw.qa().Ky < 500) {
            if (!this.Ix.oq()) {
                this.Ix = new ae(this.Iw);
                switch (i) {
                    case 1:
                        if (oS().pZ().mIsNeedAddCommenParam) {
                            this.Iw.pZ().b(this.Ix);
                        }
                        oU();
                        ou = this.Ix.ot();
                        break;
                    case 2:
                        if (oS().pZ().mIsUseCurrentBDUSS) {
                            oS().pZ().a(this.Ix);
                        }
                        if (oS().pZ().mIsNeedAddCommenParam) {
                            this.Iw.pZ().b(this.Ix);
                        }
                        oU();
                        ou = this.Ix.or();
                        break;
                    case 3:
                        if (oS().pZ().mIsUseCurrentBDUSS) {
                            oS().pZ().a(this.Ix);
                        }
                        if (oS().pZ().mIsNeedAddCommenParam) {
                            this.Iw.pZ().b(this.Ix);
                        }
                        ou = this.Ix.ou();
                        break;
                    default:
                        return null;
                }
                if (ou != null && this.Iw.qa().lT()) {
                    ak.pf();
                    str = ou;
                    if (this.Iw.qa().oV()) {
                        ao.a(this.Iz);
                        ao.bY(this.IA);
                        return str;
                    } else if (!this.Iw.qa().lT() && this.Iw.qa().Kz == 1 && this.Iw.pZ().Ku) {
                        String str2 = this.Iw.qa().mErrorString;
                        this.Iw.qa().mErrorString = "";
                        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                        AccountData md = currentAccountObj == null ? com.baidu.tbadk.core.account.a.md() : currentAccountObj;
                        if (md == null || TextUtils.isEmpty(md.getAccount())) {
                            TbadkCoreApplication.m255getInst().handler.sendMessage(TbadkCoreApplication.m255getInst().handler.obtainMessage(1));
                            return null;
                        }
                        com.baidu.tbadk.core.account.a.bI(md.getAccount());
                        if (ReloginManager.nX().ob()) {
                            AccountData oa = ReloginManager.nX().oa();
                            if (oa == null) {
                                ReloginManager.nX().d(oa);
                                return null;
                            }
                            return bT(i);
                        }
                        com.baidu.tbadk.core.data.n d = d(md.getAccount(), md.getPassword(), true);
                        if (!TextUtils.isEmpty(md.getID())) {
                            if (md.getID().equals(TbadkCoreApplication.getCurrentAccount())) {
                                SapiAccountManager.getInstance().logout();
                            } else {
                                List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
                                if (loginAccounts != null && loginAccounts.size() > 0) {
                                    Iterator<SapiAccount> it = loginAccounts.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            SapiAccount next = it.next();
                                            if (md.getID().equals(next.uid)) {
                                                SapiAccountManager.getInstance().removeLoginAccount(next);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (d == null) {
                            if (this.Iy != null) {
                                this.Iw.qa().mErrorString = this.Iy.getErrorString();
                                return null;
                            }
                            this.Iw.qa().mErrorString = str2;
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
        str = ou;
        if (this.Iw.qa().oV()) {
        }
    }

    private String bT(int i) {
        String ou;
        oT();
        switch (i) {
            case 1:
                ou = this.Ix.ot();
                break;
            case 2:
                ou = this.Ix.or();
                break;
            case 3:
                ou = this.Ix.ou();
                break;
            default:
                return null;
        }
        if (this.Iw.qa().oV()) {
            switch (this.Iw.qa().Kz) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m255getInst().handler.sendMessage(TbadkCoreApplication.m255getInst().handler.obtainMessage(1));
                    this.Iw.qa().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return ou;
            }
        }
        return ou;
    }

    public String or() {
        return bS(2);
    }

    public String ou() {
        return bS(3);
    }

    public String cu(String str) {
        byte[] bArr;
        try {
            InputStream ci = s.ci(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = ci.read(bArr2);
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
        return ou();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        oS().pZ().a(this.Ix);
        return this.Ix.a(str, handler, i, i2, i3, z);
    }
}
