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
import com.baidu.swan.videoplayer.a.a;
import com.baidu.swan.videoplayer.c;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class MediaController extends RelativeLayout {
    private a drv;
    private ImageButton dsL;
    private View dsM;
    private View dsN;
    private TextView dsO;
    private SeekBar dsP;
    private TextView dsQ;
    private long dsR;
    private Timer dsS;
    private Timer dsT;
    private SwanVideoView dsU;
    boolean dsV;
    private boolean dsW;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dsW = false;
        aJY();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsW = false;
        aJY();
    }

    private void aJY() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0464c.media_controller, this);
        this.dsL = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.dsL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dsU != null) {
                    if (MediaController.this.dsU.isPlaying()) {
                        MediaController.this.dsL.setBackgroundResource(c.a.btn_play);
                        MediaController.this.dsU.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dsL.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.dsU.start();
                }
            }
        });
        this.dsO = (TextView) inflate.findViewById(c.b.tv_position);
        this.dsP = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.dsQ = (TextView) inflate.findViewById(c.b.tv_duration);
        this.dsP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.jI(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dsV = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dsU.getDuration() > 0) {
                    MediaController.this.dsR = seekBar.getProgress();
                    if (MediaController.this.dsU != null) {
                        MediaController.this.dsU.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dsV = false;
            }
        });
        this.dsN = inflate.findViewById(c.b.btn_mute);
        this.dsN.setBackgroundResource(this.dsU != null && this.dsU.isMute() ? c.a.mute_on : c.a.mute_off);
        this.dsN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dsU != null) {
                    MediaController.this.dsU.setMuted(!MediaController.this.dsU.isMute());
                }
            }
        });
        this.dsM = inflate.findViewById(c.b.btn_toggle_screen);
        this.dsM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean dsY;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dsY = !this.dsY;
                if (MediaController.this.drv != null) {
                    MediaController.this.drv.gr(this.dsY);
                }
            }
        });
        this.dsP.setEnabled(false);
        this.dsL.setEnabled(false);
    }

    public void gw(boolean z) {
        this.dsM.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aJZ() {
        int currentPlayerState = this.dsU.getCurrentPlayerState();
        this.dsW = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aKb();
                this.dsL.setEnabled(true);
                this.dsL.setBackgroundResource(c.a.btn_play);
                this.dsP.setEnabled(false);
                jI(this.dsU == null ? 0 : this.dsU.getCurrentPosition());
                jH(this.dsU != null ? this.dsU.getDuration() : 0);
                return;
            case 1:
                this.dsL.setEnabled(false);
                this.dsP.setEnabled(false);
                return;
            case 2:
                this.dsL.setEnabled(true);
                this.dsL.setBackgroundResource(c.a.btn_play);
                this.dsP.setEnabled(true);
                jH(this.dsU == null ? 0 : this.dsU.getDuration());
                this.dsP.setMax(this.dsU != null ? this.dsU.getDuration() : 0);
                return;
            case 3:
                aKa();
                this.dsP.setEnabled(true);
                this.dsL.setEnabled(true);
                this.dsL.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.dsL.setEnabled(true);
                this.dsL.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                aKb();
                this.dsP.setProgress(this.dsP.getMax());
                this.dsP.setEnabled(false);
                this.dsL.setEnabled(true);
                this.dsL.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void aKa() {
        if (this.dsS != null) {
            this.dsS.cancel();
            this.dsS = null;
        }
        this.dsS = new Timer();
        this.dsS.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.dsU != null && MediaController.this.dsU.getVideoPlayerCallback() != null) {
                            MediaController.this.dsU.getVideoPlayerCallback().h(MediaController.this.dsU);
                        }
                        MediaController.this.aKd();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void aKb() {
        if (this.dsS != null) {
            this.dsS.cancel();
            this.dsS = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.dsU = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.drv = aVar;
    }

    private void show() {
        if (this.dsU != null) {
            setProgress((int) this.dsR);
            setVisibility(0);
        }
    }

    public void aKc() {
        show();
        if (this.dsT != null) {
            this.dsT.cancel();
            this.dsT = null;
        }
        this.dsT = new Timer();
        this.dsT.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void jH(int i) {
        if (this.dsQ != null) {
            this.dsQ.setText(jJ(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(int i) {
        if (this.dsO != null) {
            this.dsO.setText(jJ(i));
        }
    }

    public static String jJ(int i) {
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
        if (!this.dsW) {
            if (this.dsP != null) {
                this.dsP.setMax(i);
            }
            jH(i);
            if (i > 0) {
                this.dsW = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dsP != null) {
            this.dsP.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dsN != null) {
            this.dsN.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void aKd() {
        int duration;
        if (this.dsU != null && !this.dsV) {
            long currentPosition = this.dsU.getCurrentPosition();
            if (currentPosition > 0) {
                this.dsR = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dsU.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void jK(int i) {
        if (this.dsP != null && i != this.dsP.getSecondaryProgress()) {
            this.dsP.setSecondaryProgress(i);
        }
    }
}
