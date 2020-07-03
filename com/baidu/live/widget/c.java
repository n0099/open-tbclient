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
    private View bqg;
    private IGetZanViewCallback bqh;
    private IZanResponseCallback bqj;
    private a.InterfaceC0097a bqk = new a.InterfaceC0097a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.c.a.d.a.InterfaceC0097a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bqg = view;
                if (c.this.bqg instanceof SurfaceView) {
                    ((SurfaceView) c.this.bqg).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bqg).getHolder().setFormat(-3);
                }
                if (c.this.bqh != null) {
                    c.this.bqh.onGetZanView(c.this.bqg);
                }
            }
        }
    };
    private com.baidu.c.a.d.a bqe = com.baidu.c.b.a.aA(TbadkCoreApplication.getInst().getContext()).Le();
    private com.baidu.c.a.c.a bqf = com.baidu.c.b.a.aA(TbadkCoreApplication.getInst().getContext()).Ld();
    private com.baidu.c.a.c.b bqi = new com.baidu.c.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.c.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bqj != null) {
                c.this.bqj.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bqe != null) {
            this.bqe.a(activity, this.bqk);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bqg;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bqf != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.bqf.a(context, str, str2, i, i2, this.bqi);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bqe != null && this.bqg != null) {
            this.bqe.e(this.bqg, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bqh = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bqj = iZanResponseCallback;
    }
}
