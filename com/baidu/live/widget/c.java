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
    private View blf;
    private IGetZanViewCallback blg;
    private IZanResponseCallback bli;
    private a.InterfaceC0096a blj = new a.InterfaceC0096a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.c.a.d.a.InterfaceC0096a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.blf = view;
                if (c.this.blf instanceof SurfaceView) {
                    ((SurfaceView) c.this.blf).setZOrderOnTop(true);
                    ((SurfaceView) c.this.blf).getHolder().setFormat(-3);
                }
                if (c.this.blg != null) {
                    c.this.blg.onGetZanView(c.this.blf);
                }
            }
        }
    };
    private com.baidu.c.a.d.a bld = com.baidu.c.b.a.az(TbadkCoreApplication.getInst().getContext()).JV();
    private com.baidu.c.a.c.a ble = com.baidu.c.b.a.az(TbadkCoreApplication.getInst().getContext()).JU();
    private com.baidu.c.a.c.b blh = new com.baidu.c.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.c.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bli != null) {
                c.this.bli.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bld != null) {
            this.bld.a(activity, this.blj);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.blf;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.ble != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.ble.a(context, str, str2, i, i2, this.blh);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bld != null && this.blf != null) {
            this.bld.e(this.blf, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.blg = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bli = iZanResponseCallback;
    }
}
