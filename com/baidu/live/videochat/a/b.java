package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes4.dex */
public class b {
    private LivePlayer buG;
    private com.baidu.live.q.b buH;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.q.b bVar) {
        this.buH = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.buG == null) {
            this.buG = new LivePlayer(this.mActivity);
            this.buG.setIPlayerCallBack(new com.baidu.live.q.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.q.b
                public void dH(int i) {
                    if (b.this.buH != null) {
                        b.this.buH.dH(i);
                    }
                }
            });
        }
        this.buG.c(alaLiveInfoData);
    }

    public void Qz() {
        if (this.buG != null) {
            this.buG.setIPlayerCallBack(null);
            this.buG.ci(true);
            this.buG.destroy();
            this.buG = null;
        }
    }

    public boolean isStarted() {
        return this.buG != null;
    }

    public View Qu() {
        if (this.buG != null) {
            return this.buG.getLivePlayer();
        }
        return null;
    }
}
