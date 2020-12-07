package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes4.dex */
public class b {
    private LivePlayer bLh;
    private com.baidu.live.u.b bLi;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.u.b bVar) {
        this.bLi = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bLh == null) {
            this.bLh = new LivePlayer(this.mActivity);
            this.bLh.setIPlayerCallBack(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.u.b
                public void eb(int i) {
                    if (b.this.bLi != null) {
                        b.this.bLi.eb(i);
                    }
                }
            });
        }
        this.bLh.c(alaLiveInfoData);
    }

    public void Xt() {
        if (this.bLh != null) {
            this.bLh.setIPlayerCallBack(null);
            this.bLh.cE(true);
            this.bLh.destroy();
            this.bLh = null;
        }
    }

    public boolean isStarted() {
        return this.bLh != null;
    }

    public View Xr() {
        if (this.bLh != null) {
            return this.bLh.getLivePlayer();
        }
        return null;
    }
}
