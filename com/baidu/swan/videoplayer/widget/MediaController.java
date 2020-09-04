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
    private com.baidu.swan.videoplayer.a.a dLn;
    private ImageButton dMA;
    private View dMB;
    private View dMC;
    private TextView dMD;
    private SeekBar dME;
    private TextView dMF;
    private long dMG;
    private Timer dMH;
    private Timer dMI;
    private SwanVideoView dMJ;
    boolean dMK;
    private boolean dML;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dML = false;
        aXq();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dML = false;
        aXq();
    }

    private void aXq() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0528c.media_controller, this);
        this.dMA = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.dMA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dMJ != null) {
                    if (MediaController.this.dMJ.isPlaying()) {
                        MediaController.this.dMA.setBackgroundResource(c.a.btn_play);
                        MediaController.this.dMJ.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dMA.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.dMJ.start();
                }
            }
        });
        this.dMD = (TextView) inflate.findViewById(c.b.tv_position);
        this.dME = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.dMF = (TextView) inflate.findViewById(c.b.tv_duration);
        this.dME.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.ms(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dMK = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dMJ.getDuration() > 0) {
                    MediaController.this.dMG = seekBar.getProgress();
                    if (MediaController.this.dMJ != null) {
                        MediaController.this.dMJ.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dMK = false;
            }
        });
        this.dMC = inflate.findViewById(c.b.btn_mute);
        this.dMC.setBackgroundResource(this.dMJ != null && this.dMJ.isMute() ? c.a.mute_on : c.a.mute_off);
        this.dMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dMJ != null) {
                    MediaController.this.dMJ.setMuted(!MediaController.this.dMJ.isMute());
                }
            }
        });
        this.dMB = inflate.findViewById(c.b.btn_toggle_screen);
        this.dMB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean dMN;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dMN = !this.dMN;
                if (MediaController.this.dLn != null) {
                    MediaController.this.dLn.hm(this.dMN);
                }
            }
        });
        this.dME.setEnabled(false);
        this.dMA.setEnabled(false);
    }

    public void hr(boolean z) {
        this.dMB.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aXr() {
        int currentPlayerState = this.dMJ.getCurrentPlayerState();
        this.dML = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aXt();
                this.dMA.setEnabled(true);
                this.dMA.setBackgroundResource(c.a.btn_play);
                this.dME.setEnabled(false);
                ms(this.dMJ == null ? 0 : this.dMJ.getCurrentPosition());
                mr(this.dMJ != null ? this.dMJ.getDuration() : 0);
                return;
            case 1:
                this.dMA.setEnabled(false);
                this.dME.setEnabled(false);
                return;
            case 2:
                this.dMA.setEnabled(true);
                this.dMA.setBackgroundResource(c.a.btn_play);
                this.dME.setEnabled(true);
                mr(this.dMJ == null ? 0 : this.dMJ.getDuration());
                this.dME.setMax(this.dMJ != null ? this.dMJ.getDuration() : 0);
                return;
            case 3:
                aXs();
                this.dME.setEnabled(true);
                this.dMA.setEnabled(true);
                this.dMA.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.dMA.setEnabled(true);
                this.dMA.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                aXt();
                this.dME.setProgress(this.dME.getMax());
                this.dME.setEnabled(false);
                this.dMA.setEnabled(true);
                this.dMA.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void aXs() {
        if (this.dMH != null) {
            this.dMH.cancel();
            this.dMH = null;
        }
        this.dMH = new Timer();
        this.dMH.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.dMJ != null && MediaController.this.dMJ.getVideoPlayerCallback() != null) {
                            MediaController.this.dMJ.getVideoPlayerCallback().h(MediaController.this.dMJ);
                        }
                        MediaController.this.aXv();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void aXt() {
        if (this.dMH != null) {
            this.dMH.cancel();
            this.dMH = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.dMJ = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.dLn = aVar;
    }

    private void show() {
        if (this.dMJ != null) {
            setProgress((int) this.dMG);
            setVisibility(0);
        }
    }

    public void aXu() {
        show();
        if (this.dMI != null) {
            this.dMI.cancel();
            this.dMI = null;
        }
        this.dMI = new Timer();
        this.dMI.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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
        if (this.dMF != null) {
            this.dMF.setText(mt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (this.dMD != null) {
            this.dMD.setText(mt(i));
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
        if (!this.dML) {
            if (this.dME != null) {
                this.dME.setMax(i);
            }
            mr(i);
            if (i > 0) {
                this.dML = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dME != null) {
            this.dME.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dMC != null) {
            this.dMC.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void aXv() {
        int duration;
        if (this.dMJ != null && !this.dMK) {
            long currentPosition = this.dMJ.getCurrentPosition();
            if (currentPosition > 0) {
                this.dMG = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dMJ.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void mu(int i) {
        if (this.dME != null && i != this.dME.getSecondaryProgress()) {
            this.dME.setSecondaryProgress(i);
        }
    }
}
