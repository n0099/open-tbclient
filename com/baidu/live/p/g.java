package com.baidu.live.p;

import android.content.Context;
import android.media.AudioManager;
/* loaded from: classes7.dex */
public class g {
    private AudioManager bgP;
    private a bgQ;
    private boolean bgR;
    private boolean bgS;
    private AudioManager.OnAudioFocusChangeListener bgT = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.live.p.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (g.this.bgQ != null) {
                        g.this.bgQ.cg(false);
                        return;
                    }
                    return;
                case -1:
                    g.this.setFocus(false);
                    if (g.this.bgQ != null) {
                        g.this.bgQ.cg(false);
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
                    if (g.this.bgQ != null) {
                        g.this.bgQ.cg(true);
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
            if (this.bgP == null) {
                this.bgP = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bgP != null) {
                try {
                    setFocus(this.bgP.requestAudioFocus(this.bgT, 3, 1) == 1);
                    ci(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hasFocus() {
        return this.bgR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocus(boolean z) {
        this.bgR = z;
    }

    private void ci(boolean z) {
        this.bgS = z;
    }

    public void abandonAudioFocus() {
        if (this.mContext != null) {
            if (this.bgP == null) {
                this.bgP = (AudioManager) this.mContext.getSystemService("audio");
            }
            if (this.bgP != null) {
                ci(false);
                try {
                    setFocus(false);
                    this.bgP.abandonAudioFocus(this.bgT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIPlayerAudioFocusCallBack(a aVar) {
        this.bgQ = aVar;
    }
}
