package com.baidu.live.noble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class c implements com.baidu.live.h.b {
    private String aAL;
    private String aZa;
    private e baf;
    private com.baidu.live.noble.d.b bag;
    private com.baidu.live.noble.data.b bah;
    private long bai;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a baj = new b.a() { // from class: com.baidu.live.noble.b.c.1
        @Override // com.baidu.live.noble.d.b.a
        public void Gl() {
            c.this.Gj();
        }
    };
    private final e.a bak = new e.a() { // from class: com.baidu.live.noble.b.c.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            c.this.bah = bVar;
            if (c.this.bag != null) {
                c.this.bag.b(bVar);
            }
            if (bVar == null) {
                c.this.bai = 5L;
                c.this.ao(c.this.bai);
                return;
            }
            if (bVar.bav <= 0) {
                c.this.bai = 5L;
            } else {
                c.this.bai = bVar.bav;
            }
            c.this.ao(c.this.bai);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (c.this.mTbPageContext != null) {
                BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), str);
            }
            c.this.bai = 5L;
            c.this.ao(c.this.bai);
            if (c.this.bag != null && c.this.bah == null) {
                c.this.bag.bW(true);
            }
        }
    };
    private final Runnable bal = new Runnable() { // from class: com.baidu.live.noble.b.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.Gj();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aZa = str2;
        this.aAL = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.baf = new e(this.mTbPageContext, this.bak);
        this.bag = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.aZa, this.mIsHost);
        this.bag.a(this.baj);
    }

    @Override // com.baidu.live.h.b
    public void bB(boolean z) {
        if (z) {
            Gj();
        } else {
            Gk();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bag != null) {
            this.bag.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj() {
        if (this.baf != null) {
            this.baf.au(this.aZa, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(long j) {
        if (this.mHandler != null && this.bal != null) {
            this.mHandler.removeCallbacks(this.bal);
            this.mHandler.postDelayed(this.bal, 1000 * j);
        }
    }

    private void Gk() {
        if (this.mHandler != null && this.bal != null) {
            this.mHandler.removeCallbacks(this.bal);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.baf != null) {
            this.baf.onDestroy();
        }
        Gk();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bag != null) {
            return this.bag.getRootView();
        }
        return null;
    }
}
