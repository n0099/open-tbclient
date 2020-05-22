package com.baidu.live.o;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes3.dex */
public class g {
    private AudioManager aYA;
    private a aYB;
    private AudioManager.OnAudioFocusChangeListener aYC = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.o.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                case -1:
                    if (g.this.aYB != null) {
                        g.this.aYB.bV(false);
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
                    if (g.this.aYB != null) {
                        g.this.aYB.bV(true);
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

    public void FQ() {
        if (this.mContext != null) {
            if (this.aYA == null) {
                this.aYA = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.aYA != null) {
                try {
                    this.aYA.requestAudioFocus(this.aYC, 3, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void FR() {
        if (this.mContext != null) {
            if (this.aYA == null) {
                this.aYA = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.aYA != null) {
                this.aYA.abandonAudioFocus(this.aYC);
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.aYB = aVar;
    }
}
