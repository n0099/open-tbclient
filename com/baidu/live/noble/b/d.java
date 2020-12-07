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
public class d implements com.baidu.live.j.c {
    private String aOt;
    private String brl;
    private long bsA;
    private e bsx;
    private com.baidu.live.noble.d.b bsy;
    private com.baidu.live.noble.data.b bsz;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bsB = new b.a() { // from class: com.baidu.live.noble.b.d.1
        @Override // com.baidu.live.noble.d.b.a
        public void Qi() {
            d.this.Mf();
        }
    };
    private final e.a bsC = new e.a() { // from class: com.baidu.live.noble.b.d.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            d.this.bsz = bVar;
            if (d.this.bsy != null) {
                d.this.bsy.b(bVar);
            }
            if (bVar == null) {
                d.this.bsA = 5L;
                d.this.bb(d.this.bsA);
                return;
            }
            if (bVar.bsJ <= 0) {
                d.this.bsA = 5L;
            } else {
                d.this.bsA = bVar.bsJ;
            }
            d.this.bb(d.this.bsA);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (d.this.mTbPageContext != null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), str);
            }
            d.this.bsA = 5L;
            d.this.bb(d.this.bsA);
            if (d.this.bsy != null && d.this.bsz == null) {
                d.this.bsy.cC(true);
            }
        }
    };
    private final Runnable bsD = new Runnable() { // from class: com.baidu.live.noble.b.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.Mf();
        }
    };

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.brl = str2;
        this.aOt = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bsx = new e(this.mTbPageContext, this.bsC);
        this.bsy = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.brl, this.mIsHost);
        this.bsy.a(this.bsB);
    }

    @Override // com.baidu.live.j.c
    public void cb(boolean z) {
        if (z) {
            Mf();
        } else {
            Qh();
        }
    }

    @Override // com.baidu.live.j.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.j.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bsy != null) {
            this.bsy.a(configuration);
        }
    }

    @Override // com.baidu.live.j.c
    public void Mf() {
        if (this.bsx != null) {
            this.bsx.aF(this.brl, this.mLiveId);
        }
    }

    @Override // com.baidu.live.j.c
    public void cc(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(long j) {
        if (this.mHandler != null && this.bsD != null) {
            this.mHandler.removeCallbacks(this.bsD);
            this.mHandler.postDelayed(this.bsD, 1000 * j);
        }
    }

    private void Qh() {
        if (this.mHandler != null && this.bsD != null) {
            this.mHandler.removeCallbacks(this.bsD);
        }
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.bsx != null) {
            this.bsx.onDestroy();
        }
        Qh();
    }

    @Override // com.baidu.live.j.c
    public View getView() {
        if (this.bsy != null) {
            return this.bsy.getRootView();
        }
        return null;
    }
}
