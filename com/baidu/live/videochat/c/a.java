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
    private TextView bLA;
    private InterfaceC0231a bLw;
    private SimpleDraweeView bLx;
    private TextView bLy;
    private LottieAnimationView bLz;
    private View byZ;
    private TextView bza;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0231a {
        void SQ();

        void WX();

        void WY();

        void WZ();
    }

    public void a(InterfaceC0231a interfaceC0231a) {
        this.bLw = interfaceC0231a;
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
        this.bLx = (SimpleDraweeView) findViewById(a.f.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.f.ala_link_mic_status_dialog_message);
        this.bLy = (TextView) findViewById(a.f.ala_link_mic_status_dialog_inviter);
        this.byZ = findViewById(a.f.ala_link_mic_status_dialog_btn_first);
        this.bza = (TextView) findViewById(a.f.ala_link_mic_status_dialog_txt_first);
        this.bLz = (LottieAnimationView) findViewById(a.f.ala_link_mic_status_dialog_loading);
        this.bLz.setImageAssetsFolder("images/");
        this.bLA = (TextView) findViewById(a.f.ala_link_mic_status_dialog_btn_second);
        this.bLA.setVisibility(8);
        this.bLx.setBackgroundResource(a.e.sdk_default_avatar);
        RoundingParams erP = this.bLx.getHierarchy().erP();
        RoundingParams roundingParams = erP == null ? new RoundingParams() : erP;
        roundingParams.AU(true);
        roundingParams.bw(6.0f);
        roundingParams.Qo(-1);
        this.bLx.getHierarchy().a(roundingParams);
        this.bLx.setOnClickListener(this);
        this.byZ.setOnClickListener(this);
        this.bLA.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void jh(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bLx.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void ji(String str) {
        this.bLy.setText(str);
    }

    public void iK(String str) {
        this.bza.setText(str);
    }

    public void jj(String str) {
        this.bLA.setText(str);
    }

    public void fC(int i) {
        this.byZ.setVisibility(i);
    }

    public void gF(int i) {
        this.bLA.setVisibility(i);
    }

    public void gG(int i) {
        if (i == 0) {
            this.bLz.playAnimation();
        } else {
            this.bLz.cancelAnimation();
        }
        this.bLz.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLx) {
            if (this.bLw != null) {
                this.bLw.WX();
            }
        } else if (view == this.byZ) {
            if (this.bLw != null) {
                this.bLw.WY();
            }
        } else if (view == this.bLA && this.bLw != null) {
            this.bLw.WZ();
        }
    }
}
