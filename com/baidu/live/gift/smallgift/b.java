package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class b {
    private AlaSmallGiftView amP;
    private c amQ;
    private a amR;
    private int amS;
    private AlaSmallGiftView.a akq = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void sT() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void N(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.amQ = null;
            if (b.this.amR != null) {
                b.this.amR.tP();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void sU() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.tW();
                    return false;
                case 2:
                    b.this.ug();
                    return false;
                case 3:
                    b.this.tX();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable amT = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.amQ != null) {
                if (System.currentTimeMillis() - b.this.amQ.sD() < b.this.amS || b.this.amQ.ajt < b.this.amQ.ajs) {
                    b.this.mHandler.postDelayed(b.this.amT, 1000L);
                    return;
                }
                b.this.mHandler.removeMessages(2);
                b.this.mHandler.removeMessages(1);
                b.this.mHandler.sendEmptyMessage(3);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void p(c cVar);

        void tP();
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.amP = alaSmallGiftView;
        this.amP.setSmallAnimCallBack(this.akq);
    }

    public boolean isReady() {
        return this.amQ == null;
    }

    public boolean ud() {
        if (this.amQ == null || StringUtils.isNull(this.amQ.userId)) {
            return false;
        }
        return this.amQ.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean q(c cVar) {
        return (cVar == null || this.amQ == null || cVar.priority <= this.amQ.priority) ? false : true;
    }

    public boolean r(c cVar) {
        if (this.amP == null || this.amP.getVisibility() == 0 || this.amQ != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.amQ = cVar;
        ue();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.amT, 1000L);
        return true;
    }

    public void s(c cVar) {
        uf();
        if (this.amR != null) {
            this.amR.p(this.amQ);
            this.amQ = null;
        }
        this.amQ = cVar;
        ue();
        this.amP.setVisibility(0);
        this.amP.setTag(this.amQ.sF());
        this.amP.setData(this.amQ, false);
        this.mHandler.postDelayed(this.amT, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void ue() {
        this.amS = this.amQ.ajs > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void rf() {
        if (this.amQ != null) {
            uf();
            this.amP.setVisibility(4);
            if (this.amR != null) {
                this.amR.p(this.amQ);
                this.amQ = null;
            }
        }
    }

    public void rg() {
        if (this.amR != null) {
            this.amR.tP();
        }
    }

    public void onDestroy() {
        uf();
        if (this.amP != null) {
            this.amP.onDestroy();
        }
    }

    private void uf() {
        this.mHandler.removeCallbacks(this.amT);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean t(c cVar) {
        if (this.amQ == null || StringUtils.isNull(this.amQ.userId) || StringUtils.isNull(this.amQ.giftId) || !b(this.amQ, cVar)) {
            return false;
        }
        c(this.amQ, cVar);
        return true;
    }

    private boolean b(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.ajp) && cVar.ajp.equals(cVar2.ajp) && Math.abs(cVar2.sD() - cVar.sD()) <= 3000 && cVar2.ajs <= 10;
    }

    private void c(c cVar, c cVar2) {
        cVar.ajs += cVar2.ajs;
        cVar.A(cVar2.sD());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tW() {
        if (this.amQ != null) {
            this.amP.setVisibility(0);
            this.amP.setTag(this.amQ.sF());
            this.amP.setData(this.amQ, false);
            this.amP.tW();
            ug();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tX() {
        this.amP.tX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ug() {
        long j;
        if (this.amP.getVisibility() == 0) {
            this.amP.clearAnimation();
            if (this.amQ != null) {
                if (this.amQ.ajt >= this.amQ.ajs) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.amQ.A(System.currentTimeMillis());
                boolean z = this.amQ.ajs > 10;
                c cVar = this.amQ;
                if (z) {
                    j = this.amQ.ajs;
                } else {
                    c cVar2 = this.amQ;
                    j = cVar2.ajt + 1;
                    cVar2.ajt = j;
                }
                cVar.ajt = j;
                this.amP.e(this.amQ.ajs, this.amQ.ajt);
            }
        }
    }

    public void rP() {
        if (this.amQ != null && this.amQ.ajs == this.amQ.ajt) {
            this.mHandler.postDelayed(this.amT, 1000L);
        }
    }

    public void a(a aVar) {
        this.amR = aVar;
    }
}
