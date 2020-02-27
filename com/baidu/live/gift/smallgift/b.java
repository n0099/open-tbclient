package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {
    private AlaSmallGiftView apc;
    private c apd;
    private a ape;
    private int apf;
    private AlaSmallGiftView.a amw = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void uf() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void N(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.apd = null;
            if (b.this.ape != null) {
                b.this.ape.vg();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void ug() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.vn();
                    return false;
                case 2:
                    b.this.vx();
                    return false;
                case 3:
                    b.this.vo();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable apg = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.apd != null) {
                if (System.currentTimeMillis() - b.this.apd.tP() < b.this.apf || b.this.apd.alB < b.this.apd.alA) {
                    b.this.mHandler.postDelayed(b.this.apg, 1000L);
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
        void p(c cVar);

        void vg();
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.apc = alaSmallGiftView;
        this.apc.setSmallAnimCallBack(this.amw);
    }

    public boolean isReady() {
        return this.apd == null;
    }

    public boolean vu() {
        if (this.apd == null || StringUtils.isNull(this.apd.userId)) {
            return false;
        }
        return this.apd.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean q(c cVar) {
        return (cVar == null || this.apd == null || cVar.priority <= this.apd.priority) ? false : true;
    }

    public boolean r(c cVar) {
        if (this.apc == null || this.apc.getVisibility() == 0 || this.apd != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.apd = cVar;
        vv();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.apg, 1000L);
        return true;
    }

    public void s(c cVar) {
        vw();
        if (this.ape != null) {
            this.ape.p(this.apd);
            this.apd = null;
        }
        this.apd = cVar;
        vv();
        this.apc.setVisibility(0);
        this.apc.setTag(this.apd.tR());
        this.apc.setData(this.apd, false);
        this.mHandler.postDelayed(this.apg, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void vv() {
        this.apf = this.apd.alA > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void sg() {
        if (this.apd != null) {
            vw();
            this.apc.setVisibility(4);
            if (this.ape != null) {
                this.ape.p(this.apd);
                this.apd = null;
            }
        }
    }

    public void sh() {
        if (this.ape != null) {
            this.ape.vg();
        }
    }

    public void onDestroy() {
        vw();
        if (this.apc != null) {
            this.apc.onDestroy();
        }
    }

    private void vw() {
        this.mHandler.removeCallbacks(this.apg);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean t(c cVar) {
        if (this.apd == null || StringUtils.isNull(this.apd.userId) || StringUtils.isNull(this.apd.giftId) || !b(this.apd, cVar)) {
            return false;
        }
        c(this.apd, cVar);
        return true;
    }

    private boolean b(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.alx) && cVar.alx.equals(cVar2.alx) && Math.abs(cVar2.tP() - cVar.tP()) <= 3000 && cVar2.alA <= 10;
    }

    private void c(c cVar, c cVar2) {
        cVar.alA += cVar2.alA;
        cVar.B(cVar2.tP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn() {
        if (this.apd != null) {
            this.apc.setVisibility(0);
            this.apc.setTag(this.apd.tR());
            this.apc.setData(this.apd, false);
            this.apc.vn();
            vx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vo() {
        this.apc.vo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx() {
        long j;
        if (this.apc.getVisibility() == 0) {
            this.apc.clearAnimation();
            if (this.apd != null) {
                if (this.apd.alB >= this.apd.alA) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.apd.B(System.currentTimeMillis());
                boolean z = this.apd.alA > 10;
                c cVar = this.apd;
                if (z) {
                    j = this.apd.alA;
                } else {
                    c cVar2 = this.apd;
                    j = cVar2.alB + 1;
                    cVar2.alB = j;
                }
                cVar.alB = j;
                this.apc.e(this.apd.alA, this.apd.alB);
            }
        }
    }

    public void ta() {
        if (this.apd != null && this.apd.alA == this.apd.alB) {
            this.mHandler.postDelayed(this.apg, 1000L);
        }
    }

    public void a(a aVar) {
        this.ape = aVar;
    }
}
