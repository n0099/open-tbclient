package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.r;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class b {
    private AlaSmallGiftView aWK;
    private c aWL;
    private a aWM;
    private int aWN;
    private AlaSmallGiftView.a aTY = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Gz() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void R(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.aWM != null) {
                b.this.aWM.u(b.this.aWL);
            }
            b.this.aWL = null;
            if (b.this.aWM != null) {
                b.this.aWM.HD();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void GA() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.HK();
                    return false;
                case 2:
                    b.this.HU();
                    return false;
                case 3:
                    b.this.HL();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aWO = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aWL != null) {
                if (System.currentTimeMillis() - b.this.aWL.Gi() < b.this.aWN || b.this.aWL.aSX < b.this.aWL.aSW) {
                    b.this.mHandler.postDelayed(b.this.aWO, 1000L);
                    return;
                }
                b.this.mHandler.removeMessages(2);
                b.this.mHandler.removeMessages(1);
                b.this.mHandler.sendEmptyMessage(3);
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void HD();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aWK = alaSmallGiftView;
        this.aWK.setSmallAnimCallBack(this.aTY);
    }

    public boolean isReady() {
        return this.aWL == null;
    }

    public boolean HR() {
        if (this.aWL == null || StringUtils.isNull(this.aWL.userId)) {
            return false;
        }
        return this.aWL.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.aWL == null || cVar.priority <= this.aWL.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.aWK == null || this.aWK.getVisibility() == 0 || this.aWL != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.aWL = cVar;
        HS();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aWO, 1000L);
        return true;
    }

    public void y(c cVar) {
        HT();
        if (this.aWM != null) {
            this.aWM.v(this.aWL);
            this.aWL = null;
        }
        this.aWL = cVar;
        HS();
        this.aWK.setVisibility(0);
        this.aWK.setTag(this.aWL.Gk());
        this.aWK.setData(this.aWL, false);
        this.mHandler.postDelayed(this.aWO, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void HS() {
        this.aWN = this.aWL.aSW > 10 ? 6000 : 3000;
    }

    public void Ez() {
        if (this.aWL != null) {
            HT();
            this.aWK.setVisibility(4);
            r.g(this.aWL);
            if (this.aWM != null) {
                this.aWM.v(this.aWL);
                this.aWL = null;
            }
        }
    }

    public void EA() {
        if (this.aWM != null) {
            this.aWM.HD();
        }
    }

    public void onDestroy() {
        HT();
        if (this.aWK != null) {
            this.aWK.onDestroy();
        }
    }

    private void HT() {
        this.mHandler.removeCallbacks(this.aWO);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.aWL == null || StringUtils.isNull(this.aWL.userId) || StringUtils.isNull(this.aWL.giftId) || !com.baidu.live.gift.smallgift.a.c(this.aWL, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.aWL, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK() {
        if (this.aWL != null) {
            this.aWK.setVisibility(0);
            this.aWK.setTag(this.aWL.Gk());
            this.aWK.setData(this.aWL, false);
            this.aWK.HK();
            HU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        if (this.aWL != null) {
            r.g(this.aWL);
        }
        this.aWK.HL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU() {
        long j;
        if (this.aWK.getVisibility() == 0) {
            this.aWK.clearAnimation();
            if (this.aWL != null) {
                if (this.aWL.aSX >= this.aWL.aSW) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aWL.ae(System.currentTimeMillis());
                boolean z = this.aWL.aSW > 10;
                c cVar = this.aWL;
                if (z) {
                    j = this.aWL.aSW;
                } else {
                    c cVar2 = this.aWL;
                    j = cVar2.aSX + 1;
                    cVar2.aSX = j;
                }
                cVar.aSX = j;
                this.aWK.f(this.aWL.aSW, this.aWL.aSX);
            }
        }
    }

    public void Fq() {
        if (this.aWL != null && this.aWL.aSW == this.aWL.aSX) {
            this.mHandler.postDelayed(this.aWO, 1000L);
        }
    }

    public void a(a aVar) {
        this.aWM = aVar;
    }
}
