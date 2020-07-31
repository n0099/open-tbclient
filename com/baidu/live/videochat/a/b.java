package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes4.dex */
public class b {
    private LivePlayer blI;
    private com.baidu.live.p.b blJ;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.p.b bVar) {
        this.blJ = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.blI == null) {
            this.blI = new LivePlayer(this.mActivity);
            this.blI.setIPlayerCallBack(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.p.b
                public void bR(int i) {
                    if (b.this.blJ != null) {
                        b.this.blJ.bR(i);
                    }
                }
            });
        }
        this.blI.c(alaLiveInfoData);
    }

    public void JZ() {
        if (this.blI != null) {
            this.blI.setIPlayerCallBack(null);
            this.blI.bZ(true);
            this.blI.destroy();
            this.blI = null;
        }
    }

    public boolean isStarted() {
        return this.blI != null;
    }

    public View JU() {
        if (this.blI != null) {
            return this.blI.getLivePlayer();
        }
        return null;
    }
}
