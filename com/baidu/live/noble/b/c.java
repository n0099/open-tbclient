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
public class c implements com.baidu.live.h.b {
    private String aBY;
    private String aYY;
    private e bad;
    private com.baidu.live.noble.d.b bae;
    private com.baidu.live.noble.data.b baf;
    private long bag;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bah = new b.a() { // from class: com.baidu.live.noble.b.c.1
        @Override // com.baidu.live.noble.d.b.a
        public void Gf() {
            c.this.Gd();
        }
    };
    private final e.a bai = new e.a() { // from class: com.baidu.live.noble.b.c.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            c.this.baf = bVar;
            if (c.this.bae != null) {
                c.this.bae.b(bVar);
            }
            if (bVar == null) {
                c.this.bag = 5L;
                c.this.ao(c.this.bag);
                return;
            }
            if (bVar.bau <= 0) {
                c.this.bag = 5L;
            } else {
                c.this.bag = bVar.bau;
            }
            c.this.ao(c.this.bag);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (c.this.mTbPageContext != null) {
                BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), str);
            }
            c.this.bag = 5L;
            c.this.ao(c.this.bag);
            if (c.this.bae != null && c.this.baf == null) {
                c.this.bae.bX(true);
            }
        }
    };
    private final Runnable baj = new Runnable() { // from class: com.baidu.live.noble.b.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.Gd();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aYY = str2;
        this.aBY = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bad = new e(this.mTbPageContext, this.bai);
        this.bae = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.aYY, this.mIsHost);
        this.bae.a(this.bah);
    }

    @Override // com.baidu.live.h.b
    public void bE(boolean z) {
        if (z) {
            Gd();
        } else {
            Ge();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bae != null) {
            this.bae.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gd() {
        if (this.bad != null) {
            this.bad.at(this.aYY, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(long j) {
        if (this.mHandler != null && this.baj != null) {
            this.mHandler.removeCallbacks(this.baj);
            this.mHandler.postDelayed(this.baj, 1000 * j);
        }
    }

    private void Ge() {
        if (this.mHandler != null && this.baj != null) {
            this.mHandler.removeCallbacks(this.baj);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bad != null) {
            this.bad.onDestroy();
        }
        Ge();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bae != null) {
            return this.bae.getRootView();
        }
        return null;
    }
}
