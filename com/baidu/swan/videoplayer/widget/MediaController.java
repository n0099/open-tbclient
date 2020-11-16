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
    private com.baidu.swan.videoplayer.a.a elY;
    private ImageButton enm;
    private View enn;
    private View eno;
    private TextView enp;
    private SeekBar enq;
    private TextView enr;
    private long ens;
    private Timer ent;
    private Timer enu;
    private SwanVideoView enw;
    boolean enx;
    private boolean eny;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.eny = false;
        bew();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eny = false;
        bew();
    }

    private void bew() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0564c.media_controller, this);
        this.enm = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.enm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.enw != null) {
                    if (MediaController.this.enw.isPlaying()) {
                        MediaController.this.enm.setBackgroundResource(c.a.btn_play);
                        MediaController.this.enw.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.enm.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.enw.start();
                }
            }
        });
        this.enp = (TextView) inflate.findViewById(c.b.tv_position);
        this.enq = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.enr = (TextView) inflate.findViewById(c.b.tv_duration);
        this.enq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.nr(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.enx = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.enw.getDuration() > 0) {
                    MediaController.this.ens = seekBar.getProgress();
                    if (MediaController.this.enw != null) {
                        MediaController.this.enw.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.enx = false;
            }
        });
        this.eno = inflate.findViewById(c.b.btn_mute);
        this.eno.setBackgroundResource(this.enw != null && this.enw.isMute() ? c.a.mute_on : c.a.mute_off);
        this.eno.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.enw != null) {
                    MediaController.this.enw.setMuted(!MediaController.this.enw.isMute());
                }
            }
        });
        this.enn = inflate.findViewById(c.b.btn_toggle_screen);
        this.enn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean bEy;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bEy = !this.bEy;
                if (MediaController.this.elY != null) {
                    MediaController.this.elY.mo36if(this.bEy);
                }
            }
        });
        this.enq.setEnabled(false);
        this.enm.setEnabled(false);
    }

    public void ij(boolean z) {
        this.enn.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void bex() {
        int currentPlayerState = this.enw.getCurrentPlayerState();
        this.eny = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                bez();
                this.enm.setEnabled(true);
                this.enm.setBackgroundResource(c.a.btn_play);
                this.enq.setEnabled(false);
                nr(this.enw == null ? 0 : this.enw.getCurrentPosition());
                nq(this.enw != null ? this.enw.getDuration() : 0);
                return;
            case 1:
                this.enm.setEnabled(false);
                this.enq.setEnabled(false);
                return;
            case 2:
                this.enm.setEnabled(true);
                this.enm.setBackgroundResource(c.a.btn_play);
                this.enq.setEnabled(true);
                nq(this.enw == null ? 0 : this.enw.getDuration());
                this.enq.setMax(this.enw != null ? this.enw.getDuration() : 0);
                return;
            case 3:
                bey();
                this.enq.setEnabled(true);
                this.enm.setEnabled(true);
                this.enm.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.enm.setEnabled(true);
                this.enm.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                bez();
                this.enq.setProgress(this.enq.getMax());
                this.enq.setEnabled(false);
                this.enm.setEnabled(true);
                this.enm.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void bey() {
        if (this.ent != null) {
            this.ent.cancel();
            this.ent = null;
        }
        this.ent = new Timer();
        this.ent.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.enw != null && MediaController.this.enw.getVideoPlayerCallback() != null) {
                            MediaController.this.enw.getVideoPlayerCallback().h(MediaController.this.enw);
                        }
                        MediaController.this.beB();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void bez() {
        if (this.ent != null) {
            this.ent.cancel();
            this.ent = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.enw = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.elY = aVar;
    }

    private void show() {
        if (this.enw != null) {
            setProgress((int) this.ens);
            setVisibility(0);
        }
    }

    public void beA() {
        show();
        if (this.enu != null) {
            this.enu.cancel();
            this.enu = null;
        }
        this.enu = new Timer();
        this.enu.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void nq(int i) {
        if (this.enr != null) {
            this.enr.setText(ns(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i) {
        if (this.enp != null) {
            this.enp.setText(ns(i));
        }
    }

    public static String ns(int i) {
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
        if (!this.eny) {
            if (this.enq != null) {
                this.enq.setMax(i);
            }
            nq(i);
            if (i > 0) {
                this.eny = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.enq != null) {
            this.enq.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eno != null) {
            this.eno.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void beB() {
        int duration;
        if (this.enw != null && !this.enx) {
            long currentPosition = this.enw.getCurrentPosition();
            if (currentPosition > 0) {
                this.ens = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.enw.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void nt(int i) {
        if (this.enq != null && i != this.enq.getSecondaryProgress()) {
            this.enq.setSecondaryProgress(i);
        }
    }
}
