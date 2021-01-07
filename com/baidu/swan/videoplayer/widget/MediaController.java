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
/* loaded from: classes3.dex */
public class MediaController extends RelativeLayout {
    private com.baidu.swan.videoplayer.a.a eCH;
    private ImageButton eDU;
    private View eDV;
    private View eDW;
    private TextView eDX;
    private SeekBar eDY;
    private TextView eDZ;
    private long eEa;
    private Timer eEb;
    private Timer eEc;
    private SwanVideoView eEd;
    boolean eEe;
    private boolean eEf;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.eEf = false;
        bjY();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eEf = false;
        bjY();
    }

    private void bjY() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0567c.media_controller, this);
        this.eDU = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.eDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eEd != null) {
                    if (MediaController.this.eEd.isPlaying()) {
                        MediaController.this.eDU.setBackgroundResource(c.a.btn_play);
                        MediaController.this.eEd.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.eDU.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.eEd.start();
                }
            }
        });
        this.eDX = (TextView) inflate.findViewById(c.b.tv_position);
        this.eDY = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.eDZ = (TextView) inflate.findViewById(c.b.tv_duration);
        this.eDY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.nY(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.eEe = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.eEd.getDuration() > 0) {
                    MediaController.this.eEa = seekBar.getProgress();
                    if (MediaController.this.eEd != null) {
                        MediaController.this.eEd.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.eEe = false;
            }
        });
        this.eDW = inflate.findViewById(c.b.btn_mute);
        this.eDW.setBackgroundResource(this.eEd != null && this.eEd.isMute() ? c.a.mute_on : c.a.mute_off);
        this.eDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eEd != null) {
                    MediaController.this.eEd.setMuted(!MediaController.this.eEd.isMute());
                }
            }
        });
        this.eDV = inflate.findViewById(c.b.btn_toggle_screen);
        this.eDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean bOu;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bOu = !this.bOu;
                if (MediaController.this.eCH != null) {
                    MediaController.this.eCH.iP(this.bOu);
                }
            }
        });
        this.eDY.setEnabled(false);
        this.eDU.setEnabled(false);
    }

    public void iT(boolean z) {
        this.eDV.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void bjZ() {
        int currentPlayerState = this.eEd.getCurrentPlayerState();
        this.eEf = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                bkb();
                this.eDU.setEnabled(true);
                this.eDU.setBackgroundResource(c.a.btn_play);
                this.eDY.setEnabled(false);
                nY(this.eEd == null ? 0 : this.eEd.getCurrentPosition());
                nX(this.eEd != null ? this.eEd.getDuration() : 0);
                return;
            case 1:
                this.eDU.setEnabled(false);
                this.eDY.setEnabled(false);
                return;
            case 2:
                this.eDU.setEnabled(true);
                this.eDU.setBackgroundResource(c.a.btn_play);
                this.eDY.setEnabled(true);
                nX(this.eEd == null ? 0 : this.eEd.getDuration());
                this.eDY.setMax(this.eEd != null ? this.eEd.getDuration() : 0);
                return;
            case 3:
                bka();
                this.eDY.setEnabled(true);
                this.eDU.setEnabled(true);
                this.eDU.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.eDU.setEnabled(true);
                this.eDU.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                bkb();
                this.eDY.setProgress(this.eDY.getMax());
                this.eDY.setEnabled(false);
                this.eDU.setEnabled(true);
                this.eDU.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void bka() {
        if (this.eEb != null) {
            this.eEb.cancel();
            this.eEb = null;
        }
        this.eEb = new Timer();
        this.eEb.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.eEd != null && MediaController.this.eEd.getVideoPlayerCallback() != null) {
                            MediaController.this.eEd.getVideoPlayerCallback().h(MediaController.this.eEd);
                        }
                        MediaController.this.bkd();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void bkb() {
        if (this.eEb != null) {
            this.eEb.cancel();
            this.eEb = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.eEd = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.eCH = aVar;
    }

    private void show() {
        if (this.eEd != null) {
            setProgress((int) this.eEa);
            setVisibility(0);
        }
    }

    public void bkc() {
        show();
        if (this.eEc != null) {
            this.eEc.cancel();
            this.eEc = null;
        }
        this.eEc = new Timer();
        this.eEc.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void nX(int i) {
        if (this.eDZ != null) {
            this.eDZ.setText(nZ(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nY(int i) {
        if (this.eDX != null) {
            this.eDX.setText(nZ(i));
        }
    }

    public static String nZ(int i) {
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
        if (!this.eEf) {
            if (this.eDY != null) {
                this.eDY.setMax(i);
            }
            nX(i);
            if (i > 0) {
                this.eEf = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.eDY != null) {
            this.eDY.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eDW != null) {
            this.eDW.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void bkd() {
        int duration;
        if (this.eEd != null && !this.eEe) {
            long currentPosition = this.eEd.getCurrentPosition();
            if (currentPosition > 0) {
                this.eEa = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.eEd.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void oa(int i) {
        if (this.eDY != null && i != this.eDY.getSecondaryProgress()) {
            this.eDY.setSecondaryProgress(i);
        }
    }
}
