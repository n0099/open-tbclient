package com.baidu.live.videochat.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.drawee.generic.RoundingParams;
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private LottieAnimationView bLA;
    private TextView bLB;
    private InterfaceC0220a bLx;
    private SimpleDraweeView bLy;
    private TextView bLz;
    private View bzb;
    private TextView bzc;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0220a {
        void Qc();

        void Ul();

        void Um();

        void Un();
    }

    public void a(InterfaceC0220a interfaceC0220a) {
        this.bLx = interfaceC0220a;
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
        this.bLy = (SimpleDraweeView) findViewById(a.f.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.f.ala_link_mic_status_dialog_message);
        this.bLz = (TextView) findViewById(a.f.ala_link_mic_status_dialog_inviter);
        this.bzb = findViewById(a.f.ala_link_mic_status_dialog_btn_first);
        this.bzc = (TextView) findViewById(a.f.ala_link_mic_status_dialog_txt_first);
        this.bLA = (LottieAnimationView) findViewById(a.f.ala_link_mic_status_dialog_loading);
        this.bLA.setImageAssetsFolder("images/");
        this.bLB = (TextView) findViewById(a.f.ala_link_mic_status_dialog_btn_second);
        this.bLB.setVisibility(8);
        this.bLy.setBackgroundResource(a.e.sdk_default_avatar);
        RoundingParams esh = this.bLy.getHierarchy().esh();
        RoundingParams roundingParams = esh == null ? new RoundingParams() : esh;
        roundingParams.AY(true);
        roundingParams.bI(6.0f);
        roundingParams.OV(-1);
        this.bLy.getHierarchy().a(roundingParams);
        this.bLy.setOnClickListener(this);
        this.bzb.setOnClickListener(this);
        this.bLB.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void hM(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bLy.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void hN(String str) {
        this.bLz.setText(str);
    }

    public void ho(String str) {
        this.bzc.setText(str);
    }

    public void hO(String str) {
        this.bLB.setText(str);
    }

    public void dX(int i) {
        this.bzb.setVisibility(i);
    }

    public void eZ(int i) {
        this.bLB.setVisibility(i);
    }

    public void fa(int i) {
        if (i == 0) {
            this.bLA.playAnimation();
        } else {
            this.bLA.cancelAnimation();
        }
        this.bLA.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLy) {
            if (this.bLx != null) {
                this.bLx.Ul();
            }
        } else if (view == this.bzb) {
            if (this.bLx != null) {
                this.bLx.Um();
            }
        } else if (view == this.bLB && this.bLx != null) {
            this.bLx.Un();
        }
    }
}
