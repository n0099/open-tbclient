package com.baidu.live.q;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
/* loaded from: classes4.dex */
public class g {
    private AudioManager bjH;
    private a bjI;
    private boolean bjJ;
    private boolean bjK;
    private AudioManager.OnAudioFocusChangeListener bjL = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.q.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.bjI != null) {
                        g.this.bjI.ch(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.bjI != null) {
                        g.this.bjI.ch(false);
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
                    if (g.this.bjI != null) {
                        g.this.bjI.ch(true);
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
            if (this.bjH == null) {
                this.bjH = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bjH != null) {
                try {
                    setFocus(this.bjH.requestAudioFocus(this.bjL, 3, 1) == 1);
                    cj(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.bjJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.bjJ = z;
    }

    private void cj(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.bjK = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.bjK + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.bjH == null) {
                this.bjH = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bjH != null) {
                cj(false);
                try {
                    setFocus(false);
                    this.bjH.abandonAudioFocus(this.bjL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bjI = aVar;
    }
}
