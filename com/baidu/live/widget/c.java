package com.baidu.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.g.a.d.a;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class c implements IAlaBdZan {
    private View aHw;
    private IGetZanViewCallback aHx;
    private IZanResponseCallback aHz;
    private a.InterfaceC0074a aHA = new a.InterfaceC0074a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.g.a.d.a.InterfaceC0074a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.aHw = view;
                if (c.this.aHw instanceof SurfaceView) {
                    ((SurfaceView) c.this.aHw).setZOrderOnTop(true);
                    ((SurfaceView) c.this.aHw).getHolder().setFormat(-3);
                }
                if (c.this.aHx != null) {
                    c.this.aHx.onGetZanView(c.this.aHw);
                }
            }
        }
    };
    private com.baidu.g.a.d.a aHu = com.baidu.g.b.a.aP(TbadkCoreApplication.getInst().getContext()).BS();
    private com.baidu.g.a.c.a aHv = com.baidu.g.b.a.aP(TbadkCoreApplication.getInst().getContext()).BR();
    private com.baidu.g.a.c.b aHy = new com.baidu.g.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.g.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.aHz != null) {
                c.this.aHz.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.aHu != null) {
            this.aHu.a(activity, this.aHA);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.aHw;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.aHv != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.aHv.a(context, str, str2, i, i2, this.aHy);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.aHu != null && this.aHw != null) {
            this.aHu.e(this.aHw, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.aHx = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.aHz = iZanResponseCallback;
    }
}
