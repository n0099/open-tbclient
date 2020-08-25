package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes7.dex */
public class b {
    private LivePlayer bro;
    private com.baidu.live.p.b brp;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.p.b bVar) {
        this.brp = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bro == null) {
            this.bro = new LivePlayer(this.mActivity);
            this.bro.setIPlayerCallBack(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.p.b
                public void dD(int i) {
                    if (b.this.brp != null) {
                        b.this.brp.dD(i);
                    }
                }
            });
        }
        this.bro.c(alaLiveInfoData);
    }

    public void PR() {
        if (this.bro != null) {
            this.bro.setIPlayerCallBack(null);
            this.bro.ch(true);
            this.bro.destroy();
            this.bro = null;
        }
    }

    public boolean isStarted() {
        return this.bro != null;
    }

    public View PM() {
        if (this.bro != null) {
            return this.bro.getLivePlayer();
        }
        return null;
    }
}
