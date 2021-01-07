package com.baidu.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.j.a.d.a;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class c implements IAlaBdZan {
    private View bYf;
    private IGetZanViewCallback bYg;
    private IZanResponseCallback bYi;
    private a.InterfaceC0155a bYj = new a.InterfaceC0155a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.j.a.d.a.InterfaceC0155a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bYf = view;
                if (c.this.bYf instanceof SurfaceView) {
                    ((SurfaceView) c.this.bYf).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bYf).getHolder().setFormat(-3);
                }
                if (c.this.bYg != null) {
                    c.this.bYg.onGetZanView(c.this.bYf);
                }
            }
        }
    };
    private com.baidu.j.a.d.a bYd = com.baidu.j.b.a.by(TbadkCoreApplication.getInst().getContext()).abW();
    private com.baidu.j.a.c.a bYe = com.baidu.j.b.a.by(TbadkCoreApplication.getInst().getContext()).abV();
    private com.baidu.j.a.c.b bYh = new com.baidu.j.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.j.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bYi != null) {
                c.this.bYi.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bYd != null) {
            this.bYd.a(activity, this.bYj);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bYf;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bYe != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
            this.bYe.a(context, str, str2, i, i2, this.bYh);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bYd != null && this.bYf != null) {
            this.bYd.i(this.bYf, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bYg = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bYi = iZanResponseCallback;
    }
}
