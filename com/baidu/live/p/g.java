package com.baidu.live.p;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes7.dex */
public class g {
    private AudioManager bgN;
    private a bgO;
    private boolean bgP;
    private AudioManager.OnAudioFocusChangeListener bgQ = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.p.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                case -1:
                    if (g.this.bgO != null) {
                        g.this.bgO.cg(false);
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
                    if (g.this.bgO != null) {
                        g.this.bgO.cg(true);
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
            if (this.bgN == null) {
                this.bgN = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bgN != null) {
                try {
                    this.bgP = this.bgN.requestAudioFocus(this.bgQ, 3, 1) == 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void abandonAudioFocus() {
        if (this.mContext != null) {
            if (this.bgN == null) {
                this.bgN = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bgN != null) {
                this.bgN.abandonAudioFocus(this.bgQ);
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bgO = aVar;
    }
}
