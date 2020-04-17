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
    private AlaSmallGiftView aHH;
    private c aHI;
    private a aHJ;
    private int aHK;
    private AlaSmallGiftView.a aEZ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.smallgift.b.1
        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void yE() {
            b.this.mHandler.sendEmptyMessage(2);
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void P(View view) {
            view.setVisibility(4);
            view.clearAnimation();
            b.this.aHI = null;
            if (b.this.aHJ != null) {
                b.this.aHJ.zJ();
            }
        }

        @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
        public void yF() {
            b.this.mHandler.sendEmptyMessageDelayed(2, 240L);
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.smallgift.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.zQ();
                    return false;
                case 2:
                    b.this.Aa();
                    return false;
                case 3:
                    b.this.zR();
                    return false;
                default:
                    return false;
            }
        }
    });
    private Runnable aHL = new Runnable() { // from class: com.baidu.live.gift.smallgift.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.aHI != null) {
                if (System.currentTimeMillis() - b.this.aHI.yo() < b.this.aHK || b.this.aHI.aEc < b.this.aHI.aEb) {
                    b.this.mHandler.postDelayed(b.this.aHL, 1000L);
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

        void zJ();
    }

    public b(AlaSmallGiftView alaSmallGiftView) {
        this.aHH = alaSmallGiftView;
        this.aHH.setSmallAnimCallBack(this.aEZ);
    }

    public boolean isReady() {
        return this.aHI == null;
    }

    public boolean zX() {
        if (this.aHI == null || StringUtils.isNull(this.aHI.userId)) {
            return false;
        }
        return this.aHI.userId.equals(TbadkCoreApplication.getCurrentAccount());
    }

    public boolean s(c cVar) {
        return (cVar == null || this.aHI == null || cVar.priority <= this.aHI.priority) ? false : true;
    }

    public boolean t(c cVar) {
        if (this.aHH == null || this.aHH.getVisibility() == 0 || this.aHI != null || cVar == null || StringUtils.isNull(cVar.userId) || StringUtils.isNull(cVar.giftId)) {
            return false;
        }
        this.aHI = cVar;
        zY();
        this.mHandler.sendEmptyMessage(1);
        this.mHandler.postDelayed(this.aHL, 1000L);
        return true;
    }

    public void u(c cVar) {
        zZ();
        if (this.aHJ != null) {
            this.aHJ.r(this.aHI);
            this.aHI = null;
        }
        this.aHI = cVar;
        zY();
        this.aHH.setVisibility(0);
        this.aHH.setTag(this.aHI.yq());
        this.aHH.setData(this.aHI, false);
        this.mHandler.postDelayed(this.aHL, 1000L);
        this.mHandler.sendEmptyMessage(2);
    }

    private void zY() {
        this.aHK = this.aHI.aEb > 10 ? SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME : 3000;
    }

    public void wE() {
        if (this.aHI != null) {
            zZ();
            this.aHH.setVisibility(4);
            q.g(this.aHI);
            if (this.aHJ != null) {
                this.aHJ.r(this.aHI);
                this.aHI = null;
            }
        }
    }

    public void wF() {
        if (this.aHJ != null) {
            this.aHJ.zJ();
        }
    }

    public void onDestroy() {
        zZ();
        if (this.aHH != null) {
            this.aHH.onDestroy();
        }
    }

    private void zZ() {
        this.mHandler.removeCallbacks(this.aHL);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    public boolean v(c cVar) {
        if (this.aHI == null || StringUtils.isNull(this.aHI.userId) || StringUtils.isNull(this.aHI.giftId) || !com.baidu.live.gift.smallgift.a.c(this.aHI, cVar)) {
            return false;
        }
        com.baidu.live.gift.smallgift.a.d(this.aHI, cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ() {
        if (this.aHI != null) {
            this.aHH.setVisibility(0);
            this.aHH.setTag(this.aHI.yq());
            this.aHH.setData(this.aHI, false);
            this.aHH.zQ();
            Aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR() {
        if (this.aHI != null) {
            q.g(this.aHI);
        }
        this.aHH.zR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa() {
        long j;
        if (this.aHH.getVisibility() == 0) {
            this.aHH.clearAnimation();
            if (this.aHI != null) {
                if (this.aHI.aEc >= this.aHI.aEb) {
                    this.mHandler.sendEmptyMessageDelayed(2, 240L);
                    return;
                }
                this.aHI.Z(System.currentTimeMillis());
                boolean z = this.aHI.aEb > 10;
                c cVar = this.aHI;
                if (z) {
                    j = this.aHI.aEb;
                } else {
                    c cVar2 = this.aHI;
                    j = cVar2.aEc + 1;
                    cVar2.aEc = j;
                }
                cVar.aEc = j;
                this.aHH.e(this.aHI.aEb, this.aHI.aEc);
            }
        }
    }

    public void xy() {
        if (this.aHI != null && this.aHI.aEb == this.aHI.aEc) {
            this.mHandler.postDelayed(this.aHL, 1000L);
        }
    }

    public void a(a aVar) {
        this.aHJ = aVar;
    }
}
