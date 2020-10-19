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
    private boolean eyv;
    private com.baidu.tbadk.core.util.a.a eys = null;
    private s eyt = null;
    private aa eyu = null;
    private ad.a eyw = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.eys = new com.baidu.tbadk.core.util.a.a();
        this.eyt = ac.bmy().a(this.eys);
        this.eyu = null;
        this.eys.bna().bne().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bR(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a bmu() {
        return this.eys;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.eys.bna().bne().mUrl = str;
    }

    public void setUrl(String str) {
        this.eys.bna().bne().mUrl = str;
    }

    public void ak(boolean z) {
        this.eys.bna().Mj = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.eyt.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.eyt.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.eyt.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.eyt.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.eyt.getPostData();
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
        if (this.eyw == null) {
            this.eyw = ad.bmz();
        }
        if (this.eyw != null) {
            this.eyt.addPostData("stTime", String.valueOf(this.eyw.mTime));
            this.eyt.addPostData("stSize", String.valueOf(this.eyw.mSize));
            this.eyt.addPostData("stTimesNum", String.valueOf(this.eyw.mTimesNum));
            this.eyt.addPostData("stMode", String.valueOf(this.eyw.mMode));
            this.eyt.addPostData("stMethod", String.valueOf(this.eyw.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.eyw != null) {
            this.mErrorNums = this.eyw.mTimesNum;
        }
        this.eyt.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.eys.bnb().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.eys.bnb().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.eys.bnb().mNetErrorCode;
    }

    public String bmv() {
        return this.eys.bnb().mException;
    }

    public String getErrorString() {
        return this.eys.bnb().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.eyt != null) {
            this.eyt.cancelNetConnect();
        }
        if (this.eyu != null) {
            this.eyu.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.eyt != null) {
            this.eyt.setCancel();
        }
        if (this.eyu != null) {
            this.eyu.setCancel();
        }
    }

    public void iE(boolean z) {
        this.eyv = z;
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
            if (this.eyu == null) {
                this.eyu = new aa(sb.toString());
            } else {
                this.eyu.cancelNetConnect();
            }
            this.eyu.bmu().bna().mIsNeedAddCommenParam = false;
            this.eyu.bmu().bna().mIsUseCurrentBDUSS = false;
            this.eyu.bmu().bna().mNeedBackgroundLogin = false;
            this.eyu.addPostData("un", str);
            this.eyu.addPostData("passwd", str2);
            this.eyu.addPostData("isphone", "0");
            this.eyu.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.eyu.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.eyu.bmu().bna().bne().mRequestGzip = true;
            postNetData = this.eyu.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.eyu.bmu().bnb().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.parserJson(postNetData);
            String userId = anVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.eys.bnb().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.eyu.isNetSuccess()) {
            switch (this.eyu.getServerErrorCode()) {
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
        if (!this.eys.bna().mIsFromCDN) {
            this.eys.bna().b(this.eyt);
        }
        return this.eyt.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.eyt.getPostData();
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
        this.eyt.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.eys.bna().eyv) {
            this.eyt.addPostData("sig", StringU.Eo(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.eys.bna().eyv = this.eyv && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bmu().bna().mIsNeedAddCommenParam) {
                    this.eys.bna().b(this.eyt);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eyt.getNetString();
                break;
            case 2:
                if (bmu().bna().mIsUseCurrentBDUSS) {
                    bmu().bna().a(this.eyt);
                }
                if (bmu().bna().mIsNeedAddCommenParam) {
                    this.eys.bna().b(this.eyt);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eyt.postNetData();
                break;
            case 3:
                if (bmu().bna().mIsUseCurrentBDUSS) {
                    bmu().bna().a(this.eyt);
                }
                if (bmu().bna().mIsNeedAddCommenParam) {
                    this.eys.bna().b(this.eyt);
                }
                addSign();
                postMultiNetData = this.eyt.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.eys.bnb().isNetSuccess()) {
            ad.a(this.eyw);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.eys.bnb().isRequestSuccess()) {
            if (this.eys.bnb().mServerErrorCode == 1 && this.eys.bna().mNeedBackgroundLogin) {
                String str = this.eys.bnb().mErrorString;
                this.eys.bnb().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bfs();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bmw();
                    return null;
                }
                com.baidu.tbadk.core.a.b.zV(currentAccountObj.getID());
                if (ReloginManager.blG().blJ()) {
                    f(currentAccountObj);
                    ReloginManager.blG().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.an v = v(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (v == null) {
                    if (this.eyu != null) {
                        this.eys.bnb().mErrorString = this.eyu.getErrorString();
                        return null;
                    }
                    this.eys.bnb().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = ow(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bpN;
        if (!TextUtils.isEmpty(accountData.getID()) && (bpN = com.baidu.tbadk.coreExtra.a.a.bpN()) != null) {
            bpN.f(accountData);
        }
    }

    private String ow(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.eyt.getNetString();
                break;
            case 2:
                postMultiNetData = this.eyt.postNetData();
                break;
            case 3:
                postMultiNetData = this.eyt.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.eys.bnb().isNetSuccess()) {
            switch (this.eys.bnb().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bmw();
                    this.eys.bnb().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bmw() {
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

    public String Bi(String str) throws IOException {
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

    public String dJ(String str, String str2) {
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
        bmu().bna().a(this.eyt);
        return this.eyt.downloadFile(str, handler, i, i2, i3, z);
    }
}
