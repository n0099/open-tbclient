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
    private boolean emk;
    private com.baidu.tbadk.core.util.a.a emh = null;
    private s emi = null;
    private aa emj = null;
    private ad.a eml = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.emh = new com.baidu.tbadk.core.util.a.a();
        this.emi = ac.bjP().a(this.emh);
        this.emj = null;
        this.emh.bkq().bku().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bR(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a bjL() {
        return this.emh;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.emh.bkq().bku().mUrl = str;
    }

    public void setUrl(String str) {
        this.emh.bkq().bku().mUrl = str;
    }

    public void ak(boolean z) {
        this.emh.bkq().LS = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.emi.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.emi.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.emi.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.emi.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.emi.getPostData();
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
        if (this.eml == null) {
            this.eml = ad.bjQ();
        }
        if (this.eml != null) {
            this.emi.addPostData("stTime", String.valueOf(this.eml.mTime));
            this.emi.addPostData("stSize", String.valueOf(this.eml.mSize));
            this.emi.addPostData("stTimesNum", String.valueOf(this.eml.mTimesNum));
            this.emi.addPostData("stMode", String.valueOf(this.eml.mMode));
            this.emi.addPostData("stMethod", String.valueOf(this.eml.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.eml != null) {
            this.mErrorNums = this.eml.mTimesNum;
        }
        this.emi.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.emh.bkr().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.emh.bkr().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.emh.bkr().mNetErrorCode;
    }

    public String bjM() {
        return this.emh.bkr().mException;
    }

    public String getErrorString() {
        return this.emh.bkr().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.emi != null) {
            this.emi.cancelNetConnect();
        }
        if (this.emj != null) {
            this.emj.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.emi != null) {
            this.emi.setCancel();
        }
        if (this.emj != null) {
            this.emj.setCancel();
        }
    }

    public void ii(boolean z) {
        this.emk = z;
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
            if (this.emj == null) {
                this.emj = new aa(sb.toString());
            } else {
                this.emj.cancelNetConnect();
            }
            this.emj.bjL().bkq().mIsNeedAddCommenParam = false;
            this.emj.bjL().bkq().mIsUseCurrentBDUSS = false;
            this.emj.bjL().bkq().mNeedBackgroundLogin = false;
            this.emj.addPostData("un", str);
            this.emj.addPostData("passwd", str2);
            this.emj.addPostData("isphone", "0");
            this.emj.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.emj.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.emj.bjL().bkq().bku().mRequestGzip = true;
            postNetData = this.emj.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.emj.bjL().bkr().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.parserJson(postNetData);
            String userId = anVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.emh.bkr().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.emj.isNetSuccess()) {
            switch (this.emj.getServerErrorCode()) {
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
        if (!this.emh.bkq().mIsFromCDN) {
            this.emh.bkq().b(this.emi);
        }
        return this.emi.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.emi.getPostData();
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
        this.emi.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.emh.bkq().emk) {
            this.emi.addPostData("sig", StringU.DD(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.emh.bkq().emk = this.emk && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bjL().bkq().mIsNeedAddCommenParam) {
                    this.emh.bkq().b(this.emi);
                }
                addStatisticsDataParam();
                postMultiNetData = this.emi.getNetString();
                break;
            case 2:
                if (bjL().bkq().mIsUseCurrentBDUSS) {
                    bjL().bkq().a(this.emi);
                }
                if (bjL().bkq().mIsNeedAddCommenParam) {
                    this.emh.bkq().b(this.emi);
                }
                addStatisticsDataParam();
                postMultiNetData = this.emi.postNetData();
                break;
            case 3:
                if (bjL().bkq().mIsUseCurrentBDUSS) {
                    bjL().bkq().a(this.emi);
                }
                if (bjL().bkq().mIsNeedAddCommenParam) {
                    this.emh.bkq().b(this.emi);
                }
                addSign();
                postMultiNetData = this.emi.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.emh.bkr().isNetSuccess()) {
            ad.a(this.eml);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.emh.bkr().isRequestSuccess()) {
            if (this.emh.bkr().mServerErrorCode == 1 && this.emh.bkq().mNeedBackgroundLogin) {
                String str = this.emh.bkr().mErrorString;
                this.emh.bkr().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bcK();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bjN();
                    return null;
                }
                com.baidu.tbadk.core.a.b.zj(currentAccountObj.getID());
                if (ReloginManager.biX().bja()) {
                    f(currentAccountObj);
                    ReloginManager.biX().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.an v = v(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (v == null) {
                    if (this.emj != null) {
                        this.emh.bkr().mErrorString = this.emj.getErrorString();
                        return null;
                    }
                    this.emh.bkr().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = nZ(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bnd;
        if (!TextUtils.isEmpty(accountData.getID()) && (bnd = com.baidu.tbadk.coreExtra.a.a.bnd()) != null) {
            bnd.f(accountData);
        }
    }

    private String nZ(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.emi.getNetString();
                break;
            case 2:
                postMultiNetData = this.emi.postNetData();
                break;
            case 3:
                postMultiNetData = this.emi.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.emh.bkr().isNetSuccess()) {
            switch (this.emh.bkr().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bjN();
                    this.emh.bkr().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bjN() {
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

    public String Aw(String str) throws IOException {
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

    public String dE(String str, String str2) {
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
        bjL().bkq().a(this.emi);
        return this.emi.downloadFile(str, handler, i, i2, i3, z);
    }
}
