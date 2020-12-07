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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class aa {
    private boolean eSR;
    private com.baidu.tbadk.core.util.a.a eSO = null;
    private s eSP = null;
    private aa eSQ = null;
    private ad.a eSS = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.eSO = new com.baidu.tbadk.core.util.a.a();
        this.eSP = ac.btz().a(this.eSO);
        this.eSQ = null;
        this.eSO.bue().bui().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bU(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bV(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a btv() {
        return this.eSO;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.eSO.bue().bui().mUrl = str;
    }

    public void setUrl(String str) {
        this.eSO.bue().bui().mUrl = str;
    }

    public void ai(boolean z) {
        this.eSO.bue().Nf = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.eSP.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.eSP.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.eSP.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.eSP.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.eSP.getPostData();
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
        if (this.eSS == null) {
            this.eSS = ad.btA();
        }
        if (this.eSS != null) {
            this.eSP.addPostData("stTime", String.valueOf(this.eSS.mTime));
            this.eSP.addPostData("stSize", String.valueOf(this.eSS.mSize));
            this.eSP.addPostData("stTimesNum", String.valueOf(this.eSS.mTimesNum));
            this.eSP.addPostData("stMode", String.valueOf(this.eSS.mMode));
            this.eSP.addPostData("stMethod", String.valueOf(this.eSS.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.eSS != null) {
            this.mErrorNums = this.eSS.mTimesNum;
        }
        this.eSP.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.eSO.buf().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.eSO.buf().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.eSO.buf().mNetErrorCode;
    }

    public String btw() {
        return this.eSO.buf().mException;
    }

    public String getErrorString() {
        return this.eSO.buf().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.eSP != null) {
            this.eSP.cancelNetConnect();
        }
        if (this.eSQ != null) {
            this.eSQ.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.eSP != null) {
            this.eSP.setCancel();
        }
        if (this.eSQ != null) {
            this.eSQ.setCancel();
        }
    }

    public void jq(boolean z) {
        this.eSR = z;
    }

    private com.baidu.tbadk.core.data.ap x(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.eSQ == null) {
                this.eSQ = new aa(sb.toString());
            } else {
                this.eSQ.cancelNetConnect();
            }
            this.eSQ.btv().bue().mIsNeedAddCommenParam = false;
            this.eSQ.btv().bue().mIsUseCurrentBDUSS = false;
            this.eSQ.btv().bue().mNeedBackgroundLogin = false;
            this.eSQ.addPostData("un", str);
            this.eSQ.addPostData("passwd", str2);
            this.eSQ.addPostData("isphone", "0");
            this.eSQ.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.eSQ.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.eSQ.btv().bue().bui().mRequestGzip = true;
            postNetData = this.eSQ.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.eSQ.btv().buf().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
            apVar.parserJson(postNetData);
            String userId = apVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.eSO.buf().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(apVar.getUser().getUserName());
            if (apVar.getUser().getPassword() != null) {
                accountData.setPassword(apVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(apVar.getUser().getUserId());
            accountData.setBDUSS(apVar.getUser().getBDUSS());
            accountData.setPortrait(apVar.getUser().getPortrait());
            if (apVar.getUser() != null && apVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(apVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(apVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (apVar.getAnti() != null) {
                accountData.setTbs(apVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return apVar;
        }
        if (this.eSQ.isNetSuccess()) {
            switch (this.eSQ.getServerErrorCode()) {
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
        if (!this.eSO.bue().mIsFromCDN) {
            this.eSO.bue().b(this.eSP);
        }
        return this.eSP.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.eSP.getPostData();
        for (int i = 0; postData != null && i < postData.size(); i++) {
            BasicNameValuePair basicNameValuePair = postData.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.eSP.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.eSO.bue().eSR) {
            this.eSP.addPostData("sig", StringU.Fk(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.eSO.bue().eSR = this.eSR && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (btv().bue().mIsNeedAddCommenParam) {
                    this.eSO.bue().b(this.eSP);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eSP.getNetString();
                break;
            case 2:
                if (btv().bue().mIsUseCurrentBDUSS) {
                    btv().bue().a(this.eSP);
                }
                if (btv().bue().mIsNeedAddCommenParam) {
                    this.eSO.bue().b(this.eSP);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eSP.postNetData();
                break;
            case 3:
                if (btv().bue().mIsUseCurrentBDUSS) {
                    btv().bue().a(this.eSP);
                }
                if (btv().bue().mIsNeedAddCommenParam) {
                    this.eSO.bue().b(this.eSP);
                }
                addSign();
                postMultiNetData = this.eSP.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.eSO.buf().isNetSuccess()) {
            ad.a(this.eSS);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.eSO.buf().isRequestSuccess()) {
            if (this.eSO.buf().mServerErrorCode == 1 && this.eSO.bue().mNeedBackgroundLogin) {
                String str = this.eSO.buf().mErrorString;
                this.eSO.buf().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.blZ();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    btx();
                    return null;
                }
                com.baidu.tbadk.core.a.b.AE(currentAccountObj.getID());
                if (ReloginManager.bsG().bsJ()) {
                    f(currentAccountObj);
                    ReloginManager.bsG().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ap x = x(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (x == null) {
                    if (this.eSQ != null) {
                        this.eSO.buf().mErrorString = this.eSQ.getErrorString();
                        return null;
                    }
                    this.eSO.buf().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = pN(i);
            }
            com.baidu.tieba.k.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bwW;
        if (!TextUtils.isEmpty(accountData.getID()) && (bwW = com.baidu.tbadk.coreExtra.a.a.bwW()) != null) {
            bwW.f(accountData);
        }
    }

    private String pN(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.eSP.getNetString();
                break;
            case 2:
                postMultiNetData = this.eSP.postNetData();
                break;
            case 3:
                postMultiNetData = this.eSP.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.eSO.buf().isNetSuccess()) {
            switch (this.eSO.buf().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    btx();
                    this.eSO.buf().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void btx() {
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

    public String BV(String str) throws IOException {
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

    public String dW(String str, String str2) {
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
        btv().bue().a(this.eSP);
        return this.eSP.downloadFile(str, handler, i, i2, i3, z);
    }
}
