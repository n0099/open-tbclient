package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.mobstat.Config;
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
    private boolean eZZ;
    private com.baidu.tbadk.core.util.b.a eZW = null;
    private t eZX = null;
    private aa eZY = null;
    private ad.a faa = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.eZW = new com.baidu.tbadk.core.util.b.a();
        this.eZX = ac.bsv().a(this.eZW);
        this.eZY = null;
        this.eZW.bta().bte().mNetType = com.baidu.tbadk.core.util.b.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bN(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bO(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bP(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.b.a bsr() {
        return this.eZW;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.eZW.bta().bte().mUrl = str;
    }

    public void setUrl(String str) {
        this.eZW.bta().bte().mUrl = str;
    }

    public void ah(boolean z) {
        this.eZW.bta().My = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.eZX.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.eZX.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.eZX.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.eZX.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.eZX.getPostData();
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
        if (this.faa == null) {
            this.faa = ad.bsw();
        }
        if (this.faa != null) {
            this.eZX.addPostData("stTime", String.valueOf(this.faa.mTime));
            this.eZX.addPostData("stSize", String.valueOf(this.faa.mSize));
            this.eZX.addPostData("stTimesNum", String.valueOf(this.faa.mTimesNum));
            this.eZX.addPostData("stMode", String.valueOf(this.faa.mMode));
            this.eZX.addPostData("stMethod", String.valueOf(this.faa.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.faa != null) {
            this.mErrorNums = this.faa.mTimesNum;
        }
        this.eZX.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.eZW.btb().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.eZW.btb().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.eZW.btb().mNetErrorCode;
    }

    public String bss() {
        return this.eZW.btb().mException;
    }

    public String getErrorString() {
        return this.eZW.btb().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.eZX != null) {
            this.eZX.cancelNetConnect();
        }
        if (this.eZY != null) {
            this.eZY.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.eZX != null) {
            this.eZX.setCancel();
        }
        if (this.eZY != null) {
            this.eZY.setCancel();
        }
    }

    public void jL(boolean z) {
        this.eZZ = z;
    }

    private com.baidu.tbadk.core.data.aq z(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.eZY == null) {
                this.eZY = new aa(sb.toString());
            } else {
                this.eZY.cancelNetConnect();
            }
            this.eZY.bsr().bta().mIsNeedAddCommenParam = false;
            this.eZY.bsr().bta().mIsUseCurrentBDUSS = false;
            this.eZY.bsr().bta().mNeedBackgroundLogin = false;
            this.eZY.addPostData("un", str);
            this.eZY.addPostData("passwd", str2);
            this.eZY.addPostData("isphone", "0");
            this.eZY.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.eZY.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.eZY.bsr().bta().bte().mRequestGzip = true;
            postNetData = this.eZY.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.eZY.bsr().btb().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
            aqVar.parserJson(postNetData);
            String userId = aqVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.eZW.btb().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aqVar.getUser().getUserName());
            if (aqVar.getUser().getPassword() != null) {
                accountData.setPassword(aqVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aqVar.getUser().getUserId());
            accountData.setBDUSS(aqVar.getUser().getBDUSS());
            accountData.setPortrait(aqVar.getUser().getPortrait());
            if (aqVar.getUser() != null && aqVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(aqVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(aqVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (aqVar.getAnti() != null) {
                accountData.setTbs(aqVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return aqVar;
        }
        if (this.eZY.isNetSuccess()) {
            switch (this.eZY.getServerErrorCode()) {
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
        if (!this.eZW.bta().mIsFromCDN) {
            this.eZW.bta().b(this.eZX);
        }
        return this.eZX.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.eZX.getPostData();
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
        this.eZX.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.eZW.bta().eZZ) {
            this.eZX.addPostData("sig", StringU.Eu(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.eZW.bta().eZZ = this.eZZ && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bsr().bta().mIsNeedAddCommenParam) {
                    this.eZW.bta().b(this.eZX);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eZX.getNetString();
                break;
            case 2:
                if (bsr().bta().mIsUseCurrentBDUSS) {
                    bsr().bta().a(this.eZX);
                }
                if (bsr().bta().mIsNeedAddCommenParam) {
                    this.eZW.bta().b(this.eZX);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eZX.postNetData();
                break;
            case 3:
                if (bsr().bta().mIsUseCurrentBDUSS) {
                    bsr().bta().a(this.eZX);
                }
                if (bsr().bta().mIsNeedAddCommenParam) {
                    this.eZW.bta().b(this.eZX);
                }
                addSign();
                postMultiNetData = this.eZX.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.eZW.btb().isNetSuccess()) {
            ad.a(this.faa);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.eZW.btb().isRequestSuccess()) {
            if (this.eZW.btb().mServerErrorCode == 1 && this.eZW.bta().mNeedBackgroundLogin) {
                String str = this.eZW.btb().mErrorString;
                this.eZW.btb().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bkX();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bst();
                    return null;
                }
                com.baidu.tbadk.core.a.b.zI(currentAccountObj.getID());
                if (ReloginManager.brI().brL()) {
                    f(currentAccountObj);
                    ReloginManager.brI().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.aq z = z(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (z == null) {
                    if (this.eZY != null) {
                        this.eZW.btb().mErrorString = this.eZY.getErrorString();
                        return null;
                    }
                    this.eZW.btb().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = ov(i);
            }
            com.baidu.tieba.k.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bvP;
        if (!TextUtils.isEmpty(accountData.getID()) && (bvP = com.baidu.tbadk.coreExtra.a.a.bvP()) != null) {
            bvP.f(accountData);
        }
    }

    private String ov(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.eZX.getNetString();
                break;
            case 2:
                postMultiNetData = this.eZX.postNetData();
                break;
            case 3:
                postMultiNetData = this.eZX.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.eZW.btb().isNetSuccess()) {
            switch (this.eZW.btb().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bst();
                    this.eZW.btb().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bst() {
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

    public String AZ(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream GetStreamFromFile = o.GetStreamFromFile(str);
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

    public String dP(String str, String str2) {
        byte[] bArr;
        try {
            InputStream GetStreamFromTmpFile = o.GetStreamFromTmpFile(str2);
            byte[] bArr2 = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION);
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
        bsr().bta().a(this.eZX);
        return this.eZX.downloadFile(str, handler, i, i2, i3, z);
    }
}
