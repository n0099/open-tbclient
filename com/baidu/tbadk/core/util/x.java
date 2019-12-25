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
    private boolean cVc;
    private com.baidu.tbadk.core.util.a.a cUZ = null;
    private q cVa = null;
    private x cVb = null;
    private aa.a cVd = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.cUZ = new com.baidu.tbadk.core.util.a.a();
        this.cVa = z.aDF().a(this.cUZ);
        this.cVb = null;
        this.cUZ.aEb().aEe().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aDB() {
        return this.cUZ;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.cUZ.aEb().aEe().mUrl = str;
    }

    public void setUrl(String str) {
        this.cUZ.aEb().aEe().mUrl = str;
    }

    public void I(boolean z) {
        this.cUZ.aEb().rm = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.cVa.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.cVa.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.cVa.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.cVa.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.cVa.getPostData();
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
        if (this.cVd == null) {
            this.cVd = aa.aDG();
        }
        if (this.cVd != null) {
            this.cVa.addPostData("stTime", String.valueOf(this.cVd.mTime));
            this.cVa.addPostData("stSize", String.valueOf(this.cVd.mSize));
            this.cVa.addPostData("stTimesNum", String.valueOf(this.cVd.mTimesNum));
            this.cVa.addPostData("stMode", String.valueOf(this.cVd.mMode));
            this.cVa.addPostData("stMethod", String.valueOf(this.cVd.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.cVd != null) {
            this.mErrorNums = this.cVd.mTimesNum;
        }
        this.cVa.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.cUZ.aEc().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.cUZ.aEc().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.cUZ.aEc().mNetErrorCode;
    }

    public String aDC() {
        return this.cUZ.aEc().mException;
    }

    public String getErrorString() {
        return this.cUZ.aEc().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.cVa != null) {
            this.cVa.cancelNetConnect();
        }
        if (this.cVb != null) {
            this.cVb.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.cVa != null) {
            this.cVa.setCancel();
        }
        if (this.cVb != null) {
            this.cVb.setCancel();
        }
    }

    public void fy(boolean z) {
        this.cVc = z;
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
            if (this.cVb == null) {
                this.cVb = new x(sb.toString());
            } else {
                this.cVb.cancelNetConnect();
            }
            this.cVb.aDB().aEb().mIsNeedAddCommenParam = false;
            this.cVb.aDB().aEb().mIsUseCurrentBDUSS = false;
            this.cVb.aDB().aEb().mNeedBackgroundLogin = false;
            this.cVb.addPostData("un", str);
            this.cVb.addPostData("passwd", str2);
            this.cVb.addPostData("isphone", "0");
            this.cVb.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.cVb.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.cVb.aDB().aEb().aEe().mRequestGzip = true;
            postNetData = this.cVb.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.cVb.aDB().aEc().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(postNetData);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.cUZ.aEc().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.cVb.isNetSuccess()) {
            switch (this.cVb.getServerErrorCode()) {
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
        if (!this.cUZ.aEb().mIsFromCDN) {
            this.cUZ.aEb().b(this.cVa);
        }
        return this.cVa.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.cVa.getPostData();
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
        this.cVa.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.cUZ.aEb().cVc) {
            this.cVa.addPostData("sig", StringU.vP(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.cUZ.aEb().cVc = this.cVc && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aDB().aEb().mIsNeedAddCommenParam) {
                    this.cUZ.aEb().b(this.cVa);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cVa.getNetString();
                break;
            case 2:
                if (aDB().aEb().mIsUseCurrentBDUSS) {
                    aDB().aEb().a(this.cVa);
                }
                if (aDB().aEb().mIsNeedAddCommenParam) {
                    this.cUZ.aEb().b(this.cVa);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cVa.postNetData();
                break;
            case 3:
                if (aDB().aEb().mIsUseCurrentBDUSS) {
                    aDB().aEb().a(this.cVa);
                }
                if (aDB().aEb().mIsNeedAddCommenParam) {
                    this.cUZ.aEb().b(this.cVa);
                }
                addSign();
                postMultiNetData = this.cVa.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.cUZ.aEc().isNetSuccess()) {
            aa.a(this.cVd);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.cUZ.aEc().isRequestSuccess()) {
            if (this.cUZ.aEc().mServerErrorCode == 1 && this.cUZ.aEb().mNeedBackgroundLogin) {
                String str = this.cUZ.aEc().mErrorString;
                this.cUZ.aEc().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.axj();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aDD();
                    return null;
                }
                com.baidu.tbadk.core.a.b.rY(currentAccountObj.getID());
                if (ReloginManager.aCR().aCU()) {
                    f(currentAccountObj);
                    ReloginManager.aCR().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ah u = u(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (u == null) {
                    if (this.cVb != null) {
                        this.cUZ.aEc().mErrorString = this.cVb.getErrorString();
                        return null;
                    }
                    this.cUZ.aEc().mErrorString = str;
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
        com.baidu.tbadk.coreExtra.a.c aGk;
        if (!TextUtils.isEmpty(accountData.getID()) && (aGk = com.baidu.tbadk.coreExtra.a.a.aGk()) != null) {
            aGk.f(accountData);
        }
    }

    private String jZ(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.cVa.getNetString();
                break;
            case 2:
                postMultiNetData = this.cVa.postNetData();
                break;
            case 3:
                postMultiNetData = this.cVa.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.cUZ.aEc().isNetSuccess()) {
            switch (this.cUZ.aEc().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aDD();
                    this.cUZ.aEc().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aDD() {
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

    public String sY(String str) throws IOException {
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
        aDB().aEb().a(this.cVa);
        return this.cVa.downloadFile(str, handler, i, i2, i3, z);
    }
}
