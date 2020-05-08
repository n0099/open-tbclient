package com.baidu.live.o;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes3.dex */
public class g {
    private AudioManager aRn;
    private a aRo;
    private AudioManager.OnAudioFocusChangeListener aRp = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.o.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                case -1:
                    if (g.this.aRo != null) {
                        g.this.aRo.bL(false);
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
                    if (g.this.aRo != null) {
                        g.this.aRo.bL(true);
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

    public void Ea() {
        if (this.mContext != null) {
            if (this.aRn == null) {
                this.aRn = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.aRn != null) {
                try {
                    this.aRn.requestAudioFocus(this.aRp, 3, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Eb() {
        if (this.mContext != null) {
            if (this.aRn == null) {
                this.aRn = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.aRn != null) {
                this.aRn.abandonAudioFocus(this.aRp);
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.aRo = aVar;
    }
}
