package com.baidu.live.yuyinnoble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinnoble.d.e;
import com.baidu.live.yuyinnoble.e.b;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.h.b {
    private String aNj;
    private boolean bUd;
    private e bUe;
    private com.baidu.live.yuyinnoble.e.b bUf;
    private com.baidu.live.yuyinnoble.c.a bUg;
    private String bnP;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bUh = new b.a() { // from class: com.baidu.live.yuyinnoble.b.b.1
        @Override // com.baidu.live.yuyinnoble.e.b.a
        public void Oy() {
            b.this.KM();
        }
    };
    private final e.a bUi = new e.a() { // from class: com.baidu.live.yuyinnoble.b.b.2
        @Override // com.baidu.live.yuyinnoble.d.e.a
        public void a(com.baidu.live.yuyinnoble.c.a aVar) {
            b.this.bUg = aVar;
            if (b.this.bUf != null) {
                b.this.bUf.b(aVar);
            }
        }

        @Override // com.baidu.live.yuyinnoble.d.e.a
        public void onFail(int i, String str) {
            if (b.this.mTbPageContext != null) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
            if (b.this.bUf != null && b.this.bUg == null) {
                b.this.bUf.cm(true);
            }
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bnP = str2;
        this.aNj = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bUe = new e(this.mTbPageContext, this.bUi);
        this.bUf = new com.baidu.live.yuyinnoble.e.b(this.mTbPageContext, this.mLiveId, this.bnP, this.mIsHost, this.bUd);
        this.bUf.a(this.bUh);
        KM();
    }

    @Override // com.baidu.live.h.b
    public void bQ(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bUf != null) {
            this.bUf.a(configuration);
        }
    }

    @Override // com.baidu.live.h.b
    public void KM() {
        if (this.bUe != null) {
            this.bUe.jc(this.mLiveId);
        }
    }

    @Override // com.baidu.live.h.b
    public void bR(boolean z) {
        this.bUd = z;
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bUe != null) {
            this.bUe.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bUf != null) {
            return this.bUf.getRootView();
        }
        return null;
    }
}
