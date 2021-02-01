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
public class d implements com.baidu.live.j.c {
    private String aNa;
    private String buH;
    private e bvY;
    private com.baidu.live.noble.d.b bvZ;
    private com.baidu.live.noble.data.b bwa;
    private long bwb;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bwc = new b.a() { // from class: com.baidu.live.noble.b.d.1
        @Override // com.baidu.live.noble.d.b.a
        public void OP() {
            d.this.cc(false);
        }
    };
    private final e.a bwd = new e.a() { // from class: com.baidu.live.noble.b.d.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            d.this.bwa = bVar;
            if (d.this.bvZ != null) {
                d.this.bvZ.b(bVar);
            }
            if (bVar == null) {
                d.this.bwb = 5L;
                d.this.bf(d.this.bwb);
                return;
            }
            if (bVar.bwk <= 0) {
                d.this.bwb = 5L;
            } else {
                d.this.bwb = bVar.bwk;
            }
            d.this.bf(d.this.bwb);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (d.this.mTbPageContext != null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), str);
            }
            d.this.bwb = 5L;
            d.this.bf(d.this.bwb);
            if (d.this.bvZ != null && d.this.bwa == null) {
                d.this.bvZ.cK(true);
            }
        }
    };
    private final Runnable bwe = new Runnable() { // from class: com.baidu.live.noble.b.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.cc(false);
        }
    };

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.buH = str2;
        this.aNa = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bvY = new e(this.mTbPageContext, this.bwd);
        this.bvZ = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.buH, this.mIsHost);
        this.bvZ.a(this.bwc);
    }

    @Override // com.baidu.live.j.c
    public void cb(boolean z) {
        if (z) {
            cc(false);
        } else {
            OO();
        }
    }

    @Override // com.baidu.live.j.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.j.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bvZ != null) {
            this.bvZ.a(configuration);
        }
    }

    @Override // com.baidu.live.j.c
    public void cc(boolean z) {
        if (this.bvY != null) {
            this.bvY.aC(this.buH, this.mLiveId);
        }
    }

    @Override // com.baidu.live.j.c
    public void cd(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(long j) {
        if (this.mHandler != null && this.bwe != null) {
            this.mHandler.removeCallbacks(this.bwe);
            this.mHandler.postDelayed(this.bwe, 1000 * j);
        }
    }

    private void OO() {
        if (this.mHandler != null && this.bwe != null) {
            this.mHandler.removeCallbacks(this.bwe);
        }
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.bvY != null) {
            this.bvY.onDestroy();
        }
        OO();
    }

    @Override // com.baidu.live.j.c
    public View getView() {
        if (this.bvZ != null) {
            return this.bvZ.getRootView();
        }
        return null;
    }
}
