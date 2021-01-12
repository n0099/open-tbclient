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
/* loaded from: classes10.dex */
public class b {
    private AlaSmallGiftView bem;
    private c ben;
    private a beo;
    private int bep;
    private AlaSmallGiftView.a bba = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void FG() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.beo != null) {
                b.this.beo.v(b.this.ben);
            }
            b.this.ben = null;
            if (b.this.beo != null) {
                b.this.beo.GR();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void FH() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.GY();
                    return false;
                case 2:
                    b.this.Hi();
                    return false;
                case 3:
                    b.this.GZ();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable beq = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ben != null) {
                if (System.currentTimeMillis() - b.this.ben.Fp() < b.this.bep || b.this.ben.aZN < b.this.ben.aZM) {
                    b.this.mHandler.postDelayed(b.this.beq, 1000L);
                    return;
                }
                b.this.mHandler.removeMessages(2);
                b.this.mHandler.removeMessages(1);
                b.this.mHandler.sendEmptyMessage(3);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void GR();

        void v(c cVar);

        void w(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.bem = alaSmallGiftView;
        this.bem.setSmallAnimCallBack(this.bba);
    }

    public boolean isReady() {
        return this.ben == null;
    }

    public boolean Hf() {
        if (this.ben == null || StringUtils.isNull(this.ben.userId)) {
            return false;
        }
        return this.ben.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean x(c cVar) {
        return (cVar == null || this.ben == null || cVar.priority <= this.ben.priority) ? false : true;
    }

    public boolean y(c cVar) {
        if (this.bem == null || this.bem.getVisibility() == 0 || this.ben != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.ben = cVar;
        Hg();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.beq, 1000L);
        return true;
    }

    public void z(c cVar) {
        Hh();
        if (this.beo != null) {
            this.beo.w(this.ben);
            this.ben = null;
        }
        this.ben = cVar;
        Hg();
        this.bem.setVisibility(0);
        this.bem.setTag(this.ben.Fr());
        this.bem.setData(this.ben, false);
        this.mHandler.postDelayed(this.beq, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Hg() {
        this.bep = this.ben.aZM > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void Do() {
        if (this.ben != null) {
            Hh();
            this.bem.setVisibility(4);
            w.g(this.ben);
            if (this.beo != null) {
                this.beo.w(this.ben);
                this.ben = null;
            }
        }
    }

    public void Dp() {
        if (this.beo != null) {
            this.beo.GR();
        }
    }

    public void onDestroy() {
        Hh();
        if (this.bem != null) {
            this.bem.onDestroy();
        }
    }

    private void Hh() {
        this.mHandler.removeCallbacks(this.beq);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean A(c cVar) {
        if (this.ben == null || StringUtils.isNull(this.ben.userId) || StringUtils.isNull(this.ben.giftId) || !com.baidu.live.gift.smallgift.a.c(this.ben, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.ben, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY() {
        if (this.ben != null) {
            this.bem.setVisibility(0);
            this.bem.setTag(this.ben.Fr());
            this.bem.setData(this.ben, false);
            this.bem.GY();
            Hi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ() {
        if (this.ben != null) {
            w.g(this.ben);
        }
        this.bem.GZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hi() {
        long j;
        if (this.bem.getVisibility() == 0) {
            this.bem.clearAnimation();
            if (this.ben != null) {
                if (this.ben.aZN >= this.ben.aZM) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.ben.aP(System.currentTimeMillis());
                boolean z = this.ben.aZM > 10;
                c cVar = this.ben;
                if (z) {
                    j = this.ben.aZM;
                } else {
                    c cVar2 = this.ben;
                    j = cVar2.aZN + 1;
                    cVar2.aZN = j;
                }
                cVar.aZN = j;
                this.bem.i(this.ben.aZM, this.ben.aZN);
            }
        }
    }

    public void Ex() {
        if (this.ben != null && this.ben.aZM == this.ben.aZN) {
            this.mHandler.postDelayed(this.beq, 1000L);
        }
    }

    public void a(a aVar) {
        this.beo = aVar;
    }
}
