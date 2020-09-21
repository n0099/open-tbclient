package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.r;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b {
    private AlaSmallGiftView aZe;
    private c aZf;
    private a aZg;
    private int aZh;
    private AlaSmallGiftView.a aWn = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void GZ() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void T(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            if (b.this.aZg != null) {
                b.this.aZg.u(b.this.aZf);
            }
            b.this.aZf = null;
            if (b.this.aZg != null) {
                b.this.aZg.If();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void Ha() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.Im();
                    return false;
                case 2:
                    b.this.Iw();
                    return false;
                case 3:
                    b.this.In();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aZi = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aZf != null) {
                if (System.currentTimeMillis() - b.this.aZf.GI() < b.this.aZh || b.this.aZf.aVj < b.this.aZf.aVi) {
                    b.this.mHandler.postDelayed(b.this.aZi, 1000L);
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
        void If();

        void u(c cVar);

        void v(c cVar);
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aZe = alaSmallGiftView;
        this.aZe.setSmallAnimCallBack(this.aWn);
    }

    public boolean isReady() {
        return this.aZf == null;
    }

    public boolean It() {
        if (this.aZf == null || StringUtils.isNull(this.aZf.userId)) {
            return false;
        }
        return this.aZf.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean w(c cVar) {
        return (cVar == null || this.aZf == null || cVar.priority <= this.aZf.priority) ? false : true;
    }

    public boolean x(c cVar) {
        if (this.aZe == null || this.aZe.getVisibility() == 0 || this.aZf != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.aZf = cVar;
        Iu();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aZi, 1000L);
        return true;
    }

    public void y(c cVar) {
        Iv();
        if (this.aZg != null) {
            this.aZg.v(this.aZf);
            this.aZf = null;
        }
        this.aZf = cVar;
        Iu();
        this.aZe.setVisibility(0);
        this.aZe.setTag(this.aZf.GK());
        this.aZe.setData(this.aZf, false);
        this.mHandler.postDelayed(this.aZi, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void Iu() {
        this.aZh = this.aZf.aVi > 10 ? 6000 : 3000;
    }

    public void EQ() {
        if (this.aZf != null) {
            Iv();
            this.aZe.setVisibility(4);
            r.g(this.aZf);
            if (this.aZg != null) {
                this.aZg.v(this.aZf);
                this.aZf = null;
            }
        }
    }

    public void ER() {
        if (this.aZg != null) {
            this.aZg.If();
        }
    }

    public void onDestroy() {
        Iv();
        if (this.aZe != null) {
            this.aZe.onDestroy();
        }
    }

    private void Iv() {
        this.mHandler.removeCallbacks(this.aZi);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean z(c cVar) {
        if (this.aZf == null || StringUtils.isNull(this.aZf.userId) || StringUtils.isNull(this.aZf.giftId) || !com.baidu.live.gift.smallgift.a.c(this.aZf, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.aZf, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im() {
        if (this.aZf != null) {
            this.aZe.setVisibility(0);
            this.aZe.setTag(this.aZf.GK());
            this.aZe.setData(this.aZf, false);
            this.aZe.Im();
            Iw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void In() {
        if (this.aZf != null) {
            r.g(this.aZf);
        }
        this.aZe.In();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iw() {
        long j;
        if (this.aZe.getVisibility() == 0) {
            this.aZe.clearAnimation();
            if (this.aZf != null) {
                if (this.aZf.aVj >= this.aZf.aVi) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aZf.ad(System.currentTimeMillis());
                boolean z = this.aZf.aVi > 10;
                c cVar = this.aZf;
                if (z) {
                    j = this.aZf.aVi;
                } else {
                    c cVar2 = this.aZf;
                    j = cVar2.aVj + 1;
                    cVar2.aVj = j;
                }
                cVar.aVj = j;
                this.aZe.f(this.aZf.aVi, this.aZf.aVj);
            }
        }
    }

    public void FQ() {
        if (this.aZf != null && this.aZf.aVi == this.aZf.aVj) {
            this.mHandler.postDelayed(this.aZi, 1000L);
        }
    }

    public void a(a aVar) {
        this.aZg = aVar;
    }
}
