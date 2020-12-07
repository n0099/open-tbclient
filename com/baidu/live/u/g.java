package com.baidu.live.u;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
/* loaded from: classes4.dex */
public class g {
    private AudioManager btY;
    private a btZ;
    private boolean bua;
    private boolean bub;
    private AudioManager.OnAudioFocusChangeListener buc = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.u.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.btZ != null) {
                        g.this.btZ.cD(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.btZ != null) {
                        g.this.btZ.cD(false);
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
                    if (g.this.btZ != null) {
                        g.this.btZ.cD(true);
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
            if (this.btY == null) {
                this.btY = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.btY != null) {
                try {
                    setFocus(this.btY.requestAudioFocus(this.buc, 3, 1) == 1);
                    cF(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.bua;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setFocus=" + z);
        }
        this.bua = z;
    }

    private void cF(boolean z) {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "setIsAudioRequest=" + z);
        }
        this.bub = z;
    }

    public void abandonAudioFocus() {
        if (com.baidu.live.liveroom.e.h.isDebug()) {
            Log.d("LiveAudioFocus", "abandonAudioFocus mContext=" + this.mContext + "mIsAudioRequest=" + this.bub + "focus=" + hasFocus());
        }
        if (this.mContext != null) {
            if (this.btY == null) {
                this.btY = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.btY != null) {
                cF(false);
                try {
                    setFocus(false);
                    this.btY.abandonAudioFocus(this.buc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.btZ = aVar;
    }
}
