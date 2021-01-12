package com.baidu.live.videochat.a;

import android.app.Activity;
import android.view.View;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.videochat.player.LivePlayer;
/* loaded from: classes10.dex */
public class b {
    private LivePlayer bLi;
    private com.baidu.live.v.b bLj;
    private Activity mActivity;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.live.v.b bVar) {
        this.bLj = bVar;
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (this.bLi == null) {
            this.bLi = new LivePlayer(this.mActivity);
            this.bLi.setIPlayerCallBack(new com.baidu.live.v.b() { // from class: com.baidu.live.videochat.a.b.1
                @Override // com.baidu.live.v.b
                public void cs(int i) {
                    if (b.this.bLj != null) {
                        b.this.bLj.cs(i);
                    }
                }
            });
        }
        this.bLi.c(alaLiveInfoData);
    }

    public void UH() {
        if (this.bLi != null) {
            this.bLi.setIPlayerCallBack(null);
            this.bLi.cD(true);
            this.bLi.destroy();
            this.bLi = null;
        }
    }

    public boolean isStarted() {
        return this.bLi != null;
    }

    public View UF() {
        if (this.bLi != null) {
            return this.bLi.getLivePlayer();
        }
        return null;
    }
}
