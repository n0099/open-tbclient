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
    private com.baidu.tbadk.core.util.httpNet.a UM = null;
    private s UN = null;
    private aa UO = null;
    private aj UQ = null;
    private int UR = 0;

    private void sW() {
        this.UM = new com.baidu.tbadk.core.util.httpNet.a();
        this.UN = ae.tf().a(this.UM);
        this.UO = null;
        this.UM.tS().tV().mNetType = com.baidu.tbadk.core.util.httpNet.g.getNetType();
        this.UM.tS().tV().WE = this.UM.tS().WE;
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.httpNet.a sX() {
        return this.UM;
    }

    public aa() {
        sW();
    }

    public aa(String str) {
        sW();
        this.UM.tS().tV().mUrl = str;
    }

    public void setUrl(String str) {
        this.UM.tS().tV().mUrl = str;
    }

    public void n(ArrayList<BasicNameValuePair> arrayList) {
        this.UN.n(arrayList);
    }

    public void o(String str, String str2) {
        this.UN.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.UN.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.UN.d(str, bArr);
    }

    private void sY() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> sv = this.UN.sv();
            int size = sv.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = sv.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    sv.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    sv.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void sZ() {
        if (this.UQ == null) {
            this.UQ = ai.tl();
        }
        if (this.UQ != null) {
            this.UN.o("stTime", String.valueOf(this.UQ.mTime));
            this.UN.o("stSize", String.valueOf(this.UQ.mSize));
            this.UN.o("stTimesNum", String.valueOf(this.UQ.Vm));
            this.UN.o("stMode", String.valueOf(this.UQ.mMode));
            this.UN.o("stMethod", String.valueOf(this.UQ.Vl));
        }
        this.UR = ai.cb(0);
        if (this.UR == 0 && this.UQ != null) {
            this.UR = this.UQ.Vm;
        }
        this.UN.o("stErrorNums", String.valueOf(this.UR));
    }

    public boolean ta() {
        return this.UM.tT().ta();
    }

    public int tb() {
        return this.UM.tT().WI;
    }

    public int tc() {
        return this.UM.tT().WH;
    }

    public String getErrorString() {
        return this.UM.tT().mErrorString;
    }

    public void gS() {
        if (this.UN != null) {
            this.UN.gS();
        }
        if (this.UO != null) {
            this.UO.gS();
        }
    }

    private com.baidu.tbadk.core.data.n d(String str, String str2, boolean z) {
        String sw;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.UO == null) {
                this.UO = new aa(sb.toString());
            } else {
                this.UO.gS();
            }
            this.UO.sX().tS().mIsNeedAddCommenParam = false;
            this.UO.sX().tS().mIsUseCurrentBDUSS = false;
            this.UO.sX().tS().WD = false;
            this.UO.o("un", str);
            this.UO.o("passwd", str2);
            this.UO.o("isphone", GameInfoData.NOT_FROM_DETAIL);
            this.UO.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.UO.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.UO.sX().tS().tV().Xd = true;
            sw = this.UO.sw();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.UO.sX().tT().qa() && sw != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.parserJson(sw);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.UM.tT().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(com.baidu.tieba.t.neterror);
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
            if (nVar.qK() != null) {
                accountData.setTbs(nVar.qK().getTbs());
            }
            com.baidu.tbadk.core.a.d.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return nVar;
        }
        if (this.UO.ta()) {
            switch (this.UO.tb()) {
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

    public byte[] sx() {
        if (!this.UM.tS().mIsFromCDN) {
            this.UM.tS().b(this.UN);
        }
        return this.UN.sx();
    }

    private void td() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> sv = this.UN.sv();
        for (int i = 0; sv != null && i < sv.size(); i++) {
            BasicNameValuePair basicNameValuePair = sv.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.UN.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.ac.toMd5(stringBuffer.toString()));
    }

    private String bW(int i) {
        String sz;
        com.baidu.tbadk.coreExtra.act.l uV;
        switch (i) {
            case 1:
                if (sX().tS().mIsNeedAddCommenParam) {
                    this.UM.tS().b(this.UN);
                }
                sZ();
                sz = this.UN.sy();
                break;
            case 2:
                if (sX().tS().mIsUseCurrentBDUSS) {
                    sX().tS().a(this.UN);
                }
                if (sX().tS().mIsNeedAddCommenParam) {
                    this.UM.tS().b(this.UN);
                }
                sZ();
                sz = this.UN.sw();
                break;
            case 3:
                if (sX().tS().mIsUseCurrentBDUSS) {
                    sX().tS().a(this.UN);
                }
                if (sX().tS().mIsNeedAddCommenParam) {
                    this.UM.tS().b(this.UN);
                }
                td();
                sz = this.UN.sz();
                break;
            default:
                return null;
        }
        if (!this.UM.tT().ta()) {
            ai.a(this.UQ);
            ai.cc(this.UR);
            return sz;
        } else if (!this.UM.tT().qa() && this.UM.tT().WI == 1 && this.UM.tS().WD) {
            String str = this.UM.tT().mErrorString;
            this.UM.tT().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.d.qm();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.d.cc(currentAccountObj.getAccount());
            if (ReloginManager.sg().sk()) {
                AccountData sj = ReloginManager.sg().sj();
                if (sj == null) {
                    ReloginManager.sg().e(sj);
                    return null;
                }
                return bX(i);
            }
            com.baidu.tbadk.core.data.n d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (uV = com.baidu.tbadk.coreExtra.act.a.uV()) != null) {
                uV.j(currentAccountObj);
            }
            if (d == null) {
                if (this.UO != null) {
                    this.UM.tT().mErrorString = this.UO.getErrorString();
                    return null;
                }
                this.UM.tT().mErrorString = str;
                return sz;
            }
            return bX(i);
        } else {
            return sz;
        }
    }

    private String bX(int i) {
        String sz;
        sY();
        switch (i) {
            case 1:
                sz = this.UN.sy();
                break;
            case 2:
                sz = this.UN.sw();
                break;
            case 3:
                sz = this.UN.sz();
                break;
            default:
                return null;
        }
        if (this.UM.tT().ta()) {
            switch (this.UM.tT().WI) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.UM.tT().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return sz;
            }
        }
        return sz;
    }

    public String sw() {
        return bW(2);
    }

    public String sz() {
        return bW(3);
    }

    public String cS(String str) {
        byte[] bArr;
        try {
            InputStream cF = o.cF(str);
            byte[] bArr2 = new byte[a0.O];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a0.O);
            while (true) {
                int read = cF.read(bArr2);
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
        return sz();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        sX().tS().a(this.UN);
        return this.UN.a(str, handler, i, i2, i3, z);
    }
}
