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
    private boolean cjj;
    private com.baidu.tbadk.core.util.a.a cjg = null;
    private q cjh = null;
    private x cji = null;
    private aa.a cjk = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.cjg = new com.baidu.tbadk.core.util.a.a();
        this.cjh = z.amv().a(this.cjg);
        this.cji = null;
        this.cjg.amR().amU().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.ak(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a amr() {
        return this.cjg;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.cjg.amR().amU().mUrl = str;
    }

    public void setUrl(String str) {
        this.cjg.amR().amU().mUrl = str;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.cjh.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.cjh.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.cjh.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.cjh.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.cjh.getPostData();
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
        if (this.cjk == null) {
            this.cjk = aa.amw();
        }
        if (this.cjk != null) {
            this.cjh.addPostData("stTime", String.valueOf(this.cjk.mTime));
            this.cjh.addPostData("stSize", String.valueOf(this.cjk.mSize));
            this.cjh.addPostData("stTimesNum", String.valueOf(this.cjk.mTimesNum));
            this.cjh.addPostData("stMode", String.valueOf(this.cjk.mMode));
            this.cjh.addPostData("stMethod", String.valueOf(this.cjk.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.cjk != null) {
            this.mErrorNums = this.cjk.mTimesNum;
        }
        this.cjh.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.cjg.amS().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.cjg.amS().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.cjg.amS().mNetErrorCode;
    }

    public String ams() {
        return this.cjg.amS().mException;
    }

    public String getErrorString() {
        return this.cjg.amS().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.cjh != null) {
            this.cjh.cancelNetConnect();
        }
        if (this.cji != null) {
            this.cji.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.cjh != null) {
            this.cjh.setCancel();
        }
        if (this.cji != null) {
            this.cji.setCancel();
        }
    }

    public void ek(boolean z) {
        this.cjj = z;
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
            if (this.cji == null) {
                this.cji = new x(sb.toString());
            } else {
                this.cji.cancelNetConnect();
            }
            this.cji.amr().amR().mIsNeedAddCommenParam = false;
            this.cji.amr().amR().mIsUseCurrentBDUSS = false;
            this.cji.amr().amR().mNeedBackgroundLogin = false;
            this.cji.addPostData("un", str);
            this.cji.addPostData("passwd", str2);
            this.cji.addPostData("isphone", "0");
            this.cji.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.cji.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.cji.amr().amR().amU().mRequestGzip = true;
            postNetData = this.cji.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.cji.amr().amS().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(postNetData);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.cjg.amS().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.cji.isNetSuccess()) {
            switch (this.cji.getServerErrorCode()) {
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
        if (!this.cjg.amR().mIsFromCDN) {
            this.cjg.amR().b(this.cjh);
        }
        return this.cjh.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.cjh.getPostData();
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
        this.cjh.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.cjg.amR().cjj) {
            this.cjh.addPostData("sig", StringU.qF(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.cjg.amR().cjj = this.cjj && com.baidu.tbadk.t.w.isOn();
        switch (i) {
            case 1:
                if (amr().amR().mIsNeedAddCommenParam) {
                    this.cjg.amR().b(this.cjh);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cjh.getNetString();
                break;
            case 2:
                if (amr().amR().mIsUseCurrentBDUSS) {
                    amr().amR().a(this.cjh);
                }
                if (amr().amR().mIsNeedAddCommenParam) {
                    this.cjg.amR().b(this.cjh);
                }
                addStatisticsDataParam();
                postMultiNetData = this.cjh.postNetData();
                break;
            case 3:
                if (amr().amR().mIsUseCurrentBDUSS) {
                    amr().amR().a(this.cjh);
                }
                if (amr().amR().mIsNeedAddCommenParam) {
                    this.cjg.amR().b(this.cjh);
                }
                addSign();
                postMultiNetData = this.cjh.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.cjg.amS().isNetSuccess()) {
            aa.a(this.cjk);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.cjg.amS().isRequestSuccess()) {
            if (this.cjg.amS().mServerErrorCode == 1 && this.cjg.amR().mNeedBackgroundLogin) {
                String str = this.cjg.amS().mErrorString;
                this.cjg.amS().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.agu();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    amt();
                    return null;
                }
                com.baidu.tbadk.core.a.b.mK(currentAccountObj.getID());
                if (ReloginManager.alK().alN()) {
                    f(currentAccountObj);
                    ReloginManager.alK().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag t = t(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (t == null) {
                    if (this.cji != null) {
                        this.cjg.amS().mErrorString = this.cji.getErrorString();
                        return null;
                    }
                    this.cjg.amS().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = io(i);
            }
            com.baidu.tieba.i.a.a(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c aoK;
        if (!TextUtils.isEmpty(accountData.getID()) && (aoK = com.baidu.tbadk.coreExtra.a.a.aoK()) != null) {
            aoK.f(accountData);
        }
    }

    private String io(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.cjh.getNetString();
                break;
            case 2:
                postMultiNetData = this.cjh.postNetData();
                break;
            case 3:
                postMultiNetData = this.cjh.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.cjg.amS().isNetSuccess()) {
            switch (this.cjg.amS().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    amt();
                    this.cjg.amS().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void amt() {
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
        amr().amR().a(this.cjh);
        return this.cjh.downloadFile(str, handler, i, i2, i3, z);
    }
}
