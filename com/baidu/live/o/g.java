package com.baidu.live.o;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes3.dex */
public class g {
    private AudioManager axD;
    private a axE;
    private AudioManager.OnAudioFocusChangeListener axF = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.o.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                case -1:
                    if (g.this.axE != null) {
                        g.this.axE.bh(false);
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
                    if (g.this.axE != null) {
                        g.this.axE.bh(true);
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

    public void zg() {
        if (this.mContext != null) {
            if (this.axD == null) {
                this.axD = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.axD != null) {
                try {
                    this.axD.requestAudioFocus(this.axF, 3, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void zh() {
        if (this.mContext != null) {
            if (this.axD == null) {
                this.axD = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.axD != null) {
                this.axD.abandonAudioFocus(this.axF);
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.axE = aVar;
    }
}
