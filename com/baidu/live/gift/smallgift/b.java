package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.q;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {
    private AlaSmallGiftView aHN;
    private c aHO;
    private a aHP;
    private int aHQ;
    private AlaSmallGiftView.a aFf = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void yD() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void P(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.aHO = null;
            if (b.this.aHP != null) {
                b.this.aHP.zI();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void yE() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.zP();
                    return false;
                case 2:
                    b.this.zZ();
                    return false;
                case 3:
                    b.this.zQ();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aHR = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aHO != null) {
                if (System.currentTimeMillis() - b.this.aHO.yn() < b.this.aHQ || b.this.aHO.aEi < b.this.aHO.aEh) {
                    b.this.mHandler.postDelayed(b.this.aHR, 1000L);
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
        void r(c cVar);

        void zI();
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aHN = alaSmallGiftView;
        this.aHN.setSmallAnimCallBack(this.aFf);
    }

    public boolean isReady() {
        return this.aHO == null;
    }

    public boolean zW() {
        if (this.aHO == null || StringUtils.isNull(this.aHO.userId)) {
            return false;
        }
        return this.aHO.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean s(c cVar) {
        return (cVar == null || this.aHO == null || cVar.priority <= this.aHO.priority) ? false : true;
    }

    public boolean t(c cVar) {
        if (this.aHN == null || this.aHN.getVisibility() == 0 || this.aHO != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.aHO = cVar;
        zX();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aHR, 1000L);
        return true;
    }

    public void u(c cVar) {
        zY();
        if (this.aHP != null) {
            this.aHP.r(this.aHO);
            this.aHO = null;
        }
        this.aHO = cVar;
        zX();
        this.aHN.setVisibility(0);
        this.aHN.setTag(this.aHO.yp());
        this.aHN.setData(this.aHO, false);
        this.mHandler.postDelayed(this.aHR, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void zX() {
        this.aHQ = this.aHO.aEh > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void wD() {
        if (this.aHO != null) {
            zY();
            this.aHN.setVisibility(4);
            q.g(this.aHO);
            if (this.aHP != null) {
                this.aHP.r(this.aHO);
                this.aHO = null;
            }
        }
    }

    public void wE() {
        if (this.aHP != null) {
            this.aHP.zI();
        }
    }

    public void onDestroy() {
        zY();
        if (this.aHN != null) {
            this.aHN.onDestroy();
        }
    }

    private void zY() {
        this.mHandler.removeCallbacks(this.aHR);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean v(c cVar) {
        if (this.aHO == null || StringUtils.isNull(this.aHO.userId) || StringUtils.isNull(this.aHO.giftId) || !com.baidu.live.gift.smallgift.a.c(this.aHO, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.aHO, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zP() {
        if (this.aHO != null) {
            this.aHN.setVisibility(0);
            this.aHN.setTag(this.aHO.yp());
            this.aHN.setData(this.aHO, false);
            this.aHN.zP();
            zZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ() {
        if (this.aHO != null) {
            q.g(this.aHO);
        }
        this.aHN.zQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zZ() {
        long j;
        if (this.aHN.getVisibility() == 0) {
            this.aHN.clearAnimation();
            if (this.aHO != null) {
                if (this.aHO.aEi >= this.aHO.aEh) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aHO.Z(System.currentTimeMillis());
                boolean z = this.aHO.aEh > 10;
                c cVar = this.aHO;
                if (z) {
                    j = this.aHO.aEh;
                } else {
                    c cVar2 = this.aHO;
                    j = cVar2.aEi + 1;
                    cVar2.aEi = j;
                }
                cVar.aEi = j;
                this.aHN.e(this.aHO.aEh, this.aHO.aEi);
            }
        }
    }

    public void xx() {
        if (this.aHO != null && this.aHO.aEh == this.aHO.aEi) {
            this.mHandler.postDelayed(this.aHR, 1000L);
        }
    }

    public void a(a aVar) {
        this.aHP = aVar;
    }
}
