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
import com.baidu.webkit.internal.ETAG;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class aa {
    private boolean ejV;
    private com.baidu.tbadk.core.util.a.a ejS = null;
    private s ejT = null;
    private aa ejU = null;
    private ad.a ejW = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.ejS = new com.baidu.tbadk.core.util.a.a();
        this.ejT = ac.biU().a(this.ejS);
        this.ejU = null;
        this.ejS.bjv().bjz().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bO(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bP(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a biQ() {
        return this.ejS;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.ejS.bjv().bjz().mUrl = str;
    }

    public void setUrl(String str) {
        this.ejS.bjv().bjz().mUrl = str;
    }

    public void al(boolean z) {
        this.ejS.bjv().LG = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.ejT.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.ejT.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.ejT.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.ejT.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.ejT.getPostData();
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
        if (this.ejW == null) {
            this.ejW = ad.biV();
        }
        if (this.ejW != null) {
            this.ejT.addPostData("stTime", String.valueOf(this.ejW.mTime));
            this.ejT.addPostData("stSize", String.valueOf(this.ejW.mSize));
            this.ejT.addPostData("stTimesNum", String.valueOf(this.ejW.mTimesNum));
            this.ejT.addPostData("stMode", String.valueOf(this.ejW.mMode));
            this.ejT.addPostData("stMethod", String.valueOf(this.ejW.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.ejW != null) {
            this.mErrorNums = this.ejW.mTimesNum;
        }
        this.ejT.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.ejS.bjw().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.ejS.bjw().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.ejS.bjw().mNetErrorCode;
    }

    public String biR() {
        return this.ejS.bjw().mException;
    }

    public String getErrorString() {
        return this.ejS.bjw().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.ejT != null) {
            this.ejT.cancelNetConnect();
        }
        if (this.ejU != null) {
            this.ejU.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.ejT != null) {
            this.ejT.setCancel();
        }
        if (this.ejU != null) {
            this.ejU.setCancel();
        }
    }

    public void il(boolean z) {
        this.ejV = z;
    }

    private com.baidu.tbadk.core.data.an v(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.ejU == null) {
                this.ejU = new aa(sb.toString());
            } else {
                this.ejU.cancelNetConnect();
            }
            this.ejU.biQ().bjv().mIsNeedAddCommenParam = false;
            this.ejU.biQ().bjv().mIsUseCurrentBDUSS = false;
            this.ejU.biQ().bjv().mNeedBackgroundLogin = false;
            this.ejU.addPostData("un", str);
            this.ejU.addPostData("passwd", str2);
            this.ejU.addPostData("isphone", "0");
            this.ejU.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.ejU.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.ejU.biQ().bjv().bjz().mRequestGzip = true;
            postNetData = this.ejU.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ejU.biQ().bjw().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.parserJson(postNetData);
            String userId = anVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ejS.bjw().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(anVar.getUser().getUserName());
            if (anVar.getUser().getPassword() != null) {
                accountData.setPassword(anVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(anVar.getUser().getUserId());
            accountData.setBDUSS(anVar.getUser().getBDUSS());
            accountData.setPortrait(anVar.getUser().getPortrait());
            if (anVar.getUser() != null && anVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(anVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(anVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (anVar.getAnti() != null) {
                accountData.setTbs(anVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return anVar;
        }
        if (this.ejU.isNetSuccess()) {
            switch (this.ejU.getServerErrorCode()) {
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
        if (!this.ejS.bjv().mIsFromCDN) {
            this.ejS.bjv().b(this.ejT);
        }
        return this.ejT.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.ejT.getPostData();
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
        this.ejT.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.ejS.bjv().ejV) {
            this.ejT.addPostData("sig", StringU.Dg(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.ejS.bjv().ejV = this.ejV && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (biQ().bjv().mIsNeedAddCommenParam) {
                    this.ejS.bjv().b(this.ejT);
                }
                addStatisticsDataParam();
                postMultiNetData = this.ejT.getNetString();
                break;
            case 2:
                if (biQ().bjv().mIsUseCurrentBDUSS) {
                    biQ().bjv().a(this.ejT);
                }
                if (biQ().bjv().mIsNeedAddCommenParam) {
                    this.ejS.bjv().b(this.ejT);
                }
                addStatisticsDataParam();
                postMultiNetData = this.ejT.postNetData();
                break;
            case 3:
                if (biQ().bjv().mIsUseCurrentBDUSS) {
                    biQ().bjv().a(this.ejT);
                }
                if (biQ().bjv().mIsNeedAddCommenParam) {
                    this.ejS.bjv().b(this.ejT);
                }
                addSign();
                postMultiNetData = this.ejT.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.ejS.bjw().isNetSuccess()) {
            ad.a(this.ejW);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.ejS.bjw().isRequestSuccess()) {
            if (this.ejS.bjw().mServerErrorCode == 1 && this.ejS.bjv().mNeedBackgroundLogin) {
                String str = this.ejS.bjw().mErrorString;
                this.ejS.bjw().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bbQ();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    biS();
                    return null;
                }
                com.baidu.tbadk.core.a.b.yO(currentAccountObj.getID());
                if (ReloginManager.bid().big()) {
                    f(currentAccountObj);
                    ReloginManager.bid().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.an v = v(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (v == null) {
                    if (this.ejU != null) {
                        this.ejS.bjw().mErrorString = this.ejU.getErrorString();
                        return null;
                    }
                    this.ejS.bjw().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = nN(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bmj;
        if (!TextUtils.isEmpty(accountData.getID()) && (bmj = com.baidu.tbadk.coreExtra.a.a.bmj()) != null) {
            bmj.f(accountData);
        }
    }

    private String nN(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.ejT.getNetString();
                break;
            case 2:
                postMultiNetData = this.ejT.postNetData();
                break;
            case 3:
                postMultiNetData = this.ejT.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.ejS.bjw().isNetSuccess()) {
            switch (this.ejS.bjw().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    biS();
                    this.ejS.bjw().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void biS() {
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

    public String Aa(String str) throws IOException {
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
        biQ().bjv().a(this.ejT);
        return this.ejT.downloadFile(str, handler, i, i2, i3, z);
    }
}
