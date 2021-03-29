package com.baidu.android.imsdk.mcast;

import android.content.Context;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes.dex */
public class GetM3u8Request extends FileMessageHttpRequest {
    public static final String TAG = "GetM3u8Request";
    public String httpurl;
    public String mKey;

    public GetM3u8Request(Context context, String str, String str2) {
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
        String str = TAG;
        LogUtils.d(str, " m3u8 url: " + this.httpurl);
        return this.httpurl;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        String str = TAG;
        LogUtils.e(str, "onFailure " + i);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof GetM3u8CallBack)) {
            ((GetM3u8CallBack) removeListener).onResult(i, null);
            return;
        }
        LogUtils.e(TAG, "GetM3u8Request listener is null ");
        UnLoginCastService.getInstance(this.mContext).handleOnM3u8Callback(i, null);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof GetM3u8CallBack)) {
            ((GetM3u8CallBack) removeListener).onResult(i, bArr);
            return;
        }
        LogUtils.e(TAG, "GetM3u8Request listener is null ");
        UnLoginCastService.getInstance(this.mContext).handleOnM3u8Callback(i, null);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
