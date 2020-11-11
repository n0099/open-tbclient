package com.baidu.live.s;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class g {
    private AudioManager bqA;
    private a bqB;
    private boolean bqC;
    private boolean bqD;
    private AudioManager.OnAudioFocusChangeListener bqE = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.s.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.bqB != null) {
                        g.this.bqB.cn(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.bqB != null) {
                        g.this.bqB.cn(false);
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
                    if (g.this.bqB != null) {
                        g.this.bqB.cn(true);
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
            if (this.bqA == null) {
                this.bqA = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.bqA != null) {
                try {
                    setFocus(this.bqA.requestAudioFocus(this.bqE, 3, 1) == 1);
                    cp(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.bqC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.bqC = z;
    }

    private void cp(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.bqD = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.bqD + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.bqA == null) {
                this.bqA = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.bqA != null) {
                cp(false);
                try {
                    setFocus(false);
                    this.bqA.abandonAudioFocus(this.bqE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bqB = aVar;
    }
}
