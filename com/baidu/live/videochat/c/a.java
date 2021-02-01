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
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private View bCH;
    private TextView bCI;
    private InterfaceC0222a bPh;
    private SimpleDraweeView bPi;
    private TextView bPj;
    private LottieAnimationView bPk;
    private TextView bPl;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0222a {
        void RM();

        void VU();

        void VV();

        void VW();
    }

    public void a(InterfaceC0222a interfaceC0222a) {
        this.bPh = interfaceC0222a;
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
        this.bPi = (SimpleDraweeView) findViewById(a.f.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.f.ala_link_mic_status_dialog_message);
        this.bPj = (TextView) findViewById(a.f.ala_link_mic_status_dialog_inviter);
        this.bCH = findViewById(a.f.ala_link_mic_status_dialog_btn_first);
        this.bCI = (TextView) findViewById(a.f.ala_link_mic_status_dialog_txt_first);
        this.bPk = (LottieAnimationView) findViewById(a.f.ala_link_mic_status_dialog_loading);
        this.bPk.setImageAssetsFolder("images/");
        this.bPl = (TextView) findViewById(a.f.ala_link_mic_status_dialog_btn_second);
        this.bPl.setVisibility(8);
        this.bPi.setBackgroundResource(a.e.sdk_default_avatar);
        RoundingParams euz = this.bPi.getHierarchy().euz();
        RoundingParams roundingParams = euz == null ? new RoundingParams() : euz;
        roundingParams.Br(true);
        roundingParams.bL(6.0f);
        roundingParams.Pq(-1);
        this.bPi.getHierarchy().a(roundingParams);
        this.bPi.setOnClickListener(this);
        this.bCH.setOnClickListener(this);
        this.bPl.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void ih(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bPi.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void ii(String str) {
        this.bPj.setText(str);
    }

    public void hK(String str) {
        this.bCI.setText(str);
    }

    public void ij(String str) {
        this.bPl.setText(str);
    }

    public void eb(int i) {
        this.bCH.setVisibility(i);
    }

    public void fd(int i) {
        this.bPl.setVisibility(i);
    }

    public void fe(int i) {
        if (i == 0) {
            this.bPk.playAnimation();
        } else {
            this.bPk.cancelAnimation();
        }
        this.bPk.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bPi) {
            if (this.bPh != null) {
                this.bPh.VU();
            }
        } else if (view == this.bCH) {
            if (this.bPh != null) {
                this.bPh.VV();
            }
        } else if (view == this.bPl && this.bPh != null) {
            this.bPh.VW();
        }
    }
}
