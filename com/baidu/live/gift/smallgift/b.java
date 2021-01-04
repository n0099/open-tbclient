package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.gift.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class b {
    private AlaSmallGiftView bje;
    private c bjf;
    private a bjg;
    private int bjh;
    private AlaSmallGiftView.a bfQ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void JB() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.bjg != null) {
                b.this.bjg.v(b.this.bjf);
            }
            b.this.bjf = null;
            if (b.this.bjg != null) {
                b.this.bjg.KM();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void JC() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.KT();
                    return false;
                case 2:
                    b.this.Ld();
                    return false;
                case 3:
                    b.this.KU();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable bji = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bjf != null) {
                if (System.currentTimeMillis() - b.this.bjf.Jk() < b.this.bjh || b.this.bjf.beD < b.this.bjf.beC) {
                    b.this.mHandler.postDelayed(b.this.bji, 1000L);
                    return;
                }
                b.this.mHandler.removeMessages(2);
                b.this.mHandler.removeMessages(1);
                b.this.mHandler.sendEmptyMessage(3);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void KM();

        void v(c cVar);

        void w(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.bje = alaSmallGiftView;
        this.bje.setSmallAnimCallBack(this.bfQ);
    }

    public boolean isReady() {
        return this.bjf == null;
    }

    public boolean La() {
        if (this.bjf == null || StringUtils.isNull(this.bjf.userId)) {
            return false;
        }
        return this.bjf.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean x(c cVar) {
        return (cVar == null || this.bjf == null || cVar.priority <= this.bjf.priority) ? false : true;
    }

    public boolean y(c cVar) {
        if (this.bje == null || this.bje.getVisibility() == 0 || this.bjf != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.bjf = cVar;
        Lb();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.bji, 1000L);
        return true;
    }

    public void z(c cVar) {
        Lc();
        if (this.bjg != null) {
            this.bjg.w(this.bjf);
            this.bjf = null;
        }
        this.bjf = cVar;
        Lb();
        this.bje.setVisibility(0);
        this.bje.setTag(this.bjf.Jm());
        this.bje.setData(this.bjf, false);
        this.mHandler.postDelayed(this.bji, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Lb() {
        this.bjh = this.bjf.beC > 10 ? 6000 : 3000;
    }

    public void Hj() {
        if (this.bjf != null) {
            Lc();
            this.bje.setVisibility(4);
            w.g(this.bjf);
            if (this.bjg != null) {
                this.bjg.w(this.bjf);
                this.bjf = null;
            }
        }
    }

    public void Hk() {
        if (this.bjg != null) {
            this.bjg.KM();
        }
    }

    public void onDestroy() {
        Lc();
        if (this.bje != null) {
            this.bje.onDestroy();
        }
    }

    private void Lc() {
        this.mHandler.removeCallbacks(this.bji);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean A(c cVar) {
        if (this.bjf == null || StringUtils.isNull(this.bjf.userId) || StringUtils.isNull(this.bjf.giftId) || !com.baidu.live.gift.smallgift.a.c(this.bjf, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.bjf, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KT() {
        if (this.bjf != null) {
            this.bje.setVisibility(0);
            this.bje.setTag(this.bjf.Jm());
            this.bje.setData(this.bjf, false);
            this.bje.KT();
            Ld();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        if (this.bjf != null) {
            w.g(this.bjf);
        }
        this.bje.KU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        long j;
        if (this.bje.getVisibility() == 0) {
            this.bje.clearAnimation();
            if (this.bjf != null) {
                if (this.bjf.beD >= this.bjf.beC) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.bjf.aP(System.currentTimeMillis());
                boolean z = this.bjf.beC > 10;
                c cVar = this.bjf;
                if (z) {
                    j = this.bjf.beC;
                } else {
                    c cVar2 = this.bjf;
                    j = cVar2.beD + 1;
                    cVar2.beD = j;
                }
                cVar.beD = j;
                this.bje.i(this.bjf.beC, this.bjf.beD);
            }
        }
    }

    public void Is() {
        if (this.bjf != null && this.bjf.beC == this.bjf.beD) {
            this.mHandler.postDelayed(this.bji, 1000L);
        }
    }

    public void a(a aVar) {
        this.bjg = aVar;
    }
}
