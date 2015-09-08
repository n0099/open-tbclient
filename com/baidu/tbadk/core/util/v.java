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
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.i;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class v {
    private com.baidu.tbadk.core.util.a.a ZX = null;
    private q ZY = null;
    private v ZZ = null;
    private z.a aaa = null;
    private int aab = 0;

    private void ui() {
        this.ZX = new com.baidu.tbadk.core.util.a.a();
        this.ZY = y.ur().a(this.ZX);
        this.ZZ = null;
        this.ZX.uZ().vc().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.m411getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a uj() {
        return this.ZX;
    }

    public v() {
        ui();
    }

    public v(String str) {
        ui();
        this.ZX.uZ().vc().mUrl = str;
    }

    public void setUrl(String str) {
        this.ZX.uZ().vc().mUrl = str;
    }

    public void l(ArrayList<BasicNameValuePair> arrayList) {
        this.ZY.l(arrayList);
    }

    public void o(String str, String str2) {
        this.ZY.o(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.ZY.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.ZY.d(str, bArr);
    }

    private void uk() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.m411getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> tH = this.ZY.tH();
            int size = tH.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = tH.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    tH.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    tH.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void ul() {
        if (this.aaa == null) {
            this.aaa = z.us();
        }
        if (this.aaa != null) {
            this.ZY.o("stTime", String.valueOf(this.aaa.mTime));
            this.ZY.o("stSize", String.valueOf(this.aaa.mSize));
            this.ZY.o("stTimesNum", String.valueOf(this.aaa.aas));
            this.ZY.o("stMode", String.valueOf(this.aaa.mMode));
            this.ZY.o("stMethod", String.valueOf(this.aaa.aar));
        }
        this.aab = z.cl(0);
        if (this.aab == 0 && this.aaa != null) {
            this.aab = this.aaa.aas;
        }
        this.ZY.o("stErrorNums", String.valueOf(this.aab));
    }

    public boolean um() {
        return this.ZX.va().um();
    }

    public int un() {
        return this.ZX.va().abQ;
    }

    public int uo() {
        return this.ZX.va().abP;
    }

    public String getErrorString() {
        return this.ZX.va().mErrorString;
    }

    public void gJ() {
        if (this.ZY != null) {
            this.ZY.gJ();
        }
        if (this.ZZ != null) {
            this.ZZ.gJ();
        }
    }

    private com.baidu.tbadk.core.data.l d(String str, String str2, boolean z) {
        String tI;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.ZZ == null) {
                this.ZZ = new v(sb.toString());
            } else {
                this.ZZ.gJ();
            }
            this.ZZ.uj().uZ().mIsNeedAddCommenParam = false;
            this.ZZ.uj().uZ().mIsUseCurrentBDUSS = false;
            this.ZZ.uj().uZ().abM = false;
            this.ZZ.o("un", str);
            this.ZZ.o("passwd", str2);
            this.ZZ.o("isphone", "0");
            this.ZZ.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.ZZ.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.ZZ.uj().uZ().vc().acl = true;
            tI = this.ZZ.tI();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ZZ.uj().va().qZ() && tI != null) {
            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
            lVar.parserJson(tI);
            String userId = lVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ZX.va().mErrorString = TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getString(i.h.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(lVar.getUser().getUserName());
            if (lVar.getUser().getPassword() != null) {
                accountData.setPassword(lVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(lVar.getUser().getUserId());
            accountData.setBDUSS(lVar.getUser().getBDUSS());
            accountData.setPortrait(lVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (lVar.rK() != null) {
                accountData.setTbs(lVar.rK().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            return lVar;
        }
        if (this.ZZ.um()) {
            switch (this.ZZ.un()) {
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

    public byte[] tJ() {
        if (!this.ZX.uZ().mIsFromCDN) {
            this.ZX.uZ().b(this.ZY);
        }
        return this.ZY.tJ();
    }

    private void up() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> tH = this.ZY.tH();
        for (int i = 0; tH != null && i < tH.size(); i++) {
            BasicNameValuePair basicNameValuePair = tH.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.ZY.o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(stringBuffer.toString()));
    }

    private String ci(int i) {
        String tL;
        com.baidu.tbadk.coreExtra.act.l we;
        switch (i) {
            case 1:
                if (uj().uZ().mIsNeedAddCommenParam) {
                    this.ZX.uZ().b(this.ZY);
                }
                ul();
                tL = this.ZY.tK();
                break;
            case 2:
                if (uj().uZ().mIsUseCurrentBDUSS) {
                    uj().uZ().a(this.ZY);
                }
                if (uj().uZ().mIsNeedAddCommenParam) {
                    this.ZX.uZ().b(this.ZY);
                }
                ul();
                tL = this.ZY.tI();
                break;
            case 3:
                if (uj().uZ().mIsUseCurrentBDUSS) {
                    uj().uZ().a(this.ZY);
                }
                if (uj().uZ().mIsNeedAddCommenParam) {
                    this.ZX.uZ().b(this.ZY);
                }
                up();
                tL = this.ZY.tL();
                break;
            default:
                return null;
        }
        if (!this.ZX.va().um()) {
            z.a(this.aaa);
            z.cm(this.aab);
            return tL;
        } else if (!this.ZX.va().qZ() && this.ZX.va().abQ == 1 && this.ZX.uZ().abM) {
            String str = this.ZX.va().mErrorString;
            this.ZX.va().mErrorString = "";
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.a.b.rl();
            }
            if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                return null;
            }
            com.baidu.tbadk.core.a.b.cd(currentAccountObj.getAccount());
            if (ReloginManager.ts().tw()) {
                AccountData tv = ReloginManager.ts().tv();
                if (tv == null) {
                    ReloginManager.ts().e(tv);
                    return null;
                }
                return cj(i);
            }
            com.baidu.tbadk.core.data.l d = d(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
            if (!TextUtils.isEmpty(currentAccountObj.getID()) && (we = com.baidu.tbadk.coreExtra.act.a.we()) != null) {
                we.i(currentAccountObj);
            }
            if (d == null) {
                if (this.ZZ != null) {
                    this.ZX.va().mErrorString = this.ZZ.getErrorString();
                    return null;
                }
                this.ZX.va().mErrorString = str;
                return tL;
            }
            return cj(i);
        } else {
            return tL;
        }
    }

    private String cj(int i) {
        String tL;
        uk();
        switch (i) {
            case 1:
                tL = this.ZY.tK();
                break;
            case 2:
                tL = this.ZY.tI();
                break;
            case 3:
                tL = this.ZY.tL();
                break;
            default:
                return null;
        }
        if (this.ZX.va().um()) {
            switch (this.ZX.va().abQ) {
                case 1:
                case 2:
                case 5:
                    TbadkCoreApplication.m411getInst().handler.sendMessage(TbadkCoreApplication.m411getInst().handler.obtainMessage(1));
                    this.ZX.va().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return tL;
            }
        }
        return tL;
    }

    public String tI() {
        return ci(2);
    }

    public String tK() {
        return ci(1);
    }

    public String tL() {
        return ci(3);
    }

    public String da(String str) {
        byte[] bArr;
        try {
            InputStream cM = n.cM(str);
            byte[] bArr2 = new byte[a0.O];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a0.O);
            while (true) {
                int read = cM.read(bArr2);
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
        return tL();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        uj().uZ().a(this.ZY);
        return this.ZY.a(str, handler, i, i2, i3, z);
    }
}
