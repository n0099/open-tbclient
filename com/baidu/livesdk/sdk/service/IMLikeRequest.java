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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class IMLikeRequest implements LikeRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final long TIME_INTERVAL = 1200;
    public transient /* synthetic */ FieldHolder $fh;
    public int mClickHeartCount;
    public long mFirstClickTime;

    public IMLikeRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private boolean needSyncToNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mFirstClickTime == 0) {
                this.mFirstClickTime = System.currentTimeMillis();
            }
            return System.currentTimeMillis() - this.mFirstClickTime > TIME_INTERVAL && this.mClickHeartCount > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.livesdk.api.service.LikeRequest
    public void like(Context context, String str, String str2, int i2, int i3, SimpleResponseListener simpleResponseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), simpleResponseListener}) == null) {
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
                        iMLikeData.num = i2;
                        iMLikeData.roomId = parseLong;
                        iMLikeData.callFlag = i3;
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
                        baseConversation.sendQuizOpts(parseLong, parseLong2, 1000, iMLikeData.toJson(), new IMcastSetListener(this, simpleResponseListener) { // from class: com.baidu.livesdk.sdk.service.IMLikeRequest.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ IMLikeRequest this$0;
                            public final /* synthetic */ SimpleResponseListener val$listener;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, simpleResponseListener};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$listener = simpleResponseListener;
                            }

                            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                            public void onResult(int i4, long j, long j2) {
                                SimpleResponseListener simpleResponseListener2;
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2)}) == null) || (simpleResponseListener2 = this.val$listener) == null) {
                                    return;
                                }
                                simpleResponseListener2.onResult(i4, j, j2);
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
}
