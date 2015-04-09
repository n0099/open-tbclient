package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.a0;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.game.GameInfoData;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class aa {
    private com.baidu.tbadk.core.util.httpNet.a Uc = null;
    private s Ud = null;
    private aa Ue = null;
    private am Uf = null;
    private int Ug = 0;

    private void so() {
        this.Uc = new com.baidu.tbadk.core.util.httpNet.a();
        this.Ud = ah.sB().a(this.Uc);
        this.Ue = null;
        this.Uc.tp().ts().mNetType = com.baidu.tbadk.core.util.httpNet.g.getNetType();
        this.Uc.tp().ts().VX = this.Uc.tp().VX;
    }

    public com.baidu.tbadk.core.util.httpNet.a sp() {
        return this.Uc;
    }

    public aa() {
        so();
    }

    public aa(String str) {
        so();
        this.Uc.tp().ts().mUrl = str;
    }

    public void setUrl(String str) {
        this.Uc.tp().ts().mUrl = str;
    }

    public void o(ArrayList<BasicNameValuePair> arrayList) {
        this.Ud.o(arrayList);
    }

    public void o(String str, String str2) {
        this.Ud.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Ud.a(basicNameValuePair);
    }

    public void g(String str, byte[] bArr) {
        this.Ud.g(str, bArr);
    }

    private void sq() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> rM = this.Ud.rM();
            int size = rM.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = rM.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    rM.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    rM.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void sr() {
        if (this.Uf == null) {
            this.Uf = al.sI();
        }
        if (this.Uf != null) {
            this.Ud.o("stTime", String.valueOf(this.Uf.mTime));
            this.Ud.o("stSize", String.valueOf(this.Uf.mSize));
            this.Ud.o("stTimesNum", String.valueOf(this.Uf.UK));
            this.Ud.o("stMode", String.valueOf(this.Uf.mMode));
            this.Ud.o("stMethod", String.valueOf(this.Uf.UJ));
        }
        this.Ug = al.bY(0);
        if (this.Ug == 0 && this.Uf != null) {
            this.Ug = this.Uf.UK;
        }
        this.Ud.o("stErrorNums", String.valueOf(this.Ug));
    }

    public boolean ss() {
        return this.Uc.tq().ss();
    }

    public int st() {
        return this.Uc.tq().Wb;
    }

    public int su() {
        return this.Uc.tq().Wa;
    }

    public String getErrorString() {
        return this.Uc.tq().mErrorString;
    }

    public void hh() {
        if (this.Ud != null) {
            this.Ud.hh();
        }
        if (this.Ue != null) {
            this.Ue.hh();
        }
    }

    private com.baidu.tbadk.core.data.n d(String str, String str2, boolean z) {
        String rO;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.Ue == null) {
                this.Ue = new aa(sb.toString());
            } else {
                this.Ue.hh();
            }
            this.Ue.sp().tp().mIsNeedAddCommenParam = false;
            this.Ue.sp().tp().mIsUseCurrentBDUSS = false;
            this.Ue.sp().tp().VW = false;
            this.Ue.o("un", str);
            this.Ue.o("passwd", str2);
            this.Ue.o("isphone", GameInfoData.NOT_FROM_DETAIL);
            this.Ue.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.Ue.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.Ue.sp().tp().ts().Wr = true;
            rO = this.Ue.rO();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Ue.sp().tq().pv() && rO != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(rO);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Uc.tq().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.neterror);
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
            if (nVar.qe() != null) {
                accountData.setTbs(nVar.qe().getTbs());
            }
            com.baidu.tbadk.core.a.d.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return nVar;
        }
        if (this.Ue.ss()) {
            switch (this.Ue.st()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m411getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m411getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] rP() {
        if (!this.Uc.tp().mIsFromCDN) {
            this.Uc.tp().b(this.Ud);
        }
        return this.Ud.rP();
    }

    private void sv() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> rM = this.Ud.rM();
        for (int i = 0; rM != null && i < rM.size(); i++) {
            BasicNameValuePair basicNameValuePair = rM.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.Ud.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.ab.toMd5(stringBuffer.toString()));
    }

    private String bT(int i) {
        String rR;
        com.baidu.tbadk.coreExtra.act.l um;
        switch (i) {
            case 1:
                if (sp().tp().mIsNeedAddCommenParam) {
                    this.Uc.tp().b(this.Ud);
                }
                sr();
                rR = this.Ud.rQ();
                break;
            case 2:
                if (sp().tp().mIsUseCurrentBDUSS) {
                    sp().tp().a(this.Ud);
                }
                if (sp().tp().mIsNeedAddCommenParam) {
                    this.Uc.tp().b(this.Ud);
                }
                sr();
                rR = this.Ud.rO();
                break;
            case 3:
                if (sp().tp().mIsUseCurrentBDUSS) {
                    sp().tp().a(this.Ud);
                }
                if (sp().tp().mIsNeedAddCommenParam) {
                    this.Uc.tp().b(this.Ud);
                }
                sv();
                rR = this.Ud.rR();
                break;
            default:
                return null;
        }
        if (rR == null && ah.UC == 1 && this.Uc.tq().Wa != 404 && this.Uc.tq().Wa < 500) {
            if (!this.Ud.rN()) {
                this.Ud = new ab(this.Uc);
                switch (i) {
                    case 1:
                        if (sp().tp().mIsNeedAddCommenParam) {
                            this.Uc.tp().b(this.Ud);
                        }
                        sr();
                        rR = this.Ud.rQ();
                        break;
                    case 2:
                        if (sp().tp().mIsUseCurrentBDUSS) {
                            sp().tp().a(this.Ud);
                        }
                        if (sp().tp().mIsNeedAddCommenParam) {
                            this.Uc.tp().b(this.Ud);
                        }
                        sr();
                        rR = this.Ud.rO();
                        break;
                    case 3:
                        if (sp().tp().mIsUseCurrentBDUSS) {
                            sp().tp().a(this.Ud);
                        }
                        if (sp().tp().mIsNeedAddCommenParam) {
                            this.Uc.tp().b(this.Ud);
                        }
                        rR = this.Ud.rR();
                        break;
                    default:
                        return null;
                }
                if (rR != null && this.Uc.tq().pv()) {
                    ah.sC();
                }
            } else {
                BdLog.d("手动取消网络请求");
            }
        }
        if (!this.Uc.tq().ss()) {
            al.a(this.Uf);
            al.bZ(this.Ug);
            return rR;
        } else if (!this.Uc.tq().pv() && this.Uc.tq().Wb == 1 && this.Uc.tp().VW) {
            String str = this.Uc.tq().mErrorString;
            this.Uc.tq().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.d.pG();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.d.bP(currentAccountObj.getAccount());
            if (ReloginManager.rw().rA()) {
                AccountData rz = ReloginManager.rw().rz();
                if (rz == null) {
                    ReloginManager.rw().e(rz);
                    return null;
                }
                return bU(i);
            }
            com.baidu.tbadk.core.data.n d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (um = com.baidu.tbadk.coreExtra.act.a.um()) != null) {
                um.j(currentAccountObj);
            }
            if (d == null) {
                if (this.Ue != null) {
                    this.Uc.tq().mErrorString = this.Ue.getErrorString();
                    return null;
                }
                this.Uc.tq().mErrorString = str;
                return rR;
            }
            return bU(i);
        } else {
            return rR;
        }
    }

    private String bU(int i) {
        String rR;
        sq();
        switch (i) {
            case 1:
                rR = this.Ud.rQ();
                break;
            case 2:
                rR = this.Ud.rO();
                break;
            case 3:
                rR = this.Ud.rR();
                break;
            default:
                return null;
        }
        if (this.Uc.tq().ss()) {
            switch (this.Uc.tq().Wb) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.Uc.tq().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return rR;
            }
        }
        return rR;
    }

    public String rO() {
        return bT(2);
    }

    public String rR() {
        return bT(3);
    }

    public String cD(String str) {
        byte[] bArr;
        try {
            InputStream cq = o.cq(str);
            byte[] bArr2 = new byte[a0.O];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a0.O);
            while (true) {
                int read = cq.read(bArr2);
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
        return rR();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        sp().tp().a(this.Ud);
        return this.Ud.a(str, handler, i, i2, i3, z);
    }
}
