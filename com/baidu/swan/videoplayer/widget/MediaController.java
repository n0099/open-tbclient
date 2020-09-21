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
/* loaded from: classes25.dex */
public class MediaController extends RelativeLayout {
    private com.baidu.swan.videoplayer.a.a dNq;
    private ImageButton dOD;
    private View dOE;
    private View dOF;
    private TextView dOG;
    private SeekBar dOH;
    private TextView dOI;
    private long dOJ;
    private Timer dOK;
    private Timer dOL;
    private SwanVideoView dOM;
    boolean dON;
    private boolean dOO;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dOO = false;
        aYc();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dOO = false;
        aYc();
    }

    private void aYc() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0523c.media_controller, this);
        this.dOD = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.dOD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dOM != null) {
                    if (MediaController.this.dOM.isPlaying()) {
                        MediaController.this.dOD.setBackgroundResource(c.a.btn_play);
                        MediaController.this.dOM.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dOD.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.dOM.start();
                }
            }
        });
        this.dOG = (TextView) inflate.findViewById(c.b.tv_position);
        this.dOH = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.dOI = (TextView) inflate.findViewById(c.b.tv_duration);
        this.dOH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mD(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dON = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dOM.getDuration() > 0) {
                    MediaController.this.dOJ = seekBar.getProgress();
                    if (MediaController.this.dOM != null) {
                        MediaController.this.dOM.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dON = false;
            }
        });
        this.dOF = inflate.findViewById(c.b.btn_mute);
        this.dOF.setBackgroundResource(this.dOM != null && this.dOM.isMute() ? c.a.mute_on : c.a.mute_off);
        this.dOF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dOM != null) {
                    MediaController.this.dOM.setMuted(!MediaController.this.dOM.isMute());
                }
            }
        });
        this.dOE = inflate.findViewById(c.b.btn_toggle_screen);
        this.dOE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean dOQ;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dOQ = !this.dOQ;
                if (MediaController.this.dNq != null) {
                    MediaController.this.dNq.hk(this.dOQ);
                }
            }
        });
        this.dOH.setEnabled(false);
        this.dOD.setEnabled(false);
    }

    public void hp(boolean z) {
        this.dOE.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aYd() {
        int currentPlayerState = this.dOM.getCurrentPlayerState();
        this.dOO = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aYf();
                this.dOD.setEnabled(true);
                this.dOD.setBackgroundResource(c.a.btn_play);
                this.dOH.setEnabled(false);
                mD(this.dOM == null ? 0 : this.dOM.getCurrentPosition());
                mC(this.dOM != null ? this.dOM.getDuration() : 0);
                return;
            case 1:
                this.dOD.setEnabled(false);
                this.dOH.setEnabled(false);
                return;
            case 2:
                this.dOD.setEnabled(true);
                this.dOD.setBackgroundResource(c.a.btn_play);
                this.dOH.setEnabled(true);
                mC(this.dOM == null ? 0 : this.dOM.getDuration());
                this.dOH.setMax(this.dOM != null ? this.dOM.getDuration() : 0);
                return;
            case 3:
                aYe();
                this.dOH.setEnabled(true);
                this.dOD.setEnabled(true);
                this.dOD.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.dOD.setEnabled(true);
                this.dOD.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                aYf();
                this.dOH.setProgress(this.dOH.getMax());
                this.dOH.setEnabled(false);
                this.dOD.setEnabled(true);
                this.dOD.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void aYe() {
        if (this.dOK != null) {
            this.dOK.cancel();
            this.dOK = null;
        }
        this.dOK = new Timer();
        this.dOK.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.dOM != null && MediaController.this.dOM.getVideoPlayerCallback() != null) {
                            MediaController.this.dOM.getVideoPlayerCallback().h(MediaController.this.dOM);
                        }
                        MediaController.this.aYh();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void aYf() {
        if (this.dOK != null) {
            this.dOK.cancel();
            this.dOK = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.dOM = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.dNq = aVar;
    }

    private void show() {
        if (this.dOM != null) {
            setProgress((int) this.dOJ);
            setVisibility(0);
        }
    }

    public void aYg() {
        show();
        if (this.dOL != null) {
            this.dOL.cancel();
            this.dOL = null;
        }
        this.dOL = new Timer();
        this.dOL.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void mC(int i) {
        if (this.dOI != null) {
            this.dOI.setText(mE(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(int i) {
        if (this.dOG != null) {
            this.dOG.setText(mE(i));
        }
    }

    public static String mE(int i) {
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
        if (!this.dOO) {
            if (this.dOH != null) {
                this.dOH.setMax(i);
            }
            mC(i);
            if (i > 0) {
                this.dOO = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dOH != null) {
            this.dOH.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dOF != null) {
            this.dOF.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void aYh() {
        int duration;
        if (this.dOM != null && !this.dON) {
            long currentPosition = this.dOM.getCurrentPosition();
            if (currentPosition > 0) {
                this.dOJ = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dOM.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void mF(int i) {
        if (this.dOH != null && i != this.dOH.getSecondaryProgress()) {
            this.dOH.setSecondaryProgress(i);
        }
    }
}
