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
    private InterfaceC0206a bEf;
    private TextView bEg;
    private View bEh;
    private TextView bEi;
    private Context mContext;

    /* renamed from: com.baidu.live.talentshow.components.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0206a {
        boolean RO();

        void RP();
    }

    public void a(InterfaceC0206a interfaceC0206a) {
        this.bEf = interfaceC0206a;
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
        this.bEh = findViewById(a.f.live_bc_video_chat_confirm_dialog_btn_first);
        this.bEi = (TextView) findViewById(a.f.live_bc_video_chat_confirm_dialog_txt_first);
        this.bEg = (TextView) findViewById(a.f.live_bc_video_chat_count_down);
        this.bEh.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void hQ(String str) {
        this.bEi.setText(str);
    }

    public void ec(int i) {
        this.bEh.setVisibility(i);
    }

    public void hR(String str) {
        this.bEg.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bEh && this.bEf != null) {
            this.bEf.RO();
        }
    }
}
