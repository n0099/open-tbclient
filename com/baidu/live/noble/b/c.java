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
    private String aLF;
    private String bla;
    private e bmg;
    private com.baidu.live.noble.d.b bmh;
    private com.baidu.live.noble.data.b bmi;
    private long bmj;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bmk = new b.a() { // from class: com.baidu.live.noble.b.c.1
        @Override // com.baidu.live.noble.d.b.a
        public void NB() {
            c.this.Nz();
        }
    };
    private final e.a bml = new e.a() { // from class: com.baidu.live.noble.b.c.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            c.this.bmi = bVar;
            if (c.this.bmh != null) {
                c.this.bmh.b(bVar);
            }
            if (bVar == null) {
                c.this.bmj = 5L;
                c.this.aq(c.this.bmj);
                return;
            }
            if (bVar.bmw <= 0) {
                c.this.bmj = 5L;
            } else {
                c.this.bmj = bVar.bmw;
            }
            c.this.aq(c.this.bmj);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (c.this.mTbPageContext != null) {
                BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), str);
            }
            c.this.bmj = 5L;
            c.this.aq(c.this.bmj);
            if (c.this.bmh != null && c.this.bmi == null) {
                c.this.bmh.cj(true);
            }
        }
    };
    private final Runnable bmm = new Runnable() { // from class: com.baidu.live.noble.b.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.Nz();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bla = str2;
        this.aLF = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bmg = new e(this.mTbPageContext, this.bml);
        this.bmh = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.bla, this.mIsHost);
        this.bmh.a(this.bmk);
    }

    @Override // com.baidu.live.h.b
    public void bO(boolean z) {
        if (z) {
            Nz();
        } else {
            NA();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bmh != null) {
            this.bmh.a(configuration);
        }
    }

    public void Nz() {
        if (this.bmg != null) {
            this.bmg.aA(this.bla, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(long j) {
        if (this.mHandler != null && this.bmm != null) {
            this.mHandler.removeCallbacks(this.bmm);
            this.mHandler.postDelayed(this.bmm, 1000 * j);
        }
    }

    private void NA() {
        if (this.mHandler != null && this.bmm != null) {
            this.mHandler.removeCallbacks(this.bmm);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bmg != null) {
            this.bmg.onDestroy();
        }
        NA();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bmh != null) {
            return this.bmh.getRootView();
        }
        return null;
    }
}
