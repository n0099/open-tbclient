package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes3.dex */
public class b {
    private LivePlayer blo;
    private com.baidu.live.p.b blp;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.p.b bVar) {
        this.blp = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.blo == null) {
            this.blo = new LivePlayer(this.mActivity);
            this.blo.setIPlayerCallBack(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.p.b
                public void bL(int i) {
                    if (b.this.blp != null) {
                        b.this.blp.bL(i);
                    }
                }
            });
        }
        this.blo.c(alaLiveInfoData);
    }

    public void JS() {
        if (this.blo != null) {
            this.blo.setIPlayerCallBack(null);
            this.blo.bY(true);
            this.blo.destroy();
            this.blo = null;
        }
    }

    public boolean isStarted() {
        return this.blo != null;
    }

    public View JN() {
        if (this.blo != null) {
            return this.blo.getLivePlayer();
        }
        return null;
    }
}
