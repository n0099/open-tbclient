package com.baidu.live.noble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class d implements com.baidu.live.h.b {
    private String aLy;
    private String bme;
    private e bnp;
    private com.baidu.live.noble.d.b bnq;
    private com.baidu.live.noble.data.b bnr;
    private long bns;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bnt = new b.a() { // from class: com.baidu.live.noble.b.d.1
        @Override // com.baidu.live.noble.d.b.a
        public void NP() {
            d.this.Kd();
        }
    };
    private final e.a bnu = new e.a() { // from class: com.baidu.live.noble.b.d.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            d.this.bnr = bVar;
            if (d.this.bnq != null) {
                d.this.bnq.b(bVar);
            }
            if (bVar == null) {
                d.this.bns = 5L;
                d.this.aD(d.this.bns);
                return;
            }
            if (bVar.bnB <= 0) {
                d.this.bns = 5L;
            } else {
                d.this.bns = bVar.bnB;
            }
            d.this.aD(d.this.bns);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (d.this.mTbPageContext != null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), str);
            }
            d.this.bns = 5L;
            d.this.aD(d.this.bns);
            if (d.this.bnq != null && d.this.bnr == null) {
                d.this.bnq.co(true);
            }
        }
    };
    private final Runnable bnv = new Runnable() { // from class: com.baidu.live.noble.b.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.Kd();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bme = str2;
        this.aLy = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bnp = new e(this.mTbPageContext, this.bnu);
        this.bnq = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.bme, this.mIsHost);
        this.bnq.a(this.bnt);
    }

    @Override // com.baidu.live.h.b
    public void bS(boolean z) {
        if (z) {
            Kd();
        } else {
            NO();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bnq != null) {
            this.bnq.a(configuration);
        }
    }

    @Override // com.baidu.live.h.b
    public void Kd() {
        if (this.bnp != null) {
            this.bnp.aB(this.bme, this.mLiveId);
        }
    }

    @Override // com.baidu.live.h.b
    public void bT(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(long j) {
        if (this.mHandler != null && this.bnv != null) {
            this.mHandler.removeCallbacks(this.bnv);
            this.mHandler.postDelayed(this.bnv, 1000 * j);
        }
    }

    private void NO() {
        if (this.mHandler != null && this.bnv != null) {
            this.mHandler.removeCallbacks(this.bnv);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bnp != null) {
            this.bnp.onDestroy();
        }
        NO();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bnq != null) {
            return this.bnq.getRootView();
        }
        return null;
    }
}
