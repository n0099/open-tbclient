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
    private com.baidu.tbadk.core.util.httpNet.a Ua = null;
    private s Ub = null;
    private aa Uc = null;
    private am Ud = null;
    private int Ue = 0;

    private void so() {
        this.Ua = new com.baidu.tbadk.core.util.httpNet.a();
        this.Ub = ah.sB().a(this.Ua);
        this.Uc = null;
        this.Ua.tp().ts().mNetType = com.baidu.tbadk.core.util.httpNet.g.getNetType();
        this.Ua.tp().ts().VV = this.Ua.tp().VV;
    }

    public com.baidu.tbadk.core.util.httpNet.a sp() {
        return this.Ua;
    }

    public aa() {
        so();
    }

    public aa(String str) {
        so();
        this.Ua.tp().ts().mUrl = str;
    }

    public void setUrl(String str) {
        this.Ua.tp().ts().mUrl = str;
    }

    public void o(ArrayList<BasicNameValuePair> arrayList) {
        this.Ub.o(arrayList);
    }

    public void o(String str, String str2) {
        this.Ub.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Ub.a(basicNameValuePair);
    }

    public void g(String str, byte[] bArr) {
        this.Ub.g(str, bArr);
    }

    private void sq() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> rM = this.Ub.rM();
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
        if (this.Ud == null) {
            this.Ud = al.sI();
        }
        if (this.Ud != null) {
            this.Ub.o("stTime", String.valueOf(this.Ud.mTime));
            this.Ub.o("stSize", String.valueOf(this.Ud.mSize));
            this.Ub.o("stTimesNum", String.valueOf(this.Ud.UI));
            this.Ub.o("stMode", String.valueOf(this.Ud.mMode));
            this.Ub.o("stMethod", String.valueOf(this.Ud.UH));
        }
        this.Ue = al.bY(0);
        if (this.Ue == 0 && this.Ud != null) {
            this.Ue = this.Ud.UI;
        }
        this.Ub.o("stErrorNums", String.valueOf(this.Ue));
    }

    public boolean ss() {
        return this.Ua.tq().ss();
    }

    public int st() {
        return this.Ua.tq().VZ;
    }

    public int su() {
        return this.Ua.tq().VY;
    }

    public String getErrorString() {
        return this.Ua.tq().mErrorString;
    }

    public void hh() {
        if (this.Ub != null) {
            this.Ub.hh();
        }
        if (this.Uc != null) {
            this.Uc.hh();
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
            if (this.Uc == null) {
                this.Uc = new aa(sb.toString());
            } else {
                this.Uc.hh();
            }
            this.Uc.sp().tp().mIsNeedAddCommenParam = false;
            this.Uc.sp().tp().mIsUseCurrentBDUSS = false;
            this.Uc.sp().tp().VU = false;
            this.Uc.o("un", str);
            this.Uc.o("passwd", str2);
            this.Uc.o("isphone", GameInfoData.NOT_FROM_DETAIL);
            this.Uc.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.Uc.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.Uc.sp().tp().ts().Wp = true;
            rO = this.Uc.rO();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.Uc.sp().tq().pv() && rO != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(rO);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.Ua.tq().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.neterror);
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
        if (this.Uc.ss()) {
            switch (this.Uc.st()) {
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
        if (!this.Ua.tp().mIsFromCDN) {
            this.Ua.tp().b(this.Ub);
        }
        return this.Ub.rP();
    }

    private void sv() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> rM = this.Ub.rM();
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
        this.Ub.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.ab.toMd5(stringBuffer.toString()));
    }

    private String bT(int i) {
        String rR;
        com.baidu.tbadk.coreExtra.act.l um;
        switch (i) {
            case 1:
                if (sp().tp().mIsNeedAddCommenParam) {
                    this.Ua.tp().b(this.Ub);
                }
                sr();
                rR = this.Ub.rQ();
                break;
            case 2:
                if (sp().tp().mIsUseCurrentBDUSS) {
                    sp().tp().a(this.Ub);
                }
                if (sp().tp().mIsNeedAddCommenParam) {
                    this.Ua.tp().b(this.Ub);
                }
                sr();
                rR = this.Ub.rO();
                break;
            case 3:
                if (sp().tp().mIsUseCurrentBDUSS) {
                    sp().tp().a(this.Ub);
                }
                if (sp().tp().mIsNeedAddCommenParam) {
                    this.Ua.tp().b(this.Ub);
                }
                sv();
                rR = this.Ub.rR();
                break;
            default:
                return null;
        }
        if (rR == null && ah.Uz == 1 && this.Ua.tq().VY != 404 && this.Ua.tq().VY < 500) {
            if (!this.Ub.rN()) {
                this.Ub = new ab(this.Ua);
                switch (i) {
                    case 1:
                        if (sp().tp().mIsNeedAddCommenParam) {
                            this.Ua.tp().b(this.Ub);
                        }
                        sr();
                        rR = this.Ub.rQ();
                        break;
                    case 2:
                        if (sp().tp().mIsUseCurrentBDUSS) {
                            sp().tp().a(this.Ub);
                        }
                        if (sp().tp().mIsNeedAddCommenParam) {
                            this.Ua.tp().b(this.Ub);
                        }
                        sr();
                        rR = this.Ub.rO();
                        break;
                    case 3:
                        if (sp().tp().mIsUseCurrentBDUSS) {
                            sp().tp().a(this.Ub);
                        }
                        if (sp().tp().mIsNeedAddCommenParam) {
                            this.Ua.tp().b(this.Ub);
                        }
                        rR = this.Ub.rR();
                        break;
                    default:
                        return null;
                }
                if (rR != null && this.Ua.tq().pv()) {
                    ah.sC();
                }
            } else {
                BdLog.d("手动取消网络请求");
            }
        }
        if (!this.Ua.tq().ss()) {
            al.a(this.Ud);
            al.bZ(this.Ue);
            return rR;
        } else if (!this.Ua.tq().pv() && this.Ua.tq().VZ == 1 && this.Ua.tp().VU) {
            String str = this.Ua.tq().mErrorString;
            this.Ua.tq().mErrorString = "";
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
                if (this.Uc != null) {
                    this.Ua.tq().mErrorString = this.Uc.getErrorString();
                    return null;
                }
                this.Ua.tq().mErrorString = str;
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
                rR = this.Ub.rQ();
                break;
            case 2:
                rR = this.Ub.rO();
                break;
            case 3:
                rR = this.Ub.rR();
                break;
            default:
                return null;
        }
        if (this.Ua.tq().ss()) {
            switch (this.Ua.tq().VZ) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.Ua.tq().mErrorString = "";
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
        sp().tp().a(this.Ub);
        return this.Ub.a(str, handler, i, i2, i3, z);
    }
}
