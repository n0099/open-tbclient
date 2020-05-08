package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes3.dex */
public class b {
    private LivePlayer aYL;
    private com.baidu.live.o.b aYM;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.o.b bVar) {
        this.aYM = bVar;
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (this.aYL == null) {
            this.aYL = new LivePlayer(this.mActivity);
            this.aYL.setIPlayerCallBack(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.o.b
                public void bx(int i) {
                    if (b.this.aYM != null) {
                        b.this.aYM.bx(i);
                    }
                }
            });
        }
        this.aYL.b(alaLiveInfoData);
    }

    public void GM() {
        if (this.aYL != null) {
            this.aYL.setIPlayerCallBack(null);
            this.aYL.bM(true);
            this.aYL.destroy();
            this.aYL = null;
        }
    }

    public boolean isStarted() {
        return this.aYL != null;
    }

    public View GH() {
        if (this.aYL != null) {
            return this.aYL.getLivePlayer();
        }
        return null;
    }
}
