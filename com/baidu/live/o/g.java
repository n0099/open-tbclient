package com.baidu.live.o;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes3.dex */
public class g {
    private AudioManager aRi;
    private a aRj;
    private AudioManager.OnAudioFocusChangeListener aRk = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.o.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                case -1:
                    if (g.this.aRj != null) {
                        g.this.aRj.bL(false);
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
                    if (g.this.aRj != null) {
                        g.this.aRj.bL(true);
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

    public void Eb() {
        if (this.mContext != null) {
            if (this.aRi == null) {
                this.aRi = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.aRi != null) {
                try {
                    this.aRi.requestAudioFocus(this.aRk, 3, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Ec() {
        if (this.mContext != null) {
            if (this.aRi == null) {
                this.aRi = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.aRi != null) {
                this.aRi.abandonAudioFocus(this.aRk);
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.aRj = aVar;
    }
}
