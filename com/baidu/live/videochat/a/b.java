package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes3.dex */
public class b {
    private LivePlayer aYG;
    private com.baidu.live.o.b aYH;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.o.b bVar) {
        this.aYH = bVar;
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (this.aYG == null) {
            this.aYG = new LivePlayer(this.mActivity);
            this.aYG.setIPlayerCallBack(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.o.b
                public void bx(int i) {
                    if (b.this.aYH != null) {
                        b.this.aYH.bx(i);
                    }
                }
            });
        }
        this.aYG.b(alaLiveInfoData);
    }

    public void GN() {
        if (this.aYG != null) {
            this.aYG.setIPlayerCallBack(null);
            this.aYG.bM(true);
            this.aYG.destroy();
            this.aYG = null;
        }
    }

    public boolean isStarted() {
        return this.aYG != null;
    }

    public View GI() {
        if (this.aYG != null) {
            return this.aYG.getLivePlayer();
        }
        return null;
    }
}
