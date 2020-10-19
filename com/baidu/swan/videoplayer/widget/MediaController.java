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
/* loaded from: classes12.dex */
public class MediaController extends RelativeLayout {
    private com.baidu.swan.videoplayer.a.a dZr;
    private ImageButton eaE;
    private View eaF;
    private View eaG;
    private TextView eaH;
    private SeekBar eaI;
    private TextView eaJ;
    private long eaK;
    private Timer eaL;
    private Timer eaM;
    private SwanVideoView eaN;
    boolean eaO;
    private boolean eaP;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.eaP = false;
        baK();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eaP = false;
        baK();
    }

    private void baK() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0540c.media_controller, this);
        this.eaE = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.eaE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eaN != null) {
                    if (MediaController.this.eaN.isPlaying()) {
                        MediaController.this.eaE.setBackgroundResource(c.a.btn_play);
                        MediaController.this.eaN.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.eaE.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.eaN.start();
                }
            }
        });
        this.eaH = (TextView) inflate.findViewById(c.b.tv_position);
        this.eaI = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.eaJ = (TextView) inflate.findViewById(c.b.tv_duration);
        this.eaI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.na(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.eaO = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.eaN.getDuration() > 0) {
                    MediaController.this.eaK = seekBar.getProgress();
                    if (MediaController.this.eaN != null) {
                        MediaController.this.eaN.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.eaO = false;
            }
        });
        this.eaG = inflate.findViewById(c.b.btn_mute);
        this.eaG.setBackgroundResource(this.eaN != null && this.eaN.isMute() ? c.a.mute_on : c.a.mute_off);
        this.eaG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eaN != null) {
                    MediaController.this.eaN.setMuted(!MediaController.this.eaN.isMute());
                }
            }
        });
        this.eaF = inflate.findViewById(c.b.btn_toggle_screen);
        this.eaF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean eaR;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.eaR = !this.eaR;
                if (MediaController.this.dZr != null) {
                    MediaController.this.dZr.hG(this.eaR);
                }
            }
        });
        this.eaI.setEnabled(false);
        this.eaE.setEnabled(false);
    }

    public void hK(boolean z) {
        this.eaF.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void baL() {
        int currentPlayerState = this.eaN.getCurrentPlayerState();
        this.eaP = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                baN();
                this.eaE.setEnabled(true);
                this.eaE.setBackgroundResource(c.a.btn_play);
                this.eaI.setEnabled(false);
                na(this.eaN == null ? 0 : this.eaN.getCurrentPosition());
                mZ(this.eaN != null ? this.eaN.getDuration() : 0);
                return;
            case 1:
                this.eaE.setEnabled(false);
                this.eaI.setEnabled(false);
                return;
            case 2:
                this.eaE.setEnabled(true);
                this.eaE.setBackgroundResource(c.a.btn_play);
                this.eaI.setEnabled(true);
                mZ(this.eaN == null ? 0 : this.eaN.getDuration());
                this.eaI.setMax(this.eaN != null ? this.eaN.getDuration() : 0);
                return;
            case 3:
                baM();
                this.eaI.setEnabled(true);
                this.eaE.setEnabled(true);
                this.eaE.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.eaE.setEnabled(true);
                this.eaE.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                baN();
                this.eaI.setProgress(this.eaI.getMax());
                this.eaI.setEnabled(false);
                this.eaE.setEnabled(true);
                this.eaE.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void baM() {
        if (this.eaL != null) {
            this.eaL.cancel();
            this.eaL = null;
        }
        this.eaL = new Timer();
        this.eaL.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.eaN != null && MediaController.this.eaN.getVideoPlayerCallback() != null) {
                            MediaController.this.eaN.getVideoPlayerCallback().h(MediaController.this.eaN);
                        }
                        MediaController.this.baP();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void baN() {
        if (this.eaL != null) {
            this.eaL.cancel();
            this.eaL = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.eaN = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.dZr = aVar;
    }

    private void show() {
        if (this.eaN != null) {
            setProgress((int) this.eaK);
            setVisibility(0);
        }
    }

    public void baO() {
        show();
        if (this.eaM != null) {
            this.eaM.cancel();
            this.eaM = null;
        }
        this.eaM = new Timer();
        this.eaM.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void mZ(int i) {
        if (this.eaJ != null) {
            this.eaJ.setText(nb(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(int i) {
        if (this.eaH != null) {
            this.eaH.setText(nb(i));
        }
    }

    public static String nb(int i) {
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
        if (!this.eaP) {
            if (this.eaI != null) {
                this.eaI.setMax(i);
            }
            mZ(i);
            if (i > 0) {
                this.eaP = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.eaI != null) {
            this.eaI.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eaG != null) {
            this.eaG.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void baP() {
        int duration;
        if (this.eaN != null && !this.eaO) {
            long currentPosition = this.eaN.getCurrentPosition();
            if (currentPosition > 0) {
                this.eaK = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.eaN.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void nc(int i) {
        if (this.eaI != null && i != this.eaI.getSecondaryProgress()) {
            this.eaI.setSecondaryProgress(i);
        }
    }
}
