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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.switchs.EncSigNewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class z {
    private boolean fct;
    private com.baidu.tbadk.core.util.b.a fcq = null;
    private s fcr = null;
    private z fcs = null;
    private ac.a fcu = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.fcq = new com.baidu.tbadk.core.util.b.a();
        this.fcr = ab.bvV().a(this.fcq);
        this.fcs = null;
        this.fcq.bwA().bwE().mNetType = com.baidu.tbadk.core.util.b.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bN(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bO(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bP(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.b.a bvR() {
        return this.fcq;
    }

    public z() {
        initNetWork();
    }

    public z(String str) {
        initNetWork();
        this.fcq.bwA().bwE().mUrl = str;
    }

    public void setUrl(String str) {
        this.fcq.bwA().bwE().mUrl = str;
    }

    public void ah(boolean z) {
        this.fcq.bwA().MD = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.fcr.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.fcr.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.fcr.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.fcr.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.fcr.getPostData();
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
        if (this.fcu == null) {
            this.fcu = ac.bvW();
        }
        if (this.fcu != null) {
            this.fcr.addPostData("stTime", String.valueOf(this.fcu.mTime));
            this.fcr.addPostData("stSize", String.valueOf(this.fcu.mSize));
            this.fcr.addPostData("stTimesNum", String.valueOf(this.fcu.mTimesNum));
            this.fcr.addPostData("stMode", String.valueOf(this.fcu.mMode));
            this.fcr.addPostData("stMethod", String.valueOf(this.fcu.mMethod));
        }
        this.mErrorNums = ac.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.fcu != null) {
            this.mErrorNums = this.fcu.mTimesNum;
        }
        this.fcr.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.fcq.bwB().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.fcq.bwB().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.fcq.bwB().mNetErrorCode;
    }

    public String bvS() {
        return this.fcq.bwB().mException;
    }

    public String getErrorString() {
        return this.fcq.bwB().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.fcr != null) {
            this.fcr.cancelNetConnect();
        }
        if (this.fcs != null) {
            this.fcs.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.fcr != null) {
            this.fcr.setCancel();
        }
        if (this.fcs != null) {
            this.fcs.setCancel();
        }
    }

    public void jM(boolean z) {
        this.fct = z;
    }

    private com.baidu.tbadk.core.data.ap z(String str, String str2, boolean z) {
        String postNetData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.fcs == null) {
                this.fcs = new z(sb.toString());
            } else {
                this.fcs.cancelNetConnect();
            }
            this.fcs.bvR().bwA().mIsNeedAddCommenParam = false;
            this.fcs.bvR().bwA().mIsUseCurrentBDUSS = false;
            this.fcs.bvR().bwA().mNeedBackgroundLogin = false;
            this.fcs.addPostData("un", str);
            this.fcs.addPostData("passwd", str2);
            this.fcs.addPostData("isphone", "0");
            this.fcs.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.fcs.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.fcs.bvR().bwA().bwE().mRequestGzip = true;
            postNetData = this.fcs.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.fcs.bvR().bwB().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
            apVar.parserJson(postNetData);
            String userId = apVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.fcq.bwB().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(apVar.getUser().getUserName());
            if (apVar.getUser().getPassword() != null) {
                accountData.setPassword(apVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(apVar.getUser().getUserId());
            accountData.setBDUSS(apVar.getUser().getBDUSS());
            accountData.setPortrait(apVar.getUser().getPortrait());
            if (apVar.getUser() != null && apVar.getUser().getBaijiahaoInfo() != null && !StringUtils.isNull(apVar.getUser().getBaijiahaoInfo().avatar)) {
                accountData.setBjhAvatar(apVar.getUser().getBaijiahaoInfo().avatar);
            }
            accountData.setIsActive(1);
            if (apVar.getAnti() != null) {
                accountData.setTbs(apVar.getAnti().getTbs());
            }
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return apVar;
        }
        if (this.fcs.isNetSuccess()) {
            switch (this.fcs.getServerErrorCode()) {
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
        if (!this.fcq.bwA().mIsFromCDN) {
            this.fcq.bwA().b(this.fcr);
        }
        return this.fcr.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.fcr.getPostData();
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
        this.fcr.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.fcq.bwA().fct) {
            this.fcr.addPostData("sig", StringU.Fh(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.fcq.bwA().fct = this.fct && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bvR().bwA().mIsNeedAddCommenParam) {
                    this.fcq.bwA().b(this.fcr);
                }
                addStatisticsDataParam();
                postMultiNetData = this.fcr.getNetString();
                break;
            case 2:
                if (bvR().bwA().mIsUseCurrentBDUSS) {
                    bvR().bwA().a(this.fcr);
                }
                if (bvR().bwA().mIsNeedAddCommenParam) {
                    this.fcq.bwA().b(this.fcr);
                }
                addStatisticsDataParam();
                postMultiNetData = this.fcr.postNetData();
                break;
            case 3:
                if (bvR().bwA().mIsUseCurrentBDUSS) {
                    bvR().bwA().a(this.fcr);
                }
                if (bvR().bwA().mIsNeedAddCommenParam) {
                    this.fcq.bwA().b(this.fcr);
                }
                addSign();
                postMultiNetData = this.fcr.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.fcq.bwB().isNetSuccess()) {
            ac.a(this.fcu);
            ac.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.fcq.bwB().isRequestSuccess()) {
            if (this.fcq.bwB().mServerErrorCode == 1 && this.fcq.bwA().mNeedBackgroundLogin) {
                String str = this.fcq.bwB().mErrorString;
                this.fcq.bwB().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.boz();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bvT();
                    return null;
                }
                com.baidu.tbadk.core.a.b.AC(currentAccountObj.getID());
                if (ReloginManager.bvj().bvm()) {
                    f(currentAccountObj);
                    ReloginManager.bvj().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ap z = z(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (z == null) {
                    if (this.fcs != null) {
                        this.fcq.bwB().mErrorString = this.fcs.getErrorString();
                        return null;
                    }
                    this.fcq.bwB().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = pX(i);
            }
            com.baidu.tieba.k.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bzq;
        if (!TextUtils.isEmpty(accountData.getID()) && (bzq = com.baidu.tbadk.coreExtra.a.a.bzq()) != null) {
            bzq.f(accountData);
        }
    }

    private String pX(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.fcr.getNetString();
                break;
            case 2:
                postMultiNetData = this.fcr.postNetData();
                break;
            case 3:
                postMultiNetData = this.fcr.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.fcq.bwB().isNetSuccess()) {
            switch (this.fcq.bwB().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bvT();
                    this.fcq.bwB().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bvT() {
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

    public String BT(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream GetStreamFromFile = n.GetStreamFromFile(str);
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

    public String dV(String str, String str2) {
        byte[] bArr;
        try {
            InputStream GetStreamFromTmpFile = n.GetStreamFromTmpFile(str2);
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
        bvR().bwA().a(this.fcr);
        return this.fcr.downloadFile(str, handler, i, i2, i3, z);
    }
}
