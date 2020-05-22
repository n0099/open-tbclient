package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.r;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {
    private AlaSmallGiftView aNw;
    private c aNx;
    private a aNy;
    private int aNz;
    private AlaSmallGiftView.a aKH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void zT() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void O(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.aNy != null) {
                b.this.aNy.u(b.this.aNx);
            }
            b.this.aNx = null;
            if (b.this.aNy != null) {
                b.this.aNy.AY();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void zU() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Bf();
                    return false;
                case 2:
                    b.this.Bp();
                    return false;
                case 3:
                    b.this.Bg();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aNA = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aNx != null) {
                if (System.currentTimeMillis() - b.this.aNx.zD() < b.this.aNz || b.this.aNx.aJH < b.this.aNx.aJG) {
                    b.this.mHandler.postDelayed(b.this.aNA, 1000L);
                    return;
                }
                b.this.mHandler.removeMessages(2);
                b.this.mHandler.removeMessages(1);
                b.this.mHandler.sendEmptyMessage(3);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void AY();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aNw = alaSmallGiftView;
        this.aNw.setSmallAnimCallBack(this.aKH);
    }

    public boolean isReady() {
        return this.aNx == null;
    }

    public boolean Bm() {
        if (this.aNx == null || StringUtils.isNull(this.aNx.userId)) {
            return false;
        }
        return this.aNx.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.aNx == null || cVar.priority <= this.aNx.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.aNw == null || this.aNw.getVisibility() == 0 || this.aNx != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.aNx = cVar;
        Bn();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aNA, 1000L);
        return true;
    }

    public void y(c cVar) {
        Bo();
        if (this.aNy != null) {
            this.aNy.v(this.aNx);
            this.aNx = null;
        }
        this.aNx = cVar;
        Bn();
        this.aNw.setVisibility(0);
        this.aNw.setTag(this.aNx.zF());
        this.aNw.setData(this.aNx, false);
        this.mHandler.postDelayed(this.aNA, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Bn() {
        this.aNz = this.aNx.aJG > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void xU() {
        if (this.aNx != null) {
            Bo();
            this.aNw.setVisibility(4);
            r.g(this.aNx);
            if (this.aNy != null) {
                this.aNy.v(this.aNx);
                this.aNx = null;
            }
        }
    }

    public void xV() {
        if (this.aNy != null) {
            this.aNy.AY();
        }
    }

    public void onDestroy() {
        Bo();
        if (this.aNw != null) {
            this.aNw.onDestroy();
        }
    }

    private void Bo() {
        this.mHandler.removeCallbacks(this.aNA);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.aNx == null || StringUtils.isNull(this.aNx.userId) || StringUtils.isNull(this.aNx.giftId) || !com.baidu.live.gift.smallgift.a.c(this.aNx, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.aNx, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf() {
        if (this.aNx != null) {
            this.aNw.setVisibility(0);
            this.aNw.setTag(this.aNx.zF());
            this.aNw.setData(this.aNx, false);
            this.aNw.Bf();
            Bp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg() {
        if (this.aNx != null) {
            r.g(this.aNx);
        }
        this.aNw.Bg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bp() {
        long j;
        if (this.aNw.getVisibility() == 0) {
            this.aNw.clearAnimation();
            if (this.aNx != null) {
                if (this.aNx.aJH >= this.aNx.aJG) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aNx.ad(System.currentTimeMillis());
                boolean z = this.aNx.aJG > 10;
                c cVar = this.aNx;
                if (z) {
                    j = this.aNx.aJG;
                } else {
                    c cVar2 = this.aNx;
                    j = cVar2.aJH + 1;
                    cVar2.aJH = j;
                }
                cVar.aJH = j;
                this.aNw.f(this.aNx.aJG, this.aNx.aJH);
            }
        }
    }

    public void yL() {
        if (this.aNx != null && this.aNx.aJG == this.aNx.aJH) {
            this.mHandler.postDelayed(this.aNA, 1000L);
        }
    }

    public void a(a aVar) {
        this.aNy = aVar;
    }
}
