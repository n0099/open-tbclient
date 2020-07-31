package com.baidu.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.d.a.d.a;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class c implements IAlaBdZan {
    private View bqB;
    private IGetZanViewCallback bqC;
    private IZanResponseCallback bqE;
    private a.InterfaceC0114a bqF = new a.InterfaceC0114a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.d.a.d.a.InterfaceC0114a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bqB = view;
                if (c.this.bqB instanceof SurfaceView) {
                    ((SurfaceView) c.this.bqB).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bqB).getHolder().setFormat(-3);
                }
                if (c.this.bqC != null) {
                    c.this.bqC.onGetZanView(c.this.bqB);
                }
            }
        }
    };
    private com.baidu.d.a.d.a bqz = com.baidu.d.b.a.aA(TbadkCoreApplication.getInst().getContext()).Ll();
    private com.baidu.d.a.c.a bqA = com.baidu.d.b.a.aA(TbadkCoreApplication.getInst().getContext()).Lk();
    private com.baidu.d.a.c.b bqD = new com.baidu.d.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.d.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bqE != null) {
                c.this.bqE.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bqz != null) {
            this.bqz.a(activity, this.bqF);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bqB;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bqA != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.bqA.a(context, str, str2, i, i2, this.bqD);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bqz != null && this.bqB != null) {
            this.bqz.e(this.bqB, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bqC = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bqE = iZanResponseCallback;
    }
}
