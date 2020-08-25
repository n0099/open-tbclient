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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.c;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public class MediaController extends RelativeLayout {
    private com.baidu.swan.videoplayer.a.a dLj;
    private SeekBar dMA;
    private TextView dMB;
    private long dMC;
    private Timer dMD;
    private Timer dME;
    private SwanVideoView dMF;
    boolean dMG;
    private boolean dMH;
    private ImageButton dMw;
    private View dMx;
    private View dMy;
    private TextView dMz;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dMH = false;
        aXq();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dMH = false;
        aXq();
    }

    private void aXq() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0528c.media_controller, this);
        this.dMw = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.dMw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dMF != null) {
                    if (MediaController.this.dMF.isPlaying()) {
                        MediaController.this.dMw.setBackgroundResource(c.a.btn_play);
                        MediaController.this.dMF.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dMw.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.dMF.start();
                }
            }
        });
        this.dMz = (TextView) inflate.findViewById(c.b.tv_position);
        this.dMA = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.dMB = (TextView) inflate.findViewById(c.b.tv_duration);
        this.dMA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.ms(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dMG = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dMF.getDuration() > 0) {
                    MediaController.this.dMC = seekBar.getProgress();
                    if (MediaController.this.dMF != null) {
                        MediaController.this.dMF.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dMG = false;
            }
        });
        this.dMy = inflate.findViewById(c.b.btn_mute);
        this.dMy.setBackgroundResource(this.dMF != null && this.dMF.isMute() ? c.a.mute_on : c.a.mute_off);
        this.dMy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dMF != null) {
                    MediaController.this.dMF.setMuted(!MediaController.this.dMF.isMute());
                }
            }
        });
        this.dMx = inflate.findViewById(c.b.btn_toggle_screen);
        this.dMx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean dMJ;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dMJ = !this.dMJ;
                if (MediaController.this.dLj != null) {
                    MediaController.this.dLj.hl(this.dMJ);
                }
            }
        });
        this.dMA.setEnabled(false);
        this.dMw.setEnabled(false);
    }

    public void hq(boolean z) {
        this.dMx.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aXr() {
        int currentPlayerState = this.dMF.getCurrentPlayerState();
        this.dMH = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aXt();
                this.dMw.setEnabled(true);
                this.dMw.setBackgroundResource(c.a.btn_play);
                this.dMA.setEnabled(false);
                ms(this.dMF == null ? 0 : this.dMF.getCurrentPosition());
                mr(this.dMF != null ? this.dMF.getDuration() : 0);
                return;
            case 1:
                this.dMw.setEnabled(false);
                this.dMA.setEnabled(false);
                return;
            case 2:
                this.dMw.setEnabled(true);
                this.dMw.setBackgroundResource(c.a.btn_play);
                this.dMA.setEnabled(true);
                mr(this.dMF == null ? 0 : this.dMF.getDuration());
                this.dMA.setMax(this.dMF != null ? this.dMF.getDuration() : 0);
                return;
            case 3:
                aXs();
                this.dMA.setEnabled(true);
                this.dMw.setEnabled(true);
                this.dMw.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.dMw.setEnabled(true);
                this.dMw.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                aXt();
                this.dMA.setProgress(this.dMA.getMax());
                this.dMA.setEnabled(false);
                this.dMw.setEnabled(true);
                this.dMw.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void aXs() {
        if (this.dMD != null) {
            this.dMD.cancel();
            this.dMD = null;
        }
        this.dMD = new Timer();
        this.dMD.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.dMF != null && MediaController.this.dMF.getVideoPlayerCallback() != null) {
                            MediaController.this.dMF.getVideoPlayerCallback().h(MediaController.this.dMF);
                        }
                        MediaController.this.aXv();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void aXt() {
        if (this.dMD != null) {
            this.dMD.cancel();
            this.dMD = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.dMF = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.dLj = aVar;
    }

    private void show() {
        if (this.dMF != null) {
            setProgress((int) this.dMC);
            setVisibility(0);
        }
    }

    public void aXu() {
        show();
        if (this.dME != null) {
            this.dME.cancel();
            this.dME = null;
        }
        this.dME = new Timer();
        this.dME.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.hide();
                    }
                });
            }
        }, IMConnection.RETRY_DELAY_TIMES);
    }

    public void hide() {
        setVisibility(8);
    }

    private void mr(int i) {
        if (this.dMB != null) {
            this.dMB.setText(mt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (this.dMz != null) {
            this.dMz.setText(mt(i));
        }
    }

    public static String mt(int i) {
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
        if (!this.dMH) {
            if (this.dMA != null) {
                this.dMA.setMax(i);
            }
            mr(i);
            if (i > 0) {
                this.dMH = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dMA != null) {
            this.dMA.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dMy != null) {
            this.dMy.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void aXv() {
        int duration;
        if (this.dMF != null && !this.dMG) {
            long currentPosition = this.dMF.getCurrentPosition();
            if (currentPosition > 0) {
                this.dMC = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dMF.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void mu(int i) {
        if (this.dMA != null && i != this.dMA.getSecondaryProgress()) {
            this.dMA.setSecondaryProgress(i);
        }
    }
}
