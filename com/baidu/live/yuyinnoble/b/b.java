package com.baidu.live.yuyinnoble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.j.c;
import com.baidu.live.noble.data.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinnoble.c.e;
import com.baidu.live.yuyinnoble.d.b;
/* loaded from: classes10.dex */
public class b implements c {
    private String aOA;
    private String bwh;
    private d bws;
    private boolean cfl;
    private e cfm;
    private com.baidu.live.yuyinnoble.d.b cfn;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a cfo = new b.a() { // from class: com.baidu.live.yuyinnoble.b.b.1
        @Override // com.baidu.live.yuyinnoble.d.b.a
        public void OS() {
            b.this.cc(true);
        }
    };
    private final e.a cfp = new e.a() { // from class: com.baidu.live.yuyinnoble.b.b.2
        @Override // com.baidu.live.yuyinnoble.c.e.a
        public void a(d dVar) {
            b.this.bws = dVar;
            if (b.this.cfn != null) {
                b.this.cfn.b(dVar);
                b.this.cfn.dR(false);
            }
        }

        @Override // com.baidu.live.yuyinnoble.c.e.a
        public void onFail(int i, String str) {
            if (b.this.mTbPageContext != null) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
            if (b.this.cfn != null) {
                if (b.this.bws == null) {
                    b.this.cfn.cK(true);
                }
                b.this.cfn.dR(false);
            }
        }
    };

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bwh = str2;
        this.aOA = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.cfm = new e(this.mTbPageContext, this.cfp);
        this.cfn = new com.baidu.live.yuyinnoble.d.b(this.mTbPageContext, this.mLiveId, this.bwh, this.mIsHost, this.cfl);
        this.cfn.a(this.cfo);
        cc(true);
    }

    @Override // com.baidu.live.j.c
    public void cb(boolean z) {
    }

    @Override // com.baidu.live.j.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.yuyin_noble_title) : "";
    }

    @Override // com.baidu.live.j.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.cfn != null) {
            this.cfn.a(configuration);
        }
    }

    @Override // com.baidu.live.j.c
    public void cc(boolean z) {
        if (this.cfm != null) {
            this.cfm.iU(this.mLiveId);
        }
        if (this.cfn != null) {
            this.cfn.dR(z);
        }
    }

    @Override // com.baidu.live.j.c
    public void cd(boolean z) {
        this.cfl = z;
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.cfm != null) {
            this.cfm.onDestroy();
        }
    }

    @Override // com.baidu.live.j.c
    public View getView() {
        if (this.cfn != null) {
            return this.cfn.getRootView();
        }
        return null;
    }
}
