package com.baidu.android.imsdk.mcast;

import android.content.Context;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes.dex */
public class GetTsRequest extends FileMessageHttpRequest {
    public static final String TAG = "GetTsRequest";
    public String httpurl;
    public String mKey;

    public GetTsRequest(Context context, String str, String str2) {
        this.mContext = context;
        this.mKey = str;
        this.httpurl = str2;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return this.httpurl;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        String str = TAG;
        LogUtils.e(str, "onFailure " + i2);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof GetM3u8CallBack)) {
            return;
        }
        ((GetM3u8CallBack) removeListener).onResult(i2, null);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof GetM3u8CallBack)) {
            ((GetM3u8CallBack) removeListener).onResult(i2, bArr);
        } else {
            LogUtils.e(TAG, "GetM3u8Request listener is null ");
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
