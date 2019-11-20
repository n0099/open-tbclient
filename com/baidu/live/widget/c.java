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
    private View auC;
    private IGetZanViewCallback auD;
    private IZanResponseCallback auF;
    private a.InterfaceC0043a auG = new a.InterfaceC0043a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.c.a.d.a.InterfaceC0043a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.auC = view;
                if (c.this.auC instanceof SurfaceView) {
                    ((SurfaceView) c.this.auC).setZOrderOnTop(true);
                    ((SurfaceView) c.this.auC).getHolder().setFormat(-3);
                }
                if (c.this.auD != null) {
                    c.this.auD.onGetZanView(c.this.auC);
                }
            }
        }
    };
    private com.baidu.c.a.d.a auA = com.baidu.c.b.a.aB(TbadkCoreApplication.getInst().getContext()).xg();
    private com.baidu.c.a.c.a auB = com.baidu.c.b.a.aB(TbadkCoreApplication.getInst().getContext()).xf();
    private com.baidu.c.a.c.b auE = new com.baidu.c.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.c.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.auF != null) {
                c.this.auF.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.auA != null) {
            this.auA.a(activity, this.auG);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.auC;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.auB != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.auB.a(context, str, str2, i, i2, this.auE);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.auA != null && this.auC != null) {
            this.auA.e(this.auC, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.auD = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.auF = iZanResponseCallback;
    }
}
