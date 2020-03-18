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
/* loaded from: classes3.dex */
public class c implements IAlaBdZan {
    private View aHK;
    private IGetZanViewCallback aHL;
    private IZanResponseCallback aHN;
    private a.InterfaceC0074a aHO = new a.InterfaceC0074a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.g.a.d.a.InterfaceC0074a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.aHK = view;
                if (c.this.aHK instanceof SurfaceView) {
                    ((SurfaceView) c.this.aHK).setZOrderOnTop(true);
                    ((SurfaceView) c.this.aHK).getHolder().setFormat(-3);
                }
                if (c.this.aHL != null) {
                    c.this.aHL.onGetZanView(c.this.aHK);
                }
            }
        }
    };
    private com.baidu.g.a.d.a aHI = com.baidu.g.b.a.aO(TbadkCoreApplication.getInst().getContext()).BZ();
    private com.baidu.g.a.c.a aHJ = com.baidu.g.b.a.aO(TbadkCoreApplication.getInst().getContext()).BY();
    private com.baidu.g.a.c.b aHM = new com.baidu.g.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.g.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.aHN != null) {
                c.this.aHN.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.aHI != null) {
            this.aHI.a(activity, this.aHO);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.aHK;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.aHJ != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            int i2 = 0;
            if (TbadkCoreApplication.getInst().isTieba()) {
                i2 = 1;
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                i2 = 2;
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                i2 = 3;
            }
            this.aHJ.a(context, str, str2, i, i2, this.aHM);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.aHI != null && this.aHK != null) {
            this.aHI.e(this.aHK, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.aHL = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.aHN = iZanResponseCallback;
    }
}
