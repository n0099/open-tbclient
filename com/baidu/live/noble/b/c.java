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
    private String aIB;
    private String bhk;
    private e bit;
    private com.baidu.live.noble.d.b biu;
    private com.baidu.live.noble.data.b biv;
    private long biw;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bix = new b.a() { // from class: com.baidu.live.noble.b.c.1
        @Override // com.baidu.live.noble.d.b.a
        public void Mw() {
            c.this.Mu();
        }
    };
    private final e.a biy = new e.a() { // from class: com.baidu.live.noble.b.c.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            c.this.biv = bVar;
            if (c.this.biu != null) {
                c.this.biu.b(bVar);
            }
            if (bVar == null) {
                c.this.biw = 5L;
                c.this.ap(c.this.biw);
                return;
            }
            if (bVar.biJ <= 0) {
                c.this.biw = 5L;
            } else {
                c.this.biw = bVar.biJ;
            }
            c.this.ap(c.this.biw);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (c.this.mTbPageContext != null) {
                BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), str);
            }
            c.this.biw = 5L;
            c.this.ap(c.this.biw);
            if (c.this.biu != null && c.this.biv == null) {
                c.this.biu.cg(true);
            }
        }
    };
    private final Runnable biz = new Runnable() { // from class: com.baidu.live.noble.b.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.Mu();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bhk = str2;
        this.aIB = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bit = new e(this.mTbPageContext, this.biy);
        this.biu = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.bhk, this.mIsHost);
        this.biu.a(this.bix);
    }

    @Override // com.baidu.live.h.b
    public void bL(boolean z) {
        if (z) {
            Mu();
        } else {
            Mv();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.biu != null) {
            this.biu.a(configuration);
        }
    }

    public void Mu() {
        if (this.bit != null) {
            this.bit.ax(this.bhk, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(long j) {
        if (this.mHandler != null && this.biz != null) {
            this.mHandler.removeCallbacks(this.biz);
            this.mHandler.postDelayed(this.biz, 1000 * j);
        }
    }

    private void Mv() {
        if (this.mHandler != null && this.biz != null) {
            this.mHandler.removeCallbacks(this.biz);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bit != null) {
            this.bit.onDestroy();
        }
        Mv();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.biu != null) {
            return this.biu.getRootView();
        }
        return null;
    }
}
