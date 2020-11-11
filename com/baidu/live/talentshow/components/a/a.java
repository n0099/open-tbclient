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
    private View bvA;
    private TextView bvB;
    private InterfaceC0201a bvy;
    private TextView bvz;
    private Context mContext;

    /* renamed from: com.baidu.live.talentshow.components.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0201a {
        boolean Ra();

        void Rb();
    }

    public void a(InterfaceC0201a interfaceC0201a) {
        this.bvy = interfaceC0201a;
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
        this.bvA = findViewById(a.f.live_bc_video_chat_confirm_dialog_btn_first);
        this.bvB = (TextView) findViewById(a.f.live_bc_video_chat_confirm_dialog_txt_first);
        this.bvz = (TextView) findViewById(a.f.live_bc_video_chat_count_down);
        this.bvA.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void im(String str) {
        this.bvB.setText(str);
    }

    public void fi(int i) {
        this.bvA.setVisibility(i);
    }

    public void in(String str) {
        this.bvz.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvA && this.bvy != null) {
            this.bvy.Ra();
        }
    }
}
