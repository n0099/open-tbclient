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
/* loaded from: classes11.dex */
public class b implements c {
    private String aNa;
    private String buH;
    private d buS;
    private boolean cdL;
    private e cdM;
    private com.baidu.live.yuyinnoble.d.b cdN;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a cdO = new b.a() { // from class: com.baidu.live.yuyinnoble.b.b.1
        @Override // com.baidu.live.yuyinnoble.d.b.a
        public void OP() {
            b.this.cc(true);
        }
    };
    private final e.a cdP = new e.a() { // from class: com.baidu.live.yuyinnoble.b.b.2
        @Override // com.baidu.live.yuyinnoble.c.e.a
        public void a(d dVar) {
            b.this.buS = dVar;
            if (b.this.cdN != null) {
                b.this.cdN.b(dVar);
                b.this.cdN.dR(false);
            }
        }

        @Override // com.baidu.live.yuyinnoble.c.e.a
        public void onFail(int i, String str) {
            if (b.this.mTbPageContext != null) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
            if (b.this.cdN != null) {
                if (b.this.buS == null) {
                    b.this.cdN.cK(true);
                }
                b.this.cdN.dR(false);
            }
        }
    };

    @Override // com.baidu.live.j.c
    public void a(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.buH = str2;
        this.aNa = str3;
        this.mTabId = i;
        this.mIsHost = z;
        this.cdM = new e(this.mTbPageContext, this.cdP);
        this.cdN = new com.baidu.live.yuyinnoble.d.b(this.mTbPageContext, this.mLiveId, this.buH, this.mIsHost, this.cdL);
        this.cdN.a(this.cdO);
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
        if (this.cdN != null) {
            this.cdN.a(configuration);
        }
    }

    @Override // com.baidu.live.j.c
    public void cc(boolean z) {
        if (this.cdM != null) {
            this.cdM.iO(this.mLiveId);
        }
        if (this.cdN != null) {
            this.cdN.dR(z);
        }
    }

    @Override // com.baidu.live.j.c
    public void cd(boolean z) {
        this.cdL = z;
    }

    @Override // com.baidu.live.j.c
    public void onDestroy() {
        if (this.cdM != null) {
            this.cdM.onDestroy();
        }
    }

    @Override // com.baidu.live.j.c
    public View getView() {
        if (this.cdN != null) {
            return this.cdN.getRootView();
        }
        return null;
    }
}
