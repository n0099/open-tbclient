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
    private View bGv;
    private IGetZanViewCallback bGw;
    private IZanResponseCallback bGy;
    private a.InterfaceC0137a bGz = new a.InterfaceC0137a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0137a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bGv = view;
                if (c.this.bGv instanceof SurfaceView) {
                    ((SurfaceView) c.this.bGv).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bGv).getHolder().setFormat(-3);
                }
                if (c.this.bGw != null) {
                    c.this.bGw.onGetZanView(c.this.bGv);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bGt = com.baidu.h.b.a.aJ(TbadkCoreApplication.getInst().getContext()).TV();
    private com.baidu.h.a.c.a bGu = com.baidu.h.b.a.aJ(TbadkCoreApplication.getInst().getContext()).TU();
    private com.baidu.h.a.c.b bGx = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bGy != null) {
                c.this.bGy.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bGt != null) {
            this.bGt.a(activity, this.bGz);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bGv;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bGu != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
            this.bGu.a(context, str, str2, i, i2, this.bGx);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bGt != null && this.bGv != null) {
            this.bGt.e(this.bGv, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bGw = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bGy = iZanResponseCallback;
    }
}
