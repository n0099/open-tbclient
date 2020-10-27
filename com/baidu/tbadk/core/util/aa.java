package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.switchs.EncSigNewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class aa {
    private boolean eGR;
    private com.baidu.tbadk.core.util.a.a eGO = null;
    private s eGP = null;
    private aa eGQ = null;
    private ad.a eGS = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.eGO = new com.baidu.tbadk.core.util.a.a();
        this.eGP = ac.bor().a(this.eGO);
        this.eGQ = null;
        this.eGO.boT().boX().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bR(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a bon() {
        return this.eGO;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.eGO.boT().boX().mUrl = str;
    }

    public void setUrl(String str) {
        this.eGO.boT().boX().mUrl = str;
    }

    public void ak(boolean z) {
        this.eGO.boT().Mk = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.eGP.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.eGP.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.eGP.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.eGP.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.eGP.getPostData();
            int size = postData.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = postData.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    postData.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    postData.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void addStatisticsDataParam() {
        if (this.eGS == null) {
            this.eGS = ad.bos();
        }
        if (this.eGS != null) {
            this.eGP.addPostData("stTime", String.valueOf(this.eGS.mTime));
            this.eGP.addPostData("stSize", String.valueOf(this.eGS.mSize));
            this.eGP.addPostData("stTimesNum", String.valueOf(this.eGS.mTimesNum));
            this.eGP.addPostData("stMode", String.valueOf(this.eGS.mMode));
            this.eGP.addPostData("stMethod", String.valueOf(this.eGS.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.eGS != null) {
            this.mErrorNums = this.eGS.mTimesNum;
        }
        this.eGP.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.eGO.boU().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.eGO.boU().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.eGO.boU().mNetErrorCode;
    }

    public String boo() {
        return this.eGO.boU().mException;
    }

    public String getErrorString() {
        return this.eGO.boU().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.eGP != null) {
            this.eGP.cancelNetConnect();
        }
        if (this.eGQ != null) {
            this.eGQ.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.eGP != null) {
            this.eGP.setCancel();
        }
        if (this.eGQ != null) {
            this.eGQ.setCancel();
        }
    }

    public void iR(boolean z) {
        this.eGR = z;
    }

    private com.baidu.tbadk.core.data.an v(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.eGQ == null) {
                this.eGQ = new aa(sb.toString());
            } else {
                this.eGQ.cancelNetConnect();
            }
            this.eGQ.bon().boT().mIsNeedAddCommenParam = false;
            this.eGQ.bon().boT().mIsUseCurrentBDUSS = false;
            this.eGQ.bon().boT().mNeedBackgroundLogin = false;
            this.eGQ.addPostData("un", str);
            this.eGQ.addPostData("passwd", str2);
            this.eGQ.addPostData("isphone", "0");
            this.eGQ.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.eGQ.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.eGQ.bon().boT().boX().mRequestGzip = true;
            postNetData = this.eGQ.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.eGQ.bon().boU().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.parserJson(postNetData);
            String userId = anVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.eGO.boU().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(anVar.getUser().getUserName());
            if (anVar.getUser().getPassword() != null) {
                accountData.setPassword(anVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(anVar.getUser().getUserId());
            accountData.setBDUSS(anVar.getUser().getBDUSS());
            accountData.setPortrait(anVar.getUser().getPortrait());
            if (anVar.getUser() != null && anVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(anVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(anVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (anVar.getAnti() != null) {
                accountData.setTbs(anVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return anVar;
        }
        if (this.eGQ.isNetSuccess()) {
            switch (this.eGQ.getServerErrorCode()) {
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

    public byte[] getNetData() {
        if (!this.eGO.boT().mIsFromCDN) {
            this.eGO.boT().b(this.eGP);
        }
        return this.eGP.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.eGP.getPostData();
        for (int i = 0; postData != null && i < postData.size(); i++) {
            BasicNameValuePair basicNameValuePair = postData.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + ETAG.EQUAL);
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.eGP.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.eGO.boT().eGR) {
            this.eGP.addPostData("sig", StringU.EH(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.eGO.boT().eGR = this.eGR && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bon().boT().mIsNeedAddCommenParam) {
                    this.eGO.boT().b(this.eGP);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eGP.getNetString();
                break;
            case 2:
                if (bon().boT().mIsUseCurrentBDUSS) {
                    bon().boT().a(this.eGP);
                }
                if (bon().boT().mIsNeedAddCommenParam) {
                    this.eGO.boT().b(this.eGP);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eGP.postNetData();
                break;
            case 3:
                if (bon().boT().mIsUseCurrentBDUSS) {
                    bon().boT().a(this.eGP);
                }
                if (bon().boT().mIsNeedAddCommenParam) {
                    this.eGO.boT().b(this.eGP);
                }
                addSign();
                postMultiNetData = this.eGP.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.eGO.boU().isNetSuccess()) {
            ad.a(this.eGS);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.eGO.boU().isRequestSuccess()) {
            if (this.eGO.boU().mServerErrorCode == 1 && this.eGO.boT().mNeedBackgroundLogin) {
                String str = this.eGO.boU().mErrorString;
                this.eGO.boU().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bhl();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bop();
                    return null;
                }
                com.baidu.tbadk.core.a.b.Ao(currentAccountObj.getID());
                if (ReloginManager.bnz().bnC()) {
                    f(currentAccountObj);
                    ReloginManager.bnz().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.an v = v(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (v == null) {
                    if (this.eGQ != null) {
                        this.eGO.boU().mErrorString = this.eGQ.getErrorString();
                        return null;
                    }
                    this.eGO.boU().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = oH(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c brG;
        if (!TextUtils.isEmpty(accountData.getID()) && (brG = com.baidu.tbadk.coreExtra.a.a.brG()) != null) {
            brG.f(accountData);
        }
    }

    private String oH(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.eGP.getNetString();
                break;
            case 2:
                postMultiNetData = this.eGP.postNetData();
                break;
            case 3:
                postMultiNetData = this.eGP.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.eGO.boU().isNetSuccess()) {
            switch (this.eGO.boU().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bop();
                    this.eGO.boU().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bop() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public String postNetData() {
        return process(2);
    }

    public String getNetString() {
        return process(1);
    }

    public String postMultiNetData() {
        return process(3);
    }

    public String BB(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream GetStreamFromFile = n.GetStreamFromFile(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = GetStreamFromFile.read(bArr2);
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
        addPostData(UgcUBCUtils.UGC_TYPE_PIC_BTN, bArr);
        return postMultiNetData();
    }

    public String dQ(String str, String str2) {
        byte[] bArr;
        try {
            InputStream GetStreamFromTmpFile = n.GetStreamFromTmpFile(str2);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = GetStreamFromTmpFile.read(bArr2);
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
        addPostData(str, bArr);
        return postMultiNetData();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        bon().boT().a(this.eGP);
        return this.eGP.downloadFile(str, handler, i, i2, i3, z);
    }
}
