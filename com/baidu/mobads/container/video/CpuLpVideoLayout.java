package com.baidu.mobads.container.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.landingpage.JsWithPlayerData;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.mobads.container.widget.player.AdVideoView;
import com.baidu.mobads.container.widget.player.AdVideoViewListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CpuLpVideoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SOURCE_CHANGE = 1;
    public static final int SOURCE_REGISTER = 2;
    public static final String TAG = "CpuLpVideoLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public int clvIndex;
    public JsWithPlayerData mAdData;
    public AdVideoView mAdVideoView;
    public final ImageView mCoverImg;
    public CpuLpVideoControllerDecoration mCpuLpVideoControllerView;
    public JsWithPlayerData mJsWithPlayerData;
    public OnVideoStatusListener mOnVideoStatusListener;
    public boolean mOnlyNotifyUser;
    public ViewGroup mParentView;
    public boolean mPauseByUser;
    public LinearLayout.LayoutParams mPortraitParams;
    public final ProgressBar mProgressBar;
    public final AdVideoViewListener mVideoListener;
    public final Runnable updateTimeRunnable;

    /* loaded from: classes7.dex */
    public interface OnVideoStatusListener {
        void chooseNextVideo(JsWithPlayerData jsWithPlayerData);

        void choosePrevVideo(JsWithPlayerData jsWithPlayerData);

        void clickPrerolls(JsWithPlayerData jsWithPlayerData);

        void closePrerolls(JsWithPlayerData jsWithPlayerData);

        void completeVideoPlay(JsWithPlayerData jsWithPlayerData);

        void fiveSecondsLeft(JsWithPlayerData jsWithPlayerData);

        void isFullScreenStatus(boolean z);

        void occurErrorVideoPlay(JsWithPlayerData jsWithPlayerData);

        void pauseVideoPlay(JsWithPlayerData jsWithPlayerData);

        void resumeVideoPlay(JsWithPlayerData jsWithPlayerData);

        void setVideoLocation(boolean z);

        void videoNotVisible();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuLpVideoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnlyNotifyUser = true;
        this.updateTimeRunnable = new Runnable(this) { // from class: com.baidu.mobads.container.video.CpuLpVideoLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CpuLpVideoLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int duration = this.this$0.mAdVideoView.getDuration();
                    int currentPosition = this.this$0.mAdVideoView.getCurrentPosition();
                    int i4 = (duration - currentPosition) / 1000;
                    this.this$0.mCpuLpVideoControllerView.upDateVideoTime(currentPosition, duration);
                    if (i4 == 5 && this.this$0.mOnlyNotifyUser) {
                        this.this$0.mOnlyNotifyUser = false;
                        CpuLpVideoLayout cpuLpVideoLayout = this.this$0;
                        cpuLpVideoLayout.mOnVideoStatusListener.fiveSecondsLeft(cpuLpVideoLayout.mJsWithPlayerData);
                    }
                    this.this$0.postDelayed(this, 1000L);
                }
            }
        };
        this.mVideoListener = new AdVideoViewListener(this) { // from class: com.baidu.mobads.container.video.CpuLpVideoLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CpuLpVideoLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.this$0.mJsWithPlayerData.nextVideoTitle)) {
                        this.this$0.mCpuLpVideoControllerView.replayPlayIcon();
                    }
                    CpuLpVideoLayout cpuLpVideoLayout = this.this$0;
                    if (cpuLpVideoLayout.mOnVideoStatusListener != null) {
                        cpuLpVideoLayout.mJsWithPlayerData.setCurVideoStatus("video_completion");
                        this.this$0.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.this$0.mAdVideoView.getCurrentPosition()));
                        this.this$0.mJsWithPlayerData.setCurVideoUserAction("video_completion");
                        CpuLpVideoLayout cpuLpVideoLayout2 = this.this$0;
                        cpuLpVideoLayout2.mOnVideoStatusListener.completeVideoPlay(cpuLpVideoLayout2.mJsWithPlayerData);
                    }
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playFailure() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    CpuLpVideoLayout cpuLpVideoLayout = this.this$0;
                    if (cpuLpVideoLayout.mOnVideoStatusListener != null) {
                        cpuLpVideoLayout.mJsWithPlayerData.setCurVideoStatus("play_error");
                        this.this$0.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.this$0.mAdVideoView.getCurrentPosition()));
                        this.this$0.mJsWithPlayerData.setCurVideoUserAction("play_error");
                        CpuLpVideoLayout cpuLpVideoLayout2 = this.this$0;
                        cpuLpVideoLayout2.mOnVideoStatusListener.occurErrorVideoPlay(cpuLpVideoLayout2.mJsWithPlayerData);
                    }
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playPause() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.mCpuLpVideoControllerView.mVideoStatus = 11;
                    this.this$0.mCpuLpVideoControllerView.pausePlayIcon();
                    CpuLpVideoLayout cpuLpVideoLayout = this.this$0;
                    if (cpuLpVideoLayout.mOnVideoStatusListener != null) {
                        cpuLpVideoLayout.mJsWithPlayerData.setCurVideoStatus("video_pause");
                        this.this$0.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.this$0.mAdVideoView.getCurrentPosition()));
                        this.this$0.mJsWithPlayerData.setCurVideoUserAction("video_pause");
                        CpuLpVideoLayout cpuLpVideoLayout2 = this.this$0;
                        cpuLpVideoLayout2.mOnVideoStatusListener.pauseVideoPlay(cpuLpVideoLayout2.mJsWithPlayerData);
                    }
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playResume() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.this$0.mCpuLpVideoControllerView.mVideoStatus = 10;
                    this.this$0.mCpuLpVideoControllerView.resumePlayIcon();
                    this.this$0.mAdVideoView.setPlayBackSpeed(this.this$0.mCpuLpVideoControllerView.mPlayBackSpeed);
                    this.this$0.startCounter();
                    this.this$0.mCpuLpVideoControllerView.setChildrenVisible();
                    CpuLpVideoLayout cpuLpVideoLayout = this.this$0;
                    if (cpuLpVideoLayout.mOnVideoStatusListener != null) {
                        cpuLpVideoLayout.mJsWithPlayerData.setCurVideoUserAction("video_resume");
                        this.this$0.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.this$0.mAdVideoView.getCurrentPosition()));
                        this.this$0.mJsWithPlayerData.setCurVideoStatus("video_resume");
                        CpuLpVideoLayout cpuLpVideoLayout2 = this.this$0;
                        cpuLpVideoLayout2.mOnVideoStatusListener.resumeVideoPlay(cpuLpVideoLayout2.mJsWithPlayerData);
                    }
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void renderingStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.this$0.mAdVideoView.setPlayBackSpeed(this.this$0.mCpuLpVideoControllerView.mPlayBackSpeed);
                    this.this$0.mCpuLpVideoControllerView.mVideoStatus = 10;
                    this.this$0.startCounter();
                    this.this$0.mCpuLpVideoControllerView.mProgressSeekBar.setMax(this.this$0.mAdVideoView.getDuration());
                }
            }
        };
        this.mCoverImg = new ImageView(context);
        addView(this.mCoverImg, new RelativeLayout.LayoutParams(-1, -1));
        this.mProgressBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.mProgressBar, layoutParams);
        initVideoView();
        initControlVideoView();
    }

    private void initControlVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            CpuLpVideoControllerDecoration cpuLpVideoControllerDecoration = new CpuLpVideoControllerDecoration(getContext(), this);
            this.mCpuLpVideoControllerView = cpuLpVideoControllerDecoration;
            cpuLpVideoControllerDecoration.setChildrenVisible();
        }
    }

    private void initVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mAdVideoView = new AdVideoView(getContext());
            addView(this.mAdVideoView, new RelativeLayout.LayoutParams(-1, -1));
            this.mAdVideoView.setAdVideoViewListener(this.mVideoListener);
            this.mAdVideoView.initAdVideoView();
            this.mAdVideoView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCounter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mOnlyNotifyUser = true;
            postDelayed(this.updateTimeRunnable, 1000L);
        }
    }

    private void stopCounter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            removeCallbacks(this.updateTimeRunnable);
        }
    }

    public void addPrerolls(JsWithPlayerData jsWithPlayerData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsWithPlayerData) == null) {
            this.mAdData = jsWithPlayerData;
            this.mCpuLpVideoControllerView.setAdData(jsWithPlayerData);
        }
    }

    public void changePlayProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mAdVideoView.seekTo(i2);
        }
    }

    public void changeVideoSound(boolean z) {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (adVideoView = this.mAdVideoView) == null) {
            return;
        }
        adVideoView.setVideoMute(z);
    }

    public void changeVideoUrl(JsWithPlayerData jsWithPlayerData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsWithPlayerData) == null) {
            this.mJsWithPlayerData = jsWithPlayerData;
            this.mAdVideoView.stopAndRelease();
            this.mAdVideoView.setVideoUrl(this.mJsWithPlayerData.videoUrl);
            this.mAdVideoView.startPlay(this.mJsWithPlayerData.videoUrl);
            this.mCpuLpVideoControllerView.fillFloatViewWithData(jsWithPlayerData, 1);
        }
    }

    public void clickPreRollsAd() {
        OnVideoStatusListener onVideoStatusListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (onVideoStatusListener = this.mOnVideoStatusListener) == null) {
            return;
        }
        onVideoStatusListener.clickPrerolls(this.mAdData);
    }

    public void closePrerollsAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            resumeVideo();
            OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
            if (onVideoStatusListener != null) {
                onVideoStatusListener.closePrerolls(this.mAdData);
            }
        }
    }

    public void fullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).setRequestedOrientation(0);
                View findViewById = getRootView().findViewById(16908290);
                ViewParent parent = getParent();
                this.mPortraitParams = (LinearLayout.LayoutParams) getLayoutParams();
                if (parent instanceof ViewGroup) {
                    if (this.mParentView == null) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        this.mParentView = viewGroup;
                        this.clvIndex = viewGroup.indexOfChild(this);
                    }
                    ((ViewGroup) parent).removeView(this);
                }
                if (findViewById instanceof ViewGroup) {
                    ((ViewGroup) findViewById).addView(this, new FrameLayout.LayoutParams(-1, -1));
                }
            }
            AdVideoView adVideoView = this.mAdVideoView;
            if (adVideoView != null) {
                adVideoView.onResume();
            }
            this.mCpuLpVideoControllerView.mTopTipsView.setVisibility(8);
            this.mCpuLpVideoControllerView.modifyUIAfterOrientationChanged(false);
            OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
            if (onVideoStatusListener != null) {
                onVideoStatusListener.isFullScreenStatus(true);
            }
        }
    }

    public void initLayoutWithVideoData(JsWithPlayerData jsWithPlayerData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsWithPlayerData) == null) {
            this.mJsWithPlayerData = jsWithPlayerData;
            this.mAdVideoView.setVisibility(0);
            this.mCpuLpVideoControllerView.fillFloatViewWithData(this.mJsWithPlayerData, 2);
            this.mCoverImg.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        }
    }

    public void nextVideo() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.mAdVideoView == null || this.mOnVideoStatusListener == null) {
            return;
        }
        this.mJsWithPlayerData.setCurVideoUserAction("next_video");
        this.mJsWithPlayerData.setCurVideoStatus("next_video");
        this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.mAdVideoView.getCurrentPosition()));
        this.mOnVideoStatusListener.chooseNextVideo(this.mJsWithPlayerData);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            AdVideoView adVideoView = this.mAdVideoView;
            if (adVideoView != null) {
                adVideoView.stopAndRelease();
                stopCounter();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                this.mCpuLpVideoControllerView.setChildrenVisible();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
            if (i2 == 8) {
                this.mAdVideoView.stopAndRelease();
                OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
                if (onVideoStatusListener != null) {
                    onVideoStatusListener.videoNotVisible();
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        AdVideoView adVideoView;
        AdVideoView adVideoView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (getVisibility() != 0 || this.mPauseByUser) {
                return;
            }
            if (!z && (adVideoView2 = this.mAdVideoView) != null && adVideoView2.isPlaying()) {
                this.mAdVideoView.onPause();
            } else if (!z || (adVideoView = this.mAdVideoView) == null) {
            } else {
                adVideoView.onResume();
            }
        }
    }

    public void pauseVideo() {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (adVideoView = this.mAdVideoView) != null && adVideoView.isPlaying()) {
            this.mAdVideoView.onPause();
            this.mPauseByUser = true;
        }
    }

    public void playVideo() {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.mJsWithPlayerData.isAutoPlayThis && (adVideoView = this.mAdVideoView) != null) {
            adVideoView.clearData();
            this.mAdVideoView.stopAndRelease();
            this.mAdVideoView.setVideoUrl(this.mJsWithPlayerData.videoUrl);
            this.mAdVideoView.startPlay(this.mJsWithPlayerData.videoUrl);
        }
    }

    public void prevVideo() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.mAdVideoView == null || this.mOnVideoStatusListener == null) {
            return;
        }
        this.mJsWithPlayerData.setCurVideoUserAction("prev_video");
        this.mJsWithPlayerData.setCurVideoStatus("prev_video");
        this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.mAdVideoView.getCurrentPosition()));
        this.mOnVideoStatusListener.choosePrevVideo(this.mJsWithPlayerData);
    }

    public void resumeVideo() {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (adVideoView = this.mAdVideoView) == null) {
            return;
        }
        adVideoView.onResume();
        this.mPauseByUser = false;
    }

    public void retryPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.mOnVideoStatusListener == null) {
            return;
        }
        this.mJsWithPlayerData.setCurVideoStatus("video_replay");
        this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.mAdVideoView.getCurrentPosition()));
        this.mJsWithPlayerData.setCurVideoUserAction("video_replay");
        this.mOnVideoStatusListener.completeVideoPlay(this.mJsWithPlayerData);
    }

    public void setCoverPic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            XAdSimpleImageLoader.obtain(getContext()).load(this.mCoverImg, str);
        }
    }

    public void setOnVideoStatusListener(OnVideoStatusListener onVideoStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onVideoStatusListener) == null) {
            this.mOnVideoStatusListener = onVideoStatusListener;
        }
    }

    public void setPlayBackSpeed(float f2) {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048597, this, f2) == null) || (adVideoView = this.mAdVideoView) == null) {
            return;
        }
        adVideoView.setPlayBackSpeed(f2);
    }

    public void setVideoLocation(boolean z) {
        OnVideoStatusListener onVideoStatusListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (onVideoStatusListener = this.mOnVideoStatusListener) == null) {
            return;
        }
        onVideoStatusListener.setVideoLocation(z);
    }

    public void shrinkScreen() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || ((Activity) getContext()).getRequestedOrientation() == 1) {
            return;
        }
        ((Activity) getContext()).setRequestedOrientation(1);
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        ViewGroup viewGroup = this.mParentView;
        if (viewGroup != null && viewGroup.getParent() != null) {
            this.mParentView.addView(this, this.clvIndex, this.mPortraitParams);
        }
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.onResume();
        }
        this.mCpuLpVideoControllerView.mTopTipsView.setVisibility(0);
        this.mCpuLpVideoControllerView.modifyUIAfterOrientationChanged(true);
        OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
        if (onVideoStatusListener != null) {
            onVideoStatusListener.isFullScreenStatus(false);
        }
    }
}
