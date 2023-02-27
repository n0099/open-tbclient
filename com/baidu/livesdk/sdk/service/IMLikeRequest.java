package com.baidu.livesdk.sdk.service;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.livesdk.api.account.Account;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.service.LikeRequest;
import com.baidu.livesdk.api.service.SimpleResponseListener;
import com.baidu.livesdk.sdk.LiveSDK;
import com.baidu.livesdk.sdk.LiveSDKParams;
import com.baidu.livesdk.sdk.im.BDIMConversation;
import com.baidu.livesdk.sdk.im.live.LiveIMManager;
/* loaded from: classes2.dex */
public class IMLikeRequest implements LikeRequest {
    public static final boolean DEBUG = false;
    public static final long TIME_INTERVAL = 1200;
    public int mClickHeartCount;
    public long mFirstClickTime;

    private boolean needSyncToNet() {
        if (this.mFirstClickTime == 0) {
            this.mFirstClickTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - this.mFirstClickTime > TIME_INTERVAL && this.mClickHeartCount > 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.livesdk.api.service.LikeRequest
    public void like(Context context, String str, String str2, int i, int i2, final SimpleResponseListener simpleResponseListener) {
        try {
            this.mClickHeartCount++;
            if (needSyncToNet()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                LiveSDK liveSDK = LiveSDK.getInstance(context);
                IMConversation conversation = ((LiveIMManager) liveSDK.getLiveIM()).getConversation(str2);
                if (conversation != null) {
                    BIMConversation baseConversation = ((BDIMConversation) conversation).getBaseConversation();
                    IMLikeData iMLikeData = new IMLikeData();
                    iMLikeData.num = i;
                    iMLikeData.roomId = parseLong;
                    iMLikeData.callFlag = i2;
                    iMLikeData.sourceType = 0;
                    Account account = liveSDK.getAccount();
                    if (account != null && account.isLogin() && account.accountInfo() != null) {
                        try {
                            iMLikeData.uid = Long.parseLong(liveSDK.getAccount().accountInfo().getUid());
                        } catch (Exception unused) {
                            iMLikeData.uid = 0L;
                        }
                    }
                    LiveSDKParams liveSDKParams = liveSDK.getLiveSDKParams();
                    if (liveSDKParams != null) {
                        iMLikeData.appVersion = liveSDKParams.appVersion;
                        iMLikeData.cuid = liveSDKParams.cuid;
                    }
                    baseConversation.sendQuizOpts(parseLong, parseLong2, 1000, iMLikeData.toJson(), new IMcastSetListener() { // from class: com.baidu.livesdk.sdk.service.IMLikeRequest.1
                        @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                        public void onResult(int i3, long j, long j2) {
                            SimpleResponseListener simpleResponseListener2 = simpleResponseListener;
                            if (simpleResponseListener2 != null) {
                                simpleResponseListener2.onResult(i3, j, j2);
                            }
                        }
                    });
                } else if (simpleResponseListener != null) {
                    simpleResponseListener.onResult(-1, parseLong, parseLong2);
                }
                this.mClickHeartCount = 0;
                this.mFirstClickTime = System.currentTimeMillis();
            }
        } catch (Exception unused2) {
            if (simpleResponseListener != null) {
                simpleResponseListener.onResult(-1, 0L, 0L);
            }
        }
    }
}
