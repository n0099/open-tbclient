package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes11.dex */
public class b {
    private LivePlayer bOS;
    private com.baidu.live.u.b bOT;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.u.b bVar) {
        this.bOT = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bOS == null) {
            this.bOS = new LivePlayer(this.mActivity);
            this.bOS.setIPlayerCallBack(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.u.b
                public void cv(int i) {
                    if (b.this.bOT != null) {
                        b.this.bOT.cv(i);
                    }
                }
            });
        }
        this.bOS.c(alaLiveInfoData);
    }

    public void Wq() {
        if (this.bOS != null) {
            this.bOS.setIPlayerCallBack(null);
            this.bOS.cM(true);
            this.bOS.destroy();
            this.bOS = null;
        }
    }

    public boolean isStarted() {
        return this.bOS != null;
    }

    public View Wo() {
        if (this.bOS != null) {
            return this.bOS.getLivePlayer();
        }
        return null;
    }
}
