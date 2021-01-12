package com.baidu.live.yuyinnoble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.c;
import com.baidu.live.noble.data.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinnoble.c.e;
import com.baidu.live.yuyinnoble.d.b;
/* loaded from: classes10.dex */
public class b implements c {
    private String aKn;
    private boolean bZF;
    private e bZG;
    private com.baidu.live.yuyinnoble.d.b bZH;
    private String bre;
    private d brp;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bZI = new b.a() { // from class: com.baidu.live.yuyinnoble.b.b.1
        @Override // com.baidu.live.yuyinnoble.d.b.a
        public void Nq() {
            b.this.bX(true);
        }
    };
    private final e.a bZJ = new e.a() { // from class: com.baidu.live.yuyinnoble.b.b.2
        @Override // com.baidu.live.yuyinnoble.c.e.a
        public void a(d dVar) {
            b.this.brp = dVar;
            if (b.this.bZH != null) {
                b.this.bZH.b(dVar);
                b.this.bZH.dJ(false);
            }
        }

        @Override // com.baidu.live.yuyinnoble.c.e.a
        public void onFail(int i, String str) {
            if (b.this.mTbPageContext != null) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
            if (b.this.bZH != null) {
                if (b.this.brp == null) {
                    b.this.bZH.cB(true);
                }
                b.this.bZH.dJ(false);
            }
        }
    };

    @Override // com.baidu.live.k.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bre = str2;
        this.aKn = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bZG = new e(this.mTbPageContext, this.bZJ);
        this.bZH = new com.baidu.live.yuyinnoble.d.b(this.mTbPageContext, this.mLiveId, this.bre, this.mIsHost, this.bZF);
        this.bZH.a(this.bZI);
        bX(true);
    }

    @Override // com.baidu.live.k.c
    public void bW(boolean z) {
    }

    @Override // com.baidu.live.k.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.yuyin_noble_title) : "";
    }

    @Override // com.baidu.live.k.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bZH != null) {
            this.bZH.a(configuration);
        }
    }

    @Override // com.baidu.live.k.c
    public void bX(boolean z) {
        if (this.bZG != null) {
            this.bZG.ii(this.mLiveId);
        }
        if (this.bZH != null) {
            this.bZH.dJ(z);
        }
    }

    @Override // com.baidu.live.k.c
    public void bY(boolean z) {
        this.bZF = z;
    }

    @Override // com.baidu.live.k.c
    public void onDestroy() {
        if (this.bZG != null) {
            this.bZG.onDestroy();
        }
    }

    @Override // com.baidu.live.k.c
    public View getView() {
        if (this.bZH != null) {
            return this.bZH.getRootView();
        }
        return null;
    }
}
