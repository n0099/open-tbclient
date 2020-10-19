package com.baidu.android.imrtc.request;

import android.support.annotation.NonNull;
/* loaded from: classes18.dex */
public interface BIMRtcTokenListener {

    /* loaded from: classes18.dex */
    public static class BIMRTCGetTokeResult {
        public String roomId = "";
        public String token = "";
        public String rtcAppId = "";
        public long useId = -1;
    }

    void onResult(int i, String str, @NonNull BIMRTCGetTokeResult bIMRTCGetTokeResult);
}
