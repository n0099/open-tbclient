package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.r;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b {
    private a bcA;
    private int bcB;
    private AlaSmallGiftView bcy;
    private c bcz;
    private AlaSmallGiftView.a aZy = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void HV() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.bcA != null) {
                b.this.bcA.u(b.this.bcz);
            }
            b.this.bcz = null;
            if (b.this.bcA != null) {
                b.this.bcA.Jc();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void HW() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Jj();
                    return false;
                case 2:
                    b.this.Jt();
                    return false;
                case 3:
                    b.this.Jk();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable bcC = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bcz != null) {
                if (System.currentTimeMillis() - b.this.bcz.HE() < b.this.bcB || b.this.bcz.aYu < b.this.bcz.aYt) {
                    b.this.mHandler.postDelayed(b.this.bcC, 1000L);
                    return;
                }
                b.this.mHandler.removeMessages(2);
                b.this.mHandler.removeMessages(1);
                b.this.mHandler.sendEmptyMessage(3);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Jc();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.bcy = alaSmallGiftView;
        this.bcy.setSmallAnimCallBack(this.aZy);
    }

    public boolean isReady() {
        return this.bcz == null;
    }

    public boolean Jq() {
        if (this.bcz == null || StringUtils.isNull(this.bcz.userId)) {
            return false;
        }
        return this.bcz.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.bcz == null || cVar.priority <= this.bcz.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.bcy == null || this.bcy.getVisibility() == 0 || this.bcz != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.bcz = cVar;
        Jr();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.bcC, 1000L);
        return true;
    }

    public void y(c cVar) {
        Js();
        if (this.bcA != null) {
            this.bcA.v(this.bcz);
            this.bcz = null;
        }
        this.bcz = cVar;
        Jr();
        this.bcy.setVisibility(0);
        this.bcy.setTag(this.bcz.HG());
        this.bcy.setData(this.bcz, false);
        this.mHandler.postDelayed(this.bcC, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Jr() {
        this.bcB = this.bcz.aYt > 10 ? 6000 : 3000;
    }

    public void FM() {
        if (this.bcz != null) {
            Js();
            this.bcy.setVisibility(4);
            r.g(this.bcz);
            if (this.bcA != null) {
                this.bcA.v(this.bcz);
                this.bcz = null;
            }
        }
    }

    public void FN() {
        if (this.bcA != null) {
            this.bcA.Jc();
        }
    }

    public void onDestroy() {
        Js();
        if (this.bcy != null) {
            this.bcy.onDestroy();
        }
    }

    private void Js() {
        this.mHandler.removeCallbacks(this.bcC);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.bcz == null || StringUtils.isNull(this.bcz.userId) || StringUtils.isNull(this.bcz.giftId) || !com.baidu.live.gift.smallgift.a.c(this.bcz, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.bcz, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj() {
        if (this.bcz != null) {
            this.bcy.setVisibility(0);
            this.bcy.setTag(this.bcz.HG());
            this.bcy.setData(this.bcz, false);
            this.bcy.Jj();
            Jt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk() {
        if (this.bcz != null) {
            r.g(this.bcz);
        }
        this.bcy.Jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        long j;
        if (this.bcy.getVisibility() == 0) {
            this.bcy.clearAnimation();
            if (this.bcz != null) {
                if (this.bcz.aYu >= this.bcz.aYt) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.bcz.af(System.currentTimeMillis());
                boolean z = this.bcz.aYt > 10;
                c cVar = this.bcz;
                if (z) {
                    j = this.bcz.aYt;
                } else {
                    c cVar2 = this.bcz;
                    j = cVar2.aYu + 1;
                    cVar2.aYu = j;
                }
                cVar.aYu = j;
                this.bcy.f(this.bcz.aYt, this.bcz.aYu);
            }
        }
    }

    public void GM() {
        if (this.bcz != null && this.bcz.aYt == this.bcz.aYu) {
            this.mHandler.postDelayed(this.bcC, 1000L);
        }
    }

    public void a(a aVar) {
        this.bcA = aVar;
    }
}
