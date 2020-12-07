package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.gift.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b {
    private AlaSmallGiftView bhw;
    private c bhx;
    private a bhy;
    private int bhz;
    private AlaSmallGiftView.a bed = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void JZ() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.bhy != null) {
                b.this.bhy.u(b.this.bhx);
            }
            b.this.bhx = null;
            if (b.this.bhy != null) {
                b.this.bhy.Ln();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Ka() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Lu();
                    return false;
                case 2:
                    b.this.LE();
                    return false;
                case 3:
                    b.this.Lv();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable bhA = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bhx != null) {
                if (System.currentTimeMillis() - b.this.bhx.JI() < b.this.bhz || b.this.bhx.bcV < b.this.bhx.bcU) {
                    b.this.mHandler.postDelayed(b.this.bhA, 1000L);
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
        void Ln();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.bhw = alaSmallGiftView;
        this.bhw.setSmallAnimCallBack(this.bed);
    }

    public boolean isReady() {
        return this.bhx == null;
    }

    public boolean LB() {
        if (this.bhx == null || StringUtils.isNull(this.bhx.userId)) {
            return false;
        }
        return this.bhx.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.bhx == null || cVar.priority <= this.bhx.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.bhw == null || this.bhw.getVisibility() == 0 || this.bhx != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.bhx = cVar;
        LC();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.bhA, 1000L);
        return true;
    }

    public void y(c cVar) {
        LD();
        if (this.bhy != null) {
            this.bhy.v(this.bhx);
            this.bhx = null;
        }
        this.bhx = cVar;
        LC();
        this.bhw.setVisibility(0);
        this.bhw.setTag(this.bhx.JK());
        this.bhw.setData(this.bhx, false);
        this.mHandler.postDelayed(this.bhA, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void LC() {
        this.bhz = this.bhx.bcU > 10 ? 6000 : 3000;
    }

    public void HI() {
        if (this.bhx != null) {
            LD();
            this.bhw.setVisibility(4);
            w.g(this.bhx);
            if (this.bhy != null) {
                this.bhy.v(this.bhx);
                this.bhx = null;
            }
        }
    }

    public void HJ() {
        if (this.bhy != null) {
            this.bhy.Ln();
        }
    }

    public void onDestroy() {
        LD();
        if (this.bhw != null) {
            this.bhw.onDestroy();
        }
    }

    private void LD() {
        this.mHandler.removeCallbacks(this.bhA);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.bhx == null || StringUtils.isNull(this.bhx.userId) || StringUtils.isNull(this.bhx.giftId) || !com.baidu.live.gift.smallgift.a.c(this.bhx, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.bhx, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu() {
        if (this.bhx != null) {
            this.bhw.setVisibility(0);
            this.bhw.setTag(this.bhx.JK());
            this.bhw.setData(this.bhx, false);
            this.bhw.Lu();
            LE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lv() {
        if (this.bhx != null) {
            w.g(this.bhx);
        }
        this.bhw.Lv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LE() {
        long j;
        if (this.bhw.getVisibility() == 0) {
            this.bhw.clearAnimation();
            if (this.bhx != null) {
                if (this.bhx.bcV >= this.bhx.bcU) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.bhx.aQ(System.currentTimeMillis());
                boolean z = this.bhx.bcU > 10;
                c cVar = this.bhx;
                if (z) {
                    j = this.bhx.bcU;
                } else {
                    c cVar2 = this.bhx;
                    j = cVar2.bcV + 1;
                    cVar2.bcV = j;
                }
                cVar.bcV = j;
                this.bhw.f(this.bhx.bcU, this.bhx.bcV);
            }
        }
    }

    public void IR() {
        if (this.bhx != null && this.bhx.bcU == this.bhx.bcV) {
            this.mHandler.postDelayed(this.bhA, 1000L);
        }
    }

    public void a(a aVar) {
        this.bhy = aVar;
    }
}
