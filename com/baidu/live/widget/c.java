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
/* loaded from: classes10.dex */
public class c implements IAlaBdZan {
    private View bYS;
    private IGetZanViewCallback bYT;
    private IZanResponseCallback bYV;
    private a.InterfaceC0123a bYW = new a.InterfaceC0123a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0123a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bYS = view;
                if (c.this.bYS instanceof SurfaceView) {
                    ((SurfaceView) c.this.bYS).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bYS).getHolder().setFormat(-3);
                }
                if (c.this.bYT != null) {
                    c.this.bYT.onGetZanView(c.this.bYS);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bYQ = com.baidu.h.b.a.bz(TbadkCoreApplication.getInst().getContext()).aaa();
    private com.baidu.h.a.c.a bYR = com.baidu.h.b.a.bz(TbadkCoreApplication.getInst().getContext()).ZZ();
    private com.baidu.h.a.c.b bYU = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bYV != null) {
                c.this.bYV.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bYQ != null) {
            this.bYQ.a(activity, this.bYW);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bYS;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bYR != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
            this.bYR.a(context, str, str2, i, i2, this.bYU);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bYQ != null && this.bYS != null) {
            this.bYQ.i(this.bYS, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bYT = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bYV = iZanResponseCallback;
    }
}
