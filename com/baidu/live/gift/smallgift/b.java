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
    private AlaSmallGiftView aQc;
    private c aQd;
    private a aQe;
    private int aQf;
    private AlaSmallGiftView.a aNn = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void At() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void O(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.aQe != null) {
                b.this.aQe.u(b.this.aQd);
            }
            b.this.aQd = null;
            if (b.this.aQe != null) {
                b.this.aQe.By();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Au() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.BF();
                    return false;
                case 2:
                    b.this.BP();
                    return false;
                case 3:
                    b.this.BG();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aQg = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aQd != null) {
                if (System.currentTimeMillis() - b.this.aQd.Ad() < b.this.aQf || b.this.aQd.aMn < b.this.aQd.aMm) {
                    b.this.mHandler.postDelayed(b.this.aQg, 1000L);
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
        void By();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aQc = alaSmallGiftView;
        this.aQc.setSmallAnimCallBack(this.aNn);
    }

    public boolean isReady() {
        return this.aQd == null;
    }

    public boolean BM() {
        if (this.aQd == null || StringUtils.isNull(this.aQd.userId)) {
            return false;
        }
        return this.aQd.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.aQd == null || cVar.priority <= this.aQd.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.aQc == null || this.aQc.getVisibility() == 0 || this.aQd != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.aQd = cVar;
        BN();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aQg, 1000L);
        return true;
    }

    public void y(c cVar) {
        BO();
        if (this.aQe != null) {
            this.aQe.v(this.aQd);
            this.aQd = null;
        }
        this.aQd = cVar;
        BN();
        this.aQc.setVisibility(0);
        this.aQc.setTag(this.aQd.Af());
        this.aQc.setData(this.aQd, false);
        this.mHandler.postDelayed(this.aQg, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void BN() {
        this.aQf = this.aQd.aMm > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void yu() {
        if (this.aQd != null) {
            BO();
            this.aQc.setVisibility(4);
            r.g(this.aQd);
            if (this.aQe != null) {
                this.aQe.v(this.aQd);
                this.aQd = null;
            }
        }
    }

    public void yv() {
        if (this.aQe != null) {
            this.aQe.By();
        }
    }

    public void onDestroy() {
        BO();
        if (this.aQc != null) {
            this.aQc.onDestroy();
        }
    }

    private void BO() {
        this.mHandler.removeCallbacks(this.aQg);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.aQd == null || StringUtils.isNull(this.aQd.userId) || StringUtils.isNull(this.aQd.giftId) || !com.baidu.live.gift.smallgift.a.c(this.aQd, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.aQd, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BF() {
        if (this.aQd != null) {
            this.aQc.setVisibility(0);
            this.aQc.setTag(this.aQd.Af());
            this.aQc.setData(this.aQd, false);
            this.aQc.BF();
            BP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BG() {
        if (this.aQd != null) {
            r.g(this.aQd);
        }
        this.aQc.BG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP() {
        long j;
        if (this.aQc.getVisibility() == 0) {
            this.aQc.clearAnimation();
            if (this.aQd != null) {
                if (this.aQd.aMn >= this.aQd.aMm) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aQd.ad(System.currentTimeMillis());
                boolean z = this.aQd.aMm > 10;
                c cVar = this.aQd;
                if (z) {
                    j = this.aQd.aMm;
                } else {
                    c cVar2 = this.aQd;
                    j = cVar2.aMn + 1;
                    cVar2.aMn = j;
                }
                cVar.aMn = j;
                this.aQc.f(this.aQd.aMm, this.aQd.aMn);
            }
        }
    }

    public void zl() {
        if (this.aQd != null && this.aQd.aMm == this.aQd.aMn) {
            this.mHandler.postDelayed(this.aQg, 1000L);
        }
    }

    public void a(a aVar) {
        this.aQe = aVar;
    }
}
