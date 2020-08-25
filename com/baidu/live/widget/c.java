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
    private View bwr;
    private IGetZanViewCallback bws;
    private IZanResponseCallback bwu;
    private a.InterfaceC0132a bwv = new a.InterfaceC0132a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0132a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bwr = view;
                if (c.this.bwr instanceof SurfaceView) {
                    ((SurfaceView) c.this.bwr).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bwr).getHolder().setFormat(-3);
                }
                if (c.this.bws != null) {
                    c.this.bws.onGetZanView(c.this.bwr);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bwp = com.baidu.h.b.a.aF(TbadkCoreApplication.getInst().getContext()).Rl();
    private com.baidu.h.a.c.a bwq = com.baidu.h.b.a.aF(TbadkCoreApplication.getInst().getContext()).Rk();
    private com.baidu.h.a.c.b bwt = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bwu != null) {
                c.this.bwu.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bwp != null) {
            this.bwp.a(activity, this.bwv);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bwr;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bwq != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.bwq.a(context, str, str2, i, i2, this.bwt);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bwp != null && this.bwr != null) {
            this.bwp.e(this.bwr, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bws = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bwu = iZanResponseCallback;
    }
}
