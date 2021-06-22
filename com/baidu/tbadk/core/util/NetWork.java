package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.tbadk.switchs.EncSigNewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import d.a.c.e.j.b.a;
import d.a.c.e.p.q;
import d.a.n0.f0.f;
import d.a.n0.r.l.c;
import d.a.n0.r.q.q0;
import d.a.n0.s.a.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class NetWork {
    public static final int NET_TYPE_GET = 1;
    public static final int NET_TYPE_POST = 2;
    public static final int NET_TYPE_POST_CHUNK = 3;
    public static final String SIGN_SUFFIX = "tiebaclient!!!";
    public boolean mNeedSig;
    public HttpNetContext netContext = null;
    public INetWorkCore mNet = null;
    public NetWork mNetLogin = null;
    public NetWorkState.StatisticsData mStatisticsData = null;
    public int mErrorNums = 0;

    public NetWork() {
        initNetWork();
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> postData = this.mNet.getPostData();
        for (int i2 = 0; postData != null && i2 < postData.size(); i2++) {
            BasicNameValuePair basicNameValuePair = postData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.mNet.addPostData("sign", q.c(stringBuffer.toString()));
        if (this.netContext.getRequest().mNeedSig) {
            this.mNet.addPostData("sig", StringU.b(stringBuffer.toString()));
        }
    }

    private void addStatisticsDataParam() {
        NetWorkState.StatisticsData statisticsData;
        if (this.mStatisticsData == null) {
            this.mStatisticsData = NetWorkState.delStatisticsData();
        }
        NetWorkState.StatisticsData statisticsData2 = this.mStatisticsData;
        if (statisticsData2 != null) {
            this.mNet.addPostData("stTime", String.valueOf(statisticsData2.mTime));
            this.mNet.addPostData("stSize", String.valueOf(this.mStatisticsData.mSize));
            this.mNet.addPostData("stTimesNum", String.valueOf(this.mStatisticsData.mTimesNum));
            this.mNet.addPostData("stMode", String.valueOf(this.mStatisticsData.mMode));
            this.mNet.addPostData("stMethod", String.valueOf(this.mStatisticsData.mMethod));
        }
        int errorNumsAndSet = NetWorkState.getErrorNumsAndSet(0);
        this.mErrorNums = errorNumsAndSet;
        if (errorNumsAndSet == 0 && (statisticsData = this.mStatisticsData) != null) {
            this.mErrorNums = statisticsData.mTimesNum;
        }
        this.mNet.addPostData("stErrorNums", String.valueOf(this.mErrorNums));
    }

    private void initNetWork() {
        this.netContext = new HttpNetContext();
        this.mNet = NetWorkCoreFacotry.getInstance().createINetWorkCore(this.netContext);
        this.mNetLogin = null;
        this.netContext.getRequest().getNetWorkParam().mNetType = NetWorkUtil.getNetType();
        a.o(TbadkCoreApplication.getInst().getCuid());
        a.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
        a.q(TbadkCoreApplication.getInst().getCuidGalaxy3());
        a.r(TbadkCoreApplication.getInst().getCuidGid());
    }

    private q0 login(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                d.a.n0.r.z.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
                StringBuilder sb = new StringBuilder(32);
                sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                if (this.mNetLogin == null) {
                    this.mNetLogin = new NetWork(sb.toString());
                } else {
                    this.mNetLogin.cancelNetConnect();
                }
                this.mNetLogin.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                this.mNetLogin.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                this.mNetLogin.getNetContext().getRequest().mNeedBackgroundLogin = false;
                this.mNetLogin.addPostData("un", str);
                this.mNetLogin.addPostData("passwd", str2);
                this.mNetLogin.addPostData("isphone", "0");
                this.mNetLogin.addPostData("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
                this.mNetLogin.addPostData("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
                this.mNetLogin.getNetContext().getRequest().getNetWorkParam().mRequestGzip = true;
                String postNetData = this.mNetLogin.postNetData();
                if (this.mNetLogin.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    q0 q0Var = new q0();
                    q0Var.c(postNetData);
                    String userId = q0Var.b().getUserId();
                    if (userId != null && userId.length() > 0) {
                        AccountData accountData = new AccountData();
                        accountData.setAccount(q0Var.b().getUserName());
                        if (q0Var.b().getPassword() != null) {
                            accountData.setPassword(q0Var.b().getPassword());
                        } else {
                            accountData.setPassword(str2);
                        }
                        accountData.setID(q0Var.b().getUserId());
                        accountData.setBDUSS(q0Var.b().getBDUSS());
                        accountData.setPortrait(q0Var.b().getPortrait());
                        if (q0Var.b() != null && q0Var.b().getBaijiahaoInfo() != null && !StringUtils.isNull(q0Var.b().getBaijiahaoInfo().avatar)) {
                            accountData.setBjhAvatar(q0Var.b().getBaijiahaoInfo().avatar);
                        }
                        accountData.setIsActive(1);
                        if (q0Var.a() != null) {
                            accountData.setTbs(q0Var.a().getTbs());
                        }
                        c.g(accountData);
                        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                        d.a.n0.r.z.a.a("account", -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
                        TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
                        return q0Var;
                    }
                    this.netContext.getResponse().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.neterror);
                    return null;
                } else if (this.mNetLogin.isNetSuccess()) {
                    int serverErrorCode = this.mNetLogin.getServerErrorCode();
                    if ((serverErrorCode == 1 || serverErrorCode == 2 || serverErrorCode == 5) && z) {
                        TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
                    }
                    return null;
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
        return null;
    }

    private void modSessionData() {
        String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : f.b();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair(HttpRequest.BDUSS, currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair(HttpRequest.TBS, TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : f.d());
        if (currentBduss != null) {
            ArrayList<BasicNameValuePair> postData = this.mNet.getPostData();
            int size = postData.size();
            for (int i2 = 0; i2 < size; i2++) {
                BasicNameValuePair basicNameValuePair3 = postData.get(i2);
                if (basicNameValuePair3.getName().equals(HttpRequest.BDUSS)) {
                    postData.set(i2, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals(HttpRequest.TBS)) {
                    postData.set(i2, basicNameValuePair2);
                }
            }
        }
    }

    private String process(int i2) {
        String netString;
        this.netContext.getRequest().mNeedSig = this.mNeedSig && EncSigNewSwitch.isOn();
        if (i2 == 1) {
            if (getNetContext().getRequest().mIsNeedAddCommenParam) {
                this.netContext.getRequest().addCommonParam(this.mNet);
            }
            addStatisticsDataParam();
            netString = this.mNet.getNetString();
        } else if (i2 == 2) {
            if (getNetContext().getRequest().mIsUseCurrentBDUSS) {
                getNetContext().getRequest().addBdussData(this.mNet);
            }
            if (getNetContext().getRequest().mIsNeedAddCommenParam) {
                this.netContext.getRequest().addCommonParam(this.mNet);
            }
            addStatisticsDataParam();
            netString = this.mNet.postNetData();
        } else if (i2 != 3) {
            return null;
        } else {
            if (getNetContext().getRequest().mIsUseCurrentBDUSS) {
                getNetContext().getRequest().addBdussData(this.mNet);
            }
            if (getNetContext().getRequest().mIsNeedAddCommenParam) {
                this.netContext.getRequest().addCommonParam(this.mNet);
            }
            addSign();
            netString = this.mNet.postMultiNetData();
        }
        if (!this.netContext.getResponse().isNetSuccess()) {
            NetWorkState.addStatisticsData(this.mStatisticsData);
            NetWorkState.addErrorNumsAndGet(this.mErrorNums);
            return netString;
        } else if (this.netContext.getResponse().isRequestSuccess()) {
            return netString;
        } else {
            if (this.netContext.getResponse().mServerErrorCode == 1 && this.netContext.getRequest().mNeedBackgroundLogin) {
                String str = this.netContext.getResponse().mErrorString;
                this.netContext.getResponse().mErrorString = "";
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj == null) {
                    currentAccountObj = c.e();
                }
                if (currentAccountObj != null && (!TextUtils.isEmpty(currentAccountObj.getAccount()) || !TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                    c.c(currentAccountObj.getID());
                    if (ReloginManager.g().i()) {
                        removeAccount(currentAccountObj);
                        ReloginManager.g().f(null);
                        return null;
                    }
                    q0 login = login(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true);
                    removeAccount(currentAccountObj);
                    if (login == null) {
                        if (this.mNetLogin != null) {
                            this.netContext.getResponse().mErrorString = this.mNetLogin.getErrorString();
                            return null;
                        }
                        this.netContext.getResponse().mErrorString = str;
                        return netString;
                    }
                    netString = process_second(i2);
                } else {
                    sendLoginMessage();
                    return null;
                }
            }
            d.a.o0.y0.a.b(this);
            return netString;
        }
    }

    private String process_second(int i2) {
        String netString;
        int i3;
        modSessionData();
        if (i2 == 1) {
            netString = this.mNet.getNetString();
        } else if (i2 == 2) {
            netString = this.mNet.postNetData();
        } else if (i2 != 3) {
            return null;
        } else {
            netString = this.mNet.postMultiNetData();
        }
        if (this.netContext.getResponse().isNetSuccess() && ((i3 = this.netContext.getResponse().mServerErrorCode) == 1 || i3 == 2 || i3 == 5)) {
            sendLoginMessage();
            this.netContext.getResponse().mErrorString = "";
            return null;
        }
        return netString;
    }

    private void removeAccount(AccountData accountData) {
        b b2;
        if (TextUtils.isEmpty(accountData.getID()) || (b2 = d.a.n0.s.a.a.b()) == null) {
            return;
        }
        b2.c(accountData);
    }

    private void sendLoginMessage() {
        Handler handler = TbadkCoreApplication.getInst().handler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public void addPostData(String str, String str2) {
        this.mNet.addPostData(str, str2);
    }

    public void cancelNetConnect() {
        INetWorkCore iNetWorkCore = this.mNet;
        if (iNetWorkCore != null) {
            iNetWorkCore.cancelNetConnect();
        }
        NetWork netWork = this.mNetLogin;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public boolean downloadFile(String str, Handler handler, int i2) {
        return downloadFile(str, handler, i2, 5, 100);
    }

    public String getErrorString() {
        return this.netContext.getResponse().mErrorString;
    }

    public HttpNetContext getNetContext() {
        return this.netContext;
    }

    public byte[] getNetData() {
        if (!this.netContext.getRequest().mIsFromCDN) {
            this.netContext.getRequest().addCommonParam(this.mNet);
        }
        return this.mNet.getNetData();
    }

    public long getNetDataSize() {
        return this.netContext.getStat().stat.f42378b;
    }

    public int getNetErrorCode() {
        return this.netContext.getResponse().mNetErrorCode;
    }

    public String getNetException() {
        return this.netContext.getResponse().mException;
    }

    public String getNetString() {
        return process(1);
    }

    public ArrayList<BasicNameValuePair> getPostData() {
        return this.mNet.getPostData();
    }

    public int getServerErrorCode() {
        return this.netContext.getResponse().mServerErrorCode;
    }

    public boolean isNetSuccess() {
        return this.netContext.getResponse().isNetSuccess();
    }

    public boolean multiAccountLogin(String str, String str2, boolean z) {
        if (login(str, str2, z) == null) {
            if (this.mNetLogin != null) {
                this.netContext.getResponse().mErrorString = this.mNetLogin.getErrorString();
                return false;
            }
            return false;
        }
        return true;
    }

    public String postMultiNetData() {
        return process(3);
    }

    public String postNetData() {
        return process(2);
    }

    public void setCanHttpsDownToHttp(boolean z) {
        this.netContext.getRequest().mCanHttpsDownToHttp = z;
    }

    public void setCancel() {
        INetWorkCore iNetWorkCore = this.mNet;
        if (iNetWorkCore != null) {
            iNetWorkCore.setCancel();
        }
        NetWork netWork = this.mNetLogin;
        if (netWork != null) {
            netWork.setCancel();
        }
    }

    public void setNeedSig(boolean z) {
        this.mNeedSig = z;
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        this.mNet.setPostData(arrayList);
    }

    public void setUrl(String str) {
        this.netContext.getRequest().getNetWorkParam().mUrl = str;
    }

    public String uploadFile(String str, String str2) {
        byte[] bArr;
        try {
            InputStream GetStreamFromTmpFile = FileHelper.GetStreamFromTmpFile(str2);
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
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        addPostData(str, bArr);
        return postMultiNetData();
    }

    public String uploadImage(String str) throws IOException {
        byte[] bArr;
        try {
            InputStream GetStreamFromFile = FileHelper.GetStreamFromFile(str);
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
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        addPostData("pic", bArr);
        return postMultiNetData();
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.mNet.addPostData(basicNameValuePair);
    }

    public boolean downloadFile(String str, Handler handler, int i2, int i3, int i4) {
        return downloadFile(str, handler, i2, i3, i4, false);
    }

    public void addPostData(String str, byte[] bArr) {
        this.mNet.addPostData(str, bArr);
    }

    public boolean downloadFile(String str, Handler handler, int i2, int i3, int i4, boolean z) {
        getNetContext().getRequest().addBdussData(this.mNet);
        return this.mNet.downloadFile(str, handler, i2, i3, i4, z);
    }

    public NetWork(String str) {
        initNetWork();
        this.netContext.getRequest().getNetWorkParam().mUrl = str;
    }

    public NetWork(String str, ArrayList<BasicNameValuePair> arrayList) {
        initNetWork();
        this.netContext.getRequest().getNetWorkParam().mUrl = str;
        this.mNet.setPostData(arrayList);
    }
}
