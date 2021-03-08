package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.gift.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class b {
    private AlaSmallGiftView biX;
    private c biY;
    private a biZ;
    private int bja;
    private AlaSmallGiftView.a bfJ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void GZ() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.biZ != null) {
                b.this.biZ.v(b.this.biY);
            }
            b.this.biY = null;
            if (b.this.biZ != null) {
                b.this.biZ.Ik();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Ha() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Ir();
                    return false;
                case 2:
                    b.this.IB();
                    return false;
                case 3:
                    b.this.Is();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable bjb = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.biY != null) {
                if (System.currentTimeMillis() - b.this.biY.GI() < b.this.bja || b.this.biY.bew < b.this.biY.bev) {
                    b.this.mHandler.postDelayed(b.this.bjb, 1000L);
                    return;
                }
                b.this.mHandler.removeMessages(2);
                b.this.mHandler.removeMessages(1);
                b.this.mHandler.sendEmptyMessage(3);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void Ik();

        void v(c cVar);

        void w(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.biX = alaSmallGiftView;
        this.biX.setSmallAnimCallBack(this.bfJ);
    }

    public boolean isReady() {
        return this.biY == null;
    }

    public boolean Iy() {
        if (this.biY == null || StringUtils.isNull(this.biY.userId)) {
            return false;
        }
        return this.biY.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean x(c cVar) {
        return (cVar == null || this.biY == null || cVar.priority <= this.biY.priority) ? false : true;
    }

    public boolean y(c cVar) {
        if (this.biX == null || this.biX.getVisibility() == 0 || this.biY != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.biY = cVar;
        Iz();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.bjb, 1000L);
        return true;
    }

    public void z(c cVar) {
        IA();
        if (this.biZ != null) {
            this.biZ.w(this.biY);
            this.biY = null;
        }
        this.biY = cVar;
        Iz();
        this.biX.setVisibility(0);
        this.biX.setTag(this.biY.GK());
        this.biX.setData(this.biY, false);
        this.mHandler.postDelayed(this.bjb, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Iz() {
        this.bja = this.biY.bev > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void EH() {
        if (this.biY != null) {
            IA();
            this.biX.setVisibility(4);
            w.g(this.biY);
            if (this.biZ != null) {
                this.biZ.w(this.biY);
                this.biY = null;
            }
        }
    }

    public void EI() {
        if (this.biZ != null) {
            this.biZ.Ik();
        }
    }

    public void onDestroy() {
        IA();
        if (this.biX != null) {
            this.biX.onDestroy();
        }
    }

    private void IA() {
        this.mHandler.removeCallbacks(this.bjb);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean A(c cVar) {
        if (this.biY == null || StringUtils.isNull(this.biY.userId) || StringUtils.isNull(this.biY.giftId) || !com.baidu.live.gift.smallgift.a.c(this.biY, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.biY, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir() {
        if (this.biY != null) {
            this.biX.setVisibility(0);
            this.biX.setTag(this.biY.GK());
            this.biX.setData(this.biY, false);
            this.biX.Ir();
            IB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Is() {
        if (this.biY != null) {
            w.g(this.biY);
        }
        this.biX.Is();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IB() {
        long j;
        if (this.biX.getVisibility() == 0) {
            this.biX.clearAnimation();
            if (this.biY != null) {
                if (this.biY.bew >= this.biY.bev) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.biY.aS(System.currentTimeMillis());
                boolean z = this.biY.bev > 10;
                c cVar = this.biY;
                if (z) {
                    j = this.biY.bev;
                } else {
                    c cVar2 = this.biY;
                    j = cVar2.bew + 1;
                    cVar2.bew = j;
                }
                cVar.bew = j;
                this.biX.i(this.biY.bev, this.biY.bew);
            }
        }
    }

    public void FQ() {
        if (this.biY != null && this.biY.bev == this.biY.bew) {
            this.mHandler.postDelayed(this.bjb, 1000L);
        }
    }

    public void a(a aVar) {
        this.biZ = aVar;
    }
}
