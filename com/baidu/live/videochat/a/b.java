package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes4.dex */
public class b {
    private LivePlayer byI;
    private com.baidu.live.q.b byJ;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.q.b bVar) {
        this.byJ = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.byI == null) {
            this.byI = new LivePlayer(this.mActivity);
            this.byI.setIPlayerCallBack(new com.baidu.live.q.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.q.b
                public void dM(int i) {
                    if (b.this.byJ != null) {
                        b.this.byJ.dM(i);
                    }
                }
            });
        }
        this.byI.c(alaLiveInfoData);
    }

    public void RW() {
        if (this.byI != null) {
            this.byI.setIPlayerCallBack(null);
            this.byI.cl(true);
            this.byI.destroy();
            this.byI = null;
        }
    }

    public boolean isStarted() {
        return this.byI != null;
    }

    public View RR() {
        if (this.byI != null) {
            return this.byI.getLivePlayer();
        }
        return null;
    }
}
