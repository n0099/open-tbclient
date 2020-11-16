package com.baidu.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.h.a.d.a;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class c implements IAlaBdZan {
    private View bNs;
    private IGetZanViewCallback bNt;
    private IZanResponseCallback bNv;
    private a.InterfaceC0135a bNw = new a.InterfaceC0135a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0135a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bNs = view;
                if (c.this.bNs instanceof SurfaceView) {
                    ((SurfaceView) c.this.bNs).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bNs).getHolder().setFormat(-3);
                }
                if (c.this.bNt != null) {
                    c.this.bNt.onGetZanView(c.this.bNs);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bNq = com.baidu.h.b.a.aJ(TbadkCoreApplication.getInst().getContext()).XF();
    private com.baidu.h.a.c.a bNr = com.baidu.h.b.a.aJ(TbadkCoreApplication.getInst().getContext()).XE();
    private com.baidu.h.a.c.b bNu = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bNv != null) {
                c.this.bNv.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bNq != null) {
            this.bNq.a(activity, this.bNw);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bNs;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bNr != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            } else if (TbadkCoreApplication.getInst().isYinbo()) {
                i2 = 6;
            }
            this.bNr.a(context, str, str2, i, i2, this.bNu);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bNq != null && this.bNs != null) {
            this.bNq.g(this.bNs, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bNt = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bNv = iZanResponseCallback;
    }
}
