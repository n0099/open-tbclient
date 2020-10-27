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
    private InterfaceC0212a bBT;
    private SimpleDraweeView bBU;
    private TextView bBV;
    private View bBW;
    private TextView bBX;
    private LottieAnimationView bBY;
    private TextView bBZ;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0212a {
        void Sw();

        void Sx();

        void Sy();

        void Sz();
    }

    public void a(InterfaceC0212a interfaceC0212a) {
        this.bBT = interfaceC0212a;
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
        this.bBU = (SimpleDraweeView) findViewById(a.g.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.g.ala_link_mic_status_dialog_message);
        this.bBV = (TextView) findViewById(a.g.ala_link_mic_status_dialog_inviter);
        this.bBW = findViewById(a.g.ala_link_mic_status_dialog_btn_first);
        this.bBX = (TextView) findViewById(a.g.ala_link_mic_status_dialog_txt_first);
        this.bBY = (LottieAnimationView) findViewById(a.g.ala_link_mic_status_dialog_loading);
        this.bBY.setImageAssetsFolder("images/");
        this.bBZ = (TextView) findViewById(a.g.ala_link_mic_status_dialog_btn_second);
        this.bBZ.setVisibility(8);
        this.bBU.setBackgroundResource(a.f.sdk_default_avatar);
        RoundingParams ein = this.bBU.getHierarchy().ein();
        RoundingParams roundingParams = ein == null ? new RoundingParams() : ein;
        roundingParams.zZ(true);
        roundingParams.bm(6.0f);
        roundingParams.Ot(-1);
        this.bBU.getHierarchy().a(roundingParams);
        this.bBU.setOnClickListener(this);
        this.bBW.setOnClickListener(this);
        this.bBZ.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void ir(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bBU.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void is(String str) {
        this.bBV.setText(str);
    }

    public void it(String str) {
        this.bBX.setText(str);
    }

    public void iu(String str) {
        this.bBZ.setText(str);
    }

    public void fX(int i) {
        this.bBW.setVisibility(i);
    }

    public void fY(int i) {
        this.bBZ.setVisibility(i);
    }

    public void fZ(int i) {
        if (i == 0) {
            this.bBY.playAnimation();
        } else {
            this.bBY.cancelAnimation();
        }
        this.bBY.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bBU) {
            if (this.bBT != null) {
                this.bBT.Sw();
            }
        } else if (view == this.bBW) {
            if (this.bBT != null) {
                this.bBT.Sx();
            }
        } else if (view == this.bBZ && this.bBT != null) {
            this.bBT.Sy();
        }
    }
}
