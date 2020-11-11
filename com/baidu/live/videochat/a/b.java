package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes4.dex */
public class b {
    private LivePlayer bHK;
    private com.baidu.live.s.b bHL;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.s.b bVar) {
        this.bHL = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bHK == null) {
            this.bHK = new LivePlayer(this.mActivity);
            this.bHK.setIPlayerCallBack(new com.baidu.live.s.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.s.b
                public void dM(int i) {
                    if (b.this.bHL != null) {
                        b.this.bHL.dM(i);
                    }
                }
            });
        }
        this.bHK.c(alaLiveInfoData);
    }

    public void VC() {
        if (this.bHK != null) {
            this.bHK.setIPlayerCallBack(null);
            this.bHK.co(true);
            this.bHK.destroy();
            this.bHK = null;
        }
    }

    public boolean isStarted() {
        return this.bHK != null;
    }

    public View Vy() {
        if (this.bHK != null) {
            return this.bHK.getLivePlayer();
        }
        return null;
    }
}
