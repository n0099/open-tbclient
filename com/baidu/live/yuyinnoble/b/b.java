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
    private String aLy;
    private boolean bSt;
    private e bSu;
    private com.baidu.live.yuyinnoble.e.b bSv;
    private com.baidu.live.yuyinnoble.c.a bSw;
    private String bme;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bSx = new b.a() { // from class: com.baidu.live.yuyinnoble.b.b.1
        @Override // com.baidu.live.yuyinnoble.e.b.a
        public void NP() {
            b.this.Kd();
        }
    };
    private final e.a bSy = new e.a() { // from class: com.baidu.live.yuyinnoble.b.b.2
        @Override // com.baidu.live.yuyinnoble.d.e.a
        public void a(com.baidu.live.yuyinnoble.c.a aVar) {
            b.this.bSw = aVar;
            if (b.this.bSv != null) {
                b.this.bSv.b(aVar);
            }
        }

        @Override // com.baidu.live.yuyinnoble.d.e.a
        public void onFail(int i, String str) {
            if (b.this.mTbPageContext != null) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
            if (b.this.bSv != null && b.this.bSw == null) {
                b.this.bSv.co(true);
            }
        }
    };

    @Override // com.baidu.live.h.b
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bme = str2;
        this.aLy = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bSu = new e(this.mTbPageContext, this.bSy);
        this.bSv = new com.baidu.live.yuyinnoble.e.b(this.mTbPageContext, this.mLiveId, this.bme, this.mIsHost, this.bSt);
        this.bSv.a(this.bSx);
        Kd();
    }

    @Override // com.baidu.live.h.b
    public void bS(boolean z) {
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bSv != null) {
            this.bSv.a(configuration);
        }
    }

    @Override // com.baidu.live.h.b
    public void Kd() {
        if (this.bSu != null) {
            this.bSu.iW(this.mLiveId);
        }
    }

    @Override // com.baidu.live.h.b
    public void bT(boolean z) {
        this.bSt = z;
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bSu != null) {
            this.bSu.onDestroy();
        }
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bSv != null) {
            return this.bSv.getRootView();
        }
        return null;
    }
}
