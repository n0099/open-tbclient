package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes11.dex */
public class b {
    private LivePlayer bPU;
    private com.baidu.live.v.b bPV;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.v.b bVar) {
        this.bPV = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bPU == null) {
            this.bPU = new LivePlayer(this.mActivity);
            this.bPU.setIPlayerCallBack(new com.baidu.live.v.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.v.b
                public void dY(int i) {
                    if (b.this.bPV != null) {
                        b.this.bPV.dY(i);
                    }
                }
            });
        }
        this.bPU.c(alaLiveInfoData);
    }

    public void Yz() {
        if (this.bPU != null) {
            this.bPU.setIPlayerCallBack(null);
            this.bPU.cH(true);
            this.bPU.destroy();
            this.bPU = null;
        }
    }

    public boolean isStarted() {
        return this.bPU != null;
    }

    public View Yx() {
        if (this.bPU != null) {
            return this.bPU.getLivePlayer();
        }
        return null;
    }
}
