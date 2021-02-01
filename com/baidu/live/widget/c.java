package com.baidu.live.widget;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.h.a.d.a;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class c implements IAlaBdZan {
    private View bXs;
    private IGetZanViewCallback bXt;
    private IZanResponseCallback bXv;
    private a.InterfaceC0117a bXw = new a.InterfaceC0117a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0117a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bXs = view;
                if (c.this.bXs instanceof SurfaceView) {
                    ((SurfaceView) c.this.bXs).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bXs).getHolder().setFormat(-3);
                }
                if (c.this.bXt != null) {
                    c.this.bXt.onGetZanView(c.this.bXs);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bXq = com.baidu.h.b.a.bA(TbadkCoreApplication.getInst().getContext()).ZX();
    private com.baidu.h.a.c.a bXr = com.baidu.h.b.a.bA(TbadkCoreApplication.getInst().getContext()).ZW();
    private com.baidu.h.a.c.b bXu = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bXv != null) {
                c.this.bXv.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bXq != null) {
            this.bXq.a(activity, this.bXw);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bXs;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bXr != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
            this.bXr.a(context, str, str2, i, i2, this.bXu);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bXq != null && this.bXs != null) {
            this.bXq.i(this.bXs, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bXt = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bXv = iZanResponseCallback;
    }
}
