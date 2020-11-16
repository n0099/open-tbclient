package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes4.dex */
public class b {
    private LivePlayer bFZ;
    private com.baidu.live.s.b bGa;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.s.b bVar) {
        this.bGa = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bFZ == null) {
            this.bFZ = new LivePlayer(this.mActivity);
            this.bFZ.setIPlayerCallBack(new com.baidu.live.s.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.s.b
                public void dI(int i) {
                    if (b.this.bGa != null) {
                        b.this.bGa.dI(i);
                    }
                }
            });
        }
        this.bFZ.c(alaLiveInfoData);
    }

    public void UT() {
        if (this.bFZ != null) {
            this.bFZ.setIPlayerCallBack(null);
            this.bFZ.cq(true);
            this.bFZ.destroy();
            this.bFZ = null;
        }
    }

    public boolean isStarted() {
        return this.bFZ != null;
    }

    public View UP() {
        if (this.bFZ != null) {
            return this.bFZ.getLivePlayer();
        }
        return null;
    }
}
