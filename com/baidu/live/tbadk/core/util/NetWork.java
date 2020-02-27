package com.baidu.live.tbadk.core.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.network.http.BdNetWorkManager;
import com.baidu.live.adp.lib.network.http.interfaces.DownLoadCallback;
import com.baidu.live.adp.lib.network.http.interfaces.INetWork;
import com.baidu.live.adp.lib.network.http.interfaces.NetResponse;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.data.ErrorData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.NetWorkState;
import com.baidu.live.tbadk.core.util.httpnet.HttpResponse;
import com.baidu.live.u.a;
import com.baidu.sofire.ac.FH;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class NetWork {
    public static final String BDUSS = "BDUSS";
    public static final String CLIENT_ID = "_client_id";
    public static final String CLIENT_TYPE = "_client_type";
    public static final String CLIENT_VERSION = "_client_version";
    public static final String FROM = "from";
    public static final String NET_CLASS = "net";
    public static final String NET_TYPE = "net_type";
    private static final int NET_TYPE_GET = 1;
    private static final int NET_TYPE_POST = 2;
    private static final int NET_TYPE_POST_CHUNK = 3;
    public static final String PHONE_IMEI = "_phone_imei";
    private static final String SIGN_SUFFIX = "tiebaclient!!!";
    public static final String STOKEN = "stoken";
    public static final String SUBAPP_TYPE = "subapp_type";
    public static final String TBS = "tbs";
    private NetResponse mReponse;
    private int mServerErrorCode;
    private String mServerErrorString;
    private INetWork mNet = null;
    private HashMap<String, String> mHeaders = new HashMap<>();
    private HashMap<String, Object> mParams = new HashMap<>();
    public boolean isNeedTbs = false;
    public boolean isUseCurrentBDUSS = true;
    public boolean isNeedAddCommenParam = true;
    private Comparator<Map.Entry<String, Object>> mComparator = new ParamsComparator(SORT.ASCEND);
    private NetWorkState.StatisticsData mStatisticsData = null;
    private int mErrorNums = 0;

    /* loaded from: classes3.dex */
    public interface DownloadResultCallback {
        void onFail(int i);

        void onSucess();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public enum SORT {
        ASCEND,
        DESCEND,
        NONE
    }

    private void initNetWork() {
        this.mNet = BdNetWorkManager.getInstance().buildNetWork();
    }

    public NetResponse getNetResponse() {
        return this.mReponse;
    }

    public NetWork() {
        initNetWork();
    }

    public NetWork(String str) {
        initNetWork();
        this.mNet.setUrl(str);
    }

    public void setUrl(String str) {
        this.mNet.setUrl(str);
    }

    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it = arrayList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mParams.put(next.getName(), next.getValue());
            }
        }
    }

    public void addPostData(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null) {
            this.mParams.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
        }
    }

    public void addPostData(String str, byte[] bArr) {
        this.mParams.put(str, bArr);
    }

    private void modSessionData() {
        this.mParams.put("BDUSS", TbadkCoreApplication.getCurrentBduss());
        this.mParams.put("tbs", TbadkCoreApplication.getInst().getTbs());
    }

    public long getNetDataSize() {
        if (this.mReponse != null) {
            return this.mReponse.downSize;
        }
        return 0L;
    }

    private void addStatisticsDataParam() {
        if (this.mStatisticsData == null) {
            this.mStatisticsData = NetWorkState.delStatisticsData();
        }
        if (this.mStatisticsData != null) {
            this.mParams.put("stTime", String.valueOf(this.mStatisticsData.mTime));
            this.mParams.put("stSize", String.valueOf(this.mStatisticsData.mSize));
            this.mParams.put("stTimesNum", String.valueOf(this.mStatisticsData.mTimesNum));
            this.mParams.put("stMode", String.valueOf(this.mStatisticsData.mMode));
            this.mParams.put("stMethod", String.valueOf(this.mStatisticsData.mMethod));
        }
        this.mErrorNums = NetWorkState.getErrorNumsAndSet(0);
        if (this.mErrorNums == 0 && this.mStatisticsData != null) {
            this.mErrorNums = this.mStatisticsData.mTimesNum;
        }
        this.mParams.put("stErrorNums", String.valueOf(this.mErrorNums));
    }

    public int getServerErrorCode() {
        return this.mServerErrorCode;
    }

    public int getNetErrorCode() {
        if (this.mReponse != null) {
            return this.mReponse.netErrorCode;
        }
        return 0;
    }

    public String getErrorString() {
        return this.mServerErrorString;
    }

    public void cancelNetConnect() {
        if (this.mNet != null) {
            this.mNet.cancel();
        }
    }

    private void addSign() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList arrayList = new ArrayList(this.mParams.entrySet());
        if (this.mComparator != null) {
            Collections.sort(arrayList, this.mComparator);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if ((value instanceof String) && !"sign".equals(str)) {
                    stringBuffer.append(str + ETAG.EQUAL);
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append(SIGN_SUFFIX);
        this.mParams.put("sign", Md5.toMd5(stringBuffer.toString()));
    }

    private String process(int i) {
        switch (i) {
            case 1:
                addCommonHeader(false, false);
                if (this.isNeedAddCommenParam) {
                    addCommonParam();
                }
                addStatisticsDataParam();
                addSign();
                this.mReponse = this.mNet.get(new ArrayList(this.mParams.entrySet()));
                break;
            case 2:
                addCommonHeader(false, false);
                if (this.isUseCurrentBDUSS) {
                    addBdussData();
                }
                if (this.isNeedAddCommenParam) {
                    addCommonParam();
                }
                addStatisticsDataParam();
                addSign();
                this.mReponse = this.mNet.post(new ArrayList(this.mParams.entrySet()));
                break;
            case 3:
                addCommonHeader(false, false);
                if (this.isUseCurrentBDUSS) {
                    addBdussData();
                }
                if (this.isNeedAddCommenParam) {
                    addCommonParam();
                }
                addSign();
                this.mReponse = this.mNet.post(new ArrayList(this.mParams.entrySet()));
                break;
            default:
                return r0;
        }
        r0 = this.mReponse != null ? this.mReponse.decodedResponseStr : null;
        if (!isNetSuccess()) {
            NetWorkState.addStatisticsData(this.mStatisticsData);
            NetWorkState.addErrorNumsAndGet(this.mErrorNums);
        } else if (!isRequestSuccess() && this.mServerErrorCode == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN));
        }
        return r0;
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

    public void downloadFile(String str, final Handler handler, final int i, int i2, final DownloadResultCallback downloadResultCallback) {
        addBdussData();
        addCommonHeader(false, true);
        this.mNet.setRetryCount(i2);
        addCommonParam();
        this.mNet.download("", str, new DownLoadCallback() { // from class: com.baidu.live.tbadk.core.util.NetWork.1
            @Override // com.baidu.live.adp.lib.network.http.interfaces.DownLoadCallback
            public void onFileUpdateProgress(Object obj, long j, long j2) {
                handler.sendMessage(Message.obtain(handler, i, (int) j, (int) j2, obj));
            }

            @Override // com.baidu.live.adp.lib.network.http.interfaces.DownLoadCallback
            public void onFileDownloaded(Object obj, int i3) {
                if (downloadResultCallback != null) {
                    if (i3 == 0) {
                        downloadResultCallback.onSucess();
                    } else {
                        downloadResultCallback.onFail(i3);
                    }
                }
            }
        });
    }

    private void addBdussData() {
        String bduss;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null && (bduss = currentAccountInfo.getBDUSS()) != null) {
            this.mParams.put("BDUSS", bduss);
        }
    }

    private void addCommonParam() {
        this.mParams.put("_client_type", "2");
        this.mParams.put("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.mParams.put("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            this.mParams.put("subapp_type", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.mParams.put("from", from);
        }
        int netType = BdNetTypeUtil.netType();
        this.mParams.put("net_type", String.valueOf(netType));
        if (1 != netType ? TbadkCoreApplication.getInst().getKeepaliveNonWifi() != 1 : TbadkCoreApplication.getInst().getKeepaliveWifi() != 1) {
        }
        if (this.isNeedTbs) {
            this.mParams.put("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        this.mParams.put("cuid", TbadkCoreApplication.getInst().getCuid());
        this.mParams.put("timestamp", Long.toString(System.currentTimeMillis()));
        this.mParams.put("model", Build.MODEL);
        if (SharedPrefHelper.getInstance().getInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, 0) == 1) {
            this.mParams.put("z_id", FH.gz(TbadkCoreApplication.getInst()));
        }
    }

    private void addCommonHeader(boolean z, boolean z2) {
        if (z) {
            this.mHeaders.put(Headers.ACCEPT_ENCODING, "gzip");
        } else {
            this.mHeaders.put(Headers.ACCEPT_ENCODING, "");
        }
        if (z2) {
            this.mHeaders.put(SM.COOKIE, "ka=open");
            this.mHeaders.put(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            this.mHeaders.put(HTTP.CONN_DIRECTIVE, "close");
        }
        this.mNet.setHeaderData(this.mHeaders);
    }

    private String parseToString(byte[] bArr) throws Exception {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, getCharset());
    }

    private String getCharset() throws Exception {
        int indexOf;
        String contentType = getContentType();
        if (contentType == null || (indexOf = contentType.indexOf("charset")) == -1) {
            return "utf-8";
        }
        int indexOf2 = contentType.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            return contentType.substring(indexOf + 8);
        }
        return contentType.substring(indexOf + 8, indexOf2);
    }

    private String getContentType() {
        if (this.mReponse != null) {
            return this.mReponse.contentType;
        }
        return null;
    }

    protected void parseServerResponsedData(String str) {
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.mServerErrorCode = errorData.getError_code();
                if (this.mServerErrorCode == -1) {
                    this.mServerErrorString = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_error_unkown_try_again);
                } else {
                    this.mServerErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.mServerErrorCode = -1;
                this.mServerErrorString = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_error_unkown_try_again);
            }
        }
    }

    public boolean isNetSuccess() {
        return this.mReponse != null && this.mReponse.responseCode == 200;
    }

    public boolean isRequestSuccess() {
        return isNetSuccess() && this.mServerErrorCode == 0;
    }

    public HttpResponse getHttpResponse() {
        if (this.mReponse == null) {
            return null;
        }
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.mNetErrorCode = this.mReponse.netErrorCode;
        httpResponse.mServerErrorCode = this.mServerErrorCode;
        httpResponse.mErrorString = this.mServerErrorString;
        httpResponse.mHeader = this.mReponse.headers;
        return httpResponse;
    }

    /* loaded from: classes3.dex */
    private static class ParamsComparator implements Comparator<Map.Entry<String, Object>> {
        private SORT mSort;

        public ParamsComparator(SORT sort) {
            this.mSort = null;
            this.mSort = sort;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
            return this.mSort == SORT.ASCEND ? entry.getKey().compareTo(entry2.getKey()) : entry2.getKey().compareTo(entry.getKey());
        }
    }
}
