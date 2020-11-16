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
    private boolean eLF;
    private com.baidu.tbadk.core.util.a.a eLC = null;
    private s eLD = null;
    private aa eLE = null;
    private ad.a eLG = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.eLC = new com.baidu.tbadk.core.util.a.a();
        this.eLD = ac.bqe().a(this.eLC);
        this.eLE = null;
        this.eLC.bqH().bqL().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bR(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a bqa() {
        return this.eLC;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.eLC.bqH().bqL().mUrl = str;
    }

    public void setUrl(String str) {
        this.eLC.bqH().bqL().mUrl = str;
    }

    public void ak(boolean z) {
        this.eLC.bqH().Mk = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.eLD.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.eLD.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.eLD.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.eLD.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.eLD.getPostData();
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
        if (this.eLG == null) {
            this.eLG = ad.bqf();
        }
        if (this.eLG != null) {
            this.eLD.addPostData("stTime", String.valueOf(this.eLG.mTime));
            this.eLD.addPostData("stSize", String.valueOf(this.eLG.mSize));
            this.eLD.addPostData("stTimesNum", String.valueOf(this.eLG.mTimesNum));
            this.eLD.addPostData("stMode", String.valueOf(this.eLG.mMode));
            this.eLD.addPostData("stMethod", String.valueOf(this.eLG.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.eLG != null) {
            this.mErrorNums = this.eLG.mTimesNum;
        }
        this.eLD.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.eLC.bqI().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.eLC.bqI().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.eLC.bqI().mNetErrorCode;
    }

    public String bqb() {
        return this.eLC.bqI().mException;
    }

    public String getErrorString() {
        return this.eLC.bqI().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.eLD != null) {
            this.eLD.cancelNetConnect();
        }
        if (this.eLE != null) {
            this.eLE.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.eLD != null) {
            this.eLD.setCancel();
        }
        if (this.eLE != null) {
            this.eLE.setCancel();
        }
    }

    public void jb(boolean z) {
        this.eLF = z;
    }

    private com.baidu.tbadk.core.data.ao w(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.eLE == null) {
                this.eLE = new aa(sb.toString());
            } else {
                this.eLE.cancelNetConnect();
            }
            this.eLE.bqa().bqH().mIsNeedAddCommenParam = false;
            this.eLE.bqa().bqH().mIsUseCurrentBDUSS = false;
            this.eLE.bqa().bqH().mNeedBackgroundLogin = false;
            this.eLE.addPostData("un", str);
            this.eLE.addPostData("passwd", str2);
            this.eLE.addPostData("isphone", "0");
            this.eLE.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.eLE.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.eLE.bqa().bqH().bqL().mRequestGzip = true;
            postNetData = this.eLE.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.eLE.bqa().bqI().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
            aoVar.parserJson(postNetData);
            String userId = aoVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.eLC.bqI().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aoVar.getUser().getUserName());
            if (aoVar.getUser().getPassword() != null) {
                accountData.setPassword(aoVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aoVar.getUser().getUserId());
            accountData.setBDUSS(aoVar.getUser().getBDUSS());
            accountData.setPortrait(aoVar.getUser().getPortrait());
            if (aoVar.getUser() != null && aoVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(aoVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(aoVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (aoVar.getAnti() != null) {
                accountData.setTbs(aoVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aoVar;
        }
        if (this.eLE.isNetSuccess()) {
            switch (this.eLE.getServerErrorCode()) {
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
        if (!this.eLC.bqH().mIsFromCDN) {
            this.eLC.bqH().b(this.eLD);
        }
        return this.eLD.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.eLD.getPostData();
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
        this.eLD.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.eLC.bqH().eLF) {
            this.eLD.addPostData("sig", StringU.Ew(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.eLC.bqH().eLF = this.eLF && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bqa().bqH().mIsNeedAddCommenParam) {
                    this.eLC.bqH().b(this.eLD);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eLD.getNetString();
                break;
            case 2:
                if (bqa().bqH().mIsUseCurrentBDUSS) {
                    bqa().bqH().a(this.eLD);
                }
                if (bqa().bqH().mIsNeedAddCommenParam) {
                    this.eLC.bqH().b(this.eLD);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eLD.postNetData();
                break;
            case 3:
                if (bqa().bqH().mIsUseCurrentBDUSS) {
                    bqa().bqH().a(this.eLD);
                }
                if (bqa().bqH().mIsNeedAddCommenParam) {
                    this.eLC.bqH().b(this.eLD);
                }
                addSign();
                postMultiNetData = this.eLD.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.eLC.bqI().isNetSuccess()) {
            ad.a(this.eLG);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.eLC.bqI().isRequestSuccess()) {
            if (this.eLC.bqI().mServerErrorCode == 1 && this.eLC.bqH().mNeedBackgroundLogin) {
                String str = this.eLC.bqI().mErrorString;
                this.eLC.bqI().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.biP();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bqc();
                    return null;
                }
                com.baidu.tbadk.core.a.b.zX(currentAccountObj.getID());
                if (ReloginManager.bpm().bpp()) {
                    f(currentAccountObj);
                    ReloginManager.bpm().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ao w = w(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (w == null) {
                    if (this.eLE != null) {
                        this.eLC.bqI().mErrorString = this.eLE.getErrorString();
                        return null;
                    }
                    this.eLC.bqI().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = pm(i);
            }
            com.baidu.tieba.k.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c btw;
        if (!TextUtils.isEmpty(accountData.getID()) && (btw = com.baidu.tbadk.coreExtra.a.a.btw()) != null) {
            btw.f(accountData);
        }
    }

    private String pm(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.eLD.getNetString();
                break;
            case 2:
                postMultiNetData = this.eLD.postNetData();
                break;
            case 3:
                postMultiNetData = this.eLD.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.eLC.bqI().isNetSuccess()) {
            switch (this.eLC.bqI().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bqc();
                    this.eLC.bqI().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bqc() {
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

    public String Bo(String str) throws IOException {
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

    public String dP(String str, String str2) {
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
        bqa().bqH().a(this.eLD);
        return this.eLD.downloadFile(str, handler, i, i2, i3, z);
    }
}
