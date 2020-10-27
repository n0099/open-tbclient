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
    private String aMj;
    private boolean bOt;
    private e bOu;
    private com.baidu.live.yuyinnoble.e.b bOv;
    private com.baidu.live.yuyinnoble.c.a bOw;
    private String bmv;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bOx = new b.a() { // from class: com.baidu.live.yuyinnoble.b.b.1
        @Override // com.baidu.live.yuyinnoble.e.b.a
        public void NY() {
            b.this.Km();
        }
    };
    private final e.a bOy = new e.a() { // from class: com.baidu.live.yuyinnoble.b.b.2
        @Override // com.baidu.live.yuyinnoble.d.e.a
        public void a(com.baidu.live.yuyinnoble.c.a aVar) {
            b.this.bOw = aVar;
            if (b.this.bOv != null) {
                b.this.bOv.b(aVar);
            }
        }

        @Override // com.baidu.live.yuyinnoble.d.e.a
        public void onFail(int i, String str) {
            if (b.this.mTbPageContext != null) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
            if (b.this.bOv != null && b.this.bOw == null) {
                b.this.bOv.cl(true);
            }
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
        this.bOu = new e(this.mTbPageContext, this.bOy);
        this.bOv = new com.baidu.live.yuyinnoble.e.b(this.mTbPageContext, this.mLiveId, this.bmv, this.mIsHost, this.bOt);
        this.bOv.a(this.bOx);
        Km();
    }

    @Override // com.baidu.live.h.b
    public void bP(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.i.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bOv != null) {
            this.bOv.a(configuration);
        }
    }

    @Override // com.baidu.live.h.b
    public void Km() {
        if (this.bOu != null) {
            this.bOu.iP(this.mLiveId);
        }
    }

    @Override // com.baidu.live.h.b
    public void bQ(boolean z) {
        this.bOt = z;
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bOu != null) {
            this.bOu.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bOv != null) {
            return this.bOv.getRootView();
        }
        return null;
    }
}
