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
    private String aMj;
    private String bmv;
    private e bnH;
    private com.baidu.live.noble.d.b bnI;
    private com.baidu.live.noble.data.b bnJ;
    private long bnK;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bnL = new b.a() { // from class: com.baidu.live.noble.b.d.1
        @Override // com.baidu.live.noble.d.b.a
        public void NY() {
            d.this.Km();
        }
    };
    private final e.a bnM = new e.a() { // from class: com.baidu.live.noble.b.d.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            d.this.bnJ = bVar;
            if (d.this.bnI != null) {
                d.this.bnI.b(bVar);
            }
            if (bVar == null) {
                d.this.bnK = 5L;
                d.this.ar(d.this.bnK);
                return;
            }
            if (bVar.bnT <= 0) {
                d.this.bnK = 5L;
            } else {
                d.this.bnK = bVar.bnT;
            }
            d.this.ar(d.this.bnK);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (d.this.mTbPageContext != null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), str);
            }
            d.this.bnK = 5L;
            d.this.ar(d.this.bnK);
            if (d.this.bnI != null && d.this.bnJ == null) {
                d.this.bnI.cl(true);
            }
        }
    };
    private final Runnable bnN = new Runnable() { // from class: com.baidu.live.noble.b.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.Km();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bmv = str2;
        this.aMj = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bnH = new e(this.mTbPageContext, this.bnM);
        this.bnI = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.bmv, this.mIsHost);
        this.bnI.a(this.bnL);
    }

    @Override // com.baidu.live.h.b
    public void bP(boolean z) {
        if (z) {
            Km();
        } else {
            NX();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bnI != null) {
            this.bnI.a(configuration);
        }
    }

    @Override // com.baidu.live.h.b
    public void Km() {
        if (this.bnH != null) {
            this.bnH.aB(this.bmv, this.mLiveId);
        }
    }

    @Override // com.baidu.live.h.b
    public void bQ(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(long j) {
        if (this.mHandler != null && this.bnN != null) {
            this.mHandler.removeCallbacks(this.bnN);
            this.mHandler.postDelayed(this.bnN, 1000 * j);
        }
    }

    private void NX() {
        if (this.mHandler != null && this.bnN != null) {
            this.mHandler.removeCallbacks(this.bnN);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bnH != null) {
            this.bnH.onDestroy();
        }
        NX();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bnI != null) {
            return this.bnI.getRootView();
        }
        return null;
    }
}
