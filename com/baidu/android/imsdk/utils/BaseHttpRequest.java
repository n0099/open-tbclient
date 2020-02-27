package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.util.Pair;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes3.dex */
public abstract class BaseHttpRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    protected Context mContext;
    protected boolean mIsNeedSaveToDb;
    protected int mPriority;
    protected int mType;
    protected String mUUId;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public abstract Map<String, String> getHeaders();

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public abstract String getHost();

    public abstract void onFailure(int i, byte[] bArr, Throwable th);

    public BaseHttpRequest() {
        this.mUUId = UUID.randomUUID().toString();
        this.mIsNeedSaveToDb = false;
        this.mPriority = 15;
    }

    public BaseHttpRequest(boolean z) {
        this.mUUId = UUID.randomUUID().toString();
        this.mIsNeedSaveToDb = false;
        this.mPriority = 15;
        this.mIsNeedSaveToDb = z;
    }

    public int getType() {
        return this.mType;
    }

    protected void saveRequestToDB(Context context, BaseHttpRequest baseHttpRequest, String str) {
    }

    public String getUUid() {
        return this.mUUId;
    }

    public void setUUid(String str) {
        this.mUUId = str;
    }

    public String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        return Utility.byte2Hex(messageDigest.digest());
    }

    public Pair<Integer, String> transErrorCode(int i, byte[] bArr, Throwable th) {
        String str = "";
        if (bArr != null) {
            str = new String(bArr);
        }
        if (th == null && i != 1005) {
            str = "http response is error! response code:" + i;
            i = 1011;
        }
        return new Pair<>(Integer.valueOf(i), str);
    }

    public void onSuccess(int i, byte[] bArr) {
    }

    public static String getHostUrl(Context context) {
        switch (Utility.readIntData(context, Constants.KEY_ENV, 0)) {
            case 0:
                return Constants.URL_HTTP_ONLINE;
            case 1:
            case 2:
                return Constants.URL_HTTP_RD;
            case 3:
                return Constants.URL_HTTP_BOX;
            default:
                return Constants.URL_HTTP_ONLINE;
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "GET";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        return new byte[0];
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        return BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        return BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
    }
}
