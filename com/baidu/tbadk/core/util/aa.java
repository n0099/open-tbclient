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
    private boolean fby;
    private com.baidu.tbadk.core.util.b.a fbv = null;
    private t fbw = null;
    private aa fbx = null;
    private ad.a fbz = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.fbv = new com.baidu.tbadk.core.util.b.a();
        this.fbw = ac.bsy().a(this.fbv);
        this.fbx = null;
        this.fbv.btd().bth().mNetType = com.baidu.tbadk.core.util.b.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bR(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.b.a bsu() {
        return this.fbv;
    }

    public aa() {
        initNetWork();
    }

    public aa(String str) {
        initNetWork();
        this.fbv.btd().bth().mUrl = str;
    }

    public void setUrl(String str) {
        this.fbv.btd().bth().mUrl = str;
    }

    public void ah(boolean z) {
        this.fbv.btd().NZ = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.fbw.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.fbw.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.fbw.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.fbw.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.fbw.getPostData();
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
        if (this.fbz == null) {
            this.fbz = ad.bsz();
        }
        if (this.fbz != null) {
            this.fbw.addPostData("stTime", String.valueOf(this.fbz.mTime));
            this.fbw.addPostData("stSize", String.valueOf(this.fbz.mSize));
            this.fbw.addPostData("stTimesNum", String.valueOf(this.fbz.mTimesNum));
            this.fbw.addPostData("stMode", String.valueOf(this.fbz.mMode));
            this.fbw.addPostData("stMethod", String.valueOf(this.fbz.mMethod));
        }
        this.mErrorNums = ad.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.fbz != null) {
            this.mErrorNums = this.fbz.mTimesNum;
        }
        this.fbw.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.fbv.bte().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.fbv.bte().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.fbv.bte().mNetErrorCode;
    }

    public String bsv() {
        return this.fbv.bte().mException;
    }

    public String getErrorString() {
        return this.fbv.bte().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.fbw != null) {
            this.fbw.cancelNetConnect();
        }
        if (this.fbx != null) {
            this.fbx.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.fbw != null) {
            this.fbw.setCancel();
        }
        if (this.fbx != null) {
            this.fbx.setCancel();
        }
    }

    public void jL(boolean z) {
        this.fby = z;
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
            if (this.fbx == null) {
                this.fbx = new aa(sb.toString());
            } else {
                this.fbx.cancelNetConnect();
            }
            this.fbx.bsu().btd().mIsNeedAddCommenParam = false;
            this.fbx.bsu().btd().mIsUseCurrentBDUSS = false;
            this.fbx.bsu().btd().mNeedBackgroundLogin = false;
            this.fbx.addPostData("un", str);
            this.fbx.addPostData("passwd", str2);
            this.fbx.addPostData("isphone", "0");
            this.fbx.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.fbx.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.fbx.bsu().btd().bth().mRequestGzip = true;
            postNetData = this.fbx.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.fbx.bsu().bte().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
            aqVar.parserJson(postNetData);
            String userId = aqVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.fbv.bte().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.fbx.isNetSuccess()) {
            switch (this.fbx.getServerErrorCode()) {
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
        if (!this.fbv.btd().mIsFromCDN) {
            this.fbv.btd().b(this.fbw);
        }
        return this.fbw.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.fbw.getPostData();
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
        this.fbw.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.fbv.btd().fby) {
            this.fbw.addPostData("sig", StringU.Ez(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.fbv.btd().fby = this.fby && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (bsu().btd().mIsNeedAddCommenParam) {
                    this.fbv.btd().b(this.fbw);
                }
                addStatisticsDataParam();
                postMultiNetData = this.fbw.getNetString();
                break;
            case 2:
                if (bsu().btd().mIsUseCurrentBDUSS) {
                    bsu().btd().a(this.fbw);
                }
                if (bsu().btd().mIsNeedAddCommenParam) {
                    this.fbv.btd().b(this.fbw);
                }
                addStatisticsDataParam();
                postMultiNetData = this.fbw.postNetData();
                break;
            case 3:
                if (bsu().btd().mIsUseCurrentBDUSS) {
                    bsu().btd().a(this.fbw);
                }
                if (bsu().btd().mIsNeedAddCommenParam) {
                    this.fbv.btd().b(this.fbw);
                }
                addSign();
                postMultiNetData = this.fbw.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.fbv.bte().isNetSuccess()) {
            ad.a(this.fbz);
            ad.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.fbv.bte().isRequestSuccess()) {
            if (this.fbv.bte().mServerErrorCode == 1 && this.fbv.btd().mNeedBackgroundLogin) {
                String str = this.fbv.bte().mErrorString;
                this.fbv.bte().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bkZ();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    bsw();
                    return null;
                }
                com.baidu.tbadk.core.a.b.zP(currentAccountObj.getID());
                if (ReloginManager.brJ().brM()) {
                    f(currentAccountObj);
                    ReloginManager.brJ().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.aq z = z(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (z == null) {
                    if (this.fbx != null) {
                        this.fbv.bte().mErrorString = this.fbx.getErrorString();
                        return null;
                    }
                    this.fbv.bte().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = ow(i);
            }
            com.baidu.tieba.k.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bvS;
        if (!TextUtils.isEmpty(accountData.getID()) && (bvS = com.baidu.tbadk.coreExtra.a.a.bvS()) != null) {
            bvS.f(accountData);
        }
    }

    private String ow(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.fbw.getNetString();
                break;
            case 2:
                postMultiNetData = this.fbw.postNetData();
                break;
            case 3:
                postMultiNetData = this.fbw.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.fbv.bte().isNetSuccess()) {
            switch (this.fbv.bte().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    bsw();
                    this.fbv.bte().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void bsw() {
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

    public String Bg(String str) throws IOException {
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
        bsu().btd().a(this.fbw);
        return this.fbw.downloadFile(str, handler, i, i2, i3, z);
    }
}
