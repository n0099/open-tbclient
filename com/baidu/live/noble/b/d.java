package com.baidu.live.noble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class d implements com.baidu.live.k.c {
    private String aKn;
    private String bre;
    private e bsu;
    private com.baidu.live.noble.d.b bsv;
    private com.baidu.live.noble.data.b bsw;
    private long bsx;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bsy = new b.a() { // from class: com.baidu.live.noble.b.d.1
        @Override // com.baidu.live.noble.d.b.a
        public void Nq() {
            d.this.bX(false);
        }
    };
    private final e.a bsz = new e.a() { // from class: com.baidu.live.noble.b.d.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            d.this.bsw = bVar;
            if (d.this.bsv != null) {
                d.this.bsv.b(bVar);
            }
            if (bVar == null) {
                d.this.bsx = 5L;
                d.this.bb(d.this.bsx);
                return;
            }
            if (bVar.bsG <= 0) {
                d.this.bsx = 5L;
            } else {
                d.this.bsx = bVar.bsG;
            }
            d.this.bb(d.this.bsx);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (d.this.mTbPageContext != null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), str);
            }
            d.this.bsx = 5L;
            d.this.bb(d.this.bsx);
            if (d.this.bsv != null && d.this.bsw == null) {
                d.this.bsv.cB(true);
            }
        }
    };
    private final Runnable bsA = new Runnable() { // from class: com.baidu.live.noble.b.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bX(false);
        }
    };

    @Override // com.baidu.live.k.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bre = str2;
        this.aKn = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bsu = new e(this.mTbPageContext, this.bsz);
        this.bsv = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.bre, this.mIsHost);
        this.bsv.a(this.bsy);
    }

    @Override // com.baidu.live.k.c
    public void bW(boolean z) {
        if (z) {
            bX(false);
        } else {
            Np();
        }
    }

    @Override // com.baidu.live.k.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.k.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bsv != null) {
            this.bsv.a(configuration);
        }
    }

    @Override // com.baidu.live.k.c
    public void bX(boolean z) {
        if (this.bsu != null) {
            this.bsu.aC(this.bre, this.mLiveId);
        }
    }

    @Override // com.baidu.live.k.c
    public void bY(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(long j) {
        if (this.mHandler != null && this.bsA != null) {
            this.mHandler.removeCallbacks(this.bsA);
            this.mHandler.postDelayed(this.bsA, 1000 * j);
        }
    }

    private void Np() {
        if (this.mHandler != null && this.bsA != null) {
            this.mHandler.removeCallbacks(this.bsA);
        }
    }

    @Override // com.baidu.live.k.c
    public void onDestroy() {
        if (this.bsu != null) {
            this.bsu.onDestroy();
        }
        Np();
    }

    @Override // com.baidu.live.k.c
    public View getView() {
        if (this.bsv != null) {
            return this.bsv.getRootView();
        }
        return null;
    }
}
