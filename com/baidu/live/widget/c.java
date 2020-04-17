package com.baidu.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.c.a.d.a;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class c implements IAlaBdZan {
    private IZanResponseCallback bdB;
    private View bdy;
    private IGetZanViewCallback bdz;
    private a.InterfaceC0073a bdC = new a.InterfaceC0073a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.c.a.d.a.InterfaceC0073a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bdy = view;
                if (c.this.bdy instanceof SurfaceView) {
                    ((SurfaceView) c.this.bdy).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bdy).getHolder().setFormat(-3);
                }
                if (c.this.bdz != null) {
                    c.this.bdz.onGetZanView(c.this.bdy);
                }
            }
        }
    };
    private com.baidu.c.a.d.a bdw = com.baidu.c.b.a.aB(TbadkCoreApplication.getInst().getContext()).Id();
    private com.baidu.c.a.c.a bdx = com.baidu.c.b.a.aB(TbadkCoreApplication.getInst().getContext()).Ic();
    private com.baidu.c.a.c.b bdA = new com.baidu.c.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.c.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bdB != null) {
                c.this.bdB.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bdw != null) {
            this.bdw.a(activity, this.bdC);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bdy;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bdx != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.bdx.a(context, str, str2, i, i2, this.bdA);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bdw != null && this.bdy != null) {
            this.bdw.e(this.bdy, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bdz = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bdB = iZanResponseCallback;
    }
}
