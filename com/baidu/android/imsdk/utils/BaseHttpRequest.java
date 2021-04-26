package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public abstract class BaseHttpRequest implements HttpHelper.Request, HttpHelper.ResponseHandler {
    public Context mContext;
    public boolean mIsNeedSaveToDb;
    public int mPriority;
    public int mType;
    public String mUUId;

    public BaseHttpRequest() {
        this.mUUId = UUID.randomUUID().toString();
        this.mIsNeedSaveToDb = false;
        this.mPriority = 15;
    }

    public static String getHostUrl(Context context) {
        int readIntData = Utility.readIntData(context, Constants.KEY_ENV, 0);
        return (readIntData == 1 || readIntData == 2) ? "http://rd-im-server.bcc-szth.baidu.com:8080/" : readIntData != 3 ? "https://pim.baidu.com/" : Constants.URL_HTTP_BOX;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        return 15000;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public abstract Map<String, String> getHeaders();

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public abstract String getHost();

    public String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        return Utility.byte2Hex(messageDigest.digest());
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "GET";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        return 15000;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        return new byte[0];
    }

    public int getType() {
        return this.mType;
    }

    public String getUUid() {
        return this.mUUId;
    }

    public abstract void onFailure(int i2, byte[] bArr, Throwable th);

    public void onSuccess(int i2, byte[] bArr) {
    }

    public void saveRequestToDB(Context context, BaseHttpRequest baseHttpRequest, String str) {
    }

    public void setUUid(String str) {
        this.mUUId = str;
    }

    public Pair<Integer, String> transErrorCode(int i2, byte[] bArr, Throwable th) {
        String str = bArr != null ? new String(bArr) : "";
        if (th == null && i2 != 1005) {
            str = "http response is error! response code:" + i2;
            i2 = 1011;
        }
        return new Pair<>(Integer.valueOf(i2), str);
    }

    public BaseHttpRequest(boolean z) {
        this.mUUId = UUID.randomUUID().toString();
        this.mIsNeedSaveToDb = false;
        this.mPriority = 15;
        this.mIsNeedSaveToDb = z;
    }
}
