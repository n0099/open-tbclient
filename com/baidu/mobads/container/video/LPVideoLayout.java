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
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.container.video.ICustomVideoView;
import com.baidu.mobads.container.widget.player.AdVideoView;
import com.baidu.mobads.container.widget.player.AdVideoViewListener;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class LPVideoLayout extends RelativeLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener, ILpVideoLayout {
    public static final int BUTTON_MARGIN = 15;
    public static final int BUTTON_SIDE = 30;
    public static final String ICON_ARROW_BACK = "iVBORw0KGgoAAAANSUhEUgAAAB4AAAA2CAYAAADQzyn5AAADG0lEQVRYhb3ZW4hVVRgH8N+cc5hQBkVEhhARwRBB6AoFIqVpaBYVXex+wSIosIciRIoiHwR9UCgo0OhedqUipETLIhSKCiJMBrqJlVZEmZaVM/WwvtNZyYwzZ2avs97+i7X3b9/O2t/ap2ug/6gOtBo24GZsqtUbK7o6ANfxKG6IfLhWb/Q0OoA+gWuyvrVQEm7gaSzL+u7DAyXhbjyDy7K+VViTH1UJ9HlcnPXdjXX5oKrhbryMCyL/gzux/tiBVcLj8AoWZ+gKPDTY4Krg8XgVizL0Njwy1AZVwOPxBuZHHsCt2HS8jcYK92AL5kXul2anx4fbcCzwhEDnZuiN0m932DZaeCLexFkZei02j3QHo4EnYSvOiPyXNCW+1M5O2oUnB3pahi6Tnui2WjvwlEBPydBLpSe67TZSuBfbMCfyEVwi3edRtZHAJ2I7Zkf+PdCto0VHAk8NdFaGXoi3x4IOB08LYGbkQ1iK98aKHg+ejncwI/LBQN+vAh0KnhHo9Mi/Ygl2VYUOBs+ULu+0yL/gPHxYJUoqO5ttFnZk6M84twSaw7Olyzs18o+BflwCJV3qOdLk0Bt9PwT6WSkUugb6j/bhpMj7sQCfl0Rr9YaaVKb8dyD+f9/L4dL0tz9yr3SvT+4EvFuql76LvinSNHlqaRj2BL4v8uTATy8NQx/OxjeRJwV+ZmkYvsQ5+CryROn1N1fFbbAn+OvAv4g8QXrhzxtkbKUw7JUue1/knsDnDzG+Mhi+lc58T+TmimHRUBtUBcP3ge/O8Ne0FmbFYDgQ+KeRx0nl7NLSMK231SeRT5CWpBeVhuEnLMRHkbvxglRbF4VJxcFCfJDhm3FFaZhWObQzcgPP4urSMKkAXKxVddbxJK4vDcNvgb+b4Y9heWkYDuN86WXS3N9G6VNEUZjWsuatyF14GLeXhuEP6Te9JcMfxB2lYfhTKqNez/ANuKs0TFqsXy7Nas22DitLw038SryY9a3BPaVh+BtX4bmsb7X4ZFwSJn2Cug5PZX334n7SSqKgjTSxbMRNkTvy1wDpzJdL0+wt4hvnv8WzpKvW767AAAAAAElFTkSuQmCC";
    public static final String TAG = LPVideoLayout.class.getSimpleName();
    public static final int controlShowTime = 10000;
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

    public LPVideoLayout(Context context) {
        super(context);
        this.parentView = null;
        this.updateTimeRunnable = new Runnable() { // from class: com.baidu.mobads.container.video.LPVideoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                LPVideoLayout.this.updateCounter();
                LPVideoLayout.this.postDelayed(this, 200L);
            }
        };
        this.mVideoListener = new AdVideoViewListener() { // from class: com.baidu.mobads.container.video.LPVideoLayout.3
            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playCompletion() {
                LPVideoLayout.this.mPlayCompletion = true;
                LPVideoLayout.this.stopCounter();
                LPVideoLayout.this.updateCounter();
                LPVideoLayout.this.updateControls(true);
                if (LPVideoLayout.this.mVideoPlayCallback != null) {
                    LPVideoLayout.this.mVideoPlayCallback.onCompletion(null);
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playFailure() {
                LPVideoLayout.this.stopCounter();
                LPVideoLayout.this.updateControls(true);
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playPause() {
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playResume() {
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void renderingStart() {
                LPVideoLayout.this.updateControls(false);
                int duration = LPVideoLayout.this.mAdVideoView.getDuration();
                int lastPosition = LPVideoLayout.this.mAdVideoView.getLastPosition();
                if (duration > 0) {
                    LPVideoLayout.this.seekBar.setMax(duration);
                    LPVideoLayout.this.seekBar.setProgress(lastPosition);
                    int i2 = duration / 1000;
                    long j = i2 % 60;
                    long j2 = (i2 / 60) % 60;
                    long j3 = (i2 / 3600) % 24;
                    if (lastPosition == 0) {
                        if (j3 > 0) {
                            LPVideoLayout.this.textElapsed.setText("00:00:00");
                        } else {
                            LPVideoLayout.this.textElapsed.setText("00:00");
                        }
                    }
                    if (j3 > 0) {
                        LPVideoLayout.this.textTotal.setText(String.format("%d:%02d:%02d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)));
                    } else {
                        LPVideoLayout.this.textTotal.setText(String.format("%02d:%02d", Long.valueOf(j2), Long.valueOf(j)));
                    }
                }
                LPVideoLayout.this.videoControlsView.setVisibility(0);
                LPVideoLayout.this.mHandler.removeMessages(10);
                LPVideoLayout.this.mHandler.sendEmptyMessageDelayed(10, 10000L);
            }
        };
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.mobads.container.video.LPVideoLayout.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 10) {
                    LPVideoLayout.this.hideControls();
                    return false;
                }
                return false;
            }
        });
        this.mViewContext = context;
        initVideoView();
        init();
    }

    private void changeOrientation(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    private void init() {
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

    private void initVideoView() {
        this.mAdVideoView = new AdVideoView(this.mViewContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.mAdVideoView, layoutParams);
        this.mAdVideoView.setAdVideoViewListener(this.mVideoListener);
        this.mAdVideoView.stopAndRelease();
        this.mAdVideoView.initAdVideoView();
    }

    private void startCounter() {
        postDelayed(this.updateTimeRunnable, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCounter() {
        removeCallbacks(this.updateTimeRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleFullScreen() {
        ViewGroup viewGroup;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCounter() {
        int currentPosition = this.mAdVideoView.getCurrentPosition();
        if (currentPosition <= 0 || currentPosition >= this.mAdVideoView.getDuration()) {
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
        ImageView imageView = new ImageView(context);
        int pixel = ScreenUtils.getPixel(context, 7);
        imageView.setPadding(pixel, pixel, pixel, pixel);
        imageView.setImageBitmap(ConvertUtils.string2bitmap(ICON_ARROW_BACK));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.getPixel(context, 30), ScreenUtils.getPixel(context, 30));
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.leftMargin = ScreenUtils.getPixel(context, 15);
        layoutParams.topMargin = ScreenUtils.getPixel(context, 15);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.video.LPVideoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LPVideoLayout.this.mActivity.getRequestedOrientation() == 0) {
                    LPVideoLayout.this.toggleFullScreen();
                } else if (LPVideoLayout.this.mVideoPlayCallback != null) {
                    LPVideoLayout.this.mVideoPlayCallback.onReturnButtonClicked();
                }
            }
        });
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public boolean closeFullScreen() {
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

    public void hideControls() {
        Log.d(TAG, "hideControls");
        LPVideoControllerView lPVideoControllerView = this.videoControlsView;
        if (lPVideoControllerView != null) {
            lPVideoControllerView.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    @TargetApi(16)
    public void onClick(View view) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPlayCompletion) {
            Log.d(TAG, "onDetachedFromWindow END");
            stopCounter();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        Log.d(TAG, "onProgressChanged");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        stopCounter();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.mAdVideoView.seekTo(seekBar.getProgress());
        startCounter();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LPVideoControllerView lPVideoControllerView;
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

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void pause() {
        Log.d(TAG, "pause");
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView == null || !adVideoView.isPlaying()) {
            return;
        }
        this.mAdVideoView.onPause();
        stopCounter();
        updateControls(true);
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void play() {
        Log.d(TAG, IntentConfig.START);
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.startPlay(this.mVideoUrl);
            startCounter();
            updateControls(false);
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void resume() {
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.onResume();
            startCounter();
            updateControls(false);
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void setActivity(Activity activity) {
        this.mActivity = activity;
        activity.getWindow().addFlags(128);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.touchListener = onTouchListener;
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void setVideoPlayCallback(ICustomVideoView.VideoPlayCallbackImpl videoPlayCallbackImpl) {
        this.mVideoPlayCallback = videoPlayCallbackImpl;
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void setVideoURI(String str) {
        this.mVideoUrl = str;
        this.mAdVideoView.setVideoUrl(str);
        play();
    }

    public void showControls() {
        Log.d(TAG, "showControls");
        LPVideoControllerView lPVideoControllerView = this.videoControlsView;
        if (lPVideoControllerView != null) {
            lPVideoControllerView.setVisibility(0);
        }
        this.mHandler.removeMessages(10);
        this.mHandler.sendEmptyMessageDelayed(10, 10000L);
    }

    public void stop() {
        Log.d(TAG, IntentConfig.STOP);
        if (this.mAdVideoView != null) {
            this.mActivity.getWindow().clearFlags(128);
            this.mAdVideoView.stopAndRelease();
            stopCounter();
            updateControls(true);
        }
    }

    @Override // com.baidu.mobads.container.video.ILpVideoLayout
    public void stopAndRelease() {
        stop();
    }

    public void updateControls(boolean z) {
        this.videoControlsView.updateImagePauseOrPlay(z);
    }
}
