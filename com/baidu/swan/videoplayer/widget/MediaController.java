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
    private com.baidu.swan.videoplayer.a.a enH;
    private ImageButton eoV;
    private View eoW;
    private View eoX;
    private TextView eoY;
    private SeekBar eoZ;
    private TextView epa;
    private long epb;
    private Timer epc;
    private Timer epd;
    private SwanVideoView epe;
    boolean epf;
    private boolean epg;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.epg = false;
        bfd();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epg = false;
        bfd();
    }

    private void bfd() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0566c.media_controller, this);
        this.eoV = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.eoV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.epe != null) {
                    if (MediaController.this.epe.isPlaying()) {
                        MediaController.this.eoV.setBackgroundResource(c.a.btn_play);
                        MediaController.this.epe.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.eoV.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.epe.start();
                }
            }
        });
        this.eoY = (TextView) inflate.findViewById(c.b.tv_position);
        this.eoZ = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.epa = (TextView) inflate.findViewById(c.b.tv_duration);
        this.eoZ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.nv(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.epf = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.epe.getDuration() > 0) {
                    MediaController.this.epb = seekBar.getProgress();
                    if (MediaController.this.epe != null) {
                        MediaController.this.epe.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.epf = false;
            }
        });
        this.eoX = inflate.findViewById(c.b.btn_mute);
        this.eoX.setBackgroundResource(this.epe != null && this.epe.isMute() ? c.a.mute_on : c.a.mute_off);
        this.eoX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.epe != null) {
                    MediaController.this.epe.setMuted(!MediaController.this.epe.isMute());
                }
            }
        });
        this.eoW = inflate.findViewById(c.b.btn_toggle_screen);
        this.eoW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean bGj;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bGj = !this.bGj;
                if (MediaController.this.enH != null) {
                    MediaController.this.enH.ic(this.bGj);
                }
            }
        });
        this.eoZ.setEnabled(false);
        this.eoV.setEnabled(false);
    }

    public void ig(boolean z) {
        this.eoW.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void bfe() {
        int currentPlayerState = this.epe.getCurrentPlayerState();
        this.epg = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                bfg();
                this.eoV.setEnabled(true);
                this.eoV.setBackgroundResource(c.a.btn_play);
                this.eoZ.setEnabled(false);
                nv(this.epe == null ? 0 : this.epe.getCurrentPosition());
                nu(this.epe != null ? this.epe.getDuration() : 0);
                return;
            case 1:
                this.eoV.setEnabled(false);
                this.eoZ.setEnabled(false);
                return;
            case 2:
                this.eoV.setEnabled(true);
                this.eoV.setBackgroundResource(c.a.btn_play);
                this.eoZ.setEnabled(true);
                nu(this.epe == null ? 0 : this.epe.getDuration());
                this.eoZ.setMax(this.epe != null ? this.epe.getDuration() : 0);
                return;
            case 3:
                bff();
                this.eoZ.setEnabled(true);
                this.eoV.setEnabled(true);
                this.eoV.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.eoV.setEnabled(true);
                this.eoV.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                bfg();
                this.eoZ.setProgress(this.eoZ.getMax());
                this.eoZ.setEnabled(false);
                this.eoV.setEnabled(true);
                this.eoV.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void bff() {
        if (this.epc != null) {
            this.epc.cancel();
            this.epc = null;
        }
        this.epc = new Timer();
        this.epc.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.epe != null && MediaController.this.epe.getVideoPlayerCallback() != null) {
                            MediaController.this.epe.getVideoPlayerCallback().h(MediaController.this.epe);
                        }
                        MediaController.this.bfi();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void bfg() {
        if (this.epc != null) {
            this.epc.cancel();
            this.epc = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.epe = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.enH = aVar;
    }

    private void show() {
        if (this.epe != null) {
            setProgress((int) this.epb);
            setVisibility(0);
        }
    }

    public void bfh() {
        show();
        if (this.epd != null) {
            this.epd.cancel();
            this.epd = null;
        }
        this.epd = new Timer();
        this.epd.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void nu(int i) {
        if (this.epa != null) {
            this.epa.setText(nw(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(int i) {
        if (this.eoY != null) {
            this.eoY.setText(nw(i));
        }
    }

    public static String nw(int i) {
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
        if (!this.epg) {
            if (this.eoZ != null) {
                this.eoZ.setMax(i);
            }
            nu(i);
            if (i > 0) {
                this.epg = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.eoZ != null) {
            this.eoZ.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eoX != null) {
            this.eoX.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void bfi() {
        int duration;
        if (this.epe != null && !this.epf) {
            long currentPosition = this.epe.getCurrentPosition();
            if (currentPosition > 0) {
                this.epb = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.epe.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void nx(int i) {
        if (this.eoZ != null && i != this.eoZ.getSecondaryProgress()) {
            this.eoZ.setSecondaryProgress(i);
        }
    }
}
