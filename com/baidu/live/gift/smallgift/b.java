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
    private AlaSmallGiftView aWI;
    private c aWJ;
    private a aWK;
    private int aWL;
    private AlaSmallGiftView.a aTW = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Gz() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void R(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.aWK != null) {
                b.this.aWK.u(b.this.aWJ);
            }
            b.this.aWJ = null;
            if (b.this.aWK != null) {
                b.this.aWK.HD();
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
    private Runnable aWM = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aWJ != null) {
                if (System.currentTimeMillis() - b.this.aWJ.Gi() < b.this.aWL || b.this.aWJ.aSV < b.this.aWJ.aSU) {
                    b.this.mHandler.postDelayed(b.this.aWM, 1000L);
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
        this.aWI = alaSmallGiftView;
        this.aWI.setSmallAnimCallBack(this.aTW);
    }

    public boolean isReady() {
        return this.aWJ == null;
    }

    public boolean HR() {
        if (this.aWJ == null || StringUtils.isNull(this.aWJ.userId)) {
            return false;
        }
        return this.aWJ.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.aWJ == null || cVar.priority <= this.aWJ.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.aWI == null || this.aWI.getVisibility() == 0 || this.aWJ != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.aWJ = cVar;
        HS();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aWM, 1000L);
        return true;
    }

    public void y(c cVar) {
        HT();
        if (this.aWK != null) {
            this.aWK.v(this.aWJ);
            this.aWJ = null;
        }
        this.aWJ = cVar;
        HS();
        this.aWI.setVisibility(0);
        this.aWI.setTag(this.aWJ.Gk());
        this.aWI.setData(this.aWJ, false);
        this.mHandler.postDelayed(this.aWM, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void HS() {
        this.aWL = this.aWJ.aSU > 10 ? 6000 : 3000;
    }

    public void Ez() {
        if (this.aWJ != null) {
            HT();
            this.aWI.setVisibility(4);
            r.g(this.aWJ);
            if (this.aWK != null) {
                this.aWK.v(this.aWJ);
                this.aWJ = null;
            }
        }
    }

    public void EA() {
        if (this.aWK != null) {
            this.aWK.HD();
        }
    }

    public void onDestroy() {
        HT();
        if (this.aWI != null) {
            this.aWI.onDestroy();
        }
    }

    private void HT() {
        this.mHandler.removeCallbacks(this.aWM);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.aWJ == null || StringUtils.isNull(this.aWJ.userId) || StringUtils.isNull(this.aWJ.giftId) || !com.baidu.live.gift.smallgift.a.c(this.aWJ, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.aWJ, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK() {
        if (this.aWJ != null) {
            this.aWI.setVisibility(0);
            this.aWI.setTag(this.aWJ.Gk());
            this.aWI.setData(this.aWJ, false);
            this.aWI.HK();
            HU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        if (this.aWJ != null) {
            r.g(this.aWJ);
        }
        this.aWI.HL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU() {
        long j;
        if (this.aWI.getVisibility() == 0) {
            this.aWI.clearAnimation();
            if (this.aWJ != null) {
                if (this.aWJ.aSV >= this.aWJ.aSU) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aWJ.ae(System.currentTimeMillis());
                boolean z = this.aWJ.aSU > 10;
                c cVar = this.aWJ;
                if (z) {
                    j = this.aWJ.aSU;
                } else {
                    c cVar2 = this.aWJ;
                    j = cVar2.aSV + 1;
                    cVar2.aSV = j;
                }
                cVar.aSV = j;
                this.aWI.f(this.aWJ.aSU, this.aWJ.aSV);
            }
        }
    }

    public void Fq() {
        if (this.aWJ != null && this.aWJ.aSU == this.aWJ.aSV) {
            this.mHandler.postDelayed(this.aWM, 1000L);
        }
    }

    public void a(a aVar) {
        this.aWK = aVar;
    }
}
