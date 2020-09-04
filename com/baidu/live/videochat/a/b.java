package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes7.dex */
public class b {
    private LivePlayer brr;
    private com.baidu.live.p.b brs;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.p.b bVar) {
        this.brs = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.brr == null) {
            this.brr = new LivePlayer(this.mActivity);
            this.brr.setIPlayerCallBack(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.p.b
                public void dD(int i) {
                    if (b.this.brs != null) {
                        b.this.brs.dD(i);
                    }
                }
            });
        }
        this.brr.c(alaLiveInfoData);
    }

    public void PR() {
        if (this.brr != null) {
            this.brr.setIPlayerCallBack(null);
            this.brr.ch(true);
            this.brr.destroy();
            this.brr = null;
        }
    }

    public boolean isStarted() {
        return this.brr != null;
    }

    public View PM() {
        if (this.brr != null) {
            return this.brr.getLivePlayer();
        }
        return null;
    }
}
