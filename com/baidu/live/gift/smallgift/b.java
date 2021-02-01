package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.gift.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class b {
    private AlaSmallGiftView bhv;
    private c bhw;
    private a bhx;
    private int bhy;
    private AlaSmallGiftView.a bef = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void GW() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.bhx != null) {
                b.this.bhx.v(b.this.bhw);
            }
            b.this.bhw = null;
            if (b.this.bhx != null) {
                b.this.bhx.Ih();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void GX() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Io();
                    return false;
                case 2:
                    b.this.Iy();
                    return false;
                case 3:
                    b.this.Ip();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable bhz = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.bhw != null) {
                if (System.currentTimeMillis() - b.this.bhw.GF() < b.this.bhy || b.this.bhw.bcU < b.this.bhw.bcT) {
                    b.this.mHandler.postDelayed(b.this.bhz, 1000L);
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
        void Ih();

        void v(c cVar);

        void w(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.bhv = alaSmallGiftView;
        this.bhv.setSmallAnimCallBack(this.bef);
    }

    public boolean isReady() {
        return this.bhw == null;
    }

    public boolean Iv() {
        if (this.bhw == null || StringUtils.isNull(this.bhw.userId)) {
            return false;
        }
        return this.bhw.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean x(c cVar) {
        return (cVar == null || this.bhw == null || cVar.priority <= this.bhw.priority) ? false : true;
    }

    public boolean y(c cVar) {
        if (this.bhv == null || this.bhv.getVisibility() == 0 || this.bhw != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.bhw = cVar;
        Iw();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.bhz, 1000L);
        return true;
    }

    public void z(c cVar) {
        Ix();
        if (this.bhx != null) {
            this.bhx.w(this.bhw);
            this.bhw = null;
        }
        this.bhw = cVar;
        Iw();
        this.bhv.setVisibility(0);
        this.bhv.setTag(this.bhw.GH());
        this.bhv.setData(this.bhw, false);
        this.mHandler.postDelayed(this.bhz, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Iw() {
        this.bhy = this.bhw.bcT > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void EE() {
        if (this.bhw != null) {
            Ix();
            this.bhv.setVisibility(4);
            w.g(this.bhw);
            if (this.bhx != null) {
                this.bhx.w(this.bhw);
                this.bhw = null;
            }
        }
    }

    public void EF() {
        if (this.bhx != null) {
            this.bhx.Ih();
        }
    }

    public void onDestroy() {
        Ix();
        if (this.bhv != null) {
            this.bhv.onDestroy();
        }
    }

    private void Ix() {
        this.mHandler.removeCallbacks(this.bhz);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean A(c cVar) {
        if (this.bhw == null || StringUtils.isNull(this.bhw.userId) || StringUtils.isNull(this.bhw.giftId) || !com.baidu.live.gift.smallgift.a.c(this.bhw, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.bhw, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        if (this.bhw != null) {
            this.bhv.setVisibility(0);
            this.bhv.setTag(this.bhw.GH());
            this.bhv.setData(this.bhw, false);
            this.bhv.Io();
            Iy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip() {
        if (this.bhw != null) {
            w.g(this.bhw);
        }
        this.bhv.Ip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iy() {
        long j;
        if (this.bhv.getVisibility() == 0) {
            this.bhv.clearAnimation();
            if (this.bhw != null) {
                if (this.bhw.bcU >= this.bhw.bcT) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.bhw.aS(System.currentTimeMillis());
                boolean z = this.bhw.bcT > 10;
                c cVar = this.bhw;
                if (z) {
                    j = this.bhw.bcT;
                } else {
                    c cVar2 = this.bhw;
                    j = cVar2.bcU + 1;
                    cVar2.bcU = j;
                }
                cVar.bcU = j;
                this.bhv.i(this.bhw.bcT, this.bhw.bcU);
            }
        }
    }

    public void FN() {
        if (this.bhw != null && this.bhw.bcT == this.bhw.bcU) {
            this.mHandler.postDelayed(this.bhz, 1000L);
        }
    }

    public void a(a aVar) {
        this.bhx = aVar;
    }
}
