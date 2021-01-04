package com.baidu.live.v;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
/* loaded from: classes11.dex */
public class g {
    private AudioManager byK;
    private a byL;
    private boolean byM;
    private boolean byN;
    private AudioManager.OnAudioFocusChangeListener byO = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.v.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.byL != null) {
                        g.this.byL.cG(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.byL != null) {
                        g.this.byL.cG(false);
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
                    if (g.this.byL != null) {
                        g.this.byL.cG(true);
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
            if (this.byK == null) {
                this.byK = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.byK != null) {
                try {
                    setFocus(this.byK.requestAudioFocus(this.byO, 3, 1) == 1);
                    cI(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.byM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.byM = z;
    }

    private void cI(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.byN = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.byN + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.byK == null) {
                this.byK = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.byK != null) {
                cI(false);
                try {
                    setFocus(false);
                    this.byK.abandonAudioFocus(this.byO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.byL = aVar;
    }
}
