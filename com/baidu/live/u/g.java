package com.baidu.live.u;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
/* loaded from: classes11.dex */
public class g {
    private AudioManager bxC;
    private a bxD;
    private boolean bxE;
    private boolean bxF;
    private AudioManager.OnAudioFocusChangeListener bxG = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.u.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.bxD != null) {
                        g.this.bxD.cL(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.bxD != null) {
                        g.this.bxD.cL(false);
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
                    if (g.this.bxD != null) {
                        g.this.bxD.cL(true);
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
            if (this.bxC == null) {
                this.bxC = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bxC != null) {
                try {
                    setFocus(this.bxC.requestAudioFocus(this.bxG, 3, 1) == 1);
                    cN(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.bxE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.bxE = z;
    }

    private void cN(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.bxF = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.bxF + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.bxC == null) {
                this.bxC = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bxC != null) {
                cN(false);
                try {
                    setFocus(false);
                    this.bxC.abandonAudioFocus(this.bxG);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bxD = aVar;
    }
}
