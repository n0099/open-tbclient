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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private com.baidu.tbadk.core.util.a.a agk = null;
    private q agl = null;
    private x agm = null;
    private aa.a agn = null;
    private int ago = 0;

    private void vi() {
        this.agk = new com.baidu.tbadk.core.util.a.a();
        this.agl = z.vt().a(this.agk);
        this.agm = null;
        this.agk.wf().wi().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vj() {
        return this.agk;
    }

    public x() {
        vi();
    }

    public x(String str) {
        vi();
        this.agk.wf().wi().mUrl = str;
    }

    public void setUrl(String str) {
        this.agk.wf().wi().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.agl.k(arrayList);
    }

    public void n(String str, String str2) {
        this.agl.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.agl.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.agl.d(str, bArr);
    }

    private void vk() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uL = this.agl.uL();
            int size = uL.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = uL.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    uL.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    uL.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void vl() {
        if (this.agn == null) {
            this.agn = aa.vu();
        }
        if (this.agn != null) {
            this.agl.n("stTime", String.valueOf(this.agn.mTime));
            this.agl.n("stSize", String.valueOf(this.agn.agE));
            this.agl.n("stTimesNum", String.valueOf(this.agn.agF));
            this.agl.n("stMode", String.valueOf(this.agn.mMode));
            this.agl.n("stMethod", String.valueOf(this.agn.agD));
        }
        this.ago = aa.cK(0);
        if (this.ago == 0 && this.agn != null) {
            this.ago = this.agn.agF;
        }
        this.agl.n("stErrorNums", String.valueOf(this.ago));
    }

    public boolean vm() {
        return this.agk.wg().vm();
    }

    public int vn() {
        return this.agk.wg().ain;
    }

    public int vo() {
        return this.agk.wg().vm;
    }

    public String vp() {
        return this.agk.wg().aio;
    }

    public String getErrorString() {
        return this.agk.wg().mErrorString;
    }

    public void fp() {
        if (this.agl != null) {
            this.agl.fp();
        }
        if (this.agm != null) {
            this.agm.fp();
        }
    }

    public void ft() {
        if (this.agl != null) {
            this.agl.ft();
        }
        if (this.agm != null) {
            this.agm.ft();
        }
    }

    private com.baidu.tbadk.core.data.ak e(String str, String str2, boolean z) {
        String uM;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.agm == null) {
                this.agm = new x(sb.toString());
            } else {
                this.agm.fp();
            }
            this.agm.vj().wf().mIsNeedAddCommenParam = false;
            this.agm.vj().wf().mIsUseCurrentBDUSS = false;
            this.agm.vj().wf().aik = false;
            this.agm.n("un", str);
            this.agm.n("passwd", str2);
            this.agm.n("isphone", "0");
            this.agm.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.agm.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.agm.vj().wf().wi().aiL = true;
            uM = this.agm.uM();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.agm.vj().wg().isRequestSuccess() && uM != null) {
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.parserJson(uM);
            String userId = akVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.agk.wg().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(akVar.getUser().getUserName());
            if (akVar.getUser().getPassword() != null) {
                accountData.setPassword(akVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(akVar.getUser().getUserId());
            accountData.setBDUSS(akVar.getUser().getBDUSS());
            accountData.setPortrait(akVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (akVar.qn() != null) {
                accountData.setTbs(akVar.qn().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return akVar;
        }
        if (this.agm.vm()) {
            switch (this.agm.vn()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkCoreApplication.getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString(LoginActivityConfig.ACCOUNT, str);
                        obtainMessage.setData(bundle);
                        TbadkCoreApplication.getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] uc() {
        if (!this.agk.wf().mIsFromCDN) {
            this.agk.wf().b(this.agl);
        }
        return this.agl.uc();
    }

    private void vq() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uL = this.agl.uL();
        for (int i = 0; uL != null && i < uL.size(); i++) {
            BasicNameValuePair basicNameValuePair = uL.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.agl.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aS(stringBuffer.toString()));
    }

    private String cH(int i) {
        String uO;
        com.baidu.tbadk.coreExtra.a.c xO;
        switch (i) {
            case 1:
                if (vj().wf().mIsNeedAddCommenParam) {
                    this.agk.wf().b(this.agl);
                }
                vl();
                uO = this.agl.uN();
                break;
            case 2:
                if (vj().wf().mIsUseCurrentBDUSS) {
                    vj().wf().a(this.agl);
                }
                if (vj().wf().mIsNeedAddCommenParam) {
                    this.agk.wf().b(this.agl);
                }
                vl();
                uO = this.agl.uM();
                break;
            case 3:
                if (vj().wf().mIsUseCurrentBDUSS) {
                    vj().wf().a(this.agl);
                }
                if (vj().wf().mIsNeedAddCommenParam) {
                    this.agk.wf().b(this.agl);
                }
                vq();
                uO = this.agl.uO();
                break;
            default:
                return null;
        }
        if (!this.agk.wg().vm()) {
            aa.a(this.agn);
            aa.cL(this.ago);
            return uO;
        } else if (!this.agk.wg().isRequestSuccess()) {
            if (this.agk.wg().ain == 1 && this.agk.wf().aik) {
                String str = this.agk.wg().mErrorString;
                this.agk.wg().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.pe();
                }
                if (currentAccountObj == null || TextUtils.isEmpty(currentAccountObj.getAccount())) {
                    vr();
                    return null;
                }
                com.baidu.tbadk.core.a.b.cq(currentAccountObj.getAccount());
                if (ReloginManager.uu().uy()) {
                    AccountData ux = ReloginManager.uu().ux();
                    if (ux == null) {
                        ReloginManager.uu().f(ux);
                        return null;
                    }
                    return cI(i);
                }
                com.baidu.tbadk.core.data.ak e = e(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                if (!TextUtils.isEmpty(currentAccountObj.getID()) && (xO = com.baidu.tbadk.coreExtra.a.a.xO()) != null) {
                    xO.h(currentAccountObj);
                }
                if (e == null) {
                    if (this.agm != null) {
                        this.agk.wg().mErrorString = this.agm.getErrorString();
                        return null;
                    }
                    this.agk.wg().mErrorString = str;
                    return uO;
                }
                uO = cI(i);
            }
            com.baidu.tieba.h.a.a(this);
            return uO;
        } else {
            return uO;
        }
    }

    private String cI(int i) {
        String uO;
        vk();
        switch (i) {
            case 1:
                uO = this.agl.uN();
                break;
            case 2:
                uO = this.agl.uM();
                break;
            case 3:
                uO = this.agl.uO();
                break;
            default:
                return null;
        }
        if (this.agk.wg().vm()) {
            switch (this.agk.wg().ain) {
                case 1:
                case 2:
                case 5:
                    vr();
                    this.agk.wg().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return uO;
            }
        }
        return uO;
    }

    private void vr() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String uM() {
        return cH(2);
    }

    public String uN() {
        return cH(1);
    }

    public String uO() {
        return cH(3);
    }

    public String dK(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream du = k.du(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = du.read(bArr2);
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
        return uO();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vj().wf().a(this.agl);
        return this.agl.a(str, handler, i, i2, i3, z);
    }
}
