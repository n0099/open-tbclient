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
    private boolean dyR;
    private com.baidu.tbadk.core.util.a.a dyO = null;
    private q dyP = null;
    private x dyQ = null;
    private aa.a dyS = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.dyO = new com.baidu.tbadk.core.util.a.a();
        this.dyP = z.aOC().a(this.dyO);
        this.dyQ = null;
        this.dyO.aOZ().aPd().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bK(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aOy() {
        return this.dyO;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.dyO.aOZ().aPd().mUrl = str;
    }

    public void setUrl(String str) {
        this.dyO.aOZ().aPd().mUrl = str;
    }

    public void ah(boolean z) {
        this.dyO.aOZ().Km = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.dyP.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.dyP.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.dyP.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.dyP.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.dyP.getPostData();
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
        if (this.dyS == null) {
            this.dyS = aa.aOD();
        }
        if (this.dyS != null) {
            this.dyP.addPostData("stTime", String.valueOf(this.dyS.mTime));
            this.dyP.addPostData("stSize", String.valueOf(this.dyS.mSize));
            this.dyP.addPostData("stTimesNum", String.valueOf(this.dyS.mTimesNum));
            this.dyP.addPostData("stMode", String.valueOf(this.dyS.mMode));
            this.dyP.addPostData("stMethod", String.valueOf(this.dyS.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.dyS != null) {
            this.mErrorNums = this.dyS.mTimesNum;
        }
        this.dyP.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.dyO.aPa().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.dyO.aPa().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.dyO.aPa().mNetErrorCode;
    }

    public String aOz() {
        return this.dyO.aPa().mException;
    }

    public String getErrorString() {
        return this.dyO.aPa().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.dyP != null) {
            this.dyP.cancelNetConnect();
        }
        if (this.dyQ != null) {
            this.dyQ.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.dyP != null) {
            this.dyP.setCancel();
        }
        if (this.dyQ != null) {
            this.dyQ.setCancel();
        }
    }

    public void gI(boolean z) {
        this.dyR = z;
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
            if (this.dyQ == null) {
                this.dyQ = new x(sb.toString());
            } else {
                this.dyQ.cancelNetConnect();
            }
            this.dyQ.aOy().aOZ().mIsNeedAddCommenParam = false;
            this.dyQ.aOy().aOZ().mIsUseCurrentBDUSS = false;
            this.dyQ.aOy().aOZ().mNeedBackgroundLogin = false;
            this.dyQ.addPostData("un", str);
            this.dyQ.addPostData("passwd", str2);
            this.dyQ.addPostData("isphone", "0");
            this.dyQ.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.dyQ.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.dyQ.aOy().aOZ().aPd().mRequestGzip = true;
            postNetData = this.dyQ.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.dyQ.aOy().aPa().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.parserJson(postNetData);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.dyO.aPa().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.dyQ.isNetSuccess()) {
            switch (this.dyQ.getServerErrorCode()) {
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
        if (!this.dyO.aOZ().mIsFromCDN) {
            this.dyO.aOZ().b(this.dyP);
        }
        return this.dyP.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.dyP.getPostData();
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
        this.dyP.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.dyO.aOZ().dyR) {
            this.dyP.addPostData("sig", StringU.xB(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.dyO.aOZ().dyR = this.dyR && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aOy().aOZ().mIsNeedAddCommenParam) {
                    this.dyO.aOZ().b(this.dyP);
                }
                addStatisticsDataParam();
                postMultiNetData = this.dyP.getNetString();
                break;
            case 2:
                if (aOy().aOZ().mIsUseCurrentBDUSS) {
                    aOy().aOZ().a(this.dyP);
                }
                if (aOy().aOZ().mIsNeedAddCommenParam) {
                    this.dyO.aOZ().b(this.dyP);
                }
                addStatisticsDataParam();
                postMultiNetData = this.dyP.postNetData();
                break;
            case 3:
                if (aOy().aOZ().mIsUseCurrentBDUSS) {
                    aOy().aOZ().a(this.dyP);
                }
                if (aOy().aOZ().mIsNeedAddCommenParam) {
                    this.dyO.aOZ().b(this.dyP);
                }
                addSign();
                postMultiNetData = this.dyP.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.dyO.aPa().isNetSuccess()) {
            aa.a(this.dyS);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.dyO.aPa().isRequestSuccess()) {
            if (this.dyO.aPa().mServerErrorCode == 1 && this.dyO.aOZ().mNeedBackgroundLogin) {
                String str = this.dyO.aPa().mErrorString;
                this.dyO.aPa().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.aIi();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aOA();
                    return null;
                }
                com.baidu.tbadk.core.a.b.tF(currentAccountObj.getID());
                if (ReloginManager.aNO().aNR()) {
                    f(currentAccountObj);
                    ReloginManager.aNO().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ah u = u(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (u == null) {
                    if (this.dyQ != null) {
                        this.dyO.aPa().mErrorString = this.dyQ.getErrorString();
                        return null;
                    }
                    this.dyO.aPa().mErrorString = str;
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
        com.baidu.tbadk.coreExtra.a.c aRv;
        if (!TextUtils.isEmpty(accountData.getID()) && (aRv = com.baidu.tbadk.coreExtra.a.a.aRv()) != null) {
            aRv.f(accountData);
        }
    }

    private String kx(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.dyP.getNetString();
                break;
            case 2:
                postMultiNetData = this.dyP.postNetData();
                break;
            case 3:
                postMultiNetData = this.dyP.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.dyO.aPa().isNetSuccess()) {
            switch (this.dyO.aPa().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aOA();
                    this.dyO.aPa().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aOA() {
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

    public String uE(String str) throws IOException {
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
        aOy().aOZ().a(this.dyP);
        return this.dyP.downloadFile(str, handler, i, i2, i3, z);
    }
}
