package com.baidu.live.noble.b;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class d implements com.baidu.live.h.b {
    private String aNj;
    private String bnP;
    private e bpa;
    private com.baidu.live.noble.d.b bpb;
    private com.baidu.live.noble.data.b bpc;
    private long bpd;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final b.a bpe = new b.a() { // from class: com.baidu.live.noble.b.d.1
        @Override // com.baidu.live.noble.d.b.a
        public void Oy() {
            d.this.KM();
        }
    };
    private final e.a bpf = new e.a() { // from class: com.baidu.live.noble.b.d.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            d.this.bpc = bVar;
            if (d.this.bpb != null) {
                d.this.bpb.b(bVar);
            }
            if (bVar == null) {
                d.this.bpd = 5L;
                d.this.aD(d.this.bpd);
                return;
            }
            if (bVar.bpm <= 0) {
                d.this.bpd = 5L;
            } else {
                d.this.bpd = bVar.bpm;
            }
            d.this.aD(d.this.bpd);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            if (d.this.mTbPageContext != null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), str);
            }
            d.this.bpd = 5L;
            d.this.aD(d.this.bpd);
            if (d.this.bpb != null && d.this.bpc == null) {
                d.this.bpb.cm(true);
            }
        }
    };
    private final Runnable bpg = new Runnable() { // from class: com.baidu.live.noble.b.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.KM();
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
        this.bpa = new e(this.mTbPageContext, this.bpf);
        this.bpb = new com.baidu.live.noble.d.b(this.mTbPageContext, this.mLiveId, this.bnP, this.mIsHost);
        this.bpb.a(this.bpe);
    }

    @Override // com.baidu.live.h.b
    public void bQ(boolean z) {
        if (z) {
            KM();
        } else {
            Ox();
        }
    }

    @Override // com.baidu.live.h.b
    public String getTitle() {
        return this.mTbPageContext != null ? this.mTbPageContext.getResources().getString(a.h.noble_title) : "";
    }

    @Override // com.baidu.live.h.b
    public void onConfigurationChanged(Configuration configuration) {
        if (this.bpb != null) {
            this.bpb.a(configuration);
        }
    }

    @Override // com.baidu.live.h.b
    public void KM() {
        if (this.bpa != null) {
            this.bpa.aC(this.bnP, this.mLiveId);
        }
    }

    @Override // com.baidu.live.h.b
    public void bR(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(long j) {
        if (this.mHandler != null && this.bpg != null) {
            this.mHandler.removeCallbacks(this.bpg);
            this.mHandler.postDelayed(this.bpg, 1000 * j);
        }
    }

    private void Ox() {
        if (this.mHandler != null && this.bpg != null) {
            this.mHandler.removeCallbacks(this.bpg);
        }
    }

    @Override // com.baidu.live.h.b
    public void onDestroy() {
        if (this.bpa != null) {
            this.bpa.onDestroy();
        }
        Ox();
    }

    @Override // com.baidu.live.h.b
    public View getView() {
        if (this.bpb != null) {
            return this.bpb.getRootView();
        }
        return null;
    }
}
