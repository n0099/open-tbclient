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
    private View aHv;
    private IGetZanViewCallback aHw;
    private IZanResponseCallback aHy;
    private a.InterfaceC0074a aHz = new a.InterfaceC0074a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.g.a.d.a.InterfaceC0074a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.aHv = view;
                if (c.this.aHv instanceof SurfaceView) {
                    ((SurfaceView) c.this.aHv).setZOrderOnTop(true);
                    ((SurfaceView) c.this.aHv).getHolder().setFormat(-3);
                }
                if (c.this.aHw != null) {
                    c.this.aHw.onGetZanView(c.this.aHv);
                }
            }
        }
    };
    private com.baidu.g.a.d.a aHt = com.baidu.g.b.a.aP(TbadkCoreApplication.getInst().getContext()).BS();
    private com.baidu.g.a.c.a aHu = com.baidu.g.b.a.aP(TbadkCoreApplication.getInst().getContext()).BR();
    private com.baidu.g.a.c.b aHx = new com.baidu.g.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.g.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.aHy != null) {
                c.this.aHy.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.aHt != null) {
            this.aHt.a(activity, this.aHz);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.aHv;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.aHu != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.aHu.a(context, str, str2, i, i2, this.aHx);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.aHt != null && this.aHv != null) {
            this.aHt.e(this.aHv, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.aHw = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.aHy = iZanResponseCallback;
    }
}
