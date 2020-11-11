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
    private boolean eMG;
    private com.baidu.tbadk.core.util.a.a eMD = null;
    private s eME = null;
    private aa eMF = null;
    private ad.a eMH = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.eMD = new com.baidu.tbadk.core.util.a.a();
        this.eME = ac.bqR().a(this.eMD);
        this.eMF = null;
        this.eMD.brt().brx().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bR(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a bqN() {
        return this.eMD;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.eMD.brt().brx().mUrl = str;
    }

    public void setUrl(String str) {
        this.eMD.brt().brx().mUrl = str;
    }

    public void ak(boolean z) {
        this.eMD.brt().Mk = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.eME.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.eME.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.eME.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.eME.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.eME.getPostData();
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
        if (this.eMH == null) {
            this.eMH = ad.bqS();
        }
        if (this.eMH != null) {
            this.eME.addPostData("stTime", String.valueOf(this.eMH.mTime));
            this.eME.addPostData("stSize", String.valueOf(this.eMH.mSize));
            this.eME.addPostData("stTimesNum", String.valueOf(this.eMH.mTimesNum));
            this.eME.addPostData("stMode", String.valueOf(this.eMH.mMode));
            this.eME.addPostData("stMethod", String.valueOf(this.eMH.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.eMH != null) {
            this.mErrorNums = this.eMH.mTimesNum;
        }
        this.eME.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.eMD.bru().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.eMD.bru().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.eMD.bru().mNetErrorCode;
    }

    public String bqO() {
        return this.eMD.bru().mException;
    }

    public String getErrorString() {
        return this.eMD.bru().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.eME != null) {
            this.eME.cancelNetConnect();
        }
        if (this.eMF != null) {
            this.eMF.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.eME != null) {
            this.eME.setCancel();
        }
        if (this.eMF != null) {
            this.eMF.setCancel();
        }
    }

    public void ja(boolean z) {
        this.eMG = z;
    }

    private com.baidu.tbadk.core.data.an w(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.eMF == null) {
                this.eMF = new aa(sb.toString());
            } else {
                this.eMF.cancelNetConnect();
            }
            this.eMF.bqN().brt().mIsNeedAddCommenParam = false;
            this.eMF.bqN().brt().mIsUseCurrentBDUSS = false;
            this.eMF.bqN().brt().mNeedBackgroundLogin = false;
            this.eMF.addPostData("un", str);
            this.eMF.addPostData("passwd", str2);
            this.eMF.addPostData("isphone", "0");
            this.eMF.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.eMF.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.eMF.bqN().brt().brx().mRequestGzip = true;
            postNetData = this.eMF.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.eMF.bqN().bru().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.parserJson(postNetData);
            String userId = anVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.eMD.bru().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.eMF.isNetSuccess()) {
            switch (this.eMF.getServerErrorCode()) {
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
        if (!this.eMD.brt().mIsFromCDN) {
            this.eMD.brt().b(this.eME);
        }
        return this.eME.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.eME.getPostData();
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
        this.eME.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.eMD.brt().eMG) {
            this.eME.addPostData("sig", StringU.EV(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.eMD.brt().eMG = this.eMG && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bqN().brt().mIsNeedAddCommenParam) {
                    this.eMD.brt().b(this.eME);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eME.getNetString();
                break;
            case 2:
                if (bqN().brt().mIsUseCurrentBDUSS) {
                    bqN().brt().a(this.eME);
                }
                if (bqN().brt().mIsNeedAddCommenParam) {
                    this.eMD.brt().b(this.eME);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eME.postNetData();
                break;
            case 3:
                if (bqN().brt().mIsUseCurrentBDUSS) {
                    bqN().brt().a(this.eME);
                }
                if (bqN().brt().mIsNeedAddCommenParam) {
                    this.eMD.brt().b(this.eME);
                }
                addSign();
                postMultiNetData = this.eME.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.eMD.bru().isNetSuccess()) {
            ad.a(this.eMH);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.eMD.bru().isRequestSuccess()) {
            if (this.eMD.bru().mServerErrorCode == 1 && this.eMD.brt().mNeedBackgroundLogin) {
                String str = this.eMD.bru().mErrorString;
                this.eMD.bru().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bjL();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bqP();
                    return null;
                }
                com.baidu.tbadk.core.a.b.AC(currentAccountObj.getID());
                if (ReloginManager.bpZ().bqc()) {
                    f(currentAccountObj);
                    ReloginManager.bpZ().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.an w = w(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (w == null) {
                    if (this.eMF != null) {
                        this.eMD.bru().mErrorString = this.eMF.getErrorString();
                        return null;
                    }
                    this.eMD.bru().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = oR(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bug;
        if (!TextUtils.isEmpty(accountData.getID()) && (bug = com.baidu.tbadk.coreExtra.a.a.bug()) != null) {
            bug.f(accountData);
        }
    }

    private String oR(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.eME.getNetString();
                break;
            case 2:
                postMultiNetData = this.eME.postNetData();
                break;
            case 3:
                postMultiNetData = this.eME.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.eMD.bru().isNetSuccess()) {
            switch (this.eMD.bru().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bqP();
                    this.eMD.bru().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bqP() {
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

    public String BP(String str) throws IOException {
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

    public String dQ(String str, String str2) {
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
        bqN().brt().a(this.eME);
        return this.eME.downloadFile(str, handler, i, i2, i3, z);
    }
}
