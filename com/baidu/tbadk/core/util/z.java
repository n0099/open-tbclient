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
    private boolean eXK;
    private com.baidu.tbadk.core.util.b.a eXH = null;
    private s eXI = null;
    private z eXJ = null;
    private ac.a eXL = null;
    private int mErrorNums = 0;

    private void initNetWork() {
        this.eXH = new com.baidu.tbadk.core.util.b.a();
        this.eXI = ab.bsb().a(this.eXH);
        this.eXJ = null;
        this.eXH.bsG().bsK().mNetType = com.baidu.tbadk.core.util.b.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bN(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bO(TbadkCoreApplication.getInst().getCuidGalaxy3());
        com.baidu.adp.lib.network.a.a.bP(TbadkCoreApplication.getInst().getCuidGid());
    }

    public com.baidu.tbadk.core.util.b.a brX() {
        return this.eXH;
    }

    public z() {
        initNetWork();
    }

    public z(String str) {
        initNetWork();
        this.eXH.bsG().bsK().mUrl = str;
    }

    public void setUrl(String str) {
        this.eXH.bsG().bsK().mUrl = str;
    }

    public void ah(boolean z) {
        this.eXH.bsG().MA = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.eXI.setPostData(arrayList);
    }

    public void addPostData(String str, String str2) {
        this.eXI.addPostData(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.eXI.addPostData(basicNameValuePair);
    }

    public void addPostData(String str, byte[] bArr) {
        this.eXI.addPostData(str, bArr);
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : com.baidu.tbadk.mutiprocess.f.getBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : com.baidu.tbadk.mutiprocess.f.getTbs());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.eXI.getPostData();
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
        if (this.eXL == null) {
            this.eXL = ac.bsc();
        }
        if (this.eXL != null) {
            this.eXI.addPostData("stTime", String.valueOf(this.eXL.mTime));
            this.eXI.addPostData("stSize", String.valueOf(this.eXL.mSize));
            this.eXI.addPostData("stTimesNum", String.valueOf(this.eXL.mTimesNum));
            this.eXI.addPostData("stMode", String.valueOf(this.eXL.mMode));
            this.eXI.addPostData("stMethod", String.valueOf(this.eXL.mMethod));
        }
        this.mErrorNums = ac.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.eXL != null) {
            this.mErrorNums = this.eXL.mTimesNum;
        }
        this.eXI.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public boolean isNetSuccess() {
        return this.eXH.bsH().isNetSuccess();
    }

    public int getServerErrorCode() {
        return this.eXH.bsH().mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.eXH.bsH().mNetErrorCode;
    }

    public String brY() {
        return this.eXH.bsH().mException;
    }

    public String getErrorString() {
        return this.eXH.bsH().mErrorString;
    }

    public void cancelNetConnect() {
        if (this.eXI != null) {
            this.eXI.cancelNetConnect();
        }
        if (this.eXJ != null) {
            this.eXJ.cancelNetConnect();
        }
    }

    public void setCancel() {
        if (this.eXI != null) {
            this.eXI.setCancel();
        }
        if (this.eXJ != null) {
            this.eXJ.setCancel();
        }
    }

    public void jI(boolean z) {
        this.eXK = z;
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
            if (this.eXJ == null) {
                this.eXJ = new z(sb.toString());
            } else {
                this.eXJ.cancelNetConnect();
            }
            this.eXJ.brX().bsG().mIsNeedAddCommenParam = false;
            this.eXJ.brX().bsG().mIsUseCurrentBDUSS = false;
            this.eXJ.brX().bsG().mNeedBackgroundLogin = false;
            this.eXJ.addPostData("un", str);
            this.eXJ.addPostData("passwd", str2);
            this.eXJ.addPostData("isphone", "0");
            this.eXJ.addPostData(SharedPrefConfig.CHANNEL_ID, TbadkCoreApplication.getInst().getPushChannelId());
            this.eXJ.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.eXJ.brX().bsG().bsK().mRequestGzip = true;
            postNetData = this.eXJ.postNetData();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.eXJ.brX().bsH().isRequestSuccess() && postNetData != null) {
            com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
            apVar.parserJson(postNetData);
            String userId = apVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.eXH.bsH().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
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
        if (this.eXJ.isNetSuccess()) {
            switch (this.eXJ.getServerErrorCode()) {
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
        if (!this.eXH.bsG().mIsFromCDN) {
            this.eXH.bsG().b(this.eXI);
        }
        return this.eXI.getNetData();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.eXI.getPostData();
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
        this.eXI.addPostData("sign", com.baidu.adp.lib.util.s.toMd5(stringBuffer.toString()));
        if (this.eXH.bsG().eXK) {
            this.eXI.addPostData("sig", StringU.DW(stringBuffer.toString()));
        }
    }

    private String process(int i) {
        String postMultiNetData;
        this.eXH.bsG().eXK = this.eXK && EncSigNewSwitch.isOn();
        switch (i) {
            case 1:
                if (brX().bsG().mIsNeedAddCommenParam) {
                    this.eXH.bsG().b(this.eXI);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eXI.getNetString();
                break;
            case 2:
                if (brX().bsG().mIsUseCurrentBDUSS) {
                    brX().bsG().a(this.eXI);
                }
                if (brX().bsG().mIsNeedAddCommenParam) {
                    this.eXH.bsG().b(this.eXI);
                }
                addStatisticsDataParam();
                postMultiNetData = this.eXI.postNetData();
                break;
            case 3:
                if (brX().bsG().mIsUseCurrentBDUSS) {
                    brX().bsG().a(this.eXI);
                }
                if (brX().bsG().mIsNeedAddCommenParam) {
                    this.eXH.bsG().b(this.eXI);
                }
                addSign();
                postMultiNetData = this.eXI.postMultiNetData();
                break;
            default:
                return null;
        }
        if (!this.eXH.bsH().isNetSuccess()) {
            ac.a(this.eXL);
            ac.addErrorNumsAndGet(this.mErrorNums);
            return postMultiNetData;
        } else if (!this.eXH.bsH().isRequestSuccess()) {
            if (this.eXH.bsH().mServerErrorCode == 1 && this.eXH.bsG().mNeedBackgroundLogin) {
                String str = this.eXH.bsH().mErrorString;
                this.eXH.bsH().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = com.baidu.tbadk.core.a.b.bkF();
                }
                if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    brZ();
                    return null;
                }
                com.baidu.tbadk.core.a.b.zr(currentAccountObj.getID());
                if (ReloginManager.brp().brs()) {
                    f(currentAccountObj);
                    ReloginManager.brp().e(null);
                    return null;
                }
                com.baidu.tbadk.core.data.ap z = z(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                f(currentAccountObj);
                if (z == null) {
                    if (this.eXJ != null) {
                        this.eXH.bsH().mErrorString = this.eXJ.getErrorString();
                        return null;
                    }
                    this.eXH.bsH().mErrorString = str;
                    return postMultiNetData;
                }
                postMultiNetData = oq(i);
            }
            com.baidu.tieba.k.a.b(this);
            return postMultiNetData;
        } else {
            return postMultiNetData;
        }
    }

    private void f(AccountData accountData) {
        com.baidu.tbadk.coreExtra.a.c bvw;
        if (!TextUtils.isEmpty(accountData.getID()) && (bvw = com.baidu.tbadk.coreExtra.a.a.bvw()) != null) {
            bvw.f(accountData);
        }
    }

    private String oq(int i) {
        String postMultiNetData;
        modSessionData();
        switch (i) {
            case 1:
                postMultiNetData = this.eXI.getNetString();
                break;
            case 2:
                postMultiNetData = this.eXI.postNetData();
                break;
            case 3:
                postMultiNetData = this.eXI.postMultiNetData();
                break;
            default:
                return null;
        }
        if (this.eXH.bsH().isNetSuccess()) {
            switch (this.eXH.bsH().mServerErrorCode) {
                case 1:
                case 2:
                case 5:
                    brZ();
                    this.eXH.bsH().mErrorString = "";
                    return null;
                case 3:
                case 4:
                default:
                    return postMultiNetData;
            }
        }
        return postMultiNetData;
    }

    private void brZ() {
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

    public String AI(String str) throws IOException {
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

    public String dU(String str, String str2) {
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
        brX().bsG().a(this.eXI);
        return this.eXI.downloadFile(str, handler, i, i2, i3, z);
    }
}
