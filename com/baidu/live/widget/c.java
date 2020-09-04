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
/* loaded from: classes7.dex */
public class c implements IAlaBdZan {
    private View bwu;
    private IGetZanViewCallback bwv;
    private IZanResponseCallback bwx;
    private a.InterfaceC0132a bwy = new a.InterfaceC0132a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0132a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bwu = view;
                if (c.this.bwu instanceof SurfaceView) {
                    ((SurfaceView) c.this.bwu).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bwu).getHolder().setFormat(-3);
                }
                if (c.this.bwv != null) {
                    c.this.bwv.onGetZanView(c.this.bwu);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bws = com.baidu.h.b.a.aF(TbadkCoreApplication.getInst().getContext()).Rl();
    private com.baidu.h.a.c.a bwt = com.baidu.h.b.a.aF(TbadkCoreApplication.getInst().getContext()).Rk();
    private com.baidu.h.a.c.b bww = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bwx != null) {
                c.this.bwx.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bws != null) {
            this.bws.a(activity, this.bwy);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bwu;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bwt != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.bwt.a(context, str, str2, i, i2, this.bww);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bws != null && this.bwu != null) {
            this.bws.e(this.bwu, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bwv = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bwx = iZanResponseCallback;
    }
}
