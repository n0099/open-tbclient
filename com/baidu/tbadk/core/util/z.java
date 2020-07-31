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
import com.baidu.tbadk.core.util.ac;
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
public class z {
    private boolean eaj;
    private com.baidu.tbadk.core.util.a.a eag = null;
    private s eah = null;
    private z eai = null;
    private ac.a eak = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.eag = new com.baidu.tbadk.core.util.a.a();
        this.eah = ab.baz().a(this.eag);
        this.eai = null;
        this.eag.baW().bba().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bJ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bK(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a bav() {
        return this.eag;
    }

    public z() {
        initNetWork();
    }

    public z(String str) {
        initNetWork();
        this.eag.baW().bba().mUrl = str;
    }

    public void setUrl(String str) {
        this.eag.baW().bba().mUrl = str;
    }

    public void ak(boolean z) {
        this.eag.baW().Lb = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.eah.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.eah.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.eah.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.eah.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.eah.getPostData();
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
        if (this.eak == null) {
            this.eak = ac.baA();
        }
        if (this.eak != null) {
            this.eah.addPostData("stTime", String.valueOf(this.eak.mTime));
            this.eah.addPostData("stSize", String.valueOf(this.eak.mSize));
            this.eah.addPostData("stTimesNum", String.valueOf(this.eak.mTimesNum));
            this.eah.addPostData("stMode", String.valueOf(this.eak.mMode));
            this.eah.addPostData("stMethod", String.valueOf(this.eak.mMethod));
        }
        this.mErrorNums = ac.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.eak != null) {
            this.mErrorNums = this.eak.mTimesNum;
        }
        this.eah.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.eag.baX().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.eag.baX().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.eag.baX().mNetErrorCode;
    }

    public String baw() {
        return this.eag.baX().mException;
    }

    public String getErrorString() {
        return this.eag.baX().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.eah != null) {
            this.eah.cancelNetConnect();
        }
        if (this.eai != null) {
            this.eai.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.eah != null) {
            this.eah.setCancel();
        }
        if (this.eai != null) {
            this.eai.setCancel();
        }
    }

    public void hO(boolean z) {
        this.eaj = z;
    }

    private com.baidu.tbadk.core.data.am w(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.eai == null) {
                this.eai = new z(sb.toString());
            } else {
                this.eai.cancelNetConnect();
            }
            this.eai.bav().baW().mIsNeedAddCommenParam = false;
            this.eai.bav().baW().mIsUseCurrentBDUSS = false;
            this.eai.bav().baW().mNeedBackgroundLogin = false;
            this.eai.addPostData("un", str);
            this.eai.addPostData("passwd", str2);
            this.eai.addPostData("isphone", "0");
            this.eai.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.eai.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.eai.bav().baW().bba().mRequestGzip = true;
            postNetData = this.eai.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.eai.bav().baX().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.parserJson(postNetData);
            String userId = amVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.eag.baX().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(amVar.getUser().getUserName());
            if (amVar.getUser().getPassword() != null) {
                accountData.setPassword(amVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(amVar.getUser().getUserId());
            accountData.setBDUSS(amVar.getUser().getBDUSS());
            accountData.setPortrait(amVar.getUser().getPortrait());
            if (amVar.getUser() != null && amVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(amVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(amVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (amVar.getAnti() != null) {
                accountData.setTbs(amVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return amVar;
        }
        if (this.eai.isNetSuccess()) {
            switch (this.eai.getServerErrorCode()) {
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
        if (!this.eag.baW().mIsFromCDN) {
            this.eag.baW().b(this.eah);
        }
        return this.eah.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.eah.getPostData();
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
        this.eah.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.eag.baW().eaj) {
            this.eah.addPostData("sig", StringU.AL(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.eag.baW().eaj = this.eaj && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bav().baW().mIsNeedAddCommenParam) {
                    this.eag.baW().b(this.eah);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eah.getNetString();
                break;
            case 2:
                if (bav().baW().mIsUseCurrentBDUSS) {
                    bav().baW().a(this.eah);
                }
                if (bav().baW().mIsNeedAddCommenParam) {
                    this.eag.baW().b(this.eah);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eah.postNetData();
                break;
            case 3:
                if (bav().baW().mIsUseCurrentBDUSS) {
                    bav().baW().a(this.eah);
                }
                if (bav().baW().mIsNeedAddCommenParam) {
                    this.eag.baW().b(this.eah);
                }
                addSign();
                postMultiNetData = this.eah.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.eag.baX().isNetSuccess()) {
            ac.a(this.eak);
            ac.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.eag.baX().isRequestSuccess()) {
            if (this.eag.baX().mServerErrorCode == 1 && this.eag.baW().mNeedBackgroundLogin) {
                String str = this.eag.baX().mErrorString;
                this.eag.baX().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.aTz();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bax();
                    return null;
                }
                com.baidu.tbadk.core.a.b.wC(currentAccountObj.getID());
                if (ReloginManager.aZI().aZL()) {
                    f(currentAccountObj);
                    ReloginManager.aZI().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.am w = w(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (w == null) {
                    if (this.eai != null) {
                        this.eag.baX().mErrorString = this.eai.getErrorString();
                        return null;
                    }
                    this.eag.baX().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = lH(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bdD;
        if (!TextUtils.isEmpty(accountData.getID()) && (bdD = com.baidu.tbadk.coreExtra.a.a.bdD()) != null) {
            bdD.f(accountData);
        }
    }

    private String lH(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.eah.getNetString();
                break;
            case 2:
                postMultiNetData = this.eah.postNetData();
                break;
            case 3:
                postMultiNetData = this.eah.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.eag.baX().isNetSuccess()) {
            switch (this.eag.baX().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bax();
                    this.eag.baX().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bax() {
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

    public String xL(String str) throws IOException {
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
        bav().baW().a(this.eah);
        return this.eah.downloadFile(str, handler, i, i2, i3, z);
    }
}
