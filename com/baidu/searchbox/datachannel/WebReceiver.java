package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.searchbox.datachannel.DataChannelWebSchemeDispatcher;
import com.baidu.tbadk.core.data.SmallTailInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WebReceiver extends BaseBroadcastReceiver {
    public String mJsCallback;
    public DataChannelWebSchemeDispatcher.OnWebViewCallBackListener onWebViewCallBackListener;

    public WebReceiver(DataChannelWebSchemeDispatcher.OnWebViewCallBackListener onWebViewCallBackListener, String str, String str2, String str3, String str4) {
        this.onWebViewCallBackListener = onWebViewCallBackListener;
        this.mJsCallback = str;
        this.mHost = str2;
        this.mPage = str3;
        this.mAction = str4;
    }

    public String getJsCallback() {
        return this.mJsCallback;
    }

    public DataChannelWebSchemeDispatcher.OnWebViewCallBackListener getWebViewCallBackListener() {
        return this.onWebViewCallBackListener;
    }

    @Override // com.baidu.searchbox.datachannel.BaseBroadcastReceiver
    public void release() {
        this.onWebViewCallBackListener = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.onWebViewCallBackListener == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("data");
        String str = "javascript:" + this.mJsCallback + "('" + intent.getAction() + "', " + JSONObject.quote(stringExtra) + SmallTailInfo.EMOTION_SUFFIX;
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "RNReceiver onReceive ## " + str);
        }
        this.onWebViewCallBackListener.evaluateJavascript(str);
    }
}
