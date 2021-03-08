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
    private com.baidu.swan.videoplayer.a.a eBD;
    private ImageButton eCQ;
    private View eCR;
    private View eCS;
    private TextView eCT;
    private SeekBar eCU;
    private TextView eCV;
    private long eCW;
    private Timer eCX;
    private Timer eCY;
    private SwanVideoView eCZ;
    boolean eDa;
    private boolean eDb;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.eDb = false;
        bgt();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eDb = false;
        bgt();
    }

    private void bgt() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0553c.media_controller, this);
        this.eCQ = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.eCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eCZ != null) {
                    if (MediaController.this.eCZ.isPlaying()) {
                        MediaController.this.eCQ.setBackgroundResource(c.a.btn_play);
                        MediaController.this.eCZ.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.eCQ.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.eCZ.start();
                }
            }
        });
        this.eCT = (TextView) inflate.findViewById(c.b.tv_position);
        this.eCU = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.eCV = (TextView) inflate.findViewById(c.b.tv_duration);
        this.eCU.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mw(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.eDa = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.eCZ.getDuration() > 0) {
                    MediaController.this.eCW = seekBar.getProgress();
                    if (MediaController.this.eCZ != null) {
                        MediaController.this.eCZ.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.eDa = false;
            }
        });
        this.eCS = inflate.findViewById(c.b.btn_mute);
        this.eCS.setBackgroundResource(this.eCZ != null && this.eCZ.isMute() ? c.a.mute_on : c.a.mute_off);
        this.eCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eCZ != null) {
                    MediaController.this.eCZ.setMuted(!MediaController.this.eCZ.isMute());
                }
            }
        });
        this.eCR = inflate.findViewById(c.b.btn_toggle_screen);
        this.eCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean bOS;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bOS = !this.bOS;
                if (MediaController.this.eBD != null) {
                    MediaController.this.eBD.iN(this.bOS);
                }
            }
        });
        this.eCU.setEnabled(false);
        this.eCQ.setEnabled(false);
    }

    public void iR(boolean z) {
        this.eCR.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void bgu() {
        int currentPlayerState = this.eCZ.getCurrentPlayerState();
        this.eDb = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                bgw();
                this.eCQ.setEnabled(true);
                this.eCQ.setBackgroundResource(c.a.btn_play);
                this.eCU.setEnabled(false);
                mw(this.eCZ == null ? 0 : this.eCZ.getCurrentPosition());
                mv(this.eCZ != null ? this.eCZ.getDuration() : 0);
                return;
            case 1:
                this.eCQ.setEnabled(false);
                this.eCU.setEnabled(false);
                return;
            case 2:
                this.eCQ.setEnabled(true);
                this.eCQ.setBackgroundResource(c.a.btn_play);
                this.eCU.setEnabled(true);
                mv(this.eCZ == null ? 0 : this.eCZ.getDuration());
                this.eCU.setMax(this.eCZ != null ? this.eCZ.getDuration() : 0);
                return;
            case 3:
                bgv();
                this.eCU.setEnabled(true);
                this.eCQ.setEnabled(true);
                this.eCQ.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.eCQ.setEnabled(true);
                this.eCQ.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                bgw();
                this.eCU.setProgress(this.eCU.getMax());
                this.eCU.setEnabled(false);
                this.eCQ.setEnabled(true);
                this.eCQ.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void bgv() {
        if (this.eCX != null) {
            this.eCX.cancel();
            this.eCX = null;
        }
        this.eCX = new Timer();
        this.eCX.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.eCZ != null && MediaController.this.eCZ.getVideoPlayerCallback() != null) {
                            MediaController.this.eCZ.getVideoPlayerCallback().h(MediaController.this.eCZ);
                        }
                        MediaController.this.bgy();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void bgw() {
        if (this.eCX != null) {
            this.eCX.cancel();
            this.eCX = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.eCZ = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.eBD = aVar;
    }

    private void show() {
        if (this.eCZ != null) {
            setProgress((int) this.eCW);
            setVisibility(0);
        }
    }

    public void bgx() {
        show();
        if (this.eCY != null) {
            this.eCY.cancel();
            this.eCY = null;
        }
        this.eCY = new Timer();
        this.eCY.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void mv(int i) {
        if (this.eCV != null) {
            this.eCV.setText(mx(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(int i) {
        if (this.eCT != null) {
            this.eCT.setText(mx(i));
        }
    }

    public static String mx(int i) {
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
        if (!this.eDb) {
            if (this.eCU != null) {
                this.eCU.setMax(i);
            }
            mv(i);
            if (i > 0) {
                this.eDb = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.eCU != null) {
            this.eCU.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eCS != null) {
            this.eCS.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void bgy() {
        int duration;
        if (this.eCZ != null && !this.eDa) {
            long currentPosition = this.eCZ.getCurrentPosition();
            if (currentPosition > 0) {
                this.eCW = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.eCZ.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void my(int i) {
        if (this.eCU != null && i != this.eCU.getSecondaryProgress()) {
            this.eCU.setSecondaryProgress(i);
        }
    }
}
