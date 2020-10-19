package com.baidu.live.q;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class g {
    private AudioManager bnu;
    private a bnv;
    private boolean bnw;
    private boolean bnx;
    private AudioManager.OnAudioFocusChangeListener bny = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.q.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.bnv != null) {
                        g.this.bnv.ck(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.bnv != null) {
                        g.this.bnv.ck(false);
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
                    if (g.this.bnv != null) {
                        g.this.bnv.ck(true);
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
            if (this.bnu == null) {
                this.bnu = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.bnu != null) {
                try {
                    setFocus(this.bnu.requestAudioFocus(this.bny, 3, 1) == 1);
                    cm(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.bnw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.bnw = z;
    }

    private void cm(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.bnx = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.bnx + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.bnu == null) {
                this.bnu = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            if (this.bnu != null) {
                cm(false);
                try {
                    setFocus(false);
                    this.bnu.abandonAudioFocus(this.bny);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bnv = aVar;
    }
}
