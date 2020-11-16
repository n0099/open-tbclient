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
    private AlaSmallGiftView bdu;
    private c bdv;
    private a bdw;
    private int bdx;
    private AlaSmallGiftView.a baD = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Ii() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.bdw != null) {
                b.this.bdw.u(b.this.bdv);
            }
            b.this.bdv = null;
            if (b.this.bdw != null) {
                b.this.bdw.Jm();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Ij() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Jt();
                    return false;
                case 2:
                    b.this.JD();
                    return false;
                case 3:
                    b.this.Ju();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable bdy = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bdv != null) {
                if (System.currentTimeMillis() - b.this.bdv.HR() < b.this.bdx || b.this.bdv.aZx < b.this.bdv.aZw) {
                    b.this.mHandler.postDelayed(b.this.bdy, 1000L);
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
        void Jm();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.bdu = alaSmallGiftView;
        this.bdu.setSmallAnimCallBack(this.baD);
    }

    public boolean isReady() {
        return this.bdv == null;
    }

    public boolean JA() {
        if (this.bdv == null || StringUtils.isNull(this.bdv.userId)) {
            return false;
        }
        return this.bdv.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.bdv == null || cVar.priority <= this.bdv.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.bdu == null || this.bdu.getVisibility() == 0 || this.bdv != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.bdv = cVar;
        JB();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.bdy, 1000L);
        return true;
    }

    public void y(c cVar) {
        JC();
        if (this.bdw != null) {
            this.bdw.v(this.bdv);
            this.bdv = null;
        }
        this.bdv = cVar;
        JB();
        this.bdu.setVisibility(0);
        this.bdu.setTag(this.bdv.HT());
        this.bdu.setData(this.bdv, false);
        this.mHandler.postDelayed(this.bdy, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void JB() {
        this.bdx = this.bdv.aZw > 10 ? 6000 : 3000;
    }

    public void FT() {
        if (this.bdv != null) {
            JC();
            this.bdu.setVisibility(4);
            v.g(this.bdv);
            if (this.bdw != null) {
                this.bdw.v(this.bdv);
                this.bdv = null;
            }
        }
    }

    public void FU() {
        if (this.bdw != null) {
            this.bdw.Jm();
        }
    }

    public void onDestroy() {
        JC();
        if (this.bdu != null) {
            this.bdu.onDestroy();
        }
    }

    private void JC() {
        this.mHandler.removeCallbacks(this.bdy);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.bdv == null || StringUtils.isNull(this.bdv.userId) || StringUtils.isNull(this.bdv.giftId) || !com.baidu.live.gift.smallgift.a.c(this.bdv, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.bdv, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        if (this.bdv != null) {
            this.bdu.setVisibility(0);
            this.bdu.setTag(this.bdv.HT());
            this.bdu.setData(this.bdv, false);
            this.bdu.Jt();
            JD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ju() {
        if (this.bdv != null) {
            v.g(this.bdv);
        }
        this.bdu.Ju();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD() {
        long j;
        if (this.bdu.getVisibility() == 0) {
            this.bdu.clearAnimation();
            if (this.bdv != null) {
                if (this.bdv.aZx >= this.bdv.aZw) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.bdv.as(System.currentTimeMillis());
                boolean z = this.bdv.aZw > 10;
                c cVar = this.bdv;
                if (z) {
                    j = this.bdv.aZw;
                } else {
                    c cVar2 = this.bdv;
                    j = cVar2.aZx + 1;
                    cVar2.aZx = j;
                }
                cVar.aZx = j;
                this.bdu.f(this.bdv.aZw, this.bdv.aZx);
            }
        }
    }

    public void Ha() {
        if (this.bdv != null && this.bdv.aZw == this.bdv.aZx) {
            this.mHandler.postDelayed(this.bdy, 1000L);
        }
    }

    public void a(a aVar) {
        this.bdw = aVar;
    }
}
