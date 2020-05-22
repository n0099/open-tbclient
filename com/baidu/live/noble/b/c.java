package com.baidu.live.noble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c implements com.baidu.live.h.b {
    private String aWr;
    private long aXA;
    private e aXx;
    private com.baidu.live.noble.d.b aXy;
    private com.baidu.live.noble.data.b aXz;
    private String ayw;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a aXB = new b.a() { // from class: com.baidu.live.noble.b.c.1
        @Override // com.baidu.live.noble.d.b.a
        public void FC() {
            c.this.FA();
        }
    };
    private final e.a aXC = new e.a() { // from class: com.baidu.live.noble.b.c.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            c.this.aXz = bVar;
            if (c.this.aXy != null) {
                c.this.aXy.b(bVar);
            }
            if (bVar == null) {
                c.this.aXA = 5L;
                c.this.ao(c.this.aXA);
                return;
            }
            if (bVar.aXN <= 0) {
                c.this.aXA = 5L;
            } else {
                c.this.aXA = bVar.aXN;
            }
            c.this.ao(c.this.aXA);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (c.this.mTbPageContext != null) {
                BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), str);
            }
            c.this.aXA = 5L;
            c.this.ao(c.this.aXA);
            if (c.this.aXy != null && c.this.aXz == null) {
                c.this.aXy.bU(true);
            }
        }
    };
    private final Runnable aXD = new Runnable() { // from class: com.baidu.live.noble.b.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.FA();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aWr = str2;
        this.ayw = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.aXx = new e(this.mTbPageContext, this.aXC);
        this.aXy = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.aWr, this.mIsHost);
        this.aXy.a(this.aXB);
    }

    @Override // com.baidu.live.h.b
    public void bB(boolean z) {
        if (z) {
            FA();
        } else {
            FB();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.aXy != null) {
            this.aXy.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.aXx != null) {
            this.aXx.at(this.aWr, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(long j) {
        if (this.mHandler != null && this.aXD != null) {
            this.mHandler.removeCallbacks(this.aXD);
            this.mHandler.postDelayed(this.aXD, 1000 * j);
        }
    }

    private void FB() {
        if (this.mHandler != null && this.aXD != null) {
            this.mHandler.removeCallbacks(this.aXD);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.aXx != null) {
            this.aXx.onDestroy();
        }
        FB();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.aXy != null) {
            return this.aXy.getRootView();
        }
        return null;
    }
}
