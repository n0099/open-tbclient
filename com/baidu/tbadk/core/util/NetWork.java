package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.tbadk.switchs.EncSigNewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.repackage.bg;
import com.repackage.cn4;
import com.repackage.es6;
import com.repackage.gp4;
import com.repackage.mt4;
import com.repackage.nw4;
import com.repackage.ow4;
import com.repackage.p65;
import com.repackage.vi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NetWork {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NET_TYPE_GET = 1;
    public static final int NET_TYPE_POST = 2;
    public static final int NET_TYPE_POST_CHUNK = 3;
    public static final String SIGN_SUFFIX = "tiebaclient!!!";
    public transient /* synthetic */ FieldHolder $fh;
    public int mErrorNums;
    public boolean mNeedBdussForGet;
    public boolean mNeedSig;
    public INetWorkCore mNet;
    public NetWork mNetLogin;
    public NetWorkState.StatisticsData mStatisticsData;
    public HttpNetContext netContext;

    public NetWork() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.netContext = null;
        this.mNet = null;
        this.mNetLogin = null;
        this.mStatisticsData = null;
        this.mErrorNums = 0;
        initNetWork();
    }

    private void addSign() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            ArrayList<BasicNameValuePair> postData = this.mNet.getPostData();
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
            this.mNet.addPostData("sign", vi.c(stringBuffer.toString()));
            if (this.netContext.getRequest().mNeedSig) {
                this.mNet.addPostData(FunAdSdk.PLATFORM_SIG, StringU.b(stringBuffer.toString()));
            }
        }
    }

    private void addStatisticsDataParam() {
        NetWorkState.StatisticsData statisticsData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
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
    }

    private void initNetWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.netContext = new HttpNetContext();
            this.mNet = NetWorkCoreFacotry.getInstance().createINetWorkCore(this.netContext);
            this.mNetLogin = null;
            this.netContext.getRequest().mNetType = NetWorkUtil.getNetType();
            bg.o(TbadkCoreApplication.getInst().getCuid());
            bg.p(TbadkCoreApplication.getInst().getCuidGalaxy2());
            bg.q(TbadkCoreApplication.getInst().getCuidGalaxy3());
            bg.r(TbadkCoreApplication.getInst().getCuidGid());
        }
    }

    private gp4 login(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    mt4.a(DI.ACCOUNT, -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
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
                    this.mNetLogin.getNetContext().getRequest().mRequestGzip = true;
                    String postNetData = this.mNetLogin.postNetData();
                    if (this.mNetLogin.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        gp4 gp4Var = new gp4();
                        gp4Var.c(postNetData);
                        String userId = gp4Var.b().getUserId();
                        if (userId != null && userId.length() > 0) {
                            AccountData accountData = new AccountData();
                            accountData.setAccount(gp4Var.b().getUserName());
                            if (gp4Var.b().getPassword() != null) {
                                accountData.setPassword(gp4Var.b().getPassword());
                            } else {
                                accountData.setPassword(str2);
                            }
                            accountData.setID(gp4Var.b().getUserId());
                            accountData.setBDUSS(gp4Var.b().getBDUSS());
                            accountData.setPortrait(gp4Var.b().getPortrait());
                            accountData.setIsActive(1);
                            if (gp4Var.a() != null) {
                                accountData.setTbs(gp4Var.a().getTbs());
                            }
                            cn4.g(accountData);
                            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                            mt4.a(DI.ACCOUNT, -1L, 0, "login_before_clear_account", 0, "", new Object[0]);
                            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp().getApplicationContext());
                            return gp4Var;
                        }
                        this.netContext.getResponse().mErrorString = TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f0c2b);
                        return null;
                    } else if (this.mNetLogin.isNetSuccess()) {
                        int serverErrorCode = this.mNetLogin.getServerErrorCode();
                        if (serverErrorCode == 1 || serverErrorCode == 2 || serverErrorCode == 5) {
                            TbadkCoreApplication.getInst().handler.sendMessage(TbadkCoreApplication.getInst().handler.obtainMessage(1));
                        }
                        return null;
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
            return null;
        }
        return (gp4) invokeLL.objValue;
    }

    private void modSessionData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String currentBduss = TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getCurrentBduss() : p65.b();
            BasicNameValuePair basicNameValuePair = new BasicNameValuePair(HttpRequest.BDUSS, currentBduss);
            BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair(HttpRequest.TBS, TbadkCoreApplication.getInst().isMainProcess(false) ? TbadkCoreApplication.getInst().getTbs() : p65.f());
            if (currentBduss != null) {
                ArrayList<BasicNameValuePair> postData = this.mNet.getPostData();
                int size = postData.size();
                for (int i = 0; i < size; i++) {
                    BasicNameValuePair basicNameValuePair3 = postData.get(i);
                    if (basicNameValuePair3.getName().equals(HttpRequest.BDUSS)) {
                        postData.set(i, basicNameValuePair);
                    } else if (basicNameValuePair3.getName().equals(HttpRequest.TBS)) {
                        postData.set(i, basicNameValuePair2);
                    }
                }
            }
        }
    }

    private String netErrorToString(HttpResponse httpResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, httpResponse)) == null) {
            if (httpResponse == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", httpResponse.mNetErrorCode);
                jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "serverErrorCode=" + httpResponse.mServerErrorCode + "&errorString=" + httpResponse.mErrorString + "&exception=" + httpResponse.mException);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    private String process(int i, boolean z) {
        InterceptResult invokeCommon;
        String netString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            this.netContext.getRequest().mNeedSig = this.mNeedSig && EncSigNewSwitch.isOn();
            if (i == 1) {
                if (getNetContext().getRequest().mIsNeedAddCommenParam) {
                    this.netContext.getRequest().addCommonParam(this.mNet, this.mNeedBdussForGet);
                }
                addStatisticsDataParam();
                netString = this.mNet.getNetString();
            } else if (i == 2) {
                if (getNetContext().getRequest().mIsUseCurrentBDUSS) {
                    getNetContext().getRequest().addBdussData(this.mNet);
                }
                if (getNetContext().getRequest().mIsNeedAddCommenParam) {
                    this.netContext.getRequest().addCommonParam(this.mNet);
                }
                addStatisticsDataParam();
                netString = this.mNet.postNetData();
            } else if (i != 3) {
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
                return (z && TextUtils.isEmpty(netString)) ? netErrorToString(this.netContext.getResponse()) : netString;
            } else if (this.netContext.getResponse().isRequestSuccess()) {
                return netString;
            } else {
                if (this.netContext.getResponse().mServerErrorCode == 1 && this.netContext.getRequest().mNeedBackgroundLogin) {
                    String str = this.netContext.getResponse().mErrorString;
                    this.netContext.getResponse().mErrorString = "";
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj == null) {
                        currentAccountObj = cn4.e();
                    }
                    if (currentAccountObj != null && (!TextUtils.isEmpty(currentAccountObj.getAccount()) || !TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
                        cn4.c(currentAccountObj.getID());
                        if (ReloginManager.g().i()) {
                            removeAccount(currentAccountObj);
                            ReloginManager.g().f(null);
                            return null;
                        }
                        gp4 login = login(currentAccountObj.getAccount(), currentAccountObj.getPassword());
                        removeAccount(currentAccountObj);
                        if (login == null) {
                            if (this.mNetLogin != null) {
                                this.netContext.getResponse().mErrorString = this.mNetLogin.getErrorString();
                                return null;
                            }
                            this.netContext.getResponse().mErrorString = str;
                            return netString;
                        }
                        netString = process_second(i);
                    } else {
                        sendLoginMessage();
                        return null;
                    }
                }
                es6.b(this);
                return netString;
            }
        }
        return (String) invokeCommon.objValue;
    }

    private String process_second(int i) {
        InterceptResult invokeI;
        String netString;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i)) == null) {
            modSessionData();
            if (i == 1) {
                netString = this.mNet.getNetString();
            } else if (i == 2) {
                netString = this.mNet.postNetData();
            } else if (i != 3) {
                return null;
            } else {
                netString = this.mNet.postMultiNetData();
            }
            if (this.netContext.getResponse().isNetSuccess() && ((i2 = this.netContext.getResponse().mServerErrorCode) == 1 || i2 == 2 || i2 == 5)) {
                sendLoginMessage();
                this.netContext.getResponse().mErrorString = "";
                return null;
            }
            return netString;
        }
        return (String) invokeI.objValue;
    }

    private void removeAccount(AccountData accountData) {
        ow4 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, accountData) == null) || TextUtils.isEmpty(accountData.getID()) || (b = nw4.b()) == null) {
            return;
        }
        b.c(accountData);
    }

    private void sendLoginMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
        }
    }

    public void addPostData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.mNet.addPostData(str, str2);
        }
    }

    public void cancelNetConnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            INetWorkCore iNetWorkCore = this.mNet;
            if (iNetWorkCore != null) {
                iNetWorkCore.cancelNetConnect();
            }
            NetWork netWork = this.mNetLogin;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public boolean downloadFile(String str, Handler handler, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, handler, i)) == null) ? downloadFile(str, handler, i, 5, 100) : invokeLLI.booleanValue;
    }

    public String getErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.netContext.getResponse().mErrorString : (String) invokeV.objValue;
    }

    public HttpNetContext getNetContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.netContext : (HttpNetContext) invokeV.objValue;
    }

    public byte[] getNetData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.netContext.getRequest().mIsFromCDN) {
                this.netContext.getRequest().addCommonParam(this.mNet);
            }
            return this.mNet.getNetData();
        }
        return (byte[]) invokeV.objValue;
    }

    public int getNetErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.netContext.getResponse().mNetErrorCode : invokeV.intValue;
    }

    public String getNetException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.netContext.getResponse().mException : (String) invokeV.objValue;
    }

    public String getNetString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? process(1, false) : (String) invokeV.objValue;
    }

    public ArrayList<BasicNameValuePair> getPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mNet.getPostData() : (ArrayList) invokeV.objValue;
    }

    public Map<String, String> getPostDataMap() {
        InterceptResult invokeV;
        ArrayList<BasicNameValuePair> postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayMap arrayMap = new ArrayMap();
            INetWorkCore iNetWorkCore = this.mNet;
            if (iNetWorkCore == null || (postData = iNetWorkCore.getPostData()) == null) {
                return arrayMap;
            }
            for (int i = 0; i < postData.size(); i++) {
                BasicNameValuePair basicNameValuePair = postData.get(i);
                if (basicNameValuePair != null) {
                    arrayMap.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
                }
            }
            return arrayMap;
        }
        return (Map) invokeV.objValue;
    }

    public int getServerErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.netContext.getResponse().mServerErrorCode : invokeV.intValue;
    }

    public boolean isNetSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.netContext.getResponse().isNetSuccess() : invokeV.booleanValue;
    }

    public String postMultiNetData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? process(3, false) : (String) invokeV.objValue;
    }

    public String postNetData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? process(2, false) : (String) invokeV.objValue;
    }

    public void setCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            INetWorkCore iNetWorkCore = this.mNet;
            if (iNetWorkCore != null) {
                iNetWorkCore.setCancel();
            }
            NetWork netWork = this.mNetLogin;
            if (netWork != null) {
                netWork.setCancel();
            }
        }
    }

    public void setNeedBdussForGet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mNeedBdussForGet = z;
        }
    }

    public void setNeedSig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mNeedSig = z;
        }
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, arrayList) == null) {
            this.mNet.setPostData(arrayList);
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.netContext.getRequest().mUrl = str;
        }
    }

    public String uploadFile(String str, String str2) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public String uploadImage(String str) throws IOException {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, basicNameValuePair) == null) {
            this.mNet.addPostData(basicNameValuePair);
        }
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, handler, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? downloadFile(str, handler, i, i2, i3, false) : invokeCommon.booleanValue;
    }

    public String postMultiNetData(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) ? process(3, z) : (String) invokeZ.objValue;
    }

    public void addPostData(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) {
            this.mNet.addPostData(str, bArr);
        }
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, handler, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            getNetContext().getRequest().addBdussData(this.mNet);
            return this.mNet.downloadFile(str, handler, i, i2, i3, z);
        }
        return invokeCommon.booleanValue;
    }

    public NetWork(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.netContext = null;
        this.mNet = null;
        this.mNetLogin = null;
        this.mStatisticsData = null;
        this.mErrorNums = 0;
        initNetWork();
        this.netContext.getRequest().mUrl = str;
    }

    public NetWork(String str, ArrayList<BasicNameValuePair> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, arrayList};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.netContext = null;
        this.mNet = null;
        this.mNetLogin = null;
        this.mStatisticsData = null;
        this.mErrorNums = 0;
        initNetWork();
        this.netContext.getRequest().mUrl = str;
        this.mNet.setPostData(arrayList);
    }
}
