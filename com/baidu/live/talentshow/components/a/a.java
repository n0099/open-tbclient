package com.baidu.live.talentshow.components.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private InterfaceC0198a byZ;
    private TextView bza;
    private View bzb;
    private TextView bzc;
    private Context mContext;

    /* renamed from: com.baidu.live.talentshow.components.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0198a {
        boolean Qb();

        void Qc();
    }

    public void a(InterfaceC0198a interfaceC0198a) {
        this.byZ = interfaceC0198a;
    }

    public a(@NonNull Context context) {
        super(context, a.i.theme_manage_dialog_with_no_anim);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.live_bc_video_chat_invite_confirm_dialog);
        resize();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.bzb = findViewById(a.f.live_bc_video_chat_confirm_dialog_btn_first);
        this.bzc = (TextView) findViewById(a.f.live_bc_video_chat_confirm_dialog_txt_first);
        this.bza = (TextView) findViewById(a.f.live_bc_video_chat_count_down);
        this.bzb.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void ho(String str) {
        this.bzc.setText(str);
    }

    public void dX(int i) {
        this.bzb.setVisibility(i);
    }

    public void hp(String str) {
        this.bza.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bzb && this.byZ != null) {
            this.byZ.Qb();
        }
    }
}
