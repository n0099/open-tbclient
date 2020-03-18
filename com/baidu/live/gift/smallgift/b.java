package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {
    private AlaSmallGiftView apn;
    private c apo;
    private a apq;
    private int apr;
    private AlaSmallGiftView.a amH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void uk() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void N(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.apo = null;
            if (b.this.apq != null) {
                b.this.apq.vl();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void ul() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.vs();
                    return false;
                case 2:
                    b.this.vC();
                    return false;
                case 3:
                    b.this.vt();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aps = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.apo != null) {
                if (System.currentTimeMillis() - b.this.apo.tU() < b.this.apr || b.this.apo.alM < b.this.apo.alL) {
                    b.this.mHandler.postDelayed(b.this.aps, 1000L);
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
        void p(c cVar);

        void vl();
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.apn = alaSmallGiftView;
        this.apn.setSmallAnimCallBack(this.amH);
    }

    public boolean isReady() {
        return this.apo == null;
    }

    public boolean vz() {
        if (this.apo == null || StringUtils.isNull(this.apo.userId)) {
            return false;
        }
        return this.apo.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean q(c cVar) {
        return (cVar == null || this.apo == null || cVar.priority <= this.apo.priority) ? false : true;
    }

    public boolean r(c cVar) {
        if (this.apn == null || this.apn.getVisibility() == 0 || this.apo != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.apo = cVar;
        vA();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aps, 1000L);
        return true;
    }

    public void s(c cVar) {
        vB();
        if (this.apq != null) {
            this.apq.p(this.apo);
            this.apo = null;
        }
        this.apo = cVar;
        vA();
        this.apn.setVisibility(0);
        this.apn.setTag(this.apo.tW());
        this.apn.setData(this.apo, false);
        this.mHandler.postDelayed(this.aps, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void vA() {
        this.apr = this.apo.alL > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void sl() {
        if (this.apo != null) {
            vB();
            this.apn.setVisibility(4);
            if (this.apq != null) {
                this.apq.p(this.apo);
                this.apo = null;
            }
        }
    }

    public void sm() {
        if (this.apq != null) {
            this.apq.vl();
        }
    }

    public void onDestroy() {
        vB();
        if (this.apn != null) {
            this.apn.onDestroy();
        }
    }

    private void vB() {
        this.mHandler.removeCallbacks(this.aps);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean t(c cVar) {
        if (this.apo == null || StringUtils.isNull(this.apo.userId) || StringUtils.isNull(this.apo.giftId) || !b(this.apo, cVar)) {
            return false;
        }
        c(this.apo, cVar);
        return true;
    }

    private boolean b(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.alI) && cVar.alI.equals(cVar2.alI) && Math.abs(cVar2.tU() - cVar.tU()) <= 3000 && cVar2.alL <= 10;
    }

    private void c(c cVar, c cVar2) {
        cVar.alL += cVar2.alL;
        cVar.B(cVar2.tU());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs() {
        if (this.apo != null) {
            this.apn.setVisibility(0);
            this.apn.setTag(this.apo.tW());
            this.apn.setData(this.apo, false);
            this.apn.vs();
            vC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt() {
        this.apn.vt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC() {
        long j;
        if (this.apn.getVisibility() == 0) {
            this.apn.clearAnimation();
            if (this.apo != null) {
                if (this.apo.alM >= this.apo.alL) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.apo.B(System.currentTimeMillis());
                boolean z = this.apo.alL > 10;
                c cVar = this.apo;
                if (z) {
                    j = this.apo.alL;
                } else {
                    c cVar2 = this.apo;
                    j = cVar2.alM + 1;
                    cVar2.alM = j;
                }
                cVar.alM = j;
                this.apn.e(this.apo.alL, this.apo.alM);
            }
        }
    }

    public void tf() {
        if (this.apo != null && this.apo.alL == this.apo.alM) {
            this.mHandler.postDelayed(this.aps, 1000L);
        }
    }

    public void a(a aVar) {
        this.apq = aVar;
    }
}
