package com.baidu.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.i.a.d.a;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class c implements IAlaBdZan {
    private IZanResponseCallback bSB;
    private View bSy;
    private IGetZanViewCallback bSz;
    private a.InterfaceC0163a bSC = new a.InterfaceC0163a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.i.a.d.a.InterfaceC0163a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bSy = view;
                if (c.this.bSy instanceof SurfaceView) {
                    ((SurfaceView) c.this.bSy).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bSy).getHolder().setFormat(-3);
                }
                if (c.this.bSz != null) {
                    c.this.bSz.onGetZanView(c.this.bSy);
                }
            }
        }
    };
    private com.baidu.i.a.d.a bSw = com.baidu.i.b.a.bn(TbadkCoreApplication.getInst().getContext()).aai();
    private com.baidu.i.a.c.a bSx = com.baidu.i.b.a.bn(TbadkCoreApplication.getInst().getContext()).aah();
    private com.baidu.i.a.c.b bSA = new com.baidu.i.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.i.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bSB != null) {
                c.this.bSB.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bSw != null) {
            this.bSw.a(activity, this.bSC);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bSy;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bSx != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
            this.bSx.a(context, str, str2, i, i2, this.bSA);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bSw != null && this.bSy != null) {
            this.bSw.g(this.bSy, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bSz = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bSB = iZanResponseCallback;
    }
}
