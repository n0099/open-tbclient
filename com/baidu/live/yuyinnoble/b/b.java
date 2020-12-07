package com.baidu.live.yuyinnoble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.j.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinnoble.d.e;
import com.baidu.live.yuyinnoble.e.b;
/* loaded from: classes4.dex */
public class b implements c {
    private String aOt;
    private boolean bXJ;
    private e bXK;
    private com.baidu.live.yuyinnoble.e.b bXL;
    private com.baidu.live.yuyinnoble.c.a bXM;
    private String brl;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bXN = new b.a() { // from class: com.baidu.live.yuyinnoble.b.b.1
        @Override // com.baidu.live.yuyinnoble.e.b.a
        public void Qi() {
            b.this.Mf();
        }
    };
    private final e.a bXO = new e.a() { // from class: com.baidu.live.yuyinnoble.b.b.2
        @Override // com.baidu.live.yuyinnoble.d.e.a
        public void a(com.baidu.live.yuyinnoble.c.a aVar) {
            b.this.bXM = aVar;
            if (b.this.bXL != null) {
                b.this.bXL.b(aVar);
            }
        }

        @Override // com.baidu.live.yuyinnoble.d.e.a
        public void onFail(int i, String str) {
            if (b.this.mTbPageContext != null) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
            if (b.this.bXL != null && b.this.bXM == null) {
                b.this.bXL.cC(true);
            }
        }
    };

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.brl = str2;
        this.aOt = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.bXK = new e(this.mTbPageContext, this.bXO);
        this.bXL = new com.baidu.live.yuyinnoble.e.b(this.mTbPageContext, this.mLiveId, this.brl, this.mIsHost, this.bXJ);
        this.bXL.a(this.bXN);
        Mf();
    }

    @Override // com.baidu.live.j.c
    public void cb(boolean z) {
    }

    @Override // com.baidu.live.j.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.j.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bXL != null) {
            this.bXL.a(configuration);
        }
    }

    @Override // com.baidu.live.j.c
    public void Mf() {
        if (this.bXK != null) {
            this.bXK.jA(this.mLiveId);
        }
    }

    @Override // com.baidu.live.j.c
    public void cc(boolean z) {
        this.bXJ = z;
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.bXK != null) {
            this.bXK.onDestroy();
        }
    }

    @Override // com.baidu.live.j.c
    public View getView() {
        if (this.bXL != null) {
            return this.bXL.getRootView();
        }
        return null;
    }
}
