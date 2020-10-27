package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes4.dex */
public class b {
    private LivePlayer bBE;
    private com.baidu.live.r.b bBF;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.r.b bVar) {
        this.bBF = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bBE == null) {
            this.bBE = new LivePlayer(this.mActivity);
            this.bBE.setIPlayerCallBack(new com.baidu.live.r.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.r.b
                public void dM(int i) {
                    if (b.this.bBF != null) {
                        b.this.bBF.dM(i);
                    }
                }
            });
        }
        this.bBE.c(alaLiveInfoData);
    }

    public void SW() {
        if (this.bBE != null) {
            this.bBE.setIPlayerCallBack(null);
            this.bBE.cn(true);
            this.bBE.destroy();
            this.bBE = null;
        }
    }

    public boolean isStarted() {
        return this.bBE != null;
    }

    public View SR() {
        if (this.bBE != null) {
            return this.bBE.getLivePlayer();
        }
        return null;
    }
}
