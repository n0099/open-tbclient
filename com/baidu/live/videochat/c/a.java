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
    private View bEh;
    private TextView bEi;
    private InterfaceC0228a bQH;
    private SimpleDraweeView bQI;
    private TextView bQJ;
    private LottieAnimationView bQK;
    private TextView bQL;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0228a {
        void RP();

        void VX();

        void VY();

        void VZ();
    }

    public void a(InterfaceC0228a interfaceC0228a) {
        this.bQH = interfaceC0228a;
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
        this.bQI = (SimpleDraweeView) findViewById(a.f.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.f.ala_link_mic_status_dialog_message);
        this.bQJ = (TextView) findViewById(a.f.ala_link_mic_status_dialog_inviter);
        this.bEh = findViewById(a.f.ala_link_mic_status_dialog_btn_first);
        this.bEi = (TextView) findViewById(a.f.ala_link_mic_status_dialog_txt_first);
        this.bQK = (LottieAnimationView) findViewById(a.f.ala_link_mic_status_dialog_loading);
        this.bQK.setImageAssetsFolder("images/");
        this.bQL = (TextView) findViewById(a.f.ala_link_mic_status_dialog_btn_second);
        this.bQL.setVisibility(8);
        this.bQI.setBackgroundResource(a.e.sdk_default_avatar);
        RoundingParams euQ = this.bQI.getHierarchy().euQ();
        RoundingParams roundingParams = euQ == null ? new RoundingParams() : euQ;
        roundingParams.Bp(true);
        roundingParams.bP(6.0f);
        roundingParams.Pv(-1);
        this.bQI.getHierarchy().a(roundingParams);
        this.bQI.setOnClickListener(this);
        this.bEh.setOnClickListener(this);
        this.bQL.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void in(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bQI.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void io(String str) {
        this.bQJ.setText(str);
    }

    public void hQ(String str) {
        this.bEi.setText(str);
    }

    public void ip(String str) {
        this.bQL.setText(str);
    }

    public void ec(int i) {
        this.bEh.setVisibility(i);
    }

    public void fe(int i) {
        this.bQL.setVisibility(i);
    }

    public void ff(int i) {
        if (i == 0) {
            this.bQK.playAnimation();
        } else {
            this.bQK.cancelAnimation();
        }
        this.bQK.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bQI) {
            if (this.bQH != null) {
                this.bQH.VX();
            }
        } else if (view == this.bEh) {
            if (this.bQH != null) {
                this.bQH.VY();
            }
        } else if (view == this.bQL && this.bQH != null) {
            this.bQH.VZ();
        }
    }
}
