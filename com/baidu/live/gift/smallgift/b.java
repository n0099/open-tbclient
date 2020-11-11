package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b {
    private AlaSmallGiftView bfi;
    private c bfj;
    private a bfk;
    private int bfl;
    private AlaSmallGiftView.a bco = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void IR() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.bfk != null) {
                b.this.bfk.u(b.this.bfj);
            }
            b.this.bfj = null;
            if (b.this.bfk != null) {
                b.this.bfk.JV();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void IS() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Kc();
                    return false;
                case 2:
                    b.this.Km();
                    return false;
                case 3:
                    b.this.Kd();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable bfm = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bfj != null) {
                if (System.currentTimeMillis() - b.this.bfj.IA() < b.this.bfl || b.this.bfj.bbj < b.this.bfj.bbi) {
                    b.this.mHandler.postDelayed(b.this.bfm, 1000L);
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
        void JV();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.bfi = alaSmallGiftView;
        this.bfi.setSmallAnimCallBack(this.bco);
    }

    public boolean isReady() {
        return this.bfj == null;
    }

    public boolean Kj() {
        if (this.bfj == null || StringUtils.isNull(this.bfj.userId)) {
            return false;
        }
        return this.bfj.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.bfj == null || cVar.priority <= this.bfj.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.bfi == null || this.bfi.getVisibility() == 0 || this.bfj != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.bfj = cVar;
        Kk();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.bfm, 1000L);
        return true;
    }

    public void y(c cVar) {
        Kl();
        if (this.bfk != null) {
            this.bfk.v(this.bfj);
            this.bfj = null;
        }
        this.bfj = cVar;
        Kk();
        this.bfi.setVisibility(0);
        this.bfi.setTag(this.bfj.IC());
        this.bfi.setData(this.bfj, false);
        this.mHandler.postDelayed(this.bfm, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Kk() {
        this.bfl = this.bfj.bbi > 10 ? 6000 : 3000;
    }

    public void GC() {
        if (this.bfj != null) {
            Kl();
            this.bfi.setVisibility(4);
            v.g(this.bfj);
            if (this.bfk != null) {
                this.bfk.v(this.bfj);
                this.bfj = null;
            }
        }
    }

    public void GD() {
        if (this.bfk != null) {
            this.bfk.JV();
        }
    }

    public void onDestroy() {
        Kl();
        if (this.bfi != null) {
            this.bfi.onDestroy();
        }
    }

    private void Kl() {
        this.mHandler.removeCallbacks(this.bfm);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.bfj == null || StringUtils.isNull(this.bfj.userId) || StringUtils.isNull(this.bfj.giftId) || !com.baidu.live.gift.smallgift.a.c(this.bfj, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.bfj, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc() {
        if (this.bfj != null) {
            this.bfi.setVisibility(0);
            this.bfi.setTag(this.bfj.IC());
            this.bfi.setData(this.bfj, false);
            this.bfi.Kc();
            Km();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd() {
        if (this.bfj != null) {
            v.g(this.bfj);
        }
        this.bfi.Kd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        long j;
        if (this.bfi.getVisibility() == 0) {
            this.bfi.clearAnimation();
            if (this.bfj != null) {
                if (this.bfj.bbj >= this.bfj.bbi) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.bfj.as(System.currentTimeMillis());
                boolean z = this.bfj.bbi > 10;
                c cVar = this.bfj;
                if (z) {
                    j = this.bfj.bbi;
                } else {
                    c cVar2 = this.bfj;
                    j = cVar2.bbj + 1;
                    cVar2.bbj = j;
                }
                cVar.bbj = j;
                this.bfi.f(this.bfj.bbi, this.bfj.bbj);
            }
        }
    }

    public void HJ() {
        if (this.bfj != null && this.bfj.bbi == this.bfj.bbj) {
            this.mHandler.postDelayed(this.bfm, 1000L);
        }
    }

    public void a(a aVar) {
        this.bfk = aVar;
    }
}
