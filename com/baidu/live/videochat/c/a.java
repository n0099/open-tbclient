package com.baidu.live.videochat.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private InterfaceC0206a byX;
    private SimpleDraweeView byY;
    private TextView byZ;
    private View bza;
    private TextView bzb;
    private LottieAnimationView bzc;
    private TextView bzd;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0206a {
        void Rw();

        void Rx();

        void Ry();

        void Rz();
    }

    public void a(InterfaceC0206a interfaceC0206a) {
        this.byX = interfaceC0206a;
    }

    public a(@NonNull Context context) {
        super(context, a.j.theme_manage_dialog_with_no_anim);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_live_link_mic_action_dialog);
        resize();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.byY = (SimpleDraweeView) findViewById(a.g.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.g.ala_link_mic_status_dialog_message);
        this.byZ = (TextView) findViewById(a.g.ala_link_mic_status_dialog_inviter);
        this.bza = findViewById(a.g.ala_link_mic_status_dialog_btn_first);
        this.bzb = (TextView) findViewById(a.g.ala_link_mic_status_dialog_txt_first);
        this.bzc = (LottieAnimationView) findViewById(a.g.ala_link_mic_status_dialog_loading);
        this.bzc.setImageAssetsFolder("images/");
        this.bzd = (TextView) findViewById(a.g.ala_link_mic_status_dialog_btn_second);
        this.bzd.setVisibility(8);
        this.byY.setBackgroundResource(a.f.sdk_default_avatar);
        RoundingParams dYp = this.byY.getHierarchy().dYp();
        RoundingParams roundingParams = dYp == null ? new RoundingParams() : dYp;
        roundingParams.yR(true);
        roundingParams.aV(6.0f);
        roundingParams.MC(-1);
        this.byY.getHierarchy().a(roundingParams);
        this.byY.setOnClickListener(this);
        this.bza.setOnClickListener(this);
        this.bzd.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void ig(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.byY.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void ih(String str) {
        this.byZ.setText(str);
    }

    public void ii(String str) {
        this.bzb.setText(str);
    }

    public void ij(String str) {
        this.bzd.setText(str);
    }

    public void fS(int i) {
        this.bza.setVisibility(i);
    }

    public void fT(int i) {
        this.bzd.setVisibility(i);
    }

    public void fU(int i) {
        if (i == 0) {
            this.bzc.playAnimation();
        } else {
            this.bzc.cancelAnimation();
        }
        this.bzc.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byY) {
            if (this.byX != null) {
                this.byX.Rw();
            }
        } else if (view == this.bza) {
            if (this.byX != null) {
                this.byX.Rx();
            }
        } else if (view == this.bzd && this.byX != null) {
            this.byX.Ry();
        }
    }
}
