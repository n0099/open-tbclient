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
    private boolean dyV;
    private com.baidu.tbadk.core.util.a.a dyS = null;
    private q dyT = null;
    private x dyU = null;
    private aa.a dyW = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.dyS = new com.baidu.tbadk.core.util.a.a();
        this.dyT = z.aOA().a(this.dyS);
        this.dyU = null;
        this.dyS.aOW().aPa().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bK(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aOw() {
        return this.dyS;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.dyS.aOW().aPa().mUrl = str;
    }

    public void setUrl(String str) {
        this.dyS.aOW().aPa().mUrl = str;
    }

    public void ah(boolean z) {
        this.dyS.aOW().Kp = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.dyT.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.dyT.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.dyT.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.dyT.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.dyT.getPostData();
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
        if (this.dyW == null) {
            this.dyW = aa.aOB();
        }
        if (this.dyW != null) {
            this.dyT.addPostData("stTime", String.valueOf(this.dyW.mTime));
            this.dyT.addPostData("stSize", String.valueOf(this.dyW.mSize));
            this.dyT.addPostData("stTimesNum", String.valueOf(this.dyW.mTimesNum));
            this.dyT.addPostData("stMode", String.valueOf(this.dyW.mMode));
            this.dyT.addPostData("stMethod", String.valueOf(this.dyW.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.dyW != null) {
            this.mErrorNums = this.dyW.mTimesNum;
        }
        this.dyT.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.dyS.aOX().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.dyS.aOX().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.dyS.aOX().mNetErrorCode;
    }

    public String aOx() {
        return this.dyS.aOX().mException;
    }

    public String getErrorString() {
        return this.dyS.aOX().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.dyT != null) {
            this.dyT.cancelNetConnect();
        }
        if (this.dyU != null) {
            this.dyU.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.dyT != null) {
            this.dyT.setCancel();
        }
        if (this.dyU != null) {
            this.dyU.setCancel();
        }
    }

    public void gI(boolean z) {
        this.dyV = z;
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
            if (this.dyU == null) {
                this.dyU = new x(sb.toString());
            } else {
                this.dyU.cancelNetConnect();
            }
            this.dyU.aOw().aOW().mIsNeedAddCommenParam = false;
            this.dyU.aOw().aOW().mIsUseCurrentBDUSS = false;
            this.dyU.aOw().aOW().mNeedBackgroundLogin = false;
            this.dyU.addPostData("un", str);
            this.dyU.addPostData("passwd", str2);
            this.dyU.addPostData("isphone", "0");
            this.dyU.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.dyU.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.dyU.aOw().aOW().aPa().mRequestGzip = true;
            postNetData = this.dyU.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.dyU.aOw().aOX().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(postNetData);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.dyS.aOX().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.dyU.isNetSuccess()) {
            switch (this.dyU.getServerErrorCode()) {
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
        if (!this.dyS.aOW().mIsFromCDN) {
            this.dyS.aOW().b(this.dyT);
        }
        return this.dyT.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.dyT.getPostData();
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
        this.dyT.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.dyS.aOW().dyV) {
            this.dyT.addPostData("sig", StringU.xE(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.dyS.aOW().dyV = this.dyV && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aOw().aOW().mIsNeedAddCommenParam) {
                    this.dyS.aOW().b(this.dyT);
                }
                addStatisticsDataParam();
                postMultiNetData = this.dyT.getNetString();
                break;
            case 2:
                if (aOw().aOW().mIsUseCurrentBDUSS) {
                    aOw().aOW().a(this.dyT);
                }
                if (aOw().aOW().mIsNeedAddCommenParam) {
                    this.dyS.aOW().b(this.dyT);
                }
                addStatisticsDataParam();
                postMultiNetData = this.dyT.postNetData();
                break;
            case 3:
                if (aOw().aOW().mIsUseCurrentBDUSS) {
                    aOw().aOW().a(this.dyT);
                }
                if (aOw().aOW().mIsNeedAddCommenParam) {
                    this.dyS.aOW().b(this.dyT);
                }
                addSign();
                postMultiNetData = this.dyT.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.dyS.aOX().isNetSuccess()) {
            aa.a(this.dyW);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.dyS.aOX().isRequestSuccess()) {
            if (this.dyS.aOX().mServerErrorCode == 1 && this.dyS.aOW().mNeedBackgroundLogin) {
                String str = this.dyS.aOX().mErrorString;
                this.dyS.aOX().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.aIg();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aOy();
                    return null;
                }
                com.baidu.tbadk.core.a.b.tI(currentAccountObj.getID());
                if (ReloginManager.aNM().aNP()) {
                    f(currentAccountObj);
                    ReloginManager.aNM().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ah u = u(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (u == null) {
                    if (this.dyU != null) {
                        this.dyS.aOX().mErrorString = this.dyU.getErrorString();
                        return null;
                    }
                    this.dyS.aOX().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = kx(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c aRs;
        if (!TextUtils.isEmpty(accountData.getID()) && (aRs = com.baidu.tbadk.coreExtra.a.a.aRs()) != null) {
            aRs.f(accountData);
        }
    }

    private String kx(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.dyT.getNetString();
                break;
            case 2:
                postMultiNetData = this.dyT.postNetData();
                break;
            case 3:
                postMultiNetData = this.dyT.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.dyS.aOX().isNetSuccess()) {
            switch (this.dyS.aOX().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aOy();
                    this.dyS.aOX().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aOy() {
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

    public String uH(String str) throws IOException {
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
        aOw().aOW().a(this.dyT);
        return this.dyT.downloadFile(str, handler, i, i2, i3, z);
    }
}
