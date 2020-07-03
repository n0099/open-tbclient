package com.baidu.live.p;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes3.dex */
public class g {
    private AudioManager bbt;
    private a bbu;
    private AudioManager.OnAudioFocusChangeListener bbv = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.p.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                case -1:
                    if (g.this.bbu != null) {
                        g.this.bbu.bX(false);
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
                    if (g.this.bbu != null) {
                        g.this.bbu.bX(true);
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

    public void Gz() {
        if (this.mContext != null) {
            if (this.bbt == null) {
                this.bbt = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bbt != null) {
                try {
                    this.bbt.requestAudioFocus(this.bbv, 3, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void GA() {
        if (this.mContext != null) {
            if (this.bbt == null) {
                this.bbt = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bbt != null) {
                this.bbt.abandonAudioFocus(this.bbv);
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bbu = aVar;
    }
}
