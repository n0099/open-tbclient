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
    private View aCv;
    private IGetZanViewCallback aCw;
    private IZanResponseCallback aCy;
    private a.InterfaceC0068a aCz = new a.InterfaceC0068a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.g.a.d.a.InterfaceC0068a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.aCv = view;
                if (c.this.aCv instanceof SurfaceView) {
                    ((SurfaceView) c.this.aCv).setZOrderOnTop(true);
                    ((SurfaceView) c.this.aCv).getHolder().setFormat(-3);
                }
                if (c.this.aCw != null) {
                    c.this.aCw.onGetZanView(c.this.aCv);
                }
            }
        }
    };
    private com.baidu.g.a.d.a aCt = com.baidu.g.b.a.aL(TbadkCoreApplication.getInst().getContext()).ze();
    private com.baidu.g.a.c.a aCu = com.baidu.g.b.a.aL(TbadkCoreApplication.getInst().getContext()).zd();
    private com.baidu.g.a.c.b aCx = new com.baidu.g.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.g.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.aCy != null) {
                c.this.aCy.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.aCt != null) {
            this.aCt.a(activity, this.aCz);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.aCv;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.aCu != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.aCu.a(context, str, str2, i, i2, this.aCx);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.aCt != null && this.aCv != null) {
            this.aCt.e(this.aCv, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.aCw = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.aCy = iZanResponseCallback;
    }
}
