package com.baidu.live.s;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class g {
    private AudioManager boP;
    private a boQ;
    private boolean boR;
    private boolean boS;
    private AudioManager.OnAudioFocusChangeListener boT = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.s.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.boQ != null) {
                        g.this.boQ.cp(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.boQ != null) {
                        g.this.boQ.cp(false);
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
                    if (g.this.boQ != null) {
                        g.this.boQ.cp(true);
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
            if (this.boP == null) {
                this.boP = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.boP != null) {
                try {
                    setFocus(this.boP.requestAudioFocus(this.boT, 3, 1) == 1);
                    cr(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.boR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.boR = z;
    }

    private void cr(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.boS = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.boS + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.boP == null) {
                this.boP = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.boP != null) {
                cr(false);
                try {
                    setFocus(false);
                    this.boP.abandonAudioFocus(this.boT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.boQ = aVar;
    }
}
