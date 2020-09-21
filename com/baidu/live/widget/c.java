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
    private View bzS;
    private IGetZanViewCallback bzT;
    private IZanResponseCallback bzV;
    private a.InterfaceC0133a bzW = new a.InterfaceC0133a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0133a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bzS = view;
                if (c.this.bzS instanceof SurfaceView) {
                    ((SurfaceView) c.this.bzS).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bzS).getHolder().setFormat(-3);
                }
                if (c.this.bzT != null) {
                    c.this.bzT.onGetZanView(c.this.bzS);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bzQ = com.baidu.h.b.a.aF(TbadkCoreApplication.getInst().getContext()).Sc();
    private com.baidu.h.a.c.a bzR = com.baidu.h.b.a.aF(TbadkCoreApplication.getInst().getContext()).Sb();
    private com.baidu.h.a.c.b bzU = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bzV != null) {
                c.this.bzV.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bzQ != null) {
            this.bzQ.a(activity, this.bzW);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bzS;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bzR != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.bzR.a(context, str, str2, i, i2, this.bzU);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bzQ != null && this.bzS != null) {
            this.bzQ.e(this.bzS, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bzT = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bzV = iZanResponseCallback;
    }
}
