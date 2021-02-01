package com.baidu.live.talentshow.components.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private InterfaceC0200a bCF;
    private TextView bCG;
    private View bCH;
    private TextView bCI;
    private Context mContext;

    /* renamed from: com.baidu.live.talentshow.components.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0200a {
        boolean RL();

        void RM();
    }

    public void a(InterfaceC0200a interfaceC0200a) {
        this.bCF = interfaceC0200a;
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
        this.bCH = findViewById(a.f.live_bc_video_chat_confirm_dialog_btn_first);
        this.bCI = (TextView) findViewById(a.f.live_bc_video_chat_confirm_dialog_txt_first);
        this.bCG = (TextView) findViewById(a.f.live_bc_video_chat_count_down);
        this.bCH.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void hK(String str) {
        this.bCI.setText(str);
    }

    public void eb(int i) {
        this.bCH.setVisibility(i);
    }

    public void hL(String str) {
        this.bCG.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bCH && this.bCF != null) {
            this.bCF.RL();
        }
    }
}
