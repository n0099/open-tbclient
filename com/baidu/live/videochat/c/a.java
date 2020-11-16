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
    private InterfaceC0222a bGo;
    private SimpleDraweeView bGp;
    private TextView bGq;
    private LottieAnimationView bGr;
    private TextView bGs;
    private View btO;
    private TextView btP;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0222a {
        void Qs();

        void Uv();

        void Uw();

        void Ux();
    }

    public void a(InterfaceC0222a interfaceC0222a) {
        this.bGo = interfaceC0222a;
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
        this.bGp = (SimpleDraweeView) findViewById(a.f.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.f.ala_link_mic_status_dialog_message);
        this.bGq = (TextView) findViewById(a.f.ala_link_mic_status_dialog_inviter);
        this.btO = findViewById(a.f.ala_link_mic_status_dialog_btn_first);
        this.btP = (TextView) findViewById(a.f.ala_link_mic_status_dialog_txt_first);
        this.bGr = (LottieAnimationView) findViewById(a.f.ala_link_mic_status_dialog_loading);
        this.bGr.setImageAssetsFolder("images/");
        this.bGs = (TextView) findViewById(a.f.ala_link_mic_status_dialog_btn_second);
        this.bGs.setVisibility(8);
        this.bGp.setBackgroundResource(a.e.sdk_default_avatar);
        RoundingParams ema = this.bGp.getHierarchy().ema();
        RoundingParams roundingParams = ema == null ? new RoundingParams() : ema;
        roundingParams.Ar(true);
        roundingParams.bv(6.0f);
        roundingParams.Pr(-1);
        this.bGp.getHierarchy().a(roundingParams);
        this.bGp.setOnClickListener(this);
        this.btO.setOnClickListener(this);
        this.bGs.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void iD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bGp.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void iE(String str) {
        this.bGq.setText(str);
    }

    public void ig(String str) {
        this.btP.setText(str);
    }

    public void iF(String str) {
        this.bGs.setText(str);
    }

    public void fe(int i) {
        this.btO.setVisibility(i);
    }

    public void gg(int i) {
        this.bGs.setVisibility(i);
    }

    public void gh(int i) {
        if (i == 0) {
            this.bGr.playAnimation();
        } else {
            this.bGr.cancelAnimation();
        }
        this.bGr.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGp) {
            if (this.bGo != null) {
                this.bGo.Uv();
            }
        } else if (view == this.btO) {
            if (this.bGo != null) {
                this.bGo.Uw();
            }
        } else if (view == this.bGs && this.bGo != null) {
            this.bGo.Ux();
        }
    }
}
