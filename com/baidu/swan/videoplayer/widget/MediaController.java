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
    private com.baidu.swan.videoplayer.a.a ehO;
    private ImageButton ejb;
    private View ejc;
    private View ejd;
    private TextView eje;
    private SeekBar ejf;
    private TextView ejg;
    private long ejh;
    private Timer eji;
    private Timer ejj;
    private SwanVideoView ejk;
    boolean ejl;
    private boolean ejm;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.ejm = false;
        bcD();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ejm = false;
        bcD();
    }

    private void bcD() {
        View inflate = LayoutInflater.from(getContext()).inflate(c.C0554c.media_controller, this);
        this.ejb = (ImageButton) inflate.findViewById(c.b.btn_play);
        this.ejb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.ejk != null) {
                    if (MediaController.this.ejk.isPlaying()) {
                        MediaController.this.ejb.setBackgroundResource(c.a.btn_play);
                        MediaController.this.ejk.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.ejb.setBackgroundResource(c.a.btn_pause);
                    MediaController.this.ejk.start();
                }
            }
        });
        this.eje = (TextView) inflate.findViewById(c.b.tv_position);
        this.ejf = (SeekBar) inflate.findViewById(c.b.seekbar);
        this.ejg = (TextView) inflate.findViewById(c.b.tv_duration);
        this.ejf.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.nl(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.ejl = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.ejk.getDuration() > 0) {
                    MediaController.this.ejh = seekBar.getProgress();
                    if (MediaController.this.ejk != null) {
                        MediaController.this.ejk.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.ejl = false;
            }
        });
        this.ejd = inflate.findViewById(c.b.btn_mute);
        this.ejd.setBackgroundResource(this.ejk != null && this.ejk.isMute() ? c.a.mute_on : c.a.mute_off);
        this.ejd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.ejk != null) {
                    MediaController.this.ejk.setMuted(!MediaController.this.ejk.isMute());
                }
            }
        });
        this.ejc = inflate.findViewById(c.b.btn_toggle_screen);
        this.ejc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.videoplayer.widget.MediaController.4
            private boolean bzY;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.bzY = !this.bzY;
                if (MediaController.this.ehO != null) {
                    MediaController.this.ehO.hT(this.bzY);
                }
            }
        });
        this.ejf.setEnabled(false);
        this.ejb.setEnabled(false);
    }

    public void hX(boolean z) {
        this.ejc.setBackgroundResource(z ? c.a.btn_halfscreen : c.a.btn_fullscreen);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void bcE() {
        int currentPlayerState = this.ejk.getCurrentPlayerState();
        this.ejm = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                bcG();
                this.ejb.setEnabled(true);
                this.ejb.setBackgroundResource(c.a.btn_play);
                this.ejf.setEnabled(false);
                nl(this.ejk == null ? 0 : this.ejk.getCurrentPosition());
                nk(this.ejk != null ? this.ejk.getDuration() : 0);
                return;
            case 1:
                this.ejb.setEnabled(false);
                this.ejf.setEnabled(false);
                return;
            case 2:
                this.ejb.setEnabled(true);
                this.ejb.setBackgroundResource(c.a.btn_play);
                this.ejf.setEnabled(true);
                nk(this.ejk == null ? 0 : this.ejk.getDuration());
                this.ejf.setMax(this.ejk != null ? this.ejk.getDuration() : 0);
                return;
            case 3:
                bcF();
                this.ejf.setEnabled(true);
                this.ejb.setEnabled(true);
                this.ejb.setBackgroundResource(c.a.btn_pause);
                return;
            case 4:
                this.ejb.setEnabled(true);
                this.ejb.setBackgroundResource(c.a.btn_play);
                return;
            case 5:
                bcG();
                this.ejf.setProgress(this.ejf.getMax());
                this.ejf.setEnabled(false);
                this.ejb.setEnabled(true);
                this.ejb.setBackgroundResource(c.a.btn_play);
                return;
            default:
                return;
        }
    }

    private void bcF() {
        if (this.eji != null) {
            this.eji.cancel();
            this.eji = null;
        }
        this.eji = new Timer();
        this.eji.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaController.this.ejk != null && MediaController.this.ejk.getVideoPlayerCallback() != null) {
                            MediaController.this.ejk.getVideoPlayerCallback().h(MediaController.this.ejk);
                        }
                        MediaController.this.bcI();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void bcG() {
        if (this.eji != null) {
            this.eji.cancel();
            this.eji = null;
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.ejk = swanVideoView;
    }

    public void setToggleScreenListener(com.baidu.swan.videoplayer.a.a aVar) {
        this.ehO = aVar;
    }

    private void show() {
        if (this.ejk != null) {
            setProgress((int) this.ejh);
            setVisibility(0);
        }
    }

    public void bcH() {
        show();
        if (this.ejj != null) {
            this.ejj.cancel();
            this.ejj = null;
        }
        this.ejj = new Timer();
        this.ejj.schedule(new TimerTask() { // from class: com.baidu.swan.videoplayer.widget.MediaController.6
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

    private void nk(int i) {
        if (this.ejg != null) {
            this.ejg.setText(nm(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(int i) {
        if (this.eje != null) {
            this.eje.setText(nm(i));
        }
    }

    public static String nm(int i) {
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
        if (!this.ejm) {
            if (this.ejf != null) {
                this.ejf.setMax(i);
            }
            nk(i);
            if (i > 0) {
                this.ejm = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.ejf != null) {
            this.ejf.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.ejd != null) {
            this.ejd.setBackgroundResource(z ? c.a.mute_on : c.a.mute_off);
        }
    }

    public void bcI() {
        int duration;
        if (this.ejk != null && !this.ejl) {
            long currentPosition = this.ejk.getCurrentPosition();
            if (currentPosition > 0) {
                this.ejh = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.ejk.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public void nn(int i) {
        if (this.ejf != null && i != this.ejf.getSecondaryProgress()) {
            this.ejf.setSecondaryProgress(i);
        }
    }
}
