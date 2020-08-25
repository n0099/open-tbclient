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
    private String aHi;
    private String ber;
    private com.baidu.live.noble.d.b bfA;
    private com.baidu.live.noble.data.b bfB;
    private long bfC;
    private e bfz;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bfD = new b.a() { // from class: com.baidu.live.noble.b.c.1
        @Override // com.baidu.live.noble.d.b.a
        public void LT() {
            c.this.LR();
        }
    };
    private final e.a bfE = new e.a() { // from class: com.baidu.live.noble.b.c.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            c.this.bfB = bVar;
            if (c.this.bfA != null) {
                c.this.bfA.b(bVar);
            }
            if (bVar == null) {
                c.this.bfC = 5L;
                c.this.ap(c.this.bfC);
                return;
            }
            if (bVar.bfP <= 0) {
                c.this.bfC = 5L;
            } else {
                c.this.bfC = bVar.bfP;
            }
            c.this.ap(c.this.bfC);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (c.this.mTbPageContext != null) {
                BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), str);
            }
            c.this.bfC = 5L;
            c.this.ap(c.this.bfC);
            if (c.this.bfA != null && c.this.bfB == null) {
                c.this.bfA.cf(true);
            }
        }
    };
    private final Runnable bfF = new Runnable() { // from class: com.baidu.live.noble.b.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.LR();
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.ber = str2;
        this.aHi = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bfz = new e(this.mTbPageContext, this.bfE);
        this.bfA = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.ber, this.mIsHost);
        this.bfA.a(this.bfD);
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
        if (this.bfA != null) {
            this.bfA.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LR() {
        if (this.bfz != null) {
            this.bfz.ax(this.ber, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(long j) {
        if (this.mHandler != null && this.bfF != null) {
            this.mHandler.removeCallbacks(this.bfF);
            this.mHandler.postDelayed(this.bfF, 1000 * j);
        }
    }

    private void LS() {
        if (this.mHandler != null && this.bfF != null) {
            this.mHandler.removeCallbacks(this.bfF);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bfz != null) {
            this.bfz.onDestroy();
        }
        LS();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bfA != null) {
            return this.bfA.getRootView();
        }
        return null;
    }
}
