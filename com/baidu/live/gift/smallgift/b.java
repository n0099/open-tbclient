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
    private AlaSmallGiftView aev;
    private d aew;
    private a aex;
    private int aey;
    private AlaSmallGiftView.a abZ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void qT() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void K(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.aew = null;
            if (b.this.aex != null) {
                b.this.aex.rI();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void qU() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.rO();
                    return false;
                case 2:
                    b.this.rZ();
                    return false;
                case 3:
                    b.this.rP();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aez = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aew != null) {
                if (System.currentTimeMillis() - b.this.aew.qD() < b.this.aey || b.this.aew.aaX < b.this.aew.aaW) {
                    b.this.mHandler.postDelayed(b.this.aez, 1000L);
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

        void rI();
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aev = alaSmallGiftView;
        this.aev.setSmallAnimCallBack(this.abZ);
    }

    public boolean isReady() {
        return this.aew == null;
    }

    public boolean rW() {
        if (this.aew == null || StringUtils.isNull(this.aew.userId)) {
            return false;
        }
        return this.aew.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean q(d dVar) {
        return (dVar == null || this.aew == null || dVar.priority <= this.aew.priority) ? false : true;
    }

    public boolean r(d dVar) {
        if (this.aev == null || this.aev.getVisibility() == 0 || this.aew != null || dVar == null || StringUtils.isNull(dVar.userId) || StringUtils.isNull(dVar.giftId)) {
            return false;
        }
        this.aew = dVar;
        rX();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aez, 1000L);
        return true;
    }

    public void s(d dVar) {
        rY();
        if (this.aex != null) {
            this.aex.p(this.aew);
            this.aew = null;
        }
        this.aew = dVar;
        rX();
        this.aev.setVisibility(0);
        this.aev.setTag(this.aew.qF());
        this.aev.setData(this.aew);
        this.mHandler.postDelayed(this.aez, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void rX() {
        this.aey = this.aew.aaW > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void pw() {
        if (this.aew != null) {
            rY();
            this.aev.setVisibility(4);
            if (this.aex != null) {
                this.aex.p(this.aew);
                this.aew = null;
            }
        }
    }

    public void px() {
        if (this.aex != null) {
            this.aex.rI();
        }
    }

    public void onDestroy() {
        rY();
        if (this.aev != null) {
            this.aev.onDestroy();
        }
    }

    private void rY() {
        this.mHandler.removeCallbacks(this.aez);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean t(d dVar) {
        if (this.aew == null || StringUtils.isNull(this.aew.userId) || StringUtils.isNull(this.aew.giftId) || !a(this.aew, dVar)) {
            return false;
        }
        b(this.aew, dVar);
        return true;
    }

    private boolean a(d dVar, d dVar2) {
        return dVar != null && !StringUtils.isNull(dVar.aaS) && dVar.aaS.equals(dVar2.aaS) && Math.abs(dVar2.qD() - dVar.qD()) <= 3000 && dVar2.aaW <= 10;
    }

    private void b(d dVar, d dVar2) {
        dVar.aaW += dVar2.aaW;
        dVar.z(dVar2.qD());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO() {
        if (this.aew != null) {
            this.aev.setVisibility(0);
            this.aev.setTag(this.aew.qF());
            this.aev.setData(this.aew);
            this.aev.rO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP() {
        this.aev.rP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        long j;
        if (this.aev.getVisibility() == 0) {
            this.aev.clearAnimation();
            if (this.aew != null) {
                if (this.aew.aaX >= this.aew.aaW) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aew.z(System.currentTimeMillis());
                boolean z = this.aew.aaW > 10;
                d dVar = this.aew;
                if (z) {
                    j = this.aew.aaW;
                } else {
                    d dVar2 = this.aew;
                    j = dVar2.aaX + 1;
                    dVar2.aaX = j;
                }
                dVar.aaX = j;
                this.aev.e(this.aew.aaW, this.aew.aaX);
            }
        }
    }

    public void pZ() {
        if (this.aew != null && this.aew.aaW == this.aew.aaX) {
            this.mHandler.postDelayed(this.aez, 1000L);
        }
    }

    public void a(a aVar) {
        this.aex = aVar;
    }
}
