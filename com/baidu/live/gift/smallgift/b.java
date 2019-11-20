package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class b {
    private AlaSmallGiftView aed;
    private d aee;
    private a aef;
    private int aeg;
    private AlaSmallGiftView.a abH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void qU() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void K(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.aee = null;
            if (b.this.aef != null) {
                b.this.aef.rJ();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void qV() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.rP();
                    return false;
                case 2:
                    b.this.sa();
                    return false;
                case 3:
                    b.this.rQ();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aeh = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aee != null) {
                if (System.currentTimeMillis() - b.this.aee.qE() < b.this.aeg || b.this.aee.aaF < b.this.aee.aaE) {
                    b.this.mHandler.postDelayed(b.this.aeh, 1000L);
                    return;
                }
                b.this.mHandler.removeMessages(2);
                b.this.mHandler.removeMessages(1);
                b.this.mHandler.sendEmptyMessage(3);
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void p(d dVar);

        void rJ();
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aed = alaSmallGiftView;
        this.aed.setSmallAnimCallBack(this.abH);
    }

    public boolean isReady() {
        return this.aee == null;
    }

    public boolean rX() {
        if (this.aee == null || StringUtils.isNull(this.aee.userId)) {
            return false;
        }
        return this.aee.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean q(d dVar) {
        return (dVar == null || this.aee == null || dVar.priority <= this.aee.priority) ? false : true;
    }

    public boolean r(d dVar) {
        if (this.aed == null || this.aed.getVisibility() == 0 || this.aee != null || dVar == null || StringUtils.isNull(dVar.userId) || StringUtils.isNull(dVar.giftId)) {
            return false;
        }
        this.aee = dVar;
        rY();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aeh, 1000L);
        return true;
    }

    public void s(d dVar) {
        rZ();
        if (this.aef != null) {
            this.aef.p(this.aee);
            this.aee = null;
        }
        this.aee = dVar;
        rY();
        this.aed.setVisibility(0);
        this.aed.setTag(this.aee.qG());
        this.aed.setData(this.aee);
        this.mHandler.postDelayed(this.aeh, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void rY() {
        this.aeg = this.aee.aaE > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void pw() {
        if (this.aee != null) {
            rZ();
            this.aed.setVisibility(4);
            if (this.aef != null) {
                this.aef.p(this.aee);
                this.aee = null;
            }
        }
    }

    public void px() {
        if (this.aef != null) {
            this.aef.rJ();
        }
    }

    public void onDestroy() {
        rZ();
        if (this.aed != null) {
            this.aed.onDestroy();
        }
    }

    private void rZ() {
        this.mHandler.removeCallbacks(this.aeh);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean t(d dVar) {
        if (this.aee == null || StringUtils.isNull(this.aee.userId) || StringUtils.isNull(this.aee.giftId) || !b(this.aee, dVar)) {
            return false;
        }
        c(this.aee, dVar);
        return true;
    }

    private boolean b(d dVar, d dVar2) {
        return dVar != null && !StringUtils.isNull(dVar.aaA) && dVar.aaA.equals(dVar2.aaA) && Math.abs(dVar2.qE() - dVar.qE()) <= 3000 && dVar2.aaE <= 10;
    }

    private void c(d dVar, d dVar2) {
        dVar.aaE += dVar2.aaE;
        dVar.y(dVar2.qE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP() {
        if (this.aee != null) {
            this.aed.setVisibility(0);
            this.aed.setTag(this.aee.qG());
            this.aed.setData(this.aee);
            this.aed.rP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ() {
        this.aed.rQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa() {
        long j;
        if (this.aed.getVisibility() == 0) {
            this.aed.clearAnimation();
            if (this.aee != null) {
                if (this.aee.aaF >= this.aee.aaE) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aee.y(System.currentTimeMillis());
                boolean z = this.aee.aaE > 10;
                d dVar = this.aee;
                if (z) {
                    j = this.aee.aaE;
                } else {
                    d dVar2 = this.aee;
                    j = dVar2.aaF + 1;
                    dVar2.aaF = j;
                }
                dVar.aaF = j;
                this.aed.e(this.aee.aaE, this.aee.aaF);
            }
        }
    }

    public void qa() {
        if (this.aee != null && this.aee.aaE == this.aee.aaF) {
            this.mHandler.postDelayed(this.aeh, 1000L);
        }
    }

    public void a(a aVar) {
        this.aef = aVar;
    }
}
