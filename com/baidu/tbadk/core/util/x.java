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
    private boolean cZD;
    private com.baidu.tbadk.core.util.a.a cZA = null;
    private q cZB = null;
    private x cZC = null;
    private aa.a cZE = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.cZA = new com.baidu.tbadk.core.util.a.a();
        this.cZB = z.aGo().a(this.cZA);
        this.cZC = null;
        this.cZA.aGL().aGO().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aGk() {
        return this.cZA;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.cZA.aGL().aGO().mUrl = str;
    }

    public void setUrl(String str) {
        this.cZA.aGL().aGO().mUrl = str;
    }

    public void I(boolean z) {
        this.cZA.aGL().rl = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.cZB.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.cZB.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.cZB.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.cZB.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.cZB.getPostData();
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
        if (this.cZE == null) {
            this.cZE = aa.aGp();
        }
        if (this.cZE != null) {
            this.cZB.addPostData("stTime", String.valueOf(this.cZE.mTime));
            this.cZB.addPostData("stSize", String.valueOf(this.cZE.mSize));
            this.cZB.addPostData("stTimesNum", String.valueOf(this.cZE.mTimesNum));
            this.cZB.addPostData("stMode", String.valueOf(this.cZE.mMode));
            this.cZB.addPostData("stMethod", String.valueOf(this.cZE.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.cZE != null) {
            this.mErrorNums = this.cZE.mTimesNum;
        }
        this.cZB.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.cZA.aGM().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.cZA.aGM().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.cZA.aGM().mNetErrorCode;
    }

    public String aGl() {
        return this.cZA.aGM().mException;
    }

    public String getErrorString() {
        return this.cZA.aGM().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.cZB != null) {
            this.cZB.cancelNetConnect();
        }
        if (this.cZC != null) {
            this.cZC.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.cZB != null) {
            this.cZB.setCancel();
        }
        if (this.cZC != null) {
            this.cZC.setCancel();
        }
    }

    public void fL(boolean z) {
        this.cZD = z;
    }

    private com.baidu.tbadk.core.data.ah v(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.cZC == null) {
                this.cZC = new x(sb.toString());
            } else {
                this.cZC.cancelNetConnect();
            }
            this.cZC.aGk().aGL().mIsNeedAddCommenParam = false;
            this.cZC.aGk().aGL().mIsUseCurrentBDUSS = false;
            this.cZC.aGk().aGL().mNeedBackgroundLogin = false;
            this.cZC.addPostData("un", str);
            this.cZC.addPostData("passwd", str2);
            this.cZC.addPostData("isphone", "0");
            this.cZC.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.cZC.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.cZC.aGk().aGL().aGO().mRequestGzip = true;
            postNetData = this.cZC.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.cZC.aGk().aGM().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(postNetData);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.cZA.aGM().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.cZC.isNetSuccess()) {
            switch (this.cZC.getServerErrorCode()) {
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
        if (!this.cZA.aGL().mIsFromCDN) {
            this.cZA.aGL().b(this.cZB);
        }
        return this.cZB.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.cZB.getPostData();
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
        this.cZB.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.cZA.aGL().cZD) {
            this.cZB.addPostData("sig", StringU.wo(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.cZA.aGL().cZD = this.cZD && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aGk().aGL().mIsNeedAddCommenParam) {
                    this.cZA.aGL().b(this.cZB);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cZB.getNetString();
                break;
            case 2:
                if (aGk().aGL().mIsUseCurrentBDUSS) {
                    aGk().aGL().a(this.cZB);
                }
                if (aGk().aGL().mIsNeedAddCommenParam) {
                    this.cZA.aGL().b(this.cZB);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cZB.postNetData();
                break;
            case 3:
                if (aGk().aGL().mIsUseCurrentBDUSS) {
                    aGk().aGL().a(this.cZB);
                }
                if (aGk().aGL().mIsNeedAddCommenParam) {
                    this.cZA.aGL().b(this.cZB);
                }
                addSign();
                postMultiNetData = this.cZB.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.cZA.aGM().isNetSuccess()) {
            aa.a(this.cZE);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.cZA.aGM().isRequestSuccess()) {
            if (this.cZA.aGM().mServerErrorCode == 1 && this.cZA.aGL().mNeedBackgroundLogin) {
                String str = this.cZA.aGM().mErrorString;
                this.cZA.aGM().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.azV();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aGm();
                    return null;
                }
                com.baidu.tbadk.core.a.b.sq(currentAccountObj.getID());
                if (ReloginManager.aFA().aFD()) {
                    f(currentAccountObj);
                    ReloginManager.aFA().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ah v = v(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (v == null) {
                    if (this.cZC != null) {
                        this.cZA.aGM().mErrorString = this.cZC.getErrorString();
                        return null;
                    }
                    this.cZA.aGM().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = kq(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c aIY;
        if (!TextUtils.isEmpty(accountData.getID()) && (aIY = com.baidu.tbadk.coreExtra.a.a.aIY()) != null) {
            aIY.f(accountData);
        }
    }

    private String kq(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.cZB.getNetString();
                break;
            case 2:
                postMultiNetData = this.cZB.postNetData();
                break;
            case 3:
                postMultiNetData = this.cZB.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.cZA.aGM().isNetSuccess()) {
            switch (this.cZA.aGM().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aGm();
                    this.cZA.aGM().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aGm() {
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

    public String tq(String str) throws IOException {
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
        aGk().aGL().a(this.cZB);
        return this.cZB.downloadFile(str, handler, i, i2, i3, z);
    }
}
