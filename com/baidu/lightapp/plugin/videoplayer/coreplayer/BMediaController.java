package com.baidu.lightapp.plugin.videoplayer.coreplayer;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.media.AudioManager;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.LivePlayerControl;
/* loaded from: classes.dex */
public class BMediaController extends RelativeLayout implements View.OnClickListener {
    private static final String TAG = "VideoViewController";
    private View.OnClickListener backListener;
    private Context context;
    private LinearLayout controllerBar;
    private TextView durationView;
    private ImageButton lastButton;
    private AudioManager mAudioManager;
    private LivePlayerControl.PLAYER_STATUS mPlayerStatus;
    private VideoViewControl mVVCtl;
    private StateListDrawable pauseDrawable;
    private String pkgName;
    private ImageButton playButton;
    private StateListDrawable playDrawable;
    private TextView positionView;
    private ImageButton preButton;
    private View.OnClickListener preListener;
    private boolean progresssEnable;
    private ResourceUtil resourceUtil;
    private SeekBar seekBar;

    /* loaded from: classes.dex */
    public interface RTMPConnControl {
        void setOption(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface VideoViewControl {
        void close();

        void exit();

        int getCurrentPosition();

        int getDuration();

        int getSignalStrength();

        boolean isPlaying();

        void pause();

        void play();

        void seekTo(double d);

        void setVideoPath(String str);

        void start();
    }

    public BMediaController(Context context) {
        super(context);
        this.mPlayerStatus = LivePlayerControl.PLAYER_STATUS.PLAYER_IDLE;
        this.mAudioManager = null;
        this.mVVCtl = null;
        this.progresssEnable = true;
        this.context = context;
        this.pkgName = context.getPackageName();
        initUI();
        UpdateUI(this.mPlayerStatus);
    }

    public BMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPlayerStatus = LivePlayerControl.PLAYER_STATUS.PLAYER_IDLE;
        this.mAudioManager = null;
        this.mVVCtl = null;
        this.progresssEnable = true;
        this.context = context;
        this.pkgName = context.getPackageName();
        initUI();
        UpdateUI(this.mPlayerStatus);
    }

    public BMediaController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPlayerStatus = LivePlayerControl.PLAYER_STATUS.PLAYER_IDLE;
        this.mAudioManager = null;
        this.mVVCtl = null;
        this.progresssEnable = true;
        this.context = context;
        this.pkgName = context.getPackageName();
        initUI();
        UpdateUI(this.mPlayerStatus);
    }

    public BMediaController(Context context, AttributeSet attributeSet, int i, String str) {
        super(context, attributeSet, i);
        this.mPlayerStatus = LivePlayerControl.PLAYER_STATUS.PLAYER_IDLE;
        this.mAudioManager = null;
        this.mVVCtl = null;
        this.progresssEnable = true;
        this.context = context;
        this.pkgName = str;
        initUI();
        UpdateUI(this.mPlayerStatus);
    }

    public BMediaController(Context context, AttributeSet attributeSet, String str) {
        super(context, attributeSet);
        this.mPlayerStatus = LivePlayerControl.PLAYER_STATUS.PLAYER_IDLE;
        this.mAudioManager = null;
        this.mVVCtl = null;
        this.progresssEnable = true;
        this.context = context;
        this.pkgName = str;
        initUI();
        UpdateUI(this.mPlayerStatus);
    }

    public BMediaController(Context context, String str) {
        super(context);
        this.mPlayerStatus = LivePlayerControl.PLAYER_STATUS.PLAYER_IDLE;
        this.mAudioManager = null;
        this.mVVCtl = null;
        this.progresssEnable = true;
        this.context = context;
        this.pkgName = str;
        initUI();
        UpdateUI(this.mPlayerStatus);
    }

    private void createController() {
    }

