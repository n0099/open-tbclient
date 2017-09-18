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
    private com.baidu.tbadk.core.util.a.a agj = null;
    private q agk = null;
    private x agl = null;
    private aa.a agm = null;
    private int agn = 0;

    private void vi() {
        this.agj = new com.baidu.tbadk.core.util.a.a();
        this.agk = z.vt().a(this.agj);
        this.agl = null;
        this.agj.wf().wi().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuid());
    }

    public com.baidu.tbadk.core.util.a.a vj() {
        return this.agj;
    }

    public x() {
        vi();
    }

    public x(String str) {
        vi();
        this.agj.wf().wi().mUrl = str;
    }

    public void setUrl(String str) {
        this.agj.wf().wi().mUrl = str;
    }

    public void k(ArrayList<BasicNameValuePair> arrayList) {
        this.agk.k(arrayList);
    }

    public void n(String str, String str2) {
        this.agk.n(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.agk.a(basicNameValuePair);
    }

    public void d(String str, byte[] bArr) {
        this.agk.d(str, bArr);
    }

    private void vk() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> uL = this.agk.uL();
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
        if (this.agm == null) {
            this.agm = aa.vu();
        }
        if (this.agm != null) {
            this.agk.n("stTime", String.valueOf(this.agm.mTime));
            this.agk.n("stSize", String.valueOf(this.agm.agD));
            this.agk.n("stTimesNum", String.valueOf(this.agm.agE));
            this.agk.n("stMode", String.valueOf(this.agm.mMode));
            this.agk.n("stMethod", String.valueOf(this.agm.agC));
        }
        this.agn = aa.cK(0);
        if (this.agn == 0 && this.agm != null) {
            this.agn = this.agm.agE;
        }
        this.agk.n("stErrorNums", String.valueOf(this.agn));
    }

    public boolean vm() {
        return this.agj.wg().vm();
    }

    public int vn() {
        return this.agj.wg().aim;
    }

    public int vo() {
        return this.agj.wg().vm;
    }

    public String vp() {
        return this.agj.wg().ain;
    }

    public String getErrorString() {
        return this.agj.wg().mErrorString;
    }

    public void fp() {
        if (this.agk != null) {
            this.agk.fp();
        }
        if (this.agl != null) {
            this.agl.fp();
        }
    }

    public void ft() {
        if (this.agk != null) {
            this.agk.ft();
        }
        if (this.agl != null) {
            this.agl.ft();
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
            if (this.agl == null) {
                this.agl = new x(sb.toString());
            } else {
                this.agl.fp();
            }
            this.agl.vj().wf().mIsNeedAddCommenParam = false;
            this.agl.vj().wf().mIsUseCurrentBDUSS = false;
            this.agl.vj().wf().aij = false;
            this.agl.n("un", str);
            this.agl.n("passwd", str2);
            this.agl.n("isphone", "0");
            this.agl.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.agl.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.agl.vj().wf().wi().aiK = true;
            uM = this.agl.uM();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.agl.vj().wg().isRequestSuccess() && uM != null) {
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.parserJson(uM);
            String userId = akVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.agj.wg().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(d.l.neterror);
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
        if (this.agl.vm()) {
            switch (this.agl.vn()) {
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
        if (!this.agj.wf().mIsFromCDN) {
            this.agj.wf().b(this.agk);
        }
        return this.agk.uc();
    }

    private void vq() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> uL = this.agk.uL();
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
        this.agk.n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aS(stringBuffer.toString()));
    }

    private String cH(int i) {
        String uO;
        com.baidu.tbadk.coreExtra.a.c xO;
        switch (i) {
            case 1:
                if (vj().wf().mIsNeedAddCommenParam) {
                    this.agj.wf().b(this.agk);
                }
                vl();
                uO = this.agk.uN();
                break;
            case 2:
                if (vj().wf().mIsUseCurrentBDUSS) {
                    vj().wf().a(this.agk);
                }
                if (vj().wf().mIsNeedAddCommenParam) {
                    this.agj.wf().b(this.agk);
                }
                vl();
                uO = this.agk.uM();
                break;
            case 3:
                if (vj().wf().mIsUseCurrentBDUSS) {
                    vj().wf().a(this.agk);
                }
                if (vj().wf().mIsNeedAddCommenParam) {
                    this.agj.wf().b(this.agk);
                }
                vq();
                uO = this.agk.uO();
                break;
            default:
                return null;
        }
        if (!this.agj.wg().vm()) {
            aa.a(this.agm);
            aa.cL(this.agn);
            return uO;
        } else if (!this.agj.wg().isRequestSuccess()) {
            if (this.agj.wg().aim == 1 && this.agj.wf().aij) {
                String str = this.agj.wg().mErrorString;
                this.agj.wg().mErrorString = "";
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
                    if (this.agl != null) {
                        this.agj.wg().mErrorString = this.agl.getErrorString();
                        return null;
                    }
                    this.agj.wg().mErrorString = str;
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
                uO = this.agk.uN();
                break;
            case 2:
                uO = this.agk.uM();
                break;
            case 3:
                uO = this.agk.uO();
                break;
            default:
                return null;
        }
        if (this.agj.wg().vm()) {
            switch (this.agj.wg().aim) {
                case 1:
                case 2:
                case 5:
                    vr();
                    this.agj.wg().mErrorString = "";
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
        vj().wf().a(this.agk);
        return this.agk.a(str, handler, i, i2, i3, z);
    }
}
