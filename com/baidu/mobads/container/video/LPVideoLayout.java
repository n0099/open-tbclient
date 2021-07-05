package com.baidu.mobads.container.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.container.video.ICustomVideoView;
import com.baidu.mobads.container.widget.player.AdVideoView;
import com.baidu.mobads.container.widget.player.AdVideoViewListener;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class LPVideoLayout extends RelativeLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener, ILpVideoLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUTTON_MARGIN = 15;
    public static final int BUTTON_SIDE = 30;
    public static final String ICON_ARROW_BACK = "iVBORw0KGgoAAAANSUhEUgAAAB4AAAA2CAYAAADQzyn5AAADG0lEQVRYhb3ZW4hVVRgH8N+cc5hQBkVEhhARwRBB6AoFIqVpaBYVXex+wSIosIciRIoiHwR9UCgo0OhedqUipETLIhSKCiJMBrqJlVZEmZaVM/WwvtNZyYwzZ2avs97+i7X3b9/O2t/ap2ug/6gOtBo24GZsqtUbK7o6ANfxKG6IfLhWb/Q0OoA+gWuyvrVQEm7gaSzL+u7DAyXhbjyDy7K+VViTH1UJ9HlcnPXdjXX5oKrhbryMCyL/gzux/tiBVcLj8AoWZ+gKPDTY4Krg8XgVizL0Njwy1AZVwOPxBuZHHsCt2HS8jcYK92AL5kXul2anx4fbcCzwhEDnZuiN0m932DZaeCLexFkZei02j3QHo4EnYSvOiPyXNCW+1M5O2oUnB3pahi6Tnui2WjvwlEBPydBLpSe67TZSuBfbMCfyEVwi3edRtZHAJ2I7Zkf+PdCto0VHAk8NdFaGXoi3x4IOB08LYGbkQ1iK98aKHg+ejncwI/LBQN+vAh0KnhHo9Mi/Ygl2VYUOBs+ULu+0yL/gPHxYJUoqO5ttFnZk6M84twSaw7Olyzs18o+BflwCJV3qOdLk0Bt9PwT6WSkUugb6j/bhpMj7sQCfl0Rr9YaaVKb8dyD+f9/L4dL0tz9yr3SvT+4EvFuql76LvinSNHlqaRj2BL4v8uTATy8NQx/OxjeRJwV+ZmkYvsQ5+CryROn1N1fFbbAn+OvAv4g8QXrhzxtkbKUw7JUue1/knsDnDzG+Mhi+lc58T+TmimHRUBtUBcP3ge/O8Ne0FmbFYDgQ+KeRx0nl7NLSMK231SeRT5CWpBeVhuEnLMRHkbvxglRbF4VJxcFCfJDhm3FFaZhWObQzcgPP4urSMKkAXKxVddbxJK4vDcNvgb+b4Y9heWkYDuN86WXS3N9G6VNEUZjWsuatyF14GLeXhuEP6Te9JcMfxB2lYfhTKqNez/ANuKs0TFqsXy7Nas22DitLw038SryY9a3BPaVh+BtX4bmsb7X4ZFwSJn2Cug5PZX334n7SSqKgjTSxbMRNkTvy1wDpzJdL0+wt4hvnv8WzpKvW767AAAAAAElFTkSuQmCC";
    public static final String TAG;
    public static final int controlShowTime = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView imgfullscreen;
    public ImageView imgplay;
    public Activity mActivity;
    public AdVideoView mAdVideoView;
    public Handler mHandler;
    public boolean mPlayCompletion;
    public RelativeLayout.LayoutParams mPortraitParams;
    public AdVideoViewListener mVideoListener;
    public ICustomVideoView.VideoPlayCallbackImpl mVideoPlayCallback;
    public String mVideoUrl;
    public Context mViewContext;
    public ViewGroup parentView;
    public SeekBar seekBar;
    public TextView textElapsed;
    public TextView textTotal;
    public View.OnTouchListener touchListener;
    public Runnable updateTimeRunnable;
    public LPVideoControllerView videoControlsView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(190879693, "Lcom/baidu/mobads/container/video/LPVideoLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(190879693, "Lcom/baidu/mobads/container/video/LPVideoLayout;");
                return;
            }
        }
        TAG = LPVideoLayout.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LPVideoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.parentView = null;
        this.updateTimeRunnable = new Runnable(this) { // from class: com.baidu.mobads.container.video.LPVideoLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LPVideoLayout this$0;

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
                    this.this$0.updateCounter();
                    this.this$0.postDelayed(this, 200L);
                }
            }
        };
        this.mVideoListener = new AdVideoViewListener(this) { // from class: com.baidu.mobads.container.video.LPVideoLayout.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LPVideoLayout this$0;

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
                    this.this$0.mPlayCompletion = true;
                    this.this$0.stopCounter();
                    this.this$0.updateCounter();
                    this.this$0.updateControls(true);
                    if (this.this$0.mVideoPlayCallback != null) {
                        this.this$0.mVideoPlayCallback.onCompletion(null);
                    }
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playFailure() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.stopCounter();
                    this.this$0.updateControls(true);
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playPause() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playResume() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void renderingStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.this$0.updateControls(false);
                    int duration = this.this$0.mAdVideoView.getDuration();
                    int lastPosition = this.this$0.mAdVideoView.getLastPosition();
                    if (duration > 0) {
                        this.this$0.seekBar.setMax(duration);
                        this.this$0.seekBar.setProgress(lastPosition);
                        int i4 = duration / 1000;
                        long j = i4 % 60;
                        long j2 = (i4 / 60) % 60;
                        long j3 = (i4 / 3600) % 24;
                        if (lastPosition == 0) {
                            if (j3 > 0) {
                                this.this$0.textElapsed.setText("00:00:00");
                            } else {
                                this.this$0.textElapsed.setText("00:00");
                            }
                        }
                        if (j3 > 0) {
                            this.this$0.textTotal.setText(String.format("%d:%02d:%02d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)));
                        } else {
                            this.this$0.textTotal.setText(String.format("%02d:%02d", Long.valueOf(j2), Long.valueOf(j)));
                        }
                    }
                    this.this$0.videoControlsView.setVisibility(0);
                    this.this$0.mHandler.removeMessages(10);
                    this.this$0.mHandler.sendEmptyMessageDelayed(10, 10000L);
                }
            }
        };
        this.mHandler = new Handler(new Handler.Callback(this) { // from class: com.baidu.mobads.container.video.LPVideoLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LPVideoLayout this$0;

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

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    if (message.what == 10) {
                        this.this$0.hideControls();
                        return false;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        });
        this.mViewContext = context;
        initVideoView();
        init();
    }

    private void changeOrientation(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, activity) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Exception unused) {
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            Log.d(TAG, "init");
            LPVideoControllerView lPVideoControllerView = new LPVideoControllerView(this.mViewContext);
            this.videoControlsView = lPVideoControllerView;
            lPVideoControllerView.setId(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.videoControlsView, layoutParams);
            LPVideoControllerView lPVideoControllerView2 = this.videoControlsView;
            this.seekBar = lPVideoControllerView2.seekBar;
            this.imgfullscreen = lPVideoControllerView2.imgfullscreen;
            this.imgplay = lPVideoControllerView2.imgplay;
            this.textTotal = lPVideoControllerView2.textTotal;
            this.textElapsed = lPVideoControllerView2.textElapsed;
            super.setOnTouchListener(this);
            this.imgplay.setOnClickListener(this);
            this.imgfullscreen.setOnClickListener(this);
            this.seekBar.setOnSeekBarChangeListener(this);
            this.videoControlsView.setVisibility(4);
            addReturnButton(this.mViewContext);
        }
    }

    private void initVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.mAdVideoView = new AdVideoView(this.mViewContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.mAdVideoView, layoutParams);
            this.mAdVideoView.setAdVideoViewListener(this.mVideoListener);
            this.mAdVideoView.stopAndRelease();
            this.mAdVideoView.initAdVideoView();
        }
    }

    private void startCounter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            postDelayed(this.updateTimeRunnable, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCounter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            removeCallbacks(this.updateTimeRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleFullScreen() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            pause();
            changeOrientation(this.mActivity);
            boolean z = false;
            if (this.mActivity.getRequestedOrientation() == 0) {
                this.videoControlsView.updateImageFullscreen(true);
                this.mActivity.setRequestedOrientation(1);
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup2 = this.parentView;
                    if (viewGroup2 != null && viewGroup2.getParent() != null) {
                        z = true;
                    }
                    ((ViewGroup) parent).removeView(this);
                    if (z && (viewGroup = this.parentView) != null) {
                        viewGroup.addView(this);
                        setLayoutParams(this.mPortraitParams);
                    }
                }
            } else {
                this.mVideoPlayCallback.onFullScreen(this.mAdVideoView.getCurrentPosition());
                this.videoControlsView.updateImageFullscreen(false);
                this.mActivity.setRequestedOrientation(0);
                View findViewById = getRootView().findViewById(16908290);
                ViewParent parent2 = getParent();
                this.mPortraitParams = (RelativeLayout.LayoutParams) getLayoutParams();
                if (parent2 instanceof ViewGroup) {
                    if (this.parentView == null) {
                        this.parentView = (ViewGroup) parent2;
                    }
                    this.parentView.removeView(this);
                }
                if (findViewById instanceof ViewGroup) {
                    ((ViewGroup) findViewById).addView(this);
                }
            }
            resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCounter() {
        int currentPosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (currentPosition = this.mAdVideoView.getCurrentPosition()) <= 0 || currentPosition >= this.mAdVideoView.getDuration()) {
            return;
        }
        this.seekBar.setProgress(currentPosition);
        int round = Math.round(currentPosition / 1000.0f);
        long j = round % 60;
        long j2 = (round / 60) % 60;
        long j3 = (round / 3600) % 24;
        if (j3 > 0) {
            this.textElapsed.setText(String.format("%d:%02d:%02d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)));
        } else {
            this.textElapsed.setText(String.format("%02d:%02d", Long.valueOf(j2), Long.valueOf(j)));
        }
    }

    public void addReturnButton(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            ImageView imageView = new ImageView(context);
            int pixel = ScreenUtils.getPixel(context, 7);
            imageView.setPadding(pixel, pixel, pixel, pixel);
            imageView.setImageBitmap(ConvertUtils.string2bitmap(ICON_ARROW_BACK));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.getPixel(context, 30), ScreenUtils.getPixel(context, 30));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = ScreenUtils.getPixel(context, 15);
            layoutParams.topMargin = ScreenUtils.getPixel(context, 15);
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.video.LPVideoLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LPVideoLayout this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.this$0.mActivity.getRequestedOrientation() == 0) {
                            this.this$0.toggleFullScreen();
                        } else if (this.this$0.mVideoPlayCallback != null) {
                            this.this$0.mVideoPlayCallback.onReturnButtonClicked();
                        }
                    }
                }
            });
            addView(imageView, layoutParams);
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public boolean closeFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (this.mAdVideoView.isPlaying() && this.mActivity.getRequestedOrientation() == 0) {
                    toggleFullScreen();
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void hideControls() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.d(TAG, "hideControls");
            LPVideoControllerView lPVideoControllerView = this.videoControlsView;
            if (lPVideoControllerView != null) {
                lPVideoControllerView.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    @TargetApi(16)
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getId() == this.imgplay.getId()) {
                if (this.mAdVideoView.isPlaying()) {
                    pause();
                    return;
                } else {
                    resume();
                    return;
                }
            }
            toggleFullScreen();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            if (this.mPlayCompletion) {
                Log.d(TAG, "onDetachedFromWindow END");
                stopCounter();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Log.d(TAG, "onProgressChanged");
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, seekBar) == null) {
            stopCounter();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, seekBar) == null) {
            this.mAdVideoView.seekTo(seekBar.getProgress());
            startCounter();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        LPVideoControllerView lPVideoControllerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0 && (lPVideoControllerView = this.videoControlsView) != null) {
                if (lPVideoControllerView.getVisibility() == 0) {
                    this.mHandler.removeMessages(10);
                    hideControls();
                } else {
                    showControls();
                }
            }
            if (this.mActivity.getRequestedOrientation() == 0) {
                return true;
            }
            View.OnTouchListener onTouchListener = this.touchListener;
            if (onTouchListener != null) {
                return onTouchListener.onTouch(this, motionEvent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Log.d(TAG, "pause");
            AdVideoView adVideoView = this.mAdVideoView;
            if (adVideoView == null || !adVideoView.isPlaying()) {
                return;
            }
            this.mAdVideoView.onPause();
            stopCounter();
            updateControls(true);
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Log.d(TAG, "start");
            AdVideoView adVideoView = this.mAdVideoView;
            if (adVideoView != null) {
                adVideoView.startPlay(this.mVideoUrl);
                startCounter();
                updateControls(false);
            }
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void resume() {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (adVideoView = this.mAdVideoView) == null) {
            return;
        }
        adVideoView.onResume();
        startCounter();
        updateControls(false);
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            this.mActivity = activity;
            activity.getWindow().addFlags(128);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onTouchListener) == null) {
            this.touchListener = onTouchListener;
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void setVideoPlayCallback(ICustomVideoView.VideoPlayCallbackImpl videoPlayCallbackImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, videoPlayCallbackImpl) == null) {
            this.mVideoPlayCallback = videoPlayCallbackImpl;
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void setVideoURI(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mVideoUrl = str;
            this.mAdVideoView.setVideoUrl(str);
            play();
        }
    }

    public void showControls() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Log.d(TAG, "showControls");
            LPVideoControllerView lPVideoControllerView = this.videoControlsView;
            if (lPVideoControllerView != null) {
                lPVideoControllerView.setVisibility(0);
            }
            this.mHandler.removeMessages(10);
            this.mHandler.sendEmptyMessageDelayed(10, 10000L);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Log.d(TAG, IntentConfig.STOP);
            if (this.mAdVideoView != null) {
                this.mActivity.getWindow().clearFlags(128);
                this.mAdVideoView.stopAndRelease();
                stopCounter();
                updateControls(true);
            }
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void stopAndRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            stop();
        }
    }

    public void updateControls(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.videoControlsView.updateImagePauseOrPlay(z);
        }
    }
}
