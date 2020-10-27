package com.baidu.live.r;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class g {
    private AudioManager bph;
    private a bpi;
    private boolean bpj;
    private boolean bpk;
    private AudioManager.OnAudioFocusChangeListener bpl = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.r.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.bpi != null) {
                        g.this.bpi.cm(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.bpi != null) {
                        g.this.bpi.cm(false);
                        return;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                    g.this.setFocus(true);
                    if (g.this.bpi != null) {
                        g.this.bpi.cm(true);
                        return;
                    }
                    return;
            }
        }
    };
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void requestAudioFocus() {
        if (this.mContext != null) {
            if (this.bph == null) {
                this.bph = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.bph != null) {
                try {
                    setFocus(this.bph.requestAudioFocus(this.bpl, 3, 1) == 1);
                    co(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.bpj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.bpj = z;
    }

    private void co(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.bpk = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.bpk + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.bph == null) {
                this.bph = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.bph != null) {
                co(false);
                try {
                    setFocus(false);
                    this.bph.abandonAudioFocus(this.bpl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bpi = aVar;
    }
}
