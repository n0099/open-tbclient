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
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes14.dex */
public class MediaController extends RelativeLayout {
    private com.baidu.swan.videoplayer.a.a exT;
    private ImageButton ezi;
    private View ezj;
    private View ezk;
    private TextView ezl;
    private SeekBar ezm;
    private TextView ezn;
    private long ezo;
    private Timer ezp;
    private Timer ezq;
    private SwanVideoView ezr;
    boolean ezs;
    private boolean ezt;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.ezt = false;
        bge();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezt = false;
        bge();
    }

    private void bge() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0550c.media_controller, this);
        this.ezi = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.ezi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.ezr != null) {
                    if (MediaController.this.ezr.isPlaying()) {
                        MediaController.this.ezi.setBackgroundResource(c.a.btn_play);
                        MediaController.this.ezr.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.ezi.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.ezr.start();
                }
            }
        });
        this.ezl = (TextView) inflate.findViewById(c.b.tv_position);
        this.ezm = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.ezn = (TextView) inflate.findViewById(c.b.tv_duration);
        this.ezm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.ms(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.ezs = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.ezr.getDuration() > 0) {
                    MediaController.this.ezo = seekBar.getProgress();
                    if (MediaController.this.ezr != null) {
                        MediaController.this.ezr.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.ezs = false;
            }
        });
        this.ezk = inflate.findViewById(c.b.btn_mute);
        this.ezk.setBackgroundResource(this.ezr != null && this.ezr.isMute() ? c.a.mute_on : c.a.mute_off);
        this.ezk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.ezr != null) {
                    MediaController.this.ezr.setMuted(!MediaController.this.ezr.isMute());
                }
            }
        });
        this.ezj = inflate.findViewById(c.b.btn_toggle_screen);
        this.ezj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean bJI;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bJI = !this.bJI;
                if (MediaController.this.exT != null) {
                    MediaController.this.exT.iL(this.bJI);
                }
            }
        });
        this.ezm.setEnabled(false);
        this.ezi.setEnabled(false);
    }

    public void iP(boolean z) {
        this.ezj.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void bgf() {
        int currentPlayerState = this.ezr.getCurrentPlayerState();
        this.ezt = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                bgh();
                this.ezi.setEnabled(true);
                this.ezi.setBackgroundResource(c.a.btn_play);
                this.ezm.setEnabled(false);
                ms(this.ezr == null ? 0 : this.ezr.getCurrentPosition());
                mr(this.ezr != null ? this.ezr.getDuration() : 0);
                return;
            case 1:
                this.ezi.setEnabled(false);
                this.ezm.setEnabled(false);
                return;
            case 2:
                this.ezi.setEnabled(true);
                this.ezi.setBackgroundResource(c.a.btn_play);
                this.ezm.setEnabled(true);
                mr(this.ezr == null ? 0 : this.ezr.getDuration());
                this.ezm.setMax(this.ezr != null ? this.ezr.getDuration() : 0);
                return;
            case 3:
                bgg();
                this.ezm.setEnabled(true);
                this.ezi.setEnabled(true);
                this.ezi.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.ezi.setEnabled(true);
                this.ezi.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                bgh();
                this.ezm.setProgress(this.ezm.getMax());
                this.ezm.setEnabled(false);
                this.ezi.setEnabled(true);
                this.ezi.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void bgg() {
        if (this.ezp != null) {
            this.ezp.cancel();
            this.ezp = null;
        }
        this.ezp = new Timer();
        this.ezp.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.ezr != null && MediaController.this.ezr.getVideoPlayerCallback() != null) {
                            MediaController.this.ezr.getVideoPlayerCallback().h(MediaController.this.ezr);
                        }
                        MediaController.this.bgj();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void bgh() {
        if (this.ezp != null) {
            this.ezp.cancel();
            this.ezp = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.ezr = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.exT = aVar;
    }

    private void show() {
        if (this.ezr != null) {
            setProgress((int) this.ezo);
            setVisibility(0);
        }
    }

    public void bgi() {
        show();
        if (this.ezq != null) {
            this.ezq.cancel();
            this.ezq = null;
        }
        this.ezq = new Timer();
        this.ezq.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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
        if (this.ezn != null) {
            this.ezn.setText(mt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (this.ezl != null) {
            this.ezl.setText(mt(i));
        }
    }

    public static String mt(int i) {
        if (i < 0) {
            return "";
        }
        int i2 = i / 1000;
        int i3 = i2 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        int i4 = (i2 % SdkConfigData.DEFAULT_REQUEST_INTERVAL) / 60;
        int i5 = i2 % 60;
        return i3 != 0 ? String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private void setMax(int i) {
        if (!this.ezt) {
            if (this.ezm != null) {
                this.ezm.setMax(i);
            }
            mr(i);
            if (i > 0) {
                this.ezt = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.ezm != null) {
            this.ezm.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.ezk != null) {
            this.ezk.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void bgj() {
        int duration;
        if (this.ezr != null && !this.ezs) {
            long currentPosition = this.ezr.getCurrentPosition();
            if (currentPosition > 0) {
                this.ezo = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.ezr.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void mu(int i) {
        if (this.ezm != null && i != this.ezm.getSecondaryProgress()) {
            this.ezm.setSecondaryProgress(i);
        }
    }
}
