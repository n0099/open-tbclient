package com.baidu.live.videochat.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.drawee.generic.RoundingParams;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private InterfaceC0224a bHZ;
    private SimpleDraweeView bIa;
    private TextView bIb;
    private LottieAnimationView bIc;
    private TextView bId;
    private View bvA;
    private TextView bvB;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0224a {
        void Rb();

        void Ve();

        void Vf();

        void Vg();
    }

    public void a(InterfaceC0224a interfaceC0224a) {
        this.bHZ = interfaceC0224a;
    }

    public a(@NonNull Context context) {
        super(context, a.i.theme_manage_dialog_with_no_anim);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_live_link_mic_action_dialog);
        resize();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.bIa = (SimpleDraweeView) findViewById(a.f.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.f.ala_link_mic_status_dialog_message);
        this.bIb = (TextView) findViewById(a.f.ala_link_mic_status_dialog_inviter);
        this.bvA = findViewById(a.f.ala_link_mic_status_dialog_btn_first);
        this.bvB = (TextView) findViewById(a.f.ala_link_mic_status_dialog_txt_first);
        this.bIc = (LottieAnimationView) findViewById(a.f.ala_link_mic_status_dialog_loading);
        this.bIc.setImageAssetsFolder("images/");
        this.bId = (TextView) findViewById(a.f.ala_link_mic_status_dialog_btn_second);
        this.bId.setVisibility(8);
        this.bIa.setBackgroundResource(a.e.sdk_default_avatar);
        RoundingParams emc = this.bIa.getHierarchy().emc();
        RoundingParams roundingParams = emc == null ? new RoundingParams() : emc;
        roundingParams.Ak(true);
        roundingParams.bo(6.0f);
        roundingParams.OO(-1);
        this.bIa.getHierarchy().a(roundingParams);
        this.bIa.setOnClickListener(this);
        this.bvA.setOnClickListener(this);
        this.bId.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void iJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bIa.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void iK(String str) {
        this.bIb.setText(str);
    }

    public void im(String str) {
        this.bvB.setText(str);
    }

    public void iL(String str) {
        this.bId.setText(str);
    }

    public void fi(int i) {
        this.bvA.setVisibility(i);
    }

    public void gk(int i) {
        this.bId.setVisibility(i);
    }

    public void gl(int i) {
        if (i == 0) {
            this.bIc.playAnimation();
        } else {
            this.bIc.cancelAnimation();
        }
        this.bIc.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bIa) {
            if (this.bHZ != null) {
                this.bHZ.Ve();
            }
        } else if (view == this.bvA) {
            if (this.bHZ != null) {
                this.bHZ.Vf();
            }
        } else if (view == this.bId && this.bHZ != null) {
            this.bHZ.Vg();
        }
    }
}
