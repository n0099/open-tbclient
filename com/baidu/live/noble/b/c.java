package com.baidu.live.noble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class c implements com.baidu.live.h.b {
    private String aHk;
    private String beu;
    private e bfB;
    private com.baidu.live.noble.d.b bfC;
    private com.baidu.live.noble.data.b bfD;
    private long bfE;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bfF = new b.a() { // from class: com.baidu.live.noble.b.c.1
        @Override // com.baidu.live.noble.d.b.a
        public void LT() {
            c.this.LR();
        }
    };
    private final e.a bfG = new e.a() { // from class: com.baidu.live.noble.b.c.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            c.this.bfD = bVar;
            if (c.this.bfC != null) {
                c.this.bfC.b(bVar);
            }
            if (bVar == null) {
                c.this.bfE = 5L;
                c.this.ap(c.this.bfE);
                return;
            }
            if (bVar.bfR <= 0) {
                c.this.bfE = 5L;
            } else {
                c.this.bfE = bVar.bfR;
            }
            c.this.ap(c.this.bfE);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (c.this.mTbPageContext != null) {
                BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), str);
            }
            c.this.bfE = 5L;
            c.this.ap(c.this.bfE);
            if (c.this.bfC != null && c.this.bfD == null) {
                c.this.bfC.cf(true);
            }
        }
    };
    private final Runnable bfH = new Runnable() { // from class: com.baidu.live.noble.b.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.LR();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.beu = str2;
        this.aHk = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bfB = new e(this.mTbPageContext, this.bfG);
        this.bfC = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.beu, this.mIsHost);
        this.bfC.a(this.bfF);
    }

    @Override // com.baidu.live.h.b
    public void bJ(boolean z) {
        if (z) {
            LR();
        } else {
            LS();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bfC != null) {
            this.bfC.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LR() {
        if (this.bfB != null) {
            this.bfB.ax(this.beu, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(long j) {
        if (this.mHandler != null && this.bfH != null) {
            this.mHandler.removeCallbacks(this.bfH);
            this.mHandler.postDelayed(this.bfH, 1000 * j);
        }
    }

    private void LS() {
        if (this.mHandler != null && this.bfH != null) {
            this.mHandler.removeCallbacks(this.bfH);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bfB != null) {
            this.bfB.onDestroy();
        }
        LS();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bfC != null) {
            return this.bfC.getRootView();
        }
        return null;
    }
}
