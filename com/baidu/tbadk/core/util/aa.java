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
/* loaded from: classes2.dex */
public class aa {
    private boolean ejR;
    private com.baidu.tbadk.core.util.a.a ejO = null;
    private s ejP = null;
    private aa ejQ = null;
    private ad.a ejS = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.ejO = new com.baidu.tbadk.core.util.a.a();
        this.ejP = ac.biU().a(this.ejO);
        this.ejQ = null;
        this.ejO.bjv().bjz().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bO(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bP(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a biQ() {
        return this.ejO;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.ejO.bjv().bjz().mUrl = str;
    }

    public void setUrl(String str) {
        this.ejO.bjv().bjz().mUrl = str;
    }

    public void al(boolean z) {
        this.ejO.bjv().LG = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.ejP.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.ejP.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.ejP.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.ejP.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.ejP.getPostData();
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
        if (this.ejS == null) {
            this.ejS = ad.biV();
        }
        if (this.ejS != null) {
            this.ejP.addPostData("stTime", String.valueOf(this.ejS.mTime));
            this.ejP.addPostData("stSize", String.valueOf(this.ejS.mSize));
            this.ejP.addPostData("stTimesNum", String.valueOf(this.ejS.mTimesNum));
            this.ejP.addPostData("stMode", String.valueOf(this.ejS.mMode));
            this.ejP.addPostData("stMethod", String.valueOf(this.ejS.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.ejS != null) {
            this.mErrorNums = this.ejS.mTimesNum;
        }
        this.ejP.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.ejO.bjw().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.ejO.bjw().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.ejO.bjw().mNetErrorCode;
    }

    public String biR() {
        return this.ejO.bjw().mException;
    }

    public String getErrorString() {
        return this.ejO.bjw().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.ejP != null) {
            this.ejP.cancelNetConnect();
        }
        if (this.ejQ != null) {
            this.ejQ.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.ejP != null) {
            this.ejP.setCancel();
        }
        if (this.ejQ != null) {
            this.ejQ.setCancel();
        }
    }

    public void ik(boolean z) {
        this.ejR = z;
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
            if (this.ejQ == null) {
                this.ejQ = new aa(sb.toString());
            } else {
                this.ejQ.cancelNetConnect();
            }
            this.ejQ.biQ().bjv().mIsNeedAddCommenParam = false;
            this.ejQ.biQ().bjv().mIsUseCurrentBDUSS = false;
            this.ejQ.biQ().bjv().mNeedBackgroundLogin = false;
            this.ejQ.addPostData("un", str);
            this.ejQ.addPostData("passwd", str2);
            this.ejQ.addPostData("isphone", "0");
            this.ejQ.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.ejQ.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.ejQ.biQ().bjv().bjz().mRequestGzip = true;
            postNetData = this.ejQ.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.ejQ.biQ().bjw().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.parserJson(postNetData);
            String userId = anVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.ejO.bjw().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.ejQ.isNetSuccess()) {
            switch (this.ejQ.getServerErrorCode()) {
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
        if (!this.ejO.bjv().mIsFromCDN) {
            this.ejO.bjv().b(this.ejP);
        }
        return this.ejP.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.ejP.getPostData();
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
        this.ejP.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.ejO.bjv().ejR) {
            this.ejP.addPostData("sig", StringU.Df(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.ejO.bjv().ejR = this.ejR && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (biQ().bjv().mIsNeedAddCommenParam) {
                    this.ejO.bjv().b(this.ejP);
                }
                addStatisticsDataParam();
                postMultiNetData = this.ejP.getNetString();
                break;
            case 2:
                if (biQ().bjv().mIsUseCurrentBDUSS) {
                    biQ().bjv().a(this.ejP);
                }
                if (biQ().bjv().mIsNeedAddCommenParam) {
                    this.ejO.bjv().b(this.ejP);
                }
                addStatisticsDataParam();
                postMultiNetData = this.ejP.postNetData();
                break;
            case 3:
                if (biQ().bjv().mIsUseCurrentBDUSS) {
                    biQ().bjv().a(this.ejP);
                }
                if (biQ().bjv().mIsNeedAddCommenParam) {
                    this.ejO.bjv().b(this.ejP);
                }
                addSign();
                postMultiNetData = this.ejP.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.ejO.bjw().isNetSuccess()) {
            ad.a(this.ejS);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.ejO.bjw().isRequestSuccess()) {
            if (this.ejO.bjw().mServerErrorCode == 1 && this.ejO.bjv().mNeedBackgroundLogin) {
                String str = this.ejO.bjw().mErrorString;
                this.ejO.bjw().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bbQ();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    biS();
                    return null;
                }
                com.baidu.tbadk.core.a.b.yN(currentAccountObj.getID());
                if (ReloginManager.bid().big()) {
                    f(currentAccountObj);
                    ReloginManager.bid().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.an v = v(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (v == null) {
                    if (this.ejQ != null) {
                        this.ejO.bjw().mErrorString = this.ejQ.getErrorString();
                        return null;
                    }
                    this.ejO.bjw().mErrorString = str;
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
                postMultiNetData = this.ejP.getNetString();
                break;
            case 2:
                postMultiNetData = this.ejP.postNetData();
                break;
            case 3:
                postMultiNetData = this.ejP.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.ejO.bjw().isNetSuccess()) {
            switch (this.ejO.bjw().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    biS();
                    this.ejO.bjw().mErrorString = "";
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

    public String zZ(String str) throws IOException {
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
        biQ().bjv().a(this.ejP);
        return this.ejP.downloadFile(str, handler, i, i2, i3, z);
    }
}
