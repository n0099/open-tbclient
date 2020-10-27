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
/* loaded from: classes4.dex */
public class c implements IAlaBdZan {
    private View bJw;
    private IGetZanViewCallback bJx;
    private IZanResponseCallback bJz;
    private a.InterfaceC0137a bJA = new a.InterfaceC0137a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0137a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bJw = view;
                if (c.this.bJw instanceof SurfaceView) {
                    ((SurfaceView) c.this.bJw).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bJw).getHolder().setFormat(-3);
                }
                if (c.this.bJx != null) {
                    c.this.bJx.onGetZanView(c.this.bJw);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bJu = com.baidu.h.b.a.aJ(TbadkCoreApplication.getInst().getContext()).VP();
    private com.baidu.h.a.c.a bJv = com.baidu.h.b.a.aJ(TbadkCoreApplication.getInst().getContext()).VO();
    private com.baidu.h.a.c.b bJy = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bJz != null) {
                c.this.bJz.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bJu != null) {
            this.bJu.a(activity, this.bJA);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bJw;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bJv != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
            this.bJv.a(context, str, str2, i, i2, this.bJy);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bJu != null && this.bJw != null) {
            this.bJu.e(this.bJw, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bJx = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bJz = iZanResponseCallback;
    }
}
