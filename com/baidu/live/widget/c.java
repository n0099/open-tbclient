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
    private View bdD;
    private IGetZanViewCallback bdE;
    private IZanResponseCallback bdG;
    private a.InterfaceC0094a bdH = new a.InterfaceC0094a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.c.a.d.a.InterfaceC0094a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bdD = view;
                if (c.this.bdD instanceof SurfaceView) {
                    ((SurfaceView) c.this.bdD).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bdD).getHolder().setFormat(-3);
                }
                if (c.this.bdE != null) {
                    c.this.bdE.onGetZanView(c.this.bdD);
                }
            }
        }
    };
    private com.baidu.c.a.d.a bdB = com.baidu.c.b.a.ap(TbadkCoreApplication.getInst().getContext()).Ic();
    private com.baidu.c.a.c.a bdC = com.baidu.c.b.a.ap(TbadkCoreApplication.getInst().getContext()).Ib();
    private com.baidu.c.a.c.b bdF = new com.baidu.c.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.c.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bdG != null) {
                c.this.bdG.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bdB != null) {
            this.bdB.a(activity, this.bdH);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bdD;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bdC != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.bdC.a(context, str, str2, i, i2, this.bdF);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bdB != null && this.bdD != null) {
            this.bdB.e(this.bdD, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bdE = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bdG = iZanResponseCallback;
    }
}
