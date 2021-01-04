package com.baidu.live.noble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class d implements com.baidu.live.k.c {
    private String aPa;
    private String bvS;
    private e bxi;
    private com.baidu.live.noble.d.b bxj;
    private com.baidu.live.noble.data.b bxk;
    private long bxl;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bxm = new b.a() { // from class: com.baidu.live.noble.b.d.1
        @Override // com.baidu.live.noble.d.b.a
        public void Rl() {
            d.this.cb(false);
        }
    };
    private final e.a bxn = new e.a() { // from class: com.baidu.live.noble.b.d.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            d.this.bxk = bVar;
            if (d.this.bxj != null) {
                d.this.bxj.b(bVar);
            }
            if (bVar == null) {
                d.this.bxl = 5L;
                d.this.bb(d.this.bxl);
                return;
            }
            if (bVar.bxu <= 0) {
                d.this.bxl = 5L;
            } else {
                d.this.bxl = bVar.bxu;
            }
            d.this.bb(d.this.bxl);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (d.this.mTbPageContext != null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), str);
            }
            d.this.bxl = 5L;
            d.this.bb(d.this.bxl);
            if (d.this.bxj != null && d.this.bxk == null) {
                d.this.bxj.cF(true);
            }
        }
    };
    private final Runnable bxo = new Runnable() { // from class: com.baidu.live.noble.b.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.cb(false);
        }
    };

    @Override // com.baidu.live.k.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bvS = str2;
        this.aPa = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bxi = new e(this.mTbPageContext, this.bxn);
        this.bxj = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.bvS, this.mIsHost);
        this.bxj.a(this.bxm);
    }

    @Override // com.baidu.live.k.c
    public void ca(boolean z) {
        if (z) {
            cb(false);
        } else {
            Rk();
        }
    }

    @Override // com.baidu.live.k.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.k.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bxj != null) {
            this.bxj.a(configuration);
        }
    }

    @Override // com.baidu.live.k.c
    public void cb(boolean z) {
        if (this.bxi != null) {
            this.bxi.aD(this.bvS, this.mLiveId);
        }
    }

    @Override // com.baidu.live.k.c
    public void cc(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(long j) {
        if (this.mHandler != null && this.bxo != null) {
            this.mHandler.removeCallbacks(this.bxo);
            this.mHandler.postDelayed(this.bxo, 1000 * j);
        }
    }

    private void Rk() {
        if (this.mHandler != null && this.bxo != null) {
            this.mHandler.removeCallbacks(this.bxo);
        }
    }

    @Override // com.baidu.live.k.c
    public void onDestroy() {
        if (this.bxi != null) {
            this.bxi.onDestroy();
        }
        Rk();
    }

    @Override // com.baidu.live.k.c
    public View getView() {
        if (this.bxj != null) {
            return this.bxj.getRootView();
        }
        return null;
    }
}
