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
    private boolean cZo;
    private com.baidu.tbadk.core.util.a.a cZl = null;
    private q cZm = null;
    private x cZn = null;
    private aa.a cZp = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.cZl = new com.baidu.tbadk.core.util.a.a();
        this.cZm = z.aGi().a(this.cZl);
        this.cZn = null;
        this.cZl.aGF().aGI().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aGe() {
        return this.cZl;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.cZl.aGF().aGI().mUrl = str;
    }

    public void setUrl(String str) {
        this.cZl.aGF().aGI().mUrl = str;
    }

    public void I(boolean z) {
        this.cZl.aGF().rl = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.cZm.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.cZm.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.cZm.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.cZm.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.cZm.getPostData();
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
        if (this.cZp == null) {
            this.cZp = aa.aGj();
        }
        if (this.cZp != null) {
            this.cZm.addPostData("stTime", String.valueOf(this.cZp.mTime));
            this.cZm.addPostData("stSize", String.valueOf(this.cZp.mSize));
            this.cZm.addPostData("stTimesNum", String.valueOf(this.cZp.mTimesNum));
            this.cZm.addPostData("stMode", String.valueOf(this.cZp.mMode));
            this.cZm.addPostData("stMethod", String.valueOf(this.cZp.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.cZp != null) {
            this.mErrorNums = this.cZp.mTimesNum;
        }
        this.cZm.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.cZl.aGG().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.cZl.aGG().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.cZl.aGG().mNetErrorCode;
    }

    public String aGf() {
        return this.cZl.aGG().mException;
    }

    public String getErrorString() {
        return this.cZl.aGG().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.cZm != null) {
            this.cZm.cancelNetConnect();
        }
        if (this.cZn != null) {
            this.cZn.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.cZm != null) {
            this.cZm.setCancel();
        }
        if (this.cZn != null) {
            this.cZn.setCancel();
        }
    }

    public void fK(boolean z) {
        this.cZo = z;
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
            if (this.cZn == null) {
                this.cZn = new x(sb.toString());
            } else {
                this.cZn.cancelNetConnect();
            }
            this.cZn.aGe().aGF().mIsNeedAddCommenParam = false;
            this.cZn.aGe().aGF().mIsUseCurrentBDUSS = false;
            this.cZn.aGe().aGF().mNeedBackgroundLogin = false;
            this.cZn.addPostData("un", str);
            this.cZn.addPostData("passwd", str2);
            this.cZn.addPostData("isphone", "0");
            this.cZn.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.cZn.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.cZn.aGe().aGF().aGI().mRequestGzip = true;
            postNetData = this.cZn.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.cZn.aGe().aGG().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(postNetData);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.cZl.aGG().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.cZn.isNetSuccess()) {
            switch (this.cZn.getServerErrorCode()) {
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
        if (!this.cZl.aGF().mIsFromCDN) {
            this.cZl.aGF().b(this.cZm);
        }
        return this.cZm.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.cZm.getPostData();
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
        this.cZm.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.cZl.aGF().cZo) {
            this.cZm.addPostData("sig", StringU.wn(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.cZl.aGF().cZo = this.cZo && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aGe().aGF().mIsNeedAddCommenParam) {
                    this.cZl.aGF().b(this.cZm);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cZm.getNetString();
                break;
            case 2:
                if (aGe().aGF().mIsUseCurrentBDUSS) {
                    aGe().aGF().a(this.cZm);
                }
                if (aGe().aGF().mIsNeedAddCommenParam) {
                    this.cZl.aGF().b(this.cZm);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cZm.postNetData();
                break;
            case 3:
                if (aGe().aGF().mIsUseCurrentBDUSS) {
                    aGe().aGF().a(this.cZm);
                }
                if (aGe().aGF().mIsNeedAddCommenParam) {
                    this.cZl.aGF().b(this.cZm);
                }
                addSign();
                postMultiNetData = this.cZm.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.cZl.aGG().isNetSuccess()) {
            aa.a(this.cZp);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.cZl.aGG().isRequestSuccess()) {
            if (this.cZl.aGG().mServerErrorCode == 1 && this.cZl.aGF().mNeedBackgroundLogin) {
                String str = this.cZl.aGG().mErrorString;
                this.cZl.aGG().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.azQ();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aGg();
                    return null;
                }
                com.baidu.tbadk.core.a.b.ss(currentAccountObj.getID());
                if (ReloginManager.aFu().aFx()) {
                    f(currentAccountObj);
                    ReloginManager.aFu().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ah v = v(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (v == null) {
                    if (this.cZn != null) {
                        this.cZl.aGG().mErrorString = this.cZn.getErrorString();
                        return null;
                    }
                    this.cZl.aGG().mErrorString = str;
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
        com.baidu.tbadk.coreExtra.a.c aIR;
        if (!TextUtils.isEmpty(accountData.getID()) && (aIR = com.baidu.tbadk.coreExtra.a.a.aIR()) != null) {
            aIR.f(accountData);
        }
    }

    private String kq(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.cZm.getNetString();
                break;
            case 2:
                postMultiNetData = this.cZm.postNetData();
                break;
            case 3:
                postMultiNetData = this.cZm.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.cZl.aGG().isNetSuccess()) {
            switch (this.cZl.aGG().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aGg();
                    this.cZl.aGG().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aGg() {
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
        aGe().aGF().a(this.cZm);
        return this.cZm.downloadFile(str, handler, i, i2, i3, z);
    }
}
