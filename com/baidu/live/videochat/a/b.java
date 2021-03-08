package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes10.dex */
public class b {
    private LivePlayer bQs;
    private com.baidu.live.u.b bQt;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.u.b bVar) {
        this.bQt = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bQs == null) {
            this.bQs = new LivePlayer(this.mActivity);
            this.bQs.setIPlayerCallBack(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.u.b
                public void cw(int i) {
                    if (b.this.bQt != null) {
                        b.this.bQt.cw(i);
                    }
                }
            });
        }
        this.bQs.c(alaLiveInfoData);
    }

    public void Wt() {
        if (this.bQs != null) {
            this.bQs.setIPlayerCallBack(null);
            this.bQs.cM(true);
            this.bQs.destroy();
            this.bQs = null;
        }
    }

    public boolean isStarted() {
        return this.bQs != null;
    }

    public View Wr() {
        if (this.bQs != null) {
            return this.bQs.getLivePlayer();
        }
        return null;
    }
}
