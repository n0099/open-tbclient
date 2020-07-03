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
    private a dwg;
    private TextView dxA;
    private long dxB;
    private Timer dxC;
    private Timer dxD;
    private SwanVideoView dxE;
    boolean dxF;
    private boolean dxG;
    private ImageButton dxv;
    private View dxw;
    private View dxx;
    private TextView dxy;
    private SeekBar dxz;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dxG = false;
        aLe();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxG = false;
        aLe();
    }

    private void aLe() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0470c.media_controller, this);
        this.dxv = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.dxv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dxE != null) {
                    if (MediaController.this.dxE.isPlaying()) {
                        MediaController.this.dxv.setBackgroundResource(c.a.btn_play);
                        MediaController.this.dxE.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dxv.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.dxE.start();
                }
            }
        });
        this.dxy = (TextView) inflate.findViewById(c.b.tv_position);
        this.dxz = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.dxA = (TextView) inflate.findViewById(c.b.tv_duration);
        this.dxz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.jT(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dxF = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dxE.getDuration() > 0) {
                    MediaController.this.dxB = seekBar.getProgress();
                    if (MediaController.this.dxE != null) {
                        MediaController.this.dxE.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dxF = false;
            }
        });
        this.dxx = inflate.findViewById(c.b.btn_mute);
        this.dxx.setBackgroundResource(this.dxE != null && this.dxE.isMute() ? c.a.mute_on : c.a.mute_off);
        this.dxx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dxE != null) {
                    MediaController.this.dxE.setMuted(!MediaController.this.dxE.isMute());
                }
            }
        });
        this.dxw = inflate.findViewById(c.b.btn_toggle_screen);
        this.dxw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean dxI;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dxI = !this.dxI;
                if (MediaController.this.dwg != null) {
                    MediaController.this.dwg.gw(this.dxI);
                }
            }
        });
        this.dxz.setEnabled(false);
        this.dxv.setEnabled(false);
    }

    public void gB(boolean z) {
        this.dxw.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aLf() {
        int currentPlayerState = this.dxE.getCurrentPlayerState();
        this.dxG = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aLh();
                this.dxv.setEnabled(true);
                this.dxv.setBackgroundResource(c.a.btn_play);
                this.dxz.setEnabled(false);
                jT(this.dxE == null ? 0 : this.dxE.getCurrentPosition());
                jS(this.dxE != null ? this.dxE.getDuration() : 0);
                return;
            case 1:
                this.dxv.setEnabled(false);
                this.dxz.setEnabled(false);
                return;
            case 2:
                this.dxv.setEnabled(true);
                this.dxv.setBackgroundResource(c.a.btn_play);
                this.dxz.setEnabled(true);
                jS(this.dxE == null ? 0 : this.dxE.getDuration());
                this.dxz.setMax(this.dxE != null ? this.dxE.getDuration() : 0);
                return;
            case 3:
                aLg();
                this.dxz.setEnabled(true);
                this.dxv.setEnabled(true);
                this.dxv.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.dxv.setEnabled(true);
                this.dxv.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                aLh();
                this.dxz.setProgress(this.dxz.getMax());
                this.dxz.setEnabled(false);
                this.dxv.setEnabled(true);
                this.dxv.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void aLg() {
        if (this.dxC != null) {
            this.dxC.cancel();
            this.dxC = null;
        }
        this.dxC = new Timer();
        this.dxC.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.dxE != null && MediaController.this.dxE.getVideoPlayerCallback() != null) {
                            MediaController.this.dxE.getVideoPlayerCallback().h(MediaController.this.dxE);
                        }
                        MediaController.this.aLj();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void aLh() {
        if (this.dxC != null) {
            this.dxC.cancel();
            this.dxC = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.dxE = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.dwg = aVar;
    }

    private void show() {
        if (this.dxE != null) {
            setProgress((int) this.dxB);
            setVisibility(0);
        }
    }

    public void aLi() {
        show();
        if (this.dxD != null) {
            this.dxD.cancel();
            this.dxD = null;
        }
        this.dxD = new Timer();
        this.dxD.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void jS(int i) {
        if (this.dxA != null) {
            this.dxA.setText(jU(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT(int i) {
        if (this.dxy != null) {
            this.dxy.setText(jU(i));
        }
    }

    public static String jU(int i) {
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
        if (!this.dxG) {
            if (this.dxz != null) {
                this.dxz.setMax(i);
            }
            jS(i);
            if (i > 0) {
                this.dxG = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dxz != null) {
            this.dxz.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dxx != null) {
            this.dxx.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void aLj() {
        int duration;
        if (this.dxE != null && !this.dxF) {
            long currentPosition = this.dxE.getCurrentPosition();
            if (currentPosition > 0) {
                this.dxB = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dxE.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void jV(int i) {
        if (this.dxz != null && i != this.dxz.getSecondaryProgress()) {
            this.dxz.setSecondaryProgress(i);
        }
    }
}
