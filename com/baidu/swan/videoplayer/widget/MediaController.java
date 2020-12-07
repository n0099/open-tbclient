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
/* loaded from: classes6.dex */
public class MediaController extends RelativeLayout {
    private com.baidu.swan.videoplayer.a.a esZ;
    private ImageButton eun;
    private View euo;
    private View eup;
    private TextView euq;
    private SeekBar eur;
    private TextView eus;
    private long eut;
    private Timer euu;
    private Timer euv;
    private SwanVideoView euw;
    boolean eux;
    private boolean euy;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.euy = false;
        bhB();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euy = false;
        bhB();
    }

    private void bhB() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0576c.media_controller, this);
        this.eun = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.eun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.euw != null) {
                    if (MediaController.this.euw.isPlaying()) {
                        MediaController.this.eun.setBackgroundResource(c.a.btn_play);
                        MediaController.this.euw.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.eun.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.euw.start();
                }
            }
        });
        this.euq = (TextView) inflate.findViewById(c.b.tv_position);
        this.eur = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.eus = (TextView) inflate.findViewById(c.b.tv_duration);
        this.eur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.nP(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.eux = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.euw.getDuration() > 0) {
                    MediaController.this.eut = seekBar.getProgress();
                    if (MediaController.this.euw != null) {
                        MediaController.this.euw.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.eux = false;
            }
        });
        this.eup = inflate.findViewById(c.b.btn_mute);
        this.eup.setBackgroundResource(this.euw != null && this.euw.isMute() ? c.a.mute_on : c.a.mute_off);
        this.eup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.euw != null) {
                    MediaController.this.euw.setMuted(!MediaController.this.euw.isMute());
                }
            }
        });
        this.euo = inflate.findViewById(c.b.btn_toggle_screen);
        this.euo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean bJG;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bJG = !this.bJG;
                if (MediaController.this.esZ != null) {
                    MediaController.this.esZ.iu(this.bJG);
                }
            }
        });
        this.eur.setEnabled(false);
        this.eun.setEnabled(false);
    }

    public void iy(boolean z) {
        this.euo.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void bhC() {
        int currentPlayerState = this.euw.getCurrentPlayerState();
        this.euy = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                bhE();
                this.eun.setEnabled(true);
                this.eun.setBackgroundResource(c.a.btn_play);
                this.eur.setEnabled(false);
                nP(this.euw == null ? 0 : this.euw.getCurrentPosition());
                nO(this.euw != null ? this.euw.getDuration() : 0);
                return;
            case 1:
                this.eun.setEnabled(false);
                this.eur.setEnabled(false);
                return;
            case 2:
                this.eun.setEnabled(true);
                this.eun.setBackgroundResource(c.a.btn_play);
                this.eur.setEnabled(true);
                nO(this.euw == null ? 0 : this.euw.getDuration());
                this.eur.setMax(this.euw != null ? this.euw.getDuration() : 0);
                return;
            case 3:
                bhD();
                this.eur.setEnabled(true);
                this.eun.setEnabled(true);
                this.eun.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.eun.setEnabled(true);
                this.eun.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                bhE();
                this.eur.setProgress(this.eur.getMax());
                this.eur.setEnabled(false);
                this.eun.setEnabled(true);
                this.eun.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void bhD() {
        if (this.euu != null) {
            this.euu.cancel();
            this.euu = null;
        }
        this.euu = new Timer();
        this.euu.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.euw != null && MediaController.this.euw.getVideoPlayerCallback() != null) {
                            MediaController.this.euw.getVideoPlayerCallback().h(MediaController.this.euw);
                        }
                        MediaController.this.bhG();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void bhE() {
        if (this.euu != null) {
            this.euu.cancel();
            this.euu = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.euw = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.esZ = aVar;
    }

    private void show() {
        if (this.euw != null) {
            setProgress((int) this.eut);
            setVisibility(0);
        }
    }

    public void bhF() {
        show();
        if (this.euv != null) {
            this.euv.cancel();
            this.euv = null;
        }
        this.euv = new Timer();
        this.euv.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void nO(int i) {
        if (this.eus != null) {
            this.eus.setText(nQ(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(int i) {
        if (this.euq != null) {
            this.euq.setText(nQ(i));
        }
    }

    public static String nQ(int i) {
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
        if (!this.euy) {
            if (this.eur != null) {
                this.eur.setMax(i);
            }
            nO(i);
            if (i > 0) {
                this.euy = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.eur != null) {
            this.eur.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eup != null) {
            this.eup.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void bhG() {
        int duration;
        if (this.euw != null && !this.eux) {
            long currentPosition = this.euw.getCurrentPosition();
            if (currentPosition > 0) {
                this.eut = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.euw.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void nR(int i) {
        if (this.eur != null && i != this.eur.getSecondaryProgress()) {
            this.eur.setSecondaryProgress(i);
        }
    }
}
