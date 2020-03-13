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
    private AlaSmallGiftView apd;
    private c ape;
    private a apf;
    private int apg;
    private AlaSmallGiftView.a amx = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void uf() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void N(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.ape = null;
            if (b.this.apf != null) {
                b.this.apf.vg();
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
    private Runnable aph = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ape != null) {
                if (System.currentTimeMillis() - b.this.ape.tP() < b.this.apg || b.this.ape.alC < b.this.ape.alB) {
                    b.this.mHandler.postDelayed(b.this.aph, 1000L);
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
        this.apd = alaSmallGiftView;
        this.apd.setSmallAnimCallBack(this.amx);
    }

    public boolean isReady() {
        return this.ape == null;
    }

    public boolean vu() {
        if (this.ape == null || StringUtils.isNull(this.ape.userId)) {
            return false;
        }
        return this.ape.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean q(c cVar) {
        return (cVar == null || this.ape == null || cVar.priority <= this.ape.priority) ? false : true;
    }

    public boolean r(c cVar) {
        if (this.apd == null || this.apd.getVisibility() == 0 || this.ape != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.ape = cVar;
        vv();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aph, 1000L);
        return true;
    }

    public void s(c cVar) {
        vw();
        if (this.apf != null) {
            this.apf.p(this.ape);
            this.ape = null;
        }
        this.ape = cVar;
        vv();
        this.apd.setVisibility(0);
        this.apd.setTag(this.ape.tR());
        this.apd.setData(this.ape, false);
        this.mHandler.postDelayed(this.aph, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void vv() {
        this.apg = this.ape.alB > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void sg() {
        if (this.ape != null) {
            vw();
            this.apd.setVisibility(4);
            if (this.apf != null) {
                this.apf.p(this.ape);
                this.ape = null;
            }
        }
    }

    public void sh() {
        if (this.apf != null) {
            this.apf.vg();
        }
    }

    public void onDestroy() {
        vw();
        if (this.apd != null) {
            this.apd.onDestroy();
        }
    }

    private void vw() {
        this.mHandler.removeCallbacks(this.aph);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean t(c cVar) {
        if (this.ape == null || StringUtils.isNull(this.ape.userId) || StringUtils.isNull(this.ape.giftId) || !b(this.ape, cVar)) {
            return false;
        }
        c(this.ape, cVar);
        return true;
    }

    private boolean b(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.aly) && cVar.aly.equals(cVar2.aly) && Math.abs(cVar2.tP() - cVar.tP()) <= 3000 && cVar2.alB <= 10;
    }

    private void c(c cVar, c cVar2) {
        cVar.alB += cVar2.alB;
        cVar.B(cVar2.tP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn() {
        if (this.ape != null) {
            this.apd.setVisibility(0);
            this.apd.setTag(this.ape.tR());
            this.apd.setData(this.ape, false);
            this.apd.vn();
            vx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vo() {
        this.apd.vo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx() {
        long j;
        if (this.apd.getVisibility() == 0) {
            this.apd.clearAnimation();
            if (this.ape != null) {
                if (this.ape.alC >= this.ape.alB) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.ape.B(System.currentTimeMillis());
                boolean z = this.ape.alB > 10;
                c cVar = this.ape;
                if (z) {
                    j = this.ape.alB;
                } else {
                    c cVar2 = this.ape;
                    j = cVar2.alC + 1;
                    cVar2.alC = j;
                }
                cVar.alC = j;
                this.apd.e(this.ape.alB, this.ape.alC);
            }
        }
    }

    public void ta() {
        if (this.ape != null && this.ape.alB == this.ape.alC) {
            this.mHandler.postDelayed(this.aph, 1000L);
        }
    }

    public void a(a aVar) {
        this.apf = aVar;
    }
}
