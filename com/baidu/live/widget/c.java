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
/* loaded from: classes10.dex */
public class c implements IAlaBdZan {
    private View bTt;
    private IGetZanViewCallback bTu;
    private IZanResponseCallback bTw;
    private a.InterfaceC0117a bTx = new a.InterfaceC0117a() { // from class: com.baidu.live.widget.c.1
        @Override // com.baidu.h.a.d.a.InterfaceC0117a
        public void b(int i, View view) {
            if (i == 0 && (view instanceof View)) {
                c.this.bTt = view;
                if (c.this.bTt instanceof SurfaceView) {
                    ((SurfaceView) c.this.bTt).setZOrderOnTop(true);
                    ((SurfaceView) c.this.bTt).getHolder().setFormat(-3);
                }
                if (c.this.bTu != null) {
                    c.this.bTu.onGetZanView(c.this.bTt);
                }
            }
        }
    };
    private com.baidu.h.a.d.a bTr = com.baidu.h.b.a.bx(TbadkCoreApplication.getInst().getContext()).Yd();
    private com.baidu.h.a.c.a bTs = com.baidu.h.b.a.bx(TbadkCoreApplication.getInst().getContext()).Yc();
    private com.baidu.h.a.c.b bTv = new com.baidu.h.a.c.b() { // from class: com.baidu.live.widget.c.2
        @Override // com.baidu.h.a.c.b
        public void onResult(int i, long j, long j2) {
            if (c.this.bTw != null) {
                c.this.bTw.onResult(i, j, j2);
            }
        }
    };

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void prepareZanView(Activity activity) {
        if (activity != null && this.bTr != null) {
            this.bTr.a(activity, this.bTx);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public View getZanView() {
        return this.bTt;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void postZan(Context context, String str, String str2, int i) {
        if (this.bTs != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
            this.bTs.a(context, str, str2, i, i2, this.bTv);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void addHeart(int i) {
        if (this.bTr != null && this.bTt != null) {
            this.bTr.i(this.bTt, i);
        }
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setGetZanViewCallback(IGetZanViewCallback iGetZanViewCallback) {
        this.bTu = iGetZanViewCallback;
    }

    @Override // com.baidu.live.tbadk.ala.zan.IAlaBdZan
    public void setZanResponseCallback(IZanResponseCallback iZanResponseCallback) {
        this.bTw = iZanResponseCallback;
    }
}