    private String formatSecond(int i) {
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        return i2 != 0 ? String.format("%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private void initUI() {
        try {
            Resources resourcesForApplication = this.context.getPackageManager().getResourcesForApplication(this.pkgName);
            this.resourceUtil = new ResourceUtil(this.pkgName, resourcesForApplication, this.context);
            this.playDrawable = this.resourceUtil.getPlayButtonStyle();
            this.pauseDrawable = this.resourceUtil.getPauseButtonSytle();
            this.controllerBar = new LinearLayout(this.context);
            this.controllerBar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            this.controllerBar.setGravity(16);
            this.controllerBar.setBackgroundColor(Color.rgb(96, 96, 96));
            this.controllerBar.setOrientation(1);
            addView(this.controllerBar);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout linearLayout = new LinearLayout(this.context);
            layoutParams.setMargins(0, 10, 0, 5);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            this.positionView = new TextView(this.context);
            this.positionView.setLayoutParams(layoutParams2);
            this.positionView.setGravity(17);
            this.positionView.setPadding(4, 4, 4, 4);
            this.positionView.setText("00:00:00");
            this.positionView.setTextSize(14.0f);
            this.positionView.setTextColor(-1);
            this.durationView = new TextView(this.context);
            this.durationView.setLayoutParams(layoutParams2);
            this.durationView.setGravity(17);
            this.durationView.setPadding(4, 4, 4, 4);
            this.durationView.setText("00:00:00");
            this.durationView.setTextSize(14.0f);
            this.durationView.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            this.seekBar = new SeekBar(this.context);
            layoutParams3.weight = 1.0f;
            layoutParams3.leftMargin = 15;
            layoutParams3.rightMargin = 15;
            this.seekBar.setLayoutParams(layoutParams3);
            this.seekBar.setMinimumHeight(5);
            this.seekBar.setProgressDrawable(this.resourceUtil.getProgressLayer(this.seekBar));
            this.seekBar.setThumb(resourcesForApplication.getDrawable(this.resourceUtil.getDrawableId("cyberplayer_seekbar_ratio")));
            this.seekBar.setThumbOffset(0);
            linearLayout.addView(this.positionView);
            linearLayout.addView(this.seekBar);
            linearLayout.addView(this.durationView);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.setMargins(0, 0, 0, 5);
            LinearLayout linearLayout2 = new LinearLayout(this.context);
            linearLayout2.setLayoutParams(layoutParams4);
            linearLayout2.setGravity(17);
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(50, -2);
            layoutParams5.weight = 5.0f;
            layoutParams5.leftMargin = 25;
            layoutParams5.rightMargin = 25;
            this.lastButton = new ImageButton(this.context);
            this.lastButton.setLayoutParams(layoutParams5);
            this.lastButton.setBackgroundColor(Color.argb(0, 0, (int) MotionEventCompat.ACTION_MASK, 0));
            this.lastButton.setImageDrawable(this.resourceUtil.getLastButtonStyle());
            this.lastButton.setVisibility(4);
            this.preButton = new ImageButton(this.context);
            this.preButton.setLayoutParams(layoutParams5);
            this.preButton.setBackgroundColor(Color.argb(0, 0, (int) MotionEventCompat.ACTION_MASK, 0));
            this.preButton.setImageDrawable(this.resourceUtil.getPreButtonStyle());
            this.preButton.setVisibility(4);
            this.playButton = new ImageButton(this.context);
            this.playButton.setLayoutParams(layoutParams5);
            this.playButton.setBackgroundColor(Color.argb(0, 0, (int) MotionEventCompat.ACTION_MASK, 0));
            this.playButton.setImageDrawable(this.pauseDrawable);
            linearLayout2.addView(this.preButton);
            linearLayout2.addView(this.playButton);
            linearLayout2.addView(this.lastButton);
            this.controllerBar.addView(linearLayout2);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams6.setMargins(0, 10, 0, 5);
            this.controllerBar.addView(linearLayout, layoutParams6);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.preButton.setOnClickListener(this);
        this.lastButton.setOnClickListener(this);
        this.playButton.setOnClickListener(this);
        this.controllerBar.getBackground().setAlpha(90);
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.lightapp.plugin.videoplayer.coreplayer.BMediaController.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                BMediaController.this.updatePostion(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (BMediaController.this.mVVCtl == null || !BMediaController.this.progresssEnable) {
                    return;
                }
                BMediaController.this.mVVCtl.seekTo(seekBar.getProgress());
            }
        });
        enableControllerBar(true);
    }

