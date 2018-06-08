package com.baidu.ar.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.ARController;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.ui.a.a;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.util.MsgConstants;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.UiUtils;
import com.baidu.ar.util.ViewUtils;
/* loaded from: classes3.dex */
public class m extends c implements r {
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
                case 1401:
                    String str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        str = Res.getString("bdar_recg_error");
                    }
                    m.this.d(str);
                    return;
                case MsgField.IMSG_ON_DEVICE_IR_START /* 1806 */:
                    m.this.p();
                    return;
                case MsgField.MSG_ON_DEVICE_IR_RESULT /* 2503 */:
                    m.this.q();
                    i.a().d();
                    i.a().e();
                    i.a().a((r) null);
                    m.this.y.switchCase((String) obj, 0);
                    return;
                case MsgField.IMSG_NO_NETWORK /* 2511 */:
                    m.this.y.setRecgProcess(true);
                    m.this.q();
                    m.this.a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.m.a.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            m.this.q.quit();
                        }
                    });
                    return;
                case MsgField.IMSG_ON_DEVICE_IR_TIMERR_START /* 2512 */:
                    i.a().c();
                    return;
                default:
                    return;
            }
        }
    }

    public m(ViewGroup viewGroup, com.baidu.ar.b bVar, ARResource aRResource) {
        super(viewGroup, bVar, aRResource);
        this.y = bVar.i();
        z();
        p();
        this.w.a(false);
    }

    private void A() {
        if (i.a() != null) {
            i.a().g();
            ViewUtils.setViewVisibility(this.x, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface.OnClickListener onClickListener) {
        if (this.z == null) {
            if (this.r == null) {
                return;
            }
            try {
                a.C0048a c0048a = new a.C0048a(this.r);
                c0048a.a((CharSequence) Res.getString("bdar_dialog_prompt_title"));
                c0048a.a(Res.getString("bdar_error_network_tips"));
                c0048a.a(Res.getString("bdar_retry"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.m.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        m.this.y();
                        m.this.y.setRecgProcess(false);
                        m.this.y.setRecgArRetry();
                    }
                });
                c0048a.b(Res.getString("bdar_cancel"), onClickListener);
                this.z = c0048a.a();
                this.z.setCanceledOnTouchOutside(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        UiUtils.showDialogSafely(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        if (this.r != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.m.1
                @Override // java.lang.Runnable
                public void run() {
                    new ToastCustom(m.this.s).makeText(str, 0, 2).show();
                }
            });
        }
    }

    private void z() {
        this.A = Res.inflate("bdar_layout_gui_recg");
        this.p.a(this.A);
        this.x = this.p.a();
        this.a.addView(this.A);
        a(new a());
        i.a().a(this);
    }

    @Override // com.baidu.ar.ui.r
    public void a(Message message) {
        switch (message.what) {
            case MsgConstants.TRACK_SHOW_RECG_NOTSANNER /* 315 */:
                b(Res.getString("bdar_not_recg_image"));
                ViewUtils.setViewVisibility(this.x, 0);
                i.a().a(MsgConstants.TRACK_HIDE_RECG_NOTSANNER, 2000L);
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
        if (i.a() != null) {
            i.a().f();
            i.a().c();
        }
    }

    @Override // com.baidu.ar.ui.c
    public void l() {
        super.l();
        A();
    }

    @Override // com.baidu.ar.ui.c
    public void n() {
        super.n();
        if (this.A != null) {
            this.a.removeView(this.A);
            this.p.g();
        }
        i.a().h();
    }

    @Override // com.baidu.ar.ui.c
    public boolean t() {
        A();
        return super.t();
    }

    public void y() {
        if (this.z != null) {
            this.z.dismiss();
            this.z = null;
        }
    }
}
