package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class XNativeView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XNativeView";
    public transient /* synthetic */ FieldHolder $fh;
    public br mAdLogger;
    public XAdNativeResponse mCurrentNativeItem;
    public INativeVideoListener mFeedVideoListener;
    public INativeViewClickListener mNativeViewListener;
    public int mProgressBg;
    public int mProgressColor;
    public int mProgressHeight;
    public boolean mShowProgressBar;
    public FeedPortraitVideoView mVideoView;
    public boolean videoMute;

    /* loaded from: classes3.dex */
    public interface INativeViewClickListener {
        void onNativeViewClick(XNativeView xNativeView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XNativeView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private boolean isVisible(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, this, view2, i)) == null) {
            if (view2 == null || view2.getVisibility() != 0 || view2.getParent() == null) {
                return false;
            }
            Rect rect = new Rect();
            if (!view2.getGlobalVisibleRect(rect)) {
                return false;
            }
            long height = rect.height() * rect.width();
            long height2 = view2.getHeight() * view2.getWidth();
            if (height2 <= 0 || height * 100 < i * height2) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.videoMute = true;
        this.mProgressColor = -1;
        this.mProgressBg = -16777216;
        this.mShowProgressBar = false;
        this.mProgressHeight = 1;
        this.mAdLogger = br.a();
        setBackgroundColor(Color.parseColor("#000000"));
    }

    private void showView(XAdNativeResponse xAdNativeResponse) {
        FeedPortraitVideoView feedPortraitVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65549, this, xAdNativeResponse) != null) || (feedPortraitVideoView = this.mVideoView) == null) {
            return;
        }
        feedPortraitVideoView.showFeedVideoCover(xAdNativeResponse);
    }

    public void setNativeItem(NativeResponse nativeResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nativeResponse) == null) {
            this.mCurrentNativeItem = (XAdNativeResponse) nativeResponse;
            renderView();
        }
    }

    public void setNativeVideoListener(INativeVideoListener iNativeVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iNativeVideoListener) == null) {
            this.mFeedVideoListener = iNativeVideoListener;
        }
    }

    public void setNativeViewClickListener(INativeViewClickListener iNativeViewClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iNativeViewClickListener) == null) {
            this.mNativeViewListener = iNativeViewClickListener;
        }
    }

    public void setProgressBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mProgressBg = i;
            FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
            if (feedPortraitVideoView != null) {
                feedPortraitVideoView.setProgressBackgroundColor(i);
            }
        }
    }

    public void setProgressBarColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mProgressColor = i;
            FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
            if (feedPortraitVideoView != null) {
                feedPortraitVideoView.setProgressBarColor(i);
            }
        }
    }

    public void setProgressHeightInDp(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mProgressHeight = i;
            FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
            if (feedPortraitVideoView != null) {
                feedPortraitVideoView.setProgressHeightInDp(i);
            }
        }
    }

    public void setShowProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mShowProgressBar = z;
            FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
            if (feedPortraitVideoView != null) {
                feedPortraitVideoView.setShowProgress(z);
            }
        }
    }

    public void setUseDownloadFrame(boolean z) {
        FeedPortraitVideoView feedPortraitVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (feedPortraitVideoView = this.mVideoView) != null) {
            feedPortraitVideoView.setUseDownloadFrame(z);
        }
    }

    public void setVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.videoMute = z;
            FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
            if (feedPortraitVideoView != null) {
                feedPortraitVideoView.setVideoMute(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callNativeViewClick() {
        INativeViewClickListener iNativeViewClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && (iNativeViewClickListener = this.mNativeViewListener) != null) {
            iNativeViewClickListener.onNativeViewClick(this);
        }
    }

    private void initAdVideoView() {
        FeedPortraitVideoView feedPortraitVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, this) != null) || (feedPortraitVideoView = this.mVideoView) == null) {
            return;
        }
        feedPortraitVideoView.setCanClickVideo(true);
        this.mVideoView.setAdData(this.mCurrentNativeItem);
        this.mVideoView.systemSetVideoMute(this.videoMute);
    }

    private void play() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.mVideoView != null) {
            initAdVideoView();
            this.mVideoView.hideFeedPauseBtn(this.mCurrentNativeItem);
            this.mVideoView.play();
        }
    }

    public void handleCover() {
        FeedPortraitVideoView feedPortraitVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (feedPortraitVideoView = this.mVideoView) == null) {
            return;
        }
        feedPortraitVideoView.handleFeedCover(this.mCurrentNativeItem);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            XNativeViewManager.getInstance().addItem(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            XNativeViewManager.getInstance().removeNativeView(this);
        }
    }

    public void pause() {
        FeedPortraitVideoView feedPortraitVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (feedPortraitVideoView = this.mVideoView) != null) {
            feedPortraitVideoView.pause();
        }
    }

    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (shouldAutoPlay()) {
                play();
            } else {
                initAdVideoView();
            }
        }
    }

    public void resume() {
        FeedPortraitVideoView feedPortraitVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (feedPortraitVideoView = this.mVideoView) != null) {
            feedPortraitVideoView.resume();
        }
    }

    public void stop() {
        FeedPortraitVideoView feedPortraitVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (feedPortraitVideoView = this.mVideoView) != null) {
            feedPortraitVideoView.stop();
        }
    }

    private void renderView() {
        XAdNativeResponse xAdNativeResponse;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65547, this) != null) || (xAdNativeResponse = this.mCurrentNativeItem) == null) {
            return;
        }
        NativeResponse.MaterialType materialType = xAdNativeResponse.getMaterialType();
        if (this.mVideoView == null) {
            FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(getContext());
            this.mVideoView = feedPortraitVideoView;
            feedPortraitVideoView.setShowProgress(this.mShowProgressBar);
            this.mVideoView.setProgressBarColor(this.mProgressColor);
            this.mVideoView.setProgressBackgroundColor(this.mProgressBg);
            this.mVideoView.setProgressHeightInDp(this.mProgressHeight);
            addView(this.mVideoView, new RelativeLayout.LayoutParams(-1, -1));
            this.mVideoView.setFeedPortraitListener(new IFeedPortraitListener(this) { // from class: com.baidu.mobads.sdk.api.XNativeView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XNativeView this$0;

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

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void pauseBtnClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.callNativeViewClick();
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playCompletion() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.onCompletion();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playError() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.onError();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playPause() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048579, this) == null) && this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.onPause();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playResume() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048581, this) == null) && this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.onResume();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playRenderingStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        if (this.this$0.mVideoView != null) {
                            this.this$0.mVideoView.hideFeedCoverPic(this.this$0.mCurrentNativeItem);
                        }
                        XNativeViewManager.getInstance().resetAllPlayer(this.this$0);
                        if (this.this$0.mFeedVideoListener != null) {
                            this.this$0.mFeedVideoListener.onRenderingStart();
                        }
                    }
                }
            });
        }
        if (materialType == NativeResponse.MaterialType.NORMAL) {
            this.mVideoView.showNormalPic(this.mCurrentNativeItem);
        } else if (materialType == NativeResponse.MaterialType.VIDEO) {
            showView(this.mCurrentNativeItem);
        }
    }

    private boolean shouldAutoPlay() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
            if (xAdNativeResponse != null && xAdNativeResponse.isAutoPlay()) {
                z = true;
            } else {
                z = false;
            }
            XAdNativeResponse xAdNativeResponse2 = this.mCurrentNativeItem;
            if (xAdNativeResponse2 != null && !xAdNativeResponse2.isNonWifiAutoPlay()) {
                z2 = false;
            } else {
                z2 = true;
            }
            Boolean a = cn.a().a(getContext().getApplicationContext());
            if (z && a.booleanValue()) {
                return true;
            }
            if (z2 && !a.booleanValue()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
