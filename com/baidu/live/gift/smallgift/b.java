package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.r;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b {
    private AlaSmallGiftView aRv;
    private c aRw;
    private a aRx;
    private int aRy;
    private AlaSmallGiftView.a aOI = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void AV() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void R(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.aRx != null) {
                b.this.aRx.u(b.this.aRw);
            }
            b.this.aRw = null;
            if (b.this.aRx != null) {
                b.this.aRx.Ca();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void AW() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Ch();
                    return false;
                case 2:
                    b.this.Cr();
                    return false;
                case 3:
                    b.this.Ci();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aRz = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aRw != null) {
                if (System.currentTimeMillis() - b.this.aRw.AF() < b.this.aRy || b.this.aRw.aNI < b.this.aRw.aNH) {
                    b.this.mHandler.postDelayed(b.this.aRz, 1000L);
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
        void Ca();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aRv = alaSmallGiftView;
        this.aRv.setSmallAnimCallBack(this.aOI);
    }

    public boolean isReady() {
        return this.aRw == null;
    }

    public boolean Co() {
        if (this.aRw == null || StringUtils.isNull(this.aRw.userId)) {
            return false;
        }
        return this.aRw.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.aRw == null || cVar.priority <= this.aRw.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.aRv == null || this.aRv.getVisibility() == 0 || this.aRw != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.aRw = cVar;
        Cp();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aRz, 1000L);
        return true;
    }

    public void y(c cVar) {
        Cq();
        if (this.aRx != null) {
            this.aRx.v(this.aRw);
            this.aRw = null;
        }
        this.aRw = cVar;
        Cp();
        this.aRv.setVisibility(0);
        this.aRv.setTag(this.aRw.AH());
        this.aRv.setData(this.aRw, false);
        this.mHandler.postDelayed(this.aRz, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Cp() {
        this.aRy = this.aRw.aNH > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void yW() {
        if (this.aRw != null) {
            Cq();
            this.aRv.setVisibility(4);
            r.g(this.aRw);
            if (this.aRx != null) {
                this.aRx.v(this.aRw);
                this.aRw = null;
            }
        }
    }

    public void yX() {
        if (this.aRx != null) {
            this.aRx.Ca();
        }
    }

    public void onDestroy() {
        Cq();
        if (this.aRv != null) {
            this.aRv.onDestroy();
        }
    }

    private void Cq() {
        this.mHandler.removeCallbacks(this.aRz);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.aRw == null || StringUtils.isNull(this.aRw.userId) || StringUtils.isNull(this.aRw.giftId) || !com.baidu.live.gift.smallgift.a.c(this.aRw, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.aRw, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch() {
        if (this.aRw != null) {
            this.aRv.setVisibility(0);
            this.aRv.setTag(this.aRw.AH());
            this.aRv.setData(this.aRw, false);
            this.aRv.Ch();
            Cr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        if (this.aRw != null) {
            r.g(this.aRw);
        }
        this.aRv.Ci();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cr() {
        long j;
        if (this.aRv.getVisibility() == 0) {
            this.aRv.clearAnimation();
            if (this.aRw != null) {
                if (this.aRw.aNI >= this.aRw.aNH) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aRw.ad(System.currentTimeMillis());
                boolean z = this.aRw.aNH > 10;
                c cVar = this.aRw;
                if (z) {
                    j = this.aRw.aNH;
                } else {
                    c cVar2 = this.aRw;
                    j = cVar2.aNI + 1;
                    cVar2.aNI = j;
                }
                cVar.aNI = j;
                this.aRv.f(this.aRw.aNH, this.aRw.aNI);
            }
        }
    }

    public void zN() {
        if (this.aRw != null && this.aRw.aNH == this.aRw.aNI) {
            this.mHandler.postDelayed(this.aRz, 1000L);
        }
    }

    public void a(a aVar) {
        this.aRx = aVar;
    }
}
