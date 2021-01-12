package com.baidu.live.v;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
/* loaded from: classes10.dex */
public class g {
    private AudioManager btX;
    private a btY;
    private boolean btZ;
    private boolean bua;
    private AudioManager.OnAudioFocusChangeListener bub = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.v.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.btY != null) {
                        g.this.btY.cC(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.btY != null) {
                        g.this.btY.cC(false);
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
                    if (g.this.btY != null) {
                        g.this.btY.cC(true);
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
            if (this.btX == null) {
                this.btX = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.btX != null) {
                try {
                    setFocus(this.btX.requestAudioFocus(this.bub, 3, 1) == 1);
                    cE(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.btZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.btZ = z;
    }

    private void cE(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.bua = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.bua + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.btX == null) {
                this.btX = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.btX != null) {
                cE(false);
                try {
                    setFocus(false);
                    this.btX.abandonAudioFocus(this.bub);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.btY = aVar;
    }
}
