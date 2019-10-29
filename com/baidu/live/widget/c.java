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
/* loaded from: classes6.dex */
public class c implements IAlaBdZan {
    private View auU;
    private IGetZanViewCallback auV;
    private IZanResponseCallback auX;
    private a.InterfaceC0043a auY = new a.InterfaceC0043a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.c.a.d.a.InterfaceC0043a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.auU = view;
                if (c.this.auU instanceof SurfaceView) {
                    ((SurfaceView) c.this.auU).setZOrderOnTop(true);
                    ((SurfaceView) c.this.auU).getHolder().setFormat(-3);
                }
                if (c.this.auV != null) {
                    c.this.auV.onGetZanView(c.this.auU);
                }
            }
        }
    };
    private com.baidu.c.a.d.a auS = com.baidu.c.b.a.aB(TbadkCoreApplication.getInst().getContext()).xf();
    private com.baidu.c.a.c.a auT = com.baidu.c.b.a.aB(TbadkCoreApplication.getInst().getContext()).xe();
    private com.baidu.c.a.c.b auW = new com.baidu.c.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.c.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.auX != null) {
                c.this.auX.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.auS != null) {
            this.auS.a(activity, this.auY);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.auU;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.auT != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.auT.a(context, str, str2, i, i2, this.auW);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.auS != null && this.auU != null) {
            this.auS.e(this.auU, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.auV = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.auX = iZanResponseCallback;
    }
}
