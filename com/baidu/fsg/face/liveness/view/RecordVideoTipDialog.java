package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes6.dex */
public class RecordVideoTipDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private a f2425a;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public void setMenuItemClickListener(a aVar) {
        this.f2425a = aVar;
    }

    public RecordVideoTipDialog(Context context) {
        super(context);
        a();
    }

    public RecordVideoTipDialog(Context context, int i) {
        super(context, i);
        a();
    }

    protected RecordVideoTipDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        a();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_sapi_liveness_record_video_tip_dialog);
        findViewById(R.id.liveness_again_btn).setOnClickListener(this);
        findViewById(R.id.start_record_btn).setOnClickListener(this);
        findViewById(R.id.record_video_close_iv).setOnClickListener(this);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        getWindow().setAttributes(attributes);
        getWindow().setWindowAnimations(R.anim.spai_liveness_push_bottom_in);
        getWindow().setBackgroundDrawableResource(R.color.sapi_liveness_transparent);
    }

    private void a() {
        requestWindowFeature(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2425a != null) {
            if (view.getId() == R.id.liveness_again_btn) {
                this.f2425a.a();
            } else if (view.getId() == R.id.start_record_btn) {
                this.f2425a.b();
            } else if (view.getId() == R.id.record_video_close_iv) {
                this.f2425a.c();
            }
        }
    }
}
