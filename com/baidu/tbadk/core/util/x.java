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
    private boolean cZp;
    private com.baidu.tbadk.core.util.a.a cZm = null;
    private q cZn = null;
    private x cZo = null;
    private aa.a cZq = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.cZm = new com.baidu.tbadk.core.util.a.a();
        this.cZn = z.aGk().a(this.cZm);
        this.cZo = null;
        this.cZm.aGH().aGK().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aGg() {
        return this.cZm;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.cZm.aGH().aGK().mUrl = str;
    }

    public void setUrl(String str) {
        this.cZm.aGH().aGK().mUrl = str;
    }

    public void I(boolean z) {
        this.cZm.aGH().rl = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.cZn.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.cZn.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.cZn.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.cZn.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.cZn.getPostData();
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
        if (this.cZq == null) {
            this.cZq = aa.aGl();
        }
        if (this.cZq != null) {
            this.cZn.addPostData("stTime", String.valueOf(this.cZq.mTime));
            this.cZn.addPostData("stSize", String.valueOf(this.cZq.mSize));
            this.cZn.addPostData("stTimesNum", String.valueOf(this.cZq.mTimesNum));
            this.cZn.addPostData("stMode", String.valueOf(this.cZq.mMode));
            this.cZn.addPostData("stMethod", String.valueOf(this.cZq.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.cZq != null) {
            this.mErrorNums = this.cZq.mTimesNum;
        }
        this.cZn.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.cZm.aGI().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.cZm.aGI().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.cZm.aGI().mNetErrorCode;
    }

    public String aGh() {
        return this.cZm.aGI().mException;
    }

    public String getErrorString() {
        return this.cZm.aGI().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.cZn != null) {
            this.cZn.cancelNetConnect();
        }
        if (this.cZo != null) {
            this.cZo.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.cZn != null) {
            this.cZn.setCancel();
        }
        if (this.cZo != null) {
            this.cZo.setCancel();
        }
    }

    public void fK(boolean z) {
        this.cZp = z;
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
            if (this.cZo == null) {
                this.cZo = new x(sb.toString());
            } else {
                this.cZo.cancelNetConnect();
            }
            this.cZo.aGg().aGH().mIsNeedAddCommenParam = false;
            this.cZo.aGg().aGH().mIsUseCurrentBDUSS = false;
            this.cZo.aGg().aGH().mNeedBackgroundLogin = false;
            this.cZo.addPostData("un", str);
            this.cZo.addPostData("passwd", str2);
            this.cZo.addPostData("isphone", "0");
            this.cZo.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.cZo.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.cZo.aGg().aGH().aGK().mRequestGzip = true;
            postNetData = this.cZo.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.cZo.aGg().aGI().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(postNetData);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.cZm.aGI().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.cZo.isNetSuccess()) {
            switch (this.cZo.getServerErrorCode()) {
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
        if (!this.cZm.aGH().mIsFromCDN) {
            this.cZm.aGH().b(this.cZn);
        }
        return this.cZn.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.cZn.getPostData();
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
        this.cZn.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.cZm.aGH().cZp) {
            this.cZn.addPostData("sig", StringU.wn(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.cZm.aGH().cZp = this.cZp && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aGg().aGH().mIsNeedAddCommenParam) {
                    this.cZm.aGH().b(this.cZn);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cZn.getNetString();
                break;
            case 2:
                if (aGg().aGH().mIsUseCurrentBDUSS) {
                    aGg().aGH().a(this.cZn);
                }
                if (aGg().aGH().mIsNeedAddCommenParam) {
                    this.cZm.aGH().b(this.cZn);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cZn.postNetData();
                break;
            case 3:
                if (aGg().aGH().mIsUseCurrentBDUSS) {
                    aGg().aGH().a(this.cZn);
                }
                if (aGg().aGH().mIsNeedAddCommenParam) {
                    this.cZm.aGH().b(this.cZn);
                }
                addSign();
                postMultiNetData = this.cZn.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.cZm.aGI().isNetSuccess()) {
            aa.a(this.cZq);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.cZm.aGI().isRequestSuccess()) {
            if (this.cZm.aGI().mServerErrorCode == 1 && this.cZm.aGH().mNeedBackgroundLogin) {
                String str = this.cZm.aGI().mErrorString;
                this.cZm.aGI().mErrorString = "";
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
                    if (this.cZo != null) {
                        this.cZm.aGI().mErrorString = this.cZo.getErrorString();
                        return null;
                    }
                    this.cZm.aGI().mErrorString = str;
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
        com.baidu.tbadk.coreExtra.a.c aIT;
        if (!TextUtils.isEmpty(accountData.getID()) && (aIT = com.baidu.tbadk.coreExtra.a.a.aIT()) != null) {
            aIT.f(accountData);
        }
    }

    private String kq(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.cZn.getNetString();
                break;
            case 2:
                postMultiNetData = this.cZn.postNetData();
                break;
            case 3:
                postMultiNetData = this.cZn.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.cZm.aGI().isNetSuccess()) {
            switch (this.cZm.aGI().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aGi();
                    this.cZm.aGI().mErrorString = "";
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
        aGg().aGH().a(this.cZn);
        return this.cZn.downloadFile(str, handler, i, i2, i3, z);
    }
}
