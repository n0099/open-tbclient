package com.baidu.live.talentshow.components.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private InterfaceC0209a byX;
    private TextView byY;
    private View byZ;
    private TextView bza;
    private Context mContext;

    /* renamed from: com.baidu.live.talentshow.components.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0209a {
        boolean SP();

        void SQ();
    }

    public void a(InterfaceC0209a interfaceC0209a) {
        this.byX = interfaceC0209a;
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
        this.byZ = findViewById(a.f.live_bc_video_chat_confirm_dialog_btn_first);
        this.bza = (TextView) findViewById(a.f.live_bc_video_chat_confirm_dialog_txt_first);
        this.byY = (TextView) findViewById(a.f.live_bc_video_chat_count_down);
        this.byZ.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void iK(String str) {
        this.bza.setText(str);
    }

    public void fC(int i) {
        this.byZ.setVisibility(i);
    }

    public void iL(String str) {
        this.byY.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byZ && this.byX != null) {
            this.byX.SP();
        }
    }
}
