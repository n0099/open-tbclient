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
    private InterfaceC0207a bDL;
    private TextView bDM;
    private View bDN;
    private TextView bDO;
    private Context mContext;

    /* renamed from: com.baidu.live.talentshow.components.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0207a {
        boolean TW();

        void TX();
    }

    public void a(InterfaceC0207a interfaceC0207a) {
        this.bDL = interfaceC0207a;
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
        this.bDN = findViewById(a.f.live_bc_video_chat_confirm_dialog_btn_first);
        this.bDO = (TextView) findViewById(a.f.live_bc_video_chat_confirm_dialog_txt_first);
        this.bDM = (TextView) findViewById(a.f.live_bc_video_chat_count_down);
        this.bDN.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void iz(String str) {
        this.bDO.setText(str);
    }

    public void fD(int i) {
        this.bDN.setVisibility(i);
    }

    public void iA(String str) {
        this.bDM.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bDN && this.bDL != null) {
            this.bDL.TW();
        }
    }
}
