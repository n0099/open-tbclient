package com.baidu.live.u;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
/* loaded from: classes10.dex */
public class g {
    private AudioManager bzc;
    private a bzd;
    private boolean bze;
    private boolean bzf;
    private AudioManager.OnAudioFocusChangeListener bzg = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.u.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.bzd != null) {
                        g.this.bzd.cL(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.bzd != null) {
                        g.this.bzd.cL(false);
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
                    if (g.this.bzd != null) {
                        g.this.bzd.cL(true);
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
            if (this.bzc == null) {
                this.bzc = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bzc != null) {
                try {
                    setFocus(this.bzc.requestAudioFocus(this.bzg, 3, 1) == 1);
                    cN(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.bze;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.bze = z;
    }

    private void cN(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.bzf = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.bzf + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.bzc == null) {
                this.bzc = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bzc != null) {
                cN(false);
                try {
                    setFocus(false);
                    this.bzc.abandonAudioFocus(this.bzg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bzd = aVar;
    }
}
