package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.c;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class MediaController extends RelativeLayout {
    private com.baidu.swan.videoplayer.a.a dBY;
    private ImageButton dDn;
    private View dDo;
    private View dDp;
    private TextView dDq;
    private SeekBar dDr;
    private TextView dDs;
    private long dDt;
    private Timer dDu;
    private Timer dDv;
    private SwanVideoView dDw;
    boolean dDx;
    private boolean dDy;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dDy = false;
        aOS();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDy = false;
        aOS();
    }

    private void aOS() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0482c.media_controller, this);
        this.dDn = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.dDn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dDw != null) {
                    if (MediaController.this.dDw.isPlaying()) {
                        MediaController.this.dDn.setBackgroundResource(c.a.btn_play);
                        MediaController.this.dDw.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dDn.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.dDw.start();
                }
            }
        });
        this.dDq = (TextView) inflate.findViewById(c.b.tv_position);
        this.dDr = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.dDs = (TextView) inflate.findViewById(c.b.tv_duration);
        this.dDr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.km(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dDx = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dDw.getDuration() > 0) {
                    MediaController.this.dDt = seekBar.getProgress();
                    if (MediaController.this.dDw != null) {
                        MediaController.this.dDw.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dDx = false;
            }
        });
        this.dDp = inflate.findViewById(c.b.btn_mute);
        this.dDp.setBackgroundResource(this.dDw != null && this.dDw.isMute() ? c.a.mute_on : c.a.mute_off);
        this.dDp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dDw != null) {
                    MediaController.this.dDw.setMuted(!MediaController.this.dDw.isMute());
                }
            }
        });
        this.dDo = inflate.findViewById(c.b.btn_toggle_screen);
        this.dDo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean dDA;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dDA = !this.dDA;
                if (MediaController.this.dBY != null) {
                    MediaController.this.dBY.gR(this.dDA);
                }
            }
        });
        this.dDr.setEnabled(false);
        this.dDn.setEnabled(false);
    }

    public void gW(boolean z) {
        this.dDo.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aOT() {
        int currentPlayerState = this.dDw.getCurrentPlayerState();
        this.dDy = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aOV();
                this.dDn.setEnabled(true);
                this.dDn.setBackgroundResource(c.a.btn_play);
                this.dDr.setEnabled(false);
                km(this.dDw == null ? 0 : this.dDw.getCurrentPosition());
                kl(this.dDw != null ? this.dDw.getDuration() : 0);
                return;
            case 1:
                this.dDn.setEnabled(false);
                this.dDr.setEnabled(false);
                return;
            case 2:
                this.dDn.setEnabled(true);
                this.dDn.setBackgroundResource(c.a.btn_play);
                this.dDr.setEnabled(true);
                kl(this.dDw == null ? 0 : this.dDw.getDuration());
                this.dDr.setMax(this.dDw != null ? this.dDw.getDuration() : 0);
                return;
            case 3:
                aOU();
                this.dDr.setEnabled(true);
                this.dDn.setEnabled(true);
                this.dDn.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.dDn.setEnabled(true);
                this.dDn.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                aOV();
                this.dDr.setProgress(this.dDr.getMax());
                this.dDr.setEnabled(false);
                this.dDn.setEnabled(true);
                this.dDn.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void aOU() {
        if (this.dDu != null) {
            this.dDu.cancel();
            this.dDu = null;
        }
        this.dDu = new Timer();
        this.dDu.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.dDw != null && MediaController.this.dDw.getVideoPlayerCallback() != null) {
                            MediaController.this.dDw.getVideoPlayerCallback().h(MediaController.this.dDw);
                        }
                        MediaController.this.aOX();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void aOV() {
        if (this.dDu != null) {
            this.dDu.cancel();
            this.dDu = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.dDw = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.dBY = aVar;
    }

    private void show() {
        if (this.dDw != null) {
            setProgress((int) this.dDt);
            setVisibility(0);
        }
    }

    public void aOW() {
        show();
        if (this.dDv != null) {
            this.dDv.cancel();
            this.dDv = null;
        }
        this.dDv = new Timer();
        this.dDv.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.hide();
                    }
                });
            }
        }, 3000L);
    }

    public void hide() {
        setVisibility(8);
    }

    private void kl(int i) {
        if (this.dDs != null) {
            this.dDs.setText(kn(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(int i) {
        if (this.dDq != null) {
            this.dDq.setText(kn(i));
        }
    }

    public static String kn(int i) {
        if (i < 0) {
            return "";
        }
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        int i4 = (i2 % 3600) / 60;
        int i5 = i2 % 60;
        return i3 != 0 ? String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private void setMax(int i) {
        if (!this.dDy) {
            if (this.dDr != null) {
                this.dDr.setMax(i);
            }
            kl(i);
            if (i > 0) {
                this.dDy = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dDr != null) {
            this.dDr.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dDp != null) {
            this.dDp.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void aOX() {
        int duration;
        if (this.dDw != null && !this.dDx) {
            long currentPosition = this.dDw.getCurrentPosition();
            if (currentPosition > 0) {
                this.dDt = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dDw.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void ko(int i) {
        if (this.dDr != null && i != this.dDr.getSecondaryProgress()) {
            this.dDr.setSecondaryProgress(i);
        }
    }
}
