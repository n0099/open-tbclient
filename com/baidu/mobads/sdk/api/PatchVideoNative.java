package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PatchVideoNative {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAdPlaceId;
    public PrerollVideoResponse mAdResponse;
    public String mAppSid;
    public BaiduNativeManager mBaiduNativeManager;
    public Context mContext;
    public boolean mIsMute;
    public IPatchVideoNativeListener mListener;
    public RelativeLayout mParentView;
    public PatchAdView mPatchView;

    /* loaded from: classes3.dex */
    public interface IPatchVideoNativeListener {
        void onAdClick();

        void onAdFailed(int i, String str);

        void onAdLoad(String str);

        void onAdShow();

        void playCompletion();

        void playError();
    }

    public PatchVideoNative(Context context, String str, RelativeLayout relativeLayout, IPatchVideoNativeListener iPatchVideoNativeListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, relativeLayout, iPatchVideoNativeListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mParentView = relativeLayout;
        this.mListener = iPatchVideoNativeListener;
        this.mBaiduNativeManager = new BaiduNativeManager(this.mContext, this.mAdPlaceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callLoadFail(int i, String str) {
        IPatchVideoNativeListener iPatchVideoNativeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65546, this, i, str) == null) && (iPatchVideoNativeListener = this.mListener) != null) {
            iPatchVideoNativeListener.onAdFailed(i, str);
        }
    }

    public void requestAd(RequestParameters requestParameters) {
        BaiduNativeManager baiduNativeManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, requestParameters) == null) && (baiduNativeManager = this.mBaiduNativeManager) != null) {
            baiduNativeManager.setAppSid(this.mAppSid);
            this.mBaiduNativeManager.loadPrerollVideo(requestParameters, new BaiduNativeManager.FeedAdListener(this) { // from class: com.baidu.mobads.sdk.api.PatchVideoNative.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PatchVideoNative this$0;

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onLpClosed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onVideoDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    }
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onVideoDownloadSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNativeFail(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) {
                        return;
                    }
                    this.this$0.callLoadFail(i, str);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNoAd(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeIL(1048579, this, i, str) != null) {
                        return;
                    }
                    this.this$0.callLoadFail(i, str);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNativeLoad(List<NativeResponse> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < list.size(); i++) {
                            arrayList.add(new XAdVideoResponse(list.get(i)));
                        }
                        this.this$0.mAdResponse = (PrerollVideoResponse) arrayList.get(0);
                        this.this$0.callLoadSucc();
                    }
                }
            });
        }
    }

    public void setAppSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mAppSid = str;
        }
    }

    public void setVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mIsMute = z;
            PatchAdView patchAdView = this.mPatchView;
            if (patchAdView != null) {
                patchAdView.setVideoVolume(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdClick() {
        IPatchVideoNativeListener iPatchVideoNativeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && (iPatchVideoNativeListener = this.mListener) != null) {
            iPatchVideoNativeListener.onAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdShow() {
        IPatchVideoNativeListener iPatchVideoNativeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && (iPatchVideoNativeListener = this.mListener) != null) {
            iPatchVideoNativeListener.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPlayCompletion() {
        IPatchVideoNativeListener iPatchVideoNativeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && (iPatchVideoNativeListener = this.mListener) != null) {
            iPatchVideoNativeListener.playCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPlayError() {
        IPatchVideoNativeListener iPatchVideoNativeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && (iPatchVideoNativeListener = this.mListener) != null) {
            iPatchVideoNativeListener.playError();
        }
    }

    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PatchAdView patchAdView = this.mPatchView;
            if (patchAdView != null) {
                return patchAdView.getCurrentPosition();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PatchAdView patchAdView = this.mPatchView;
            if (patchAdView != null) {
                return patchAdView.getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callLoadSucc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
            if (iPatchVideoNativeListener != null) {
                iPatchVideoNativeListener.onAdLoad(this.mAdResponse.getMaterialType());
            }
            PatchAdView patchAdView = new PatchAdView(this.mContext);
            this.mPatchView = patchAdView;
            patchAdView.setVideoVolume(this.mIsMute);
            this.mParentView.addView(this.mPatchView, new RelativeLayout.LayoutParams(-1, -1));
            this.mPatchView.setPatchAdListener(new IPatchAdListener(this) { // from class: com.baidu.mobads.sdk.api.PatchVideoNative.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PatchVideoNative this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.sdk.api.IPatchAdListener
                public void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.callAdClick();
                }

                @Override // com.baidu.mobads.sdk.api.IPatchAdListener
                public void onAdShow() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.this$0.callAdShow();
                }

                @Override // com.baidu.mobads.sdk.api.IPatchAdListener
                public void playCompletion() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                        return;
                    }
                    this.this$0.callPlayCompletion();
                }

                @Override // com.baidu.mobads.sdk.api.IPatchAdListener
                public void playError() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048579, this) != null) {
                        return;
                    }
                    this.this$0.callPlayError();
                }
            });
            this.mPatchView.setAdData((XAdVideoResponse) this.mAdResponse);
        }
    }
}
