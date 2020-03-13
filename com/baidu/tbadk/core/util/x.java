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
    private boolean cZq;
    private com.baidu.tbadk.core.util.a.a cZn = null;
    private q cZo = null;
    private x cZp = null;
    private aa.a cZr = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.cZn = new com.baidu.tbadk.core.util.a.a();
        this.cZo = z.aGk().a(this.cZn);
        this.cZp = null;
        this.cZn.aGH().aGK().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aGg() {
        return this.cZn;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.cZn.aGH().aGK().mUrl = str;
    }

    public void setUrl(String str) {
        this.cZn.aGH().aGK().mUrl = str;
    }

    public void I(boolean z) {
        this.cZn.aGH().rl = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.cZo.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.cZo.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.cZo.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.cZo.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.cZo.getPostData();
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
        if (this.cZr == null) {
            this.cZr = aa.aGl();
        }
        if (this.cZr != null) {
            this.cZo.addPostData("stTime", String.valueOf(this.cZr.mTime));
            this.cZo.addPostData("stSize", String.valueOf(this.cZr.mSize));
            this.cZo.addPostData("stTimesNum", String.valueOf(this.cZr.mTimesNum));
            this.cZo.addPostData("stMode", String.valueOf(this.cZr.mMode));
            this.cZo.addPostData("stMethod", String.valueOf(this.cZr.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.cZr != null) {
            this.mErrorNums = this.cZr.mTimesNum;
        }
        this.cZo.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.cZn.aGI().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.cZn.aGI().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.cZn.aGI().mNetErrorCode;
    }

    public String aGh() {
        return this.cZn.aGI().mException;
    }

    public String getErrorString() {
        return this.cZn.aGI().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.cZo != null) {
            this.cZo.cancelNetConnect();
        }
        if (this.cZp != null) {
            this.cZp.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.cZo != null) {
            this.cZo.setCancel();
        }
        if (this.cZp != null) {
            this.cZp.setCancel();
        }
    }

    public void fK(boolean z) {
        this.cZq = z;
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
            if (this.cZp == null) {
                this.cZp = new x(sb.toString());
            } else {
                this.cZp.cancelNetConnect();
            }
            this.cZp.aGg().aGH().mIsNeedAddCommenParam = false;
            this.cZp.aGg().aGH().mIsUseCurrentBDUSS = false;
            this.cZp.aGg().aGH().mNeedBackgroundLogin = false;
            this.cZp.addPostData("un", str);
            this.cZp.addPostData("passwd", str2);
            this.cZp.addPostData("isphone", "0");
            this.cZp.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.cZp.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.cZp.aGg().aGH().aGK().mRequestGzip = true;
            postNetData = this.cZp.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.cZp.aGg().aGI().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(postNetData);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.cZn.aGI().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.cZp.isNetSuccess()) {
            switch (this.cZp.getServerErrorCode()) {
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
        if (!this.cZn.aGH().mIsFromCDN) {
            this.cZn.aGH().b(this.cZo);
        }
        return this.cZo.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.cZo.getPostData();
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
        this.cZo.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.cZn.aGH().cZq) {
            this.cZo.addPostData("sig", StringU.wo(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.cZn.aGH().cZq = this.cZq && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aGg().aGH().mIsNeedAddCommenParam) {
                    this.cZn.aGH().b(this.cZo);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cZo.getNetString();
                break;
            case 2:
                if (aGg().aGH().mIsUseCurrentBDUSS) {
                    aGg().aGH().a(this.cZo);
                }
                if (aGg().aGH().mIsNeedAddCommenParam) {
                    this.cZn.aGH().b(this.cZo);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cZo.postNetData();
                break;
            case 3:
                if (aGg().aGH().mIsUseCurrentBDUSS) {
                    aGg().aGH().a(this.cZo);
                }
                if (aGg().aGH().mIsNeedAddCommenParam) {
                    this.cZn.aGH().b(this.cZo);
                }
                addSign();
                postMultiNetData = this.cZo.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.cZn.aGI().isNetSuccess()) {
            aa.a(this.cZr);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.cZn.aGI().isRequestSuccess()) {
            if (this.cZn.aGI().mServerErrorCode == 1 && this.cZn.aGH().mNeedBackgroundLogin) {
                String str = this.cZn.aGI().mErrorString;
                this.cZn.aGI().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.azS();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aGi();
                    return null;
                }
                com.baidu.tbadk.core.a.b.ss(currentAccountObj.getID());
                if (ReloginManager.aFw().aFz()) {
                    f(currentAccountObj);
                    ReloginManager.aFw().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ah v = v(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (v == null) {
                    if (this.cZp != null) {
                        this.cZn.aGI().mErrorString = this.cZp.getErrorString();
                        return null;
                    }
                    this.cZn.aGI().mErrorString = str;
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
        com.baidu.tbadk.coreExtra.a.c aIU;
        if (!TextUtils.isEmpty(accountData.getID()) && (aIU = com.baidu.tbadk.coreExtra.a.a.aIU()) != null) {
            aIU.f(accountData);
        }
    }

    private String kq(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.cZo.getNetString();
                break;
            case 2:
                postMultiNetData = this.cZo.postNetData();
                break;
            case 3:
                postMultiNetData = this.cZo.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.cZn.aGI().isNetSuccess()) {
            switch (this.cZn.aGI().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aGi();
                    this.cZn.aGI().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aGi() {
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

    public String tr(String str) throws IOException {
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
        aGg().aGH().a(this.cZo);
        return this.cZo.downloadFile(str, handler, i, i2, i3, z);
    }
}
