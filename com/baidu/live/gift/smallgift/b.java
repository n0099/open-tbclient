package com.baidu.live.gift.smallgift;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class b {
    private AlaSmallGiftView amc;
    private com.baidu.live.gift.a.b amd;
    private a ame;
    private int amf;
    private AlaSmallGiftView.a ajG = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void sD() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void L(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.amd = null;
            if (b.this.ame != null) {
                b.this.ame.ty();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void sE() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.tF();
                    return false;
                case 2:
                    b.this.tP();
                    return false;
                case 3:
                    b.this.tG();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable amg = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.amd != null) {
                if (System.currentTimeMillis() - b.this.amd.sn() < b.this.amf || b.this.amd.aiI < b.this.amd.aiH) {
                    b.this.mHandler.postDelayed(b.this.amg, 1000L);
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
        void p(com.baidu.live.gift.a.b bVar);

        void ty();
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.amc = alaSmallGiftView;
        this.amc.setSmallAnimCallBack(this.ajG);
    }

    public boolean isReady() {
        return this.amd == null;
    }

    public boolean tM() {
        if (this.amd == null || StringUtils.isNull(this.amd.userId)) {
            return false;
        }
        return this.amd.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean q(com.baidu.live.gift.a.b bVar) {
        return (bVar == null || this.amd == null || bVar.priority <= this.amd.priority) ? false : true;
    }

    public boolean r(com.baidu.live.gift.a.b bVar) {
        if (this.amc == null || this.amc.getVisibility() == 0 || this.amd != null || bVar == null || StringUtils.isNull(bVar.userId) || StringUtils.isNull(bVar.giftId)) {
            return false;
        }
        this.amd = bVar;
        tN();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.amg, 1000L);
        return true;
    }

    public void s(com.baidu.live.gift.a.b bVar) {
        tO();
        if (this.ame != null) {
            this.ame.p(this.amd);
            this.amd = null;
        }
        this.amd = bVar;
        tN();
        this.amc.setVisibility(0);
        this.amc.setTag(this.amd.sp());
        this.amc.setData(this.amd, false);
        this.mHandler.postDelayed(this.amg, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void tN() {
        this.amf = this.amd.aiH > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void qT() {
        if (this.amd != null) {
            tO();
            this.amc.setVisibility(4);
            if (this.ame != null) {
                this.ame.p(this.amd);
                this.amd = null;
            }
        }
    }

    public void qU() {
        if (this.ame != null) {
            this.ame.ty();
        }
    }

    public void onDestroy() {
        tO();
        if (this.amc != null) {
            this.amc.onDestroy();
        }
    }

    private void tO() {
        this.mHandler.removeCallbacks(this.amg);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean t(com.baidu.live.gift.a.b bVar) {
        if (this.amd == null || StringUtils.isNull(this.amd.userId) || StringUtils.isNull(this.amd.giftId) || !b(this.amd, bVar)) {
            return false;
        }
        c(this.amd, bVar);
        return true;
    }

    private boolean b(com.baidu.live.gift.a.b bVar, com.baidu.live.gift.a.b bVar2) {
        return bVar != null && !StringUtils.isNull(bVar.aiD) && bVar.aiD.equals(bVar2.aiD) && Math.abs(bVar2.sn() - bVar.sn()) <= 3000 && bVar2.aiH <= 10;
    }

    private void c(com.baidu.live.gift.a.b bVar, com.baidu.live.gift.a.b bVar2) {
        bVar.aiH += bVar2.aiH;
        bVar.A(bVar2.sn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tF() {
        if (this.amd != null) {
            this.amc.setVisibility(0);
            this.amc.setTag(this.amd.sp());
            this.amc.setData(this.amd, false);
            this.amc.tF();
            tP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG() {
        this.amc.tG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP() {
        long j;
        if (this.amc.getVisibility() == 0) {
            this.amc.clearAnimation();
            if (this.amd != null) {
                if (this.amd.aiI >= this.amd.aiH) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.amd.A(System.currentTimeMillis());
                boolean z = this.amd.aiH > 10;
                com.baidu.live.gift.a.b bVar = this.amd;
                if (z) {
                    j = this.amd.aiH;
                } else {
                    com.baidu.live.gift.a.b bVar2 = this.amd;
                    j = bVar2.aiI + 1;
                    bVar2.aiI = j;
                }
                bVar.aiI = j;
                this.amc.e(this.amd.aiH, this.amd.aiI);
            }
        }
    }

    public void rC() {
        if (this.amd != null && this.amd.aiH == this.amd.aiI) {
            this.mHandler.postDelayed(this.amg, 1000L);
        }
    }

    public void a(a aVar) {
        this.ame = aVar;
    }
}