    private void tooglePause() {
        if (this.mVVCtl == null) {
            Log.w(TAG, "videoview is null");
            return;
        }
        Log.e(TAG, "player init " + this.mPlayerStatus);
        if (this.mPlayerStatus == LivePlayerControl.PLAYER_STATUS.PLAYER_INIT) {
            this.mVVCtl.start();
        } else if (this.mVVCtl.isPlaying()) {
            this.mVVCtl.pause();
            if (this.playDrawable != null) {
                this.playButton.setImageDrawable(this.playDrawable);
            }
        } else {
            this.mVVCtl.play();
            if (this.playDrawable != null) {
                this.playButton.setImageDrawable(this.pauseDrawable);
            }
        }
    }

    private void updateDuration(int i) {
        if (this.durationView != null) {
            this.durationView.setText(formatSecond(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePostion(int i) {
        if (this.positionView != null) {
            this.positionView.setText(formatSecond(i));
        }
    }

    public void UpdateUI(LivePlayerControl.PLAYER_STATUS player_status) {
        this.mPlayerStatus = player_status;
        if (this.mPlayerStatus == LivePlayerControl.PLAYER_STATUS.PLAYER_IDLE || this.mPlayerStatus == LivePlayerControl.PLAYER_STATUS.PLAYER_STOPPED) {
            this.playButton.setEnabled(true);
            this.playButton.setImageDrawable(this.playDrawable);
            if (this.progresssEnable) {
                this.seekBar.setEnabled(true);
            }
        } else if (this.mPlayerStatus == LivePlayerControl.PLAYER_STATUS.PLAYER_INIT) {
            this.playButton.setEnabled(false);
            this.playButton.setImageDrawable(this.pauseDrawable);
            this.seekBar.setEnabled(false);
        } else if (this.mPlayerStatus == LivePlayerControl.PLAYER_STATUS.PLAYER_PREPARED || this.mPlayerStatus == LivePlayerControl.PLAYER_STATUS.PLAYER_PLAYING) {
            this.playButton.setEnabled(true);
            this.playButton.setImageDrawable(this.pauseDrawable);
            if (this.progresssEnable) {
                this.seekBar.setEnabled(true);
            }
        }
    }

    public void enableControllerBar(boolean z) {
        this.playButton.setEnabled(z);
        if (this.progresssEnable && z) {
            this.seekBar.setEnabled(true);
        } else {
            this.seekBar.setEnabled(false);
        }
    }

    public void enableProgress(boolean z) {
        this.progresssEnable = z;
        this.seekBar.setEnabled(z);
    }

    @Override // android.view.View
    public int getVisibility() {
        return this.controllerBar.getVisibility();
    }

    public boolean hasVideoView() {
        return this.mVVCtl != null;
    }

    public void hide() {
        if (this.controllerBar.getVisibility() == 0) {
            this.controllerBar.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
        if (view == this.playButton) {
            tooglePause();
        } else if (view == this.lastButton) {
            if (this.backListener != null) {
                this.backListener.onClick(view);
            }
        } else if (view != this.preButton || this.preListener == null) {
        } else {
            this.preListener.onClick(view);
        }
    }

    public void setCache(int i) {
        if (this.seekBar == null || i == this.seekBar.getSecondaryProgress()) {
            return;
        }
        this.seekBar.setSecondaryProgress(i);
    }

    public void setMax(int i) {
        if (this.seekBar != null) {
            this.seekBar.setMax(i);
        }
        updateDuration(i);
    }

    public void setMediaPlayerControl(VideoViewControl videoViewControl) {
        this.mVVCtl = videoViewControl;
    }

    public void setPreNextListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.preListener = onClickListener;
        this.backListener = onClickListener2;
        if (onClickListener != null) {
            this.preButton.setVisibility(0);
        } else {
            this.preButton.setVisibility(4);
        }
        if (onClickListener2 != null) {
            this.lastButton.setVisibility(0);
        } else {
            this.lastButton.setVisibility(4);
        }
    }

    public void setProgress(int i) {
        if (this.seekBar == null || i == this.seekBar.getProgress()) {
            return;
        }
        if (this.progresssEnable) {
            this.seekBar.setProgress(i);
        } else {
            updatePostion(i);
        }
    }

    public void show() {
        if (this.mVVCtl == null || this.controllerBar.getVisibility() == 0) {
            return;
        }
        this.controllerBar.setVisibility(0);
    }
}
