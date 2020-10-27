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
    private AlaSmallGiftView bdM;
    private c bdN;
    private a bdO;
    private int bdP;
    private AlaSmallGiftView.a baW = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Iq() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.bdO != null) {
                b.this.bdO.u(b.this.bdN);
            }
            b.this.bdN = null;
            if (b.this.bdO != null) {
                b.this.bdO.Jv();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Ir() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.JC();
                    return false;
                case 2:
                    b.this.JM();
                    return false;
                case 3:
                    b.this.JD();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable bdQ = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bdN != null) {
                if (System.currentTimeMillis() - b.this.bdN.HZ() < b.this.bdP || b.this.bdN.aZQ < b.this.bdN.aZP) {
                    b.this.mHandler.postDelayed(b.this.bdQ, 1000L);
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
        void Jv();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.bdM = alaSmallGiftView;
        this.bdM.setSmallAnimCallBack(this.baW);
    }

    public boolean isReady() {
        return this.bdN == null;
    }

    public boolean JJ() {
        if (this.bdN == null || StringUtils.isNull(this.bdN.userId)) {
            return false;
        }
        return this.bdN.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.bdN == null || cVar.priority <= this.bdN.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.bdM == null || this.bdM.getVisibility() == 0 || this.bdN != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.bdN = cVar;
        JK();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.bdQ, 1000L);
        return true;
    }

    public void y(c cVar) {
        JL();
        if (this.bdO != null) {
            this.bdO.v(this.bdN);
            this.bdN = null;
        }
        this.bdN = cVar;
        JK();
        this.bdM.setVisibility(0);
        this.bdM.setTag(this.bdN.Ib());
        this.bdM.setData(this.bdN, false);
        this.mHandler.postDelayed(this.bdQ, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void JK() {
        this.bdP = this.bdN.aZP > 10 ? 6000 : 3000;
    }

    public void Gb() {
        if (this.bdN != null) {
            JL();
            this.bdM.setVisibility(4);
            w.g(this.bdN);
            if (this.bdO != null) {
                this.bdO.v(this.bdN);
                this.bdN = null;
            }
        }
    }

    public void Gc() {
        if (this.bdO != null) {
            this.bdO.Jv();
        }
    }

    public void onDestroy() {
        JL();
        if (this.bdM != null) {
            this.bdM.onDestroy();
        }
    }

    private void JL() {
        this.mHandler.removeCallbacks(this.bdQ);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.bdN == null || StringUtils.isNull(this.bdN.userId) || StringUtils.isNull(this.bdN.giftId) || !com.baidu.live.gift.smallgift.a.c(this.bdN, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.bdN, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JC() {
        if (this.bdN != null) {
            this.bdM.setVisibility(0);
            this.bdM.setTag(this.bdN.Ib());
            this.bdM.setData(this.bdN, false);
            this.bdM.JC();
            JM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD() {
        if (this.bdN != null) {
            w.g(this.bdN);
        }
        this.bdM.JD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JM() {
        long j;
        if (this.bdM.getVisibility() == 0) {
            this.bdM.clearAnimation();
            if (this.bdN != null) {
                if (this.bdN.aZQ >= this.bdN.aZP) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.bdN.ag(System.currentTimeMillis());
                boolean z = this.bdN.aZP > 10;
                c cVar = this.bdN;
                if (z) {
                    j = this.bdN.aZP;
                } else {
                    c cVar2 = this.bdN;
                    j = cVar2.aZQ + 1;
                    cVar2.aZQ = j;
                }
                cVar.aZQ = j;
                this.bdM.f(this.bdN.aZP, this.bdN.aZQ);
            }
        }
    }

    public void Hi() {
        if (this.bdN != null && this.bdN.aZP == this.bdN.aZQ) {
            this.mHandler.postDelayed(this.bdQ, 1000L);
        }
    }

    public void a(a aVar) {
        this.bdO = aVar;
    }
}
