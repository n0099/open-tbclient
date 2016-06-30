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
import com.baidu.tieba.u;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab {
    private com.baidu.tbadk.core.util.a.a WL = null;
    private t WM = null;
    private ab WN = null;
    private af.a WO = null;
    private int WP = 0;

    private void tx() {
        this.WL = new com.baidu.tbadk.core.util.a.a();
        this.WM = ae.tH().a(this.WL);
        this.WN = null;
        this.WL.uu().ux().mNetType = com.baidu.tbadk.core.util.a.j.getNetType();
        com.baidu.adp.lib.network.a.a.ad(TbadkCoreApplication.m9getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a ty() {
        return this.WL;
    }

    public ab() {
        tx();
    }

    public ab(String str) {
        tx();
        this.WL.uu().ux().mUrl = str;
    }

    public void setUrl(String str) {
        this.WL.uu().ux().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.WM.k(arrayList);
    }

    public void n(String str, String str2) {
        this.WM.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.WM.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.WM.d(str, bArr);
    }

    private void tz() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m9getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> sZ = this.WM.sZ();
            int size = sZ.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = sZ.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    sZ.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    sZ.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void tA() {
        if (this.WO == null) {
            this.WO = af.tI();
        }
        if (this.WO != null) {
            this.WM.n("stTime", String.valueOf(this.WO.mTime));
            this.WM.n("stSize", String.valueOf(this.WO.Xg));
            this.WM.n("stTimesNum", String.valueOf(this.WO.Xh));
            this.WM.n("stMode", String.valueOf(this.WO.mMode));
            this.WM.n("stMethod", String.valueOf(this.WO.Xf));
        }
        this.WP = af.cr(0);
        if (this.WP == 0 && this.WO != null) {
            this.WP = this.WO.Xh;
        }
        this.WM.n("stErrorNums", String.valueOf(this.WP));
    }

    public boolean tB() {
        return this.WL.uv().tB();
    }

    public int tC() {
        return this.WL.uv().YU;
    }

    public int tD() {
        return this.WL.uv().lE;
    }

    public String tE() {
        return this.WL.uv().YV;
    }

    public String getErrorString() {
        return this.WL.uv().mErrorString;
    }

    public void dm() {
        if (this.WM != null) {
            this.WM.dm();
        }
        if (this.WN != null) {
            this.WN.dm();
        }
    }

    public void dp() {
        if (this.WM != null) {
            this.WM.dp();
        }
        if (this.WN != null) {
            this.WN.dp();
        }
    }

    private com.baidu.tbadk.core.data.aa d(String str, String str2, boolean z) {
        String ta;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.WN == null) {
                this.WN = new ab(sb.toString());
            } else {
                this.WN.dm();
            }
            this.WN.ty().uu().mIsNeedAddCommenParam = false;
            this.WN.ty().uu().mIsUseCurrentBDUSS = false;
            this.WN.ty().uu().YR = false;
            this.WN.n("un", str);
            this.WN.n("passwd", str2);
            this.WN.n("isphone", "0");
            this.WN.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.WN.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.WN.ty().uu().ux().Zs = true;
            ta = this.WN.ta();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.WN.ty().uv().nU() && ta != null) {
            com.baidu.tbadk.core.data.aa aaVar = new com.baidu.tbadk.core.data.aa();
            aaVar.parserJson(ta);
            String userId = aaVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.WL.uv().mErrorString = TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getString(u.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aaVar.getUser().getUserName());
            if (aaVar.getUser().getPassword() != null) {
                accountData.setPassword(aaVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aaVar.getUser().getUserId());
            accountData.setBDUSS(aaVar.getUser().getBDUSS());
            accountData.setPortrait(aaVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aaVar.pt() != null) {
                accountData.setTbs(aaVar.pt().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            return aaVar;
        }
        if (this.WN.tB()) {
            switch (this.WN.tC()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.m9getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.m9getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] tb() {
        if (!this.WL.uu().mIsFromCDN) {
            this.WL.uu().b(this.WM);
        }
        return this.WM.tb();
    }

    private void tF() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> sZ = this.WM.sZ();
        for (int i = 0; sZ != null && i < sZ.size(); i++) {
            BasicNameValuePair basicNameValuePair = sZ.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.WM.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aS(stringBuffer.toString()));
    }

    private String co(int i) {
        String td;
        com.baidu.tbadk.coreExtra.a.c wk;
        switch (i) {
            case 1:
                if (ty().uu().mIsNeedAddCommenParam) {
                    this.WL.uu().b(this.WM);
                }
                tA();
                td = this.WM.tc();
                break;
            case 2:
                if (ty().uu().mIsUseCurrentBDUSS) {
                    ty().uu().a(this.WM);
                }
                if (ty().uu().mIsNeedAddCommenParam) {
                    this.WL.uu().b(this.WM);
                }
                tA();
                td = this.WM.ta();
                break;
            case 3:
                if (ty().uu().mIsUseCurrentBDUSS) {
                    ty().uu().a(this.WM);
                }
                if (ty().uu().mIsNeedAddCommenParam) {
                    this.WL.uu().b(this.WM);
                }
                tF();
                td = this.WM.td();
                break;
            default:
                return null;
        }
        if (!this.WL.uv().tB()) {
            af.a(this.WO);
            af.cs(this.WP);
            return td;
        } else if (!this.WL.uv().nU() && this.WL.uv().YU == 1 && this.WL.uu().YR) {
            String str = this.WL.uv().mErrorString;
            this.WL.uv().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.oi();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.ce(currentAccountObj.getAccount());
            if (ReloginManager.sJ().sN()) {
                AccountData sM = ReloginManager.sJ().sM();
                if (sM == null) {
                    ReloginManager.sJ().e(sM);
                    return null;
                }
                return cp(i);
            }
            com.baidu.tbadk.core.data.aa d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (wk = com.baidu.tbadk.coreExtra.a.a.wk()) != null) {
                wk.g(currentAccountObj);
            }
            if (d == null) {
                if (this.WN != null) {
                    this.WL.uv().mErrorString = this.WN.getErrorString();
                    return null;
                }
                this.WL.uv().mErrorString = str;
                return td;
            }
            return cp(i);
        } else {
            return td;
        }
    }

    private String cp(int i) {
        String td;
        tz();
        switch (i) {
            case 1:
                td = this.WM.tc();
                break;
            case 2:
                td = this.WM.ta();
                break;
            case 3:
                td = this.WM.td();
                break;
            default:
                return null;
        }
        if (this.WL.uv().tB()) {
            switch (this.WL.uv().YU) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m9getInst().handler.sendMessage(TbadkCoreApplication.m9getInst().handler.obtainMessage(1));
                    this.WL.uv().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return td;
            }
        }
        return td;
    }

    public String ta() {
        return co(2);
    }

    public String tc() {
        return co(1);
    }

    public String td() {
        return co(3);
    }

    public String dm(String str) {
        byte[] bArr;
        try {
            InputStream cX = m.cX(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = cX.read(bArr2);
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
        return td();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        ty().uu().a(this.WM);
        return this.WM.a(str, handler, i, i2, i3, z);
    }
}
