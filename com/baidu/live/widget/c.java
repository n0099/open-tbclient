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
/* loaded from: classes2.dex */
public class c implements IAlaBdZan {
    private View aDn;
    private IGetZanViewCallback aDo;
    private IZanResponseCallback aDq;
    private a.InterfaceC0068a aDr = new a.InterfaceC0068a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.g.a.d.a.InterfaceC0068a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.aDn = view;
                if (c.this.aDn instanceof SurfaceView) {
                    ((SurfaceView) c.this.aDn).setZOrderOnTop(true);
                    ((SurfaceView) c.this.aDn).getHolder().setFormat(-3);
                }
                if (c.this.aDo != null) {
                    c.this.aDo.onGetZanView(c.this.aDn);
                }
            }
        }
    };
    private com.baidu.g.a.d.a aDl = com.baidu.g.b.a.aL(TbadkCoreApplication.getInst().getContext()).zA();
    private com.baidu.g.a.c.a aDm = com.baidu.g.b.a.aL(TbadkCoreApplication.getInst().getContext()).zz();
    private com.baidu.g.a.c.b aDp = new com.baidu.g.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.g.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.aDq != null) {
                c.this.aDq.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.aDl != null) {
            this.aDl.a(activity, this.aDr);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.aDn;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.aDm != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.aDm.a(context, str, str2, i, i2, this.aDp);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.aDl != null && this.aDn != null) {
            this.aDl.e(this.aDn, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.aDo = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.aDq = iZanResponseCallback;
    }
}
