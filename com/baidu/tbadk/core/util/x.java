package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
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
public class x {
    private boolean cVm;
    private com.baidu.tbadk.core.util.a.a cVj = null;
    private q cVk = null;
    private x cVl = null;
    private aa.a cVn = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.cVj = new com.baidu.tbadk.core.util.a.a();
        this.cVk = z.aDY().a(this.cVj);
        this.cVl = null;
        this.cVj.aEu().aEx().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aDU() {
        return this.cVj;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.cVj.aEu().aEx().mUrl = str;
    }

    public void setUrl(String str) {
        this.cVj.aEu().aEx().mUrl = str;
    }

    public void I(boolean z) {
        this.cVj.aEu().rk = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.cVk.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.cVk.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.cVk.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.cVk.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.cVk.getPostData();
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
        if (this.cVn == null) {
            this.cVn = aa.aDZ();
        }
        if (this.cVn != null) {
            this.cVk.addPostData("stTime", String.valueOf(this.cVn.mTime));
            this.cVk.addPostData("stSize", String.valueOf(this.cVn.mSize));
            this.cVk.addPostData("stTimesNum", String.valueOf(this.cVn.mTimesNum));
            this.cVk.addPostData("stMode", String.valueOf(this.cVn.mMode));
            this.cVk.addPostData("stMethod", String.valueOf(this.cVn.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.cVn != null) {
            this.mErrorNums = this.cVn.mTimesNum;
        }
        this.cVk.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.cVj.aEv().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.cVj.aEv().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.cVj.aEv().mNetErrorCode;
    }

    public String aDV() {
        return this.cVj.aEv().mException;
    }

    public String getErrorString() {
        return this.cVj.aEv().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.cVk != null) {
            this.cVk.cancelNetConnect();
        }
        if (this.cVl != null) {
            this.cVl.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.cVk != null) {
            this.cVk.setCancel();
        }
        if (this.cVl != null) {
            this.cVl.setCancel();
        }
    }

    public void fD(boolean z) {
        this.cVm = z;
    }

    private com.baidu.tbadk.core.data.ah u(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.cVl == null) {
                this.cVl = new x(sb.toString());
            } else {
                this.cVl.cancelNetConnect();
            }
            this.cVl.aDU().aEu().mIsNeedAddCommenParam = false;
            this.cVl.aDU().aEu().mIsUseCurrentBDUSS = false;
            this.cVl.aDU().aEu().mNeedBackgroundLogin = false;
            this.cVl.addPostData("un", str);
            this.cVl.addPostData("passwd", str2);
            this.cVl.addPostData("isphone", "0");
            this.cVl.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.cVl.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.cVl.aDU().aEu().aEx().mRequestGzip = true;
            postNetData = this.cVl.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.cVl.aDU().aEv().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(postNetData);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.cVj.aEv().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(ahVar.getUser().getUserName());
            if (ahVar.getUser().getPassword() != null) {
                accountData.setPassword(ahVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(ahVar.getUser().getUserId());
            accountData.setBDUSS(ahVar.getUser().getBDUSS());
            accountData.setPortrait(ahVar.getUser().getPortrait());
            if (ahVar.getUser() != null && ahVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(ahVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(ahVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (ahVar.getAnti() != null) {
                accountData.setTbs(ahVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return ahVar;
        }
        if (this.cVl.isNetSuccess()) {
            switch (this.cVl.getServerErrorCode()) {
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
        if (!this.cVj.aEu().mIsFromCDN) {
            this.cVj.aEu().b(this.cVk);
        }
        return this.cVk.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.cVk.getPostData();
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
        this.cVk.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.cVj.aEu().cVm) {
            this.cVk.addPostData("sig", StringU.vT(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.cVj.aEu().cVm = this.cVm && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aDU().aEu().mIsNeedAddCommenParam) {
                    this.cVj.aEu().b(this.cVk);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cVk.getNetString();
                break;
            case 2:
                if (aDU().aEu().mIsUseCurrentBDUSS) {
                    aDU().aEu().a(this.cVk);
                }
                if (aDU().aEu().mIsNeedAddCommenParam) {
                    this.cVj.aEu().b(this.cVk);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cVk.postNetData();
                break;
            case 3:
                if (aDU().aEu().mIsUseCurrentBDUSS) {
                    aDU().aEu().a(this.cVk);
                }
                if (aDU().aEu().mIsNeedAddCommenParam) {
                    this.cVj.aEu().b(this.cVk);
                }
                addSign();
                postMultiNetData = this.cVk.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.cVj.aEv().isNetSuccess()) {
            aa.a(this.cVn);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.cVj.aEv().isRequestSuccess()) {
            if (this.cVj.aEv().mServerErrorCode == 1 && this.cVj.aEu().mNeedBackgroundLogin) {
                String str = this.cVj.aEv().mErrorString;
                this.cVj.aEv().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.axC();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aDW();
                    return null;
                }
                com.baidu.tbadk.core.a.b.sb(currentAccountObj.getID());
                if (ReloginManager.aDk().aDn()) {
                    f(currentAccountObj);
                    ReloginManager.aDk().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ah u = u(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (u == null) {
                    if (this.cVl != null) {
                        this.cVj.aEv().mErrorString = this.cVl.getErrorString();
                        return null;
                    }
                    this.cVj.aEv().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = jZ(i);
            }
            com.baidu.tieba.i.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c aGD;
        if (!TextUtils.isEmpty(accountData.getID()) && (aGD = com.baidu.tbadk.coreExtra.a.a.aGD()) != null) {
            aGD.f(accountData);
        }
    }

    private String jZ(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.cVk.getNetString();
                break;
            case 2:
                postMultiNetData = this.cVk.postNetData();
                break;
            case 3:
                postMultiNetData = this.cVk.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.cVj.aEv().isNetSuccess()) {
            switch (this.cVj.aEv().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aDW();
                    this.cVj.aEv().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aDW() {
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

    public String tb(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream GetStreamFromFile = m.GetStreamFromFile(str);
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
        addPostData("pic", bArr);
        return postMultiNetData();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aDU().aEu().a(this.cVk);
        return this.cVk.downloadFile(str, handler, i, i2, i3, z);
    }
}
