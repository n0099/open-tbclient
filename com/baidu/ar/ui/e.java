package com.baidu.ar.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.ARController;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.util.MsgConstants;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.UiUtils;
import com.baidu.ar.util.ViewUtils;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
/* loaded from: classes3.dex */
public class e extends c implements r {
    private View A;
    protected RotateViewGroup x;
    private ARController y;
    private Dialog z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements k {
        private a() {
        }

        @Override // com.baidu.ar.ui.k
        public void a(int i, Object obj) {
            switch (i) {
                case 1403:
                    e.this.d((String) obj);
                    return;
                case MsgField.IMSG_CLORD_ID_START /* 1807 */:
                    if (NetworkUtil.isNetworkConnected(e.this.A())) {
                        e.this.p();
                        return;
                    }
                    e.this.y.changeCloudArState(2);
                    e.this.q();
                    e.this.a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.e.a.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            e.this.y.changeCloudArState(2);
                            e.this.B();
                        }
                    });
                    return;
                case MsgField.IMSG_CLOUDAR_RECG_RESULT /* 2106 */:
                    i.a().d();
                    i.a().e();
                    i.a().a((r) null);
                    e.this.q();
                    e.this.y.switchCase((String) obj, 0);
                    return;
                default:
                    return;
            }
        }
    }

    public e(ViewGroup viewGroup, com.baidu.ar.b bVar, ARResource aRResource) {
        super(viewGroup, bVar, aRResource);
        this.y = bVar.i();
        z();
        p();
        this.w.a(false);
        i.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context A() {
        return this.q.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (A() instanceof Activity) {
            ((Activity) A()).finish();
        }
    }

    private void C() {
        if (i.a() != null) {
            i.a().g();
            ViewUtils.setViewVisibility(this.x, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface.OnClickListener onClickListener) {
        if (this.z != null || A() == null) {
            return;
        }
        this.z = g.d(A(), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.e.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                e.this.y();
                e.this.y.changeCloudArState(-1);
            }
        }, onClickListener);
        UiUtils.showDialogSafely(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        if (this.r != null) {
            if (!this.r.isFinishing() || this.r.isDestroyed()) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        new ToastCustom(e.this.s).makeText(str, 0, 2).show();
                    }
                });
            }
        }
    }

    private void z() {
        this.A = Res.inflate("bdar_layout_gui_cloud");
        this.p.a(this.A);
        this.x = this.p.a();
        this.a.addView(this.A);
        a(new a());
    }

    @Override // com.baidu.ar.ui.r
    public void a(Message message) {
        switch (message.what) {
            case MsgConstants.TRACK_SHOW_RECG_NOTSANNER /* 315 */:
                b(Res.getString("bdar_not_recg_image"));
                ViewUtils.setViewVisibility(this.x, 0);
                i.a().a(MsgConstants.TRACK_HIDE_RECG_NOTSANNER, SystemScreenshotManager.DELAY_TIME);
                return;
            case MsgConstants.TRACK_HIDE_RECG_NOTSANNER /* 316 */:
                ViewUtils.setViewVisibility(this.x, 8);
                i.a().d();
                i.a().c();
                return;
            case MsgConstants.TRACK_CLOSE_RECG_NOTSANNER /* 317 */:
                ViewUtils.setViewVisibility(this.x, 8);
                i.a().d();
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.ar.ui.c
    public void k() {
        super.k();
        i.a().f();
        i.a().c();
    }

    @Override // com.baidu.ar.ui.c
    public void l() {
        super.l();
        C();
    }

    @Override // com.baidu.ar.ui.c
    public void n() {
        super.n();
        q();
        if (this.A != null) {
            this.a.removeView(this.A);
        }
        i.a().h();
    }

    @Override // com.baidu.ar.ui.c
    public boolean t() {
        C();
        return super.t();
    }

    public void y() {
        if (this.z != null) {
            this.z.dismiss();
            this.z = null;
        }
    }
}
