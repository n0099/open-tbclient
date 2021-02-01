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
/* loaded from: classes15.dex */
public class MediaController extends RelativeLayout {
    private com.baidu.swan.videoplayer.a.a eAc;
    private boolean eBA;
    private ImageButton eBp;
    private View eBq;
    private View eBr;
    private TextView eBs;
    private SeekBar eBt;
    private TextView eBu;
    private long eBv;
    private Timer eBw;
    private Timer eBx;
    private SwanVideoView eBy;
    boolean eBz;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.eBA = false;
        bgr();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eBA = false;
        bgr();
    }

    private void bgr() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0547c.media_controller, this);
        this.eBp = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.eBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eBy != null) {
                    if (MediaController.this.eBy.isPlaying()) {
                        MediaController.this.eBp.setBackgroundResource(c.a.btn_play);
                        MediaController.this.eBy.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.eBp.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.eBy.start();
                }
            }
        });
        this.eBs = (TextView) inflate.findViewById(c.b.tv_position);
        this.eBt = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.eBu = (TextView) inflate.findViewById(c.b.tv_duration);
        this.eBt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mv(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.eBz = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.eBy.getDuration() > 0) {
                    MediaController.this.eBv = seekBar.getProgress();
                    if (MediaController.this.eBy != null) {
                        MediaController.this.eBy.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.eBz = false;
            }
        });
        this.eBr = inflate.findViewById(c.b.btn_mute);
        this.eBr.setBackgroundResource(this.eBy != null && this.eBy.isMute() ? c.a.mute_on : c.a.mute_off);
        this.eBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eBy != null) {
                    MediaController.this.eBy.setMuted(!MediaController.this.eBy.isMute());
                }
            }
        });
        this.eBq = inflate.findViewById(c.b.btn_toggle_screen);
        this.eBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean bNs;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bNs = !this.bNs;
                if (MediaController.this.eAc != null) {
                    MediaController.this.eAc.iN(this.bNs);
                }
            }
        });
        this.eBt.setEnabled(false);
        this.eBp.setEnabled(false);
    }

    public void iR(boolean z) {
        this.eBq.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void bgs() {
        int currentPlayerState = this.eBy.getCurrentPlayerState();
        this.eBA = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                bgu();
                this.eBp.setEnabled(true);
                this.eBp.setBackgroundResource(c.a.btn_play);
                this.eBt.setEnabled(false);
                mv(this.eBy == null ? 0 : this.eBy.getCurrentPosition());
                mu(this.eBy != null ? this.eBy.getDuration() : 0);
                return;
            case 1:
                this.eBp.setEnabled(false);
                this.eBt.setEnabled(false);
                return;
            case 2:
                this.eBp.setEnabled(true);
                this.eBp.setBackgroundResource(c.a.btn_play);
                this.eBt.setEnabled(true);
                mu(this.eBy == null ? 0 : this.eBy.getDuration());
                this.eBt.setMax(this.eBy != null ? this.eBy.getDuration() : 0);
                return;
            case 3:
                bgt();
                this.eBt.setEnabled(true);
                this.eBp.setEnabled(true);
                this.eBp.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.eBp.setEnabled(true);
                this.eBp.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                bgu();
                this.eBt.setProgress(this.eBt.getMax());
                this.eBt.setEnabled(false);
                this.eBp.setEnabled(true);
                this.eBp.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void bgt() {
        if (this.eBw != null) {
            this.eBw.cancel();
            this.eBw = null;
        }
        this.eBw = new Timer();
        this.eBw.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.eBy != null && MediaController.this.eBy.getVideoPlayerCallback() != null) {
                            MediaController.this.eBy.getVideoPlayerCallback().h(MediaController.this.eBy);
                        }
                        MediaController.this.bgw();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void bgu() {
        if (this.eBw != null) {
            this.eBw.cancel();
            this.eBw = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.eBy = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.eAc = aVar;
    }

    private void show() {
        if (this.eBy != null) {
            setProgress((int) this.eBv);
            setVisibility(0);
        }
    }

    public void bgv() {
        show();
        if (this.eBx != null) {
            this.eBx.cancel();
            this.eBx = null;
        }
        this.eBx = new Timer();
        this.eBx.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void mu(int i) {
        if (this.eBu != null) {
            this.eBu.setText(mw(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv(int i) {
        if (this.eBs != null) {
            this.eBs.setText(mw(i));
        }
    }

    public static String mw(int i) {
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
        if (!this.eBA) {
            if (this.eBt != null) {
                this.eBt.setMax(i);
            }
            mu(i);
            if (i > 0) {
                this.eBA = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.eBt != null) {
            this.eBt.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eBr != null) {
            this.eBr.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void bgw() {
        int duration;
        if (this.eBy != null && !this.eBz) {
            long currentPosition = this.eBy.getCurrentPosition();
            if (currentPosition > 0) {
                this.eBv = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.eBy.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void mx(int i) {
        if (this.eBt != null && i != this.eBt.getSecondaryProgress()) {
            this.eBt.setSecondaryProgress(i);
        }
    }
}
