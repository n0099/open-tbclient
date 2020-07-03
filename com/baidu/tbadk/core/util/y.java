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
import com.baidu.tbadk.core.util.ab;
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
public class y {
    private boolean dTQ;
    private com.baidu.tbadk.core.util.a.a dTN = null;
    private r dTO = null;
    private y dTP = null;
    private ab.a dTR = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.dTN = new com.baidu.tbadk.core.util.a.a();
        this.dTO = aa.aWy().a(this.dTN);
        this.dTP = null;
        this.dTN.aWV().aWZ().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bM(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bN(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aWu() {
        return this.dTN;
    }

    public y() {
        initNetWork();
    }

    public y(String str) {
        initNetWork();
        this.dTN.aWV().aWZ().mUrl = str;
    }

    public void setUrl(String str) {
        this.dTN.aWV().aWZ().mUrl = str;
    }

    public void ak(boolean z) {
        this.dTN.aWV().Lb = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.dTO.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.dTO.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.dTO.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.dTO.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.dTO.getPostData();
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
        if (this.dTR == null) {
            this.dTR = ab.aWz();
        }
        if (this.dTR != null) {
            this.dTO.addPostData("stTime", String.valueOf(this.dTR.mTime));
            this.dTO.addPostData("stSize", String.valueOf(this.dTR.mSize));
            this.dTO.addPostData("stTimesNum", String.valueOf(this.dTR.mTimesNum));
            this.dTO.addPostData("stMode", String.valueOf(this.dTR.mMode));
            this.dTO.addPostData("stMethod", String.valueOf(this.dTR.mMethod));
        }
        this.mErrorNums = ab.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.dTR != null) {
            this.mErrorNums = this.dTR.mTimesNum;
        }
        this.dTO.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.dTN.aWW().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.dTN.aWW().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.dTN.aWW().mNetErrorCode;
    }

    public String aWv() {
        return this.dTN.aWW().mException;
    }

    public String getErrorString() {
        return this.dTN.aWW().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.dTO != null) {
            this.dTO.cancelNetConnect();
        }
        if (this.dTP != null) {
            this.dTP.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.dTO != null) {
            this.dTO.setCancel();
        }
        if (this.dTP != null) {
            this.dTP.setCancel();
        }
    }

    public void hj(boolean z) {
        this.dTQ = z;
    }

    private com.baidu.tbadk.core.data.al w(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.dTP == null) {
                this.dTP = new y(sb.toString());
            } else {
                this.dTP.cancelNetConnect();
            }
            this.dTP.aWu().aWV().mIsNeedAddCommenParam = false;
            this.dTP.aWu().aWV().mIsUseCurrentBDUSS = false;
            this.dTP.aWu().aWV().mNeedBackgroundLogin = false;
            this.dTP.addPostData("un", str);
            this.dTP.addPostData("passwd", str2);
            this.dTP.addPostData("isphone", "0");
            this.dTP.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.dTP.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.dTP.aWu().aWV().aWZ().mRequestGzip = true;
            postNetData = this.dTP.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.dTP.aWu().aWW().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.parserJson(postNetData);
            String userId = alVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.dTN.aWW().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(alVar.getUser().getUserName());
            if (alVar.getUser().getPassword() != null) {
                accountData.setPassword(alVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(alVar.getUser().getUserId());
            accountData.setBDUSS(alVar.getUser().getBDUSS());
            accountData.setPortrait(alVar.getUser().getPortrait());
            if (alVar.getUser() != null && alVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(alVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(alVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (alVar.getAnti() != null) {
                accountData.setTbs(alVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return alVar;
        }
        if (this.dTP.isNetSuccess()) {
            switch (this.dTP.getServerErrorCode()) {
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
        if (!this.dTN.aWV().mIsFromCDN) {
            this.dTN.aWV().b(this.dTO);
        }
        return this.dTO.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.dTO.getPostData();
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
        this.dTO.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.dTN.aWV().dTQ) {
            this.dTO.addPostData("sig", StringU.zD(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.dTN.aWV().dTQ = this.dTQ && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aWu().aWV().mIsNeedAddCommenParam) {
                    this.dTN.aWV().b(this.dTO);
                }
                addStatisticsDataParam();
                postMultiNetData = this.dTO.getNetString();
                break;
            case 2:
                if (aWu().aWV().mIsUseCurrentBDUSS) {
                    aWu().aWV().a(this.dTO);
                }
                if (aWu().aWV().mIsNeedAddCommenParam) {
                    this.dTN.aWV().b(this.dTO);
                }
                addStatisticsDataParam();
                postMultiNetData = this.dTO.postNetData();
                break;
            case 3:
                if (aWu().aWV().mIsUseCurrentBDUSS) {
                    aWu().aWV().a(this.dTO);
                }
                if (aWu().aWV().mIsNeedAddCommenParam) {
                    this.dTN.aWV().b(this.dTO);
                }
                addSign();
                postMultiNetData = this.dTO.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.dTN.aWW().isNetSuccess()) {
            ab.a(this.dTR);
            ab.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.dTN.aWW().isRequestSuccess()) {
            if (this.dTN.aWW().mServerErrorCode == 1 && this.dTN.aWV().mNeedBackgroundLogin) {
                String str = this.dTN.aWW().mErrorString;
                this.dTN.aWW().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.aPE();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aWw();
                    return null;
                }
                com.baidu.tbadk.core.a.b.vA(currentAccountObj.getID());
                if (ReloginManager.aVI().aVL()) {
                    f(currentAccountObj);
                    ReloginManager.aVI().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.al w = w(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (w == null) {
                    if (this.dTP != null) {
                        this.dTN.aWW().mErrorString = this.dTP.getErrorString();
                        return null;
                    }
                    this.dTN.aWW().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = ln(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c aZG;
        if (!TextUtils.isEmpty(accountData.getID()) && (aZG = com.baidu.tbadk.coreExtra.a.a.aZG()) != null) {
            aZG.f(accountData);
        }
    }

    private String ln(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.dTO.getNetString();
                break;
            case 2:
                postMultiNetData = this.dTO.postNetData();
                break;
            case 3:
                postMultiNetData = this.dTO.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.dTN.aWW().isNetSuccess()) {
            switch (this.dTN.aWW().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aWw();
                    this.dTN.aWW().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aWw() {
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

    public String wD(String str) throws IOException {
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

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aWu().aWV().a(this.dTO);
        return this.dTO.downloadFile(str, handler, i, i2, i3, z);
    }
}
