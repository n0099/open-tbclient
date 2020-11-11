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
    private View bPc;
    private IGetZanViewCallback bPd;
    private IZanResponseCallback bPf;
    private a.InterfaceC0137a bPg = new a.InterfaceC0137a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0137a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bPc = view;
                if (c.this.bPc instanceof SurfaceView) {
                    ((SurfaceView) c.this.bPc).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bPc).getHolder().setFormat(-3);
                }
                if (c.this.bPd != null) {
                    c.this.bPd.onGetZanView(c.this.bPc);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bPa = com.baidu.h.b.a.aJ(TbadkCoreApplication.getInst().getContext()).Yo();
    private com.baidu.h.a.c.a bPb = com.baidu.h.b.a.aJ(TbadkCoreApplication.getInst().getContext()).Yn();
    private com.baidu.h.a.c.b bPe = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bPf != null) {
                c.this.bPf.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bPa != null) {
            this.bPa.a(activity, this.bPg);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bPc;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bPb != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
            this.bPb.a(context, str, str2, i, i2, this.bPe);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bPa != null && this.bPc != null) {
            this.bPa.e(this.bPc, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bPd = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bPf = iZanResponseCallback;
    }
}
