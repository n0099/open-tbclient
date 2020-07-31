package com.baidu.live.p;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes4.dex */
public class g {
    private AudioManager bbr;
    private a bbs;
    private AudioManager.OnAudioFocusChangeListener bbt = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.p.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                case -1:
                    if (g.this.bbs != null) {
                        g.this.bbs.bY(false);
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
                    if (g.this.bbs != null) {
                        g.this.bbs.bY(true);
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

    public void Gu() {
        if (this.mContext != null) {
            if (this.bbr == null) {
                this.bbr = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bbr != null) {
                try {
                    this.bbr.requestAudioFocus(this.bbt, 3, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Gv() {
        if (this.mContext != null) {
            if (this.bbr == null) {
                this.bbr = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bbr != null) {
                this.bbr.abandonAudioFocus(this.bbt);
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bbs = aVar;
    }
}
