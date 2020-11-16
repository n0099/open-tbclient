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
    private InterfaceC0199a btM;
    private TextView btN;
    private View btO;
    private TextView btP;
    private Context mContext;

    /* renamed from: com.baidu.live.talentshow.components.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0199a {
        boolean Qr();

        void Qs();
    }

    public void a(InterfaceC0199a interfaceC0199a) {
        this.btM = interfaceC0199a;
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
        this.btO = findViewById(a.f.live_bc_video_chat_confirm_dialog_btn_first);
        this.btP = (TextView) findViewById(a.f.live_bc_video_chat_confirm_dialog_txt_first);
        this.btN = (TextView) findViewById(a.f.live_bc_video_chat_count_down);
        this.btO.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void ig(String str) {
        this.btP.setText(str);
    }

    public void fe(int i) {
        this.btO.setVisibility(i);
    }

    public void ih(String str) {
        this.btN.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btO && this.btM != null) {
            this.btM.Qr();
        }
    }
}
