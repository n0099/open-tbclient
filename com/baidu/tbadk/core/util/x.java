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
    private boolean dNa;
    private com.baidu.tbadk.core.util.a.a dMX = null;
    private q dMY = null;
    private x dMZ = null;
    private aa.a dNb = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.dMX = new com.baidu.tbadk.core.util.a.a();
        this.dMY = z.aUE().a(this.dMX);
        this.dMZ = null;
        this.dMX.aVa().aVe().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bK(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bM(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.a.a aUA() {
        return this.dMX;
    }

    public x() {
        initNetWork();
    }

    public x(String str) {
        initNetWork();
        this.dMX.aVa().aVe().mUrl = str;
    }

    public void setUrl(String str) {
        this.dMX.aVa().aVe().mUrl = str;
    }

    public void aj(boolean z) {
        this.dMX.aVa().KA = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.dMY.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.dMY.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.dMY.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.dMY.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.dMY.getPostData();
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
        if (this.dNb == null) {
            this.dNb = aa.aUF();
        }
        if (this.dNb != null) {
            this.dMY.addPostData("stTime", String.valueOf(this.dNb.mTime));
            this.dMY.addPostData("stSize", String.valueOf(this.dNb.mSize));
            this.dMY.addPostData("stTimesNum", String.valueOf(this.dNb.mTimesNum));
            this.dMY.addPostData("stMode", String.valueOf(this.dNb.mMode));
            this.dMY.addPostData("stMethod", String.valueOf(this.dNb.mMethod));
        }
        this.mErrorNums = aa.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.dNb != null) {
            this.mErrorNums = this.dNb.mTimesNum;
        }
        this.dMY.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.dMX.aVb().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.dMX.aVb().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.dMX.aVb().mNetErrorCode;
    }

    public String aUB() {
        return this.dMX.aVb().mException;
    }

    public String getErrorString() {
        return this.dMX.aVb().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.dMY != null) {
            this.dMY.cancelNetConnect();
        }
        if (this.dMZ != null) {
            this.dMZ.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.dMY != null) {
            this.dMY.setCancel();
        }
        if (this.dMZ != null) {
            this.dMZ.setCancel();
        }
    }

    public void ha(boolean z) {
        this.dNa = z;
    }

    private com.baidu.tbadk.core.data.ag w(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.dMZ == null) {
                this.dMZ = new x(sb.toString());
            } else {
                this.dMZ.cancelNetConnect();
            }
            this.dMZ.aUA().aVa().mIsNeedAddCommenParam = false;
            this.dMZ.aUA().aVa().mIsUseCurrentBDUSS = false;
            this.dMZ.aUA().aVa().mNeedBackgroundLogin = false;
            this.dMZ.addPostData("un", str);
            this.dMZ.addPostData("passwd", str2);
            this.dMZ.addPostData("isphone", "0");
            this.dMZ.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.dMZ.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.dMZ.aUA().aVa().aVe().mRequestGzip = true;
            postNetData = this.dMZ.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.dMZ.aUA().aVb().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            agVar.parserJson(postNetData);
            String userId = agVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.dMX.aVb().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
            if (agVar.getUser() != null && agVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(agVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(agVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (agVar.getAnti() != null) {
                accountData.setTbs(agVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return agVar;
        }
        if (this.dMZ.isNetSuccess()) {
            switch (this.dMZ.getServerErrorCode()) {
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
        if (!this.dMX.aVa().mIsFromCDN) {
            this.dMX.aVa().b(this.dMY);
        }
        return this.dMY.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.dMY.getPostData();
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
        this.dMY.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.dMX.aVa().dNa) {
            this.dMY.addPostData("sig", StringU.zk(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.dMX.aVa().dNa = this.dNa && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (aUA().aVa().mIsNeedAddCommenParam) {
                    this.dMX.aVa().b(this.dMY);
                }
                addStatisticsDataParam();
                postMultiNetData = this.dMY.getNetString();
                break;
            case 2:
                if (aUA().aVa().mIsUseCurrentBDUSS) {
                    aUA().aVa().a(this.dMY);
                }
                if (aUA().aVa().mIsNeedAddCommenParam) {
                    this.dMX.aVa().b(this.dMY);
                }
                addStatisticsDataParam();
                postMultiNetData = this.dMY.postNetData();
                break;
            case 3:
                if (aUA().aVa().mIsUseCurrentBDUSS) {
                    aUA().aVa().a(this.dMY);
                }
                if (aUA().aVa().mIsNeedAddCommenParam) {
                    this.dMX.aVa().b(this.dMY);
                }
                addSign();
                postMultiNetData = this.dMY.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.dMX.aVb().isNetSuccess()) {
            aa.a(this.dNb);
            aa.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.dMX.aVb().isRequestSuccess()) {
            if (this.dMX.aVb().mServerErrorCode == 1 && this.dMX.aVa().mNeedBackgroundLogin) {
                String str = this.dMX.aVb().mErrorString;
                this.dMX.aVb().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.aNU();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    aUC();
                    return null;
                }
                com.baidu.tbadk.core.a.b.vo(currentAccountObj.getID());
                if (ReloginManager.aTQ().aTT()) {
                    f(currentAccountObj);
                    ReloginManager.aTQ().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ag w = w(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (w == null) {
                    if (this.dMZ != null) {
                        this.dMX.aVb().mErrorString = this.dMZ.getErrorString();
                        return null;
                    }
                    this.dMX.aVb().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = kX(i);
            }
            com.baidu.tieba.j.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c aXz;
        if (!TextUtils.isEmpty(accountData.getID()) && (aXz = com.baidu.tbadk.coreExtra.a.a.aXz()) != null) {
            aXz.f(accountData);
        }
    }

    private String kX(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.dMY.getNetString();
                break;
            case 2:
                postMultiNetData = this.dMY.postNetData();
                break;
            case 3:
                postMultiNetData = this.dMY.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.dMX.aVb().isNetSuccess()) {
            switch (this.dMX.aVb().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    aUC();
                    this.dMX.aVb().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void aUC() {
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

    public String wn(String str) throws IOException {
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
        aUA().aVa().a(this.dMY);
        return this.dMY.downloadFile(str, handler, i, i2, i3, z);
    }
}
