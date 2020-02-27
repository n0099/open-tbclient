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
    private View aHu;
    private IGetZanViewCallback aHv;
    private IZanResponseCallback aHx;
    private a.InterfaceC0074a aHy = new a.InterfaceC0074a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.g.a.d.a.InterfaceC0074a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.aHu = view;
                if (c.this.aHu instanceof SurfaceView) {
                    ((SurfaceView) c.this.aHu).setZOrderOnTop(true);
                    ((SurfaceView) c.this.aHu).getHolder().setFormat(-3);
                }
                if (c.this.aHv != null) {
                    c.this.aHv.onGetZanView(c.this.aHu);
                }
            }
        }
    };
    private com.baidu.g.a.d.a aHs = com.baidu.g.b.a.aP(TbadkCoreApplication.getInst().getContext()).BQ();
    private com.baidu.g.a.c.a aHt = com.baidu.g.b.a.aP(TbadkCoreApplication.getInst().getContext()).BP();
    private com.baidu.g.a.c.b aHw = new com.baidu.g.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.g.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.aHx != null) {
                c.this.aHx.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.aHs != null) {
            this.aHs.a(activity, this.aHy);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.aHu;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.aHt != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.aHt.a(context, str, str2, i, i2, this.aHw);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.aHs != null && this.aHu != null) {
            this.aHs.e(this.aHu, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.aHv = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.aHx = iZanResponseCallback;
    }
}
