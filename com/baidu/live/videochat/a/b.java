package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes3.dex */
public class b {
    private LivePlayer bgh;
    private com.baidu.live.o.b bgi;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.o.b bVar) {
        this.bgi = bVar;
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (this.bgh == null) {
            this.bgh = new LivePlayer(this.mActivity);
            this.bgh.setIPlayerCallBack(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.o.b
                public void bG(int i) {
                    if (b.this.bgi != null) {
                        b.this.bgi.bG(i);
                    }
                }
            });
        }
        this.bgh.b(alaLiveInfoData);
    }

    public void IF() {
        if (this.bgh != null) {
            this.bgh.setIPlayerCallBack(null);
            this.bgh.bW(true);
            this.bgh.destroy();
            this.bgh = null;
        }
    }

    public boolean isStarted() {
        return this.bgh != null;
    }

    public View IA() {
        if (this.bgh != null) {
            return this.bgh.getLivePlayer();
        }
        return null;
    }
}
