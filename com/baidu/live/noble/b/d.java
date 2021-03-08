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
public class d implements com.baidu.live.j.c {
    private String aOA;
    private String bwh;
    private com.baidu.live.noble.data.b bxA;
    private long bxB;
    private e bxy;
    private com.baidu.live.noble.d.b bxz;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bxC = new b.a() { // from class: com.baidu.live.noble.b.d.1
        @Override // com.baidu.live.noble.d.b.a
        public void OS() {
            d.this.cc(false);
        }
    };
    private final e.a bxD = new e.a() { // from class: com.baidu.live.noble.b.d.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            d.this.bxA = bVar;
            if (d.this.bxz != null) {
                d.this.bxz.b(bVar);
            }
            if (bVar == null) {
                d.this.bxB = 5L;
                d.this.bf(d.this.bxB);
                return;
            }
            if (bVar.bxK <= 0) {
                d.this.bxB = 5L;
            } else {
                d.this.bxB = bVar.bxK;
            }
            d.this.bf(d.this.bxB);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (d.this.mTbPageContext != null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), str);
            }
            d.this.bxB = 5L;
            d.this.bf(d.this.bxB);
            if (d.this.bxz != null && d.this.bxA == null) {
                d.this.bxz.cK(true);
            }
        }
    };
    private final Runnable bxE = new Runnable() { // from class: com.baidu.live.noble.b.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.cc(false);
        }
    };

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bwh = str2;
        this.aOA = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bxy = new e(this.mTbPageContext, this.bxD);
        this.bxz = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.bwh, this.mIsHost);
        this.bxz.a(this.bxC);
    }

    @Override // com.baidu.live.j.c
    public void cb(boolean z) {
        if (z) {
            cc(false);
        } else {
            OR();
        }
    }

    @Override // com.baidu.live.j.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.j.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bxz != null) {
            this.bxz.a(configuration);
        }
    }

    @Override // com.baidu.live.j.c
    public void cc(boolean z) {
        if (this.bxy != null) {
            this.bxy.aC(this.bwh, this.mLiveId);
        }
    }

    @Override // com.baidu.live.j.c
    public void cd(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(long j) {
        if (this.mHandler != null && this.bxE != null) {
            this.mHandler.removeCallbacks(this.bxE);
            this.mHandler.postDelayed(this.bxE, 1000 * j);
        }
    }

    private void OR() {
        if (this.mHandler != null && this.bxE != null) {
            this.mHandler.removeCallbacks(this.bxE);
        }
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.bxy != null) {
            this.bxy.onDestroy();
        }
        OR();
    }

    @Override // com.baidu.live.j.c
    public View getView() {
        if (this.bxz != null) {
            return this.bxz.getRootView();
        }
        return null;
    }
}
