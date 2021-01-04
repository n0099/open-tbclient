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
/* loaded from: classes11.dex */
public class b implements c {
    private String aPa;
    private String bvS;
    private d bwd;
    private boolean cev;
    private e cew;
    private com.baidu.live.yuyinnoble.d.b cex;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a cey = new b.a() { // from class: com.baidu.live.yuyinnoble.b.b.1
        @Override // com.baidu.live.yuyinnoble.d.b.a
        public void Rl() {
            b.this.cb(true);
        }
    };
    private final e.a cez = new e.a() { // from class: com.baidu.live.yuyinnoble.b.b.2
        @Override // com.baidu.live.yuyinnoble.c.e.a
        public void a(d dVar) {
            b.this.bwd = dVar;
            if (b.this.cex != null) {
                b.this.cex.b(dVar);
                b.this.cex.dN(false);
            }
        }

        @Override // com.baidu.live.yuyinnoble.c.e.a
        public void onFail(int i, String str) {
            if (b.this.mTbPageContext != null) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
            if (b.this.cex != null) {
                if (b.this.bwd == null) {
                    b.this.cex.cF(true);
                }
                b.this.cex.dN(false);
            }
        }
    };

    @Override // com.baidu.live.k.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bvS = str2;
        this.aPa = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.cew = new e(this.mTbPageContext, this.cez);
        this.cex = new com.baidu.live.yuyinnoble.d.b(this.mTbPageContext, this.mLiveId, this.bvS, this.mIsHost, this.cev);
        this.cex.a(this.cey);
        cb(true);
    }

    @Override // com.baidu.live.k.c
    public void ca(boolean z) {
    }

    @Override // com.baidu.live.k.c
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.yuyin_noble_title) : "";
    }

    @Override // com.baidu.live.k.c
    public void onConfigurationChanged(Configuration configuration) {
        if (this.cex != null) {
            this.cex.a(configuration);
        }
    }

    @Override // com.baidu.live.k.c
    public void cb(boolean z) {
        if (this.cew != null) {
            this.cew.jt(this.mLiveId);
        }
        if (this.cex != null) {
            this.cex.dN(z);
        }
    }

    @Override // com.baidu.live.k.c
    public void cc(boolean z) {
        this.cev = z;
    }

    @Override // com.baidu.live.k.c
    public void onDestroy() {
        if (this.cew != null) {
            this.cew.onDestroy();
        }
    }

    @Override // com.baidu.live.k.c
    public View getView() {
        if (this.cex != null) {
            return this.cex.getRootView();
        }
        return null;
    }
}
