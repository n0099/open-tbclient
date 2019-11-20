package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x {
    private boolean cis;
    private com.baidu.tbadk.core.util.a.a cip = null;
    private q ciq = null;
    private x cir = null;
    private aa.a cit = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.cip = new com.baidu.tbadk.core.util.a.a();
        this.ciq = z.amt().a(this.cip);
        this.cir = null;
        this.cip.amP().amS().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.ak(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a amp() {
        return this.cip;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.cip.amP().amS().mUrl = str;
    }

    public void setUrl(String str) {
        this.cip.amP().amS().mUrl = str;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.ciq.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.ciq.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.ciq.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.ciq.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.ciq.getPostData();
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
        if (this.cit == null) {
            this.cit = aa.amu();
        }
        if (this.cit != null) {
            this.ciq.addPostData("stTime", String.valueOf(this.cit.mTime));
            this.ciq.addPostData("stSize", String.valueOf(this.cit.mSize));
            this.ciq.addPostData("stTimesNum", String.valueOf(this.cit.mTimesNum));
            this.ciq.addPostData("stMode", String.valueOf(this.cit.mMode));
            this.ciq.addPostData("stMethod", String.valueOf(this.cit.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.cit != null) {
            this.mErrorNums = this.cit.mTimesNum;
        }
        this.ciq.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.cip.amQ().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.cip.amQ().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.cip.amQ().mNetErrorCode;
    }

    public String amq() {
        return this.cip.amQ().mException;
    }

    public String getErrorString() {
        return this.cip.amQ().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.ciq != null) {
            this.ciq.cancelNetConnect();
        }
        if (this.cir != null) {
            this.cir.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.ciq != null) {
            this.ciq.setCancel();
        }
        if (this.cir != null) {
            this.cir.setCancel();
        }
    }

    public void ek(boolean z) {
        this.cis = z;
    }

    private com.baidu.tbadk.core.data.ag t(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.cir == null) {
                this.cir = new x(sb.toString());
            } else {
                this.cir.cancelNetConnect();
            }
            this.cir.amp().amP().mIsNeedAddCommenParam = false;
            this.cir.amp().amP().mIsUseCurrentBDUSS = false;
            this.cir.amp().amP().mNeedBackgroundLogin = false;
            this.cir.addPostData("un", str);
            this.cir.addPostData("passwd", str2);
            this.cir.addPostData("isphone", "0");
            this.cir.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.cir.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.cir.amp().amP().amS().mRequestGzip = true;
            postNetData = this.cir.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.cir.amp().amQ().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(postNetData);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.cip.amQ().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(agVar.getUser().getUserName());
            if (agVar.getUser().getPassword() != null) {
                accountData.setPassword(agVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(agVar.getUser().getUserId());
            accountData.setBDUSS(agVar.getUser().getBDUSS());
            accountData.setPortrait(agVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (agVar.getAnti() != null) {
                accountData.setTbs(agVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return agVar;
        }
        if (this.cir.isNetSuccess()) {
            switch (this.cir.getServerErrorCode()) {
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
        if (!this.cip.amP().mIsFromCDN) {
            this.cip.amP().b(this.ciq);
        }
        return this.ciq.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.ciq.getPostData();
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
        this.ciq.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.cip.amP().cis) {
            this.ciq.addPostData("sig", StringU.qF(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.cip.amP().cis = this.cis && com.baidu.tbadk.t.w.isOn();
        switch (i) {
            case 1:
                if (amp().amP().mIsNeedAddCommenParam) {
                    this.cip.amP().b(this.ciq);
                }
                addStatisticsDataParam();
                postMultiNetData = this.ciq.getNetString();
                break;
            case 2:
                if (amp().amP().mIsUseCurrentBDUSS) {
                    amp().amP().a(this.ciq);
                }
                if (amp().amP().mIsNeedAddCommenParam) {
                    this.cip.amP().b(this.ciq);
                }
                addStatisticsDataParam();
                postMultiNetData = this.ciq.postNetData();
                break;
            case 3:
                if (amp().amP().mIsUseCurrentBDUSS) {
                    amp().amP().a(this.ciq);
                }
                if (amp().amP().mIsNeedAddCommenParam) {
                    this.cip.amP().b(this.ciq);
                }
                addSign();
                postMultiNetData = this.ciq.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.cip.amQ().isNetSuccess()) {
            aa.a(this.cit);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.cip.amQ().isRequestSuccess()) {
            if (this.cip.amQ().mServerErrorCode == 1 && this.cip.amP().mNeedBackgroundLogin) {
                String str = this.cip.amQ().mErrorString;
                this.cip.amQ().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.ags();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    amr();
                    return null;
                }
                com.baidu.tbadk.core.a.b.mK(currentAccountObj.getID());
                if (ReloginManager.alI().alL()) {
                    f(currentAccountObj);
                    ReloginManager.alI().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag t = t(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (t == null) {
                    if (this.cir != null) {
                        this.cip.amQ().mErrorString = this.cir.getErrorString();
                        return null;
                    }
                    this.cip.amQ().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = in(i);
            }
            com.baidu.tieba.i.a.a(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c aoI;
        if (!TextUtils.isEmpty(accountData.getID()) && (aoI = com.baidu.tbadk.coreExtra.a.a.aoI()) != null) {
            aoI.f(accountData);
        }
    }

    private String in(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.ciq.getNetString();
                break;
            case 2:
                postMultiNetData = this.ciq.postNetData();
                break;
            case 3:
                postMultiNetData = this.ciq.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.cip.amQ().isNetSuccess()) {
            switch (this.cip.amQ().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    amr();
                    this.cip.amQ().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void amr() {
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

    public String nN(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream GetStreamFromFile = m.GetStreamFromFile(str);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
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
        addPostData("pic", bArr);
        return postMultiNetData();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        amp().amP().a(this.ciq);
        return this.ciq.downloadFile(str, handler, i, i2, i3, z);
    }
}
