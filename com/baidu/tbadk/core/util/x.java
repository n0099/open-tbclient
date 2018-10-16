package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.StringU;
import com.baidu.tieba.e;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private boolean awG;
    private com.baidu.tbadk.core.util.a.a awD = null;
    private q awE = null;
    private x awF = null;
    private aa.a awH = null;
    private int awI = 0;

    private void BX() {
        this.awD = new com.baidu.tbadk.core.util.a.a();
        this.awE = z.Ci().a(this.awD);
        this.awF = null;
        this.awD.CW().CZ().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a BY() {
        return this.awD;
    }

    public x() {
        BX();
    }

    public x(String str) {
        BX();
        this.awD.CW().CZ().mUrl = str;
    }

    public void setUrl(String str) {
        this.awD.CW().CZ().mUrl = str;
    }

    public void p(ArrayList<BasicNameValuePair> arrayList) {
        this.awE.p(arrayList);
    }

    public void x(String str, String str2) {
        this.awE.x(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.awE.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.awE.d(str, bArr);
    }

    private void BZ() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> Bz = this.awE.Bz();
            int size = Bz.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = Bz.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    Bz.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    Bz.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void Ca() {
        if (this.awH == null) {
            this.awH = aa.Cj();
        }
        if (this.awH != null) {
            this.awE.x("stTime", String.valueOf(this.awH.mTime));
            this.awE.x("stSize", String.valueOf(this.awH.mSize));
            this.awE.x("stTimesNum", String.valueOf(this.awH.awY));
            this.awE.x("stMode", String.valueOf(this.awH.mMode));
            this.awE.x("stMethod", String.valueOf(this.awH.awX));
        }
        this.awI = aa.dc(0);
        if (this.awI == 0 && this.awH != null) {
            this.awI = this.awH.awY;
        }
        this.awE.x("stErrorNums", String.valueOf(this.awI));
    }

    public boolean Cb() {
        return this.awD.CX().Cb();
    }

    public int Cc() {
        return this.awD.CX().aze;
    }

    public int Cd() {
        return this.awD.CX().Da;
    }

    public String Ce() {
        return this.awD.CX().azf;
    }

    public String getErrorString() {
        return this.awD.CX().mErrorString;
    }

    public void ji() {
        if (this.awE != null) {
            this.awE.ji();
        }
        if (this.awF != null) {
            this.awF.ji();
        }
    }

    public void jl() {
        if (this.awE != null) {
            this.awE.jl();
        }
        if (this.awF != null) {
            this.awF.jl();
        }
    }

    public void bb(boolean z) {
        this.awG = z;
    }

    private com.baidu.tbadk.core.data.ae f(String str, String str2, boolean z) {
        String BA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.awF == null) {
                this.awF = new x(sb.toString());
            } else {
                this.awF.ji();
            }
            this.awF.BY().CW().mIsNeedAddCommenParam = false;
            this.awF.BY().CW().mIsUseCurrentBDUSS = false;
            this.awF.BY().CW().azb = false;
            this.awF.x("un", str);
            this.awF.x("passwd", str2);
            this.awF.x("isphone", "0");
            this.awF.x("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.awF.x("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.awF.BY().CW().CZ().azC = true;
            BA = this.awF.BA();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.awF.BY().CX().isRequestSuccess() && BA != null) {
            com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
            aeVar.parserJson(BA);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.awD.CX().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(e.j.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aeVar.getUser().getUserName());
            if (aeVar.getUser().getPassword() != null) {
                accountData.setPassword(aeVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aeVar.getUser().getUserId());
            accountData.setBDUSS(aeVar.getUser().getBDUSS());
            accountData.setPortrait(aeVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aeVar.xs() != null) {
                accountData.setTbs(aeVar.xs().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aeVar;
        }
        if (this.awF.Cb()) {
            switch (this.awF.Cc()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] BB() {
        if (!this.awD.CW().mIsFromCDN) {
            this.awD.CW().b(this.awE);
        }
        return this.awE.BB();
    }

    private void Cf() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> Bz = this.awE.Bz();
        for (int i = 0; Bz != null && i < Bz.size(); i++) {
            BasicNameValuePair basicNameValuePair = Bz.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + ETAG.EQUAL);
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.awE.x("sign", com.baidu.adp.lib.util.s.bC(stringBuffer.toString()));
        if (this.awD.CW().awG) {
            this.awE.x("sig", StringU.iO(stringBuffer.toString()));
        }
    }

    private String cZ(int i) {
        String BD;
        this.awD.CW().awG = this.awG && com.baidu.tbadk.p.s.jL();
        switch (i) {
            case 1:
                if (BY().CW().mIsNeedAddCommenParam) {
                    this.awD.CW().b(this.awE);
                }
                Ca();
                BD = this.awE.BC();
                break;
            case 2:
                if (BY().CW().mIsUseCurrentBDUSS) {
                    BY().CW().a(this.awE);
                }
                if (BY().CW().mIsNeedAddCommenParam) {
                    this.awD.CW().b(this.awE);
                }
                Ca();
                BD = this.awE.BA();
                break;
            case 3:
                if (BY().CW().mIsUseCurrentBDUSS) {
                    BY().CW().a(this.awE);
                }
                if (BY().CW().mIsNeedAddCommenParam) {
                    this.awD.CW().b(this.awE);
                }
                Cf();
                BD = this.awE.BD();
                break;
            default:
                return null;
        }
        if (!this.awD.CX().Cb()) {
            aa.a(this.awH);
            aa.dd(this.awI);
            return BD;
        } else if (!this.awD.CX().isRequestSuccess()) {
            if (this.awD.CX().aze == 1 && this.awD.CW().azb) {
                String str = this.awD.CX().mErrorString;
                this.awD.CX().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.wB();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    Cg();
                    return null;
                }
                com.baidu.tbadk.core.a.b.dL(currentAccountObj.getID());
                if (ReloginManager.Bi().Bl()) {
                    f(currentAccountObj);
                    ReloginManager.Bi().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ae f = f(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (f == null) {
                    if (this.awF != null) {
                        this.awD.CX().mErrorString = this.awF.getErrorString();
                        return null;
                    }
                    this.awD.CX().mErrorString = str;
                    return BD;
                }
                BD = da(i);
            }
            com.baidu.tieba.i.a.a(this);
            return BD;
        } else {
            return BD;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c EK;
        if (!TextUtils.isEmpty(accountData.getID()) && (EK = com.baidu.tbadk.coreExtra.a.a.EK()) != null) {
            EK.f(accountData);
        }
    }

    private String da(int i) {
        String BD;
        BZ();
        switch (i) {
            case 1:
                BD = this.awE.BC();
                break;
            case 2:
                BD = this.awE.BA();
                break;
            case 3:
                BD = this.awE.BD();
                break;
            default:
                return null;
        }
        if (this.awD.CX().Cb()) {
            switch (this.awD.CX().aze) {
                case 1:
                case 2:
                case 5:
                    Cg();
                    this.awD.CX().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return BD;
            }
        }
        return BD;
    }

    private void Cg() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String BA() {
        return cZ(2);
    }

    public String BC() {
        return cZ(1);
    }

    public String BD() {
        return cZ(3);
    }

    public String fh(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream eS = l.eS(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = eS.read(bArr2);
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
        return BD();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        BY().CW().a(this.awE);
        return this.awE.a(str, handler, i, i2, i3, z);
    }
}
